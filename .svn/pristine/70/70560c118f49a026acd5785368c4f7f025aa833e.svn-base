/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Objects;

import Objects.Setup.Unit;
import Tools.Tools;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author MITM
 */
public class Fxp_Archguip_pro_cg {
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
    private String numguia;     
    private String numfalt;     
    private int unidfalt;     
    private Unit unidDespCont;
    private int uniporem;
    
    /**
     * 
     */
    public Fxp_Archguip_pro_cg(){
        
    }

    /**
     * 
     * @param rs 
     */
    public Fxp_Archguip_pro_cg(ResultSet rs){
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

            Unit objUnitCont = new Unit();
            objUnitCont.setIdUnit(rs.getInt(13));
            objUnitCont.setAbrev(rs.getString(14));
            unidDespCont = objUnitCont;

            uniporem        = rs.getInt(15);
            
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
     * @return the numfalt
     */
    public String getNumfalt() {
        return numfalt;
    }

    /**
     * @param numfalt the numfalt to set
     */
    public void setNumfalt(String numfalt) {
        this.numfalt = numfalt;
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


    
}
