/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Objects;

import Objects.Setup.Unit;
import Tools.Tools;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author MITM
 */
public class Fxp_Archguip_pro_dv {
    private String orden;
    private String codigo;
    private String unidad;     
    private String descrip;     
    private int ICantDesp;
    private int ICantFalt;
    private Unit unidDespEmb;
    private String SCantDesp;     
    private String SCantFalt;     
    private double pesokgs;
    private String idChequeador;     
    private String numguia;     
    private String numfact;     
    private int idMotivo;     
    private String smotivo;     
    private int unidfalt;     
    private String observ;     
    private Date fecha;
    private Unit unidDespCont;
    private int uniporem;
    private String stat_reg;
    private Double pre_marc;
    
    /**
     * 
     */
    public Fxp_Archguip_pro_dv(){
        
    }

    /**
     * 
     * @param rs 
     */
    public Fxp_Archguip_pro_dv(ResultSet rs){
        try{
            orden           = rs.getString(1);
            codigo          = rs.getString(2);
            unidad          = rs.getString(3);
            descrip         = rs.getString(4);
            ICantDesp       = rs.getInt(5);
            ICantFalt       = rs.getInt(6);

            Unit objUnitEmp = new Unit();
            objUnitEmp.setIdUnit(rs.getInt(7));
            objUnitEmp.setAbrev(rs.getString(8));
            unidDespEmb = objUnitEmp;

            SCantDesp       = rs.getString(9);
            SCantFalt       = rs.getString(10);
            pesokgs         = rs.getDouble(11);
            numguia         = rs.getString(12);
            numfact         = rs.getString(13);

            Unit objUnitCont = new Unit();
            objUnitCont.setIdUnit(rs.getInt(14));
            objUnitCont.setAbrev(rs.getString(15));
            unidDespCont = objUnitCont;
            
            uniporem        = rs.getInt(16);
            
        }catch(SQLException e){
            Tools.getErrorMessage(e.getStackTrace(),e.getMessage());
        }
    }

    /**
     * @return the orden
     */
    public String getOrden() {
        return orden;
    }

    /**
     * @param orden the orden to set
     */
    public void setOrden(String orden) {
        this.orden = orden;
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
     * @return the unidad
     */
    public String getUnidad() {
        return unidad;
    }

    /**
     * @param unidad the unidad to set
     */
    public void setUnidad(String unidad) {
        this.unidad = unidad;
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
     * @return the ICantDesp
     */
    public int getICantDesp() {
        return ICantDesp;
    }

    /**
     * @param ICantDesp the ICantDesp to set
     */
    public void setICantDesp(int ICantDesp) {
        this.ICantDesp = ICantDesp;
    }

    /**
     * @return the ICantFalt
     */
    public int getICantFalt() {
        return ICantFalt;
    }

    /**
     * @param ICantFalt the ICantFalt to set
     */
    public void setICantFalt(int ICantFalt) {
        this.ICantFalt = ICantFalt;
    }

    /**
     * @return the unidDespEmb
     */
    public Unit getUnidDespEmb() {
        return unidDespEmb;
    }

    /**
     * @param unidDespEmb the unidDespEmb to set
     */
    public void setUnidDespEmb(Unit unidDespEmb) {
        this.unidDespEmb = unidDespEmb;
    }

    /**
     * @return the SCantDesp
     */
    public String getSCantDesp() {
        return SCantDesp;
    }

    /**
     * @param SCantDesp the SCantDesp to set
     */
    public void setSCantDesp(String SCantDesp) {
        this.SCantDesp = SCantDesp;
    }

    /**
     * @return the SCantFalt
     */
    public String getSCantFalt() {
        return SCantFalt;
    }

    /**
     * @param SCantFalt the SCantFalt to set
     */
    public void setSCantFalt(String SCantFalt) {
        this.SCantFalt = SCantFalt;
    }

    /**
     * @return the pesokgs
     */
    public double getPesokgs() {
        return pesokgs;
    }

    /**
     * @param pesokgs the pesokgs to set
     */
    public void setPesokgs(double pesokgs) {
        this.pesokgs = pesokgs;
    }

    /**
     * @return the idChequeador
     */
    public String getIdChequeador() {
        return idChequeador;
    }

    /**
     * @param idChequeador the idChequeador to set
     */
    public void setIdChequeador(String idChequeador) {
        this.idChequeador = idChequeador;
    }

    /**
     * @return the numguia
     */
    public String getNumguia() {
        return numguia;
    }

    /**
     * @param numguia the numguia to set
     */
    public void setNumguia(String numguia) {
        this.numguia = numguia;
    }

    /**
     * @return the numfact
     */
    public String getNumfact() {
        return numfact;
    }

    /**
     * @param numfact the numfact to set
     */
    public void setNumfact(String numfact) {
        this.numfact = numfact;
    }

    /**
     * @return the idMotivo
     */
    public int getIdMotivo() {
        return idMotivo;
    }

    /**
     * @param idMotivo the idMotivo to set
     */
    public void setIdMotivo(int idMotivo) {
        this.idMotivo = idMotivo;
    }

    /**
     * @return the smotivo
     */
    public String getSmotivo() {
        return smotivo;
    }

    /**
     * @param smotivo the smotivo to set
     */
    public void setSmotivo(String smotivo) {
        this.smotivo = smotivo;
    }

    /**
     * @return the unidfalt
     */
    public int getUnidfalt() {
        return unidfalt;
    }

    /**
     * @param unidfalt the unidfalt to set
     */
    public void setUnidfalt(int unidfalt) {
        this.unidfalt = unidfalt;
    }

    /**
     * @return the observ
     */
    public String getObserv() {
        return observ;
    }

    /**
     * @param observ the observ to set
     */
    public void setObserv(String observ) {
        this.observ = observ;
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
     * @return the unidDespCont
     */
    public Unit getUnidDespCont() {
        return unidDespCont;
    }

    /**
     * @param unidDespCont the unidDespCont to set
     */
    public void setUnidDespCont(Unit unidDespCont) {
        this.unidDespCont = unidDespCont;
    }

    /**
     * @return the uniporem
     */
    public int getUniporem() {
        return uniporem;
    }

    /**
     * @param uniporem the uniporem to set
     */
    public void setUniporem(int uniporem) {
        this.uniporem = uniporem;
    }

    /**
     * @return the stat_reg
     */
    public String getStat_reg() {
        return stat_reg;
    }

    /**
     * @param stat_reg the stat_reg to set
     */
    public void setStat_reg(String stat_reg) {
        this.stat_reg = stat_reg;
    }

    /**
     * @return the pre_marc
     */
    public Double getPre_marc() {
        return pre_marc;
    }

    /**
     * @param pre_marc the pre_marc to set
     */
    public void setPre_marc(Double pre_marc) {
        this.pre_marc = pre_marc;
    }



}
