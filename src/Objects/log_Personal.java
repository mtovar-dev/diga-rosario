/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Objects;

import Objects.Setup.State;
import Objects.Setup.Municipality;
import Objects.Setup.City;
import Objects.Setup.Sex;
import Objects.Setup.Parish;
import Tools.Tools;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author MITM
 */
public class log_Personal {
    private String idPersonal;
    private String nro_ci;
    private Sex sex;
    private String nombres;
    private String apellidos;     
    private City city;
    private Parish parish;
    private Municipality municipality;
    private State state;
    private int country;
    private log_TPersonal tpersonal;
    private String direccion;
    private String telefonos;
    private String celular;
    private String correo;
    private String ruta_ci;
    private String ruta_lc;
    private String ruta_cm;
    private String ruta_cs;
    private String ruta_ma;
    private Date fec_lc;
    private Date fec_cm;
    private Date fec_cs;
    private Date fec_ma;
    private int dias_lc;
    private int dias_cm;
    private int dias_cs;
    private int dias_ma;
    private String stat_lc;
    private String stat_cm;
    private String stat_cs;
    private String stat_ma;
    private int status;     
    /**
     * 
     */
    public log_Personal(){
        
    }

    /**
     * 
     * @param rs 
     */
    public log_Personal(ResultSet rs){
        try{
            idPersonal          = rs.getString(1);
            nro_ci              = rs.getString(2);
            
            //Datos GroupSupplier del Personal
            Sex objSx = new Sex();
            objSx.setIdSexo(rs.getInt(3));
            objSx.setNombre(rs.getString(4));
            objSx.setAbrev(null);
            sex = objSx;

            //Datos TPersonal del Personal
            log_TPersonal objTp = new log_TPersonal();
            objTp.setIdTPersonal(rs.getInt(5));
            objTp.setNombre(rs.getString(6));
            objTp.setAbrev(null);
            tpersonal = objTp;

            nombres             = rs.getString(7);
            apellidos           = rs.getString(8);

            //Datos City del Personal
            City objCi = new City();
            objCi.setIdPoblacion(rs.getInt(9));
            objCi.setNombre(rs.getString(10));
            objCi.setAbrev(null);
            objCi.setIdTipo(null);
            objCi.setIdPoblacionp(0);
            city = objCi;
            
            //Datos Parish del Personal
            Parish objPa = new Parish();
            objPa.setIdPoblacion(rs.getInt(11));
            objPa.setNombre(rs.getString(12));
            objPa.setAbrev(null);
            objPa.setIdTipo(null);
            objPa.setIdPoblacionp(0);
            parish = objPa;

            //Datos Municipality del Personal
            Municipality objMu = new Municipality();
            objMu.setIdPoblacion(rs.getInt(13));
            objMu.setNombre(rs.getString(14));
            objMu.setAbrev(null);
            objMu.setIdTipo(null);
            objMu.setIdPoblacionp(0);
            municipality = objMu;

            //Datos State del Personal
            State objSt = new State();
            objSt.setIdPoblacion(rs.getInt(15));
            objSt.setNombre(rs.getString(16));
            objSt.setAbrev(null);
            objSt.setIdTipo(null);
            objSt.setIdPoblacionp(0);
            state = objSt;

            direccion       = rs.getString(19);
            telefonos       = rs.getString(20);
            celular         = rs.getString(21);
            correo          = rs.getString(22);

            ruta_ci         = rs.getString(23);
            
            ruta_lc         = rs.getString(24);
            fec_lc          = rs.getDate(25);
            dias_lc         = rs.getInt(26);
            stat_lc         = rs.getString(27);
            
            ruta_cm         = rs.getString(28);
            fec_cm          = rs.getDate(29);
            dias_cm         = rs.getInt(30);
            stat_cm         = rs.getString(31);
            
            ruta_cs         = rs.getString(32);
            fec_cs          = rs.getDate(33);
            dias_cs         = rs.getInt(34);
            stat_cs         = rs.getString(35);

            ruta_ma         = rs.getString(36);
            fec_ma          = rs.getDate(37);
            dias_ma         = rs.getInt(38);
            stat_ma         = rs.getString(39);

            status          = rs.getInt(40);
                    
        }catch(SQLException e){
            Tools.getErrorMessage(e.getStackTrace(),e.getMessage());
        }
    }

    /**
     * @return the idPersonal
     */
    public String getIdPersonal() {
        return idPersonal;
    }

    /**
     * @param idPersonal the idPersonal to set
     */
    public void setIdPersonal(String idPersonal) {
        this.idPersonal = idPersonal;
    }

    /**
     * @return the nro_ci
     */
    public String getNro_ci() {
        return nro_ci;
    }

    /**
     * @param nro_ci the nro_ci to set
     */
    public void setNro_ci(String nro_ci) {
        this.nro_ci = nro_ci;
    }

    /**
     * @return the sex
     */
    public Sex getSex() {
        return sex;
    }

    /**
     * @param _sex the sex to set
     */
    public void setSex(Sex _sex) {
        this.sex = _sex;
    }

    /**
     * @return the nombres
     */
    public String getNombres() {
        return nombres;
    }

    /**
     * @param nombres the nombres to set
     */
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    /**
     * @return the apellidos
     */
    public String getApellidos() {
        return apellidos;
    }

    /**
     * @param apellidos the apellidos to set
     */
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    /**
     * @return the city
     */
    public City getCity() {
        return city;
    }

    /**
     * @param _city the city to set
     */
    public void setCity(City _city) {
        this.city = _city;
    }

    /**
     * @return the parish
     */
    public Parish getParish() {
        return parish;
    }

    /**
     * @param _parish the parish to set
     */
    public void setParish(Parish _parish) {
        this.parish = _parish;
    }

    /**
     * @return the municipality
     */
    public Municipality getMunicipality() {
        return municipality;
    }

    /**
     * @param _municipality the municipality to set
     */
    public void setMunicipality(Municipality _municipality) {
        this.municipality = _municipality;
    }

    /**
     * @return the state
     */
    public State getState() {
        return state;
    }

    /**
     * @param _state the state to set
     */
    public void setState(State _state) {
        this.state = _state;
    }

    /**
     * @return the country
     */
    public int getCountry() {
        return country;
    }

    /**
     * @param country the country to set
     */
    public void setCountry(int country) {
        this.country = country;
    }

    /**
     * @return the tpersonal
     */
    public log_TPersonal getTpersonal() {
        return tpersonal;
    }

    /**
     * @param _tpersonal the tpersonal to set
     */
    public void setTpersonal(log_TPersonal _tpersonal) {
        this.tpersonal = _tpersonal;
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
     * @return the correo
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * @param correo the correo to set
     */
    public void setCorreo(String correo) {
        this.correo = correo;
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

    /**
     * @return the ruta_ci
     */
    public String getRuta_ci() {
        return ruta_ci;
    }

    /**
     * @param ruta_ci the ruta_ci to set
     */
    public void setRuta_ci(String ruta_ci) {
        this.ruta_ci = ruta_ci;
    }

    /**
     * @return the ruta_lc
     */
    public String getRuta_lc() {
        return ruta_lc;
    }

    /**
     * @param ruta_lc the ruta_lc to set
     */
    public void setRuta_lc(String ruta_lc) {
        this.ruta_lc = ruta_lc;
    }

    /**
     * @return the ruta_cm
     */
    public String getRuta_cm() {
        return ruta_cm;
    }

    /**
     * @param ruta_cm the ruta_cm to set
     */
    public void setRuta_cm(String ruta_cm) {
        this.ruta_cm = ruta_cm;
    }

    /**
     * @return the ruta_cs
     */
    public String getRuta_cs() {
        return ruta_cs;
    }

    /**
     * @param ruta_cs the ruta_cs to set
     */
    public void setRuta_cs(String ruta_cs) {
        this.ruta_cs = ruta_cs;
    }

    /**
     * @return the ruta_ma
     */
    public String getRuta_ma() {
        return ruta_ma;
    }

    /**
     * @param ruta_ma the ruta_ma to set
     */
    public void setRuta_ma(String ruta_ma) {
        this.ruta_ma = ruta_ma;
    }

    /**
     * @return the fec_lc
     */
    public Date getFec_lc() {
        return fec_lc;
    }

    /**
     * @param fec_lc the fec_lc to set
     */
    public void setFec_lc(Date fec_lc) {
        this.fec_lc = fec_lc;
    }

    /**
     * @return the fec_cm
     */
    public Date getFec_cm() {
        return fec_cm;
    }

    /**
     * @param fec_cm the fec_cm to set
     */
    public void setFec_cm(Date fec_cm) {
        this.fec_cm = fec_cm;
    }

    /**
     * @return the fec_cs
     */
    public Date getFec_cs() {
        return fec_cs;
    }

    /**
     * @param fec_cs the fec_cs to set
     */
    public void setFec_cs(Date fec_cs) {
        this.fec_cs = fec_cs;
    }

    /**
     * @return the fec_ma
     */
    public Date getFec_ma() {
        return fec_ma;
    }

    /**
     * @param fec_ma the fec_ma to set
     */
    public void setFec_ma(Date fec_ma) {
        this.fec_ma = fec_ma;
    }

    /**
     * @return the dias_lc
     */
    public int getDias_lc() {
        return dias_lc;
    }

    /**
     * @param dias_lc the dias_lc to set
     */
    public void setDias_lc(int dias_lc) {
        this.dias_lc = dias_lc;
    }

    /**
     * @return the dias_cm
     */
    public int getDias_cm() {
        return dias_cm;
    }

    /**
     * @param dias_cm the dias_cm to set
     */
    public void setDias_cm(int dias_cm) {
        this.dias_cm = dias_cm;
    }

    /**
     * @return the dias_cs
     */
    public int getDias_cs() {
        return dias_cs;
    }

    /**
     * @param dias_cs the dias_cs to set
     */
    public void setDias_cs(int dias_cs) {
        this.dias_cs = dias_cs;
    }

    /**
     * @return the dias_ma
     */
    public int getDias_ma() {
        return dias_ma;
    }

    /**
     * @param dias_ma the dias_ma to set
     */
    public void setDias_ma(int dias_ma) {
        this.dias_ma = dias_ma;
    }

    /**
     * @return the stat_lc
     */
    public String getStat_lc() {
        return stat_lc;
    }

    /**
     * @param stat_lc the stat_lc to set
     */
    public void setStat_lc(String stat_lc) {
        this.stat_lc = stat_lc;
    }

    /**
     * @return the stat_cm
     */
    public String getStat_cm() {
        return stat_cm;
    }

    /**
     * @param stat_cm the stat_cm to set
     */
    public void setStat_cm(String stat_cm) {
        this.stat_cm = stat_cm;
    }

    /**
     * @return the stat_cs
     */
    public String getStat_cs() {
        return stat_cs;
    }

    /**
     * @param stat_cs the stat_cs to set
     */
    public void setStat_cs(String stat_cs) {
        this.stat_cs = stat_cs;
    }

    /**
     * @return the stat_ma
     */
    public String getStat_ma() {
        return stat_ma;
    }

    /**
     * @param stat_ma the stat_ma to set
     */
    public void setStat_ma(String stat_ma) {
        this.stat_ma = stat_ma;
    }

    /**
     * 
     * @return 
     */
    @Override
    public String toString(){
        return this.nombres;
    }
 
}
