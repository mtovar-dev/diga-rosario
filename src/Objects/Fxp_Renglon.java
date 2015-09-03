/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects;

import Tools.Tools;
import java.sql.ResultSet;

/**
 *
 * @author MITM
 */
public class Fxp_Renglon {
    private int orden;
    private String codigo;
    private int cantdesp;
    private int maracay;
    private int turmero;
    private int id_unidad;     
    private String unidad;     
    private int id_almacen;

    /**
     * 
     */
    public Fxp_Renglon(){
        
    }

    /**
     * 
     * @param rs 
     */
    public Fxp_Renglon(ResultSet rs){
        try{
            orden           = rs.getInt(1);
            codigo          = rs.getString(2);
            cantdesp        = rs.getInt(3);
            id_unidad       = rs.getInt(6);
            unidad          = rs.getString(7);
            id_almacen      = rs.getInt(8);

        }catch(Exception e){
            Tools.getErrorMessage(e.getStackTrace(),e.getMessage());
        }
    }

    /**
     * @return the orden
     */
    public int getOrden() {
        return orden;
    }

    /**
     * @param orden the orden to set
     */
    public void setOrden(int orden) {
        this.orden = orden;
    }

    /**
     * @return the codigo
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
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
     * @return the maracay
     */
    public int getMaracay() {
        return maracay;
    }

    /**
     * @param maracay the maracay to set
     */
    public void setMaracay(int maracay) {
        this.maracay = maracay;
    }

    /**
     * @return the turmero
     */
    public int getTurmero() {
        return turmero;
    }

    /**
     * @param turmero the turmero to set
     */
    public void setTurmero(int turmero) {
        this.turmero = turmero;
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

    /**
     * @return the id_almacen
     */
    public int getId_almacen() {
        return id_almacen;
    }

    /**
     * @param id_almacen the id_almacen to set
     */
    public void setId_almacen(int id_almacen) {
        this.id_almacen = id_almacen;
    }

    
}
