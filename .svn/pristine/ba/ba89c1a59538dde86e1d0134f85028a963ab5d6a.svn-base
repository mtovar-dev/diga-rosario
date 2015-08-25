/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Objects;

import Tools.Tools;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author MITM
 */
public class log_CGuias_falt_cg{
    private String numrela;
    private String numorden;
    private Date fecha;
    private String numguiac;
    private String numguiaf;
    private String producto;
    private String produnid;
    private String descrip;
    private int cantfact;
    private int cantfalt;
    private int cantdesp;
    private int id_unidad;
    private String unidad;
    

    /**
     * 
     */
    public log_CGuias_falt_cg(){

    }

    /**
     * 
     * @param rs 
     */
    public log_CGuias_falt_cg(ResultSet rs){
        try{
            numrela              = rs.getString(1);
            numorden             = rs.getString(2);
            fecha                = rs.getDate(3);
            numguiac             = rs.getString(4);
            numguiaf             = rs.getString(5);
            producto             = rs.getString(6);
            produnid             = rs.getString(7);
            descrip              = rs.getString(8);
            cantfact             = rs.getInt(9);
            cantfalt             = rs.getInt(10);
            cantdesp             = rs.getInt(11);
            id_unidad            = rs.getInt(12);
            unidad               = rs.getString(13);
            
        }catch(SQLException e){
            Tools.getErrorMessage(e.getStackTrace(),e.getMessage());
        }
    }    

    /**
     * @return the numrela
     */
    public String getNumrela() {
        return numrela;
    }

    /**
     * @param numrela the numrela to set
     */
    public void setNumrela(String numrela) {
        this.numrela = numrela;
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
     * @return the numguiac
     */
    public String getNumguiac() {
        return numguiac;
    }

    /**
     * @param numguiac the numguiac to set
     */
    public void setNumguiac(String numguiac) {
        this.numguiac = numguiac;
    }

    /**
     * @return the numguiaf
     */
    public String getNumguiaf() {
        return numguiaf;
    }

    /**
     * @param numguiaf the numguiaf to set
     */
    public void setNumguiaf(String numguiaf) {
        this.numguiaf = numguiaf;
    }

    /**
     * @return the producto
     */
    public String getProducto() {
        return producto;
    }

    /**
     * @param producto the producto to set
     */
    public void setProducto(String producto) {
        this.producto = producto;
    }

    /**
     * @return the produnid
     */
    public String getProdunid() {
        return produnid;
    }

    /**
     * @param produnid the produnid to set
     */
    public void setProdunid(String produnid) {
        this.produnid = produnid;
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
     * @return the cantfact
     */
    public int getCantfact() {
        return cantfact;
    }

    /**
     * @param cantfact the cantfact to set
     */
    public void setCantfact(int cantfact) {
        this.cantfact = cantfact;
    }

    /**
     * @return the cantfalt
     */
    public int getCantfalt() {
        return cantfalt;
    }

    /**
     * @param cantfalt the cantfalt to set
     */
    public void setCantfalt(int cantfalt) {
        this.cantfalt = cantfalt;
    }

    /**
     * @return the cantdesp
     */
    public int getCantdesp() {
        return cantdesp;
    }

    /**
     * @param cantdesp the cantdesp to set
     */
    public void setCantdesp(int cantdesp) {
        this.cantdesp = cantdesp;
    }

    /**
     * @return the id_unidad
     */
    public int getId_unidad() {
        return id_unidad;
    }

    /**
     * @param id_unidad the id_unidad to set
     */
    public void setId_unidad(int id_unidad) {
        this.id_unidad = id_unidad;
    }

    /**
     * @return the unidad
     */
    public String getUnidad() {
        return unidad;
    }

    /**
     * @param unidad the unidad to set
     */
    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }


}
