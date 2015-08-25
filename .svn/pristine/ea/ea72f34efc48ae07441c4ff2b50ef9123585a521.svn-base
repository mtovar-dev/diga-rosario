/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects.Orders;

import Tools.Tools;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author MITM
 */
public class Orders {
    private int idOrden;
    private Date fecha;
    private int idSupplier;
    private String rif;
    private String nombre;
    private String firma;
    private String direccion;
    private String ciudad;
    private String telefonos;
    private String fdespacho;
    private String ldespacho;
    private String nota;
    private String usr_creacion;
    private String usr_ncreacion;
    private String usr_supervisa;
    private String usr_nsupervisa;
    private int statenc;
    private String numorden;
    private String idProducto;
    private String descrip;
    private int cant_sol;
    private int id_unidsol;
    private String unidsol;
    private int cant_ent;
    private int id_unident;
    private String unident;
    private int cant_dif;
    private int id_uniddif;
    private String uniddif;
    private double costo;
    private double preciosug;
    private String observ;
    private String statdet;
    private String correo;
    private String statord;

    /**
     * 
     */
    public Orders(){
        
    }

    /**
     * 
     * @param rs 
     */
    public Orders(ResultSet rs){
        try{
            idOrden         = rs.getInt(1);
            fecha           = rs.getDate(2);
            idSupplier      = rs.getInt(3);
            rif             = rs.getString(4);
            nombre          = rs.getString(5);
            firma           = rs.getString(6);
            direccion       = rs.getString(7);
            ciudad          = rs.getString(8);
            telefonos       = rs.getString(9);
            fdespacho       = rs.getString(10);
            ldespacho       = rs.getString(11);
            nota            = rs.getString(12);
            usr_creacion    = rs.getString(13);
            usr_ncreacion   = rs.getString(14);
            usr_supervisa   = rs.getString(15);
            usr_nsupervisa  = rs.getString(16);
            statenc         = rs.getInt(17);
            numorden        = rs.getString(18);
            idProducto      = rs.getString(19);
            descrip         = rs.getString(20);
            cant_sol        = rs.getInt(21);
            id_unidsol      = rs.getInt(22);
            unidsol         = rs.getString(23);
            cant_ent        = rs.getInt(24);
            id_unident      = rs.getInt(25);
            unident         = rs.getString(26);
            cant_dif        = rs.getInt(27);
            id_uniddif      = rs.getInt(28);
            uniddif         = rs.getString(29);
            costo           = rs.getDouble(30);
            preciosug       = rs.getDouble(31);
            observ          = rs.getString(32);
            statdet         = rs.getString(33);
            correo          = rs.getString(34);
            statord         = rs.getString(35);
            
                    
        }catch(SQLException e){
            Tools.getErrorMessage(e.getStackTrace(),e.getMessage());
        }
    }

    /**
     * @return the idOrden
     */
    public int getIdOrden() {
        return idOrden;
    }

    /**
     * @param idOrden the idOrden to set
     */
    public void setIdOrden(int idOrden) {
        this.idOrden = idOrden;
    }

    /**
     * @return the fecha
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
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
     * @return the ciudad
     */
    public String getCiudad() {
        return ciudad;
    }

    /**
     * @param ciudad the ciudad to set
     */
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
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
     * @return the fdespacho
     */
    public String getFdespacho() {
        return fdespacho;
    }

    /**
     * @param fdespacho the fdespacho to set
     */
    public void setFdespacho(String fdespacho) {
        this.fdespacho = fdespacho;
    }

    /**
     * @return the ldespacho
     */
    public String getLdespacho() {
        return ldespacho;
    }

    /**
     * @param ldespacho the ldespacho to set
     */
    public void setLdespacho(String ldespacho) {
        this.ldespacho = ldespacho;
    }

    /**
     * @return the nota
     */
    public String getNota() {
        return nota;
    }

    /**
     * @param nota the nota to set
     */
    public void setNota(String nota) {
        this.nota = nota;
    }

    /**
     * @return the usr_creacion
     */
    public String getUsr_creacion() {
        return usr_creacion;
    }

    /**
     * @param usr_creacion the usr_creacion to set
     */
    public void setUsr_creacion(String usr_creacion) {
        this.usr_creacion = usr_creacion;
    }

    /**
     * @return the usr_ncreacion
     */
    public String getUsr_ncreacion() {
        return usr_ncreacion;
    }

    /**
     * @param usr_ncreacion the usr_ncreacion to set
     */
    public void setUsr_ncreacion(String usr_ncreacion) {
        this.usr_ncreacion = usr_ncreacion;
    }

    /**
     * @return the usr_supervisa
     */
    public String getUsr_supervisa() {
        return usr_supervisa;
    }

    /**
     * @param usr_supervisa the usr_supervisa to set
     */
    public void setUsr_supervisa(String usr_supervisa) {
        this.usr_supervisa = usr_supervisa;
    }

    /**
     * @return the usr_nsupervisa
     */
    public String getUsr_nsupervisa() {
        return usr_nsupervisa;
    }

    /**
     * @param usr_nsupervisa the usr_nsupervisa to set
     */
    public void setUsr_nsupervisa(String usr_nsupervisa) {
        this.usr_nsupervisa = usr_nsupervisa;
    }

    /**
     * @return the statenc
     */
    public int getStatenc() {
        return statenc;
    }

    /**
     * @param statenc the statenc to set
     */
    public void setStatenc(int statenc) {
        this.statenc = statenc;
    }

    /**
     * @return the numorden
     */
    public String getNumorden() {
        return numorden;
    }

    /**
     * @param numorden the numorden to set
     */
    public void setNumorden(String numorden) {
        this.numorden = numorden;
    }

    /**
     * @return the idProducto
     */
    public String getIdProducto() {
        return idProducto;
    }

    /**
     * @param idProducto the idProducto to set
     */
    public void setIdProducto(String idProducto) {
        this.idProducto = idProducto;
    }

    /**
     * @return the descrip
     */
    public String getDescrip() {
        return descrip;
    }

    /**
     * @param descrip the descrip to set
     */
    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }

    /**
     * @return the cant_sol
     */
    public int getCant_sol() {
        return cant_sol;
    }

    /**
     * @param cant_sol the cant_sol to set
     */
    public void setCant_sol(int cant_sol) {
        this.cant_sol = cant_sol;
    }

    /**
     * @return the id_unidsol
     */
    public int getId_unidsol() {
        return id_unidsol;
    }

    /**
     * @param id_unidsol the id_unidsol to set
     */
    public void setId_unidsol(int id_unidsol) {
        this.id_unidsol = id_unidsol;
    }

    /**
     * @return the unidsol
     */
    public String getUnidsol() {
        return unidsol;
    }

    /**
     * @param unidsol the unidsol to set
     */
    public void setUnidsol(String unidsol) {
        this.unidsol = unidsol;
    }

    /**
     * @return the cant_ent
     */
    public int getCant_ent() {
        return cant_ent;
    }

    /**
     * @param cant_ent the cant_ent to set
     */
    public void setCant_ent(int cant_ent) {
        this.cant_ent = cant_ent;
    }

    /**
     * @return the id_unident
     */
    public int getId_unident() {
        return id_unident;
    }

    /**
     * @param id_unident the id_unident to set
     */
    public void setId_unident(int id_unident) {
        this.id_unident = id_unident;
    }

    /**
     * @return the unident
     */
    public String getUnident() {
        return unident;
    }

    /**
     * @param unident the unident to set
     */
    public void setUnident(String unident) {
        this.unident = unident;
    }

    /**
     * @return the cant_dif
     */
    public int getCant_dif() {
        return cant_dif;
    }

    /**
     * @param cant_dif the cant_dif to set
     */
    public void setCant_dif(int cant_dif) {
        this.cant_dif = cant_dif;
    }

    /**
     * @return the id_uniddif
     */
    public int getId_uniddif() {
        return id_uniddif;
    }

    /**
     * @param id_uniddif the id_uniddif to set
     */
    public void setId_uniddif(int id_uniddif) {
        this.id_uniddif = id_uniddif;
    }

    /**
     * @return the uniddif
     */
    public String getUniddif() {
        return uniddif;
    }

    /**
     * @param uniddif the uniddif to set
     */
    public void setUniddif(String uniddif) {
        this.uniddif = uniddif;
    }

    /**
     * @return the costo
     */
    public double getCosto() {
        return costo;
    }

    /**
     * @param costo the costo to set
     */
    public void setCosto(double costo) {
        this.costo = costo;
    }

    /**
     * @return the preciosug
     */
    public double getPreciosug() {
        return preciosug;
    }

    /**
     * @param preciosug the preciosug to set
     */
    public void setPreciosug(double preciosug) {
        this.preciosug = preciosug;
    }

    /**
     * @return the observ
     */
    public String getObserv() {
        return observ;
    }

    /**
     * @param observ the observ to set
     */
    public void setObserv(String observ) {
        this.observ = observ;
    }

    /**
     * @return the statdet
     */
    public String getStatdet() {
        return statdet;
    }

    /**
     * @param statdet the statdet to set
     */
    public void setStatdet(String statdet) {
        this.statdet = statdet;
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
     * @return the statord
     */
    public String getStatord() {
        return statord;
    }

    /**
     * @param statord the statord to set
     */
    public void setStatord(String statord) {
        this.statord = statord;
    }

}
