/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects.Reports;

import Tools.Tools;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author MITM
 */
public class Dev_FanulSucursales {
    private String numorden;
    private String idsucursal;
    private String nombsucursal;
    private int cantfact;
    private double mtofact;
    

    /**
     * 
     */
    public Dev_FanulSucursales(){

    }

    /**
     * 
     * @param rs 
     */
    public Dev_FanulSucursales(ResultSet rs){
        try{
            numorden            = rs.getString(1);
            idsucursal          = rs.getString(2);
            nombsucursal        = rs.getString(3);
            cantfact            = rs.getInt(4);
            mtofact             = rs.getDouble(5);
            
        }catch(SQLException e){
            Tools.getErrorMessage(e.getStackTrace(),e.getMessage());
        }
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
     * @return the idsucursal
     */
    public String getIdsucursal() {
        return idsucursal;
    }

    /**
     * @param idsucursal the idsucursal to set
     */
    public void setIdsucursal(String idsucursal) {
        this.idsucursal = idsucursal;
    }

    /**
     * @return the nombsucursal
     */
    public String getNombsucursal() {
        return nombsucursal;
    }

    /**
     * @param nombsucursal the nombsucursal to set
     */
    public void setNombsucursal(String nombsucursal) {
        this.nombsucursal = nombsucursal;
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
     * @return the mtofact
     */
    public double getMtofact() {
        return mtofact;
    }

    /**
     * @param mtofact the mtofact to set
     */
    public void setMtofact(double mtofact) {
        this.mtofact = mtofact;
    }

}
