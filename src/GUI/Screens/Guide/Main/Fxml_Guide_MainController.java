/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Screens.Guide.Main;

import GUI.Gui;
import LN.Ln;
import LN.xy;
import Listeners.FocusPropertyChangeListener;
import Listeners.SelectKeyComboBoxListener;
import Objects.Fxp_Archguid;
import Objects.Fxp_Archguid_cp;
import Objects.Fxp_Archguid_gfc;
import Objects.Fxp_Archguip_det;
import Objects.Fxp_Archguip_pro;
import Objects.Fxp_Archguip_pro_cg;
import Objects.Fxp_Archguip_pro_dv;
import Objects.Fxp_Archguip_sum;
import Objects.Fxp_Renglon;
import Objects.log_TMotdev;
import Objects.Setup.Unit;
import Objects.log_CGuias;
import Objects.log_CGuias_falt_cg;
import Objects.log_CGuias_falt_dv;
import Objects.log_CGuias_perm;
import Objects.log_Guide;
import Objects.log_Guide_insopesca;
import Objects.log_Guide_rel_cred;
import Objects.log_Guide_rel_inv;
import Objects.log_Guide_sada;
import Objects.log_Personal;
import Objects.log_Vehiculos;
import Tools.Datos;
import java.math.RoundingMode;
import java.net.URL;
import java.sql.Date;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Accordion;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.control.Tooltip;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.effect.BoxBlur;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.util.Callback;

/**
 *
 * @author MITM
 */
public class Fxml_Guide_MainController implements Initializable {
    
    @FXML
    private AnchorPane ap_root;

    @FXML
    private Accordion ac_ppal;
    
    @FXML
    private Accordion ac_almacen;
    
    @FXML 
    private Button bt_c1; 

    @FXML 
    private Button bt_c2; 

    @FXML 
    private Button bt_c3; 

    @FXML 
    private Button bt_c4; 

    @FXML 
    private Button bt_c5; 

    @FXML 
    private Button bt_c6; 

    @FXML 
    private Button bt_c7; 

    @FXML 
    private Button bt_cr1; 

    @FXML 
    private Button bt_cr2; 

    @FXML 
    private Button bt_cr3; 

    @FXML 
    private Button bt_cr4; 

    @FXML 
    private Button bt_cr5; 

    @FXML 
    private Button bt_cr6; 

    @FXML 
    private Button bt_cr7; 

    @FXML 
    private Button bt_cpq; 

    @FXML 
    private Button bt_gc; 

    @FXML 
    private Button bt_d1; 

    @FXML 
    private Button bt_d2; 

    @FXML 
    private Button bt_dpc; 

    @FXML 
    private Button bt_dpv; 

    @FXML
    private ComboBox<Unit> cb_unidcg;

    @FXML
    private ComboBox<Unit> cb_uniddv;

    @FXML
    private ComboBox<log_TMotdev> cb_motivodv;

    @FXML
    private DatePicker dp_fcarga;
    
    @FXML
    private DatePicker dp_fsalida;
    
    @FXML
    private DatePicker dp_faltcg;
    
    @FXML
    private DatePicker dp_faltdv;
    
    @FXML
    private HBox hb_1;

    @FXML
    private HBox hbox_toolbar;

    @FXML
    private ImageView im_check;

    @FXML
    private ImageView im_checkg;

    @FXML
    private ImageView im_checks;

    @FXML
    private ImageView im_checki;

    @FXML
    private ImageView im_checkfg;

    @FXML
    private ImageView im_checkcg;

    @FXML
    private ImageView im_checkfp;

    @FXML
    private ImageView im_checkdf;

    @FXML
    private ImageView im_checkdp;

    @FXML
    private ImageView im_tool1;

    @FXML
    private ImageView im_tool10;

    @FXML
    private ImageView im_tool11;

    @FXML
    private ImageView im_tool12;

    @FXML
    private ImageView im_tool2;

    @FXML
    private ImageView im_tool3;

    @FXML
    private ImageView im_tool4;

    @FXML
    private ImageView im_tool5;

    @FXML
    private ImageView im_tool6;

    @FXML
    private ImageView im_tool7;

    @FXML
    private ImageView im_tool8;

    @FXML
    private ImageView im_tool9;

    @FXML
    private ImageView im_val;

    @FXML
    private ImageView im_lcc;

    @FXML
    private ImageView im_cmc;

    @FXML
    private ImageView im_csc;

    @FXML
    private ImageView im_mac;

    @FXML
    private ImageView im_rcv1;

    @FXML
    private ImageView im_ps1;

    @FXML
    private ImageView im_rgt1;

    @FXML
    private ImageView im_rcv2;

    @FXML
    private ImageView im_ps2;

    @FXML
    private ImageView im_rgt2;

    @FXML 
    private Label lb_screen; 

    @FXML 
    private Label lb_Title; 

    @FXML 
    private Label lb_chofer; 

    @FXML 
    private Label lb_veh1; 

    @FXML 
    private Label lb_veh2; 

    @FXML 
    private Label lb_ayud1; 

    @FXML 
    private Label lb_ayud2; 

    @FXML 
    private Label lb_cheqp; 

    @FXML 
    private Label lb_rgt1; 

    @FXML 
    private Label lb_rgt2; 

    @FXML 
    private Label lb_cheqpdv; 

    @FXML 
    private Label lb_supruta; 

    @FXML
    private TableView<Fxp_Archguip_det> tb_alm1;

    @FXML
    private TableView<Fxp_Archguip_sum> tb_alm1s;

    @FXML
    private TableView<Fxp_Archguip_det> tb_alm2;
    
    @FXML
    private TableView<Fxp_Archguip_sum> tb_alm2s;

    @FXML
    private TableView<Fxp_Archguip_det> tb_alm3;

    @FXML
    private TableView<Fxp_Archguip_sum> tb_alm3s;

    @FXML
    private TableView<Fxp_Archguip_det> tb_alm4;
    
    @FXML
    private TableView<Fxp_Archguip_sum> tb_alm4s;

    @FXML
    private TableView<Fxp_Archguip_det> tb_alm5;

    @FXML
    private TableView<Fxp_Archguip_sum> tb_alm5s;

    @FXML
    private TableView<Fxp_Archguip_det> tb_alm6;
    
    @FXML
    private TableView<Fxp_Archguip_sum> tb_alm6s;

    @FXML
    private TableView<Fxp_Archguip_det> tb_alm7;
    
    @FXML
    private TableView<Fxp_Archguip_sum> tb_alm7s;

    @FXML
    private TableView<Fxp_Archguip_det> tb_almp;

    @FXML
    private TableView<Fxp_Archguip_sum> tb_almps;

    @FXML
    private TableView<Fxp_Archguid> tb_factura;

    @FXML
    private TableView<log_Guide_sada> tb_sada;

    @FXML
    private TableView<log_Guide_insopesca> tb_insopesca;

    @FXML
    private TableView<Fxp_Archguip_pro_cg> tb_almm;

    @FXML
    private TableView<Fxp_Archguid> tb_credit;

    @FXML
    private TableView<xy> tb_guias;

    @FXML
    private TableView<Fxp_Archguip_pro_dv> tb_almr;

    @FXML
    private TextField tf_buscar;

    @FXML
    private TextField tf_nroguia;

    @FXML
    private TextField tf_nrorguia;

    @FXML
    private TextField tf_pcarga;

    @FXML
    private TextField tf_turno;

    @FXML
    private TextField tf_odometro;

    @FXML
    private TextField tf_chofer;

    @FXML
    private TextField tf_veh1;

    @FXML
    private TextField tf_veh2;

    @FXML
    private TextField tf_ayud1;

    @FXML
    private TextField tf_ayud2;

    @FXML
    private TextField tf_cheqp;

    @FXML
    private TextField tf_supruta;

    @FXML
    private TextField tf_cheqr1;

    @FXML
    private TextField tf_cheqr2;

    @FXML
    private TextField tf_cheqr3;

    @FXML
    private TextField tf_cheqr4;

    @FXML
    private TextField tf_cheqr5;

    @FXML
    private TextField tf_cheqr6;

    @FXML
    private TextField tf_cheqr7;

    @FXML
    private TextField tf_cheqpq;

    @FXML
    private TextField tf_sada;

    @FXML
    private TextField tf_insopesca;

    @FXML
    private TextField tf_nrofguia;

    @FXML
    private TextField tf_nrocguia;

    @FXML
    private TextField tf_nrocred;

    @FXML
    private TextField tf_prodcg;

    @FXML
    private TextField tf_cantcg;

    @FXML
    private TextField tf_cheqpdv;

    @FXML
    private TextField tf_factdv;

    @FXML
    private TextField tf_motivodv;

    @FXML
    private TextField tf_proddv;

    @FXML
    private TextField tf_cantdv;

    @FXML
    private TextField tf_pmarcado;

    @FXML
    private TextField tf_obserdv;

    @FXML
    private TitledPane tp_factura;

    @FXML
    private TitledPane tp_almacen;

    @FXML
    private TitledPane tp_carga;
    
    @FXML
    private TitledPane tp_permiso;
    
    @FXML
    private TitledPane tp_fcarga;
    
    @FXML
    private TitledPane tp_fdevolucion;
    
    @FXML
    private TitledPane tp_notascr;
    
    @FXML
    private VBox vb_form;

    @FXML 
    private VBox vb_table; 


    private static String rows = 
            java.util.ResourceBundle.getBundle("BD/DBcon").getString("rows");
    
    private static final String path_dat = 
            java.util.ResourceBundle.getBundle("BD/DBcon").getString("path_dat");

    private static final String path_ima = 
            java.util.ResourceBundle.getBundle("BD/DBcon").getString("path_ima");

    private static final String path_rep = 
            java.util.ResourceBundle.getBundle("BD/DBcon").getString("path_rep");

    private static final String path = System.getProperty("user.dir");
    
    Map<String, Object> JrxmlParam = new HashMap<String, Object>();
    
    private static int tipoOperacion;    
    private static ImageView[] tools;    
    private static TextField[] cheqs;    
    private static Integer[] toolsConfig;    
    private static String[] tooltips;
    private static String[] cheqtips;

    private static int numGuias         = 0; 
    
    private static int numFactCarga     = 0; 
    private static int numClieCarga     = 0; 
    private static int numFaltCarga     = 0; 
    private static int numSadaCarga     = 0; 
    private static int numInsoCarga     = 0; 

    private static int numFactDev       = 0; 
    private static int numClieDev       = 0; 
    private static int numFaltDev       = 0; 
    private static int numNotaDev       = 0; 
    private static int numStatDev       = 0; 
    private static int numCompDevCar    = 0; 
    private static int numUnidMin       = 0;
    private static int numCantDesp      = 0;
    private static int numIdMotivo      = 0;
    private static int numAlmacen       = 0;

    private static double dblPvp        = 0;
    
    private static final ObservableList<xy> log_guide_guia = FXCollections.observableArrayList();
    private static final ObservableList<log_Guide_sada> log_guide_sada = FXCollections.observableArrayList();
    private static final ObservableList<log_Guide_insopesca> log_guide_insopesca = FXCollections.observableArrayList();
    private static final ObservableList<Fxp_Archguip_pro_cg> log_guide_missing = FXCollections.observableArrayList();
    private static final ObservableList<Fxp_Archguip_pro_dv> log_guide_refund = FXCollections.observableArrayList();
    private static final ObservableList<Fxp_Archguid> log_guide_credit = FXCollections.observableArrayList();

    private static final String ScreenName = "Guia de Carga";
    
    /**
     * Initializes the controller class.
     * @param fxmlFileLocation
     * @param resources
     */     
    @Override // This method is called by the FXMLLoader when initialization is complete
    public void initialize(URL fxmlFileLocation, ResourceBundle resources) {
        assert ap_root != null : "fx:id=\"ap_root\" was not injected: check your FXML file 'Fxml_Guide.fxml'.";
        assert ac_almacen != null : "fx:id=\"ac_almacen\" was not injected: check your FXML file 'Fxml_Guide.fxml'.";
        assert ac_ppal != null : "fx:id=\"ac_ppal\" was not injected: check your FXML file 'Fxml_Guide.fxml'.";
        assert bt_c1 != null : "fx:id=\"bt_c1\" was not injected: check your FXML file 'Fxml_Guide.fxml'.";
        assert bt_c2 != null : "fx:id=\"bt_c2\" was not injected: check your FXML file 'Fxml_Guide.fxml'.";
        assert bt_c3 != null : "fx:id=\"bt_c3\" was not injected: check your FXML file 'Fxml_Guide.fxml'.";
        assert bt_c4 != null : "fx:id=\"bt_c4\" was not injected: check your FXML file 'Fxml_Guide.fxml'.";
        assert bt_c5 != null : "fx:id=\"bt_c5\" was not injected: check your FXML file 'Fxml_Guide.fxml'.";
        assert bt_c6 != null : "fx:id=\"bt_c6\" was not injected: check your FXML file 'Fxml_Guide.fxml'.";
        assert bt_c7 != null : "fx:id=\"bt_c7\" was not injected: check your FXML file 'Fxml_Guide.fxml'.";
        assert bt_cr1 != null : "fx:id=\"bt_cr1\" was not injected: check your FXML file 'Fxml_Guide.fxml'.";
        assert bt_cr2 != null : "fx:id=\"bt_cr2\" was not injected: check your FXML file 'Fxml_Guide.fxml'.";
        assert bt_cr3 != null : "fx:id=\"bt_cr3\" was not injected: check your FXML file 'Fxml_Guide.fxml'.";
        assert bt_cr4 != null : "fx:id=\"bt_cr4\" was not injected: check your FXML file 'Fxml_Guide.fxml'.";
        assert bt_cr5 != null : "fx:id=\"bt_cr5\" was not injected: check your FXML file 'Fxml_Guide.fxml'.";
        assert bt_cr6 != null : "fx:id=\"bt_cr6\" was not injected: check your FXML file 'Fxml_Guide.fxml'.";
        assert bt_cr7 != null : "fx:id=\"bt_cr7\" was not injected: check your FXML file 'Fxml_Guide.fxml'.";
        assert bt_cpq != null : "fx:id=\"bt_cpq\" was not injected: check your FXML file 'Fxml_Guide.fxml'.";
        assert bt_gc != null : "fx:id=\"bt_gc\" was not injected: check your FXML file 'Fxml_Guide.fxml'.";
        assert bt_d1 != null : "fx:id=\"bt_d1\" was not injected: check your FXML file 'Fxml_Guide.fxml'.";
        assert bt_d2 != null : "fx:id=\"bt_d2\" was not injected: check your FXML file 'Fxml_Guide.fxml'.";
        assert bt_dpc != null : "fx:id=\"bt_dpc\" was not injected: check your FXML file 'Fxml_Guide.fxml'.";
        assert bt_dpv != null : "fx:id=\"bt_dpv\" was not injected: check your FXML file 'Fxml_Guide.fxml'.";
        assert cb_unidcg != null : "fx:id=\"cb_unidcg\" was not injected: check your FXML file 'Fxml_Guide.fxml'.";
        assert cb_uniddv != null : "fx:id=\"cb_uniddv\" was not injected: check your FXML file 'Fxml_Guide.fxml'.";
        assert cb_motivodv != null : "fx:id=\"cb_motivodv\" was not injected: check your FXML file 'Fxml_Guide.fxml'.";
        assert dp_fcarga != null : "fx:id=\"dt_fcarga\" was not injected: check your FXML file 'Fxml_Guide.fxml'.";
        assert dp_fsalida != null : "fx:id=\"dt_fsalida\" was not injected: check your FXML file 'Fxml_Guide.fxml'.";
        assert dp_faltcg != null : "fx:id=\"dt_faltc\" was not injected: check your FXML file 'Fxml_Guide.fxml'.";
        assert dp_faltdv != null : "fx:id=\"dt_faltd\" was not injected: check your FXML file 'Fxml_Guide.fxml'.";
        assert hb_1 != null : "fx:id=\"hb_1\" was not injected: check your FXML file 'Fxml_Guide.fxml'.";
        assert hbox_toolbar != null : "fx:id=\"hbox_toolbar\" was not injected: check your FXML file 'Fxml_Guide.fxml'.";
        assert im_check != null : "fx:id=\"im_check\" was not injected: check your FXML file 'Fxml_Guide.fxml'.";
        assert im_checkg != null : "fx:id=\"im_checkg\" was not injected: check your FXML file 'Fxml_Guide.fxml'.";
        assert im_checks != null : "fx:id=\"im_checkg\" was not injected: check your FXML file 'Fxml_Guide.fxml'.";
        assert im_checki != null : "fx:id=\"im_checkg\" was not injected: check your FXML file 'Fxml_Guide.fxml'.";
        assert im_checkfg != null : "fx:id=\"im_checkfg\" was not injected: check your FXML file 'Fxml_Guide.fxml'.";
        assert im_checkcg != null : "fx:id=\"im_checkcg\" was not injected: check your FXML file 'Fxml_Guide.fxml'.";
        assert im_checkfp != null : "fx:id=\"im_checkfp\" was not injected: check your FXML file 'Fxml_Guide.fxml'.";
        assert im_checkdf != null : "fx:id=\"im_checkdf\" was not injected: check your FXML file 'Fxml_Guide.fxml'.";
        assert im_checkdp != null : "fx:id=\"im_checkdp\" was not injected: check your FXML file 'Fxml_Guide.fxml'.";
        assert im_tool1 != null : "fx:id=\"im_tool1\" was not injected: check your FXML file 'Fxml_Guide.fxml'.";
        assert im_tool10 != null : "fx:id=\"im_tool10\" was not injected: check your FXML file 'Fxml_Guide.fxml'.";
        assert im_tool11 != null : "fx:id=\"im_tool11\" was not injected: check your FXML file 'Fxml_Guide.fxml'.";
        assert im_tool12 != null : "fx:id=\"im_tool12\" was not injected: check your FXML file 'Fxml_Guide.fxml'.";
        assert im_tool2 != null : "fx:id=\"im_tool2\" was not injected: check your FXML file 'Fxml_Guide.fxml'.";
        assert im_tool3 != null : "fx:id=\"im_tool3\" was not injected: check your FXML file 'Fxml_Guide.fxml'.";
        assert im_tool4 != null : "fx:id=\"im_tool4\" was not injected: check your FXML file 'Fxml_Guide.fxml'.";
        assert im_tool5 != null : "fx:id=\"im_tool5\" was not injected: check your FXML file 'Fxml_Guide.fxml'.";
        assert im_tool6 != null : "fx:id=\"im_tool6\" was not injected: check your FXML file 'Fxml_Guide.fxml'.";
        assert im_tool7 != null : "fx:id=\"im_tool7\" was not injected: check your FXML file 'Fxml_Guide.fxml'.";
        assert im_tool8 != null : "fx:id=\"im_tool8\" was not injected: check your FXML file 'Fxml_Guide.fxml'.";
        assert im_tool9 != null : "fx:id=\"im_tool9\" was not injected: check your FXML file 'Fxml_Guide.fxml'.";
        assert im_val != null : "fx:id=\"im_val\" was not injected: check your FXML file 'Fxml_Guide.fxml'.";
        assert im_lcc != null : "fx:id=\"im_lcc\" was not injected: check your FXML file 'Fxml_Guide.fxml'.";
        assert im_cmc != null : "fx:id=\"im_cmc\" was not injected: check your FXML file 'Fxml_Guide.fxml'.";
        assert im_csc != null : "fx:id=\"im_csc\" was not injected: check your FXML file 'Fxml_Guide.fxml'.";
        assert im_mac != null : "fx:id=\"im_mac\" was not injected: check your FXML file 'Fxml_Guide.fxml'.";
        assert im_rcv1 != null : "fx:id=\"im_rcv1\" was not injected: check your FXML file 'Fxml_Guide.fxml'.";
        assert im_ps1 != null : "fx:id=\"im_ps1\" was not injected: check your FXML file 'Fxml_Guide.fxml'.";
        assert im_rgt1 != null : "fx:id=\"im_rgt1\" was not injected: check your FXML file 'Fxml_Guide.fxml'.";
        assert im_rcv2 != null : "fx:id=\"im_rcv2\" was not injected: check your FXML file 'Fxml_Guide.fxml'.";
        assert im_ps2 != null : "fx:id=\"im_ps2\" was not injected: check your FXML file 'Fxml_Guide.fxml'.";
        assert im_rgt2 != null : "fx:id=\"im_rgt2\" was not injected: check your FXML file 'Fxml_Guide.fxml'.";
        assert lb_screen != null : "fx:id=\"lb_Title\" was not injected: check your FXML file 'Fxml_Guide.fxml'.";
        assert lb_Title != null : "fx:id=\"lb_Title\" was not injected: check your FXML file 'Fxml_Guide.fxml'.";
        assert lb_chofer != null : "fx:id=\"lb_chofer\" was not injected: check your FXML file 'Fxml_Guide.fxml'.";
        assert lb_veh1 != null : "fx:id=\"lb_veh1\" was not injected: check your FXML file 'Fxml_Guide.fxml'.";
        assert lb_veh2 != null : "fx:id=\"lb_veh2\" was not injected: check your FXML file 'Fxml_Guide.fxml'.";
        assert lb_ayud1 != null : "fx:id=\"lb_ayud1\" was not injected: check your FXML file 'Fxml_Guide.fxml'.";
        assert lb_ayud2 != null : "fx:id=\"lb_ayud2\" was not injected: check your FXML file 'Fxml_Guide.fxml'.";
        assert lb_cheqp != null : "fx:id=\"lb_cheqp\" was not injected: check your FXML file 'Fxml_Guide.fxml'.";
        assert lb_supruta != null : "fx:id=\"lb_supruta\" was not injected: check your FXML file 'Fxml_Guide.fxml'.";
        assert lb_cheqpdv != null : "fx:id=\"lb_cheqpdv\" was not injected: check your FXML file 'Fxml_Guide.fxml'.";
        assert lb_rgt1 != null : "fx:id=\"lb_ayud1\" was not injected: check your FXML file 'Fxml_Guide.fxml'.";
        assert lb_rgt2 != null : "fx:id=\"lb_ayud2\" was not injected: check your FXML file 'Fxml_Guide.fxml'.";
        assert tb_alm1 != null : "fx:id=\"tb_alm1\" was not injected: check your FXML file 'Fxml_Guide.fxml'.";
        assert tb_alm1s != null : "fx:id=\"tb_alm1s\" was not injected: check your FXML file 'Fxml_Guide.fxml'.";
        assert tb_alm2 != null : "fx:id=\"tb_alm2\" was not injected: check your FXML file 'Fxml_Guide.fxml'.";
        assert tb_alm3 != null : "fx:id=\"tb_alm3\" was not injected: check your FXML file 'Fxml_Guide.fxml'.";
        assert tb_alm4 != null : "fx:id=\"tb_alm4\" was not injected: check your FXML file 'Fxml_Guide.fxml'.";
        assert tb_alm5 != null : "fx:id=\"tb_alm5\" was not injected: check your FXML file 'Fxml_Guide.fxml'.";
        assert tb_alm6 != null : "fx:id=\"tb_alm6\" was not injected: check your FXML file 'Fxml_Guide.fxml'.";
        assert tb_alm7 != null : "fx:id=\"tb_alm6\" was not injected: check your FXML file 'Fxml_Guide.fxml'.";
        assert tb_almp != null : "fx:id=\"tb_almp\" was not injected: check your FXML file 'Fxml_Guide.fxml'.";
        assert tb_almps != null : "fx:id=\"tb_almps\" was not injected: check your FXML file 'Fxml_Guide.fxml'.";
        assert tb_sada != null : "fx:id=\"tb_sada\" was not injected: check your FXML file 'Fxml_Guide.fxml'.";
        assert tb_insopesca != null : "fx:id=\"tb_insopesca\" was not injected: check your FXML file 'Fxml_Guide.fxml'.";
        assert tb_almm != null : "fx:id=\"tb_almm\" was not injected: check your FXML file 'Fxml_Guide.fxml'.";
        assert tb_almr != null : "fx:id=\"tb_almr\" was not injected: check your FXML file 'Fxml_Guide.fxml'.";
        assert tb_credit != null : "fx:id=\"tb_credit\" was not injected: check your FXML file 'Fxml_Guide.fxml'.";
        assert tb_factura != null : "fx:id=\"tb_factura\" was not injected: check your FXML file 'Fxml_Guide.fxml'.";
        assert tb_guias != null : "fx:id=\"tb_guias\" was not injected: check your FXML file 'Fxml_Guide.fxml'.";
        assert tf_buscar != null : "fx:id=\"tf_pcarga\" was not injected: check your FXML file 'Fxml_Guide.fxml'.";
        assert tf_nrorguia != null : "fx:id=\"tf_nrofguia\" was not injected: check your FXML file 'Fxml_Guide.fxml'.";
        assert tf_pcarga != null : "fx:id=\"tf_pcarga\" was not injected: check your FXML file 'Fxml_Guide.fxml'.";
        assert tf_turno != null : "fx:id=\"tf_turno\" was not injected: check your FXML file 'Fxml_Guide.fxml'.";
        assert tf_odometro != null : "fx:id=\"tf_odometro\" was not injected: check your FXML file 'Fxml_Guide.fxml'.";
        assert tf_chofer != null : "fx:id=\"tf_chofer\" was not injected: check your FXML file 'Fxml_Guide.fxml'.";
        assert tf_veh1 != null : "fx:id=\"tf_veh1\" was not injected: check your FXML file 'Fxml_Guide.fxml'.";
        assert tf_veh2 != null : "fx:id=\"tf_veh2\" was not injected: check your FXML file 'Fxml_Guide.fxml'.";
        assert tf_ayud1 != null : "fx:id=\"tf_ayud1\" was not injected: check your FXML file 'Fxml_Guide.fxml'.";
        assert tf_ayud2 != null : "fx:id=\"tf_ayud2\" was not injected: check your FXML file 'Fxml_Guide.fxml'.";
        assert tf_cheqp != null : "fx:id=\"tf_cheqp\" was not injected: check your FXML file 'Fxml_Guide.fxml'.";
        assert tf_supruta != null : "fx:id=\"tf_supruta\" was not injected: check your FXML file 'Fxml_Guide.fxml'.";
        assert tf_cheqr1 != null : "fx:id=\"tf_cheqr1\" was not injected: check your FXML file 'Fxml_Guide.fxml'.";
        assert tf_cheqr2 != null : "fx:id=\"tf_cheqr2\" was not injected: check your FXML file 'Fxml_Guide.fxml'.";
        assert tf_cheqr3 != null : "fx:id=\"tf_cheqr3\" was not injected: check your FXML file 'Fxml_Guide.fxml'.";
        assert tf_cheqr4 != null : "fx:id=\"tf_cheqr4\" was not injected: check your FXML file 'Fxml_Guide.fxml'.";
        assert tf_cheqr5 != null : "fx:id=\"tf_cheqr5\" was not injected: check your FXML file 'Fxml_Guide.fxml'.";
        assert tf_cheqr6 != null : "fx:id=\"tf_cheqr6\" was not injected: check your FXML file 'Fxml_Guide.fxml'.";
        assert tf_cheqr7 != null : "fx:id=\"tf_cheqr7\" was not injected: check your FXML file 'Fxml_Guide.fxml'.";
        assert tf_cheqpq != null : "fx:id=\"tf_cheqpq\" was not injected: check your FXML file 'Fxml_Guide.fxml'.";
        assert tf_sada != null : "fx:id=\"tf_sada\" was not injected: check your FXML file 'Fxml_Guide.fxml'.";
        assert tf_insopesca != null : "fx:id=\"tf_isopesca\" was not injected: check your FXML file 'Fxml_Guide.fxml'.";
        assert tf_nrofguia != null : "fx:id=\"tf_nrofguia\" was not injected: check your FXML file 'Fxml_Guide.fxml'.";
        assert tf_nrocguia != null : "fx:id=\"tf_nrocguia\" was not injected: check your FXML file 'Fxml_Guide.fxml'.";
        assert tf_nrocred != null : "fx:id=\"tf_nrocred\" was not injected: check your FXML file 'Fxml_Guide.fxml'.";
        assert tf_prodcg != null : "fx:id=\"tf_producto\" was not injected: check your FXML file 'Fxml_Guide.fxml'.";
        assert tf_cantcg != null : "fx:id=\"tf_cant\" was not injected: check your FXML file 'Fxml_Guide.fxml'.";
        assert tf_cheqpdv != null : "fx:id=\"tf_cheqpd\" was not injected: check your FXML file 'Fxml_Guide.fxml'.";
        assert tf_factdv != null : "fx:id=\"tf_factdv\" was not injected: check your FXML file 'Fxml_Guide.fxml'.";
        assert tf_motivodv != null : "fx:id=\"tf_motdv\" was not injected: check your FXML file 'Fxml_Guide.fxml'.";
        assert tf_proddv != null : "fx:id=\"tf_proddv\" was not injected: check your FXML file 'Fxml_Guide.fxml'.";
        assert tf_cantdv != null : "fx:id=\"tf_cantdv\" was not injected: check your FXML file 'Fxml_Guide.fxml'.";
        assert tf_pmarcado != null : "fx:id=\"tf_pmarcado\" was not injected: check your FXML file 'Fxml_Guide.fxml'.";
        assert tf_obserdv != null : "fx:id=\"tf_obserdv\" was not injected: check your FXML file 'Fxml_Guide.fxml'.";
        assert tp_factura != null : "fx:id=\"tp_factura\" was not injected: check your FXML file 'Fxml_Guide.fxml'.";
        assert tp_almacen != null : "fx:id=\"tp_almacen\" was not injected: check your FXML file 'Fxml_Guide.fxml'.";
        assert tp_carga != null : "fx:id=\"tp_carga\" was not injected: check your FXML file 'Fxml_Guide.fxml'.";
        assert tp_permiso != null : "fx:id=\"tp_permiso\" was not injected: check your FXML file 'Fxml_Guide.fxml'.";
        assert tp_fcarga != null : "fx:id=\"tp_fcarga\" was not injected: check your FXML file 'Fxml_Guide.fxml'.";
        assert tp_fdevolucion != null : "fx:id=\"tp_fdevolucion\" was not injected: check your FXML file 'Fxml_Guide.fxml'.";
        assert tp_notascr != null : "fx:id=\"tp_notascr\" was not injected: check your FXML file 'Fxml_Guide.fxml'.";
        assert vb_form != null : "fx:id=\"vb_form\" was not injected: check your FXML file 'Fxml_Guide.fxml'.";
        assert vb_table != null : "fx:id=\"vb_table\" was not injected: check your FXML file 'Fxml_Guide.fxml'.";

        //Inicializa la Barra de Herramientas y comportamiento del Boton de Busqueda
        defineToolBar();         
        defineBotonBuscar();    
        init_buttons();     //Establece los comportamientos de los botones
        botonInicio();      //Se imprime la pantalla Inicio

        //
        createTableGuide();     //Crea e Inicializa la Tabla de Datos   

        createTableBill();      //Crea e Inicializa la Tabla de Datos   
        createTableCredit();    //Crea e Inicializa la Tabla de Datos   
        
        createTableStock1();    //Crea e Inicializa la Tabla de Datos                    
        createTableStock1s();

        createTableStock2();    //Crea e Inicializa la Tabla de Datos                    
        createTableStock2s();

        createTableStock3();    //Crea e Inicializa la Tabla de Datos                    
        createTableStock3s();

        createTableStock4();    //Crea e Inicializa la Tabla de Datos                    
        createTableStock4s();

        createTableStock5();    //Crea e Inicializa la Tabla de Datos                    
        createTableStock5s();

        createTableStock6();    //Crea e Inicializa la Tabla de Datos                    
        createTableStock6s();

        createTableStock7();    //Crea e Inicializa la Tabla de Datos                    
        createTableStock7s();

        createTableStockP1();   //Crea e Inicializa la Tabla de Datos                    
        createTableStockPs();

        createTableSada();      //Crea e Inicializa la Tabla de Datos   
        createTableInsopesca();  //Crea e Inicializa la Tabla de Datos   

        createTableStockM1();   //Crea e Inicializa la Tabla de Datos                    

        createTableStockR1();   //Crea e Inicializa la Tabla de Datos                    
        createTableStockRs();

        loadTMotdev();
        
        //Capturador de eventos de Teclado en toda la pantalla 
        ap_root.addEventFilter(KeyEvent.KEY_RELEASED, (KeyEvent ke) -> {
            if (ke.getCode().equals(KeyCode.ENTER)){
                nextFocusedField(ke);    //Traslado el ENFOQUE al siguiente Campo
            }
//            if (ke.isAltDown() && ke.getCode().equals(KeyCode.DIGIT1)){
//                botonNuevo();
//            }
//            if (ke.isAltDown() && ke.getCode().equals(KeyCode.DIGIT2)){
//                botonEditar();
//            }
//            if (ke.isAltDown() && ke.getCode().equals(KeyCode.DIGIT4)){
//                botonEliminar();
//            }
//            if (ke.isAltDown() && ke.getCode().equals(KeyCode.DIGIT5)){
//                botonImprimir();
//            }
//            if (ke.isAltDown() && ke.getCode().equals(KeyCode.DIGIT6)){
//                //CANCELAR
//                botonInicio();
//            }
//            if (ke.isAltDown() && ke.getCode().equals(KeyCode.B)){
//                botonBuscar();
//            }
        });
    }    
    
    /***************************************************************************/
    /***************************** PROCEDIMIENTOS ******************************/
    /***************************************************************************/
    
    /**
    * Metodo encargado de Crear e inicializar la Tabla de Datos
    */
    private void createTableGuide(){
        //Se crean y definen las columnas de la Tabla
        TableColumn col_orden       = new TableColumn("#");        
        TableColumn col_guide       = new TableColumn("Guia");
        TableColumn stat_guia       = new TableColumn("S");
        
        //Se establece el ancho de cada columna
        this.objectWidth(col_orden      , 22,  22); //30
        this.objectWidth(col_guide      , 54,  54); //65
        this.objectWidth(stat_guia      , 18,  18);

        col_guide.setCellFactory(TextFieldTableCell.forTableColumn());        

//        col_guide.setOnEditCommit(
//            new EventHandler<CellEditEvent<log_Guide_rel_inv, String>>() {
//                @Override
//                public void handle(CellEditEvent<log_Guide_rel_inv, String> t) {
//                    ((log_Guide_rel_inv) t.getTableView().getItems().get(
//                            t.getTablePosition().getRow())
//                            ).setGuias(t.getNewValue());
//                }
//            }
//        );
        
        stat_guia.setCellFactory(new Callback<TableColumn, TableCell>() {
            @Override
            public TableCell call(TableColumn param) {
                return new TableCell<log_Guide_rel_inv, Object>() {
                    @Override
                    public void updateItem(Object item, boolean empty) {
                        super.updateItem(item, empty);
                        setText(empty ? null : getString());
                        setAlignment(Pos.CENTER);
                    }

                    private String getString() {
                        String ret = "";
                        if (getItem() != null) {
                            ret = getItem().toString();

                            setTextFill(isSelected() ? Color.WHITE :
                                ret.equals("A") ? Color.RED : 
                                ret.equals("P") ? Color.GREEN : Color.BLUE);
                        } else {
                            ret = "";
                        }
                        return ret;
                    }                
                };
            }

//        @Override
//        protected void updateItem(Employee item, boolean empty) {
//            super.updateItem(item, empty);
//
//            if (item == null || empty) {
//                setGraphic(null);
//            } else {
//                btn.setStyle(item.getSalary() > 1000 ? "-fx-base:red" : "-fx-base: green");
//                btn.setText(item.getName() + "=" + item.getSalary());
//                setGraphic(btn);
//            }
//        }
//        firstTextCol.setCellFactory(new Callback<TableColumn, TableCell>() {
//            public TableCell call(TableColumn p) {
//                TableCell cell = new TableCell<Person, String>() {
//                    @Override
//                    public void updateItem(String item, boolean empty) {
//                        super.updateItem(item, empty);
//                        setText(empty ? null : getString());
//                        setGraphic(null);
//                    }
//
//                    private String getString() {
//                        return getItem() == null ? "" : getItem().toString();
//                    }
//                };
//
//                cell.setStyle("-fx-alignment: CENTER-LEFT;");
//                return cell;
//            }
//        });            
//        if (!isEmpty()) {
//            this.setTextFill(Color.RED);
//            // Get fancy and change color based on data
//            if(item.contains("@")) 
//                this.setTextFill(Color.BLUEVIOLET);
//            setText(item);
//        }
        });        

        //Se define la columna de la tabla con el nombre del atributo del objeto USUARIO correspondiente
        col_orden.setCellValueFactory( 
                new PropertyValueFactory<>("numorden") );
        col_guide.setCellValueFactory( 
                new PropertyValueFactory<>("guias") );
        stat_guia.setCellValueFactory( 
                new PropertyValueFactory<>("stat_guia") );
        
        //Se Asigna ordenadamente las columnas de la tabla
        tb_guias.getColumns().addAll(
                col_orden, col_guide, stat_guia
                );                
        
        //Se Asigna menu contextual 
        tb_guias.setRowFactory((TableView<xy> tableView) -> {
            final TableRow<xy> row = new TableRow<>();
            final ContextMenu contextMenu = new ContextMenu();
            final MenuItem removeMenuItem = new MenuItem("Anulada");
            final MenuItem slopeMenuItem = new MenuItem("Pendiente");
            final MenuItem completedMenuItem = new MenuItem("Completa");

            contextMenu.getItems().add(removeMenuItem);
            removeMenuItem.setOnAction((ActionEvent event) -> {
                switch (tipoOperacion){
                    case 1:
                        numFactCarga = numFactCarga - tb_guias.getItems().get(row.getIndex()).getNumfact();
                        numClieCarga = numClieCarga - tb_guias.getItems().get(row.getIndex()).getNumclie();

                        //tb_guias.getItems().remove(row.getItem());
                        tb_guias.getItems().remove(tb_guias.getSelectionModel().getSelectedIndex());

                        tp_factura.setText(
                            "Relación de Guias / Facturas / Clientes " + 
                            "               -          " + 
                            log_guide_guia.size() + " / " + 
                            numFactCarga + " / " + 
                            numClieCarga);

                        if ((tb_factura.getItems() != null) && (!tb_factura.getItems().isEmpty())){
                            tb_factura.getItems().clear(); 
                            tb_alm1.getItems().clear();
                            tb_alm2.getItems().clear();
                            tb_alm3.getItems().clear();
                            tb_alm4.getItems().clear();
                            tb_alm5.getItems().clear();
                            tb_alm6.getItems().clear();
                            tb_almp.getItems().clear();
                        }
                        break;
                    case 2:
                        if ((tb_guias.getItems().get(tb_guias.getSelectionModel().getSelectedIndex()).getStat_guia() == null)){
                            tb_guias.getItems().get(tb_guias.getSelectionModel().getSelectedIndex()).setStat_guia("A");
                            stat_guia.setVisible(false);
                            stat_guia.setVisible(true);
                        }
                        break;
                }
            });

            contextMenu.getItems().add(slopeMenuItem);
            slopeMenuItem.setOnAction((ActionEvent event) -> {
                switch (tipoOperacion){
                    case 2:
                        if ((tb_guias.getItems().get(tb_guias.getSelectionModel().getSelectedIndex()).getStat_guia() == null)){
                            tb_guias.getItems().get(tb_guias.getSelectionModel().getSelectedIndex()).setStat_guia("P");
                            stat_guia.setVisible(false);
                            stat_guia.setVisible(true);
                        }
                        break;
                }
            });

            contextMenu.getItems().add(completedMenuItem);
            completedMenuItem.setOnAction((ActionEvent event) -> {
                switch (tipoOperacion){
                    case 1:
                    case 2:
                        if ((tb_guias.getItems().get(tb_guias.getSelectionModel().getSelectedIndex()).getStat_guia().equals("P"))){
                            tb_guias.getItems().get(tb_guias.getSelectionModel().getSelectedIndex()).setStat_guia("C");
                            stat_guia.setVisible(false);
                            stat_guia.setVisible(true);
                        }
                        break;
                }
            });

            // Set context menu on row, but use a binding to make it only show for non-empty rows:
            row.contextMenuProperty().bind(
                Bindings.when(row.emptyProperty())
                    .then((ContextMenu)null)
                    .otherwise(contextMenu)
            );
            return row ;  
        });
        
        //Se define el comportamiento de las teclas ARRIBA y ABAJO en la tabla
        EventHandler eh = new EventHandler<KeyEvent>(){
            @Override
            public void handle(KeyEvent ke){
                //Si fue presionado la tecla ARRIBA o ABAJO
                if (ke.getCode().equals(KeyCode.UP) || ke.getCode().equals(KeyCode.DOWN)){     
                    //Selecciona la FILA enfocada
                    selectedRowGuide();
                }
            }
        };
        //Se Asigna el comportamiento para que se ejecute cuando se suelta una tecla
        tb_guias.setOnKeyReleased(eh);    

    }
    

    /**
    * Metodo encargado de Crear e inicializar la Tabla de Datos
    */
    private void createTableBill(){
        //Se crean y definen las columnas de la Tabla
        TableColumn col_orden       = new TableColumn("#");        
        TableColumn col_city        = new TableColumn("Ciudad");
        TableColumn col_codigo      = new TableColumn("Código");                
        TableColumn col_cliente     = new TableColumn("Cliente");        
        TableColumn col_fac_nc      = new TableColumn("FAC./NC.");        
        TableColumn col_fecha       = new TableColumn("Fecha");
        TableColumn col_monto       = new TableColumn("Monto");        
        TableColumn col_anulada     = new TableColumn("A");
        
        //Se establece el ancho de cada columna
        this.objectWidth(col_orden      , 25,  25);  
        this.objectWidth(col_city       , 90, 150);  
        this.objectWidth(col_codigo     , 86,  86); 
        this.objectWidth(col_cliente    , 165, 300); 
        this.objectWidth(col_fac_nc     , 70,  78);  
        this.objectWidth(col_fecha      , 68,  68);  
        this.objectWidth(col_monto      , 73,  73);  
        this.objectWidth(col_anulada    , 18,  18);

        col_fac_nc.setCellFactory(new Callback<TableColumn, TableCell>() {
            @Override
            public TableCell call(TableColumn param) {
                return new TableCell<Fxp_Archguip_det, String>() {
                    @Override
                    public void updateItem(String item, boolean empty) {
                        super.updateItem(item, empty);
                        setText(empty ? null : getString());
                        setAlignment(Pos.CENTER);
                    }

                    private String getString() {
                        String ret = "";
                        if (getItem() != null) {
                            ret = getItem().toString();
                            if (ret.equals("0"))
                                ret = "";
                        } else {
                            ret = "";
                        }
                        return ret;
                    }                
                };
            }
        });        

        col_fecha.setCellFactory(new Callback<TableColumn, TableCell>() {
            @Override
            public TableCell call(TableColumn param) {
                return new TableCell<Fxp_Archguip_det, Date>() {
                    @Override
                    public void updateItem(Date item, boolean empty) {
                        super.updateItem(item, empty);
                        if(!empty){
                            setText(item.toLocalDate().toString());
                            setAlignment(Pos.CENTER);
                        }
                        else
                            setText(null);
                    }
                };
            }
        });        

        col_monto.setCellFactory(new Callback<TableColumn, TableCell>() {
            @Override
            public TableCell call(TableColumn param) {
                return new TableCell<Fxp_Archguid, Double>() {
                    @Override
                    public void updateItem(Double item, boolean empty) {
                        super.updateItem(item, empty);
                        setText(empty ? null : getString());
                        setAlignment(Pos.CENTER_RIGHT);
                    }

                    private String getString() {
                        String ret = "";
                        if (getItem() != null) {
                            String gi = getItem().toString();
                            NumberFormat df = DecimalFormat.getInstance();
                            df.setMinimumFractionDigits(2);
                            df.setRoundingMode(RoundingMode.DOWN);

                            ret = df.format(Double.parseDouble(gi));
                        } else {
                            ret = "0,00";
                        }
                        return ret;
                    }                
                };
            }
        });        

        col_anulada.setCellFactory(new Callback<TableColumn, TableCell>() {
            @Override
            public TableCell call(TableColumn param) {
                return new TableCell<Fxp_Archguid, Integer>() {
                    @Override
                    public void updateItem(Integer item, boolean empty) {
                        super.updateItem(item, empty);
                        setText(empty ? null : getString());
                        setAlignment(Pos.CENTER);
                    }

                    private String getString() {
                        String ret = "";
                        if (getItem() != null) {
                            ret = getItem().toString();
                            if (ret.equals("0"))
                                ret = "";

                            setTextFill(isSelected() ? Color.WHITE :
                                ret.equals("0") ? Color.BLACK :
                                ret.equals("1") ? Color.RED : Color.GREEN);
                        } else {
                            ret = "";
                        }
                        return ret;
                    }                
                };
            }
        });        

        //Se define la columna de la tabla con el nombre del atributo del objeto USUARIO correspondiente
        col_orden.setCellValueFactory( 
                new PropertyValueFactory<>("orden") );
        col_city.setCellValueFactory( 
                new PropertyValueFactory<>("ciudad") );
        col_codigo.setCellValueFactory( 
                new PropertyValueFactory<>("codigo") );
        col_cliente.setCellValueFactory( 
                new PropertyValueFactory<>("cliente") );
        col_fac_nc.setCellValueFactory( 
                new PropertyValueFactory<>("numdocs") );
        col_fecha.setCellValueFactory( 
                new PropertyValueFactory<>("fecdoc") );
        col_monto.setCellValueFactory( 
                new PropertyValueFactory<>("monto") );
        col_anulada.setCellValueFactory( 
                new PropertyValueFactory<>("anulada") );
        
        //Se Asigna ordenadamente las columnas de la tabla
        tb_factura.getColumns().addAll(
                col_orden, col_city, col_codigo, col_cliente, col_fac_nc, col_fecha, 
                col_monto, col_anulada 
                );                
        
        //Se Asigna menu contextual 
        tb_factura.setRowFactory((TableView<Fxp_Archguid> tableView) -> {
            final TableRow<Fxp_Archguid> row = new TableRow<>();
            final ContextMenu contextMenu = new ContextMenu();
            final MenuItem removeMenuItem = new MenuItem("Anular Factura");
            removeMenuItem.setOnAction((ActionEvent event) -> {
                switch (tipoOperacion){
                    case 1:
                        tb_factura.getItems().remove(tb_factura.getSelectionModel().getSelectedIndex());
                        break;
                    case 2:
                        tb_factura.getItems().get(tb_factura.getSelectionModel().getSelectedIndex()).setAnulada(1);
                        col_anulada.setVisible(false);
                        col_anulada.setVisible(true);
                        break;
                }
            });
            contextMenu.getItems().add(removeMenuItem);
            // Set context menu on row, but use a binding to make it only show for non-empty rows:
            row.contextMenuProperty().bind(
                Bindings.when(row.emptyProperty())
                    .then((ContextMenu)null)
                    .otherwise(contextMenu)
            );
            return row ;  
        });
        
        //Se define el comportamiento de las teclas ARRIBA y ABAJO en la tabla
        EventHandler eh = new EventHandler<KeyEvent>(){
            @Override
            public void handle(KeyEvent ke){
                //Si fue presionado la tecla ARRIBA o ABAJO
                if (ke.getCode().equals(KeyCode.UP) || ke.getCode().equals(KeyCode.DOWN)){     
                    //Selecciona la FILA enfocada
                    selectedRowInvoice();
                }
            }
        };
        //Se Asigna el comportamiento para que se ejecute cuando se suelta una tecla
        tb_factura.setOnKeyReleased(eh);    
    }

    
    /**
    * Metodo encargado de Crear e inicializar la Tabla de Datos
    */
    private void createTableCredit(){
        //Se crean y definen las columnas de la Tabla
        TableColumn col_orden       = new TableColumn("#");        
        TableColumn col_city        = new TableColumn("Ciudad");
        TableColumn col_codigo      = new TableColumn("Código");                
        TableColumn col_cliente     = new TableColumn("Cliente");        
        TableColumn col_fac_nc      = new TableColumn("FAC./NC.");        
        TableColumn col_numguia     = new TableColumn("Guia");        
        TableColumn col_fecha       = new TableColumn("Fecha");
        TableColumn col_cant        = new TableColumn("Cant.");        
        
        //Se establece el ancho de cada columna
        this.objectWidth(col_orden      , 22,  20);
        this.objectWidth(col_city       , 80, 150);
        this.objectWidth(col_codigo     , 82,  86);
        this.objectWidth(col_cliente    , 170, 300); //180
        this.objectWidth(col_fac_nc     , 62,  70);
        this.objectWidth(col_numguia    , 58,  60);
        this.objectWidth(col_fecha      , 68,  68);
        this.objectWidth(col_cant       , 48,  48); //38

        col_fac_nc.setCellFactory(new Callback<TableColumn, TableCell>() {
            @Override
            public TableCell call(TableColumn param) {
                return new TableCell<Fxp_Archguid, String>() {
                    @Override
                    public void updateItem(String item, boolean empty) {
                        super.updateItem(item, empty);
                        setText(empty ? null : getString());
                        setAlignment(Pos.CENTER);
                    }

                    private String getString() {
                        String ret = "";
                        if (getItem() != null) {
                            ret = getItem().toString();
                            if (ret.equals("0"))
                                ret = "";
                        } else {
                            ret = "";
                        }
                        return ret;
                    }                
                };
            }
        });        

        col_fecha.setCellFactory(new Callback<TableColumn, TableCell>() {
            @Override
            public TableCell call(TableColumn param) {
                return new TableCell<Fxp_Archguid, Date>() {
                    @Override
                    public void updateItem(Date item, boolean empty) {
                        super.updateItem(item, empty);
                        if(!empty){
                            setText(item.toLocalDate().toString());
                            setAlignment(Pos.CENTER);
                        }
                        else
                            setText(null);
                    }
                };
            }
        });        

        col_numguia.setCellFactory(new Callback<TableColumn, TableCell>() {
            @Override
            public TableCell call(TableColumn param) {
                return new TableCell<Fxp_Archguid, Integer>() {
                    @Override
                    public void updateItem(Integer item, boolean empty) {
                        super.updateItem(item, empty);
                        setText(empty ? null : getString());
                        setAlignment(Pos.CENTER);
                    }

                    private String getString() {
                        String ret = "";
                        if (getItem() != null) {
                            ret = getItem().toString();
                            if (ret.equals("0"))
                                ret = "";
                        } else {
                            ret = "";
                        }
                        return ret;
                    }                
                };
            }
        });        


        col_cant.setCellFactory(new Callback<TableColumn, TableCell>() {
            @Override
            public TableCell call(TableColumn param) {
                return new TableCell<Fxp_Archguid, String>() {
                    @Override
                    public void updateItem(String item, boolean empty) {
                        super.updateItem(item, empty);
                        setText(empty ? null : getString());
                        setAlignment(Pos.CENTER);
                    }

                    private String getString() {
                        String ret = "";
                        if (getItem() != null) {
                            ret = getItem().toString();
                            if (ret.equals("0"))
                                ret = "";
                        } else {
                            ret = "";
                        }
                        return ret;
                    }                
                };
            }
        });        

        //Se define la columna de la tabla con el nombre del atributo del objeto USUARIO correspondiente
        col_orden.setCellValueFactory( 
                new PropertyValueFactory<>("orden") );
        col_city.setCellValueFactory( 
                new PropertyValueFactory<>("ciudad") );
        col_codigo.setCellValueFactory( 
                new PropertyValueFactory<>("codigo") );
        col_cliente.setCellValueFactory( 
                new PropertyValueFactory<>("cliente") );
        col_fac_nc.setCellValueFactory( 
                new PropertyValueFactory<>("numdocs") );
        col_numguia.setCellValueFactory( 
                new PropertyValueFactory<>("numguia") );
        col_fecha.setCellValueFactory( 
                new PropertyValueFactory<>("fecdoc") );
        col_cant.setCellValueFactory( 
                new PropertyValueFactory<>("SCantFact") );
        
        //Se Asigna ordenadamente las columnas de la tabla
        tb_credit.getColumns().addAll(
                col_orden, col_city, col_codigo, col_cliente, col_fac_nc, col_numguia, 
                col_fecha, col_cant
                );                
        
        //Se Asigna menu contextual 
        tb_credit.setRowFactory((TableView<Fxp_Archguid> tableView) -> {
            final TableRow<Fxp_Archguid> row = new TableRow<>();
            final ContextMenu contextMenu = new ContextMenu();
            final MenuItem numGuideMenuItem = new MenuItem("Copiar Guia");
            numGuideMenuItem.setOnAction((ActionEvent event) -> {
                tf_nrocguia.setText(String.valueOf(((Fxp_Archguid) tb_credit.getItems().get(tb_credit.getSelectionModel().getSelectedIndex())).getNumguia()));
                tf_nrocguia.requestFocus();
            });
            contextMenu.getItems().add(numGuideMenuItem);
            // Set context menu on row, but use a binding to make it only show for non-empty rows:
            row.contextMenuProperty().bind(
                    Bindings.when(row.emptyProperty())
                            .then((ContextMenu)null)
                            .otherwise(contextMenu)
            );
            return row ;  
        });
        
        //Se define el comportamiento de las teclas ARRIBA y ABAJO en la tabla
        EventHandler eh = new EventHandler<KeyEvent>(){
            @Override
            public void handle(KeyEvent ke){
                //Si fue presionado la tecla ARRIBA o ABAJO
                if (ke.getCode().equals(KeyCode.UP) || ke.getCode().equals(KeyCode.DOWN)){     
                    //Selecciona la FILA enfocada
//                    selectedRow();
                }
            }
        };
        //Se Asigna el comportamiento para que se ejecute cuando se suelta una tecla
        tb_credit.setOnKeyReleased(eh);    
    }

    
    /**
    * Metodo encargado de Crear e inicializar la Tabla de Datos
    */
    private void createTableStock1(){
        //Se crean y definen las columnas de la Tabla
        TableColumn col_orden       = new TableColumn("#");        
        TableColumn col_codigo      = new TableColumn("Código");                
        TableColumn col_unidad      = new TableColumn("Unidad");        
        TableColumn col_descrip     = new TableColumn("Descripción");        
        TableColumn col_cant        = new TableColumn("Cant.");
        TableColumn col_peso        = new TableColumn("Peso");        
        
        //Se establece el ancho de cada columna
        this.objectWidth(col_orden      , 30,  30);
        this.objectWidth(col_codigo     , 55,  55);
        this.objectWidth(col_unidad     , 85,  85);
        this.objectWidth(col_descrip    , 220, 250);
        this.objectWidth(col_cant       , 55,  55);
        this.objectWidth(col_peso       , 45,  45);

        col_codigo.setCellFactory(new Callback<TableColumn, TableCell>() {
            @Override
            public TableCell call(TableColumn param) {
                return new TableCell<Fxp_Archguip_det, String>() {
                    @Override
                    public void updateItem(String item, boolean empty) {
                        super.updateItem(item, empty);
                        setText(empty ? null : getString());
                        setAlignment(Pos.CENTER);
                    }

                    private String getString() {
                        String ret = "";
                        if (getItem() != null) {
                            ret = getItem().toString();
                            if (ret.equals("0"))
                                ret = "";
                        } else {
                            ret = "";
                        }
                        return ret;
                    }                
                };
            }
        });        

        col_cant.setCellFactory(new Callback<TableColumn, TableCell>() {
            @Override
            public TableCell call(TableColumn param) {
                return new TableCell<Fxp_Archguip_det, String>() {
                    @Override
                    public void updateItem(String item, boolean empty) {
                        super.updateItem(item, empty);
                        setText(empty ? null : getString());
                        setAlignment(Pos.CENTER);
                    }

                    private String getString() {
                        String ret = "";
                        if (getItem() != null) {
                            ret = getItem().toString();
                            if (ret.equals("0"))
                                ret = "";
                        } else {
                            ret = "";
                        }
                        return ret;
                    }                
                };
            }
        });        

        col_peso.setCellFactory(new Callback<TableColumn, TableCell>() {
            @Override
            public TableCell call(TableColumn param) {
                return new TableCell<Fxp_Archguip_det, Double>() {
                    @Override
                    public void updateItem(Double item, boolean empty) {
                        super.updateItem(item, empty);
                        setText(empty ? null : getString());
                        setAlignment(Pos.CENTER);
                    }

                    private String getString() {
                        String ret = "";
                        if (getItem() != null) {
                            String gi = getItem().toString();
                            NumberFormat df = DecimalFormat.getInstance();
                            df.setMinimumFractionDigits(2);
                            df.setRoundingMode(RoundingMode.DOWN);

                            ret = df.format(Double.parseDouble(gi));
                        } else {
                            ret = "0,00";
                        }
                        return ret;
                    }                
                };
            }
        });        

        //Se define la columna de la tabla con el nombre del atributo del objeto USUARIO correspondiente
        col_orden.setCellValueFactory( 
                new PropertyValueFactory<>("orden") );
        col_codigo.setCellValueFactory( 
                new PropertyValueFactory<>("codigo") );
        col_unidad.setCellValueFactory( 
                new PropertyValueFactory<>("unidad") );
        col_descrip.setCellValueFactory( 
                new PropertyValueFactory<>("descrip") );
        col_cant.setCellValueFactory( 
                new PropertyValueFactory<>("cantidad") );
        col_peso.setCellValueFactory( 
                new PropertyValueFactory<>("pesokgs") );
        
        //Se Asigna ordenadamente las columnas de la tabla
        tb_alm1.getColumns().addAll(
                col_orden, col_codigo, col_unidad, col_descrip, col_cant, 
                col_peso 
                );                
        
        //Se define el comportamiento de las teclas ARRIBA y ABAJO en la tabla
        EventHandler eh = new EventHandler<KeyEvent>(){
            @Override
            public void handle(KeyEvent ke){
                //Si fue presionado la tecla ARRIBA o ABAJO
                if (ke.getCode().equals(KeyCode.UP) || ke.getCode().equals(KeyCode.DOWN)){     
                    //Selecciona la FILA enfocada
                }
            }
        };
        //Se Asigna el comportamiento para que se ejecute cuando se suelta una tecla
        tb_alm1.setOnKeyReleased(eh);    
    }

    
    /**
    * Metodo encargado de Crear e inicializar la Tabla de Datos
    */
    private void createTableStock1s(){
        //Se crean y definen las columnas de la Tabla
        TableColumn col_orden       = new TableColumn("#");        
        TableColumn col_unidad      = new TableColumn("Unid.");        
        TableColumn col_cant        = new TableColumn("Cant.");
        
        //Se establece el ancho de cada columna
        this.objectWidth(col_orden      , 30,  30);
        this.objectWidth(col_unidad     , 42,  42);
        this.objectWidth(col_cant       , 42,  42);

        col_unidad.setCellFactory(new Callback<TableColumn, TableCell>() {
            @Override
            public TableCell call(TableColumn param) {
                return new TableCell<Fxp_Archguip_sum, String>() {
                    @Override
                    public void updateItem(String item, boolean empty) {
                        super.updateItem(item, empty);
                        setText(empty ? null : getString());
                        setAlignment(Pos.CENTER);
                    }

                    private String getString() {
                        String ret = "";
                        if (getItem() != null) {
                            ret = getItem().toString();
                            if (ret.equals("0"))
                                ret = "";
                        } else {
                            ret = "";
                        }
                        return ret;
                    }                
                };
            }
        });        

        col_cant.setCellFactory(new Callback<TableColumn, TableCell>() {
            @Override
            public TableCell call(TableColumn param) {
                return new TableCell<Fxp_Archguip_sum, Integer>() {
                    @Override
                    public void updateItem(Integer item, boolean empty) {
                        super.updateItem(item, empty);
                        setText(empty ? null : getString());
                        setAlignment(Pos.CENTER);
                    }

                    private String getString() {
                        String ret = "";
                        if (getItem() != null) {
                            ret = getItem().toString();
                            if (ret.equals("0"))
                                ret = "";
                        } else {
                            ret = "";
                        }
                        return ret;
                    }                
                };
            }
        });        

        //Se define la columna de la tabla con el nombre del atributo del objeto USUARIO correspondiente
        col_orden.setCellValueFactory( 
                new PropertyValueFactory<>("orden") );
        col_unidad.setCellValueFactory( 
                new PropertyValueFactory<>("uniddesp") );
        col_cant.setCellValueFactory( 
                new PropertyValueFactory<>("cantdesp") );
        
        //Se Asigna ordenadamente las columnas de la tabla
        tb_alm1s.getColumns().addAll(
                col_cant, col_unidad
                );                
        
        //Se define el comportamiento de las teclas ARRIBA y ABAJO en la tabla
        EventHandler eh = new EventHandler<KeyEvent>(){
            @Override
            public void handle(KeyEvent ke){
                //Si fue presionado la tecla ARRIBA o ABAJO
                if (ke.getCode().equals(KeyCode.UP) || ke.getCode().equals(KeyCode.DOWN)){     
                    //Selecciona la FILA enfocada
                }
            }
        };
        //Se Asigna el comportamiento para que se ejecute cuando se suelta una tecla
        tb_alm1s.setOnKeyReleased(eh);    
    }

    
    /**
    * Metodo encargado de Crear e inicializar la Tabla de Datos
    */
    private void createTableStock2(){
        //Se crean y definen las columnas de la Tabla
        TableColumn col_orden       = new TableColumn("#");        
        TableColumn col_codigo      = new TableColumn("Código");                
        TableColumn col_unidad      = new TableColumn("Unidad");        
        TableColumn col_descrip     = new TableColumn("Descripción");        
        TableColumn col_cant        = new TableColumn("Cant.");
        TableColumn col_peso        = new TableColumn("Peso");        
        
        //Se establece el ancho de cada columna
        this.objectWidth(col_orden      , 30,  30);
        this.objectWidth(col_codigo     , 55,  55);
        this.objectWidth(col_unidad     , 85,  85);
        this.objectWidth(col_descrip    , 220, 250);
        this.objectWidth(col_cant       , 55,  55);
        this.objectWidth(col_peso       , 45,  45);

        col_codigo.setCellFactory(new Callback<TableColumn, TableCell>() {
            @Override
            public TableCell call(TableColumn param) {
                return new TableCell<Fxp_Archguip_det, String>() {
                    @Override
                    public void updateItem(String item, boolean empty) {
                        super.updateItem(item, empty);
                        setText(empty ? null : getString());
                        setAlignment(Pos.CENTER);
                    }

                    private String getString() {
                        String ret = "";
                        if (getItem() != null) {
                            ret = getItem().toString();
                            if (ret.equals("0"))
                                ret = "";
                        } else {
                            ret = "";
                        }
                        return ret;
                    }                
                };
            }
        });        

        col_cant.setCellFactory(new Callback<TableColumn, TableCell>() {
            @Override
            public TableCell call(TableColumn param) {
                return new TableCell<Fxp_Archguip_det, String>() {
                    @Override
                    public void updateItem(String item, boolean empty) {
                        super.updateItem(item, empty);
                        setText(empty ? null : getString());
                        setAlignment(Pos.CENTER);
                    }

                    private String getString() {
                        String ret = "";
                        if (getItem() != null) {
                            ret = getItem().toString();
                            if (ret.equals("0"))
                                ret = "";
                        } else {
                            ret = "";
                        }
                        return ret;
                    }                
                };
            }
        });        

        col_peso.setCellFactory(new Callback<TableColumn, TableCell>() {
            @Override
            public TableCell call(TableColumn param) {
                return new TableCell<Fxp_Archguip_det, Double>() {
                    @Override
                    public void updateItem(Double item, boolean empty) {
                        super.updateItem(item, empty);
                        setText(empty ? null : getString());
                        setAlignment(Pos.CENTER);
                    }

                    private String getString() {
                        String ret = "";
                        if (getItem() != null) {
                            String gi = getItem().toString();
                            NumberFormat df = DecimalFormat.getInstance();
                            df.setMinimumFractionDigits(2);
                            df.setRoundingMode(RoundingMode.DOWN);

                            ret = df.format(Double.parseDouble(gi));
                        } else {
                            ret = "0,00";
                        }
                        return ret;
                    }                
                };
            }
        });        

        //Se define la columna de la tabla con el nombre del atributo del objeto USUARIO correspondiente
        col_orden.setCellValueFactory( 
                new PropertyValueFactory<>("orden") );
        col_codigo.setCellValueFactory( 
                new PropertyValueFactory<>("codigo") );
        col_unidad.setCellValueFactory( 
                new PropertyValueFactory<>("unidad") );
        col_descrip.setCellValueFactory( 
                new PropertyValueFactory<>("descrip") );
        col_cant.setCellValueFactory( 
                new PropertyValueFactory<>("cantidad") );
        col_peso.setCellValueFactory( 
                new PropertyValueFactory<>("pesokgs") );
        
        //Se Asigna ordenadamente las columnas de la tabla
        tb_alm2.getColumns().addAll(
                col_orden, col_codigo, col_unidad, col_descrip, col_cant, 
                col_peso 
                );                
        
        //Se define el comportamiento de las teclas ARRIBA y ABAJO en la tabla
        EventHandler eh = new EventHandler<KeyEvent>(){
            @Override
            public void handle(KeyEvent ke){
                //Si fue presionado la tecla ARRIBA o ABAJO
                if (ke.getCode().equals(KeyCode.UP) || ke.getCode().equals(KeyCode.DOWN)){     
                    //Selecciona la FILA enfocada
                }
            }
        };
        //Se Asigna el comportamiento para que se ejecute cuando se suelta una tecla
        tb_alm2.setOnKeyReleased(eh);    
    }

    
    /**
    * Metodo encargado de Crear e inicializar la Tabla de Datos
    */
    private void createTableStock2s(){
        //Se crean y definen las columnas de la Tabla
        TableColumn col_orden       = new TableColumn("#");        
        TableColumn col_unidad      = new TableColumn("Unid.");        
        TableColumn col_cant        = new TableColumn("Cant.");
        
        //Se establece el ancho de cada columna
        this.objectWidth(col_orden      , 30,  30);
        this.objectWidth(col_unidad     , 42,  42);
        this.objectWidth(col_cant       , 42,  42);

        col_unidad.setCellFactory(new Callback<TableColumn, TableCell>() {
            @Override
            public TableCell call(TableColumn param) {
                return new TableCell<Fxp_Archguip_sum, String>() {
                    @Override
                    public void updateItem(String item, boolean empty) {
                        super.updateItem(item, empty);
                        setText(empty ? null : getString());
                        setAlignment(Pos.CENTER);
                    }

                    private String getString() {
                        String ret = "";
                        if (getItem() != null) {
                            ret = getItem().toString();
                            if (ret.equals("0"))
                                ret = "";
                        } else {
                            ret = "";
                        }
                        return ret;
                    }                
                };
            }
        });        

        col_cant.setCellFactory(new Callback<TableColumn, TableCell>() {
            @Override
            public TableCell call(TableColumn param) {
                return new TableCell<Fxp_Archguip_sum, Integer>() {
                    @Override
                    public void updateItem(Integer item, boolean empty) {
                        super.updateItem(item, empty);
                        setText(empty ? null : getString());
                        setAlignment(Pos.CENTER);
                    }

                    private String getString() {
                        String ret = "";
                        if (getItem() != null) {
                            ret = getItem().toString();
                            if (ret.equals("0"))
                                ret = "";
                        } else {
                            ret = "";
                        }
                        return ret;
                    }                
                };
            }
        });        

        //Se define la columna de la tabla con el nombre del atributo del objeto USUARIO correspondiente
        col_orden.setCellValueFactory( 
                new PropertyValueFactory<>("orden") );
        col_unidad.setCellValueFactory( 
                new PropertyValueFactory<>("uniddesp") );
        col_cant.setCellValueFactory( 
                new PropertyValueFactory<>("cantdesp") );
        
        //Se Asigna ordenadamente las columnas de la tabla
        tb_alm2s.getColumns().addAll(
                col_cant, col_unidad
                );                
        
        //Se define el comportamiento de las teclas ARRIBA y ABAJO en la tabla
        EventHandler eh = new EventHandler<KeyEvent>(){
            @Override
            public void handle(KeyEvent ke){
                //Si fue presionado la tecla ARRIBA o ABAJO
                if (ke.getCode().equals(KeyCode.UP) || ke.getCode().equals(KeyCode.DOWN)){     
                    //Selecciona la FILA enfocada
                }
            }
        };
        //Se Asigna el comportamiento para que se ejecute cuando se suelta una tecla
        tb_alm2s.setOnKeyReleased(eh);    
    }

    
    /**
    * Metodo encargado de Crear e inicializar la Tabla de Datos
    */
    private void createTableStock3(){
        //Se crean y definen las columnas de la Tabla
        TableColumn col_orden       = new TableColumn("#");        
        TableColumn col_codigo      = new TableColumn("Código");                
        TableColumn col_unidad      = new TableColumn("Unidad");        
        TableColumn col_descrip     = new TableColumn("Descripción");        
        TableColumn col_cant        = new TableColumn("Cant.");
        TableColumn col_peso        = new TableColumn("Peso");        
        
        //Se establece el ancho de cada columna
        this.objectWidth(col_orden      , 30,  30);
        this.objectWidth(col_codigo     , 55,  55);
        this.objectWidth(col_unidad     , 85,  85);
        this.objectWidth(col_descrip    , 220, 250);
        this.objectWidth(col_cant       , 55,  55);
        this.objectWidth(col_peso       , 45,  45);

        col_codigo.setCellFactory(new Callback<TableColumn, TableCell>() {
            @Override
            public TableCell call(TableColumn param) {
                return new TableCell<Fxp_Archguip_det, String>() {
                    @Override
                    public void updateItem(String item, boolean empty) {
                        super.updateItem(item, empty);
                        setText(empty ? null : getString());
                        setAlignment(Pos.CENTER);
                    }

                    private String getString() {
                        String ret = "";
                        if (getItem() != null) {
                            ret = getItem().toString();
                            if (ret.equals("0"))
                                ret = "";
                        } else {
                            ret = "";
                        }
                        return ret;
                    }                
                };
            }
        });        

        col_cant.setCellFactory(new Callback<TableColumn, TableCell>() {
            @Override
            public TableCell call(TableColumn param) {
                return new TableCell<Fxp_Archguip_det, String>() {
                    @Override
                    public void updateItem(String item, boolean empty) {
                        super.updateItem(item, empty);
                        setText(empty ? null : getString());
                        setAlignment(Pos.CENTER);
                    }

                    private String getString() {
                        String ret = "";
                        if (getItem() != null) {
                            ret = getItem().toString();
                            if (ret.equals("0"))
                                ret = "";
                        } else {
                            ret = "";
                        }
                        return ret;
                    }                
                };
            }
        });        

        col_peso.setCellFactory(new Callback<TableColumn, TableCell>() {
            @Override
            public TableCell call(TableColumn param) {
                return new TableCell<Fxp_Archguip_det, Double>() {
                    @Override
                    public void updateItem(Double item, boolean empty) {
                        super.updateItem(item, empty);
                        setText(empty ? null : getString());
                        setAlignment(Pos.CENTER);
                    }

                    private String getString() {
                        String ret = "";
                        if (getItem() != null) {
                            String gi = getItem().toString();
                            NumberFormat df = DecimalFormat.getInstance();
                            df.setMinimumFractionDigits(2);
                            df.setRoundingMode(RoundingMode.DOWN);

                            ret = df.format(Double.parseDouble(gi));
                        } else {
                            ret = "0,00";
                        }
                        return ret;
                    }                
                };
            }
        });        

        //Se define la columna de la tabla con el nombre del atributo del objeto USUARIO correspondiente
        col_orden.setCellValueFactory( 
                new PropertyValueFactory<>("orden") );
        col_codigo.setCellValueFactory( 
                new PropertyValueFactory<>("codigo") );
        col_unidad.setCellValueFactory( 
                new PropertyValueFactory<>("unidad") );
        col_descrip.setCellValueFactory( 
                new PropertyValueFactory<>("descrip") );
        col_cant.setCellValueFactory( 
                new PropertyValueFactory<>("cantidad") );
        col_peso.setCellValueFactory( 
                new PropertyValueFactory<>("pesokgs") );
        
        //Se Asigna ordenadamente las columnas de la tabla
        tb_alm3.getColumns().addAll(
                col_orden, col_codigo, col_unidad, col_descrip, col_cant, 
                col_peso 
                );                
        
        //Se define el comportamiento de las teclas ARRIBA y ABAJO en la tabla
        EventHandler eh = new EventHandler<KeyEvent>(){
            @Override
            public void handle(KeyEvent ke){
                //Si fue presionado la tecla ARRIBA o ABAJO
                if (ke.getCode().equals(KeyCode.UP) || ke.getCode().equals(KeyCode.DOWN)){     
                    //Selecciona la FILA enfocada
                }
            }
        };
        //Se Asigna el comportamiento para que se ejecute cuando se suelta una tecla
        tb_alm3.setOnKeyReleased(eh);    
    }

    
    /**
    * Metodo encargado de Crear e inicializar la Tabla de Datos
    */
    private void createTableStock3s(){
        //Se crean y definen las columnas de la Tabla
        TableColumn col_orden       = new TableColumn("#");        
        TableColumn col_unidad      = new TableColumn("Unid.");        
        TableColumn col_cant        = new TableColumn("Cant.");
        
        //Se establece el ancho de cada columna
        this.objectWidth(col_orden      , 30,  30);
        this.objectWidth(col_unidad     , 42,  42);
        this.objectWidth(col_cant       , 42,  42);

        col_unidad.setCellFactory(new Callback<TableColumn, TableCell>() {
            @Override
            public TableCell call(TableColumn param) {
                return new TableCell<Fxp_Archguip_sum, String>() {
                    @Override
                    public void updateItem(String item, boolean empty) {
                        super.updateItem(item, empty);
                        setText(empty ? null : getString());
                        setAlignment(Pos.CENTER);
                    }

                    private String getString() {
                        String ret = "";
                        if (getItem() != null) {
                            ret = getItem().toString();
                            if (ret.equals("0"))
                                ret = "";
                        } else {
                            ret = "";
                        }
                        return ret;
                    }                
                };
            }
        });        

        col_cant.setCellFactory(new Callback<TableColumn, TableCell>() {
            @Override
            public TableCell call(TableColumn param) {
                return new TableCell<Fxp_Archguip_sum, Integer>() {
                    @Override
                    public void updateItem(Integer item, boolean empty) {
                        super.updateItem(item, empty);
                        setText(empty ? null : getString());
                        setAlignment(Pos.CENTER);
                    }

                    private String getString() {
                        String ret = "";
                        if (getItem() != null) {
                            ret = getItem().toString();
                            if (ret.equals("0"))
                                ret = "";
                        } else {
                            ret = "";
                        }
                        return ret;
                    }                
                };
            }
        });        

        //Se define la columna de la tabla con el nombre del atributo del objeto USUARIO correspondiente
        col_orden.setCellValueFactory( 
                new PropertyValueFactory<>("orden") );
        col_unidad.setCellValueFactory( 
                new PropertyValueFactory<>("uniddesp") );
        col_cant.setCellValueFactory( 
                new PropertyValueFactory<>("cantdesp") );
        
        //Se Asigna ordenadamente las columnas de la tabla
        tb_alm3s.getColumns().addAll(
                col_cant, col_unidad
                );                
        
        //Se define el comportamiento de las teclas ARRIBA y ABAJO en la tabla
        EventHandler eh = new EventHandler<KeyEvent>(){
            @Override
            public void handle(KeyEvent ke){
                //Si fue presionado la tecla ARRIBA o ABAJO
                if (ke.getCode().equals(KeyCode.UP) || ke.getCode().equals(KeyCode.DOWN)){     
                    //Selecciona la FILA enfocada
                }
            }
        };
        //Se Asigna el comportamiento para que se ejecute cuando se suelta una tecla
        tb_alm3s.setOnKeyReleased(eh);    
    }

    
    /**
    * Metodo encargado de Crear e inicializar la Tabla de Datos
    */
    private void createTableStock4(){
        //Se crean y definen las columnas de la Tabla
        TableColumn col_orden       = new TableColumn("#");        
        TableColumn col_codigo      = new TableColumn("Código");                
        TableColumn col_unidad      = new TableColumn("Unidad");        
        TableColumn col_descrip     = new TableColumn("Descripción");        
        TableColumn col_cant        = new TableColumn("Cant.");
        TableColumn col_peso        = new TableColumn("Peso");        
        
        //Se establece el ancho de cada columna
        this.objectWidth(col_orden      , 30,  30);
        this.objectWidth(col_codigo     , 55,  55);
        this.objectWidth(col_unidad     , 85,  85);
        this.objectWidth(col_descrip    , 220, 250);
        this.objectWidth(col_cant       , 55,  55);
        this.objectWidth(col_peso       , 45,  45);

        col_codigo.setCellFactory(new Callback<TableColumn, TableCell>() {
            @Override
            public TableCell call(TableColumn param) {
                return new TableCell<Fxp_Archguip_det, String>() {
                    @Override
                    public void updateItem(String item, boolean empty) {
                        super.updateItem(item, empty);
                        setText(empty ? null : getString());
                        setAlignment(Pos.CENTER);
                    }

                    private String getString() {
                        String ret = "";
                        if (getItem() != null) {
                            ret = getItem().toString();
                            if (ret.equals("0"))
                                ret = "";
                        } else {
                            ret = "";
                        }
                        return ret;
                    }                
                };
            }
        });        

        col_cant.setCellFactory(new Callback<TableColumn, TableCell>() {
            @Override
            public TableCell call(TableColumn param) {
                return new TableCell<Fxp_Archguip_det, String>() {
                    @Override
                    public void updateItem(String item, boolean empty) {
                        super.updateItem(item, empty);
                        setText(empty ? null : getString());
                        setAlignment(Pos.CENTER);
                    }

                    private String getString() {
                        String ret = "";
                        if (getItem() != null) {
                            ret = getItem().toString();
                            if (ret.equals("0"))
                                ret = "";
                        } else {
                            ret = "";
                        }
                        return ret;
                    }                
                };
            }
        });        

        col_peso.setCellFactory(new Callback<TableColumn, TableCell>() {
            @Override
            public TableCell call(TableColumn param) {
                return new TableCell<Fxp_Archguip_det, Double>() {
                    @Override
                    public void updateItem(Double item, boolean empty) {
                        super.updateItem(item, empty);
                        setText(empty ? null : getString());
                        setAlignment(Pos.CENTER);
                    }

                    private String getString() {
                        String ret = "";
                        if (getItem() != null) {
                            String gi = getItem().toString();
                            NumberFormat df = DecimalFormat.getInstance();
                            df.setMinimumFractionDigits(2);
                            df.setRoundingMode(RoundingMode.DOWN);

                            ret = df.format(Double.parseDouble(gi));
                        } else {
                            ret = "0,00";
                        }
                        return ret;
                    }                
                };
            }
        });        

        //Se define la columna de la tabla con el nombre del atributo del objeto USUARIO correspondiente
        col_orden.setCellValueFactory( 
                new PropertyValueFactory<>("orden") );
        col_codigo.setCellValueFactory( 
                new PropertyValueFactory<>("codigo") );
        col_unidad.setCellValueFactory( 
                new PropertyValueFactory<>("unidad") );
        col_descrip.setCellValueFactory( 
                new PropertyValueFactory<>("descrip") );
        col_cant.setCellValueFactory( 
                new PropertyValueFactory<>("cantidad") );
        col_peso.setCellValueFactory( 
                new PropertyValueFactory<>("pesokgs") );
        
        //Se Asigna ordenadamente las columnas de la tabla
        tb_alm4.getColumns().addAll(
                col_orden, col_codigo, col_unidad, col_descrip, col_cant, 
                col_peso 
                );                
        
        //Se define el comportamiento de las teclas ARRIBA y ABAJO en la tabla
        EventHandler eh = new EventHandler<KeyEvent>(){
            @Override
            public void handle(KeyEvent ke){
                //Si fue presionado la tecla ARRIBA o ABAJO
                if (ke.getCode().equals(KeyCode.UP) || ke.getCode().equals(KeyCode.DOWN)){     
                    //Selecciona la FILA enfocada
                }
            }
        };
        //Se Asigna el comportamiento para que se ejecute cuando se suelta una tecla
        tb_alm4.setOnKeyReleased(eh);    
    }

    
    /**
    * Metodo encargado de Crear e inicializar la Tabla de Datos
    */
    private void createTableStock4s(){
        //Se crean y definen las columnas de la Tabla
        TableColumn col_orden       = new TableColumn("#");        
        TableColumn col_unidad      = new TableColumn("Unid.");        
        TableColumn col_cant        = new TableColumn("Cant.");
        
        //Se establece el ancho de cada columna
        this.objectWidth(col_orden      , 30,  30);
        this.objectWidth(col_unidad     , 42,  42);
        this.objectWidth(col_cant       , 42,  42);

        col_unidad.setCellFactory(new Callback<TableColumn, TableCell>() {
            @Override
            public TableCell call(TableColumn param) {
                return new TableCell<Fxp_Archguip_sum, String>() {
                    @Override
                    public void updateItem(String item, boolean empty) {
                        super.updateItem(item, empty);
                        setText(empty ? null : getString());
                        setAlignment(Pos.CENTER);
                    }

                    private String getString() {
                        String ret = "";
                        if (getItem() != null) {
                            ret = getItem().toString();
                            if (ret.equals("0"))
                                ret = "";
                        } else {
                            ret = "";
                        }
                        return ret;
                    }                
                };
            }
        });        

        col_cant.setCellFactory(new Callback<TableColumn, TableCell>() {
            @Override
            public TableCell call(TableColumn param) {
                return new TableCell<Fxp_Archguip_sum, Integer>() {
                    @Override
                    public void updateItem(Integer item, boolean empty) {
                        super.updateItem(item, empty);
                        setText(empty ? null : getString());
                        setAlignment(Pos.CENTER);
                    }

                    private String getString() {
                        String ret = "";
                        if (getItem() != null) {
                            ret = getItem().toString();
                            if (ret.equals("0"))
                                ret = "";
                        } else {
                            ret = "";
                        }
                        return ret;
                    }                
                };
            }
        });        

        //Se define la columna de la tabla con el nombre del atributo del objeto USUARIO correspondiente
        col_orden.setCellValueFactory( 
                new PropertyValueFactory<>("orden") );
        col_unidad.setCellValueFactory( 
                new PropertyValueFactory<>("uniddesp") );
        col_cant.setCellValueFactory( 
                new PropertyValueFactory<>("cantdesp") );
        
        //Se Asigna ordenadamente las columnas de la tabla
        tb_alm4s.getColumns().addAll(
                col_cant, col_unidad
                );                
        
        //Se define el comportamiento de las teclas ARRIBA y ABAJO en la tabla
        EventHandler eh = new EventHandler<KeyEvent>(){
            @Override
            public void handle(KeyEvent ke){
                //Si fue presionado la tecla ARRIBA o ABAJO
                if (ke.getCode().equals(KeyCode.UP) || ke.getCode().equals(KeyCode.DOWN)){     
                    //Selecciona la FILA enfocada
                }
            }
        };
        //Se Asigna el comportamiento para que se ejecute cuando se suelta una tecla
        tb_alm4s.setOnKeyReleased(eh);    
    }

    
    /**
    * Metodo encargado de Crear e inicializar la Tabla de Datos
    */
    private void createTableStock5(){
        //Se crean y definen las columnas de la Tabla
        TableColumn col_orden       = new TableColumn("#");        
        TableColumn col_codigo      = new TableColumn("Código");                
        TableColumn col_unidad      = new TableColumn("Unidad");        
        TableColumn col_descrip     = new TableColumn("Descripción");        
        TableColumn col_cant        = new TableColumn("Cant.");
        TableColumn col_peso        = new TableColumn("Peso");        
        
        //Se establece el ancho de cada columna
        this.objectWidth(col_orden      , 30,  30);
        this.objectWidth(col_codigo     , 55,  55);
        this.objectWidth(col_unidad     , 85,  85);
        this.objectWidth(col_descrip    , 220, 250);
        this.objectWidth(col_cant       , 55,  55);
        this.objectWidth(col_peso       , 45,  45);

        col_codigo.setCellFactory(new Callback<TableColumn, TableCell>() {
            @Override
            public TableCell call(TableColumn param) {
                return new TableCell<Fxp_Archguip_det, String>() {
                    @Override
                    public void updateItem(String item, boolean empty) {
                        super.updateItem(item, empty);
                        setText(empty ? null : getString());
                        setAlignment(Pos.CENTER);
                    }

                    private String getString() {
                        String ret = "";
                        if (getItem() != null) {
                            ret = getItem().toString();
                            if (ret.equals("0"))
                                ret = "";
                        } else {
                            ret = "";
                        }
                        return ret;
                    }                
                };
            }
        });        

        col_cant.setCellFactory(new Callback<TableColumn, TableCell>() {
            @Override
            public TableCell call(TableColumn param) {
                return new TableCell<Fxp_Archguip_det, String>() {
                    @Override
                    public void updateItem(String item, boolean empty) {
                        super.updateItem(item, empty);
                        setText(empty ? null : getString());
                        setAlignment(Pos.CENTER);
                    }

                    private String getString() {
                        String ret = "";
                        if (getItem() != null) {
                            ret = getItem().toString();
                            if (ret.equals("0"))
                                ret = "";
                        } else {
                            ret = "";
                        }
                        return ret;
                    }                
                };
            }
        });        

        col_peso.setCellFactory(new Callback<TableColumn, TableCell>() {
            @Override
            public TableCell call(TableColumn param) {
                return new TableCell<Fxp_Archguip_det, Double>() {
                    @Override
                    public void updateItem(Double item, boolean empty) {
                        super.updateItem(item, empty);
                        setText(empty ? null : getString());
                        setAlignment(Pos.CENTER);
                    }

                    private String getString() {
                        String ret = "";
                        if (getItem() != null) {
                            String gi = getItem().toString();
                            NumberFormat df = DecimalFormat.getInstance();
                            df.setMinimumFractionDigits(2);
                            df.setRoundingMode(RoundingMode.DOWN);

                            ret = df.format(Double.parseDouble(gi));
                        } else {
                            ret = "0,00";
                        }
                        return ret;
                    }                
                };
            }
        });        

        //Se define la columna de la tabla con el nombre del atributo del objeto USUARIO correspondiente
        col_orden.setCellValueFactory( 
                new PropertyValueFactory<>("orden") );
        col_codigo.setCellValueFactory( 
                new PropertyValueFactory<>("codigo") );
        col_unidad.setCellValueFactory( 
                new PropertyValueFactory<>("unidad") );
        col_descrip.setCellValueFactory( 
                new PropertyValueFactory<>("descrip") );
        col_cant.setCellValueFactory( 
                new PropertyValueFactory<>("cantidad") );
        col_peso.setCellValueFactory( 
                new PropertyValueFactory<>("pesokgs") );
        
        //Se Asigna ordenadamente las columnas de la tabla
        tb_alm5.getColumns().addAll(
                col_orden, col_codigo, col_unidad, col_descrip, col_cant, 
                col_peso 
                );                
        
        //Se define el comportamiento de las teclas ARRIBA y ABAJO en la tabla
        EventHandler eh = new EventHandler<KeyEvent>(){
            @Override
            public void handle(KeyEvent ke){
                //Si fue presionado la tecla ARRIBA o ABAJO
                if (ke.getCode().equals(KeyCode.UP) || ke.getCode().equals(KeyCode.DOWN)){     
                    //Selecciona la FILA enfocada
                }
            }
        };
        //Se Asigna el comportamiento para que se ejecute cuando se suelta una tecla
        tb_alm5.setOnKeyReleased(eh);    
    }

    
    /**
    * Metodo encargado de Crear e inicializar la Tabla de Datos
    */
    private void createTableStock5s(){
        //Se crean y definen las columnas de la Tabla
        TableColumn col_orden       = new TableColumn("#");        
        TableColumn col_unidad      = new TableColumn("Unid.");        
        TableColumn col_cant        = new TableColumn("Cant.");
        
        //Se establece el ancho de cada columna
        this.objectWidth(col_orden      , 30,  30);
        this.objectWidth(col_unidad     , 42,  42);
        this.objectWidth(col_cant       , 42,  42);

        col_unidad.setCellFactory(new Callback<TableColumn, TableCell>() {
            @Override
            public TableCell call(TableColumn param) {
                return new TableCell<Fxp_Archguip_sum, String>() {
                    @Override
                    public void updateItem(String item, boolean empty) {
                        super.updateItem(item, empty);
                        setText(empty ? null : getString());
                        setAlignment(Pos.CENTER);
                    }

                    private String getString() {
                        String ret = "";
                        if (getItem() != null) {
                            ret = getItem().toString();
                            if (ret.equals("0"))
                                ret = "";
                        } else {
                            ret = "";
                        }
                        return ret;
                    }                
                };
            }
        });        

        col_cant.setCellFactory(new Callback<TableColumn, TableCell>() {
            @Override
            public TableCell call(TableColumn param) {
                return new TableCell<Fxp_Archguip_sum, Integer>() {
                    @Override
                    public void updateItem(Integer item, boolean empty) {
                        super.updateItem(item, empty);
                        setText(empty ? null : getString());
                        setAlignment(Pos.CENTER);
                    }

                    private String getString() {
                        String ret = "";
                        if (getItem() != null) {
                            ret = getItem().toString();
                            if (ret.equals("0"))
                                ret = "";
                        } else {
                            ret = "";
                        }
                        return ret;
                    }                
                };
            }
        });        

        //Se define la columna de la tabla con el nombre del atributo del objeto USUARIO correspondiente
        col_orden.setCellValueFactory( 
                new PropertyValueFactory<>("orden") );
        col_unidad.setCellValueFactory( 
                new PropertyValueFactory<>("uniddesp") );
        col_cant.setCellValueFactory( 
                new PropertyValueFactory<>("cantdesp") );
        
        //Se Asigna ordenadamente las columnas de la tabla
        tb_alm5s.getColumns().addAll(
                col_cant, col_unidad
                );                
        
        //Se define el comportamiento de las teclas ARRIBA y ABAJO en la tabla
        EventHandler eh = new EventHandler<KeyEvent>(){
            @Override
            public void handle(KeyEvent ke){
                //Si fue presionado la tecla ARRIBA o ABAJO
                if (ke.getCode().equals(KeyCode.UP) || ke.getCode().equals(KeyCode.DOWN)){     
                    //Selecciona la FILA enfocada
                }
            }
        };
        //Se Asigna el comportamiento para que se ejecute cuando se suelta una tecla
        tb_alm5s.setOnKeyReleased(eh);    
    }

    
    /**
    * Metodo encargado de Crear e inicializar la Tabla de Datos
    */
    private void createTableStock6(){
        //Se crean y definen las columnas de la Tabla
        TableColumn col_orden       = new TableColumn("#");        
        TableColumn col_codigo      = new TableColumn("Código");                
        TableColumn col_unidad      = new TableColumn("Unidad");        
        TableColumn col_descrip     = new TableColumn("Descripción");        
        TableColumn col_cant        = new TableColumn("Cant.");
        TableColumn col_peso        = new TableColumn("Peso");        
        
        //Se establece el ancho de cada columna
        this.objectWidth(col_orden      , 30,  30);
        this.objectWidth(col_codigo     , 55,  55);
        this.objectWidth(col_unidad     , 85,  85);
        this.objectWidth(col_descrip    , 220, 250);
        this.objectWidth(col_cant       , 55,  55);
        this.objectWidth(col_peso       , 45,  45);

        col_codigo.setCellFactory(new Callback<TableColumn, TableCell>() {
            @Override
            public TableCell call(TableColumn param) {
                return new TableCell<Fxp_Archguip_det, String>() {
                    @Override
                    public void updateItem(String item, boolean empty) {
                        super.updateItem(item, empty);
                        setText(empty ? null : getString());
                        setAlignment(Pos.CENTER);
                    }

                    private String getString() {
                        String ret = "";
                        if (getItem() != null) {
                            ret = getItem().toString();
                            if (ret.equals("0"))
                                ret = "";
                        } else {
                            ret = "";
                        }
                        return ret;
                    }                
                };
            }
        });        

        col_cant.setCellFactory(new Callback<TableColumn, TableCell>() {
            @Override
            public TableCell call(TableColumn param) {
                return new TableCell<Fxp_Archguip_det, String>() {
                    @Override
                    public void updateItem(String item, boolean empty) {
                        super.updateItem(item, empty);
                        setText(empty ? null : getString());
                        setAlignment(Pos.CENTER);
                    }

                    private String getString() {
                        String ret = "";
                        if (getItem() != null) {
                            ret = getItem().toString();
                            if (ret.equals("0"))
                                ret = "";
                        } else {
                            ret = "";
                        }
                        return ret;
                    }                
                };
            }
        });        

        col_peso.setCellFactory(new Callback<TableColumn, TableCell>() {
            @Override
            public TableCell call(TableColumn param) {
                return new TableCell<Fxp_Archguip_det, Double>() {
                    @Override
                    public void updateItem(Double item, boolean empty) {
                        super.updateItem(item, empty);
                        setText(empty ? null : getString());
                        setAlignment(Pos.CENTER);
                    }

                    private String getString() {
                        String ret = "";
                        if (getItem() != null) {
                            String gi = getItem().toString();
                            NumberFormat df = DecimalFormat.getInstance();
                            df.setMinimumFractionDigits(2);
                            df.setRoundingMode(RoundingMode.DOWN);

                            ret = df.format(Double.parseDouble(gi));
                        } else {
                            ret = "0,00";
                        }
                        return ret;
                    }                
                };
            }
        });        

        //Se define la columna de la tabla con el nombre del atributo del objeto USUARIO correspondiente
        col_orden.setCellValueFactory( 
                new PropertyValueFactory<>("orden") );
        col_codigo.setCellValueFactory( 
                new PropertyValueFactory<>("codigo") );
        col_unidad.setCellValueFactory( 
                new PropertyValueFactory<>("unidad") );
        col_descrip.setCellValueFactory( 
                new PropertyValueFactory<>("descrip") );
        col_cant.setCellValueFactory( 
                new PropertyValueFactory<>("cantidad") );
        col_peso.setCellValueFactory( 
                new PropertyValueFactory<>("pesokgs") );
        
        //Se Asigna ordenadamente las columnas de la tabla
        tb_alm6.getColumns().addAll(
                col_orden, col_codigo, col_unidad, col_descrip, col_cant, 
                col_peso 
                );                
        
        //Se define el comportamiento de las teclas ARRIBA y ABAJO en la tabla
        EventHandler eh = new EventHandler<KeyEvent>(){
            @Override
            public void handle(KeyEvent ke){
                //Si fue presionado la tecla ARRIBA o ABAJO
                if (ke.getCode().equals(KeyCode.UP) || ke.getCode().equals(KeyCode.DOWN)){     
                    //Selecciona la FILA enfocada
                }
            }
        };
        //Se Asigna el comportamiento para que se ejecute cuando se suelta una tecla
        tb_alm6.setOnKeyReleased(eh);    
    }

    
    /**
    * Metodo encargado de Crear e inicializar la Tabla de Datos
    */
    private void createTableStock6s(){
        //Se crean y definen las columnas de la Tabla
        TableColumn col_orden       = new TableColumn("#");        
        TableColumn col_unidad      = new TableColumn("Unid.");        
        TableColumn col_cant        = new TableColumn("Cant.");
        
        //Se establece el ancho de cada columna
        this.objectWidth(col_orden      , 30,  30);
        this.objectWidth(col_unidad     , 42,  42);
        this.objectWidth(col_cant       , 42,  42);

        col_unidad.setCellFactory(new Callback<TableColumn, TableCell>() {
            @Override
            public TableCell call(TableColumn param) {
                return new TableCell<Fxp_Archguip_sum, String>() {
                    @Override
                    public void updateItem(String item, boolean empty) {
                        super.updateItem(item, empty);
                        setText(empty ? null : getString());
                        setAlignment(Pos.CENTER);
                    }

                    private String getString() {
                        String ret = "";
                        if (getItem() != null) {
                            ret = getItem().toString();
                            if (ret.equals("0"))
                                ret = "";
                        } else {
                            ret = "";
                        }
                        return ret;
                    }                
                };
            }
        });        

        col_cant.setCellFactory(new Callback<TableColumn, TableCell>() {
            @Override
            public TableCell call(TableColumn param) {
                return new TableCell<Fxp_Archguip_sum, Integer>() {
                    @Override
                    public void updateItem(Integer item, boolean empty) {
                        super.updateItem(item, empty);
                        setText(empty ? null : getString());
                        setAlignment(Pos.CENTER);
                    }

                    private String getString() {
                        String ret = "";
                        if (getItem() != null) {
                            ret = getItem().toString();
                            if (ret.equals("0"))
                                ret = "";
                        } else {
                            ret = "";
                        }
                        return ret;
                    }                
                };
            }
        });        

        //Se define la columna de la tabla con el nombre del atributo del objeto USUARIO correspondiente
        col_orden.setCellValueFactory( 
                new PropertyValueFactory<>("orden") );
        col_unidad.setCellValueFactory( 
                new PropertyValueFactory<>("uniddesp") );
        col_cant.setCellValueFactory( 
                new PropertyValueFactory<>("cantdesp") );
        
        //Se Asigna ordenadamente las columnas de la tabla
        tb_alm6s.getColumns().addAll(
                col_cant, col_unidad
                );                
        
        //Se define el comportamiento de las teclas ARRIBA y ABAJO en la tabla
        EventHandler eh = new EventHandler<KeyEvent>(){
            @Override
            public void handle(KeyEvent ke){
                //Si fue presionado la tecla ARRIBA o ABAJO
                if (ke.getCode().equals(KeyCode.UP) || ke.getCode().equals(KeyCode.DOWN)){     
                    //Selecciona la FILA enfocada
                }
            }
        };
        //Se Asigna el comportamiento para que se ejecute cuando se suelta una tecla
        tb_alm6s.setOnKeyReleased(eh);    
    }

    
    /**
    * Metodo encargado de Crear e inicializar la Tabla de Datos
    */
    private void createTableStock7(){
        //Se crean y definen las columnas de la Tabla
        TableColumn col_orden       = new TableColumn("#");        
        TableColumn col_codigo      = new TableColumn("Código");                
        TableColumn col_unidad      = new TableColumn("Unidad");        
        TableColumn col_descrip     = new TableColumn("Descripción");        
        TableColumn col_cant        = new TableColumn("Cant.");
        TableColumn col_peso        = new TableColumn("Peso");        
        
        //Se establece el ancho de cada columna
        this.objectWidth(col_orden      , 30,  30);
        this.objectWidth(col_codigo     , 55,  55);
        this.objectWidth(col_unidad     , 85,  85);
        this.objectWidth(col_descrip    , 220, 250);
        this.objectWidth(col_cant       , 55,  55);
        this.objectWidth(col_peso       , 45,  45);

        col_codigo.setCellFactory(new Callback<TableColumn, TableCell>() {
            @Override
            public TableCell call(TableColumn param) {
                return new TableCell<Fxp_Archguip_det, String>() {
                    @Override
                    public void updateItem(String item, boolean empty) {
                        super.updateItem(item, empty);
                        setText(empty ? null : getString());
                        setAlignment(Pos.CENTER);
                    }

                    private String getString() {
                        String ret = "";
                        if (getItem() != null) {
                            ret = getItem().toString();
                            if (ret.equals("0"))
                                ret = "";
                        } else {
                            ret = "";
                        }
                        return ret;
                    }                
                };
            }
        });        

        col_cant.setCellFactory(new Callback<TableColumn, TableCell>() {
            @Override
            public TableCell call(TableColumn param) {
                return new TableCell<Fxp_Archguip_det, String>() {
                    @Override
                    public void updateItem(String item, boolean empty) {
                        super.updateItem(item, empty);
                        setText(empty ? null : getString());
                        setAlignment(Pos.CENTER);
                    }

                    private String getString() {
                        String ret = "";
                        if (getItem() != null) {
                            ret = getItem().toString();
                            if (ret.equals("0"))
                                ret = "";
                        } else {
                            ret = "";
                        }
                        return ret;
                    }                
                };
            }
        });        

        col_peso.setCellFactory(new Callback<TableColumn, TableCell>() {
            @Override
            public TableCell call(TableColumn param) {
                return new TableCell<Fxp_Archguip_det, Double>() {
                    @Override
                    public void updateItem(Double item, boolean empty) {
                        super.updateItem(item, empty);
                        setText(empty ? null : getString());
                        setAlignment(Pos.CENTER);
                    }

                    private String getString() {
                        String ret = "";
                        if (getItem() != null) {
                            String gi = getItem().toString();
                            NumberFormat df = DecimalFormat.getInstance();
                            df.setMinimumFractionDigits(2);
                            df.setRoundingMode(RoundingMode.DOWN);

                            ret = df.format(Double.parseDouble(gi));
                        } else {
                            ret = "0,00";
                        }
                        return ret;
                    }                
                };
            }
        });        

        //Se define la columna de la tabla con el nombre del atributo del objeto USUARIO correspondiente
        col_orden.setCellValueFactory( 
                new PropertyValueFactory<>("orden") );
        col_codigo.setCellValueFactory( 
                new PropertyValueFactory<>("codigo") );
        col_unidad.setCellValueFactory( 
                new PropertyValueFactory<>("unidad") );
        col_descrip.setCellValueFactory( 
                new PropertyValueFactory<>("descrip") );
        col_cant.setCellValueFactory( 
                new PropertyValueFactory<>("cantidad") );
        col_peso.setCellValueFactory( 
                new PropertyValueFactory<>("pesokgs") );
        
        //Se Asigna ordenadamente las columnas de la tabla
        tb_alm7.getColumns().addAll(
                col_orden, col_codigo, col_unidad, col_descrip, col_cant, 
                col_peso 
                );                
        
        //Se define el comportamiento de las teclas ARRIBA y ABAJO en la tabla
        EventHandler eh = new EventHandler<KeyEvent>(){
            @Override
            public void handle(KeyEvent ke){
                //Si fue presionado la tecla ARRIBA o ABAJO
                if (ke.getCode().equals(KeyCode.UP) || ke.getCode().equals(KeyCode.DOWN)){     
                    //Selecciona la FILA enfocada
                }
            }
        };
        //Se Asigna el comportamiento para que se ejecute cuando se suelta una tecla
        tb_alm7.setOnKeyReleased(eh);    
    }

    
    /**
    * Metodo encargado de Crear e inicializar la Tabla de Datos
    */
    private void createTableStock7s(){
        //Se crean y definen las columnas de la Tabla
        TableColumn col_orden       = new TableColumn("#");        
        TableColumn col_unidad      = new TableColumn("Unid.");        
        TableColumn col_cant        = new TableColumn("Cant.");
        
        //Se establece el ancho de cada columna
        this.objectWidth(col_orden      , 30,  30);
        this.objectWidth(col_unidad     , 42,  42);
        this.objectWidth(col_cant       , 42,  42);

        col_unidad.setCellFactory(new Callback<TableColumn, TableCell>() {
            @Override
            public TableCell call(TableColumn param) {
                return new TableCell<Fxp_Archguip_sum, String>() {
                    @Override
                    public void updateItem(String item, boolean empty) {
                        super.updateItem(item, empty);
                        setText(empty ? null : getString());
                        setAlignment(Pos.CENTER);
                    }

                    private String getString() {
                        String ret = "";
                        if (getItem() != null) {
                            ret = getItem().toString();
                            if (ret.equals("0"))
                                ret = "";
                        } else {
                            ret = "";
                        }
                        return ret;
                    }                
                };
            }
        });        

        col_cant.setCellFactory(new Callback<TableColumn, TableCell>() {
            @Override
            public TableCell call(TableColumn param) {
                return new TableCell<Fxp_Archguip_sum, Integer>() {
                    @Override
                    public void updateItem(Integer item, boolean empty) {
                        super.updateItem(item, empty);
                        setText(empty ? null : getString());
                        setAlignment(Pos.CENTER);
                    }

                    private String getString() {
                        String ret = "";
                        if (getItem() != null) {
                            ret = getItem().toString();
                            if (ret.equals("0"))
                                ret = "";
                        } else {
                            ret = "";
                        }
                        return ret;
                    }                
                };
            }
        });        

        //Se define la columna de la tabla con el nombre del atributo del objeto USUARIO correspondiente
        col_orden.setCellValueFactory( 
                new PropertyValueFactory<>("orden") );
        col_unidad.setCellValueFactory( 
                new PropertyValueFactory<>("uniddesp") );
        col_cant.setCellValueFactory( 
                new PropertyValueFactory<>("cantdesp") );
        
        //Se Asigna ordenadamente las columnas de la tabla
        tb_alm7s.getColumns().addAll(
                col_cant, col_unidad
                );                
        
        //Se define el comportamiento de las teclas ARRIBA y ABAJO en la tabla
        EventHandler eh = new EventHandler<KeyEvent>(){
            @Override
            public void handle(KeyEvent ke){
                //Si fue presionado la tecla ARRIBA o ABAJO
                if (ke.getCode().equals(KeyCode.UP) || ke.getCode().equals(KeyCode.DOWN)){     
                    //Selecciona la FILA enfocada
                }
            }
        };
        //Se Asigna el comportamiento para que se ejecute cuando se suelta una tecla
        tb_alm7s.setOnKeyReleased(eh);    
    }

    
    /**
    * Metodo encargado de Crear e inicializar la Tabla de Datos
    */
    private void createTableStockP1(){
        //Se crean y definen las columnas de la Tabla
        TableColumn col_orden       = new TableColumn("#");        
        TableColumn col_codigo      = new TableColumn("Código");                
        TableColumn col_unidad      = new TableColumn("Unidad");        
        TableColumn col_descrip     = new TableColumn("Descripción");        
        TableColumn col_cant        = new TableColumn("Cant.");
        TableColumn col_peso        = new TableColumn("Peso");        
        
        //Se establece el ancho de cada columna
        this.objectWidth(col_orden      , 30,  30);
        this.objectWidth(col_codigo     , 55,  55);
        this.objectWidth(col_unidad     , 85,  85);
        this.objectWidth(col_descrip    , 220, 250);
        this.objectWidth(col_cant       , 55,  55);
        this.objectWidth(col_peso       , 45,  45);

        col_codigo.setCellFactory(new Callback<TableColumn, TableCell>() {
            @Override
            public TableCell call(TableColumn param) {
                return new TableCell<Fxp_Archguip_det, String>() {
                    @Override
                    public void updateItem(String item, boolean empty) {
                        super.updateItem(item, empty);
                        setText(empty ? null : getString());
                        setAlignment(Pos.CENTER);
                    }

                    private String getString() {
                        String ret = "";
                        if (getItem() != null) {
                            ret = getItem().toString();
                            if (ret.equals("0"))
                                ret = "";
                        } else {
                            ret = "";
                        }
                        return ret;
                    }                
                };
            }
        });        

        col_cant.setCellFactory(new Callback<TableColumn, TableCell>() {
            @Override
            public TableCell call(TableColumn param) {
                return new TableCell<Fxp_Archguip_det, String>() {
                    @Override
                    public void updateItem(String item, boolean empty) {
                        super.updateItem(item, empty);
                        setText(empty ? null : getString());
                        setAlignment(Pos.CENTER);
                    }

                    private String getString() {
                        String ret = "";
                        if (getItem() != null) {
                            ret = getItem().toString();
                            if (ret.equals("0"))
                                ret = "";
                        } else {
                            ret = "";
                        }
                        return ret;
                    }                
                };
            }
        });        

        col_peso.setCellFactory(new Callback<TableColumn, TableCell>() {
            @Override
            public TableCell call(TableColumn param) {
                return new TableCell<Fxp_Archguip_det, Double>() {
                    @Override
                    public void updateItem(Double item, boolean empty) {
                        super.updateItem(item, empty);
                        setText(empty ? null : getString());
                        setAlignment(Pos.CENTER);
                    }

                    private String getString() {
                        String ret = "";
                        if (getItem() != null) {
                            String gi = getItem().toString();
                            NumberFormat df = DecimalFormat.getInstance();
                            df.setMinimumFractionDigits(2);
                            df.setRoundingMode(RoundingMode.DOWN);

                            ret = df.format(Double.parseDouble(gi));
                        } else {
                            ret = "0,00";
                        }
                        return ret;
                    }                
                };
            }
        });        

        //Se define la columna de la tabla con el nombre del atributo del objeto USUARIO correspondiente
        col_orden.setCellValueFactory( 
                new PropertyValueFactory<>("orden") );
        col_codigo.setCellValueFactory( 
                new PropertyValueFactory<>("codigo") );
        col_unidad.setCellValueFactory( 
                new PropertyValueFactory<>("unidad") );
        col_descrip.setCellValueFactory( 
                new PropertyValueFactory<>("descrip") );
        col_cant.setCellValueFactory( 
                new PropertyValueFactory<>("cantidad") );
        col_peso.setCellValueFactory( 
                new PropertyValueFactory<>("pesokgs") );
        
        //Se Asigna ordenadamente las columnas de la tabla
        tb_almp.getColumns().addAll(
                col_orden, col_codigo, col_unidad, col_descrip, col_cant, 
                col_peso 
                );                
        
        //Se define el comportamiento de las teclas ARRIBA y ABAJO en la tabla
        EventHandler eh = new EventHandler<KeyEvent>(){
            @Override
            public void handle(KeyEvent ke){
                //Si fue presionado la tecla ARRIBA o ABAJO
                if (ke.getCode().equals(KeyCode.UP) || ke.getCode().equals(KeyCode.DOWN)){     
                    //Selecciona la FILA enfocada
                }
            }
        };
        //Se Asigna el comportamiento para que se ejecute cuando se suelta una tecla
        tb_almp.setOnKeyReleased(eh);    
    }

    
    /**
    * Metodo encargado de Crear e inicializar la Tabla de Datos
    */
    private void createTableStockPs(){
        //Se crean y definen las columnas de la Tabla
        TableColumn col_orden       = new TableColumn("#");        
        TableColumn col_unidad      = new TableColumn("Unid.");        
        TableColumn col_cant        = new TableColumn("Cant.");
        
        //Se establece el ancho de cada columna
        this.objectWidth(col_orden      , 30,  30);
        this.objectWidth(col_unidad     , 42,  42);
        this.objectWidth(col_cant       , 42,  42);

        col_unidad.setCellFactory(new Callback<TableColumn, TableCell>() {
            @Override
            public TableCell call(TableColumn param) {
                return new TableCell<Fxp_Archguip_sum, String>() {
                    @Override
                    public void updateItem(String item, boolean empty) {
                        super.updateItem(item, empty);
                        setText(empty ? null : getString());
                        setAlignment(Pos.CENTER);
                    }

                    private String getString() {
                        String ret = "";
                        if (getItem() != null) {
                            ret = getItem().toString();
                            if (ret.equals("0"))
                                ret = "";
                        } else {
                            ret = "";
                        }
                        return ret;
                    }                
                };
            }
        });        

        col_cant.setCellFactory(new Callback<TableColumn, TableCell>() {
            @Override
            public TableCell call(TableColumn param) {
                return new TableCell<Fxp_Archguip_sum, Integer>() {
                    @Override
                    public void updateItem(Integer item, boolean empty) {
                        super.updateItem(item, empty);
                        setText(empty ? null : getString());
                        setAlignment(Pos.CENTER);
                    }

                    private String getString() {
                        String ret = "";
                        if (getItem() != null) {
                            ret = getItem().toString();
                            if (ret.equals("0"))
                                ret = "";
                        } else {
                            ret = "";
                        }
                        return ret;
                    }                
                };
            }
        });        

        //Se define la columna de la tabla con el nombre del atributo del objeto USUARIO correspondiente
        col_orden.setCellValueFactory( 
                new PropertyValueFactory<>("orden") );
        col_unidad.setCellValueFactory( 
                new PropertyValueFactory<>("uniddesp") );
        col_cant.setCellValueFactory( 
                new PropertyValueFactory<>("cantdesp") );
        
        //Se Asigna ordenadamente las columnas de la tabla
        tb_almps.getColumns().addAll(
                col_cant, col_unidad
                );                
        
        //Se define el comportamiento de las teclas ARRIBA y ABAJO en la tabla
        EventHandler eh = new EventHandler<KeyEvent>(){
            @Override
            public void handle(KeyEvent ke){
                //Si fue presionado la tecla ARRIBA o ABAJO
                if (ke.getCode().equals(KeyCode.UP) || ke.getCode().equals(KeyCode.DOWN)){     
                    //Selecciona la FILA enfocada
                }
            }
        };
        //Se Asigna el comportamiento para que se ejecute cuando se suelta una tecla
        tb_almps.setOnKeyReleased(eh);    
    }

    
    /**
    * Metodo encargado de Crear e inicializar la Tabla de Datos
    */
    private void createTableStockM1(){
        //Se crean y definen las columnas de la Tabla
        TableColumn col_orden       = new TableColumn("#");        
        TableColumn col_guianc      = new TableColumn("G-Carga");                
        TableColumn col_guiafc      = new TableColumn("G-Falt.");                
        TableColumn col_codigo      = new TableColumn("Código");                
        TableColumn col_unidad      = new TableColumn("Unidad");        
        TableColumn col_descrip     = new TableColumn("Descripción");        
        TableColumn col_cant        = new TableColumn("Cant.");
        TableColumn col_falt        = new TableColumn("Falt.");
        TableColumn col_peso        = new TableColumn("Peso");        
        
        //Se establece el ancho de cada columna
        this.objectWidth(col_orden      , 25,  25);
        this.objectWidth(col_guianc     , 60,  60);
        this.objectWidth(col_guiafc     , 60,  60);
        this.objectWidth(col_codigo     , 55,  55);
        this.objectWidth(col_unidad     , 78,  78);
        this.objectWidth(col_descrip    , 215, 280);
        this.objectWidth(col_cant       , 52,  52);
        this.objectWidth(col_falt       , 52,  52);
        this.objectWidth(col_peso       , 50,  50);

        col_guianc.setCellFactory(new Callback<TableColumn, TableCell>() {
            @Override
            public TableCell call(TableColumn param) {
                return new TableCell<Fxp_Archguip_pro_cg, String>() {
                    @Override
                    public void updateItem(String item, boolean empty) {
                        super.updateItem(item, empty);
                        setText(empty ? null : getString());
                        setAlignment(Pos.CENTER);
                    }

                    private String getString() {
                        String ret = "";
                        if (getItem() != null) {
                            ret = getItem().toString();
                            if (ret.equals("0"))
                                ret = "";
                        } else {
                            ret = "";
                        }
                        return ret;
                    }                
                };
            }
        });        

        col_guiafc.setCellFactory(new Callback<TableColumn, TableCell>() {
            @Override
            public TableCell call(TableColumn param) {
                return new TableCell<Fxp_Archguip_pro_cg, String>() {
                    @Override
                    public void updateItem(String item, boolean empty) {
                        super.updateItem(item, empty);
                        setText(empty ? null : getString());
                        setAlignment(Pos.CENTER);
                    }

                    private String getString() {
                        String ret = "";
                        if (getItem() != null) {
                            ret = getItem().toString();
                            if (ret.equals("0"))
                                ret = "";
                        } else {
                            ret = "";
                        }
                        return ret;
                    }                
                };
            }
        });        

        col_codigo.setCellFactory(new Callback<TableColumn, TableCell>() {
            @Override
            public TableCell call(TableColumn param) {
                return new TableCell<Fxp_Archguip_pro_cg, String>() {
                    @Override
                    public void updateItem(String item, boolean empty) {
                        super.updateItem(item, empty);
                        setText(empty ? null : getString());
                        setAlignment(Pos.CENTER);
                    }

                    private String getString() {
                        String ret = "";
                        if (getItem() != null) {
                            ret = getItem().toString();
                            if (ret.equals("0"))
                                ret = "";
                        } else {
                            ret = "";
                        }
                        return ret;
                    }                
                };
            }
        });        

        col_cant.setCellFactory(new Callback<TableColumn, TableCell>() {
            @Override
            public TableCell call(TableColumn param) {
                return new TableCell<Fxp_Archguip_pro_cg, String>() {
                    @Override
                    public void updateItem(String item, boolean empty) {
                        super.updateItem(item, empty);
                        setText(empty ? null : getString());
                        setAlignment(Pos.CENTER);
                    }

                    private String getString() {
                        String ret = "";
                        if (getItem() != null) {
                            ret = getItem().toString();
                            if (ret.equals("0"))
                                ret = "";
                        } else {
                            ret = "";
                        }
                        return ret;
                    }                
                };
            }
        });        

        col_falt.setCellFactory(new Callback<TableColumn, TableCell>() {
            @Override
            public TableCell call(TableColumn param) {
                return new TableCell<Fxp_Archguip_pro_cg, String>() {
                    @Override
                    public void updateItem(String item, boolean empty) {
                        super.updateItem(item, empty);
                        setText(empty ? null : getString());
                        setAlignment(Pos.CENTER);
                    }

                    private String getString() {
                        String ret = "";
                        if (getItem() != null) {
                            ret = getItem().toString();
                            if (ret.equals("0"))
                                ret = "";
                        } else {
                            ret = "";
                        }
                        return ret;
                    }                
                };
            }
        });        

        col_peso.setCellFactory(new Callback<TableColumn, TableCell>() {
            @Override
            public TableCell call(TableColumn param) {
                return new TableCell<Fxp_Archguip_pro_cg, Double>() {
                    @Override
                    public void updateItem(Double item, boolean empty) {
                        super.updateItem(item, empty);
                        setText(empty ? null : getString());
                        setAlignment(Pos.CENTER);
                    }

                    private String getString() {
                        String ret = "";
                        if (getItem() != null) {
                            String gi = getItem().toString();
                            NumberFormat df = DecimalFormat.getInstance();
                            df.setMinimumFractionDigits(2);
                            df.setRoundingMode(RoundingMode.DOWN);

                            ret = df.format(Double.parseDouble(gi));
                        } else {
                            ret = "0,00";
                        }
                        return ret;
                    }                
                };
            }
        });        

        //Se define la columna de la tabla con el nombre del atributo del objeto USUARIO correspondiente
        col_orden.setCellValueFactory( 
                new PropertyValueFactory<>("orden") );
        col_guiafc.setCellValueFactory( 
                new PropertyValueFactory<>("numfalt") );
        col_guianc.setCellValueFactory( 
                new PropertyValueFactory<>("numguia") );
        col_codigo.setCellValueFactory( 
                new PropertyValueFactory<>("codigo") );
        col_unidad.setCellValueFactory( 
                new PropertyValueFactory<>("unidad") );
        col_descrip.setCellValueFactory( 
                new PropertyValueFactory<>("descrip") );
        col_cant.setCellValueFactory( 
                new PropertyValueFactory<>("sCantDesp") );
        col_falt.setCellValueFactory( 
                new PropertyValueFactory<>("sCantFalt") );
        col_peso.setCellValueFactory( 
                new PropertyValueFactory<>("pesokgs") );
        
        //Se Asigna ordenadamente las columnas de la tabla
        tb_almm.getColumns().addAll(
                col_orden, col_guiafc, col_guianc, col_codigo, col_unidad, 
                col_descrip, col_cant, col_falt//, col_peso 
                );                
        
        //Se Asigna menu contextual 
        tb_almm.setRowFactory((TableView<Fxp_Archguip_pro_cg> tableView) -> {
            final TableRow<Fxp_Archguip_pro_cg> row = new TableRow<>();
            final ContextMenu contextMenu = new ContextMenu();
            final MenuItem removeMenuItem = new MenuItem("Eliminar Producto");
            removeMenuItem.setOnAction((ActionEvent event) -> {
                tb_almm.getItems().remove(row.getItem());
            });
            contextMenu.getItems().add(removeMenuItem);
            // Set context menu on row, but use a binding to make it only show for non-empty rows:
            row.contextMenuProperty().bind(
                    Bindings.when(row.emptyProperty())
                            .then((ContextMenu)null)
                            .otherwise(contextMenu)
            );
            return row ;  
        });
        
        //Se define el comportamiento de las teclas ARRIBA y ABAJO en la tabla
        EventHandler eh = new EventHandler<KeyEvent>(){
            @Override
            public void handle(KeyEvent ke){
                //Si fue presionado la tecla ARRIBA o ABAJO
                if (ke.getCode().equals(KeyCode.UP) || ke.getCode().equals(KeyCode.DOWN)){     
                    //Selecciona la FILA enfocada
                    selectedRowAlmm();
                }
            }
        };
        //Se Asigna el comportamiento para que se ejecute cuando se suelta una tecla
        tb_almm.setOnKeyReleased(eh);    
    }

    
    /**
    * Metodo encargado de Crear e inicializar la Tabla de Datos
    */
    private void createTableStockR1(){
        //Se crean y definen las columnas de la Tabla
        TableColumn col_orden       = new TableColumn("#");        
        TableColumn col_statreg     = new TableColumn("Act");
        TableColumn col_fact        = new TableColumn("Factura");        
        TableColumn col_codigo      = new TableColumn("Código");                
        TableColumn col_unidad      = new TableColumn("Unidad");        
        TableColumn col_descrip     = new TableColumn("Descripción");        
        TableColumn col_cant        = new TableColumn("Cant.");
        TableColumn col_falt        = new TableColumn("Dev.");
        TableColumn col_motivo      = new TableColumn("Motivo");
        TableColumn col_observ      = new TableColumn("Comentario");
        
        //Se establece el ancho de cada columna
        this.objectWidth(col_orden      , 30,  30);
        this.objectWidth(col_statreg    , 30 , 30);
        this.objectWidth(col_fact       , 52,  52);
        this.objectWidth(col_codigo     , 52,  52);
        this.objectWidth(col_unidad     , 85,  85);
        this.objectWidth(col_descrip    , 230, 250);
        this.objectWidth(col_cant       , 55,  55);
        this.objectWidth(col_falt       , 55,  55);
        this.objectWidth(col_motivo     , 60,  60);
        this.objectWidth(col_observ     , 300, 380);
        /**
         * Sobreescritura de un metodo de la Columna, para sustituir el valor numerico 
         * del STATUS del usuario por una Imagen segun el valor
         * 1 - VERDE (HABILITADO)
         * 2 - ROJO  (DESHABILITADO)
         */
        col_statreg.setCellFactory(new Callback<TableColumn, TableCell>() {
            @Override
            public TableCell call(TableColumn param) {
                return new TableCell<Fxp_Archguip_pro_dv, String>() {
                    public void updateItem(String item, boolean empty) {
                        super.updateItem(item, empty);
                        setText(empty ? null : getString());
                        setAlignment(Pos.CENTER);
                    }

                    private String getString() {
                        String ret = "";
                        if (getItem() != null) {
                            ret = getItem();
                            switch(ret){  
                                case "C":     //DESHABILITADO
                                    setGraphic(new ImageView(new Image(getClass().getResourceAsStream("/Images/img59.png"), 15, 15, false,false))); 
                                    break;
                                case "A":     //HABILITADO
                                    setGraphic(new ImageView(new Image(getClass().getResourceAsStream("/Images/img61.png"), 15, 15, false,false))); 
                                    break;   
                            }                            
                        } else {
                            setGraphic(null);
                        }
                        return ret;
                    }                
                };
            }
        });       


        col_fact.setCellFactory(new Callback<TableColumn, TableCell>() {
            @Override
            public TableCell call(TableColumn param) {
                return new TableCell<Fxp_Archguip_pro_dv, String>() {
                    @Override
                    public void updateItem(String item, boolean empty) {
                        super.updateItem(item, empty);
                        setText(empty ? null : getString());
                        setAlignment(Pos.CENTER);
                    }

                    private String getString() {
                        String ret = "";
                        if (getItem() != null) {
                            ret = getItem();
                            if (ret.equals("0"))
                                ret = "";
                        } else {
                            ret = "";
                        }
                        return ret;
                    }                
                };
            }
        });        

        col_codigo.setCellFactory(new Callback<TableColumn, TableCell>() {
            @Override
            public TableCell call(TableColumn param) {
                return new TableCell<Fxp_Archguip_pro_dv, String>() {
                    @Override
                    public void updateItem(String item, boolean empty) {
                        super.updateItem(item, empty);
                        setText(empty ? null : getString());
                        setAlignment(Pos.CENTER);
                    }

                    private String getString() {
                        String ret = "";
                        if (getItem() != null) {
                            ret = getItem();
                            if (ret.equals("0"))
                                ret = "";
                        } else {
                            ret = "";
                        }
                        return ret;
                    }                
                };
            }
        });        

        col_cant.setCellFactory(new Callback<TableColumn, TableCell>() {
            @Override
            public TableCell call(TableColumn param) {
                return new TableCell<Fxp_Archguip_pro_dv, String>() {
                    @Override
                    public void updateItem(String item, boolean empty) {
                        super.updateItem(item, empty);
                        setText(empty ? null : getString());
                        setAlignment(Pos.CENTER);
                    }

                    private String getString() {
                        String ret = "";
                        if (getItem() != null) {
                            ret = getItem();
                            if (ret.equals("0"))
                                ret = "";
                        } else {
                            ret = "";
                        }
                        return ret;
                    }                
                };
            }
        });        

        col_falt.setCellFactory(new Callback<TableColumn, TableCell>() {
            @Override
            public TableCell call(TableColumn param) {
                return new TableCell<Fxp_Archguip_pro_dv, String>() {
                    @Override
                    public void updateItem(String item, boolean empty) {
                        super.updateItem(item, empty);
                        setText(empty ? null : getString());
                        setAlignment(Pos.CENTER);
                    }

                    private String getString() {
                        String ret = "";
                        if (getItem() != null) {
                            ret = getItem();
                            if (ret.equals("0"))
                                ret = "";
                        } else {
                            ret = "";
                        }
                        return ret;
                    }                
                };
            }
        });        

        col_motivo.setCellFactory(new Callback<TableColumn, TableCell>() {
            @Override
            public TableCell call(TableColumn param) {
                return new TableCell<Fxp_Archguip_pro_dv, String>() {
                    @Override
                    public void updateItem(String item, boolean empty) {
                        super.updateItem(item, empty);
                        setText(empty ? null : getString());
                        setAlignment(Pos.CENTER);
                    }

                    private String getString() {
                        String ret = "";
                        if (getItem() != null) {
                            ret = getItem();
                            if (ret.equals("0"))
                                ret = "";
                        } else {
                            ret = "";
                        }
                        return ret;
                    }                
                };
            }
        });        

        //Se define la columna de la tabla con el nombre del atributo del objeto USUARIO correspondiente
        col_orden.setCellValueFactory( 
                new PropertyValueFactory<>("orden") );
        col_statreg.setCellValueFactory( 
                new PropertyValueFactory<>("stat_reg") );
        col_fact.setCellValueFactory( 
                new PropertyValueFactory<>("numfact") );
        col_codigo.setCellValueFactory( 
                new PropertyValueFactory<>("codigo") );
        col_unidad.setCellValueFactory( 
                new PropertyValueFactory<>("unidad") );
        col_descrip.setCellValueFactory( 
                new PropertyValueFactory<>("descrip") );
        col_cant.setCellValueFactory( 
                new PropertyValueFactory<>("sCantDesp") );
        col_falt.setCellValueFactory( 
                new PropertyValueFactory<>("sCantFalt") );
        col_motivo.setCellValueFactory( 
                new PropertyValueFactory<>("smotivo") );
        col_observ.setCellValueFactory( 
                new PropertyValueFactory<>("observ") );

        
        //Se Asigna ordenadamente las columnas de la tabla
        tb_almr.getColumns().addAll(
                col_orden, col_statreg, col_fact, col_codigo, col_descrip, 
                col_falt, col_motivo, col_observ
                );                
        
        //Se Asigna menu contextual 
        tb_almr.setRowFactory((TableView<Fxp_Archguip_pro_dv> tableView) -> {
            final TableRow<Fxp_Archguip_pro_dv> row = new TableRow<>();
            final ContextMenu contextMenu = new ContextMenu();

            final MenuItem changeMenuItemBE = new MenuItem("Buen Estado");
            contextMenu.getItems().add(changeMenuItemBE);
            changeMenuItemBE.setOnAction((ActionEvent event) -> {
                if (tipoOperacion == 9){
                    numIdMotivo = (((Fxp_Archguip_pro_dv) tb_almr.getItems().get(tb_almr.getSelectionModel().getSelectedIndex())).getIdMotivo());

                    switch (numIdMotivo){
                        case 111:
                        case 112:
                        case 113:
                            tf_motivodv.setText("110");
                            break;
                        case 121:
                        case 122:
                        case 123:
                            tf_motivodv.setText("120");
                            break;
                        case 131:
                        case 132:
                        case 133:
                            tf_motivodv.setText("130");
                            break;
                        case 141:
                        case 142:
                        case 143:
                            tf_motivodv.setText("140");
                            break;
                        case 151:
                        case 152:
                        case 153:
                            tf_motivodv.setText("150");
                            break;
                        case 211:
                        case 212:
                        case 213:
                            tf_motivodv.setText("210");
                            break;
                        case 221:
                        case 222:
                        case 223:
                            tf_motivodv.setText("220");
                            break;
                        case 231:
                        case 232:
                        case 233:
                            tf_motivodv.setText("230");
                            break;
                        case 411:
                        case 412:
                        case 414:
                            tf_motivodv.setText("410");
                            break;
                        case 511:
                            tf_motivodv.setText("510");
                            break;
                        case 521:
                            tf_motivodv.setText("520");
                            break;
                    }
                    numStatDev = Integer.parseInt(((Fxp_Archguip_pro_dv) tb_almr.getItems().get(tb_almr.getSelectionModel().getSelectedIndex())).getOrden());
                    tf_factdv.setText(String.valueOf(((Fxp_Archguip_pro_dv) tb_almr.getItems().get(tb_almr.getSelectionModel().getSelectedIndex())).getNumfact()));
                    tf_proddv.setText(String.valueOf(((Fxp_Archguip_pro_dv) tb_almr.getItems().get(tb_almr.getSelectionModel().getSelectedIndex())).getCodigo()));
                    tf_cantdv.setText(String.valueOf(((Fxp_Archguip_pro_dv) tb_almr.getItems().get(tb_almr.getSelectionModel().getSelectedIndex())).getICantFalt()));
                    tf_obserdv.setText(String.valueOf(((Fxp_Archguip_pro_dv) tb_almr.getItems().get(tb_almr.getSelectionModel().getSelectedIndex())).getObserv()));

                    tf_motivodv.requestFocus();
                }
            });

            final MenuItem changeMenuItemME_RE = new MenuItem("ME - Recuperación");
            contextMenu.getItems().add(changeMenuItemME_RE);
            changeMenuItemME_RE.setOnAction((ActionEvent event) -> {
                if (tipoOperacion == 9){
                    numIdMotivo = (((Fxp_Archguip_pro_dv) tb_almr.getItems().get(tb_almr.getSelectionModel().getSelectedIndex())).getIdMotivo());

                    switch (numIdMotivo){
                        case 110:
                            tf_motivodv.setText("111");
                            break;
                        case 120:
                            tf_motivodv.setText("121");
                            break;
                        case 130:
                            tf_motivodv.setText("131");
                            break;
                        case 140:
                            tf_motivodv.setText("141");
                            break;
                        case 150:
                            tf_motivodv.setText("151");
                            break;
                        case 210:
                            tf_motivodv.setText("211");
                            break;
                        case 220:
                            tf_motivodv.setText("221");
                            break;
                        case 230:
                            tf_motivodv.setText("231");
                            break;
                        case 410:
                            tf_motivodv.setText("411");
                            break;
                    }
                    numStatDev = Integer.parseInt(((Fxp_Archguip_pro_dv) tb_almr.getItems().get(tb_almr.getSelectionModel().getSelectedIndex())).getOrden());
                    tf_factdv.setText(String.valueOf(((Fxp_Archguip_pro_dv) tb_almr.getItems().get(tb_almr.getSelectionModel().getSelectedIndex())).getNumfact()));
                    tf_proddv.setText(String.valueOf(((Fxp_Archguip_pro_dv) tb_almr.getItems().get(tb_almr.getSelectionModel().getSelectedIndex())).getCodigo()));
                    tf_cantdv.setText(String.valueOf(((Fxp_Archguip_pro_dv) tb_almr.getItems().get(tb_almr.getSelectionModel().getSelectedIndex())).getICantFalt()));
                    tf_obserdv.setText(String.valueOf(((Fxp_Archguip_pro_dv) tb_almr.getItems().get(tb_almr.getSelectionModel().getSelectedIndex())).getObserv()));

                    tf_motivodv.requestFocus();
                }
            });

            final MenuItem changeMenuItemME_VE = new MenuItem("ME - Vencido");
            contextMenu.getItems().add(changeMenuItemME_VE);
            changeMenuItemME_VE.setOnAction((ActionEvent event) -> {
                if (tipoOperacion == 9){
                    numIdMotivo = (((Fxp_Archguip_pro_dv) tb_almr.getItems().get(tb_almr.getSelectionModel().getSelectedIndex())).getIdMotivo());

                    switch (numIdMotivo){
                        case 110:
                            tf_motivodv.setText("112");
                            break;
                        case 120:
                            tf_motivodv.setText("122");
                            break;
                        case 130:
                            tf_motivodv.setText("132");
                            break;
                        case 140:
                            tf_motivodv.setText("142");
                            break;
                        case 150:
                            tf_motivodv.setText("152");
                            break;
                        case 210:
                            tf_motivodv.setText("212");
                            break;
                        case 220:
                            tf_motivodv.setText("222");
                            break;
                        case 230:
                            tf_motivodv.setText("232");
                            break;
                        case 410:
                            tf_motivodv.setText("412");
                            break;
                    }
                    numStatDev = Integer.parseInt(((Fxp_Archguip_pro_dv) tb_almr.getItems().get(tb_almr.getSelectionModel().getSelectedIndex())).getOrden());
                    tf_factdv.setText(String.valueOf(((Fxp_Archguip_pro_dv) tb_almr.getItems().get(tb_almr.getSelectionModel().getSelectedIndex())).getNumfact()));
                    tf_proddv.setText(String.valueOf(((Fxp_Archguip_pro_dv) tb_almr.getItems().get(tb_almr.getSelectionModel().getSelectedIndex())).getCodigo()));
                    tf_cantdv.setText(String.valueOf(((Fxp_Archguip_pro_dv) tb_almr.getItems().get(tb_almr.getSelectionModel().getSelectedIndex())).getICantFalt()));
                    tf_obserdv.setText(String.valueOf(((Fxp_Archguip_pro_dv) tb_almr.getItems().get(tb_almr.getSelectionModel().getSelectedIndex())).getObserv()));

                    tf_motivodv.requestFocus();
                }
            });

            final MenuItem changeMenuItemME_IR = new MenuItem("ME - Irrecuperable");
            contextMenu.getItems().add(changeMenuItemME_IR);
            changeMenuItemME_IR.setOnAction((ActionEvent event) -> {
                if (tipoOperacion == 9){
                    numIdMotivo = (((Fxp_Archguip_pro_dv) tb_almr.getItems().get(tb_almr.getSelectionModel().getSelectedIndex())).getIdMotivo());

                    switch (numIdMotivo){
                        case 110:
                            tf_motivodv.setText("113");
                            break;
                        case 120:
                            tf_motivodv.setText("123");
                            break;
                        case 130:
                            tf_motivodv.setText("133");
                            break;
                        case 140:
                            tf_motivodv.setText("143");
                            break;
                        case 150:
                            tf_motivodv.setText("153");
                            break;
                        case 210:
                            tf_motivodv.setText("213");
                            break;
                        case 220:
                            tf_motivodv.setText("223");
                            break;
                        case 230:
                            tf_motivodv.setText("233");
                            break;
                        case 410:
                            tf_motivodv.setText("413");
                            break;
                    }
                    numStatDev = Integer.parseInt(((Fxp_Archguip_pro_dv) tb_almr.getItems().get(tb_almr.getSelectionModel().getSelectedIndex())).getOrden());
                    tf_factdv.setText(String.valueOf(((Fxp_Archguip_pro_dv) tb_almr.getItems().get(tb_almr.getSelectionModel().getSelectedIndex())).getNumfact()));
                    tf_proddv.setText(String.valueOf(((Fxp_Archguip_pro_dv) tb_almr.getItems().get(tb_almr.getSelectionModel().getSelectedIndex())).getCodigo()));
                    tf_cantdv.setText(String.valueOf(((Fxp_Archguip_pro_dv) tb_almr.getItems().get(tb_almr.getSelectionModel().getSelectedIndex())).getICantFalt()));
                    tf_obserdv.setText(String.valueOf(((Fxp_Archguip_pro_dv) tb_almr.getItems().get(tb_almr.getSelectionModel().getSelectedIndex())).getObserv()));

                    tf_motivodv.requestFocus();
                }
            });

            final MenuItem changeMenuItem = new MenuItem("Cambiar otros");
            contextMenu.getItems().add(changeMenuItem);
            changeMenuItem.setOnAction((ActionEvent event) -> {
                if (tipoOperacion == 9){
                    numStatDev = Integer.parseInt(((Fxp_Archguip_pro_dv) tb_almr.getItems().get(tb_almr.getSelectionModel().getSelectedIndex())).getOrden());
                    tf_factdv.setText(String.valueOf(((Fxp_Archguip_pro_dv) tb_almr.getItems().get(tb_almr.getSelectionModel().getSelectedIndex())).getNumfact()));
                    tf_proddv.setText(String.valueOf(((Fxp_Archguip_pro_dv) tb_almr.getItems().get(tb_almr.getSelectionModel().getSelectedIndex())).getCodigo()));
                    tf_cantdv.setText(String.valueOf(((Fxp_Archguip_pro_dv) tb_almr.getItems().get(tb_almr.getSelectionModel().getSelectedIndex())).getICantFalt()));
                    tf_obserdv.setText(String.valueOf(((Fxp_Archguip_pro_dv) tb_almr.getItems().get(tb_almr.getSelectionModel().getSelectedIndex())).getObserv()));

                    tf_factdv.requestFocus();
                }
            });

            final MenuItem removeMenuItem = new MenuItem("Desactivar");
            contextMenu.getItems().add(removeMenuItem);
            removeMenuItem.setOnAction((ActionEvent event) -> {
                if (tipoOperacion == 9){
                    if (numFaltDev == 0){
                        tb_almr.getItems().remove(row.getItem());
                    }
                    else{
                        tb_almr.getItems().get(tb_almr.getSelectionModel().getSelectedIndex()).setStat_reg("A");
                        col_statreg.setVisible(false);
                        col_statreg.setVisible(true);
                    }
                        
                }
            });

            // Set context menu on row, but use a binding to make it only show for non-empty rows:
            row.contextMenuProperty().bind(
                    Bindings.when(row.emptyProperty())
                            .then((ContextMenu)null)
                            .otherwise(contextMenu)
            );
            return row ;  
        });
        
        //Se define el comportamiento de las teclas ARRIBA y ABAJO en la tabla
        EventHandler eh = new EventHandler<KeyEvent>(){
            @Override
            public void handle(KeyEvent ke){
                //Si fue presionado la tecla ARRIBA o ABAJO
                if (ke.getCode().equals(KeyCode.UP) || ke.getCode().equals(KeyCode.DOWN)){     
                    //Selecciona la FILA enfocada
                }
            }
        };
        //Se Asigna el comportamiento para que se ejecute cuando se suelta una tecla
        tb_almr.setOnKeyReleased(eh);    
    }

    
    /**
    * Metodo encargado de Crear e inicializar la Tabla de Datos
    */
    private void createTableStockRs(){
        //Se crean y definen las columnas de la Tabla
        TableColumn col_orden       = new TableColumn("#");        
        TableColumn col_unidad      = new TableColumn("Unid.");        
        TableColumn col_cant        = new TableColumn("Cant.");
        
        //Se establece el ancho de cada columna
        this.objectWidth(col_orden      , 30,  30);
        this.objectWidth(col_unidad     , 42,  42);
        this.objectWidth(col_cant       , 42,  42);

        col_unidad.setCellFactory(new Callback<TableColumn, TableCell>() {
            @Override
            public TableCell call(TableColumn param) {
                return new TableCell<Fxp_Archguip_sum, String>() {
                    @Override
                    public void updateItem(String item, boolean empty) {
                        super.updateItem(item, empty);
                        setText(empty ? null : getString());
                        setAlignment(Pos.CENTER);
                    }

                    private String getString() {
                        String ret = "";
                        if (getItem() != null) {
                            ret = getItem();
                            if (ret.equals("0"))
                                ret = "";
                        } else {
                            ret = "";
                        }
                        return ret;
                    }                
                };
            }
        });        

        col_cant.setCellFactory(new Callback<TableColumn, TableCell>() {
            @Override
            public TableCell call(TableColumn param) {
                return new TableCell<Fxp_Archguip_sum, Integer>() {
                    @Override
                    public void updateItem(Integer item, boolean empty) {
                        super.updateItem(item, empty);
                        setText(empty ? null : getString());
                        setAlignment(Pos.CENTER);
                    }

                    private String getString() {
                        String ret = "";
                        if (getItem() != null) {
                            ret = getItem().toString();
                            if (ret.equals("0"))
                                ret = "";
                        } else {
                            ret = "";
                        }
                        return ret;
                    }                
                };
            }
        });        

        //Se define la columna de la tabla con el nombre del atributo del objeto USUARIO correspondiente
        col_orden.setCellValueFactory( 
                new PropertyValueFactory<>("orden") );
        col_unidad.setCellValueFactory( 
                new PropertyValueFactory<>("uniddesp") );
        col_cant.setCellValueFactory( 
                new PropertyValueFactory<>("cantdesp") );
        
        //Se Asigna ordenadamente las columnas de la tabla
//        tb_almrs.getColumns().addAll(
//                col_cant, col_unidad
//                );                
        
        //Se define el comportamiento de las teclas ARRIBA y ABAJO en la tabla
        EventHandler eh = new EventHandler<KeyEvent>(){
            @Override
            public void handle(KeyEvent ke){
                //Si fue presionado la tecla ARRIBA o ABAJO
                if (ke.getCode().equals(KeyCode.UP) || ke.getCode().equals(KeyCode.DOWN)){     
                    //Selecciona la FILA enfocada
                }
            }
        };
        //Se Asigna el comportamiento para que se ejecute cuando se suelta una tecla
    }

    
    /**
    * Metodo encargado de Crear e inicializar la Tabla de Datos
    */
    private void createTableSada(){
        //Se crean y definen las columnas de la Tabla
        TableColumn col_orden       = new TableColumn("#");        
        TableColumn col_guide       = new TableColumn("Guia");
        
        //Se establece el ancho de cada columna
        this.objectWidth(col_orden      , 25,  25);
        this.objectWidth(col_guide      , 70,  70);

        col_guide.setCellFactory(TextFieldTableCell.forTableColumn());        

        col_guide.setOnEditCommit(
            new EventHandler<CellEditEvent<log_Guide_sada, String>>() {
                @Override
                public void handle(CellEditEvent<log_Guide_sada, String> t) {
                    ((log_Guide_sada) t.getTableView().getItems().get(
                            t.getTablePosition().getRow())
                            ).setGuias(t.getNewValue());
                }
            }
        );
        
        //Se define la columna de la tabla con el nombre del atributo del objeto USUARIO correspondiente
        col_orden.setCellValueFactory( 
                new PropertyValueFactory<>("orden") );
        col_guide.setCellValueFactory( 
                new PropertyValueFactory<>("guias") );
        
        //Se Asigna ordenadamente las columnas de la tabla
        tb_sada.getColumns().addAll(
                col_orden, col_guide
                );                
        
        //Se Asigna menu contextual 
        tb_sada.setRowFactory((TableView<log_Guide_sada> tableView) -> {
            final TableRow<log_Guide_sada> row = new TableRow<>();
            final ContextMenu contextMenu = new ContextMenu();
            final MenuItem removeMenuItem = new MenuItem("Eliminar Guia");
            removeMenuItem.setOnAction((ActionEvent event) -> {
                tb_sada.getItems().remove(row.getItem());
            });
            contextMenu.getItems().add(removeMenuItem);
            // Set context menu on row, but use a binding to make it only show for non-empty rows:
            row.contextMenuProperty().bind(
                    Bindings.when(row.emptyProperty())
                            .then((ContextMenu)null)
                            .otherwise(contextMenu)
            );
            return row ;  
        });
        
        //Se define el comportamiento de las teclas ARRIBA y ABAJO en la tabla
        EventHandler eh = new EventHandler<KeyEvent>(){
            @Override
            public void handle(KeyEvent ke){
                //Si fue presionado la tecla ARRIBA o ABAJO
                if (ke.getCode().equals(KeyCode.UP) || ke.getCode().equals(KeyCode.DOWN)){     
                    //Selecciona la FILA enfocada
//                    selectedRow();
                }
            }
        };
        //Se Asigna el comportamiento para que se ejecute cuando se suelta una tecla
        tb_sada.setOnKeyReleased(eh);    

    }
    
    
    /**
    * Metodo encargado de Crear e inicializar la Tabla de Datos
    */
    private void createTableInsopesca(){
        //Se crean y definen las columnas de la Tabla
        TableColumn col_orden       = new TableColumn("#");        
        TableColumn col_guide       = new TableColumn("Guia");
        
        //Se establece el ancho de cada columna
        this.objectWidth(col_orden      , 25,  25);
        this.objectWidth(col_guide      , 70,  70);

        col_guide.setCellFactory(TextFieldTableCell.forTableColumn());        

        col_guide.setOnEditCommit(
            new EventHandler<CellEditEvent<log_Guide_insopesca, String>>() {
                @Override
                public void handle(CellEditEvent<log_Guide_insopesca, String> t) {
                    ((log_Guide_insopesca) t.getTableView().getItems().get(
                            t.getTablePosition().getRow())
                            ).setGuias(t.getNewValue());
                }
            }
        );
        
        //Se define la columna de la tabla con el nombre del atributo del objeto USUARIO correspondiente
        col_orden.setCellValueFactory( 
                new PropertyValueFactory<>("orden") );
        col_guide.setCellValueFactory( 
                new PropertyValueFactory<>("guias") );
        
        //Se Asigna ordenadamente las columnas de la tabla
        tb_insopesca.getColumns().addAll(
                col_orden, col_guide
                );                
        
        //Se Asigna menu contextual 
        tb_insopesca.setRowFactory((TableView<log_Guide_insopesca> tableView) -> {
            final TableRow<log_Guide_insopesca> row = new TableRow<>();
            final ContextMenu contextMenu = new ContextMenu();
            final MenuItem removeMenuItem = new MenuItem("Eliminar Guia");
            removeMenuItem.setOnAction((ActionEvent event) -> {
                tb_insopesca.getItems().remove(row.getItem());
            });
            contextMenu.getItems().add(removeMenuItem);
            // Set context menu on row, but use a binding to make it only show for non-empty rows:
            row.contextMenuProperty().bind(
                    Bindings.when(row.emptyProperty())
                            .then((ContextMenu)null)
                            .otherwise(contextMenu)
            );
            return row ;  
        });
        
        //Se define el comportamiento de las teclas ARRIBA y ABAJO en la tabla
        EventHandler eh = new EventHandler<KeyEvent>(){
            @Override
            public void handle(KeyEvent ke){
                //Si fue presionado la tecla ARRIBA o ABAJO
                if (ke.getCode().equals(KeyCode.UP) || ke.getCode().equals(KeyCode.DOWN)){     
                    //Selecciona la FILA enfocada
//                    selectedRow();
                }
            }
        };
        //Se Asigna el comportamiento para que se ejecute cuando se suelta una tecla
        tb_insopesca.setOnKeyReleased(eh);    

    }
    
    
    /**
     * Metodo encargado de guardar los datos de un nueva guia o de una 
     * guia modificado
     */
    private boolean saveCGuias() {
        //Se asigna el valor del tipo de procedimiento que viene de ser ejecutado,
        // 1 si es una NUEVA guia
        // 2 si es una guia MODIFICADA
        int proceso = tipoOperacion;    

        String sPuerta = tf_pcarga.getText();
        String sChofer = tf_chofer.getText();
        String sVeh1 = tf_veh1.getText();
        String sCheqp = tf_cheqp.getText();
 
        if((sPuerta != null && !sPuerta.equals("")) 
            &&  (sChofer != null && !sChofer.equals(""))   
            &&  (sVeh1 != null && !sVeh1.equals(""))   
            &&  (sCheqp != null && !sCheqp.equals(""))){
            //Ejecuta los procesos predeterminados para el guardado de la guia
            setCurrentOperation();
            //Se asignan los valores del objeto 
            boolean result = false;
            log_CGuias log_cguias = new log_CGuias();
            log_CGuias_perm log_cguias_perm = new log_CGuias_perm();

            for (int i = 0; i < log_guide_guia.size(); i++) {
                log_cguias.setNumguia(tb_guias.getItems().get(i).getGuias());      
                log_cguias.setFecha(Date.valueOf(dp_fcarga.getValue()));
                log_cguias.setFecsalida(Date.valueOf(dp_fsalida.getValue()));
                log_cguias.setNumpuerta(Integer.parseInt(tf_pcarga.getText()));
                log_cguias.setTurno(Integer.parseInt(tf_turno.getText()));
                log_cguias.setOdometro(tf_odometro.getText());
                
                log_cguias.setIdsupruta(tf_supruta.getText());
                log_cguias.setNumfact(tb_guias.getItems().get(i).getNumfact());
                log_cguias.setNumclie(tb_guias.getItems().get(i).getNumclie());
                log_cguias.setStat_guia(tb_guias.getItems().get(i).getStat_guia());
                log_cguias.setAnulada(tb_guias.getItems().get(i).getAnulada());
                
                if (i == 0){
                    log_cguias.setChofer(tf_chofer.getText());
                    log_cguias.setVeh1(tf_veh1.getText().toUpperCase());
                    if ((tf_veh2.getText() != null) && (!tf_veh2.getText().isEmpty())){
                        log_cguias.setVeh2(tf_veh2.getText());
                    }
                    log_cguias.setAyud1(tf_ayud1.getText().toUpperCase());
                    if ((tf_ayud2.getText() != null) && (!tf_ayud2.getText().isEmpty())){
                        log_cguias.setAyud2(tf_ayud2.getText().toUpperCase());
                    }
                    log_cguias.setCheq_pta(tf_cheqp.getText());
                    log_cguias.setTcheq_pta(0);

                    if ((tf_cheqr1.getText() != null) && (!tf_cheqr1.getText().isEmpty())){
                        log_cguias.setCheq_r1(tf_cheqr1.getText());
                    }
                    if ((tf_cheqr2.getText() != null) && (!tf_cheqr2.getText().isEmpty())){
                        log_cguias.setCheq_r2(tf_cheqr2.getText());
                    }
                    if ((tf_cheqr3.getText() != null) && (!tf_cheqr3.getText().isEmpty())){
                        log_cguias.setCheq_r3(tf_cheqr3.getText());
                    }
                    if ((tf_cheqr4.getText() != null) && (!tf_cheqr4.getText().isEmpty())){
                        log_cguias.setCheq_r4(tf_cheqr4.getText());
                    }
                    if ((tf_cheqr5.getText() != null) && (!tf_cheqr5.getText().isEmpty())){
                        log_cguias.setCheq_r5(tf_cheqr5.getText());
                    }
                    if ((tf_cheqr6.getText() != null) && (!tf_cheqr6.getText().isEmpty())){
                        log_cguias.setCheq_r6(tf_cheqr6.getText());
                    }
                    if ((tf_cheqr7.getText() != null) && (!tf_cheqr7.getText().isEmpty())){
                        log_cguias.setCheq_r7(tf_cheqr7.getText());
                    }
                    if ((tf_cheqpq.getText() != null) && (!tf_cheqpq.getText().isEmpty())){
                        log_cguias.setCheq_pq(tf_cheqpq.getText());
                    }
                    
                    result = 
                            Ln.getInstance().save_log_CGuias(log_cguias, proceso, i);


                    // Guias Sada
                    if (numSadaCarga == 0)
                        proceso = 1; 

                    for (int j = 0; j < log_guide_sada.size(); j++) {
                        log_cguias_perm.setNumrela(Datos.getNumRela());
                        log_cguias_perm.setFecha(Date.valueOf(dp_fcarga.getValue()));
                        log_cguias_perm.setGuias(tb_sada.getItems().get(j).getGuias());
                        log_cguias_perm.setTpermiso(1);

                        result = 
                                Ln.getInstance().save_log_CGuias_perm(log_cguias_perm, proceso, j);
                    }
                    proceso = tipoOperacion;


                    // Guias Insopesca
                    if (numInsoCarga == 0)
                        proceso = 1; 

                    for (int j = 0; j < log_guide_insopesca.size(); j++) {
                        log_cguias_perm.setNumrela(Datos.getNumRela());
                        log_cguias_perm.setFecha(Date.valueOf(dp_fcarga.getValue()));
                        log_cguias_perm.setGuias(tb_insopesca.getItems().get(j).getGuias());
                        log_cguias_perm.setTpermiso(2);

                        result = 
                                Ln.getInstance().save_log_CGuias_perm(log_cguias_perm, proceso, j);
                    }
                    proceso = tipoOperacion;

                }
                else {
                    if (i == numGuias)
                        proceso = 1;

                    result = 
                            Ln.getInstance().save_log_CGuias(log_cguias, proceso, i);
                }
            }

            //Si el Resultado es correcto
            if(result){
                //Se Notifica al usuario
                tf_nroguia.setText(Datos.getNumRela());
                Gui.getInstance().showMessage("La relación de " + ScreenName + " se ha Guardado Correctamente!", "I");
                return true;
            }     
        }else{                            
            Gui.getInstance().showMessage("No Existe ninguna " + ScreenName + " para ser Guardado!", "A");
        }
        return true;
    }
    /**
     * Metodo encargado de guardar los datos de un nueva guia o de una 
     * guia modificado
     */
    private boolean saveMissing() {
        int proceso = 0; 
        if (numFaltCarga == 0)
            proceso = 1; 
        else    
            proceso = 2; 
        
        String sPuerta = tf_pcarga.getText();
        String sChofer = tf_chofer.getText();
        String sVeh1 = tf_veh1.getText();
        String sCheqp = tf_cheqp.getText();
 
        if((sPuerta != null && !sPuerta.equals("")) 
            &&  (sChofer != null && !sChofer.equals(""))   
            &&  (sVeh1 != null && !sVeh1.equals(""))   
            &&  (sCheqp != null && !sCheqp.equals(""))   ){
            setCurrentOperation();
            //Se asignan los valores del objeto 
            boolean result = false;
            log_CGuias_falt_cg log_cguias_falt = new log_CGuias_falt_cg();
        
            for (int j = 0; j < log_guide_missing.size(); j++) {
                log_cguias_falt.setNumrela(Datos.getNumRela());
                log_cguias_falt.setFecha(Date.valueOf(dp_faltcg.getValue()));
                log_cguias_falt.setNumguiac(tb_almm.getItems().get(j).getNumguia());
                log_cguias_falt.setNumguiaf(tb_almm.getItems().get(j).getNumfalt());
                log_cguias_falt.setNumncred(tb_almm.getItems().get(j).getNumncred());
                log_cguias_falt.setProducto(tb_almm.getItems().get(j).getCodigo());
                log_cguias_falt.setCantfact(tb_almm.getItems().get(j).getICantDesp());
                log_cguias_falt.setCantfalt(tb_almm.getItems().get(j).getICantFalt());
                if (tb_almm.getItems().get(j).getICantFalt() > tb_almm.getItems().get(j).getICantDesp()){
                    log_cguias_falt.setCantdesp((tb_almm.getItems().get(j).getICantDesp() * (tb_almm.getItems().get(j).getUniporem()) - tb_almm.getItems().get(j).getICantFalt()));
                }
                else{
                    log_cguias_falt.setCantdesp((tb_almm.getItems().get(j).getICantDesp() - tb_almm.getItems().get(j).getICantFalt()));
                }
                log_cguias_falt.setId_unidad(tb_almm.getItems().get(j).getUnidfalt());

                if (j == numFaltCarga)
                    proceso = 1;
                
                result = 
                        Ln.getInstance().save_log_CGuias_fcar(log_cguias_falt, proceso, j);
            }

            //Si el Resultado es correcto
            if(result){
                //Se Notifica al usuario
                tf_nroguia.setText(Datos.getNumRela());
                Gui.getInstance().showMessage("La relación de Faltante - Carga se ha Guardado Correctamente!", "I");
                //loadPersonal();            //Se Recarga la tabla de usuarios existentes
                return true;
            }     
        }else{                            
            Gui.getInstance().showMessage("No Existe ninguna Relación de Faltante - Carga para ser Guardado!", "A");
        }
        return true;
    }

    /**
     * Metodo encargado de guardar los datos de un nueva guia o de una 
     * guia modificado
     */
    private boolean saveRefund() {
        int proceso = 0; 
        if (numFaltDev == 0)
            proceso = 1; 
        else    
            proceso = 2; 

        String sPuerta = tf_pcarga.getText();
        String sChofer = tf_chofer.getText();
        String sVeh1 = tf_veh1.getText();
        String sCheqp = tf_cheqpdv.getText();
 
        if((sPuerta != null && !sPuerta.equals("")) 
            &&  (sChofer != null && !sChofer.equals(""))   
            &&  (sVeh1 != null && !sVeh1.equals(""))   
            &&  (sCheqp != null && !sCheqp.equals(""))   ){
            setCurrentOperation();
            //Se asignan los valores del objeto 
            boolean result = false;
            log_CGuias_falt_dv log_cguias_dev = new log_CGuias_falt_dv();

            // Guia Fecha Salida
            if(dp_fsalida.getValue() != null){
                log_CGuias log_cguias = new log_CGuias();
                log_cguias.setNumguia("0");
                log_cguias.setFecsalida(Date.valueOf(dp_faltdv.getValue()));
                result = Ln.getInstance().save_log_CGuias(log_cguias, 2, 2);
            }

            for (int j = 0; j < log_guide_refund.size(); j++) {
                log_cguias_dev.setNumrela(Datos.getNumRela());
                log_cguias_dev.setFec_carga(Date.valueOf(LocalDate.now()));
                log_cguias_dev.setNumdev(Datos.getNumRel_Dev());
                log_cguias_dev.setCheq_pta(tb_almr.getItems().get(j).getIdChequeador());
                log_cguias_dev.setNumdoc(tb_almr.getItems().get(j).getNumfact());
                log_cguias_dev.setProducto(tb_almr.getItems().get(j).getCodigo());
                log_cguias_dev.setId_motivo(tb_almr.getItems().get(j).getIdMotivo());
                log_cguias_dev.setCantfact(tb_almr.getItems().get(j).getICantDesp());
                log_cguias_dev.setCantdev(tb_almr.getItems().get(j).getICantFalt());
                if (tb_almr.getItems().get(j).getICantFalt() > tb_almr.getItems().get(j).getICantDesp()){
                    log_cguias_dev.setCantdesp((tb_almr.getItems().get(j).getICantDesp() * (tb_almr.getItems().get(j).getUniporem()) - tb_almr.getItems().get(j).getICantFalt()));
                }
                else{
                    log_cguias_dev.setCantdesp((tb_almr.getItems().get(j).getICantDesp() - tb_almr.getItems().get(j).getICantFalt()));
                }
                log_cguias_dev.setId_unidad(tb_almr.getItems().get(j).getUnidfalt());
                log_cguias_dev.setPre_marc(tb_almr.getItems().get(j).getPre_marc());
                log_cguias_dev.setPre_fact(tb_almr.getItems().get(j).getPre_fact());
                log_cguias_dev.setId_almacen(tb_almr.getItems().get(j).getIdAlmacen());
                log_cguias_dev.setObserv(tb_almr.getItems().get(j).getObserv());
                log_cguias_dev.setStat_reg(tb_almr.getItems().get(j).getStat_reg());

                if (j == numFaltDev){
                    proceso = 1;
                }
                
                result = 
                        Ln.getInstance().save_log_CGuias_fdev(log_cguias_dev, proceso, j);
            }

            //Si el Resultado es correcto
            if(result){
                //Se Notifica al usuario
                tf_nroguia.setText(String.valueOf(Datos.getNumRela()));
                Gui.getInstance().showMessage("La relación de Faltante - Devolución se ha Guardado Correctamente!", "I");
                return true;
            }     
        }else{                            
            Gui.getInstance().showMessage("No Existe ninguna Relación de Faltante - Devolución para ser Guardado!", "A");
        }
        return true;
    }

    /**
     * Procedimiento encargado de refrescar el formulario de la pantalla,
     * establece nuevos valores a cada campo de Texto
     */
    private void refreshForm(){       
        //tf_nroguia.setText(String.valueOf(Datos.getLog_cguias().getNumrela()));
        
        //Ejecuta el metodo que define el formulario segun el tipo de operacion que fue ejecutada
        setCurrentOperation();
    }  
    /**
     * Metodo que ejecuta los procesos de modificacion del formulario y otros, 
     * correspondientes al tipo de operacion que se este ejecutando
     */
    private void setCurrentOperation(){     
        boolean isNamesVisible = true;   //Valor logico si los campos de nombres y apellidos seran visibles
        Integer[] disables;              //Se declara el arreglo que contendra las posiciones de la TOOLBAR que seran DESHABILITADOS para cada operacion
        loadToolBar();                   //Se Refresca la barra de Herramientas
        lb_Title.setText("");            //Se deja en blanco la etiqueta del Titulo
        //Se evalua el tipo de Operacion
        switch(tipoOperacion){
            case 0:  //SOLO LECTURA                    
                tf_nroguia.setEditable(true);
                tf_nrorguia.setEditable(false);
                tf_pcarga.setEditable(false);
                tf_turno.setEditable(false);
                tf_odometro.setEditable(false);
                tf_chofer.setEditable(false);
                tf_veh1.setEditable(false);
                tf_veh2.setEditable(false);
                tf_ayud1.setEditable(false);
                tf_ayud2.setEditable(false);
                tf_cheqp.setEditable(false);
                tf_supruta.setEditable(false);
                tf_cheqr1.setEditable(false);
                tf_cheqr2.setEditable(false);
                tf_cheqr3.setEditable(false);
                tf_cheqr4.setEditable(false);
                tf_cheqr5.setEditable(false);
                tf_cheqr6.setEditable(false);
                tf_cheqr7.setEditable(false);
                tf_cheqpq.setEditable(false);

                tf_sada.setEditable(false);
                tf_insopesca.setEditable(false);

                tf_nrofguia.setEditable(false);
                tf_nrocguia.setEditable(false);
                tf_nrocred.setEditable(false);
                tf_prodcg.setEditable(false);
                tf_cantcg.setEditable(false);

                tf_cheqpdv.setEditable(false);
                tf_factdv.setEditable(false);
                tf_motivodv.setEditable(false);
                tf_proddv.setEditable(false);
                tf_cantdv.setEditable(false);
                tf_pmarcado.setEditable(false);
                tf_obserdv.setEditable(false);
                
                cb_unidcg.setDisable(true);
                cb_motivodv.setDisable(true);
                cb_uniddv.setDisable(true);
                
                dp_fcarga.setDisable(true);
                dp_fsalida.setDisable(true);
                dp_faltcg.setDisable(true);
                dp_faltdv.setDisable(true);
                       
                im_check.setVisible(false);
                im_val.setVisible(false);

                bt_c1.setDisable(true);
                bt_c2.setDisable(true);
                bt_c3.setDisable(true);
                bt_c4.setDisable(true);
                bt_c5.setDisable(true);
                bt_c6.setDisable(true);
                bt_c7.setDisable(true);
                bt_cr1.setDisable(true);
                bt_cr2.setDisable(true);
                bt_cr3.setDisable(true);
                bt_cr4.setDisable(true);
                bt_cr5.setDisable(true);
                bt_cr6.setDisable(true);
                bt_cr7.setDisable(true);
                bt_cpq.setDisable(true);

                bt_d1.setDisable(true);
                bt_d2.setDisable(true);
                bt_dpc.setDisable(true);
                bt_dpv.setDisable(true);
                bt_gc.setDisable(true);

                //SE PERMITE: NUEVO, CANCELAR Y BUSCAR
                //disables = new Integer[]{2,6,7,8,9,10};
                disables = new Integer[]{2,5,6,9,10};
                disableAllToolBar(disables); 
                hb_1.setVisible(true);
                break;
            case 1:  //NUEVO
//                lb_Title.setText(Tools.verticalText("NUEVO"));
                lb_Title.setText("NUEVO");
                tf_nroguia.setEditable(false);
                tf_nrorguia.setEditable(true);
                tf_pcarga.setEditable(true);
                tf_turno.setEditable(true);
                tf_odometro.setEditable(true);
                tf_chofer.setEditable(true);
                tf_veh1.setEditable(true);
                tf_veh2.setEditable(true);
                tf_ayud1.setEditable(true);
                tf_ayud2.setEditable(true);
                tf_cheqp.setEditable(true);
                tf_supruta.setEditable(true);
                tf_cheqr1.setEditable(true);
                tf_cheqr2.setEditable(true);
                tf_cheqr3.setEditable(true);
                tf_cheqr4.setEditable(true);
                tf_cheqr5.setEditable(true);
                tf_cheqr6.setEditable(true);
                tf_cheqr7.setEditable(true);
                tf_cheqpq.setEditable(true);

                tf_sada.setEditable(true);
                tf_insopesca.setEditable(true);

                tf_nrofguia.setEditable(true);
                tf_nrocguia.setEditable(true);
                tf_nrocred.setEditable(true);
                tf_prodcg.setEditable(true);
                tf_cantcg.setEditable(true);

                tf_cheqpdv.setEditable(false);
                tf_factdv.setEditable(false);
                tf_motivodv.setEditable(false);
                tf_proddv.setEditable(false);
                tf_cantdv.setEditable(false);
                tf_pmarcado.setEditable(false);
                tf_obserdv.setEditable(false);

                cb_unidcg.setDisable(false);
                cb_motivodv.setDisable(true);
                cb_uniddv.setDisable(true);
                
                dp_fcarga.setDisable(false);
                dp_fsalida.setDisable(false);
                dp_faltcg.setDisable(false);
                dp_faltdv.setDisable(true);
                
                im_check.setVisible(true);
                im_val.setVisible(false);

                bt_c1.setDisable(false);
                bt_c2.setDisable(false);
                bt_c3.setDisable(false);
                bt_c4.setDisable(false);
                bt_c5.setDisable(false);
                bt_c6.setDisable(false);
                bt_c7.setDisable(false);
                bt_cr1.setDisable(false);
                bt_cr2.setDisable(false);
                bt_cr3.setDisable(false);
                bt_cr4.setDisable(false);
                bt_cr5.setDisable(false);
                bt_cr6.setDisable(false);
                bt_cr7.setDisable(false);
                bt_cpq.setDisable(false);

                bt_d1.setDisable(false);
                bt_d2.setDisable(false);
                bt_dpc.setDisable(false);
                bt_gc.setDisable(false);
                bt_dpv.setDisable(false);

                //SE PERMITE: NUEVO,GUARDAR Y CANCELAR             
                disables = new Integer[]{0,1,3,4,6,7,8,9,10,11};
                disableAllToolBar(disables);                            
                break;
            case 2:  //EDITAR
//                lb_Title.setText(Tools.verticalText("EDITAR"));
                lb_Title.setText("EDITAR");
                tf_nroguia.setEditable(false);
                tf_nrorguia.setEditable(true);
                tf_pcarga.setEditable(true);
                tf_turno.setEditable(true);
                tf_odometro.setEditable(true);
                tf_chofer.setEditable(true);
                tf_veh1.setEditable(true);
                tf_veh2.setEditable(true);
                tf_ayud1.setEditable(true);
                tf_ayud2.setEditable(true);
                tf_cheqp.setEditable(true);
                tf_supruta.setEditable(true);
                tf_cheqr1.setEditable(true);
                tf_cheqr2.setEditable(true);
                tf_cheqr3.setEditable(true);
                tf_cheqr4.setEditable(true);
                tf_cheqr5.setEditable(true);
                tf_cheqr6.setEditable(true);
                tf_cheqr7.setEditable(true);
                tf_cheqpq.setEditable(true);

                tf_sada.setEditable(true);
                tf_insopesca.setEditable(true);

                tf_nrofguia.setEditable(false);
                tf_nrocguia.setEditable(false);
                tf_nrocred.setEditable(false);
                tf_prodcg.setEditable(false);
                tf_cantcg.setEditable(false);

                tf_cheqpdv.setEditable(false);
                tf_factdv.setEditable(false);
                tf_motivodv.setEditable(false);
                tf_proddv.setEditable(false);
                tf_cantdv.setEditable(false);
                tf_pmarcado.setEditable(false);
                tf_obserdv.setEditable(false);

                cb_unidcg.setDisable(true);
                cb_motivodv.setDisable(true);
                cb_uniddv.setDisable(true);
                
                dp_fcarga.setDisable(false);
                dp_fsalida.setDisable(false);
                dp_faltcg.setDisable(true);
                dp_faltdv.setDisable(true);
                
                im_check.setVisible(true);
                im_val.setVisible(false);
                
                bt_c1.setDisable(false);
                bt_c2.setDisable(false);
                bt_c3.setDisable(false);
                bt_c4.setDisable(false);
                bt_c5.setDisable(false);
                bt_c6.setDisable(false);
                bt_c7.setDisable(false);
                bt_cr1.setDisable(false);
                bt_cr2.setDisable(false);
                bt_cr3.setDisable(false);
                bt_cr4.setDisable(false);
                bt_cr5.setDisable(false);
                bt_cr6.setDisable(false);
                bt_cr7.setDisable(false);
                bt_cpq.setDisable(false);

                bt_d1.setDisable(true);
                bt_d2.setDisable(true);
                bt_dpc.setDisable(true);
                bt_dpv.setDisable(true);
                bt_gc.setDisable(true);

                //SE PERMITE: EDITAR,GUARDAR Y CANCELAR
                disables = new Integer[]{0,1,3,4,6,7,8,9,10,11};
                disableAllToolBar(disables);            
                break;
            case 3:  //GUARDAR
                tf_nroguia.setEditable(true);
                tf_nrorguia.setEditable(false);
                tf_pcarga.setEditable(false);
                tf_turno.setEditable(false);
                tf_odometro.setEditable(false);
                tf_chofer.setEditable(false);
                tf_veh1.setEditable(false);
                tf_veh2.setEditable(false);
                tf_ayud1.setEditable(false);
                tf_ayud2.setEditable(false);
                tf_cheqp.setEditable(false);
                tf_supruta.setEditable(false);
                tf_cheqr1.setEditable(true);
                tf_cheqr2.setEditable(true);
                tf_cheqr3.setEditable(true);
                tf_cheqr4.setEditable(true);
                tf_cheqr5.setEditable(true);
                tf_cheqr6.setEditable(true);
                tf_cheqr7.setEditable(true);
                tf_cheqpq.setEditable(true);

                tf_sada.setEditable(false);
                tf_insopesca.setEditable(false);

                tf_nrofguia.setEditable(false);
                tf_nrocguia.setEditable(false);
                tf_nrocred.setEditable(false);
                tf_prodcg.setEditable(false);
                tf_cantcg.setEditable(false);

                tf_cheqpdv.setEditable(false);
                tf_factdv.setEditable(false);
                tf_motivodv.setEditable(false);
                tf_proddv.setEditable(false);
                tf_cantdv.setEditable(false);
                tf_pmarcado.setEditable(false);
                tf_obserdv.setEditable(false);

                cb_unidcg.setDisable(true);
                cb_motivodv.setDisable(true);
                cb_uniddv.setDisable(true);
                
                dp_fcarga.setDisable(true);
                dp_fsalida.setDisable(true);
                dp_faltcg.setDisable(true);
                dp_faltdv.setDisable(true);
                
                im_check.setVisible(false);
                im_val.setVisible(false);

                bt_c1.setDisable(true);
                bt_c2.setDisable(true);
                bt_c3.setDisable(true);
                bt_c4.setDisable(true);
                bt_c5.setDisable(true);
                bt_c6.setDisable(true);
                bt_c7.setDisable(true);
                bt_cr1.setDisable(true);
                bt_cr2.setDisable(true);
                bt_cr3.setDisable(true);
                bt_cr4.setDisable(true);
                bt_cr5.setDisable(true);
                bt_cr6.setDisable(true);
                bt_cr7.setDisable(true);
                bt_cpq.setDisable(true);

                bt_d1.setDisable(true);
                bt_d2.setDisable(true);
                bt_dpc.setDisable(true);
                bt_dpv.setDisable(true);
                bt_gc.setDisable(true);

                //SE PERMITE: GUARDAR Y CANCELAR
                disables = new Integer[]{0,1,3,4,6,7,8,9,10,11};
                disableAllToolBar(disables);   
                break;
            case 4:  //CAMBIAR STATUS 
                tf_nroguia.setEditable(true);
                tf_nrorguia.setEditable(false);
                tf_pcarga.setEditable(false);
                tf_turno.setEditable(false);
                tf_odometro.setEditable(false);
                tf_chofer.setEditable(false);
                tf_veh1.setEditable(false);
                tf_veh2.setEditable(false);
                tf_ayud1.setEditable(false);
                tf_ayud2.setEditable(false);
                tf_cheqp.setEditable(false);
                tf_supruta.setEditable(false);
                tf_cheqr1.setEditable(false);
                tf_cheqr2.setEditable(false);
                tf_cheqr3.setEditable(false);
                tf_cheqr4.setEditable(false);
                tf_cheqr5.setEditable(false);
                tf_cheqr6.setEditable(false);
                tf_cheqr7.setEditable(false);
                tf_cheqpq.setEditable(false);

                tf_sada.setEditable(false);
                tf_insopesca.setEditable(false);

                tf_nrofguia.setEditable(false);
                tf_nrocguia.setEditable(false);
                tf_nrocred.setEditable(false);
                tf_prodcg.setEditable(false);
                tf_cantcg.setEditable(false);

                tf_cheqpdv.setEditable(false);
                tf_factdv.setEditable(false);
                tf_motivodv.setEditable(false);
                tf_proddv.setEditable(false);
                tf_cantdv.setEditable(false);
                tf_pmarcado.setEditable(false);
                tf_obserdv.setEditable(false);

                cb_unidcg.setDisable(true);
                cb_motivodv.setDisable(true);
                cb_uniddv.setDisable(true);
                
                dp_fcarga.setDisable(true);
                dp_fsalida.setDisable(true);
                dp_faltcg.setDisable(true);
                dp_faltdv.setDisable(true);
                
                im_check.setVisible(false);
                im_val.setVisible(false);

                bt_c1.setDisable(false);
                bt_c2.setDisable(false);
                bt_c3.setDisable(false);
                bt_c4.setDisable(false);
                bt_c5.setDisable(false);
                bt_c6.setDisable(false);
                bt_c7.setDisable(false);
                bt_cr1.setDisable(false);
                bt_cr2.setDisable(false);
                bt_cr3.setDisable(false);
                bt_cr4.setDisable(false);
                bt_cr5.setDisable(false);
                bt_cr6.setDisable(false);
                bt_cr7.setDisable(false);
                bt_cpq.setDisable(false);

                bt_d1.setDisable(false);
                bt_d2.setDisable(false);
                bt_dpc.setDisable(false);
                bt_dpv.setDisable(false);
                bt_gc.setDisable(false);

                //SE PERMITE: GUARDAR,CAMBIO STATUS Y CANCELAR
                //disables = new Integer[]{0,1,2,4,6,7,8,9,10,11};
                disables = new Integer[]{2,5,6,7,8,9,10};
                disableAllToolBar(disables); 
                break;
            case 8:  //Faltante en Carga
                lb_Title.setText("Falt.Car");
                tf_nroguia.setEditable(false);
                tf_nrorguia.setEditable(false);
                tf_pcarga.setEditable(false);
                tf_turno.setEditable(false);
                tf_odometro.setEditable(false);
                tf_chofer.setEditable(false);
                tf_veh1.setEditable(false);
                tf_veh2.setEditable(false);
                tf_ayud1.setEditable(false);
                tf_ayud2.setEditable(false);
                tf_cheqp.setEditable(false);
                tf_supruta.setEditable(false);
                tf_cheqr1.setEditable(false);
                tf_cheqr2.setEditable(false);
                tf_cheqr3.setEditable(false);
                tf_cheqr4.setEditable(false);
                tf_cheqr5.setEditable(false);
                tf_cheqr6.setEditable(false);
                tf_cheqr7.setEditable(false);
                tf_cheqpq.setEditable(false);

                tf_sada.setEditable(false);
                tf_insopesca.setEditable(false);

                tf_nrofguia.setEditable(true);
                tf_nrocguia.setEditable(true);
                tf_nrocred.setEditable(true);
                tf_prodcg.setEditable(true);
                tf_cantcg.setEditable(true);

                tf_cheqpdv.setEditable(false);
                tf_factdv.setEditable(false);
                tf_motivodv.setEditable(false);
                tf_proddv.setEditable(false);
                tf_cantdv.setEditable(false);
                tf_pmarcado.setEditable(false);
                tf_obserdv.setEditable(false);

                cb_unidcg.setDisable(false);
                cb_motivodv.setDisable(true);
                cb_uniddv.setDisable(true);
                
                dp_fcarga.setDisable(true);
                dp_faltcg.setDisable(false);
                dp_faltdv.setDisable(false);
                
                im_check.setVisible(true);
                im_val.setVisible(false);
                
                bt_c1.setDisable(true);
                bt_c2.setDisable(true);
                bt_c3.setDisable(true);
                bt_c4.setDisable(true);
                bt_c5.setDisable(true);
                bt_c6.setDisable(true);
                bt_c7.setDisable(true);
                bt_cr1.setDisable(true);
                bt_cr2.setDisable(true);
                bt_cr3.setDisable(true);
                bt_cr4.setDisable(true);
                bt_cr5.setDisable(true);
                bt_cr6.setDisable(true);
                bt_cr7.setDisable(true);
                bt_cpq.setDisable(true);

                bt_d1.setDisable(true);
                bt_d2.setDisable(true);
                bt_dpc.setDisable(false);
                bt_dpv.setDisable(true);
                bt_gc.setDisable(false);

                //SE PERMITE: EDITAR,GUARDAR Y CANCELAR
                disables = new Integer[]{0,1,3,4,6,7,8,9,10,11};
                disableAllToolBar(disables);            
                break;
            case 9:  //Faltante en Devolución
                lb_Title.setText("Falt.Dev");
                tf_nroguia.setEditable(false);
                tf_nrorguia.setEditable(false);
                tf_pcarga.setEditable(false);
                tf_turno.setEditable(false);
                tf_veh1.setEditable(false);
                tf_veh2.setEditable(false);
                tf_ayud1.setEditable(false);
                tf_ayud2.setEditable(false);
                tf_cheqp.setEditable(false);
                tf_supruta.setEditable(false);
                tf_cheqr1.setEditable(false);
                tf_cheqr2.setEditable(false);
                tf_cheqr3.setEditable(false);
                tf_cheqr4.setEditable(false);
                tf_cheqr5.setEditable(false);
                tf_cheqr6.setEditable(false);
                tf_cheqr7.setEditable(false);
                tf_cheqpq.setEditable(false);

                tf_sada.setEditable(false);
                tf_insopesca.setEditable(false);
                tf_nrofguia.setEditable(false);
                tf_nrocguia.setEditable(false);
                tf_prodcg.setEditable(false);
                tf_cantcg.setEditable(false);

                tf_cheqpdv.setEditable(true);
                tf_factdv.setEditable(true);
                tf_motivodv.setEditable(true);
                tf_proddv.setEditable(true);
                tf_cantdv.setEditable(true);
                tf_pmarcado.setEditable(true);
                tf_obserdv.setEditable(true);

                dp_fcarga.setDisable(true);
                cb_motivodv.setDisable(false);
                cb_uniddv.setDisable(false);
                
                dp_fcarga.setDisable(true);
                dp_faltcg.setDisable(false);
                dp_faltdv.setDisable(false);
                
                im_check.setVisible(true);
                im_val.setVisible(false);
                
                bt_c1.setDisable(true);
                bt_c2.setDisable(true);
                bt_c3.setDisable(true);
                bt_c4.setDisable(true);
                bt_c5.setDisable(true);
                bt_c6.setDisable(true);
                bt_c7.setDisable(true);
                bt_cr1.setDisable(true);
                bt_cr2.setDisable(true);
                bt_cr3.setDisable(true);
                bt_cr4.setDisable(true);
                bt_cr5.setDisable(true);
                bt_cr6.setDisable(true);
                bt_cr7.setDisable(true);
                bt_cpq.setDisable(true);

                bt_d1.setDisable(false);
                bt_d2.setDisable(false);
                bt_dpc.setDisable(true);
                bt_dpv.setDisable(false);
                bt_gc.setDisable(true);

                //SE PERMITE: EDITAR,GUARDAR Y CANCELAR
                disables = new Integer[]{0,1,3,4,6,7,8,9,10,11};
                disableAllToolBar(disables);            
                break;
        }        
        init_FocusArray(tipoOperacion);       
        Gui.getInstance().setTipoOperacion(tipoOperacion);
    }    
    /**
     * Procedimiento de llenado de datos en la tabla de datos
     */
    private void loadTableGuide_guias(){    
        if (tipoOperacion == 0){
            log_guide_guia.clear();
            tb_guias.setItems(log_guide_guia);
        }else{
            tb_guias.setItems(log_guide_guia);
            tb_guias.scrollTo(log_guide_guia.size());
        }
    }    
    /**
     * Procedimiento de llenado de datos en la tabla de datos
     */
    private void loadTableGuide_sada(){    
        if (tipoOperacion == 0){
            log_guide_sada.clear();
            tb_sada.setItems(log_guide_sada);
        }else{
            tb_sada.setItems(log_guide_sada);
            tb_sada.scrollTo(log_guide_sada.size());
        }
    }    
    /**
     * Procedimiento de llenado de datos en la tabla de datos
     */
    private void loadTableGuide_isopesca(){    
        if (tipoOperacion == 0){
            log_guide_insopesca.clear();
            tb_insopesca.setItems(log_guide_insopesca);
        }else{
            tb_insopesca.setItems(log_guide_insopesca);
            tb_insopesca.scrollTo(log_guide_insopesca.size());
        }
    }    
    /**
     * Procedimiento de llenado de datos en la tabla de datos
     */
    private void loadTableMissing(){    
        if (tipoOperacion == 0){
            log_guide_missing.clear();
            tb_almm.setItems(log_guide_missing);

            log_guide_credit.clear();
            tb_credit.setItems(log_guide_credit);
        }else{
            tb_almm.setItems(log_guide_missing);
            tb_almm.scrollTo(log_guide_missing.size());
        }
    } 
    /**
     * Procedimiento de llenado de datos en la tabla de datos
     */
    private void loadTableRefund(){    
        if (tipoOperacion == 0){
            log_guide_refund.clear();
            tb_almr.setItems(log_guide_refund);
        }else{
            tb_almr.setItems(log_guide_refund);
            if (numStatDev == 0){
                tb_almr.scrollTo(log_guide_refund.size());
            }
        }
    } 
    /**
     * Procedimiento de llenado de datos en la tabla de datos
     */
    private void loadTable(log_CGuias[] log_cguias){    
        if(log_cguias != null){
            Datos.setNumRela(log_cguias[0].getNumrela());

            ObservableList<xy> data = FXCollections.observableArrayList();
            data.addAll(Arrays.asList(log_cguias));   

            numGuias = data.size();
            
            log_guide_guia.clear();
            log_guide_credit.clear();

            for (int i = 0; i < data.size(); i++) {
                log_Guide_rel_inv guide_carga = new log_Guide_rel_inv();
                
                guide_carga.setNumorden(data.get(i).getNumorden());
                guide_carga.setGuias(data.get(i).getGuias());
                guide_carga.setNumfact(data.get(i).getNumfact());
                guide_carga.setNumclie(data.get(i).getNumclie());
                guide_carga.setStat_guia(data.get(i).getStat_guia());
                log_guide_guia.add(guide_carga);
            }
            tb_guias.setItems(log_guide_guia); 
            tb_guias.scrollTo(0);
            tb_credit.setItems(log_guide_credit);
            tb_credit.scrollTo(0);

            
            log_guide_sada.clear();
            log_guide_insopesca.clear();
            Datos.setRep_log_cguias_perm(Ln.getInstance().find_log_CGuias_perm(Datos.getNumRela()));
            ObservableList<log_CGuias_perm> data_perm = FXCollections.observableArrayList();
            data_perm.addAll(Arrays.asList(Datos.getRep_log_cguias_perm()));   

            for (int i = 0; i < data_perm.size(); i++) {
                log_Guide_sada guide_sada = new log_Guide_sada();
                log_Guide_insopesca guide_insopesca = new log_Guide_insopesca();
                
                switch (data_perm.get(i).getTpermiso()){
                    case 1:
                        guide_sada.setOrden(data_perm.get(i).getNumorden());
                        guide_sada.setGuias(data_perm.get(i).getGuias());
                        log_guide_sada.add(guide_sada);
                        break;
                    case 2:
                        guide_insopesca.setOrden(data_perm.get(i).getNumorden());
                        guide_insopesca.setGuias(data_perm.get(i).getGuias());
                        log_guide_insopesca.add(guide_insopesca);
                        break;
                }
            }
            tb_sada.setItems(log_guide_sada);
            tb_insopesca.setItems(log_guide_insopesca);

            numSadaCarga = log_guide_sada.size();
            numInsoCarga = log_guide_insopesca.size();
            
           
            dp_faltcg.setValue(log_cguias[0].getFecha().toLocalDate());
            log_guide_missing.clear();
            Datos.setRep_log_cguias_fcar(Ln.getInstance().find_log_CGuias_fcar(Datos.getNumRela()));
            ObservableList<log_CGuias_falt_cg> data_fcar = FXCollections.observableArrayList();
            data_fcar.addAll(Arrays.asList(Datos.getRep_log_cguias_fcar()));   

            numFaltCarga = data_fcar.size();
            for (int i = 0; i < data_fcar.size(); i++) {
                Fxp_Archguip_pro_cg log_cguias_falt = new Fxp_Archguip_pro_cg();
                
                if (i == 0){
                    dp_faltcg.setValue(data_fcar.get(i).getFecha().toLocalDate());
                }

                log_cguias_falt.setOrden(data_fcar.get(i).getNumorden());
                log_cguias_falt.setNumfalt(data_fcar.get(i).getNumguiac());
                log_cguias_falt.setNumguia(data_fcar.get(i).getNumguiaf());
                log_cguias_falt.setNumncred(data_fcar.get(i).getNumncred());
                log_cguias_falt.setCodigo(data_fcar.get(i).getProducto());
                log_cguias_falt.setUnidad(data_fcar.get(i).getProdunid());
                log_cguias_falt.setDescrip(data_fcar.get(i).getDescrip());
                log_cguias_falt.setICantDesp(data_fcar.get(i).getCantfact());
                log_cguias_falt.setSCantDesp(data_fcar.get(i).getCantfact() + " " + data_fcar.get(i).getUnidad());
                log_cguias_falt.setICantFalt(data_fcar.get(i).getCantfalt());
                log_cguias_falt.setSCantFalt(data_fcar.get(i).getCantfalt() + " " + data_fcar.get(i).getUnidad());
                log_cguias_falt.setUnidfalt(data_fcar.get(i).getId_unidad());
                log_guide_missing.add(log_cguias_falt);
            }
            tb_almm.setItems(log_guide_missing);
            tb_almm.scrollTo(0);
            
            
            dp_faltdv.setValue(LocalDate.now());
            log_guide_refund.clear();
            Datos.setRep_log_cguias_fdev(Ln.getInstance().find_log_CGuias_fdev(Datos.getNumRela()));
            ObservableList<log_CGuias_falt_dv> data_fdev = FXCollections.observableArrayList();
            data_fdev.addAll(Arrays.asList(Datos.getRep_log_cguias_fdev()));   

            numFaltDev = data_fdev.size();
            for (int i = 0; i < data_fdev.size(); i++) {
                Fxp_Archguip_pro_dv log_cguias_dev = new Fxp_Archguip_pro_dv();
                
                if (i == 0){
                    Datos.setNumRel_Dev(data_fdev.get(i).getNumdev());
                    tf_cheqpdv.setText(data_fdev.get(i).getCheq_pta());
                    lb_cheqpdv.setText(data_fdev.get(i).getScheq_pta());
                }

                log_cguias_dev.setOrden(data_fdev.get(i).getNumorden());
                log_cguias_dev.setIdChequeador(data_fdev.get(i).getCheq_pta());
                log_cguias_dev.setNumfact(data_fdev.get(i).getNumdoc());
                log_cguias_dev.setCodigo(data_fdev.get(i).getProducto());
                log_cguias_dev.setUnidad(data_fdev.get(i).getProdunid());
                log_cguias_dev.setDescrip(data_fdev.get(i).getDescrip());
                log_cguias_dev.setICantDesp(data_fdev.get(i).getCantfact());
                log_cguias_dev.setSCantDesp(data_fdev.get(i).getCantfact() + " " + data_fdev.get(i).getUnidad());
                log_cguias_dev.setICantFalt(data_fdev.get(i).getCantdev());
                log_cguias_dev.setSCantFalt(data_fdev.get(i).getCantdev()+ " " + data_fdev.get(i).getUnidad());
                log_cguias_dev.setIdMotivo(data_fdev.get(i).getId_motivo());
                log_cguias_dev.setSmotivo(data_fdev.get(i).getMotivo());
                log_cguias_dev.setUnidfalt(data_fdev.get(i).getId_unidad());
                log_cguias_dev.setPre_marc(data_fdev.get(i).getPre_marc());
                log_cguias_dev.setPre_fact(data_fdev.get(i).getPre_fact());
                log_cguias_dev.setIdAlmacen(data_fdev.get(i).getId_almacen());
                log_cguias_dev.setObserv(data_fdev.get(i).getObserv());
                log_cguias_dev.setStat_reg(data_fdev.get(i).getStat_reg());
                log_guide_refund.add(log_cguias_dev);
            }
            tb_almr.setItems(log_guide_refund);
            tb_almr.scrollTo(0);
            
            
            numCompDevCar = 0;
            tf_nroguia.setText(String.valueOf(log_cguias[0].getNumrela()));
            if(log_cguias[0].getFecha() == null){
                dp_fcarga.setValue(LocalDate.now());
            }
            else{
                dp_fcarga.setValue(log_cguias[0].getFecha().toLocalDate());
            }
            if(log_cguias[0].getFecsalida() == null){
                dp_fsalida.setValue(LocalDate.now());
                dp_faltdv.setValue(LocalDate.now());
            }
            else{
                dp_fsalida.setValue(log_cguias[0].getFecsalida().toLocalDate());
                dp_faltdv.setValue(log_cguias[0].getFecsalida().toLocalDate());
            }
            if (log_cguias[0].getAyud1() == null){
                numCompDevCar +=1;
            }
            tf_pcarga.setText(String.valueOf(log_cguias[0].getNumpuerta()));
            tf_turno.setText(String.valueOf(log_cguias[0].getTurno()));
            tf_odometro.setText(log_cguias[0].getOdometro());
            tf_chofer.setText(log_cguias[0].getChofer());
            tf_veh1.setText(log_cguias[0].getVeh1());
            tf_veh2.setText(log_cguias[0].getVeh2());
            if (log_cguias[0].getAyud1() == null){
                tf_ayud1.setText("");
            }
            else{
                tf_ayud1.setText(log_cguias[0].getAyud1());
            }
            if (log_cguias[0].getAyud2() == null){
                tf_ayud2.setText("");
            }
            else{
                tf_ayud2.setText(log_cguias[0].getAyud2());
            }
            if (log_cguias[0].getIdsupruta() == null){
                tf_supruta.setText("");
            }
            else{
                tf_supruta.setText(log_cguias[0].getIdsupruta());
            }
            tf_cheqp.setText(log_cguias[0].getCheq_pta());
            if (log_cguias[0].getCheq_r1()== null){
                tf_cheqr1.setText("");
            }
            else{
                tf_cheqr1.setText(log_cguias[0].getCheq_r1());
            }
            if (log_cguias[0].getCheq_r2()== null){
                tf_cheqr2.setText("");
            }
            else{
                tf_cheqr2.setText(log_cguias[0].getCheq_r2());
            }
            if (log_cguias[0].getCheq_r3()== null){
                tf_cheqr3.setText("");
            }
            else{
                tf_cheqr3.setText(log_cguias[0].getCheq_r3());
            }
            if (log_cguias[0].getCheq_r4()== null){
                tf_cheqr4.setText("");
            }
            else{
                tf_cheqr4.setText(log_cguias[0].getCheq_r4());
            }
            if (log_cguias[0].getCheq_r5()== null){
                tf_cheqr5.setText("");
            }
            else{
                tf_cheqr5.setText(log_cguias[0].getCheq_r5());
            }
            if (log_cguias[0].getCheq_r6()== null){
                tf_cheqr6.setText("");
            }
            else{
                tf_cheqr6.setText(log_cguias[0].getCheq_r6());
            }
            if (log_cguias[0].getCheq_r7()== null){
                tf_cheqr7.setText("");
            }
            else{
                tf_cheqr7.setText(log_cguias[0].getCheq_r7());
            }
            if (log_cguias[0].getCheq_pq()== null){
                tf_cheqpq.setText("");
            }
            else{
                tf_cheqpq.setText(log_cguias[0].getCheq_pq());
            }
            lb_chofer.setText(log_cguias[0].getSchofer());
            lb_ayud1.setText(log_cguias[0].getSayud1());
            lb_supruta.setText(log_cguias[0].getSsup_ruta());
            lb_cheqp.setText(log_cguias[0].getScheq_pta());
            
            cheqs = new TextField[]{tf_cheqr1, tf_cheqr2, tf_cheqr3, tf_cheqr4, tf_cheqr5, tf_cheqr6, tf_cheqr7, tf_cheqpq};        
            cheqtips = new String[]{
                tf_cheqr1.getText() + " ",
                tf_cheqr2.getText() + " ",
                tf_cheqr3.getText() + " ",
                tf_cheqr4.getText() + " ",
                tf_cheqr5.getText() + " ",
                tf_cheqr6.getText() + " ",
                tf_cheqr7.getText() + " ",
                tf_cheqpq.getText() + " "
                };
            //se asigna la etiqueta a su respectivo textfield
            for (int i = 0; i < cheqs.length; i++) {            
                Tooltip tip_tool = new Tooltip(cheqtips[i]);
                Tooltip.install(cheqs[i], tip_tool);
            }

        tp_carga.setExpanded(true);
        }
        else {
            botonInicio();
        }
    } 
    /**
     * Procedimiento de llenado de datos en la tabla de datos
     */
    private void loadTables(String NroGuia){
        log_Guide log_guide = new log_Guide();
        
        if (NroGuia.isEmpty()){
            tb_factura.setItems(null);
            tb_alm1.setItems(null);
            tb_alm1s.setItems(null);
            tb_alm2.setItems(null);
            tb_alm2s.setItems(null);
            tb_alm3.setItems(null);
            tb_alm3s.setItems(null);
            tb_alm4.setItems(null);
            tb_alm4s.setItems(null);
            tb_alm5.setItems(null);
            tb_alm5s.setItems(null);
            tb_alm6.setItems(null);
            tb_alm6s.setItems(null);
            tb_alm7.setItems(null);
            tb_alm7s.setItems(null);
            tb_almp.setItems(null);
            tb_almps.setItems(null);
            tb_almm.setItems(null);
            tb_almr.setItems(null);

            tb_credit.setItems(null);
        }else{
            log_guide.setTp_factura(Ln.getInstance().find_Archguid(NroGuia, ""));
            loadTableBill(tb_factura, log_guide.getTp_factura() );     


            log_guide.setTp_stock1(Ln.getInstance().find_Archguip_det(NroGuia, "1"));
            loadTableStockDet(tb_alm1, log_guide.getTp_stock1());     

            log_guide.setSm_stock1(Ln.getInstance().find_Archguip_sum(NroGuia, "1"));
            loadTableStockSum(tb_alm1s, log_guide.getSm_stock1());     


            log_guide.setTp_stock2(Ln.getInstance().find_Archguip_det(NroGuia, "2"));
            loadTableStockDet(tb_alm2, log_guide.getTp_stock2());     

            log_guide.setSm_stock2(Ln.getInstance().find_Archguip_sum(NroGuia, "2"));
            loadTableStockSum(tb_alm2s, log_guide.getSm_stock2());     


            log_guide.setTp_stock3(Ln.getInstance().find_Archguip_det(NroGuia, "3"));
            loadTableStockDet(tb_alm3, log_guide.getTp_stock3());     

            log_guide.setSm_stock3(Ln.getInstance().find_Archguip_sum(NroGuia, "3"));
            loadTableStockSum(tb_alm3s, log_guide.getSm_stock3());     


            log_guide.setTp_stock4(Ln.getInstance().find_Archguip_det(NroGuia, "4"));
            loadTableStockDet(tb_alm4, log_guide.getTp_stock4());     

            log_guide.setSm_stock4(Ln.getInstance().find_Archguip_sum(NroGuia, "4"));
            loadTableStockSum(tb_alm4s, log_guide.getSm_stock4());     


            log_guide.setTp_stock5(Ln.getInstance().find_Archguip_det(NroGuia, "5"));
            loadTableStockDet(tb_alm5, log_guide.getTp_stock5());     

            log_guide.setSm_stock5(Ln.getInstance().find_Archguip_sum(NroGuia, "5"));
            loadTableStockSum(tb_alm5s, log_guide.getSm_stock5());     


            log_guide.setTp_stock6(Ln.getInstance().find_Archguip_det(NroGuia, "6"));
            loadTableStockDet(tb_alm6, log_guide.getTp_stock6());     

            log_guide.setSm_stock6(Ln.getInstance().find_Archguip_sum(NroGuia, "6"));
            loadTableStockSum(tb_alm6s, log_guide.getSm_stock6());     


            log_guide.setTp_stock6(Ln.getInstance().find_Archguip_det(NroGuia, "7"));
            loadTableStockDet(tb_alm6, log_guide.getTp_stock7());     

            log_guide.setSm_stock6(Ln.getInstance().find_Archguip_sum(NroGuia, "7"));
            loadTableStockSum(tb_alm6s, log_guide.getSm_stock7());     


            log_guide.setTp_stockp1(Ln.getInstance().find_Archguip_det(NroGuia, "P"));
            loadTableStockDet(tb_almp, log_guide.getTp_stockp1());     

            log_guide.setSm_stockp1(Ln.getInstance().find_Archguip_sum(NroGuia, "P"));
            loadTableStockSum(tb_almps, log_guide.getSm_stockp1());     
        }
    }
    /**
     * Procedimiento de llenado de datos en la tabla de datos
     */
    private void loadTableBill(TableView <Fxp_Archguid> tb_view, Fxp_Archguid[] archguid){    
        if(archguid != null){
            ObservableList<Fxp_Archguid> data = FXCollections.observableArrayList();        
            data.addAll(Arrays.asList(archguid));   
            tb_view.setItems(data);        
        }
    }    
    /**
     * Procedimiento de llenado de datos en la tabla de datos
     */
    private void loadTableStockDet(TableView <Fxp_Archguip_det> tb_view, Fxp_Archguip_det[] archguip){    
        if(archguip != null){
            ObservableList<Fxp_Archguip_det> data = FXCollections.observableArrayList();        
            data.addAll(Arrays.asList(archguip));   
            tb_view.setItems(data);        
        }
        
    } 
    /**
     * Procedimiento de llenado de datos en la tabla de datos
     */
    private void loadTableStockSum(TableView <Fxp_Archguip_sum> tb_view, Fxp_Archguip_sum[] archguip){    
        if(archguip != null){
            ObservableList<Fxp_Archguip_sum> data = FXCollections.observableArrayList();        
            data.addAll(Arrays.asList(archguip));   
            tb_view.setItems(data);        
        }
    } 
    /**
     * Metodo que selecciona y llena el formulario con los datos del usuario 
     * seleccionado en la tabla
     */
    private void selectedRowGuide(){
        xy log_guide_rel_inv  = tb_guias.getSelectionModel().getSelectedItem();          
        loadTables(log_guide_rel_inv.getGuias());
        
        List<Fxp_Archguid_gfc> data = Ln.getList_log_Archguid_gfc(Ln.getInstance().find_Archguid_gfc(log_guide_rel_inv.getGuias()));

        tp_factura.setText(
            "Relación de Guia / Facturas / Clientes " + 
            "               -          " + 
            data.size() + " / " + 
            data.get(0).getNumfact() + " / " + 
            data.get(0).getNumclie());
    }
    /**
     * Metodo que selecciona y llena el formulario con los datos del usuario 
     * seleccionado en la tabla
     */
    private void selectedRowInvoice(){
        //numOrdenInv = tb_factura.getSelectionModel().getSelectedIndex();
    }
    /**
     * Metodo que selecciona y llena el formulario con los datos del usuario 
     * seleccionado en la tabla
     */
    private void selectedRowAlmm(){
        Fxp_Archguip_pro_cg archguip_pro  = tb_almm.getSelectionModel().getSelectedItem();          
        log_Guide_rel_cred log_Guide_cred = new log_Guide_rel_cred();
        log_Guide_cred.setTb_factura(Ln.getInstance().find_Archguid(archguip_pro.getNumguia(), archguip_pro.getCodigo()));
        loadTableBill(tb_credit, log_Guide_cred.getTb_factura() );     
    }
    /**
     * Metodo que selecciona y llena el formulario con los datos del usuario 
     * seleccionado en la tabla
     */
    private void selectedRowCredit(){
//        Fxp_Archguid archguid  = tb_credit.getSelectionModel().getSelectedItem();  
//
//        tooltips = new String[]{
//            " Num. de Guia: "  + archguid.getNumguia()
//            };
//
//        Tooltip tip_tool = new Tooltip(tooltips[0]);
//        Tooltip.install(tb_credit, tip_tool);
    }
    /**
     * Procedimiento que obtiene los Distintos Unidades de la BD
     * y los carga en el COMBOBOX
     */
    private void loadUnits(){        
        Unit[] unit = Ln.getInstance().load_Unit();        
        final ObservableList<Unit> data = FXCollections.observableArrayList();
        data.addAll(Arrays.asList(unit)); 

        cb_unidcg.setItems(data); 
        Datos.setCbUnit(cb_unidcg);                       
        new SelectKeyComboBoxListener(cb_unidcg); 

        cb_uniddv.setItems(data); 
        Datos.setCbUnit(cb_uniddv);                       
        new SelectKeyComboBoxListener(cb_uniddv); 
    }  
    /**
     * Procedimiento que obtiene los Distintos Motivos de la BD
     * y los carga en el COMBOBOX
     */
    private void loadTMotdev(){        
        log_TMotdev[] log_tmotdev = Ln.getInstance().load_log_TMotdev();        
        final ObservableList<log_TMotdev> data = FXCollections.observableArrayList();
        data.addAll(Arrays.asList(log_tmotdev)); 
        cb_motivodv.setItems(data); 
        Datos.setCbLog_tmotdev(cb_motivodv);              
        //new AutoCompleteComboBoxListener<>(cb_motivodv);
        new SelectKeyComboBoxListener(cb_motivodv);
        //AutoCompleteComboBoxListener<Object> handler = new AutoCompleteComboBoxListener<>(cb_motivodv);
//        priorityComboBox.setValue("Normal");
//        priorityComboBox.setCellFactory(
//            new Callback<ListView<String>, ListCell<String>>() {
//                @Override public ListCell<String> call(ListView<String> param) {
//                    final ListCell<String> cell = new ListCell<String>() {
//                        {
//                            super.setPrefWidth(100);
//                        }
//                        @Override public void updateItem(String item, 
//                            boolean empty) {
//                                super.updateItem(item, empty);
//                                if (item != null) {
//                                    setText(item);    
//                                    if (item.contains("High")) {
//                                        setTextFill(Color.RED);
//                                    }
//                                    else if (item.contains("Low")){
//                                        setTextFill(Color.GREEN);
//                                    }
//                                    else {
//                                        setTextFill(Color.BLACK);
//                                    }
//                                }
//                                else {
//                                    setText(null);
//                                }
//                            }
//                };
//                return cell;
//            }
//        });
    }  
    private void loadCheqTips(){ 
        cheqs = new TextField[]{tf_cheqr1, tf_cheqr2, tf_cheqr3, tf_cheqr4, tf_cheqr5, tf_cheqr6, tf_cheqr7, tf_cheqpq};        
        cheqtips = new String[]{
            " ",
            " ",
            " ",
            " ",
            " ",
            " ",
            " ",
            " ",
            };
        //se asigna la etiqueta a su respectivo textfield
        for (int i = 0; i < cheqs.length; i++) {            
            Tooltip tip_tool = new Tooltip(cheqtips[i]);
            Tooltip.install(cheqs[i], tip_tool);
        }
    }    

    /***************************************************************************/
    /************************ METODOS DE ACCESO RAPIDO *************************/
    /***************************************************************************/
        
    /**
     * Metodo que define el arreglo de NODOS del formulario que podran ser
     * enfocados con las teclas
     * @param opc 
     */
    private void init_FocusArray(int opc){
        Gui.setFieldsType(opc);
        //Se definen los NODOS del formulario que estaran activos segun la operacion
        //y se inicializa la posicion del foco
        Node[] nodos = null;
        switch(opc){
            case 0:     //SOLO LECTURA
                nodos = new Node[]{
                    dp_fcarga, tf_pcarga, tf_turno, tf_odometro, tf_chofer, tf_veh1, tf_veh2, 
                    tf_ayud1, tf_ayud2, tf_supruta, tf_cheqp, 
                    tf_cheqr1, tf_cheqr2, tf_cheqr3, tf_cheqr4, tf_cheqr5, 
                    tf_cheqr6, tf_cheqr7, tf_cheqpq, 
                    dp_faltcg, tf_nrofguia, tf_nrocguia, tf_nrocred, tf_prodcg, 
                    tf_cantcg, cb_unidcg,
                    dp_faltdv, tf_cheqpdv, tf_factdv, cb_motivodv,
                    tf_proddv, tf_cantdv, cb_uniddv, tf_obserdv};
                break;
            case 1:     //NUEVO
                nodos = new Node[]{
                    dp_fcarga, tf_pcarga, tf_turno, tf_odometro, tf_chofer, bt_c1, tf_veh1, 
                    bt_c2, tf_veh2, bt_c3, tf_ayud1, bt_c4, tf_ayud2, bt_c5, 
                    tf_supruta, bt_c7, tf_cheqp, bt_c6, 
                    tf_cheqr1, bt_cr1, tf_cheqr2, bt_cr2, tf_cheqr3, bt_cr3, 
                    tf_cheqr4, bt_cr4, tf_cheqr5, bt_cr5, tf_cheqr6, bt_cr6, 
                    tf_cheqr7, bt_cr7, tf_cheqpq, bt_cpq, 
                    dp_faltcg, tf_nrofguia, tf_nrocguia, tf_nrocred, tf_prodcg, 
                    tf_cantcg, cb_unidcg,
                    dp_faltdv, tf_cheqpdv, bt_d1, tf_factdv, bt_d2, cb_motivodv,
                    tf_proddv, tf_cantdv, cb_uniddv, tf_pmarcado, tf_obserdv};
                break;
            case 2:     //EDITAR
                nodos = new Node[]{
                    dp_fcarga, tf_pcarga, tf_turno, tf_odometro, tf_chofer, bt_c1, tf_veh1, 
                    bt_c2, tf_veh2, bt_c3, tf_ayud1, bt_c4, tf_ayud2, bt_c5, 
                    tf_supruta, bt_c7, tf_cheqp, bt_c6, 
                    tf_cheqr1, bt_cr1, tf_cheqr2, bt_cr2, tf_cheqr3, bt_cr3, 
                    tf_cheqr4, bt_cr4, tf_cheqr5, bt_cr5, tf_cheqr6, bt_cr6, 
                    tf_cheqr7, bt_cr7, tf_cheqpq, bt_cpq, 
                    dp_faltcg, tf_nrofguia, tf_nrocguia, tf_nrocred, tf_prodcg, 
                    tf_cantcg, cb_unidcg,
                    dp_faltdv, tf_cheqpdv, bt_d1, tf_factdv, bt_d2, cb_motivodv,
                    tf_proddv, tf_cantdv, cb_uniddv, tf_pmarcado, tf_obserdv};
                break;
            case 8:     //Faltante en Carga
                nodos = new Node[]{
                    dp_faltcg, tf_nrofguia, tf_nrocguia, tf_nrocred, tf_prodcg, 
                    tf_cantcg, cb_unidcg};
                break;
            case 9:     //Faltante en Devolucion 
                nodos = new Node[]{
                    dp_faltdv, tf_cheqpdv, bt_d1, tf_factdv, bt_d2, tf_motivodv, 
                    cb_motivodv, tf_proddv, tf_cantdv, cb_uniddv, tf_pmarcado, 
                    tf_obserdv, dp_faltcg, tf_nrofguia, tf_nrocguia, tf_prodcg, 
                    tf_cantcg, cb_unidcg};
                break;
        }             
        switch (opc){
            case 1: 
            case 2: 
            case 3:
                Gui.setFields(nodos); 
                Gui.setFieldFocused(0);
                Gui.setFieldsSize(nodos.length);
                break;
                
            case 8: 
            case 9:
                Gui.setFields(nodos); 
                Gui.setFieldFocused(0);
                Gui.setFieldsSize(nodos.length);
                break;
        }

        //Inicializo los Listeners de cada uno de los NODOS del formulario
        for(int i=0;i < Gui.getFields().length; i++){
            FocusPropertyChangeListener fpcl = new FocusPropertyChangeListener(Gui.getFields()[i],i);
            Gui.getFields()[i].focusedProperty().addListener(fpcl);                
        }
    }  
    /**
     * Metodo encargado de cambiar el FOCUS entre los nodos del Formulario y 
     * ejecutar los procedimientos correspondientes.
     */
    private void nextFocusedField(KeyEvent ke) {
        Gui.sumFieldFocused();  //Aumenta el contador
        //Si el foco esta en algun nodo del formulario 
        if(Gui.getFieldFocused() < Gui.getFieldsSize()){
            //Se Enfoca el nuevo nodo correspondiente
            Gui.getFields()[Gui.getFieldFocused()].requestFocus();            
        }                
    }
    
    /***************************************************************************/
    /**************************** METODOS DE TOOLBAR ***************************/
    /***************************************************************************/
    
    /**
     * Inicializa la TOOLBAR, carga de la BD la configuracion del usuario, define el orden de los botones 
     * y asigna los TOOLTIPS de cada boton.
     */
    private void defineToolBar() {
        //ARREGLO CON LOS BOTONES ORDENADOS POR POSICION
        tools = new ImageView[]{im_tool1,im_tool2,im_tool3,im_tool4,im_tool5,im_tool6,im_tool7,im_tool8,im_tool9,im_tool10,im_tool11,im_tool12};        
        //CARGA DE LA BD LA CONFIGURACION DE USUARIO PARA LA PANTALLA
        toolsConfig = Ln.getInstance().loadToolBar();
        // arreglo con cada etiqueta, ordenado por boton
        tooltips = new String[]{
            "Nueva " + ScreenName + " ",
            "Editar " + ScreenName + " ",
            "Guardar " + ScreenName + " ",
            "Cambiar Status de " + ScreenName + " ",
            "Imprimir " + ScreenName + " ",
            "Cancelar ",
            "Sin Asignar ",
            "Faltante en " + ScreenName + " ",
            "Devolución en " + ScreenName + " ",
            "Sin Asignar",
            "Sin Asignar",
            "Buscar " + ScreenName + " "
            };
        //se asigna la etiqueta a su respectivo boton
        for (int i = 0; i < tools.length; i++) {            
            Tooltip tip_tool = new Tooltip(tooltips[i]);
            Tooltip.install(tools[i], tip_tool);
        }
        
        im_tool7.setVisible(false);
        im_tool10.setVisible(false);
        im_tool11.setVisible(false);
    }
    /**
     * Metodo que se encarga de habilitar y deshabilitar los botones segun
     * la configuracion asignada al ROL del Usuario
     */    
    private void loadToolBar() {
        //si existe la configuracion de la TOOLBAR asociada al usuario
        if(toolsConfig != null){
            //Si el id de pantalla es la correcta y se encuentra activo 1 el TOOLBAR
            if(Datos.getIdScreen()==toolsConfig[0] && toolsConfig[1]==1){                
                for (int i = 0; i < tools.length; i++){    //Recorre el arreglo de botones
                    if(toolsConfig[i+2] == 1){      //Si esta disponible 1 
                        enableToolBar(tools, i);    //habilita el boton
                    }else{  
                        disableToolBar(tools,i);    //deshabilita el boton
                    }                    
                }
            }
        }
        else{
            for (int i = 0; i < tools.length; i++){    //Recorre el arreglo de botones
                disableToolBar(tools,i);    //deshabilita el boton
            }
        }
    }
    /**
     * Metodo que se encarga de DESHABILITAR toodos los botones definidos en el parametro de entrada.
     * @param disables Contiene las posiciones del Arreglo TOOLS que define cuales botones seran desactivados
     */
    private void disableAllToolBar(Integer[] disables) {
        for (int i = 0; i < disables.length; i++) { //Recorre todo el arreglo
            //Deshabilita el boton de TOOLS que se encuentra en la posicion disbles[i]
            disableToolBar(tools,disables[i]);  
        }
    }
    /**
     * Metodo que DESHABILITA un boton del TOOLBAR
     * @param im Arreglo con todos los botones del TOOLBAR
     * @param j Posicion del boton que se va a deshabilitar
     */
    private void disableToolBar(ImageView[] im,int j) {        
        BoxBlur bb = new BoxBlur();     //Inicializa el efecto Difuminado
        //se define los parametros del efecto del 
        bb.setWidth(5);                 
        bb.setHeight(5);                
        bb.setIterations(1);            
        im[j].setEffect(bb);            //Asigna el Efecto al Boton Correspondiente
        im[j].setDisable(true);         //Deshabilita el Boton Correspondiente
    }    
    /**
     * Metodo que HABILITA un boton del TOOLBAR
     * @param im Arreglo con todos los botones del TOOLBAR
     * @param j Posicion del boton que se va a habilitar
     */
    private void enableToolBar(ImageView[] im,int j) {        
        im[j].setEffect(null);      //Quita cualquier efecto asignado al boton
        im[j].setDisable(false);    //Habilita el boton   
    }
    
    /***************************************************************************/
    /**************************** METODOS DE BOTONES ***************************/
    /***************************************************************************/
    
    /**
     * Metodo que Define el comportamiento del TEXTFIELD de busqueda
     */
    private void defineBotonBuscar() {
        tf_buscar.setVisible(false);    //establece el textField como oculto al iniciarse la Pantalla
        //Manejador del Evento
        
        EventHandler eh = new EventHandler<KeyEvent>(){
            @Override
            public void handle(KeyEvent ke){
                //SI es presionado ENTER o TAB entonces
                if (ke.getCode().equals(KeyCode.ENTER) || ke.getCode().equals(KeyCode.TAB)){     
                    //Valida que el evento se haya generado en el campo de busqueda
                    if(((Node)ke.getSource()).getId().equals("tf_buscar")){                        
                        //Solicita los datos y envia la Respuesta a imprimirse en la Pantalla
                        Datos.setLog_cguias(new log_CGuias());                           
                        boolean boo = Ln.getInstance().check_log_CGuias_carga(tf_buscar.getText());                
                        numGuias = 0;
                        if(boo){
                            Datos.setRep_log_cguias(Ln.getInstance().find_log_CGuias(tf_buscar.getText(), "", "nguia", Integer.parseInt(rows)));
                            loadTable(Datos.getRep_log_cguias());     
                        }
                        else{
                            change_im_val(0, im_checkg); 
                            Gui.getInstance().showMessage("El Nro. de " + ScreenName + " NO existe!", "A");
                            tf_nroguia.requestFocus();
                        }
                        tf_buscar.setVisible(false);    //establece el textField como oculto al finalizar
                    }
                }
            }
        };
        //Se asigna el manejador a ejecutarse cuando se suelta una tecla
        tf_buscar.setOnKeyReleased(eh);
    }        
    /**
     * 
     */
    private void botonInicio() {
        tipoOperacion = 0;                  //OPERACION SOLO LECTURA
        numFactCarga = 0;
        numClieCarga = 0;
        numFactDev  = 0; 
        numClieDev  = 0; 
        numGuias = 0;
        numNotaDev = 0;
        numAlmacen = 0;
        dblPvp = 0;
                
        loadToolBar();
        //SE LIMPIA EL FORMULARIO
        tf_nrorguia.setText("");
        tf_nrofguia.setText("");
        tf_nrocguia.setText("");
        tf_pcarga.setText("");
        tf_turno.setText("");
        tf_odometro.setText("");
        tf_chofer.setText("");
        tf_veh1.setText("");
        tf_veh2.setText("");
        tf_ayud1.setText("");
        tf_ayud2.setText("");
        tf_cheqp.setText("");
        tf_supruta.setText("");
        tf_cheqr1.setText("");
        tf_cheqr2.setText("");
        tf_cheqr3.setText("");
        tf_cheqr4.setText("");
        tf_cheqr5.setText("");
        tf_cheqr6.setText("");
        tf_cheqr7.setText("");
        tf_cheqpq.setText("");

        tf_sada.setText("");
        tf_insopesca.setText("");
        tf_nrocred.setText("");
        tf_prodcg.setText("");
        tf_cantcg.setText("");
        tf_cheqpdv.setText("");
        tf_factdv.setText("");
        tf_motivodv.setText("");
        tf_proddv.setText("");
        tf_cantdv.setText("");
        tf_pmarcado.setText("0");
        tf_obserdv.setText("");

        tf_buscar.setText("");
        tf_buscar.setVisible(false);
        
        lb_chofer.setText("");
        lb_veh1.setText("");
        lb_veh2.setText("");
        lb_rgt1.setText("");
        lb_rgt2.setText("");
        lb_ayud1.setText("");
        lb_ayud2.setText("");
        lb_cheqp.setText("");
        lb_supruta.setText("");
        

        im_lcc.setVisible(false);
        im_cmc.setVisible(false);
        im_csc.setVisible(false);
        im_mac.setVisible(false);

        im_rcv1.setVisible(false);
        im_ps1.setVisible(false);
        im_rgt1.setVisible(false);
        
        im_rcv2.setVisible(false);
        im_ps2.setVisible(false);
        im_rgt2.setVisible(false);
        
        dp_fcarga.setValue(LocalDate.now());
        dp_fsalida.setValue(LocalDate.now());
        dp_faltcg.setValue(LocalDate.now());
        dp_faltdv.setValue(LocalDate.now());

        cb_unidcg.setValue(null);
        cb_motivodv.setValue(null);
        cb_uniddv.setValue(null);

        tp_factura.setText("Relación de Guia / Facturas / Clientes ");

        Datos.setLog_cguias(new log_CGuias());                           
        Datos.setLog_guide_rel_inv(new log_Guide_rel_inv());
        refreshForm();                      
        Datos.setLog_cguias(null);                  //RESET DE LA VARIABLE
        Datos.setLog_guide_rel_inv(null);           //RESET DE LA VARIABLE
        setFormVisible(false);                      //OCULTA EL FORMULARIO
        //RECARGA LA TABLA ORIGINAL
        loadTableGuide_guias();
        loadTableGuide_sada();
        loadTableGuide_isopesca();
        loadTableMissing();
        loadTableRefund();
        loadTables("");
        loadCheqTips();
        
        tp_factura.setExpanded(false);
        tp_almacen.setExpanded(false);
        tp_carga.setExpanded(false);
        tp_permiso.setExpanded(false);
        tp_fcarga.setExpanded(false);
        tp_fdevolucion.setExpanded(false);
        
        tf_nroguia.requestFocus();
    }
    /**
     * 
     */
    private void botonNuevo(){
        if(toolsConfig[2]==1){
            tipoOperacion = 1;
            change_im_check(false);
            Datos.setLog_cguias(new log_CGuias());                           
            refreshForm();
            setFormVisible(true);
            Gui.getFields()[Gui.getFieldFocused()].requestFocus();

            tf_nroguia.setText("");
            tf_nrorguia.requestFocus();
        }
    }
    /**
     * 
     */
    private void botonEditar(){
        if(Datos.getLog_cguias()!= null && toolsConfig[3]==1){
            tipoOperacion = 2;
            refreshForm();
            setFormVisible(true);     
            Gui.getFields()[Gui.getFieldFocused()].requestFocus();
        }
    }
    /**
     * 
     */
    private void botonFaltCarga(){
        if(Datos.getLog_cguias()!= null && toolsConfig[9]==1){
            tipoOperacion = 8;
            Datos.setNumRela(tf_nroguia.getText());
            refreshForm();
            setFormVisible(true);     
            tp_fcarga.setExpanded(true);
            Gui.getFields()[Gui.getFieldFocused()].requestFocus();
        }
    }
    /**
     * 
     */
    private void botonFaltDev(){
        if(Datos.getLog_cguias()!= null && toolsConfig[10]==1){
            tipoOperacion = 9;
            Datos.setNumRela(tf_nroguia.getText());
            refreshForm();
            setFormVisible(true);   
            switch (numCompDevCar){
                case 1:
                    tp_carga.setExpanded(true);
                    tf_ayud1.setEditable(true);
                    bt_c4.setDisable(false);
                    tf_ayud1.requestFocus();
                    break;
                default:
                    tp_fdevolucion.setExpanded(true);
                    dp_faltdv.setValue(dp_fcarga.getValue());
                    break;
            }
            Gui.getFields()[Gui.getFieldFocused()].requestFocus();
        }
    }
    /**
     * 
     */
    private void botonGuardar(){   
        if(Datos.getLog_cguias()!= null){
            boolean result = false;
            switch (tipoOperacion){
                case 1:
                    if(toolsConfig[4]==1){
                        if (!dp_fcarga.getValue().isAfter(LocalDate.now())){
                            result = saveCGuias();
                        }
                        else{
                            Gui.getInstance().showMessage("La Fecha de Carga no puede ser mayor a la Fecha Actual!", "A");            
                            dp_fcarga.requestFocus();
                        }
                    }
                    break;
                case 2:
                    if(toolsConfig[4]==1){
                        result = saveCGuias();
                    }
                    break;
                case 8:
                    if(toolsConfig[9]==1){
                        if (!dp_faltcg.getValue().isAfter(LocalDate.now())){
                            result = saveMissing();
                        }
                        else{
                            Gui.getInstance().showMessage("La Fecha de Faltante - Carga no puede ser mayor a la Fecha Actual!", "A");            
                            dp_faltcg.requestFocus();
                        }
                    }
                    break;
                case 9:
                    if(toolsConfig[10]==1){
                        if (!dp_faltdv.getValue().isAfter(LocalDate.now())){
                            result = saveRefund();
                        }
                        else{
                            Gui.getInstance().showMessage("La Fecha de Faltante - Devolución no puede ser mayor a la Fecha Actual!", "A");            
                            dp_faltdv.requestFocus();
                        }
                    }
                    break;
            }
            if (result)
                botonInicio();
        }
    }
    /**
     * 
     */
    private void botonEliminar() {
        if(Datos.getLog_cguias()!= null && toolsConfig[5]==1){
            tipoOperacion = 4;      //OPERACION DE BORRADO
            change_im_check(true);       //SE CAMBIA EL ICONO DE VERIFICACION DEL SUPPLIER                   
            refreshForm();         
            setFormVisible(true);  
            String verbo = "desactivar";
            if(Datos.getLog_cguias().getAnulada()== 1){
                verbo = "activar";
            }
            String mensj = 
                "¿Seguro que desea " + verbo + " el " + ScreenName + Datos.getLog_cguias().getNumguia()+"?";
            Gui.getInstance().showConfirmar(mensj);  
        }
    }
    /**
     * 
     */
    private void botonBuscar(){
        if(toolsConfig[13]==1){
            //tipoOperacion = 0;                          //OPERACION SOLO LECTURA
            numGuias = 0;
            tf_nroguia.setText("");
            //SE LIMPIA EL FORMULARIO
            tf_buscar.setVisible(true);
            Datos.setLog_cguias(new log_CGuias());                           
            refreshForm();                      
            Datos.setLog_cguias(null);                //RESET DE LA VARIABLE
            setFormVisible(false);                      //OCULTA EL FORMULARIO     
            tf_buscar.requestFocus();
        }
    }
    /**
     * 
     */
    private void botonImprimir(){
        tipoOperacion = 5;                  //OPERACION SOLO LECTURA
        if(numGuias > 0){
            Gui.getInstance().showPrint(ScreenName);  
        }
        else{
            Gui.getInstance().showMessage("Indicar un Nro. de Relación de " + ScreenName + "!", "A");
            tf_nroguia.requestFocus();
        }
    }
    /**
     * Procedimiento que define los comportamientos en diversos Eventos 
     * de cada boton en la pantalla actual.
     */
    private void init_buttons(){
        /**
         * SELECCION EN LA TABLA
         */
        tb_guias.setOnMouseClicked((MouseEvent mouseEvent) -> {
            if(mouseEvent.getButton().equals(MouseButton.PRIMARY)){
                if(mouseEvent.getClickCount() > 0){
                    if ((tb_guias.getItems() != null) && (!tb_guias.getItems().isEmpty()))
                        selectedRowGuide();
                }
            }
        });        
        /**
         * SELECCION EN LA TABLA
         */
        tb_almm.setOnMouseClicked((MouseEvent mouseEvent) -> {
            if(mouseEvent.getButton().equals(MouseButton.PRIMARY)){
                if(mouseEvent.getClickCount() > 0){
                    selectedRowAlmm();
                }
            }
        });        
        /**
         * SELECCION EN LA TABLA
         */
        tb_credit.setOnMouseClicked((MouseEvent mouseEvent) -> {
            if(mouseEvent.getButton().equals(MouseButton.PRIMARY)){
                if(mouseEvent.getClickCount() > 0){
                    selectedRowCredit();
                }
            }
        });        
        /**
         * BOTON NUEVO
         */
        im_tool1.setOnMouseClicked((MouseEvent mouseEvent) -> {
            if(mouseEvent.getButton().equals(MouseButton.PRIMARY)){
                if(mouseEvent.getClickCount() > 0){
                    botonInicio();
                    botonNuevo();
                }
            }
        });
        /**
         * BOTON EDITAR
         */
        im_tool2.setOnMouseClicked((MouseEvent mouseEvent) -> {
            if(mouseEvent.getButton().equals(MouseButton.PRIMARY)){
                if(mouseEvent.getClickCount() > 0){
                    botonEditar();
                }
            }
        });
        /**
         * BOTON GUARDAR
         */
        im_tool3.setOnMouseClicked((MouseEvent mouseEvent) -> {
            if(mouseEvent.getButton().equals(MouseButton.PRIMARY)){
                if(mouseEvent.getClickCount() > 0){
                    botonGuardar();
                }
            }
        });        
        /**
         * BOTON ELIMINAR
         */
        im_tool4.setOnMouseClicked((MouseEvent mouseEvent) -> {
            if(mouseEvent.getButton().equals(MouseButton.PRIMARY)){
                if(mouseEvent.getClickCount() > 0){
                    botonEliminar();
                }
            }
        });
        /**
         * BOTON IMPRIMIR
         */
        im_tool5.setOnMouseClicked((MouseEvent mouseEvent) -> {
            if(mouseEvent.getButton().equals(MouseButton.PRIMARY)){
                if(mouseEvent.getClickCount() > 0){   
                    botonImprimir();
                }
            }
        });
        /**
         * BOTON REGRESAR
         */
        im_tool6.setOnMouseClicked((MouseEvent mouseEvent) -> {
            if(mouseEvent.getButton().equals(MouseButton.PRIMARY)){
                if(mouseEvent.getClickCount() > 0){
                    botonInicio();
                }
            }
        });
        /**
         * BOTON POR ASIGNAR
         */
        im_tool7.setOnMouseClicked((MouseEvent mouseEvent) -> {
            if(mouseEvent.getButton().equals(MouseButton.PRIMARY)){
                if(mouseEvent.getClickCount() > 0){
                    //
                }
            }
        });
        /**
         * BOTON NOTAS DE CREDITO
         */
        im_tool8.setOnMouseClicked((MouseEvent mouseEvent) -> {
            if(mouseEvent.getButton().equals(MouseButton.PRIMARY)){
                if(mouseEvent.getClickCount() > 0){
                    botonFaltCarga();
                }
            }
        });
        /**
         * BOTON DEVOLUCION
         */
        im_tool9.setOnMouseClicked((MouseEvent mouseEvent) -> {
            if(mouseEvent.getButton().equals(MouseButton.PRIMARY)){
                if(mouseEvent.getClickCount() > 0){
                    botonFaltDev();
                }
            }
        });
        /**
         * BOTON BUSCAR
         */
        im_tool12.setOnMouseClicked((MouseEvent mouseEvent) -> {
            if(mouseEvent.getButton().equals(MouseButton.PRIMARY)){
                switch (mouseEvent.getClickCount()){
                    case 1:
                        botonInicio();
                        botonBuscar();
                        break;
                    case 2:
                        Datos.setIdButton(2003041);
                        Gui.getInstance().showBusqueda("Busqueda");  
                        break;
                }
            }
        });
        /**
         * BOTON CHECK - Es utilizado para generar un nombre de usuario correcto, 
         * basado en los nombres y apellidos de la persona.
         */
        im_check.setOnMouseClicked((MouseEvent mouseEvent) -> {
            if(mouseEvent.getButton().equals(MouseButton.PRIMARY)){
                if(mouseEvent.getClickCount() > 0){
                    
                }        
            }
        });                
         /**
         * metodo para mostrar buscar el nro de guia
         * param: ENTER O TAB
         */
        tf_nroguia.setOnKeyReleased((KeyEvent ke) -> {
            if (ke.getCode().equals(KeyCode.ENTER)){
                //Valida que el evento se haya generado en el campo de busqueda
                if(((Node)ke.getSource()).getId().equals("tf_nroguia")){
                    //Solicita los datos y envia la Respuesta a imprimirse en la Pantalla
                    Datos.setLog_cguias(new log_CGuias());                           
                    boolean boo = Ln.getInstance().check_log_CGuias_rela_carga(tf_nroguia.getText());                
                    numGuias = 0;
                    if(boo){
                        Datos.setRep_log_cguias(Ln.getInstance().find_log_CGuias(tf_nroguia.getText(), "", "nrela", Integer.parseInt(rows)));
                        loadTable(Datos.getRep_log_cguias());     
                    }
                    else{
                        change_im_val(0, im_checkg); 
                        Gui.getInstance().showMessage("El Nro. de Relación de " + ScreenName + " NO existe!", "A");
                        tf_nroguia.requestFocus();
                    }
                }
            }
        });
         /**
         * metodo para mostrar buscar el nro de guia
         * param: ENTER O TAB
         */
        tf_nrorguia.setOnKeyReleased((KeyEvent ke) -> {
            if (ke.getCode().equals(KeyCode.ENTER)){
                //Valida que el evento se haya generado en el campo de busqueda
                if(!tf_nrorguia.getText().isEmpty()){
                    if(((Node)ke.getSource()).getId().equals("tf_nrorguia")){
                        //Solicita los datos y envia la Respuesta a imprimirse en la Pantalla

                        if(tf_nrorguia.getText().substring(0, 1).toUpperCase().equals("R")){
                            log_Guide_rel_inv guide_carga = new log_Guide_rel_inv();

                            Fxp_Archguid_cp[] archguid_cp = 
                                Ln.getInstance().find_Archguid_red_ca(Integer.parseInt(tf_nrorguia.getText().substring(1, tf_nrorguia.getText().length())));

                            boolean boor = true;
                            for (int i = 0; i < log_guide_guia.size(); i++) {
                                if(String.valueOf(archguid_cp[0].getNumfact_vta()).equals(tb_guias.getItems().get(i).getGuias()) &&
                                        tb_guias.getItems().get(i).getStat_guia().equals("R")){
                                    boor = false;
                                    Gui.getInstance().showMessage("Este Nro de Factura ya esta relacionado!", "A");
                                    tf_nrorguia.requestFocus();
                                    break;
                                }
                            } 

                            if(boor){
                                guide_carga.setNumorden(String.valueOf((log_guide_guia.size() + 1)));
                                guide_carga.setGuias(String.valueOf(archguid_cp[0].getNumfact_vta()));
                                guide_carga.setNumfact(0);
                                guide_carga.setNumclie(0);

                                guide_carga.setStat_guia("R");

                                log_guide_guia.add(guide_carga);

                                loadTableGuide_guias();
                                change_im_val(200, im_checkg); 

                                tf_nrorguia.setText("");
                            }
                        }else{
                            boolean booa = Ln.getInstance().check_log_Archguie(tf_nrorguia.getText());                
                            if(booa){
                                boolean booc = Ln.getInstance().check_log_CGuias_carga(tf_nrorguia.getText());                
                                if(booc){
                                    change_im_val(0, im_checkg); 
                                    Gui.getInstance().showMessage("El Nro. de " + ScreenName + ", ya esta Relacionado!", "A");
                                    tf_nrorguia.requestFocus();
                                }
                                else{
                                    for (int i = 0; i < log_guide_guia.size(); i++) {
                                        if(tf_nrorguia.getText().equals(tb_guias.getItems().get(i).getGuias())){
                                            booa = false;
                                            Gui.getInstance().showMessage("El Nro. de " + ScreenName + ", ya esta Relacionado!", "A");
                                            tf_nrorguia.requestFocus();
                                            break;
                                        }
                                    } 
                                    if(booa){
                                        log_Guide_rel_inv guide_carga = new log_Guide_rel_inv();

                                        List<Fxp_Archguid_gfc> data = 
                                            Ln.getList_log_Archguid_gfc(Ln.getInstance().find_Archguid_gfc(tf_nrorguia.getText()));

                                        if (!data.get(0).getStat_guia().equals("X")
                                                && !data.get(0).getStat_guia().equals("C")){
                                            guide_carga.setNumorden(String.valueOf((log_guide_guia.size() + 1)));
                                            guide_carga.setGuias(tf_nrorguia.getText());
                                            guide_carga.setNumfact(data.get(0).getNumfact());
                                            guide_carga.setNumclie(data.get(0).getNumclie());

                                            if (data.get(0).getStat_guia().equals("A")){
                                                if (tipoOperacion == 1){
                                                    guide_carga.setStat_guia(null);
                                                }
                                                else{
                                                    guide_carga.setStat_guia(data.get(0).getStat_guia());
                                                }
                                            }
                                            else{
                                                if (data.get(0).getStat_guia().equals("")){
                                                    guide_carga.setStat_guia(null);
                                                }
                                                else{
                                                    guide_carga.setStat_guia(data.get(0).getStat_guia());
                                                }
                                            }


                                            log_guide_guia.add(guide_carga);

                                            loadTableGuide_guias();
                                            change_im_val(200, im_checkg); 

                                            numFactCarga = numFactCarga + data.get(0).getNumfact();
                                            numClieCarga = numClieCarga + data.get(0).getNumclie();

                                            tp_factura.setText(
                                                "Relación de Guias / Facturas / Clientes " + 
                                                "               -          " + 
                                                log_guide_guia.size() + " / " + 
                                                numFactCarga + " / " + 
                                                numClieCarga);

                                            tf_nrorguia.setText("");
                                        }else{
                                            Gui.getInstance().showMessage("El Nro. de " + ScreenName + ", ya esta Relacionado!", "A");
                                            tf_nrorguia.requestFocus();
                                        }

                                    }
                                }
                            }
                            else{
                                change_im_val(0, im_checkg); 
                                Gui.getInstance().showMessage("El Nro. de " + ScreenName + " NO existe!", "A");
                                tf_nrorguia.requestFocus();
                            }
                        }
                    }
                }
            }
        });
         /**
         * metodo para validar la cant falta
         * param: ENTER 
         */
        tf_pcarga.setOnKeyReleased((KeyEvent ke) -> {
            if (ke.getCode().equals(KeyCode.ENTER) || ke.getCode().equals(KeyCode.TAB)){
                if(((Node)ke.getSource()).getId().equals("tf_pcarga") &&
                        tf_pcarga.getText().isEmpty()){
                    Gui.getInstance().ventanaError("Indicar el Nro de la Puerta!");
                    tf_pcarga.requestFocus();
                }
            }
        });
         /**
         * metodo para validar la cant falta
         * param: ENTER 
         */
        tf_turno.setOnKeyReleased((KeyEvent ke) -> {
            if (ke.getCode().equals(KeyCode.ENTER) || ke.getCode().equals(KeyCode.TAB)){
                if(((Node)ke.getSource()).getId().equals("tf_turno") &&
                        tf_turno.getText().isEmpty()){
                    tf_turno.setText("0");
                }
            }
        });
         /**
         * metodo para validar la cant falta
         * param: ENTER 
         */
        tf_odometro.setOnKeyReleased((KeyEvent ke) -> {
            if (ke.getCode().equals(KeyCode.ENTER) || ke.getCode().equals(KeyCode.TAB)){
                if(((Node)ke.getSource()).getId().equals("tf_odometro") &&
                        tf_odometro.getText().isEmpty()){
                    tf_odometro.setText("0");
                }
            }
        });
         /**
         * metodo para mostrar buscar el nro de guia
         * param: ENTER 
         */
        tf_chofer.setOnKeyReleased((KeyEvent ke) -> {
            if (ke.getCode().equals(KeyCode.ENTER)){
                if(!tf_chofer.getText().isEmpty()){
                    if(((Node)ke.getSource()).getId().equals("tf_chofer") &&
                            (tf_chofer.getText().length() > 6)){
                        List<log_Personal> data = null;
                        data = Ln.getList_log_Personal(Ln.getInstance().find_log_Personal_tp(tf_chofer.getText(), 3, 4));
                        if(data.isEmpty()){
                            data = Ln.getList_log_Personal(Ln.getInstance().find_log_Personal_tp(tf_chofer.getText(), 8, 9));
                        }

                        if(!data.isEmpty()){
                            lb_chofer.setText(
                                data.get(0).getNombres() + ", " + data.get(0).getApellidos() + " " );

                            changeIconDate("vencido", 0, im_lcc);          
                            if (data.get(0).getStat_lc() != null) {
                                im_lcc.setVisible(true);
                                changeIconDate(data.get(0).getStat_lc(), data.get(0).getDias_lc(), im_lcc);          
                            }

                            changeIconDate("vencido", 0, im_cmc);          
                            if (data.get(0).getStat_cm() != null) {
                                im_cmc.setVisible(true);
                                changeIconDate(data.get(0).getStat_cm(), data.get(0).getDias_cm(), im_cmc);
                            }

                            changeIconDate("vencido", 0, im_csc);          
                            if (data.get(0).getStat_cs() != null) {
                                im_csc.setVisible(true);
                                changeIconDate(data.get(0).getStat_cs(), data.get(0).getDias_cs(), im_csc);          
                            }

                            // manipulacion de alimentación NO tiene Vencimiento

                            tf_veh1.requestFocus();
                          }
                        else{
                            Gui.getInstance().showMessage("El Chofer No existe!", "A");
                            tf_chofer.requestFocus();
                        }
                    }
                    else{
                        Gui.getInstance().showMessage("El Chofer No existe!", "A");
                        tf_chofer.requestFocus();
                    }
                }
                else{
                    Gui.getInstance().showMessage("Indicar el Chofer!", "A");
                    tf_chofer.requestFocus();
                }
            }
            if (ke.getCode().equals(KeyCode.BACK_SPACE)){
                lb_chofer.setText("" );
            }
        });
        /**
         * BOTON CHOFER
         */
        bt_c1.setOnMouseClicked((MouseEvent mouseEvent) -> {
            if(mouseEvent.getButton().equals(MouseButton.PRIMARY)){
                if(mouseEvent.getClickCount() > 0){
                    Datos.setIdButton(2003031);
                    Gui.getInstance().showBusqueda("Choferes");  
                }
            }
        });
        /**
         * metodo para mostrar buscar el nro de guia
         * param: ENTER 
         */
        tf_veh1.setOnKeyReleased((KeyEvent ke) -> {
            if (ke.getCode().equals(KeyCode.ENTER)){
                if(!tf_veh1.getText().isEmpty()){
                    if(((Node)ke.getSource()).getId().equals("tf_veh1") &&
                            (tf_veh1.getText().length() > 5)){
                        List<log_Vehiculos> data = Ln.getList_log_Vehiculos(Ln.getInstance().find_log_Vehiculos(tf_veh1.getText()));
                        if(!data.isEmpty()){
                            tf_veh1.setText(tf_veh1.getText().toUpperCase());
                            lb_veh1.setText(data.get(0).getModelo());
                            lb_rgt1.setText(data.get(0).getNro_rgt());

                            changeIconDate("vencido", 0, im_rcv1);          
                            if (data.get(0).getStat_rcv() != null) {
                                im_rcv1.setVisible(true);
                                changeIconDate(data.get(0).getStat_rcv(), data.get(0).getDias_rcv(), im_rcv1);          
                            }

                            changeIconDate("vencido", 0, im_ps1);          
                            if (data.get(0).getStat_ps() != null) {
                                im_ps1.setVisible(true);
                                changeIconDate(data.get(0).getStat_ps(), data.get(0).getDias_ps(), im_ps1);          
                            }

                            changeIconDate("vencido", 0, im_rgt1);          
                            if (data.get(0).getStat_rgt() != null){
                                im_rgt1.setVisible(true);
                                changeIconDate(data.get(0).getStat_rgt(), data.get(0).getDias_rgt(), im_rgt1);          
                            } 

                            tf_veh2.requestFocus();
                        }
                        else{
                            Gui.getInstance().showMessage("El Nro. de Placa del Vehiculo No existe!", "A");
                            tf_veh1.requestFocus();
                        }
                    }
                    else{
                        Gui.getInstance().showMessage("El Nro. de Placa del Vehiculo No existe!", "A");
                        tf_veh1.requestFocus();
                    }
                }
                else{
                    Gui.getInstance().showMessage("Indicar el Vehiculo!", "A");
                    tf_veh1.requestFocus();
                }
            }
            if (ke.getCode().equals(KeyCode.BACK_SPACE)){
                lb_veh1.setText("" );
                lb_rgt1.setText("" );

                im_rcv1.setVisible(false);
                im_ps1.setVisible(false);
                im_rgt1.setVisible(false);
            }
        });
        /**
         * BOTON VEHICULOS 1
         */
        bt_c2.setOnMouseClicked((MouseEvent mouseEvent) -> {
            if(mouseEvent.getButton().equals(MouseButton.PRIMARY)){
                if(mouseEvent.getClickCount() > 0){
                    Datos.setIdButton(2003032);
                    Gui.getInstance().showBusqueda("Vehiculos");  
                }
            }
        });
        /**
         * metodo para mostrar buscar el nro de guia
         * param: ENTER 
         */
        tf_veh2.setOnKeyReleased((KeyEvent ke) -> {
            if (ke.getCode().equals(KeyCode.ENTER) &&
                    (!tf_veh2.getText().isEmpty()) ){
                if(!tf_veh2.getText().toUpperCase().equals (tf_veh1.getText().toUpperCase())){
                    if(((Node)ke.getSource()).getId().equals("tf_veh2")&&
                            (tf_veh2.getText().length() > 5)){
                        List<log_Vehiculos> data = Ln.getList_log_Vehiculos(Ln.getInstance().find_log_Vehiculos(tf_veh2.getText()));
                        if(!data.isEmpty()){
                            tf_veh2.setText(tf_veh2.getText().toUpperCase());
                            lb_veh2.setText(data.get(0).getModelo());
                            lb_rgt2.setText(data.get(0).getNro_rgt());

                            changeIconDate("vencido", 0, im_rcv2);          
                            if (data.get(0).getStat_rcv() != null) {
                                im_rcv2.setVisible(true);
                                changeIconDate(data.get(0).getStat_rcv(), data.get(0).getDias_rcv(), im_rcv2);          
                            }

                            changeIconDate("vencido", 0, im_ps2);          
                            if (data.get(0).getStat_ps() != null) {
                                im_ps2.setVisible(true);
                                changeIconDate(data.get(0).getStat_ps(), data.get(0).getDias_ps(), im_ps2);          
                            }

                            changeIconDate("vencido", 0, im_rgt2);          
                            if (data.get(0).getStat_rgt() != null){
                                im_rgt2.setVisible(true);
                                changeIconDate(data.get(0).getStat_rgt(), data.get(0).getDias_rgt(), im_rgt2);          
                            } 

                            tf_ayud1.requestFocus();
                        }
                        else{
                            Gui.getInstance().showMessage("El Nro. de Placa del Vehiculo No existe!", "A");
                            tf_veh2.requestFocus();
                        }
                    }
                    else{
                        Gui.getInstance().showMessage("El Nro. de Placa del Vehiculo No existe!", "A");
                        tf_veh2.requestFocus();
                    }
                }
                else{
                    Gui.getInstance().showMessage("El Nro. de Placa del Vehiculo, ya esta asignado!", "A");
                    tf_veh2.requestFocus();
                }
            }
            if (ke.getCode().equals(KeyCode.BACK_SPACE)){
                lb_veh2.setText("" );
                lb_rgt2.setText("" );

                im_rcv2.setVisible(false);
                im_ps2.setVisible(false);
                im_rgt2.setVisible(false);
            }
        });
        /**
         * BOTON VEHICULOS 2
         */
        bt_c3.setOnMouseClicked((MouseEvent mouseEvent) -> {
            if(mouseEvent.getButton().equals(MouseButton.PRIMARY)){
                if(mouseEvent.getClickCount() > 0){
                    Datos.setIdButton(2003033);
                    Gui.getInstance().showBusqueda("Vehiculos");  
                }
            }
        });
         /**
         * metodo para mostrar buscar el nro de guia
         * param: ENTER 
         */
        tf_ayud1.setOnKeyReleased((KeyEvent ke) -> {
            if (ke.getCode().equals(KeyCode.ENTER) &&
                    (!tf_ayud1.getText().isEmpty()) ){
                if(((Node)ke.getSource()).getId().equals("tf_ayud1") &&
                        (tf_ayud1.getText().length() > 6)){
                    List<log_Personal> data = Ln.getList_log_Personal(Ln.getInstance().find_log_Personal_tp(tf_ayud1.getText(), 5, 6));
                    if(!data.isEmpty()){
                        lb_ayud1.setText(
                            data.get(0).getNombres() + ", " + data.get(0).getApellidos() + " " );

                        tf_ayud2.requestFocus();
                    }
                    else{
                        Gui.getInstance().showMessage("El Ayudante No existe!", "A");
                        tf_ayud1.requestFocus();
                    }
                }
                else{
                    Gui.getInstance().showMessage("El Ayudante No existe!", "A");
                    tf_ayud1.requestFocus();
                }
            }
            if (ke.getCode().equals(KeyCode.BACK_SPACE)){
                lb_ayud1.setText("" );
            }
        });
        /**
         * BOTON AYUDANTE 1
         */
        bt_c4.setOnMouseClicked((MouseEvent mouseEvent) -> {
            if(mouseEvent.getButton().equals(MouseButton.PRIMARY)){
                if(mouseEvent.getClickCount() > 0){
                    Datos.setIdButton(2003034);
                    Gui.getInstance().showBusqueda("Ayudantes");  
                }
            }
        });
         /**
         * metodo para mostrar buscar el nro de guia
         * param: ENTER 
         */
        tf_ayud2.setOnKeyReleased((KeyEvent ke) -> {
            if (ke.getCode().equals(KeyCode.ENTER) &&
                    (!tf_ayud2.getText().isEmpty()) ){
                if(!tf_ayud2.getText().equals(tf_ayud1.getText())){
                    if(((Node)ke.getSource()).getId().equals("tf_ayud2")&&
                            (tf_ayud2.getText().length() > 6)){
                        List<log_Personal> data = Ln.getList_log_Personal(Ln.getInstance().find_log_Personal_tp(tf_ayud2.getText(), 5, 6));
                        if(!data.isEmpty()){
                            lb_ayud2.setText(
                                data.get(0).getNombres() + ", " + data.get(0).getApellidos() + " " );

                            tf_supruta.requestFocus();
                        }
                        else{
                            Gui.getInstance().showMessage("El Ayudante No existe!", "A");
                            tf_ayud2.requestFocus();
                        }
                    }
                    else{
                        Gui.getInstance().showMessage("El Ayudante No existe!", "A");
                        tf_ayud2.requestFocus();
                    }
                }
                else{
                    Gui.getInstance().showMessage("El Ayudante, ya esta asignado!", "A");
                    tf_ayud2.requestFocus();
                }
            }
            if (ke.getCode().equals(KeyCode.BACK_SPACE)){
                lb_ayud2.setText("" );
            }
        });
        /**
         * BOTON AYUDANTE 2
         */
        bt_c5.setOnMouseClicked((MouseEvent mouseEvent) -> {
            if(mouseEvent.getButton().equals(MouseButton.PRIMARY)){
                if(mouseEvent.getClickCount() > 0){
                    Datos.setIdButton(2003035);
                    Gui.getInstance().showBusqueda("Ayudantes");  
                }
            }
        });
         /**
         * metodo para mostrar buscar el nro de guia
         * param: ENTER 
         */
        tf_supruta.setOnKeyReleased((KeyEvent ke) -> {
            if (ke.getCode().equals(KeyCode.ENTER)){
                if(!tf_supruta.getText().isEmpty()){
                    if(((Node)ke.getSource()).getId().equals("tf_supruta") &&
                            (tf_supruta.getText().length() > 6)){
                        List<log_Personal> data = Ln.getList_log_Personal(Ln.getInstance().find_log_Personal_tp(tf_supruta.getText(), 7, 7));
                        if(!data.isEmpty()){
                            lb_supruta.setText(
                                data.get(0).getNombres() + ", " + data.get(0).getApellidos() + " " );

                            tf_cheqp.requestFocus();
                        }
                        else{
                            Gui.getInstance().showMessage("El Sup. de Ruta No existe!", "A");
                            tf_supruta.requestFocus();
                        }
                    }
                    else{
                        Gui.getInstance().showMessage("El Sup. de Ruta No existe!", "A");
                        tf_supruta.requestFocus();
                    }
                }
                else{
                    Gui.getInstance().showMessage("Indicar Sup. de Ruta!", "A");
                    tf_supruta.requestFocus();
                }
            }
            if (ke.getCode().equals(KeyCode.BACK_SPACE)){
                lb_supruta.setText("" );
            }
        });
        /**
         * BOTON SUPERVISOR DE RUTA
         */
        bt_c7.setOnMouseClicked((MouseEvent mouseEvent) -> {
            if(mouseEvent.getButton().equals(MouseButton.PRIMARY)){
                if(mouseEvent.getClickCount() > 0){
                    Datos.setIdButton(2003042);
                    Gui.getInstance().showBusqueda("Sup. de Ruta");  
                }
            }
        });
         /**
         * metodo para mostrar buscar el nro de guia
         * param: ENTER 
         */
        tf_cheqp.setOnKeyReleased((KeyEvent ke) -> {
            if (ke.getCode().equals(KeyCode.ENTER)){
                if (!tf_cheqp.getText().isEmpty()){
                    if(((Node)ke.getSource()).getId().equals("tf_cheqp") &&
                            (tf_cheqp.getText().length() > 6)){
                        List<log_Personal> data = Ln.getList_log_Personal(Ln.getInstance().find_log_Personal_tp(tf_cheqp.getText(), 1, 2));
                        if(!data.isEmpty()){
                            lb_cheqp.setText(
                                data.get(0).getNombres() + ", " + data.get(0).getApellidos() + " " );

                            tf_cheqr1.requestFocus();
                        }
                        else{
                            Gui.getInstance().showMessage("El Cheq. Puerta No existe!", "A");
                            tf_cheqp.requestFocus();
                        }
                    }
                    else{
                        Gui.getInstance().showMessage("El Cheq. Puerta No existe!", "A");
                        tf_cheqp.requestFocus();
                    }
                }
                else{
                    Gui.getInstance().showMessage("Indicar Cheq. Puerta!", "A");
                    tf_cheqpdv.requestFocus();
                }
            }
            if (ke.getCode().equals(KeyCode.BACK_SPACE)){
                lb_cheqp.setText("" );
            }
        });
        /**
         * BOTON CHEQUEADOR DE CARGA
         */
        bt_c6.setOnMouseClicked((MouseEvent mouseEvent) -> {
            if(mouseEvent.getButton().equals(MouseButton.PRIMARY)){
                if(mouseEvent.getClickCount() > 0){
                    Datos.setIdButton(2003036);
                    Gui.getInstance().showBusqueda("Chequeadores");  
                }
            }
        });
         /**
         * metodo para mostrar buscar el nro de guia
         * param: ENTER 
         */
        tf_cheqr1.setOnKeyReleased((KeyEvent ke) -> {
            if (ke.getCode().equals(KeyCode.ENTER)){
                if(!tf_cheqr1.getText().isEmpty()){
                    if(((Node)ke.getSource()).getId().equals("tf_cheqr1") &&
                            (tf_cheqr1.getText().length() > 6)){
                        List<log_Personal> data = Ln.getList_log_Personal(Ln.getInstance().find_log_Personal_tp(tf_cheqr1.getText(), 1, 2));
                        if(!data.isEmpty()){
                            tf_cheqr2.requestFocus();
                        }
                        else{  
                            Gui.getInstance().showMessage("El Cheq. Interno No existe!", "A");
                            tf_cheqr1.requestFocus();
                        }
                    }
                    else{
                        Gui.getInstance().showMessage("El Cheq. Interno No existe!", "A");
                        tf_cheqr1.requestFocus();
                    }
                }
                else{
                    Gui.getInstance().showMessage("Indicar Cheq. Interno!", "A");
                    tf_cheqr1.requestFocus();
                }
            }
        });
        /**
         * BOTON CHEQUEADOR DE ALMANCEN 1
         */
        bt_cr1.setOnMouseClicked((MouseEvent mouseEvent) -> {
            if(mouseEvent.getButton().equals(MouseButton.PRIMARY)){
                if(mouseEvent.getClickCount() > 0){
                    Datos.setIdButton(2003036);
                    Gui.getInstance().showBusqueda("Chequeadores");  
                }
            }
        });
         /**
         * metodo para mostrar buscar el nro de guia
         * param: ENTER 
         */
        tf_cheqr2.setOnKeyReleased((KeyEvent ke) -> {
            if (ke.getCode().equals(KeyCode.ENTER)){
                if(!tf_cheqr2.getText().isEmpty()){
                    if(((Node)ke.getSource()).getId().equals("tf_cheqr2") &&
                            (tf_cheqr2.getText().length() > 6)){
                        List<log_Personal> data = Ln.getList_log_Personal(Ln.getInstance().find_log_Personal_tp(tf_cheqr2.getText(), 1, 2));
                        if(!data.isEmpty()){
                            tf_cheqr3.requestFocus();
                        }
                        else{  
                            Gui.getInstance().showMessage("El Cheq. Interno No existe!", "A");
                            tf_cheqr2.requestFocus();
                        }
                    }
                    else{
                        Gui.getInstance().showMessage("El Cheq. Interno No existe!", "A");
                        tf_cheqr2.requestFocus();
                    }
                }
                else{
                    Gui.getInstance().showMessage("Indicar Cheq. Interno!", "A");
                    tf_cheqr2.requestFocus();
                }
            }
        });
        /**
         * BOTON CHEQUEADOR DE ALMANCEN 2
         */
        bt_cr2.setOnMouseClicked((MouseEvent mouseEvent) -> {
            if(mouseEvent.getButton().equals(MouseButton.PRIMARY)){
                if(mouseEvent.getClickCount() > 0){
                    Datos.setIdButton(2003036);
                    Gui.getInstance().showBusqueda("Chequeadores");  
                }
            }
        });
         /**
         * metodo para mostrar buscar el nro de guia
         * param: ENTER 
         */
        tf_cheqr3.setOnKeyReleased((KeyEvent ke) -> {
            if (ke.getCode().equals(KeyCode.ENTER)){
                if(!tf_cheqr3.getText().isEmpty()){
                    if(((Node)ke.getSource()).getId().equals("tf_cheqr3") &&
                            (tf_cheqr3.getText().length() > 6)){
                        List<log_Personal> data = Ln.getList_log_Personal(Ln.getInstance().find_log_Personal_tp(tf_cheqr3.getText(), 1, 2));
                        if(!data.isEmpty()){
                            tf_cheqr4.requestFocus();
                        }
                        else{  
                            Gui.getInstance().showMessage("El Cheq. Interno No existe!", "A");
                            tf_cheqr3.requestFocus();
                        }
                    }
                    else{
                        Gui.getInstance().showMessage("El Cheq. Interno No existe!", "A");
                        tf_cheqr3.requestFocus();
                    }
                }
                else{
                    Gui.getInstance().showMessage("Indicar Cheq. Interno!", "A");
                    tf_cheqr3.requestFocus();
                }
            }
        });
        /**
         * BOTON CHEQUEADOR DE ALMANCEN 3
         */
        bt_cr3.setOnMouseClicked((MouseEvent mouseEvent) -> {
            if(mouseEvent.getButton().equals(MouseButton.PRIMARY)){
                if(mouseEvent.getClickCount() > 0){
                    Datos.setIdButton(2003036);
                    Gui.getInstance().showBusqueda("Chequeadores");  
                }
            }
        });
         /**
         * metodo para mostrar buscar el nro de guia
         * param: ENTER 
         */
        tf_cheqr4.setOnKeyReleased((KeyEvent ke) -> {
            if (ke.getCode().equals(KeyCode.ENTER)){
                if(!tf_cheqr4.getText().isEmpty()){
                    if(((Node)ke.getSource()).getId().equals("tf_cheqr4") &&
                            (tf_cheqr4.getText().length() > 6)){
                        List<log_Personal> data = Ln.getList_log_Personal(Ln.getInstance().find_log_Personal_tp(tf_cheqr4.getText(), 1, 2));
                        if(!data.isEmpty()){
                            tf_cheqr5.requestFocus();
                        }
                        else{  
                            Gui.getInstance().showMessage("El Cheq. Interno No existe!", "A");
                            tf_cheqr4.requestFocus();
                        }
                    }
                    else{
                        Gui.getInstance().showMessage("El Cheq. Interno No existe!", "A");
                        tf_cheqr4.requestFocus();
                    }
                }
                else{
                    Gui.getInstance().showMessage("Indicar Cheq. Interno!", "A");
                    tf_cheqr4.requestFocus();
                }
            }
        });
        /**
         * BOTON CHEQUEADOR DE ALMANCEN 4
         */
        bt_cr4.setOnMouseClicked((MouseEvent mouseEvent) -> {
            if(mouseEvent.getButton().equals(MouseButton.PRIMARY)){
                if(mouseEvent.getClickCount() > 0){
                    Datos.setIdButton(2003036);
                    Gui.getInstance().showBusqueda("Chequeadores");  
                }
            }
        });
         /**
         * metodo para mostrar buscar el nro de guia
         * param: ENTER 
         */
        tf_cheqr5.setOnKeyReleased((KeyEvent ke) -> {
            if (ke.getCode().equals(KeyCode.ENTER)){
                if(!tf_cheqr5.getText().isEmpty()){
                    if(((Node)ke.getSource()).getId().equals("tf_cheqr5") &&
                            (tf_cheqr5.getText().length() > 6)){
                        List<log_Personal> data = Ln.getList_log_Personal(Ln.getInstance().find_log_Personal_tp(tf_cheqr5.getText(), 1, 2));
                        if(!data.isEmpty()){
                            tf_cheqr6.requestFocus();
                        }
                        else{  
                            Gui.getInstance().showMessage("El Cheq. Interno No existe!", "A");
                            tf_cheqr5.requestFocus();
                        }
                    }
                    else{
                        Gui.getInstance().showMessage("El Cheq. Interno No existe!", "A");
                        tf_cheqr5.requestFocus();
                    }
                }
                else{
                    Gui.getInstance().showMessage("Indicar Cheq. Interno!", "A");
                    tf_cheqr5.requestFocus();
                }
            }
        });
        /**
         * BOTON CHEQUEADOR DE ALMANCEN 5
         */
        bt_cr5.setOnMouseClicked((MouseEvent mouseEvent) -> {
            if(mouseEvent.getButton().equals(MouseButton.PRIMARY)){
                if(mouseEvent.getClickCount() > 0){
                    Datos.setIdButton(2003036);
                    Gui.getInstance().showBusqueda("Chequeadores");  
                }
            }
        });
         /**
         * metodo para mostrar buscar el nro de guia
         * param: ENTER 
         */
        tf_cheqr6.setOnKeyReleased((KeyEvent ke) -> {
            if (ke.getCode().equals(KeyCode.ENTER)){
                if(!tf_cheqr6.getText().isEmpty()){
                    if(((Node)ke.getSource()).getId().equals("tf_cheqr6") &&
                            (tf_cheqr6.getText().length() > 6)){
                        List<log_Personal> data = Ln.getList_log_Personal(Ln.getInstance().find_log_Personal_tp(tf_cheqr6.getText(), 1, 2));
                        if(!data.isEmpty()){
                            tf_cheqr7.requestFocus();
                        }
                        else{  
                            Gui.getInstance().showMessage("El Cheq. Interno No existe!", "A");
                            tf_cheqr6.requestFocus();
                        }
                    }
                    else{
                        Gui.getInstance().showMessage("El Cheq. Interno No existe!", "A");
                        tf_cheqr6.requestFocus();
                    }
                }
                else{
                    Gui.getInstance().showMessage("Indicar Cheq. Interno!", "A");
                    tf_cheqr6.requestFocus();
                }
            }
        });
        /**
         * BOTON CHEQUEADOR DE ALMANCEN 6
         */
        bt_cr6.setOnMouseClicked((MouseEvent mouseEvent) -> {
            if(mouseEvent.getButton().equals(MouseButton.PRIMARY)){
                if(mouseEvent.getClickCount() > 0){
                    Datos.setIdButton(2003036);
                    Gui.getInstance().showBusqueda("Chequeadores");  
                }
            }
        });
         /**
         * metodo para mostrar buscar el nro de guia
         * param: ENTER 
         */
        tf_cheqr7.setOnKeyReleased((KeyEvent ke) -> {
            if (ke.getCode().equals(KeyCode.ENTER)){
                if(!tf_cheqr7.getText().isEmpty()){
                    if(((Node)ke.getSource()).getId().equals("tf_cheqr7") &&
                            (tf_cheqr7.getText().length() > 6)){
                        List<log_Personal> data = Ln.getList_log_Personal(Ln.getInstance().find_log_Personal_tp(tf_cheqr7.getText(), 1, 2));
                        if(!data.isEmpty()){
                            tf_cheqpq.requestFocus();
                        }
                        else{  
                            Gui.getInstance().showMessage("El Cheq. Interno No existe!", "A");
                            tf_cheqr7.requestFocus();
                        }
                    }
                    else{
                        Gui.getInstance().showMessage("El Cheq. Interno No existe!", "A");
                        tf_cheqr7.requestFocus();
                    }
                }
                else{
                    Gui.getInstance().showMessage("Indicar Cheq. Interno!", "A");
                    tf_cheqr7.requestFocus();
                }
            }
        });
        /**
         * BOTON CHEQUEADOR DE ALMANCEN 7
         */
        bt_cr7.setOnMouseClicked((MouseEvent mouseEvent) -> {
            if(mouseEvent.getButton().equals(MouseButton.PRIMARY)){
                if(mouseEvent.getClickCount() > 0){
                    Datos.setIdButton(2003036);
                    Gui.getInstance().showBusqueda("Chequeadores");  
                }
            }
        });
         /**
         * metodo para mostrar buscar el nro de guia
         * param: ENTER 
         */
        tf_cheqpq.setOnKeyReleased((KeyEvent ke) -> {
            if (ke.getCode().equals(KeyCode.ENTER)){
                if(!tf_cheqpq.getText().isEmpty()){
                    if(((Node)ke.getSource()).getId().equals("tf_cheqpq") &&
                            (tf_cheqpq.getText().length() > 6)){
                        List<log_Personal> data = Ln.getList_log_Personal(Ln.getInstance().find_log_Personal_tp(tf_cheqpq.getText(), 1, 2));
                        if(!data.isEmpty()){
                            //
                        }
                        else{  
                            Gui.getInstance().showMessage("El Cheq. Interno No existe!", "A");
                            tf_cheqpq.requestFocus();
                        }
                    }
                    else{
                        Gui.getInstance().showMessage("El Cheq. Interno No existe!", "A");
                        tf_cheqpq.requestFocus();
                    }
                }
                else{
                    Gui.getInstance().showMessage("Indicar Cheq. Interno!", "A");
                    tf_cheqpq.requestFocus();
                }
            }
        });
        /**
         * BOTON CHEQUEADOR DE ALMANCEN PQ
         */
        bt_cpq.setOnMouseClicked((MouseEvent mouseEvent) -> {
            if(mouseEvent.getButton().equals(MouseButton.PRIMARY)){
                if(mouseEvent.getClickCount() > 0){
                    Datos.setIdButton(2003036);
                    Gui.getInstance().showBusqueda("Chequeadores");  
                }
            }
        });
         /**
         * metodo para mostrar buscar el nro de guia
         * param: ENTER 
         */
        tf_sada.setOnKeyReleased((KeyEvent ke) -> {
            if (ke.getCode().equals(KeyCode.ENTER) &&
                        !tf_sada.getText().isEmpty()){
                //Valida que el evento se haya generado en el campo de busqueda
                if(((Node)ke.getSource()).getId().equals("tf_sada")){
                    //Solicita los datos y envia la Respuesta a imprimirse en la Pantalla
                    boolean boo = true;
                    for (int i = 0; i < log_guide_sada.size(); i++) {
                        if(tf_sada.getText().equals(tb_sada.getItems().get(i).getGuias())){
                            boo = false;
                            Gui.getInstance().showMessage("El Nro de Guia SADA, ya esta relacionado!", "A");
                            break;
                        }
                    }
                    if(boo){
                        log_Guide_sada guide_sada = new log_Guide_sada();
                        guide_sada.setOrden(String.valueOf(log_guide_sada.size() + 1));
                        guide_sada.setGuias(tf_sada.getText());
                        log_guide_sada.add(guide_sada);

                        loadTableGuide_sada();
                        tf_sada.setText("");
                        change_im_val(200, im_checks); 
                    }
                }
            }
        });
         /**
         * metodo para mostrar buscar el nro de guia
         * param: ENTER 
         */
        tf_insopesca.setOnKeyReleased((KeyEvent ke) -> {
            if (ke.getCode().equals(KeyCode.ENTER)){
                //Valida que el evento se haya generado en el campo de busqueda
                if(((Node)ke.getSource()).getId().equals("tf_insopesca") &&
                        !tf_insopesca.getText().isEmpty()){
                    //Solicita los datos y envia la Respuesta a imprimirse en la Pantalla
                    boolean boo = true;
                    for (int i = 0; i < log_guide_insopesca.size(); i++) {
                        if(tf_insopesca.getText().equals(tb_insopesca.getItems().get(i).getGuias())){
                            boo = false;
                            Gui.getInstance().showMessage("El Nro de Guia INSOPESCA, ya esta relacionado!", "A");
                            break;
                        }
                    }
                    if(boo){
                        log_Guide_insopesca guide_insopesca = new log_Guide_insopesca();
                        guide_insopesca.setOrden(String.valueOf(log_guide_insopesca.size() + 1));
                        guide_insopesca.setGuias(tf_insopesca.getText());
                        log_guide_insopesca.add(guide_insopesca);

                        loadTableGuide_isopesca();
                        tf_insopesca.setText("");
                        change_im_val(200, im_checki); 
                    }
                }
            }
        });
         /**
         * metodo para mostrar buscar el nro de guia faltante
         * param: ENTER 
         */
        tf_nrofguia.setOnKeyReleased((KeyEvent ke) -> {
            if (ke.getCode().equals(KeyCode.ENTER) || ke.getCode().equals(KeyCode.TAB)){
                //Valida que el evento se haya generado en el campo de busqueda
                if(((Node)ke.getSource()).getId().equals("tf_nrofguia") &&
                        !tf_nrofguia.getText().isEmpty()){
                    //Solicita los datos y envia la Respuesta a imprimirse en la Pantalla
                    boolean booc = Ln.getInstance().check_log_CGuias_fcarga(tf_nrofguia.getText()); 
                    if(booc){
                        boolean boot = false;
                        for (int i = 0; i < log_guide_missing.size(); i++) {
                            if(tf_nrofguia.getText().equals(tb_almm.getItems().get(i).getNumfalt())){
                                boot = true;
                                break;
                            }
                        }
                        if (booc && boot){
                            change_im_val(200, im_checkcg); 
                        } 
                        else{
                            change_im_val(0, im_checkfg); 
                            Gui.getInstance().showMessage("Indicar el Nro de Guia Faltante - Carga, ya esta Relacionado!", "A");
                            tf_nrofguia.requestFocus();
                        }
                    } 
                    else{
                        change_im_val(200, im_checkfg); 
                    }
                }
                else{
                    change_im_val(0, im_checkfg); 
                    Gui.getInstance().showMessage("Indicar el Nro de Guia Faltante - Carga!", "A");
                    tf_nrofguia.requestFocus();
                }
            }
        });
         /**
         * metodo para mostrar buscar el nro de guia carga
         * param: ENTER 
         */
        tf_nrocguia.setOnKeyReleased((KeyEvent ke) -> {
            if (ke.getCode().equals(KeyCode.ENTER) || ke.getCode().equals(KeyCode.TAB)){
                //Valida que el evento se haya generado en el campo de busqueda
                if(((Node)ke.getSource()).getId().equals("tf_nrocguia") &&
                        !tf_nrocguia.getText().isEmpty()){
                    //Solicita los datos y envia la Respuesta a imprimirse en la Pantalla
                    tb_credit.setItems(null);

                    if (log_guide_guia.size() != 0){
                        boolean boo = false;
                        for (int i = 0; i < log_guide_guia.size(); i++) {
                            if(tf_nrocguia.getText().equals(tb_guias.getItems().get(i).getGuias())){
                                boo = true;
                                break;
                            }
                        }

                        if (boo){
                            change_im_val(200, im_checkcg); 
                        } 
                        else if ((boo = false) && (!tf_nrocguia.equals("0"))){
                            change_im_val(0, im_checkcg); 
                            Gui.getInstance().showMessage("El Nro. de " + ScreenName + " NO esta relacionado", "A");
                            tf_nrocguia.requestFocus();
                        }
                    }
                    else{
                        Gui.getInstance().showMessage("No Existe " + ScreenName + " para validar!", "A");
                        tf_nrorguia.requestFocus();
                    }
                }
                else{
                    change_im_val(0, im_checkcg); 
                    Gui.getInstance().showMessage("Indicar el Nro. de " + ScreenName + "!", "A");
                    tf_nrocguia.requestFocus();
                }
            }
        });
        /**
         * BOTON GUIA DE CARGA
         */
        bt_gc.setOnMouseClicked((MouseEvent mouseEvent) -> {
            if(mouseEvent.getButton().equals(MouseButton.PRIMARY)){
                if(mouseEvent.getClickCount() > 0){
                    Datos.setIdButton(2003037);
                    //Gui.getInstance().showBusqueda("Guia de Carga");  

                    log_guide_credit.clear();

                    for (int i = 0; i < log_guide_guia.size(); i++) {  
                        boolean boo = Ln.getInstance().check_log_Archguip_guia(tb_guias.getItems().get(i).getGuias(), tf_prodcg.getText()); 
                        if (boo){
                            log_guide_credit.addAll(Ln.getInstance().find_Archguid(tb_guias.getItems().get(i).getGuias(), tf_prodcg.getText()));
                        }
                    } 
                    tb_credit.setItems(log_guide_credit);
                }
            }
        });
         /**
         * metodo para validar la cant falta
         * param: ENTER 
         */
        tf_nrocred.setOnKeyReleased((KeyEvent ke) -> {
            if (ke.getCode().equals(KeyCode.ENTER) || ke.getCode().equals(KeyCode.TAB)){
                if(((Node)ke.getSource()).getId().equals("tf_nrocred") &&
                        tf_nrocred.getText().isEmpty()){
                    tf_nrocred.setText("0");
                }
            }
        });
         /**
         * metodo para mostrar buscar el nro de guia
         * param: ENTER 
         */
        tf_prodcg.setOnKeyReleased((KeyEvent ke) -> {
            if (ke.getCode().equals(KeyCode.ENTER) || ke.getCode().equals(KeyCode.TAB)){
                //Valida que el evento se haya generado en el campo de busqueda
                if(((Node)ke.getSource()).getId().equals("tf_prodcg") &&
                        (!tf_prodcg.getText().isEmpty()) &&
                        (tf_prodcg.getText().length() < 6)){
                    //Solicita los datos y envia la Respuesta a imprimirse en la Pantalla
                    boolean boo = Ln.getInstance().check_log_Archguip_guia(tf_nrocguia.getText(), tf_prodcg.getText()); 
                    if(boo){
                        change_im_val(200, im_checkfp); 
                        tf_prodcg.setText(tf_prodcg.getText().toUpperCase()); 

                        if(!tf_nrocguia.getText().equals("0")){
                            Fxp_Archguip_pro_cg[] archguip_pro = 
                                Ln.getInstance().find_Archguip_pro_guia(tf_nrocguia.getText(), tf_prodcg.getText());
                            
                            cb_unidcg.getItems().clear();
                            if (archguip_pro != null){
                                final ObservableList<Unit> data = FXCollections.observableArrayList();

                                Unit[] unitEmb = Ln.getInstance().find_Unit(archguip_pro[0].getUnidDespEmb().getAbrev());        
                                data.addAll(Arrays.asList(unitEmb)); 

                                if (!archguip_pro[0].getUnidDespEmb().getAbrev().equals(archguip_pro[0].getUnidDespCont().getAbrev())){
                                    Unit[] unitCont = Ln.getInstance().find_Unit(archguip_pro[0].getUnidDespCont().getAbrev());        
                                    data.addAll(Arrays.asList(unitCont)); 
                                }

                                cb_unidcg.setItems(data); 
                            }
                        }
                    } 
                    else{
                        if(tf_nrocguia.getText().equals("0")){
                            log_guide_credit.clear();

                            for (int i = 0; i < log_guide_guia.size(); i++) {  
                                boo = Ln.getInstance().check_log_Archguip_guia(tb_guias.getItems().get(i).getGuias(), tf_prodcg.getText()); 
                                if (boo){
                                    log_guide_credit.addAll(Ln.getInstance().find_Archguid(tb_guias.getItems().get(i).getGuias(), tf_prodcg.getText()));
                                }
                            } 
                            tb_credit.setItems(log_guide_credit);

                            if (!log_guide_credit.isEmpty()){
                                tf_nrocguia.requestFocus();
                            }
                            else {
                                change_im_val(0, im_checkfp); 
                                Gui.getInstance().showMessage("El Producto No esta relacionado para la " + ScreenName + "!", "A");
                                tf_prodcg.requestFocus();
                            }
                        }
                        else {
                            change_im_val(0, im_checkfp); 
                            Gui.getInstance().showMessage("El Producto No esta relacionado para la " + ScreenName + "!", "A");
                            tf_prodcg.requestFocus();
                        }
                    }
                }
                else{
                    change_im_val(0, im_checkfp); 
                    Gui.getInstance().showMessage("Indicar la Código del Producto!", "A");
                    tf_prodcg.requestFocus();
                }
            }
        });
        /**
         * BOTON PRODUCTO
         */
        bt_dpc.setOnMouseClicked((MouseEvent mouseEvent) -> {
            if(mouseEvent.getButton().equals(MouseButton.PRIMARY)){
                if(mouseEvent.getClickCount() > 0){
                    Datos.setIdButton(2003039);
                    Gui.getInstance().showBusqueda("Productos");  
                }
            }
        });
         /**
         * metodo para validar la cant falta
         * param: ENTER 
         */
        tf_cantcg.setOnKeyReleased((KeyEvent ke) -> {
            if (ke.getCode().equals(KeyCode.ENTER) || ke.getCode().equals(KeyCode.TAB)){
                //Valida que el evento se haya generado en el campo de busqueda
                if(((Node)ke.getSource()).getId().equals("tf_cantcg") &&
                        tf_cantcg.getText().isEmpty()){
                    Gui.getInstance().showMessage("Indicar la Cantidad del Producto!", "A");
                    tf_cantcg.requestFocus();
                }
            }
        });
         /**
         * metodo para mostrar buscar el nro de guia
         * param: ENTER 
         */
        cb_unidcg.setOnKeyReleased((KeyEvent ke) -> {
            if (ke.getCode().equals(KeyCode.ENTER)){
                //Valida que el evento se haya generado en el campo de busqueda
                if(((Node)ke.getSource()).getId().equals("cb_unidcg") &&
                        !tf_nrocguia.getText().isEmpty() &&
                        !tf_prodcg.getText().isEmpty() &&
                        !tf_cantcg.getText().isEmpty() &&
                        !cb_unidcg.getSelectionModel().isEmpty()){
                    //Solicita los datos y envia la Respuesta a imprimirse en la Pantalla
                    
                    boolean boo = true; 
                    for (int i = 0; i < log_guide_missing.size(); i++) {
                        if((tf_prodcg.getText().equals(tb_almm.getItems().get(i).getCodigo())) &&
                                (tf_nrocguia.getText().equals(tb_almm.getItems().get(i).getNumguia()))){
                            boo = false;
                            Gui.getInstance().showMessage("El Producto Ya esta relacionado para la " + ScreenName + "!", "A");
                            break;
                        }
                    }
                    if(boo){
                        Fxp_Archguip_pro_cg[] archguip_pro = 
                            Ln.getInstance().find_Archguip_pro_guia(tf_nrocguia.getText(), tf_prodcg.getText());

                        int unidMin = 0;
                        for (int i = 0; i < archguip_pro.length; i++) {  
                            switch (archguip_pro[i].getUnidDespEmb().getAbrev()){
                                case "BUL":
                                    unidMin += archguip_pro[i].getICantDesp() * archguip_pro[i].getUniporem();
                                    break;
                                default:
                                    unidMin += archguip_pro[i].getICantDesp();
                                    break;
                            }
                        } 

                        if (Integer.parseInt(tf_cantcg.getText()) <= archguip_pro[0].getICantDesp() ||
                                Integer.parseInt(tf_cantcg.getText()) <= unidMin){

                            if (!cb_unidcg.getValue().getAbrev().equals(archguip_pro[0].getUnidDespEmb().getAbrev()) &&
                                    !cb_unidcg.getValue().getAbrev().equals(archguip_pro[0].getUnidDespCont().getAbrev())){
                                Gui.getInstance().showMessage("La unidad seleccionada no corresponde con la del Producto!", "A");
                                cb_unidcg.requestFocus();
                            }
                            else{
                                archguip_pro[0].setOrden(String.valueOf(log_guide_missing.size() + 1));
                                archguip_pro[0].setICantFalt(Integer.parseInt(tf_cantcg.getText()));
                                archguip_pro[0].setSCantFalt(tf_cantcg.getText() + " " + cb_unidcg.getValue().getAbrev());
                                archguip_pro[0].setNumfalt(tf_nrofguia.getText());
                                archguip_pro[0].setNumncred(tf_nrocred.getText());

                                //Se obtiene Unidad
                                Unit unit = (Unit) cb_unidcg.getValue();            
                                archguip_pro[0].setUnidfalt(unit.getIdUnit());

                                log_guide_missing.add(archguip_pro[0]);
                                loadTableMissing();
                                tf_nrocguia.setText("");
                                tf_nrocred.setText("");
                                tf_prodcg.setText("");
                                tf_cantcg.setText("");
                                cb_unidcg.setValue(null);
                                cb_unidcg.getItems().clear();

                                tf_nrocguia.requestFocus();
                            }
                        }
                        else{
                            Gui.getInstance().showMessage("La Cant. Faltante no puede ser mayor a la Cant. de la " + ScreenName, "A");
                            tf_cantcg.requestFocus();
                        }
                    }
                }
                else{
                    Gui.getInstance().showMessage("Existen Parametros que debe completar de la " + ScreenName, "A");
                }
            }
        });
         /**
         * metodo para mostrar buscar el nro de guia
         * param: ENTER 
         */
        tf_cheqpdv.setOnKeyReleased((KeyEvent ke) -> {
            if (ke.getCode().equals(KeyCode.ENTER)){
                if (!tf_cheqpdv.getText().isEmpty()){
                    if(((Node)ke.getSource()).getId().equals("tf_cheqpdv") &&
                            (tf_cheqpdv.getText().length() > 5)){
                        List<log_Personal> data = Ln.getList_log_Personal(Ln.getInstance().find_log_Personal_tp(tf_cheqpdv.getText(), 1, 2));
                        if(!data.isEmpty()){
                            lb_cheqpdv.setText(
                                data.get(0).getNombres() + ", " + data.get(0).getApellidos() + " " );
                                tf_factdv.requestFocus();
                        }
                        else{
                            Gui.getInstance().showMessage("El Cheq. Puerta No existe!", "A");
                            tf_cheqpdv.requestFocus();
                        }
                    }
                    else{
                        Gui.getInstance().showMessage("El Cheq. Puerta No existe!", "A");
                        tf_cheqpdv.requestFocus();
                    }
                }
                else{
                    Gui.getInstance().showMessage("Indicar el Cheq. Puerta!", "A");
                    tf_cheqpdv.requestFocus();
                }
            }
            if (ke.getCode().equals(KeyCode.BACK_SPACE)){
                lb_cheqp.setText("" );
            }
        });
        /**
         * BOTON CHEQUEADOR DE DEVOLUCION
         */
        bt_d1.setOnMouseClicked((MouseEvent mouseEvent) -> {
            if(mouseEvent.getButton().equals(MouseButton.PRIMARY)){
                if(mouseEvent.getClickCount() > 0){
                    Datos.setIdButton(2003038);
                    Gui.getInstance().showBusqueda("Chequeadores");  
                }
            }
        });
         /**
         * metodo para mostrar buscar el nro de guia carga
         * param: ENTER 
         */
        tf_factdv.setOnKeyReleased((KeyEvent ke) -> {
            if (ke.getCode().equals(KeyCode.ENTER) || ke.getCode().equals(KeyCode.TAB)){
                //Valida que el evento se haya generado en el campo de busqueda
                if(((Node)ke.getSource()).getId().equals("tf_factdv") &&
                        !tf_factdv.getText().isEmpty()){
                    //Solicita los datos y envia la Respuesta a imprimirse en la Pantalla
                    
                    change_im_val(0, im_checkdf); 
                    tf_factdv.setText(tf_factdv.getText().toUpperCase());

                    if (log_guide_guia.size() != 0){
                        boolean boo = false;
                        for (int i = 0; i < log_guide_guia.size(); i++) {  
                            if(!tf_factdv.getText().substring(0, 1).toUpperCase().equals("J") && 
                                    !tf_factdv.getText().substring(0, 1).toUpperCase().equals("E") && 
                                    !tf_factdv.getText().substring(0, 1).toUpperCase().equals("V"))
                                boo = Ln.getInstance().check_log_Archguip_fact_guia(tf_factdv.getText(), tb_guias.getItems().get(i).getGuias()); 
                            
                            if(boo)
                                break;
                        }

                        if(boo){
                            change_im_val(200, im_checkdf); 
                            tf_motivodv.requestFocus();
                        }
                        else {
                            if ((!tf_factdv.getText().equals("0")) && 
                                    !tf_factdv.getText().substring(0, 1).toUpperCase().equals("J") && 
                                    !tf_factdv.getText().substring(0, 1).toUpperCase().equals("E") && 
                                    !tf_factdv.getText().substring(0, 1).toUpperCase().equals("V")){
                                Gui.getInstance().showMessage("La relación de Guias no contiene la Factura indicada!", "A");
                                tf_factdv.requestFocus();
                            }
                            else {
                                tf_motivodv.requestFocus();
                            }
                        }
                    }
                    else{
                        Gui.getInstance().showMessage("No hay relación " + ScreenName + " para validar!", "A");
                        tf_nrorguia.requestFocus();
                    }
                }
                else{
                    change_im_val(0, im_checkdf); 
                    Gui.getInstance().showMessage("Indicar el Nro. de Factura!", "A");
                    tf_factdv.requestFocus();
                }
            }
        });
        /**
         * BOTON CLIENTE
         */
        bt_d2.setOnMouseClicked((MouseEvent mouseEvent) -> {
            if(mouseEvent.getButton().equals(MouseButton.PRIMARY)){
                if(mouseEvent.getClickCount() > 0){
                    Datos.setIdButton(2003040);
                    Gui.getInstance().showBusqueda("Clientes");  
                }
            }
        });
         /**
         * metodo para mostrar buscar el motivo
         * param: ENTER 
         */
        tf_motivodv.setOnKeyReleased((KeyEvent ke) -> {
            if (ke.getCode().equals(KeyCode.ENTER)){
                //Valida que el evento se haya generado en el campo de busqueda
                if(((Node)ke.getSource()).getId().equals("tf_motdv") &&
                        !tf_motivodv.getText().isEmpty()){
                    //Solicita los datos y envia la Respuesta a imprimirse en la Pantalla
                    List<log_TMotdev> data = Ln.getList_log_TMotdev(Ln.getInstance().find_log_TMotdev(tf_motivodv.getText()));
                    if(!data.isEmpty()){
                        tf_motivodv.setText(tf_motivodv.getText().toUpperCase());

                        cb_motivodv.setValue(data.get(0));
                        log_TMotdev log_tmotdev = (log_TMotdev) cb_motivodv.getValue();
                        Datos.setLog_tmotdev(log_tmotdev);

                        tf_motivodv.setText(log_tmotdev.getAbrev());

                        switch (Datos.getLog_tmotdev().getValblq()){
                            case 0:
                                tf_proddv.setDisable(false);
                                tf_cantdv.setDisable(false);
                                cb_uniddv.setDisable(false);
                                
                                tf_proddv.requestFocus();
                                break;
                            case 1:
                                if (numStatDev == 0){
                                    tf_proddv.setDisable(true);
                                    tf_cantdv.setDisable(true);
                                    cb_uniddv.setDisable(true);

                                    tf_obserdv.requestFocus();
                                }
                                else{
                                    tf_proddv.requestFocus();
                                }
                                break;
                        }

                        switch (Datos.getLog_tmotdev().getValobserv()){
                            case 0:
                                break;
                            case 1:
                                tf_obserdv.setText("");
                                break;
                            case 2:
                                tf_obserdv.setText("Nro. ");
                                break;
                            case 3:
                                tf_obserdv.setText("Llego ");
                                break;
                        }
                    }else{
                        cb_motivodv.requestFocus();
                    }
                }
                else{
                    Gui.getInstance().showMessage("Indicar el Motivo de la Devolución!", "A");
                    cb_motivodv.requestFocus();
                }
            }
        });
         /**
         * metodo para mostrar buscar el motivo
         * param: ENTER 
         */
        cb_motivodv.setOnKeyPressed((KeyEvent ke) -> {
            if (ke.getCode().equals(KeyCode.ENTER)){
                //Valida que el evento se haya generado en el campo de busqueda
                if(((Node)ke.getSource()).getId().equals("cb_motivodv")  &&
                        !tf_factdv.getText().isEmpty() && 
                        !cb_motivodv.getSelectionModel().isEmpty()){
                    //Solicita los datos y envia la Respuesta a imprimirse en la Pantalla
                    log_TMotdev log_tmotdev = (log_TMotdev) cb_motivodv.getValue();
                    Datos.setLog_tmotdev(log_tmotdev);

                    tf_motivodv.setText(log_tmotdev.getAbrev());

                    switch (Datos.getLog_tmotdev().getValblq()){
                        case 0:
                            tf_proddv.setDisable(false);
                            tf_cantdv.setDisable(false);
                            cb_uniddv.setDisable(false);

                            tf_proddv.requestFocus();
                            break;
                        case 1:
                            tf_proddv.setDisable(true);
                            tf_cantdv.setDisable(true);
                            cb_uniddv.setDisable(true);
                            break;
                    }

                    switch (Datos.getLog_tmotdev().getValobserv()){
                        case 0:
                            break;
                        case 1:
                            tf_obserdv.setText("");
                            break;
                        case 2:
                            tf_obserdv.setText("Nro. ");
                            break;
                        case 3:
                            tf_obserdv.setText("Llego ");
                            break;
                    }
                }
                else{
                    Gui.getInstance().showMessage("Indicar el Motivo de la Devolución!", "A");
                    cb_motivodv.requestFocus();
                }
            }
        });         /**
         * metodo para mostrar buscar el nro de factura
         * param: ENTER 
         */
        tf_proddv.setOnKeyReleased((KeyEvent ke) -> {
            if (ke.getCode().equals(KeyCode.ENTER) || ke.getCode().equals(KeyCode.TAB)){
                //Valida que el evento se haya generado en el campo de busqueda
                if(((Node)ke.getSource()).getId().equals("tf_proddv") &&
                        (!tf_proddv.getText().isEmpty()) &&
                        (tf_proddv.getText().length() < 6)){
                    //Solicita los datos y envia la Respuesta a imprimirse en la Pantalla
                    boolean boo = false;
                    boolean booc = true;

                    Fxp_Archguid_cp[] archguid_cp = null;
                    if(tf_factdv.getText().substring(0, 1).toUpperCase().equals("J") || 
                            tf_factdv.getText().substring(0, 1).toUpperCase().equals("E") ||
                            tf_factdv.getText().substring(0, 1).toUpperCase().equals("V")){
                        for (int i = 0; i < log_guide_guia.size(); i++) {  
                            archguid_cp = 
                                Ln.getInstance().find_Archguid_cp(tf_factdv.getText(), tf_proddv.getText(), tb_guias.getItems().get(i).getGuias());
                             
                            if ((archguid_cp != null) && archguid_cp.length > 0){
                                if (archguid_cp[0].getNumfact_vta() > 0 && archguid_cp[0].getNumfact_vis() > 0 ){
                                    tf_obserdv.setText(
                                        "Cliente # " + String.valueOf(archguid_cp[0].getCliente()) + " - " +
                                        "Vta. en FT # " + String.valueOf(archguid_cp[0].getNumfact_vta()) + " - " +
                                        "Dev. con FT # " + String.valueOf(archguid_cp[0].getNumfact_vis()) + " - " +
                                        "Nota # ") ;
                                    tf_factdv.setText(String.valueOf(archguid_cp[0].getNumfact_vis()));
                                    numNotaDev = archguid_cp[0].getNumfact_vta();
                                    booc = false;
                                    break;       
                                }
                            }
                        }   
                        if(booc){
                            tf_obserdv.setText(
                                "Cliente # " + String.valueOf(archguid_cp[0].getCliente()) + " - " +
                                "Vta. en FT # " + String.valueOf(archguid_cp[0].getNumfact_vta()) + " - " +
                                "Nota # ") ;
                            tf_factdv.setText(String.valueOf(archguid_cp[0].getNumfact_vis()));
                            numNotaDev = archguid_cp[0].getNumfact_vta();
                        }
                    } 


                    Fxp_Archguip_pro[] archguip_pro = null;
                    if (archguid_cp != null && archguid_cp.length > 0){
                        archguip_pro = 
                            Ln.getInstance().find_Archguid_pro_fact(archguid_cp[0].getLetdoc(), tf_factdv.getText(), String.valueOf(archguid_cp[0].getCliente()), tf_proddv.getText());
                    }
                    else{
                        archguip_pro = 
                            Ln.getInstance().find_Archguid_pro_fact("A", tf_factdv.getText(), "0", tf_proddv.getText());
                    }

                    numClieDev = Integer.parseInt(archguip_pro[0].getNumcli());
                    numUnidMin = archguip_pro[0].getUniporem();
                    numCantDesp = archguip_pro[0].getiCantDesp();
                    dblPvp = archguip_pro[0].getPre_fact();
                    numAlmacen = archguip_pro[0].getIdAlmacen();
                    
                    change_im_val(200, im_checkdp); 
                    tf_proddv.setText(tf_proddv.getText().toUpperCase()); 

                    cb_uniddv.getItems().clear();
                    if (archguip_pro != null && archguip_pro.length > 0){
                        boo = true;
                        final ObservableList<Unit> data = FXCollections.observableArrayList();

                        Unit[] unitEmb = Ln.getInstance().find_Unit(archguip_pro[0].getUnidVta().getAbrev());        
                        data.addAll(Arrays.asList(unitEmb)); 

                        if (!archguip_pro[0].getUnidVta().getAbrev().equals(archguip_pro[0].getUnidMin().getAbrev())){
                            Unit[] unitCont = Ln.getInstance().find_Unit(archguip_pro[0].getUnidMin().getAbrev());        
                            data.addAll(Arrays.asList(unitCont)); 
                        }

                        Unit[] unitUni = Ln.getInstance().find_Unit("UNI");        
                        data.addAll(Arrays.asList(unitUni)); 

                        cb_uniddv.setItems(data); 
                    }
                    
                    if(Datos.getLog_tmotdev().getValdev() == 1){
                        if (!boo){
                            change_im_val(0, im_checkdp); 
                            Gui.getInstance().showMessage("El Producto No esta relacionado para esa Factura!", "A");
                            tf_proddv.requestFocus();
                        }
                    } 
                    else {
                        if (booc)
                            change_im_val(0, im_checkdp); 

                        if ((archguid_cp == null || archguid_cp.length == 0) && 
                                (archguip_pro == null || archguip_pro.length == 0)){
                            Gui.getInstance().showMessage("El Cliente y el Producto NO esta relacionado para esta " + ScreenName, "A");
                            tf_factdv.requestFocus();
                        }
                    }
                }
                else{
                    change_im_val(0, im_checkfp); 
                    Gui.getInstance().showMessage("Indicar el Código del Producto!", "A");
                    tf_proddv.requestFocus();
                }
            }
        });
        /**
         * BOTON PRODUCTO
         */
        bt_dpv.setOnMouseClicked((MouseEvent mouseEvent) -> {
            if(mouseEvent.getButton().equals(MouseButton.PRIMARY)){
                if(mouseEvent.getClickCount() > 0){
                    Datos.setIdButton(2003039);
                    Gui.getInstance().showBusqueda("Productos");  
                }
            }
        });
         /**
         * metodo para validar la cant falta
         * param: ENTER 
         */
        tf_cantdv.setOnKeyReleased((KeyEvent ke) -> {
            if (ke.getCode().equals(KeyCode.ENTER) || ke.getCode().equals(KeyCode.TAB)){
                //Valida que el evento se haya generado en el campo de busqueda
                if(((Node)ke.getSource()).getId().equals("tf_cantdv") &&
                        tf_cantdv.getText().isEmpty()){
                    Gui.getInstance().showMessage("Indicar el Cantidad del Producto!", "A");
                    tf_cantdv.requestFocus();
                }
            }
        });
         /**
         * metodo para mostrar buscar el nro de guia
         * param: ENTER 
         */
        cb_uniddv.setOnKeyReleased((KeyEvent ke) -> {
            if (ke.getCode().equals(KeyCode.ENTER)){
                //Valida que el evento se haya generado en el campo de busqueda
                if(((Node)ke.getSource()).getId().equals("cb_uniddv") &&
                        cb_uniddv.getPromptText().isEmpty()){
                    //Solicita los datos y envia la Respuesta a imprimirse en la Pantalla
                    if (!cb_uniddv.getValue().getAbrev().equals("")){
                        boolean bou = false; 
                        switch (cb_uniddv.getValue().getAbrev()){
                            case "BUL":
                                if((!tf_factdv.getText().equals("0")) && (numNotaDev == 0)){
                                    if (Integer.parseInt(tf_cantdv.getText()) > numCantDesp){
                                        bou = true;
                                    }
                                }
                                break;
                            default:
                                if(numNotaDev == 0){
                                    if ((numUnidMin > 1) && 
                                            (Integer.parseInt(tf_cantdv.getText()) > (numCantDesp * numUnidMin))){
                                        bou = true;
                                    }
                                }
                                break;
                        }

                        if (bou){
                            Gui.getInstance().showMessage("La cantidad/unidad seleccionada No corresponde!", "A");
                            tf_cantdv.requestFocus();
                        }
                    } 
                    else{
                        Gui.getInstance().showMessage("Indicar la Unidad del Producto!", "A");
                        cb_uniddv.requestFocus();
                    }
                }
            }
        });
         /**
         * metodo para validar la cant falta
         * param: ENTER 
         */
        tf_pmarcado.setOnKeyReleased((KeyEvent ke) -> {
            if (ke.getCode().equals(KeyCode.ENTER) || ke.getCode().equals(KeyCode.TAB)){
                if(((Node)ke.getSource()).getId().equals("tf_pmarcado") &&
                        !tf_pmarcado.getText().isEmpty()){
                    boolean boo = 
                            Ln.getInstance().check_log_cguias_check_fdev_prod(tf_proddv.getText()); 

                    if(boo){
                        if (Double.parseDouble(tf_pmarcado.getText()) == 0){
                            Gui.getInstance().ventanaError("Indicar el Precio del Producto!");
                            tf_pmarcado.requestFocus();
                        }
                    }
                    else{
                        tf_pmarcado.setText("0");
                    }
                }
            }
        });
         /**
         * metodo para validar la cant falta
         * param: ENTER 
         */
        tf_obserdv.setOnKeyReleased((KeyEvent ke) -> {
            if (ke.getCode().equals(KeyCode.ENTER)){
                //Valida que el evento se haya generado en el campo de busqueda
                if(((Node)ke.getSource()).getId().equals("tf_obserdv") &&
                        !tf_factdv.getText().isEmpty()){
                    
                    if (Datos.getLog_tmotdev().getValblq() == 0 &&
                        tf_factdv.getText().isEmpty() &&
                        tf_proddv.getText().isEmpty() &&
                        tf_cantdv.getText().isEmpty() &&
                        cb_uniddv.getSelectionModel().isEmpty()){
    
                        Gui.getInstance().showMessage("Existen Parametros que debe completar de la " + ScreenName, "A");
                        
                    }else{
                        boolean boor = true;
                        for (int i = 0; i < log_guide_refund.size(); i++) {
                            switch (Datos.getLog_tmotdev().getValfact()){
                                case 0:
                                    break;
                                case 1:
                                    if (numStatDev == 0){
                                        if((tf_factdv.getText().equals(tb_almr.getItems().get(i).getNumfact()))){
                                            boor = false;
                                            Gui.getInstance().showMessage("El Nro. de Factura, ya esta relacionado con ese Motivo!", "A");
                                            tf_factdv.requestFocus();
                                        }
                                    }
                                    break;
                            }
                        } 

                        if (boor){
                            boolean boo = true;                
                            boolean bou = false;

                            Fxp_Archguip_pro_dv[] archguip_pro_dv = null;
                            if (Datos.getLog_tmotdev().getValblq() == 0){

                                if (numNotaDev == 0){
                                    archguip_pro_dv = 
                                        Ln.getInstance().find_Archguip_pro_fact(tf_factdv.getText(), String.valueOf(0), tf_proddv.getText());
                                }
                                else{
                                    archguip_pro_dv = 
                                        Ln.getInstance().find_Archguip_pro_fact(String.valueOf(numNotaDev), String.valueOf(0), tf_proddv.getText());
                                }
                                
                                int cantDesp = 0;
                                for (int i = 0; i < log_guide_refund.size(); i++) {
                                    if((tf_proddv.getText().equals(tb_almr.getItems().get(i).getCodigo())) &&
                                            (tf_factdv.getText().equals(tb_almr.getItems().get(i).getNumfact())) &&
                                            (!cb_uniddv.getValue().getAbrev().equals("UNI"))){
// unid entrada con unid cargada
// para validar cant y NO
// repita el producto                  
                                        switch (cb_uniddv.getValue().getAbrev()){
                                            case "BUL":
                                                if (numStatDev == 0){
                                                    if(!tf_factdv.getText().equals("0")){
                                                        if(numCantDesp <= archguip_pro_dv[0].getICantDesp()){
                                                            cantDesp = (archguip_pro_dv[0].getICantDesp() - tb_almr.getItems().get(i).getICantFalt());
                                                        }
                                                        else{
                                                            cantDesp = (numCantDesp - tb_almr.getItems().get(i).getICantFalt());
                                                        }
                                                            
                                                        if (Integer.parseInt(tf_cantdv.getText()) > cantDesp){
                                                            bou = true; 
                                                            Gui.getInstance().showMessage("La Cant. Faltante no puede ser mayor a la Cant. en Factura!", "A");
                                                            tf_cantdv.requestFocus();
                                                        } 
                                                    }
                                                }
                                                break;
                                            default:
                                                if (numStatDev == 0){
                                                    cantDesp = ((numUnidMin * numCantDesp) - tb_almr.getItems().get(i).getICantFalt());
                                                    if (Integer.parseInt(tf_cantdv.getText()) > cantDesp){
                                                        bou = true; 
                                                        Gui.getInstance().showMessage("La Cant. Faltante no puede ser mayor a la Cant. en Factura!", "A");
                                                        tf_cantdv.requestFocus();
                                                    }
                                                }
                                                break;
                                        }

                                        if(bou){
                                            boo = false; 
                                            break;
                                        }
                                    }
                                }

                                if ((numNotaDev > 0) || (numStatDev > 0)){
                                    numUnidMin = 48 * numUnidMin;
                                }
                                if(boo){
                                    if (Integer.parseInt(tf_cantdv.getText()) <= numCantDesp ||
                                            Integer.parseInt(tf_cantdv.getText()) <= (numUnidMin * numCantDesp)){

                                        archguip_pro_dv[0].setFecha(Date.valueOf(dp_faltdv.getValue()));
                                        archguip_pro_dv[0].setIdChequeador(tf_cheqpdv.getText().trim());
                                        archguip_pro_dv[0].setNumfact(tf_factdv.getText().trim());
                                        archguip_pro_dv[0].setCodigo(tf_proddv.getText().trim());
                                        archguip_pro_dv[0].setICantFalt(Integer.parseInt(tf_cantdv.getText()));
                                        switch (Datos.getLog_tmotdev().getIdTMotdev()){
                                            case 410: //27
                                            case 411: //28
                                                archguip_pro_dv[0].setICantDesp(0);
                                                break;
                                            default:
                                                archguip_pro_dv[0].setICantDesp(numCantDesp);
                                                break;
                                        }
                                        archguip_pro_dv[0].setSCantFalt(tf_cantdv.getText() + " " + cb_uniddv.getValue());
                                        archguip_pro_dv[0].setPre_marc(Double.parseDouble(tf_pmarcado.getText()));
                                        archguip_pro_dv[0].setPre_fact(dblPvp);
                                        archguip_pro_dv[0].setIdAlmacen(numAlmacen);
                                        archguip_pro_dv[0].setObserv(tf_obserdv.getText().toUpperCase().trim());

                                         //Se obtiene Motivo
                                        archguip_pro_dv[0].setIdMotivo(Datos.getLog_tmotdev().getIdTMotdev());
                                        archguip_pro_dv[0].setSmotivo(Datos.getLog_tmotdev().getAbrev());

                                        //Se obtiene Unidad
                                        Unit unit = (Unit) cb_uniddv.getValue();            
                                        archguip_pro_dv[0].setUnidfalt(unit.getIdUnit());

                                        if (numStatDev == 0){
                                            archguip_pro_dv[0].setOrden(String.valueOf(log_guide_refund.size() + 1));
                                            archguip_pro_dv[0].setStat_reg(null);
                                            log_guide_refund.add(archguip_pro_dv[0]);
                                        }
                                        else{
                                            archguip_pro_dv[0].setOrden(String.valueOf(numStatDev));
                                            archguip_pro_dv[0].setStat_reg("C");
                                            if (numStatDev == 1){
                                                log_guide_refund.remove(0);
                                                log_guide_refund.add(0, archguip_pro_dv[0]);
                                            }
                                            else{
                                                log_guide_refund.remove(numStatDev - 1);
                                                log_guide_refund.add(numStatDev - 1, archguip_pro_dv[0]);
                                            }
                                        }
                                    }
                                    else{
                                        Gui.getInstance().showMessage("La Cant. Faltante no puede ser mayor a la Cant. en Factura!", "A");
                                        tf_cantdv.requestFocus();
                                    }
                                }
                            } 
                            else {
                                Fxp_Renglon[] renglon = 
                                    Ln.getInstance().find_Renglon(tf_factdv.getText());

                                for (int i = 0; i < renglon.length; i++) {
                                    if (numStatDev == 0){
                                        archguip_pro_dv = 
                                            Ln.getInstance().find_Archguip_pro_fact(tf_factdv.getText(), String.valueOf(numClieDev), renglon[i].getCodigo());
                                        boo = true;
                                    }
                                    else{
                                        archguip_pro_dv = 
                                            Ln.getInstance().find_Archguip_pro_fact(tf_factdv.getText(), String.valueOf(numClieDev), tf_proddv.getText());
                                        boo = false;
                                    }

                                    archguip_pro_dv[0].setFecha(Date.valueOf(dp_faltdv.getValue()));
                                    archguip_pro_dv[0].setIdChequeador(tf_cheqpdv.getText().trim());
                                    archguip_pro_dv[0].setNumfact(tf_factdv.getText().trim());
                                    if (numStatDev == 0){
                                        archguip_pro_dv[0].setCodigo(renglon[i].getCodigo().trim());
                                        archguip_pro_dv[0].setICantFalt(renglon[i].getCantdesp());
                                        archguip_pro_dv[0].setSCantFalt(renglon[i].getCantdesp() + " " + renglon[i].getUnidad());

                                        archguip_pro_dv[0].setUnidfalt(renglon[i].getId_unidad());
                                    }
                                    else{
                                        archguip_pro_dv[0].setCodigo(tf_proddv.getText().trim());
                                        archguip_pro_dv[0].setICantFalt(Integer.parseInt(tf_cantdv.getText()));
                                        archguip_pro_dv[0].setSCantFalt(tf_cantdv.getText() + " " + cb_uniddv.getValue());

                                        Unit unit = (Unit) cb_uniddv.getValue();            
                                        archguip_pro_dv[0].setUnidfalt(unit.getIdUnit());
                                    }
                                    archguip_pro_dv[0].setICantDesp(renglon[i].getCantdesp());
                                    archguip_pro_dv[0].setPre_marc(Double.parseDouble(tf_pmarcado.getText()));
                                    archguip_pro_dv[0].setPre_fact(dblPvp);
                                    archguip_pro_dv[0].setIdAlmacen(renglon[i].getId_almacen());
                                    archguip_pro_dv[0].setObserv(tf_obserdv.getText().toUpperCase().trim());

                                     //Se obtiene Motivo
                                    archguip_pro_dv[0].setIdMotivo(Datos.getLog_tmotdev().getIdTMotdev());
                                    archguip_pro_dv[0].setSmotivo(Datos.getLog_tmotdev().getAbrev());

                                    if (numStatDev == 0){
                                        archguip_pro_dv[0].setOrden(String.valueOf(log_guide_refund.size() + 1));
                                        archguip_pro_dv[0].setStat_reg(null);
                                        log_guide_refund.add(archguip_pro_dv[0]);
                                    }
                                    else{
                                        archguip_pro_dv[0].setOrden(String.valueOf(numStatDev));
                                        archguip_pro_dv[0].setStat_reg("C");
                                        if (numStatDev == 1){
                                            log_guide_refund.remove(0);
                                            log_guide_refund.add(0, archguip_pro_dv[0]);
                                        }
                                        else{
                                            log_guide_refund.remove(numStatDev - 1);
                                            log_guide_refund.add(numStatDev - 1, archguip_pro_dv[0]);
                                        }
                                    }
                                    if(!boo){
                                        break;
                                    }
                                }
                            }
                            loadTableRefund();
                            tf_motivodv.setText("");
                            tf_proddv.setText("");
                            tf_cantdv.setText("");
                            tf_pmarcado.setText("0");
                            cb_motivodv.setValue(null);
                            cb_uniddv.setValue(null);

                            tf_proddv.setDisable(false);
                            tf_cantdv.setDisable(false);
                            cb_uniddv.setDisable(false);

                            numNotaDev = 0;
                            numStatDev = 0;
                            numAlmacen = 0;
                            dblPvp = 0;
                            switch (Datos.getLog_tmotdev().getValobserv()){
                                case 0:
                                    break;
                                case 1:
                                    tf_obserdv.setText("");
                                    break;
                            }

                            tf_factdv.requestFocus();
                        }
                    }
                }
            }
        });

    }   

    /***************************************************************************/
    /********************** METODOS DE INTERFAZ GRAFICA ************************/
    /***************************************************************************/
    
    /**
     * Metodo que permite cambiar la imagen del boton CheckUsername
     * @param boo TRUE si el MEASURE esta validado
     */
    private void change_im_check(boolean boo){
        if(boo){    //IMAGEN SI EL MEASURE ES CORRECTO
            im_check.setImage(new Image(getClass().getResourceAsStream("/Images/img06.png")));
        }else{      //IMAGEN PARA LA BUSQUEDA DE UN MEASURE
            im_check.setImage(new Image(getClass().getResourceAsStream("/Images/img34.png")));
        }
    }
    /**
     * Metodo que permite cambiar la imagen del boton CheckUserSupplier
     * @param boo TRUE si el VEHICULO esta validado
     */
    private void change_im_val(int boo, ImageView im_obj){
        if(boo == 200){    //IMAGEN SI EL VEHICULO ES CORRECTO
            im_obj.setImage(new Image(getClass().getResourceAsStream("/Images/img57a.png")));
        }else{      //IMAGEN PARA LA BUSQUEDA DE UN VEHICULO
            im_obj.setImage(new Image(getClass().getResourceAsStream("/Images/img61a.png")));
        }
    }
    /**
     * Metodo que permite cambiar la imagen del boton Cambio de Status
     * @param boo 0 si esta DESHABILITADO, 1 si esta HABILITADO 
     */
    private void change_im_tool4(int boo){
        if(boo == 0){   //IMAGEN SI EL USUARIO ESTA INHABILITADO
            im_tool4.setImage(new Image(getClass().getResourceAsStream("/Images/img07.png")));
        }else{          //IMAGEN PARA HABILITAR AL USUARIO
            im_tool4.setImage(new Image(getClass().getResourceAsStream("/Images/img06.png")));
        }
    }
    /**
     * Metodo que permite cambiar la imagen Status por la Fecha del documento
     * @param sta si esta VENCIDO, 1 si esta X VENCER 
     * @param dia si esta <46 alerta al usuario
     * @param ima si esta OBJETO
     */
    private void changeIconDate(String sta, Integer dia, ImageView ima){
        switch (sta){
            case "vencido":
                ima.setImage(new Image(getClass().getResourceAsStream("/Images/img61a.png")));
                break;
            case "x vencer":
                if (dia < 46)
                    ima.setImage(new Image(getClass().getResourceAsStream("/Images/img59a.png")));
                else
                    ima.setImage(new Image(getClass().getResourceAsStream("/Images/img57a.png")));
                break;
        }
    }
    /**
     * Metodo que establece el estado grafico del formulario, y mueve la tabla de datos
     * de posicion vertical
     * @param value TRUE si el formulario es Visible
     */
    private void setFormVisible(boolean value){
        vb_form.setVisible(value);  //Establece el estado grafico del formulario
    }           
    /**
     * Metodo que establece el valor maximo y minimo de cada columna una tabla
     * @param col Columna que va a ser Configurada
     * @param min Valor minimo del ancho de la Columna
     * @param max Valor maximo del ancho de la Columna
     */
    private void objectWidth(TableColumn col,int min,int max){
        col.setMinWidth(min);   //Establece el valor minimo
        col.setMaxWidth(max);   //Establece el valor maximo
    }

    /**
     * 
     */
    public static void refreshIdBusqueda(){
        //tf_chofer.setText(Gui.getIdBusqueda());
    }
    
}
