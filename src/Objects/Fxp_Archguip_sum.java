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
 * @author Personal
 */
public class Fxp_Archguip_sum {
    private int orden;
    private String uniddesp;
    private int cantdesp;
    
    /**
     * 
     */
    public Fxp_Archguip_sum(){
        
    }

    /**
     * 
     * @param rs 
     */
    public Fxp_Archguip_sum(ResultSet rs){
        try{
            orden           = rs.getInt(1);
            uniddesp        = rs.getString(2);
            cantdesp        = rs.getInt(3);
            
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

}
