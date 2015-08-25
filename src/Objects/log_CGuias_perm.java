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
public class log_CGuias_perm {
    private String numrela;
    private String numorden;
    private Date fecha;
    private String guias;    
    private int tpermiso;
    

    /**
     * 
     */
    public log_CGuias_perm(){

    }

    /**
     * 
     * @param rs 
     */
    public log_CGuias_perm(ResultSet rs){
        try{
            numrela              = rs.getString(1);
            numorden             = rs.getString(2);
            fecha                = rs.getDate(3);
            guias                = rs.getString(4);
            tpermiso             = rs.getInt(5);
            
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
     * @return the guias
     */
    public String getGuias() {
        return guias;
    }

    /**
     * @param guias the guias to set
     */
    public void setGuias(String guias) {
        this.guias = guias;
    }

    /**
     * @return the tpermiso
     */
    public int getTpermiso() {
        return tpermiso;
    }

    /**
     * @param tpermiso the tpermiso to set
     */
    public void setTpermiso(int tpermiso) {
        this.tpermiso = tpermiso;
    }

    
}
