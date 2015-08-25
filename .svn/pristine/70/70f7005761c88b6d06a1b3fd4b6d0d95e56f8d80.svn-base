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
 * @author Personal
 */
public class Fxp_Archguip_pro {
    private int     orden;
    private String  codigo;
    private String  descrip;
    private int     iCantDesp;
    private String  sCantDesp;
    private String  unidEmp;
    private Unit    unidVta;
    private Unit    unidMin;
    private int     uniporem;
    private String  tipodoc;
    private String  letdoc;
    private Date    fecdoc;
    private String  numdoc;
    private String  numguia;
    private String  numfact;
    private String  ciudad;
    private String  cliente;
    private String  sucursal;
    private String  vendedor;
    private String  ruta;
    private String  numcli;
    private String  nomcli;
    private double  subfac;
    private double  ivafac;
    private double  totfac;
    private int     anulada;
    
    /**
     * 
     */
    public Fxp_Archguip_pro(){
        
    }

    /**
     * 
     * @param rs 
     */
    public Fxp_Archguip_pro(ResultSet rs){
        try{
            orden           = rs.getInt(1);
            codigo          = rs.getString(2);
            descrip         = rs.getString(3);
            iCantDesp       = rs.getInt(4);
            sCantDesp       = rs.getString(5);
            unidEmp         = rs.getString(6);
            
            Unit objUnitVta = new Unit();
            objUnitVta.setIdUnit(rs.getInt(7));
            objUnitVta.setAbrev(rs.getString(8));
            unidVta = objUnitVta;

            Unit objUnitMin = new Unit();
            objUnitMin.setIdUnit(rs.getInt(9));
            objUnitMin.setAbrev(rs.getString(10));
            unidMin = objUnitMin;

            uniporem        = rs.getInt(11);
            tipodoc         = rs.getString(12);
            letdoc          = rs.getString(13);
            fecdoc          = rs.getDate(14);
            numdoc          = rs.getString(15);
            numguia         = rs.getString(16);
            numfact         = rs.getString(17);
            ciudad          = rs.getString(18);
            cliente         = rs.getString(19);
            sucursal        = rs.getString(20);
            vendedor        = rs.getString(21);
            ruta            = rs.getString(22);
            numcli          = rs.getString(23);
            nomcli          = rs.getString(24);
            subfac          = rs.getDouble(25);
            ivafac          = rs.getDouble(26);
            totfac          = rs.getDouble(27);
            anulada         = rs.getInt(28);

            
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
     * @return the iCantDesp
     */
    public int getiCantDesp() {
        return iCantDesp;
    }

    /**
     * @param iCantDesp the iCantDesp to set
     */
    public void setiCantDesp(int iCantDesp) {
        this.iCantDesp = iCantDesp;
    }

    /**
     * @return the sCantDesp
     */
    public String getsCantDesp() {
        return sCantDesp;
    }

    /**
     * @param sCantDesp the sCantDesp to set
     */
    public void setsCantDesp(String sCantDesp) {
        this.sCantDesp = sCantDesp;
    }

    /**
     * @return the unidEmp
     */
    public String getUnidEmp() {
        return unidEmp;
    }

    /**
     * @param unidEmp the unidEmp to set
     */
    public void setUnidEmp(String unidEmp) {
        this.unidEmp = unidEmp;
    }

    /**
     * @return the unidVta
     */
    public Unit getUnidVta() {
        return unidVta;
    }

    /**
     * @param unidVta the unidVta to set
     */
    public void setUnidVta(Unit unidVta) {
        this.unidVta = unidVta;
    }

    /**
     * @return the unidMin
     */
    public Unit getUnidMin() {
        return unidMin;
    }

    /**
     * @param unidMin the unidMin to set
     */
    public void setUnidMin(Unit unidMin) {
        this.unidMin = unidMin;
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
     * @return the tipodoc
     */
    public String getTipodoc() {
        return tipodoc;
    }

    /**
     * @param tipodoc the tipodoc to set
     */
    public void setTipodoc(String tipodoc) {
        this.tipodoc = tipodoc;
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
     * @return the numdoc
     */
    public String getNumdoc() {
        return numdoc;
    }

    /**
     * @param numdoc the numdoc to set
     */
    public void setNumdoc(String numdoc) {
        this.numdoc = numdoc;
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
     * @return the sucursal
     */
    public String getSucursal() {
        return sucursal;
    }

    /**
     * @param sucursal the sucursal to set
     */
    public void setSucursal(String sucursal) {
        this.sucursal = sucursal;
    }

    /**
     * @return the vendedor
     */
    public String getVendedor() {
        return vendedor;
    }

    /**
     * @param vendedor the vendedor to set
     */
    public void setVendedor(String vendedor) {
        this.vendedor = vendedor;
    }

    /**
     * @return the ruta
     */
    public String getRuta() {
        return ruta;
    }

    /**
     * @param ruta the ruta to set
     */
    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    /**
     * @return the numcli
     */
    public String getNumcli() {
        return numcli;
    }

    /**
     * @param numcli the numcli to set
     */
    public void setNumcli(String numcli) {
        this.numcli = numcli;
    }

    /**
     * @return the nomcli
     */
    public String getNomcli() {
        return nomcli;
    }

    /**
     * @param nomcli the nomcli to set
     */
    public void setNomcli(String nomcli) {
        this.nomcli = nomcli;
    }

    /**
     * @return the subfac
     */
    public double getSubfac() {
        return subfac;
    }

    /**
     * @param subfac the subfac to set
     */
    public void setSubfac(double subfac) {
        this.subfac = subfac;
    }

    /**
     * @return the ivafac
     */
    public double getIvafac() {
        return ivafac;
    }

    /**
     * @param ivafac the ivafac to set
     */
    public void setIvafac(double ivafac) {
        this.ivafac = ivafac;
    }

    /**
     * @return the totfac
     */
    public double getTotfac() {
        return totfac;
    }

    /**
     * @param totfac the totfac to set
     */
    public void setTotfac(double totfac) {
        this.totfac = totfac;
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

    
}
