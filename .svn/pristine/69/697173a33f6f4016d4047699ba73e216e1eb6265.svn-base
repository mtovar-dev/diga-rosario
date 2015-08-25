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
public class Fxp_Archguid_cli {
    private String estado;
    private String codigo;
    private String cliente;
    private String descrip;     
    private String rif;
    
    /**
     * 
     */
    public Fxp_Archguid_cli(){

    }

    /**
     * 
     * @param rs 
     */
    public Fxp_Archguid_cli(ResultSet rs){
        try{
            estado           = rs.getString(1);
            codigo           = rs.getString(2);
            cliente          = rs.getString(3);
            descrip          = rs.getString(4);
            rif              = rs.getString(5);
           
        }catch(SQLException e){
            Tools.getErrorMessage(e.getStackTrace(),e.getMessage());
        }
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
     * @return the cliente
     */
    public String getCliente() {
        return cliente;
    }

    /**
     * @param cliente the cliente to set
     */
    public void setCliente(String cliente) {
        this.cliente = cliente;
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
     * @return the rif
     */
    public String getRif() {
        return rif;
    }

    /**
     * @param rif the rif to set
     */
    public void setRif(String rif) {
        this.rif = rif;
    }


    
}
