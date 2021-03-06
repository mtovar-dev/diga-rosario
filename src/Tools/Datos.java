/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Tools;

import Objects.Fxp_Archguid;
import Objects.Fxp_Archguip_pro_cg;
import Objects.Fxp_Archguip_pro_dv;
import Objects.Indicators.Zsi_nros_sem;
import Objects.Indicators.Zsi_nros_sem_avg;
import Objects.Indicators.Zsi_nros_sem_day;
import Objects.Indicators.Zsi_nros_sem_r;
import Objects.Inventory.InventoryBlockProd;
import Objects.Orders.Orders;
import Objects.Seniat.UploadExcelFile;
import Objects.Setup.City;
import Objects.Setup.Country;
import Objects.Setup.GroupSupplier;
import Objects.Setup.Measure;
import Objects.Setup.Municipality;
import Objects.Setup.Parish;
import Objects.log_TMotdev;
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
import Objects.log_CGuias_falt_cg;
import Objects.log_CGuias_falt_dv;
import Objects.log_CGuias_perm;
import Objects.log_Guide_rel_inv;
import Objects.log_Personal;
import Objects.log_TDispflota;
import Objects.log_TMarca;
import Objects.log_TPersonal;
import Objects.log_TProced;
import Objects.log_TSeguros;
import Objects.log_TTransp;
import Objects.log_Vehiculos;
import Objects.Reports.Dev_FanulSucursales;
import Objects.Reports.Dev_FaltCarga;
import Objects.Setup.Branch;
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
    private static String numOrd_toma;
    private static String path_im_view;

    
    private static ComboBox<Branch>             cbBranch;
    private static ComboBox<City>               cbCity;
    private static ComboBox<Country>            cbCountry;
    private static ComboBox<Municipality>       cbMunicipality;
    private static ComboBox<Parish>             cbParish;
    private static ComboBox<Rol>                cbRoles;
    private static ComboBox<Sex>                cbSex;
    private static ComboBox<State>              cbState;
    private static ComboBox<Unit>               cbUnit;

    private static ComboBox<GroupSupplier>      cbGroupSupplier;
    private static ComboBox<log_TMarca>         cbMarca;
    private static ComboBox<log_TPersonal>      cbTPersonal;
    private static ComboBox<log_TProced>        cbProced;
    private static ComboBox<log_TTransp>        cbTTransp;
    private static ComboBox<log_TMotdev>        cbLog_tmotdev;
    private static ComboBox<log_TSeguros>       cbTSeguro;
    private static ComboBox<log_TDispflota>     cbLog_tdispflota;
    
    
    private static Usuario                      user;
    private static Branch                       branch;
    private static City                         city;
    private static Country                      country;
    private static GroupSupplier                groupSupplier;
    private static InventoryBlockProd           invenblockprod;
    private static Measure                      measure;
    private static Municipality                 municipality;
    private static Orders                       orders;
    private static Parish                       parish;
    private static Rol                          role;
    private static Sex                          sex;
    private static State                        state;
    private static Supplier                     supplier;
    private static Unit                         unit;
    private static UploadExcelFile              updloadexcelfile;

    private static log_CGuias                   log_cguias;
    private static log_Guide_rel_inv            log_guide_rel_inv;
    private static log_Personal                 log_personal;
    private static log_TDispflota               log_tdispflota;
    private static log_TMarca                   log_tmarca;
    private static log_TMotdev                  log_tmotdev;
    private static log_TPersonal                log_tpersonal;
    private static log_TProced                  log_tproced;
    private static log_TSeguros                 log_tseguros;
    private static log_TTransp                  log_ttransp;
    private static log_Vehiculos                log_vehiculos;

    private static Zsi_nros_sem                 zsi_nros_sem;
    private static Zsi_nros_sem_avg             zsi_nros_sem_avg;
    private static Zsi_nros_sem_day             zsi_nros_sem_day;
    private static Zsi_nros_sem_r               zsi_nros_sem_r;
    
    
    private static ItemLeftBar[]                itemLeftBar; 

    private static Fxp_Archguid[]               rep_log_guide_doc;
    private static Fxp_Archguip_pro_cg[]        rep_log_guide_pro_cg;
    private static Fxp_Archguip_pro_dv[]        rep_log_guide_pro_dv;

    private static Dev_FanulSucursales[]        rep_dev_fanulaucursales;
    private static Dev_FaltCarga[]              rep_dev_faltcarga;

    private static Zsi_nros_sem_avg[]           ind_zsi_nros_sem_avg;
    private static Zsi_nros_sem_day[]           ind_zsi_nros_sem_day;
    private static Zsi_nros_sem_r[]             ind_zsi_nros_sem_r;
    
    private static GroupSupplier[]              rep_grp_supplier;
    private static InventoryBlockProd[]         rep_invenblockprod;
    private static Measure[]                    rep_measure;
    private static Orders[]                     rep_orders;
    private static Rol[]                        rep_role;
    private static Supplier[]                   rep_supplier;
    private static Unit[]                       rep_unit;
    private static UploadExcelFile[]            rep_updloadexcelfile;

    private static log_CGuias[]                 rep_log_cguias;
    private static log_CGuias_falt_cg[]         rep_log_cguias_fcar;
    private static log_CGuias_falt_dv[]         rep_log_cguias_fdev;
    private static log_CGuias_perm[]            rep_log_cguias_perm;
    private static log_CGuias_Glomar_price[]    rep_log_cguias_glomar_price;
    private static log_CGuias_Glomar_invoice[]  rep_log_cguias_glomar_invoice;
    private static log_Guide_rel_inv[]          rep_log_guide_rel_inv;
    private static log_Personal[]               rep_log_personal;
    private static log_TDispflota[]             rep_log_tdispflota;
    private static log_TMotdev[]                rep_log_tmotdev;
    private static log_TPersonal[]              rep_log_tpersonal;
    private static log_TSeguros[]               rep_log_tseguros;
    private static log_Vehiculos[]              rep_log_vehiculo;

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


    /***************************************************************************/
    /**************************** static int ***********************************/
    /***************************************************************************/
    /**
     * @return the sesion
     */
    public static Sesion getSesion() {
        return sesion;
    }

    /**
     * @param aSesion the sesion to set
     */
    public static void setSesion(Sesion aSesion) {
        sesion = aSesion;
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


    /***************************************************************************/
    /**************************** static String ********************************/
    /***************************************************************************/
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
     * @return the numRel_Dev
     */
    public static String getNumRel_Dev() {
        return numRel_Dev;
    }

    /**
     * @param aNumRel_Dev the numRel_Dev to set
     */
    public static void setNumRel_Dev(String aNumRel_Dev) {
        numRel_Dev = aNumRel_Dev;
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

    /**
     * @return the numOrd_toma
     */
    public static String getNumOrd_toma() {
        return numOrd_toma;
    }

    /**
     * @param aNumOrd_toma the numOrd_toma to set
     */
    public static void setNumOrd_toma(String aNumOrd_toma) {
        numOrd_toma = aNumOrd_toma;
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


    /***************************************************************************/
    /**************************** static ComboBox *****************************/
    /***************************************************************************/
    /**
     * @return the cbBranch
     */
    public static ComboBox<Branch> getCbBranch() {
        return cbBranch;
    }

    /**
     * @param aCbBranch the cbBranch to set
     */
    public static void setCbBranch(ComboBox<Branch> aCbBranch) {
        cbBranch = aCbBranch;
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
     * @return the cbRoles
     */
    public static ComboBox<Rol> getCbRoles() {
        return cbRoles;
    }

    /**
     * @param aCbRoles the cbRoles to set
     */
    public static void setCbRoles(ComboBox<Rol> aCbRoles) {
        cbRoles = aCbRoles;
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
     * @return the cbLog_tmotdev
     */
    public static ComboBox<log_TMotdev> getCbLog_tmotdev() {
        return cbLog_tmotdev;
    }

    /**
     * @param aCbLog_tmotdev the cbLog_tmotdev to set
     */
    public static void setCbLog_tmotdev(ComboBox<log_TMotdev> aCbLog_tmotdev) {
        cbLog_tmotdev = aCbLog_tmotdev;
    }

    /**
     * @return the cbTSeguro
     */
    public static ComboBox<log_TSeguros> getCbTSeguro() {
        return cbTSeguro;
    }

    /**
     * @param aCbTSeguro the cbTSeguro to set
     */
    public static void setCbTSeguro(ComboBox<log_TSeguros> aCbTSeguro) {
        cbTSeguro = aCbTSeguro;
    }

    /**
     * @return the cbLog_tdispflota
     */
    public static ComboBox<log_TDispflota> getCbLog_tdispflota() {
        return cbLog_tdispflota;
    }

    /**
     * @param aCbLog_tdispflota the cbLog_tdispflota to set
     */
    public static void setCbLog_tdispflota(ComboBox<log_TDispflota> aCbLog_tdispflota) {
        cbLog_tdispflota = aCbLog_tdispflota;
    }


    /***************************************************************************/
    /**************************** static Objetcs *******************************/
    /***************************************************************************/
    /**
     * @return the user
     */
    public static Usuario getUser() {
        return user;
    }

    /**
     * @param aUsuario the user to set
     */
    public static void setUser(Usuario aUsuario) {
        user = aUsuario;
    }

    /**
     * @return the branch
     */
    public static Branch getBranch() {
        return branch;
    }

    /**
     * @param aBranch the branch to set
     */
    public static void setBranch(Branch aBranch) {
        branch = aBranch;
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
     * @return the invenblockprod
     */
    public static InventoryBlockProd getInvenblockprod() {
        return invenblockprod;
    }

    /**
     * @param aInventoryblockprod the invenblockprod to set
     */
    public static void setInvenblockprod(InventoryBlockProd aInventoryblockprod) {
        invenblockprod = aInventoryblockprod;
    }

    /**
     * @return the measure
     */
    public static Measure getMeasure() {
        return measure;
    }

    /**
     * @param aMeasure the measure to set
     */
    public static void setMeasure(Measure aMeasure) {
        measure = aMeasure;
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
     * @return the log_tdispflota
     */
    public static log_TDispflota getLog_tdispflota() {
        return log_tdispflota;
    }

    /**
     * @param aLog_tdispflota the log_tdispflota to set
     */
    public static void setLog_tdispflota(log_TDispflota aLog_tdispflota) {
        log_tdispflota = aLog_tdispflota;
    }

    /**
     * @return the log_tmarca
     */
    public static log_TMarca getLog_tmarca() {
        return log_tmarca;
    }

    /**
     * @param aLog_tmarca the log_tmarca to set
     */
    public static void setLog_tmarca(log_TMarca aLog_tmarca) {
        log_tmarca = aLog_tmarca;
    }

    /**
     * @return the log_tmotdev
     */
    public static log_TMotdev getLog_tmotdev() {
        return log_tmotdev;
    }

    /**
     * @param aLog_tmotdev the log_tmotdev to set
     */
    public static void setLog_tmotdev(log_TMotdev aLog_tmotdev) {
        log_tmotdev = aLog_tmotdev;
    }

    /**
     * @return the log_tpersonal
     */
    public static log_TPersonal getLog_tpersonal() {
        return log_tpersonal;
    }

    /**
     * @param aLog_tpersonal the log_tpersonal to set
     */
    public static void setLog_tpersonal(log_TPersonal aLog_tpersonal) {
        log_tpersonal = aLog_tpersonal;
    }

    /**
     * @return the log_tproced
     */
    public static log_TProced getLog_tproced() {
        return log_tproced;
    }

    /**
     * @param aLog_tproced the log_tproced to set
     */
    public static void setLog_tproced(log_TProced aLog_tproced) {
        log_tproced = aLog_tproced;
    }

    /**
     * @return the log_tseguros
     */
    public static log_TSeguros getLog_tseguros() {
        return log_tseguros;
    }

    /**
     * @param aLog_tseguros the log_tseguros to set
     */
    public static void setLog_tseguros(log_TSeguros aLog_tseguros) {
        log_tseguros = aLog_tseguros;
    }

    /**
     * @return the log_ttransp
     */
    public static log_TTransp getLog_ttransp() {
        return log_ttransp;
    }

    /**
     * @param aLog_ttransp the log_ttransp to set
     */
    public static void setLog_ttransp(log_TTransp aLog_ttransp) {
        log_ttransp = aLog_ttransp;
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
     * @return the zsi_nros_sem_avg
     */
    public static Zsi_nros_sem_avg getZsi_nros_sem_avg() {
        return zsi_nros_sem_avg;
    }

    /**
     * @param aZsi_nros_sem_avgh the zsi_nros_sem_avg to set
     */
    public static void setZsi_nros_sem_avg(Zsi_nros_sem_avg aZsi_nros_sem_avgh) {
        zsi_nros_sem_avg = aZsi_nros_sem_avgh;
    }

    /**
     * @return the zsi_nros_sem
     */
    public static Zsi_nros_sem getZsi_nros_sem() {
        return zsi_nros_sem;
    }

    /**
     * @param aZsi_nros_sem_avgv the zsi_nros_sem to set
     */
    public static void setZsi_nros_sem(Zsi_nros_sem aZsi_nros_sem_avgv) {
        zsi_nros_sem = aZsi_nros_sem_avgv;
    }

    /**
     * @return the zsi_nros_sem_day
     */
    public static Zsi_nros_sem_day getZsi_nros_sem_day() {
        return zsi_nros_sem_day;
    }

    /**
     * @param aZsi_nros_sem_day the zsi_nros_sem_day to set
     */
    public static void setZsi_nros_sem_day(Zsi_nros_sem_day aZsi_nros_sem_day) {
        zsi_nros_sem_day = aZsi_nros_sem_day;
    }

    /**
     * @return the zsi_nros_sem_r
     */
    public static Zsi_nros_sem_r getZsi_nros_sem_r() {
        return zsi_nros_sem_r;
    }

    /**
     * @param aZsi_nros_sem_rh the zsi_nros_sem_r to set
     */
    public static void setZsi_nros_sem_r(Zsi_nros_sem_r aZsi_nros_sem_rh) {
        zsi_nros_sem_r = aZsi_nros_sem_rh;
    }


    /***************************************************************************/
    /**************************** static Objetcs *******************************/
    /***************************************************************************/
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
     * @return the rep_dev_fanulaucursales
     */
    public static Dev_FanulSucursales[] getRep_dev_fanulaucursales() {
        return rep_dev_fanulaucursales;
    }

    /**
     * @param aRep_dev_fanulaucursales the rep_dev_fanulaucursales to set
     */
    public static void setRep_dev_fanulaucursales(Dev_FanulSucursales[] aRep_dev_fanulaucursales) {
        rep_dev_fanulaucursales = aRep_dev_fanulaucursales;
    }

    /**
     * @return the ind_zsi_nros_sem_avg
     */
    public static Zsi_nros_sem_avg[] getInd_zsi_nros_sem_avg() {
        return ind_zsi_nros_sem_avg;
    }

    /**
     * @param aInd_zsi_nros_sem_avg the ind_zsi_nros_sem_avg to set
     */
    public static void setInd_zsi_nros_sem_avg(Zsi_nros_sem_avg[] aInd_zsi_nros_sem_avg) {
        ind_zsi_nros_sem_avg = aInd_zsi_nros_sem_avg;
    }

    /**
     * @return the ind_zsi_nros_sem_day
     */
    public static Zsi_nros_sem_day[] getInd_zsi_nros_sem_day() {
        return ind_zsi_nros_sem_day;
    }

    /**
     * @param aInd_zsi_nros_sem_day the ind_zsi_nros_sem_day to set
     */
    public static void setInd_zsi_nros_sem_day(Zsi_nros_sem_day[] aInd_zsi_nros_sem_day) {
        ind_zsi_nros_sem_day = aInd_zsi_nros_sem_day;
    }

    /**
     * @return the ind_zsi_nros_sem_r
     */
    public static Zsi_nros_sem_r[] getInd_zsi_nros_sem_r() {
        return ind_zsi_nros_sem_r;
    }

    /**
     * @param aInd_zsi_nros_sem_rh the ind_zsi_nros_sem_r to set
     */
    public static void setInd_zsi_nros_sem_r(Zsi_nros_sem_r[] aInd_zsi_nros_sem_rh) {
        ind_zsi_nros_sem_r = aInd_zsi_nros_sem_rh;
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
     * @return the rep_invenblockprod
     */
    public static InventoryBlockProd[] getRep_invenblockprod() {
        return rep_invenblockprod;
    }

    /**
     * @param aRep_invenblockprod the rep_invenblockprod to set
     */
    public static void setRep_invenblockprod(InventoryBlockProd[] aRep_invenblockprod) {
        rep_invenblockprod = aRep_invenblockprod;
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
     * @return the rep_dev_faltcarga
     */
    public static Dev_FaltCarga[] getRep_dev_faltcarga() {
        return rep_dev_faltcarga;
    }

    /**
     * @param aRep_log_cguias_falt the rep_dev_faltcarga to set
     */
    public static void setRep_dev_faltcarga(Dev_FaltCarga[] aRep_log_cguias_falt) {
        rep_dev_faltcarga = aRep_log_cguias_falt;
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
     * @return the rep_log_personal
     */
    public static log_Personal[] getRep_log_personal() {
        return rep_log_personal;
    }

    /**
     * @param aRep_log_personal the rep_log_personal to set
     */
    public static void setRep_log_personal(log_Personal[] aRep_log_personal) {
        rep_log_personal = aRep_log_personal;
    }

    /**
     * @return the rep_log_tdispflota
     */
    public static log_TDispflota[] getRep_log_tdispflota() {
        return rep_log_tdispflota;
    }

    /**
     * @param aRep_log_tdispflota the rep_log_tdispflota to set
     */
    public static void setRep_log_tdispflota(log_TDispflota[] aRep_log_tdispflota) {
        rep_log_tdispflota = aRep_log_tdispflota;
    }

    /**
     * @return the rep_log_tmotdev
     */
    public static log_TMotdev[] getRep_log_tmotdev() {
        return rep_log_tmotdev;
    }

    /**
     * @param aRep_log_tmotdev the rep_log_tmotdev to set
     */
    public static void setRep_log_tmotdev(log_TMotdev[] aRep_log_tmotdev) {
        rep_log_tmotdev = aRep_log_tmotdev;
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
     * @return the rep_log_tseguros
     */
    public static log_TSeguros[] getRep_log_tseguros() {
        return rep_log_tseguros;
    }

    /**
     * @param aRep_log_tseguros the rep_log_tseguros to set
     */
    public static void setRep_log_tseguros(log_TSeguros[] aRep_log_tseguros) {
        rep_log_tseguros = aRep_log_tseguros;
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

}

