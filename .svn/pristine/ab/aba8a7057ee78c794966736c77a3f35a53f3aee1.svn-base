/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects.System;

import Tools.Tools;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author ARMGARCES
 */
public class Rol {
    private int idRol;
    private String nombre;
    private String abrev;
    private int status;

    /**
     * 
     */
    public Rol(){
        
    }
    
    /**
     * 
     * @param rs 
     */
    public Rol(ResultSet rs){
        try{
            idRol           = rs.getInt(1);
            nombre          = rs.getString(2);
            abrev           = rs.getString(3);
            status          = rs.getInt(4);
            
        }catch(SQLException e){
            Tools.getErrorMessage(e.getStackTrace(),e.getMessage());
        }
    }
    
    /**
     * @return the idRol
     */
    public int getIdRol() {
        return idRol;
    }

    /**
     * @param idRol the idRol to set
     */
    public void setIdRol(int idRol) {
        this.idRol = idRol;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the abrev
     */
    public String getAbrev() {
        return abrev;
    }

    /**
     * @param abrev the abrev to set
     */
    public void setAbrev(String abrev) {
        this.abrev = abrev;
    }
    
    /**
     * 
     * @return 
     */
    @Override
    public String toString(){
        return this.nombre;
    }

    /**
     * @return the status
     */
    public int getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(int status) {
        this.status = status;
    }
}
