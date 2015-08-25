/*
 * To change this license header, choose License Headers in Project Properties.
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
public class log_CGuias_falt_dv {
    private String numrela;    
    private String numorden;
    private Date fec_carga;      
    private String numdev;
    private String numdoc;    
    private String producto;
    private String produnid;
    private String descrip;
    private int cantfact;
    private int cantdev;       
    private int cantdesp;      
    private int id_unidad;      
    private String unidad;
    private int id_motivo;      
    private String motivo;
    private String observ;
    private String cheq_pta;    
    private String scheq_pta;
    private String chofer;
    private String schofer;
    private String veh1;
    private String nombre_emp;
    private String ciudad;    
    private String sucursal;
    private String vendedor;
    private String numcli;
    private String nomcli;
    private Date fecdoc;
    private Double subfac;
    private Double ivafac;
    private int clasif_motivo;      
    private String rif_emp;
    private Date fec_dev;      
    private String stat_reg;
    private Date fec_mov;      
    private int hor_mov;      
    private Double pre_fact;
    private Double pre_marc;
    
    
    /**
     * 
     */
    public log_CGuias_falt_dv(){

    }

    /**
     * 
     * @param rs 
     */
    public log_CGuias_falt_dv(ResultSet rs){
        try{
            numrela              = rs.getString(1);
            numorden             = rs.getString(2);
            fec_carga            = rs.getDate(3);
            numdev               = rs.getString(4);
            numdoc               = rs.getString(5);
            producto             = rs.getString(6);
            produnid             = rs.getString(7);
            descrip              = rs.getString(8);
            cantfact             = rs.getInt(9);
            cantdev              = rs.getInt(10);
            cantdesp             = rs.getInt(11);
            id_unidad            = rs.getInt(12);
            unidad               = rs.getString(13);
            id_motivo            = rs.getInt(14);
            motivo               = rs.getString(15);
            observ               = rs.getString(16);
            cheq_pta             = rs.getString(17);
            scheq_pta            = rs.getString(18);
            chofer               = rs.getString(19);
            schofer              = rs.getString(20);
            veh1                 = rs.getString(21);
            nombre_emp           = rs.getString(22);
            ciudad               = rs.getString(23);
            sucursal             = rs.getString(24);
            vendedor             = rs.getString(25);
            numcli               = rs.getString(26);
            nomcli               = rs.getString(27);
            fecdoc               = rs.getDate(28);
            subfac               = rs.getDouble(29);
            ivafac               = rs.getDouble(30);
            clasif_motivo        = rs.getInt(31);
            rif_emp              = rs.getString(32);
            fec_dev              = rs.getDate(33);
            stat_reg             = rs.getString(34);
            fec_mov              = rs.getDate(35);
            hor_mov              = rs.getInt(36);
            pre_fact             = rs.getDouble(37);
            pre_marc             = rs.getDouble(38);
            
        }catch(SQLException e){
            Tools.getErrorMessage(e.getStackTrace(),e.getMessage());
        }
    }    

    /**
     * @return the numrela
     */
    public String getNumrela() {
        return numrela;
    }

    /**
     * @param numrela the numrela to set
     */
    public void setNumrela(String numrela) {
        this.numrela = numrela;
    }

    /**
     * @return the numorden
     */
    public String getNumorden() {
        return numorden;
    }

    /**
     * @param numorden the numorden to set
     */
    public void setNumorden(String numorden) {
        this.numorden = numorden;
    }

    /**
     * @return the fec_carga
     */
    public Date getFec_carga() {
        return fec_carga;
    }

    /**
     * @param fec_carga the fec_carga to set
     */
    public void setFec_carga(Date fec_carga) {
        this.fec_carga = fec_carga;
    }

    /**
     * @return the numdev
     */
    public String getNumdev() {
        return numdev;
    }

    /**
     * @param numdev the numdev to set
     */
    public void setNumdev(String numdev) {
        this.numdev = numdev;
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
     * @return the producto
     */
    public String getProducto() {
        return producto;
    }

    /**
     * @param producto the producto to set
     */
    public void setProducto(String producto) {
        this.producto = producto;
    }

    /**
     * @return the produnid
     */
    public String getProdunid() {
        return produnid;
    }

    /**
     * @param produnid the produnid to set
     */
    public void setProdunid(String produnid) {
        this.produnid = produnid;
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
     * @return the cantfact
     */
    public int getCantfact() {
        return cantfact;
    }

    /**
     * @param cantfact the cantfact to set
     */
    public void setCantfact(int cantfact) {
        this.cantfact = cantfact;
    }

    /**
     * @return the cantdev
     */
    public int getCantdev() {
        return cantdev;
    }

    /**
     * @param cantdev the cantdev to set
     */
    public void setCantdev(int cantdev) {
        this.cantdev = cantdev;
    }

    /**
     * @return the cantdesp
     */
    public int getCantdesp() {
        return cantdesp;
    }

    /**
     * @param cantdesp the cantdesp to set
     */
    public void setCantdesp(int cantdesp) {
        this.cantdesp = cantdesp;
    }

    /**
     * @return the id_unidad
     */
    public int getId_unidad() {
        return id_unidad;
    }

    /**
     * @param id_unidad the id_unidad to set
     */
    public void setId_unidad(int id_unidad) {
        this.id_unidad = id_unidad;
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
     * @return the id_motivo
     */
    public int getId_motivo() {
        return id_motivo;
    }

    /**
     * @param id_motivo the id_motivo to set
     */
    public void setId_motivo(int id_motivo) {
        this.id_motivo = id_motivo;
    }

    /**
     * @return the motivo
     */
    public String getMotivo() {
        return motivo;
    }

    /**
     * @param motivo the motivo to set
     */
    public void setMotivo(String motivo) {
        this.motivo = motivo;
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
     * @return the cheq_pta
     */
    public String getCheq_pta() {
        return cheq_pta;
    }

    /**
     * @param cheq_pta the cheq_pta to set
     */
    public void setCheq_pta(String cheq_pta) {
        this.cheq_pta = cheq_pta;
    }

    /**
     * @return the scheq_pta
     */
    public String getScheq_pta() {
        return scheq_pta;
    }

    /**
     * @param scheq_pta the scheq_pta to set
     */
    public void setScheq_pta(String scheq_pta) {
        this.scheq_pta = scheq_pta;
    }

    /**
     * @return the chofer
     */
    public String getChofer() {
        return chofer;
    }

    /**
     * @param chofer the chofer to set
     */
    public void setChofer(String chofer) {
        this.chofer = chofer;
    }

    /**
     * @return the schofer
     */
    public String getSchofer() {
        return schofer;
    }

    /**
     * @param schofer the schofer to set
     */
    public void setSchofer(String schofer) {
        this.schofer = schofer;
    }

    /**
     * @return the veh1
     */
    public String getVeh1() {
        return veh1;
    }

    /**
     * @param veh1 the veh1 to set
     */
    public void setVeh1(String veh1) {
        this.veh1 = veh1;
    }

    /**
     * @return the nombre_emp
     */
    public String getNombre_emp() {
        return nombre_emp;
    }

    /**
     * @param nombre_emp the nombre_emp to set
     */
    public void setNombre_emp(String nombre_emp) {
        this.nombre_emp = nombre_emp;
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
     * @return the subfac
     */
    public Double getSubfac() {
        return subfac;
    }

    /**
     * @param subfac the subfac to set
     */
    public void setSubfac(Double subfac) {
        this.subfac = subfac;
    }

    /**
     * @return the ivafac
     */
    public Double getIvafac() {
        return ivafac;
    }

    /**
     * @param ivafac the ivafac to set
     */
    public void setIvafac(Double ivafac) {
        this.ivafac = ivafac;
    }

    /**
     * @return the clasif_motivo
     */
    public int getClasif_motivo() {
        return clasif_motivo;
    }

    /**
     * @param clasif_motivo the clasif_motivo to set
     */
    public void setClasif_motivo(int clasif_motivo) {
        this.clasif_motivo = clasif_motivo;
    }

    /**
     * @return the rif_emp
     */
    public String getRif_emp() {
        return rif_emp;
    }

    /**
     * @param rif_emp the rif_emp to set
     */
    public void setRif_emp(String rif_emp) {
        this.rif_emp = rif_emp;
    }

    /**
     * @return the fec_dev
     */
    public Date getFec_dev() {
        return fec_dev;
    }

    /**
     * @param fec_dev the fec_dev to set
     */
    public void setFec_dev(Date fec_dev) {
        this.fec_dev = fec_dev;
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
     * @return the fec_mov
     */
    public Date getFec_mov() {
        return fec_mov;
    }

    /**
     * @param fec_mov the fec_mov to set
     */
    public void setFec_mov(Date fec_mov) {
        this.fec_mov = fec_mov;
    }

    /**
     * @return the hor_mov
     */
    public int getHor_mov() {
        return hor_mov;
    }

    /**
     * @param hor_mov the hor_mov to set
     */
    public void setHor_mov(int hor_mov) {
        this.hor_mov = hor_mov;
    }

    /**
     * @return the pre_fact
     */
    public Double getPre_fact() {
        return pre_fact;
    }

    /**
     * @param pre_fact the pre_fact to set
     */
    public void setPre_fact(Double pre_fact) {
        this.pre_fact = pre_fact;
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
