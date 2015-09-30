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
public class Municipality {
    private int idPoblacion;
    private String nombre;
    private String abrev;     
    private String idTipo;        
    private int idPoblacionp;
    /**
     * 
     */
    public Municipality(){
        
    }

    /**
     * 
     * @param rs 
     */
    public Municipality(ResultSet rs){
        try{
            idPoblacion     = rs.getInt(1);
            nombre          = rs.getString(2);
            abrev           = rs.getString(3);
            idTipo          = rs.getString(4);
            idPoblacionp    = rs.getInt(5);
            
        }catch(SQLException e){
            Tools.getErrorMessage(e.getStackTrace(),e.getMessage());
        }
    }

    /**
     * @return the idPoblacion
     */
    public int getIdPoblacion() {
        return idPoblacion;
    }

    /**
     * @param idPoblacion the idPoblacion to set
     */
    public void setIdPoblacion(int idPoblacion) {
        this.idPoblacion = idPoblacion;
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
     * @return the idTipo
     */
    public String getIdTipo() {
        return idTipo;
    }

    /**
     * @param idTipo the idTipo to set
     */
    public void setIdTipo(String idTipo) {
        this.idTipo = idTipo;
    }

    /**
     * @return the idPoblacionp
     */
    public int getIdPoblacionp() {
        return idPoblacionp;
    }

    /**
     * @param idPoblacionp the idPoblacionp to set
     */
    public void setIdPoblacionp(int idPoblacionp) {
        this.idPoblacionp = idPoblacionp;
    }

    /**
     * @return 
     */
    @Override
    public String toString(){
        return this.nombre;
    }
    
}
