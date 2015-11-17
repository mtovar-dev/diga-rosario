/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects.Inventory;

import Tools.Tools;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author MITM
 */
public class InventoryBlockProd {
    private String numtoma;
    private String numorden;
    private int idSupplier;
    private String rif;
    private String nombre;
    private String idProducto;
    private String descrip;
    private Date fecha;
    private String observ;
    private int anulada;
    private String status;
    private int sql;
    private int cantProd;
    private String usr_creacion;
    
    /**
     * 
     */
    public InventoryBlockProd(){
        
    }

    /**
     * 
     * @param rs 
     */
    public InventoryBlockProd(ResultSet rs){
        try{
            numtoma         = rs.getString(1);
            numorden        = rs.getString(2);
            idSupplier      = rs.getInt(3);
            rif             = rs.getString(4);
            nombre          = rs.getString(5);
            idProducto      = rs.getString(6);
            descrip         = rs.getString(7);
            fecha           = rs.getDate(8);
            observ          = rs.getString(9);
            anulada         = rs.getInt(10);
            status          = rs.getString(11);
            sql             = rs.getInt(12);
            cantProd        = rs.getInt(13);
            usr_creacion    = rs.getString(14);

                    
        }catch(SQLException e){
            Tools.getErrorMessage(e.getStackTrace(),e.getMessage());
        }
    }

    /**
     * @return the numtoma
     */
    public String getNumtoma() {
        return numtoma;
    }

    /**
     * @param numtoma the numtoma to set
     */
    public void setNumtoma(String numtoma) {
        this.numtoma = numtoma;
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
     * @return the anulada
     */
    public int getAnulada() {
        return anulada;
    }

    /**
     * @param anulada the anulada to set
     */
    public void setAnulada(int anulada) {
        this.anulada = anulada;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return the sql
     */
    public int getSql() {
        return sql;
    }

    /**
     * @param sql the sql to set
     */
    public void setSql(int sql) {
        this.sql = sql;
    }

    /**
     * @return the cantProd
     */
    public int getCantProd() {
        return cantProd;
    }

    /**
     * @param cantProd the cantProd to set
     */
    public void setCantProd(int cantProd) {
        this.cantProd = cantProd;
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


}
