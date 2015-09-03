/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Screens;

import GUI.Gui;
import LN.Ln;
import LN.xy;
import Listeners.FocusPropertyChangeListener;
import Objects.Fxp_Archguid;
import Objects.Fxp_Archguid_gfc;
import Objects.Fxp_Archguip_det;
import Objects.log_CGuias;
import Objects.log_Guide;
import Objects.log_Guide_rel_inv;
import Tools.Datos;
import java.math.RoundingMode;
import java.net.URL;
import java.sql.Date;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
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
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author MITM
 */
public class Fxml_Guide_paydeskController implements Initializable {

    @FXML
    private AnchorPane ap_root;

    @FXML
    private Accordion ac_ppal;
    
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
    private ComboBox<?> cb_destino;

    @FXML
    private DatePicker dt_fcarga;
    
    @FXML
    private DatePicker dt_relacion;
    
    @FXML
    private HBox hb_1;    
    
    @FXML
    private HBox hbox_toolbar;

    @FXML
    private ImageView im_check;

    @FXML
    private ImageView im_checkg;

    @FXML
    private ImageView im_tool2;

    @FXML
    private ImageView im_tool1;

    @FXML
    private ImageView im_tool8;

    @FXML
    private ImageView im_tool12;

    @FXML
    private ImageView im_tool7;

    @FXML
    private ImageView im_tool9;

    @FXML
    private ImageView im_tool4;

    @FXML
    private ImageView im_tool3;

    @FXML
    private ImageView im_tool6;

    @FXML
    private ImageView im_tool10;

    @FXML
    private ImageView im_tool5;

    @FXML
    private ImageView im_tool11;

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
    private Label lb_supruta; 

    @FXML
    private TableView<xy> tb_guias;

    @FXML
    private TableView<Fxp_Archguid> tb_factura;

    @FXML
    private TextField tf_buscar;

    @FXML
    private TextField tf_nroguia;

    @FXML
    private TextField tf_nrorguia;

    @FXML
    private TextField tf_pcarga;

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
    private TitledPane tp_factura;

    @FXML
    private TitledPane tp_carga;
    
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

    
    boolean keybackspace = false;

    private static int tipoOperacion;    
    private static ImageView[] tools;    
    private static Integer[] toolsConfig;    
    private static String[] tooltips;

    private static int numGuias         = 0; 

    private static int numFactCarga     = 0; 
    private static int numClieCarga     = 0; 
    
    private static final ObservableList<xy> log_guide_guia = FXCollections.observableArrayList();

    private static final String ScreenName = "Relación de Caja";
    
    /**
     * Initializes the controller class.
     * @param fxmlFileLocation
     * @param resources
     */     
    @Override // This method is called by the FXMLLoader when initialization is complete
    public void initialize(URL fxmlFileLocation, ResourceBundle resources) {
        assert ap_root != null : "fx:id=\"ap_root\" was not injected: check your FXML file 'Fxml_Guide_paydesk.fxml'.";
        assert ac_ppal != null : "fx:id=\"ac_ppal\" was not injected: check your FXML file 'Fxml_Guide_paydesk.fxml'.";
        assert bt_c1 != null : "fx:id=\"bt_c1\" was not injected: check your FXML file 'Fxml_Guide_paydesk.fxml'.";
        assert bt_c2 != null : "fx:id=\"bt_c2\" was not injected: check your FXML file 'Fxml_Guide_paydesk.fxml'.";
        assert bt_c3 != null : "fx:id=\"bt_c3\" was not injected: check your FXML file 'Fxml_Guide_paydesk.fxml'.";
        assert bt_c4 != null : "fx:id=\"bt_c4\" was not injected: check your FXML file 'Fxml_Guide_paydesk.fxml'.";
        assert bt_c5 != null : "fx:id=\"bt_c5\" was not injected: check your FXML file 'Fxml_Guide_paydesk.fxml'.";
        assert bt_c6 != null : "fx:id=\"bt_c6\" was not injected: check your FXML file 'Fxml_Guide_paydesk.fxml'.";
        assert bt_c7 != null : "fx:id=\"bt_c7\" was not injected: check your FXML file 'Fxml_Guide_paydesk.fxml'.";
        assert cb_destino != null : "fx:id=\"cb_destino\" was not injected: check your FXML file 'Fxml_Guide_paydesk.fxml'.";
        assert dt_fcarga != null : "fx:id=\"dt_fcarga\" was not injected: check your FXML file 'Fxml_Guide_paydesk.fxml'.";
        assert dt_relacion != null : "fx:id=\"dt_relacion\" was not injected: check your FXML file 'Fxml_Guide_paydesk.fxml'.";
        assert hb_1 != null : "fx:id=\"hb_1\" was not injected: check your FXML file 'Fxml_Guide_paydesk.fxml'.";
        assert hbox_toolbar != null : "fx:id=\"hbox_toolbar\" was not injected: check your FXML file 'Fxml_Guide_paydesk.fxml'.";
        assert im_check != null : "fx:id=\"im_check\" was not injected: check your FXML file 'Fxml_Guide.fxml'.";
        assert im_checkg != null : "fx:id=\"im_checkg\" was not injected: check your FXML file 'Fxml_Guide.fxml'.";
        assert im_tool1 != null : "fx:id=\"im_tool1\" was not injected: check your FXML file 'Fxml_Guide_paydesk.fxml'.";
        assert im_tool10 != null : "fx:id=\"im_tool10\" was not injected: check your FXML file 'Fxml_Guide_paydesk.fxml'.";
        assert im_tool11 != null : "fx:id=\"im_tool11\" was not injected: check your FXML file 'Fxml_Guide_paydesk.fxml'.";
        assert im_tool12 != null : "fx:id=\"im_tool12\" was not injected: check your FXML file 'Fxml_Guide_paydesk.fxml'.";
        assert im_tool2 != null : "fx:id=\"im_tool2\" was not injected: check your FXML file 'Fxml_Guide_paydesk.fxml'.";
        assert im_tool3 != null : "fx:id=\"im_tool3\" was not injected: check your FXML file 'Fxml_Guide_paydesk.fxml'.";
        assert im_tool4 != null : "fx:id=\"im_tool4\" was not injected: check your FXML file 'Fxml_Guide_paydesk.fxml'.";
        assert im_tool5 != null : "fx:id=\"im_tool5\" was not injected: check your FXML file 'Fxml_Guide_paydesk.fxml'.";
        assert im_tool6 != null : "fx:id=\"im_tool6\" was not injected: check your FXML file 'Fxml_Guide_paydesk.fxml'.";
        assert im_tool7 != null : "fx:id=\"im_tool7\" was not injected: check your FXML file 'Fxml_Guide_paydesk.fxml'.";
        assert im_tool8 != null : "fx:id=\"im_tool8\" was not injected: check your FXML file 'Fxml_Guide_paydesk.fxml'.";
        assert im_tool9 != null : "fx:id=\"im_tool9\" was not injected: check your FXML file 'Fxml_Guide_paydesk.fxml'.";
        assert im_val != null : "fx:id=\"im_val\" was not injected: check your FXML file 'Fxml_Guide_paydesk.fxml'.";
        assert im_lcc != null : "fx:id=\"im_lcc\" was not injected: check your FXML file 'Fxml_Guide_paydesk.fxml'.";
        assert im_cmc != null : "fx:id=\"im_cmc\" was not injected: check your FXML file 'Fxml_Guide_paydesk.fxml'.";
        assert im_csc != null : "fx:id=\"im_csc\" was not injected: check your FXML file 'Fxml_Guide_paydesk.fxml'.";
        assert im_mac != null : "fx:id=\"im_mac\" was not injected: check your FXML file 'Fxml_Guide_paydesk.fxml'.";
        assert im_rcv1 != null : "fx:id=\"im_rcv1\" was not injected: check your FXML file 'Fxml_Guide_paydesk.fxml'.";
        assert im_ps1 != null : "fx:id=\"im_ps1\" was not injected: check your FXML file 'Fxml_Guide_paydesk.fxml'.";
        assert im_rgt1 != null : "fx:id=\"im_rgt1\" was not injected: check your FXML file 'Fxml_Guide_paydesk.fxml'.";
        assert im_rcv2 != null : "fx:id=\"im_rcv2\" was not injected: check your FXML file 'Fxml_Guide_paydesk.fxml'.";
        assert im_ps2 != null : "fx:id=\"im_ps2\" was not injected: check your FXML file 'Fxml_Guide_paydesk.fxml'.";
        assert im_rgt2 != null : "fx:id=\"im_rgt2\" was not injected: check your FXML file 'Fxml_Guide_paydesk.fxml'.";
        assert lb_chofer != null : "fx:id=\"lb_chofer\" was not injected: check your FXML file 'Fxml_Guide_paydesk.fxml'.";
        assert lb_veh1 != null : "fx:id=\"lb_veh1\" was not injected: check your FXML file 'Fxml_Guide_paydesk.fxml'.";
        assert lb_veh2 != null : "fx:id=\"lb_veh2\" was not injected: check your FXML file 'Fxml_Guide_paydesk.fxml'.";
        assert lb_ayud1 != null : "fx:id=\"lb_ayud1\" was not injected: check your FXML file 'Fxml_Guide_paydesk.fxml'.";
        assert lb_ayud2 != null : "fx:id=\"lb_ayud2\" was not injected: check your FXML file 'Fxml_Guide_paydesk.fxml'.";
        assert lb_cheqp != null : "fx:id=\"lb_cheqp\" was not injected: check your FXML file 'Fxml_Guide_paydesk.fxml'.";
        assert lb_supruta != null : "fx:id=\"lb_supruta\" was not injected: check your FXML file 'Fxml_Guide_paydesk.fxml'.";
        assert lb_rgt1 != null : "fx:id=\"lb_ayud1\" was not injected: check your FXML file 'Fxml_Guide_paydesk.fxml'.";
        assert lb_rgt2 != null : "fx:id=\"lb_ayud2\" was not injected: check your FXML file 'Fxml_Guide_paydesk.fxml'.";
        assert lb_screen != null : "fx:id=\"lb_screen\" was not injected: check your FXML file 'Fxml_Guide_paydesk.fxml'.";
        assert lb_Title != null : "fx:id=\"lb_Title\" was not injected: check your FXML file 'Fxml_Guide_paydesk.fxml'.";
        assert tb_guias != null : "fx:id=\"tb_guias\" was not injected: check your FXML file 'Fxml_Guide_paydesk.fxml'.";
        assert tb_factura != null : "fx:id=\"tb_factura\" was not injected: check your FXML file 'Fxml_Guide_paydesk.fxml'.";
        assert tf_buscar != null : "fx:id=\"tf_pcarga\" was not injected: check your FXML file 'Fxml_Guide_paydesk.fxml'.";
        assert tf_nroguia != null : "fx:id=\"tf_nrofguia\" was not injected: check your FXML file 'Fxml_Guide_paydesk.fxml'.";
        assert tf_nrorguia != null : "fx:id=\"tf_nrofguia\" was not injected: check your FXML file 'Fxml_Guide_paydesk.fxml'.";
        assert tf_pcarga != null : "fx:id=\"tf_pcarga\" was not injected: check your FXML file 'Fxml_Guide_paydesk.fxml'.";
        assert tf_chofer != null : "fx:id=\"tf_chofer\" was not injected: check your FXML file 'Fxml_Guide_paydesk.fxml'.";
        assert tf_veh1 != null : "fx:id=\"tf_veh1\" was not injected: check your FXML file 'Fxml_Guide_paydesk.fxml'.";
        assert tf_veh2 != null : "fx:id=\"tf_veh2\" was not injected: check your FXML file 'Fxml_Guide_paydesk.fxml'.";
        assert tf_ayud1 != null : "fx:id=\"tf_ayud1\" was not injected: check your FXML file 'Fxml_Guide_paydesk.fxml'.";
        assert tf_ayud2 != null : "fx:id=\"tf_ayud2\" was not injected: check your FXML file 'Fxml_Guide_paydesk.fxml'.";
        assert tf_cheqp != null : "fx:id=\"tf_cheqp\" was not injected: check your FXML file 'Fxml_Guide_paydesk.fxml'.";
        assert tf_supruta != null : "fx:id=\"tf_supruta\" was not injected: check your FXML file 'Fxml_Guide_paydesk.fxml'.";
        assert tp_factura != null : "fx:id=\"tp_factura\" was not injected: check your FXML file 'Fxml_Guide_paydesk.fxml'.";
        assert tp_carga != null : "fx:id=\"tp_carga\" was not injected: check your FXML file 'Fxml_Guide_paydesk.fxml'.";
        assert vb_form != null : "fx:id=\"vb_form\" was not injected: check your FXML file 'Fxml_Guide_paydesk.fxml'.";
        assert vb_table != null : "fx:id=\"vb_table\" was not injected: check your FXML file 'Fxml_Guide_paydesk.fxml'.";

        //Inicializa la Barra de Herramientas y comportamiento del Boton de Busqueda
        defineToolBar();         
        defineBotonBuscar();    
        init_buttons(); //Establece los comportamientos de los botones
        botonInicio();  //Se imprime la pantalla Inicio

        //
        createTableGuide();     //Crea e Inicializa la Tabla de Datos   
        createTableBill();      //Crea e Inicializa la Tabla de Datos   

        cb_destino.setVisible(false);

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
        this.objectWidth(col_orden      , 26,  26); 
        this.objectWidth(col_guide      , 50,  50); 
        this.objectWidth(stat_guia      , 18,  18);

        col_guide.setCellFactory(TextFieldTableCell.forTableColumn());        

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
            final MenuItem removeMenuItem = new MenuItem("Quitar de la Relación");

            contextMenu.getItems().add(removeMenuItem);
            removeMenuItem.setOnAction((ActionEvent event) -> {
                switch (tipoOperacion){
                    case 1:
                        numFactCarga = numFactCarga - tb_guias.getItems().get(row.getIndex()).getNumfact();
                        numClieCarga = numClieCarga - tb_guias.getItems().get(row.getIndex()).getNumclie();

                        //tb_guias.getItems().remove(row.getItem());
                        tb_guias.getItems().remove(tb_guias.getSelectionModel().getSelectedIndex());
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
                tf_chofer.setEditable(false);
                tf_veh1.setEditable(false);
                tf_veh2.setEditable(false);
                tf_ayud1.setEditable(false);
                tf_ayud2.setEditable(false);
                tf_cheqp.setEditable(false);
                tf_supruta.setEditable(false);

                dt_fcarga.setDisable(true);
                dt_relacion.setDisable(true);

                im_check.setVisible(false);
                im_val.setVisible(false);

                bt_c1.setDisable(true);
                bt_c2.setDisable(true);
                bt_c3.setDisable(true);
                bt_c4.setDisable(true);
                bt_c5.setDisable(true);
                bt_c6.setDisable(true);
                bt_c7.setDisable(true);

                //SE PERMITE: NUEVO, CANCELAR Y BUSCAR
                disables = new Integer[]{2,5,6,9,10};
                disableAllToolBar(disables); 
                hb_1.setVisible(true);
                break;
            case 1:  //NUEVO
                lb_Title.setText("NUEVO");

                tf_nroguia.setEditable(false);
                tf_nrorguia.setEditable(true);

                dt_relacion.setDisable(false);

                im_check.setVisible(true);
                im_val.setVisible(false);

                //SE PERMITE: NUEVO,GUARDAR Y CANCELAR             
                disables = new Integer[]{0,1,3,4,6,7,8,9,10,11};
                disableAllToolBar(disables);                            
                break;
            case 2:  //EDITAR
                lb_Title.setText("EDITAR");

                tf_nroguia.setEditable(false);
                tf_nrorguia.setEditable(true);

                dt_relacion.setDisable(false);
                
                im_check.setVisible(true);
                im_val.setVisible(false);
                
                //SE PERMITE: EDITAR,GUARDAR Y CANCELAR
                disables = new Integer[]{0,1,3,4,6,7,8,9,10,11};
                disableAllToolBar(disables);            
                break;
            case 3:  //GUARDAR
                tf_nroguia.setEditable(true);
                tf_nrorguia.setEditable(false);

                dt_relacion.setDisable(true);
                
                im_check.setVisible(false);
                im_val.setVisible(false);

                //SE PERMITE: GUARDAR Y CANCELAR
                disables = new Integer[]{0,1,3,4,6,7,8,9,10,11};
                disableAllToolBar(disables);   
                break;
            case 4:  //CAMBIAR STATUS 
                tf_nroguia.setEditable(true);
                tf_nrorguia.setEditable(false);

                dt_relacion.setDisable(true);
                
                im_check.setVisible(false);
                im_val.setVisible(false);

                //SE PERMITE: GUARDAR,CAMBIO STATUS Y CANCELAR
                disables = new Integer[]{2,5,6,7,8,9,10};
                disableAllToolBar(disables); 
                break;
        }        
        init_FocusArray(tipoOperacion);       
        Gui.getInstance().setTipoOperacion(tipoOperacion);
    }    

    /**
     * Metodo que selecciona y llena el formulario con los datos del usuario 
     * seleccionado en la tabla
     */
    private void selectedRowGuide(){
        xy log_guide_rel_inv  = tb_guias.getSelectionModel().getSelectedItem();          
        loadTables(log_guide_rel_inv.getGuias());
        loadCarga(log_guide_rel_inv.getGuias());
        
        List<Fxp_Archguid_gfc> data = Ln.getList_log_Archguid_gfc(Ln.getInstance().find_Archguid_gfc(log_guide_rel_inv.getGuias()));

        tp_factura.setText(
            "Relación de Guia / Facturas / Clientes " + 
            "               -          " + 
            data.size() + " / " + 
            data.get(0).getNumfact() + " / " + 
            data.get(0).getNumclie());

        tp_factura.setExpanded(true);
        
    }
    /**
     * Metodo que selecciona y llena el formulario con los datos del usuario 
     * seleccionado en la tabla
     */
    private void selectedRowInvoice(){
        //numOrdenInv = tb_factura.getSelectionModel().getSelectedIndex();
    }
    /**
     * Procedimiento de llenado de datos en la tabla de datos
     */
    private void loadTable(log_CGuias[] log_cguias){    
        if(log_cguias != null){
            Datos.setNumRel_Caj(log_cguias[0].getNumcaja());

            ObservableList<xy> data = FXCollections.observableArrayList();
            data.addAll(Arrays.asList(log_cguias));   

            numGuias = data.size();
            
            log_guide_guia.clear();

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
            
            tf_nroguia.setText(String.valueOf(log_cguias[0].getNumcaja()));
            if(log_cguias[0].getFeccaja()== null)
                dt_relacion.setValue(LocalDate.now());
            else
                dt_relacion.setValue(log_cguias[0].getFeccaja().toLocalDate());

        }
        else {
            botonInicio();
        }
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
    private void loadTables(String NroGuia){
        log_Guide log_guide = new log_Guide();
        
        if (NroGuia.isEmpty()){
            tb_factura.setItems(null);
        }else{
            log_guide.setTp_factura(Ln.getInstance().find_Archguid(NroGuia, ""));
            loadTableBill(tb_factura, log_guide.getTp_factura() );     
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
     * Metodo que selecciona y llena el formulario con los datos del usuario 
     * seleccionado en la tabla
     */
    private void loadCarga(String NroGuia){
        log_CGuias[] log_cguias_carga = Ln.getInstance().find_log_CGuias(NroGuia, "", "nguia", Integer.parseInt(rows));
        
        tf_pcarga.setText(String.valueOf(log_cguias_carga[0].getNumpuerta()));
        tf_chofer.setText(log_cguias_carga[0].getChofer());
        tf_veh1.setText(log_cguias_carga[0].getVeh1());
        tf_veh2.setText(log_cguias_carga[0].getVeh2());
        if (log_cguias_carga[0].getAyud1() != null)
            tf_ayud1.setText(log_cguias_carga[0].getAyud1());
        else
            tf_ayud1.setText("");
        if (log_cguias_carga[0].getAyud2() != null)
            tf_ayud2.setText(log_cguias_carga[0].getAyud2());
        else
            tf_ayud2.setText("");
        tf_cheqp.setText(log_cguias_carga[0].getCheq_pta());
        if (log_cguias_carga[0].getIdsupruta() != null)
            tf_supruta.setText(log_cguias_carga[0].getIdsupruta());
        else
            tf_supruta.setText("");

        lb_chofer.setText(log_cguias_carga[0].getSchofer());
        lb_ayud1.setText(log_cguias_carga[0].getSayud1());
        lb_cheqp.setText(log_cguias_carga[0].getScheq_pta());
        lb_supruta.setText(log_cguias_carga[0].getSsup_ruta());
        
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

        //Ejecuta los procesos predeterminados para el guardado de la guia
        setCurrentOperation();
        //Se asignan los valores del objeto 
        boolean result = false;
        log_CGuias log_cguias = new log_CGuias();

        for (int i = 0; i < log_guide_guia.size(); i++) {
            log_cguias.setNumguia(tb_guias.getItems().get(i).getGuias());      
            log_cguias.setFeccaja(Date.valueOf(dt_relacion.getValue()));

            result = 
                    Ln.getInstance().save_log_CGuias_caja(log_cguias, proceso, i, ScreenName);
        }

        //Si el Resultado es correcto
        if(result){
            //Se Notifica al usuario
            tf_nroguia.setText(Datos.getNumRela());
            Gui.getInstance().showMessage("La " + ScreenName + " se ha Guardado Correctamente!", "I");
            return true;
        }     
        return true;
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
                    tf_nroguia, dt_relacion, tf_nrorguia
                    };
                break;
            case 1:     //NUEVO
                nodos = new Node[]{
                    tf_nroguia, dt_relacion, tf_nrorguia
                    };
                break;
            case 2:     //EDITAR
                nodos = new Node[]{
                    tf_nroguia, dt_relacion, tf_nrorguia
                    };
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
        }else{  //Sino
//            botonGuardar();  //Guardar los datos
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
        im_tool8.setVisible(false);
        im_tool9.setVisible(false);
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
                        boolean boo = Ln.getInstance().check_log_CGuias_caja(tf_buscar.getText());                
                        numGuias = 0;
                        if(boo){
                            Datos.setRep_log_cguias(Ln.getInstance().find_log_CGuias(tf_buscar.getText(), "", "ncaja", Integer.parseInt(rows)));
                            loadTable(Datos.getRep_log_cguias());     
                        }
                        else{
                            change_im_val(0, im_checkg); 
                            Gui.getInstance().showMessage("El Nro. Guia NO existe en la " + ScreenName, "A");
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
        numGuias = 0;
        
        loadToolBar();
        //SE LIMPIA EL FORMULARIO
        tf_nroguia.setText("");
        tf_nrorguia.setText("");
        tf_pcarga.setText("");
        tf_chofer.setText("");
        tf_veh1.setText("");
        tf_veh2.setText("");
        tf_ayud1.setText("");
        tf_ayud2.setText("");
        tf_cheqp.setText("");
        tf_supruta.setText("");

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
        
        dt_fcarga.setValue(LocalDate.now());
        dt_relacion.setValue(LocalDate.now());
        
        tp_factura.setText("Relación de Guia / Facturas / Clientes ");

        Datos.setLog_cguias(new log_CGuias());                           
        Datos.setLog_guide_rel_inv(new log_Guide_rel_inv());
        refreshForm();                      
        Datos.setLog_cguias(null);                  //RESET DE LA VARIABLE
        Datos.setLog_guide_rel_inv(null);           //RESET DE LA VARIABLE
        setFormVisible(false);                      //OCULTA EL FORMULARIO
        //RECARGA LA TABLA ORIGINAL
        loadTableGuide_guias();
        loadTables("");

        tp_factura.setExpanded(false);
        tp_carga.setExpanded(false);

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
    private void botonGuardar(){   
        if(Datos.getLog_cguias()!= null){
            boolean result = false;
            switch (tipoOperacion){
                case 1:
                    if(toolsConfig[4]==1)
                        result = saveCGuias();
                    break;
                case 2:
                    if(toolsConfig[4]==1)
                        result = saveCGuias();
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
            JasperReport jReport = null;
            JasperViewer jview = null;
            JasperPrint jPrint = null;

            //Datos
            List<log_CGuias> data = Ln.getList_log_CGuias(Datos.getRep_log_cguias());
            JRBeanCollectionDataSource JRDs = new JRBeanCollectionDataSource(data, true);

            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); // Set your date format

            //Parametros
            JrxmlParam.put("p_user", Datos.getSesion().getUsername());
            JrxmlParam.put("p_subtitulo", 
                    "Relación Nro: " + data.get(0).getNumcaja() + "         Fecha: " + sdf.format(data.get(0).getFeccaja()));

            try{
                jReport = (JasperReport) JRLoader.loadObjectFromFile(path + path_rep + "/logistica/log_guia_rela_chof.jasper");
                jPrint = JasperFillManager.fillReport(jReport, JrxmlParam, JRDs);
                jview = new JasperViewer(jPrint, false);
                jview.setTitle("DIGA - Listado de Guias (Logistica) ");

            } catch (JRException ee){
                Gui.getInstance().showMessage("Error Cargando Reporte: \n" + ee.getMessage(), "E");
            }

            jview.setVisible(true);
            jview.setResizable(false);
        }
        else{
            Gui.getInstance().showMessage("Debe indicar un Nro. de Relación de Carga!", "A");
            tf_nroguia.requestFocus();
        }

    }
    /**
     * Procedimiento que define los comportamientos en diversos Eventos 
     * de cada boton en la pantalla actual.
     */
    private void init_buttons(){
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
                    //
                }
            }
        });
        /**
         * BOTON DEVOLUCION
         */
        im_tool9.setOnMouseClicked((MouseEvent mouseEvent) -> {
            if(mouseEvent.getButton().equals(MouseButton.PRIMARY)){
                if(mouseEvent.getClickCount() > 0){
                    //
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
         * metodo para mostrar buscar el nro de guia
         * param: ENTER O TAB
         */
        tf_nroguia.setOnKeyReleased((KeyEvent ke) -> {
            if (ke.getCode().equals(KeyCode.ENTER)){
                //Valida que el evento se haya generado en el campo de busqueda
                if(((Node)ke.getSource()).getId().equals("tf_nroguia")){
                    //Solicita los datos y envia la Respuesta a imprimirse en la Pantalla
                    Datos.setLog_cguias(new log_CGuias());                           
                    boolean boo = Ln.getInstance().check_log_CGuias_rela_caja(tf_nroguia.getText());                
                    numGuias = 0;
                    if(boo){
                        Datos.setRep_log_cguias(Ln.getInstance().find_log_CGuias(tf_nroguia.getText(), "", "ncaja", Integer.parseInt(rows)));
                        loadTable(Datos.getRep_log_cguias());     
                    }
                    else{
                        change_im_val(0, im_checkg); 
                        Gui.getInstance().showMessage("El Nro. de " + ScreenName + " NO existe!", "A");
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
                if(((Node)ke.getSource()).getId().equals("tf_nrorguia")){
                    //Solicita los datos y envia la Respuesta a imprimirse en la Pantalla
                    boolean booa = true;                
                    if(booa){
                        boolean booc = Ln.getInstance().check_log_CGuias_caja(tf_nrorguia.getText());                
                        if(booc){
                            change_im_val(0, im_checkg); 
                            Gui.getInstance().showMessage("El Nro. de Guia ya esta relacionado!", "A");
                            tf_nrorguia.requestFocus();
                        }
                        else{
                            for (int i = 0; i < log_guide_guia.size(); i++) {
                                if(tf_nrorguia.getText().equals(tb_guias.getItems().get(i).getGuias())){
                                    booa = false;
                                    Gui.getInstance().showMessage("El Nro. de Guia ya esta relacionado!", "A");
                                    tf_nrorguia.requestFocus();
                                    break;
                                }
                            } 
                            if(booa){
                                log_Guide_rel_inv guide_carga = new log_Guide_rel_inv();

                                List<Fxp_Archguid_gfc> data = 
                                    Ln.getList_log_Archguid_gfc(Ln.getInstance().find_Archguid_gfc(tf_nrorguia.getText()));

                                if (data.get(0).getStat_guia().equals("X")
                                        || data.get(0).getStat_guia().equals("C")){
                                    guide_carga.setNumorden(String.valueOf((log_guide_guia.size() + 1)));
                                    guide_carga.setGuias(tf_nrorguia.getText());
                                    guide_carga.setNumfact(data.get(0).getNumfact());
                                    guide_carga.setNumclie(data.get(0).getNumclie());

                                    if (data.get(0).getStat_guia().equals("A")){
                                        if (tipoOperacion == 1)
                                            guide_carga.setStat_guia(null);
                                        else
                                            guide_carga.setStat_guia(data.get(0).getStat_guia());
                                    }
                                    else{
                                        guide_carga.setStat_guia(null);
                                    }
                                    
                                        
                                    log_guide_guia.add(guide_carga);

                                    loadTableGuide_guias();
                                    change_im_val(200, im_checkg); 

                                    numFactCarga = numFactCarga + data.get(0).getNumfact();
                                    numClieCarga = numClieCarga + data.get(0).getNumclie();

                                    tf_nrorguia.setText("");
                                }else{
                                    if (data.get(0).getStat_guia().equals("")){
                                        Gui.getInstance().showMessage("El Nro. de Guia NO tiene relación de Guia de Carga!", "A");
                                    }
                                    else{
                                        Gui.getInstance().showMessage("El Nro. de Guia ya esta relacionado!", "A");
                                    }
                                    tf_nrorguia.requestFocus();
                                }
                                    
                            }
                        }
                    }
                    else{
                        change_im_val(0, im_checkg); 
                        Gui.getInstance().showMessage("El Nro. de Guia NO existe!", "A");
                        tf_nrorguia.requestFocus();
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
//        if(value){  //Si el estado es visible entonces 
//            vb_table.relocate(30, 439);
//            vb_table.setPrefHeight(133);
//        }else{
//            vb_table.relocate(30, 64);
//            vb_table.setPrefHeight(508);
//        }
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

