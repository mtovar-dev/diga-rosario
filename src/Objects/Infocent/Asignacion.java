/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects.Infocent;

/**
 *
 * @author ARMGARCES
 */
public class Asignacion extends InfocentTableData{
    private String nomina;
    private String concepto;
    private String descto;
    private int    tipoProceso;
    private String proceso;
    private int    subproceso;
    private int    periodo;
    private int    num;
    private int    cantidad;
    private double monto;
    private double saldo;

    /**
     * @return the nomina
     */
    public String getNomina() {
        return nomina;
    }

    /**
     * @param nomina the nomina to set
     */
    public void setNomina(String nomina) {
        this.nomina = nomina;
    }

    /**
     * @return the concepto
     */
    public String getConcepto() {
        return concepto;
    }

    /**
     * @param concepto the concepto to set
     */
    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    /**
     * @return the descto
     */
    public String getDescto() {
        return descto;
    }

    /**
     * @param descto the descto to set
     */
    public void setDescto(String descto) {
        this.descto = descto;
    }

    /**
     * @return the tipoProceso
     */
    public int getTipoProceso() {
        return tipoProceso;
    }

    /**
     * @param tipoProceso the tipoProceso to set
     */
    public void setTipoProceso(int tipoProceso) {
        this.tipoProceso = tipoProceso;
    }

    /**
     * @return the proceso
     */
    public String getProceso() {
        return proceso;
    }

    /**
     * @param proceso the proceso to set
     */
    public void setProceso(String proceso) {
        this.proceso = proceso;
    }

    /**
     * @return the subproceso
     */
    public int getSubproceso() {
        return subproceso;
    }

    /**
     * @param subproceso the subproceso to set
     */
    public void setSubproceso(int subproceso) {
        this.subproceso = subproceso;
    }

    /**
     * @return the periodo
     */
    public int getPeriodo() {
        return periodo;
    }

    /**
     * @param periodo the periodo to set
     */
    public void setPeriodo(int periodo) {
        this.periodo = periodo;
    }

    /**
     * @return the num
     */
    public int getNum() {
        return num;
    }

    /**
     * @param num the num to set
     */
    public void setNum(int num) {
        this.num = num;
    }

    /**
     * @return the cantidad
     */
    public int getCantidad() {
        return cantidad;
    }

    /**
     * @param cantidad the cantidad to set
     */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * @return the monto
     */
    public double getMonto() {
        return monto;
    }

    /**
     * @param monto the monto to set
     */
    public void setMonto(double monto) {
        this.monto = monto;
    }

    /**
     * @return the saldo
     */
    public double getSaldo() {
        return saldo;
    }

    /**
     * @param saldo the saldo to set
     */
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    
    
}
