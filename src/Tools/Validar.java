/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Tools;

import GUI.Gui;
import Objects.Setup.GroupSupplier;
import Objects.Setup.Measure;
import Objects.log_TMotdev;
import Objects.System.Rol;
import Objects.Setup.Sex;
import Objects.Orders.Supplier;
import Objects.Setup.Unit;
import Objects.System.Usuario;
import Objects.log_CGuias;
import Objects.log_Personal;
import Objects.log_TDispflota;
import Objects.log_TMarca;
import Objects.log_TPersonal;
import Objects.log_TProced;
import Objects.log_TSeguros;
import Objects.log_TTransp;
import Objects.log_Vehiculos;

/**
 *
 * @author ARMGARCES
 */
 public class Validar {
    
    private static final int  Unidad = 1; 
    private static final int  Decena = 10;
    private static final int  Centena = 100;
    
    public static final int sinComillas     = 0;
    public static final int numerosYletras  = 1;
    public static final int soloLetras      = 2;
    public static final int soloNumeros     = 3;
    public static final int soloCorreos     = 4;
    public static final int soloTelefonos   = 5;
    /**
     * 
     * @param user Campo correspondiente al nombre de usuario
     * @param pswd Campo correspondiente a la contraseña de usuario
     * @return True si cumple todas las condiciones establecidas; False en caso contrario
     */
    public static boolean validarLogIn(String user,String pswd){
        
        boolean opc1 = Validar.validarTexto(user,30,numerosYletras,false);
        boolean opc2 = Validar.validarTexto(pswd,20,numerosYletras,false);
        
        if(!opc1 || !opc2){
            Gui.getInstance().ventanaError("Usuario y/o Contraseña Erroneo!");
            return false;
        }else{
            return true;
        }
    }    
    /**
     * 
     * @param user
     * @param pswd
     * @return 
     */
    public static boolean validarSaveUsuario(Usuario user, String pswd) {
        boolean opc3 = true;
        boolean opc5 = true;

        boolean opc1 = validarTexto(user.getUsername(),30,numerosYletras,false);
        boolean opc2 = validarTexto(user.getNombre1(),35,soloLetras,false);
        if (user.getNombre2() != null)
            opc3 = validarTexto(user.getNombre2(),35,soloLetras,true);
        boolean opc4 = validarTexto(user.getApellido1(),35,soloLetras,false);
        if (user.getApellido2() != null)
            opc5 = validarTexto(user.getApellido2(),35,soloLetras,true);        
        boolean opc6 = validarTexto(user.getPswd_old(),20,numerosYletras,false);                
        boolean opc7 = validarPasswordOld(user.getPswd_old(), pswd);        
        
        if(opc1 && opc2 && opc3 && opc4 && opc5 && opc6){
            if(opc7){                
                return true;
            }else{
                Gui.getInstance().ventanaError("Error Confirmado la Contraseña");
                return false;
            }
        }else{
            Gui.getInstance().ventanaError("Existen Parametros que no cumplen las especificaciones!");
            return false;
        }
    }
    /**
     * 
     * @param param Valor a ser evaluado
     * @param length Longitud maxima del campo correspondiente en la base de datos
     * @return 
     */
    private static boolean validarTexto(String param,int length,int opc,boolean nullable){
        if(param == null){
            return false;
        }
        if(!nullable){
            if(param.length() == 0){
                return false;
            }
        }
        if(param.length() > length){
            return false;
        }
        
        switch(opc){
            case 0:
                if(param.contains("\"") || param.contains("\'")){
                    return false;
                }
                break;
            case 1:
                if(!numerosYLetras(param)){
                    return false;
                }
                break;
            case 2:
                if(!soloLetras(param)){
                    return false;
                }
                break;
            case 3:
                if(!num_ent(param)){
                    return false;
                }
                break;
            case 4:
                if(!correo(param)){
                    return false;
                }
                break;
            case 5:
                if(!telefonos(param)){
                    return false;
                }
                break;
        }
               
        return true;
    }
    /**
     * @author MITM
     * @param param
     * @param conf
     * @return 
     */
    private static boolean validarPasswordOld(String param, String conf){        
        return param.equals(conf);                        
    }
    /**
     * @author MITM
     * @param param
     * @param conf
     * @return 
     */
    private static boolean validarPasswordNew(String param,String conf){        
        String pattern = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+-*=])(?=\\S+$).{6,10}";
        if(param.equals(conf)){
            return conf.matches(pattern);                        
        }else{
            return false;
        }                        
    }
    /**
     * @author MITM
     * @param text
     * @return 
     */
    private static boolean soloLetras(String text){
        return text.matches("[A-Za-zÑñ ]*");
    }  
    /**
     * @author MITM
     * @param text
     * @return 
     */
    public static boolean numerosYLetras(String text){        
        return text.matches("([A-Za-z0-9Ññ.,-]+[\\s]*)+$");
    }      
    /**
     * @author MITM
     * @param text
     * @return 
     */
    private static boolean telefonos(String text){        
        return text.matches("^[0]{1}[0-9]{3}[-][0-9]{7}");
    }      
    /**
     * @author MITM
     * @param text
     * @return 
     */
    private static boolean correo(String text){        
        return text.matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" +
                "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
    }      
    /**
     * @author MITM
     * @param num_ent
     * @return 
     */
    private static boolean num_ent(String num_ent){
//        boolean valor = false;
//        if (!num_ent.matches("[0-9]*")) {
//        } else {
//            valor = true;
//        }
        return num_ent.matches("[0-9]*");
    }    
    /**
     * @author MITM
     * @param num_dec
     * @return 
     */
    private static boolean num_dec(String num_dec){
        boolean valor = false;
        if(!num_dec.matches( "[0-9]+.[0-9]*" )) {
        } else {
            valor = true;
        }
        return valor;
    }    
    /**
     * @author MITM
     * @param Number
     * @param sepDecimal
     * @param sMoney
     * @return 
     */
    public static String numeros_letras(String Number, String sepDecimal, String sMoney) {
        String  V[] = initVector(), s = "", z = "", c = "", e = " ", t;
        int l = Number.length(), k = Number.indexOf( sepDecimal ), u = 1, n = 0, j = 0, b = 0, d, p, r;
      
        try{
            //obtiene los decimales
            if( k >= 0 ) { c = Number.substring( k + 1, l );  l = k; }
            
            if ( l <= 15 ){
                for( int i = l ; i >= 1; i-- ){
                    d = Integer.parseInt( String.valueOf( Number.charAt( i - 1 ) )); 
                    n = ( d * u ) + n;

                    switch( u ){
                        case Unidad: 
                            s = V[ n ]; 
                            if ( i == l && n == 1 ) b++;
                            break;
                        case Decena:                                                
                            p = d - 2;
                                    
                            if( p < 0 )   
                                s = V[ n ];                                      
                            else{ 
                                t =  V[ 20 + p ];
                                            
                            if( n % 10 != 0 )
                                s  =  (d == 2)? "veinti" + s : t + " y " + s;
                            else    
                                s = t;
                            }
                            break;
                        case Centena:
                            p = d - 1; 
                            t = V[ 30 + p ];
         
                            if( n % 100  == 0 ) 
                                { s = ""; e = ""; }  
                            else 
                                if( d == 1 ) t += "to";  
                                       
                            s = t + e + s;                                       
                            z = ( s + z );   
                            break;          
                    }  
                                
                    e = " ";     
                    //ini. calcula los miles, millones, billones
                    r = l - i;                                
                    if( r > 0 && r % 3 == 0  ){
                        p = ( r > 10 )?  2 : j++ & 1;     
                        t = V[ 40 + p ];
                                        
                        if( p > 0 )
                            if( ( n == 1 && i > 1 ) || n > 1  ) t += "es";
                                        
                        z = e + t + e + z;
                    }
                              //fin.
                                
                               //reinicia las variables
                    if ( u == Centena ){  u = 1;  n = 0;  s = "";  } else u *= 10;                                 
                } 
             }      

           //ini. adiciona la moneda y los centavos
             if ( !c.equals("") ) c = " con " + c + " centimos";            
             if ( !sMoney.equals("") )        
                sMoney = " " + sMoney; 
             else
                if( b > 0 ) z += "o";  
           //fin. 
            
             z = ( s + z ) + sMoney + c;
        }
        catch(NumberFormatException ex){
            z = "ERROR [readNumber]: Formato numerico incorrecto.";
        }      
        return z;    
    }
    /**
     * @author MITM
     * @return 
     */
    private static String[] initVector(  ){
        String V[] = new String[43];
        
        V[0] = "cero";
        V[1] = "un";
        V[2] = "dos";
        V[3] = "tres";
        V[4] = "cuatro";
        V[5] = "cinco";
        V[6] = "seis";
        V[7] = "siete";
        V[8] = "ocho";
        V[9] = "nueve";
        V[10] = "diez";
        V[11] = "once";
        V[12] = "doce";
        V[13] = "trece";
        V[14] = "catorce";
        V[15] = "quince";
        V[16] = "dieciseis";
        V[17] = "diecisiete";
        V[18] = "dieciocho";
        V[19] = "diecinueve";
        V[20] = "veinte";
        V[21] = "treinta";
        V[22] = "cuarenta";
        V[23] = "cincuenta";
        V[24] = "secenta";
        V[25] = "setenta";
        V[26] = "ochenta";
        V[27] = "noventa";
        V[28] = "";
        V[29] = "";
        V[30] = "cien";
        V[31] = "doscientos";
        V[32] = "trescientos";
        V[33] = "cuatrocientos";
        V[34] = "quinientos";
        V[35] = "seiscientos";
        V[36] = "setecientos";
        V[37] = "ochocientos";
        V[38] = "novecientos";
        V[39] = "";
        V[40] = "mil";
        V[41] = "millon";
        V[42] = "billon";
        
        return V;
    }        

    /***************************************************************************/
    /********************************* USERS ***********************************/
    /***************************************************************************/
    
    /**
     * 
     * @param text
     * @param old
     * @param text1
     * @param pswd
     * @return 
     */
    public static boolean validar_UpdatePswd(String text, String old, String text1, String pswd) {
        boolean opc1 = true;                
//        boolean opc1 = validarTexto(text,20,numerosYletras,false);                
        boolean opc2 = validarPasswordOld(text1, pswd);        
        boolean opc3 = validarPasswordOld(text, old);        
        
        if(opc1){
            if(opc2){
                if(opc3){                
                    return true;
                }else{
                    Gui.getInstance().ventanaError("Error Confirmado la Contraseña Anterior");
                    return false;
                }
             
            }else{
                Gui.getInstance().ventanaError("Error Confirmado la Nueva Contraseña");
                return false;
            }
        }else{
            Gui.getInstance().ventanaError("Existen Parametros que no cumplen las especificaciones!");
            return false;
        }
    }
    
    
    /***************************************************************************/
    /********************************* ROLE ************************************/
    /***************************************************************************/
    
    /**
     * @author MITM
     * @param role
     * @return 
     */
    public static boolean validar_Save_Rol(Rol role) {
        boolean opc1 = validarTexto(role.getNombre(),150,numerosYletras,false);
        boolean opc2 = validarTexto(role.getAbrev(),5,soloLetras,true);
        
        if(opc1 && opc2){
            return true;
        }else{
            Gui.getInstance().ventanaError("Existen Parametros que no cumplen las especificaciones!");
            return false;
        }
    }

    
    /***************************************************************************/
    /***************************** GROUPSUPPLIER *******************************/
    /***************************************************************************/
    
     /**
     * @author MITM
     * @param groupsupplier
     * @return 
     */
    public static boolean validar_Save_GroupSupplier(GroupSupplier groupsupplier) {
        boolean opc1 = validarTexto(groupsupplier.getNombre(),150,numerosYletras,false);
        boolean opc2 = validarTexto(groupsupplier.getAbrev(),5,soloLetras,true);
        
        if(opc1 && opc2){
            return true;
        }else{
            Gui.getInstance().ventanaError("Existen Parametros que no cumplen las especificaciones!");
            return false;
        }
    }

    
    /***************************************************************************/
    /******************************** MEASURE **********************************/
    /***************************************************************************/
    
    /**
     * @author MITM
     * @param measure
     * @return 
     */
    public static boolean validar_Save_Measure(Measure measure) {
        boolean opc1 = validarTexto(measure.getNombre(),150,numerosYletras,false);
        boolean opc2 = validarTexto(measure.getAbrev(),5,soloLetras,true);
        
        if(!opc1 || !opc2){
            Gui.getInstance().ventanaError("Existen Parametros que no cumplen las especificaciones!");
            return false;
        }else{
            return true;
        }
    }

    
    /***************************************************************************/
    /********************************* UNIT ************************************/
    /***************************************************************************/
    
    /**
     * @author MITM
     * @param unit
     * @return 
     */
    public static boolean validar_Save_Unit(Unit unit) {
        boolean opc1 = validarTexto(unit.getNombre(),150,numerosYletras,false);
        boolean opc2 = validarTexto(unit.getAbrev(),5,soloLetras,true);
        
        if(!opc1 || !opc2){
            Gui.getInstance().ventanaError("Existen Parametros que no cumplen las especificaciones!");
            return false;
        }else{
            return true;
        }
    }

    
    /***************************************************************************/
    /******************************** REASON ***********************************/
    /***************************************************************************/
    
    /**
     * @author MITM
     * @param log_tmotdev
     * @return 
     */
    public static boolean validar_Save_log_TMotdev(log_TMotdev log_tmotdev) {
        boolean opc1 = validarTexto(log_tmotdev.getNombre(),150,numerosYletras,false);
        boolean opc2 = validarTexto(log_tmotdev.getAbrev(),5,numerosYletras,true);
        
        if(!opc1 || !opc2){
            Gui.getInstance().ventanaError("Existen Parametros que no cumplen las especificaciones!");
            return false;
        }else{
            return true;
        }
    }

    
    /***************************************************************************/
    /******************************** SUPPLIER *********************************/
    /***************************************************************************/
    
    /**
     * @author MITM
     * @param supplier
     * @return 
     */
    public static boolean validar_Save_Supplier(Supplier supplier) {
        boolean opc1 = validarTexto(supplier.getNombre(),250,numerosYletras,false);
        boolean opc2 = validarTexto(supplier.getFirma(),100,numerosYletras,true);
        boolean opc3 = validarTexto(supplier.getDireccion(),250,numerosYletras,false);
        boolean opc4 = validarTexto(supplier.getTelefonos(),50,soloTelefonos,false);
        boolean opc5 = validarTexto(supplier.getFax(),15,soloTelefonos,true);
        boolean opc6 = validarTexto(supplier.getContacto(),50,numerosYletras,true);
        boolean opc7 = validarTexto(supplier.getCelular(),15,soloTelefonos,true);
        boolean opc8 = validarTexto(supplier.getCorreo1(),50,soloCorreos,true);

        if(opc1 && opc2 && opc3 && opc4 && opc5 && opc6 && opc7 && opc8){
            return true;
        }else{
            Gui.getInstance().ventanaError("Existen Parametros que no cumplen las especificaciones!");
            return false;
        }
    }

    
    /***************************************************************************/
    /********************************* SEX *************************************/
    /***************************************************************************/
    
     /**
     * @author MITM
     * @param sex
     * @return 
     */
    public static boolean validar_Save_Sex(Sex sex) {
        boolean opc1 = validarTexto(sex.getNombre(),150,soloLetras,false);
        boolean opc2 = validarTexto(sex.getAbrev(),5,soloLetras,true);
        
        if(opc1 && opc2){
            return true;
        }else{
            Gui.getInstance().ventanaError("Existen Parametros que no cumplen las especificaciones!");
            return false;
        }
    }
    
    
    /***************************************************************************/
    /****************************** LOG_PERSONAL *******************************/
    /***************************************************************************/
    
    /**
     * @author MITM
     * @param log_personal
     * @return 
     */
    public static boolean validar_Save_log_Personal(log_Personal log_personal) {
        boolean opc4 = true;
        boolean opc5 = true;
        boolean opc6 = true;

        boolean opc1 = validarTexto(log_personal.getNombres(),250,numerosYletras,false);
        boolean opc2 = validarTexto(log_personal.getApellidos(),100,numerosYletras,true);
        boolean opc3 = validarTexto(log_personal.getDireccion(),250,numerosYletras,false);

        if (log_personal.getTelefonos() != null)
            opc4 = validarTexto(log_personal.getTelefonos(),50,soloTelefonos,false);

        if (log_personal.getCelular() != null)
            opc5 = validarTexto(log_personal.getCelular(),15,soloTelefonos,true);
        
        if (log_personal.getCorreo() != null)
            opc6 = validarTexto(log_personal.getCorreo(),50,soloCorreos,true);
        
        
        if(opc1 && opc2 && opc3 && opc4 && opc5 && opc6){
            return true;
        }else{
            Gui.getInstance().ventanaError("Existen Parametros que no cumplen las especificaciones!");
            return false;
        }
    }

    
    /***************************************************************************/
    /***************************** LOG_TPERSONAL *******************************/
    /***************************************************************************/
    
     /**
     * @author MITM
     * @param log_tpersonal
     * @return 
     */
    public static boolean validar_Save_log_TPersonal(log_TPersonal log_tpersonal) {
        boolean opc1 = validarTexto(log_tpersonal.getNombre(),150,soloLetras,false);
        boolean opc2 = validarTexto(log_tpersonal.getAbrev(),5,soloLetras,true);
        
        if(!opc1 || !opc2){
            Gui.getInstance().ventanaError("Existen Parametros que no cumplen las especificaciones!");
            return false;
        }else{
            return true;
        }
    }
    
    
    /***************************************************************************/
    /****************************** LOG_VEHICULO *******************************/
    /***************************************************************************/
    
    /**
     * @author MITM
     * @param log_vehiculos
     * @return 
     */
    public static boolean validar_Save_log_Vehiculos(log_Vehiculos log_vehiculos) {
        boolean opc3 = true;
        boolean opc5 = true;
        boolean opc6 = true;

        boolean opc1 = validarTexto(log_vehiculos.getModelo(),25,numerosYletras,false);
        boolean opc2 = validarTexto(Integer.toString(log_vehiculos.getCap_cargkgrs()),5,soloNumeros,false);
        
        if (log_vehiculos.getEmpresa() != null)
            opc3 = validarTexto(log_vehiculos.getEmpresa(),150,numerosYletras,false);

        boolean opc4 = validarTexto(Integer.toString(log_vehiculos.getAno()),50,soloNumeros,false);

        if (log_vehiculos.getCelular() != null)
            opc5 = validarTexto(log_vehiculos.getCelular(),15,soloTelefonos,true);
        
        if (log_vehiculos.getCorreo() != null)
            opc6 = validarTexto(log_vehiculos.getCorreo(),50,soloCorreos,true);
        
        if(opc1 && opc2 && opc3 && opc4 && opc5 && opc6){
            return true;
        }else{
            Gui.getInstance().ventanaError("Existen Parametros que no cumplen las especificaciones!");
            return false;
        }
    }

    
    /***************************************************************************/
    /****************************** LOG_TMARCA *********************************/
    /***************************************************************************/
    
     /**
     * @author MITM
     * @param log_tmarca
     * @return 
     */
    public static boolean validar_Save_log_TMarca(log_TMarca log_tmarca) {
        boolean opc1 = validarTexto(log_tmarca.getNombre(),150,soloLetras,false);
        boolean opc2 = validarTexto(log_tmarca.getAbrev(),5,soloLetras,true);
        
        if(!opc1 || !opc2){
            Gui.getInstance().ventanaError("Existen Parametros que no cumplen las especificaciones!");
            return false;
        }else{
            return true;
        }
    }
    
    
    /***************************************************************************/
    /****************************** LOG_TPROCED ********************************/
    /***************************************************************************/
    
     /**
     * @author MITM
     * @param log_tproced
     * @return 
     */
    public static boolean validar_Save_log_TProced(log_TProced log_tproced) {
        boolean opc1 = validarTexto(log_tproced.getNombre(),150,soloLetras,false);
        boolean opc2 = validarTexto(log_tproced.getAbrev(),5,soloLetras,true);
        
        if(!opc1 || !opc2){
            Gui.getInstance().ventanaError("Existen Parametros que no cumplen las especificaciones!");
            return false;
        }else{
            return true;
        }
    }
    
    
    /***************************************************************************/
    /****************************** LOG_TTRANSP ********************************/
    /***************************************************************************/
    
     /**
     * @author MITM
     * @param log_ttransp
     * @return 
     */
    public static boolean validar_Save_log_TTransp(log_TTransp log_ttransp) {
        boolean opc1 = validarTexto(log_ttransp.getNombre(),150,soloLetras,false);
        boolean opc2 = validarTexto(log_ttransp.getAbrev(),5,soloLetras,true);
        
        if(!opc1 || !opc2){
            Gui.getInstance().ventanaError("Existen Parametros que no cumplen las especificaciones!");
            return false;
        }else{
            return true;
        }
    }
    

    /***************************************************************************/
    /****************************** LOG_TSEGUROS *******************************/
    /***************************************************************************/
    
     /**
     * @author MITM
     * @param log_tseguros
     * @return 
     */
    public static boolean validar_Save_log_TSeguros(log_TSeguros log_tseguros) {
        boolean opc1 = validarTexto(log_tseguros.getNombre(),150,soloLetras,false);
        boolean opc2 = validarTexto(log_tseguros.getAbrev(),5,soloLetras,true);
        
        if(!opc1 || !opc2){
            Gui.getInstance().ventanaError("Existen Parametros que no cumplen las especificaciones!");
            return false;
        }else{
            return true;
        }
    }
    

    /***************************************************************************/
    /****************************** LOG_TSEGUROS *******************************/
    /***************************************************************************/
    
     /**
     * @author MITM
     * @param log_tdispflota
     * @return 
     */
    public static boolean validar_Save_log_TDispflota(log_TDispflota log_tdispflota) {
        boolean opc1 = validarTexto(log_tdispflota.getNombre(),150,soloLetras,false);
        boolean opc2 = validarTexto(log_tdispflota.getAbrev(),5,soloLetras,true);
        
        if(!opc1 || !opc2){
            Gui.getInstance().ventanaError("Existen Parametros que no cumplen las especificaciones!");
            return false;
        }else{
            return true;
        }
    }
    

    /***************************************************************************/
    /********************************* GUIDE ***********************************/
    /***************************************************************************/
    
     /**
     * @author MITM
     * @param log_cguias
     * @return 
     */
    public static boolean validar_Save_log_CGuias(log_CGuias log_cguias) {
        boolean opc4 = true;

        boolean opc1 = validarTexto(Integer.toString(log_cguias.getNumpuerta()),2,soloNumeros,false);
        boolean opc2 = validarTexto(log_cguias.getChofer(),8,soloNumeros,false);
        boolean opc3 = validarTexto(log_cguias.getVeh1(),7,numerosYletras,false);

        if (log_cguias.getAyud1() != null)
            opc4 = validarTexto(log_cguias.getAyud1(),8,soloNumeros,true);

        boolean opc5 = validarTexto(log_cguias.getCheq_pta(),8,soloNumeros,false);
        
        if(opc1 && opc2 && opc3 && opc4 && opc5){
            return true;
        }else{
            Gui.getInstance().ventanaError("Existen Parametros que no cumplen las especificaciones!");
            return false;
        }
    }
    

 }
