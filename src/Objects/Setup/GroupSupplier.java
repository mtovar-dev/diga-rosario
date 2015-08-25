/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects.Setup;

import Tools.Tools;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author MITM
 */
public class GroupSupplier {
    private int idGroupSupplier;
    private String nombre;
    private String abrev;     
    private int status;     

    /**
     * 
     */
    public GroupSupplier(){
        
    }

    /**
     * 
     * @param rs 
     */
    public GroupSupplier(ResultSet rs){
        try{
            idGroupSupplier  = rs.getInt(1);
            nombre           = rs.getString(2);
            abrev            = rs.getString(3);
            status           = rs.getInt(4);
            
        }catch(SQLException e){
            Tools.getErrorMessage(e.getStackTrace(),e.getMessage());
        }
    }

    /**
     * @return the idGroupSupplier
     */
    public int getIdGroupSupplier() {
        return idGroupSupplier;
    }

    /**
     * @param idGroupSupplier the idGroupSupplier to set
     */
    public void setIdGroupSupplier(int idGroupSupplier) {
        this.idGroupSupplier = idGroupSupplier;
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

