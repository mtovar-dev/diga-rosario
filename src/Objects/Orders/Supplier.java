/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects.Orders;

import Objects.Setup.Country;
import Objects.Setup.State;
import Objects.Setup.Municipality;
import Objects.Setup.City;
import Objects.Setup.GroupSupplier;
import Objects.Setup.Parish;
import Tools.Tools;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author MITM
 */
public class Supplier {
    private int idSupplier;
    private String rif;
    private int rif_val;
    private int sen_areten;
    private int sen_civa;
    private int sen_preten;
    private GroupSupplier groupsupplier;
    private String nombre;
    private String firma;
    private City city;
    private Parish parish;
    private Municipality municipality;
    private State state;
    private Country country;
    private String direccion;
    private String telefonos;
    private String fax;
    private String correo1;
    private String correo2;
    private String contacto;
    private String celular;
    private int status;

    /**
     * 
     */
    public Supplier(){
        
    }

    /**
     * 
     * @param rs 
     */
    public Supplier(ResultSet rs){
        try{
            //Datos del Proveedor
            idSupplier      = rs.getInt(1);
            rif             = rs.getString(2);
            rif_val         = rs.getInt(3);
            sen_areten      = rs.getInt(4);
            sen_civa        = rs.getInt(5);
            sen_preten      = rs.getInt(6);
            
            //Datos GroupSupplier del Cliente
            GroupSupplier objGs = new GroupSupplier();
            objGs.setIdGroupSupplier(rs.getInt(7));
            objGs.setNombre(rs.getString(8));
            groupsupplier = objGs;

            nombre          = rs.getString(9);
            firma           = rs.getString(10);

            //Datos City del Cliente
            City objCi = new City();
            objCi.setIdPoblacion(rs.getInt(11));
            objCi.setNombre(rs.getString(12));
            city = objCi;

            //Datos Parish del Cliente
            Parish objPa = new Parish();
            objPa.setIdPoblacion(rs.getInt(13));
            objPa.setNombre(rs.getString(14));
            parish = objPa;

            //Datos Municipality del Cliente
            Municipality objMu = new Municipality();
            objMu.setIdPoblacion(rs.getInt(15));
            objMu.setNombre(rs.getString(16));
            municipality = objMu;

            //Datos State del Cliente
            State objSt = new State();
            objSt.setIdPoblacion(rs.getInt(17));
            objSt.setNombre(rs.getString(18));
            state = objSt;

            //Datos Country del Cliente
            Country objCo = new Country();
            objCo.setIdPoblacion(rs.getInt(19));
            objCo.setNombre(rs.getString(20));
            objCo.setAbrev(rs.getString(21));
            country = objCo;

            direccion       = rs.getString(22);
            telefonos       = rs.getString(23);
            fax             = rs.getString(24);
            celular         = rs.getString(25);
            contacto        = rs.getString(26);
            correo1         = rs.getString(27);
            correo2         = rs.getString(28);
            status          = rs.getInt(29);
                    
        }catch(SQLException e){
            Tools.getErrorMessage(e.getStackTrace(),e.getMessage());
        }
    }

    /**
     * @return the idSupplier
     */
    public int getIdSupplier() {
        return idSupplier;
    }

    /**
     * @param idSupplier the idSupplier to set
     */
    public void setIdSupplier(int idSupplier) {
        this.idSupplier = idSupplier;
    }

    /**
     * @return the rif
     */
    public String getRif() {
        return rif;
    }

    /**
     * @param rif the rif to set
     */
    public void setRif(String rif) {
        this.rif = rif;
    }

    /**
     * @return the rif_val
     */
    public int getRif_val() {
        return rif_val;
    }

    /**
     * @param rif_val the rif_val to set
     */
    public void setRif_val(int rif_val) {
        this.rif_val = rif_val;
    }

    /**
     * @return the sen_areten
     */
    public int getSen_areten() {
        return sen_areten;
    }

    /**
     * @param sen_areten the sen_areten to set
     */
    public void setSen_areten(int sen_areten) {
        this.sen_areten = sen_areten;
    }

    /**
     * @return the sen_civa
     */
    public int getSen_civa() {
        return sen_civa;
    }

    /**
     * @param sen_civa the sen_civa to set
     */
    public void setSen_civa(int sen_civa) {
        this.sen_civa = sen_civa;
    }

    /**
     * @return the sen_preten
     */
    public int getSen_preten() {
        return sen_preten;
    }

    /**
     * @param sen_preten the sen_preten to set
     */
    public void setSen_preten(int sen_preten) {
        this.sen_preten = sen_preten;
    }

    /**
     * @return the groupsupplier
     */
    public GroupSupplier getGroupsupplier() {
        return groupsupplier;
    }

    /**
     * @param groupsupplier the groupsupplier to set
     */
    public void setGroupsupplier(GroupSupplier groupsupplier) {
        this.groupsupplier = groupsupplier;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the firma
     */
    public String getFirma() {
        return firma;
    }

    /**
     * @param firma the firma to set
     */
    public void setFirma(String firma) {
        this.firma = firma;
    }

    /**
     * @return the city
     */
    public City getCity() {
        return city;
    }

    /**
     * @param city the city to set
     */
    public void setCity(City city) {
        this.city = city;
    }

    /**
     * @return the parish
     */
    public Parish getParish() {
        return parish;
    }

    /**
     * @param parish the parish to set
     */
    public void setParish(Parish parish) {
        this.parish = parish;
    }

    /**
     * @return the municipality
     */
    public Municipality getMunicipality() {
        return municipality;
    }

    /**
     * @param municipality the municipality to set
     */
    public void setMunicipality(Municipality municipality) {
        this.municipality = municipality;
    }

    /**
     * @return the state
     */
    public State getState() {
        return state;
    }

    /**
     * @param state the state to set
     */
    public void setState(State state) {
        this.state = state;
    }

    /**
     * @return the country
     */
    public Country getCountry() {
        return country;
    }

    /**
     * @param country the country to set
     */
    public void setCountry(Country country) {
        this.country = country;
    }

    /**
     * @return the direccion
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * @param direccion the direccion to set
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * @return the telefonos
     */
    public String getTelefonos() {
        return telefonos;
    }

    /**
     * @param telefonos the telefonos to set
     */
    public void setTelefonos(String telefonos) {
        this.telefonos = telefonos;
    }

    /**
     * @return the fax
     */
    public String getFax() {
        return fax;
    }

    /**
     * @param fax the fax to set
     */
    public void setFax(String fax) {
        this.fax = fax;
    }

    /**
     * @return the correo1
     */
    public String getCorreo1() {
        return correo1;
    }

    /**
     * @param correo1 the correo1 to set
     */
    public void setCorreo1(String correo1) {
        this.correo1 = correo1;
    }

    /**
     * @return the correo2
     */
    public String getCorreo2() {
        return correo2;
    }

    /**
     * @param correo2 the correo2 to set
     */
    public void setCorreo2(String correo2) {
        this.correo2 = correo2;
    }

    /**
     * @return the contacto
     */
    public String getContacto() {
        return contacto;
    }

    /**
     * @param contacto the contacto to set
     */
    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    /**
     * @return the celular
     */
    public String getCelular() {
        return celular;
    }

    /**
     * @param celular the celular to set
     */
    public void setCelular(String celular) {
        this.celular = celular;
    }

    /**
     * @return the status
     */
    public int getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(int status) {
        this.status = status;
    }

}
