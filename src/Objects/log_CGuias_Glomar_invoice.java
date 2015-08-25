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
public class log_CGuias_Glomar_invoice {
    private String chofer;    
    private String fecha;    
    private String guia;    
    private String destino;    
    private String nroPlaca;    
    private double mtoGuia;
    private double mtoFlete;


    /**
     * 
     */
    public log_CGuias_Glomar_invoice(){

    }

    /**
     * 
     * @param rs 
     */
    public log_CGuias_Glomar_invoice(ResultSet rs){
        try{
            chofer              = rs.getString(1);
            fecha               = rs.getString(2);
            guia                = rs.getString(3);
            destino             = rs.getString(4);
            nroPlaca            = rs.getString(5);
            mtoGuia             = rs.getDouble(6);
            mtoFlete            = rs.getDouble(7);
            
        }catch(SQLException e){
            Tools.getErrorMessage(e.getStackTrace(),e.getMessage());
        }
    }    

    /**
     * @return the chofer
     */
    public String getChofer() {
        return chofer;
    }

    /**
     * @param chofer the chofer to set
     */
    public void setChofer(String chofer) {
        this.chofer = chofer;
    }

    /**
     * @return the fecha
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    /**
     * @return the guia
     */
    public String getGuia() {
        return guia;
    }

    /**
     * @param guia the guia to set
     */
    public void setGuia(String guia) {
        this.guia = guia;
    }

    /**
     * @return the destino
     */
    public String getDestino() {
        return destino;
    }

    /**
     * @param destino the destino to set
     */
    public void setDestino(String destino) {
        this.destino = destino;
    }

    /**
     * @return the nroPlaca
     */
    public String getNroPlaca() {
        return nroPlaca;
    }

    /**
     * @param nroPlaca the nroPlaca to set
     */
    public void setNroPlaca(String nroPlaca) {
        this.nroPlaca = nroPlaca;
    }

    /**
     * @return the mtoGuia
     */
    public double getMtoGuia() {
        return mtoGuia;
    }

    /**
     * @param mtoGuia the mtoGuia to set
     */
    public void setMtoGuia(double mtoGuia) {
        this.mtoGuia = mtoGuia;
    }

    /**
     * @return the mtoFlete
     */
    public double getMtoFlete() {
        return mtoFlete;
    }

    /**
     * @param mtoFlete the mtoFlete to set
     */
    public void setMtoFlete(double mtoFlete) {
        this.mtoFlete = mtoFlete;
    }

}
