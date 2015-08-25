/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Tools;

import Objects.Fxp_Archguid;
import Objects.Fxp_Archguip_pro_cg;
import Objects.Fxp_Archguip_pro_dv;
import Objects.Orders.Orders;
import Objects.Seniat.UploadExcelFile;
import Objects.Setup.City;
import Objects.Setup.Country;
import Objects.Setup.GroupSupplier;
import Objects.Setup.Measure;
import Objects.Setup.Municipality;
import Objects.Setup.Parish;
import Objects.Setup.Reason;
import Objects.System.Sesion;
import Objects.Setup.Sex;
import Objects.Setup.State;
import Objects.Setup.Unit;
import Objects.System.ItemLeftBar;
import Objects.System.Rol;
import Objects.System.Usuario;
import Objects.Orders.Supplier;
import Objects.log_CGuias;
import Objects.log_CGuias_Glomar_invoice;
import Objects.log_CGuias_Glomar_price;
import Objects.log_CGuias_falt;
import Objects.log_CGuias_falt_cg;
import Objects.log_CGuias_falt_dv;
import Objects.log_CGuias_perm;
import Objects.log_Guide_rel_inv;
import Objects.log_Personal;
import Objects.log_TMarca;
import Objects.log_TPersonal;
import Objects.log_TProced;
import Objects.log_TTransp;
import Objects.log_Vehiculos;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import javafx.scene.control.ComboBox;

/**
 *
 * @author ARMGARCES
 */
public class Datos {
 
    private static Sesion sesion;
    private static int cont_login = 0;
    private static int idScreen = 0;
    private static int idButton = 0;
    private static int stSeniat = 0;

    private static String numRela;
    private static String numRel_Dev;
    private static String numRel_Caj;
    private static String numOrd_comp;
    
    private static String path_im_view;

    private static Usuario                      usuario;
    private static City                         city;
    private static Country                      country;
    private static GroupSupplier                groupSupplier;
    private static log_CGuias                   log_cguias;
    private static log_Guide_rel_inv            log_guide_rel_inv;
    private static log_TMarca                   log_tmarca;
    private static log_Personal                 log_personal;
    private static log_TPersonal                log_tpersonal;
    private static log_TProced                  log_tproced;
    private static log_TTransp                  log_ttransp;
    private static log_Vehiculos                log_vehiculos;
    private static Measure                      measure;
    private static Municipality                 municipality;
    private static Orders                       orders;
    private static Parish                       parish;
    private static Rol                          role;
    private static Reason                       reason;
    private static Sex                          sex;
    private static State                        state;
    private static Supplier                     supplier;
    private static Unit                         unit;
    private static UploadExcelFile              updloadexcelfile;

    private static ComboBox<Rol>                roles;
    private static ComboBox<Country>            cbCountry;
    private static ComboBox<City>               cbCity;
    private static ComboBox<GroupSupplier>      cbGroupSupplier;
    private static ComboBox<log_TMarca>         cbMarca;
    private static ComboBox<log_TPersonal>      cbTPersonal;
    private static ComboBox<log_TProced>        cbProced;
    private static ComboBox<log_TTransp>        cbTTransp;
    private static ComboBox<Municipality>       cbMunicipality;
    private static ComboBox<Parish>             cbParish;
    private static ComboBox<Reason>             cbReason;
    private static ComboBox<Sex>                cbSex;
    private static ComboBox<State>              cbState;
    private static ComboBox<Unit>               cbUnit;
    
    private static ItemLeftBar[]                itemLeftBar; 
    private static Fxp_Archguid[]               rep_log_guide_doc;
    private static Fxp_Archguip_pro_cg[]        rep_log_guide_pro_cg;
    private static Fxp_Archguip_pro_dv[]        rep_log_guide_pro_dv;
    private static GroupSupplier[]              rep_grp_supplier;
    private static Measure[]                    rep_measure;
    private static log_CGuias[]                 rep_log_cguias;
    private static log_CGuias_falt[]            rep_log_cguias_falt;
    private static log_CGuias_falt_cg[]         rep_log_cguias_fcar;
    private static log_CGuias_falt_dv[]         rep_log_cguias_fdev;
    private static log_CGuias_perm[]            rep_log_cguias_perm;
    private static log_CGuias_Glomar_price[]    rep_log_cguias_glomar_price;
    private static log_CGuias_Glomar_invoice[]  rep_log_cguias_glomar_invoice;
    private static log_Guide_rel_inv[]          rep_log_guide_rel_inv;
    private static log_Personal[]               rep_log_personal;
    private static log_TPersonal[]              rep_log_tpersonal;
    private static log_Vehiculos[]              rep_log_vehiculo;
    private static Orders[]                     rep_orders;
    private static Reason[]                     rep_reason;
    private static Rol[]                        rep_role;
    private static Supplier[]                   rep_supplier;
    private static Unit[]                       rep_unit;
    private static UploadExcelFile[]            rep_updloadexcelfile;

    /**
     * @return the sesion
     */
    public static Sesion getSesion() {
        return sesion;
    }
    /**
     * @param _sesion the sesion to set
     */
    public static void setSesion(Sesion _sesion) {
        sesion = _sesion;
    }

    /**
     * @return the cont_login
     */
    public static int getCont_login() {
        return cont_login;
    }

    /**
     * @param aCont_login the cont_login to set
     */
    public static void setCont_login(int aCont_login) {
        cont_login = aCont_login;
    }
    
    /**
     * @return the cont_login
     */
    public static void sumCont_login() {
        cont_login++;
    }

    /**
     * @return the idScreen
     */
    public static int getIdScreen() {
        return idScreen;
    }

    /**
     * @param aIdScreen the idScreen to set
     */
    public static void setIdScreen(int aIdScreen) {
        idScreen = aIdScreen;
    }
    
    /**
     * @return the cont_login
     */
    public static String[] getLocalHost() {
        
        InetAddress ip;

        try {
            ip = InetAddress.getLocalHost();
            NetworkInterface network = NetworkInterface.getByInetAddress(ip);
            byte[] sb = network.getHardwareAddress();

            StringBuilder mac = new StringBuilder();
            for (int i = 0; i < sb.length; i++) {
                    mac.append(String.format("%02X%s", sb[i], (i < sb.length - 1) ? "-" : ""));		
            }
            return new String[] {ip.getHostName(), ip.getHostAddress(), mac.toString()};
            
        } catch (UnknownHostException | SocketException e) {
            Tools.getErrorMessage(e.getStackTrace(), e.getMessage());
 	}
        return null;
    }

    /**
     * @return the usuario
     */
    public static Usuario getUsuario() {
        return usuario;
    }

    /**
     * @param aUsuario the usuario to set
     */
    public static void setUsuario(Usuario aUsuario) {
        usuario = aUsuario;
    }

    /**
     * @return the itemLeftBar
     */
    public static ItemLeftBar[] getItemLeftBar() {
        return itemLeftBar;
    }

    /**
     * @param aItemLeftBar the itemLeftBar to set
     */
    public static void setItemLeftBar(ItemLeftBar[] aItemLeftBar) {
        itemLeftBar = aItemLeftBar;
    }

    /**
     * @return the roles
     */
    public static ComboBox<Rol> getRoles() {
        return roles;
    }

    /**
     * @param roles the roles to set
     */
    public static void setRoles(ComboBox<Rol> roles) {
        Datos.roles = roles;
    }
    
    /**
     * @return the usuario
     */
    public static Measure getMeasure() {
        return measure;
    }

    /**
     * @param aUsuario the usuario to set
     */
    public static void setMeasure(Measure aMeasure) {
        measure = aMeasure;
    }

    /**
     * @return the groupSupplier
     */
    public static GroupSupplier getGroupSupplier() {
        return groupSupplier;
    }

    /**
     * @param aGroupSupplier the groupSupplier to set
     */
    public static void setGroupSupplier(GroupSupplier aGroupSupplier) {
        groupSupplier = aGroupSupplier;
    }

    /**
     * @return the cbGroupSupplier
     */
    public static ComboBox<GroupSupplier> getCbGroupSupplier() {
        return cbGroupSupplier;
    }

    /**
     * @param aCbGroupSupplier the cbGroupSupplier to set
     */
    public static void setCbGroupSupplier(ComboBox<GroupSupplier> aCbGroupSupplier) {
        cbGroupSupplier = aCbGroupSupplier;
    }

    /**
     * @return the country
     */
    public static Country getCountry() {
        return country;
    }

    /**
     * @param aCountry the country to set
     */
    public static void setCountry(Country aCountry) {
        country = aCountry;
    }

    /**
     * @return the state
     */
    public static State getState() {
        return state;
    }

    /**
     * @param aState the state to set
     */
    public static void setState(State aState) {
        state = aState;
    }

    /**
     * @return the city
     */
    public static City getCity() {
        return city;
    }

    /**
     * @param aCity the city to set
     */
    public static void setCity(City aCity) {
        city = aCity;
    }

    /**
     * @return the municipality
     */
    public static Municipality getMunicipality() {
        return municipality;
    }

    /**
     * @param aMunicipality the municipality to set
     */
    public static void setMunicipality(Municipality aMunicipality) {
        municipality = aMunicipality;
    }

    /**
     * @return the parish
     */
    public static Parish getParish() {
        return parish;
    }

    /**
     * @param aParish the parish to set
     */
    public static void setParish(Parish aParish) {
        parish = aParish;
    }

    /**
     * @return the cbCountry
     */
    public static ComboBox<Country> getCbCountry() {
        return cbCountry;
    }

    /**
     * @param aCbCountry the cbCountry to set
     */
    public static void setCbCountry(ComboBox<Country> aCbCountry) {
        cbCountry = aCbCountry;
    }

    /**
     * @return the cbState
     */
    public static ComboBox<State> getCbState() {
        return cbState;
    }

    /**
     * @param aCbState the cbState to set
     */
    public static void setCbState(ComboBox<State> aCbState) {
        cbState = aCbState;
    }

    /**
     * @return the cbCity
     */
    public static ComboBox<City> getCbCity() {
        return cbCity;
    }

    /**
     * @param aCbCity the cbCity to set
     */
    public static void setCbCity(ComboBox<City> aCbCity) {
        cbCity = aCbCity;
    }

    /**
     * @return the cbMunicipality
     */
    public static ComboBox<Municipality> getCbMunicipality() {
        return cbMunicipality;
    }

    /**
     * @param aCbMunicipality the cbMunicipality to set
     */
    public static void setCbMunicipality(ComboBox<Municipality> aCbMunicipality) {
        cbMunicipality = aCbMunicipality;
    }

    /**
     * @return the cbParish
     */
    public static ComboBox<Parish> getCbParish() {
        return cbParish;
    }

    /**
     * @param aCbParish the cbParish to set
     */
    public static void setCbParish(ComboBox<Parish> aCbParish) {
        cbParish = aCbParish;
    }

    /**
     * @return the supplier
     */
    public static Supplier getSupplier() {
        return supplier;
    }

    /**
     * @param aSupplier the supplier to set
     */
    public static void setSupplier(Supplier aSupplier) {
        supplier = aSupplier;
    }

    /**
     * @return the stSeniat
     */
    public static int getStSeniat() {
        return stSeniat;
    }

    /**
     * @param aStSeniat the stSeniat to set
     */
    public static void setStSeniat(int aStSeniat) {
        stSeniat = aStSeniat;
    }

    /**
     * @return the sex
     */
    public static Sex getSex() {
        return sex;
    }

    /**
     * @param aSex the sex to set
     */
    public static void setSex(Sex aSex) {
        sex = aSex;
    }

    /**
     * @return the cbSex
     */
    public static ComboBox<Sex> getCbSex() {
        return cbSex;
    }

    /**
     * @param aCbSex the cbSex to set
     */
    public static void setCbSex(ComboBox<Sex> aCbSex) {
        cbSex = aCbSex;
    }

    /**
     * @return the log_personal
     */
    public static log_Personal getLog_personal() {
        return log_personal;
    }

    /**
     * @param aLog_personal the log_personal to set
     */
    public static void setLog_personal(log_Personal aLog_personal) {
        log_personal = aLog_personal;
    }

    /**
     * @return the cbTPersonal
     */
    public static ComboBox<log_TPersonal> getCbTPersonal() {
        return cbTPersonal;
    }

    /**
     * @param aCbTPersonal the cbTPersonal to set
     */
    public static void setCbTPersonal(ComboBox<log_TPersonal> aCbTPersonal) {
        cbTPersonal = aCbTPersonal;
    }

    /**
     * @return the cbMarca
     */
    public static ComboBox<log_TMarca> getCbMarca() {
        return cbMarca;
    }

    /**
     * @param aCbMarca the cbMarca to set
     */
    public static void setCbMarca(ComboBox<log_TMarca> aCbMarca) {
        cbMarca = aCbMarca;
    }

    /**
     * @return the cbProced
     */
    public static ComboBox<log_TProced> getCbProced() {
        return cbProced;
    }

    /**
     * @param aCbProced the cbProced to set
     */
    public static void setCbProced(ComboBox<log_TProced> aCbProced) {
        cbProced = aCbProced;
    }

    /**
     * @return the cbTTransp
     */
    public static ComboBox<log_TTransp> getCbTTransp() {
        return cbTTransp;
    }

    /**
     * @param aCbTTransp the cbTTransp to set
     */
    public static void setCbTTransp(ComboBox<log_TTransp> aCbTTransp) {
        cbTTransp = aCbTTransp;
    }

    /**
     * @return the log_vehiculos
     */
    public static log_Vehiculos getLog_vehiculos() {
        return log_vehiculos;
    }

    /**
     * @param aLog_vehiculos the log_vehiculos to set
     */
    public static void setLog_vehiculos(log_Vehiculos aLog_vehiculos) {
        log_vehiculos = aLog_vehiculos;
    }

    /**
     * @return the rep_log_personal
     */
    public static log_Personal[] getRep_log_personal() {
        return rep_log_personal;
    }

    /**
     * @param aRep_personal the rep_log_personal to set
     */
    public static void setRep_log_personal(log_Personal[] aRep_personal) {
        rep_log_personal = aRep_personal;
    }

    /**
     * @return the rep_log_vehiculo
     */
    public static log_Vehiculos[] getRep_log_vehiculo() {
        return rep_log_vehiculo;
    }

    /**
     * @param aRep_log_vehiculo the rep_log_vehiculo to set
     */
    public static void setRep_log_vehiculo(log_Vehiculos[] aRep_log_vehiculo) {
        rep_log_vehiculo = aRep_log_vehiculo;
    }

    /**
     * @return the rep_log_tpersonal
     */
    public static log_TPersonal[] getRep_log_tpersonal() {
        return rep_log_tpersonal;
    }

    /**
     * @param aRep_log_tpersonal the rep_log_tpersonal to set
     */
    public static void setRep_log_tpersonal(log_TPersonal[] aRep_log_tpersonal) {
        rep_log_tpersonal = aRep_log_tpersonal;
    }

    /**
     * @return the rep_grp_supplier
     */
    public static GroupSupplier[] getRep_grp_supplier() {
        return rep_grp_supplier;
    }

    /**
     * @param aRep_grp_supplier the rep_grp_supplier to set
     */
    public static void setRep_grp_supplier(GroupSupplier[] aRep_grp_supplier) {
        rep_grp_supplier = aRep_grp_supplier;
    }

    /**
     * @return the rep_measure
     */
    public static Measure[] getRep_measure() {
        return rep_measure;
    }

    /**
     * @param aRep_measure the rep_measure to set
     */
    public static void setRep_measure(Measure[] aRep_measure) {
        rep_measure = aRep_measure;
    }

    /**
     * @return the rep_supplier
     */
    public static Supplier[] getRep_supplier() {
        return rep_supplier;
    }

    /**
     * @param aRep_supplier the rep_supplier to set
     */
    public static void setRep_supplier(Supplier[] aRep_supplier) {
        rep_supplier = aRep_supplier;
    }

    /**
     * @return the unit
     */
    public static Unit getUnit() {
        return unit;
    }

    /**
     * @param aUnit the unit to set
     */
    public static void setUnit(Unit aUnit) {
        unit = aUnit;
    }

    /**
     * @return the rep_unit
     */
    public static Unit[] getRep_unit() {
        return rep_unit;
    }

    /**
     * @param aRep_unit the rep_unit to set
     */
    public static void setRep_unit(Unit[] aRep_unit) {
        rep_unit = aRep_unit;
    }

    /**
     * @return the idButton
     */
    public static int getIdButton() {
        return idButton;
    }

    /**
     * @param aIdButton the idButton to set
     */
    public static void setIdButton(int aIdButton) {
        idButton = aIdButton;
    }

    /**
     * @return the cbUnit
     */
    public static ComboBox<Unit> getCbUnit() {
        return cbUnit;
    }

    /**
     * @param aCbUnit the cbUnit to set
     */
    public static void setCbUnit(ComboBox<Unit> aCbUnit) {
        cbUnit = aCbUnit;
    }

    /**
     * @return the path_im_view
     */
    public static String getPath_im_view() {
        return path_im_view;
    }

    /**
     * @param aPath_im_view the path_im_view to set
     */
    public static void setPath_im_view(String aPath_im_view) {
        path_im_view = aPath_im_view;
    }

    /**
     * @return the log_cguias
     */
    public static log_CGuias getLog_cguias() {
        return log_cguias;
    }

    /**
     * @param aLog_cguias the log_cguias to set
     */
    public static void setLog_cguias(log_CGuias aLog_cguias) {
        log_cguias = aLog_cguias;
    }

    /**
     * @return the log_guide_rel_inv
     */
    public static log_Guide_rel_inv getLog_guide_rel_inv() {
        return log_guide_rel_inv;
    }

    /**
     * @param aLog_guide_rel_inv the log_guide_rel_inv to set
     */
    public static void setLog_guide_rel_inv(log_Guide_rel_inv aLog_guide_rel_inv) {
        log_guide_rel_inv = aLog_guide_rel_inv;
    }

    /**
     * @return the numRela
     */
    public static String getNumRela() {
        return numRela;
    }

    /**
     * @param aNumRela the numRela to set
     */
    public static void setNumRela(String aNumRela) {
        numRela = aNumRela;
    }

    /**
     * @return the reason
     */
    public static Reason getReason() {
        return reason;
    }

    /**
     * @param aReason the reason to set
     */
    public static void setReason(Reason aReason) {
        reason = aReason;
    }

    /**
     * @return the rep_reason
     */
    public static Reason[] getRep_reason() {
        return rep_reason;
    }

    /**
     * @param aRep_reason the rep_reason to set
     */
    public static void setRep_reason(Reason[] aRep_reason) {
        rep_reason = aRep_reason;
    }

    /**
     * @return the rep_log_guide_rel_inv
     */
    public static log_Guide_rel_inv[] getRep_log_guide_rel_inv() {
        return rep_log_guide_rel_inv;
    }

    /**
     * @param aRep_log_guide_rel_inv the rep_log_guide_rel_inv to set
     */
    public static void setRep_log_guide_rel_inv(log_Guide_rel_inv[] aRep_log_guide_rel_inv) {
        rep_log_guide_rel_inv = aRep_log_guide_rel_inv;
    }

    /**
     * @return the rep_log_guide_doc
     */
    public static Fxp_Archguid[] getRep_log_guide_doc() {
        return rep_log_guide_doc;
    }

    /**
     * @param aRep_log_guide_doc the rep_log_guide_doc to set
     */
    public static void setRep_log_guide_doc(Fxp_Archguid[] aRep_log_guide_doc) {
        rep_log_guide_doc = aRep_log_guide_doc;
    }

    /**
     * @return the cbReason
     */
    public static ComboBox<Reason> getCbReason() {
        return cbReason;
    }

    /**
     * @param aCbReason the cbReason to set
     */
    public static void setCbReason(ComboBox<Reason> aCbReason) {
        cbReason = aCbReason;
    }

    /**
     * @return the rep_log_guide_pro_cg
     */
    public static Fxp_Archguip_pro_cg[] getRep_log_guide_pro_cg() {
        return rep_log_guide_pro_cg;
    }

    /**
     * @param aRep_log_guide_pro_cg the rep_log_guide_pro_cg to set
     */
    public static void setRep_log_guide_pro_cg(Fxp_Archguip_pro_cg[] aRep_log_guide_pro_cg) {
        rep_log_guide_pro_cg = aRep_log_guide_pro_cg;
    }

    /**
     * @return the rep_log_guide_pro_dv
     */
    public static Fxp_Archguip_pro_dv[] getRep_log_guide_pro_dv() {
        return rep_log_guide_pro_dv;
    }

    /**
     * @param aRep_log_guide_pro_dv the rep_log_guide_pro_dv to set
     */
    public static void setRep_log_guide_pro_dv(Fxp_Archguip_pro_dv[] aRep_log_guide_pro_dv) {
        rep_log_guide_pro_dv = aRep_log_guide_pro_dv;
    }

    /**
     * @return the numRel_Dev
     */
    public static String getNumRel_Dev() {
        return numRel_Dev;
    }

    /**
     * @param aNumRelDev the numRel_Dev to set
     */
    public static void setNumRel_Dev(String aNumRelDev) {
        numRel_Dev = aNumRelDev;
    }

    /**
     * @return the rep_log_cguias
     */
    public static log_CGuias[] getRep_log_cguias() {
        return rep_log_cguias;
    }

    /**
     * @param aRep_log_cguias the rep_log_cguias to set
     */
    public static void setRep_log_cguias(log_CGuias[] aRep_log_cguias) {
        rep_log_cguias = aRep_log_cguias;
    }

    /**
     * @return the rep_log_cguias_fcar
     */
    public static log_CGuias_falt_cg[] getRep_log_cguias_fcar() {
        return rep_log_cguias_fcar;
    }

    /**
     * @param aRep_log_cguias_fcar the rep_log_cguias_fcar to set
     */
    public static void setRep_log_cguias_fcar(log_CGuias_falt_cg[] aRep_log_cguias_fcar) {
        rep_log_cguias_fcar = aRep_log_cguias_fcar;
    }

    /**
     * @return the rep_log_cguias_fdev
     */
    public static log_CGuias_falt_dv[] getRep_log_cguias_fdev() {
        return rep_log_cguias_fdev;
    }

    /**
     * @param aRep_log_cguias_fdev the rep_log_cguias_fdev to set
     */
    public static void setRep_log_cguias_fdev(log_CGuias_falt_dv[] aRep_log_cguias_fdev) {
        rep_log_cguias_fdev = aRep_log_cguias_fdev;
    }

    /**
     * @return the rep_log_cguias_perm
     */
    public static log_CGuias_perm[] getRep_log_cguias_perm() {
        return rep_log_cguias_perm;
    }

    /**
     * @param aRep_log_cguias_perm the rep_log_cguias_perm to set
     */
    public static void setRep_log_cguias_perm(log_CGuias_perm[] aRep_log_cguias_perm) {
        rep_log_cguias_perm = aRep_log_cguias_perm;
    }

    /**
     * @return the role
     */
    public static Rol getRole() {
        return role;
    }

    /**
     * @param aRole the role to set
     */
    public static void setRole(Rol aRole) {
        role = aRole;
    }

    /**
     * @return the rep_role
     */
    public static Rol[] getRep_role() {
        return rep_role;
    }

    /**
     * @param aRep_role the rep_role to set
     */
    public static void setRep_role(Rol[] aRep_role) {
        rep_role = aRep_role;
    }

    /**
     * @return the numRel_Caj
     */
    public static String getNumRel_Caj() {
        return numRel_Caj;
    }

    /**
     * @param aNumRel_Caj the numRel_Caj to set
     */
    public static void setNumRel_Caj(String aNumRel_Caj) {
        numRel_Caj = aNumRel_Caj;
    }

    /**
     * @return the rep_log_cguias_glomar_price
     */
    public static log_CGuias_Glomar_price[] getRep_log_cguias_glomar_price() {
        return rep_log_cguias_glomar_price;
    }

    /**
     * @param aRep_log_cguias_glomar_price the rep_log_cguias_glomar_price to set
     */
    public static void setRep_log_cguias_glomar_price(log_CGuias_Glomar_price[] aRep_log_cguias_glomar_price) {
        rep_log_cguias_glomar_price = aRep_log_cguias_glomar_price;
    }

    /**
     * @return the updloadexcelfile
     */
    public static UploadExcelFile getUpdloadexcelfile() {
        return updloadexcelfile;
    }

    /**
     * @param aUpdloadexcelfile the updloadexcelfile to set
     */
    public static void setUpdloadexcelfile(UploadExcelFile aUpdloadexcelfile) {
        updloadexcelfile = aUpdloadexcelfile;
    }

    /**
     * @return the rep_log_cguias_glomar_invoice
     */
    public static log_CGuias_Glomar_invoice[] getRep_log_cguias_glomar_invoice() {
        return rep_log_cguias_glomar_invoice;
    }

    /**
     * @param aRep_log_cguias_glomar_invoice the rep_log_cguias_glomar_invoice to set
     */
    public static void setRep_log_cguias_glomar_invoice(log_CGuias_Glomar_invoice[] aRep_log_cguias_glomar_invoice) {
        rep_log_cguias_glomar_invoice = aRep_log_cguias_glomar_invoice;
    }

    /**
     * @return the rep_updloadexcelfile
     */
    public static UploadExcelFile[] getRep_updloadexcelfile() {
        return rep_updloadexcelfile;
    }

    /**
     * @param aRep_updloadexcelfile the rep_updloadexcelfile to set
     */
    public static void setRep_updloadexcelfile(UploadExcelFile[] aRep_updloadexcelfile) {
        rep_updloadexcelfile = aRep_updloadexcelfile;
    }

    /**
     * @return the rep_log_cguias_falt
     */
    public static log_CGuias_falt[] getRep_log_cguias_falt() {
        return rep_log_cguias_falt;
    }

    /**
     * @param aRep_log_cguias_falt the rep_log_cguias_falt to set
     */
    public static void setRep_log_cguias_falt(log_CGuias_falt[] aRep_log_cguias_falt) {
        rep_log_cguias_falt = aRep_log_cguias_falt;
    }

    /**
     * @return the orders
     */
    public static Orders getOrders() {
        return orders;
    }

    /**
     * @param aOrders the orders to set
     */
    public static void setOrders(Orders aOrders) {
        orders = aOrders;
    }

    /**
     * @return the rep_orders
     */
    public static Orders[] getRep_orders() {
        return rep_orders;
    }

    /**
     * @param aRep_orders the rep_orders to set
     */
    public static void setRep_orders(Orders[] aRep_orders) {
        rep_orders = aRep_orders;
    }

    /**
     * @return the numOrd_comp
     */
    public static String getNumOrd_comp() {
        return numOrd_comp;
    }

    /**
     * @param aNumOrd_comp the numOrd_comp to set
     */
    public static void setNumOrd_comp(String aNumOrd_comp) {
        numOrd_comp = aNumOrd_comp;
    }

}
