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
public class Fxp_Archguid_gfc {
    private int numguia;
    private int numfact;
    private int numclie;
    private String stat_guia;

    /**
     * 
     */
    public Fxp_Archguid_gfc(){

    }

    /**
     * 
     * @param rs 
     */
    public Fxp_Archguid_gfc(ResultSet rs){
        try{
            numguia           = rs.getInt(1);
            numfact           = rs.getInt(2);
            numclie           = rs.getInt(3);
            stat_guia         = rs.getString(4);
           
        }catch(SQLException e){
            Tools.getErrorMessage(e.getStackTrace(),e.getMessage());
        }
    }    

    /**
     * @return the numguia
     */
    public int getNumguia() {
        return numguia;
    }

    /**
     * @param numguia the numguia to set
     */
    public void setNumguia(int numguia) {
        this.numguia = numguia;
    }

    /**
     * @return the numfact
     */
    public int getNumfact() {
        return numfact;
    }

    /**
     * @param numfact the numfact to set
     */
    public void setNumfact(int numfact) {
        this.numfact = numfact;
    }

    /**
     * @return the numclie
     */
    public int getNumclie() {
        return numclie;
    }

    /**
     * @param numclie the numclie to set
     */
    public void setNumclie(int numclie) {
        this.numclie = numclie;
    }

    /**
     * @return the stat_guia
     */
    public String getStat_guia() {
        return stat_guia;
    }

    /**
     * @param stat_guia the stat_guia to set
     */
    public void setStat_guia(String stat_guia) {
        this.stat_guia = stat_guia;
    }


}
