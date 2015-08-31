/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Objects;

import LN.xy;
import Tools.Tools;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author MITM
 */
public class log_CGuias extends xy {
    private String numrela;
    private String numorden;
    private String numguia;
    private Date fecha;
    private int numpuerta;     
    private String chofer;
    private String veh1;
    private String veh2;
    private String ayud1;
    private String ayud2;
    private String cheq_pta;
    private int tcheq_pta;
    private String idsupruta;     
    private int numfact;
    private int numclie;
    private String stat_guia;
    private String schofer;
    private String sayud1;
    private String scheq_pta;
    private String ssup_ruta;
    private int anulada;
    private String faltc;
    private String guiac;
    private String prodc;
    private String descrip;
    private String numcaja;
    private Date feccaja;
    private Date fecsalida;
    private String cheq_r1;
    private String scheq_r1;
    private String cheq_r2;
    private String scheq_r2;
    private String cheq_r3;
    private String scheq_r3;
    private String cheq_r4;
    private String scheq_r4;
    private String cheq_r5;
    private String scheq_r5;
    private String cheq_r6;
    private String scheq_r6;
    private String cheq_r7;
    private String scheq_r7;
    private String cheq_pq;
    private String scheq_pq;
    
    /**
     * 
     */
    public log_CGuias(){
        super();
    }

    /**
     * 
     * @param rs 
     */
    public log_CGuias(ResultSet rs){
        try{
            numrela             = rs.getString(1);
            numorden            = rs.getString(2);
            numguia             = rs.getString(3);
            fecha               = rs.getDate(4);
            numpuerta           = rs.getInt(5);
            numfact             = rs.getInt(6);
            numclie             = rs.getInt(7);
            stat_guia           = rs.getString(8);
            chofer              = rs.getString(9);
            veh1                = rs.getString(10);
            veh2                = rs.getString(11);
            ayud1               = rs.getString(12);
            ayud2               = rs.getString(13);
            cheq_pta            = rs.getString(14);
            idsupruta           = rs.getString(15);
            schofer             = rs.getString(16);
            sayud1              = rs.getString(17);
            scheq_pta           = rs.getString(18);
            ssup_ruta           = rs.getString(19);
            anulada             = rs.getInt(20);
            numcaja             = rs.getString(21);
            feccaja             = rs.getDate(22);
            fecsalida           = rs.getDate(23);
            cheq_r1             = rs.getString(24);
            scheq_r1            = rs.getString(25);
            cheq_r2             = rs.getString(26);
            scheq_r2            = rs.getString(27);
            cheq_r3             = rs.getString(28);
            scheq_r3            = rs.getString(29);
            cheq_r4             = rs.getString(30);
            scheq_r4            = rs.getString(31);
            cheq_r5             = rs.getString(32);
            scheq_r5            = rs.getString(33);
            cheq_r6             = rs.getString(34);
            scheq_r6            = rs.getString(35);
            cheq_r7             = rs.getString(36);
            scheq_r7            = rs.getString(37);
            cheq_pq             = rs.getString(38);
            scheq_pq            = rs.getString(39);
            
            super.setNumorden(numorden);
            super.setGuias(numguia);
            super.setNumfact(numfact);
            super.setNumclie(numclie);
            super.setStat_guia(stat_guia);
            super.setAnulada(anulada);
            
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
     * @return the numpuerta
     */
    public int getNumpuerta() {
        return numpuerta;
    }

    /**
     * @param numpuerta the numpuerta to set
     */
    public void setNumpuerta(int numpuerta) {
        this.numpuerta = numpuerta;
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
     * @return the veh2
     */
    public String getVeh2() {
        return veh2;
    }

    /**
     * @param veh2 the veh2 to set
     */
    public void setVeh2(String veh2) {
        this.veh2 = veh2;
    }

    /**
     * @return the ayud1
     */
    public String getAyud1() {
        return ayud1;
    }

    /**
     * @param ayud1 the ayud1 to set
     */
    public void setAyud1(String ayud1) {
        this.ayud1 = ayud1;
    }

    /**
     * @return the ayud2
     */
    public String getAyud2() {
        return ayud2;
    }

    /**
     * @param ayud2 the ayud2 to set
     */
    public void setAyud2(String ayud2) {
        this.ayud2 = ayud2;
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
     * @return the tcheq_pta
     */
    public int getTcheq_pta() {
        return tcheq_pta;
    }

    /**
     * @param tcheq_pta the tcheq_pta to set
     */
    public void setTcheq_pta(int tcheq_pta) {
        this.tcheq_pta = tcheq_pta;
    }

    /**
     * @return the idsupruta
     */
    public String getIdsupruta() {
        return idsupruta;
    }

    /**
     * @param idsupruta the idsupruta to set
     */
    public void setIdsupruta(String idsupruta) {
        this.idsupruta = idsupruta;
    }

    /**
     * @return the numfact
     */
    public int getNumfact() {
        return numfact;
    }

    /**
     * @param numfact the numfact to set
     */
    public void setNumfact(int numfact) {
        this.numfact = numfact;
    }

    /**
     * @return the numclie
     */
    public int getNumclie() {
        return numclie;
    }

    /**
     * @param numclie the numclie to set
     */
    public void setNumclie(int numclie) {
        this.numclie = numclie;
    }

    /**
     * @return the stat_guia
     */
    public String getStat_guia() {
        return stat_guia;
    }

    /**
     * @param stat_guia the stat_guia to set
     */
    public void setStat_guia(String stat_guia) {
        this.stat_guia = stat_guia;
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
     * @return the sayud1
     */
    public String getSayud1() {
        return sayud1;
    }

    /**
     * @param sayud1 the sayud1 to set
     */
    public void setSayud1(String sayud1) {
        this.sayud1 = sayud1;
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
     * @return the ssup_ruta
     */
    public String getSsup_ruta() {
        return ssup_ruta;
    }

    /**
     * @param ssup_ruta the ssup_ruta to set
     */
    public void setSsup_ruta(String ssup_ruta) {
        this.ssup_ruta = ssup_ruta;
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
     * @return the faltc
     */
    public String getFaltc() {
        return faltc;
    }

    /**
     * @param faltc the faltc to set
     */
    public void setFaltc(String faltc) {
        this.faltc = faltc;
    }

    /**
     * @return the guiac
     */
    public String getGuiac() {
        return guiac;
    }

    /**
     * @param guiac the guiac to set
     */
    public void setGuiac(String guiac) {
        this.guiac = guiac;
    }

    /**
     * @return the prodc
     */
    public String getProdc() {
        return prodc;
    }

    /**
     * @param prodc the prodc to set
     */
    public void setProdc(String prodc) {
        this.prodc = prodc;
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
     * @return the numcaja
     */
    public String getNumcaja() {
        return numcaja;
    }

    /**
     * @param numcaja the numcaja to set
     */
    public void setNumcaja(String numcaja) {
        this.numcaja = numcaja;
    }

    /**
     * @return the feccaja
     */
    public Date getFeccaja() {
        return feccaja;
    }

    /**
     * @param feccaja the feccaja to set
     */
    public void setFeccaja(Date feccaja) {
        this.feccaja = feccaja;
    }

    /**
     * @return the fecsalida
     */
    public Date getFecsalida() {
        return fecsalida;
    }

    /**
     * @param fecsalida the fecsalida to set
     */
    public void setFecsalida(Date fecsalida) {
        this.fecsalida = fecsalida;
    }

    /**
     * @return the cheq_r1
     */
    public String getCheq_r1() {
        return cheq_r1;
    }

    /**
     * @param cheq_r1 the cheq_r1 to set
     */
    public void setCheq_r1(String cheq_r1) {
        this.cheq_r1 = cheq_r1;
    }

    /**
     * @return the scheq_r1
     */
    public String getScheq_r1() {
        return scheq_r1;
    }

    /**
     * @param scheq_r1 the scheq_r1 to set
     */
    public void setScheq_r1(String scheq_r1) {
        this.scheq_r1 = scheq_r1;
    }

    /**
     * @return the cheq_r2
     */
    public String getCheq_r2() {
        return cheq_r2;
    }

    /**
     * @param cheq_r2 the cheq_r2 to set
     */
    public void setCheq_r2(String cheq_r2) {
        this.cheq_r2 = cheq_r2;
    }

    /**
     * @return the scheq_r2
     */
    public String getScheq_r2() {
        return scheq_r2;
    }

    /**
     * @param scheq_r2 the scheq_r2 to set
     */
    public void setScheq_r2(String scheq_r2) {
        this.scheq_r2 = scheq_r2;
    }

    /**
     * @return the cheq_r3
     */
    public String getCheq_r3() {
        return cheq_r3;
    }

    /**
     * @param cheq_r3 the cheq_r3 to set
     */
    public void setCheq_r3(String cheq_r3) {
        this.cheq_r3 = cheq_r3;
    }

    /**
     * @return the scheq_r3
     */
    public String getScheq_r3() {
        return scheq_r3;
    }

    /**
     * @param scheq_r3 the scheq_r3 to set
     */
    public void setScheq_r3(String scheq_r3) {
        this.scheq_r3 = scheq_r3;
    }

    /**
     * @return the cheq_r4
     */
    public String getCheq_r4() {
        return cheq_r4;
    }

    /**
     * @param cheq_r4 the cheq_r4 to set
     */
    public void setCheq_r4(String cheq_r4) {
        this.cheq_r4 = cheq_r4;
    }

    /**
     * @return the scheq_r4
     */
    public String getScheq_r4() {
        return scheq_r4;
    }

    /**
     * @param scheq_r4 the scheq_r4 to set
     */
    public void setScheq_r4(String scheq_r4) {
        this.scheq_r4 = scheq_r4;
    }

    /**
     * @return the cheq_r5
     */
    public String getCheq_r5() {
        return cheq_r5;
    }

    /**
     * @param cheq_r5 the cheq_r5 to set
     */
    public void setCheq_r5(String cheq_r5) {
        this.cheq_r5 = cheq_r5;
    }

    /**
     * @return the scheq_r5
     */
    public String getScheq_r5() {
        return scheq_r5;
    }

    /**
     * @param scheq_r5 the scheq_r5 to set
     */
    public void setScheq_r5(String scheq_r5) {
        this.scheq_r5 = scheq_r5;
    }

    /**
     * @return the cheq_r6
     */
    public String getCheq_r6() {
        return cheq_r6;
    }

    /**
     * @param cheq_r6 the cheq_r6 to set
     */
    public void setCheq_r6(String cheq_r6) {
        this.cheq_r6 = cheq_r6;
    }

    /**
     * @return the scheq_r6
     */
    public String getScheq_r6() {
        return scheq_r6;
    }

    /**
     * @param scheq_r6 the scheq_r6 to set
     */
    public void setScheq_r6(String scheq_r6) {
        this.scheq_r6 = scheq_r6;
    }

    /**
     * @return the cheq_r7
     */
    public String getCheq_r7() {
        return cheq_r7;
    }

    /**
     * @param cheq_r7 the cheq_r7 to set
     */
    public void setCheq_r7(String cheq_r7) {
        this.cheq_r7 = cheq_r7;
    }

    /**
     * @return the scheq_r7
     */
    public String getScheq_r7() {
        return scheq_r7;
    }

    /**
     * @param scheq_r7 the scheq_r7 to set
     */
    public void setScheq_r7(String scheq_r7) {
        this.scheq_r7 = scheq_r7;
    }

    /**
     * @return the cheq_pq
     */
    public String getCheq_pq() {
        return cheq_pq;
    }

    /**
     * @param cheq_pq the cheq_pq to set
     */
    public void setCheq_pq(String cheq_pq) {
        this.cheq_pq = cheq_pq;
    }

    /**
     * @return the scheq_pq
     */
    public String getScheq_pq() {
        return scheq_pq;
    }

    /**
     * @param scheq_pq the scheq_pq to set
     */
    public void setScheq_pq(String scheq_pq) {
        this.scheq_pq = scheq_pq;
    }

}
