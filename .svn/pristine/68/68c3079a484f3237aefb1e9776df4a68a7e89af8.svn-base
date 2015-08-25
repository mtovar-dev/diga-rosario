/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects.Orders;

import Objects.Setup.Unit;
import Tools.Tools;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author MITM
 */
public class Fxp_Inventa {
    private String estado;
    private Double supli;
    private Double linpro;
    private String grupo;
    private String codigo;
    private String descri;     
    private Double sugerido;
    private Unit tipoemba;
    private int uniporem;
    private Double conxbul;
    private Unit unixbul;
    private Unit tipounida;
    private String registro;
    private Double invmax;
    private Double maracay;
    private Double turmero;
    private Double almacen;
    private Double minimo;
    private Double maximo;
    private Double unipor2;
    private Unit tipoun2;
    private Double tiva;
    private Double tiva10;
    private Double tiva2;
    private String tipopre;
    private Double pvp;
    private Double predetal1;
    private Double predetal2;
    private Double precadena;
    private Double premayor;
    private Double predima;
    private Double prediego;
    private Double precio7;
    private Double precio8;
    private Double precio9;
    private Double precio10;
    private Double precio11;
    private Double precio12;
    private Double porcentaje;
    private Double porcentaj;
    private Double porcentaj1;
    private Double costo;
    private Double costorefe;
    private String oferta;
    private String obser;
    private String czoru;
    private String alic10;
    private int borrado;
    private Double plu;
    private Double emax;
    private Double emin;
    private Double uniporpvp;
    private String porlote;
    private Double pedido;
    private Double almsuper;
    private String resaltar;
    private String lote;
    private Double pedireci;
    private Double peditran;
    private Double pediprov;
    private Double costulti;
    private String codiprov;
    private String tipopvp;
    private Double voluunid;
    private Double gramunid;
    private String ubialm;
    private String swtipoemb;
    private String swtipouni;
    private Double pordesmax;
    private Double pordesmax2;
    private Double pordesmax3;
    private String ordarm;
    private String ordric;
    private String codelpro;
    private String contenido;
    private Double canescala;
    private Double porescala;
    private Double canescalb;
    private Double porescalb;
    private String codara;
    private Double cidsica;
    private Double fisico;
    private String ealmsuper;
    private Double almfoil;
    private Double almcarjil;
    private Double almmorit2;
    private Double almacenr;
    private Double almdevo;
    private Double pgastos;
    private String paleta;
    private String fpaqbul;

    /**
     * 
     */
    public Fxp_Inventa(){

    }

    /**
     * 
     * @param rs 
     */
    public Fxp_Inventa(ResultSet rs){
        try{
            estado          = rs.getString(1);
            supli           = rs.getDouble(2);
            linpro          = rs.getDouble(3);
            grupo           = rs.getString(4);
            codigo          = rs.getString(5);
            descri          = rs.getString(6);
            sugerido        = rs.getDouble(7);

            Unit objUnitEmp = new Unit();
            objUnitEmp.setIdUnit(rs.getInt(8));
            objUnitEmp.setAbrev(rs.getString(9));
            tipoemba = objUnitEmp;

            uniporem        = rs.getInt(10);
            conxbul         = rs.getDouble(11);
            
            Unit objUnitBul = new Unit();
            objUnitBul.setIdUnit(rs.getInt(12));
            objUnitBul.setAbrev(rs.getString(13));
            unixbul = objUnitBul;

            Unit objUnitUnida = new Unit();
            objUnitUnida.setIdUnit(rs.getInt(14));
            objUnitUnida.setAbrev(rs.getString(15));
            tipounida = objUnitUnida;

            registro        = rs.getString(16);
            invmax          = rs.getDouble(17);
            maracay         = rs.getDouble(18);
            turmero         = rs.getDouble(19);
            almacen         = rs.getDouble(20);
            minimo          = rs.getDouble(21);
            maximo          = rs.getDouble(22);
            unipor2         = rs.getDouble(23);
            
            Unit objUnitUnid2 = new Unit();
            objUnitUnid2.setIdUnit(rs.getInt(24));
            objUnitUnid2.setAbrev(rs.getString(25));
            tipoun2 = objUnitUnid2;

            tiva            = rs.getDouble(26);
            tiva10          = rs.getDouble(27);
            tiva2           = rs.getDouble(28);
            tipopre         = rs.getString(29);
            pvp             = rs.getDouble(30);
            predetal1       = rs.getDouble(31);
            predetal2       = rs.getDouble(32);
            precadena       = rs.getDouble(33);
            premayor        = rs.getDouble(34);
            predima         = rs.getDouble(35);
            prediego        = rs.getDouble(36);
            precio7         = rs.getDouble(37);
            precio8         = rs.getDouble(38);
            precio9         = rs.getDouble(39);
            precio10        = rs.getDouble(40);
            precio11        = rs.getDouble(41);
            precio12        = rs.getDouble(42);
            porcentaje      = rs.getDouble(43);
            porcentaj       = rs.getDouble(44);
            porcentaj1      = rs.getDouble(45);
            costo           = rs.getDouble(46);
            costorefe       = rs.getDouble(47);
            oferta          = rs.getString(48);
            obser           = rs.getString(49);
            czoru           = rs.getString(50);
            alic10          = rs.getString(51);
            borrado         = rs.getInt(52);
            plu             = rs.getDouble(53);
            emax            = rs.getDouble(54);
            emin            = rs.getDouble(55);
            uniporpvp       = rs.getDouble(56);
            porlote         = rs.getString(57);
            pedido          = rs.getDouble(58);
            almsuper        = rs.getDouble(59);
            resaltar        = rs.getString(60);
            lote            = rs.getString(61);
            pedireci        = rs.getDouble(62);
            peditran        = rs.getDouble(63);
            pediprov        = rs.getDouble(64);
            costulti        = rs.getDouble(65);
            codiprov         = rs.getString(66);
            tipopvp         = rs.getString(67);
            voluunid        = rs.getDouble(68);
            gramunid        = rs.getDouble(69);
            ubialm          = rs.getString(70);
            swtipoemb       = rs.getString(71);
            swtipouni       = rs.getString(72);
            pordesmax       = rs.getDouble(73);
            pordesmax2      = rs.getDouble(74);
            pordesmax3      = rs.getDouble(75);
            ordarm          = rs.getString(76);
            ordric          = rs.getString(77);
            codelpro        = rs.getString(78);
            contenido       = rs.getString(79);
            canescala       = rs.getDouble(80);
            porescala       = rs.getDouble(81);
            canescalb       = rs.getDouble(82);
            porescalb       = rs.getDouble(83);
            codara          = rs.getString(84);
            cidsica         = rs.getDouble(85);
            fisico          = rs.getDouble(86);
            ealmsuper       = rs.getString(87);
            almfoil         = rs.getDouble(88);
            almcarjil       = rs.getDouble(89);
            almmorit2       = rs.getDouble(90);
            almacenr        = rs.getDouble(91);
            almdevo         = rs.getDouble(92);
            pgastos         = rs.getDouble(93);
            paleta          = rs.getString(94);
            fpaqbul         = rs.getString(95);

            
        }catch(SQLException e){
            Tools.getErrorMessage(e.getStackTrace(),e.getMessage());
        }
    }

    /**
     * @return the estado
     */
    public String getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * @return the supli
     */
    public Double getSupli() {
        return supli;
    }

    /**
     * @param supli the supli to set
     */
    public void setSupli(Double supli) {
        this.supli = supli;
    }

    /**
     * @return the linpro
     */
    public Double getLinpro() {
        return linpro;
    }

    /**
     * @param linpro the linpro to set
     */
    public void setLinpro(Double linpro) {
        this.linpro = linpro;
    }

    /**
     * @return the grupo
     */
    public String getGrupo() {
        return grupo;
    }

    /**
     * @param grupo the grupo to set
     */
    public void setGrupo(String grupo) {
        this.grupo = grupo;
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
     * @return the descri
     */
    public String getDescri() {
        return descri;
    }

    /**
     * @param descri the descri to set
     */
    public void setDescri(String descri) {
        this.descri = descri;
    }

    /**
     * @return the sugerido
     */
    public Double getSugerido() {
        return sugerido;
    }

    /**
     * @param sugerido the sugerido to set
     */
    public void setSugerido(Double sugerido) {
        this.sugerido = sugerido;
    }

    /**
     * @return the tipoemba
     */
    public Unit getTipoemba() {
        return tipoemba;
    }

    /**
     * @param tipoemba the tipoemba to set
     */
    public void setTipoemba(Unit tipoemba) {
        this.tipoemba = tipoemba;
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
     * @return the conxbul
     */
    public Double getConxbul() {
        return conxbul;
    }

    /**
     * @param conxbul the conxbul to set
     */
    public void setConxbul(Double conxbul) {
        this.conxbul = conxbul;
    }

    /**
     * @return the unixbul
     */
    public Unit getUnixbul() {
        return unixbul;
    }

    /**
     * @param unixbul the unixbul to set
     */
    public void setUnixbul(Unit unixbul) {
        this.unixbul = unixbul;
    }

    /**
     * @return the tipounida
     */
    public Unit getTipounida() {
        return tipounida;
    }

    /**
     * @param tipounida the tipounida to set
     */
    public void setTipounida(Unit tipounida) {
        this.tipounida = tipounida;
    }

    /**
     * @return the registro
     */
    public String getRegistro() {
        return registro;
    }

    /**
     * @param registro the registro to set
     */
    public void setRegistro(String registro) {
        this.registro = registro;
    }

    /**
     * @return the invmax
     */
    public Double getInvmax() {
        return invmax;
    }

    /**
     * @param invmax the invmax to set
     */
    public void setInvmax(Double invmax) {
        this.invmax = invmax;
    }

    /**
     * @return the maracay
     */
    public Double getMaracay() {
        return maracay;
    }

    /**
     * @param maracay the maracay to set
     */
    public void setMaracay(Double maracay) {
        this.maracay = maracay;
    }

    /**
     * @return the turmero
     */
    public Double getTurmero() {
        return turmero;
    }

    /**
     * @param turmero the turmero to set
     */
    public void setTurmero(Double turmero) {
        this.turmero = turmero;
    }

    /**
     * @return the almacen
     */
    public Double getAlmacen() {
        return almacen;
    }

    /**
     * @param almacen the almacen to set
     */
    public void setAlmacen(Double almacen) {
        this.almacen = almacen;
    }

    /**
     * @return the minimo
     */
    public Double getMinimo() {
        return minimo;
    }

    /**
     * @param minimo the minimo to set
     */
    public void setMinimo(Double minimo) {
        this.minimo = minimo;
    }

    /**
     * @return the maximo
     */
    public Double getMaximo() {
        return maximo;
    }

    /**
     * @param maximo the maximo to set
     */
    public void setMaximo(Double maximo) {
        this.maximo = maximo;
    }

    /**
     * @return the unipor2
     */
    public Double getUnipor2() {
        return unipor2;
    }

    /**
     * @param unipor2 the unipor2 to set
     */
    public void setUnipor2(Double unipor2) {
        this.unipor2 = unipor2;
    }

    /**
     * @return the tipoun2
     */
    public Unit getTipoun2() {
        return tipoun2;
    }

    /**
     * @param tipoun2 the tipoun2 to set
     */
    public void setTipoun2(Unit tipoun2) {
        this.tipoun2 = tipoun2;
    }

    /**
     * @return the tiva
     */
    public Double getTiva() {
        return tiva;
    }

    /**
     * @param tiva the tiva to set
     */
    public void setTiva(Double tiva) {
        this.tiva = tiva;
    }

    /**
     * @return the tiva10
     */
    public Double getTiva10() {
        return tiva10;
    }

    /**
     * @param tiva10 the tiva10 to set
     */
    public void setTiva10(Double tiva10) {
        this.tiva10 = tiva10;
    }

    /**
     * @return the tiva2
     */
    public Double getTiva2() {
        return tiva2;
    }

    /**
     * @param tiva2 the tiva2 to set
     */
    public void setTiva2(Double tiva2) {
        this.tiva2 = tiva2;
    }

    /**
     * @return the tipopre
     */
    public String getTipopre() {
        return tipopre;
    }

    /**
     * @param tipopre the tipopre to set
     */
    public void setTipopre(String tipopre) {
        this.tipopre = tipopre;
    }

    /**
     * @return the pvp
     */
    public Double getPvp() {
        return pvp;
    }

    /**
     * @param pvp the pvp to set
     */
    public void setPvp(Double pvp) {
        this.pvp = pvp;
    }

    /**
     * @return the predetal1
     */
    public Double getPredetal1() {
        return predetal1;
    }

    /**
     * @param predetal1 the predetal1 to set
     */
    public void setPredetal1(Double predetal1) {
        this.predetal1 = predetal1;
    }

    /**
     * @return the predetal2
     */
    public Double getPredetal2() {
        return predetal2;
    }

    /**
     * @param predetal2 the predetal2 to set
     */
    public void setPredetal2(Double predetal2) {
        this.predetal2 = predetal2;
    }

    /**
     * @return the precadena
     */
    public Double getPrecadena() {
        return precadena;
    }

    /**
     * @param precadena the precadena to set
     */
    public void setPrecadena(Double precadena) {
        this.precadena = precadena;
    }

    /**
     * @return the premayor
     */
    public Double getPremayor() {
        return premayor;
    }

    /**
     * @param premayor the premayor to set
     */
    public void setPremayor(Double premayor) {
        this.premayor = premayor;
    }

    /**
     * @return the predima
     */
    public Double getPredima() {
        return predima;
    }

    /**
     * @param predima the predima to set
     */
    public void setPredima(Double predima) {
        this.predima = predima;
    }

    /**
     * @return the prediego
     */
    public Double getPrediego() {
        return prediego;
    }

    /**
     * @param prediego the prediego to set
     */
    public void setPrediego(Double prediego) {
        this.prediego = prediego;
    }

    /**
     * @return the precio7
     */
    public Double getPrecio7() {
        return precio7;
    }

    /**
     * @param precio7 the precio7 to set
     */
    public void setPrecio7(Double precio7) {
        this.precio7 = precio7;
    }

    /**
     * @return the precio8
     */
    public Double getPrecio8() {
        return precio8;
    }

    /**
     * @param precio8 the precio8 to set
     */
    public void setPrecio8(Double precio8) {
        this.precio8 = precio8;
    }

    /**
     * @return the precio9
     */
    public Double getPrecio9() {
        return precio9;
    }

    /**
     * @param precio9 the precio9 to set
     */
    public void setPrecio9(Double precio9) {
        this.precio9 = precio9;
    }

    /**
     * @return the precio10
     */
    public Double getPrecio10() {
        return precio10;
    }

    /**
     * @param precio10 the precio10 to set
     */
    public void setPrecio10(Double precio10) {
        this.precio10 = precio10;
    }

    /**
     * @return the precio11
     */
    public Double getPrecio11() {
        return precio11;
    }

    /**
     * @param precio11 the precio11 to set
     */
    public void setPrecio11(Double precio11) {
        this.precio11 = precio11;
    }

    /**
     * @return the precio12
     */
    public Double getPrecio12() {
        return precio12;
    }

    /**
     * @param precio12 the precio12 to set
     */
    public void setPrecio12(Double precio12) {
        this.precio12 = precio12;
    }

    /**
     * @return the porcentaje
     */
    public Double getPorcentaje() {
        return porcentaje;
    }

    /**
     * @param porcentaje the porcentaje to set
     */
    public void setPorcentaje(Double porcentaje) {
        this.porcentaje = porcentaje;
    }

    /**
     * @return the porcentaj
     */
    public Double getPorcentaj() {
        return porcentaj;
    }

    /**
     * @param porcentaj the porcentaj to set
     */
    public void setPorcentaj(Double porcentaj) {
        this.porcentaj = porcentaj;
    }

    /**
     * @return the porcentaj1
     */
    public Double getPorcentaj1() {
        return porcentaj1;
    }

    /**
     * @param porcentaj1 the porcentaj1 to set
     */
    public void setPorcentaj1(Double porcentaj1) {
        this.porcentaj1 = porcentaj1;
    }

    /**
     * @return the costo
     */
    public Double getCosto() {
        return costo;
    }

    /**
     * @param costo the costo to set
     */
    public void setCosto(Double costo) {
        this.costo = costo;
    }

    /**
     * @return the costorefe
     */
    public Double getCostorefe() {
        return costorefe;
    }

    /**
     * @param costorefe the costorefe to set
     */
    public void setCostorefe(Double costorefe) {
        this.costorefe = costorefe;
    }

    /**
     * @return the oferta
     */
    public String getOferta() {
        return oferta;
    }

    /**
     * @param oferta the oferta to set
     */
    public void setOferta(String oferta) {
        this.oferta = oferta;
    }

    /**
     * @return the obser
     */
    public String getObser() {
        return obser;
    }

    /**
     * @param obser the obser to set
     */
    public void setObser(String obser) {
        this.obser = obser;
    }

    /**
     * @return the czoru
     */
    public String getCzoru() {
        return czoru;
    }

    /**
     * @param czoru the czoru to set
     */
    public void setCzoru(String czoru) {
        this.czoru = czoru;
    }

    /**
     * @return the alic10
     */
    public String getAlic10() {
        return alic10;
    }

    /**
     * @param alic10 the alic10 to set
     */
    public void setAlic10(String alic10) {
        this.alic10 = alic10;
    }

    /**
     * @return the borrado
     */
    public int getBorrado() {
        return borrado;
    }

    /**
     * @param borrado the borrado to set
     */
    public void setBorrado(int borrado) {
        this.borrado = borrado;
    }

    /**
     * @return the plu
     */
    public Double getPlu() {
        return plu;
    }

    /**
     * @param plu the plu to set
     */
    public void setPlu(Double plu) {
        this.plu = plu;
    }

    /**
     * @return the emax
     */
    public Double getEmax() {
        return emax;
    }

    /**
     * @param emax the emax to set
     */
    public void setEmax(Double emax) {
        this.emax = emax;
    }

    /**
     * @return the emin
     */
    public Double getEmin() {
        return emin;
    }

    /**
     * @param emin the emin to set
     */
    public void setEmin(Double emin) {
        this.emin = emin;
    }

    /**
     * @return the uniporpvp
     */
    public Double getUniporpvp() {
        return uniporpvp;
    }

    /**
     * @param uniporpvp the uniporpvp to set
     */
    public void setUniporpvp(Double uniporpvp) {
        this.uniporpvp = uniporpvp;
    }

    /**
     * @return the porlote
     */
    public String getPorlote() {
        return porlote;
    }

    /**
     * @param porlote the porlote to set
     */
    public void setPorlote(String porlote) {
        this.porlote = porlote;
    }

    /**
     * @return the pedido
     */
    public Double getPedido() {
        return pedido;
    }

    /**
     * @param pedido the pedido to set
     */
    public void setPedido(Double pedido) {
        this.pedido = pedido;
    }

    /**
     * @return the almsuper
     */
    public Double getAlmsuper() {
        return almsuper;
    }

    /**
     * @param almsuper the almsuper to set
     */
    public void setAlmsuper(Double almsuper) {
        this.almsuper = almsuper;
    }

    /**
     * @return the resaltar
     */
    public String getResaltar() {
        return resaltar;
    }

    /**
     * @param resaltar the resaltar to set
     */
    public void setResaltar(String resaltar) {
        this.resaltar = resaltar;
    }

    /**
     * @return the lote
     */
    public String getLote() {
        return lote;
    }

    /**
     * @param lote the lote to set
     */
    public void setLote(String lote) {
        this.lote = lote;
    }

    /**
     * @return the pedireci
     */
    public Double getPedireci() {
        return pedireci;
    }

    /**
     * @param pedireci the pedireci to set
     */
    public void setPedireci(Double pedireci) {
        this.pedireci = pedireci;
    }

    /**
     * @return the peditran
     */
    public Double getPeditran() {
        return peditran;
    }

    /**
     * @param peditran the peditran to set
     */
    public void setPeditran(Double peditran) {
        this.peditran = peditran;
    }

    /**
     * @return the pediprov
     */
    public Double getPediprov() {
        return pediprov;
    }

    /**
     * @param pediprov the pediprov to set
     */
    public void setPediprov(Double pediprov) {
        this.pediprov = pediprov;
    }

    /**
     * @return the costulti
     */
    public Double getCostulti() {
        return costulti;
    }

    /**
     * @param costulti the costulti to set
     */
    public void setCostulti(Double costulti) {
        this.costulti = costulti;
    }

    /**
     * @return the codiprov
     */
    public String getCodiprov() {
        return codiprov;
    }

    /**
     * @param codiprov the codiprov to set
     */
    public void setCodiprov(String codiprov) {
        this.codiprov = codiprov;
    }

    /**
     * @return the tipopvp
     */
    public String getTipopvp() {
        return tipopvp;
    }

    /**
     * @param tipopvp the tipopvp to set
     */
    public void setTipopvp(String tipopvp) {
        this.tipopvp = tipopvp;
    }

    /**
     * @return the voluunid
     */
    public Double getVoluunid() {
        return voluunid;
    }

    /**
     * @param voluunid the voluunid to set
     */
    public void setVoluunid(Double voluunid) {
        this.voluunid = voluunid;
    }

    /**
     * @return the gramunid
     */
    public Double getGramunid() {
        return gramunid;
    }

    /**
     * @param gramunid the gramunid to set
     */
    public void setGramunid(Double gramunid) {
        this.gramunid = gramunid;
    }

    /**
     * @return the ubialm
     */
    public String getUbialm() {
        return ubialm;
    }

    /**
     * @param ubialm the ubialm to set
     */
    public void setUbialm(String ubialm) {
        this.ubialm = ubialm;
    }

    /**
     * @return the swtipoemb
     */
    public String getSwtipoemb() {
        return swtipoemb;
    }

    /**
     * @param swtipoemb the swtipoemb to set
     */
    public void setSwtipoemb(String swtipoemb) {
        this.swtipoemb = swtipoemb;
    }

    /**
     * @return the swtipouni
     */
    public String getSwtipouni() {
        return swtipouni;
    }

    /**
     * @param swtipouni the swtipouni to set
     */
    public void setSwtipouni(String swtipouni) {
        this.swtipouni = swtipouni;
    }

    /**
     * @return the pordesmax
     */
    public Double getPordesmax() {
        return pordesmax;
    }

    /**
     * @param pordesmax the pordesmax to set
     */
    public void setPordesmax(Double pordesmax) {
        this.pordesmax = pordesmax;
    }

    /**
     * @return the pordesmax2
     */
    public Double getPordesmax2() {
        return pordesmax2;
    }

    /**
     * @param pordesmax2 the pordesmax2 to set
     */
    public void setPordesmax2(Double pordesmax2) {
        this.pordesmax2 = pordesmax2;
    }

    /**
     * @return the pordesmax3
     */
    public Double getPordesmax3() {
        return pordesmax3;
    }

    /**
     * @param pordesmax3 the pordesmax3 to set
     */
    public void setPordesmax3(Double pordesmax3) {
        this.pordesmax3 = pordesmax3;
    }

    /**
     * @return the ordarm
     */
    public String getOrdarm() {
        return ordarm;
    }

    /**
     * @param ordarm the ordarm to set
     */
    public void setOrdarm(String ordarm) {
        this.ordarm = ordarm;
    }

    /**
     * @return the ordric
     */
    public String getOrdric() {
        return ordric;
    }

    /**
     * @param ordric the ordric to set
     */
    public void setOrdric(String ordric) {
        this.ordric = ordric;
    }

    /**
     * @return the codelpro
     */
    public String getCodelpro() {
        return codelpro;
    }

    /**
     * @param codelpro the codelpro to set
     */
    public void setCodelpro(String codelpro) {
        this.codelpro = codelpro;
    }

    /**
     * @return the contenido
     */
    public String getContenido() {
        return contenido;
    }

    /**
     * @param contenido the contenido to set
     */
    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    /**
     * @return the canescala
     */
    public Double getCanescala() {
        return canescala;
    }

    /**
     * @param canescala the canescala to set
     */
    public void setCanescala(Double canescala) {
        this.canescala = canescala;
    }

    /**
     * @return the porescala
     */
    public Double getPorescala() {
        return porescala;
    }

    /**
     * @param porescala the porescala to set
     */
    public void setPorescala(Double porescala) {
        this.porescala = porescala;
    }

    /**
     * @return the canescalb
     */
    public Double getCanescalb() {
        return canescalb;
    }

    /**
     * @param canescalb the canescalb to set
     */
    public void setCanescalb(Double canescalb) {
        this.canescalb = canescalb;
    }

    /**
     * @return the porescalb
     */
    public Double getPorescalb() {
        return porescalb;
    }

    /**
     * @param porescalb the porescalb to set
     */
    public void setPorescalb(Double porescalb) {
        this.porescalb = porescalb;
    }

    /**
     * @return the codara
     */
    public String getCodara() {
        return codara;
    }

    /**
     * @param codara the codara to set
     */
    public void setCodara(String codara) {
        this.codara = codara;
    }

    /**
     * @return the cidsica
     */
    public Double getCidsica() {
        return cidsica;
    }

    /**
     * @param cidsica the cidsica to set
     */
    public void setCidsica(Double cidsica) {
        this.cidsica = cidsica;
    }

    /**
     * @return the fisico
     */
    public Double getFisico() {
        return fisico;
    }

    /**
     * @param fisico the fisico to set
     */
    public void setFisico(Double fisico) {
        this.fisico = fisico;
    }

    /**
     * @return the ealmsuper
     */
    public String getEalmsuper() {
        return ealmsuper;
    }

    /**
     * @param ealmsuper the ealmsuper to set
     */
    public void setEalmsuper(String ealmsuper) {
        this.ealmsuper = ealmsuper;
    }

    /**
     * @return the almfoil
     */
    public Double getAlmfoil() {
        return almfoil;
    }

    /**
     * @param almfoil the almfoil to set
     */
    public void setAlmfoil(Double almfoil) {
        this.almfoil = almfoil;
    }

    /**
     * @return the almcarjil
     */
    public Double getAlmcarjil() {
        return almcarjil;
    }

    /**
     * @param almcarjil the almcarjil to set
     */
    public void setAlmcarjil(Double almcarjil) {
        this.almcarjil = almcarjil;
    }

    /**
     * @return the almmorit2
     */
    public Double getAlmmorit2() {
        return almmorit2;
    }

    /**
     * @param almmorit2 the almmorit2 to set
     */
    public void setAlmmorit2(Double almmorit2) {
        this.almmorit2 = almmorit2;
    }

    /**
     * @return the almacenr
     */
    public Double getAlmacenr() {
        return almacenr;
    }

    /**
     * @param almacenr the almacenr to set
     */
    public void setAlmacenr(Double almacenr) {
        this.almacenr = almacenr;
    }

    /**
     * @return the almdevo
     */
    public Double getAlmdevo() {
        return almdevo;
    }

    /**
     * @param almdevo the almdevo to set
     */
    public void setAlmdevo(Double almdevo) {
        this.almdevo = almdevo;
    }

    /**
     * @return the pgastos
     */
    public Double getPgastos() {
        return pgastos;
    }

    /**
     * @param pgastos the pgastos to set
     */
    public void setPgastos(Double pgastos) {
        this.pgastos = pgastos;
    }

    /**
     * @return the paleta
     */
    public String getPaleta() {
        return paleta;
    }

    /**
     * @param paleta the paleta to set
     */
    public void setPaleta(String paleta) {
        this.paleta = paleta;
    }

    /**
     * @return the fpaqbul
     */
    public String getFpaqbul() {
        return fpaqbul;
    }

    /**
     * @param fpaqbul the fpaqbul to set
     */
    public void setFpaqbul(String fpaqbul) {
        this.fpaqbul = fpaqbul;
    }

}
