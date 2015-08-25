/*
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Objects;

import Tools.Tools;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author MITM  
 */
public class Fxp_Archguip_det {
    private int orden;
    private String codigo;
    private String unidad;     
    private String descrip;     
    private int cantdesp;
    private String uniddesp;
    private String cantidad;     
    private double pesokgs;
    private String estado;
    
    /**
     * 
     */
    public Fxp_Archguip_det(){
        
    }

    /**
     * 
     * @param rs 
     */
    public Fxp_Archguip_det(ResultSet rs){
        try{
            orden           = rs.getInt(1);
            codigo          = rs.getString(2);
            unidad          = rs.getString(3);
            descrip         = rs.getString(4);
            cantdesp        = rs.getInt(5);
            uniddesp        = rs.getString(6);
            cantidad        = rs.getString(7);
            pesokgs         = rs.getDouble(8);
            estado          = rs.getString(9);
            
        }catch(SQLException e){
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
     * @return the uniddesp
     */
    public String getUniddesp() {
        return uniddesp;
    }

    /**
     * @param uniddesp the uniddesp to set
     */
    public void setUniddesp(String uniddesp) {
        this.uniddesp = uniddesp;
    }

    /**
     * @return the cantidad
     */
    public String getCantidad() {
        return cantidad;
    }

    /**
     * @param cantidad the cantidad to set
     */
    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * @return the pesokgs
     */
    public double getPesokgs() {
        return pesokgs;
    }

    /**
     * @param pesokgs the pesokgs to set
     */
    public void setPesokgs(double pesokgs) {
        this.pesokgs = pesokgs;
    }

    /**
     * @return the estado
     */
    public String getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    
}
