/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects.Infocent;

/**
 *
 * @author armgarces
 */
public class Reporte {
    private int    id;
    private String nombre;

    /**
     * 
     * @param _id
     * @param _value 
     */
    public Reporte(int _id, String _value){
        id     = _id;
        nombre = _value;
    }
    
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
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
     * 
     * @return 
     */
    @Override
    public String toString(){
        return nombre;
    }
}
