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
public class log_TProced {
    private int idTProced;
    private String nombre;
    private String abrev;     
    private int status;
    /**
     * 
     */
    public log_TProced(){
        
    }    

    /**
     * 
     * @param rs 
     */
    public log_TProced(ResultSet rs){
        try{
            idTProced       = rs.getInt(1);
            nombre          = rs.getString(2);
            abrev           = rs.getString(3);
            status          = rs.getInt(4);
            
        }catch(SQLException e){
            Tools.getErrorMessage(e.getStackTrace(),e.getMessage());
        }
    }

    /**
     * @return the idTProced
     */
    public int getIdTProced() {
        return idTProced;
    }

    /**
     * @param idTProced the idTProced to set
     */
    public void setIdTProced(int idTProced) {
        this.idTProced = idTProced;
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
    
    /**
     * 
     * @return 
     */
    @Override
    public String toString(){
        return this.nombre;
    }
    
}
