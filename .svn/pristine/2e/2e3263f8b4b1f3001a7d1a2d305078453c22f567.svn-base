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
public class log_CGuias_falt {
    private String guiafalt;    
    private String numorden;
    private String fecha;
    private String chofer;    
    private String numrela;
    

    /**
     * 
     */
    public log_CGuias_falt(){

    }

    /**
     * 
     * @param rs 
     */
    public log_CGuias_falt(ResultSet rs){
        try{
            guiafalt             = rs.getString(1);
            numorden             = rs.getString(2);
            fecha                = rs.getString(3);
            chofer               = rs.getString(4);
            numrela              = rs.getString(5);
            
        }catch(SQLException e){
            Tools.getErrorMessage(e.getStackTrace(),e.getMessage());
        }
    }    

    /**
     * @return the guiafalt
     */
    public String getGuiafalt() {
        return guiafalt;
    }

    /**
     * @param guiafalt the guiafalt to set
     */
    public void setGuiafalt(String guiafalt) {
        this.guiafalt = guiafalt;
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

}
