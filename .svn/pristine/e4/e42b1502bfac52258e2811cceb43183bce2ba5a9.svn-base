/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects.Seniat;

import Tools.Tools;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author MITM
 */
public class UploadExcelFile {
    private int ano;
    private int mes;
    private String Excelfile;
    private String numorden;
    private String RifAgente;
    private String NombAgente;
    private Date FechaDoc;
    private String TipoDoc;
    private double MtoDoc1;
    private double MtoDoc2;
    private double MtoRet1;
    private double MtoRet2;
    private double MtoExe1;
    private double MtoExe2;
    private String NroDoc;
    private String NroControl;
    private String NroDocAfect;
    private double alicuota;
    private int status;
    private String NroComprobante;
    private double MtoRet3;
    private double MtoRet4;

    /**
     * 
     */
    public UploadExcelFile(){
        
    }

    /**
     * 
     * @param rs 
     */
    public UploadExcelFile(ResultSet rs){
        try{
            ano             = rs.getInt(1);
            mes             = rs.getInt(2);
            Excelfile       = rs.getString(3);
            numorden        = rs.getString(4);
            RifAgente       = rs.getString(5);
            NombAgente      = rs.getString(6);
            FechaDoc        = rs.getDate(7);
            TipoDoc         = rs.getString(8);
            MtoDoc1         = rs.getDouble(9);
            MtoDoc2         = rs.getDouble(10);
            MtoRet1         = rs.getDouble(11);
            MtoRet2         = rs.getDouble(12);
            MtoExe1         = rs.getDouble(13);
            MtoExe2         = rs.getDouble(14);
            NroDoc          = rs.getString(15);
            NroControl      = rs.getString(16);
            NroDocAfect     = rs.getString(17);
            alicuota        = rs.getDouble(18);
            status          = rs.getInt(19);
            NroComprobante  = rs.getString(20);
            MtoRet3         = rs.getDouble(21);
            
        }catch(SQLException e){    
            Tools.getErrorMessage(e.getStackTrace(),e.getMessage());
        }
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
     * @return the mes
     */
    public int getMes() {
        return mes;
    }

    /**
     * @param mes the mes to set
     */
    public void setMes(int mes) {
        this.mes = mes;
    }

    /**
     * @return the Excelfile
     */
    public String getExcelfile() {
        return Excelfile;
    }

    /**
     * @param Excelfile the Excelfile to set
     */
    public void setExcelfile(String Excelfile) {
        this.Excelfile = Excelfile;
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
     * @return the RifAgente
     */
    public String getRifAgente() {
        return RifAgente;
    }

    /**
     * @param RifAgente the RifAgente to set
     */
    public void setRifAgente(String RifAgente) {
        this.RifAgente = RifAgente;
    }

    /**
     * @return the NombAgente
     */
    public String getNombAgente() {
        return NombAgente;
    }

    /**
     * @param NombAgente the NombAgente to set
     */
    public void setNombAgente(String NombAgente) {
        this.NombAgente = NombAgente;
    }

    /**
     * @return the FechaDoc
     */
    public Date getFechaDoc() {
        return FechaDoc;
    }

    /**
     * @param FechaDoc the FechaDoc to set
     */
    public void setFechaDoc(Date FechaDoc) {
        this.FechaDoc = FechaDoc;
    }

    /**
     * @return the TipoDoc
     */
    public String getTipoDoc() {
        return TipoDoc;
    }

    /**
     * @param TipoDoc the TipoDoc to set
     */
    public void setTipoDoc(String TipoDoc) {
        this.TipoDoc = TipoDoc;
    }

    /**
     * @return the MtoDoc1
     */
    public double getMtoDoc1() {
        return MtoDoc1;
    }

    /**
     * @param MtoDoc1 the MtoDoc1 to set
     */
    public void setMtoDoc1(double MtoDoc1) {
        this.MtoDoc1 = MtoDoc1;
    }

    /**
     * @return the MtoDoc2
     */
    public double getMtoDoc2() {
        return MtoDoc2;
    }

    /**
     * @param MtoDoc2 the MtoDoc2 to set
     */
    public void setMtoDoc2(double MtoDoc2) {
        this.MtoDoc2 = MtoDoc2;
    }

    /**
     * @return the MtoRet1
     */
    public double getMtoRet1() {
        return MtoRet1;
    }

    /**
     * @param MtoRet1 the MtoRet1 to set
     */
    public void setMtoRet1(double MtoRet1) {
        this.MtoRet1 = MtoRet1;
    }

    /**
     * @return the MtoRet2
     */
    public double getMtoRet2() {
        return MtoRet2;
    }

    /**
     * @param MtoRet2 the MtoRet2 to set
     */
    public void setMtoRet2(double MtoRet2) {
        this.MtoRet2 = MtoRet2;
    }

    /**
     * @return the MtoExe1
     */
    public double getMtoExe1() {
        return MtoExe1;
    }

    /**
     * @param MtoExe1 the MtoExe1 to set
     */
    public void setMtoExe1(double MtoExe1) {
        this.MtoExe1 = MtoExe1;
    }

    /**
     * @return the MtoExe2
     */
    public double getMtoExe2() {
        return MtoExe2;
    }

    /**
     * @param MtoExe2 the MtoExe2 to set
     */
    public void setMtoExe2(double MtoExe2) {
        this.MtoExe2 = MtoExe2;
    }

    /**
     * @return the NroDoc
     */
    public String getNroDoc() {
        return NroDoc;
    }

    /**
     * @param NroDoc the NroDoc to set
     */
    public void setNroDoc(String NroDoc) {
        this.NroDoc = NroDoc;
    }

    /**
     * @return the NroControl
     */
    public String getNroControl() {
        return NroControl;
    }

    /**
     * @param NroControl the NroControl to set
     */
    public void setNroControl(String NroControl) {
        this.NroControl = NroControl;
    }

    /**
     * @return the NroDocAfect
     */
    public String getNroDocAfect() {
        return NroDocAfect;
    }

    /**
     * @param NroDocAfect the NroDocAfect to set
     */
    public void setNroDocAfect(String NroDocAfect) {
        this.NroDocAfect = NroDocAfect;
    }

    /**
     * @return the alicuota
     */
    public double getAlicuota() {
        return alicuota;
    }

    /**
     * @param alicuota the alicuota to set
     */
    public void setAlicuota(double alicuota) {
        this.alicuota = alicuota;
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
     * @return the NroComprobante
     */
    public String getNroComprobante() {
        return NroComprobante;
    }

    /**
     * @param NroComprobante the NroComprobante to set
     */
    public void setNroComprobante(String NroComprobante) {
        this.NroComprobante = NroComprobante;
    }

    /**
     * @return the MtoRet3
     */
    public double getMtoRet3() {
        return MtoRet3;
    }

    /**
     * @param MtoRet3 the MtoRet3 to set
     */
    public void setMtoRet3(double MtoRet3) {
        this.MtoRet3 = MtoRet3;
    }

    /**
     * @return the MtoRet4
     */
    public double getMtoRet4() {
        return MtoRet4;
    }

    /**
     * @param MtoRet4 the MtoRet4 to set
     */
    public void setMtoRet4(double MtoRet4) {
        this.MtoRet4 = MtoRet4;
    }

   
}

