/*
* To change this template, choose Tools | Templates
* and open the template in the editor.
 */
package BD;

import GUI.Gui;
import Objects.Fxp_Archguid;
import Objects.Fxp_Archguid_cli;
import Objects.Fxp_Archguid_cp;
import Objects.Fxp_Archguid_gfc;
import Objects.Fxp_Archguip_det;
import Objects.Fxp_Archguip_pro_cg;
import Objects.Fxp_Archguip_pro_dv;
import Objects.Fxp_Archguip_sum;
import Objects.Setup.City;
import Objects.Setup.Country;
import Objects.Fxp_Archguip_pro;
import Objects.Fxp_Renglon;
import Objects.Indicators.Zsi_nros_sem_avg;
import Objects.Indicators.Zsi_nros_sem;
import Objects.Indicators.Zsi_nros_sem_day;
import Objects.Indicators.Zsi_nros_sem_r;
import Objects.Inventory.InventoryBlockProd;
import Objects.Orders.Fxp_Inventa;
import Objects.Orders.Orders;
import Objects.Seniat.UploadExcelFile;
import Objects.Setup.GroupSupplier;
import Objects.System.ItemLeftBar;
import Objects.System.ItemPrintScreen;
import Objects.Setup.Measure;
import Objects.Setup.Municipality;
import Objects.Setup.Parish;
import Objects.log_TMotdev;
import Objects.System.Rol;
import Objects.System.Sesion;
import Objects.Setup.Sex;
import Objects.Setup.State;
import Objects.Orders.Supplier;
import Objects.Reports.Dev_FanulSucursales;
import Objects.Setup.Unit;
import Objects.System.Usuario;
import Objects.log_CGuias;
import Objects.log_CGuias_Glomar_invoice;
import Objects.log_CGuias_Glomar_price;
import Objects.Reports.Dev_FaltCarga;
import Objects.Setup.Branch;
import Objects.log_CGuias_falt_cg;
import Objects.log_CGuias_falt_dv;
import Objects.log_CGuias_perm;
import Objects.log_Personal;
import Objects.log_TDispflota;
import Objects.log_TMarca;
import Objects.log_TPersonal;
import Objects.log_TProced;
import Objects.log_TSeguros;
import Objects.log_TTransp;
import Objects.log_Vehiculos;
import Tools.Datos;
import Tools.Tools;
import java.sql.*;
import java.time.LocalDate;
import java.util.Vector;

/**
 * 
 * @author ARMGARCES
 */
public class Bd implements BdInterface{
    protected String[] params;
    protected Connection connection;
    
    /***************************************************************************/
    /********************************** BD *************************************/
    /***************************************************************************/

    /**
     * 
     */
    public Bd(){
       
    }
    /**
     * 
     * @return 
     */
    @Override
    public Connection open(){
        return null;
    } 

    /***************************************************************************/
    /******************************** SESION ***********************************/
    /***************************************************************************/

    /**
     * 
     * @param usr
     * @param pwd
     * @return
     * @throws Exception 
     */
    public Sesion iniciarSesion(String usr, String pwd) throws Exception{
        BdInterface bd = ConnBdType.open(ConnBdType.SqlServer);
        connection = bd.open();
        
        StringBuilder sqlSp = new StringBuilder();
        sqlSp.append("{call sp_get_user_sesion(?, ?)}");
            
        if (connection != null){
            try {
                CallableStatement cstmt = connection.prepareCall(sqlSp.toString());
                cstmt.setString("@id_user", usr);
                cstmt.setString("@pswd", pwd);   
                
                ResultSet rs = cstmt.executeQuery();                
                
                if(rs.next() && rs.getObject(1) != null){                            
                    Sesion sesion = new Sesion(rs);
                    notificarSesion("Lin", usr, "Inicio Sesion");
                    return sesion;                                                                
                }                
            } catch (Exception e) {
                Tools.getErrorMessage(e.getStackTrace(), e.getMessage());
                throw e;
            }finally{
                connection.close();
            }
        }else {
            Gui.getInstance().showMessage("Error: Conexion no activa", "E");
        }
        
        return null;
    }
    /**
     * 
     * @throws Exception 
     */
    public void cerrarSesion() throws Exception{
        BdInterface bd = ConnBdType.open(ConnBdType.SqlServer);
        connection = bd.open();
        
        if (connection != null){
            try{
                notificarSesion("Lof", "", "Cerrado Forzado de Sesion");                                 
            } catch (Exception e) {
                Tools.getErrorMessage(e.getStackTrace(), e.getMessage());
                throw e;
            }finally{
                connection.close();
            }
        }else{
            Gui.getInstance().showMessage("Error: Conexion no activa", "E");
        }               
    }
    /**
     * 
     * @param usr
     * @throws Exception 
     */
    public void cerrarSesion(Sesion usr) throws Exception{
        BdInterface bd = ConnBdType.open(ConnBdType.SqlServer);
        connection = bd.open();
        
        if (connection != null){
            try{
                notificarSesion("Lot",usr.getUsername(),"Cerrar Sesion");                                 
            } catch (Exception e) {
                Tools.getErrorMessage(e.getStackTrace(), e.getMessage());
                throw e;
            }finally{
                connection.close();
            }
        }else{
            Gui.getInstance().showMessage("Error: Conexion no activa", "E");
        }               
    }    
    /**
     * 
     * @param tipo
     * @param usr
     * @param mnsj 
     */
    private void notificarSesion(String tipo,String usr,String mnsj) {
        try{
            StringBuilder sqlProc = new StringBuilder();
            sqlProc.append("{call sp_ins_user_sesion(?,?,?,?,?,?)}");
            
            if (connection != null){
               CallableStatement cstmt = connection.prepareCall(sqlProc.toString());
               cstmt.setString("@tipo_aud", tipo);
               cstmt.setString("@usuario", usr);
               String[] data = Datos.getLocalHost();
               cstmt.setString("@ip_terminal",  data[0]);
               cstmt.setString("@ip_direccion", data[1]);
               cstmt.setString("@ip_mac",       data[2]);
               cstmt.setString("@mensaje", mnsj);
               cstmt.execute();             
            }else{
                Gui.getInstance().showMessage("Error: Conexion no activa", "E");
            }
        }catch(Exception e){
           StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
            Tools.getErrorMessage(stacktrace,"Error = " + e); 
        }
    }


    /***************************************************************************/
    /******************************** AUDIT ************************************/
    /***************************************************************************/

    /**
     * 
     * @param pkValue
     * @param mensaje
     * @throws SQLException 
     */
    private void auditar(String pkValue,String mensaje) throws SQLException{
        StringBuilder sqlAud = new StringBuilder();
        sqlAud.append("{call sp_upd_user_audit(?,?,?,?,?,?,?,?)}");
        CallableStatement cstmt1 = connection.prepareCall(sqlAud.toString());                           
        cstmt1.setString("@audit_tb", "tb_audit_bd");
        cstmt1.setString("@audit_pk", "id_aud_bd");
        cstmt1.setString("@pk_value", pkValue);
        cstmt1.setString("@id_user", Datos.getSesion().getUsername());

        String[] host = Datos.getLocalHost();
        cstmt1.setString("@ip_terminal", host[0]);
        cstmt1.setString("@ip_direccion",host[1]);
        cstmt1.setString("@ip_mac", host[2]);

        cstmt1.setString("@mensaje", mensaje);
        cstmt1.execute();
    }

    
    /***************************************************************************/
    /******************************** TOOLBAR **********************************/
    /***************************************************************************/
    
    /**
     * 
     * @return 
     * @throws java.sql.SQLException 
     */
    public Integer[] load_ToolBar() throws SQLException {
        try{
            BdInterface bd = ConnBdType.open(ConnBdType.SqlServer);
            connection = bd.open();
        
            StringBuilder sqlProc = new StringBuilder();
            sqlProc.append("{call sp_get_menu_top( ?, ?)}");
            
            if (connection != null){
               CallableStatement cstmt = connection.prepareCall(sqlProc.toString());                
               cstmt.setString("@id_user"  , Datos.getSesion().getUsername() );
               cstmt.setInt("@id_screen"  , Datos.getIdScreen()  );
               ResultSet rs = cstmt.executeQuery(); 
               if(rs.next()){                          
                  Integer[] result = new Integer[14];
                  for (int i = 0; i < result.length; i++) {
                    result[i] = rs.getInt(i+1);
                  }
                  return result;
               }    
            }else{
                Gui.getInstance().showMessage("Error: Conexion no activa", "E");
            }
        }catch(SQLException e){  
            e.printStackTrace();
            StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
            Tools.getErrorMessage(stacktrace,"Error = " + e); 
        }finally{
            connection.close();
        }
        return null;
    }

    
    /***************************************************************************/
    /******************************** LEFTBAR **********************************/
    /***************************************************************************/
    
    /**
     * 
     * @return
     * @throws SQLException 
     */
    public ItemLeftBar[] load_Menu() throws SQLException {
         try{
            BdInterface bd = ConnBdType.open(ConnBdType.SqlServer);
            connection = bd.open();
        
            StringBuilder sqlProc = new StringBuilder();
            sqlProc.append("{call sp_get_menu_left(?)}");
            
            if (connection != null){
               CallableStatement cstmt = connection.prepareCall(sqlProc.toString());
               cstmt.setString("@id_user", Datos.getSesion().getUsername());
               
               ResultSet result = cstmt.executeQuery();            
               Vector<ItemLeftBar> vector = new Vector<>();
               
               while(result.next()) {
                   ItemLeftBar menu = new ItemLeftBar(result);
                   vector.add(menu);
               }
               
               ItemLeftBar[] menus = new ItemLeftBar[vector.size()];
               for (int i = 0; i < vector.size(); i++) {
                   menus[i] = vector.elementAt(i);                    
               }
               return menus;
            }else{
                Gui.getInstance().showMessage("Error: Conexion no activa", "E");
            }
        }catch(SQLException e){          
            e.printStackTrace();
            StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
            Tools.getErrorMessage(stacktrace,"Error = " + e); 
        }finally{
            connection.close();
        }
        return null;
    }

    
    /***************************************************************************/
    /********************************* USERS ***********************************/
    /***************************************************************************/
    
    /**
     * 
     * @return 
     * @throws java.sql.SQLException 
     */
    public Usuario[] load_Users() throws SQLException {
        try{
            BdInterface bd = ConnBdType.open(ConnBdType.SqlServer);
            connection = bd.open();
        
            StringBuilder sqlProc = new StringBuilder();
            sqlProc.append("{call sp_get_user_all}");
            
            if (connection != null){
               CallableStatement cstmt = connection.prepareCall(sqlProc.toString());
               ResultSet result = cstmt.executeQuery();            
               
               Vector<Usuario> vector = new Vector<>();
               
               while(result.next()) {
                   Usuario usuario = new Usuario(result);
                   vector.add(usuario);
               }
               
               Usuario[] users = new Usuario[vector.size()];
               for (int i = 0; i < vector.size(); i++) {
                   users[i] = vector.elementAt(i);                    
               }
               
               return users;
            }else{
                Gui.getInstance().showMessage("Error: Conexion no activa", "E");
            }
        }catch(SQLException e){              
            StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
            Tools.getErrorMessage(stacktrace,"Error = " + e); 
        }finally{
            connection.close();
        }
        return null;
    }
    /**
     * Valida si el username generado ya se encuentra asignado a un usuario en la BD
     * @param username valor a ser chequeado en la BD
     * @return true si el username esta en uso, false si esta disponible el username
     * @throws java.sql.SQLException
     */
    public boolean check_UserName(String username) throws SQLException {
        try{
            BdInterface bd = ConnBdType.open(ConnBdType.SqlServer);
            connection = bd.open();
        
            StringBuilder sqlProc = new StringBuilder();
            sqlProc.append("{call sp_get_user_check(?,?)}");
            if (connection != null){
               CallableStatement cstmt = connection.prepareCall(sqlProc.toString());                           
               cstmt.setString("@id_user", username);
               cstmt.registerOutParameter("result", java.sql.Types.INTEGER);               
               cstmt.execute();
               if(cstmt.getInt("result") == 1) return true;               
            }else{
                Gui.getInstance().showMessage("Error: Conexion no activa", "E");
            }
        }catch(SQLException e){            
            StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
            Tools.getErrorMessage(stacktrace,"Error = " + e); 
        }finally{
            connection.close();
        }
        return false;
    }
    /**
     * 
     * @param usuario
     * @return 
     * @throws java.lang.Exception 
     */
    public boolean change_UserStatus(Usuario usuario) throws Exception {
        BdInterface bd = ConnBdType.open(ConnBdType.SqlServer);
        connection = bd.open();
        
        try{
         if (connection != null){
            //Inicia Transaccion 
            connection.setAutoCommit(false);
            StringBuilder sqlProc = new StringBuilder();
            sqlProc.append("{call sp_upd_user_status(?,?)}");
            CallableStatement cstmt = connection.prepareCall(sqlProc.toString());                 
            cstmt.setString("@id_user", usuario.getUsername());
            int value = 0;
            if(usuario.getStatus() == 0){
                value = 1;
            }            
            cstmt.setInt("@status", value );
            cstmt.execute();            
            // Auditar el proceso
            auditar(usuario.getUsername(),"deleteUser:");
            
            connection.commit();
            
            return true;
         }else{
            Gui.getInstance().showMessage("Error: Conexion no activa", "E");
            throw new Exception("Error de Conexion con la BD");
         }
        }catch(Exception e){            
            connection.rollback();            
            StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
            Tools.getErrorMessage(stacktrace,"Error = " + e);    
            throw e;
        }finally{
            connection.close();
        }
    }
    /**
     * 
     * @param operacion Determina el Proceso que se va a ejecutar 1 INSERT, 2 UPDATE, 3 UPDATE PSWD
     * @param usuario
     * @return
     * @throws SQLException
     * @throws Exception 
     */
    public boolean save_User(int operacion, Usuario usuario) throws SQLException, Exception {
        
        BdInterface bd = ConnBdType.open(ConnBdType.SqlServer);
        connection = bd.open();        
        try{
         if (connection != null){
            //Inicia Transaccion 
            connection.setAutoCommit(false);
            StringBuilder sql = new StringBuilder();            
            String mensj = "";
            
            switch(operacion){
                case 1:
                    sql.append("{call sp_ins_user_data(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}");
                    mensj = "Nuevo Usuario:";
                    break;
                case 2:
                    sql.append("{call sp_upd_user_basic(?, ?, ?, ?, ?, ?, ?, ?, ?)}");
                    mensj = "Actualizando Usuario:";
                    break;
                case 3:
                    sql.append("{call sp_upd_user_pswd(?, ?)}");
                    mensj = "Actualizando Clave de Usuario:";
                    break;
            }
            CallableStatement cstmt = connection.prepareCall(sql.toString());
            switch(operacion){
                case 1:
                    cstmt.setString("@id_user"      , usuario.getUsername());
                    cstmt.setString("@nombre1"      , usuario.getNombre1());
                    cstmt.setString("@nombre2"  , usuario.getNombre2());
                    cstmt.setString("@apellido1"    , usuario.getApellido1());
                    cstmt.setString("@apellido2", usuario.getApellido2());
                    cstmt.setString("@clave"        , usuario.getPswd_old());
                    cstmt.setInt("@id_rol"          , usuario.getRol().getIdRol());
                    cstmt.setString("@correo"       , usuario.getEmail());
                    cstmt.setString("@clave_correo" , usuario.getEmail_pswd());
                    cstmt.setInt("@status"          , usuario.getStatus());
                    break;
                case 2:
                    cstmt.setString("@id_user"      , usuario.getUsername());
                    cstmt.setString("@nombre1"      , usuario.getNombre1());
                    cstmt.setString("@nombre2"  , usuario.getNombre2());
                    cstmt.setString("@apellido1"    , usuario.getApellido1());
                    cstmt.setString("@apellido2", usuario.getApellido2());
                    cstmt.setInt("@id_rol"          , usuario.getRol().getIdRol());
                    cstmt.setString("@correo"       , usuario.getEmail());
                    cstmt.setString("@clave_correo" , usuario.getEmail_pswd());
                    cstmt.setInt("@status"          , usuario.getStatus());
                    break;
                case 3:
                    cstmt.setString("@id_user"      , usuario.getUsername() );
                    cstmt.setString("@clave"        , usuario.getPswd_old());
                    break;
            }
            cstmt.execute();            
            // Auditar el proceso
            auditar(usuario.getUsername(),mensj);
            
            connection.commit();
            
            return true;
         }else{
            Gui.getInstance().showMessage("Error: Conexion no activa", "E");
            throw new Exception("Error de Conexion con la BD");
         }
        }catch(Exception e){            
            connection.rollback();   
            e.printStackTrace();
            StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
            Tools.getErrorMessage(stacktrace,"Error = " + e);    
            throw e;
        }finally{
            connection.close();
        }
    }
    /**
     * 
     * @param find
     * @return 
     * @throws java.sql.SQLException 
     */
    public Usuario[] find_User(String find) throws SQLException {
         try{
            BdInterface bd = ConnBdType.open(ConnBdType.SqlServer);
            connection = bd.open();
        
            StringBuilder sqlProc = new StringBuilder();
            sqlProc.append("{call sp_get_user_find(?)}");
            
            if (connection != null){
               CallableStatement cstmt = connection.prepareCall(sqlProc.toString());
               cstmt.setString("@find"  , find );
               ResultSet result = cstmt.executeQuery();            
               
               Vector<Usuario> vector = new Vector<>();
               
               while(result.next()) {
                   Usuario usuario = new Usuario(result);
                   vector.add(usuario);
               }
               
               Usuario[] users = new Usuario[vector.size()];
               for (int i = 0; i < vector.size(); i++) {
                   users[i] = vector.elementAt(i);                    
               }
               
               return users;
            }else{
                Gui.getInstance().showMessage("Error: Conexion no activa", "E");
            }
        }catch(SQLException e){            
            StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
            Tools.getErrorMessage(stacktrace,"Error = " + e); 
        }finally{
            connection.close();
        }
        return null;
    }

    /***************************************************************************/
    /********************************* USERS ***********************************/
    /***************************************************************************/
    
    /**
     * 
     * @return 
     * @throws java.sql.SQLException 
     */
    public Rol[] load_Rols() throws SQLException {
         try{
            BdInterface bd = ConnBdType.open(ConnBdType.SqlServer);
            connection = bd.open();
        
            StringBuilder sqlProc = new StringBuilder();
            sqlProc.append("{call sp_get_role_all}");
            
            if (connection != null){
               CallableStatement cstmt = connection.prepareCall(sqlProc.toString());
               ResultSet result = cstmt.executeQuery();            
               
               Vector<Rol> vector = new Vector<>();
               
               while(result.next()) {
                   Rol rol = new Rol(result);
                   vector.add(rol);
               }
               
               Rol[] rols = new Rol[vector.size()];
               for (int i = 0; i < vector.size(); i++) {
                   rols[i] = vector.elementAt(i);                    
               }
               return rols;
            }else{
                Gui.getInstance().showMessage("Error: Conexion no activa", "E");
            }
        }catch(SQLException e){            
            StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
            Tools.getErrorMessage(stacktrace,"Error = " + e); 
        }finally{
            connection.close();
        }
        return null;
    }

    
    /***************************************************************************/
    /********************************* ROLE ************************************/
    /***************************************************************************/
    
    /**
     * @author MITM
     * @return 
     * @throws java.sql.SQLException 
     */
    public Rol[] load_Rol() throws SQLException {
         try{
            BdInterface bd = ConnBdType.open(ConnBdType.SqlServer);
            connection = bd.open();
        
            StringBuilder sqlProc = new StringBuilder();
            sqlProc.append("{call sp_get_role_all}");
            
            if (connection != null){
               CallableStatement cstmt = connection.prepareCall(sqlProc.toString());
               ResultSet result = cstmt.executeQuery();            
               
               Vector<Rol> vector = new Vector<>();
               
               while(result.next()) {
                   Rol role = new Rol(result);
                   vector.add(role);
               }
               
               Rol[] role = new Rol[vector.size()];
               for (int i = 0; i < vector.size(); i++) {
                   role[i] = vector.elementAt(i);                    
               }
               return role;
            }else{
                Gui.getInstance().showMessage("Error: Conexion no activa", "E");
            }
        }catch(SQLException e){            
            StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
            Tools.getErrorMessage(stacktrace,"Error = " + e); 
        }finally{
            connection.close();
        }
        return null;
    }
    /**
     * @author MITM
     * @param find
     * @return 
     * @throws java.sql.SQLException 
     */
    public Rol[] find_Rol(String find) throws SQLException {
        try{
            BdInterface bd = ConnBdType.open(ConnBdType.SqlServer);
            connection = bd.open();
        
            StringBuilder sqlProc = new StringBuilder();
            sqlProc.append("{call sp_get_role_find(?)}");
            
            if (connection != null){
               CallableStatement cstmt = connection.prepareCall(sqlProc.toString());
               cstmt.setString("@find"  , find );
               ResultSet result = cstmt.executeQuery();            
               Vector<Rol> vector = new Vector<>();
               
               while(result.next()) {
                   Rol role = new Rol(result);
                   vector.add(role);
               }
               
               Rol[] role = new Rol[vector.size()];
               for (int i = 0; i < vector.size(); i++) {
                   role[i] = vector.elementAt(i);                    
               }
               
               return role;
            }else{
                Gui.getInstance().showMessage("Error: Conexion no activa", "E");
            }
        }catch(SQLException e){            
            StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
            Tools.getErrorMessage(stacktrace,"Error = " + e); 
        }finally{
            connection.close();
        }
        return null;
    }
    /**
     * @author MITM
     * @param operacion Determina el Proceso que se va a ejecutar 1 INSERT, 2 UPDATE
     * @param role
     * @return
     * @throws SQLException
     * @throws Exception 
     */
    public boolean save_Rol(int operacion, Rol role) throws SQLException, Exception {
        
        BdInterface bd = ConnBdType.open(ConnBdType.SqlServer);
        connection = bd.open();        
        try{
         if (connection != null){
            //Inicia Transaccion 
            connection.setAutoCommit(false);
            StringBuilder sql = new StringBuilder();            
            String mensj = "";
            
            switch(operacion){
                case 1:
                    sql.append("{call sp_ins_role(?, ?)}");
                    mensj = "Nuevo Rol:";
                    break;
                case 2:
                    sql.append("{call sp_upd_role_basic(?, ?, ?)}");
                    mensj = "Actualizando Rol:";
                    break;
            }
            CallableStatement cstmt = connection.prepareCall(sql.toString());
            switch(operacion){
                case 1:
                    cstmt.setString("@nombre"       , role.getNombre().toUpperCase());
                    cstmt.setString("@abrev"        , role.getAbrev().toUpperCase());
                    break;
                case 2:
                    cstmt.setInt("@id_role"         , role.getIdRol());
                    cstmt.setString("@nombre"       , role.getNombre().toUpperCase());
                    cstmt.setString("@abrev"        , role.getAbrev().toUpperCase());
                    break;
            }
            cstmt.execute();            
            // Auditar el proceso
            auditar(role.getIdRol()+ "",mensj);
            
            connection.commit();
            
            return true;
         }else{
            Gui.getInstance().showMessage("Error: Conexion no activa", "E");
            throw new Exception("Error de Conexion con la BD");
         }
        }catch(Exception e){            
            connection.rollback();   
            StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
            Tools.getErrorMessage(stacktrace,"Error = " + e);    
            throw e;
        }finally{
            connection.close();
        }
    }
    /**
     * @author MITM
     * Valida si el measurename generado ya se encuentra asignado a una medida en la BD
     * @param rolename valor a ser chequeado en la BD
     * @return true si el measure esta en uso, false si esta disponible la medida
     * @throws java.sql.SQLException
     */
    public boolean check_Rol(String rolename) throws SQLException {
        try{
            BdInterface bd = ConnBdType.open(ConnBdType.SqlServer);
            connection = bd.open();
        
            StringBuilder sqlProc = new StringBuilder();
            sqlProc.append("{call sp_get_role_check(?,?)}");
            
            if (connection != null){
               CallableStatement cstmt = connection.prepareCall(sqlProc.toString());                           
               cstmt.setString("@role", rolename);
               cstmt.registerOutParameter("result", java.sql.Types.INTEGER);               
               cstmt.execute();
               if(cstmt.getInt("result") == 1) return true;               
            }else{
                Gui.getInstance().showMessage("Error: Conexion no activa", "E");
            }
        }catch(SQLException e){            
            StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
            Tools.getErrorMessage(stacktrace,"Error = " + e); 
        }finally{
            connection.close();
        }
        return false;
    }
    /**
     * @author MITM
     * @param role
     * @return 
     * @throws java.lang.Exception 
     */
    public boolean change_Rol(Rol role) throws Exception {
        BdInterface bd = ConnBdType.open(ConnBdType.SqlServer);
        connection = bd.open();
        
        try{
         if (connection != null){
            //Inicia Transaccion 
            connection.setAutoCommit(false);
            
            StringBuilder sqlProc = new StringBuilder();
            sqlProc.append("{call sp_upd_role_status(?,?)}");
            CallableStatement cstmt = connection.prepareCall(sqlProc.toString());                 
            cstmt.setInt("@id_role", role.getIdRol());
            int value = 0;
            if(role.getStatus() == 0){
                value = 1;
            }            
            cstmt.setInt("@status", value );
            cstmt.execute();            
            // Auditar el proceso
            auditar(role.getIdRol()+ "","deleteRol:");
            
            connection.commit();
            
            return true;
         }else{
            Gui.getInstance().showMessage("Error: Conexion no activa", "E");
            throw new Exception("Error de Conexion con la BD");
         }
        }catch(Exception e){            
            connection.rollback();            
            StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
            Tools.getErrorMessage(stacktrace,"Error = " + e);    
            throw e;
        }finally{
            connection.close();
        }
    }

    
    /***************************************************************************/
    /******************************** BRANCH ***********************************/
    /***************************************************************************/
    
    /**
     * @author MITM
     * @return 
     * @throws java.sql.SQLException 
     */
    public Branch[] load_Branch() throws SQLException {
         try{
            BdInterface bd = ConnBdType.open(ConnBdType.SqlServer);
            connection = bd.open();
        
            StringBuilder sqlProc = new StringBuilder();
            sqlProc.append("{call sp_get_branch_all}");
            
            if (connection != null){
               CallableStatement cstmt = connection.prepareCall(sqlProc.toString());
               ResultSet result = cstmt.executeQuery();            
               
               Vector<Branch> vector = new Vector<>();
               
               while(result.next()) {
                   Branch branch = new Branch(result);
                   vector.add(branch);
               }
               
               Branch[] branch = new Branch[vector.size()];
               for (int i = 0; i < vector.size(); i++) {
                   branch[i] = vector.elementAt(i);                    
               }
               return branch;
            }else{
                Gui.getInstance().showMessage("Error: Conexion no activa", "E");
            }
        }catch(SQLException e){            
            StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
            Tools.getErrorMessage(stacktrace,"Error = " + e); 
        }finally{
            connection.close();
        }
        return null;
    }
    /**
     * @author MITM
     * @param find
     * @return 
     * @throws java.sql.SQLException 
     */
    public Branch[] find_Branch(String find) throws SQLException {
        try{
            BdInterface bd = ConnBdType.open(ConnBdType.SqlServer);
            connection = bd.open();
        
            StringBuilder sqlProc = new StringBuilder();
            sqlProc.append("{call sp_get_branch_find(?)}");
            
            if (connection != null){
               CallableStatement cstmt = connection.prepareCall(sqlProc.toString());
               cstmt.setString("@find"  , find );
               ResultSet result = cstmt.executeQuery();            
               Vector<Branch> vector = new Vector<>();
               
               while(result.next()) {
                   Branch branch = new Branch(result);
                   vector.add(branch);
               }
               
               Branch[] branch = new Branch[vector.size()];
               for (int i = 0; i < vector.size(); i++) {
                   branch[i] = vector.elementAt(i);                    
               }
               
               return branch;
            }else{
                Gui.getInstance().showMessage("Error: Conexion no activa", "E");
            }
        }catch(SQLException e){            
            StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
            Tools.getErrorMessage(stacktrace,"Error = " + e); 
        }finally{
            connection.close();
        }
        return null;
    }
    /**
     * @author MITM
     * @param operacion Determina el Proceso que se va a ejecutar 1 INSERT, 2 UPDATE
     * @param branch
     * @return
     * @throws SQLException
     * @throws Exception 
     */
    public boolean save_Branch(int operacion, Branch branch) throws SQLException, Exception {
        
        BdInterface bd = ConnBdType.open(ConnBdType.SqlServer);
        connection = bd.open();        
        try{
         if (connection != null){
            //Inicia Transaccion 
            connection.setAutoCommit(false);
            StringBuilder sql = new StringBuilder();            
            String mensj = "";
            
            switch(operacion){
                case 1:
                    sql.append("{call sp_ins_branch(?, ?)}");
                    mensj = "Nueva Unidad:";
                    break;
                case 2:
                    sql.append("{call sp_upd_branch_basic(?, ?, ?)}");
                    mensj = "Actualizando Unidad:";
                    break;
            }
            CallableStatement cstmt = connection.prepareCall(sql.toString());
            switch(operacion){
                case 1:
                    cstmt.setString("@nombre"       , branch.getNombre().toUpperCase());
                    cstmt.setString("@abrev"        , branch.getAbrev().toUpperCase());
                    break;
                case 2:
                    cstmt.setInt("@id_branch"         , branch.getIdBranch());
                    cstmt.setString("@nombre"       , branch.getNombre().toUpperCase());
                    cstmt.setString("@abrev"        , branch.getAbrev().toUpperCase());
                    break;
            }
            cstmt.execute();            
            // Auditar el proceso
            auditar(branch.getIdBranch()+ "",mensj);
            
            connection.commit();
            
            return true;
         }else{
                Gui.getInstance().showMessage("Error: Conexion no activa", "E");
            throw new Exception("Error de Conexion con la BD");
         }
        }catch(Exception e){            
            connection.rollback();   
            StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
            Tools.getErrorMessage(stacktrace,"Error = " + e);    
            throw e;
        }finally{
            connection.close();
        }
    }
    /**
     * @author MITM
     * Valida si el measurename generado ya se encuentra asignado a una medida en la BD
     * @param branchname valor a ser chequeado en la BD
     * @return true si el measure esta en uso, false si esta disponible la medida
     * @throws java.sql.SQLException
     */
    public boolean check_Branch(String branchname) throws SQLException {
        try{
            BdInterface bd = ConnBdType.open(ConnBdType.SqlServer);
            connection = bd.open();
        
            StringBuilder sqlProc = new StringBuilder();
            sqlProc.append("{call sp_get_branch_check(?,?)}");
            
            if (connection != null){
               CallableStatement cstmt = connection.prepareCall(sqlProc.toString());                           
               cstmt.setString("@branch", branchname);
               cstmt.registerOutParameter("result", java.sql.Types.INTEGER);               
               cstmt.execute();
               if(cstmt.getInt("result") == 1) return true;               
            }else{
                Gui.getInstance().showMessage("Error: Conexion no activa", "E");
            }
        }catch(SQLException e){            
            StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
            Tools.getErrorMessage(stacktrace,"Error = " + e); 
        }finally{
            connection.close();
        }
        return false;
    }
    /**
     * @author MITM
     * @param branch
     * @return 
     * @throws java.lang.Exception 
     */
    public boolean change_Branch(Branch branch) throws Exception {
        BdInterface bd = ConnBdType.open(ConnBdType.SqlServer);
        connection = bd.open();
        
        try{
         if (connection != null){
            //Inicia Transaccion 
            connection.setAutoCommit(false);
            
            StringBuilder sqlProc = new StringBuilder();
            sqlProc.append("{call sp_upd_branch_status(?,?)}");
            CallableStatement cstmt = connection.prepareCall(sqlProc.toString());                 
            cstmt.setInt("@id_branch", branch.getIdBranch());
            int value = 0;
            if(branch.getStatus() == 0){
                value = 1;
            }            
            cstmt.setInt("@status", value );
            cstmt.execute();            
            // Auditar el proceso
            auditar(branch.getIdBranch()+ "","deleteBranch:");
            
            connection.commit();
            
            return true;
         }else{
            Gui.getInstance().showMessage("Error: Conexion no activa", "E");
            throw new Exception("Error de Conexion con la BD");
         }
        }catch(Exception e){            
            connection.rollback();            
            StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
            Tools.getErrorMessage(stacktrace,"Error = " + e);    
            throw e;
        }finally{
            connection.close();
        }
    }

    
    /***************************************************************************/
    /***************************** GROUPSUPPLIER *******************************/
    /***************************************************************************/
    
    /**
     * @author MITM
     * @return 
     * @throws java.sql.SQLException 
     */
    
    public GroupSupplier[] load_GroupSupplier() throws SQLException {
         try{
            BdInterface bd = ConnBdType.open(ConnBdType.SqlServer);
            connection = bd.open();
        
            StringBuilder sqlProc = new StringBuilder();
            sqlProc.append("{call sp_get_group_supplier_all}");
            
            if (connection != null){
               CallableStatement cstmt = connection.prepareCall(sqlProc.toString());
               ResultSet result = cstmt.executeQuery();            
               
               Vector<GroupSupplier> vector = new Vector<>();
               
               while(result.next()) {
                   GroupSupplier groupsupplier = new GroupSupplier(result);
                   vector.add(groupsupplier);
               }
               
               GroupSupplier[] groupsupplier = new GroupSupplier[vector.size()];
               for (int i = 0; i < vector.size(); i++) {
                   groupsupplier[i] = vector.elementAt(i);                    
               }
               return groupsupplier;
            }else{
                System.out.println("Error: Connexion no activa");
            }
        }catch(SQLException e){            
            StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
            Tools.getErrorMessage(stacktrace,"Error = " + e); 
        }finally{
            connection.close();
        }
        return null;
    }
    /**
     * @author MITM
     * @param find
     * @return 
     * @throws java.sql.SQLException 
     */
    public GroupSupplier[] find_GroupSupplier(String find) throws SQLException {
        try{
            BdInterface bd = ConnBdType.open(ConnBdType.SqlServer);
            connection = bd.open();
        
            StringBuilder sqlProc = new StringBuilder();
            sqlProc.append("{call sp_get_group_supplier_find(?)}");
            
            if (connection != null){
               CallableStatement cstmt = connection.prepareCall(sqlProc.toString());
               cstmt.setString("@grp_supplier"  , find );
               ResultSet result = cstmt.executeQuery();            
               Vector<GroupSupplier> vector = new Vector<>();
               
               while(result.next()) {
                   GroupSupplier groupsupplier = new GroupSupplier(result);
                   vector.add(groupsupplier);
               }
               
               GroupSupplier[] groupsupplier = new GroupSupplier[vector.size()];
               for (int i = 0; i < vector.size(); i++) {
                   groupsupplier[i] = vector.elementAt(i);                    
               }
               
               return groupsupplier;
            }else{
                System.out.println("Error: Connexion no activa");
            }
        }catch(SQLException e){            
            StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
            Tools.getErrorMessage(stacktrace,"Error = " + e); 
        }finally{
            connection.close();
        }
        return null;
    }
    /**
     * @author MITM
     * @param operacion Determina el Proceso que se va a ejecutar 1 INSERT, 2 UPDATE
     * @param groupsupplier
     * @return
     * @throws SQLException
     * @throws Exception 
     */
    public boolean save_GroupSupplier(int operacion, GroupSupplier groupsupplier) throws SQLException, Exception {
        
        BdInterface bd = ConnBdType.open(ConnBdType.SqlServer);
        connection = bd.open();        
        try{
         if (connection != null){
            //Inicia Transaccion 
            connection.setAutoCommit(false);
            StringBuilder sql = new StringBuilder();            
            String mensj = "";
            
            switch(operacion){
                case 1:
                    sql.append("{call sp_ins_group_supplier(?, ?)}");
                    mensj = "Nuevo Grupo de Proveedor:";
                    break;
                case 2:
                    sql.append("{call sp_upd_group_supplier_basic(?, ?, ?)}");
                    mensj = "Actualizando Grupo de Proveedor:";
                    break;
            }
            CallableStatement cstmt = connection.prepareCall(sql.toString());
            switch(operacion){
                case 1:
                    cstmt.setString("@nombre"       , groupsupplier.getNombre().toUpperCase());
                    cstmt.setString("@abrev"        , groupsupplier.getAbrev().toUpperCase());
                    break;
                case 2:
                    cstmt.setInt("@grp_supplier"    , groupsupplier.getIdGroupSupplier() );
                    cstmt.setString("@nombre"       , groupsupplier.getNombre().toUpperCase());
                    cstmt.setString("@abrev"        , groupsupplier.getAbrev().toUpperCase());
                    break;
            }
            cstmt.execute();            
            // Auditar el proceso
            auditar(groupsupplier.getIdGroupSupplier() + "",mensj);
            
            connection.commit();
            
            return true;
         }else{
            System.out.println("Error: Connexion no activa");
            throw new Exception("Error de Conexion con la BD");
         }
        }catch(Exception e){            
            connection.rollback();   
            e.printStackTrace();
            StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
            Tools.getErrorMessage(stacktrace,"Error = " + e);    
            throw e;
        }finally{
            connection.close();
        }
    }
    /**
     * @author MITM
     * Valida si el groupsuppliername generado ya se encuentra asignado a un grupo en la BD
     * @param groupsuppliername valor a ser chequeado en la BD
     * @return true si el groupsupplier esta en uso, false si esta disponible el grupo
     * @throws java.sql.SQLException
     */
    public boolean check_GroupSupplier(String groupsuppliername) throws SQLException {
        try{
            BdInterface bd = ConnBdType.open(ConnBdType.SqlServer);
            connection = bd.open();
        
            StringBuilder sqlProc = new StringBuilder();
            sqlProc.append("{call sp_get_group_supplier_check(?,?)}");
            
            if (connection != null){
               CallableStatement cstmt = connection.prepareCall(sqlProc.toString());                           
               cstmt.setString("@grp_supplier", groupsuppliername);
               cstmt.registerOutParameter("result", java.sql.Types.INTEGER);               
               cstmt.execute();
               if(cstmt.getInt("result") == 1) return true;               
            }else{
                System.out.println("Error: Connexion no activa");
            }
        }catch(SQLException e){            
            StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
            Tools.getErrorMessage(stacktrace,"Error = " + e); 
        }finally{
            connection.close();
        }
        return false;
    }
    /**
     * @author MITM
     * @param groupsupplier
     * @return 
     * @throws java.lang.Exception 
     */
    public boolean change_GroupSupplier(GroupSupplier groupsupplier) throws Exception {
        BdInterface bd = ConnBdType.open(ConnBdType.SqlServer);
        connection = bd.open();
        
        try{
         if (connection != null){
            //Inicia Transaccion 
            connection.setAutoCommit(false);
            
            StringBuilder sqlProc = new StringBuilder();
            sqlProc.append("{call sp_upd_group_supplier_status(?,?)}");
            CallableStatement cstmt = connection.prepareCall(sqlProc.toString());                 
            cstmt.setInt("@grp_supplier", groupsupplier.getIdGroupSupplier());
            int value = 0;
            if(groupsupplier.getStatus()== 0){
                value = 1;
            }            
            cstmt.setInt("@status", value );
            cstmt.execute();            
            // Auditar el proceso
            auditar(groupsupplier.getIdGroupSupplier() + "","deleteGroupSupplier:");
            
            connection.commit();
            
            return true;
         }else{
            System.out.println("Error: Connexion no activa");
            throw new Exception("Error de Conexion con la BD");
         }
        }catch(Exception e){            
            connection.rollback();            
            StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
            Tools.getErrorMessage(stacktrace,"Error = " + e);    
            throw e;
        }finally{
            connection.close();
        }
    }

    
    /***************************************************************************/
    /******************************** COUNTRY **********************************/
    /***************************************************************************/
    
    /**
     * @author MITM
     * @return 
     * @throws java.sql.SQLException 
     */
    public Country[] load_Country() throws SQLException {
         try{
            BdInterface bd = ConnBdType.open(ConnBdType.SqlServer);
            connection = bd.open();
        
            StringBuilder sqlProc = new StringBuilder();
            sqlProc.append("{call sp_get_country_all}");
            
            if (connection != null){
               CallableStatement cstmt = connection.prepareCall(sqlProc.toString());
               ResultSet result = cstmt.executeQuery();            
               
               Vector<Country> vector = new Vector<>();
               
               while(result.next()) {
                   Country country = new Country(result);
                   vector.add(country);
               }
               
               Country[] country = new Country[vector.size()];
               for (int i = 0; i < vector.size(); i++) {
                   country[i] = vector.elementAt(i);                    
               }
               return country;
            }else{
                System.out.println("Error: Connexion no activa");
            }
        }catch(SQLException e){            
            StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
            Tools.getErrorMessage(stacktrace,"Error = " + e); 
        }finally{
            connection.close();
        }
        return null;
    }
    /**
     * @author MITM
     * @param find
     * @return 
     * @throws java.sql.SQLException 
     */
    public Country[] find_Country(String find) throws SQLException {
         try{
            BdInterface bd = ConnBdType.open(ConnBdType.SqlServer);
            connection = bd.open();
        
            StringBuilder sqlProc = new StringBuilder();
            sqlProc.append("{call sp_get_country_find(?)}");
            
            if (connection != null){
               CallableStatement cstmt = connection.prepareCall(sqlProc.toString());
               cstmt.setString("@country"  , find );
               ResultSet result = cstmt.executeQuery();            
               
               Vector<Country> vector = new Vector<>();
               
               while(result.next()) {
                   Country country = new Country(result);
                   vector.add(country);
               }
               
               Country[] country = new Country[vector.size()];
               for (int i = 0; i < vector.size(); i++) {
                   country[i] = vector.elementAt(i);                    
               }
               
               return country;
            }else{
                System.out.println("Error: Connexion no activa");
            }
        }catch(SQLException e){            
            StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
            Tools.getErrorMessage(stacktrace,"Error = " + e); 
        }finally{
            connection.close();
        }
        return null;
    }

    
    /***************************************************************************/
    /********************************* STATE ***********************************/
    /***************************************************************************/
    
    /**
     * @author MITM
     * @return 
     * @throws java.sql.SQLException 
     */
    public State[] load_State() throws SQLException {
         try{
            BdInterface bd = ConnBdType.open(ConnBdType.SqlServer);
            connection = bd.open();
        
            StringBuilder sqlProc = new StringBuilder();
            sqlProc.append("{call sp_get_state_all}");
            
            if (connection != null){
               CallableStatement cstmt = connection.prepareCall(sqlProc.toString());
               ResultSet result = cstmt.executeQuery();            
               
               Vector<State> vector = new Vector<>();
               
               while(result.next()) {
                   State state = new State(result);
                   vector.add(state);
               }
               
               State[] state = new State[vector.size()];
               for (int i = 0; i < vector.size(); i++) {
                   state[i] = vector.elementAt(i);                    
               }
               return state;
            }else{
                System.out.println("Error: Connexion no activa");
            }
        }catch(SQLException e){            
            StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
            Tools.getErrorMessage(stacktrace,"Error = " + e); 
        }finally{
            connection.close();
        }
        return null;
    }
    /**
     * @author MITM
     * @param find
     * @return 
     * @throws java.sql.SQLException 
     */
    public State[] find_State(String find) throws SQLException {
         try{
            BdInterface bd = ConnBdType.open(ConnBdType.SqlServer);
            connection = bd.open();
        
            StringBuilder sqlProc = new StringBuilder();
            sqlProc.append("{call sp_get_state_find(?)}");
            
            if (connection != null){
               CallableStatement cstmt = connection.prepareCall(sqlProc.toString());
               cstmt.setString("@country"  , find );
               ResultSet result = cstmt.executeQuery();            
               
               Vector<State> vector = new Vector<>();
               
               while(result.next()) {
                   State state = new State(result);
                   vector.add(state);
               }
               
               State[] state = new State[vector.size()];
               for (int i = 0; i < vector.size(); i++) {
                   state[i] = vector.elementAt(i);                    
               }
               
               return state;
            }else{
                System.out.println("Error: Connexion no activa");
            }
        }catch(SQLException e){            
            StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
            Tools.getErrorMessage(stacktrace,"Error = " + e); 
        }finally{
            connection.close();
        }
        return null;
    }

    
    /***************************************************************************/
    /********************************** CITY ***********************************/
    /***************************************************************************/
    
    /**
     * @author MITM
     * @return 
     * @throws java.sql.SQLException 
     */
    public City[] load_City() throws SQLException {
         try{
            BdInterface bd = ConnBdType.open(ConnBdType.SqlServer);
            connection = bd.open();
        
            StringBuilder sqlProc = new StringBuilder();
            sqlProc.append("{call sp_get_city_all}");
            
            if (connection != null){
               CallableStatement cstmt = connection.prepareCall(sqlProc.toString());
               ResultSet result = cstmt.executeQuery();            
               
               Vector<City> vector = new Vector<>();
               
               while(result.next()) {
                   City city = new City(result);
                   vector.add(city);
               }
               
               City[] city = new City[vector.size()];
               for (int i = 0; i < vector.size(); i++) {
                   city[i] = vector.elementAt(i);                    
               }
               return city;
            }else{
                System.out.println("Error: Connexion no activa");
            }
        }catch(SQLException e){            
            StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
            Tools.getErrorMessage(stacktrace,"Error = " + e); 
        }finally{
            connection.close();
        }
        return null;
    }
    /**
     * @author MITM
     * @param find
     * @return 
     * @throws java.sql.SQLException 
     */
    public City[] find_City(String find) throws SQLException {
        try{
            BdInterface bd = ConnBdType.open(ConnBdType.SqlServer);
            connection = bd.open();
        
            StringBuilder sqlProc = new StringBuilder();
            sqlProc.append("{call sp_get_city_find(?)}");
            
            if (connection != null){
               CallableStatement cstmt = connection.prepareCall(sqlProc.toString());
               cstmt.setString("@state"  , find );
               ResultSet result = cstmt.executeQuery();            
               Vector<City> vector = new Vector<>();
               
               while(result.next()) {
                   City city = new City(result);
                   vector.add(city);
               }
               
               City[] city = new City[vector.size()];
               for (int i = 0; i < vector.size(); i++) {
                   city[i] = vector.elementAt(i);                    
               }
               
               return city;
            }else{
                System.out.println("Error: Connexion no activa");
            }
        }catch(SQLException e){            
            StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
            Tools.getErrorMessage(stacktrace,"Error = " + e); 
        }finally{
            connection.close();
        }
        return null;
    }

    
    /***************************************************************************/
    /****************************** MUNICIPALITY *******************************/
    /***************************************************************************/
    
    /**
     * @author MITM
     * @return 
     * @throws java.sql.SQLException 
     */
    public Municipality[] load_Municipality() throws SQLException {
         try{
            BdInterface bd = ConnBdType.open(ConnBdType.SqlServer);
            connection = bd.open();
        
            StringBuilder sqlProc = new StringBuilder();
            sqlProc.append("{call sp_get_municipality_all}");
            
            if (connection != null){
               CallableStatement cstmt = connection.prepareCall(sqlProc.toString());
               ResultSet result = cstmt.executeQuery();            
               
               Vector<Municipality> vector = new Vector<>();
               
               while(result.next()) {
                   Municipality municipality = new Municipality(result);
                   vector.add(municipality);
               }
               
               Municipality[] municipality = new Municipality[vector.size()];
               for (int i = 0; i < vector.size(); i++) {
                   municipality[i] = vector.elementAt(i);                    
               }
               return municipality;
            }else{
                System.out.println("Error: Connexion no activa");
            }
        }catch(SQLException e){            
            StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
            Tools.getErrorMessage(stacktrace,"Error = " + e); 
        }finally{
            connection.close();
        }
        return null;
    }
    /**
     * @author MITM
     * @param find
     * @return 
     * @throws java.sql.SQLException 
     */
    public Municipality[] find_Municipality(String find) throws SQLException {
        try{
            BdInterface bd = ConnBdType.open(ConnBdType.SqlServer);
            connection = bd.open();
        
            StringBuilder sqlProc = new StringBuilder();
            sqlProc.append("{call sp_get_municipality_find(?)}");
            
            if (connection != null){
               CallableStatement cstmt = connection.prepareCall(sqlProc.toString());
               cstmt.setString("@municipality"  , find );
               ResultSet result = cstmt.executeQuery();            
               Vector<Municipality> vector = new Vector<>();
               
               while(result.next()) {
                   Municipality municipality = new Municipality(result);
                   vector.add(municipality);
               }
               
               Municipality[] municipality = new Municipality[vector.size()];
               for (int i = 0; i < vector.size(); i++) {
                   municipality[i] = vector.elementAt(i);                    
               }
               
               return municipality;
            }else{
                System.out.println("Error: Connexion no activa");
            }
        }catch(SQLException e){            
            StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
            Tools.getErrorMessage(stacktrace,"Error = " + e); 
        }finally{
            connection.close();
        }
        return null;
    }

    
    /***************************************************************************/
    /********************************* PARISH **********************************/
    /***************************************************************************/
    
    /**
     * @author MITM
     * @return 
     * @throws java.sql.SQLException 
     */
    public Parish[] load_Parish() throws SQLException {
         try{
            BdInterface bd = ConnBdType.open(ConnBdType.SqlServer);
            connection = bd.open();
        
            StringBuilder sqlProc = new StringBuilder();
            sqlProc.append("{call sp_get_parish_all}");
            
            if (connection != null){
               CallableStatement cstmt = connection.prepareCall(sqlProc.toString());
               ResultSet result = cstmt.executeQuery();            
               
               Vector<Parish> vector = new Vector<>();
               
               while(result.next()) {
                   Parish parish = new Parish(result);
                   vector.add(parish);
               }
               
               Parish[] parish = new Parish[vector.size()];
               for (int i = 0; i < vector.size(); i++) {
                   parish[i] = vector.elementAt(i);                    
               }
               return parish;
            }else{
                System.out.println("Error: Connexion no activa");
            }
        }catch(SQLException e){            
            StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
            Tools.getErrorMessage(stacktrace,"Error = " + e); 
        }finally{
            connection.close();
        }
        return null;
    }
    /**
     * @author MITM
     * @param findM
     * @param findS
     * @return 
     * @throws java.sql.SQLException 
     */
    public Parish[] find_Parish(String findM, String findS) throws SQLException {
        try{
            BdInterface bd = ConnBdType.open(ConnBdType.SqlServer);
            connection = bd.open();
        
            StringBuilder sqlProc = new StringBuilder();
            sqlProc.append("{call sp_get_parish_find(?,?)}");
            
            if (connection != null){
               CallableStatement cstmt = connection.prepareCall(sqlProc.toString());
               cstmt.setString("@municipality"  , findM );
               cstmt.setString("@state"  , findS );
               ResultSet result = cstmt.executeQuery();            
               Vector<Parish> vector = new Vector<>();
               
               while(result.next()) {
                   Parish parish = new Parish(result);
                   vector.add(parish);
               }
               
               Parish[] parish = new Parish[vector.size()];
               for (int i = 0; i < vector.size(); i++) {
                   parish[i] = vector.elementAt(i);                    
               }
               
               return parish;
            }else{
                System.out.println("Error: Connexion no activa");
            }
        }catch(SQLException e){            
            StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
            Tools.getErrorMessage(stacktrace,"Error = " + e); 
        }finally{
            connection.close();
        }
        return null;
    }

    
    /***************************************************************************/
    /******************************** MEASURE **********************************/
    /***************************************************************************/
    
    /**
     * @author MITM
     * @return 
     * @throws java.sql.SQLException 
     */
    public Measure[] load_Measure() throws SQLException {
         try{
            BdInterface bd = ConnBdType.open(ConnBdType.SqlServer);
            connection = bd.open();
        
            StringBuilder sqlProc = new StringBuilder();
            sqlProc.append("{call sp_get_measure_all}");
            
            if (connection != null){
               CallableStatement cstmt = connection.prepareCall(sqlProc.toString());
               ResultSet result = cstmt.executeQuery();            
               
               Vector<Measure> vector = new Vector<>();
               
               while(result.next()) {
                   Measure measure = new Measure(result);
                   vector.add(measure);
               }
               
               Measure[] measure = new Measure[vector.size()];
               for (int i = 0; i < vector.size(); i++) {
                   measure[i] = vector.elementAt(i);                    
               }
               return measure;
            }else{
                System.out.println("Error: Connexion no activa");
            }
        }catch(SQLException e){            
            StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
            Tools.getErrorMessage(stacktrace,"Error = " + e); 
        }finally{
            connection.close();
        }
        return null;
    }
    /**
     * @author MITM
     * @param find
     * @return 
     * @throws java.sql.SQLException 
     */
    public Measure[] find_Measure(String find) throws SQLException {
        try{
            BdInterface bd = ConnBdType.open(ConnBdType.SqlServer);
            connection = bd.open();
        
            StringBuilder sqlProc = new StringBuilder();
            sqlProc.append("{call sp_get_measure_find(?)}");
            
            if (connection != null){
               CallableStatement cstmt = connection.prepareCall(sqlProc.toString());
               cstmt.setString("@find"  , find );
               ResultSet result = cstmt.executeQuery();            
               Vector<Measure> vector = new Vector<>();
               
               while(result.next()) {
                   Measure measure = new Measure(result);
                   vector.add(measure);
               }
               
               Measure[] measure = new Measure[vector.size()];
               for (int i = 0; i < vector.size(); i++) {
                   measure[i] = vector.elementAt(i);                    
               }
               
               return measure;
            }else{
                System.out.println("Error: Connexion no activa");
            }
        }catch(SQLException e){            
            StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
            Tools.getErrorMessage(stacktrace,"Error = " + e); 
        }finally{
            connection.close();
        }
        return null;
    }
    /**
     * @author MITM
     * @param operacion Determina el Proceso que se va a ejecutar 1 INSERT, 2 UPDATE
     * @param measure
     * @return
     * @throws SQLException
     * @throws Exception 
     */
    public boolean save_Measure(int operacion, Measure measure) throws SQLException, Exception {
        
        BdInterface bd = ConnBdType.open(ConnBdType.SqlServer);
        connection = bd.open();        
        try{
         if (connection != null){
            //Inicia Transaccion 
            connection.setAutoCommit(false);
            StringBuilder sql = new StringBuilder();            
            String mensj = "";
            
            switch(operacion){
                case 1:
                    sql.append("{call sp_ins_measure(?, ?)}");
                    mensj = "Nueva Medida:";
                    break;
                case 2:
                    sql.append("{call sp_upd_measure_basic(?, ?, ?)}");
                    mensj = "Actualizando Medida:";
                    break;
            }
            CallableStatement cstmt = connection.prepareCall(sql.toString());
            switch(operacion){
                case 1:
                    cstmt.setString("@nombre"       , measure.getNombre().toUpperCase());
                    cstmt.setString("@abrev"        , measure.getAbrev().toUpperCase());
                    break;
                case 2:
                    cstmt.setInt("@id_measure"      , measure.getIdMeasure());
                    cstmt.setString("@nombre"       , measure.getNombre().toUpperCase());
                    cstmt.setString("@abrev"        , measure.getAbrev().toUpperCase());
                    break;
            }
            cstmt.execute();            
            // Auditar el proceso
            auditar(measure.getIdMeasure() + "",mensj);
            
            connection.commit();
            
            return true;
         }else{
            System.out.println("Error: Connexion no activa");
            throw new Exception("Error de Conexion con la BD");
         }
        }catch(Exception e){            
            connection.rollback();   
            StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
            Tools.getErrorMessage(stacktrace,"Error = " + e);    
            throw e;
        }finally{
            connection.close();
        }
    }
    /**
     * @author MITM
     * Valida si el measurename generado ya se encuentra asignado a una medida en la BD
     * @param measurename valor a ser chequeado en la BD
     * @return true si el measure esta en uso, false si esta disponible la medida
     * @throws java.sql.SQLException
     */
    public boolean check_Measure(String measurename) throws SQLException {
        try{
            BdInterface bd = ConnBdType.open(ConnBdType.SqlServer);
            connection = bd.open();
        
            StringBuilder sqlProc = new StringBuilder();
            sqlProc.append("{call sp_get_measure_check(?,?)}");
            
            if (connection != null){
               CallableStatement cstmt = connection.prepareCall(sqlProc.toString());                           
               cstmt.setString("@measure", measurename);
               cstmt.registerOutParameter("result", java.sql.Types.INTEGER);               
               cstmt.execute();
               if(cstmt.getInt("result") == 1) return true;               
            }else{
                System.out.println("Error: Connexion no activa");
            }
        }catch(SQLException e){            
            StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
            Tools.getErrorMessage(stacktrace,"Error = " + e); 
        }finally{
            connection.close();
        }
        return false;
    }
    /**
     * @author MITM
     * @param measure
     * @return 
     * @throws java.lang.Exception 
     */
    public boolean change_Measure(Measure measure) throws Exception {
        BdInterface bd = ConnBdType.open(ConnBdType.SqlServer);
        connection = bd.open();
        
        try{
         if (connection != null){
            //Inicia Transaccion 
            connection.setAutoCommit(false);
            
            StringBuilder sqlProc = new StringBuilder();
            sqlProc.append("{call sp_upd_measure_status(?,?)}");
            CallableStatement cstmt = connection.prepareCall(sqlProc.toString());                 
            cstmt.setInt("@id_measure", measure.getIdMeasure());
            int value = 0;
            if(measure.getStatus() == 0){
                value = 1;
            }            
            cstmt.setInt("@status", value );
            cstmt.execute();            
            // Auditar el proceso
            auditar(measure.getIdMeasure() + "","deleteMeasure:");
            
            connection.commit();
            
            return true;
         }else{
            System.out.println("Error: Connexion no activa");
            throw new Exception("Error de Conexion con la BD");
         }
        }catch(Exception e){            
            connection.rollback();            
            StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
            Tools.getErrorMessage(stacktrace,"Error = " + e);    
            throw e;
        }finally{
            connection.close();
        }
    }


    /***************************************************************************/
    /********************************* UNIT ************************************/
    /***************************************************************************/
    
    /**
     * @author MITM
     * @return 
     * @throws java.sql.SQLException 
     */
    public Unit[] load_Unit() throws SQLException {
         try{
            BdInterface bd = ConnBdType.open(ConnBdType.SqlServer);
            connection = bd.open();
        
            StringBuilder sqlProc = new StringBuilder();
            sqlProc.append("{call sp_get_unit_all}");
            
            if (connection != null){
               CallableStatement cstmt = connection.prepareCall(sqlProc.toString());
               ResultSet result = cstmt.executeQuery();            
               
               Vector<Unit> vector = new Vector<>();
               
               while(result.next()) {
                   Unit unit = new Unit(result);
                   vector.add(unit);
               }
               
               Unit[] unit = new Unit[vector.size()];
               for (int i = 0; i < vector.size(); i++) {
                   unit[i] = vector.elementAt(i);                    
               }
               return unit;
            }else{
                System.out.println("Error: Connexion no activa");
            }
        }catch(SQLException e){            
            StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
            Tools.getErrorMessage(stacktrace,"Error = " + e); 
        }finally{
            connection.close();
        }
        return null;
    }
    /**
     * @author MITM
     * @param find
     * @return 
     * @throws java.sql.SQLException 
     */
    public Unit[] find_Unit(String find) throws SQLException {
        try{
            BdInterface bd = ConnBdType.open(ConnBdType.SqlServer);
            connection = bd.open();
        
            StringBuilder sqlProc = new StringBuilder();
            sqlProc.append("{call sp_get_unit_find(?)}");
            
            if (connection != null){
               CallableStatement cstmt = connection.prepareCall(sqlProc.toString());
               cstmt.setString("@find"  , find );
               ResultSet result = cstmt.executeQuery();            
               Vector<Unit> vector = new Vector<>();
               
               while(result.next()) {
                   Unit unit = new Unit(result);
                   vector.add(unit);
               }
               
               Unit[] unit = new Unit[vector.size()];
               for (int i = 0; i < vector.size(); i++) {
                   unit[i] = vector.elementAt(i);                    
               }
               
               return unit;
            }else{
                System.out.println("Error: Connexion no activa");
            }
        }catch(SQLException e){            
            StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
            Tools.getErrorMessage(stacktrace,"Error = " + e); 
        }finally{
            connection.close();
        }
        return null;
    }
    /**
     * @author MITM
     * @param operacion Determina el Proceso que se va a ejecutar 1 INSERT, 2 UPDATE
     * @param unit
     * @return
     * @throws SQLException
     * @throws Exception 
     */
    public boolean save_Unit(int operacion, Unit unit) throws SQLException, Exception {
        
        BdInterface bd = ConnBdType.open(ConnBdType.SqlServer);
        connection = bd.open();        
        try{
         if (connection != null){
            //Inicia Transaccion 
            connection.setAutoCommit(false);
            StringBuilder sql = new StringBuilder();            
            String mensj = "";
            
            switch(operacion){
                case 1:
                    sql.append("{call sp_ins_unit(?, ?)}");
                    mensj = "Nueva Unidad:";
                    break;
                case 2:
                    sql.append("{call sp_upd_unit_basic(?, ?, ?)}");
                    mensj = "Actualizando Unidad:";
                    break;
            }
            CallableStatement cstmt = connection.prepareCall(sql.toString());
            switch(operacion){
                case 1:
                    cstmt.setString("@nombre"       , unit.getNombre().toUpperCase());
                    cstmt.setString("@abrev"        , unit.getAbrev().toUpperCase());
                    break;
                case 2:
                    cstmt.setInt("@id_unit"         , unit.getIdUnit());
                    cstmt.setString("@nombre"       , unit.getNombre().toUpperCase());
                    cstmt.setString("@abrev"        , unit.getAbrev().toUpperCase());
                    break;
            }
            cstmt.execute();            
            // Auditar el proceso
            auditar(unit.getIdUnit()+ "",mensj);
            
            connection.commit();
            
            return true;
         }else{
            System.out.println("Error: Connexion no activa");
            throw new Exception("Error de Conexion con la BD");
         }
        }catch(Exception e){            
            connection.rollback();   
            StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
            Tools.getErrorMessage(stacktrace,"Error = " + e);    
            throw e;
        }finally{
            connection.close();
        }
    }
    /**
     * @author MITM
     * Valida si el measurename generado ya se encuentra asignado a una medida en la BD
     * @param unitname valor a ser chequeado en la BD
     * @return true si el measure esta en uso, false si esta disponible la medida
     * @throws java.sql.SQLException
     */
    public boolean check_Unit(String unitname) throws SQLException {
        try{
            BdInterface bd = ConnBdType.open(ConnBdType.SqlServer);
            connection = bd.open();
        
            StringBuilder sqlProc = new StringBuilder();
            sqlProc.append("{call sp_get_unit_check(?,?)}");
            
            if (connection != null){
               CallableStatement cstmt = connection.prepareCall(sqlProc.toString());                           
               cstmt.setString("@unit", unitname);
               cstmt.registerOutParameter("result", java.sql.Types.INTEGER);               
               cstmt.execute();
               if(cstmt.getInt("result") == 1) return true;               
            }else{
                System.out.println("Error: Connexion no activa");
            }
        }catch(SQLException e){            
            StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
            Tools.getErrorMessage(stacktrace,"Error = " + e); 
        }finally{
            connection.close();
        }
        return false;
    }
    /**
     * @author MITM
     * @param unit
     * @return 
     * @throws java.lang.Exception 
     */
    public boolean change_Unit(Unit unit) throws Exception {
        BdInterface bd = ConnBdType.open(ConnBdType.SqlServer);
        connection = bd.open();
        
        try{
         if (connection != null){
            //Inicia Transaccion 
            connection.setAutoCommit(false);
            
            StringBuilder sqlProc = new StringBuilder();
            sqlProc.append("{call sp_upd_unit_status(?,?)}");
            CallableStatement cstmt = connection.prepareCall(sqlProc.toString());                 
            cstmt.setInt("@id_unit", unit.getIdUnit());
            int value = 0;
            if(unit.getStatus() == 0){
                value = 1;
            }            
            cstmt.setInt("@status", value );
            cstmt.execute();            
            // Auditar el proceso
            auditar(unit.getIdUnit() + "","deleteUnit:");
            
            connection.commit();
            
            return true;
         }else{
            System.out.println("Error: Connexion no activa");
            throw new Exception("Error de Conexion con la BD");
         }
        }catch(Exception e){            
            connection.rollback();            
            StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
            Tools.getErrorMessage(stacktrace,"Error = " + e);    
            throw e;
        }finally{
            connection.close();
        }
    }

    
    /***************************************************************************/
    /******************************** REASON ***********************************/
    /***************************************************************************/
    
    /**
     * @author MITM
     * @return 
     * @throws java.sql.SQLException 
     */
    public log_TMotdev[] load_log_TMotdev() throws SQLException {
         try{
            BdInterface bd = ConnBdType.open(ConnBdType.SqlServer);
            connection = bd.open();
        
            StringBuilder sqlProc = new StringBuilder();
            sqlProc.append("{call sp_get_log_tmotdev_all}");
            
            if (connection != null){
               CallableStatement cstmt = connection.prepareCall(sqlProc.toString());
               ResultSet result = cstmt.executeQuery();            
               
               Vector<log_TMotdev> vector = new Vector<>();
               
               while(result.next()) {
                   log_TMotdev log_tmotdev = new log_TMotdev(result);
                   vector.add(log_tmotdev);
               }
               
               log_TMotdev[] log_tmotdev = new log_TMotdev[vector.size()];
               for (int i = 0; i < vector.size(); i++) {
                   log_tmotdev[i] = vector.elementAt(i);                    
               }
               return log_tmotdev;
            }else{
                System.out.println("Error: Connexion no activa");
            }
        }catch(SQLException e){            
            StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
            Tools.getErrorMessage(stacktrace,"Error = " + e); 
        }finally{
            connection.close();
        }
        return null;
    }
    /**
     * @author MITM
     * @param find
     * @return 
     * @throws java.sql.SQLException 
     */
    public log_TMotdev[] find_log_TMotdev(String find) throws SQLException {
        try{
            BdInterface bd = ConnBdType.open(ConnBdType.SqlServer);
            connection = bd.open();
        
            StringBuilder sqlProc = new StringBuilder();
            sqlProc.append("{call sp_get_log_tmotdev_find(?)}");
            
            if (connection != null){
               CallableStatement cstmt = connection.prepareCall(sqlProc.toString());
               cstmt.setString("@find"  , find );
               ResultSet result = cstmt.executeQuery();            
               Vector<log_TMotdev> vector = new Vector<>();
               
               while(result.next()) {
                   log_TMotdev log_tmotdev = new log_TMotdev(result);
                   vector.add(log_tmotdev);
               }
               
               log_TMotdev[] measure = new log_TMotdev[vector.size()];
               for (int i = 0; i < vector.size(); i++) {
                   measure[i] = vector.elementAt(i);                    
               }
               
               return measure;
            }else{
                System.out.println("Error: Connexion no activa");
            }
        }catch(SQLException e){            
            StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
            Tools.getErrorMessage(stacktrace,"Error = " + e); 
        }finally{
            connection.close();
        }
        return null;
    }
    /**
     * @author MITM
     * @param operacion Determina el Proceso que se va a ejecutar 1 INSERT, 2 UPDATE
     * @param log_tmotdev
     * @return
     * @throws SQLException
     * @throws Exception 
     */
    public boolean save_log_TMotdev(int operacion, log_TMotdev log_tmotdev) throws SQLException, Exception {
        
        BdInterface bd = ConnBdType.open(ConnBdType.SqlServer);
        connection = bd.open();        
        try{
         if (connection != null){
            //Inicia Transaccion 
            connection.setAutoCommit(false);
            StringBuilder sql = new StringBuilder();            
            String mensj = "";
            
            switch(operacion){
                case 1:
                    sql.append("{call sp_ins_log_tmotdev(?, ?, ?)}");
                    mensj = "Nuevo Motivo:";
                    break;
                case 2:
                    sql.append("{call sp_upd_log_tmotdev_basic(?, ?, ?, ?)}");
                    mensj = "Actualizando Motivo:";
                    break;
            }
            CallableStatement cstmt = connection.prepareCall(sql.toString());
            switch(operacion){
                case 1:
                    cstmt.setString("@nombre"       , log_tmotdev.getNombre().toUpperCase());
                    cstmt.setString("@abrev"        , log_tmotdev.getAbrev().toUpperCase());
                    cstmt.setInt("@val"             , log_tmotdev.getValdev());
                    break;
                case 2:
                    cstmt.setInt("@id_motivo"       , log_tmotdev.getIdTMotdev());
                    cstmt.setString("@nombre"       , log_tmotdev.getNombre().toUpperCase());
                    cstmt.setString("@abrev"        , log_tmotdev.getAbrev().toUpperCase());
                    cstmt.setInt("@val"             , log_tmotdev.getValdev());
                    break;
            }
            cstmt.execute();            
            // Auditar el proceso
            auditar(log_tmotdev.getIdTMotdev()+ "",mensj);
            
            connection.commit();
            
            return true;
         }else{
            System.out.println("Error: Connexion no activa");
            throw new Exception("Error de Conexion con la BD");
         }
        }catch(Exception e){            
            connection.rollback();   
            StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
            Tools.getErrorMessage(stacktrace,"Error = " + e);    
            throw e;
        }finally{
            connection.close();
        }
    }
    /**
     * @author MITM
     * Valida si el measurename generado ya se encuentra asignado a una medida en la BD
     * @param log_tmotdevname valor a ser chequeado en la BD
     * @return true si el measure esta en uso, false si esta disponible la medida
     * @throws java.sql.SQLException
     */
    public boolean check_log_TMotdev(String log_tmotdevname) throws SQLException {
        try{
            BdInterface bd = ConnBdType.open(ConnBdType.SqlServer);
            connection = bd.open();
        
            StringBuilder sqlProc = new StringBuilder();
            sqlProc.append("{call sp_get_log_tmotdev_check(?,?)}");
            
            if (connection != null){
               CallableStatement cstmt = connection.prepareCall(sqlProc.toString());                           
               cstmt.setString("@motivo", log_tmotdevname);
               cstmt.registerOutParameter("result", java.sql.Types.INTEGER);               
               cstmt.execute();
               if(cstmt.getInt("result") == 1) return true;               
            }else{
                System.out.println("Error: Connexion no activa");
            }
        }catch(SQLException e){            
            StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
            Tools.getErrorMessage(stacktrace,"Error = " + e); 
        }finally{
            connection.close();
        }
        return false;
    }
    /**
     * @author MITM
     * @param log_tmotdev
     * @return 
     * @throws java.lang.Exception 
     */
    public boolean change_log_TMotdev(log_TMotdev log_tmotdev) throws Exception {
        BdInterface bd = ConnBdType.open(ConnBdType.SqlServer);
        connection = bd.open();
        
        try{
         if (connection != null){
            //Inicia Transaccion 
            connection.setAutoCommit(false);
            
            StringBuilder sqlProc = new StringBuilder();
            sqlProc.append("{call sp_upd_log_tmotdev_status(?,?)}");
            CallableStatement cstmt = connection.prepareCall(sqlProc.toString());                 
            cstmt.setInt("@id_motivo", log_tmotdev.getIdTMotdev());
            int value = 0;
            if(log_tmotdev.getStatus() == 0){
                value = 1;
            }            
            cstmt.setInt("@status", value );
            cstmt.execute();            
            // Auditar el proceso
            auditar(log_tmotdev.getIdTMotdev()+ "","deleteReason:");
            
            connection.commit();
            
            return true;
         }else{
            System.out.println("Error: Connexion no activa");
            throw new Exception("Error de Conexion con la BD");
         }
        }catch(Exception e){            
            connection.rollback();            
            StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
            Tools.getErrorMessage(stacktrace,"Error = " + e);    
            throw e;
        }finally{
            connection.close();
        }
    }


    /***************************************************************************/
    /******************************** SUPPLIER *********************************/
    /***************************************************************************/
    
    /**
     * @author MITM
     * @return 
     * @throws java.sql.SQLException 
     */
    public Supplier[] load_Supplier() throws SQLException {
         try{
            BdInterface bd = ConnBdType.open(ConnBdType.SqlServer);
            connection = bd.open();
        
            StringBuilder sqlProc = new StringBuilder();
            sqlProc.append("{call sp_get_supplier_all}");
            
            if (connection != null){
               CallableStatement cstmt = connection.prepareCall(sqlProc.toString());
               ResultSet result = cstmt.executeQuery();            
               
               Vector<Supplier> vector = new Vector<>();
               
               while(result.next()) {                   
                   Supplier supplier = new Supplier(result);
                   vector.add(supplier);
               }
               
               Supplier[] supplier = new Supplier[vector.size()];
               for (int i = 0; i < vector.size(); i++) {
                   supplier[i] = vector.elementAt(i);                    
               }
               return supplier;
            }else{
                System.out.println("Error: Connexion no activa");
            }
        }catch(SQLException e){            
            StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
            Tools.getErrorMessage(stacktrace,"Error = " + e); 
        }finally{
            connection.close();
        }
        return null;
    }
    /**
     * @author MITM
     * @param find
     * @return 
     * @throws java.sql.SQLException 
     */
    public Supplier[] find_Supplier(String find) throws SQLException {
        try{
            BdInterface bd = ConnBdType.open(ConnBdType.SqlServer);
            connection = bd.open();
        
            StringBuilder sqlProc = new StringBuilder();
            sqlProc.append("{call sp_get_supplier_find(?)}");
            
            if (connection != null){
               CallableStatement cstmt = connection.prepareCall(sqlProc.toString());
               cstmt.setString("@find"  , find );
               ResultSet result = cstmt.executeQuery();            
               Vector<Supplier> vector = new Vector<>();
               
               while(result.next()) {
                   Supplier supplier = new Supplier(result);
                   vector.add(supplier);
               }
               
               Supplier[] supplier = new Supplier[vector.size()];
               for (int i = 0; i < vector.size(); i++) {
                   supplier[i] = vector.elementAt(i);                    
               }
               
               return supplier;
            }else{
                System.out.println("Error: Connexion no activa");
            }
        }catch(SQLException e){            
            StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
            Tools.getErrorMessage(stacktrace,"Error = " + e); 
        }finally{
            connection.close();
        }
        return null;
    }
    /**
     * @author MITM
     * @param operacion Determina el Proceso que se va a ejecutar 1 INSERT, 2 UPDATE
     * @param supplier
     * @return
     * @throws SQLException
     * @throws Exception 
     */
    public boolean save_Supplier(int operacion, Supplier supplier) throws SQLException, Exception {
        
        BdInterface bd = ConnBdType.open(ConnBdType.SqlServer);
        connection = bd.open();        
        try{
         if (connection != null){
            //Inicia Transaccion 
            connection.setAutoCommit(false);
            StringBuilder sql = new StringBuilder();            
            String mensj = "";
            
            switch(operacion){
                case 1:
                    sql.append("{call sp_ins_prov_data(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}");
                    mensj = "Nuevo Proveedor:";
                    break;
                case 2:
                    sql.append("{call sp_upd_prov_basic(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}");
                    mensj = "Actualizando Proveedor:";
                    break;
            }
            CallableStatement cstmt = connection.prepareCall(sql.toString());
            cstmt.setString("@rif_prov"         , supplier.getRif());
            cstmt.setInt("@rif_val"             , supplier.getRif_val());
            cstmt.setInt("@sen_areten"          , supplier.getSen_areten());
            cstmt.setInt("@sen_civa"            , supplier.getSen_civa());
            cstmt.setInt("@sen_preten"          , supplier.getSen_preten());
            cstmt.setInt("@grp_prov"            , supplier.getGroupsupplier().getIdGroupSupplier());
            cstmt.setString("@nombre"           , supplier.getNombre());
            cstmt.setString("@firma"            , supplier.getFirma());
            if (supplier.getCity() != null)
                cstmt.setInt("@id_ciudad"       , supplier.getCity().getIdPoblacion());
            else
                cstmt.setInt("@id_ciudad"       , 0);

            if (supplier.getParish() != null)
                cstmt.setInt("@id_parroquia"    , supplier.getParish().getIdPoblacion());
            else
                cstmt.setInt("@id_parroquia"    , 0);

            if (supplier.getMunicipality() != null)
                cstmt.setInt("@id_municipio"    , supplier.getMunicipality().getIdPoblacion());
            else
                cstmt.setInt("@id_municipio"    , 0);

            if (supplier.getState() != null)
                cstmt.setInt("@id_estado"       , supplier.getState().getIdPoblacion());
            else
                cstmt.setInt("@id_estado"       , 0);

//            cstmt.setInt("@id_parroquia"        , supplier.getParish().getIdPoblacion());
//            cstmt.setInt("@id_municipio"        , supplier.getMunicipality().getIdPoblacion());
//            cstmt.setInt("@id_estado"           , supplier.getState().getIdPoblacion());
            cstmt.setInt("@id_pais"             , supplier.getCountry().getIdPoblacion());
            cstmt.setString("@direccion"        , supplier.getDireccion().toLowerCase());
            cstmt.setString("@telefonos"        , supplier.getTelefonos());
            cstmt.setString("@fax"              , supplier.getFax());
            cstmt.setString("@correo1"          , supplier.getCorreo1());
            cstmt.setString("@correo2"          , supplier.getCorreo2());
            cstmt.setString("@contacto"         , supplier.getContacto());
            cstmt.setString("@celular"          , supplier.getCelular());

            cstmt.execute();            
            // Auditar el proceso
            auditar(supplier.getIdSupplier() + "",mensj);
            
            connection.commit();
            
            return true;
         }else{
            System.out.println("Error: Connexion no activa");
            throw new Exception("Error de Conexion con la BD");
         }
        }catch(Exception e){            
            connection.rollback();   
            StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
            Tools.getErrorMessage(stacktrace,"Error = " + e);    
            throw e;
        }finally{
            connection.close();
        }
    }
    /**
     * @author MITM
     * Valida si el measurename generado ya se encuentra asignado a una medida en la BD
     * @param supplierRif valor a ser chequeado en la BD
     * @return true si el measure esta en uso, false si esta disponible la medida
     * @throws java.sql.SQLException
     */
    public boolean check_Supplier(String supplierRif) throws SQLException {
        try{
            BdInterface bd = ConnBdType.open(ConnBdType.SqlServer);
            connection = bd.open();
        
            StringBuilder sqlProc = new StringBuilder();
            sqlProc.append("{call sp_get_supplier_check(?,?,?)}");
            if (connection != null){
               CallableStatement cstmt = connection.prepareCall(sqlProc.toString());                           
               cstmt.setString("@rif_prov", supplierRif);
               cstmt.registerOutParameter("result", java.sql.Types.INTEGER);               
               cstmt.registerOutParameter("seniat", java.sql.Types.INTEGER);               
               cstmt.execute();
               Datos.setStSeniat(cstmt.getInt("seniat"));
               if(cstmt.getInt("result") == 1) return true;               
            }else{
                System.out.println("Error: Connexion no activa");
            }
        }catch(SQLException e){            
            StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
            Tools.getErrorMessage(stacktrace,"Error = " + e); 
        }finally{
            connection.close();
        }
        return false;
    }
    /**
     * @author MITM
     * @param supplier
     * @return 
     * @throws java.lang.Exception 
     */
    public boolean change_Supplier(Supplier supplier) throws Exception {
        BdInterface bd = ConnBdType.open(ConnBdType.SqlServer);
        connection = bd.open();
        
        try{
         if (connection != null){
            //Inicia Transaccion 
            connection.setAutoCommit(false);
            
            StringBuilder sqlProc = new StringBuilder();
            sqlProc.append("{call sp_upd_prov_status(?,?)}");
            CallableStatement cstmt = connection.prepareCall(sqlProc.toString());                 
            cstmt.setString("@rif_prov", supplier.getRif());
            int value = 0;
            if(supplier.getStatus() == 0){
                value = 1;
            }            
            cstmt.setInt("@status", value );
            cstmt.execute();            
            // Auditar el proceso
            auditar(supplier.getIdSupplier() + "","deleteProveedor:");
            
            connection.commit();
            
            return true;
         }else{
            System.out.println("Error: Connexion no activa");
            throw new Exception("Error de Conexion con la BD");
         }
        }catch(Exception e){            
            connection.rollback();            
            StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
            Tools.getErrorMessage(stacktrace,"Error = " + e);    
            throw e;
        }finally{
            connection.close();
        }
    }
    
   
    /***************************************************************************/
    /********************************** SEX ************************************/
    /***************************************************************************/
    
    /**
     * @author MITM
     * @return 
     * @throws java.sql.SQLException 
     */
    public Sex[] load_Sex() throws SQLException {
         try{
            BdInterface bd = ConnBdType.open(ConnBdType.SqlServer);
            connection = bd.open();
        
            StringBuilder sqlProc = new StringBuilder();
            sqlProc.append("{call sp_get_sex_all}");
            
            if (connection != null){
               CallableStatement cstmt = connection.prepareCall(sqlProc.toString());
               ResultSet result = cstmt.executeQuery();            
               
               Vector<Sex> vector = new Vector<>();
               
               while(result.next()) {
                   Sex sex = new Sex(result);
                   vector.add(sex);
               }
               
               Sex[] sex = new Sex[vector.size()];
               for (int i = 0; i < vector.size(); i++) {
                   sex[i] = vector.elementAt(i);                    
               }
               return sex;
            }else{
                System.out.println("Error: Connexion no activa");
            }
        }catch(SQLException e){            
            StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
            Tools.getErrorMessage(stacktrace,"Error = " + e); 
        }finally{
            connection.close();
        }
        return null;
    }
    /**
     * @author MITM
     * @param find
     * @return 
     * @throws java.sql.SQLException 
     */
    public Sex[] find_Sex(String find) throws SQLException {
        try{
            BdInterface bd = ConnBdType.open(ConnBdType.SqlServer);
            connection = bd.open();
        
            StringBuilder sqlProc = new StringBuilder();
            sqlProc.append("{call sp_get_sex_find(?)}");
            
            if (connection != null){
               CallableStatement cstmt = connection.prepareCall(sqlProc.toString());
               cstmt.setString("@find"  , find );
               ResultSet result = cstmt.executeQuery();            
               Vector<Sex> vector = new Vector<>();
               
               while(result.next()) {
                   Sex sex = new Sex(result);
                   vector.add(sex);
               }
               
               Sex[] sex = new Sex[vector.size()];
               for (int i = 0; i < vector.size(); i++) {
                   sex[i] = vector.elementAt(i);                    
               }
               
               return sex;
            }else{
                System.out.println("Error: Connexion no activa");
            }
        }catch(SQLException e){            
            StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
            Tools.getErrorMessage(stacktrace,"Error = " + e); 
        }finally{
            connection.close();
        }
        return null;
    }
    /**
     * @author MITM
     * @param operacion Determina el Proceso que se va a ejecutar 1 INSERT, 2 UPDATE
     * @param sex
     * @return
     * @throws SQLException
     * @throws Exception 
     */
    public boolean save_Sex(int operacion, Sex sex) throws SQLException, Exception {
        
        BdInterface bd = ConnBdType.open(ConnBdType.SqlServer);
        connection = bd.open();        
        try{
         if (connection != null){
            //Inicia Transaccion 
            connection.setAutoCommit(false);
            StringBuilder sql = new StringBuilder();            
            String mensj = "";
            
            switch(operacion){
                case 1:
                    sql.append("{call sp_ins_sex(?, ?)}");
                    mensj = "Nuevo Sexo:";
                    break;
                case 2:
                    sql.append("{call sp_upd_sex_basic(?, ?, ?)}");
                    mensj = "Actualizando Sexo:";
                    break;
            }
            CallableStatement cstmt = connection.prepareCall(sql.toString());
            switch(operacion){
                case 1:
                    cstmt.setString("@nombre"       , sex.getNombre().toUpperCase());
                    cstmt.setString("@abrev"        , sex.getAbrev().toUpperCase());
                    break;
                case 2:
                    cstmt.setInt("@grp_supplier"    , sex.getIdSexo());
                    cstmt.setString("@nombre"       , sex.getNombre().toUpperCase());
                    cstmt.setString("@abrev"        , sex.getAbrev().toUpperCase());
                    break;
            }
            cstmt.execute();            
            // Auditar el proceso
            auditar(sex.getIdSexo()+ "",mensj);
            
            connection.commit();
            
            return true;
         }else{
            System.out.println("Error: Connexion no activa");
            throw new Exception("Error de Conexion con la BD");
         }
        }catch(Exception e){            
            connection.rollback();   
            StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
            Tools.getErrorMessage(stacktrace,"Error = " + e);    
            throw e;
        }finally{
            connection.close();
        }
    }
    /**
     * @author MITM
     * Valida si el groupsuppliername generado ya se encuentra asignado a un grupo en la BD
     * @param sexname valor a ser chequeado en la BD
     * @return true si el groupsupplier esta en uso, false si esta disponible el grupo
     * @throws java.sql.SQLException
     */
    public boolean check_Sex(String sexname) throws SQLException {
        try{
            BdInterface bd = ConnBdType.open(ConnBdType.SqlServer);
            connection = bd.open();
        
            StringBuilder sqlProc = new StringBuilder();
            sqlProc.append("{call sp_get_sex_check(?,?)}");
            
            if (connection != null){
               CallableStatement cstmt = connection.prepareCall(sqlProc.toString());                           
               cstmt.setString("@id_sex", sexname);
               cstmt.registerOutParameter("result", java.sql.Types.INTEGER);               
               cstmt.execute();
               if(cstmt.getInt("result") == 1) return true;               
            }else{
                System.out.println("Error: Connexion no activa");
            }
        }catch(SQLException e){            
            StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
            Tools.getErrorMessage(stacktrace,"Error = " + e); 
        }finally{
            connection.close();
        }
        return false;
    }
    /**
     * @author MITM
     * @param sex
     * @return 
     * @throws java.lang.Exception
    */
    public boolean change_Sex(Sex sex) throws Exception {
        BdInterface bd = ConnBdType.open(ConnBdType.SqlServer);
        connection = bd.open();
        
        try{
         if (connection != null){
            //Inicia Transaccion 
            connection.setAutoCommit(false);
            
            StringBuilder sqlProc = new StringBuilder();
            sqlProc.append("{call sp_upd_sex_status(?,?)}");
            CallableStatement cstmt = connection.prepareCall(sqlProc.toString());                 
            cstmt.setInt("@id_sex", sex.getIdSexo());
            int value = 0;
            if(sex.getStatus()== 0){
                value = 1;
            }            
            cstmt.setInt("@status", value );
            cstmt.execute();            
            // Auditar el proceso
            auditar(sex.getIdSexo()+ "","deleteSex:");
            
            connection.commit();
            
            return true;
         }else{
            System.out.println("Error: Connexion no activa");
            throw new Exception("Error de Conexion con la BD");
         }
        }catch(Exception e){            
            connection.rollback();            
            StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
            Tools.getErrorMessage(stacktrace,"Error = " + e);    
            throw e;
        }finally{
            connection.close();
        }
    }

    
    /***************************************************************************/
    /****************************** LOG_PERSONAL *******************************/
    /***************************************************************************/
    
    /**
     * @author MITM
     * @return 
     * @throws java.sql.SQLException 
     */
    public log_Personal[] load_log_Personal() throws SQLException {
         try{
            BdInterface bd = ConnBdType.open(ConnBdType.SqlServer);
            connection = bd.open();
        
            StringBuilder sqlProc = new StringBuilder();
            sqlProc.append("{call sp_get_log_personal_all}");
            
            if (connection != null){
               CallableStatement cstmt = connection.prepareCall(sqlProc.toString());
               ResultSet result = cstmt.executeQuery();            

               Vector<log_Personal> vector = new Vector<>();
               
               while(result.next()) {                   
                   log_Personal log_personal = new log_Personal(result);
                   vector.add(log_personal);
               }
               
               log_Personal[] log_personal = new log_Personal[vector.size()];
               for (int i = 0; i < vector.size(); i++) {
                   log_personal[i] = vector.elementAt(i);                    
               }
               return log_personal;
            }else{
                System.out.println("Error: Connexion no activa");
            }
        }catch(SQLException e){            
            StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
            Tools.getErrorMessage(stacktrace,"Error = " + e); 
        }finally{
            connection.close();
        }
        return null;
    }
    /**
     * @author MITM
     * @param find
     * @return 
     * @throws java.sql.SQLException 
     */
    public log_Personal[] find_log_Personal(String find) throws SQLException {
        try{
            BdInterface bd = ConnBdType.open(ConnBdType.SqlServer);
            connection = bd.open();
        
            StringBuilder sqlProc = new StringBuilder();
            sqlProc.append("{call sp_get_log_personal_find(?)}");
            
            if (connection != null){
               CallableStatement cstmt = connection.prepareCall(sqlProc.toString());
               cstmt.setString("@find"  , find );
               ResultSet result = cstmt.executeQuery();            
               Vector<log_Personal> vector = new Vector<>();
               
               while(result.next()) {
                   log_Personal log_personal = new log_Personal(result);
                   vector.add(log_personal);
               }
               
               log_Personal[] log_personal = new log_Personal[vector.size()];
               for (int i = 0; i < vector.size(); i++) {
                   log_personal[i] = vector.elementAt(i);                    
               }
               
               return log_personal;
            }else{
                System.out.println("Error: Connexion no activa");
            }
        }catch(SQLException e){            
            StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
            Tools.getErrorMessage(stacktrace,"Error = " + e); 
        }finally{
            connection.close();
        }
        return null;
    }
    /**
     * @author MITM
     * @param find
     * @param tpersonal1
     * @param tpersonal2
     * @return 
     * @throws java.sql.SQLException 
     */
    public log_Personal[] find_log_Personal_tp(String find, int tpersonal1, int tpersonal2) throws SQLException {
        try{
            BdInterface bd = ConnBdType.open(ConnBdType.SqlServer);
            connection = bd.open();
        
            StringBuilder sqlProc = new StringBuilder();
            sqlProc.append("{call sp_get_log_personal_find_tp(?,?,?)}");
            
            if (connection != null){
               CallableStatement cstmt = connection.prepareCall(sqlProc.toString());
               cstmt.setString("@find"  , find );
               cstmt.setInt("@tpersonal1"  , tpersonal1 );
               cstmt.setInt("@tpersonal2"  , tpersonal2 );
               ResultSet result = cstmt.executeQuery();            
               Vector<log_Personal> vector = new Vector<>();
               
               while(result.next()) {
                   log_Personal log_personal = new log_Personal(result);
                   vector.add(log_personal);
               }
               
               log_Personal[] log_personal = new log_Personal[vector.size()];
               for (int i = 0; i < vector.size(); i++) {
                   log_personal[i] = vector.elementAt(i);                    
               }
               
               return log_personal;
            }else{
                System.out.println("Error: Connexion no activa");
            }
        }catch(SQLException e){            
            StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
            Tools.getErrorMessage(stacktrace,"Error = " + e); 
        }finally{
            connection.close();
        }
        return null;
    }
    /**
     * @author MITM
     * @param operacion Determina el Proceso que se va a ejecutar 1 INSERT, 2 UPDATE
     * @param log_personal
     * @return
     * @throws SQLException
     * @throws Exception 
     */
    public boolean save_log_Personal(int operacion, log_Personal log_personal) throws SQLException, Exception {
        
        BdInterface bd = ConnBdType.open(ConnBdType.SqlServer);
        connection = bd.open();        
        try{
         if (connection != null){
            //Inicia Transaccion 
            connection.setAutoCommit(false);
            StringBuilder sql = new StringBuilder();            
            String mensj = "";
            
            switch(operacion){
                case 1:
                    sql.append("{call sp_ins_log_personal_data(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}");
                    mensj = "Nuevo Personal:";
                    break;
                case 2:
                    sql.append("{call sp_upd_log_personal_basic(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}");
                    mensj = "Actualizando Personal:";
                    break;
            }
            CallableStatement cstmt = connection.prepareCall(sql.toString());
            cstmt.setString("@nro_ci"           , log_personal.getNro_ci());
            cstmt.setInt("@tpersonal"           , log_personal.getTpersonal().getIdTPersonal());
            cstmt.setInt("@sexo"                , log_personal.getSex().getIdSexo());
            cstmt.setString("@nombres"          , log_personal.getNombres().toUpperCase());
            cstmt.setString("@apellidos"        , log_personal.getApellidos().toUpperCase());
            cstmt.setInt("@id_ciudad"           , log_personal.getCity().getIdPoblacion());
            cstmt.setInt("@id_parroquia"        , log_personal.getParish().getIdPoblacion());
            cstmt.setInt("@id_municipio"        , log_personal.getMunicipality().getIdPoblacion());
            cstmt.setInt("@id_estado"           , log_personal.getState().getIdPoblacion());
            cstmt.setInt("@id_pais"             , log_personal.getCountry());
            cstmt.setString("@direccion"        , log_personal.getDireccion().toLowerCase());
            cstmt.setString("@telefonos"        , log_personal.getTelefonos());
            cstmt.setString("@celular"          , log_personal.getCelular());
            cstmt.setString("@correo"           , log_personal.getCorreo());
            cstmt.setString("@ruta_ci"          , log_personal.getRuta_ci());
            cstmt.setString("@ruta_lc"          , log_personal.getRuta_lc());
            cstmt.setString("@ruta_cm"          , log_personal.getRuta_cm());
            cstmt.setString("@ruta_cs"          , log_personal.getRuta_cs());
            cstmt.setString("@ruta_ma"          , log_personal.getRuta_ma());
            
            if(log_personal.getFec_lc().toString().equals(LocalDate.now().toString())) 
                cstmt.setDate("@fec_lc"         , null);
            else
                cstmt.setDate("@fec_lc"         , log_personal.getFec_lc());

            if(log_personal.getFec_cm().toString().equals(LocalDate.now().toString())) 
                cstmt.setDate("@fec_cm"         , null);
            else
                cstmt.setDate("@fec_cm"         , log_personal.getFec_cm());

            if(log_personal.getFec_cs().toString().equals(LocalDate.now().toString())) 
                cstmt.setDate("@fec_cs"         , null);
            else
                cstmt.setDate("@fec_cs"         , log_personal.getFec_cs());

            if(log_personal.getFec_ma().toString().equals(LocalDate.now().toString())) 
                cstmt.setDate("@fec_ma"         , null);
            else
                cstmt.setDate("@fec_ma"         , log_personal.getFec_ma());
                
            cstmt.execute();            
            // Auditar el proceso
            auditar(log_personal.getNro_ci()+ "",mensj);
            
            connection.commit();
            
            return true;
         }else{
            System.out.println("Error: Connexion no activa");
            throw new Exception("Error de Conexion con la BD");
         }
        }catch(Exception e){            
            connection.rollback();   
            StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
            Tools.getErrorMessage(stacktrace,"Error = " + e);    
            throw e;
        }finally{
            connection.close();
        }
    }
    /**
     * @author MITM
     * Valida si el measurename generado ya se encuentra asignado a una medida en la BD
     * @param log_PersonalCi valor a ser chequeado en la BD
     * @return true si el measure esta en uso, false si esta disponible la medida
     * @throws java.sql.SQLException
     */
    public boolean check_log_Personal(String log_PersonalCi) throws SQLException {
        try{
            BdInterface bd = ConnBdType.open(ConnBdType.SqlServer);
            connection = bd.open();
        
            StringBuilder sqlProc = new StringBuilder();
            sqlProc.append("{call sp_get_log_personal_check(?,?)}");
            if (connection != null){
               CallableStatement cstmt = connection.prepareCall(sqlProc.toString());                           
               cstmt.setString("@log_Personal", log_PersonalCi);
               cstmt.registerOutParameter("result", java.sql.Types.INTEGER);               
               cstmt.execute();
               if(cstmt.getInt("result") == 1) return true;               
            }else{
                System.out.println("Error: Connexion no activa");
            }
        }catch(SQLException e){            
            StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
            Tools.getErrorMessage(stacktrace,"Error = " + e); 
        }finally{
            connection.close();
        }
        return false;
    }
    /**
     * @author MITM
     * @param log_personal
     * @return 
     * @throws java.lang.Exception 
     */
    public boolean change_log_Personal(log_Personal log_personal) throws Exception {
        BdInterface bd = ConnBdType.open(ConnBdType.SqlServer);
        connection = bd.open();
        
        try{
         if (connection != null){
            //Inicia Transaccion 
            connection.setAutoCommit(false);
            
            StringBuilder sqlProc = new StringBuilder();
            sqlProc.append("{call sp_upd_log_personal_status(?,?)}");
            CallableStatement cstmt = connection.prepareCall(sqlProc.toString());                 
            cstmt.setString("@nro_ci", log_personal.getNro_ci());
            int value = 0;
            if(log_personal.getStatus() == 0){
                value = 1;
            }            
            cstmt.setInt("@status", value );
            cstmt.execute();            
            // Auditar el proceso
            auditar(log_personal.getIdPersonal()+ "","deletelog_Personal:");
            
            connection.commit();
            
            return true;
         }else{
            System.out.println("Error: Connexion no activa");
            throw new Exception("Error de Conexion con la BD");
         }
        }catch(Exception e){            
            connection.rollback();            
            StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
            Tools.getErrorMessage(stacktrace,"Error = " + e);    
            throw e;
        }finally{
            connection.close();
        }
    }
    /**
     * @author MITM
     * @param param1
     * @param param2
     * @return 
     * @throws java.sql.SQLException 
     */
    public log_Personal[] print_log_Personal(String param1, String param2) throws SQLException {
        try{
            BdInterface bd = ConnBdType.open(ConnBdType.SqlServer);
            connection = bd.open();
        
            StringBuilder sqlProc = new StringBuilder();
            sqlProc.append("{call sp_get_log_personal_print(?,?)}");
            
            if (connection != null){
               CallableStatement cstmt = connection.prepareCall(sqlProc.toString());
               cstmt.setString("@param1"  , param1 );
               cstmt.setString("@param2"  , param2 );
               ResultSet result = cstmt.executeQuery();            
               Vector<log_Personal> vector = new Vector<>();
               
               while(result.next()) {
                   log_Personal log_personal = new log_Personal(result);
                   vector.add(log_personal);
               }
               
               log_Personal[] log_personal = new log_Personal[vector.size()];
               for (int i = 0; i < vector.size(); i++) {
                   log_personal[i] = vector.elementAt(i);                    
               }
               
               return log_personal;
            }else{
                System.out.println("Error: Connexion no activa");
            }
        }catch(SQLException e){            
            StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
            Tools.getErrorMessage(stacktrace,"Error = " + e); 
        }finally{
            connection.close();
        }
        return null;
    }
    
   
    /***************************************************************************/
    /***************************** log_TPersonal *******************************/
    /***************************************************************************/
    
    /**
     * @author MITM
     * @return 
     * @throws java.sql.SQLException 
     */
    public log_TPersonal[] load_log_TPersonal() throws SQLException {
         try{
            BdInterface bd = ConnBdType.open(ConnBdType.SqlServer);
            connection = bd.open();
        
            StringBuilder sqlProc = new StringBuilder();
            sqlProc.append("{call sp_get_log_tpersonal_all}");
            
            if (connection != null){
               CallableStatement cstmt = connection.prepareCall(sqlProc.toString());
               ResultSet result = cstmt.executeQuery();            
               
               Vector<log_TPersonal> vector = new Vector<>();
               
               while(result.next()) {
                   log_TPersonal log_tpersonal = new log_TPersonal(result);
                   vector.add(log_tpersonal);
               }
               
               log_TPersonal[] log_tpersonal = new log_TPersonal[vector.size()];
               for (int i = 0; i < vector.size(); i++) {
                   log_tpersonal[i] = vector.elementAt(i);                    
               }
               return log_tpersonal;
            }else{
                System.out.println("Error: Connexion no activa");
            }
        }catch(SQLException e){            
            StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
            Tools.getErrorMessage(stacktrace,"Error = " + e); 
        }finally{
            connection.close();
        }
        return null;
    }
    /**
     * @author MITM
     * @param find
     * @return 
     * @throws java.sql.SQLException 
     */
    public log_TPersonal[] find_log_TPersonal(String find) throws SQLException {
        try{
            BdInterface bd = ConnBdType.open(ConnBdType.SqlServer);
            connection = bd.open();
        
            StringBuilder sqlProc = new StringBuilder();
            sqlProc.append("{call sp_get_log_tpersonal_find(?)}");
            
            if (connection != null){
               CallableStatement cstmt = connection.prepareCall(sqlProc.toString());
               cstmt.setString("@find"  , find );
               ResultSet result = cstmt.executeQuery();            
               Vector<log_TPersonal> vector = new Vector<>();
               
               while(result.next()) {
                   log_TPersonal log_tpersonal = new log_TPersonal(result);
                   vector.add(log_tpersonal);
               }
               
               log_TPersonal[] log_tpersonal = new log_TPersonal[vector.size()];
               for (int i = 0; i < vector.size(); i++) {
                   log_tpersonal[i] = vector.elementAt(i);                    
               }
               
               return log_tpersonal;
            }else{
                System.out.println("Error: Connexion no activa");
            }
        }catch(SQLException e){            
            StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
            Tools.getErrorMessage(stacktrace,"Error = " + e); 
        }finally{
            connection.close();
        }
        return null;
    }
    /**
     * @author MITM
     * @param operacion Determina el Proceso que se va a ejecutar 1 INSERT, 2 UPDATE
     * @param log_tpersonal
     * @return
     * @throws SQLException
     * @throws Exception 
     */
    public boolean save_log_TPersonal(int operacion, log_TPersonal log_tpersonal) throws SQLException, Exception {
        
        BdInterface bd = ConnBdType.open(ConnBdType.SqlServer);
        connection = bd.open();        
        try{
         if (connection != null){
            //Inicia Transaccion 
            connection.setAutoCommit(false);
            StringBuilder sql = new StringBuilder();            
            String mensj = "";
            
            switch(operacion){
                case 1:
                    sql.append("{call sp_ins_log_tpersonal(?, ?)}");
                    mensj = "Nuevo Tipo Personal:";
                    break;
                case 2:
                    sql.append("{call sp_upd_log_tpersonal_basic(?, ?, ?)}");
                    mensj = "Actualizando Tipo Personal:";
                    break;
            }
            CallableStatement cstmt = connection.prepareCall(sql.toString());
            switch(operacion){
                case 1:
                    cstmt.setString("@nombre"       , log_tpersonal.getNombre().toUpperCase());
                    cstmt.setString("@abrev"        , log_tpersonal.getAbrev().toUpperCase());
                    break;
                case 2:
                    cstmt.setInt("@grp_supplier"    , log_tpersonal.getIdTPersonal());
                    cstmt.setString("@nombre"       , log_tpersonal.getNombre().toUpperCase());
                    cstmt.setString("@abrev"        , log_tpersonal.getAbrev().toUpperCase());
                    break;
            }
            cstmt.execute();            
            // Auditar el proceso
            auditar(log_tpersonal.getIdTPersonal()+ "",mensj);
            
            connection.commit();
            
            return true;
         }else{
            System.out.println("Error: Connexion no activa");
            throw new Exception("Error de Conexion con la BD");
         }
        }catch(Exception e){            
            connection.rollback();   
            StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
            Tools.getErrorMessage(stacktrace,"Error = " + e);    
            throw e;
        }finally{
            connection.close();
        }
    }
    /**
     * @author MITM
     * Valida si el groupsuppliername generado ya se encuentra asignado a un grupo en la BD
     * @param tpersonalname valor a ser chequeado en la BD
     * @return true si el groupsupplier esta en uso, false si esta disponible el grupo
     * @throws java.sql.SQLException
     */
    public boolean check_log_TPersonal(String tpersonalname) throws SQLException {
        try{
            BdInterface bd = ConnBdType.open(ConnBdType.SqlServer);
            connection = bd.open();
        
            StringBuilder sqlProc = new StringBuilder();
            sqlProc.append("{call sp_get_log_tpersonal_check(?,?)}");
            
            if (connection != null){
               CallableStatement cstmt = connection.prepareCall(sqlProc.toString());                           
               cstmt.setString("@log_tpersonal", tpersonalname);
               cstmt.registerOutParameter("result", java.sql.Types.INTEGER);               
               cstmt.execute();
               if(cstmt.getInt("result") == 1) return true;               
            }else{
                System.out.println("Error: Connexion no activa");
            }
        }catch(SQLException e){            
            StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
            Tools.getErrorMessage(stacktrace,"Error = " + e); 
        }finally{
            connection.close();
        }
        return false;
    }
    /**
     * @author MITM
     * @param log_tpersonal
     * @return 
     * @throws java.lang.Exception 
     */
    public boolean change_log_TPersonal(log_TPersonal log_tpersonal) throws Exception {
        BdInterface bd = ConnBdType.open(ConnBdType.SqlServer);
        connection = bd.open();
        
        try{
         if (connection != null){
            //Inicia Transaccion 
            connection.setAutoCommit(false);
            
            StringBuilder sqlProc = new StringBuilder();
            sqlProc.append("{call sp_upd_log_tpersonal_status(?,?)}");
            CallableStatement cstmt = connection.prepareCall(sqlProc.toString());                 
            cstmt.setInt("@id_tpersonal", log_tpersonal.getIdTPersonal());
            int value = 0;
            if(log_tpersonal.getStatus()== 0){
                value = 1;
            }            
            cstmt.setInt("@status", value );
            cstmt.execute();            
            // Auditar el proceso
            auditar(log_tpersonal.getIdTPersonal()+ "","deletelog_tpersonal:");
            
            connection.commit();
            
            return true;
         }else{
            System.out.println("Error: Connexion no activa");
            throw new Exception("Error de Conexion con la BD");
         }
        }catch(Exception e){            
            connection.rollback();            
            StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
            Tools.getErrorMessage(stacktrace,"Error = " + e);    
            throw e;
        }finally{
            connection.close();
        }
    }


    /***************************************************************************/
    /****************************** LOG_VEHICULO *******************************/
    /***************************************************************************/
    
    /**
     * @author MITM
     * @return 
     * @throws java.sql.SQLException 
     */
    public log_Vehiculos[] load_log_Vehiculos() throws SQLException {
         try{
            BdInterface bd = ConnBdType.open(ConnBdType.SqlServer);
            connection = bd.open();
        
            StringBuilder sqlProc = new StringBuilder();
            sqlProc.append("{call sp_get_log_vehiculo_all}");
            
            if (connection != null){
               CallableStatement cstmt = connection.prepareCall(sqlProc.toString());
               ResultSet result = cstmt.executeQuery();            
               
               Vector<log_Vehiculos> vector = new Vector<>();
               
               while(result.next()) {                   
                   log_Vehiculos log_vehiculos = new log_Vehiculos(result);
                   vector.add(log_vehiculos);
               }
               
               log_Vehiculos[] log_vehiculos = new log_Vehiculos[vector.size()];
               for (int i = 0; i < vector.size(); i++) {
                   log_vehiculos[i] = vector.elementAt(i);                    
               }
               return log_vehiculos;
            }else{
                System.out.println("Error: Connexion no activa");
            }
        }catch(SQLException e){            
            StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
            Tools.getErrorMessage(stacktrace,"Error = " + e); 
        }finally{
            connection.close();
        }
        return null;
    }
    /**
     * @author MITM
     * @param find
     * @return 
     * @throws java.sql.SQLException 
     */
    public log_Vehiculos[] find_log_Vehiculos(String find) throws SQLException {
        try{
            BdInterface bd = ConnBdType.open(ConnBdType.SqlServer);
            connection = bd.open();
        
            StringBuilder sqlProc = new StringBuilder();
            sqlProc.append("{call sp_get_log_vehiculo_find(?)}");
            
            if (connection != null){
               CallableStatement cstmt = connection.prepareCall(sqlProc.toString());
               cstmt.setString("@find"  , find );
               ResultSet result = cstmt.executeQuery();            
               Vector<log_Vehiculos> vector = new Vector<>();
               
               while(result.next()) {
                   log_Vehiculos log_vehiculos = new log_Vehiculos(result);
                   vector.add(log_vehiculos);
               }
               
               log_Vehiculos[] log_vehiculos = new log_Vehiculos[vector.size()];
               for (int i = 0; i < vector.size(); i++) {
                   log_vehiculos[i] = vector.elementAt(i);                    
               }
               
               return log_vehiculos;
            }else{
                System.out.println("Error: Connexion no activa");
            }
        }catch(SQLException e){            
            StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
            Tools.getErrorMessage(stacktrace,"Error = " + e); 
        }finally{
            connection.close();
        }
        return null;
    }
    /**
     * @author MITM
     * @param operacion Determina el Proceso que se va a ejecutar 1 INSERT, 2 UPDATE
     * @param log_vehiculos
     * @return
     * @throws SQLException
     * @throws Exception 
     */
    public boolean save_log_Vehiculos(int operacion, log_Vehiculos log_vehiculos) throws SQLException, Exception {
        
        BdInterface bd = ConnBdType.open(ConnBdType.SqlServer);
        connection = bd.open();        
        try{
         if (connection != null){
            //Inicia Transaccion 
            connection.setAutoCommit(false);
            StringBuilder sql = new StringBuilder();            
            String mensj = "";
            
            switch(operacion){
                case 1:
                    sql.append("{call sp_ins_log_vehiculo_data(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}");
                    mensj = "Nuevo Vehiculo:";
                    break;
                case 2:
                    sql.append("{call sp_upd_log_vehiculo_basic(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}");
                    mensj = "Actualizando Vehiculo:";
                    break;
            }
            CallableStatement cstmt = connection.prepareCall(sql.toString());
            cstmt.setString("@nro_placa"           , log_vehiculos.getIdPlaca());
            cstmt.setInt("@tmarca"                 , log_vehiculos.getTmarca().getIdTMarca());
            cstmt.setInt("@tproced"                , log_vehiculos.getTproced().getIdTProced());
            cstmt.setInt("@ttransp"                , log_vehiculos.getTtransp().getIdTTransp());
            if (log_vehiculos.getTseguro() != null)
                cstmt.setInt("@tseguro"            , log_vehiculos.getTseguro().getIdTSeguro());
            else
                cstmt.setInt("@tseguro"            , 0);
            if (log_vehiculos.getTseguro() != null)
                cstmt.setInt("@tdispflota"         , log_vehiculos.getTdispflota().getIdTDispflota());
            else
                cstmt.setInt("@tdispflota"         , 0);
            cstmt.setString("@modelo"              , log_vehiculos.getModelo());
            cstmt.setInt("@tara"                   , log_vehiculos.getPeso_bveh());
            cstmt.setInt("@capcargakgrs"           , log_vehiculos.getCap_cargkgrs());
            cstmt.setDouble("@capcargamtrs3"       , log_vehiculos.getCap_cargmtrs3());
            cstmt.setInt("@ano"                    , log_vehiculos.getAno());
            cstmt.setInt("@clasificacion"          , log_vehiculos.getClasif());
            cstmt.setString("@telefonos"           , log_vehiculos.getTelefonos());
            cstmt.setString("@celular"             , log_vehiculos.getCelular());
            cstmt.setString("@empresa"             , log_vehiculos.getEmpresa());
            cstmt.setString("@rif_empresa"         , log_vehiculos.getRif_empresa());
            cstmt.setString("@correo"              , log_vehiculos.getCorreo());
            cstmt.setString("@ruta_cc"             , log_vehiculos.getRuta_cc());
            cstmt.setString("@ruta_tt"             , log_vehiculos.getRuta_tt());
            cstmt.setString("@ruta_rcv"            , log_vehiculos.getRuta_rcv());
            cstmt.setString("@ruta_ps"             , log_vehiculos.getRuta_ps());
            cstmt.setString("@ruta_rgt"            , log_vehiculos.getRuta_rgt());
            cstmt.setDate("@fec_rcv"               , log_vehiculos.getFec_rcv());
            cstmt.setDate("@fec_ps"                , log_vehiculos.getFec_ps());
            cstmt.setDate("@fec_rgt"               , log_vehiculos.getFec_rgt());
            cstmt.setString("@nro_rgt"             , log_vehiculos.getNro_rgt());
                
            cstmt.execute();            
            // Auditar el proceso
            auditar(log_vehiculos.getIdPlaca()+ "",mensj);
            
            connection.commit();
            
            return true;
         }else{
            System.out.println("Error: Connexion no activa");
            throw new Exception("Error de Conexion con la BD");
         }
        }catch(Exception e){            
            connection.rollback();   
            StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
            Tools.getErrorMessage(stacktrace,"Error = " + e);    
            throw e;
        }finally{
            connection.close();
        }
    }
    /**
     * @author MITM
     * Valida si el measurename generado ya se encuentra asignado a una medida en la BD
     * @param NroPlaca valor a ser chequeado en la BD
     * @return true si el measure esta en uso, false si esta disponible la medida
     * @throws java.sql.SQLException
     */
    public boolean check_log_Vehiculos(String NroPlaca) throws SQLException {
        try{
            BdInterface bd = ConnBdType.open(ConnBdType.SqlServer);
            connection = bd.open();
        
            StringBuilder sqlProc = new StringBuilder();
            sqlProc.append("{call sp_get_log_vehiculo_check(?,?)}");
            if (connection != null){
               CallableStatement cstmt = connection.prepareCall(sqlProc.toString());                           
               cstmt.setString("@log_vehiculo", NroPlaca);
               cstmt.registerOutParameter("result", java.sql.Types.INTEGER);               
               cstmt.execute();
               if(cstmt.getInt("result") == 1) return true;               
            }else{
                System.out.println("Error: Connexion no activa");
            }
        }catch(SQLException e){            
            StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
            Tools.getErrorMessage(stacktrace,"Error = " + e); 
        }finally{
            connection.close();
        }
        return false;
    }
    /**
     * @author MITM
     * @param log_vehiculos
     * @return 
     * @throws java.lang.Exception 
     */
    public boolean change_log_Vehiculos(log_Vehiculos log_vehiculos) throws Exception {
        BdInterface bd = ConnBdType.open(ConnBdType.SqlServer);
        connection = bd.open();
        
        try{
         if (connection != null){
            //Inicia Transaccion 
            connection.setAutoCommit(false);
            
            StringBuilder sqlProc = new StringBuilder();
            sqlProc.append("{call sp_upd_log_vehiculo_status(?,?)}");
            CallableStatement cstmt = connection.prepareCall(sqlProc.toString());                 
            cstmt.setString("@nro_placa", log_vehiculos.getIdPlaca());
            int value = 0;
            if(log_vehiculos.getStatus() == 0){
                value = 1;
            }            
            cstmt.setInt("@status", value );
            cstmt.execute();            
            // Auditar el proceso
            auditar(log_vehiculos.getIdPlaca()+ "","deletelog_vehiculos:");
            
            connection.commit();
            
            return true;
         }else{
            System.out.println("Error: Connexion no activa");
            throw new Exception("Error de Conexion con la BD");
         }
        }catch(Exception e){            
            connection.rollback();            
            StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
            Tools.getErrorMessage(stacktrace,"Error = " + e);    
            throw e;
        }finally{
            connection.close();
        }
    }
    /**
     * @author MITM
     * @param param1
     * @param param2
     * @return 
     * @throws java.sql.SQLException 
     */
    public log_Vehiculos[] print_log_Vehiculos(String param1, String param2) throws SQLException {
        try{
            BdInterface bd = ConnBdType.open(ConnBdType.SqlServer);
            connection = bd.open();
        
            StringBuilder sqlProc = new StringBuilder();
            sqlProc.append("{call sp_get_log_vehiculo_print(?,?)}");
            
            if (connection != null){
               CallableStatement cstmt = connection.prepareCall(sqlProc.toString());
               cstmt.setString("@param1"  , param1 );
               cstmt.setString("@param2"  , param2 );
               ResultSet result = cstmt.executeQuery();            
               Vector<log_Vehiculos> vector = new Vector<>();
               
               while(result.next()) {
                   log_Vehiculos log_vehiculos = new log_Vehiculos(result);
                   vector.add(log_vehiculos);
               }
               
               log_Vehiculos[] log_vehiculos = new log_Vehiculos[vector.size()];
               for (int i = 0; i < vector.size(); i++) {
                   log_vehiculos[i] = vector.elementAt(i);                    
               }
               
               return log_vehiculos;
            }else{
                System.out.println("Error: Connexion no activa");
            }
        }catch(SQLException e){            
            StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
            Tools.getErrorMessage(stacktrace,"Error = " + e); 
        }finally{
            connection.close();
        }
        return null;
    }
    
   
    /***************************************************************************/
    /****************************** log_TMarca *********************************/
    /***************************************************************************/
    
    /**
     * @author MITM
     * @return 
     * @throws java.sql.SQLException 
     */
    public log_TMarca[] load_log_TMarca() throws SQLException {
         try{
            BdInterface bd = ConnBdType.open(ConnBdType.SqlServer);
            connection = bd.open();
        
            StringBuilder sqlProc = new StringBuilder();
            sqlProc.append("{call sp_get_log_tmarca_all}");
            
            if (connection != null){
               CallableStatement cstmt = connection.prepareCall(sqlProc.toString());
               ResultSet result = cstmt.executeQuery();            
               
               Vector<log_TMarca> vector = new Vector<>();
               
               while(result.next()) {
                   log_TMarca log_tmarca = new log_TMarca(result);
                   vector.add(log_tmarca);
               }
               
               log_TMarca[] log_tmarca = new log_TMarca[vector.size()];
               for (int i = 0; i < vector.size(); i++) {
                   log_tmarca[i] = vector.elementAt(i);                    
               }
               return log_tmarca;
            }else{
                System.out.println("Error: Connexion no activa");
            }
        }catch(SQLException e){            
            StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
            Tools.getErrorMessage(stacktrace,"Error = " + e); 
        }finally{
            connection.close();
        }
        return null;
    }
    /**
     * @author MITM
     * @param find
     * @return 
     * @throws java.sql.SQLException 
     */
    public log_TMarca[] find_log_TMarca(String find) throws SQLException {
        try{
            BdInterface bd = ConnBdType.open(ConnBdType.SqlServer);
            connection = bd.open();
        
            StringBuilder sqlProc = new StringBuilder();
            sqlProc.append("{call sp_get_log_tmarca_find(?)}");
            
            if (connection != null){
               CallableStatement cstmt = connection.prepareCall(sqlProc.toString());
               cstmt.setString("@find"  , find );
               ResultSet result = cstmt.executeQuery();            
               Vector<log_TMarca> vector = new Vector<>();
               
               while(result.next()) {
                   log_TMarca log_tmarca = new log_TMarca(result);
                   vector.add(log_tmarca);
               }
               
               log_TMarca[] log_tmarca = new log_TMarca[vector.size()];
               for (int i = 0; i < vector.size(); i++) {
                   log_tmarca[i] = vector.elementAt(i);                    
               }
               
               return log_tmarca;
            }else{
                System.out.println("Error: Connexion no activa");
            }
        }catch(SQLException e){            
            StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
            Tools.getErrorMessage(stacktrace,"Error = " + e); 
        }finally{
            connection.close();
        }
        return null;
    }
    /**
     * @author MITM
     * @param operacion Determina el Proceso que se va a ejecutar 1 INSERT, 2 UPDATE
     * @param log_tmarca
     * @return
     * @throws SQLException
     * @throws Exception 
     */
    public boolean save_log_TMarca(int operacion, log_TMarca log_tmarca) throws SQLException, Exception {
        
        BdInterface bd = ConnBdType.open(ConnBdType.SqlServer);
        connection = bd.open();        
        try{
         if (connection != null){
            //Inicia Transaccion 
            connection.setAutoCommit(false);
            StringBuilder sql = new StringBuilder();            
            String mensj = "";
            
            switch(operacion){
                case 1:
                    sql.append("{call sp_ins_log_tmarca(?, ?)}");
                    mensj = "Nuevo Tipo Marca:";
                    break;
                case 2:
                    sql.append("{call sp_upd_log_tmarca_basic(?, ?, ?)}");
                    mensj = "Actualizando Tipo Marca:";
                    break;
            }
            CallableStatement cstmt = connection.prepareCall(sql.toString());
            switch(operacion){
                case 1:
                    cstmt.setString("@nombre"       , log_tmarca.getNombre().toUpperCase());
                    cstmt.setString("@abrev"        , log_tmarca.getAbrev().toUpperCase());
                    break;
                case 2:
                    cstmt.setInt("@id_tmarca"       , log_tmarca.getIdTMarca());
                    cstmt.setString("@nombre"       , log_tmarca.getNombre().toUpperCase());
                    cstmt.setString("@abrev"        , log_tmarca.getAbrev().toUpperCase());
                    break;
            }
            cstmt.execute();            
            // Auditar el proceso
            auditar(log_tmarca.getIdTMarca()+ "",mensj);
            
            connection.commit();
            
            return true;
         }else{
            System.out.println("Error: Connexion no activa");
            throw new Exception("Error de Conexion con la BD");
         }
        }catch(Exception e){            
            connection.rollback();   
            StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
            Tools.getErrorMessage(stacktrace,"Error = " + e);    
            throw e;
        }finally{
            connection.close();
        }
    }
    /**
     * @author MITM
     * Valida si el groupsuppliername generado ya se encuentra asignado a un grupo en la BD
     * @param tmarcaname valor a ser chequeado en la BD
     * @return true si el groupsupplier esta en uso, false si esta disponible el grupo
     * @throws java.sql.SQLException
     */
    public boolean check_log_TMarca(String tmarcaname) throws SQLException {
        try{
            BdInterface bd = ConnBdType.open(ConnBdType.SqlServer);
            connection = bd.open();
        
            StringBuilder sqlProc = new StringBuilder();
            sqlProc.append("{call sp_get_log_tmarca_check(?,?)}");
            
            if (connection != null){
               CallableStatement cstmt = connection.prepareCall(sqlProc.toString());                           
               cstmt.setString("@log_tmarca", tmarcaname);
               cstmt.registerOutParameter("result", java.sql.Types.INTEGER);               
               cstmt.execute();
               if(cstmt.getInt("result") == 1) return true;               
            }else{
                System.out.println("Error: Connexion no activa");
            }
        }catch(SQLException e){            
            StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
            Tools.getErrorMessage(stacktrace,"Error = " + e); 
        }finally{
            connection.close();
        }
        return false;
    }
    /**
     * @author MITM
     * @param log_tmarca
     * @return 
     * @throws java.lang.Exception 
     */
    public boolean change_log_TMarca(log_TMarca log_tmarca) throws Exception {
        BdInterface bd = ConnBdType.open(ConnBdType.SqlServer);
        connection = bd.open();
        
        try{
         if (connection != null){
            //Inicia Transaccion 
            connection.setAutoCommit(false);
            
            StringBuilder sqlProc = new StringBuilder();
            sqlProc.append("{call sp_upd_log_tmarca_status(?,?)}");
            CallableStatement cstmt = connection.prepareCall(sqlProc.toString());                 
            cstmt.setInt("@id_tmarca", log_tmarca.getIdTMarca());
            int value = 0;
            if(log_tmarca.getStatus()== 0){
                value = 1;
            }            
            cstmt.setInt("@status", value );
            cstmt.execute();            
            // Auditar el proceso
            auditar(log_tmarca.getIdTMarca()+ "","deletelog_tmarca:");
            
            connection.commit();
            
            return true;
         }else{
            System.out.println("Error: Connexion no activa");
            throw new Exception("Error de Conexion con la BD");
         }
        }catch(Exception e){            
            connection.rollback();            
            StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
            Tools.getErrorMessage(stacktrace,"Error = " + e);    
            throw e;
        }finally{
            connection.close();
        }
    }


    /***************************************************************************/
    /****************************** log_TProced ********************************/
    /***************************************************************************/
    
    /**
     * @author MITM
     * @return 
     * @throws java.sql.SQLException 
     */
    public log_TProced[] load_log_TProced() throws SQLException {
         try{
            BdInterface bd = ConnBdType.open(ConnBdType.SqlServer);
            connection = bd.open();
        
            StringBuilder sqlProc = new StringBuilder();
            sqlProc.append("{call sp_get_log_tproced_all}");
            
            if (connection != null){
               CallableStatement cstmt = connection.prepareCall(sqlProc.toString());
               ResultSet result = cstmt.executeQuery();            
               
               Vector<log_TProced> vector = new Vector<>();
               
               while(result.next()) {
                   log_TProced log_tproced = new log_TProced(result);
                   vector.add(log_tproced);
               }
               
               log_TProced[] log_tproced = new log_TProced[vector.size()];
               for (int i = 0; i < vector.size(); i++) {
                   log_tproced[i] = vector.elementAt(i);                    
               }
               return log_tproced;
            }else{
                System.out.println("Error: Connexion no activa");
            }
        }catch(SQLException e){            
            StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
            Tools.getErrorMessage(stacktrace,"Error = " + e); 
        }finally{
            connection.close();
        }
        return null;
    }
    /**
     * @author MITM
     * @param find
     * @return 
     * @throws java.sql.SQLException 
     */
    public log_TProced[] find_log_TProced(String find) throws SQLException {
        try{
            BdInterface bd = ConnBdType.open(ConnBdType.SqlServer);
            connection = bd.open();
        
            StringBuilder sqlProc = new StringBuilder();
            sqlProc.append("{call sp_get_log_tproced_find(?)}");
            
            if (connection != null){
               CallableStatement cstmt = connection.prepareCall(sqlProc.toString());
               cstmt.setString("@find"  , find );
               ResultSet result = cstmt.executeQuery();            
               Vector<log_TProced> vector = new Vector<>();
               
               while(result.next()) {
                   log_TProced log_tproced = new log_TProced(result);
                   vector.add(log_tproced);
               }
               
               log_TProced[] log_tproced = new log_TProced[vector.size()];
               for (int i = 0; i < vector.size(); i++) {
                   log_tproced[i] = vector.elementAt(i);                    
               }
               
               return log_tproced;
            }else{
                System.out.println("Error: Connexion no activa");
            }
        }catch(SQLException e){            
            StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
            Tools.getErrorMessage(stacktrace,"Error = " + e); 
        }finally{
            connection.close();
        }
        return null;
    }
    /**
     * @author MITM
     * @param operacion Determina el Proceso que se va a ejecutar 1 INSERT, 2 UPDATE
     * @param log_tproced
     * @return
     * @throws SQLException
     * @throws Exception 
     */
    public boolean save_log_TProced(int operacion, log_TProced log_tproced) throws SQLException, Exception {
        
        BdInterface bd = ConnBdType.open(ConnBdType.SqlServer);
        connection = bd.open();        
        try{
         if (connection != null){
            //Inicia Transaccion 
            connection.setAutoCommit(false);
            StringBuilder sql = new StringBuilder();            
            String mensj = "";
            
            switch(operacion){
                case 1:
                    sql.append("{call sp_ins_log_tproced(?, ?)}");
                    mensj = "Nuevo Tipo Proced:";
                    break;
                case 2:
                    sql.append("{call sp_upd_log_tproced_basic(?, ?, ?)}");
                    mensj = "Actualizando Tipo Proced:";
                    break;
            }
            CallableStatement cstmt = connection.prepareCall(sql.toString());
            switch(operacion){
                case 1:
                    cstmt.setString("@nombre"       , log_tproced.getNombre().toUpperCase());
                    cstmt.setString("@abrev"        , log_tproced.getAbrev().toUpperCase());
                    break;
                case 2:
                    cstmt.setInt("@id_tproced"       , log_tproced.getIdTProced());
                    cstmt.setString("@nombre"       , log_tproced.getNombre().toUpperCase());
                    cstmt.setString("@abrev"        , log_tproced.getAbrev().toUpperCase());
                    break;
            }
            cstmt.execute();            
            // Auditar el proceso
            auditar(log_tproced.getIdTProced()+ "",mensj);
            
            connection.commit();
            
            return true;
         }else{
            System.out.println("Error: Connexion no activa");
            throw new Exception("Error de Conexion con la BD");
         }
        }catch(Exception e){            
            connection.rollback();   
            StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
            Tools.getErrorMessage(stacktrace,"Error = " + e);    
            throw e;
        }finally{
            connection.close();
        }
    }
    /**
     * @author MITM
     * Valida si el groupsuppliername generado ya se encuentra asignado a un grupo en la BD
     * @param tprocedname valor a ser chequeado en la BD
     * @return true si el groupsupplier esta en uso, false si esta disponible el grupo
     * @throws java.sql.SQLException
     */
    public boolean check_log_TProced(String tprocedname) throws SQLException {
        try{
            BdInterface bd = ConnBdType.open(ConnBdType.SqlServer);
            connection = bd.open();
        
            StringBuilder sqlProc = new StringBuilder();
            sqlProc.append("{call sp_get_log_tproced_check(?,?)}");
            
            if (connection != null){
               CallableStatement cstmt = connection.prepareCall(sqlProc.toString());                           
               cstmt.setString("@log_tproced", tprocedname);
               cstmt.registerOutParameter("result", java.sql.Types.INTEGER);               
               cstmt.execute();
               if(cstmt.getInt("result") == 1) return true;               
            }else{
                System.out.println("Error: Connexion no activa");
            }
        }catch(SQLException e){            
            StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
            Tools.getErrorMessage(stacktrace,"Error = " + e); 
        }finally{
            connection.close();
        }
        return false;
    }
    /**
     * @author MITM
     * @param log_tproced
     * @return 
     * @throws java.lang.Exception 
     */
    public boolean change_log_TProced(log_TProced log_tproced) throws Exception {
        BdInterface bd = ConnBdType.open(ConnBdType.SqlServer);
        connection = bd.open();
        
        try{
         if (connection != null){
            //Inicia Transaccion 
            connection.setAutoCommit(false);
            
            StringBuilder sqlProc = new StringBuilder();
            sqlProc.append("{call sp_upd_log_tproced_status(?,?)}");
            CallableStatement cstmt = connection.prepareCall(sqlProc.toString());                 
            cstmt.setInt("@id_tproced", log_tproced.getIdTProced());
            int value = 0;
            if(log_tproced.getStatus()== 0){
                value = 1;
            }            
            cstmt.setInt("@status", value );
            cstmt.execute();            
            // Auditar el proceso
            auditar(log_tproced.getIdTProced()+ "","deletelog_tproced:");
            
            connection.commit();
            
            return true;
         }else{
            System.out.println("Error: Connexion no activa");
            throw new Exception("Error de Conexion con la BD");
         }
        }catch(Exception e){            
            connection.rollback();            
            StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
            Tools.getErrorMessage(stacktrace,"Error = " + e);    
            throw e;
        }finally{
            connection.close();
        }
    }


    /***************************************************************************/
    /****************************** log_TTransp ********************************/
    /***************************************************************************/
    
    /**
     * @author MITM
     * @return 
     * @throws java.sql.SQLException 
     */
    public log_TTransp[] load_log_TTransp() throws SQLException {
         try{
            BdInterface bd = ConnBdType.open(ConnBdType.SqlServer);
            connection = bd.open();
        
            StringBuilder sqlProc = new StringBuilder();
            sqlProc.append("{call sp_get_log_ttransp_all}");
            
            if (connection != null){
               CallableStatement cstmt = connection.prepareCall(sqlProc.toString());
               ResultSet result = cstmt.executeQuery();            
               
               Vector<log_TTransp> vector = new Vector<>();
               
               while(result.next()) {
                   log_TTransp log_ttransp = new log_TTransp(result);
                   vector.add(log_ttransp);
               }
               
               log_TTransp[] log_ttransp = new log_TTransp[vector.size()];
               for (int i = 0; i < vector.size(); i++) {
                   log_ttransp[i] = vector.elementAt(i);                    
               }
               return log_ttransp;
            }else{
                System.out.println("Error: Connexion no activa");
            }
        }catch(SQLException e){            
            StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
            Tools.getErrorMessage(stacktrace,"Error = " + e); 
        }finally{
            connection.close();
        }
        return null;
    }
    /**
     * @author MITM
     * @param find
     * @return 
     * @throws java.sql.SQLException 
     */
    public log_TTransp[] find_log_TTransp(String find) throws SQLException {
        try{
            BdInterface bd = ConnBdType.open(ConnBdType.SqlServer);
            connection = bd.open();
        
            StringBuilder sqlProc = new StringBuilder();
            sqlProc.append("{call sp_get_log_ttransp_find(?)}");
            
            if (connection != null){
               CallableStatement cstmt = connection.prepareCall(sqlProc.toString());
               cstmt.setString("@find"  , find );
               ResultSet result = cstmt.executeQuery();            
               Vector<log_TTransp> vector = new Vector<>();
               
               while(result.next()) {
                   log_TTransp log_ttransp = new log_TTransp(result);
                   vector.add(log_ttransp);
               }
               
               log_TTransp[] log_ttransp = new log_TTransp[vector.size()];
               for (int i = 0; i < vector.size(); i++) {
                   log_ttransp[i] = vector.elementAt(i);                    
               }
               
               return log_ttransp;
            }else{
                System.out.println("Error: Connexion no activa");
            }
        }catch(SQLException e){            
            StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
            Tools.getErrorMessage(stacktrace,"Error = " + e); 
        }finally{
            connection.close();
        }
        return null;
    }
    /**
     * @author MITM
     * @param operacion Determina el Proceso que se va a ejecutar 1 INSERT, 2 UPDATE
     * @param log_ttransp
     * @return
     * @throws SQLException
     * @throws Exception 
     */
    public boolean save_log_TTransp(int operacion, log_TTransp log_ttransp) throws SQLException, Exception {
        
        BdInterface bd = ConnBdType.open(ConnBdType.SqlServer);
        connection = bd.open();        
        try{
         if (connection != null){
            //Inicia Transaccion 
            connection.setAutoCommit(false);
            StringBuilder sql = new StringBuilder();            
            String mensj = "";
            
            switch(operacion){
                case 1:
                    sql.append("{call sp_ins_log_ttransp(?, ?)}");
                    mensj = "Nuevo Tipo Transp:";
                    break;
                case 2:
                    sql.append("{call sp_upd_log_ttransp_basic(?, ?, ?)}");
                    mensj = "Actualizando Tipo Transp:";
                    break;
            }
            CallableStatement cstmt = connection.prepareCall(sql.toString());
            switch(operacion){
                case 1:
                    cstmt.setString("@nombre"       , log_ttransp.getNombre().toUpperCase());
                    cstmt.setString("@abrev"        , log_ttransp.getAbrev().toUpperCase());
                    break;
                case 2:
                    cstmt.setInt("@id_ttransp"       , log_ttransp.getIdTTransp());
                    cstmt.setString("@nombre"        , log_ttransp.getNombre().toUpperCase());
                    cstmt.setString("@abrev"         , log_ttransp.getAbrev().toUpperCase());
                    break;
            }
            cstmt.execute();            
            // Auditar el proceso
            auditar(log_ttransp.getIdTTransp()+ "",mensj);
            
            connection.commit();
            
            return true;
         }else{
            System.out.println("Error: Connexion no activa");
            throw new Exception("Error de Conexion con la BD");
         }
        }catch(Exception e){            
            connection.rollback();   
            StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
            Tools.getErrorMessage(stacktrace,"Error = " + e);    
            throw e;
        }finally{
            connection.close();
        }
    }
    /**
     * @author MITM
     * Valida si el groupsuppliername generado ya se encuentra asignado a un grupo en la BD
     * @param ttranspname valor a ser chequeado en la BD
     * @return true si el groupsupplier esta en uso, false si esta disponible el grupo
     * @throws java.sql.SQLException
     */
    public boolean check_log_TTransp(String ttranspname) throws SQLException {
        try{
            BdInterface bd = ConnBdType.open(ConnBdType.SqlServer);
            connection = bd.open();
        
            StringBuilder sqlProc = new StringBuilder();
            sqlProc.append("{call sp_get_log_ttransp_check(?,?)}");
            
            if (connection != null){
               CallableStatement cstmt = connection.prepareCall(sqlProc.toString());                           
               cstmt.setString("@log_ttransp", ttranspname);
               cstmt.registerOutParameter("result", java.sql.Types.INTEGER);               
               cstmt.execute();
               if(cstmt.getInt("result") == 1) return true;               
            }else{
                System.out.println("Error: Connexion no activa");
            }
        }catch(SQLException e){            
            StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
            Tools.getErrorMessage(stacktrace,"Error = " + e); 
        }finally{
            connection.close();
        }
        return false;
    }
    /**
     * @author MITM
     * @param log_ttransp
     * @return 
     * @throws java.lang.Exception 
     */
    public boolean change_log_TTransp(log_TTransp log_ttransp) throws Exception {
        BdInterface bd = ConnBdType.open(ConnBdType.SqlServer);
        connection = bd.open();
        
        try{
         if (connection != null){
            //Inicia Transaccion 
            connection.setAutoCommit(false);
            
            StringBuilder sqlProc = new StringBuilder();
            sqlProc.append("{call sp_upd_log_ttransp_status(?,?)}");
            CallableStatement cstmt = connection.prepareCall(sqlProc.toString());                 
            cstmt.setInt("@id_tproced", log_ttransp.getIdTTransp());
            int value = 0;
            if(log_ttransp.getStatus()== 0){
                value = 1;
            }            
            cstmt.setInt("@status", value );
            cstmt.execute();            
            // Auditar el proceso
            auditar(log_ttransp.getIdTTransp()+ "","deletelog_ttransp:");
            
            connection.commit();
            
            return true;
         }else{
            System.out.println("Error: Connexion no activa");
            throw new Exception("Error de Conexion con la BD");
         }
        }catch(Exception e){            
            connection.rollback();            
            StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
            Tools.getErrorMessage(stacktrace,"Error = " + e);    
            throw e;
        }finally{
            connection.close();
        }
    }


    /***************************************************************************/
    /****************************** log_TSeguros *******************************/
    /***************************************************************************/
    
    /**
     * @author MITM
     * @return 
     * @throws java.sql.SQLException 
     */
    public log_TSeguros[] load_log_TSeguros() throws SQLException {
         try{
            BdInterface bd = ConnBdType.open(ConnBdType.SqlServer);
            connection = bd.open();
        
            StringBuilder sqlProc = new StringBuilder();
            sqlProc.append("{call sp_get_log_tseguro_all}");
            
            if (connection != null){
               CallableStatement cstmt = connection.prepareCall(sqlProc.toString());
               ResultSet result = cstmt.executeQuery();            
               
               Vector<log_TSeguros> vector = new Vector<>();
               
               while(result.next()) {
                   log_TSeguros log_tseguros = new log_TSeguros(result);
                   vector.add(log_tseguros);
               }
               
               log_TSeguros[] log_tseguros = new log_TSeguros[vector.size()];
               for (int i = 0; i < vector.size(); i++) {
                   log_tseguros[i] = vector.elementAt(i);                    
               }
               return log_tseguros;
            }else{
                System.out.println("Error: Connexion no activa");
            }
        }catch(SQLException e){            
            StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
            Tools.getErrorMessage(stacktrace,"Error = " + e); 
        }finally{
            connection.close();
        }
        return null;
    }
    /**
     * @author MITM
     * @param find
     * @return 
     * @throws java.sql.SQLException 
     */
    public log_TSeguros[] find_log_TSeguros(String find) throws SQLException {
        try{
            BdInterface bd = ConnBdType.open(ConnBdType.SqlServer);
            connection = bd.open();
        
            StringBuilder sqlProc = new StringBuilder();
            sqlProc.append("{call sp_get_log_tseguro_find(?)}");
            
            if (connection != null){
               CallableStatement cstmt = connection.prepareCall(sqlProc.toString());
               cstmt.setString("@find"  , find );
               ResultSet result = cstmt.executeQuery();            
               Vector<log_TSeguros> vector = new Vector<>();
               
               while(result.next()) {
                   log_TSeguros log_tseguros = new log_TSeguros(result);
                   vector.add(log_tseguros);
               }
               
               log_TSeguros[] log_tseguros = new log_TSeguros[vector.size()];
               for (int i = 0; i < vector.size(); i++) {
                   log_tseguros[i] = vector.elementAt(i);                    
               }
               
               return log_tseguros;
            }else{
                System.out.println("Error: Connexion no activa");
            }
        }catch(SQLException e){            
            StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
            Tools.getErrorMessage(stacktrace,"Error = " + e); 
        }finally{
            connection.close();
        }
        return null;
    }
    /**
     * @author MITM
     * @param operacion Determina el Proceso que se va a ejecutar 1 INSERT, 2 UPDATE
     * @param log_tseguros
     * @return
     * @throws SQLException
     * @throws Exception 
     */
    public boolean save_log_TSeguros(int operacion, log_TSeguros log_tseguros) throws SQLException, Exception {
        
        BdInterface bd = ConnBdType.open(ConnBdType.SqlServer);
        connection = bd.open();        
        try{
         if (connection != null){
            //Inicia Transaccion 
            connection.setAutoCommit(false);
            StringBuilder sql = new StringBuilder();            
            String mensj = "";
            
            switch(operacion){
                case 1:
                    sql.append("{call sp_ins_log_tseguro(?, ?)}");
                    mensj = "Nuevo Tipo Seguro:";
                    break;
                case 2:
                    sql.append("{call sp_upd_log_tseguro_basic(?, ?, ?)}");
                    mensj = "Actualizando Tipo Seguro:";
                    break;
            }
            CallableStatement cstmt = connection.prepareCall(sql.toString());
            switch(operacion){
                case 1:
                    cstmt.setString("@nombre"       , log_tseguros.getNombre().toUpperCase());
                    cstmt.setString("@abrev"        , log_tseguros.getAbrev().toUpperCase());
                    break;
                case 2:
                    cstmt.setInt("@id_tseguro"       , log_tseguros.getIdTSeguro());
                    cstmt.setString("@nombre"        , log_tseguros.getNombre().toUpperCase());
                    cstmt.setString("@abrev"         , log_tseguros.getAbrev().toUpperCase());
                    break;
            }
            cstmt.execute();            
            // Auditar el proceso
            auditar(log_tseguros.getIdTSeguro()+ "",mensj);
            
            connection.commit();
            
            return true;
         }else{
            System.out.println("Error: Connexion no activa");
            throw new Exception("Error de Conexion con la BD");
         }
        }catch(Exception e){            
            connection.rollback();   
            StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
            Tools.getErrorMessage(stacktrace,"Error = " + e);    
            throw e;
        }finally{
            connection.close();
        }
    }
    /**
     * @author MITM
     * Valida si el groupsuppliername generado ya se encuentra asignado a un grupo en la BD
     * @param log_tsegurosname valor a ser chequeado en la BD
     * @return true si el groupsupplier esta en uso, false si esta disponible el grupo
     * @throws java.sql.SQLException
     */
    public boolean check_log_TSeguros(String log_tsegurosname) throws SQLException {
        try{
            BdInterface bd = ConnBdType.open(ConnBdType.SqlServer);
            connection = bd.open();
        
            StringBuilder sqlProc = new StringBuilder();
            sqlProc.append("{call sp_get_log_tseguro_check(?,?)}");
            
            if (connection != null){
               CallableStatement cstmt = connection.prepareCall(sqlProc.toString());                           
               cstmt.setString("@log_tseguro", log_tsegurosname);
               cstmt.registerOutParameter("result", java.sql.Types.INTEGER);               
               cstmt.execute();
               if(cstmt.getInt("result") == 1) return true;               
            }else{
                System.out.println("Error: Connexion no activa");
            }
        }catch(SQLException e){            
            StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
            Tools.getErrorMessage(stacktrace,"Error = " + e); 
        }finally{
            connection.close();
        }
        return false;
    }
    /**
     * @author MITM
     * @param log_tseguros
     * @return 
     * @throws java.lang.Exception 
     */
    public boolean change_log_TSeguros(log_TSeguros log_tseguros) throws Exception {
        BdInterface bd = ConnBdType.open(ConnBdType.SqlServer);
        connection = bd.open();
        
        try{
         if (connection != null){
            //Inicia Transaccion 
            connection.setAutoCommit(false);
            
            StringBuilder sqlProc = new StringBuilder();
            sqlProc.append("{call sp_upd_log_ttransp_status(?,?)}");
            CallableStatement cstmt = connection.prepareCall(sqlProc.toString());                 
            cstmt.setInt("@id_tproced", log_tseguros.getIdTSeguro());
            int value = 0;
            if(log_tseguros.getStatus()== 0){
                value = 1;
            }            
            cstmt.setInt("@status", value );
            cstmt.execute();            
            // Auditar el proceso
            auditar(log_tseguros.getIdTSeguro()+ "","deletelog_tseguros:");
            
            connection.commit();
            
            return true;
         }else{
            System.out.println("Error: Connexion no activa");
            throw new Exception("Error de Conexion con la BD");
         }
        }catch(Exception e){            
            connection.rollback();            
            StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
            Tools.getErrorMessage(stacktrace,"Error = " + e);    
            throw e;
        }finally{
            connection.close();
        }
    }


    /***************************************************************************/
    /**************************** log_TDispflota *******************************/
    /***************************************************************************/
    
    /**
     * @author MITM
     * @return 
     * @throws java.sql.SQLException 
     */
    public log_TDispflota[] load_log_TDispflota() throws SQLException {
         try{
            BdInterface bd = ConnBdType.open(ConnBdType.SqlServer);
            connection = bd.open();
        
            StringBuilder sqlProc = new StringBuilder();
            sqlProc.append("{call sp_get_log_tdispflota_all}");
            
            if (connection != null){
               CallableStatement cstmt = connection.prepareCall(sqlProc.toString());
               ResultSet result = cstmt.executeQuery();            
               
               Vector<log_TDispflota> vector = new Vector<>();
               
               while(result.next()) {
                   log_TDispflota log_tdispflota = new log_TDispflota(result);
                   vector.add(log_tdispflota);
               }
               
               log_TDispflota[] log_tdispflota = new log_TDispflota[vector.size()];
               for (int i = 0; i < vector.size(); i++) {
                   log_tdispflota[i] = vector.elementAt(i);                    
               }
               return log_tdispflota;
            }else{
                System.out.println("Error: Connexion no activa");
            }
        }catch(SQLException e){            
            StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
            Tools.getErrorMessage(stacktrace,"Error = " + e); 
        }finally{
            connection.close();
        }
        return null;
    }
    /**
     * @author MITM
     * @param find
     * @return 
     * @throws java.sql.SQLException 
     */
    public log_TDispflota[] find_log_TDispflota(String find) throws SQLException {
        try{
            BdInterface bd = ConnBdType.open(ConnBdType.SqlServer);
            connection = bd.open();
        
            StringBuilder sqlProc = new StringBuilder();
            sqlProc.append("{call sp_get_log_tdispflota_find(?)}");
            
            if (connection != null){
               CallableStatement cstmt = connection.prepareCall(sqlProc.toString());
               cstmt.setString("@find"  , find );
               ResultSet result = cstmt.executeQuery();            
               Vector<log_TDispflota> vector = new Vector<>();
               
               while(result.next()) {
                   log_TDispflota log_tdispflota = new log_TDispflota(result);
                   vector.add(log_tdispflota);
               }
               
               log_TDispflota[] log_tdispflota = new log_TDispflota[vector.size()];
               for (int i = 0; i < vector.size(); i++) {
                   log_tdispflota[i] = vector.elementAt(i);                    
               }
               
               return log_tdispflota;
            }else{
                System.out.println("Error: Connexion no activa");
            }
        }catch(SQLException e){            
            StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
            Tools.getErrorMessage(stacktrace,"Error = " + e); 
        }finally{
            connection.close();
        }
        return null;
    }
    /**
     * @author MITM
     * @param operacion Determina el Proceso que se va a ejecutar 1 INSERT, 2 UPDATE
     * @param log_tdispflota
     * @return
     * @throws SQLException
     * @throws Exception 
     */
    public boolean save_log_TDispflota(int operacion, log_TDispflota log_tdispflota) throws SQLException, Exception {
        
        BdInterface bd = ConnBdType.open(ConnBdType.SqlServer);
        connection = bd.open();        
        try{
         if (connection != null){
            //Inicia Transaccion 
            connection.setAutoCommit(false);
            StringBuilder sql = new StringBuilder();            
            String mensj = "";
            
            switch(operacion){
                case 1:
                    sql.append("{call sp_ins_log_tdispflota(?, ?)}");
                    mensj = "Nuevo Tipo Dispflota:";
                    break;
                case 2:
                    sql.append("{call sp_upd_log_tseguro_basic(?, ?, ?)}");
                    mensj = "Actualizando Tipo Dispflota:";
                    break;
            }
            CallableStatement cstmt = connection.prepareCall(sql.toString());
            switch(operacion){
                case 1:
                    cstmt.setString("@nombre"       , log_tdispflota.getNombre().toUpperCase());
                    cstmt.setString("@abrev"        , log_tdispflota.getAbrev().toUpperCase());
                    break;
                case 2:
                    cstmt.setInt("@id_tdispflota"    , log_tdispflota.getIdTDispflota());
                    cstmt.setString("@nombre"        , log_tdispflota.getNombre().toUpperCase());
                    cstmt.setString("@abrev"         , log_tdispflota.getAbrev().toUpperCase());
                    break;
            }
            cstmt.execute();            
            // Auditar el proceso
            auditar(log_tdispflota.getIdTDispflota()+ "",mensj);
            
            connection.commit();
            
            return true;
         }else{
            System.out.println("Error: Connexion no activa");
            throw new Exception("Error de Conexion con la BD");
         }
        }catch(Exception e){            
            connection.rollback();   
            StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
            Tools.getErrorMessage(stacktrace,"Error = " + e);    
            throw e;
        }finally{
            connection.close();
        }
    }
    /**
     * @author MITM
     * Valida si el groupsuppliername generado ya se encuentra asignado a un grupo en la BD
     * @param log_tdispflotasname valor a ser chequeado en la BD
     * @return true si el groupsupplier esta en uso, false si esta disponible el grupo
     * @throws java.sql.SQLException
     */
    public boolean check_log_TDispflota(String log_tdispflotasname) throws SQLException {
        try{
            BdInterface bd = ConnBdType.open(ConnBdType.SqlServer);
            connection = bd.open();
        
            StringBuilder sqlProc = new StringBuilder();
            sqlProc.append("{call sp_get_log_tdispflota_check(?,?)}");
            
            if (connection != null){
               CallableStatement cstmt = connection.prepareCall(sqlProc.toString());                           
               cstmt.setString("@log_tdispflota", log_tdispflotasname);
               cstmt.registerOutParameter("result", java.sql.Types.INTEGER);               
               cstmt.execute();
               if(cstmt.getInt("result") == 1) return true;               
            }else{
                System.out.println("Error: Connexion no activa");
            }
        }catch(SQLException e){            
            StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
            Tools.getErrorMessage(stacktrace,"Error = " + e); 
        }finally{
            connection.close();
        }
        return false;
    }
    /**
     * @author MITM
     * @param log_tdispflota
     * @return 
     * @throws java.lang.Exception 
     */
    public boolean change_log_TDispflota(log_TDispflota log_tdispflota) throws Exception {
        BdInterface bd = ConnBdType.open(ConnBdType.SqlServer);
        connection = bd.open();
        
        try{
         if (connection != null){
            //Inicia Transaccion 
            connection.setAutoCommit(false);
            
            StringBuilder sqlProc = new StringBuilder();
            sqlProc.append("{call sp_upd_log_ttransp_status(?,?)}");
            CallableStatement cstmt = connection.prepareCall(sqlProc.toString());                 
            cstmt.setInt("@id_tproced", log_tdispflota.getIdTDispflota());
            int value = 0;
            if(log_tdispflota.getStatus()== 0){
                value = 1;
            }            
            cstmt.setInt("@status", value );
            cstmt.execute();            
            // Auditar el proceso
            auditar(log_tdispflota.getIdTDispflota()+ "","deletelog_tseguros:");
            
            connection.commit();
            
            return true;
         }else{
            System.out.println("Error: Connexion no activa");
            throw new Exception("Error de Conexion con la BD");
         }
        }catch(Exception e){            
            connection.rollback();            
            StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
            Tools.getErrorMessage(stacktrace,"Error = " + e);    
            throw e;
        }finally{
            connection.close();
        }
    }


    /***************************************************************************/
    /********************************* GUIDE ***********************************/
    /***************************************************************************/
    
    /**
     * @author MITM
     * @param find
     * @param producto
     * @return 
     * @throws java.sql.SQLException 
     */
    public Fxp_Archguid[] find_Archguid(String find, String producto) throws SQLException {
        try{
            BdInterface bd = ConnBdType.open(ConnBdType.SqlServer);
            connection = bd.open();
        
            StringBuilder sqlProc = new StringBuilder();
            sqlProc.append("{call sp_get_archguid_find(?,?)}");
            
            if (connection != null){
               CallableStatement cstmt = connection.prepareCall(sqlProc.toString());
               cstmt.setString("@numguia"   , find );
               cstmt.setString("@producto"  , producto );
               ResultSet result = cstmt.executeQuery();            
               Vector<Fxp_Archguid> vector = new Vector<>();
               
               while(result.next()) {
                   Fxp_Archguid archguid = new Fxp_Archguid(result);
                   vector.add(archguid);
               }
               
               Fxp_Archguid[] archguid = new Fxp_Archguid[vector.size()];
               for (int i = 0; i < vector.size(); i++) {
                   archguid[i] = vector.elementAt(i);                    
               }
               
               return archguid;
            }else{
                System.out.println("Error: Connexion no activa");
            }
        }catch(SQLException e){            
            StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
            Tools.getErrorMessage(stacktrace,"Error = " + e); 
        }finally{
            connection.close();
        }
        return null;
    }
    /**
     * @author MITM
     * @param find
     * @return 
     * @throws java.sql.SQLException 
     */
    public Fxp_Archguid_gfc[] find_Archguid_gfc(String find) throws SQLException {
        try{
            BdInterface bd = ConnBdType.open(ConnBdType.SqlServer);
            connection = bd.open();
        
            StringBuilder sqlProc = new StringBuilder();
            sqlProc.append("{call sp_get_archguid_find_gfc(?)}");
            
            if (connection != null){
               CallableStatement cstmt = connection.prepareCall(sqlProc.toString());
               cstmt.setString("@numguia"   , find );
               ResultSet result = cstmt.executeQuery();            
               Vector<Fxp_Archguid_gfc> vector = new Vector<>();
               
               while(result.next()) {
                   Fxp_Archguid_gfc archguid_gfc = new Fxp_Archguid_gfc(result);
                   vector.add(archguid_gfc);
               }
               
               Fxp_Archguid_gfc[] archguid_gfc = new Fxp_Archguid_gfc[vector.size()];
               for (int i = 0; i < vector.size(); i++) {
                   archguid_gfc[i] = vector.elementAt(i);                    
               }
               
               return archguid_gfc;
            }else{
                System.out.println("Error: Connexion no activa");
            }
        }catch(SQLException e){            
            StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
            Tools.getErrorMessage(stacktrace,"Error = " + e); 
        }finally{
            connection.close();
        }
        return null;
    }
    /**
     * @author MITM
     * @param rif
     * @param producto
     * @param guia
     * @return 
     * @throws java.sql.SQLException 
     */
    public Fxp_Archguid_cp[] find_Archguid_cp(String rif, String producto, String guia) throws SQLException {
        try{
            BdInterface bd = ConnBdType.open(ConnBdType.SqlServer);
            connection = bd.open();
        
            StringBuilder sqlProc = new StringBuilder();
            sqlProc.append("{call sp_get_archguid_find_cp(?, ?, ?)}");
            
            if (connection != null){
               CallableStatement cstmt = connection.prepareCall(sqlProc.toString());
               cstmt.setString("@numrif"    , rif );
               cstmt.setString("@numguia"   , guia );
               cstmt.setString("@producto"  , producto );
               ResultSet result = cstmt.executeQuery();            
               Vector<Fxp_Archguid_cp> vector = new Vector<>();
               
               while(result.next()) {
                   Fxp_Archguid_cp archguid_cp = new Fxp_Archguid_cp(result);
                   vector.add(archguid_cp);
               }
               
               Fxp_Archguid_cp[] archguid_cp = new Fxp_Archguid_cp[vector.size()];
               for (int i = 0; i < vector.size(); i++) {
                   archguid_cp[i] = vector.elementAt(i);                    
               }
               
               return archguid_cp;
            }else{
                System.out.println("Error: Connexion no activa");
            }
        }catch(SQLException e){            
            StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
            Tools.getErrorMessage(stacktrace,"Error = " + e); 
        }finally{
            connection.close();
        }
        return null;
    }
    /**
     * @author MITM
     * @param numdoc
     * @return 
     * @throws java.sql.SQLException 
     */
    public Fxp_Archguid_cp[] find_Archguid_red_ca(Integer numdoc) throws SQLException {
        try{
            BdInterface bd = ConnBdType.open(ConnBdType.SqlServer);
            connection = bd.open();
        
            StringBuilder sqlProc = new StringBuilder();
            sqlProc.append("{call sp_get_archguid_find_red_ca(?)}");
            
            if (connection != null){
               CallableStatement cstmt = connection.prepareCall(sqlProc.toString());
               cstmt.setInt("@numdoc"       , numdoc );
               ResultSet result = cstmt.executeQuery();            
               Vector<Fxp_Archguid_cp> vector = new Vector<>();
               
               while(result.next()) {
                   Fxp_Archguid_cp archguid_cp = new Fxp_Archguid_cp(result);
                   vector.add(archguid_cp);
               }
               
               Fxp_Archguid_cp[] archguid_cp = new Fxp_Archguid_cp[vector.size()];
               for (int i = 0; i < vector.size(); i++) {
                   archguid_cp[i] = vector.elementAt(i);                    
               }
               
               return archguid_cp;
            }else{
                System.out.println("Error: Connexion no activa");
            }
        }catch(SQLException e){            
            StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
            Tools.getErrorMessage(stacktrace,"Error = " + e); 
        }finally{
            connection.close();
        }
        return null;
    }
    /**
     * @author MITM
     * @param cliente
     * @return 
     * @throws java.sql.SQLException 
     */
    public Fxp_Archguid_cli[] find_Archguid_cli(String cliente) throws SQLException {
        try{
            BdInterface bd = ConnBdType.open(ConnBdType.SqlServer);
            connection = bd.open();
        
            StringBuilder sqlProc = new StringBuilder();
            sqlProc.append("{call sp_get_archguid_find_clie(?)}");
            
            if (connection != null){
               CallableStatement cstmt = connection.prepareCall(sqlProc.toString());
               cstmt.setString("@find"  , cliente );
               ResultSet result = cstmt.executeQuery();            
               Vector<Fxp_Archguid_cli> vector = new Vector<>();
               
               while(result.next()) {
                   Fxp_Archguid_cli archguid_clie = new Fxp_Archguid_cli(result);
                   vector.add(archguid_clie);
               }
               
               Fxp_Archguid_cli[] archguid_clie = new Fxp_Archguid_cli[vector.size()];
               for (int i = 0; i < vector.size(); i++) {
                   archguid_clie[i] = vector.elementAt(i);                    
               }
               
               return archguid_clie;
            }else{
                System.out.println("Error: Connexion no activa");
            }
        }catch(SQLException e){            
            StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
            Tools.getErrorMessage(stacktrace,"Error = " + e); 
        }finally{
            connection.close();
        }
        return null;
    }
    /**
     * @author MITM
     * @param guia
     * @param alm
     * @return 
     * @throws java.sql.SQLException 
     */
    public Fxp_Archguip_det[] find_Archguip_det(String guia, String alm) throws SQLException {
        try{
            BdInterface bd = ConnBdType.open(ConnBdType.SqlServer);
            connection = bd.open();
        
            StringBuilder sqlProc = new StringBuilder();
            sqlProc.append("{call sp_get_archguip_find_det(?, ?)}");
            
            if (connection != null){
               CallableStatement cstmt = connection.prepareCall(sqlProc.toString());
               cstmt.setString("@numguia"  , guia );
               cstmt.setString("@almacen"  , alm );
               ResultSet result = cstmt.executeQuery();            
               Vector<Fxp_Archguip_det> vector = new Vector<>();
               
               while(result.next()) {
                   Fxp_Archguip_det archguip = new Fxp_Archguip_det(result);
                   vector.add(archguip);
               }
               
               Fxp_Archguip_det[] archguip = new Fxp_Archguip_det[vector.size()];
               for (int i = 0; i < vector.size(); i++) {
                   archguip[i] = vector.elementAt(i);                    
               }
               
               return archguip;
            }else{
                System.out.println("Error: Connexion no activa");
            }
        }catch(SQLException e){            
            StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
            Tools.getErrorMessage(stacktrace,"Error = " + e); 
        }finally{
            connection.close();
        }
        return null;
    }
    /**
     * @author MITM
     * @param producto
     * @return 
     * @throws java.sql.SQLException 
     */
    public Fxp_Archguip_det[] find_Archguip_pro_det(String producto) throws SQLException {
        try{
            BdInterface bd = ConnBdType.open(ConnBdType.SqlServer);
            connection = bd.open();
        
            StringBuilder sqlProc = new StringBuilder();
            sqlProc.append("{call sp_get_archguip_pro_find_det(?)}");
            
            if (connection != null){
               CallableStatement cstmt = connection.prepareCall(sqlProc.toString());
               cstmt.setString("@find"  , producto );
               ResultSet result = cstmt.executeQuery();            
               Vector<Fxp_Archguip_det> vector = new Vector<>();
               
               while(result.next()) {
                   Fxp_Archguip_det archguip = new Fxp_Archguip_det(result);
                   vector.add(archguip);
               }
               
               Fxp_Archguip_det[] archguip = new Fxp_Archguip_det[vector.size()];
               for (int i = 0; i < vector.size(); i++) {
                   archguip[i] = vector.elementAt(i);                    
               }
               
               return archguip;
            }else{
                System.out.println("Error: Connexion no activa");
            }
        }catch(SQLException e){            
            StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
            Tools.getErrorMessage(stacktrace,"Error = " + e); 
        }finally{
            connection.close();
        }
        return null;
    }
    /**
     * @author MITM
     * @param guia
     * @param producto
     * @return 
     * @throws java.sql.SQLException 
     */
    public Fxp_Archguip_pro_cg[] find_Archguip_pro_guia(String guia, String producto) throws SQLException {
        try{
            BdInterface bd = ConnBdType.open(ConnBdType.SqlServer);
            connection = bd.open();
        
            StringBuilder sqlProc = new StringBuilder();
            sqlProc.append("{call sp_get_archguip_find_pro_guia(?, ?)}");
            
            if (connection != null){
               CallableStatement cstmt = connection.prepareCall(sqlProc.toString());
               cstmt.setString("@numguia"  , guia );
               cstmt.setString("@producto"  , producto );
               ResultSet result = cstmt.executeQuery();            
               Vector<Fxp_Archguip_pro_cg> vector = new Vector<>();
               
               while(result.next()) {
                   Fxp_Archguip_pro_cg archguip = new Fxp_Archguip_pro_cg(result);
                   vector.add(archguip);
               }
               
               Fxp_Archguip_pro_cg[] archguip = new Fxp_Archguip_pro_cg[vector.size()];
               for (int i = 0; i < vector.size(); i++) {
                   archguip[i] = vector.elementAt(i);                    
               }
               
               return archguip;
            }else{
                System.out.println("Error: Connexion no activa");
            }
        }catch(SQLException e){            
            StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
            Tools.getErrorMessage(stacktrace,"Error = " + e); 
        }finally{
            connection.close();
        }
        return null;
    }
    /**
     * @author MITM
     * @param fact
     * @param clie
     * @param producto
     * @return 
     * @throws java.sql.SQLException 
     */
    public Fxp_Archguip_pro_dv[] find_Archguip_pro_fact(String fact, String clie, String producto) throws SQLException {
        try{
            BdInterface bd = ConnBdType.open(ConnBdType.SqlServer);
            connection = bd.open();
        
            StringBuilder sqlProc = new StringBuilder();
            sqlProc.append("{call sp_get_archguip_find_pro_fact(?, ?, ?)}");
            
            if (connection != null){
               CallableStatement cstmt = connection.prepareCall(sqlProc.toString());
               cstmt.setString("@numdoc"    , fact );
               cstmt.setString("@numcli"    , clie );
               cstmt.setString("@producto"  , producto );
               ResultSet result = cstmt.executeQuery();            
               Vector<Fxp_Archguip_pro_dv> vector = new Vector<>();
               
               while(result.next()) {
                   Fxp_Archguip_pro_dv archguip = new Fxp_Archguip_pro_dv(result);
                   vector.add(archguip);
               }
               
               Fxp_Archguip_pro_dv[] archguip = new Fxp_Archguip_pro_dv[vector.size()];
               for (int i = 0; i < vector.size(); i++) {
                   archguip[i] = vector.elementAt(i);                    
               }
               
               return archguip;
            }else{
                System.out.println("Error: Connexion no activa");
            }
        }catch(SQLException e){            
            StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
            Tools.getErrorMessage(stacktrace,"Error = " + e); 
        }finally{
            connection.close();
        }
        return null;
    }
    /**
     * @author MITM
     * @param letdoc
     * @param fact
     * @param clie
     * @param producto
     * @return 
     * @throws java.sql.SQLException 
     */
    public Fxp_Archguip_pro[] find_Archguid_pro_fact(String letdoc, String fact, String clie, String producto) throws SQLException {
        try{
            BdInterface bd = ConnBdType.open(ConnBdType.SqlServer);
            connection = bd.open();
        
            StringBuilder sqlProc = new StringBuilder();
            sqlProc.append("{call sp_get_archguid_find_pro_fact(?, ?, ?, ?)}");
            
            if (connection != null){
               CallableStatement cstmt = connection.prepareCall(sqlProc.toString());
               cstmt.setString("@letdoc"    , letdoc );
               cstmt.setString("@numdoc"    , fact );
               cstmt.setString("@numcli"    , clie );
               cstmt.setString("@producto"  , producto );
               ResultSet result = cstmt.executeQuery();            
               Vector<Fxp_Archguip_pro> vector = new Vector<>();
               
               while(result.next()) {
                   Fxp_Archguip_pro archguip = new Fxp_Archguip_pro(result);
                   vector.add(archguip);
               }
               
               Fxp_Archguip_pro[] archguip = new Fxp_Archguip_pro[vector.size()];
               for (int i = 0; i < vector.size(); i++) {
                   archguip[i] = vector.elementAt(i);                    
               }
               
               return archguip;
            }else{
                System.out.println("Error: Connexion no activa");
            }
        }catch(SQLException e){            
            StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
            Tools.getErrorMessage(stacktrace,"Error = " + e); 
        }finally{
            connection.close();
        }
        return null;
    }
    /**
     * @author MITM
     * @param guia
     * @param alm
     * @return 
     * @throws java.sql.SQLException 
     */
    public Fxp_Archguip_sum[] find_Archguip_sum(String guia, String alm) throws SQLException {
        try{
            BdInterface bd = ConnBdType.open(ConnBdType.SqlServer);
            connection = bd.open();
        
            StringBuilder sqlProc = new StringBuilder();
            sqlProc.append("{call sp_get_archguip_find_sum(?, ?)}");
            
            if (connection != null){
               CallableStatement cstmt = connection.prepareCall(sqlProc.toString());
               cstmt.setString("@numguia"  , guia );
               cstmt.setString("@almacen"  , alm );
               ResultSet result = cstmt.executeQuery();            
               Vector<Fxp_Archguip_sum> vector = new Vector<>();
               
               while(result.next()) {
                   Fxp_Archguip_sum archguip = new Fxp_Archguip_sum(result);
                   vector.add(archguip);
               }
               
               Fxp_Archguip_sum[] archguip = new Fxp_Archguip_sum[vector.size()];
               for (int i = 0; i < vector.size(); i++) {
                   archguip[i] = vector.elementAt(i);                    
               }
               
               return archguip;
            }else{
                System.out.println("Error: Connexion no activa");
            }
        }catch(SQLException e){            
            StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
            Tools.getErrorMessage(stacktrace,"Error = " + e); 
        }finally{
            connection.close();
        }
        return null;
    }
    /**
     * @author MITM
     * @param fact
     * @return 
     * @throws java.sql.SQLException 
     */
    public Fxp_Renglon[] find_Renglon(String fact) throws SQLException {
        try{
            BdInterface bd = ConnBdType.open(ConnBdType.SqlServer);
            connection = bd.open();
        
            StringBuilder sqlProc = new StringBuilder();
            sqlProc.append("{call sp_get_fxp_renglon_find(?)}");
            
            if (connection != null){
               CallableStatement cstmt = connection.prepareCall(sqlProc.toString());
               cstmt.setString("@numfac"  , fact );
               ResultSet result = cstmt.executeQuery();            
               Vector<Fxp_Renglon> vector = new Vector<>();
               
               while(result.next()) {
                   Fxp_Renglon renglon = new Fxp_Renglon(result);
                   vector.add(renglon);
               }
               
               Fxp_Renglon[] renglon = new Fxp_Renglon[vector.size()];
               for (int i = 0; i < vector.size(); i++) {
                   renglon[i] = vector.elementAt(i);                    
               }
               
               return renglon;
            }else{
                System.out.println("Error: Connexion no activa");
            }
        }catch(SQLException e){            
            StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
            Tools.getErrorMessage(stacktrace,"Error = " + e); 
        }finally{
            connection.close();
        }
        return null;
    }
    /**
     * @author MITM
     * Valida si el groupsuppliername generado ya se encuentra asignado a un grupo en la BD
     * @param guia valor a ser chequeado en la BD
     * @return true si el groupsupplier esta en uso, false si esta disponible el grupo
     * @throws java.sql.SQLException
     */
    public boolean check_log_Archguie(String guia) throws SQLException {
        try{
            BdInterface bd = ConnBdType.open(ConnBdType.SqlServer);
            connection = bd.open();
        
            StringBuilder sqlProc = new StringBuilder();
            sqlProc.append("{call sp_get_archguie_check(?,?)}");
            
            if (connection != null){
               CallableStatement cstmt = connection.prepareCall(sqlProc.toString());                           
               cstmt.setString("@numguia", guia);
               cstmt.registerOutParameter("result", java.sql.Types.INTEGER);               
               cstmt.execute();
               if(cstmt.getInt("result") == 1) return true;               
            }else{
                System.out.println("Error: Connexion no activa");
            }
        }catch(SQLException e){            
            StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
            Tools.getErrorMessage(stacktrace,"Error = " + e); 
        }finally{
            connection.close();
        }
        return false;
    }
    /**
     * @author MITM
     * Valida si el groupsuppliername generado ya se encuentra asignado a un grupo en la BD
     * @param guia
     * @param producto valor a ser chequeado en la BD
     * @return true si el groupsupplier esta en uso, false si esta disponible el grupo
     * @throws java.sql.SQLException
     */
    public boolean check_log_Archguip_guia(String guia, String producto) throws SQLException {
        try{
            BdInterface bd = ConnBdType.open(ConnBdType.SqlServer);
            connection = bd.open();
        
            StringBuilder sqlProc = new StringBuilder();
            sqlProc.append("{call sp_get_archguip_check_guia(?,?,?)}");
            
            if (connection != null){
               CallableStatement cstmt = connection.prepareCall(sqlProc.toString());                           
               cstmt.setString("@numguia", guia);
               cstmt.setString("@producto", producto);
               cstmt.registerOutParameter("result", java.sql.Types.INTEGER);               
               cstmt.execute();
               if(cstmt.getInt("result") == 1) return true;               
            }else{
                System.out.println("Error: Connexion no activa");
            }
        }catch(SQLException e){            
            StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
            Tools.getErrorMessage(stacktrace,"Error = " + e); 
        }finally{
            connection.close();
        }
        return false;
    }
    /**
     * @author MITM
     * Valida si el groupsuppliername generado ya se encuentra asignado a un grupo en la BD
     * @param fact
     * @param producto valor a ser chequeado en la BD
     * @return true si el groupsupplier esta en uso, false si esta disponible el grupo
     * @throws java.sql.SQLException
     */
    public boolean check_log_Archguip_fact(String fact, String producto) throws SQLException {
        try{
            BdInterface bd = ConnBdType.open(ConnBdType.SqlServer);
            connection = bd.open();
        
            StringBuilder sqlProc = new StringBuilder();
            sqlProc.append("{call sp_get_archguip_check_fact(?,?,?)}");
            
            if (connection != null){
               CallableStatement cstmt = connection.prepareCall(sqlProc.toString());                           
               cstmt.setString("@numdoc", fact);
               cstmt.setString("@producto", producto);
               cstmt.registerOutParameter("result", java.sql.Types.INTEGER);               
               cstmt.execute();
               if(cstmt.getInt("result") == 1) return true;               
            }else{
                System.out.println("Error: Connexion no activa");
            }
        }catch(SQLException e){            
            StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
            Tools.getErrorMessage(stacktrace,"Error = " + e); 
        }finally{
            connection.close();
        }
        return false;
    }
    /**
     * @author MITM
     * Valida si el groupsuppliername generado ya se encuentra asignado a un grupo en la BD
     * @param numdoc valor a ser chequeado en la BD
     * @return true si el groupsupplier esta en uso, false si esta disponible el grupo
     * @throws java.sql.SQLException
     */
    public boolean check_log_Archguid_Numdoc(String numdoc, String guia) throws SQLException {
        try{
            BdInterface bd = ConnBdType.open(ConnBdType.SqlServer);
            connection = bd.open();
        
            StringBuilder sqlProc = new StringBuilder();
            sqlProc.append("{call sp_get_archguid_check_fact(?,?,?)}");
            
            if (connection != null){
               CallableStatement cstmt = connection.prepareCall(sqlProc.toString());                           
               cstmt.setString("@numdoc", numdoc);
               cstmt.setString("@numguia", guia);
               cstmt.registerOutParameter("result", java.sql.Types.INTEGER);               
               cstmt.execute();
               if(cstmt.getInt("result") == 1) return true;               
            }else{
                System.out.println("Error: Connexion no activa");
            }
        }catch(SQLException e){            
            StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
            Tools.getErrorMessage(stacktrace,"Error = " + e); 
        }finally{
            connection.close();
        }
        return false;
    }
    /**
     * @author MITM
     * Valida si el groupsuppliername generado ya se encuentra asignado a un grupo en la BD
     * @param guia valor a ser chequeado en la BD
     * @return true si el groupsupplier esta en uso, false si esta disponible el grupo
     * @throws java.sql.SQLException
     */
    public boolean check_log_CGuias_rela_carga(String guia) throws SQLException {
        try{
            BdInterface bd = ConnBdType.open(ConnBdType.SqlServer);
            connection = bd.open();
        
            StringBuilder sqlProc = new StringBuilder();
            sqlProc.append("{call sp_get_log_cguias_check_nr_car(?,?)}");
            
            if (connection != null){
               CallableStatement cstmt = connection.prepareCall(sqlProc.toString());                           
               cstmt.setString("@numrela", guia);
               cstmt.registerOutParameter("result", java.sql.Types.INTEGER);               
               cstmt.execute();
               if(cstmt.getInt("result") == 1) return true;               
            }else{
                System.out.println("Error: Connexion no activa");
            }
        }catch(SQLException e){            
            StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
            Tools.getErrorMessage(stacktrace,"Error = " + e); 
        }finally{
            connection.close();
        }
        return false;
    }
    /**
     * @author MITM
     * Valida si el groupsuppliername generado ya se encuentra asignado a un grupo en la BD
     * @param guia valor a ser chequeado en la BD
     * @return true si el groupsupplier esta en uso, false si esta disponible el grupo
     * @throws java.sql.SQLException
     */
    public boolean check_log_CGuias_rela_caja(String guia) throws SQLException {
        try{
            BdInterface bd = ConnBdType.open(ConnBdType.SqlServer);
            connection = bd.open();
        
            StringBuilder sqlProc = new StringBuilder();
            sqlProc.append("{call sp_get_log_cguias_check_nr_caj(?,?)}");
            
            if (connection != null){
               CallableStatement cstmt = connection.prepareCall(sqlProc.toString());                           
               cstmt.setString("@numrela", guia);
               cstmt.registerOutParameter("result", java.sql.Types.INTEGER);               
               cstmt.execute();
               if(cstmt.getInt("result") == 1) return true;               
            }else{
                System.out.println("Error: Connexion no activa");
            }
        }catch(SQLException e){            
            StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
            Tools.getErrorMessage(stacktrace,"Error = " + e); 
        }finally{
            connection.close();
        }
        return false;
    }
    /**
     * @author MITM
     * Valida si el groupsuppliername generado ya se encuentra asignado a un grupo en la BD
     * @param guia valor a ser chequeado en la BD
     * @return true si el groupsupplier esta en uso, false si esta disponible el grupo
     * @throws java.sql.SQLException
     */
    public boolean check_log_CGuias_carga(String guia) throws SQLException {
        try{
            BdInterface bd = ConnBdType.open(ConnBdType.SqlServer);
            connection = bd.open();
        
            StringBuilder sqlProc = new StringBuilder();
            sqlProc.append("{call sp_get_log_cguias_check_ng_car(?,?)}");
            
            if (connection != null){
               CallableStatement cstmt = connection.prepareCall(sqlProc.toString());                           
               cstmt.setString("@numguia", guia);
               cstmt.registerOutParameter("result", java.sql.Types.INTEGER);               
               cstmt.execute();
               if(cstmt.getInt("result") == 1) return true;               
            }else{
                System.out.println("Error: Connexion no activa");
            }
        }catch(SQLException e){            
            StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
            Tools.getErrorMessage(stacktrace,"Error = " + e); 
        }finally{
            connection.close();
        }
        return false;
    }
    /**
     * @author MITM
     * Valida si el groupsuppliername generado ya se encuentra asignado a un grupo en la BD
     * @param guia valor a ser chequeado en la BD
     * @return true si el groupsupplier esta en uso, false si esta disponible el grupo
     * @throws java.sql.SQLException
     */
    public boolean check_log_CGuias_caja(String guia) throws SQLException {
        try{
            BdInterface bd = ConnBdType.open(ConnBdType.SqlServer);
            connection = bd.open();
        
            StringBuilder sqlProc = new StringBuilder();
            sqlProc.append("{call sp_get_log_cguias_check_ng_caj(?,?)}");
            
            if (connection != null){
               CallableStatement cstmt = connection.prepareCall(sqlProc.toString());                           
               cstmt.setString("@numrela", guia);
               cstmt.registerOutParameter("result", java.sql.Types.INTEGER);               
               cstmt.execute();
               if(cstmt.getInt("result") == 1) return true;               
            }else{
                System.out.println("Error: Connexion no activa");
            }
        }catch(SQLException e){            
            StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
            Tools.getErrorMessage(stacktrace,"Error = " + e); 
        }finally{
            connection.close();
        }
        return false;
    }
    /**
     * @author MITM
     * Valida si el groupsuppliername generado ya se encuentra asignado a un grupo en la BD
     * @param guiaFalt valor a ser chequeado en la BD
     * @return true si el groupsupplier esta en uso, false si esta disponible el grupo
     * @throws java.sql.SQLException
     */
    public boolean check_log_CGuias_fcarga(String guiaFalt) throws SQLException {
        try{
            BdInterface bd = ConnBdType.open(ConnBdType.SqlServer);
            connection = bd.open();
        
            StringBuilder sqlProc = new StringBuilder();
            sqlProc.append("{call sp_get_log_cguias_check_fcar(?, ?)}");
            
            if (connection != null){
               CallableStatement cstmt = connection.prepareCall(sqlProc.toString());                           
               cstmt.setString("@numfcar", guiaFalt);
               cstmt.registerOutParameter("result", java.sql.Types.INTEGER);               
               cstmt.execute();
               if(cstmt.getInt("result") == 1) return true;               
            }else{
                System.out.println("Error: Connexion no activa");
            }
        }catch(SQLException e){            
            StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
            Tools.getErrorMessage(stacktrace,"Error = " + e); 
        }finally{
            connection.close();
        }
        return false;
    }
    /**
     * @author MITM
     * Valida si el groupsuppliername generado ya se encuentra asignado a un grupo en la BD
     * @param producto valor a ser chequeado en la BD
     * @return true si el groupsupplier esta en uso, false si esta disponible el grupo
     * @throws java.sql.SQLException
     */
    public boolean check_log_cguias_check_fdev_prod(String producto) throws SQLException {
        try{
            BdInterface bd = ConnBdType.open(ConnBdType.SqlServer);
            connection = bd.open();
        
            StringBuilder sqlProc = new StringBuilder();
            sqlProc.append("{call sp_get_log_cguias_check_fdev_prod(?,?)}");
            
            if (connection != null){
               CallableStatement cstmt = connection.prepareCall(sqlProc.toString());                           
               cstmt.setString("@producto", producto);
               cstmt.registerOutParameter("result", java.sql.Types.INTEGER);               
               cstmt.execute();
               if(cstmt.getInt("result") == 1) return true;               
            }else{
                System.out.println("Error: Connexion no activa");
            }
        }catch(SQLException e){            
            StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
            Tools.getErrorMessage(stacktrace,"Error = " + e); 
        }finally{
            connection.close();
        }
        return false;
    }
    /**
     * @author MITM
     * @param operacion Determina el Proceso que se va a ejecutar 1 INSERT, 2 UPDATE
     * @param log_cguias
     * @param pos
     * @return
     * @throws SQLException
     * @throws Exception 
     */
    public boolean save_log_CGuias(
            log_CGuias log_cguias, int operacion, int pos) throws SQLException, Exception {
        
        BdInterface bd = ConnBdType.open(ConnBdType.SqlServer);
        connection = bd.open();        
        try{
            if (connection != null){
                //Inicia Transaccion 
                connection.setAutoCommit(false);
                StringBuilder sql_rela = new StringBuilder();            
                StringBuilder sql_data = new StringBuilder();            
                StringBuilder sql_chof = new StringBuilder();            
                StringBuilder sql_vehi = new StringBuilder();            
                StringBuilder sql_ayud = new StringBuilder();            
                StringBuilder sql_cheq = new StringBuilder();            
                StringBuilder sql_perm = new StringBuilder();            
                String mensj = "";

                switch(operacion){
                    case 1:
                        sql_rela.append("{call sp_ins_log_cguias_numrela(?)}");
                        sql_data.append("{call sp_ins_log_cguias_data(?, ?, ?, ?, ?, ?, ?, ?, ?)}");
                        sql_chof.append("{call sp_ins_log_cguias_chof(?, ?, ?)}");
                        sql_vehi.append("{call sp_ins_log_cguias_vehi(?, ?, ?, ?, ?, ?, ?)}");
                        sql_ayud.append("{call sp_ins_log_cguias_ayud(?, ?, ?, ?)}");
                        sql_cheq.append("{call sp_ins_log_cguias_cheq(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}");
                        mensj = "Nueva log_CGuias:";
                        break;
                    case 2:
                        log_cguias.setNumrela(String.valueOf(Datos.getNumRela()));

                        sql_data.append("{call sp_upd_log_cguias_data(?, ?, ?, ?, ?, ?, ?, ?, ?)}");
                        sql_chof.append("{call sp_upd_log_cguias_chof(?, ?, ?)}");
                        sql_vehi.append("{call sp_upd_log_cguias_vehi(?, ?, ?, ?, ?, ?, ?)}");
                        sql_ayud.append("{call sp_upd_log_cguias_ayud(?, ?, ?, ?)}");
                        sql_cheq.append("{call sp_upd_log_cguias_cheq(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}");
                        mensj = "Actualizando log_CGuias:";
                        break;
                }
                CallableStatement cstmt = null;
                if (pos == 0){
                    /**
                     * Busqueda NumRela
                     */
                    if (operacion == 1){
                        cstmt = connection.prepareCall(sql_rela.toString());
                        cstmt.registerOutParameter("numrela"    , java.sql.Types.VARCHAR);
                        cstmt.execute();            
                        log_cguias.setNumrela(cstmt.getString("numrela"));
                        Datos.setNumRela(cstmt.getString("numrela"));
                    }


                    /**
                     * Choferes
                     */
                    cstmt = connection.prepareCall(sql_chof.toString());
                    cstmt.setString("@numrela"         , log_cguias.getNumrela());
                    cstmt.setDate("@fecha"             , log_cguias.getFecha());
                    cstmt.setString("@id_personal"     , log_cguias.getChofer());
                    cstmt.execute();


                    /**
                     * Vehiculos
                     */
                    cstmt = connection.prepareCall(sql_vehi.toString());
                    cstmt.setString("@numrela"         , log_cguias.getNumrela());
                    cstmt.setDate("@fecha"             , log_cguias.getFecha());
                    cstmt.setInt("@numpuerta"          , log_cguias.getNumpuerta());
                    cstmt.setInt("@numturno"          , log_cguias.getTurno());
                    cstmt.setString("@nro_placa1"      , log_cguias.getVeh1());
                    cstmt.setString("@nro_placa2"      , log_cguias.getVeh2());
                    cstmt.setString("@odometro"        , log_cguias.getOdometro());
                    cstmt.execute();


                    /**
                     * Ayudantes
                     */
                    cstmt = connection.prepareCall(sql_ayud.toString());
                    cstmt.setString("@numrela"         , log_cguias.getNumrela());
                    cstmt.setDate("@fecha"             , log_cguias.getFecha());
                    if(log_cguias.getAyud1().equals("")) 
                        cstmt.setString("@id_personal1", null);
                    else
                        cstmt.setString("@id_personal1", log_cguias.getAyud1());

                    cstmt.setString("@id_personal2"    , log_cguias.getAyud2());
                    cstmt.execute();


                    /**
                     * Chequeador Sup. Ruta, Puerta e Interno
                     */
                    cstmt = connection.prepareCall(sql_cheq.toString());
                    cstmt.setString("@numrela"         , log_cguias.getNumrela());
                    cstmt.setDate("@fecha"             , log_cguias.getFecha());
                    cstmt.setString("@id_supruta"      , log_cguias.getIdsupruta());
                    cstmt.setString("@id_cheqext"      , log_cguias.getCheq_pta());
                    cstmt.setString("@id_cheqa1"       , log_cguias.getCheq_r1());
                    cstmt.setString("@id_cheqa2"       , log_cguias.getCheq_r2());
                    cstmt.setString("@id_cheqa3"       , log_cguias.getCheq_r3());
                    cstmt.setString("@id_cheqa4"       , log_cguias.getCheq_r4());
                    cstmt.setString("@id_cheqa5"       , log_cguias.getCheq_r5());
                    cstmt.setString("@id_cheqa6"       , log_cguias.getCheq_r6());
                    cstmt.setString("@id_cheqa7"       , log_cguias.getCheq_r7());
                    cstmt.setString("@id_cheqap"       , log_cguias.getCheq_pq());
                    cstmt.execute();
                }


                /**
                 * Guias de Carga
                 */
                cstmt = connection.prepareCall(sql_data.toString());
                cstmt.setString("@numrela"              , log_cguias.getNumrela());
                cstmt.setDouble("@numorden"             , pos + 1);
                cstmt.setString("@numguia"              , log_cguias.getNumguia());
                cstmt.setInt("@numfacturas"             , log_cguias.getNumfact());
                cstmt.setInt("@numclientes"             , log_cguias.getNumclie());
                cstmt.setString("@status"               , log_cguias.getStat_guia());
                cstmt.setInt("@anulada"                 , log_cguias.getAnulada());
                cstmt.setDate("@fecha"                  , log_cguias.getFecha());
                cstmt.setDate("@fecsalida"              , log_cguias.getFecsalida());
                cstmt.execute();            

                // Auditar el proceso
                auditar(log_cguias.getNumrela()+ "",mensj);

                connection.commit();

                return true;
            }else{
                System.out.println("Error: Connexion no activa");
                throw new Exception("Error de Conexion con la BD");
            }
        }catch(Exception e){            
            connection.rollback();   
            StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
            Tools.getErrorMessage(stacktrace,"Error = " + e);    
            throw e;
        }finally{
            connection.close();
        }
    }
    /**
     * @author MITM
     * @param operacion Determina el Proceso que se va a ejecutar 1 INSERT, 2
     * UPDATE
     * @param log_cguias_perm
     * @param pos
     * @return
     * @throws SQLException
     * @throws Exception
     */
    public boolean save_log_CGuias_perm(
            log_CGuias_perm log_cguias_perm, int operacion, int pos) throws SQLException, Exception {

        BdInterface bd = ConnBdType.open(ConnBdType.SqlServer);
        connection = bd.open();
        try {
            if (connection != null) {
                //Inicia Transaccion 
                connection.setAutoCommit(false);
                StringBuilder sqlProc = new StringBuilder();
                String mensj = "";

                switch (operacion) {
                    case 1:
                        sqlProc.append("{call sp_ins_log_cguias_perm(?, ?, ?, ?, ?)}");
                        mensj = "Nueva log_CGuias_perm:";
                        break;
                    case 2:
                        sqlProc.append("{call sp_upd_log_cguias_perm(?, ?, ?, ?, ? )}");
                        mensj = "Actualizando log_CGuias_perm:";
                        break;
                }
                CallableStatement cstmt = connection.prepareCall(sqlProc.toString());                           
                cstmt.setString("@numrela",         log_cguias_perm.getNumrela());
                cstmt.setDouble("@numorden",        pos + 1);
                cstmt.setString("@numpermiso",      log_cguias_perm.getGuias());
                cstmt.setInt("@id_tpermiso",        log_cguias_perm.getTpermiso());
                cstmt.setDate("@fecha",             log_cguias_perm.getFecha());
                cstmt.execute();

                // Auditar el proceso
                auditar(log_cguias_perm.getNumrela() + "", mensj);

                connection.commit();

                return true;
            } else {
                System.out.println("Error: Connexion no activa");
                throw new Exception("Error de Conexion con la BD");
            }
        } catch (Exception e) {
            connection.rollback();
            StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
            Tools.getErrorMessage(stacktrace, "Error = " + e);
            throw e;
        } finally {
            connection.close();
        }
    }
    /**
     * @author MITM
     * @param operacion Determina el Proceso que se va a ejecutar 1 INSERT, 2
     * UPDATE
     * @param log_cguias_falt
     * @param pos
     * @return
     * @throws SQLException
     * @throws Exception
     */
    public boolean save_log_CGuias_falt(
            log_CGuias_falt_cg log_cguias_falt, int operacion, int pos) throws SQLException, Exception {

        BdInterface bd = ConnBdType.open(ConnBdType.SqlServer);
        connection = bd.open();
        try {
            if (connection != null) {
                //Inicia Transaccion 
                connection.setAutoCommit(false);
                StringBuilder sqlProc = new StringBuilder();
                String mensj = "";

                switch (operacion) {
                    case 1:
                        sqlProc.append("{call sp_ins_log_cguias_falt(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}");
                        mensj = "Nueva log_CGuias_falt:";
                        break;
                    case 2:
                        sqlProc.append("{call sp_upd_log_cguias_falt(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}");
                        mensj = "Actualizando log_CGuias_falt:";
                        break;
                }
                CallableStatement cstmt = connection.prepareCall(sqlProc.toString());                           
                cstmt.setString("@numrela",         log_cguias_falt.getNumrela());
                cstmt.setDouble("@numorden",        pos + 1);
                cstmt.setDate("@fecha",             log_cguias_falt.getFecha());
                cstmt.setString("@numguia",         log_cguias_falt.getNumguiac());
                cstmt.setString("@numfalt",         log_cguias_falt.getNumguiaf());
                cstmt.setString("@numncred",        log_cguias_falt.getNumncred());
                cstmt.setString("@producto",        log_cguias_falt.getProducto());
                cstmt.setInt("@cantfact",           log_cguias_falt.getCantfact());
                cstmt.setInt("@cantfalt",           log_cguias_falt.getCantfalt());
                cstmt.setInt("@cantdesp",           log_cguias_falt.getCantdesp());
                cstmt.setInt("@id_unidad",          log_cguias_falt.getId_unidad());
                cstmt.execute();

                // Auditar el proceso
                auditar(log_cguias_falt.getNumrela() + "", mensj);

                connection.commit();

                return true;
            } else {
                System.out.println("Error: Connexion no activa");
                throw new Exception("Error de Conexion con la BD");
            }
        } catch (Exception e) {
            connection.rollback();
            StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
            Tools.getErrorMessage(stacktrace, "Error = " + e);
            throw e;
        } finally {
            connection.close();
        }
    }
    /**
     * @author MITM
     * @param operacion Determina el Proceso que se va a ejecutar 1 INSERT, 2
     * UPDATE
     * @param log_cguias_dev
     * @param pos
     * @return
     * @throws SQLException
     * @throws Exception
     */
    public boolean save_log_CGuias_dev(
            log_CGuias_falt_dv log_cguias_dev, int operacion, int pos) throws SQLException, Exception {

        BdInterface bd = ConnBdType.open(ConnBdType.SqlServer);
        connection = bd.open();
        try {
            if (connection != null) {
                //Inicia Transaccion 
                connection.setAutoCommit(false);
                StringBuilder sql_rela = new StringBuilder();            
                StringBuilder sql_data = new StringBuilder();
                String mensj = "";

                switch (operacion) {
                    case 1:
                        sql_rela.append("{call sp_ins_log_cguias_numrela_dev(?)}");
                        sql_data.append("{call sp_ins_log_cguias_dev(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}");
                        mensj = "Nueva log_CGuias_dev:";
                        break;
                    case 2:
                        log_cguias_dev.setNumdev(String.valueOf(Datos.getNumRel_Dev()));

                        sql_data.append("{call sp_upd_log_cguias_dev(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}");
                        mensj = "Actualizando log_CGuias_dev:";
                        break;
                }
                CallableStatement cstmt = null;                           
                if (pos == 0){
                    /**
                     * Busqueda NumRela_Dev
                     */
                    if (operacion == 1){
                        cstmt = connection.prepareCall(sql_rela.toString());
                        cstmt.registerOutParameter("numrela"    , java.sql.Types.DECIMAL);
                        cstmt.execute();            
                        log_cguias_dev.setNumdev(cstmt.getString("numrela"));
                        Datos.setNumRel_Dev(cstmt.getString("numrela"));
                    }
                }
                cstmt = connection.prepareCall(sql_data.toString());
                cstmt.setString("@numrela",         log_cguias_dev.getNumrela());
                cstmt.setDouble("@numorden",        pos + 1);
                cstmt.setDate("@fecha",             log_cguias_dev.getFec_carga());
                cstmt.setString("@numdev",          log_cguias_dev.getNumdev());
                cstmt.setString("@numdoc",          log_cguias_dev.getNumdoc());
                cstmt.setString("@id_personal",     log_cguias_dev.getCheq_pta());
                cstmt.setString("@producto",        log_cguias_dev.getProducto());
                cstmt.setInt("@id_motivo",          log_cguias_dev.getId_motivo());
                cstmt.setInt("@cantfact",           log_cguias_dev.getCantfact());
                cstmt.setInt("@cantdev",            log_cguias_dev.getCantdev());
                cstmt.setInt("@cantdesp",           log_cguias_dev.getCantdesp());
                cstmt.setInt("@id_unidad",          log_cguias_dev.getId_unidad());
                cstmt.setDouble("@pmarcado",        log_cguias_dev.getPre_marc());
                cstmt.setDouble("@pfacturado",      log_cguias_dev.getPre_fact());
                cstmt.setInt("@id_almacen",         log_cguias_dev.getId_almacen());
                cstmt.setString("@observ",          log_cguias_dev.getObserv());
                cstmt.setString("@anulada",         log_cguias_dev.getStat_reg());

                cstmt.execute();

                // Auditar el proceso
                auditar(log_cguias_dev.getNumrela()+ "", mensj);

                connection.commit();

                return true;
            } else {
                System.out.println("Error: Connexion no activa");
                throw new Exception("Error de Conexion con la BD");
            }
        } catch (Exception e) {
            connection.rollback();
            StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
            Tools.getErrorMessage(stacktrace, "Error = " + e);
            throw e;
        } finally {
            connection.close();
        }
    }
    /**
     * @author MITM
     * @param operacion Determina el Proceso que se va a ejecutar 1 INSERT, 2
     * UPDATE
     * @param log_cguias
     * @param pos
     * @return
     * @throws SQLException
     * @throws Exception
     */
    public boolean save_log_CGuias_caja(
            log_CGuias log_cguias, int operacion, int pos) throws SQLException, Exception {

        BdInterface bd = ConnBdType.open(ConnBdType.SqlServer);
        connection = bd.open();
        try {
            if (connection != null) {
                //Inicia Transaccion 
                connection.setAutoCommit(false);
                StringBuilder sql_rela = new StringBuilder();            
                StringBuilder sql_data = new StringBuilder();
                String mensj = "";

                switch (operacion) {
                    case 1:
                        sql_rela.append("{call sp_ins_log_cguias_numrela_caj(?)}");
                        sql_data.append("{call sp_ins_log_cguias_caja(?, ?, ?, ?)}");
                        mensj = "Nueva log_CGuias_caja:";
                        break;
                    case 2:
                        log_cguias.setNumcaja(String.valueOf(Datos.getNumRel_Caj()));

                        sql_data.append("{call sp_upd_log_cguias_caja(?, ?, ?, ?)}");
                        mensj = "Actualizando log_CGuias_caja:";
                        break;
                }
                CallableStatement cstmt = null;                           
                if (pos == 0){
                    /**
                     * Busqueda NumRela_Caja
                     */
                    if (operacion == 1){
                        cstmt = connection.prepareCall(sql_rela.toString());
                        cstmt.registerOutParameter("numrela"    , java.sql.Types.DECIMAL);
                        cstmt.execute();            
                        log_cguias.setNumcaja(cstmt.getString("numrela"));
                        Datos.setNumRel_Caj(cstmt.getString("numrela"));
                    }
                }
                cstmt = connection.prepareCall(sql_data.toString());
                cstmt.setString("@numcaja",         log_cguias.getNumcaja());
                cstmt.setDouble("@numorden",        pos + 1);
                cstmt.setString("@numguia",         log_cguias.getNumguia());
                cstmt.setDate("@fecha",             log_cguias.getFeccaja());
                cstmt.execute();

                // Auditar el proceso
                auditar(log_cguias.getNumcaja()+ "", mensj);

                connection.commit();

                return true;
            } else {
                System.out.println("Error: Connexion no activa");
                throw new Exception("Error de Conexion con la BD");
            }
        } catch (Exception e) {
            connection.rollback();
            StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
            Tools.getErrorMessage(stacktrace, "Error = " + e);
            throw e;
        } finally {
            connection.close();
        }
    }
    /**
     * @author MITM
     * @return 
     * @throws java.sql.SQLException 
     */
    public log_CGuias[] load_log_CGuias() throws SQLException {
         try{
            BdInterface bd = ConnBdType.open(ConnBdType.SqlServer);
            connection = bd.open();
        
            StringBuilder sqlProc = new StringBuilder();
            sqlProc.append("{call xxx}");
            
            if (connection != null){
               CallableStatement cstmt = connection.prepareCall(sqlProc.toString());
               ResultSet result = cstmt.executeQuery();            
               
               Vector<log_CGuias> vector = new Vector<>();
               
               while(result.next()) {
                   log_CGuias log_cguias = new log_CGuias(result);
                   vector.add(log_cguias);
               }
               
               log_CGuias[] log_cguias = new log_CGuias[vector.size()];
               for (int i = 0; i < vector.size(); i++) {
                   log_cguias[i] = vector.elementAt(i);                    
               }
               return log_cguias;
            }else{
                System.out.println("Error: Connexion no activa");
            }
        }catch(SQLException e){            
            StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
            Tools.getErrorMessage(stacktrace,"Error = " + e); 
        }finally{
            connection.close();
        }
        return null;
    }
    /**
     * @author MITM
     * @param find1
     * @param find2
     * @param param
     * @param rows
     * @return 
     * @throws java.sql.SQLException 
     */
    public log_CGuias[] find_log_CGuias(String find1, String find2, String param, int rows) throws SQLException {
        try{
            BdInterface bd = ConnBdType.open(ConnBdType.SqlServer);
            connection = bd.open();
        
            StringBuilder sqlProc = new StringBuilder();
            switch(param){
                case "nrela":
                    sqlProc.append("{call sp_get_log_cguias_find_nrela(?, ?, ?)}");
                    break;
                case "nguia":
                    sqlProc.append("{call sp_get_log_cguias_find_nguia(?, ?, ?)}");
                    break;
                case "nfact":
                    sqlProc.append("{call sp_get_log_cguias_find_nfact(?, ?, ?)}");
                    break;
                case "nfcarga":
                    sqlProc.append("{call sp_get_log_cguias_find_nfca(?, ?, ?)}");
                    break;
                case "ncaja":
                    sqlProc.append("{call sp_get_log_cguias_find_ncaja(?, ?, ?)}");
                    break;
                case "ncred":
                    sqlProc.append("{call sp_get_log_cguias_find_ncred(?, ?, ?)}");
                    break;
                case "cprod":
                    sqlProc.append("{call sp_get_log_cguias_find_prod(?, ?, ?)}");
                    break;
                case "vehi":
                    sqlProc.append("{call sp_get_log_cguias_find_vehi(?, ?, ?)}");
                    break;
                case "chof":
                    sqlProc.append("{call sp_get_log_cguias_find_chof(?, ?, ?)}");
                    break;
                case "ayud":
                    sqlProc.append("{call sp_get_log_cguias_find_ayud(?, ?, ?)}");
                    break;
                case "cheq":
                    sqlProc.append("{call sp_get_log_cguias_find_cheq(?, ?, ?)}");
                    break;
                case "sruta":
                    sqlProc.append("{call sp_get_log_cguias_find_srut(?, ?, ?)}");
                    break;
            }
            
            if (connection != null){
               CallableStatement cstmt = connection.prepareCall(sqlProc.toString());
               cstmt.setString("@find1"  , find1 );
               cstmt.setString("@find2"  , find2 );
               cstmt.setInt("@rows"  , rows );
               ResultSet result = cstmt.executeQuery();            
               Vector<log_CGuias> vector = new Vector<>();
               
               while(result.next()) {
                   log_CGuias log_cguias = new log_CGuias(result);
                   vector.add(log_cguias);
               }
               
               log_CGuias[] log_cguias = new log_CGuias[vector.size()];
               for (int i = 0; i < vector.size(); i++) {
                   log_cguias[i] = vector.elementAt(i);                    
               }
               
               return log_cguias;
            }else{
                System.out.println("Error: Connexion no activa");
            }
        }catch(SQLException e){            
            StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
            Tools.getErrorMessage(stacktrace,"Error = " + e); 
        }finally{
            connection.close();
        }
        return null;
    }
    /**
     * @author MITM
     * @param numrela
     * @return 
     * @throws java.sql.SQLException 
     */
    public log_CGuias_perm[] find_log_CGuias_perm(String numrela) throws SQLException {
        try{
            BdInterface bd = ConnBdType.open(ConnBdType.SqlServer);
            connection = bd.open();
        
            StringBuilder sqlProc = new StringBuilder();
            sqlProc.append("{call sp_get_log_cguias_find_perm(?)}");
            
            if (connection != null){
               CallableStatement cstmt = connection.prepareCall(sqlProc.toString());
               cstmt.setString("@numrela"  , numrela );
               ResultSet result = cstmt.executeQuery();            
               Vector<log_CGuias_perm> vector = new Vector<>();
               
               while(result.next()) {
                   log_CGuias_perm log_cguias_perm = new log_CGuias_perm(result);
                   vector.add(log_cguias_perm);
               }
               
               log_CGuias_perm[] log_cguias_perm = new log_CGuias_perm[vector.size()];
               for (int i = 0; i < vector.size(); i++) {
                   log_cguias_perm[i] = vector.elementAt(i);                    
               }
               
               return log_cguias_perm;
            }else{
                System.out.println("Error: Connexion no activa");
            }
        }catch(SQLException e){            
            StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
            Tools.getErrorMessage(stacktrace,"Error = " + e); 
        }finally{
            connection.close();
        }
        return null;
    }
    /**
     * @author MITM
     * @param numrela
     * @return 
     * @throws java.sql.SQLException 
     */
    public log_CGuias_falt_cg[] find_log_CGuias_fcar(String numrela) throws SQLException {
        try{
            BdInterface bd = ConnBdType.open(ConnBdType.SqlServer);
            connection = bd.open();
        
            StringBuilder sqlProc = new StringBuilder();
            sqlProc.append("{call sp_get_log_cguias_find_fcar(?)}");
            
            if (connection != null){
               CallableStatement cstmt = connection.prepareCall(sqlProc.toString());
               cstmt.setString("@numrela"  , numrela );
               ResultSet result = cstmt.executeQuery();            
               Vector<log_CGuias_falt_cg> vector = new Vector<>();
               
               while(result.next()) {
                   log_CGuias_falt_cg log_cguias_fcar = new log_CGuias_falt_cg(result);
                   vector.add(log_cguias_fcar);
               }
               
               log_CGuias_falt_cg[] log_cguias_fcar = new log_CGuias_falt_cg[vector.size()];
               for (int i = 0; i < vector.size(); i++) {
                   log_cguias_fcar[i] = vector.elementAt(i);                    
               }
               
               return log_cguias_fcar;
            }else{
                System.out.println("Error: Connexion no activa");
            }
        }catch(SQLException e){            
            StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
            Tools.getErrorMessage(stacktrace,"Error = " + e); 
        }finally{
            connection.close();
        }
        return null;
    }
    /**
     * @author MITM
     * @param numrela
     * @return 
     * @throws java.sql.SQLException 
     */
    public log_CGuias_falt_dv[] find_log_CGuias_fdev(String numrela) throws SQLException {
        try{
            BdInterface bd = ConnBdType.open(ConnBdType.SqlServer);
            connection = bd.open();
        
            StringBuilder sqlProc = new StringBuilder();
            sqlProc.append("{call sp_get_log_cguias_find_fdev(?)}");
            
            if (connection != null){
               CallableStatement cstmt = connection.prepareCall(sqlProc.toString());
               cstmt.setString("@numrela"  , numrela );
               ResultSet result = cstmt.executeQuery();            
               Vector<log_CGuias_falt_dv> vector = new Vector<>();
               
               while(result.next()) {
                   log_CGuias_falt_dv log_cguias_fdev = new log_CGuias_falt_dv(result);
                   vector.add(log_cguias_fdev);
               }
               
               log_CGuias_falt_dv[] log_cguias_fdev = new log_CGuias_falt_dv[vector.size()];
               for (int i = 0; i < vector.size(); i++) {
                   log_cguias_fdev[i] = vector.elementAt(i);                    
               }
               
               return log_cguias_fdev;
            }else{
                System.out.println("Error: Connexion no activa");
            }
        }catch(SQLException e){            
            StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
            Tools.getErrorMessage(stacktrace,"Error = " + e); 
        }finally{
            connection.close();
        }
        return null;
    }
    /**
     * @author MITM
     * @param numrela
     * @param param
     * @return 
     * @throws java.sql.SQLException 
     */
    public log_CGuias_falt_dv[] print_log_CGuias_fdev(String numrela, int param) throws SQLException {
        try{
            BdInterface bd = ConnBdType.open(ConnBdType.SqlServer);
            connection = bd.open();
        
            StringBuilder sqlProc = new StringBuilder();
            sqlProc.append("{call sp_get_log_cguias_print_fdev(?, ?)}");
            
            if (connection != null){
               CallableStatement cstmt = connection.prepareCall(sqlProc.toString());
               cstmt.setString("@numrela"   , numrela );
               cstmt.setInt("@numhyper"     , param );
               ResultSet result = cstmt.executeQuery();            
               Vector<log_CGuias_falt_dv> vector = new Vector<>();
               
               while(result.next()) {
                   log_CGuias_falt_dv log_cguias_fdev = new log_CGuias_falt_dv(result);
                   vector.add(log_cguias_fdev);
               }
               
               log_CGuias_falt_dv[] log_cguias_fdev = new log_CGuias_falt_dv[vector.size()];
               for (int i = 0; i < vector.size(); i++) {
                   log_cguias_fdev[i] = vector.elementAt(i);                    
               }
               
               return log_cguias_fdev;
            }else{
                System.out.println("Error: Connexion no activa");
            }
        }catch(SQLException e){            
            StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
            Tools.getErrorMessage(stacktrace,"Error = " + e); 
        }finally{
            connection.close();
        }
        return null;
    }

    
    /***************************************************************************/
    /****************************** PRINT SCREEN *******************************/
    /***************************************************************************/
    
    /**
     * @author MITM
     * @param idscreen
     * @param idobjeto
     * @return 
     * @throws java.sql.SQLException 
     */
    public ItemPrintScreen[] find_PrintScreen(int idscreen, String idobjeto) throws SQLException {
         try{
            BdInterface bd = ConnBdType.open(ConnBdType.SqlServer);
            connection = bd.open();
        
            StringBuilder sqlProc = new StringBuilder();
            sqlProc.append("{call sp_get_menu_print(?,?)}");
            
            if (connection != null){
               CallableStatement cstmt = connection.prepareCall(sqlProc.toString());
               cstmt.setInt("@idscreen"  , idscreen );
               cstmt.setString("@idobjeto"  , idobjeto );
               ResultSet result = cstmt.executeQuery();            
               
               Vector<ItemPrintScreen> vector = new Vector<>();
               
               while(result.next()) {
                   ItemPrintScreen printscreen = new ItemPrintScreen(result);
                   vector.add(printscreen);
               }
               
               ItemPrintScreen[] printscreen = new ItemPrintScreen[vector.size()];
               for (int i = 0; i < vector.size(); i++) {
                   printscreen[i] = vector.elementAt(i);                    
               }
               
               return printscreen;
            }else{
                System.out.println("Error: Connexion no activa");
            }
        }catch(SQLException e){            
            StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
            Tools.getErrorMessage(stacktrace,"Error = " + e); 
        }finally{
            connection.close();
        }
        return null;
    }
    
    
    /***************************************************************************/
    /************************** CGUIAS_GLOMAR_PRICE ****************************/
    /***************************************************************************/
    
    /**
     * @author MITM
     * @return 
     * @throws java.sql.SQLException 
     */
    public log_CGuias_Glomar_price[] load_Glomar_price() throws SQLException {
         try{
            BdInterface bd = ConnBdType.open(ConnBdType.SqlServer);
            connection = bd.open();
        
            StringBuilder sqlProc = new StringBuilder();
            sqlProc.append("{call sp_get_log_cguias_glomar_price}");
            
            if (connection != null){
               CallableStatement cstmt = connection.prepareCall(sqlProc.toString());
               ResultSet result = cstmt.executeQuery();            
               
               Vector<log_CGuias_Glomar_price> vector = new Vector<>();
               
               while(result.next()) {
                   log_CGuias_Glomar_price glomar_price = new log_CGuias_Glomar_price(result);
                   vector.add(glomar_price);
               }
               
               log_CGuias_Glomar_price[] glomar_price = new log_CGuias_Glomar_price[vector.size()];
               for (int i = 0; i < vector.size(); i++) {
                   glomar_price[i] = vector.elementAt(i);                    
               }
               return glomar_price;
            }else{
                System.out.println("Error: Connexion no activa");
            }
        }catch(SQLException e){            
            StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
            Tools.getErrorMessage(stacktrace,"Error = " + e); 
        }finally{
            connection.close();
        }
        return null;
    }
    /**
     * @author MITM
     * @param find
     * @return 
     * @throws java.sql.SQLException 
     */
    public log_CGuias_Glomar_price[] find_Glomar_price(String find) throws SQLException {
        try{
            BdInterface bd = ConnBdType.open(ConnBdType.SqlServer);
            connection = bd.open();
        
            StringBuilder sqlProc = new StringBuilder();
            sqlProc.append("{call (?)}");
            
            if (connection != null){
               CallableStatement cstmt = connection.prepareCall(sqlProc.toString());
               cstmt.setString("@find"  , find );
               ResultSet result = cstmt.executeQuery();            
               Vector<log_CGuias_Glomar_price> vector = new Vector<>();
               
               while(result.next()) {
                   log_CGuias_Glomar_price glomar_price = new log_CGuias_Glomar_price(result);
                   vector.add(glomar_price);
               }
               
               log_CGuias_Glomar_price[] glomar_price = new log_CGuias_Glomar_price[vector.size()];
               for (int i = 0; i < vector.size(); i++) {
                   glomar_price[i] = vector.elementAt(i);                    
               }
               
               return glomar_price;
            }else{
                System.out.println("Error: Connexion no activa");
            }
        }catch(SQLException e){            
            StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
            Tools.getErrorMessage(stacktrace,"Error = " + e); 
        }finally{
            connection.close();
        }
        return null;
    }
    /**
     * @author MITM
     * @param operacion Determina el Proceso que se va a ejecutar 1 INSERT, 2 UPDATE
     * @param glomar_price
     * @return
     * @throws SQLException
     * @throws Exception 
     */
    public boolean save_Glomar_price(int operacion, log_CGuias_Glomar_price glomar_price) throws SQLException, Exception {
        
        BdInterface bd = ConnBdType.open(ConnBdType.SqlServer);
        connection = bd.open();        
        try{
         if (connection != null){
            //Inicia Transaccion 
            connection.setAutoCommit(false);
            StringBuilder sql = new StringBuilder();            
            String mensj = "";
            
            switch(operacion){
                case 1:
//                    sql.append("{call sp_ins_role(?, ?)}");
                    mensj = "Nuevo Glomar_price:";
                    break;
                case 2:
//                    sql.append("{call sp_upd_role_basic(?, ?, ?)}");
                    mensj = "Actualizando Glomar_price:";
                    break;
            }
            CallableStatement cstmt = connection.prepareCall(sql.toString());
            switch(operacion){
                case 1:
//                    cstmt.setString("@nombre"       , glomar_price.getNombre().toUpperCase());
                    break;
                case 2:
                    cstmt.setString("@id_role"      , glomar_price.getCodigo());
//                    cstmt.setString("@nombre"       , glomar_price.getNombre().toUpperCase());
                    break;
            }
            cstmt.execute();            
            // Auditar el proceso
            auditar(glomar_price.getCodigo()+ "",mensj);
            
            connection.commit();
            
            return true;
         }else{
            System.out.println("Error: Connexion no activa");
            throw new Exception("Error de Conexion con la BD");
         }
        }catch(Exception e){            
            connection.rollback();   
            StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
            Tools.getErrorMessage(stacktrace,"Error = " + e);    
            throw e;
        }finally{
            connection.close();
        }
    }
    /***************************************************************************/
    /************************** CGUIAS_GLOMAR_INVOICE ****************************/
    /***************************************************************************/
    
    /**
     * @author MITM
     * @param year
     * @param month
     * @param quality
     * @param date1
     * @param date2
     * @return 
     * @throws java.sql.SQLException 
     */
    public log_CGuias_Glomar_invoice[] find_Glomar_invoice(int year, int month, int quality, String date1, String date2) throws SQLException {
        try{
            BdInterface bd = ConnBdType.open(ConnBdType.SqlServer);
            connection = bd.open();
        
            StringBuilder sqlProc = new StringBuilder();
            sqlProc.append("{call sp_get_log_cguias_glomar_invoice(?, ?, ?, ?, ?)}");
            
            if (connection != null){
               CallableStatement cstmt = connection.prepareCall(sqlProc.toString());
               cstmt.setInt("@ano"          , year );
               cstmt.setInt("@mes"          , month );
               cstmt.setInt("@clasif"       , quality );
               cstmt.setString("@fecha1"    , date1 );
               cstmt.setString("@fecha2"    , date2 );
               ResultSet result = cstmt.executeQuery();            
               Vector<log_CGuias_Glomar_invoice> vector = new Vector<>();
               
               while(result.next()) {
                   log_CGuias_Glomar_invoice glomar_invoice = new log_CGuias_Glomar_invoice(result);
                   vector.add(glomar_invoice);
               }
               
               log_CGuias_Glomar_invoice[] glomar_invoice = new log_CGuias_Glomar_invoice[vector.size()];
               for (int i = 0; i < vector.size(); i++) {
                   glomar_invoice[i] = vector.elementAt(i);                    
               }
               
               return glomar_invoice;
            }else{
                System.out.println("Error: Connexion no activa");
            }
        }catch(SQLException e){            
            StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
            Tools.getErrorMessage(stacktrace,"Error = " + e); 
        }finally{
            connection.close();
        }
        return null;
    }
    /***************************************************************************/
    /************************** UPFILE RETENCIONES *****************************/
    /***************************************************************************/    

    /**
     * @author MITM
     * @return 
     * @throws java.sql.SQLException 
     */
    public UploadExcelFile[] load_UploadExcelFile() throws SQLException {
         try{
            BdInterface bd = ConnBdType.open(ConnBdType.SqlServer);
            connection = bd.open();
        
            StringBuilder sqlProc = new StringBuilder();
            sqlProc.append("{call sp_get_log_cguias_glomar_price}");
            
            if (connection != null){
               CallableStatement cstmt = connection.prepareCall(sqlProc.toString());
               ResultSet result = cstmt.executeQuery();            
               
               Vector<UploadExcelFile> vector = new Vector<>();
               
               while(result.next()) {
                   UploadExcelFile sqlexcel = new UploadExcelFile(result);
                   vector.add(sqlexcel);
               }
               
               UploadExcelFile[] sqlexcel = new UploadExcelFile[vector.size()];
               for (int i = 0; i < vector.size(); i++) {
                   sqlexcel[i] = vector.elementAt(i);                    
               }
               return sqlexcel;
            }else{
                System.out.println("Error: Connexion no activa");
            }
        }catch(SQLException e){            
            StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
            Tools.getErrorMessage(stacktrace,"Error = " + e); 
        }finally{
            connection.close();
        }
        return null;
    }
    /**
     * @author MITM
     * @param find
     * @return 
     * @throws java.sql.SQLException 
     */
    public UploadExcelFile[] find_UploadExcelFile(String find) throws SQLException {
        try{
            BdInterface bd = ConnBdType.open(ConnBdType.SqlServer);
            connection = bd.open();
        
            StringBuilder sqlProc = new StringBuilder();
            sqlProc.append("{call [sp_get_sen_ret_prov](?)}");
            
            if (connection != null){
               CallableStatement cstmt = connection.prepareCall(sqlProc.toString());
               cstmt.setString("@find"  , find );
               ResultSet result = cstmt.executeQuery();            
               Vector<UploadExcelFile> vector = new Vector<>();
               
               while(result.next()) {
                   UploadExcelFile sqlexcel = new UploadExcelFile(result);
                   vector.add(sqlexcel);
               }
               
               UploadExcelFile[] sqlexcel = new UploadExcelFile[vector.size()];
               for (int i = 0; i < vector.size(); i++) {
                   sqlexcel[i] = vector.elementAt(i);                    
               }
               
               return sqlexcel;
            }else{
                System.out.println("Error: Connexion no activa");
            }
        }catch(SQLException e){            
            StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
            Tools.getErrorMessage(stacktrace,"Error = " + e); 
        }finally{
            connection.close();
        }
        return null;
    }
    /**
     * @author MITM
     * @param operacion Determina el Proceso que se va a ejecutar 1 INSERT, 2
     * UPDATE
     * @param sqlexcel
     * @param pos
     * @return
     * @throws SQLException
     * @throws Exception
     */
    public boolean save_Upfile_Retenciones(
            UploadExcelFile sqlexcel, int operacion, int pos) throws SQLException, Exception {

        BdInterface bd = ConnBdType.open(ConnBdType.SqlServer);
        connection = bd.open();
        try {
            if (connection != null) {
                //Inicia Transaccion 
                connection.setAutoCommit(false);
                StringBuilder sql_data = new StringBuilder();
                String mensj = "";

                switch (operacion) {
                    case 1:
                        sql_data.append("{call sp_ins_sen_ret_prov(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}");
                        mensj = "Nuevo Upfile_Retenciones:";
                        break;
                    case 2:
                        sql_data.append("{call sp_ins_sen_ret_prov(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}");
//                        sql_data.append("{call sp_upd_sen_ret_prov(?, ?, ?)}");
                        mensj = "Actualizando Upfile_Retenciones:";
                        break;
                }
                CallableStatement cstmt = null;                           
                cstmt = connection.prepareCall(sql_data.toString());
                cstmt.setInt("@ano",                    sqlexcel.getAno());
                cstmt.setInt("@mes",                    sqlexcel.getMes());
                cstmt.setString("@archivo",             sqlexcel.getExcelfile());
                cstmt.setInt("@numorden",               pos + 1);
                cstmt.setString("@rif_agente",          sqlexcel.getRifAgente());
                cstmt.setString("@nombre_agente",       sqlexcel.getNombAgente());
                cstmt.setDate("@fecha",                 sqlexcel.getFechaDoc());
                cstmt.setString("@tipo_doc",            sqlexcel.getTipoDoc());
                cstmt.setDouble("@mto_doc1",            sqlexcel.getMtoDoc1());
                cstmt.setDouble("@mto_doc2",            sqlexcel.getMtoDoc2());
                cstmt.setDouble("@mto_ret1",            sqlexcel.getMtoRet1());
                cstmt.setDouble("@mto_ret2",            sqlexcel.getMtoRet2());
                cstmt.setDouble("@mto_exe1",            sqlexcel.getMtoExe1());
                cstmt.setDouble("@mto_exe2",            sqlexcel.getMtoExe2());
                cstmt.setString("@nro_doc",             sqlexcel.getNroDoc());
                cstmt.setString("@nro_control",         sqlexcel.getNroControl());
                cstmt.setString("@nro_doc_afec",        sqlexcel.getNroDocAfect());
                cstmt.setDouble("@alicuota",            sqlexcel.getAlicuota());
                cstmt.setInt("@status",                 sqlexcel.getStatus());
                cstmt.execute();

                // Auditar el proceso
                auditar(sqlexcel.getExcelfile()+ "", mensj);

                connection.commit();

                return true;
            } else {
                System.out.println("Error: Connexion no activa");
                throw new Exception("Error de Conexion con la BD");
            }
        } catch (Exception e) {
            connection.rollback();
            StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
            Tools.getErrorMessage(stacktrace, "Error = " + e);
            throw e;
        } finally {
            connection.close();
        }
    }
    /***************************************************************************/
    /********************************* ORDERS **********************************/
    /***************************************************************************/
    
    /**
     * @author MITM
     * @param producto
     * @param proveedor
     * @return 
     * @throws java.sql.SQLException 
     */
    public Fxp_Inventa[] find_inventa_prod_prov(String producto, String proveedor) throws SQLException {
        try{
            BdInterface bd = ConnBdType.open(ConnBdType.SqlServer);
            connection = bd.open();
        
            StringBuilder sqlProc = new StringBuilder();
            sqlProc.append("{call sp_get_fxp_inventa_find(?, ?)}");
            
            if (connection != null){
               CallableStatement cstmt = connection.prepareCall(sqlProc.toString());
               cstmt.setString("@producto"    , producto );
               cstmt.setString("@proveedor"    , proveedor );
               ResultSet result = cstmt.executeQuery();            
               Vector<Fxp_Inventa> vector = new Vector<>();
               
               while(result.next()) {
                   Fxp_Inventa inventa = new Fxp_Inventa(result);
                   vector.add(inventa);
               }
               
               Fxp_Inventa[] inventa = new Fxp_Inventa[vector.size()];
               for (int i = 0; i < vector.size(); i++) {
                   inventa[i] = vector.elementAt(i);                    
               }
               
               return inventa;
            }else{
                System.out.println("Error: Connexion no activa");
            }
        }catch(SQLException e){            
            StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
            Tools.getErrorMessage(stacktrace,"Error = " + e); 
        }finally{
            connection.close();
        }
        return null;
    }
    /**
     * @author MITM
     * @param id
     * @return 
     * @throws java.sql.SQLException 
     */
    public Orders[] find_orders(String id) throws SQLException {
        try{
            BdInterface bd = ConnBdType.open(ConnBdType.SqlServer);
            connection = bd.open();
        
            StringBuilder sqlProc = new StringBuilder();
            sqlProc.append("{call sp_get_ord_orden_compra(?)}");
            
            if (connection != null){
               CallableStatement cstmt = connection.prepareCall(sqlProc.toString());
               cstmt.setString("@idorden"  , id );
               ResultSet result = cstmt.executeQuery();            
               Vector<Orders> vector = new Vector<>();
               
               while(result.next()) {
                   Orders orders = new Orders(result);
                   vector.add(orders);
               }
               
               Orders[] orders = new Orders[vector.size()];
               for (int i = 0; i < vector.size(); i++) {
                   orders[i] = vector.elementAt(i);                    
               }
               
               return orders;
            }else{
                System.out.println("Error: Connexion no activa");
            }
        }catch(SQLException e){            
            StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
            Tools.getErrorMessage(stacktrace,"Error = " + e); 
        }finally{
            connection.close();
        }
        return null;
    }
    /**
     * @author MITM
     * @param id
     * @return 
     * @throws java.sql.SQLException 
     */
    public Orders[] find_orders_print(String id) throws SQLException {
        try{
            BdInterface bd = ConnBdType.open(ConnBdType.SqlServer);
            connection = bd.open();
        
            StringBuilder sqlProc = new StringBuilder();
            sqlProc.append("{call sp_get_ord_orden_compra_print(?)}");
            
            if (connection != null){
               CallableStatement cstmt = connection.prepareCall(sqlProc.toString());
               cstmt.setString("@idorden"  , id );
               ResultSet result = cstmt.executeQuery();            
               Vector<Orders> vector = new Vector<>();
               
               while(result.next()) {
                   Orders orders = new Orders(result);
                   vector.add(orders);
               }
               
               Orders[] orders = new Orders[vector.size()];
               for (int i = 0; i < vector.size(); i++) {
                   orders[i] = vector.elementAt(i);                    
               }
               
               return orders;
            }else{
                System.out.println("Error: Connexion no activa");
            }
        }catch(SQLException e){            
            StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
            Tools.getErrorMessage(stacktrace,"Error = " + e); 
        }finally{
            connection.close();
        }
        return null;
    }
    /**
     * @author MITM
     * @param id
     * @return 
     * @throws java.sql.SQLException 
     */
    public Orders[] find_orders_id(String id) throws SQLException {
        try{
            BdInterface bd = ConnBdType.open(ConnBdType.SqlServer);
            connection = bd.open();
        
            StringBuilder sqlProc = new StringBuilder();
            sqlProc.append("{call sp_get_ord_orden_compra_find_id(?)}");
            
            if (connection != null){
               CallableStatement cstmt = connection.prepareCall(sqlProc.toString());
               cstmt.setString("@idorden"  , id );
               ResultSet result = cstmt.executeQuery();            
               Vector<Orders> vector = new Vector<>();
               
               while(result.next()) {
                   Orders orders = new Orders(result);
                   vector.add(orders);
               }
               
               Orders[] orders = new Orders[vector.size()];
               for (int i = 0; i < vector.size(); i++) {
                   orders[i] = vector.elementAt(i);                    
               }
               
               return orders;
            }else{
                System.out.println("Error: Connexion no activa");
            }
        }catch(SQLException e){            
            StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
            Tools.getErrorMessage(stacktrace,"Error = " + e); 
        }finally{
            connection.close();
        }
        return null;
    }
    /**
     * @author MITM
     * @param id1
     * @param id2
     * @return 
     * @throws java.sql.SQLException 
     */
    public Orders[] find_orders_ids(String id1, String id2) throws SQLException {
        try{
            BdInterface bd = ConnBdType.open(ConnBdType.SqlServer);
            connection = bd.open();
        
            StringBuilder sqlProc = new StringBuilder();
            sqlProc.append("{call sp_get_ord_orden_compra_find_ids(?, ?)}");
            
            if (connection != null){
               CallableStatement cstmt = connection.prepareCall(sqlProc.toString());
               cstmt.setString("@idorden1"  , id1 );
               cstmt.setString("@idorden2"  , id2 );
               ResultSet result = cstmt.executeQuery();            
               Vector<Orders> vector = new Vector<>();
               
               while(result.next()) {
                   Orders orders = new Orders(result);
                   vector.add(orders);
               }
               
               Orders[] orders = new Orders[vector.size()];
               for (int i = 0; i < vector.size(); i++) {
                   orders[i] = vector.elementAt(i);                    
               }
               
               return orders;
            }else{
                System.out.println("Error: Connexion no activa");
            }
        }catch(SQLException e){            
            StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
            Tools.getErrorMessage(stacktrace,"Error = " + e); 
        }finally{
            connection.close();
        }
        return null;
    }
    /**
     * @author MITM
     * @param date
     * @return 
     * @throws java.sql.SQLException 
     */
    public Orders[] find_orders_date(String date) throws SQLException {
        try{
            BdInterface bd = ConnBdType.open(ConnBdType.SqlServer);
            connection = bd.open();
        
            StringBuilder sqlProc = new StringBuilder();
            sqlProc.append("{call sp_get_ord_orden_compra_find_date(?)}");
            
            if (connection != null){
               CallableStatement cstmt = connection.prepareCall(sqlProc.toString());
               cstmt.setString("@date"  , date );
               ResultSet result = cstmt.executeQuery();            
               Vector<Orders> vector = new Vector<>();
               
               while(result.next()) {
                   Orders orders = new Orders(result);
                   vector.add(orders);
               }
               
               Orders[] orders = new Orders[vector.size()];
               for (int i = 0; i < vector.size(); i++) {
                   orders[i] = vector.elementAt(i);                    
               }
               
               return orders;
            }else{
                System.out.println("Error: Connexion no activa");
            }
        }catch(SQLException e){            
            StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
            Tools.getErrorMessage(stacktrace,"Error = " + e); 
        }finally{
            connection.close();
        }
        return null;
    }
    /**
     * @author MITM
     * @param rows
     * @return 
     * @throws java.sql.SQLException 
     */
    public Orders[] find_orders_all(int rows) throws SQLException {
        try{
            BdInterface bd = ConnBdType.open(ConnBdType.SqlServer);
            connection = bd.open();
        
            StringBuilder sqlProc = new StringBuilder();
            sqlProc.append("{call sp_get_ord_orden_compra_find_all(?)}");
            
            if (connection != null){
               CallableStatement cstmt = connection.prepareCall(sqlProc.toString());
               cstmt.setInt("@rows"  , rows );
               ResultSet result = cstmt.executeQuery();            
               Vector<Orders> vector = new Vector<>();
               
               while(result.next()) {
                   Orders orders = new Orders(result);
                   vector.add(orders);
               }
               
               Orders[] orders = new Orders[vector.size()];
               for (int i = 0; i < vector.size(); i++) {
                   orders[i] = vector.elementAt(i);                    
               }
               
               return orders;
            }else{
                System.out.println("Error: Connexion no activa");
            }
        }catch(SQLException e){            
            StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
            Tools.getErrorMessage(stacktrace,"Error = " + e); 
        }finally{
            connection.close();
        }
        return null;
    }
    /**
     * @author MITM
     * @param rows
     * @param find
     * @return 
     * @throws java.sql.SQLException 
     */
    public Orders[] find_orders_open(int rows, String find) throws SQLException {
        try{
            BdInterface bd = ConnBdType.open(ConnBdType.SqlServer);
            connection = bd.open();
        
            StringBuilder sqlProc = new StringBuilder();
            sqlProc.append("{call sp_get_ord_orden_compra_find_open(?)}");
            
            if (connection != null){
               CallableStatement cstmt = connection.prepareCall(sqlProc.toString());
               cstmt.setInt("@rows"  , rows );
               ResultSet result = cstmt.executeQuery();            
               Vector<Orders> vector = new Vector<>();
               
               while(result.next()) {
                   Orders orders = new Orders(result);
                   vector.add(orders);
               }
               
               Orders[] orders = new Orders[vector.size()];
               for (int i = 0; i < vector.size(); i++) {
                   orders[i] = vector.elementAt(i);                    
               }
               
               return orders;
            }else{
                System.out.println("Error: Connexion no activa");
            }
        }catch(SQLException e){            
            StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
            Tools.getErrorMessage(stacktrace,"Error = " + e); 
        }finally{
            connection.close();
        }
        return null;
    }
    /**
     * @author MITM
     * @param rows
     * @param find
     * @return 
     * @throws java.sql.SQLException 
     */
    public Orders[] find_orders_close(int rows, String find) throws SQLException {
        try{
            BdInterface bd = ConnBdType.open(ConnBdType.SqlServer);
            connection = bd.open();
        
            StringBuilder sqlProc = new StringBuilder();
            sqlProc.append("{call sp_get_ord_orden_compra_find_close(?)}");
            
            if (connection != null){
               CallableStatement cstmt = connection.prepareCall(sqlProc.toString());
               cstmt.setInt("@rows"  , rows );
               ResultSet result = cstmt.executeQuery();            
               Vector<Orders> vector = new Vector<>();
               
               while(result.next()) {
                   Orders orders = new Orders(result);
                   vector.add(orders);
               }
               
               Orders[] orders = new Orders[vector.size()];
               for (int i = 0; i < vector.size(); i++) {
                   orders[i] = vector.elementAt(i);                    
               }
               
               return orders;
            }else{
                System.out.println("Error: Connexion no activa");
            }
        }catch(SQLException e){            
            StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
            Tools.getErrorMessage(stacktrace,"Error = " + e); 
        }finally{
            connection.close();
        }
        return null;
    }
    /**
     * @author MITM
     * Valida si el groupsuppliername generado ya se encuentra asignado a un grupo en la BD
     * @param idorden valor a ser chequeado en la BD
     * @return true si el groupsupplier esta en uso, false si esta disponible el grupo
     * @throws java.sql.SQLException
     */
    public boolean check_orders(String idorden) throws SQLException {
        try{
            BdInterface bd = ConnBdType.open(ConnBdType.SqlServer);
            connection = bd.open();
        
            StringBuilder sqlProc = new StringBuilder();
            sqlProc.append("{call sp_get_ord_orden_compra_check(?,?)}");
            
            if (connection != null){
               CallableStatement cstmt = connection.prepareCall(sqlProc.toString());                           
               cstmt.setString("@idorden", idorden);
               cstmt.registerOutParameter("result", java.sql.Types.INTEGER);               
               cstmt.execute();
               if(cstmt.getInt("result") == 1) return true;               
            }else{
                System.out.println("Error: Connexion no activa");
            }
        }catch(SQLException e){            
            StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
            Tools.getErrorMessage(stacktrace,"Error = " + e); 
        }finally{
            connection.close();
        }
        return false;
    }
    /**
     * @author MITM
     * @param operacion Determina el Proceso que se va a ejecutar 1 INSERT, 2 UPDATE
     * @param orders
     * @param pos
     * @return
     * @throws SQLException
     * @throws Exception 
     */
    public boolean save_orders(
            Orders orders, int operacion, int pos) throws SQLException, Exception {
        
        BdInterface bd = ConnBdType.open(ConnBdType.SqlServer);
        connection = bd.open();        
        try{
            if (connection != null){
                //Inicia Transaccion 
                connection.setAutoCommit(false);
                StringBuilder sql_rela = new StringBuilder();            
                StringBuilder sql_data = new StringBuilder();            
                String mensj = "";

                switch(operacion){
                    case 1:
                        sql_rela.append("{call sp_ins_ord_numcompra(?)}");
                        sql_data.append("{call sp_ins_ord_orden_compra(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}");
                        mensj = "Nueva orde_compa:";
                        break;
                    case 2:
                        orders.setIdOrden(Integer.parseInt(Datos.getNumOrd_comp()));

                        sql_data.append("{call sp_upd_ord_orden_compra(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}");
                        mensj = "Actualizando orde_compa:";
                        break;
                }
                CallableStatement cstmt = null;
                if (pos == 0){
                    /**
                     * Busqueda idorden
                     */
                    if (operacion == 1){
                        cstmt = connection.prepareCall(sql_rela.toString());
                        cstmt.registerOutParameter("idorden"    , java.sql.Types.VARCHAR);
                        cstmt.execute();            
                        orders.setIdOrden(cstmt.getInt("idorden"));
                        Datos.setNumOrd_comp(cstmt.getString("idorden"));
                    }
                }

                cstmt = connection.prepareCall(sql_data.toString());
                cstmt.setInt("@idorden"                 , orders.getIdOrden());
                cstmt.setString("@staorden"             , orders.getStatord());
                cstmt.setDate("@fecha"                  , orders.getFecha());
                cstmt.setInt("@id_prov"                 , orders.getIdSupplier());
                cstmt.setString("@rif_prov"             , orders.getRif());
                cstmt.setString("@fdespacho"            , orders.getFdespacho());
                cstmt.setString("@ldespacho"            , orders.getLdespacho());
                cstmt.setString("@nota"                 , orders.getNota());
                cstmt.setString("@ucreacion"            , orders.getUsr_creacion());
                cstmt.setString("@usupervisa"           , orders.getUsr_supervisa());
                cstmt.setInt("@numorden"                , pos + 1);
                cstmt.setString("@producto"             , orders.getIdProducto());
                cstmt.setString("@codelpro"             , orders.getCodelpro());
                cstmt.setInt("@cantsol"                 , orders.getCant_sol());
                cstmt.setInt("@id_unidsol"              , orders.getId_unidsol());
                cstmt.setDouble("@costo"                , orders.getCosto());
                cstmt.setDouble("@preciosug"            , orders.getPreciosug());
                cstmt.setString("@observ"               , orders.getObserv());
                cstmt.setString("@anulada"              , orders.getStatdet());
                cstmt.execute();            

                // Auditar el proceso
                auditar(orders.getIdOrden()+ "",mensj);

                connection.commit();

                return true;
            }else{
                System.out.println("Error: Connexion no activa");
                throw new Exception("Error de Conexion con la BD");
            }
        }catch(Exception e){            
            connection.rollback();   
            StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
            Tools.getErrorMessage(stacktrace,"Error = " + e);    
            throw e;
        }finally{
            connection.close();
        }
    }
    /**
     * @author MITM
     * @param orders
     * @return 
     * @throws java.lang.Exception 
     */
    public boolean change_Orders(Orders orders) throws Exception {
        BdInterface bd = ConnBdType.open(ConnBdType.SqlServer);
        connection = bd.open();
        
        try{
         if (connection != null){
            //Inicia Transaccion 
            connection.setAutoCommit(false);
            
            StringBuilder sqlProc = new StringBuilder();
            sqlProc.append("{call sp_upd_prov_status(?,?)}");
            CallableStatement cstmt = connection.prepareCall(sqlProc.toString());                 
            cstmt.setInt("@idorden", orders.getIdOrden());
            int value = 0;
            if(orders.getStatenc()== 0){
                value = 1;
            }            
            cstmt.setInt("@status", value );
            cstmt.execute();            
            // Auditar el proceso
            auditar(orders.getIdOrden()+ "","deleteOrdenCompra:");
            
            connection.commit();
            
            return true;
         }else{
            System.out.println("Error: Connexion no activa");
            throw new Exception("Error de Conexion con la BD");
         }
        }catch(Exception e){            
            connection.rollback();            
            StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
            Tools.getErrorMessage(stacktrace,"Error = " + e);    
            throw e;
        }finally{
            connection.close();
        }
    }
    /***************************************************************************/
    /********************************* REPORTS *********************************/
    /***************************************************************************/
    /**
     * @author MITM
     * @param year1
     * @param year2
     * @param branch
     * @param date1
     * @param date2
     * @return 
     * @throws java.sql.SQLException 
     */
    public Dev_FanulSucursales[] find_Dev_FanulSucursales(int year1, int year2, String branch, String date1, String date2) throws SQLException {
        try{
            BdInterface bd = ConnBdType.open(ConnBdType.SqlServer);
            connection = bd.open();
        
            StringBuilder sqlProc = new StringBuilder();
            sqlProc.append("{call [sp_get_rep_dev_factanul_suc](?, ?, ?, ?, ?)}");
            
            if (connection != null){
               CallableStatement cstmt = connection.prepareCall(sqlProc.toString());
               cstmt.setInt("@ano1"         , year1 );
               cstmt.setInt("@ano2"         , year2 );
               cstmt.setString("@sucursal"  , branch );
               cstmt.setString("@fecha1"    , date1 );
               cstmt.setString("@fecha2"    , date2 );
               ResultSet result = cstmt.executeQuery();            
               Vector<Dev_FanulSucursales> vector = new Vector<>();
               
               while(result.next()) {
                   Dev_FanulSucursales sqlQuery = new Dev_FanulSucursales(result);
                   vector.add(sqlQuery);
               }
               
               Dev_FanulSucursales[] sqlQuery = new Dev_FanulSucursales[vector.size()];
               for (int i = 0; i < vector.size(); i++) {
                   sqlQuery[i] = vector.elementAt(i);                    
               }
               
               return sqlQuery;
            }else{
                System.out.println("Error: Connexion no activa");
            }
        }catch(SQLException e){            
            StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
            Tools.getErrorMessage(stacktrace,"Error = " + e); 
        }finally{
            connection.close();
        }
        return null;
    }
   
    /**
     * @author MITM
     * @param find
     * @return 
     * @throws java.sql.SQLException 
     */
    public Dev_FaltCarga[] find_Dev_Faltcarga(String find) throws SQLException {
        try{
            BdInterface bd = ConnBdType.open(ConnBdType.SqlServer);
            connection = bd.open();
        
            StringBuilder sqlProc = new StringBuilder();
            sqlProc.append("{call sp_get_rep_dev_faltcarga(?)}");
            
            if (connection != null){
               CallableStatement cstmt = connection.prepareCall(sqlProc.toString());
               cstmt.setString("@find"    , find );
               ResultSet result = cstmt.executeQuery();            
               Vector<Dev_FaltCarga> vector = new Vector<>();
               
               while(result.next()) {
                   Dev_FaltCarga cguias_falt = new Dev_FaltCarga(result);
                   vector.add(cguias_falt);
               }
               
               Dev_FaltCarga[] cguias_falt = new Dev_FaltCarga[vector.size()];
               for (int i = 0; i < vector.size(); i++) {
                   cguias_falt[i] = vector.elementAt(i);                    
               }
               
               return cguias_falt;
            }else{
                System.out.println("Error: Connexion no activa");
            }
        }catch(SQLException e){            
            StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
            Tools.getErrorMessage(stacktrace,"Error = " + e); 
        }finally{
            connection.close();
        }
        return null;
    }
    /***************************************************************************/
    /******************************** INDICATORS *******************************/
    /***************************************************************************/
    /**
     * @author MITM
     * @param year
     * @param IdScreen
     * @return 
     * @throws java.sql.SQLException 
     */
    public Zsi_nros_sem[] find_Zsi_nros_sem(int year, int IdScreen) throws SQLException {
        try{
            BdInterface bd = ConnBdType.open(ConnBdType.SqlServer);
            connection = bd.open();
        
            StringBuilder sqlProc = new StringBuilder();
            switch(Datos.getIdScreen()){
                case 2007010:
                    sqlProc.append("{call [sp_get_zsi_nros_fact_emi](?)}");
                    break;
                case 2007020:
                    sqlProc.append("{call [sp_get_zsi_nros_guia_pen](?)}");
                    break;
                case 2007030:
                    sqlProc.append("{call [sp_get_zsi_nros_guia_emi](?)}");
                    break;
                case 2007040:
                    sqlProc.append("{call [sp_get_zsi_nros_guia_des](?)}");
                    break;
                case 2007050:
                    sqlProc.append("{call [sp_get_zsi_nros_guia_pen](?)}");
                    break;
                case 2007060:
                    sqlProc.append("{call [sp_get_zsi_nros_vehi_ct](?)}");
                    break;
            }
            
            if (connection != null){
               CallableStatement cstmt = connection.prepareCall(sqlProc.toString());
               cstmt.setInt("@ano"         , year );
               ResultSet result = cstmt.executeQuery();            
               Vector<Zsi_nros_sem> vector = new Vector<>();
               
               while(result.next()) {
                   Zsi_nros_sem sqlQuery = new Zsi_nros_sem(result);
                   vector.add(sqlQuery);
               }
               
               Zsi_nros_sem[] sqlQuery = new Zsi_nros_sem[vector.size()];
               for (int i = 0; i < vector.size(); i++) {
                   sqlQuery[i] = vector.elementAt(i);                    
               }
               
               return sqlQuery;
            }else{
                System.out.println("Error: Connexion no activa");
            }
        }catch(SQLException e){            
            StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
            Tools.getErrorMessage(stacktrace,"Error = " + e); 
        }finally{
            connection.close();
        }
        return null;
    }
    /**
     * @author MITM
     * @param year
     * @param IdScreen
     * @param grafico
     * @return 
     * @throws java.sql.SQLException 
     */
    public int[] find_Zsi_nros_sem_int(int year, int IdScreen, String grafico) throws SQLException {
        try{
            BdInterface bd = ConnBdType.open(ConnBdType.SqlServer);
            connection = bd.open();
        
            StringBuilder sqlProc = new StringBuilder();
            switch(Datos.getIdScreen()){
                case 2007010:
                    if(grafico.equals("X")){
                        sqlProc.append("{call [sp_get_zsi_nros_fact_emi_avg](?)}");
                    }
                    else{
                        sqlProc.append("{call [sp_get_zsi_nros_fact_emi_r](?)}");
                    }
                    break;
                case 2007020:
                    if(grafico.equals("X")){
                        sqlProc.append("{call [sp_get_zsi_nros_guia_pen_avg](?)}");
                    }
                    else{
                        sqlProc.append("{call [sp_get_zsi_nros_guia_pen_r](?)}");
                    }
                    break;
                case 2007030:
                    if(grafico.equals("X")){
                        sqlProc.append("{call [sp_get_zsi_nros_guia_emi_avg](?)}");
                    }
                    else{
                        sqlProc.append("{call [sp_get_zsi_nros_guia_emi_r](?)}");
                    }
                    break;
                case 2007040:
                    if(grafico.equals("X")){
                        sqlProc.append("{call [sp_get_zsi_nros_guia_des_avg](?)}");
                    }
                    else{
                        sqlProc.append("{call [sp_get_zsi_nros_guia_des_r](?)}");
                    }
                    break;
                case 2007050:
                    if(grafico.equals("X")){
                        sqlProc.append("{call [sp_get_zsi_nros_guia_pen_avg](?)}");
                    }
                    else{
                        sqlProc.append("{call [sp_get_zsi_nros_guia_pen_r](?)}");
                    }
                    break;
                case 2007060:
                    if(grafico.equals("X")){
                        sqlProc.append("{call [sp_get_zsi_nros_vehi_ct_avg](?)}");
                    }
                    else{
                        sqlProc.append("{call [sp_get_zsi_nros_vehi_ct_r](?)}");
                    }
                    break;
            }
            
            if (connection != null){
               CallableStatement cstmt = connection.prepareCall(sqlProc.toString());
               cstmt.setInt("@ano"         , year );
               ResultSet result = cstmt.executeQuery();            
               
               if(result.next()){                          
                    int[] sqlQuery = new int[53];
                    for (int i = 0; i < sqlQuery.length; i++) {
                        switch(i){
                            case 0:
                                sqlQuery[i] = result.getInt(2);
                                break;
                            case 1:
                                sqlQuery[i] = result.getInt(13);
                                break;
                            case 2:
                                sqlQuery[i] = result.getInt(24);
                                break;
                            case 3:
                                sqlQuery[i] = result.getInt(35);
                                break;
                            case 4:
                                sqlQuery[i] = result.getInt(46);
                                break;
                            case 5:
                                sqlQuery[i] = result.getInt(51);
                                break;
                            case 6:
                                sqlQuery[i] = result.getInt(52);
                                break;
                            case 7:
                                sqlQuery[i] = result.getInt(53);
                                break;
                            case 8:
                                sqlQuery[i] = result.getInt(54);
                                break;
                            case 9:
                                sqlQuery[i] = result.getInt(3);
                                break;
                            case 10:
                                sqlQuery[i] = result.getInt(4);
                                break;
                            case 11:
                                sqlQuery[i] = result.getInt(5);
                                break;
                            case 12:
                                sqlQuery[i] = result.getInt(6);
                                break;
                            case 13:
                                sqlQuery[i] = result.getInt(7);
                                break;
                            case 14:
                                sqlQuery[i] = result.getInt(8);
                                break;
                            case 15:
                                sqlQuery[i] = result.getInt(9);
                                break;
                            case 16:
                                sqlQuery[i] = result.getInt(10);
                                break;
                            case 17:
                                sqlQuery[i] = result.getInt(11);
                                break;
                            case 18:
                                sqlQuery[i] = result.getInt(12);
                                break;
                            case 19:
                                sqlQuery[i] = result.getInt(14);
                                break;
                            case 20:
                                sqlQuery[i] = result.getInt(15);
                                break;
                            case 21:
                                sqlQuery[i] = result.getInt(16);
                                break;
                            case 22:
                                sqlQuery[i] = result.getInt(17);
                                break;
                            case 23:
                                sqlQuery[i] = result.getInt(18);
                                break;
                            case 24:
                                sqlQuery[i] = result.getInt(19);
                                break;
                            case 25:
                                sqlQuery[i] = result.getInt(20);
                                break;
                            case 26:
                                sqlQuery[i] = result.getInt(21);
                                break;
                            case 27:
                                sqlQuery[i] = result.getInt(22);
                                break;
                            case 28:
                                sqlQuery[i] = result.getInt(23);
                                break;
                            case 29:
                                sqlQuery[i] = result.getInt(25);
                                break;
                            case 30:
                                sqlQuery[i] = result.getInt(26);
                                break;
                            case 31:
                                sqlQuery[i] = result.getInt(27);
                                break;
                            case 32:
                                sqlQuery[i] = result.getInt(28);
                                break;
                            case 33:
                                sqlQuery[i] = result.getInt(29);
                                break;
                            case 34:
                                sqlQuery[i] = result.getInt(30);
                                break;
                            case 35:
                                sqlQuery[i] = result.getInt(31);
                                break;
                            case 36:
                                sqlQuery[i] = result.getInt(32);
                                break;
                            case 37:
                                sqlQuery[i] = result.getInt(33);
                                break;
                            case 38:
                                sqlQuery[i] = result.getInt(34);
                                break;
                            case 39:
                                sqlQuery[i] = result.getInt(36);
                                break;
                            case 40:
                                sqlQuery[i] = result.getInt(37);
                                break;
                            case 41:
                                sqlQuery[i] = result.getInt(38);
                                break;
                            case 42:
                                sqlQuery[i] = result.getInt(39);
                                break;
                            case 43:
                                sqlQuery[i] = result.getInt(40);
                                break;
                            case 44:
                                sqlQuery[i] = result.getInt(41);
                                break;
                            case 45:
                                sqlQuery[i] = result.getInt(42);
                                break;
                            case 46:
                                sqlQuery[i] = result.getInt(43);
                                break;
                            case 47:
                                sqlQuery[i] = result.getInt(44);
                                break;
                            case 48:
                                sqlQuery[i] = result.getInt(45);
                                break;
                            case 49:
                                sqlQuery[i] = result.getInt(47);
                                break;
                            case 50:
                                sqlQuery[i] = result.getInt(48);
                                break;
                            case 51:
                                sqlQuery[i] = result.getInt(49);
                                break;
                            case 52:
                                sqlQuery[i] = result.getInt(50);
                                break;
                        }
                    }
                    return sqlQuery;
                }    
            }else{
                System.out.println("Error: Connexion no activa");
            }
        }catch(SQLException e){            
            StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
            Tools.getErrorMessage(stacktrace,"Error = " + e); 
        }finally{
            connection.close();
        }
        return null;
    }
    /**
     * @author MITM
     * @param year
     * @param IdScreen
     * @return 
     * @throws java.sql.SQLException 
     */
    public Zsi_nros_sem_avg[] find_Zsi_nros_sem_avg(int year, int IdScreen) throws SQLException {
        try{
            BdInterface bd = ConnBdType.open(ConnBdType.SqlServer);
            connection = bd.open();
        
            StringBuilder sqlProc = new StringBuilder();
            switch(Datos.getIdScreen()){
                case 2007010:
                    sqlProc.append("{call [sp_get_zsi_nros_fact_emi_avg](?)}");
                    break;
                case 2007020:
                    sqlProc.append("{call [sp_get_zsi_nros_vehi_ct_avg](?)}");
                    break;
                case 2007030:
                    sqlProc.append("{call [sp_get_zsi_nros_guia_emi_avg](?)}");
                    break;
                case 2007040:
                    sqlProc.append("{call [sp_get_zsi_nros_guia_des_avg](?)}");
                    break;
                case 2007050:
                    sqlProc.append("{call [sp_get_zsi_nros_guia_pen_avg](?)}");
                    break;
                case 2007060:
                    sqlProc.append("{call [sp_get_zsi_nros_vehi_ct_avg](?)}");
                    break;
            }
            
            if (connection != null){
               CallableStatement cstmt = connection.prepareCall(sqlProc.toString());
               cstmt.setInt("@ano"         , year );
               ResultSet result = cstmt.executeQuery();            
               Vector<Zsi_nros_sem_avg> vector = new Vector<>();
               
               while(result.next()) {
                   Zsi_nros_sem_avg sqlQuery = new Zsi_nros_sem_avg(result);
                   vector.add(sqlQuery);
               }
               
               Zsi_nros_sem_avg[] sqlQuery = new Zsi_nros_sem_avg[vector.size()];
               for (int i = 0; i < vector.size(); i++) {
                   sqlQuery[i] = vector.elementAt(i);                    
               }
               
               return sqlQuery;
            }else{
                System.out.println("Error: Connexion no activa");
            }
        }catch(SQLException e){            
            StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
            Tools.getErrorMessage(stacktrace,"Error = " + e); 
        }finally{
            connection.close();
        }
        return null;
    }
    /**
     * @author MITM
     * @param year
     * @param IdScreen
     * @return 
     * @throws java.sql.SQLException 
     */
    public Zsi_nros_sem_day[] find_Zsi_nros_sem_day(int year, int IdScreen) throws SQLException {
        try{
            BdInterface bd = ConnBdType.open(ConnBdType.SqlServer);
            connection = bd.open();
        
            StringBuilder sqlProc = new StringBuilder();
            switch(Datos.getIdScreen()){
                case 2007010:
                    sqlProc.append("{call [sp_get_zsi_nros_fact_emi_day](?)}");
                    break;
                case 2007020:
                    sqlProc.append("{call [sp_get_zsi_nros_guia_pen_day](?)}");
                    break;
                case 2007030:
                    sqlProc.append("{call [sp_get_zsi_nros_guia_emi_day](?)}");
                    break;
                case 2007040:
                    sqlProc.append("{call [sp_get_zsi_nros_guia_des_day](?)}");
                    break;
                case 2007050:
                    sqlProc.append("{call [sp_get_zsi_nros_guia_pen_day](?)}");
                    break;
                case 2007060:
                    sqlProc.append("{call [sp_get_zsi_nros_vehi_ct_day](?)}");
                    break;
            }
            
            if (connection != null){
               CallableStatement cstmt = connection.prepareCall(sqlProc.toString());
               cstmt.setInt("@ano"         , year );
               ResultSet result = cstmt.executeQuery();            
               Vector<Zsi_nros_sem_day> vector = new Vector<>();
               
               while(result.next()) {
                   Zsi_nros_sem_day sqlQuery = new Zsi_nros_sem_day(result);
                   vector.add(sqlQuery);
               }
               
               Zsi_nros_sem_day[] sqlQuery = new Zsi_nros_sem_day[vector.size()];
               for (int i = 0; i < vector.size(); i++) {
                   sqlQuery[i] = vector.elementAt(i);                    
               }
               
               return sqlQuery;
            }else{
                System.out.println("Error: Connexion no activa");
            }
        }catch(SQLException e){            
            StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
            Tools.getErrorMessage(stacktrace,"Error = " + e); 
        }finally{
            connection.close();
        }
        return null;
    }
    /**
     * @author MITM
     * @param year
     * @param IdScreen
     * @return 
     * @throws java.sql.SQLException 
     */
    public Zsi_nros_sem_r[] find_Zsi_nros_sem_r(int year, int IdScreen) throws SQLException {
        try{
            BdInterface bd = ConnBdType.open(ConnBdType.SqlServer);
            connection = bd.open();
        
            StringBuilder sqlProc = new StringBuilder();
            switch(Datos.getIdScreen()){
                case 2007010:
                    sqlProc.append("{call [sp_get_zsi_nros_fact_emi_r](?)}");
                    break;
                case 2007020:
                    sqlProc.append("{call [sp_get_zsi_nros_guia_pen_r](?)}");
                    break;
                case 2007030:
                    sqlProc.append("{call [sp_get_zsi_nros_guia_emi_r](?)}");
                    break;
                case 2007040:
                    sqlProc.append("{call [sp_get_zsi_nros_guia_des_r](?)}");
                    break;
                case 2007050:
                    sqlProc.append("{call [sp_get_zsi_nros_guia_pen_r](?)}");
                    break;
                case 2007060:
                    sqlProc.append("{call [sp_get_zsi_nros_vehi_ct_r](?)}");
                    break;
            }
            
            if (connection != null){
               CallableStatement cstmt = connection.prepareCall(sqlProc.toString());
               cstmt.setInt("@ano"         , year );
               ResultSet result = cstmt.executeQuery();            
               Vector<Zsi_nros_sem_r> vector = new Vector<>();
               
               while(result.next()) {
                   Zsi_nros_sem_r sqlQuery = new Zsi_nros_sem_r(result);
                   vector.add(sqlQuery);
               }
               
               Zsi_nros_sem_r[] sqlQuery = new Zsi_nros_sem_r[vector.size()];
               for (int i = 0; i < vector.size(); i++) {
                   sqlQuery[i] = vector.elementAt(i);                    
               }
               
               return sqlQuery;
            }else{
                System.out.println("Error: Connexion no activa");
            }
        }catch(SQLException e){            
            StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
            Tools.getErrorMessage(stacktrace,"Error = " + e); 
        }finally{
            connection.close();
        }
        return null;
    }
    /***************************************************************************/
    /******************************* INVENTORY *********************************/
    /***************************************************************************/
    
    /**
     * @author MITM
     * @param producto
     * @param proveedor
     * @return 
     * @throws java.sql.SQLException 
     */
    public InventoryBlockProd[] find_invenblockprod_prod_prov(String producto, String proveedor) throws SQLException {
        try{
            BdInterface bd = ConnBdType.open(ConnBdType.SqlServer);
            connection = bd.open();
        
            StringBuilder sqlProc = new StringBuilder();
            sqlProc.append("{call sp_get_fxp_inventa_find(?, ?)}");
            
            if (connection != null){
               CallableStatement cstmt = connection.prepareCall(sqlProc.toString());
               cstmt.setString("@producto"    , producto );
               cstmt.setString("@proveedor"    , proveedor );
               ResultSet result = cstmt.executeQuery();            
               Vector<InventoryBlockProd> vector = new Vector<>();
               
               while(result.next()) {
                   InventoryBlockProd invenblockprod = new InventoryBlockProd(result);
                   vector.add(invenblockprod);
               }
               
               InventoryBlockProd[] invenblockprod = new InventoryBlockProd[vector.size()];
               for (int i = 0; i < vector.size(); i++) {
                   invenblockprod[i] = vector.elementAt(i);                    
               }
               
               return invenblockprod;
            }else{
                System.out.println("Error: Connexion no activa");
            }
        }catch(SQLException e){            
            StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
            Tools.getErrorMessage(stacktrace,"Error = " + e); 
        }finally{
            connection.close();
        }
        return null;
    }
    /**
     * @author MITM
     * @param id
     * @return 
     * @throws java.sql.SQLException 
     */
    public InventoryBlockProd[] find_invenblockprod(String id) throws SQLException {
        try{
            BdInterface bd = ConnBdType.open(ConnBdType.SqlServer);
            connection = bd.open();
        
            StringBuilder sqlProc = new StringBuilder();
            sqlProc.append("{call sp_get_inv_nro_toma(?)}");
            
            if (connection != null){
               CallableStatement cstmt = connection.prepareCall(sqlProc.toString());
               cstmt.setString("@idtoma"  , id );
               ResultSet result = cstmt.executeQuery();            
               Vector<InventoryBlockProd> vector = new Vector<>();
               
               while(result.next()) {
                   InventoryBlockProd invenblockprod = new InventoryBlockProd(result);
                   vector.add(invenblockprod);
               }
               
               InventoryBlockProd[] invenblockprod = new InventoryBlockProd[vector.size()];
               for (int i = 0; i < vector.size(); i++) {
                   invenblockprod[i] = vector.elementAt(i);                    
               }
               
               return invenblockprod;
            }else{
                System.out.println("Error: Connexion no activa");
            }
        }catch(SQLException e){            
            StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
            Tools.getErrorMessage(stacktrace,"Error = " + e); 
        }finally{
            connection.close();
        }
        return null;
    }
    /**
     * @author MITM
     * @param rows
     * @return 
     * @throws java.sql.SQLException 
     */
    public InventoryBlockProd[] find_invenblockprod_all(int rows) throws SQLException {
        try{
            BdInterface bd = ConnBdType.open(ConnBdType.SqlServer);
            connection = bd.open();
        
            StringBuilder sqlProc = new StringBuilder();
            sqlProc.append("{call sp_get_inv_nro_toma_all(?)}");
            
            if (connection != null){
               CallableStatement cstmt = connection.prepareCall(sqlProc.toString());
               cstmt.setInt("@rows"  , rows );
               ResultSet result = cstmt.executeQuery();            
               Vector<InventoryBlockProd> vector = new Vector<>();
               
               while(result.next()) {
                   InventoryBlockProd invenblockprod = new InventoryBlockProd(result);
                   vector.add(invenblockprod);
               }
               
               InventoryBlockProd[] invenblockprod = new InventoryBlockProd[vector.size()];
               for (int i = 0; i < vector.size(); i++) {
                   invenblockprod[i] = vector.elementAt(i);                    
               }
               
               return invenblockprod;
            }else{
                System.out.println("Error: Connexion no activa");
            }
        }catch(SQLException e){            
            StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
            Tools.getErrorMessage(stacktrace,"Error = " + e); 
        }finally{
            connection.close();
        }
        return null;
    }
    /**
     * @author MITM
     * Valida si el groupsuppliername generado ya se encuentra asignado a un grupo en la BD
     * @param idtoma valor a ser chequeado en la BD
     * @return true si el groupsupplier esta en uso, false si esta disponible el grupo
     * @throws java.sql.SQLException
     */
    public boolean check_invenblockprod(String idtoma) throws SQLException {
        try{
            BdInterface bd = ConnBdType.open(ConnBdType.SqlServer);
            connection = bd.open();
        
            StringBuilder sqlProc = new StringBuilder();
            sqlProc.append("{call sp_get_inv_nro_toma_check(?,?)}");
            
            if (connection != null){
               CallableStatement cstmt = connection.prepareCall(sqlProc.toString());                           
               cstmt.setString("@idtoma", idtoma);
               cstmt.registerOutParameter("result", java.sql.Types.INTEGER);               
               cstmt.execute();
               if(cstmt.getInt("result") == 1) return true;               
            }else{
                System.out.println("Error: Connexion no activa");
            }
        }catch(SQLException e){            
            StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
            Tools.getErrorMessage(stacktrace,"Error = " + e); 
        }finally{
            connection.close();
        }
        return false;
    }
    /**
     * @author MITM
     * @param operacion Determina el Proceso que se va a ejecutar 1 INSERT, 2 UPDATE
     * @param invenblockprod
     * @param pos
     * @return
     * @throws SQLException
     * @throws Exception 
     */
    public boolean save_invenblockprod(
            InventoryBlockProd invenblockprod, int operacion, int pos) throws SQLException, Exception {
        
        BdInterface bd = ConnBdType.open(ConnBdType.SqlServer);
        connection = bd.open();        
        try{
            if (connection != null){
                //Inicia Transaccion 
                connection.setAutoCommit(false);
                StringBuilder sql_rela = new StringBuilder();            
                StringBuilder sql_data = new StringBuilder();            
                String mensj = "";

                switch(operacion){
                    case 1:
                        sql_rela.append("{call sp_ins_inv_numtoma(?)}");
                        sql_data.append("{call sp_ins_inv_toma_prod(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}");
                        mensj = "Nueva toma_productos:";
                        break;
                    case 2:
                        invenblockprod.setNumtoma(Datos.getNumOrd_toma());

                        sql_data.append("{call sp_upd_inv_toma_prod(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}");
                        mensj = "Actualizando toma_productos:";
                        break;
                }
                CallableStatement cstmt = null;
                if (pos == 0){
                    /**
                     * Busqueda numtoma
                     */
                    if (operacion == 1){
                        cstmt = connection.prepareCall(sql_rela.toString());
                        cstmt.registerOutParameter("idtoma"    , java.sql.Types.VARCHAR);
                        cstmt.execute();            
                        invenblockprod.setNumtoma(cstmt.getString("idtoma"));
                        Datos.setNumOrd_comp(cstmt.getString("idtoma"));
                    }
                }

                cstmt = connection.prepareCall(sql_data.toString());
                cstmt.setString("@numtoma"              , invenblockprod.getNumtoma());
                cstmt.setDate("@fecha"                  , invenblockprod.getFecha());
                cstmt.setInt("@id_prov"                 , invenblockprod.getIdSupplier());
                cstmt.setString("@rif_prov"             , invenblockprod.getRif());
                cstmt.setInt("@numorden"                , pos + 1);
                cstmt.setString("@producto"             , invenblockprod.getIdProducto());
                cstmt.setString("@observ"               , invenblockprod.getObserv());
                cstmt.setInt("@anulada"                 , invenblockprod.getAnulada());
                cstmt.setString("@status"               , invenblockprod.getStatus());
                cstmt.setInt("@sql"                     , invenblockprod.getSql());
                cstmt.setString("@ucreacion"               , invenblockprod.getUsr_creacion());
                cstmt.execute();            

                // Auditar el proceso
                auditar(invenblockprod.getNumtoma()+ "",mensj);

                connection.commit();

                return true;
            }else{
                System.out.println("Error: Connexion no activa");
                throw new Exception("Error de Conexion con la BD");
            }
        }catch(Exception e){            
            connection.rollback();   
            StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
            Tools.getErrorMessage(stacktrace,"Error = " + e);    
            throw e;
        }finally{
            connection.close();
        }
    }
    /**
     * @author MITM
     * @param invenblockprod
     * @return 
     * @throws java.lang.Exception 
     */
    public boolean change_invenblockprod(InventoryBlockProd invenblockprod) throws Exception {
        BdInterface bd = ConnBdType.open(ConnBdType.SqlServer);
        connection = bd.open();
        
        try{
         if (connection != null){
            //Inicia Transaccion 
            connection.setAutoCommit(false);
            
            StringBuilder sqlProc = new StringBuilder();
            sqlProc.append("{call sp_upd_prov_status(?,?)}");
            CallableStatement cstmt = connection.prepareCall(sqlProc.toString());                 
            cstmt.setString("@idorden", invenblockprod.getNumtoma());
            int value = 0;
            if(invenblockprod.getAnulada()== 0){
                value = 1;
            }            
            cstmt.setInt("@status", value );
            cstmt.execute();            
            // Auditar el proceso
            auditar(invenblockprod.getNumtoma()+ "","deleteOrdenCompra:");
            
            connection.commit();
            
            return true;
         }else{
            System.out.println("Error: Connexion no activa");
            throw new Exception("Error de Conexion con la BD");
         }
        }catch(Exception e){            
            connection.rollback();            
            StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
            Tools.getErrorMessage(stacktrace,"Error = " + e);    
            throw e;
        }finally{
            connection.close();
        }
    }
    
    /***************************************************************************/
    /******************************* SINGLETON *********************************/
    /***************************************************************************/
    
    private static class BdHolder {
        private static final Bd INSTANCE = new Bd();
    }
    
    public static Bd getInstance() {
        return Bd.BdHolder.INSTANCE;
    }
}

