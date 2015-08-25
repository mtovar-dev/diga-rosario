/*
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
public class Fxp_Archguid {
    private int orden;
    private int numguia;
    private String ciudad;
    private String codigo;
    private String cliente;
    private String tipdoc;
    private String letdoc;     
    private int numdoci;
    private String numdocs;     
    private Date fecdoc;
    private Double monto;
    private int anulada;
    private String unidDespEmb;
    private String SCantFact;     
    
    
    /**
     * 
     */
    public Fxp_Archguid(){

    }

    /**
     * 
     * @param rs 
     */
    public Fxp_Archguid(ResultSet rs){
        try{
            orden           = rs.getInt(1);
            numguia         = rs.getInt(2);
            ciudad          = rs.getString(3);
            codigo          = rs.getString(4);
            cliente         = rs.getString(5);
            tipdoc          = rs.getString(6);
            letdoc          = rs.getString(7);
            numdoci         = rs.getInt(8);
            numdocs         = rs.getString(9);
            fecdoc          = rs.getDate(10);
            monto           = rs.getDouble(11);
            anulada         = rs.getInt(12);
            unidDespEmb     = rs.getString(13);
            SCantFact       = rs.getString(14);
            
        }catch(SQLException e){
            Tools.getErrorMessage(e.getStackTrace(),e.getMessage());
        }
    }

    /**
     * @return the orden
     */
    public int getOrden() {
        return orden;
    }

    /**
     * @param orden the orden to set
     */
    public void setOrden(int orden) {
        this.orden = orden;
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
     * @return the ciudad
     */
    public String getCiudad() {
        return ciudad;
    }

    /**
     * @param ciudad the ciudad to set
     */
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
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
     * @return the tipdoc
     */
    public String getTipdoc() {
        return tipdoc;
    }

    /**
     * @param tipdoc the tipdoc to set
     */
    public void setTipdoc(String tipdoc) {
        this.tipdoc = tipdoc;
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

    /**
     * @return the numdoci
     */
    public int getNumdoci() {
        return numdoci;
    }

    /**
     * @param numdoci the numdoci to set
     */
    public void setNumdoci(int numdoci) {
        this.numdoci = numdoci;
    }

    /**
     * @return the numdocs
     */
    public String getNumdocs() {
        return numdocs;
    }

    /**
     * @param numdocs the numdocs to set
     */
    public void setNumdocs(String numdocs) {
        this.numdocs = numdocs;
    }

    /**
     * @return the fecdoc
     */
    public Date getFecdoc() {
        return fecdoc;
    }

    /**
     * @param fecdoc the fecdoc to set
     */
    public void setFecdoc(Date fecdoc) {
        this.fecdoc = fecdoc;
    }

    /**
     * @return the monto
     */
    public Double getMonto() {
        return monto;
    }

    /**
     * @param monto the monto to set
     */
    public void setMonto(Double monto) {
        this.monto = monto;
    }

    /**
     * @return the anulada
     */
    public int getAnulada() {
        return anulada;
    }

    /**
     * @param anulada the anulada to set
     */
    public void setAnulada(int anulada) {
        this.anulada = anulada;
    }

    /**
     * @return the unidDespEmb
     */
    public String getUnidDespEmb() {
        return unidDespEmb;
    }

    /**
     * @param unidDespEmb the unidDespEmb to set
     */
    public void setUnidDespEmb(String unidDespEmb) {
        this.unidDespEmb = unidDespEmb;
    }

    /**
     * @return the SCantFact
     */
    public String getSCantFact() {
        return SCantFact;
    }

    /**
     * @param SCantFact the SCantFact to set
     */
    public void setSCantFact(String SCantFact) {
        this.SCantFact = SCantFact;
    }


}
