/*
* To change this template, choose Tools | Templates
* and open the template in the editor.
 */
package BD;
import Objects.Infocent.Asignacion;
import Objects.Infocent.Concepto;
import Objects.Infocent.Deduccion;
import Objects.Infocent.Empleado;
import Tools.Tools;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 * 
 * @author ARMGARCES
 */
public class Infocent implements BdInterface{
    protected String[] params;
    protected Connection connection;
    /***************************************************************************/
    /********************************** BD *************************************/
    /***************************************************************************/
    public Infocent(){
       
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
    /**************************** NOMINA - INFOCENT*****************************/
    /***************************************************************************/    
    /**
     * 
     * @param find
     * @return
     * @throws SQLException 
     */
    public Empleado[] find_Empelado(String find) throws SQLException {
        try{
            Infocent bd = (Infocent) ConnBdType.open(ConnBdType.Oracle);
            connection = bd.open();
            
            StringBuilder sqlProc = new StringBuilder();
            
            if (connection != null){
                sqlProc.append(
                    "SELECT " + 
                        "cedula, ficha, nombre, apellido, compania, " +
                        "nomina, fecha_ingreso, fecha_retiro " +
                    "FROM " +
                        "asignacion " +
                    "WHERE " + 
                        "cedula like '%" + find + "%' OR " +
                        "nombre like '%" + find + "%' OR " +
                        "apellido like '%" + find + "%' " +
                    "GROUP BY " +
                        "cedula, ficha, nombre, apellido, compania, " +
                        "nomina, fecha_ingreso, fecha_retiro " +
                    "ORDER BY " +
                        "fecha_ingreso");
                
                Statement stmt = connection.createStatement();
                ResultSet result = stmt.executeQuery(sqlProc.toString());
                
                List<Empleado> list = new ArrayList<>();
                while(result.next()) {
                    Empleado obj = new Empleado();                   
                    obj.setCompania(result.getString("compania"));
                    obj.setNomina  (result.getString("nomina"));
                    obj.setCedula  (result.getString("cedula"));
                    obj.setFicha   (result.getString("ficha"));
                    obj.setIngreso (result.getString("fecha_ingreso"));
                    obj.setRetiro  (result.getString("fecha_retiro"));
                    obj.setNombre  (result.getString("nombre"));
                    obj.setApellido(result.getString("apellido"));
                    list.add(obj);
                }               
                return list.toArray(new Empleado[list.size()]);                 
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
     * 
     * @param empleado
     * @return
     * @throws SQLException 
     */
    public Empleado[] loadInfoEmpleado(Empleado empleado) throws SQLException {
        try{
            Infocent bd = (Infocent) ConnBdType.open(ConnBdType.Oracle);
            connection = bd.open();

            StringBuilder sqlProc = new StringBuilder();
            
            if (connection != null){
                String query;
                if(empleado.getFicha() != null){    
                    sqlProc.append(
                        "SELECT " +
                            "compania, nomina, cedula, ficha, fecha_ingreso, " +
                            "fecha_retiro, nombre, apellido " +
                        "FROM " +
                            "asignacion " +
                        "WHERE " +
                            "cedula = '" + empleado.getCedula() + "' AND " + 
                            "ficha = '" + empleado.getFicha() + "' AND " +
                            "nomina = '" + empleado.getNomina() + "' " +
                        "GROUP BY " +
                            "ficha, compania, nomina, cedula, fecha_ingreso, " +
                            "fecha_retiro, nombre, apellido");			
                }else{
                    sqlProc.append(
                        "SELECT " +
                            "compania, nomina, cedula, ficha, fecha_ingreso, " +
                            "fecha_retiro, nombre, apellido " +
                        "FROM " +
                            "asignacion " +
                        "WHERE " +
                            "cedula = '" + empleado.getCedula() + "' " + 
                        "GROUP BY " +
                            "ficha, compania, nomina, cedula, fecha_ingreso, " +
                            "fecha_retiro, nombre, apellido");			
                }  

                Statement stmt = connection.createStatement();
                ResultSet rs = stmt.executeQuery(sqlProc.toString());
                
                List<Empleado> list = new ArrayList<>();
                while(rs.next()) {
                    Empleado obj = new Empleado();                   
                    obj.setCompania(rs.getString("compania"));
                    obj.setNomina  (rs.getString("nomina"));
                    obj.setCedula  (rs.getString("cedula"));
                    obj.setFicha   (rs.getString("ficha"));
                    obj.setIngreso (rs.getString("fecha_ingreso"));
                    obj.setRetiro  (rs.getString("fecha_retiro"));
                    obj.setNombre  (rs.getString("nombre"));
                    obj.setApellido(rs.getString("apellido"));
                    list.add(obj);
                }               
                return list.toArray(new Empleado[list.size()]);                 
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
     * @param empleado
     * @param year
     * @return
     * @throws SQLException 
     */
    public Asignacion[] loadAsignacionesXAno(Empleado empleado, int year) throws SQLException {
        try{
            Infocent bd = (Infocent) ConnBdType.open(ConnBdType.Oracle);
            connection = bd.open();

            StringBuilder sqlProc = new StringBuilder();

            if (connection != null){
                if(empleado.getFicha() != null){
                    sqlProc.append(
			"SELECT " +
                            "concepto, descto, tipo_proceso, proceso, subproceso, " +
                            "COUNT(*) num, SUM(cantidad) cantidad, SUM(monto) monto, SUM(saldo) saldo "+
                        "FROM " +
                            "asignacion " + 
                        "WHERE " + 
                            "cedula = '" + empleado.getCedula() + "' AND ficha = '" + empleado.getFicha() + "' AND " + 
                            "nomina = '" + empleado.getNomina() + "' AND ano = " + year + " " +
                        "GROUP BY " +
                             "concepto, descto, tipo_proceso, proceso, subproceso " + 
                        "ORDER BY " + 
                            "concepto");			
		}else{
                    sqlProc.append(
			"SELECT " +
                            "concepto, descto, tipo_proceso, proceso, subproceso, " +
                            "COUNT(*) num, SUM(cantidad) cantidad, SUM(monto) monto, SUM(saldo) saldo "+
                        "FROM " +
                            "asignacion " + 
                        "WHERE " + 
                            "cedula = '" + empleado.getCedula() + "' AND ano = " + year + " " +
                        "GROUP BY " +
                             "concepto, descto, tipo_proceso, proceso, subproceso " + 
                        "ORDER BY " + 
                            "concepto");			
		}        
                
                Statement stmt = connection.createStatement();
                ResultSet rs = stmt.executeQuery(sqlProc.toString());
                
                List<Asignacion> list = new ArrayList<>();
                while(rs.next()) {
                    Asignacion obj = new Asignacion();          
                    obj.setConcepto   (rs.getString("concepto"));
                    obj.setDescto     (rs.getString("descto"));
                    obj.setTipoProceso(rs.getInt("tipo_proceso"));
                    obj.setProceso    (rs.getString("proceso"));
                    obj.setSubproceso (rs.getInt("subproceso"));
                    obj.setNum        (rs.getInt("num"));
                    obj.setCantidad   (rs.getInt("cantidad"));
                    obj.setMonto      (rs.getDouble("monto"));
                    obj.setSaldo      (rs.getDouble("saldo"));
                    list.add(obj);
                }          
                return list.toArray(new Asignacion[list.size()]);                 
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
     * @param empleado
     * @param year
     * @return
     * @throws SQLException 
     */
    public Deduccion[] loadDeduccionesXAno(Empleado empleado, int year) throws SQLException {
        try{
            Infocent bd = (Infocent) ConnBdType.open(ConnBdType.Oracle);
            connection = bd.open();

            StringBuilder sqlProc = new StringBuilder();

            if (connection != null){
                if(empleado.getFicha() != null){
                    sqlProc.append(
			"SELECT " +
                            "concepto, descto, tipo_proceso, proceso, subproceso, " +
                            "COUNT(*) num, SUM(cantidad) cantidad, SUM(monto) monto, SUM(saldo) saldo "+
                        "FROM " +
                            "deduccion " + 
                        "WHERE " + 
                            "cedula = '" + empleado.getCedula() + "' AND ficha = '" + empleado.getFicha() + "' AND " + 
                            "nomina = '" + empleado.getNomina() + "' AND ano = " + year + " " +
                        "GROUP BY " +
                             "concepto, descto, tipo_proceso, proceso, subproceso " + 
                        "ORDER BY " + 
                            "concepto");			
		}else{
                    sqlProc.append(
			"SELECT " +
                            "concepto, descto, tipo_proceso, proceso, subproceso, " +
                            "COUNT(*) num, SUM(cantidad) cantidad, SUM(monto) monto, SUM(saldo) saldo "+
                        "FROM " +
                            "deduccion " + 
                        "WHERE " + 
                            "cedula = '" + empleado.getCedula() + "' AND ano = " + year + " " +
                        "GROUP BY " +
                             "concepto, descto, tipo_proceso, proceso, subproceso " + 
                        "ORDER BY " + 
                            "concepto");			
		}        
                
                Statement stmt = connection.createStatement();
                ResultSet rs = stmt.executeQuery(sqlProc.toString());
                
                List<Deduccion> list = new ArrayList<>();
                while(rs.next()) {
                    Deduccion obj = new Deduccion();          
                    obj.setConcepto   (rs.getString("concepto"));
                    obj.setDescto     (rs.getString("descto"));
                    obj.setTipoProceso(rs.getInt("tipo_proceso"));
                    obj.setProceso    (rs.getString("proceso"));
                    obj.setSubproceso (rs.getInt("subproceso"));
                    obj.setNum        (rs.getInt("num"));
                    obj.setCantidad   (rs.getInt("cantidad"));
                    obj.setMonto      (rs.getDouble("monto"));
                    obj.setSaldo      (rs.getDouble("saldo"));
                    list.add(obj);
                }          
                return list.toArray(new Deduccion[list.size()]);                 
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
     * @param empleado
     * @param year
     * @param month
     * @return
     * @throws SQLException 
     */
    public Asignacion[] loadAsignacionesXMes(Empleado empleado, int year, int month) throws SQLException {
        try{
            Infocent bd = (Infocent) ConnBdType.open(ConnBdType.Oracle);
            connection = bd.open();

            StringBuilder sqlProc = new StringBuilder();

            if (connection != null){
                if(empleado.getFicha() != null){
                    sqlProc.append(
			"SELECT " +
                            "concepto, descto, tipo_proceso, proceso, subproceso, " +
                            "COUNT(*) num, SUM(cantidad) cantidad, SUM(monto) monto, SUM(saldo) saldo "+
                        "FROM " +
                            "asignacion " + 
                        "WHERE " + 
                            "cedula = '" + empleado.getCedula() + "' AND ficha = '" + empleado.getFicha() + "' AND " + 
                            "nomina = '" + empleado.getNomina() + "' AND ano = " + year + " AND " +
                            "mes = " + month + " " +
                        "GROUP BY " +
                             "concepto, descto, tipo_proceso, proceso, subproceso " + 
                        "ORDER BY " + 
                            "concepto");			
		}else{
                    sqlProc.append(
			"SELECT " +
                            "concepto, descto, tipo_proceso, proceso, subproceso, " +
                            "COUNT(*) num, SUM(cantidad) cantidad, SUM(monto) monto, SUM(saldo) saldo "+
                        "FROM " +
                            "asignacion " + 
                        "WHERE " + 
                            "cedula = '" + empleado.getCedula() + "' AND ano = " + year + " AND " +
                            "mes = " + month + " " +
                        "GROUP BY " +
                             "concepto, descto, tipo_proceso, proceso, subproceso " + 
                        "ORDER BY " + 
                            "concepto");			
		}        
                
                Statement stmt = connection.createStatement();
                ResultSet rs = stmt.executeQuery(sqlProc.toString());
                
                List<Asignacion> list = new ArrayList<>();
                while(rs.next()) {
                    Asignacion obj = new Asignacion();          
                    obj.setConcepto   (rs.getString("concepto"));
                    obj.setDescto     (rs.getString("descto"));
                    obj.setTipoProceso(rs.getInt("tipo_proceso"));
                    obj.setProceso    (rs.getString("proceso"));
                    obj.setSubproceso (rs.getInt("subproceso"));
                    obj.setNum        (rs.getInt("num"));
                    obj.setCantidad   (rs.getInt("cantidad"));
                    obj.setMonto      (rs.getDouble("monto"));
                    obj.setSaldo      (rs.getDouble("saldo"));
                    list.add(obj);
                }               
                return list.toArray(new Asignacion[list.size()]);                 
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
     * @param empleado
     * @param year
     * @param month
     * @return
     * @throws SQLException
     */
    public Deduccion[] loadDeduccionesXMes(Empleado empleado, int year, int month) throws SQLException {
        try{
            Infocent bd = (Infocent) ConnBdType.open(ConnBdType.Oracle);
            connection = bd.open();

            StringBuilder sqlProc = new StringBuilder();

            if (connection != null){
                if(empleado.getFicha() != null){
                    sqlProc.append(
			"SELECT " +
                            "concepto, descto, tipo_proceso, proceso, subproceso, " +
                            "COUNT(*) num, SUM(cantidad) cantidad, SUM(monto) monto, SUM(saldo) saldo "+
                        "FROM " +
                            "deduccion " + 
                        "WHERE " + 
                            "cedula = '" + empleado.getCedula() + "' AND ficha = '" + empleado.getFicha() + "' AND " + 
                            "nomina = '" + empleado.getNomina() + "' AND ano = " + year + " AND " +
                            "mes = " + month + " " +
                        "GROUP BY " +
                             "concepto, descto, tipo_proceso, proceso, subproceso " + 
                        "ORDER BY " + 
                            "concepto");			
		}else{
                    sqlProc.append(
			"SELECT " +
                            "concepto, descto, tipo_proceso, proceso, subproceso, " +
                            "COUNT(*) num, SUM(cantidad) cantidad, SUM(monto) monto, SUM(saldo) saldo "+
                        "FROM " +
                            "deduccion " + 
                        "WHERE " + 
                            "cedula = '" + empleado.getCedula() + "' AND ano = " + year + " AND " +
                            "mes = " + month + " " +
                        "GROUP BY " +
                             "concepto, descto, tipo_proceso, proceso, subproceso " + 
                        "ORDER BY " + 
                            "concepto");			
		}        
                
                Statement stmt = connection.createStatement();
                ResultSet rs = stmt.executeQuery(sqlProc.toString());
                
                List<Deduccion> list = new ArrayList<>();
                while(rs.next()) {
                    Deduccion obj = new Deduccion();          
                    obj.setConcepto   (rs.getString("concepto"));
                    obj.setDescto     (rs.getString("descto"));
                    obj.setTipoProceso(rs.getInt("tipo_proceso"));
                    obj.setProceso    (rs.getString("proceso"));
                    obj.setSubproceso (rs.getInt("subproceso"));
                    obj.setNum        (rs.getInt("num"));
                    obj.setCantidad   (rs.getInt("cantidad"));
                    obj.setMonto      (rs.getDouble("monto"));
                    obj.setSaldo      (rs.getDouble("saldo"));
                    list.add(obj);
                }              
                return list.toArray(new Deduccion[list.size()]);                
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
     * @param cedula
     * @param year
     * @param month
     * @return
     * @throws SQLException 
     */
    public Integer[] loadPeriodos(String cedula, int year, int month) throws SQLException {
        try{
            Infocent bd = (Infocent) ConnBdType.open(ConnBdType.Oracle);
            connection = bd.open();            

            StringBuilder sqlProc = new StringBuilder();

            if (connection != null){
                sqlProc.append(
                    "SELECT " +
                        "periodo " +
                    "FROM " +
                        "asignacion " +
                    "WHERE " +
                        "cedula = '" + cedula + "' AND " +
                        "ano = " + year + " AND mes = " + month + " " +
                    "GROUP BY " + 
                        "periodo " +
                    "ORDER BY " + 
                        "periodo ASC");  

                Statement stmt = connection.createStatement();
                ResultSet rs = stmt.executeQuery(sqlProc.toString());

                List<Integer> list = new ArrayList<>();
                while(rs.next()){    
                    list.add(rs.getInt("PERIODO"));                                                      
                }    
                return list.toArray(new Integer[list.size()]);     
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
     * @param empleado
     * @param year
     * @param month
     * @param period
     * @return
     * @throws SQLException 
     */
    public Asignacion[] loadAsignacionesXPeriodo(Empleado empleado, int year, int month, int period) throws SQLException {
        try{
            Infocent bd = (Infocent) ConnBdType.open(ConnBdType.Oracle);
            connection = bd.open();

            StringBuilder sqlProc = new StringBuilder();

            if (connection != null){
                if(empleado.getFicha() != null){
                    sqlProc.append(
			"SELECT " +
                            "concepto, descto, tipo_proceso, proceso, subproceso, " +
                            "COUNT(*) num, SUM(cantidad) cantidad, SUM(monto) monto, SUM(saldo) saldo "+
                        "FROM " +
                            "asignacion " + 
                        "WHERE " + 
                            "cedula = '" + empleado.getCedula() + "' AND ficha = '" + empleado.getFicha() + "' AND " + 
                            "nomina = '" + empleado.getNomina() + "' AND ano = " + year + " AND " +
                            "mes = " + month + " AND periodo = " + period + " " +
                        "GROUP BY " +
                             "concepto, descto, tipo_proceso, proceso, subproceso " + 
                        "ORDER BY " + 
                            "concepto");			
		}else{
                    sqlProc.append(
			"SELECT " +
                            "concepto, descto, tipo_proceso, proceso, subproceso, " +
                            "COUNT(*) num, SUM(cantidad) cantidad, SUM(monto) monto, SUM(saldo) saldo "+
                        "FROM " +
                            "asignacion " + 
                        "WHERE " + 
                            "cedula = '" + empleado.getCedula() + "' AND ano = " + year + " AND " +
                            "mes = " + month + " AND periodo = " + period + " " +
                        "GROUP BY " +
                             "concepto, descto, tipo_proceso, proceso, subproceso " + 
                        "ORDER BY " + 
                            "concepto");			
		}        
                
                Statement stmt = connection.createStatement();
                ResultSet rs = stmt.executeQuery(sqlProc.toString());
                
                List<Asignacion> list = new ArrayList<>();
                while(rs.next()) {
                    Asignacion obj = new Asignacion();          
                    obj.setConcepto   (rs.getString("concepto"));
                    obj.setDescto     (rs.getString("descto"));
                    obj.setTipoProceso(rs.getInt("tipo_proceso"));
                    obj.setProceso    (rs.getString("proceso"));
                    obj.setSubproceso (rs.getInt("subproceso"));
                    obj.setNum        (1);
                    //obj.setNum        (rs.getInt("num"));
                    obj.setCantidad   (rs.getInt("cantidad"));
                    obj.setMonto      (rs.getDouble("monto"));
                    obj.setSaldo      (rs.getDouble("saldo"));
                    list.add(obj);
                }               
                return list.toArray(new Asignacion[list.size()]);                 
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
     * @param empleado
     * @param year
     * @param month
     * @param period
     * @return
     * @throws SQLException 
     */
    public Deduccion[] loadDeduccionesXPeriodo(Empleado empleado, int year, int month, int period) throws SQLException {
        try{
            Infocent bd = (Infocent) ConnBdType.open(ConnBdType.Oracle);
            connection = bd.open();

            StringBuilder sqlProc = new StringBuilder();

            if (connection != null){
                if(empleado.getFicha() != null){
                    sqlProc.append(
			"SELECT " +
                            "concepto, descto, tipo_proceso, proceso, subproceso, " +
                            "COUNT(*) num, SUM(cantidad) cantidad, SUM(monto) monto, SUM(saldo) saldo "+
                        "FROM " +
                            "deduccion " + 
                        "WHERE " + 
                            "cedula = '" + empleado.getCedula() + "' AND ficha = '" + empleado.getFicha() + "' AND " + 
                            "nomina = '" + empleado.getNomina() + "' AND ano = " + year + " AND " +
                            "mes = " + month + " AND periodo = " + period + " " +
                        "GROUP BY " +
                             "concepto, descto, tipo_proceso, proceso, subproceso " + 
                        "ORDER BY " + 
                            "concepto");			
		}else{
                    sqlProc.append(
			"SELECT " +
                            "concepto, descto, tipo_proceso, proceso, subproceso, " +
                            "COUNT(*) num, SUM(cantidad) cantidad, SUM(monto) monto, SUM(saldo) saldo "+
                        "FROM " +
                            "deduccion " + 
                        "WHERE " + 
                            "cedula = '" + empleado.getCedula() + "' AND ano = " + year + " AND " +
                            "mes = " + month + " AND periodo = " + period + " " +
                        "GROUP BY " +
                             "concepto, descto, tipo_proceso, proceso, subproceso " + 
                        "ORDER BY " + 
                            "concepto");			
		}
                
                Statement stmt = connection.createStatement();
                ResultSet rs = stmt.executeQuery(sqlProc.toString());
                
                List<Deduccion> list = new ArrayList<>();
                while(rs.next()) {
                    Deduccion obj = new Deduccion();          
                    obj.setConcepto   (rs.getString("concepto"));
                    obj.setDescto     (rs.getString("descto"));
                    obj.setTipoProceso(rs.getInt("tipo_proceso"));
                    obj.setProceso    (rs.getString("proceso"));
                    obj.setSubproceso (rs.getInt("subproceso"));
                    obj.setNum        (1);
                    //obj.setNum        (rs.getInt("num"));
                    obj.setCantidad   (rs.getInt("cantidad"));
                    obj.setMonto      (rs.getDouble("monto"));
                    obj.setSaldo      (rs.getDouble("saldo"));
                    list.add(obj);
                }               
                return list.toArray(new Deduccion[list.size()]);                 
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
     * @param compania
     * @param year
     * @return
     * @throws SQLException 
     */
    public String[] loadNominasXEmpresa(String compania, int year) throws SQLException {
        try{
            Infocent bd = (Infocent) ConnBdType.open(ConnBdType.Oracle);
            connection = bd.open();
            
            StringBuilder sqlProc = new StringBuilder();
            
            if (connection != null){
                sqlProc.append(
                    "SELECT " + 
                        "compania, nomina " +
                    "FROM " +
                        "asignacion " +
                    "WHERE " + 
                        "compania = '" + compania + "' AND " +
                        "ano = " + year + " " + 
                    "GROUP BY " + 
                        "nomina, compania");

                Statement stmt = connection.createStatement();
                ResultSet rs = stmt.executeQuery(sqlProc.toString());

                List<String> list = new ArrayList<>();
                while(rs.next()){    
                    list.add(rs.getString("nomina"));                                                      
                }    
                return list.toArray(new String[list.size()]);     
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
     * @param auditar 
     * @param compania
     * @param nomina
     * @param year
     * @param month
     * @param type
     * @return
     * @throws SQLException 
     */
    public Concepto[] loadConceptos(String auditar, String compania, String nomina, int year, int month, int type) throws SQLException {
        try{
            Infocent bd = (Infocent) ConnBdType.open(ConnBdType.Oracle);
            connection = bd.open();
            
            StringBuilder sqlProc = new StringBuilder();
            
            if (connection != null){
                String sTable = "";
                switch (auditar){
                    case "AS":
                        sTable = "asignacion";
                        break;
                    case "DE":
                        sTable = "deduccion";
                        break;
                }
                sqlProc.append(
                    "SELECT " +
                        "concepto, descto " +
                    "FROM " +
                        sTable + " " +
                    "WHERE " +
                        "compania = '" + compania + "' AND " +
                        "nomina = '" + nomina + "' AND " +
                        "ano = " + year + " AND " +
                        "mes = " + month + " AND " +
                        "tipo_proceso = " + type + " " +
                    "GROUP BY " +
                         "concepto, descto " + 
                    "ORDER BY " + 
                        "concepto, descto");			

                Statement stmt = connection.createStatement();
                ResultSet rs = stmt.executeQuery(sqlProc.toString());
                
                List<Concepto> list = new ArrayList<>();
                while(rs.next()) {
                    Concepto obj = new Concepto();                   
                    obj.setId(rs.getInt("concepto"));
                    obj.setDescripcion(rs.getString("descto"));
                    list.add(obj);
                }               
                return list.toArray(new Concepto[list.size()]);                 
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
     * 
     * @param compania
     * @param nomina
     * @param year
     * @return
     * @throws SQLException 
     */
    public Integer[] loadTipoProcesosXAno(String compania, String nomina, int year) throws SQLException{
        try{
            Infocent bd = (Infocent) ConnBdType.open(ConnBdType.Oracle);
            connection = bd.open();            
            
            StringBuilder sqlProc = new StringBuilder();
            
            if (connection != null){
                sqlProc.append(
                    "SELECT " +
                        "a.tipo_proceso " + 
                    "FROM " +
                        "(SELECT " +
                            "compania, tipo_proceso " +
                        "FROM " +
                            "asignacion " +
                        "WHERE " +
                            "compania = '" + compania + "' AND " +
                            "nomina = '" + nomina + "' AND " +
                            "ano = " + year + " " +
                        "GROUP BY " +
                            "tipo_proceso, nomina, compania " +
                        "ORDER BY " +
                            "tipo_proceso " +
                        ") a " +
                    "LEFT JOIN " +
                        "(SELECT " +
                            "compania, tipo_proceso " +
                        "FROM " +
                            "deduccion " +
                        "WHERE " +
                            "compania = '" + compania + "' AND " +
                            "nomina = '" + nomina + "' AND " +
                            "ano = " + year + " " +
                        "GROUP BY " +
                            "tipo_proceso, nomina, compania " +
                        "ORDER BY " +
                            "tipo_proceso " +
                        ") d " +
                    "ON " +
                        "a.tipo_proceso = d.tipo_proceso " +
                    "ORDER BY " +
                        "a.tipo_proceso");

                Statement stmt = connection.createStatement();
                ResultSet rs = stmt.executeQuery(sqlProc.toString());

                List<Integer> list = new ArrayList<>();
                while(rs.next()){    
                    list.add(rs.getInt("tipo_proceso"));                                                      
                }    
                return list.toArray(new Integer[list.size()]);     
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
     * 
     * @param compania
     * @param nomina
     * @param year
     * @param month
     * @return
     * @throws SQLException 
     */
    public Integer[] loadTipoProcesosXMes(String compania, String nomina, int year, int month) throws SQLException{
        try{
            Infocent bd = (Infocent) ConnBdType.open(ConnBdType.Oracle);
            connection = bd.open();            
            
            StringBuilder sqlProc = new StringBuilder();
            
            if (connection != null){
                sqlProc.append(
                    "SELECT " +
                        "a.tipo_proceso " + 
                    "FROM " +
                        "(SELECT " +
                            "compania, tipo_proceso " +
                        "FROM " +
                            "asignacion " +
                        "WHERE " +
                            "compania = '" + compania + "' AND " +
                            "nomina = '" + nomina + "' AND " +
                            "ano = " + year + " AND " +
                            "mes = " + month + " " +
                        "GROUP BY " +
                            "tipo_proceso, nomina, compania " +
                        "ORDER BY " +
                            "tipo_proceso " +
                        ") a " +
                    "LEFT JOIN " +
                        "(SELECT " +
                            "compania, tipo_proceso " +
                        "FROM " +
                            "deduccion " +
                        "WHERE " +
                            "compania = '" + compania + "' AND " +
                            "nomina = '" + nomina + "' AND " +
                            "ano = " + year + " AND " +
                            "mes = " + month + " " +
                        "GROUP BY " +
                            "tipo_proceso, nomina, compania " +
                        "ORDER BY " +
                            "tipo_proceso " +
                        ") d " +
                    "ON " +
                        "a.tipo_proceso = d.tipo_proceso " +
                    "ORDER BY " +
                        "a.tipo_proceso");

                Statement stmt = connection.createStatement();
                ResultSet rs = stmt.executeQuery(sqlProc.toString());

                List<Integer> list = new ArrayList<>();
                while(rs.next()){    
                    list.add(rs.getInt("tipo_proceso"));                                                      
                }    
                return list.toArray(new Integer[list.size()]);     
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
     * 
     * @param compania
     * @param nomina
     * @param year
     * @param month
     * @param type
     * @param concept
     * @return
     * @throws SQLException 
     */
    public Asignacion[] loadAsignacionesConceptoXMes(String compania, String nomina, int year, int month, int type, int concept) throws SQLException {
        try{
            Infocent bd = (Infocent) ConnBdType.open(ConnBdType.Oracle);
            connection = bd.open();

            StringBuilder sqlProc = new StringBuilder();

            if (connection != null){
                sqlProc.append(
                    "SELECT " +
                        "periodo, nomina, concepto, descto, tipo_proceso, proceso, subproceso, " +
                        "COUNT(*) num, SUM(cantidad) cantidad, SUM(monto) monto, SUM(saldo) saldo "+
                    "FROM " +
                        "asignacion " + 
                    "WHERE " + 
                        "compania = '" + compania + "' AND " +
                        "nomina = '" + nomina + "' AND " +
                        "ano = " + year + " AND " +
                        "mes = " + month + " AND " +
                        "tipo_proceso = " + type + " AND " +
                        "concepto = " + concept + " " +
                    "GROUP BY " +
                         "concepto, tipo_proceso, descto, proceso, subproceso, " + 
                         "periodo, nomina " + 
                    "ORDER BY " + 
                        "concepto, periodo, nomina, tipo_proceso");			

                Statement stmt = connection.createStatement();
                ResultSet rs = stmt.executeQuery(sqlProc.toString());
                
                List<Asignacion> list = new ArrayList<>();
                while(rs.next()) {
                    Asignacion obj = new Asignacion();       
                    obj.setNomina     (rs.getString("nomina"));
                    obj.setConcepto   (rs.getString("concepto"));
                    obj.setDescto     (rs.getString("descto"));
                    obj.setTipoProceso(rs.getInt("tipo_proceso"));
                    obj.setProceso    (rs.getString("proceso"));
                    obj.setSubproceso (rs.getInt("subproceso"));
                    obj.setPeriodo    (rs.getInt("periodo"));
                    obj.setNum        (rs.getInt("num"));
                    obj.setCantidad   (rs.getInt("cantidad"));
                    obj.setMonto      (rs.getDouble("monto"));
                    obj.setSaldo      (rs.getDouble("saldo"));
                    list.add(obj);
                }               
                return list.toArray(new Asignacion[list.size()]);                 
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
     * 
     * @param compania
     * @param nomina
     * @param year
     * @param month
     * @param type
     * @param concept
     * @return
     * @throws SQLException 
     */
    public Deduccion[] loadDeduccionesConceptoXMes(String compania, String nomina, int year, int month, int type, int concept) throws SQLException {
        try{
            Infocent bd = (Infocent) ConnBdType.open(ConnBdType.Oracle);
            connection = bd.open();

            StringBuilder sqlProc = new StringBuilder();

            if (connection != null){
                sqlProc.append(
                    "SELECT " +
                        "periodo, nomina, concepto, descto, tipo_proceso, proceso, subproceso, " +
                        "COUNT(*) num, SUM(cantidad) cantidad, SUM(monto) monto, SUM(saldo) saldo "+
                    "FROM " +
                        "deduccion " + 
                    "WHERE " + 
                        "compania = '" + compania + "' AND " +
                        "nomina = '" + nomina + "' AND " +
                        "ano = " + year + " AND " +
                        "mes = " + month + " AND " +
                        "tipo_proceso = " + type + " AND " +
                        "concepto = " + concept + " " +
                    "GROUP BY " +
                         "concepto, tipo_proceso, descto, proceso, subproceso, " + 
                         "periodo, nomina " + 
                    "ORDER BY " + 
                        "concepto, periodo, nomina, tipo_proceso");			

                Statement stmt = connection.createStatement();
                ResultSet rs = stmt.executeQuery(sqlProc.toString());
                
                List<Deduccion> list = new ArrayList<>();
                while(rs.next()) {
                    Deduccion obj = new Deduccion();       
                    obj.setNomina     (rs.getString("nomina"));
                    obj.setConcepto   (rs.getString("concepto"));
                    obj.setDescto     (rs.getString("descto"));
                    obj.setTipoProceso(rs.getInt("tipo_proceso"));
                    obj.setProceso    (rs.getString("proceso"));
                    obj.setSubproceso (rs.getInt("subproceso"));
                    obj.setPeriodo    (rs.getInt("periodo"));
                    obj.setNum        (rs.getInt("num"));
                    obj.setCantidad   (rs.getInt("cantidad"));
                    obj.setMonto      (rs.getDouble("monto"));
                    obj.setSaldo      (rs.getDouble("saldo"));
                    list.add(obj);
                }             
                return list.toArray(new Deduccion[list.size()]);                 
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
     * 
     * @param compania
     * @param nomina
     * @param year
     * @param month
     * @param type
     * @return
     * @throws SQLException 
     */
    public Asignacion[] loadAsignacionesEmpresaXProceso(String compania, String nomina, int year, int month, int type) throws SQLException {
        try{
            Infocent bd = (Infocent) ConnBdType.open(ConnBdType.Oracle);
            connection = bd.open();

            StringBuilder sqlProc = new StringBuilder();

            if (connection != null){
                if(month == -1){
                    sqlProc.append(
                        "SELECT " +
                            "nomina, concepto, descto, tipo_proceso, proceso, subproceso, " +
                            "COUNT(*) num, SUM(cantidad) cantidad, SUM(monto) monto, SUM(saldo) saldo " +
                      "FROM " +
                            "asignacion " + 
                        "WHERE " + 
                            "compania = '" + compania + "' AND " +
                            "nomina = '" + nomina + "' AND " +
                            "ano = " + year + " AND " +
                            "tipo_proceso = " + type + " " +
                        "GROUP BY " +
                             "concepto, tipo_proceso, descto, proceso, subproceso, " + 
                             "nomina " + 
                        "ORDER BY " + 
                            "nomina, concepto, tipo_proceso");			
                }else{
                    sqlProc.append(
                        "SELECT " +
                            "nomina, concepto, descto, tipo_proceso, proceso, subproceso, " +
                            "COUNT(*) num, SUM(cantidad) cantidad, SUM(monto) monto, SUM(saldo) saldo " +
                      "FROM " +
                            "asignacion " + 
                        "WHERE " + 
                            "compania = '" + compania + "' AND " +
                            "nomina = '" + nomina + "' AND " +
                            "ano = " + year + " AND " +
                            "mes = " + month + " AND " +
                            "tipo_proceso = " + type + " " +
                        "GROUP BY " +
                             "concepto, tipo_proceso, descto, proceso, subproceso,  " + 
                             "nomina " + 
                        "ORDER BY " + 
                            "nomina, concepto, tipo_proceso");			
                }

                Statement stmt = connection.createStatement();
                ResultSet rs = stmt.executeQuery(sqlProc.toString());
                
                List<Asignacion> list = new ArrayList<>();
                while(rs.next()) {
                    Asignacion obj = new Asignacion();       
                    obj.setNomina     (rs.getString("nomina"));
                    obj.setConcepto   (rs.getString("concepto"));
                    obj.setDescto     (rs.getString("descto"));
                    obj.setTipoProceso(rs.getInt("tipo_proceso"));
                    obj.setProceso    (rs.getString("proceso"));
                    obj.setSubproceso (rs.getInt("subproceso"));
                    obj.setNum        (rs.getInt("num"));
                    obj.setCantidad   (rs.getInt("cantidad"));
                    obj.setMonto      (rs.getDouble("monto"));
                    obj.setSaldo      (rs.getDouble("saldo"));
                    list.add(obj);
                }               
                return list.toArray(new Asignacion[list.size()]);                 
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
     * 
     * @param compania
     * @param nomina
     * @param year
     * @param month
     * @param type
     * @return
     * @throws SQLException 
     */
    public Deduccion[] loadDeduccionesEmpresaXProceso(String compania, String nomina, int year, int month, int type) throws SQLException {
        try{
            Infocent bd = (Infocent) ConnBdType.open(ConnBdType.Oracle);
            connection = bd.open();

            StringBuilder sqlProc = new StringBuilder();

            if (connection != null){
                if(month == -1){
                    sqlProc.append(
                        "SELECT " +
                            "nomina, concepto, descto, tipo_proceso, proceso, subproceso, " +
                            "COUNT(*) num, SUM(cantidad) cantidad, SUM(monto) monto, SUM(saldo) saldo " +
                      "FROM " +
                            "deduccion " + 
                        "WHERE " + 
                            "compania = '" + compania + "' AND " +
                            "nomina = '" + nomina + "' AND " +
                            "ano = " + year + " AND " +
                            "tipo_proceso = " + type + " " +
                        "GROUP BY " +
                             "concepto, tipo_proceso, descto, proceso, subproceso, " + 
                             "nomina " + 
                        "ORDER BY " + 
                            "nomina, concepto, tipo_proceso");			
                }else{
                    sqlProc.append(
                        "SELECT " +
                            "nomina, concepto, descto, tipo_proceso, proceso, subproceso, " +
                            "COUNT(*) num, SUM(cantidad) cantidad, SUM(monto) monto, SUM(saldo) saldo " +
                      "FROM " +
                            "deduccion " + 
                        "WHERE " + 
                            "compania = '" + compania + "' AND " +
                            "nomina = '" + nomina + "' AND " +
                            "ano = " + year + " AND " +
                            "mes = " + month + " AND " +
                            "tipo_proceso = " + type + " " +
                        "GROUP BY " +
                             "concepto, tipo_proceso, descto, proceso, subproceso, " + 
                             "nomina " + 
                        "ORDER BY " + 
                            "nomina, concepto, tipo_proceso");			
                }

                Statement stmt = connection.createStatement();
                ResultSet rs = stmt.executeQuery(sqlProc.toString());
                
                List<Deduccion> list = new ArrayList<>();
                while(rs.next()) {
                    Deduccion obj = new Deduccion();       
                    obj.setNomina     (rs.getString("nomina"));
                    obj.setConcepto   (rs.getString("concepto"));
                    obj.setDescto     (rs.getString("descto"));
                    obj.setTipoProceso(rs.getInt("tipo_proceso"));
                    obj.setProceso    (rs.getString("proceso"));
                    obj.setSubproceso (rs.getInt("subproceso"));
                    obj.setNum        (rs.getInt("num"));
                    obj.setCantidad   (rs.getInt("cantidad"));
                    obj.setMonto      (rs.getDouble("monto"));
                    obj.setSaldo      (rs.getDouble("saldo"));
                    list.add(obj);
                }             
                return list.toArray(new Deduccion[list.size()]);                 
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
    /**
     * 
     * @param compania
     * @param nomina
     * @param mes
     * @param ano
     * @return
     * @throws SQLException 
     */
    public Integer countFichaXEmpresaXMes(String compania,String nomina,int mes,int ano) throws SQLException {
        try{
            Infocent bd = (Infocent) ConnBdType.open(ConnBdType.Oracle);
            connection = bd.open();
            //
            if (connection != null){
                String query =  "SELECT COUNT(*) AS COUNT FROM (SELECT COMPANIA,FICHA FROM ASIGNACION "+
                                "WHERE COMPANIA = '"+compania+"' AND NOMINA = '"+nomina+"' AND MES = "+mes+" AND ANO = "+ano+" "+
                                "GROUP BY FICHA,NOMINA,COMPANIA)";			                
                Statement stmt = connection.createStatement();
                ResultSet rs = stmt.executeQuery(query);
                int result = 0;
                if(rs.next()){    
                    result = rs.getInt("COUNT");
                }    
                return result;
            }else{
                System.out.println("Error: Connexion no activa");
            }
        }catch(SQLException e){  
            StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
            Tools.getErrorMessage(stacktrace,"Error = " + e); 
//            System.out.println("stacktrace = " + "Error = " + e.getMessage());
        }finally{
            connection.close();
        }
        return null;
    }    
    /**
     * 
     * @param compania
     * @param nomina
     * @param ano
     * @return
     * @throws SQLException 
     */
    public Integer countFichaXEmpresaXAno(String compania,String nomina,int ano) throws SQLException {
        try{
            Infocent bd = (Infocent) ConnBdType.open(ConnBdType.Oracle);
            connection = bd.open();
            //
            if (connection != null){
                String query =  "SELECT COUNT(*) AS COUNT FROM (SELECT COMPANIA,FICHA FROM ASIGNACION "+
                                "WHERE COMPANIA = '"+compania+"' AND NOMINA = '"+nomina+"' AND ANO = "+ano+" "+
                                "GROUP BY FICHA,NOMINA,COMPANIA)";			                
                Statement stmt = connection.createStatement();
                ResultSet rs = stmt.executeQuery(query);
                int result = 0;
                if(rs.next()){    
                    result = rs.getInt("COUNT");
                }    
                return result;
            }else{
                System.out.println("Error: Connexion no activa");
            }
        }catch(SQLException e){  
            StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
            Tools.getErrorMessage(stacktrace,"Error = " + e); 
//            System.out.println("stacktrace = " + "Error = " + e.getMessage());
        }finally{
            connection.close();
        }
        return null;
    }           
    /**
     * 
     * @param compania
     * @param nomina
     * @param periodo
     * @param mes
     * @param ano
     * @return
     * @throws SQLException 
     */
    public Integer countFichaXVacacionesXPeriodo(String compania,String nomina,int periodo,int mes,int ano) throws SQLException {
        try{
            Infocent bd = (Infocent) ConnBdType.open(ConnBdType.Oracle);
            connection = bd.open();
            //
            if (connection != null){
                String query =  "SELECT COUNT(*) AS COUNT FROM (SELECT COMPANIA,FICHA FROM ASIGNACION "+
                                "WHERE COMPANIA = '"+compania+"' AND NOMINA = '"+nomina+"' AND TIPO_PROCESO = 4 "+
                                "AND PERIODO = "+periodo+" AND MES = "+mes+" AND ANO = "+ano+" GROUP BY FICHA,NOMINA,COMPANIA)";			                
                Statement stmt = connection.createStatement();
                ResultSet rs = stmt.executeQuery(query);
                int result = 0;
                if(rs.next()){    
                    result = rs.getInt("COUNT");
                }    
                return result;
            }else{
                System.out.println("Error: Connexion no activa");
            }
        }catch(SQLException e){  
            StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
            Tools.getErrorMessage(stacktrace,"Error = " + e); 
//            System.out.println("stacktrace = " + "Error = " + e.getMessage());
        }finally{
            connection.close();
        }
        return null;
    }    
    /***************************************************************************/
    /******************************* SINGLETON *********************************/
    /***************************************************************************/
    /**
     * 
     */
    private static class BdHolder {
        private static final Infocent INSTANCE = new Infocent();
    }
    /**
     * 
     * @return 
     */
    public static Infocent getInstance() {
        return Infocent.BdHolder.INSTANCE;
    }
}

