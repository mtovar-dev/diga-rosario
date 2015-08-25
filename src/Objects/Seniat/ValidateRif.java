/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects.Seniat;

/**
 *
 * @author MITM
 */
public class ValidateRif {
    private String rif;    
    private String nombre;
    private String iva_agen;
    private String iva_cont;
    private int tasa;
    private int status;

    /**
     * 
     */
    public ValidateRif(){
        
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
     * @return the iva_agen
     */
    public String getIva_agen() {
        return iva_agen;
    }

    /**
     * @param iva_agen the iva_agen to set
     */
    public void setIva_agen(String iva_agen) {
        this.iva_agen = iva_agen;
    }

    /**
     * @return the iva_cont
     */
    public String getIva_cont() {
        return iva_cont;
    }

    /**
     * @param iva_cont the iva_cont to set
     */
    public void setIva_cont(String iva_cont) {
        this.iva_cont = iva_cont;
    }

    /**
     * @return the tasa
     */
    public int getTasa() {
        return tasa;
    }

    /**
     * @param tasa the tasa to set
     */
    public void setTasa(int tasa) {
        this.tasa = tasa;
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
