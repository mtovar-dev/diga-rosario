/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI.Screens;

import GUI.Gui;
import LN.Ln;
import Listeners.FocusPropertyChangeListener;
import Listeners.SelectKeyComboBoxListener;
import Objects.Orders.Orders;
import Objects.log_CGuias;
import Objects.log_TMarca;
import Objects.log_TProced;
import Objects.log_TTransp;
import Objects.log_Vehiculos;
import Tools.Datos;
import Tools.ValidateTextFieldNumber;
import Tools.ValidateTextFieldPhone;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Tooltip;
import javafx.scene.control.cell.PropertyValueFactory;
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
import javafx.stage.FileChooser;
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
 * @author Personal
 */
public class Fxml_VehiculosController implements Initializable {
    
    @FXML
    private AnchorPane ap_root;

    @FXML
    private Button bt_cc;
    
    @FXML
    private Button bt_ps;
    
    @FXML
    private Button bt_rcv;
    
    @FXML
    private Button bt_se;
    
    @FXML
    private Button bt_rgt;
    
    @FXML
    private Button bt_tt;
    
    @FXML
    private ComboBox<log_TMarca> cb_marca;

    @FXML
    private ComboBox<log_TProced> cb_proced;

    @FXML
    private ComboBox<log_TTransp> cb_ttrans;

    @FXML
    private DatePicker dp_ps;
    
    @FXML
    private DatePicker dp_rcv;

    @FXML
    private DatePicker dp_rgt;
    
    @FXML
    private HBox hb_1;

    @FXML
    private HBox hb_2;

    @FXML
    private HBox hb_7;

    @FXML
    private HBox hbox_toolbar;

    @FXML
    private ImageView im_check;

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
    private ImageView im_rcv;

    @FXML
    private ImageView im_ps;

    @FXML
    private ImageView im_rgt;

    @FXML
    private Label lb_rcv;

    @FXML
    private Label lb_ps;
    
    @FXML
    private Label lb_rgt;

    @FXML 
    private Label lb_Title; 

    @FXML
    private Label lb_ocultar;

    @FXML
    private RadioButton rb_clasif1;
    
    @FXML
    private RadioButton rb_clasif2;
    
    @FXML
    private RadioButton rb_clasif3;
    
    @FXML
    private TableView<log_Vehiculos> tb_table;

    @FXML
    private TextField tf_buscar;

    @FXML
    private ValidateTextFieldNumber tf_capacidad;

    @FXML
    private ValidateTextFieldPhone tf_celular;

    @FXML
    private TextField tf_correo;

    @FXML
    private TextField tf_empresa;

    @FXML
    private TextField tf_rif;

    @FXML
    private ValidateTextFieldNumber tf_ano;

    @FXML
    private TextField tf_modelo;

    @FXML
    private TextField tf_placa;

    @FXML
    private TextField tf_cc;
    
    @FXML
    private TextField tf_tt;
    
    @FXML
    private TextField tf_rcv;
    
    @FXML
    private TextField tf_seguro;
    
    @FXML
    private TextField tf_ps;
    
    @FXML
    private TextField tf_rgt;
    
    @FXML
    private ValidateTextFieldNumber tf_nrorgt;
    
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
    private static Integer[] toolsConfig;    
    private static String[] tooltips;
    private File file;    
    
    private static final String ScreenName = "Vehiculo";

    final ToggleGroup rb_clasif = new ToggleGroup();

    
    /**
     * Initializes the controller class.
     * @param fxmlFileLocation
     * @param resources
     */     
    @Override // This method is called by the FXMLLoader when initialization is complete
    public void initialize(URL fxmlFileLocation, ResourceBundle resources) {
        assert ap_root != null : "fx:id=\"ap_root\" was not injected: check your FXML file 'Fxml_Vehiculos.fxml'.";
        assert bt_cc != null : "fx:id=\"bt_cc\" was not injected: check your FXML file 'Fxml_Vehiculos.fxml'.";
        assert bt_tt != null : "fx:id=\"bt_tt\" was not injected: check your FXML file 'Fxml_Vehiculos.fxml'.";
        assert bt_rcv != null : "fx:id=\"bt_rcv\" was not injected: check your FXML file 'Fxml_Vehiculos.fxml'.";
        assert bt_se != null : "fx:id=\"bt_se\" was not injected: check your FXML file 'Fxml_Vehiculos.fxml'.";
        assert bt_ps != null : "fx:id=\"bt_ps\" was not injected: check your FXML file 'Fxml_Vehiculos.fxml'.";
        assert bt_rgt != null : "fx:id=\"bt_rgt\" was not injected: check your FXML file 'Fxml_Vehiculos.fxml'.";
        assert cb_marca != null : "fx:id=\"cb_marca\" was not injected: check your FXML file 'Fxml_Vehiculos.fxml'.";
        assert cb_proced != null : "fx:id=\"cb_proced\" was not injected: check your FXML file 'Fxml_Vehiculos.fxml'.";
        assert cb_ttrans != null : "fx:id=\"cb_ttrans\" was not injected: check your FXML file 'Fxml_Vehiculos.fxml'.";
        assert dp_rcv != null : "fx:id=\"dp_rcv\" was not injected: check your FXML file 'Fxml_Vehiculos.fxml'.";
        assert dp_ps != null : "fx:id=\"dt_ps\" was not injected: check your FXML file 'Fxml_Vehiculos.fxml'.";
        assert dp_rgt != null : "fx:id=\"dt_rgt\" was not injected: check your FXML file 'Fxml_Vehiculos.fxml'.";
        assert hb_1 != null : "fx:id=\"hb_1\" was not injected: check your FXML file 'Fxml_Vehiculos.fxml'.";
        assert hb_2 != null : "fx:id=\"hb_2\" was not injected: check your FXML file 'Fxml_Vehiculos.fxml'.";
        assert hb_7 != null : "fx:id=\"hb_7\" was not injected: check your FXML file 'Fxml_Vehiculos.fxml'.";
        assert hbox_toolbar != null : "fx:id=\"hbox_toolbar\" was not injected: check your FXML file 'Fxml_Vehiculos.fxml'.";
        assert im_check != null : "fx:id=\"im_check\" was not injected: check your FXML file 'Fxml_Vehiculos.fxml'.";
        assert im_tool1 != null : "fx:id=\"im_tool1\" was not injected: check your FXML file 'Fxml_Vehiculos.fxml'.";
        assert im_tool10 != null : "fx:id=\"im_tool10\" was not injected: check your FXML file 'Fxml_Vehiculos.fxml'.";
        assert im_tool11 != null : "fx:id=\"im_tool11\" was not injected: check your FXML file 'Fxml_Vehiculos.fxml'.";
        assert im_tool12 != null : "fx:id=\"im_tool12\" was not injected: check your FXML file 'Fxml_Vehiculos.fxml'.";
        assert im_tool2 != null : "fx:id=\"im_tool2\" was not injected: check your FXML file 'Fxml_Vehiculos.fxml'.";
        assert im_tool3 != null : "fx:id=\"im_tool3\" was not injected: check your FXML file 'Fxml_Vehiculos.fxml'.";
        assert im_tool4 != null : "fx:id=\"im_tool4\" was not injected: check your FXML file 'Fxml_Vehiculos.fxml'.";
        assert im_tool5 != null : "fx:id=\"im_tool5\" was not injected: check your FXML file 'Fxml_Vehiculos.fxml'.";
        assert im_tool6 != null : "fx:id=\"im_tool6\" was not injected: check your FXML file 'Fxml_Vehiculos.fxml'.";
        assert im_tool7 != null : "fx:id=\"im_tool7\" was not injected: check your FXML file 'Fxml_Vehiculos.fxml'.";
        assert im_tool8 != null : "fx:id=\"im_tool8\" was not injected: check your FXML file 'Fxml_Vehiculos.fxml'.";
        assert im_tool9 != null : "fx:id=\"im_tool9\" was not injected: check your FXML file 'Fxml_Vehiculos.fxml'.";
        assert im_val != null : "fx:id=\"im_val\" was not injected: check your FXML file 'Fxml_Vehiculos.fxml'.";
        assert im_rcv != null : "fx:id=\"im_rcv\" was not injected: check your FXML file 'Fxml_Vehiculos.fxml'.";
        assert lb_ps != null : "fx:id=\"lb_ps\" was not injected: check your FXML file 'Fxml_Vehiculos.fxml'.";
        assert lb_rgt != null : "fx:id=\"lb_rgt\" was not injected: check your FXML file 'Fxml_Vehiculos.fxml'.";
        assert lb_Title != null : "fx:id=\"lb_Title\" was not injected: check your FXML file 'Fxml_Supplier.fxml'.";
        assert lb_ocultar != null : "fx:id=\"lb_ocultar\" was not injected: check your FXML file 'Fxml_Vehiculos.fxml'.";
        assert rb_clasif1 != null : "fx:id=\"rb_clasif1\" was not injected: check your FXML file 'Fxml_Vehiculos.fxml'."; 
        assert rb_clasif2 != null : "fx:id=\"rb_clasif2\" was not injected: check your FXML file 'Fxml_Vehiculos.fxml'."; 
        assert rb_clasif3 != null : "fx:id=\"rb_clasif3\" was not injected: check your FXML file 'Fxml_Vehiculos.fxml'."; 
        assert tb_table != null : "fx:id=\"tb_table\" was not injected: check your FXML file 'Fxml_Vehiculos.fxml'.";
        assert tf_buscar != null : "fx:id=\"tf_buscar\" was not injected: check your FXML file 'Fxml_Vehiculos.fxml'.";
        assert tf_capacidad != null : "fx:id=\"tf_capacidad\" was not injected: check your FXML file 'Fxml_Vehiculos.fxml'.";
        assert tf_celular != null : "fx:id=\"tf_celular\" was not injected: check your FXML file 'Fxml_Vehiculos.fxml'.";
        assert tf_rcv != null : "fx:id=\"tf_rcv\" was not injected: check your FXML file 'Fxml_Vehiculos.fxml'.";
        assert tf_seguro != null : "fx:id=\"tf_seguro\" was not injected: check your FXML file 'Fxml_Vehiculos.fxml'.";
        assert tf_ps != null : "fx:id=\"tf_ps\" was not injected: check your FXML file 'Fxml_Vehiculos.fxml'.";
        assert tf_rgt != null : "fx:id=\"tf_rgt\" was not injected: check your FXML file 'Fxml_Vehiculos.fxml'.";
        assert tf_nrorgt != null : "fx:id=\"tf_nrorgt\" was not injected: check your FXML file 'Fxml_Vehiculos.fxml'.";
        assert tf_correo != null : "fx:id=\"tf_correo\" was not injected: check your FXML file 'Fxml_Vehiculos.fxml'.";
        assert tf_empresa != null : "fx:id=\"tf_empresa\" was not injected: check your FXML file 'Fxml_Vehiculos.fxml'.";
        assert tf_rif != null : "fx:id=\"tf_rif\" was not injected: check your FXML file 'Fxml_Vehiculos.fxml'.";
        assert tf_ano != null : "fx:id=\"tf_ano\" was not injected: check your FXML file 'Fxml_Vehiculos.fxml'.";
        assert tf_modelo != null : "fx:id=\"tf_modelo\" was not injected: check your FXML file 'Fxml_Vehiculos.fxml'.";
        assert tf_placa != null : "fx:id=\"tf_placa\" was not injected: check your FXML file 'Fxml_Vehiculos.fxml'.";
        assert vb_form != null : "fx:id=\"vb_form\" was not injected: check your FXML file 'Fxml_Vehiculos.fxml'.";
        assert vb_table != null : "fx:id=\"vb_table\" was not injected: check your FXML file 'Fxml_Vehiculos.fxml'.";

        //Inicializa la Barra de Herramientas y comportamiento del Boton de Busqueda
        defineToolBar();         
        defineBotonBuscar();    
        init_buttons();     //Establece los comportamientos de los botones
        botonInicio();      //Se imprime la pantalla Inicio
        
        //
        loadBrands();
        loadTProced();
        loadTTransp();
        createTable();  //Crea e Inicializa la Tabla de Datos                    

        tf_celular.setMaxlength(12);

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
    private void createTable(){
        //Se crean y definen las columnas de la Tabla
        TableColumn col_status          = new TableColumn("Act");
        TableColumn col_nroplaca        = new TableColumn("Nro Placa");                
        TableColumn col_modelo          = new TableColumn("Modelo");        
        TableColumn col_capacidad       = new TableColumn("Cap. Carga");        
        TableColumn col_tmarca          = new TableColumn("T/Marca");
        TableColumn col_tproced         = new TableColumn("T/Proced");        
        TableColumn col_ttransp         = new TableColumn("T/Transp");        
        TableColumn col_empresa         = new TableColumn("Empresa");        
        TableColumn col_telefonos       = new TableColumn("Teléfonos");        
        TableColumn col_celular         = new TableColumn("Celular");        
        TableColumn col_correo          = new TableColumn("Correo");        

        TableColumn col_fec_rcv         = new TableColumn("Fecha");        
        TableColumn col_dias_rcv        = new TableColumn("Dias");        
        TableColumn col_stat_rcv        = new TableColumn("Status");        
        TableColumn col_rcv             = new TableColumn("Resp. Civil");        
        col_rcv.getColumns().addAll(col_fec_rcv, col_dias_rcv, col_stat_rcv);

        TableColumn col_fec_ps          = new TableColumn("Fecha");        
        TableColumn col_dias_ps         = new TableColumn("Dias");        
        TableColumn col_stat_ps         = new TableColumn("Status");        
        TableColumn col_ps              = new TableColumn("Perm. Sanitario");        
        col_ps.getColumns().addAll(col_fec_ps, col_dias_ps, col_stat_ps);

        TableColumn col_fec_rgt         = new TableColumn("Fecha");        
        TableColumn col_dias_rgt        = new TableColumn("Dias");        
        TableColumn col_stat_rgt        = new TableColumn("Status");        
        TableColumn col_rgt             = new TableColumn("RGT");        
        col_rgt.getColumns().addAll(col_fec_rgt, col_dias_rgt, col_stat_rgt);
        
        //Se establece el ancho de cada columna
        this.objectWidth(col_status         , 30, 30);
        this.objectWidth(col_nroplaca       , 80, 80);
        this.objectWidth(col_modelo         , 130, 200);
        this.objectWidth(col_capacidad      , 75, 75);
        this.objectWidth(col_tmarca         , 100, 150);
        this.objectWidth(col_tproced        , 90, 150);
        this.objectWidth(col_ttransp        , 110, 150);
        this.objectWidth(col_empresa        , 180, 350);
        this.objectWidth(col_telefonos      , 100, 150);
        this.objectWidth(col_celular        , 100, 150);
        this.objectWidth(col_correo         , 200, 250);
        this.objectWidth(col_fec_rcv        , 75, 75);
        this.objectWidth(col_fec_ps         , 75, 75);
        this.objectWidth(col_fec_rgt        , 75, 75);
        this.objectWidth(col_dias_rcv       , 40, 40);
        this.objectWidth(col_dias_ps        , 40, 40);
        this.objectWidth(col_dias_rgt       , 40, 40);
        this.objectWidth(col_stat_rcv       , 60, 60);
        this.objectWidth(col_stat_ps        , 60, 60);
        this.objectWidth(col_stat_rgt       , 60, 60);
        /**
         * Sobreescritura de un metodo de la Columna, para sustituir el valor numerico 
         * del STATUS del usuario por una Imagen segun el valor
         * 1 - VERDE (HABILITADO)
         * 2 - ROJO  (DESHABILITADO)
         */
        col_status.setCellFactory(new Callback<TableColumn, TableCell>() {
            @Override
            public TableCell call(TableColumn param) {
                return new TableCell<log_Vehiculos, Object>() {
                    @Override
                    public void updateItem(Object item, boolean empty) {
                        super.updateItem(item, empty);
                        if(!empty){
                            switch(item.toString()){  
                                case "0":     //DESHABILITADO
                                    setGraphic(new ImageView(new Image(getClass().getResourceAsStream("/Images/img57.png"), 15, 15, false,false))); 
                                    break;
                                case "1":     //HABILITADO
                                    setGraphic(new ImageView(new Image(getClass().getResourceAsStream("/Images/img61.png"), 15, 15, false,false))); 
                                    break;   
                            }                            
                            setAlignment(Pos.CENTER);
                        }
                        else
                            setGraphic(null);
                    }
                };
            }
        });        

        col_dias_rcv.setCellFactory(new Callback<TableColumn, TableCell>() {
            @Override
            public TableCell call(TableColumn param) {
                return new TableCell<log_Vehiculos, Integer>() {
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
        
        col_dias_ps.setCellFactory(new Callback<TableColumn, TableCell>() {
            @Override
            public TableCell call(TableColumn param) {
                return new TableCell<log_Vehiculos, Integer>() {
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
        
        col_dias_rgt.setCellFactory(new Callback<TableColumn, TableCell>() {
            @Override
            public TableCell call(TableColumn param) {
                return new TableCell<log_Vehiculos, Integer>() {
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
        col_status.setCellValueFactory( 
                new PropertyValueFactory<>("status") );
        col_nroplaca.setCellValueFactory( 
                new PropertyValueFactory<>("idPlaca") );
        col_modelo.setCellValueFactory( 
                new PropertyValueFactory<>("modelo") );
        col_capacidad.setCellValueFactory( 
                new PropertyValueFactory<>("capacidad") );
        col_tmarca.setCellValueFactory( 
                new PropertyValueFactory<>("tmarca") );
        col_tproced.setCellValueFactory( 
                new PropertyValueFactory<>("tproced") );
        col_ttransp.setCellValueFactory( 
                new PropertyValueFactory<>("ttransp") );
        col_empresa.setCellValueFactory( 
                new PropertyValueFactory<>("empresa") );
        col_telefonos.setCellValueFactory( 
                new PropertyValueFactory<>("telefonos") );
        col_celular.setCellValueFactory( 
                new PropertyValueFactory<>("celular") );
        col_correo.setCellValueFactory( 
                new PropertyValueFactory<>("correo") );
        col_fec_rcv.setCellValueFactory( 
                new PropertyValueFactory<>("fec_rcv") );
        col_fec_ps.setCellValueFactory( 
                new PropertyValueFactory<>("fec_ps") );
        col_fec_rgt.setCellValueFactory( 
                new PropertyValueFactory<>("fec_rgt") );
        col_dias_rcv.setCellValueFactory( 
                new PropertyValueFactory<>("dias_rcv") );
        col_dias_ps.setCellValueFactory( 
                new PropertyValueFactory<>("dias_ps") );
        col_dias_rgt.setCellValueFactory( 
                new PropertyValueFactory<>("dias_rgt") );
        col_stat_rcv.setCellValueFactory( 
                new PropertyValueFactory<>("stat_rcv") );
        col_stat_ps.setCellValueFactory( 
                new PropertyValueFactory<>("stat_ps") );
        col_stat_rgt.setCellValueFactory( 
                new PropertyValueFactory<>("stat_rgt") );
        
        //Se Asigna ordenadamente las columnas de la tabla
        tb_table.getColumns().addAll(
                col_status, col_nroplaca, col_modelo, col_capacidad,  
                col_tmarca, col_tproced, col_ttransp, col_empresa, 
                col_telefonos, col_celular, col_correo,
                col_rcv, col_ps, col_rgt
                );                
        
        //Se Asigna tamaño del VBox para que lo tome el TableView
        vb_table.relocate(30, 64);
        vb_table.setPrefWidth(712);
        vb_table.setPrefHeight(508);

        //Se define el comportamiento de las teclas ARRIBA y ABAJO en la tabla
        EventHandler eh = new EventHandler<KeyEvent>(){
            @Override
            public void handle(KeyEvent ke){
                //Si fue presionado la tecla ARRIBA o ABAJO
                if (ke.getCode().equals(KeyCode.UP) || ke.getCode().equals(KeyCode.DOWN)){     
                    //Selecciona la FILA enfocada
                    selectedRow();
                }
            }
        };
        //Se Asigna el comportamiento para que se ejecute cuando se suelta una tecla
        tb_table.setOnKeyReleased(eh);
    }  
    /**
     * Metodo encargado de guardar los datos de un nuevo usuario o de un 
     * usuario modificado
     */
    private boolean saveVehiculo() {
        //Se asigna el valor del tipo de procedimiento que viene de ser ejecutado,
        // 1 si es un NUEVO personal 
        // 2 si es un personal MODIFICADO
        int proceso = tipoOperacion;    
        //Se obtiene el rif y nombre del personal
        String nro_placa = tf_placa.getText();
        String modelo = tf_modelo.getText();
        String capacidad = tf_capacidad.getText();
        //Si el nombre de usuario no esta en blanco
        if((nro_placa != null && !nro_placa.equals("")) &&
           (modelo != null && !modelo.equals(""))  &&
           (capacidad != null && !capacidad.equals(""))){
            //Ejecuta los procesos predeterminados para el guardado del personal
            setCurrentOperation();
            //Se asignan los valores del objeto 
            log_Vehiculos log_vehiculos = new log_Vehiculos();
            log_vehiculos.setIdPlaca(tf_placa.getText());
            log_vehiculos.setModelo(tf_modelo.getText());
            log_vehiculos.setCapacidad(Integer.parseInt(tf_capacidad.getText()));
            log_vehiculos.setEmpresa(tf_empresa.getText());

            log_vehiculos.setRif_empresa(tf_rif.getText());
            log_vehiculos.setAno(Integer.parseInt(tf_ano.getText()));
            log_vehiculos.setCelular(tf_celular.getText());
            log_vehiculos.setCorreo(tf_correo.getText());
            log_vehiculos.setRuta_cc(tf_cc.getText());
            log_vehiculos.setRuta_tt(tf_tt.getText());
            log_vehiculos.setRuta_rcv(tf_rcv.getText());
            log_vehiculos.setId_tseguro(Integer.parseInt(tf_seguro.getText()));
            log_vehiculos.setRuta_ps(tf_ps.getText());
            log_vehiculos.setRuta_rgt(tf_rgt.getText());
            if(dp_rcv.getValue() != null)
                log_vehiculos.setFec_rcv(Date.valueOf(dp_rcv.getValue()));
            if(dp_ps.getValue() != null)
                log_vehiculos.setFec_ps(Date.valueOf(dp_ps.getValue()));
            if(dp_rgt.getValue() != null)
                log_vehiculos.setFec_rgt(Date.valueOf(dp_rgt.getValue()));
            log_vehiculos.setNro_rgt(tf_nrorgt.getText());
            log_vehiculos.setStatus(Datos.getLog_vehiculos().getStatus());      //Se asigna el STATUS del personal

            switch(rb_clasif.getSelectedToggle().getUserData().toString()){
                case "peq":
                    log_vehiculos.setClasif(1);
                    break;
                case "gra":
                    log_vehiculos.setClasif(2);
                    break;
                case "gan":
                    log_vehiculos.setClasif(3);
                    break;
            }
            
            //Se obtiene el log_tmarca
            log_TMarca log_tmarca = (log_TMarca) cb_marca.getValue();            
            if(log_tmarca == null){             //Si no existe un GroupSupplier seleccionado
                log_vehiculos.setTmarca(null);   //Se establece la ScreenNameiable como NULA
            }else{  
                log_vehiculos.setTmarca(log_tmarca);
            }            

            //Se obtiene el log_tproced
            log_TProced log_tproced = (log_TProced) cb_proced.getValue();            
            if(log_tproced == null){             //Si no existe un GroupSupplier seleccionado
                log_vehiculos.setTproced(null);   //Se establece la ScreenNameiable como NULA
            }else{  
                log_vehiculos.setTproced(log_tproced);
            }            

            //Se obtiene el log_ttransp 
            log_TTransp log_ttransp = (log_TTransp) cb_ttrans.getValue();            
            if(log_ttransp == null){             //Si no existe un Estado seleccionado
                log_vehiculos.setTtransp(null);   //Se establece la ScreenNameiable como NULA
            }else{  
                log_vehiculos.setTtransp(log_ttransp);
            }            
            
            //Se llama al proceso de Guardado
            boolean result = 
                    Ln.getInstance().save_log_Vehiculos(log_vehiculos, proceso, ScreenName);
            //Si el Resultado es correcto
            if(result){
                //Se Notifica al usuario
                Gui.getInstance().showMessage("El " + ScreenName + " se ha Guardado Correctamente!", "I");
                loadVehiculo();            //Se Recarga la tabla de usuarios existentes
                return true;
            }     
        }else{                            
            Gui.getInstance().showMessage("No Existe ningun " + ScreenName + " para ser Guardado!", "A");
        }
        return false;
    }
    /**
     * Procedimiento encargado de refrescar el formulario de la pantalla,
     * establece nuevos valores a cada campo de Texto
     */
    private void refreshForm(){       
        tf_placa.setText(Datos.getLog_vehiculos().getIdPlaca());
        tf_modelo.setText(Datos.getLog_vehiculos().getModelo());
        tf_capacidad.setText(Integer.toString(Datos.getLog_vehiculos().getCapacidad()));
        tf_empresa.setText(Datos.getLog_vehiculos().getEmpresa());
        tf_rif.setText(Datos.getLog_vehiculos().getRif_empresa());
        tf_ano.setText(Integer.toString(Datos.getLog_vehiculos().getAno()));
        tf_celular.setText(Datos.getLog_vehiculos().getCelular());
        tf_correo.setText(Datos.getLog_vehiculos().getCorreo());
        cb_marca.setValue(Datos.getLog_vehiculos().getTmarca());
        cb_proced.setValue(Datos.getLog_vehiculos().getTproced());
        cb_ttrans.setValue(Datos.getLog_vehiculos().getTtransp());
        tf_cc.setText(Datos.getLog_vehiculos().getRuta_cc());
        tf_tt.setText(Datos.getLog_vehiculos().getRuta_tt());
        tf_rcv.setText(Datos.getLog_vehiculos().getRuta_rcv());
        tf_ps.setText(Datos.getLog_vehiculos().getRuta_ps());
        tf_rgt.setText(Datos.getLog_vehiculos().getRuta_rgt());
        tf_nrorgt.setText(Datos.getLog_vehiculos().getNro_rgt());

        switch (Datos.getLog_vehiculos().getClasif()){
            case 0:
                rb_clasif1.setSelected(false);
                rb_clasif2.setSelected(false);
                rb_clasif3.setSelected(false);
                break;
            case 1:
                rb_clasif1.setSelected(true);
                break;
            case 2:
                rb_clasif2.setSelected(true);
                break;
            case 3:
                rb_clasif3.setSelected(true);
                break;
        }
            
        if(Datos.getLog_vehiculos().getFec_rcv() != null)
            dp_rcv.setValue(Datos.getLog_vehiculos().getFec_rcv().toLocalDate());
        else
            dp_rcv.setValue(null);
        lb_rcv.setText(Integer.toString(Datos.getLog_vehiculos().getDias_rcv()) + " D");
        changeIconDate("vencido", 0, im_rcv);          
        if (Datos.getLog_vehiculos().getStat_rcv()!= null) 
            changeIconDate(Datos.getLog_vehiculos().getStat_rcv(), Datos.getLog_vehiculos().getDias_rcv(), im_rcv);

        tf_seguro.setText(String.valueOf(Datos.getLog_vehiculos().getId_tseguro()));
        Tooltip tip_tool = new Tooltip();
        if(Datos.getLog_vehiculos().getTseguro() == null){
            tip_tool.setText("");
        }
        else{
            tip_tool.setText(Datos.getLog_vehiculos().getTseguro());
        }
        tf_seguro.setTooltip(tip_tool);
        
        if(Datos.getLog_vehiculos().getFec_ps() != null)
            dp_ps.setValue(Datos.getLog_vehiculos().getFec_ps().toLocalDate());
        else
            dp_ps.setValue(null);
        lb_ps.setText(Integer.toString(Datos.getLog_vehiculos().getDias_ps()) + " D");
        changeIconDate("vencido", 0, im_ps);          
        if (Datos.getLog_vehiculos().getStat_ps()!= null) 
            changeIconDate(Datos.getLog_vehiculos().getStat_ps(), Datos.getLog_vehiculos().getDias_ps(), im_ps);          

        if(Datos.getLog_vehiculos().getFec_rgt() != null)
            dp_rgt.setValue(Datos.getLog_vehiculos().getFec_rgt().toLocalDate());
        else
            dp_rgt.setValue(null);
        lb_rgt.setText(Integer.toString(Datos.getLog_vehiculos().getDias_rgt()) + " D");
        changeIconDate("vencido", 0, im_rgt);          
        if (Datos.getLog_vehiculos().getStat_rgt()!= null) 
            changeIconDate(Datos.getLog_vehiculos().getStat_rgt(), Datos.getLog_vehiculos().getDias_rgt(), im_rgt);
        
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
        hb_7.setVisible(false);          //Se oculta el NODO que contiene el link de ocultar formulario
        loadToolBar();                   //Se Refresca la barra de Herramientas
        lb_Title.setText("");            //Se deja en blanco la etiqueta del Titulo
        //Se evalua el tipo de Operacion
        switch(tipoOperacion){
            case 0:  //SOLO LECTURA                    
                tf_placa.setEditable(false);
                tf_modelo.setEditable(false);
                tf_capacidad.setEditable(false);
                tf_empresa.setEditable(false);
                tf_rif.setEditable(false);
                tf_ano.setEditable(false);
                tf_celular.setEditable(false);
                tf_correo.setEditable(false);
                tf_cc.setEditable(false);
                tf_tt.setEditable(false);
                tf_rcv.setEditable(false);
                tf_ps.setEditable(false);
                tf_rgt.setEditable(false);
                tf_nrorgt.setEditable(false);

                dp_rcv.setDisable(true);
                dp_ps.setDisable(true);
                dp_rgt.setDisable(true);

                lb_rcv.setVisible(true);
                lb_ps.setVisible(true);
                lb_rgt.setVisible(true);

                im_rcv.setVisible(true);
                im_ps.setVisible(true);
                im_rgt.setVisible(true);

                im_check.setVisible(false);
                im_val.setVisible(false);

                //SE PERMITE: NUEVO, CANCELAR Y BUSCAR
                disables = new Integer[]{2,6,7,8,9,10};
                disableAllToolBar(disables); 
                hb_7.setVisible(true);
                break;
            case 1:  //NUEVO
//                lb_Title.setText(Tools.verticalText("NUEVO"));
                lb_Title.setText("NUEVO");
                tf_placa.setEditable(true);
                tf_modelo.setEditable(true);
                tf_capacidad.setEditable(true);
                tf_empresa.setEditable(true);
                tf_rif.setEditable(true);
                tf_ano.setEditable(true);
                tf_celular.setEditable(true);
                tf_correo.setEditable(true);
                tf_cc.setEditable(true);
                tf_tt.setEditable(true);
                tf_rcv.setEditable(true);
                tf_ps.setEditable(true);
                tf_rgt.setEditable(true);
                tf_nrorgt.setEditable(true);

                dp_rcv.setDisable(false);
                dp_ps.setDisable(false);
                dp_rgt.setDisable(false);

//                lb_rcv.setVisible(false);
//                lb_ps.setVisible(false);
//                lb_rgt.setVisible(false);
//
//                im_rcv.setVisible(false);
//                im_ps.setVisible(false);
//                im_rgt.setVisible(false);

                im_check.setVisible(true);
                im_val.setVisible(false);

                //SE PERMITE: NUEVO,GUARDAR Y CANCELAR             
                disables = new Integer[]{0,1,3,4,6,7,8,9,10,11};
                disableAllToolBar(disables);                            
                break;
            case 2:  //EDITAR
//                lb_Title.setText(Tools.verticalText("EDITAR"));
                lb_Title.setText("EDITAR");
                tf_placa.setEditable(false);
                tf_modelo.setEditable(true);
                tf_capacidad.setEditable(true);
                tf_empresa.setEditable(true);
                tf_rif.setEditable(true);
                tf_ano.setEditable(true);
                tf_celular.setEditable(true);
                tf_correo.setEditable(true);
                tf_cc.setEditable(true);
                tf_tt.setEditable(true);
                tf_rcv.setEditable(true);
                tf_ps.setEditable(true);
                tf_rgt.setEditable(true);
                tf_nrorgt.setEditable(true);

                dp_rcv.setDisable(false);
                dp_ps.setDisable(false);
                dp_rgt.setDisable(false);

//                lb_rcv.setVisible(false);
//                lb_ps.setVisible(false);
//                lb_rgt.setVisible(false);

                im_check.setVisible(true);
                im_val.setVisible(false);

                //SE PERMITE: EDITAR,GUARDAR Y CANCELAR
                disables = new Integer[]{0,1,3,4,6,7,8,9,10,11};
                disableAllToolBar(disables);            
                break;
            case 3:  //GUARDAR
                tf_placa.setEditable(false);
                tf_modelo.setEditable(false);
                tf_capacidad.setEditable(false);
                tf_empresa.setEditable(false);
                tf_rif.setEditable(false);
                tf_ano.setEditable(false);
                tf_celular.setEditable(false);
                tf_correo.setEditable(false);
                tf_cc.setEditable(false);
                tf_tt.setEditable(false);
                tf_rcv.setEditable(false);
                tf_ps.setEditable(false);
                tf_rgt.setEditable(false);
                tf_nrorgt.setEditable(false);

                bt_cc.setDisable(true);
                bt_tt.setDisable(true);
                bt_rcv.setDisable(true);
                bt_ps.setDisable(true);
                bt_rgt.setDisable(true);
                
                dp_rcv.setDisable(true);
                dp_ps.setDisable(true);
                dp_rgt.setDisable(true);

                im_check.setVisible(false);
                im_val.setVisible(false);

                //SE PERMITE: GUARDAR Y CANCELAR
                disables = new Integer[]{0,1,3,4,6,7,8,9,10,11};
                disableAllToolBar(disables);   
                break;
            case 4:  //CAMBIAR STATUS 
                tf_placa.setEditable(false);
                tf_modelo.setEditable(false);
                tf_capacidad.setEditable(false);
                tf_empresa.setEditable(false);
                tf_rif.setEditable(false);
                tf_ano.setEditable(false);
                tf_celular.setEditable(false);
                tf_correo.setEditable(false);
                tf_cc.setEditable(false);
                tf_tt.setEditable(false);
                tf_rcv.setEditable(false);
                tf_ps.setEditable(false);
                tf_rgt.setEditable(false);
                tf_nrorgt.setEditable(false);

                dp_rcv.setDisable(true);
                dp_ps.setDisable(true);
                dp_rgt.setDisable(true);

                im_check.setVisible(false);
                im_val.setVisible(false);

                //SE PERMITE: GUARDAR,CAMBIO STATUS Y CANCELAR
                disables = new Integer[]{0,1,2,4,6,7,8,9,10,11};
                disableAllToolBar(disables); 
                break;
        }        
        hb_2.setVisible(isNamesVisible);
        init_FocusArray(tipoOperacion);       
        Gui.getInstance().setTipoOperacion(tipoOperacion);
    }    
    /**
     * Procedimiento que busca en BD la lista de usuarios
     * y los envia a cargar en la tabla
     */
    private void loadVehiculo(){        
        Datos.setRep_log_vehiculo(Ln.getInstance().load_log_Vehiculos());
        loadTable(Datos.getRep_log_vehiculo());    
    }
    /**
     * Procedimiento de llenado de datos en la tabla de datos
     */
    private void loadTable(log_Vehiculos[] log_vehiculos){    
        if(log_vehiculos != null){
            ObservableList<log_Vehiculos> data = FXCollections.observableArrayList();        
            data.addAll(Arrays.asList(log_vehiculos));   
            tb_table.setItems(data);        
        }
    } 
    /**
     * Metodo que selecciona y llena el formulario con los datos del usuario 
     * seleccionado en la tabla
     */
    private void selectedRow(){
        tipoOperacion = 0;      //SOLO LECTURA
        //Selecciona el usuario enfocado
        log_Vehiculos log_vehiculos = tb_table.getSelectionModel().getSelectedItem();          
        if(log_vehiculos != null){
            Datos.setLog_vehiculos(log_vehiculos);          //Asigno el Usuario a la Clase de Datos Globales
            change_im_tool4(log_vehiculos.getStatus());  //Se define el valor del Boton de Cambio se Status
            refreshForm();                      //Refresca el Formulario
            setFormVisible(true);               //Coloca Visible el formulario
        }
    }

    /**
     * Procedimiento que obtiene los Distintos Sexo de la BD
     * y los carga en el COMBOBOX
     */
    private void loadBrands(){        
        log_TMarca[] log_tmarca = Ln.getInstance().load_log_TMarca();        
        final ObservableList<log_TMarca> data = FXCollections.observableArrayList();
        data.addAll(Arrays.asList(log_tmarca));          
        cb_marca.setItems(data); 
//        CbTMarcaKeyHandler cbkh = new CbTMarcaKeyHandler(data);
//        cb_marca.setOnKeyReleased(cbkh);
        Datos.setCbMarca(cb_marca);                       
        new SelectKeyComboBoxListener(cb_marca); 
    }  
    /**
     * Procedimiento que obtiene los Distintos Sexo de la BD
     * y los carga en el COMBOBOX
     */
    private void loadTProced(){        
        log_TProced[] log_tproced = Ln.getInstance().load_log_TProced();        
        final ObservableList<log_TProced> data = FXCollections.observableArrayList();
        data.addAll(Arrays.asList(log_tproced));          
        cb_proced.setItems(data); 
//        CbTProcedKeyHandler cbkh = new CbTProcedKeyHandler(data);
//        cb_proced.setOnKeyReleased(cbkh);
        Datos.setCbProced(cb_proced);                       
        new SelectKeyComboBoxListener(cb_proced); 
    }  
    /**
     * Procedimiento que obtiene los Distintos Estados de la BD
     * y los carga en el COMBOBOX
     * param: nombre del pais
     */
    private void loadTTransp(){ 
        log_TTransp[] log_ttransp = Ln.getInstance().load_log_TTransp();        
        final ObservableList<log_TTransp> data = FXCollections.observableArrayList();
        data.addAll(Arrays.asList(log_ttransp));          
        cb_ttrans.setItems(data); 
//        CbTTranspKeyHandler cbkh = new CbTTranspKeyHandler(data);
//        cb_ttrans.setOnKeyReleased(cbkh);
        Datos.setCbTTransp(cb_ttrans);                       
        new SelectKeyComboBoxListener(cb_ttrans); 
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
                    tf_placa,cb_marca,tf_modelo,tf_capacidad,tf_ano,tf_empresa,tf_rif,
                    tf_celular,tf_correo,cb_ttrans,cb_proced,tf_cc,bt_cc,tf_tt,bt_tt,
                    tf_rcv,bt_rcv,dp_rcv,tf_ps,bt_ps,dp_ps,tf_rgt,bt_rgt,dp_rgt,tf_nrorgt};
                break;
            case 1:     //NUEVO
                nodos = new Node[]{
                    tf_placa,im_check,cb_marca,tf_modelo,tf_capacidad,tf_ano,tf_empresa,tf_rif,
                    tf_celular,tf_correo,cb_ttrans,cb_proced,tf_cc,bt_cc,tf_tt,bt_tt,
                    tf_rcv,bt_rcv,dp_rcv,tf_ps,bt_ps,dp_ps,tf_rgt,bt_rgt,dp_rgt,tf_nrorgt};
                break;
            case 2:     //EDITAR
                nodos = new Node[]{
                    tf_placa,im_check,cb_marca,tf_modelo,tf_capacidad,tf_ano,tf_empresa,tf_rif,
                    tf_celular,tf_correo,cb_ttrans,cb_proced,tf_cc,bt_cc,tf_tt,bt_tt,
                    tf_rcv,bt_rcv,dp_rcv,tf_ps,bt_ps,dp_ps,tf_rgt,bt_rgt,dp_rgt,tf_nrorgt};
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
           botonGuardar();  //Guardar los datos
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
        tools = new ImageView[]{im_tool1,im_tool2,im_tool3,im_tool4,im_tool6,im_tool7,im_tool8,im_tool5,im_tool9,im_tool10,im_tool11,im_tool12};        
        //CARGA DE LA BD LA CONFIGURACION DE USUARIO PARA LA PANTALLA
        toolsConfig = Ln.getInstance().loadToolBar();                        
        // arreglo con cada etiqueta, ordenado por boton
        tooltips = new String[]{
            "Nuevo " + ScreenName + " ",
            "Editar " + ScreenName + " ",
            "Guardar " + ScreenName + " ",
            "Cambiar Status " + ScreenName + " ",
            "Imprimir " + ScreenName + " ",
            "Cancelar ",
            "Sin Asignar " + ScreenName + " ",
            "Sin Asignar",
            "Sin Asignar",
            "Sin Asignar",
            "Sin Asignar",
            "Buscar " + ScreenName + " "
            };
        //se asigna la etiqueta a su respectivo boton
        for (int i = 0; i < tools.length; i++) {            
            Tooltip tip_tool = new Tooltip(tooltips[i]);
            Tooltip.install(tools[i], tip_tool);
        }

        im_tool5.setVisible(false);
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
                        try{
                            Datos.setRep_log_vehiculo(Ln.getInstance().find_log_Vehiculos(tf_buscar.getText()));
                            loadTable(Datos.getRep_log_vehiculo());     
                        } catch(Exception e){
                            Gui.getInstance().showMessage("El Nro. de Placa del " + ScreenName + " NO existe!", "A");
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

        dp_ps.setValue(null);
        dp_rcv.setValue(null);
        dp_rgt.setValue(null);
        
        loadToolBar();
        //SE LIMPIA EL FORMULARIO
        tf_buscar.setText("");
        tf_buscar.setVisible(false);
        Datos.setLog_vehiculos(new log_Vehiculos());                           
        refreshForm();                      
        Datos.setLog_vehiculos(null);             //RESET DE LA VARIABLE
        setFormVisible(false);               //OCULTA EL FORMULARIO
        //RECARGA LA TABLA ORIGINAL
        loadVehiculo();
    }
    /**
     * 
     */
    private void botonNuevo(){
        if(toolsConfig[2]==1){
            tipoOperacion = 1;
            change_im_check(false);
            loadVehiculo();
            Datos.setLog_vehiculos(new log_Vehiculos());
            refreshForm();
            setFormVisible(true);
            Gui.getFields()[Gui.getFieldFocused()].requestFocus();
        }
    }
    /**
     * 
     */
    private void botonEditar(){
        if(Datos.getLog_vehiculos()!= null && toolsConfig[3]==1){
            tipoOperacion = 2;
            change_im_tool4(Datos.getLog_vehiculos().getStatus());
            refreshForm();
            setFormVisible(true);     
            Gui.getFields()[Gui.getFieldFocused()].requestFocus();
        }
    }
    /**
     * 
     */
    private void botonGuardar(){        
        if(Datos.getLog_vehiculos()!= null && toolsConfig[4]==1){
            boolean result = saveVehiculo();
            if (result)
                botonInicio();
        }
    }
    /**
     * 
     */
    private void botonEliminar() {
        if(Datos.getLog_vehiculos()!= null && toolsConfig[5]==1){
            tipoOperacion = 4;      //OPERACION DE BORRADO
            change_im_check(true);       //SE CAMBIA EL ICONO DE VERIFICACION DEL VEHICULO                   
            refreshForm();         
            setFormVisible(true);  
            String verbo = "desactivar";
            if(Datos.getLog_vehiculos().getStatus() == 1){
                verbo = "activar";
            }
            String mensj = 
                "¿Seguro que desea " + verbo + " el " + ScreenName + " " + Datos.getLog_vehiculos().getIdPlaca() + " ?";
            Gui.getInstance().showConfirmar(mensj);  
        }
    }
    /**
     * 
     */
    private void botonBuscar(){
        if(toolsConfig[13]==1){
            tipoOperacion = 0;                  //OPERACION SOLO LECTURA
            //SE LIMPIA EL FORMULARIO
            tf_buscar.setVisible(true);
            Datos.setLog_vehiculos(new log_Vehiculos());                           
            refreshForm();                      
            Datos.setLog_vehiculos(null);             //RESET DE LA VARIABLE
            setFormVisible(false);              //OCULTA EL FORMULARIO     
            tf_buscar.requestFocus();
        }
    }
    /**
     * 
     */
    private void botonOcultar(){
        tipoOperacion = 0;                  //OPERACION SOLO LECTURA
        //SE LIMPIA EL FORMULARIO
        tf_buscar.setVisible(false);
        Datos.setLog_vehiculos(new log_Vehiculos());                           
        refreshForm();                      
        Datos.setLog_vehiculos(new log_Vehiculos());    //RESET DE LA VARIABLE
        setFormVisible(false);              //OCULTA EL FORMULARIO
    }
    /**
     * 
     */
    private void botonImprimir(){
        tipoOperacion = 5;                  //OPERACION SOLO LECTURA

        JasperReport jReport = null;
        JasperViewer jview = null;
        JasperPrint jPrint = null;

        //Datos
        ObservableList<log_Vehiculos> data = FXCollections.observableArrayList();
        data.addAll(Arrays.asList(Ln.getInstance().print_log_Vehiculos("", "")));   
        JRBeanCollectionDataSource JRDs = new JRBeanCollectionDataSource(data, true);
        
        //Parametros
        JrxmlParam.put("p_user", Datos.getSesion().getUsername());
        JrxmlParam.put("p_subtitulo", "");

        try{
            jReport = (JasperReport) JRLoader.loadObjectFromFile(path + path_rep + "/logistica/log_veh_port_vehi.jasper");
            jPrint = JasperFillManager.fillReport(jReport, JrxmlParam, JRDs);
            jview = new JasperViewer(jPrint, false);
            jview.setTitle("DIGA - Listado de Vehiculo (Logistica) ");

        } catch (JRException ee){
            Gui.getInstance().showMessage("Error Cargando Reporte: \n" + ee.getMessage(), "E");
        }

        jview.setVisible(true);
        jview.setResizable(false);
    }    
    /**
     * Procedimiento que define los comportamientos en diversos Eventos 
     * de cada boton en la pantalla actual.
     */
    private void init_buttons(){

        rb_clasif1.setToggleGroup(rb_clasif);
        rb_clasif1.setUserData("peq");

        rb_clasif2.setToggleGroup(rb_clasif);
        rb_clasif2.setUserData("gra");

        rb_clasif3.setToggleGroup(rb_clasif);
        rb_clasif3.setUserData("gan");
        
        /**
         * LINK PARA OCULTAR FORMULARIO
         */
        lb_ocultar.setOnMouseClicked((MouseEvent mouseEvent) -> {
            if(mouseEvent.getButton().equals(MouseButton.PRIMARY)){
                if(mouseEvent.getClickCount() > 0){                        
                    botonOcultar();
                    
                }
            }
        });
        /**
         * SELECCION EN LA TABLA
         */
        tb_table.setOnMouseClicked((MouseEvent mouseEvent) -> {
            if(mouseEvent.getButton().equals(MouseButton.PRIMARY)){
                if(mouseEvent.getClickCount() < 2){
                    selectedRow();
                }
            }
        });        
        /**
         * BOTON NUEVO
         */
        im_tool1.setOnMouseClicked((MouseEvent mouseEvent) -> {
            if(mouseEvent.getButton().equals(MouseButton.PRIMARY)){
                if(mouseEvent.getClickCount() > 0){
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
         * BOTON CAMBIO CLAVE
         */
        im_tool5.setOnMouseClicked((MouseEvent mouseEvent) -> {
            if(mouseEvent.getButton().equals(MouseButton.PRIMARY)){
                if(mouseEvent.getClickCount() > 0){   
//                        botonUpdPswd();
                }
            }
        });
        /**
         * BOTON IMPRIMIR
         */
        im_tool6.setOnMouseClicked((MouseEvent mouseEvent) -> {
            if(mouseEvent.getButton().equals(MouseButton.PRIMARY)){
                if(mouseEvent.getClickCount() > 0){
                    botonImprimir();
                }
            }
        });
        /**
         * BOTON REGRESAR
         */
        im_tool7.setOnMouseClicked((MouseEvent mouseEvent) -> {
            if(mouseEvent.getButton().equals(MouseButton.PRIMARY)){
                if(mouseEvent.getClickCount() > 0){
                    botonInicio();
                }
            }
        });
        /**
         * BOTON POR ASIGNAR
         */
        im_tool8.setOnMouseClicked((MouseEvent mouseEvent) -> {
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
                if(mouseEvent.getClickCount() > 0){
                    botonBuscar();
                }
            }
        });
        /**
         * BOTON CHECK - Es utilizado para generar un nombre de usuario correcto, 
         * basado en los nombres y apellidos de la persona.
         */
        im_check.setOnMouseClicked((MouseEvent mouseEvent) -> {
            if(mouseEvent.getButton().equals(MouseButton.PRIMARY)){
                if((mouseEvent.getClickCount() < 2) && (tipoOperacion != 0)){
                    boolean boo = Ln.getInstance().check_log_Personal(tf_placa.getText());
                    if(boo){
                        Gui.getInstance().showMessage("Ya existe el " + ScreenName + "!", "E");
                        botonInicio();
                    }
                }        
            }
        });                
        /**
         * metodo para mostrar buscar el nro de placa
         * param: ENTER O TAB
         */
        tf_placa.setOnKeyReleased((KeyEvent ke) -> {
            if (ke.getCode().equals(KeyCode.ENTER) || ke.getCode().equals(KeyCode.TAB)){
                //Valida que el evento se haya generado en el campo de busqueda
                if(((Node)ke.getSource()).getId().equals("tf_placa")){
                    //Solicita los datos y envia la Respuesta a imprimirse en la Pantalla
                    boolean boo = Ln.getInstance().check_log_Vehiculos(tf_placa.getText());
                    if(boo){
                        Gui.getInstance().showMessage("Ya existe el " + ScreenName + "!", "E");
                        botonInicio();
                    }
                }
            }
        });
        /**
         * metodo para mostrar la clasificacion del vehiculo por su capacidad
         * param: ENTER O TAB
         */
        tf_capacidad.setOnKeyReleased((KeyEvent ke) -> {
            if (ke.getCode().equals(KeyCode.ENTER) || ke.getCode().equals(KeyCode.TAB)){
                //Valida que el evento se haya generado en el campo de busqueda
                if(((Node)ke.getSource()).getId().equals("tf_capacidad")){
                    if ((Integer.parseInt(tf_capacidad.getText()) > 500) &&
                        (Integer.parseInt(tf_capacidad.getText()) < 6001))
                            rb_clasif1.setSelected(true);
                            
                    if ((Integer.parseInt(tf_capacidad.getText()) > 6000) &&
                        (Integer.parseInt(tf_capacidad.getText()) < 15000))
                            rb_clasif2.setSelected(true);

                    if ((Integer.parseInt(tf_capacidad.getText()) > 15001) &&
                        (Integer.parseInt(tf_capacidad.getText()) < 60000))
                            rb_clasif3.setSelected(true);
                }
            }
        });
        /**
         * BOTON CC
         */
        bt_cc.setOnAction((ActionEvent event) -> {
            FileChooser fileChooser = new FileChooser();
            if (tipoOperacion == 0){
                if(tf_cc.getText() != null){
                    file = new File(tf_cc.getText());
                    if (file != null) {  
                        new Thread(new Runnable() {  
                            @Override  
                            public void run() {  
                                try {  
                                    Desktop.getDesktop().open(file);  
                                } catch (IOException e) {  
                                    // TODO Auto-generated catch block  
                                    e.printStackTrace();  
                                }  
                            }  
                        }).start();  
                    }  
                }
                else{
                    Gui.getInstance().showMessage("No hay archivo/imagen disponible", "A");
                }
            }
            else{
                //Set extension filter
                FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("image files (*.jpg) (*.png)", "*.jpg", "*.png");
                fileChooser.getExtensionFilters().add(extFilter);

                fileChooser.setInitialDirectory(new File(path + path_dat + "/logistica/vehiculos/"));

                //Show open file dialog
                file = fileChooser.showOpenDialog(null);
                if (file != null)
                    tf_cc.setText(file.getPath());
            }
        });
        /**
         * BOTON TT
         */
        bt_tt.setOnAction((ActionEvent event) -> {
            FileChooser fileChooser = new FileChooser();
            if (tipoOperacion == 0){
                if(tf_tt.getText() != null){
                    file = new File(tf_tt.getText());
                    if (file != null) {  
                        new Thread(new Runnable() {  
                            @Override  
                            public void run() {  
                                try {  
                                    Desktop.getDesktop().open(file);  
                                } catch (IOException e) {  
                                    // TODO Auto-generated catch block  
                                    e.printStackTrace();  
                                }  
                            }  
                        }).start();  
                    }  
                }
                else{
                    Gui.getInstance().showMessage("No hay archivo/imagen disponible", "A");
                }
            }
            else{
                //Set extension filter
                FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("pdf files (*.pdf)", "*.pdf");
                fileChooser.getExtensionFilters().add(extFilter);

                fileChooser.setInitialDirectory(new File(path + path_dat + "/logistica/vehiculos/"));

                //Show open file dialog
                file = fileChooser.showOpenDialog(null);
                if (file != null)
                    tf_tt.setText(file.getPath());
            }
        });
        /**
         * BOTON RCV
         */
        bt_rcv.setOnAction((ActionEvent event) -> {
            FileChooser fileChooser = new FileChooser();
            if (tipoOperacion == 0){
                if(tf_rcv.getText() != null){
                    file = new File(tf_rcv.getText());
                    if (file != null) {  
                        new Thread(new Runnable() {  
                            @Override  
                            public void run() {  
                                try {  
                                    Desktop.getDesktop().open(file);  
                                } catch (IOException e) {  
                                    // TODO Auto-generated catch block  
                                    e.printStackTrace();  
                                }  
                            }  
                        }).start();  
                    }  
                }
                else{
                    Gui.getInstance().showMessage("No hay archivo/imagen disponible", "A");
                }
            }
            else{
                //Set extension filter
                FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("pdf files (*.pdf)", "*.pdf");
                fileChooser.getExtensionFilters().add(extFilter);

                fileChooser.setInitialDirectory(new File(path + path_dat + "/logistica/vehiculos/"));

                //Show open file dialog
                file = fileChooser.showOpenDialog(null);
                if (file != null)
                    tf_rcv.setText(file.getPath());
            }
        });
        /**
         * Fecha RCV
         */
        dp_rcv.setOnKeyReleased((KeyEvent ke) -> {
            if (ke.getCode().equals(KeyCode.ENTER) || ke.getCode().equals(KeyCode.TAB)){
                //Valida que el evento se haya generado en el campo de busqueda
                if(((Node)ke.getSource()).getId().equals("dp_rcv") &&
                        dp_rcv.getValue() != null){
                    
                    Calendar calendar1 = Calendar.getInstance();
                    Calendar calendar2 = Calendar.getInstance();
                    calendar1.setTime(Date.valueOf(dp_rcv.getValue()));
                    calendar2.setTime(Date.valueOf(LocalDate.now())); 
 
                    long milliseconds1 = calendar1.getTimeInMillis();
                    long milliseconds2 = calendar2.getTimeInMillis();
                    long diff = milliseconds2 - milliseconds1;
                    long diffDays = diff / (24 * 60 * 60 * 1000);
        
                    lb_rcv.setText(String.valueOf(Math.abs(diffDays)) + " D");
                    if(diffDays < 0){
                        changeIconDate("x vencer", (int) Math.abs(diffDays), im_rcv);          
                    }
                    else{
                        changeIconDate("vencido", (int) Math.abs(diffDays), im_rcv);          
                    }
                }
            }
        });
        /**
         * BOTON PRODUCTO
         */
        bt_se.setOnMouseClicked((MouseEvent mouseEvent) -> {
            if(mouseEvent.getButton().equals(MouseButton.PRIMARY)){
                if(mouseEvent.getClickCount() > 0){
                    Datos.setIdButton(2005011);
                    Gui.getInstance().showBusqueda("Empresa de Seguro");  
                }
            }
        });
        /**
         * BOTON PS
         */
        bt_ps.setOnAction((ActionEvent event) -> {
            FileChooser fileChooser = new FileChooser();
            if (tipoOperacion == 0){
                if(tf_ps.getText() != null){
                    file = new File(tf_ps.getText());
                    if (file != null) {  
                        new Thread(new Runnable() {  
                            @Override  
                            public void run() {  
                                try {  
                                    Desktop.getDesktop().open(file);  
                                } catch (IOException e) {  
                                    // TODO Auto-generated catch block  
                                    e.printStackTrace();  
                                }  
                            }  
                        }).start();  
                    }  
                }
                else{
                    Gui.getInstance().showMessage("No hay archivo/imagen disponible", "A");
                }
            }
            else{
                //Set extension filter
                FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("pdf files (*.pdf)", "*.pdf");
                fileChooser.getExtensionFilters().add(extFilter);

                fileChooser.setInitialDirectory(new File(path + path_dat + "/logistica/vehiculos/"));

                //Show open file dialog
                file = fileChooser.showOpenDialog(null);
                if (file != null)
                    tf_ps.setText(file.getPath());
            }
        });
        /**
         * Fecha PS
         */
        dp_ps.setOnKeyReleased((KeyEvent ke) -> {
            if (ke.getCode().equals(KeyCode.ENTER) || ke.getCode().equals(KeyCode.TAB)){
                //Valida que el evento se haya generado en el campo de busqueda
                if(((Node)ke.getSource()).getId().equals("dp_ps") &&
                        dp_ps.getValue() != null){
                    
                    Calendar calendar1 = Calendar.getInstance();
                    Calendar calendar2 = Calendar.getInstance();
                    calendar1.setTime(Date.valueOf(dp_ps.getValue()));
                    calendar2.setTime(Date.valueOf(LocalDate.now())); 
 
                    long milliseconds1 = calendar1.getTimeInMillis();
                    long milliseconds2 = calendar2.getTimeInMillis();
                    long diff = milliseconds2 - milliseconds1;
                    long diffDays = diff / (24 * 60 * 60 * 1000);
        
                    lb_ps.setText(String.valueOf(Math.abs(diffDays)) + " D");
                    if(diffDays < 0){
                        changeIconDate("x vencer", (int) Math.abs(diffDays), im_ps);
                    }
                    else{
                        changeIconDate("vencido", (int) Math.abs(diffDays), im_ps);
                    }
                }
            }
        });
        /**
         * BOTON RGT
         */
        bt_rgt.setOnAction((ActionEvent event) -> {
            FileChooser fileChooser = new FileChooser();
            if (tipoOperacion == 0){
                if(tf_rgt.getText() != null){
                    file = new File(tf_rgt.getText());
                    if (file != null) {  
                        new Thread(new Runnable() {  
                            @Override  
                            public void run() {  
                                try {  
                                    Desktop.getDesktop().open(file);  
                                } catch (IOException e) {  
                                    // TODO Auto-generated catch block  
                                    e.printStackTrace();  
                                }  
                            }  
                        }).start();  
                    }  
                }
                else{
                    Gui.getInstance().showMessage("No hay archivo/imagen disponible", "A");
                }
            }
            else{
                //Set extension filter
                FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("image files (*.jpg) (*.png)", "*.jpg", "*.png");
                fileChooser.getExtensionFilters().add(extFilter);

                fileChooser.setInitialDirectory(new File(path + path_dat + "/logistica/vehiculos/"));

                //Show open file dialog
                file = fileChooser.showOpenDialog(null);
                if (file != null)
                    tf_rgt.setText(file.getPath());
            }
        });
        /**
         * Fecha RGT
         */
        dp_rgt.setOnKeyReleased((KeyEvent ke) -> {
            if (ke.getCode().equals(KeyCode.ENTER) || ke.getCode().equals(KeyCode.TAB)){
                //Valida que el evento se haya generado en el campo de busqueda
                if(((Node)ke.getSource()).getId().equals("dp_rgt") &&
                        dp_rgt.getValue() != null){
                    
                    Calendar calendar1 = Calendar.getInstance();
                    Calendar calendar2 = Calendar.getInstance();
                    calendar1.setTime(Date.valueOf(dp_rgt.getValue()));
                    calendar2.setTime(Date.valueOf(LocalDate.now())); 
 
                    long milliseconds1 = calendar1.getTimeInMillis();
                    long milliseconds2 = calendar2.getTimeInMillis();
                    long diff = milliseconds2 - milliseconds1;
                    long diffDays = diff / (24 * 60 * 60 * 1000);
        
                    lb_rgt.setText(String.valueOf(Math.abs(diffDays)) + " D");
                    if(diffDays < 0){
                        changeIconDate("x vencer", (int) Math.abs(diffDays), im_rgt);
                    }
                    else{
                        changeIconDate("vencido", (int) Math.abs(diffDays), im_rgt);
                    }
                }
            }
        });
    }   
    
    /***************************************************************************/
    /********************** METODOS DE INTERFAZ GRAFICA ************************/
    /***************************************************************************/
    
    /**
     * Metodo que permite cambiar la imagen del boton CheckUserSupplier
     * @param boo TRUE si el VEHICULO esta validado
     */
    private void change_im_check(boolean boo){
        if(boo){    //IMAGEN SI EL VEHICULO ES CORRECTO
            im_check.setImage(new Image(getClass().getResourceAsStream("/Images/img06.png")));
        }else{      //IMAGEN PARA LA BUSQUEDA DE UN VEHICULO
            im_check.setImage(new Image(getClass().getResourceAsStream("/Images/img34.png")));
        }
    }
    /**
     * Metodo que permite cambiar la imagen del boton CheckUserSupplier
     * @param boo TRUE si el VEHICULO esta validado
     */
    private void change_im_val(int boo){
        // 200 HTTP_request Ok
        if(boo == 200){    //IMAGEN SI EL VEHICULO ES CORRECTO
            im_val.setImage(new Image(getClass().getResourceAsStream("/Images/img57a.png")));
        }else{      //IMAGEN PARA LA BUSQUEDA DE UN VEHICULO
            im_val.setImage(new Image(getClass().getResourceAsStream("/Images/img61a.png")));
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
     * @param dia si esta <91 alerta al usuario
     * @param ima si esta OBJETO
     */
    private void changeIconDate(String sta, Integer dia, ImageView ima){
        switch (sta){
            case "vencido":
                ima.setImage(new Image(getClass().getResourceAsStream("/Images/img61a.png")));
                break;
            case "x vencer":
                if (dia < 91)
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
        if(value){  //Si el estado es visible entonces 
            vb_table.relocate(30, 375);
            vb_table.setPrefHeight(208);
        }else{
            vb_table.relocate(30, 64);
            vb_table.setPrefHeight(508);
        }
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
    
}
