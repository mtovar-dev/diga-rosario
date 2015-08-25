/*
 * To change this license header, choose License Headers in Project Properties.
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
public class log_CGuias_Glomar_price {
    private String codigo;
    private String zonGlomar;    
    private String zonVenta;    
    private double vehPeq;
    private double vehGra;
    private double vehGan;


    /**
     * 
     */
    public log_CGuias_Glomar_price(){

    }

    /**
     * 
     * @param rs 
     */
    public log_CGuias_Glomar_price(ResultSet rs){
        try{
            codigo              = rs.getString(1);
            zonGlomar           = rs.getString(2);
            vehPeq              = rs.getDouble(3);
            vehGra              = rs.getDouble(4);
            vehGan              = rs.getDouble(5);
            
        }catch(SQLException e){
            Tools.getErrorMessage(e.getStackTrace(),e.getMessage());
        }
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
     * @return the zonGlomar
     */
    public String getZonGlomar() {
        return zonGlomar;
    }

    /**
     * @param zonGlomar the zonGlomar to set
     */
    public void setZonGlomar(String zonGlomar) {
        this.zonGlomar = zonGlomar;
    }

    /**
     * @return the zonVenta
     */
    public String getZonVenta() {
        return zonVenta;
    }

    /**
     * @param zonVenta the zonVenta to set
     */
    public void setZonVenta(String zonVenta) {
        this.zonVenta = zonVenta;
    }

    /**
     * @return the vehPeq
     */
    public double getVehPeq() {
        return vehPeq;
    }

    /**
     * @param vehPeq the vehPeq to set
     */
    public void setVehPeq(double vehPeq) {
        this.vehPeq = vehPeq;
    }

    /**
     * @return the vehGra
     */
    public double getVehGra() {
        return vehGra;
    }

    /**
     * @param vehGra the vehGra to set
     */
    public void setVehGra(double vehGra) {
        this.vehGra = vehGra;
    }

    /**
     * @return the vehGan
     */
    public double getVehGan() {
        return vehGan;
    }

    /**
     * @param vehGan the vehGan to set
     */
    public void setVehGan(double vehGan) {
        this.vehGan = vehGan;
    }

}
