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
 * @author mtovar
 */
public class Fxp_Archguid_cp {
    private int numfact_vta;
    private int numfact_vis;
    private int cliente;
    private String letdoc;
    
    /**
     * 
     */
    public Fxp_Archguid_cp(){

    }

    /**
     * 
     * @param rs 
     */
    public Fxp_Archguid_cp(ResultSet rs){
        try{
            numfact_vta           = rs.getInt(1);
            numfact_vis           = rs.getInt(2);
            cliente               = rs.getInt(3);
            letdoc                = rs.getString(4);
           
        }catch(SQLException e){
            Tools.getErrorMessage(e.getStackTrace(),e.getMessage());
        }
    }    

    /**
     * @return the numfact_vta
     */
    public int getNumfact_vta() {
        return numfact_vta;
    }

    /**
     * @param numfact_vta the numfact_vta to set
     */
    public void setNumfact_vta(int numfact_vta) {
        this.numfact_vta = numfact_vta;
    }

    /**
     * @return the numfact_vis
     */
    public int getNumfact_vis() {
        return numfact_vis;
    }

    /**
     * @param numfact_vis the numfact_vis to set
     */
    public void setNumfact_vis(int numfact_vis) {
        this.numfact_vis = numfact_vis;
    }

    /**
     * @return the cliente
     */
    public int getCliente() {
        return cliente;
    }

    /**
     * @param cliente the cliente to set
     */
    public void setCliente(int cliente) {
        this.cliente = cliente;
    }

    /**
     * @return the letdoc
     */
    public String getLetdoc() {
        return letdoc;
    }

    /**
     * @param letdoc the letdoc to set
     */
    public void setLetdoc(String letdoc) {
        this.letdoc = letdoc;
    }

}
