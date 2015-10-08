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
public class log_Vehiculos {
    private String idPlaca;
    private log_TMarca tmarca;
    private log_TProced tproced;
    private log_TTransp ttransp;
    private log_TSeguros tseguro;
    private log_TDispflota tdispflota;
    private String modelo;
    private int peso_bveh;
    private int cap_cargkgrs;
    private double cap_cargmtrs3;
    private String empresa;     
    private String telefonos;
    private String celular;
    private String correo;
    private String ruta_cc;
    private String ruta_tt;
    private String ruta_rcv;
    private String ruta_ps;
    private String ruta_rgt;
    private Date fec_rcv;
    private Date fec_ps;
    private Date fec_rgt;
    private int dias_rcv;
    private int dias_ps;
    private int dias_rgt;
    private String stat_rcv;
    private String stat_ps;
    private String stat_rgt;
    private String nro_rgt;
    private int status;     
    private int ano;     
    private String rif_empresa;
    private int clasif;     
    private String tclasif;

    /**
     * 
     */
    public log_Vehiculos(){
        
    }

    /**
     * 
     * @param rs 
     */
    public log_Vehiculos(ResultSet rs){
        try{
            idPlaca             = rs.getString(1);
            
            //Datos TMarca del Vehiculo
            log_TMarca objMa = new log_TMarca();
            objMa.setIdTMarca(rs.getInt(2));
            objMa.setNombre(rs.getString(3));
            objMa.setAbrev(null);
            tmarca = objMa;

            //Datos TProced del Vehiculo
            log_TProced objTp = new log_TProced();
            objTp.setIdTProced(rs.getInt(4));
            objTp.setNombre(rs.getString(5));
            objTp.setAbrev(null);
            tproced = objTp;

            //Datos TTransp del Vehiculo
            log_TTransp objTt = new log_TTransp();
            objTt.setIdTTransp(rs.getInt(6));
            objTt.setNombre(rs.getString(7));
            objTt.setAbrev(null);
            ttransp = objTt;

            ano                 = rs.getInt(8);
            modelo              = rs.getString(9);
            peso_bveh           = rs.getInt(10);
            cap_cargkgrs        = rs.getInt(11);
            cap_cargmtrs3       = rs.getDouble(12);
            empresa             = rs.getString(13);
            rif_empresa         = rs.getString(14);
            telefonos           = rs.getString(15);
            celular             = rs.getString(16);
            correo              = rs.getString(17);

            ruta_cc             = rs.getString(18);
            ruta_tt             = rs.getString(19);

            ruta_rcv            = rs.getString(20);
            fec_rcv             = rs.getDate(21);
            dias_rcv            = rs.getInt(22);
            stat_rcv            = rs.getString(23);
            
            ruta_ps             = rs.getString(24);
            fec_ps              = rs.getDate(25);
            dias_ps             = rs.getInt(26);
            stat_ps             = rs.getString(27);

            ruta_rgt             = rs.getString(28);
            fec_rgt              = rs.getDate(29);
            dias_rgt             = rs.getInt(30);
            stat_rgt             = rs.getString(31);
            
            nro_rgt             = rs.getString(32);
            status              = rs.getInt(33);

            //Datos TSeguro del Vehiculo
            log_TSeguros objTs = new log_TSeguros();
            objTs.setIdTSeguro(rs.getInt(34));
            objTs.setNombre(rs.getString(35));
            objTs.setAbrev(rs.getString(36));
            tseguro = objTs;

            clasif              = rs.getInt(37);
            tclasif             = rs.getString(38);

            //Datos TDisponible de Flota
            log_TDispflota objTd = new log_TDispflota();
            objTd.setIdTDispflota(rs.getInt(39));
            objTd.setNombre(rs.getString(40));
            objTd.setAbrev(rs.getString(41));
            tdispflota = objTd;

        }catch(SQLException e){
            Tools.getErrorMessage(e.getStackTrace(),e.getMessage());
        }
    }

    /**
     * @return the idPlaca
     */
    public String getIdPlaca() {
        return idPlaca;
    }

    /**
     * @param idPlaca the idPlaca to set
     */
    public void setIdPlaca(String idPlaca) {
        this.idPlaca = idPlaca;
    }

    /**
     * @return the tmarca
     */
    public log_TMarca getTmarca() {
        return tmarca;
    }

    /**
     * @param tmarca the tmarca to set
     */
    public void setTmarca(log_TMarca tmarca) {
        this.tmarca = tmarca;
    }

    /**
     * @return the tproced
     */
    public log_TProced getTproced() {
        return tproced;
    }

    /**
     * @param tproced the tproced to set
     */
    public void setTproced(log_TProced tproced) {
        this.tproced = tproced;
    }

    /**
     * @return the ttransp
     */
    public log_TTransp getTtransp() {
        return ttransp;
    }

    /**
     * @param ttransp the ttransp to set
     */
    public void setTtransp(log_TTransp ttransp) {
        this.ttransp = ttransp;
    }

    /**
     * @return the tseguro
     */
    public log_TSeguros getTseguro() {
        return tseguro;
    }

    /**
     * @param tseguro the tseguro to set
     */
    public void setTseguro(log_TSeguros tseguro) {
        this.tseguro = tseguro;
    }

    /**
     * @return the tdispflota
     */
    public log_TDispflota getTdispflota() {
        return tdispflota;
    }

    /**
     * @param tdispflota the tdispflota to set
     */
    public void setTdispflota(log_TDispflota tdispflota) {
        this.tdispflota = tdispflota;
    }

    /**
     * @return the modelo
     */
    public String getModelo() {
        return modelo;
    }

    /**
     * @param modelo the modelo to set
     */
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    /**
     * @return the peso_bveh
     */
    public int getPeso_bveh() {
        return peso_bveh;
    }

    /**
     * @param peso_bveh the peso_bveh to set
     */
    public void setPeso_bveh(int peso_bveh) {
        this.peso_bveh = peso_bveh;
    }

    /**
     * @return the cap_cargkgrs
     */
    public int getCap_cargkgrs() {
        return cap_cargkgrs;
    }

    /**
     * @param cap_cargkgrs the cap_cargkgrs to set
     */
    public void setCap_cargkgrs(int cap_cargkgrs) {
        this.cap_cargkgrs = cap_cargkgrs;
    }

    /**
     * @return the cap_cargmtrs3
     */
    public double getCap_cargmtrs3() {
        return cap_cargmtrs3;
    }

    /**
     * @param cap_cargmtrs3 the cap_cargmtrs3 to set
     */
    public void setCap_cargmtrs3(double cap_cargmtrs3) {
        this.cap_cargmtrs3 = cap_cargmtrs3;
    }

    /**
     * @return the empresa
     */
    public String getEmpresa() {
        return empresa;
    }

    /**
     * @param empresa the empresa to set
     */
    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    /**
     * @return the telefonos
     */
    public String getTelefonos() {
        return telefonos;
    }

    /**
     * @param telefonos the telefonos to set
     */
    public void setTelefonos(String telefonos) {
        this.telefonos = telefonos;
    }

    /**
     * @return the celular
     */
    public String getCelular() {
        return celular;
    }

    /**
     * @param celular the celular to set
     */
    public void setCelular(String celular) {
        this.celular = celular;
    }

    /**
     * @return the correo
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * @param correo the correo to set
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * @return the ruta_cc
     */
    public String getRuta_cc() {
        return ruta_cc;
    }

    /**
     * @param ruta_cc the ruta_cc to set
     */
    public void setRuta_cc(String ruta_cc) {
        this.ruta_cc = ruta_cc;
    }

    /**
     * @return the ruta_tt
     */
    public String getRuta_tt() {
        return ruta_tt;
    }

    /**
     * @param ruta_tt the ruta_tt to set
     */
    public void setRuta_tt(String ruta_tt) {
        this.ruta_tt = ruta_tt;
    }

    /**
     * @return the ruta_rcv
     */
    public String getRuta_rcv() {
        return ruta_rcv;
    }

    /**
     * @param ruta_rcv the ruta_rcv to set
     */
    public void setRuta_rcv(String ruta_rcv) {
        this.ruta_rcv = ruta_rcv;
    }

    /**
     * @return the ruta_ps
     */
    public String getRuta_ps() {
        return ruta_ps;
    }

    /**
     * @param ruta_ps the ruta_ps to set
     */
    public void setRuta_ps(String ruta_ps) {
        this.ruta_ps = ruta_ps;
    }

    /**
     * @return the ruta_rgt
     */
    public String getRuta_rgt() {
        return ruta_rgt;
    }

    /**
     * @param ruta_rgt the ruta_rgt to set
     */
    public void setRuta_rgt(String ruta_rgt) {
        this.ruta_rgt = ruta_rgt;
    }

    /**
     * @return the fec_rcv
     */
    public Date getFec_rcv() {
        return fec_rcv;
    }

    /**
     * @param fec_rcv the fec_rcv to set
     */
    public void setFec_rcv(Date fec_rcv) {
        this.fec_rcv = fec_rcv;
    }

    /**
     * @return the fec_ps
     */
    public Date getFec_ps() {
        return fec_ps;
    }

    /**
     * @param fec_ps the fec_ps to set
     */
    public void setFec_ps(Date fec_ps) {
        this.fec_ps = fec_ps;
    }

    /**
     * @return the fec_rgt
     */
    public Date getFec_rgt() {
        return fec_rgt;
    }

    /**
     * @param fec_rgt the fec_rgt to set
     */
    public void setFec_rgt(Date fec_rgt) {
        this.fec_rgt = fec_rgt;
    }

    /**
     * @return the dias_rcv
     */
    public int getDias_rcv() {
        return dias_rcv;
    }

    /**
     * @param dias_rcv the dias_rcv to set
     */
    public void setDias_rcv(int dias_rcv) {
        this.dias_rcv = dias_rcv;
    }

    /**
     * @return the dias_ps
     */
    public int getDias_ps() {
        return dias_ps;
    }

    /**
     * @param dias_ps the dias_ps to set
     */
    public void setDias_ps(int dias_ps) {
        this.dias_ps = dias_ps;
    }

    /**
     * @return the dias_rgt
     */
    public int getDias_rgt() {
        return dias_rgt;
    }

    /**
     * @param dias_rgt the dias_rgt to set
     */
    public void setDias_rgt(int dias_rgt) {
        this.dias_rgt = dias_rgt;
    }

    /**
     * @return the stat_rcv
     */
    public String getStat_rcv() {
        return stat_rcv;
    }

    /**
     * @param stat_rcv the stat_rcv to set
     */
    public void setStat_rcv(String stat_rcv) {
        this.stat_rcv = stat_rcv;
    }

    /**
     * @return the stat_ps
     */
    public String getStat_ps() {
        return stat_ps;
    }

    /**
     * @param stat_ps the stat_ps to set
     */
    public void setStat_ps(String stat_ps) {
        this.stat_ps = stat_ps;
    }

    /**
     * @return the stat_rgt
     */
    public String getStat_rgt() {
        return stat_rgt;
    }

    /**
     * @param stat_rgt the stat_rgt to set
     */
    public void setStat_rgt(String stat_rgt) {
        this.stat_rgt = stat_rgt;
    }

    /**
     * @return the nro_rgt
     */
    public String getNro_rgt() {
        return nro_rgt;
    }

    /**
     * @param nro_rgt the nro_rgt to set
     */
    public void setNro_rgt(String nro_rgt) {
        this.nro_rgt = nro_rgt;
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
     * @return the ano
     */
    public int getAno() {
        return ano;
    }

    /**
     * @param ano the ano to set
     */
    public void setAno(int ano) {
        this.ano = ano;
    }

    /**
     * @return the rif_empresa
     */
    public String getRif_empresa() {
        return rif_empresa;
    }

    /**
     * @param rif_empresa the rif_empresa to set
     */
    public void setRif_empresa(String rif_empresa) {
        this.rif_empresa = rif_empresa;
    }

    /**
     * @return the clasif
     */
    public int getClasif() {
        return clasif;
    }

    /**
     * @param clasif the clasif to set
     */
    public void setClasif(int clasif) {
        this.clasif = clasif;
    }

    /**
     * @return the tclasif
     */
    public String getTclasif() {
        return tclasif;
    }

    /**
     * @param tclasif the tclasif to set
     */
    public void setTclasif(String tclasif) {
        this.tclasif = tclasif;
    }

}
