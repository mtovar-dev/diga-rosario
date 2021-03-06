/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package LN;

import BD.Bd;
import BD.Infocent;
import GUI.Gui;
import GUI.Screens.Screens;
import GUI.TopBar.TopBar;
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
import Objects.Setup.GroupSupplier;
import Objects.Infocent.Asignacion;
import Objects.Infocent.Concepto;
import Objects.Infocent.Deduccion;
import Objects.Infocent.Empleado;
import Objects.Infocent.Empresa;
import Objects.Inventory.InventoryBlockProd;
import Objects.Orders.Fxp_Inventa;
import Objects.Orders.Orders;
import Objects.Seniat.UploadExcelFile;
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
import Tools.Protector;
import Tools.Validar;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javafx.stage.Stage;


/**
 *
 * @author MITM
 */
public class Ln {
    public String userID;

    /***************************************************************************/
    /********************************** BD *************************************/
    /***************************************************************************/

    /**
     * 
     */
    public Ln(){        

    }    

    /***************************************************************************/
    /******************************** SESION ***********************************/
    /***************************************************************************/

    /**
     * 
     * @param userName
     * @param userPass
     * @return 
     */
    public boolean logIn(String userName, String userPass){
        boolean boo = Validar.validarLogIn(userName, userPass);
        if (boo){
            try{
                //Siempre y cuando no exceda el 3er intento
                if (Datos.getCont_login() < 3){
                    Datos.sumCont_login();
                    //Encrypt
                    String salt = java.util.ResourceBundle.getBundle("BD/DBcon").getString("dns");
                    userPass = Protector.encrypt(userPass, salt);
                    
                    Sesion sesion = Bd.getInstance().iniciarSesion(userName, userPass);
                    
                    if (sesion != null && sesion.getFullName() != null){
                        Datos.setCont_login(0);
                        Datos.setSesion(sesion);
                        Datos.getLocalHost();

                        //Solicito lo datos (siempre a travez de un proceso de LN)
                        if(Datos.getSesion().getStatus() == 0){
                            ItemLeftBar[] items =  loadMenu();
                            Datos.setItemLeftBar(items);
                            Gui.getLeftBar().loadLeftBar(items);    //Solicitud al proceso de impresion grafica
                            //
                            TopBar.refreshLogImage();
                            TopBar.refreshSesion(sesion);                        
                            Gui.getInstance().closeDialog(); 
                        }
                        else{
                            Gui.getInstance().showPassUpd("Cambio de Contraseña");  
                        }
                    }else{
                        throw new Exception("Usuario o Contraseña Incorrecta!");
                    }                
                }else{                
                    throw new Exception("Supero el numero de Intentos!\n Por Favor contacte a Sistemas!");
                }
            }catch(NullPointerException e){
                Gui.getInstance().showMessage("Error Iniciando Sesion!", "A");
            }catch(Exception e){
                Gui.getInstance().showMessage("Error Iniciando Sesion: \n" + e.getMessage(), "E");
            }
        }
        return false;
    }    
    /**
     * 
     * @return 
     */
    public boolean logOut(){        
        try{
            Datos.setCont_login(0);
            Bd.getInstance().cerrarSesion(Datos.getSesion());    
            Datos.setSesion(null);
            Gui.getLeftBar().clearLeftBar();
            TopBar.refreshLogImage();
            TopBar.refreshSesion(null);
            Gui.getInstance().closeDialog();
            Screens.getInstance().startIndex(new Stage());
                
        }catch(Exception e){
            Gui.getInstance().showMessage("Error Iniciando Sesion: \n" + e.getMessage(), "E");
        }
        return false;
    }    
    /**
     * 
     */
    public void closeApp(){        
        try{
            if(Datos.getSesion() == null){
                Bd.getInstance().cerrarSesion();
            }else{
                Bd.getInstance().cerrarSesion(Datos.getSesion());
            }                   
                
        }catch(Exception e){ }
    }

    /***************************************************************************/
    /******************************** AUDIT ************************************/
    /***************************************************************************/

    /***************************************************************************/
    /******************************** TOOLBAR **********************************/
    /***************************************************************************/
    /**
     * 
     * @return 
     */
    public ItemLeftBar[] loadMenu(){        
        try{
            ItemLeftBar[] menus = Bd.getInstance().load_Menu();      
            return menus;
        }catch(SQLException e){
            Gui.getInstance().showMessage("Por favor contactar a Sistemas: \n" + e.getMessage(), "I");
        }
        return null;
    }
    /**
     * 
     * @return 
     */
    public Integer[] loadToolBar() {
        try{
            Integer[] tools = Bd.getInstance().load_ToolBar();                         
            return tools;
        }catch(SQLException e){
            Gui.getInstance().showMessage("Por favor contactar a Sistemas: \n" + e.getMessage(), "I");
        }
        return null;
    }
    
    /***************************************************************************/
    /******************************** LEFTBAR **********************************/
    /***************************************************************************/
    

    /***************************************************************************/
    /********************************* USERS ***********************************/
    /***************************************************************************/
    
    /**
     * 
     * @return 
     */
    public Usuario[] load_Users(){        
        try{
            Usuario[] users = Bd.getInstance().load_Users();      
            return users;
        }catch(SQLException e){
            Gui.getInstance().showMessage("Error cargando Usuario: \n" + e.getMessage(), "E");
        }
        return null;
    }    
    /**
     * 
     * @return 
     */
    public Rol[] load_Rols() {
        try{
            Rol[] rols = Bd.getInstance().load_Rols();      
            return rols;
        }catch(SQLException e){
            Gui.getInstance().showMessage("Error cargando Usuario: \n" + e.getMessage(), "E");
        }
        return null;
    }    
    /**
     * 
     * @param usuario
     * @param pswd
     * @param operacion
     * @param ScreenName
     * @return 
     */
    public boolean save_Usuario(Usuario usuario, String pswd, int operacion, String ScreenName) {
        boolean boo = Validar.validarSaveUsuario(usuario,pswd);
        if (boo){
            try{                
                //Encrypt
                if(operacion == 1){
                    String salt = java.util.ResourceBundle.getBundle("BD/DBcon").getString("dns");
                    usuario.setPswd_old(Protector.encrypt(pswd, salt));
                }
                boolean result = Bd.getInstance().save_User(operacion, usuario);

                return result;
            }catch(Exception e){
                Gui.getInstance().showMessage("Error guardando " + ScreenName +": \n" + e.getMessage(), "E");
            }
        }        
        return false;
    }
    /**
     * 
     * @param username
     * @return 
     */
    public boolean check_UserName(String username) {
        try{
            return Bd.getInstance().check_UserName(username);                
        }catch(SQLException e){             
        }
        return false;
    }
    /**
     * 
     * @param usuario
     * @return 
     */
    public boolean change_UserStatus(Usuario usuario) {
        try{
            return Bd.getInstance().change_UserStatus(usuario);                
        }catch(Exception e){       
            Gui.getInstance().showMessage("Error deshabilitando Usuario: \n" + e.getMessage(), "E");
        }
        return false;
    }    
    /**
     * 
     * @param find 
     * @return  
     */
    public Usuario[] find_User(String find) {
        try{
            Usuario[] users = Bd.getInstance().find_User(find);      
            return users;
        }catch(SQLException e){
            Gui.getInstance().showMessage("Error en busqueda: \n" + e.getMessage(), "E");
        }
        return null;
    }    
    /**
     * 
     * @param usuario
     * @param old
     * @param pswd
     * @return 
     */
    public boolean update_UserPswd(Usuario usuario, String old, String pswd) {
        boolean boo = Validar.validar_UpdatePswd(Datos.getUser().getPswd_old(), old, usuario.getPswd_new(), pswd);
        if (boo){
            try{                
                //Encrypt
                String salt = java.util.ResourceBundle.getBundle("BD/DBcon").getString("dns");
                usuario.setPswd_old(Protector.encrypt(pswd, salt));
                
                return Bd.getInstance().save_User(3, usuario);                                
            }catch(Exception e){
                Gui.getInstance().showMessage("Error guardando Contraseña: \n" + e.getMessage(), "E");
            }
        }        
        return false;
    }

    /***************************************************************************/
    /********************************* ROLE ************************************/
    /***************************************************************************/
    
    /**
     * @author MITM
     * @lista para generar el reporte
     * @param role
     * @return 
     */
    public static List<Rol> getList_Rol(Rol[] role){
        List<Rol> list = new ArrayList<>();        
        list.addAll(Arrays.asList(role));        
        return list;
    }
    /**
     * @author MITM
     * @return 
     */
    public Rol[] load_Rol() {
        try{
            Rol[] role = Bd.getInstance().load_Rol();      
            return role;
        }catch(SQLException e){
            Gui.getInstance().showMessage("Error cargando Rol: \n" + e.getMessage(), "E");
        }
        return null;
    }    
    /**
     * @author MITM
     * @param find
     * @return 
     */
    public Rol[] find_Rol(String find) {
        try{
            Rol[] role = Bd.getInstance().find_Rol(find);      
            return role;
        }catch(SQLException e){
            Gui.getInstance().showMessage("Error cargando Rol: \n" + e.getMessage(), "E");
        }
        return null;
    }    
    /**
     * @author MITM
     * @param role
     * @param operacion
     * @param ScreenName
     * @return 
     */
    public boolean save_Rol(Rol role, int operacion, String ScreenName) {
        boolean boo = Validar.validar_Save_Rol(role);
        if (boo){
            try{                
                boolean result = Bd.getInstance().save_Rol(operacion, role);

                return result;
            }catch(Exception e){
                Gui.getInstance().showMessage("Error guardando " + ScreenName +": \n" + e.getMessage(), "E");
            }
        }        
        return false;
    }
    /**
     * @author MITM
     * @param rolename
     * @return 
     */
    public boolean check_Rol(String rolename) {
        try{
            return Bd.getInstance().check_Rol(rolename);                
        }catch(SQLException e){             
        }
        return false;
    }
    /**
     * @author MITM
     * @param role
     * @return 
     */
    public boolean change_Rol(Rol role) {
        try{
            return Bd.getInstance().change_Rol(role);                
        }catch(Exception e){       
            Gui.getInstance().showMessage("Error deshabilitando Rol: \n" + e.getMessage(), "E");
        }
        return false;
    }    
    
    /***************************************************************************/
    /******************************** BRANCH ***********************************/
    /***************************************************************************/    
    /**
     * @author MITM
     * @lista para generar el reporte
     * @param unit
     * @return 
     */
    public static List<Branch> getList_Branch(Branch[] branch){
        List<Branch> list = new ArrayList<>();        
        list.addAll(Arrays.asList(branch));        
        return list;
    }
    /**
     * @author MITM
     * @return 
     */
    public Branch[] load_Branch() {
        try{
            Branch[] branch = Bd.getInstance().load_Branch();      
            return branch;
        }catch(SQLException e){
            Gui.getInstance().ventanaError("Error Cargando Sucursal: \n"+e.getMessage()); 
        }
        return null;
    }    
    /**
     * @author MITM
     * @param find
     * @return 
     */
    public Branch[] find_Branch(String find) {
        try{
            Branch[] branch = Bd.getInstance().find_Branch(find);      
            return branch;
        }catch(SQLException e){
            Gui.getInstance().ventanaError("Error Cargando Sucursal: \n"+e.getMessage()); 
        }
        return null;
    }    
    /**
     * @author MITM
     * @param unit
     * @param operacion
     * @param ScreenName
     * @return 
     */
    public boolean save_Branch(Branch branch, int operacion, String ScreenName) {
        boolean boo = Validar.validar_Save_Branch(branch);
        if (boo){
            try{                
                boolean result = Bd.getInstance().save_Branch(operacion, branch);

                return result;
            }catch(Exception e){
                Gui.getInstance().showMessage("Error guardando " + ScreenName +": \n" + e.getMessage(), "E");
            }
        }        
        return false;
    }
    /**
     * @author MITM
     * @param branchname
     * @return 
     */
    public boolean check_Branch(String branchname) {
        try{
            return Bd.getInstance().check_Unit(branchname);                
        }catch(SQLException e){             
        }
        return false;
    }
    /**
     * @author MITM
     * @param branch
     * @return 
     */
    public boolean change_Branch(Branch branch) {
        try{
            return Bd.getInstance().change_Branch(branch);                
        }catch(Exception e){       
            Gui.getInstance().ventanaError("Error Deshabilitando Sucursal: \n"+e.getMessage()); 
        }
        return false;
    }        

    /***************************************************************************/
    /***************************** GROUPSUPPLIER *******************************/
    /***************************************************************************/
    
    /**
     * @author MITM
     * @lista para generar el reporte
     * @param groupsupplier
     * @return 
     */
    public static List<GroupSupplier> getList_GroupSupplier(GroupSupplier[] groupsupplier){
        List<GroupSupplier> list = new ArrayList<>();        
        list.addAll(Arrays.asList(groupsupplier));        
        return list;
    }
    /**
     * @author MITM
     * @return 
     */
    public GroupSupplier[] load_GroupSupplier() {
        try{
            GroupSupplier[] groupsupplier = Bd.getInstance().load_GroupSupplier();      
            return groupsupplier;
        }catch(SQLException e){
            Gui.getInstance().showMessage("Error cargando Grupo de Proveedor: \n" + e.getMessage(), "E");
        }
        return null;
    }    
    /**
     * @author MITM
     * @param find
     * @return 
     */
    public GroupSupplier[] find_GroupSupplier(String find) {
        try{
            GroupSupplier[] groupsupplier = Bd.getInstance().find_GroupSupplier(find);      
            return groupsupplier;
        }catch(SQLException e){
            Gui.getInstance().showMessage("Error cargando Grupo de Proveedor: \n" + e.getMessage(), "E");
        }
        return null;
    }    
    /**
     * @author MITM
     * @param groupsupplier
     * @param operacion
     * @param ScreenName
     * @return 
     */
    public boolean save_GroupSupplier(GroupSupplier groupsupplier, int operacion, String ScreenName) {
        boolean boo = Validar.validar_Save_GroupSupplier(groupsupplier);
        if (boo){
            try{                
                boolean result = Bd.getInstance().save_GroupSupplier(operacion, groupsupplier);

                return result;
            }catch(Exception e){
                Gui.getInstance().showMessage("Error guardando " + ScreenName +": \n" + e.getMessage(), "E");
            }
        }        
        return false;
    }
    /**
     * @author MITM
     * @param groupsuppliername
     * @return 
     */
    public boolean check_GroupSupplier(String groupsuppliername) {
        try{
            return Bd.getInstance().check_GroupSupplier(groupsuppliername);                
        }catch(SQLException e){             
        }
        return false;
    }
    /**
     * @author MITM
     * @param groupsupplier
     * @return 
     */
    public boolean change_GroupSupplier(GroupSupplier groupsupplier) {
        try{
            return Bd.getInstance().change_GroupSupplier(groupsupplier);                
        }catch(Exception e){       
            Gui.getInstance().showMessage("Error deshabilitando Grupo de Proveedor: \n" + e.getMessage(), "E");
        }
        return false;
    }    
    
    
    /***************************************************************************/
    /******************************** COUNTRY **********************************/
    /***************************************************************************/
    
    /**
     * @author MITM
     * @return 
     */
    public Country[] load_Country() {
        try{
            Country[] country = Bd.getInstance().load_Country();      
            return country;
        }catch(SQLException e){
            Gui.getInstance().showMessage("Error cargando País: \n" + e.getMessage(), "E");
        }
        return null;
    }    

    
    /***************************************************************************/
    /********************************* STATE ***********************************/
    /***************************************************************************/
    
    /**
     * @author MITM
     * @return 
     */
    public State[] load_State() {
        try{
            State[] state = Bd.getInstance().load_State();      
            return state;
        }catch(SQLException e){
            Gui.getInstance().showMessage("Error cargando Estado: \n" + e.getMessage(), "E");
        }
        return null;
    }    
    /**
     * @author MITM
     * @param find
     * @return 
     */
    public State[] find_State(String find) {
        try{
            State[] state = Bd.getInstance().find_State(find);      
            return state;
        }catch(SQLException e){
            Gui.getInstance().showMessage("Error cargando Estado: \n" + e.getMessage(), "E");
        }
        return null;
    }    

    
    /***************************************************************************/
    /********************************** CITY ***********************************/
    /***************************************************************************/
    
    /**
     * @author MITM
     * @return 
     */
    public City[] load_City() {
        try{
            City[] city = Bd.getInstance().load_City();      
            return city;
        }catch(SQLException e){
            Gui.getInstance().showMessage("Error cargando Ciudad: \n" + e.getMessage(), "E");
        }
        return null;
    }    
    /**
     * @author MITM
     * @param find
     * @return 
     */
    public City[] find_City(String find) {
        try{
            City[] city = Bd.getInstance().find_City(find);      
            return city;
        }catch(SQLException e){
            Gui.getInstance().showMessage("Error cargando Ciudad: \n" + e.getMessage(), "E");
        }
        return null;
    }    

    
    /***************************************************************************/
    /****************************** MUNICIPALITY *******************************/
    /***************************************************************************/
    
    /**
     * @author MITM
     * @return 
     */
    public Municipality[] load_Municipality() {
        try{
            Municipality[] municipality = Bd.getInstance().load_Municipality();      
            return municipality;
        }catch(SQLException e){
            Gui.getInstance().showMessage("Error cargando Municipio: \n" + e.getMessage(), "E");
        }
        return null;
    }    
    /**
     * @author MITM
     * @param find
     * @return 
     */
    public Municipality[] find_Municipality(String find) {
        try{
            Municipality[] municipality = Bd.getInstance().find_Municipality(find);      
            return municipality;
        }catch(SQLException e){
            Gui.getInstance().showMessage("Error cargando Municipio: \n" + e.getMessage(), "E");
        }
        return null;
    }    

    
    /***************************************************************************/
    /********************************* PARISH **********************************/
    /***************************************************************************/
    
    /**
     * @author MITM
     * @return 
     */
    public Parish[] load_Parish() {
        try{
            Parish[] parish = Bd.getInstance().load_Parish();      
            return parish;
        }catch(SQLException e){
            Gui.getInstance().showMessage("Error cargando Parroquia: \n" + e.getMessage(), "E");
        }
        return null;
    }    
    /**
     * @author MITM
     * @param findM
     * @param findS
     * @return 
     */
    public Parish[] find_Parish(String findM, String findS) {
        try{
            Parish[] parish = Bd.getInstance().find_Parish(findM, findS);   
            return parish;
        }catch(SQLException e){
            Gui.getInstance().showMessage("Error cargando Parroquia: \n" + e.getMessage(), "E");
        }
        return null;
    }    

    
    /***************************************************************************/
    /******************************** MEASURE **********************************/
    /***************************************************************************/    
    /**
     * @author MITM
     * @lista para generar el reporte
     * @param measure
     * @return 
     */
    public static List<Measure> getList_Measure(Measure[] measure){
        List<Measure> list = new ArrayList<>();        
        list.addAll(Arrays.asList(measure));        
        return list;
    }
    /**
     * @author MITM
     * @return 
     */
    public Measure[] load_Measure() {
        try{
            Measure[] measure = Bd.getInstance().load_Measure();      
            return measure;
        }catch(SQLException e){
            Gui.getInstance().showMessage("Error cargando Medida: \n" + e.getMessage(), "E");
        }
        return null;
    }    
    /**
     * @author MITM
     * @param find
     * @return 
     */
    public Measure[] find_Measure(String find) {
        try{
            Measure[] measure = Bd.getInstance().find_Measure(find);      
            return measure;
        }catch(SQLException e){
            Gui.getInstance().showMessage("Error cargando Medida: \n" + e.getMessage(), "E");
        }
        return null;
    }    
    /**
     * @author MITM
     * @param measure
     * @param operacion
     * @param ScreenName
     * @return 
     */
    public boolean save_Measure(Measure measure, int operacion, String ScreenName) {
        boolean boo = Validar.validar_Save_Measure(measure);
        if (boo){
            try{                
                boolean result = Bd.getInstance().save_Measure(operacion, measure);

                return result;
            }catch(Exception e){
                Gui.getInstance().showMessage("Error guardando " + ScreenName +": \n" + e.getMessage(), "E");
            }
        }        
        return false;
    }
    /**
     * @author MITM
     * @param measurename
     * @return 
     */
    public boolean check_Measure(String measurename) {
        try{
            return Bd.getInstance().check_Measure(measurename);                
        }catch(SQLException e){             
        }
        return false;
    }
    /**
     * @author MITM
     * @param measure
     * @return 
     */
    public boolean change_Measure(Measure measure) {
        try{
            return Bd.getInstance().change_Measure(measure);                
        }catch(Exception e){       
            Gui.getInstance().ventanaError("Error Deshabilitando Medida: \n"+e.getMessage()); 
        }
        return false;
    }    
    /***************************************************************************/
    /********************************* UNIT ************************************/
    /***************************************************************************/    
    /**
     * @author MITM
     * @lista para generar el reporte
     * @param unit
     * @return 
     */
    public static List<Unit> getList_Unit(Unit[] unit){
        List<Unit> list = new ArrayList<>();        
        list.addAll(Arrays.asList(unit));        
        return list;
    }
    /**
     * @author MITM
     * @return 
     */
    public Unit[] load_Unit() {
        try{
            Unit[] unit = Bd.getInstance().load_Unit();      
            return unit;
        }catch(SQLException e){
            Gui.getInstance().ventanaError("Error Cargando Unidad: \n"+e.getMessage()); 
        }
        return null;
    }    
    /**
     * @author MITM
     * @param find
     * @return 
     */
    public Unit[] find_Unit(String find) {
        try{
            Unit[] unit = Bd.getInstance().find_Unit(find);      
            return unit;
        }catch(SQLException e){
            Gui.getInstance().ventanaError("Error Cargando Unidad: \n"+e.getMessage()); 
        }
        return null;
    }    
    /**
     * @author MITM
     * @param unit
     * @param operacion
     * @param ScreenName
     * @return 
     */
    public boolean save_Unit(Unit unit, int operacion, String ScreenName) {
        boolean boo = Validar.validar_Save_Unit(unit);
        if (boo){
            try{                
                boolean result = Bd.getInstance().save_Unit(operacion, unit);

                return result;
            }catch(Exception e){
                Gui.getInstance().showMessage("Error guardando " + ScreenName +": \n" + e.getMessage(), "E");
            }
        }        
        return false;
    }
    /**
     * @author MITM
     * @param unitname
     * @return 
     */
    public boolean check_Unit(String unitname) {
        try{
            return Bd.getInstance().check_Unit(unitname);                
        }catch(SQLException e){             
        }
        return false;
    }
    /**
     * @author MITM
     * @param unit
     * @return 
     */
    public boolean change_Unit(Unit unit) {
        try{
            return Bd.getInstance().change_Unit(unit);                
        }catch(Exception e){       
            Gui.getInstance().ventanaError("Error Deshabilitando Unidad: \n"+e.getMessage()); 
        }
        return false;
    }        
    /***************************************************************************/
    /******************************** REASON ***********************************/
    /***************************************************************************/    
    /**
     * @author MITM
     * @lista para generar el reporte
     * @param log_tmotdev
     * @return 
     */
    public static List<log_TMotdev> getList_log_TMotdev(log_TMotdev[] log_tmotdev){
        List<log_TMotdev> list = new ArrayList<>();        
        list.addAll(Arrays.asList(log_tmotdev));        
        return list;
    }
    /**
     * @author MITM
     * @return 
     */
    public log_TMotdev[] load_log_TMotdev() {
        try{
            log_TMotdev[] log_tmotdev = Bd.getInstance().load_log_TMotdev();      
            return log_tmotdev;
        }catch(SQLException e){
            Gui.getInstance().ventanaError("Error Cargando Motivo: \n"+e.getMessage()); 
        }
        return null;
    }    
    /**
     * @author MITM
     * @param find
     * @return 
     */
    public log_TMotdev[] find_log_TMotdev(String find) {
        try{
            log_TMotdev[] log_tmotdev = Bd.getInstance().find_log_TMotdev(find);      
            return log_tmotdev;
        }catch(SQLException e){
            Gui.getInstance().ventanaError("Error Cargando Motivo: \n"+e.getMessage()); 
        }
        return null;
    }    
    /**
     * @author MITM
     * @param log_tmotdev
     * @param operacion
     * @param ScreenName
     * @return 
     */
    public boolean save_log_TMotdev(log_TMotdev log_tmotdev, int operacion, String ScreenName) {
        boolean boo = Validar.validar_Save_log_TMotdev(log_tmotdev);
        if (boo){
            try{                
                boolean result = Bd.getInstance().save_log_TMotdev(operacion, log_tmotdev);

                return result;
            }catch(Exception e){
                Gui.getInstance().showMessage("Error guardando " + ScreenName +": \n" + e.getMessage(), "E");
            }
        }        
        return false;
    }
    /**
     * @author MITM
     * @param log_tmotdevname
     * @return 
     */
    public boolean check_log_TMotdev(String log_tmotdevname) {
        try{
            return Bd.getInstance().check_log_TMotdev(log_tmotdevname);                
        }catch(SQLException e){             
        }
        return false;
    }
    /**
     * @author MITM
     * @param log_tmotdev
     * @return 
     */
    public boolean change_log_TMotdev(log_TMotdev log_tmotdev) {
        try{
            return Bd.getInstance().change_log_TMotdev(log_tmotdev);                
        }catch(Exception e){       
            Gui.getInstance().ventanaError("Error Deshabilitando Motivo: \n"+e.getMessage()); 
        }
        return false;
    }        
    /***************************************************************************/
    /******************************** SUPPLIER *********************************/
    /***************************************************************************/    
    /**
     * @author MITM
     * @lista para generar el reporte
     * @param supplier
     * @return 
     */
    public static List<Supplier> getList_Supplier(Supplier[] supplier){
        List<Supplier> list = new ArrayList<>();        
        list.addAll(Arrays.asList(supplier));        
        return list;
    }
    /**
     * @author MITM
     * @return 
     */
    public Supplier[] load_Supplier() {
        try{
            Supplier[] supplier = Bd.getInstance().load_Supplier();      
            return supplier;
        }catch(SQLException e){
            Gui.getInstance().ventanaError("Error Cargando Proveedor: \n"+e.getMessage()); 
        }
        return null;
    }    
    /**
     * @author MITM
     * @param find
     * @return 
     */
    public Supplier[] find_Supplier(String find) {
        try{
            Supplier[] supplier = Bd.getInstance().find_Supplier(find);      
            return supplier;
        }catch(SQLException e){
            Gui.getInstance().ventanaError("Error Cargando Proveedor: \n"+e.getMessage()); 
        }
        return null;
    }    
    /**
     * @author MITM
     * @param supplier
     * @param operacion
     * @param ScreenName
     * @return 
     */
    public boolean save_Supplier(Supplier supplier, int operacion, String ScreenName) {
        try{                
            boolean result = Bd.getInstance().save_Supplier(operacion, supplier);

            return result;
        }catch(Exception e){
            Gui.getInstance().showMessage("Error guardando " + ScreenName +": \n" + e.getMessage(), "E");
        }
        return false;
    }
    /**
     * @author MITM
     * @param supplierRif
     * @return 
     */
    public boolean check_Supplier(String supplierRif) {
        try{
            return Bd.getInstance().check_Supplier(supplierRif);                
        }catch(SQLException e){             
        }
        return false;
    }
    /**
     * @author MITM
     * @param supplier
     * @return 
     */
    public boolean change_Supplier(Supplier supplier) {
        try{
            return Bd.getInstance().change_Supplier(supplier);                
        }catch(Exception e){       
            Gui.getInstance().ventanaError("Error Deshabilitando Proveedor: \n"+e.getMessage()); 
        }
        return false;
    }  
    /***************************************************************************/
    /****************************** LOG_PERSONAL *******************************/
    /***************************************************************************/
    /**
     * @author MITM
     * @lista para generar el reporte
     * @param personal
     * @return 
     */
    public static List<log_Personal> getList_log_Personal(log_Personal[] personal){
        List<log_Personal> list = new ArrayList<>();        
        list.addAll(Arrays.asList(personal));        
        return list;
    }
    /**
     * @author MITM
     * @return 
     */
    public log_Personal[] load_log_Personal() {
        try{
            log_Personal[] log_personal = Bd.getInstance().load_log_Personal();      
            return log_personal;
        }catch(SQLException e){
            Gui.getInstance().ventanaError("Error Cargando Personal: \n"+e.getMessage()); 
        }
        return null;
    }    
    /**
     * @author MITM
     * @param log_personal
     * @param operacion
     * @param ScreenName
     * @return 
     */
    public boolean save_log_Personal(log_Personal log_personal, int operacion, String ScreenName) {
        boolean boo = Validar.validar_Save_log_Personal(log_personal);
        if (boo){
            try{                
                boolean result = Bd.getInstance().save_log_Personal(operacion, log_personal);

                return result;
            }catch(Exception e){
                Gui.getInstance().showMessage("Error guardando " + ScreenName +": \n" + e.getMessage(), "E");
            }
        }        
        return false;
    }
    /**
     * @author MITM
     * @param supplierRif
     * @return 
     */
    public boolean check_log_Personal(String supplierRif) {
        try{
            return Bd.getInstance().check_log_Personal(supplierRif);                
        }catch(SQLException e){             
        }
        return false;
    }
    /**
     * @author MITM
     * @param log_personal
     * @return 
     */
    public boolean change_log_Personal(log_Personal log_personal) {
        try{
            return Bd.getInstance().change_log_Personal(log_personal);                
        }catch(Exception e){       
            Gui.getInstance().ventanaError("Error Deshabilitando Personal: \n"+e.getMessage()); 
        }
        return false;
    }    
    /**
     * @author MITM
     * @param find
     * @return 
     */
    public log_Personal[] find_log_Personal(String find) {
        try{
            log_Personal[] log_personal = Bd.getInstance().find_log_Personal(find);      
            return log_personal;
        }catch(SQLException e){
            Gui.getInstance().ventanaError("Error Cargando Personal: \n"+e.getMessage()); 
        }
        return null;
    }    
    /**
     * @author MITM
     * @param find
     * @param tpersonal1
     * @param tpersonal2
     * @return 
     */
    public log_Personal[] find_log_Personal_tp(String find, int tpersonal1, int tpersonal2) {
        try{
            log_Personal[] log_personal = Bd.getInstance().find_log_Personal_tp(find, tpersonal1, tpersonal2);      
            return log_personal;
        }catch(SQLException e){
            Gui.getInstance().ventanaError("Error Cargando Personal: \n"+e.getMessage()); 
        }
        return null;
    }    
    /**
     * @author MITM
     * @param param1
     * @param param2
     * @return 
     */
    public log_Personal[] print_log_Personal(String param1, String param2) {
        try{
            log_Personal[] log_personal = Bd.getInstance().print_log_Personal(param1, param2);      
            return log_personal;
        }catch(SQLException e){
            Gui.getInstance().ventanaError("Error Cargando Personal: \n"+e.getMessage()); 
        }
        return null;
    }        
    /***************************************************************************/
    /********************************* SEX *************************************/
    /***************************************************************************/   
    /**
     * @author MITM
     * @lista para generar el reporte
     * @param sex
     * @return 
     */
    public static List<Sex> getList_Sex(Sex[] sex){
        List<Sex> list = new ArrayList<>();        
        list.addAll(Arrays.asList(sex));        
        return list;
    }
    /**
     * @author MITM
     * @return 
     */
    public Sex[] load_Sex() {
        try{
            Sex[] sex = Bd.getInstance().load_Sex();      
            return sex;
        }catch(SQLException e){
            Gui.getInstance().ventanaError("Error Cargando Sexo: \n"+e.getMessage()); 
        }
        return null;
    }    
    /**
     * @author MITM
     * @param find
     * @return 
     */
    public Sex[] find_Sex(String find) {
        try{
            Sex[] sex = Bd.getInstance().find_Sex(find);      
            return sex;
        }catch(SQLException e){
            Gui.getInstance().ventanaError("Error Cargando Sexo: \n"+e.getMessage()); 
        }
        return null;
    }    
    /**
     * @author MITM
     * @param sex
     * @param operacion
     * @return 
     */
    public boolean save_Sex(Sex sex, int operacion) {
        boolean boo = Validar.validar_Save_Sex(sex);
        if (boo){
            try{                
                boolean result = Bd.getInstance().save_Sex(operacion, sex);

                return result;
            }catch(Exception e){
                Gui.getInstance().ventanaError("Error guardando Sexo: \n"+e.getMessage()); 
            }
        }        
        return false;
    }
    /**
     * @author MITM
     * @param sexname
     * @return 
     */
    public boolean check_Sex(String sexname) {
        try{
            return Bd.getInstance().check_Sex(sexname);                
        }catch(SQLException e){             
        }
        return false;
    }
    /**
     * @author MITM
     * @param sex
     * @return 
     */
    public boolean change_Sex(Sex sex) {
        try{
            return Bd.getInstance().change_Sex(sex);                
        }catch(Exception e){       
            Gui.getInstance().ventanaError("Error Deshabilitando Sexo: \n"+e.getMessage()); 
        }
        return false;
    }    
    /***************************************************************************/
    /**************************** LOG_TPERSONAL ********************************/
    /***************************************************************************/   
    /**
     * @author MITM
     * @lista para generar el reporte
     * @param tpersonal
     * @return 
     */
    public static List<log_TPersonal> getList_log_TPersonal(log_TPersonal[] tpersonal){
        List<log_TPersonal> list = new ArrayList<>();        
        list.addAll(Arrays.asList(tpersonal));        
        return list;
    }
    /**
     * @author MITM
     * @return 
     */
    public log_TPersonal[] load_log_TPersonal() {
        try{
            log_TPersonal[] log_tpersonal = Bd.getInstance().load_log_TPersonal();      
            return log_tpersonal;
        }catch(SQLException e){
            Gui.getInstance().ventanaError("Error Cargando Tipo de Personal: \n"+e.getMessage()); 
        }
        return null;
    }    
    /**
     * @author MITM
     * @param find
     * @return 
     */
    public log_TPersonal[] find_log_TPersonal(String find) {
        try{
            log_TPersonal[] log_tpersonal = Bd.getInstance().find_log_TPersonal(find);      
            return log_tpersonal;
        }catch(SQLException e){
            Gui.getInstance().ventanaError("Error Cargando Tipo de Personal: \n"+e.getMessage()); 
        }
        return null;
    }    
    /**
     * @author MITM
     * @param log_tpersonal
     * @param operacion
     * @return 
     */
    public boolean save_log_TPersonal(log_TPersonal log_tpersonal, int operacion) {
        boolean boo = Validar.validar_Save_log_TPersonal(log_tpersonal);
        if (boo){
            try{                
                boolean result = Bd.getInstance().save_log_TPersonal(operacion, log_tpersonal);

                return result;
            }catch(Exception e){
                Gui.getInstance().ventanaError("Error guardando Tipo de Personal: \n"+e.getMessage()); 
            }
        }        
        return false;
    }
    /**
     * @author MITM
     * @param tpersonalname
     * @return 
     */
    public boolean check_log_TPersonal(String tpersonalname) {
        try{
            return Bd.getInstance().check_Sex(tpersonalname);                
        }catch(SQLException e){             
        }
        return false;
    }
    /**
     * @author MITM
     * @param log_tpersonal
     * @return 
     */
    public boolean change_log_TPersonal(log_TPersonal log_tpersonal) {
        try{
            return Bd.getInstance().change_log_TPersonal(log_tpersonal);                
        }catch(Exception e){       
            Gui.getInstance().ventanaError("Error Deshabilitando Tipo de Personal: \n"+e.getMessage()); 
        }
        return false;
    }    
    /***************************************************************************/
    /******************************* VEHICULOS *********************************/
    /***************************************************************************/    
    /**
     * @author MITM
     * @lista para generar el reporte
     * @param vehiculo
     * @return 
     */
    public static List<log_Vehiculos> getList_log_Vehiculos(log_Vehiculos[] vehiculo){
        List<log_Vehiculos> list = new ArrayList<>();        
        list.addAll(Arrays.asList(vehiculo));        
        return list;
    }
    /**
     * @author MITM
     * @return 
     */
    public log_Vehiculos[] load_log_Vehiculos() {
        try{
            log_Vehiculos[] log_vehiculos = Bd.getInstance().load_log_Vehiculos();      
            return log_vehiculos;
        }catch(SQLException e){
            Gui.getInstance().ventanaError("Error Cargando Vehiculo: \n"+e.getMessage()); 
        }
        return null;
    }    
    /**
     * @author MITM
     * @param find
     * @return 
     */
    public log_Vehiculos[] find_log_Vehiculos(String find) {
        try{
            log_Vehiculos[] log_vehiculos = Bd.getInstance().find_log_Vehiculos(find);      
            return log_vehiculos;
        }catch(SQLException e){
            Gui.getInstance().ventanaError("Error Cargando Vehiculo: \n"+e.getMessage()); 
        }
        return null;
    }    
    /**
     * @author MITM
     * @param log_vehiculos
     * @param operacion
     * @param ScreenName
     * @return 
     */
    public boolean save_log_Vehiculos(log_Vehiculos log_vehiculos, int operacion, String ScreenName) {
        boolean boo = Validar.validar_Save_log_Vehiculos(log_vehiculos);
        if (boo){
            try{                
                boolean result = Bd.getInstance().save_log_Vehiculos(operacion, log_vehiculos);

                return result;
            }catch(Exception e){
                Gui.getInstance().showMessage("Error guardando " + ScreenName +": \n" + e.getMessage(), "E");
            }
        }        
        return false;
    }
    /**
     * @author MITM
     * @param NroPlaca
     * @return 
     */
    public boolean check_log_Vehiculos(String NroPlaca) {
        try{
            return Bd.getInstance().check_log_Vehiculos(NroPlaca);                
        }catch(SQLException e){             
        }
        return false;
    }
    /**
     * @author MITM
     * @param log_vehiculos
     * @return 
     */
    public boolean change_log_Vehiculos(log_Vehiculos log_vehiculos) {
        try{
            return Bd.getInstance().change_log_Vehiculos(log_vehiculos);                
        }catch(Exception e){       
            Gui.getInstance().ventanaError("Error Deshabilitando Vehiculo: \n"+e.getMessage()); 
        }
        return false;
    }    
    /**
     * @author MITM
     * @param param1
     * @param param2
     * @return 
     */
    public log_Vehiculos[] print_log_Vehiculos(String param1, String param2) {
        try{
            log_Vehiculos[] log_vehiculos = Bd.getInstance().print_log_Vehiculos(param1, param2);      
            return log_vehiculos;
        }catch(SQLException e){
            Gui.getInstance().ventanaError("Error Cargando Vehiculo: \n"+e.getMessage()); 
        }
        return null;
    }        
    /***************************************************************************/
    /****************************** log_TMarca *********************************/
    /***************************************************************************/    
    /**
     * @author MITM
     * @lista para generar el reporte
     * @param log_tmarca
     * @return 
     */
    public static List<log_TMarca> getList_log_TMarca(log_TMarca[] log_tmarca){
        List<log_TMarca> list = new ArrayList<>();        
        list.addAll(Arrays.asList(log_tmarca));        
        return list;
    }
    /**
     * @author MITM
     * @return 
     */
    public log_TMarca[] load_log_TMarca() {
        try{
            log_TMarca[] log_tmarca = Bd.getInstance().load_log_TMarca();      
            return log_tmarca;
        }catch(SQLException e){
            Gui.getInstance().ventanaError("Error Cargando Tipo de Marca: \n"+e.getMessage()); 
        }
        return null;
    }    
    /**
     * @author MITM
     * @param find
     * @return 
     */
    public log_TMarca[] find_log_TMarca(String find) {
        try{
            log_TMarca[] log_tmarca = Bd.getInstance().find_log_TMarca(find);      
            return log_tmarca;
        }catch(SQLException e){
            Gui.getInstance().ventanaError("Error Cargando Tipo de Marca: \n"+e.getMessage()); 
        }
        return null;
    }    
    /**
     * @author MITM
     * @param log_tmarca
     * @param operacion
     * @return 
     */
    public boolean save_log_TMarca(log_TMarca log_tmarca, int operacion) {
        boolean boo = Validar.validar_Save_log_TMarca(log_tmarca);
        if (boo){
            try{                
                boolean result = Bd.getInstance().save_log_TMarca(operacion, log_tmarca);

                return result;
            }catch(Exception e){
                Gui.getInstance().ventanaError("Error guardando Tipo de Marca: \n"+e.getMessage()); 
            }
        }        
        return false;
    }
    /**
     * @author MITM
     * @param tmarcaname
     * @return 
     */
    public boolean check_log_TMarca(String tmarcaname) {
        try{
            return Bd.getInstance().check_log_TMarca(tmarcaname);                
        }catch(SQLException e){             
        }
        return false;
    }
    /**
     * @author MITM
     * @param log_tmarca
     * @return 
     */
    public boolean change_log_TMarca(log_TMarca log_tmarca) {
        try{
            return Bd.getInstance().change_log_TMarca(log_tmarca);                
        }catch(Exception e){       
            Gui.getInstance().ventanaError("Error Deshabilitando Tipo de Marca: \n"+e.getMessage()); 
        }
        return false;
    }    
    /***************************************************************************/
    /****************************** log_TProced ********************************/
    /***************************************************************************/    
    /**
     * @author MITM
     * @lista para generar el reporte
     * @param log_tproced
     * @return 
     */
    public static List<log_TProced> getList_log_TProced(log_TProced[] log_tproced){
        List<log_TProced> list = new ArrayList<>();        
        list.addAll(Arrays.asList(log_tproced));        
        return list;
    }
    /**
     * @author MITM
     * @return 
     */
    public log_TProced[] load_log_TProced() {
        try{
            log_TProced[] log_tproced = Bd.getInstance().load_log_TProced();      
            return log_tproced;
        }catch(SQLException e){
            Gui.getInstance().ventanaError("Error Cargando Tipo de Procedencia: \n"+e.getMessage()); 
        }
        return null;
    }    
    /**
     * @author MITM
     * @param find
     * @return 
     */
    public log_TProced[] find_log_TProced(String find) {
        try{
            log_TProced[] log_tproced = Bd.getInstance().find_log_TProced(find);      
            return log_tproced;
        }catch(SQLException e){
            Gui.getInstance().ventanaError("Error Cargando Tipo de Procedencia: \n"+e.getMessage()); 
        }
        return null;
    }    
    /**
     * @author MITM
     * @param log_tproced
     * @param operacion
     * @return 
     */
    public boolean save_log_TProced(log_TProced log_tproced, int operacion) {
        boolean boo = Validar.validar_Save_log_TProced(log_tproced);
        if (boo){
            try{                
                boolean result = Bd.getInstance().save_log_TProced(operacion, log_tproced);

                return result;
            }catch(Exception e){
                Gui.getInstance().ventanaError("Error guardando Tipo de Procedencia: \n"+e.getMessage()); 
            }
        }        
        return false;
    }
    /**
     * @author MITM
     * @param log_tprocedname
     * @return 
     */
    public boolean check_log_TProced(String log_tprocedname) {
        try{
            return Bd.getInstance().check_log_TProced(log_tprocedname);                
        }catch(SQLException e){             
        }
        return false;
    }
    /**
     * @author MITM
     * @param log_tproced
     * @return 
     */
    public boolean change_log_TProced(log_TProced log_tproced) {
        try{
            return Bd.getInstance().change_log_TProced(log_tproced);                
        }catch(Exception e){       
            Gui.getInstance().ventanaError("Error Deshabilitando Tipo de Procedencia: \n"+e.getMessage()); 
        }
        return false;
    }    
    /***************************************************************************/
    /****************************** log_TTransp ********************************/
    /***************************************************************************/    
    /**
     * @author MITM
     * @lista para generar el reporte
     * @param log_ttransp
     * @return 
     */
    public static List<log_TTransp> getList_log_TTransp(log_TTransp[] log_ttransp){
        List<log_TTransp> list = new ArrayList<>();        
        list.addAll(Arrays.asList(log_ttransp));        
        return list;
    }
    /**
     * @author MITM
     * @return 
     */
    public log_TTransp[] load_log_TTransp() {
        try{
            log_TTransp[] log_ttransp = Bd.getInstance().load_log_TTransp();      
            return log_ttransp;
        }catch(SQLException e){
            Gui.getInstance().ventanaError("Error Cargando Tipo de Transporte: \n"+e.getMessage()); 
        }
        return null;
    }    
    /**
     * @author MITM
     * @param find
     * @return 
     */
    public log_TTransp[] find_log_TTransp(String find) {
        try{
            log_TTransp[] log_ttransp = Bd.getInstance().find_log_TTransp(find);      
            return log_ttransp;
        }catch(SQLException e){
            Gui.getInstance().ventanaError("Error Cargando Tipo de Transporte: \n"+e.getMessage()); 
        }
        return null;
    }    
    /**
     * @author MITM
     * @param log_ttransp
     * @param operacion
     * @return 
     */
    public boolean save_log_TTransp(log_TTransp log_ttransp, int operacion) {
        boolean boo = Validar.validar_Save_log_TTransp(log_ttransp);
        if (boo){
            try{                
                boolean result = Bd.getInstance().save_log_TTransp(operacion, log_ttransp);

                return result;
            }catch(Exception e){
                Gui.getInstance().ventanaError("Error guardando Tipo de Transporte: \n"+e.getMessage()); 
            }
        }        
        return false;
    }
    /**
     * @author MITM
     * @param log_ttranspname
     * @return 
     */
    public boolean check_log_TTransp(String log_ttranspname) {
        try{
            return Bd.getInstance().check_log_TTransp(log_ttranspname);                
        }catch(SQLException e){             
        }
        return false;
    }
    /**
     * @author MITM
     * @param log_ttransp
     * @return 
     */
    public boolean change_log_TTransp(log_TTransp log_ttransp) {
        try{
            return Bd.getInstance().change_log_TTransp(log_ttransp);                
        }catch(Exception e){       
            Gui.getInstance().ventanaError("Error Deshabilitando Tipo de Transporte: \n"+e.getMessage()); 
        }
        return false;
    }    
    /***************************************************************************/
    /***************************** log_TSeguros ********************************/
    /***************************************************************************/    
    /**
     * @author MITM
     * @lista para generar el reporte
     * @param log_tseguros
     * @return 
     */
    public static List<log_TSeguros> getList_log_TSeguros(log_TSeguros[] log_tseguros){
        List<log_TSeguros> list = new ArrayList<>();        
        list.addAll(Arrays.asList(log_tseguros));        
        return list;
    }
    /**
     * @author MITM
     * @return 
     */
    public log_TSeguros[] load_log_TSeguros() {
        try{
            log_TSeguros[] log_tseguros = Bd.getInstance().load_log_TSeguros();      
            return log_tseguros;
        }catch(SQLException e){
            Gui.getInstance().ventanaError("Error Cargando Aseguradora: \n"+e.getMessage()); 
        }
        return null;
    }    
    /**
     * @author MITM
     * @param find
     * @return 
     */
    public log_TSeguros[] find_log_TSeguros(String find) {
        try{
            log_TSeguros[] log_tseguros = Bd.getInstance().find_log_TSeguros(find);      
            return log_tseguros;
        }catch(SQLException e){
            Gui.getInstance().ventanaError("Error Cargando Aseguradora: \n"+e.getMessage()); 
        }
        return null;
    }    
    /**
     * @author MITM
     * @param log_tseguros
     * @param operacion
     * @param ScreenName
     * @return 
     */
    public boolean save_log_TSeguros(log_TSeguros log_tseguros, int operacion, String ScreenName) {
        boolean boo = Validar.validar_Save_log_TSeguros(log_tseguros);
        if (boo){
            try{                
                boolean result = Bd.getInstance().save_log_TSeguros(operacion, log_tseguros);

                return result;
            }catch(Exception e){
                Gui.getInstance().showMessage("Error guardando " + ScreenName +": \n" + e.getMessage(), "E");
            }
        }        
        return false;
    }
    /**
     * @author MITM
     * @param log_tsegurosname
     * @return 
     */
    public boolean check_log_TSeguros(String log_tsegurosname) {
        try{
            return Bd.getInstance().check_log_TSeguros(log_tsegurosname);                
        }catch(SQLException e){             
        }
        return false;
    }
    /**
     * @author MITM
     * @param log_tseguros
     * @return 
     */
    public boolean change_log_TSeguros(log_TSeguros log_tseguros) {
        try{
            return Bd.getInstance().change_log_TSeguros(log_tseguros);                
        }catch(Exception e){       
            Gui.getInstance().ventanaError("Error Deshabilitando Aseguradora: \n"+e.getMessage()); 
        }
        return false;
    }    
    /***************************************************************************/
    /*************************** log_TDispflota ********************************/
    /***************************************************************************/    
    /**
     * @author MITM
     * @lista para generar el reporte
     * @param log_tdispflota
     * @return 
     */
    public static List<log_TDispflota> getList_log_TDispflota(log_TDispflota[] log_tdispflota){
        List<log_TDispflota> list = new ArrayList<>();        
        list.addAll(Arrays.asList(log_tdispflota));        
        return list;
    }
    /**
     * @author MITM
     * @return 
     */
    public log_TDispflota[] load_log_TDispflota() {
        try{
            log_TDispflota[] log_tdispflota = Bd.getInstance().load_log_TDispflota();      
            return log_tdispflota;
        }catch(SQLException e){
            Gui.getInstance().ventanaError("Error Cargando Disponibilidad: \n"+e.getMessage()); 
        }
        return null;
    }    
    /**
     * @author MITM
     * @param find
     * @return 
     */
    public log_TDispflota[] find_log_TDispflota(String find) {
        try{
            log_TDispflota[] log_tdispflota = Bd.getInstance().find_log_TDispflota(find);      
            return log_tdispflota;
        }catch(SQLException e){
            Gui.getInstance().ventanaError("Error Cargando Disponibilidad: \n"+e.getMessage()); 
        }
        return null;
    }    
    /**
     * @author MITM
     * @param log_tdispflota
     * @param operacion
     * @param ScreenName
     * @return 
     */
    public boolean save_log_TDispflota(log_TDispflota log_tdispflota, int operacion, String ScreenName) {
        boolean boo = Validar.validar_Save_log_TDispflota(log_tdispflota);
        if (boo){
            try{                
                boolean result = Bd.getInstance().save_log_TDispflota(operacion, log_tdispflota);

                return result;
            }catch(Exception e){
                Gui.getInstance().showMessage("Error guardando " + ScreenName +": \n" + e.getMessage(), "E");
            }
        }        
        return false;
    }
    /**
     * @author MITM
     * @param log_ttranspname
     * @return 
     */
    public boolean check_log_TDispflota(String log_ttranspname) {
        try{
            return Bd.getInstance().check_log_TSeguros(log_ttranspname);                
        }catch(SQLException e){             
        }
        return false;
    }
    /**
     * @author MITM
     * @param log_tdispflota
     * @return 
     */
    public boolean change_log_TDispflota(log_TDispflota log_tdispflota) {
        try{
            return Bd.getInstance().change_log_TDispflota(log_tdispflota);                
        }catch(Exception e){       
            Gui.getInstance().ventanaError("Error Deshabilitando Disponibilidad: \n"+e.getMessage()); 
        }
        return false;
    }    
    /***************************************************************************/
    /********************************* GUIDE ***********************************/
    /***************************************************************************/    
    /**
     * @author MITM
     * @lista para generar el reporte
     * @param archguid_gfc
     * @return 
     */
    public static List<Fxp_Archguid_gfc> getList_log_Archguid_gfc(Fxp_Archguid_gfc[] archguid_gfc){
        List<Fxp_Archguid_gfc> list = new ArrayList<>();        
        list.addAll(Arrays.asList(archguid_gfc));        
        return list;
    }
    /**
     * @author MITM
     * @lista para generar el reporte
     * @param archguip
     * @return 
     */
    public static List<Fxp_Archguip_pro_cg> getList_log_Archguip_cg(Fxp_Archguip_pro_cg[] archguip){
        List<Fxp_Archguip_pro_cg> list = new ArrayList<>();        
        list.addAll(Arrays.asList(archguip));        
        return list;
    }
    /**
     * @author MITM
     * @lista para generar el reporte
     * @param archguip
     * @return 
     */
    public static List<Fxp_Archguip_pro_dv> getList_log_Archguip_dv(Fxp_Archguip_pro_dv[] archguip){
        List<Fxp_Archguip_pro_dv> list = new ArrayList<>();        
        list.addAll(Arrays.asList(archguip));        
        return list;
    }
    /**
     * @author MITM
     * @lista para generar el codigo en guia master
     * @param log_cguias
     * @return 
     */
    public static List<log_CGuias> getList_log_CGuias(log_CGuias[] log_cguias){
        List<log_CGuias> list = new ArrayList<>();        
        list.addAll(Arrays.asList(log_cguias));        
        return list;
    }
    /**
     * @author MITM
     * @param find
     * @param producto
     * @return 
     */
    public Fxp_Archguid[] find_Archguid(String find, String producto) {
        try{
            Fxp_Archguid[] archguid = Bd.getInstance().find_Archguid(find, producto);      
            return archguid;
        }catch(SQLException e){
            Gui.getInstance().ventanaError("Error Cargando Guia (Documentos): \n"+e.getMessage()); 
        }
        return null;
    }    
    /**
     * @author MITM
     * @param find
     * @return 
     */
    public Fxp_Archguid_gfc[] find_Archguid_gfc(String find) {
        try{
            Fxp_Archguid_gfc[] archguid_gfc = Bd.getInstance().find_Archguid_gfc(find);      
            return archguid_gfc;
        }catch(SQLException e){
            Gui.getInstance().ventanaError("Error Cargando Guia (Documentos): \n"+e.getMessage()); 
        }
        return null;
    }    
    /**
     * @author MITM
     * @param rif
     * @param producto
     * @param guia
     * @return 
     */
    public Fxp_Archguid_cp[] find_Archguid_cp(String rif, String producto, String guia) {
        try{
            Fxp_Archguid_cp[] archguid_cp = Bd.getInstance().find_Archguid_cp(rif, producto, guia);      
            return archguid_cp;
        }catch(SQLException e){
            Gui.getInstance().ventanaError("Error Cargando Guia (Documentos): \n"+e.getMessage()); 
        }
        return null;
    }    
    /**
     * @author MITM
     * @param numdoc
     * @return 
     */
    public Fxp_Archguid_cp[] find_Archguid_red_ca(Integer numdoc) {
        try{
            Fxp_Archguid_cp[] archguid_cp = Bd.getInstance().find_Archguid_red_ca(numdoc);
            return archguid_cp;
        }catch(SQLException e){
            Gui.getInstance().ventanaError("Error Cargando Guia (Documentos): \n"+e.getMessage()); 
        }
        return null;
    }    
    /**
     * @author MITM
     * @param cliente
     * @return 
     */
    public Fxp_Archguid_cli[] find_Archguid_cli(String cliente) {
        try{
            Fxp_Archguid_cli[] archguid_clie = Bd.getInstance().find_Archguid_cli(cliente);      
            return archguid_clie;
        }catch(SQLException e){
            Gui.getInstance().ventanaError("Error Cargando Guia (Documentos): \n"+e.getMessage()); 
        }
        return null;
    }    
    /**
     * @author MITM
     * @param guia
     * @param alm
     * @return 
     */
    public Fxp_Archguip_det[] find_Archguip_det(String guia, String alm) {
        try{
            Fxp_Archguip_det[] archguip = Bd.getInstance().find_Archguip_det(guia, alm);      
            return archguip;
        }catch(SQLException e){
            Gui.getInstance().ventanaError("Error Cargando Guia (Documentos): \n"+e.getMessage()); 
        }
        return null;
    }    
    /**
     * @author MITM
     * @param producto
     * @return 
     */
    public Fxp_Archguip_det[] find_Archguip_pro_det(String producto) {
        try{
            Fxp_Archguip_det[] archguip = Bd.getInstance().find_Archguip_pro_det(producto);      
            return archguip;
        }catch(SQLException e){
            Gui.getInstance().ventanaError("Error Cargando Guia (Documentos): \n"+e.getMessage()); 
        }
        return null;
    }    
    /**
     * @author MITM
     * @param guia
     * @param producto
     * @return 
     */
    public Fxp_Archguip_pro_cg[] find_Archguip_pro_guia(String guia, String producto) {
        try{
            Fxp_Archguip_pro_cg[] archguip = Bd.getInstance().find_Archguip_pro_guia(guia, producto);      
            return archguip;
        }catch(SQLException e){
            Gui.getInstance().ventanaError("Error Cargando Guia (Documentos): \n"+e.getMessage()); 
        }
        return null;
    }    
    /**
     * @author MITM
     * @param fact
     * @param clie
     * @param producto
     * @return 
     */
    public Fxp_Archguip_pro_dv[] find_Archguip_pro_fact(String fact, String clie, String producto) {
        try{
            Fxp_Archguip_pro_dv[] archguip = Bd.getInstance().find_Archguip_pro_fact(fact, clie, producto);      
            return archguip;
        }catch(SQLException e){
            Gui.getInstance().ventanaError("Error Cargando Guia (Documentos): \n"+e.getMessage()); 
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
     */
    public Fxp_Archguip_pro[] find_Archguid_pro_fact(String letdoc, String fact, String clie, String producto) {
        try{
            Fxp_Archguip_pro[] archguip = Bd.getInstance().find_Archguid_pro_fact(letdoc, fact, clie, producto);      
            return archguip;
        }catch(SQLException e){
            Gui.getInstance().ventanaError("Error Cargando Guia (Documentos): \n"+e.getMessage()); 
        }
        return null;
    }    
    /**
     * @author MITM
     * @param guia
     * @param alm
     * @return 
     */
    public Fxp_Archguip_sum[] find_Archguip_sum(String guia, String alm) {
        try{
            Fxp_Archguip_sum[] archguip = Bd.getInstance().find_Archguip_sum(guia, alm);      
            return archguip;
        }catch(SQLException e){
            Gui.getInstance().ventanaError("Error Cargando Guia (Documentos): \n"+e.getMessage()); 
        }
        return null;
    }    
    /*
     * @author MITM
     * @param fact
     * @return 
     */
    public Fxp_Renglon[] find_Renglon(String fact) {
        try{
            Fxp_Renglon[] renglon = Bd.getInstance().find_Renglon(fact);      
            return renglon;
        }catch(SQLException e){
            Gui.getInstance().ventanaError("Error Cargando Guia (Documentos): \n"+e.getMessage()); 
        }
        return null;
    }    
    /**
     * @author MITM
     * @param guia
     * @return 
     */
    public boolean check_log_Archguie(String guia) {
        try{
            return Bd.getInstance().check_log_Archguie(guia);                
        }catch(SQLException e){             
        }
        return false;
    }
    /**
     * @author MITM
     * @param guia
     * @param producto
     * @return 
     */
    public boolean check_log_Archguip_guia(String guia, String producto) {
        try{
            return Bd.getInstance().check_log_Archguip_guia(guia, producto);                
        }catch(SQLException e){             
        }
        return false;
    }
    /**
     * @author MITM
     * @param numdoc
     * @param guia
     * @return 
     */
    public boolean check_log_Archguip_fact_guia(String numdoc, String guia) {
        try{
            return Bd.getInstance().check_log_Archguid_Numdoc(numdoc, guia);                
        }catch(SQLException e){             
        }
        return false;
    }
    /**
     * @author MITM
     * @param fact
     * @param producto
     * @return 
     */
    public boolean check_log_Archguip_fact_pro(String fact, String producto) {
        try{
            return Bd.getInstance().check_log_Archguip_fact(fact, producto);                
        }catch(SQLException e){             
        }
        return false;
    }
    /**
     * @author MITM
     * @param guia
     * @return 
     */
    public boolean check_log_CGuias_rela_carga(String guia) {
        try{
            return Bd.getInstance().check_log_CGuias_rela_carga(guia);                
        }catch(SQLException e){             
        }
        return false;
    }
    /**
     * @author MITM
     * @param guia
     * @return 
     */
    public boolean check_log_CGuias_rela_caja(String guia) {
        try{
            return Bd.getInstance().check_log_CGuias_rela_caja(guia);                
        }catch(SQLException e){             
        }
        return false;
    }
    /**
     * @author MITM
     * @param guia
     * @return 
     */
    public boolean check_log_CGuias_carga(String guia) {
        try{
            return Bd.getInstance().check_log_CGuias_carga(guia);                
        }catch(SQLException e){             
        }
        return false;
    }
    /**
     * @author MITM
     * @param guia
     * @return 
     */
    public boolean check_log_CGuias_caja(String guia) {
        try{
            return Bd.getInstance().check_log_CGuias_caja(guia);                
        }catch(SQLException e){             
        }
        return false;
    }
    /**
     * @author MITM
     * @param guia
     * @return 
     */
    public boolean check_log_CGuias_fcarga(String guia) {
        try{
            return Bd.getInstance().check_log_CGuias_fcarga(guia);                
        }catch(SQLException e){             
        }
        return false;
    }
    /**
     * @author MITM
     * @param producto
     * @return 
     */
    public boolean check_log_cguias_check_fdev_prod(String producto) {
        try{
            return Bd.getInstance().check_log_cguias_check_fdev_prod(producto);                
        }catch(SQLException e){             
        }
        return false;
    }
    /**
     * @author MITM
     * @param log_cguias
     * @param operacion
     * @param pos
     * @return 
     */
    public boolean save_log_CGuias(log_CGuias log_cguias, int operacion, int pos) {
        //boolean boo = Validar.validar_Save_log_CGuias(log_cguias);
        boolean boo = true;
        if (boo){
            try{                
                boolean result = Bd.getInstance().save_log_CGuias(log_cguias, operacion, pos);

                return result;
            }catch(Exception e){
                Gui.getInstance().ventanaError("Error guardando Guia: \n"+e.getMessage()); 
            }
        }
        return false;
    }
    /**
     * @author MITM
     * @param log_cguias_perm
     * @param operacion
     * @param pos
     * @return 
     */
    public boolean save_log_CGuias_perm(log_CGuias_perm log_cguias_perm, int operacion, int pos) {
        try{                
            boolean result = Bd.getInstance().save_log_CGuias_perm(log_cguias_perm, operacion, pos);

            return result;
        }catch(Exception e){
            Gui.getInstance().ventanaError("Error guardando Guia: \n"+e.getMessage()); 
        }
        return false;
    }
    /**
     * @author MITM
     * @param log_cguias_falt
     * @param operacion
     * @param pos
     * @return 
     */
    public boolean save_log_CGuias_fcar(log_CGuias_falt_cg log_cguias_falt, int operacion, int pos) {
        try{                
            boolean result = Bd.getInstance().save_log_CGuias_falt(log_cguias_falt, operacion, pos);

            return result;
        }catch(Exception e){
            Gui.getInstance().ventanaError("Error guardando Guia: \n"+e.getMessage()); 
        }
        return false;
    }
    /**
     * @author MITM
     * @param log_cguias_dev
     * @param operacion
     * @param pos
     * @return 
     */
    public boolean save_log_CGuias_fdev(log_CGuias_falt_dv log_cguias_dev, int operacion, int pos) {
        try{                
            boolean result = Bd.getInstance().save_log_CGuias_dev(log_cguias_dev, operacion, pos);

            return result;
        }catch(Exception e){
            Gui.getInstance().ventanaError("Error guardando Guia: \n"+e.getMessage()); 
        }
        return false;
    }
    /**
     * @author MITM
     * @param log_cguias
     * @param operacion
     * @param pos
     * @param ScreenName
     * @return 
     */
    public boolean save_log_CGuias_caja(log_CGuias log_cguias, int operacion, int pos, String ScreenName) {
        try{                
            boolean result = Bd.getInstance().save_log_CGuias_caja(log_cguias, operacion, pos);

            return result;
        }catch(Exception e){
                Gui.getInstance().showMessage("Error guardando " + ScreenName +": \n" + e.getMessage(), "E");
        }
        return false;
    }
    /**
     * @author MITM
     * @return 
     */
    public log_CGuias[] load_log_CGuias() {
        try{
            log_CGuias[] log_cguias = Bd.getInstance().load_log_CGuias();      
            return log_cguias;
        }catch(SQLException e){
            Gui.getInstance().ventanaError("Error Cargando Guia: \n"+e.getMessage()); 
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
     */
    public log_CGuias[] find_log_CGuias(String find1, String find2, String param, int rows) {
        try{
            log_CGuias[] log_cguias = Bd.getInstance().find_log_CGuias(find1, find2, param, rows);      
            return log_cguias;
        }catch(SQLException e){
            Gui.getInstance().ventanaError("Error Cargando Guia: \n"+e.getMessage()); 
        }
        return null;
    }    
    /**
     * @author MITM
     * @param numrela
     * @return 
     */
    public log_CGuias_perm[] find_log_CGuias_perm(String numrela) {
        try{
            log_CGuias_perm[] log_cguias = Bd.getInstance().find_log_CGuias_perm(numrela);      
            return log_cguias;
        }catch(SQLException e){
            Gui.getInstance().ventanaError("Error Cargando Guia: \n"+e.getMessage()); 
        }
        return null;
    }    
    /**
     * @author MITM
     * @param numrela
     * @return 
     */
    public log_CGuias_falt_cg[] find_log_CGuias_fcar(String numrela) {
        try{
            log_CGuias_falt_cg[] log_cguias = Bd.getInstance().find_log_CGuias_fcar(numrela);      
            return log_cguias;
        }catch(SQLException e){
            Gui.getInstance().ventanaError("Error Cargando Guia: \n"+e.getMessage()); 
        }
        return null;
    }    
    /**
     * @author MITM
     * @param numrela
     * @return 
     */
    public log_CGuias_falt_dv[] find_log_CGuias_fdev(String numrela) {
        try{
            log_CGuias_falt_dv[] log_cguias = Bd.getInstance().find_log_CGuias_fdev(numrela);      
            return log_cguias;
        }catch(SQLException e){
            Gui.getInstance().ventanaError("Error Cargando Guia: \n"+e.getMessage()); 
        }
        return null;
    }    
    /**
     * @author MITM
     * @param numrela
     * @param param
     * @return 
     */
    public log_CGuias_falt_dv[] print_log_CGuias_fdev(String numrela, int param) {
        try{
            log_CGuias_falt_dv[] log_cguias = Bd.getInstance().print_log_CGuias_fdev(numrela, param);      
            return log_cguias;
        }catch(SQLException e){
            Gui.getInstance().ventanaError("Error Cargando Guia: \n"+e.getMessage()); 
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
     */
    public ItemPrintScreen[] find_PrintScreen(int idscreen, String idobjeto) {
        try{
            ItemPrintScreen[] printscreen = Bd.getInstance().find_PrintScreen(idscreen, idobjeto);      
            return printscreen;
        }catch(SQLException e){
            Gui.getInstance().ventanaError("Error Cargando parametros de impresion: \n"+e.getMessage()); 
        }
        return null;
    }    
    /***************************************************************************/
    /*************************** NOMINA - INFOCENT *****************************/
    /***************************************************************************/    
    /**
     * @author MITM
     * @param find
     * @return 
     */
    public Empleado[] find_Empelado(String find) {
        try{
            Empleado[] empInfocent = Infocent.getInstance().find_Empelado(find);      
            return empInfocent;
        }catch(SQLException e){
            Gui.getInstance().ventanaError("Error Cargando Guia (Documentos): \n"+e.getMessage()); 
        }
        return null;
    }    
    /**
     * @param empleado
     * @param year
     * @return 
     */
    public Asignacion[] loadAsignacionesXAno(Empleado empleado, int year) {
        try {
            return Infocent.getInstance().loadAsignacionesXAno(empleado, year);
        } catch (SQLException ex) {
            
        }
        return null;
    }
    /**
     * @param empleado
     * @param year
     * @return 
     */
    public Deduccion[] loadDeduccionesXAno(Empleado empleado, int year) {
        try {
            return Infocent.getInstance().loadDeduccionesXAno(empleado, year);
        } catch (SQLException ex) {
            
        }
        return null;
    }
    /**
     * @param empleado
     * @param year
     * @param month
     * @return 
     */
    public Asignacion[] loadAsignacionesXMes(Empleado empleado, int year, int month) {
        try {
            return Infocent.getInstance().loadAsignacionesXMes(empleado, year, month);
        } catch (SQLException ex) {
            
        }
        return null;
    }
    /**
     * @param empleado
     * @param year
     * @param month
     * @return 
     */
    public Deduccion[] loadDeduccionesXMes(Empleado empleado, int year, int month) {
        try {
            return Infocent.getInstance().loadDeduccionesXMes(empleado, year, month);
        } catch (SQLException ex) {
        }
        return null;
    }
    /**
     * @param cedula
     * @param year
     * @param month
     * @return 
     */
    public Integer[] loadPeriodos(String cedula, int year, int month){
        try {
            return Infocent.getInstance().loadPeriodos(cedula, year, month);
        } catch (SQLException ex) {
            
        }
        return null;
    }
    /**
     * @param empleado
     * @param year
     * @param month
     * @param period
     * @return 
     */
    public Asignacion[] loadAsignacionesXPeriodo(Empleado empleado, int year, int month, int period){
        try{
            return Infocent.getInstance().loadAsignacionesXPeriodo(empleado, year, month, period);
        }catch(SQLException e){
        }
        return null;
    }
    /**
     * @param empleado
     * @param year
     * @param month
     * @param period
     * @return 
     */
    public Deduccion[] loadDeduccionesXPeriodo(Empleado empleado, int year, int month, int period){
        try{
            return Infocent.getInstance().loadDeduccionesXPeriodo(empleado, year, month, period);
        }catch(SQLException e){            
        }
        return null;
    }    
    /**
     * @param empresa
     * @param year
     * @return 
     */
    public String[] loadNominas(Empresa empresa, int year) {
        try {
            return Infocent.getInstance().loadNominasXEmpresa(empresa.getId(), year);
        } catch (SQLException ex) {
            
        }
        return null;
    }
    /**
     * @param auditar
     * @param empresa
     * @param nomina
     * @param year
     * @param month
     * @param type
     * @return 
     */
    public Concepto[] loadConceptos(String auditar, Empresa empresa, String nomina, int year, int month, int type){
        try {
            return Infocent.getInstance().loadConceptos(auditar, empresa.getId(), nomina, year, month, type);
        } catch (SQLException ex) {
            
        }
        return null;
    }
    /**
     * 
     * @param empresa
     * @param nomina
     * @param year
     * @param month
     * @param type
     * @param concepto
     * @return 
     */
    public Asignacion[] loadAsignacionesConceptosXMes(Empresa empresa, String nomina, int year, int month, int type, Concepto concepto) {       
        try {
            return Infocent.getInstance().loadAsignacionesConceptoXMes(empresa.getId(), nomina, year, month, type, concepto.getId());
        } catch (SQLException ex) {
            
        }
        return null;
    }
    /**
     * 
     * @param empresa
     * @param nomina
     * @param year
     * @param month
     * @param type
     * @param concepto
     * @return 
     */
    public Deduccion[] loadDeduccionesConceptosXMes(Empresa empresa, String nomina, int year, int month, int type, Concepto concepto) {       
        try {
            return Infocent.getInstance().loadDeduccionesConceptoXMes(empresa.getId(), nomina, year, month, type, concepto.getId());
        } catch (SQLException ex) {
            
        }
        return null;
    }
    /**
     * @param empresa
     * @param nomina
     * @param year
     * @return 
     */
    public Integer[] loadTipoProcesosXAno(Empresa empresa, String nomina, int year) {
        try{
            return Infocent.getInstance().loadTipoProcesosXAno(empresa.getId(), nomina, year);            
        }catch(SQLException e){
            
        }
        return null;
    }
    /**
     * @param empresa
     * @param nomina
     * @param year
     * @param month
     * @return 
     */
    public Integer[] loadTipoProcesosXMes(Empresa empresa, String nomina, int year, int month) {
        try{
            return Infocent.getInstance().loadTipoProcesosXMes(empresa.getId(), nomina, year, month);            
        }catch(SQLException e){
            
        }
        return null;
    }
    /**
     * 
     * @param empresa
     * @param nomina
     * @param year
     * @param month
     * @param type
     * @return 
     */
    public Asignacion[] loadAsignacionesEmpresaXProceso(Empresa empresa, String nomina, int year, int month, int type) {       
        try {
            return Infocent.getInstance().loadAsignacionesEmpresaXProceso(empresa.getId(), nomina, year, month, type);
        } catch (SQLException ex) {
            
        }
        return null;
    }
    /**
     * 
     * @param empresa
     * @param nomina
     * @param year
     * @param month
     * @param type
     * @return 
     */
    public Deduccion[] loadDeduccionesEmpresaXProceso(Empresa empresa, String nomina, int year, int month, int type) {       
        try {
            return Infocent.getInstance().loadDeduccionesEmpresaXProceso(empresa.getId(), nomina, year, month, type);
        } catch (SQLException ex) {
            
        }
        return null;
    }
    /***************************************************************************/
    /************************** CGUIAS_GLOMAR_PRICE ****************************/
    /***************************************************************************/
    
    /**
     * @author MITM
     * @lista para generar el reporte
     * @param glomar_price
     * @return 
     */
    public static List<log_CGuias_Glomar_price> getList_Glomar_price(log_CGuias_Glomar_price[] glomar_price){
        List<log_CGuias_Glomar_price> list = new ArrayList<>();        
        list.addAll(Arrays.asList(glomar_price));        
        return list;
    }
    /**
     * @author MITM
     * @return 
     */
    public log_CGuias_Glomar_price[] load_Glomar_price() {
        try{
            log_CGuias_Glomar_price[] glomar_price = Bd.getInstance().load_Glomar_price();      
            return glomar_price;
        }catch(SQLException e){
            Gui.getInstance().ventanaError("Error Cargando Precios: \n"+e.getMessage()); 
        }
        return null;
    }    
    /**
     * @author MITM
     * @param find
     * @return 
     */
    public log_CGuias_Glomar_price[] find_Glomar_price(String find) {
        try{
            log_CGuias_Glomar_price[] glomar_price = Bd.getInstance().find_Glomar_price(find);      
            return glomar_price;
        }catch(SQLException e){
            Gui.getInstance().ventanaError("Error Cargando Precios: \n"+e.getMessage()); 
        }
        return null;
    }    
    /**
     * @author MITM
     * @param glomar_price
     * @param operacion
     * @return 
     */
    public boolean save_Glomar_price(log_CGuias_Glomar_price glomar_price, int operacion) {
//        boolean boo = Validar.validar_Save_Rol(glomar_price);
//        if (boo){
//            try{                
//                boolean result = Bd.getInstance().save_Glomar_price(operacion, glomar_price);
//
//                return result;
//            }catch(Exception e){
//                Gui.getInstance().ventanaError("Error guardando Rol: \n"+e.getMessage()); 
//            }
//        }        
        return false;
    }
    /***************************************************************************/
    /************************* CGUIAS_GLOMAR_INVOICE ***************************/
    /***************************************************************************/
    
    /**
     * @author MITM
     * @lista para generar el reporte
     * @param glomar_invoice
     * @return 
     */
    public static List<log_CGuias_Glomar_invoice> getList_Glomar_invoice(log_CGuias_Glomar_invoice[] glomar_invoice){
        List<log_CGuias_Glomar_invoice> list = new ArrayList<>();        
        list.addAll(Arrays.asList(glomar_invoice));        
        return list;
    }
    /**
     * @author MITM
     * @param year
     * @param month
     * @param quality
     * @param date1
     * @param date2
     * @return 
     */
    public log_CGuias_Glomar_invoice[] find_Glomar_invoice(int year, int month, int quality, String date1, String date2) {
        try{
            log_CGuias_Glomar_invoice[] glomar_invoice = Bd.getInstance().find_Glomar_invoice(year, month, quality, date1, date2);      
            return glomar_invoice;
        }catch(SQLException e){
            Gui.getInstance().ventanaError("Error Cargando Cargas: \n"+e.getMessage()); 
        }
        return null;
    }    
    /***************************************************************************/
    /************************** UPFILE RETENCIONES *****************************/
    /***************************************************************************/    
    
    /**
     * @author MITM
     * @lista para generar el reporte
     * @param sqlexcel
     * @return 
     */
    public static List<UploadExcelFile> getList_Upfile_Retenciones(UploadExcelFile[] sqlexcel){
        List<UploadExcelFile> list = new ArrayList<>();        
        list.addAll(Arrays.asList(sqlexcel));        
        return list;
    }
    /**
     * @author MITM
     * @param find
     * @return 
     */
    public UploadExcelFile[] find_Upfile_Retenciones(String find) {
        try{
            UploadExcelFile[] sqlexcel = Bd.getInstance().find_UploadExcelFile(find);      
            return sqlexcel;
        }catch(SQLException e){
            Gui.getInstance().ventanaError("Error Cargando Retenciones: \n"+e.getMessage()); 
        }
        return null;
    }    
    /**
     * @author MITM
     * @param sqlexcel
     * @param operacion
     * @param pos
     * @return 
     */
    public boolean save_Upfile_Retenciones(UploadExcelFile sqlexcel, int operacion, int pos) {
        try{                
            boolean result = Bd.getInstance().save_Upfile_Retenciones(sqlexcel, operacion, pos);

            return result;
        }catch(Exception e){
            Gui.getInstance().ventanaError("Error guardando Archivo: \n"+e.getMessage()); 
        }
        return false;
    }
    /***************************************************************************/
    /********************************* ORDERS **********************************/
    /***************************************************************************/
    
    /**
     * @author MITM
     * @lista para generar el reporte
     * @param inventa
     * @return 
     */
    public static List<Fxp_Inventa> getList_inventa(Fxp_Inventa[] inventa){
        List<Fxp_Inventa> list = new ArrayList<>();        
        list.addAll(Arrays.asList(inventa));        
        return list;
    }
    /**
     * @author MITM
     * @param producto
     * @param proveedor
     * @return 
     */
    public Fxp_Inventa[] find_inventa_prod_prov(String producto, String proveedor) {
        try{
            Fxp_Inventa[] inventa = Bd.getInstance().find_inventa_prod_prov(producto, proveedor);      
            return inventa;
        }catch(SQLException e){
            Gui.getInstance().ventanaError("Error Cargando Producto: \n"+e.getMessage()); 
        }
        return null;
    }    
    /**
     * @author MITM
     * @param find
     * @return 
     */
    public Orders[] find_orders(String find) {
        try{
            Orders[] orders = Bd.getInstance().find_orders(find);      
            return orders;
        }catch(SQLException e){
            Gui.getInstance().ventanaError("Error Cargando Grupo de Proveedor: \n"+e.getMessage()); 
        }
        return null;
    }    
    /**
     * @author MITM
     * @param find
     * @return 
     */
    public Orders[] find_orders_print(String find) {
        try{
            Orders[] orders = Bd.getInstance().find_orders_print(find);      
            return orders;
        }catch(SQLException e){
            Gui.getInstance().ventanaError("Error Cargando Grupo de Proveedor: \n"+e.getMessage()); 
        }
        return null;
    }    
    /**
     * @author MITM
     * @param find
     * @return 
     */
    public Orders[] find_orders_id(String find) {
        try{
            Orders[] orders = Bd.getInstance().find_orders_id(find);      
            return orders;
        }catch(SQLException e){
            Gui.getInstance().ventanaError("Error Cargando Grupo de Proveedor: \n"+e.getMessage()); 
        }
        return null;
    }    
    /**
     * @author MITM
     * @param find1
     * @param find2
     * @return 
     */
    public Orders[] find_orders_ids(String find1, String find2) {
        try{
            Orders[] orders = Bd.getInstance().find_orders_ids(find1, find2);      
            return orders;
        }catch(SQLException e){
            Gui.getInstance().ventanaError("Error Cargando Grupo de Proveedor: \n"+e.getMessage()); 
        }
        return null;
    }    
    /**
     * @author MITM
     * @param find
     * @return 
     */
    public Orders[] find_orders_date(String find) {
        try{
            Orders[] orders = Bd.getInstance().find_orders_date(find);      
            return orders;
        }catch(SQLException e){
            Gui.getInstance().ventanaError("Error Cargando Grupo de Proveedor: \n"+e.getMessage()); 
        }
        return null;
    }    
    /**
     * @author MITM
     * @param rows
     * @return 
     */
    public Orders[] find_orders_all(int rows) {
        try{
            Orders[] orders = Bd.getInstance().find_orders_all(rows);      
            return orders;
        }catch(SQLException e){
            Gui.getInstance().ventanaError("Error Cargando Grupo de Proveedor: \n"+e.getMessage()); 
        }
        return null;
    }    
    /**
     * @author MITM
     * @param rows
     * @param find
     * @return 
     */
    public Orders[] find_orders_open(int rows, String find) {
        try{
            Orders[] orders = Bd.getInstance().find_orders_open(rows, find);      
            return orders;
        }catch(SQLException e){
            Gui.getInstance().ventanaError("Error Cargando Grupo de Proveedor: \n"+e.getMessage()); 
        }
        return null;
    }    
    /**
     * @author MITM
     * @param rows
     * @param find
     * @return 
     */
    public Orders[] find_orders_close(int rows, String find) {
        try{
            Orders[] orders = Bd.getInstance().find_orders_close(rows, find);      
            return orders;
        }catch(SQLException e){
            Gui.getInstance().ventanaError("Error Cargando Grupo de Proveedor: \n"+e.getMessage()); 
        }
        return null;
    }    
    /**
     * @author MITM
     * @param idorden
     * @return 
     */
    public boolean check_orders(String idorden) {
        try{
            return Bd.getInstance().check_orders(idorden);                
        }catch(SQLException e){             
        }
        return false;
    }
    /**
     * @author MITM
     * @param orders
     * @param operacion
     * @param pos
     * @param ScreenName
     * @return 
     */
    public boolean save_orders(Orders orders, int operacion, int pos, String ScreenName) {
        boolean boo = true;
        if (boo){
            try{                
                boolean result = Bd.getInstance().save_orders(orders, operacion, pos);

                return result;
            }catch(Exception e){
                Gui.getInstance().showMessage("Error guardando " + ScreenName +": \n" + e.getMessage(), "E");
            }
        }
        return false;
    }
    /**
     * @author MITM
     * @param orders
     * @return 
     */
    public boolean change_Orders(Orders orders) {
        try{
            return Bd.getInstance().change_Orders(orders);                
        }catch(Exception e){       
            Gui.getInstance().ventanaError("Error Deshabilitando Proveedor: \n"+e.getMessage()); 
        }
        return false;
    }  
    /***************************************************************************/
    /********************************* REPORTS *********************************/
    /***************************************************************************/
   
    /**
     * @author MITM
     * @param year1
     * @param year2
     * @param date1
     * @param date2
     * @return 
     */
    public Dev_FanulSucursales[] find_Dev_FanulSucursales(int year1, int year2, String branch, String date1, String date2) {
        try{
            Dev_FanulSucursales[] sqlQuery = Bd.getInstance().find_Dev_FanulSucursales(year1, year2, branch, date1, date2);      
            return sqlQuery;
        }catch(SQLException e){
            Gui.getInstance().ventanaError("Error Cargando Consulta: \n"+e.getMessage()); 
        }
        return null;
    }    
    /**
     * @author MITM
     * @param find
     * @return 
     */
    public Dev_FaltCarga[] find_Dev_Faltcarga(String find) {
        try{
            Dev_FaltCarga[] cguias_falt = Bd.getInstance().find_Dev_Faltcarga(find);      
            return cguias_falt;
        }catch(SQLException e){
            Gui.getInstance().ventanaError("Error Cargando Cargas: \n"+e.getMessage()); 
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
     */
    public Zsi_nros_sem[] find_Zsi_nros_sem(int year, int IdScreen) {
        try{
            Zsi_nros_sem[] sqlQuery = Bd.getInstance().find_Zsi_nros_sem(year, IdScreen);      
            return sqlQuery;
        }catch(SQLException e){
            Gui.getInstance().ventanaError("Error Cargando Consulta: \n"+e.getMessage()); 
        }
        return null;
    }    
    /**
     * @author MITM
     * @param year
     * @param IdScreen
     * @param grafico
     * @return 
     */
    public int[] find_Zsi_nros_sem_int(int year, int IdScreen, String grafico) {
        try{
            int[] sqlQuery = Bd.getInstance().find_Zsi_nros_sem_int(year, IdScreen, grafico);                         
            return sqlQuery;
        }catch(SQLException e){
            Gui.getInstance().showMessage("Por favor contactar a Sistemas: \n" + e.getMessage(), "I");
        }
        return null;
    }

    /**
     * @author MITM
     * @param year
     * @param IdScreen
     * @return 
     */
    public Zsi_nros_sem_avg[] find_Zsi_nros_sem_avg(int year, int IdScreen) {
        try{
            Zsi_nros_sem_avg[] sqlQuery = Bd.getInstance().find_Zsi_nros_sem_avg(year, IdScreen);      
            return sqlQuery;
        }catch(SQLException e){
            Gui.getInstance().ventanaError("Error Cargando Consulta: \n"+e.getMessage()); 
        }
        return null;
    }    
    /**
     * @author MITM
     * @param year
     * @param IdScreen
     * @return 
     */
    public Zsi_nros_sem_day[] find_Zsi_nros_sem_day(int year, int IdScreen) {
        try{
            Zsi_nros_sem_day[] sqlQuery = Bd.getInstance().find_Zsi_nros_sem_day(year, IdScreen);      
            return sqlQuery;
        }catch(SQLException e){
            Gui.getInstance().ventanaError("Error Cargando Consulta: \n"+e.getMessage()); 
        }
        return null;
    }    
    /**
     * @author MITM
     * @param year
     * @param IdScreen
     * @return 
     */
    public Zsi_nros_sem_r[] find_Zsi_nros_sem_r(int year, int IdScreen) {
        try{
            Zsi_nros_sem_r[] cguias_falt = Bd.getInstance().find_Zsi_nros_sem_r(year, IdScreen);      
            return cguias_falt;
        }catch(SQLException e){
            Gui.getInstance().ventanaError("Error Cargando Cargas: \n"+e.getMessage()); 
        }
        return null;
    }    
    /***************************************************************************/
    /******************************* INVENTORY *********************************/
    /***************************************************************************/
    
    /**
     * @author MITM
     * @lista para generar el reporte
     * @param invenblockprod
     * @return 
     */
    public static List<InventoryBlockProd> getList_invenblockprod(InventoryBlockProd[] invenblockprod){
        List<InventoryBlockProd> list = new ArrayList<>();        
        list.addAll(Arrays.asList(invenblockprod));        
        return list;
    }
    /**
     * @author MITM
     * @param producto
     * @param proveedor
     * @return 
     */
    public InventoryBlockProd[] find_invenblockprod_prod_prov(String producto, String proveedor) {
        try{
            InventoryBlockProd[] invenblockprod = Bd.getInstance().find_invenblockprod_prod_prov(producto, proveedor);      
            return invenblockprod;
        }catch(SQLException e){
            Gui.getInstance().ventanaError("Error Cargando Bloqueo de Productos: \n"+e.getMessage()); 
        }
        return null;
    }    
    /**
     * @author MITM
     * @param find
     * @return 
     */
    public InventoryBlockProd[] find_invenblockprod(String find) {
        try{
            InventoryBlockProd[] invenblockprod = Bd.getInstance().find_invenblockprod(find);      
            return invenblockprod;
        }catch(SQLException e){
            Gui.getInstance().ventanaError("Error Cargando Bloqueo de Productos: \n"+e.getMessage()); 
        }
        return null;
    }    
    /**
     * @author MITM
     * @param rows
     * @return 
     */
    public InventoryBlockProd[] find_invenblockprod_all(int rows) {
        try{
            InventoryBlockProd[] invenblockprod = Bd.getInstance().find_invenblockprod_all(rows);      
            return invenblockprod;
        }catch(SQLException e){
            Gui.getInstance().ventanaError("Error Cargando Bloqueo de Productos: \n"+e.getMessage()); 
        }
        return null;
    }    
    /**
     * @author MITM
     * @param idtoma
     * @return 
     */
    public boolean check_invenblockprod(String idtoma) {
        try{
            return Bd.getInstance().check_invenblockprod(idtoma);                
        }catch(SQLException e){             
        }
        return false;
    }
    /**
     * @author MITM
     * @param invenblockprod
     * @param operacion
     * @param pos
     * @param ScreenName
     * @return 
     */
    public boolean save_invenblockprod(InventoryBlockProd invenblockprod, int operacion, int pos, String ScreenName) {
        boolean boo = true;
        if (boo){
            try{                
                boolean result = Bd.getInstance().save_invenblockprod(invenblockprod, operacion, pos);

                return result;
            }catch(Exception e){
                Gui.getInstance().showMessage("Error guardando " + ScreenName +": \n" + e.getMessage(), "E");
            }
        }
        return false;
    }
    /**
     * @author MITM
     * @param invenblockprod
     * @return 
     */
    public boolean change_invenblockprod(InventoryBlockProd invenblockprod) {
        try{
            return Bd.getInstance().change_invenblockprod(invenblockprod);                
        }catch(Exception e){       
            Gui.getInstance().ventanaError("Error Deshabilitando Bloqueo de Productos: \n"+e.getMessage()); 
        }
        return false;
    }  


    
    /***************************************************************************/    
    /**
     * 
     * @param empleado
     * @return 
     */
    public Empleado[]   loadInfoEmpleado(Empleado empleado){
        try {
            return Infocent.getInstance().loadInfoEmpleado(empleado);
        } catch (SQLException ex) {
            
        }
        return null;
    }
    /***************************************************************************/
    /******************************* SINGLETON *********************************/
    /***************************************************************************/
    
    /**
     * 
     */
    private static class LnHolder {

        private static final Ln INSTANCE = new Ln();
    }
    /**
     * 
     * @return 
     */
    public static Ln getInstance() {
        return Ln.LnHolder.INSTANCE;
    }
            
}
