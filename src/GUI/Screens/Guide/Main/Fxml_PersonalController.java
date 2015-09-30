/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI.Screens.Guide.Main;

import GUI.Gui;
import LN.Ln;
import Listeners.FocusPropertyChangeListener;
import Listeners.SelectKeyComboBoxListener;
import Objects.Setup.City;
import Objects.Setup.Municipality;
import Objects.Setup.Parish;
import Objects.Setup.Sex;
import Objects.Setup.State;
import Objects.log_Personal;
import Objects.log_TPersonal;
import Tools.Datos;
import Tools.ValidateTextFieldNumber;
import Tools.ValidateTextFieldPhone;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.beans.value.ObservableValue;
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
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
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

/**
 *
 * @author MITM
 */
public class Fxml_PersonalController implements Initializable {
    
    @FXML
    private AnchorPane ap_root;

    @FXML
    private Button bt_ci;
    
    @FXML
    private Button bt_lc;
    
    @FXML
    private Button bt_cm;
    
    @FXML
    private Button bt_cs;
    
    @FXML
    private Button bt_ma;
    
    @FXML
    private ComboBox<State> cb_estado;

    @FXML
    private ComboBox<City> cb_localidad;

    @FXML
    private ComboBox<Municipality> cb_municipio;

    @FXML
    private ComboBox<Parish> cb_parroquia;

    @FXML
    private ComboBox<Sex> cb_sexo;

    @FXML
    private ComboBox<log_TPersonal> cb_tpersonal;

    @FXML
    private DatePicker dp_lc;
    
    @FXML
    private DatePicker dp_cm;

    @FXML
    private DatePicker dp_cs;
    
    @FXML
    private DatePicker dp_ma;
    
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
    private ImageView im_lc;

    @FXML
    private ImageView im_cm;

    @FXML
    private ImageView im_cs;

    @FXML
    private ImageView im_ma;

    @FXML
    private Label lb_lc;
    
    @FXML
    private Label lb_cm;

    @FXML
    private Label lb_cs;
    
    @FXML
    private Label lb_ma;

    @FXML 
    private Label lb_Title; 

    @FXML
    private Label lb_ocultar;

    @FXML
    private TableView<log_Personal> tb_table;

    @FXML
    private TextField tf_apellidos;

    @FXML
    private TextField tf_buscar;

    @FXML
    private ValidateTextFieldPhone tf_celular;

    @FXML
    private TextField tf_correo;

    @FXML
    private TextField tf_direccion;

    @FXML
    private TextField tf_nombres;

    @FXML
    private ValidateTextFieldNumber tf_nroci;

    @FXML
    private ValidateTextFieldPhone tf_thab;

    @FXML
    private TextField tf_ci;
    
    @FXML
    private TextField tf_lc;
    
    @FXML
    private TextField tf_cm;
    
    @FXML
    private TextField tf_cs;
    
    @FXML
    private TextField tf_ma;
    
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
    File file;
    
    private static final String ScreenName = "Personal";
    
    /**
     * Initializes the controller class.
     * @param fxmlFileLocation
     * @param resources
     */     
    @Override // This method is called by the FXMLLoader when initialization is complete
    public void initialize(URL fxmlFileLocation, ResourceBundle resources) {
        assert ap_root != null : "fx:id=\"ap_root\" was not injected: check your FXML file 'Fxml_Personal.fxml'.";
        assert bt_ci != null : "fx:id=\"bt_ci\" was not injected: check your FXML file 'Fxml_Personal.fxml'.";
        assert bt_lc != null : "fx:id=\"bt_lc\" was not injected: check your FXML file 'Fxml_Personal.fxml'.";
        assert bt_cm != null : "fx:id=\"bt_cm\" was not injected: check your FXML file 'Fxml_Personal.fxml'.";
        assert bt_cs != null : "fx:id=\"bt_cs\" was not injected: check your FXML file 'Fxml_Personal.fxml'.";
        assert bt_ma != null : "fx:id=\"bt_ma\" was not injected: check your FXML file 'Fxml_Personal.fxml'.";
        assert cb_estado != null : "fx:id=\"cb_estado\" was not injected: check your FXML file 'Fxml_Personal.fxml'.";
        assert cb_localidad != null : "fx:id=\"cb_localidad\" was not injected: check your FXML file 'Fxml_Personal.fxml'.";
        assert cb_municipio != null : "fx:id=\"cb_municipio\" was not injected: check your FXML file 'Fxml_Personal.fxml'.";
        assert cb_parroquia != null : "fx:id=\"cb_parroquia\" was not injected: check your FXML file 'Fxml_Personal.fxml'.";
        assert cb_sexo != null : "fx:id=\"cb_sexo\" was not injected: check your FXML file 'Fxml_Personal.fxml'.";
        assert cb_tpersonal != null : "fx:id=\"cb_tpersonal\" was not injected: check your FXML file 'Fxml_Personal.fxml'.";
        assert dp_lc != null : "fx:id=\"dt_lc\" was not injected: check your FXML file 'Fxml_Personal.fxml'.";
        assert dp_cm != null : "fx:id=\"dt_cm\" was not injected: check your FXML file 'Fxml_Personal.fxml'.";
        assert dp_cs != null : "fx:id=\"dt_cs\" was not injected: check your FXML file 'Fxml_Personal.fxml'.";
        assert dp_ma != null : "fx:id=\"dt_ma\" was not injected: check your FXML file 'Fxml_Personal.fxml'.";
        assert hb_1 != null : "fx:id=\"hb_1\" was not injected: check your FXML file 'Fxml_Personal.fxml'.";
        assert hb_2 != null : "fx:id=\"hb_2\" was not injected: check your FXML file 'Fxml_Personal.fxml'.";
        assert hb_7 != null : "fx:id=\"hb_7\" was not injected: check your FXML file 'Fxml_Personal.fxml'.";
        assert hbox_toolbar != null : "fx:id=\"hbox_toolbar\" was not injected: check your FXML file 'Fxml_Personal.fxml'.";
        assert im_check != null : "fx:id=\"im_check\" was not injected: check your FXML file 'Fxml_Personal.fxml'.";
        assert im_tool1 != null : "fx:id=\"im_tool1\" was not injected: check your FXML file 'Fxml_Personal.fxml'.";
        assert im_tool10 != null : "fx:id=\"im_tool10\" was not injected: check your FXML file 'Fxml_Personal.fxml'.";
        assert im_tool11 != null : "fx:id=\"im_tool11\" was not injected: check your FXML file 'Fxml_Personal.fxml'.";
        assert im_tool12 != null : "fx:id=\"im_tool12\" was not injected: check your FXML file 'Fxml_Personal.fxml'.";
        assert im_tool2 != null : "fx:id=\"im_tool2\" was not injected: check your FXML file 'Fxml_Personal.fxml'.";
        assert im_tool3 != null : "fx:id=\"im_tool3\" was not injected: check your FXML file 'Fxml_Personal.fxml'.";
        assert im_tool4 != null : "fx:id=\"im_tool4\" was not injected: check your FXML file 'Fxml_Personal.fxml'.";
        assert im_tool5 != null : "fx:id=\"im_tool5\" was not injected: check your FXML file 'Fxml_Personal.fxml'.";
        assert im_tool6 != null : "fx:id=\"im_tool6\" was not injected: check your FXML file 'Fxml_Personal.fxml'.";
        assert im_tool7 != null : "fx:id=\"im_tool7\" was not injected: check your FXML file 'Fxml_Personal.fxml'.";
        assert im_tool8 != null : "fx:id=\"im_tool8\" was not injected: check your FXML file 'Fxml_Personal.fxml'.";
        assert im_tool9 != null : "fx:id=\"im_tool9\" was not injected: check your FXML file 'Fxml_Personal.fxml'.";
        assert im_val != null : "fx:id=\"im_val\" was not injected: check your FXML file 'Fxml_Personal.fxml'.";
        assert im_lc != null : "fx:id=\"im_lc\" was not injected: check your FXML file 'Fxml_Personal.fxml'.";
        assert im_cm != null : "fx:id=\"im_cm\" was not injected: check your FXML file 'Fxml_Personal.fxml'.";
        assert im_cs != null : "fx:id=\"im_cs\" was not injected: check your FXML file 'Fxml_Personal.fxml'.";
        assert im_ma != null : "fx:id=\"im_ma\" was not injected: check your FXML file 'Fxml_Personal.fxml'.";
        assert lb_lc != null : "fx:id=\"lb_lc\" was not injected: check your FXML file 'Fxml_Personal.fxml'.";
        assert lb_cm != null : "fx:id=\"lb_cm\" was not injected: check your FXML file 'Fxml_Personal.fxml'.";
        assert lb_Title != null : "fx:id=\"lb_Title\" was not injected: check your FXML file 'Fxml_Personal.fxml'.";
        assert lb_ocultar != null : "fx:id=\"lb_ocultar\" was not injected: check your FXML file 'Fxml_Personal.fxml'.";
        assert tb_table != null : "fx:id=\"tb_table\" was not injected: check your FXML file 'Fxml_Personal.fxml'.";
        assert tf_apellidos != null : "fx:id=\"tf_apellidos\" was not injected: check your FXML file 'Fxml_Personal.fxml'.";
        assert tf_buscar != null : "fx:id=\"tf_buscar\" was not injected: check your FXML file 'Fxml_Personal.fxml'.";
        assert tf_celular != null : "fx:id=\"tf_celular\" was not injected: check your FXML file 'Fxml_Personal.fxml'.";
        assert tf_ci != null : "fx:id=\"tf_ci\" was not injected: check your FXML file 'Fxml_Personal.fxml'.";
        assert tf_lc != null : "fx:id=\"tf_lc\" was not injected: check your FXML file 'Fxml_Personal.fxml'.";
        assert tf_cm != null : "fx:id=\"tf_cm\" was not injected: check your FXML file 'Fxml_Personal.fxml'.";
        assert tf_cs != null : "fx:id=\"tf_cs\" was not injected: check your FXML file 'Fxml_Personal.fxml'.";
        assert tf_ma != null : "fx:id=\"tf_ma\" was not injected: check your FXML file 'Fxml_Personal.fxml'.";
        assert tf_correo != null : "fx:id=\"tf_correo\" was not injected: check your FXML file 'Fxml_Personal.fxml'.";
        assert tf_direccion != null : "fx:id=\"tf_direccion\" was not injected: check your FXML file 'Fxml_Personal.fxml'.";
        assert tf_nombres != null : "fx:id=\"tf_nombress\" was not injected: check your FXML file 'Fxml_Personal.fxml'.";
        assert tf_nroci != null : "fx:id=\"tf_nroci\" was not injected: check your FXML file 'Fxml_Personal.fxml'.";
        assert tf_thab != null : "fx:id=\"tf_thab\" was not injected: check your FXML file 'Fxml_Personal.fxml'.";
        assert vb_form != null : "fx:id=\"vb_form\" was not injected: check your FXML file 'Fxml_Personal.fxml'.";
        assert vb_table != null : "fx:id=\"vb_table\" was not injected: check your FXML file 'Fxml_Personal.fxml'.";
        
        //Inicializa la Barra de Herramientas y comportamiento del Boton de Busqueda
        defineToolBar();         
        defineBotonBuscar();    
        init_buttons();     //Establece los comportamientos de los botones
        botonInicio();      //Se imprime la pantalla Inicio
        
        //
        loadSexs();
        loadTPersonals();
        loadState();
        createTable();  //Crea e Inicializa la Tabla de Datos                    

        tf_thab.setMaxlength(12);
        tf_celular.setMaxlength(12);

        //Capturador de eventos de Teclado en toda la pantalla 
        ap_root.addEventFilter(KeyEvent.KEY_RELEASED, (KeyEvent ke) -> {
               if (ke.getCode().equals(KeyCode.ENTER)){                     
                   nextFocusedField(ke);    //Traslado el ENFOQUE al siguiente Campo                         
               }                
//               if (ke.isAltDown() && ke.getCode().equals(KeyCode.DIGIT1)){                     
//                   botonNuevo();
//               }
//               if (ke.isAltDown() && ke.getCode().equals(KeyCode.DIGIT2)){                     
//                   botonEditar();
//               }
//               if (ke.isAltDown() && ke.getCode().equals(KeyCode.DIGIT4)){                     
//                   botonEliminar();
//               }
//               if (ke.isAltDown() && ke.getCode().equals(KeyCode.DIGIT5)){                     
//                   botonImprimir();
//               }
//               if (ke.isAltDown() && ke.getCode().equals(KeyCode.DIGIT6)){                     
//                   //CANCELAR
//                   botonInicio();
//               }
//               if (ke.isAltDown() && ke.getCode().equals(KeyCode.B)){                     
//                   botonBuscar();
//               }
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
        TableColumn col_status      = new TableColumn("Act");
        TableColumn col_nroci       = new TableColumn("Nro CI");                
        TableColumn col_nombres     = new TableColumn("Nombres");        
        TableColumn col_apellidos   = new TableColumn("Apellidos");        
        TableColumn col_sexo        = new TableColumn("Sexo");
        TableColumn col_ciudad      = new TableColumn("Ciudad");        
        TableColumn col_parroquia   = new TableColumn("Parroquia");        
        TableColumn col_municipio   = new TableColumn("Municipio");        
        TableColumn col_estado      = new TableColumn("Estado");        
        TableColumn col_direccion   = new TableColumn("Dirección");        
        TableColumn col_telefonos   = new TableColumn("Teléfonos");        
        TableColumn col_celular     = new TableColumn("Celular");        
        TableColumn col_correo      = new TableColumn("Correo");        
        TableColumn col_tpersonal   = new TableColumn("T/Personal");        

        TableColumn col_fec_lc      = new TableColumn("Fecha");        
        TableColumn col_dias_lc     = new TableColumn("Dias");        
        TableColumn col_stat_lc     = new TableColumn("Status");        
        TableColumn col_licencia    = new TableColumn("Lic. Conducir");        
        col_licencia.getColumns().addAll(col_fec_lc, col_dias_lc, col_stat_lc);

        TableColumn col_fec_cm      = new TableColumn("Fecha");        
        TableColumn col_dias_cm     = new TableColumn("Dias");        
        TableColumn col_stat_cm     = new TableColumn("Status");        
        TableColumn col_cert_med    = new TableColumn("Cert. Medico");        
        col_cert_med.getColumns().addAll(col_fec_cm, col_dias_cm, col_stat_cm);

        TableColumn col_fec_cs      = new TableColumn("Fecha");        
        TableColumn col_dias_cs     = new TableColumn("Dias");        
        TableColumn col_stat_cs     = new TableColumn("Status");        
        TableColumn col_cert_sal    = new TableColumn("Cert. Salud");        
        col_cert_sal.getColumns().addAll(col_fec_cs, col_dias_cs, col_stat_cs);

        TableColumn col_fec_ma      = new TableColumn("Fecha");        
        TableColumn col_dias_ma     = new TableColumn("Dias");        
        TableColumn col_stat_ma     = new TableColumn("Status");        
        TableColumn col_man_alim    = new TableColumn("Man. Alimento");        
        col_man_alim.getColumns().addAll(col_fec_ma, col_dias_ma, col_stat_ma);
        
        
        //Se establece el ancho de cada columna
        this.objectWidth(col_status     , 30 , 30);
        this.objectWidth(col_nroci      , 75, 75);
        this.objectWidth(col_nombres    , 140, 200);
        this.objectWidth(col_apellidos  , 170, 200);
        this.objectWidth(col_tpersonal  , 100, 100);
        this.objectWidth(col_sexo       , 80, 80);
        this.objectWidth(col_direccion  , 180, 350);
        this.objectWidth(col_ciudad     , 130, 200);
        this.objectWidth(col_parroquia  , 130, 200);
        this.objectWidth(col_municipio  , 130, 200);
        this.objectWidth(col_estado     , 130, 200);
        this.objectWidth(col_telefonos  , 100, 150);
        this.objectWidth(col_celular    , 100, 150);
        this.objectWidth(col_correo     , 200, 250);
        this.objectWidth(col_fec_lc     , 75, 75);
        this.objectWidth(col_fec_cm     , 75, 75);
        this.objectWidth(col_fec_cs     , 75, 75);
        this.objectWidth(col_fec_ma     , 75, 75);
        this.objectWidth(col_dias_lc    , 40, 40);
        this.objectWidth(col_dias_cm    , 40, 40);
        this.objectWidth(col_dias_cs    , 40, 40);
        this.objectWidth(col_dias_ma    , 40, 40);
        this.objectWidth(col_stat_lc    , 60, 60);
        this.objectWidth(col_stat_cm    , 60, 60);
        this.objectWidth(col_stat_cs    , 60, 60);
        this.objectWidth(col_stat_ma    , 60, 60);
        /**
         * Sobreescritura de un metodo de la Columna, para sustituir el valor numerico 
         * del STATUS del usuario por una Imagen segun el valor
         * 1 - VERDE (HABILITADO)
         * 2 - ROJO  (DESHABILITADO)
         */
        col_status.setCellFactory(new Callback<TableColumn, TableCell>() {
            @Override
            public TableCell call(TableColumn param) {
                return new TableCell<log_Personal, Object>() {
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

        col_dias_lc.setCellFactory(new Callback<TableColumn, TableCell>() {
            @Override
            public TableCell call(TableColumn param) {
                return new TableCell<log_Personal, Integer>() {
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

        col_dias_cm.setCellFactory(new Callback<TableColumn, TableCell>() {
            @Override
            public TableCell call(TableColumn param) {
                return new TableCell<log_Personal, Integer>() {
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
        
        col_dias_cs.setCellFactory(new Callback<TableColumn, TableCell>() {
            @Override
            public TableCell call(TableColumn param) {
                return new TableCell<log_Personal, Integer>() {
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
        
        col_dias_ma.setCellFactory(new Callback<TableColumn, TableCell>() {
            @Override
            public TableCell call(TableColumn param) {
                return new TableCell<log_Personal, Integer>() {
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
        col_nroci.setCellValueFactory( 
                new PropertyValueFactory<>("nro_ci") );
        col_nombres.setCellValueFactory( 
                new PropertyValueFactory<>("nombres") );
        col_apellidos.setCellValueFactory( 
                new PropertyValueFactory<>("apellidos") );
        col_sexo.setCellValueFactory( 
                new PropertyValueFactory<>("sex") );
        col_ciudad.setCellValueFactory( 
                new PropertyValueFactory<>("city") );
        col_parroquia.setCellValueFactory( 
                new PropertyValueFactory<>("parish") );
        col_municipio.setCellValueFactory( 
                new PropertyValueFactory<>("municipality") );
        col_estado.setCellValueFactory( 
                new PropertyValueFactory<>("state") );
        col_direccion.setCellValueFactory( 
                new PropertyValueFactory<>("direccion") );
        col_telefonos.setCellValueFactory( 
                new PropertyValueFactory<>("telefonos") );
        col_celular.setCellValueFactory( 
                new PropertyValueFactory<>("celular") );
        col_correo.setCellValueFactory( 
                new PropertyValueFactory<>("correo") );
        col_tpersonal.setCellValueFactory( 
                new PropertyValueFactory<>("tpersonal") );
        col_fec_lc.setCellValueFactory( 
                new PropertyValueFactory<>("fec_lc") );
        col_fec_cm.setCellValueFactory( 
                new PropertyValueFactory<>("fec_cm") );
        col_fec_cs.setCellValueFactory( 
                new PropertyValueFactory<>("fec_cs") );
        col_fec_ma.setCellValueFactory( 
                new PropertyValueFactory<>("fec_ma") );
        col_dias_lc.setCellValueFactory( 
                new PropertyValueFactory<>("dias_lc") );
        col_stat_lc.setCellValueFactory( 
                new PropertyValueFactory<>("stat_lc") );
        col_dias_cm.setCellValueFactory( 
                new PropertyValueFactory<>("dias_cm") );
        col_stat_cm.setCellValueFactory( 
                new PropertyValueFactory<>("stat_cm") );
        col_dias_cs.setCellValueFactory( 
                new PropertyValueFactory<>("dias_cs") );
        col_stat_cs.setCellValueFactory( 
                new PropertyValueFactory<>("stat_cs") );
        col_dias_ma.setCellValueFactory( 
                new PropertyValueFactory<>("dias_ma") );
        col_stat_ma.setCellValueFactory( 
                new PropertyValueFactory<>("stat_ma") );
        
        //Se Asigna ordenadamente las columnas de la tabla
        tb_table.getColumns().addAll(
                col_status, col_nroci, col_nombres, col_apellidos, col_tpersonal, 
                col_sexo, col_direccion, col_ciudad, col_parroquia, col_municipio, 
                col_estado, col_telefonos, col_celular, col_correo,
                col_licencia, col_cert_med, col_cert_sal, col_man_alim
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
    private boolean savePersonal() {
        //Se asigna el valor del tipo de procedimiento que viene de ser ejecutado,
        // 1 si es un NUEVO personal 
        // 2 si es un personal MODIFICADO
        int proceso = tipoOperacion;    
        //Se obtiene el rif y nombre del personal
        String personalCi = tf_nroci.getText();
        String personalName1 = tf_nombres.getText();
        String personalName2 = tf_apellidos.getText();
        //Si el nombre de usuario no esta en blanco
        if((personalCi != null && !personalCi.equals("")) &&
           (personalName1 != null && !personalName1.equals(""))  &&
           (personalName2 != null && !personalName2.equals(""))){
            //Ejecuta los procesos predeterminados para el guardado del personal
            setCurrentOperation();
            //Se asignan los valores del objeto 
            log_Personal log_personal = new log_Personal();
            log_personal.setNro_ci(tf_nroci.getText());
            log_personal.setNombres(tf_nombres.getText());
            log_personal.setApellidos(tf_apellidos.getText());
            log_personal.setDireccion(tf_direccion.getText());
            log_personal.setTelefonos(tf_thab.getText());
            log_personal.setCelular(tf_celular.getText());
            log_personal.setCorreo(tf_correo.getText());
            log_personal.setRuta_ci(tf_ci.getText());
            log_personal.setRuta_lc(tf_lc.getText());
            log_personal.setRuta_cm(tf_cm.getText());
            log_personal.setRuta_cs(tf_cs.getText());
            log_personal.setRuta_ma(tf_ma.getText());
            log_personal.setFec_lc(Date.valueOf(dp_lc.getValue()));
            log_personal.setFec_cm(Date.valueOf(dp_cm.getValue()));
            log_personal.setFec_cs(Date.valueOf(dp_cs.getValue()));
            log_personal.setFec_ma(Date.valueOf(dp_ma.getValue()));
            log_personal.setCountry(1);
            log_personal.setStatus(Datos.getLog_personal().getStatus());      //Se asigna el STATUS del personal

            //Se obtiene el Sexo
            Sex sex = (Sex) cb_sexo.getValue();            
            if(sex == null){             //Si no existe un GroupSupplier seleccionado
                log_personal.setSex(null);   //Se establece la variable como NULA
            }else{  
                log_personal.setSex(sex);
            }            

            //Se obtiene el log_tpersonal
            log_TPersonal log_tpersonal = (log_TPersonal) cb_tpersonal.getValue();            
            if(log_tpersonal == null){             //Si no existe un GroupSupplier seleccionado
                log_personal.setTpersonal(null);   //Se establece la variable como NULA
            }else{  
                log_personal.setTpersonal(log_tpersonal);
            }            

            //Se obtiene el Estado 
            State state = (State) cb_estado.getValue();            
            if(state == null){             //Si no existe un Estado seleccionado
                log_personal.setState(null);   //Se establece la variable como NULA
            }else{  
                log_personal.setState(state);
            }            
            
            //Se obtiene la Ciudad
            City city = (City) cb_localidad.getValue();            
            if(city == null){             //Si no existe una Ciudad seleccionada
                log_personal.setCity(null);   //Se establece la variable como NULA
            }else{  
                log_personal.setCity(city);
            }            

            //Se obtiene el Municipio 
            Municipality municipality = (Municipality) cb_municipio.getValue();            
            if(municipality == null){             //Si no existe un Municipio seleccionado
                log_personal.setMunicipality(null);   //Se establece la variable como NULA
            }else{  
                log_personal.setMunicipality(municipality);
            }            
            
            //Se obtiene la Parroquia 
            Parish parish = (Parish) cb_parroquia.getValue();            
            if(parish == null){             //Si no existe una Parroquia seleccionada
                log_personal.setParish(null);   //Se establece la variable como NULA
            }else{  
                log_personal.setParish(parish);
            }            
            
            //Se llama al proceso de Guardado
            boolean result = 
                    Ln.getInstance().save_log_Personal(log_personal, proceso, ScreenName);
            //Si el Resultado es correcto
            if(result){
                //Se Notifica al usuario
                Gui.getInstance().showMessage("El " + ScreenName + " se ha Guardado Correctamente!", "I");
                loadPersonal();            //Se Recarga la tabla de usuarios existentes
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
        tf_nroci.setText(Datos.getLog_personal().getNro_ci());
        tf_nombres.setText(Datos.getLog_personal().getNombres());
        tf_apellidos.setText(Datos.getLog_personal().getApellidos());
        tf_direccion.setText(Datos.getLog_personal().getDireccion());
        tf_thab.setText(Datos.getLog_personal().getTelefonos());
        tf_celular.setText(Datos.getLog_personal().getCelular());
        tf_correo.setText(Datos.getLog_personal().getCorreo());
        cb_sexo.setValue(Datos.getLog_personal().getSex());
        cb_estado.setValue(Datos.getLog_personal().getState());
        cb_localidad.setValue(Datos.getLog_personal().getCity());
        cb_municipio.setValue(Datos.getLog_personal().getMunicipality());
        cb_parroquia.setValue(Datos.getLog_personal().getParish());
        cb_tpersonal.setValue(Datos.getLog_personal().getTpersonal());
        tf_ci.setText(Datos.getLog_personal().getRuta_ci());
        tf_lc.setText(Datos.getLog_personal().getRuta_lc());
        tf_cm.setText(Datos.getLog_personal().getRuta_cm());
        tf_cs.setText(Datos.getLog_personal().getRuta_cs());
        tf_ma.setText(Datos.getLog_personal().getRuta_ma());

        if(Datos.getLog_personal().getFec_lc() != null)
            dp_lc.setValue(Datos.getLog_personal().getFec_lc().toLocalDate());
        else
            dp_lc.setValue(LocalDate.now());
        lb_lc.setText(Integer.toString(Datos.getLog_personal().getDias_lc()) + " D");
        changeIconDate("vencido", 0, im_lc);          
        if (Datos.getLog_personal().getStat_lc()!= null) 
            changeIconDate(Datos.getLog_personal().getStat_lc(), Datos.getLog_personal().getDias_lc(), im_lc);          
        
        if(Datos.getLog_personal().getFec_cm() != null)
            dp_cm.setValue(Datos.getLog_personal().getFec_cm().toLocalDate());
        else
            dp_cm.setValue(LocalDate.now());
        lb_cm.setText(Integer.toString(Datos.getLog_personal().getDias_cm()) + " D");
        changeIconDate("vencido", 0, im_cm);          
        if (Datos.getLog_personal().getStat_cm()!= null) 
            changeIconDate(Datos.getLog_personal().getStat_cm(), Datos.getLog_personal().getDias_cm(), im_cm);
        
        if(Datos.getLog_personal().getFec_cs() != null)
            dp_cs.setValue(Datos.getLog_personal().getFec_cs().toLocalDate());
        else
            dp_cs.setValue(LocalDate.now());
        lb_cs.setText(Integer.toString(Datos.getLog_personal().getDias_cs()) + " D");
        changeIconDate("vencido", 0, im_cs);          
        if (Datos.getLog_personal().getStat_cs()!= null) 
            changeIconDate(Datos.getLog_personal().getStat_cs(), Datos.getLog_personal().getDias_cs(), im_cs);          
        
        // manipulacion de alimentación NO tiene Vencimiento
//        if(Datos.getLog_personal().getFec_ma() != null)
//            dp_ma.setValue(Datos.getLog_personal().getFec_ma().toLocalDate());
//        else
            dp_ma.setValue(LocalDate.now());
//        lb_ma.setText(Integer.toString(Datos.getLog_personal().getDias_ma()) + " D");
//        changeIconDate("vencido", 0, im_ma);          
//        if (Datos.getLog_personal().getStat_ma()!= null) 
//            changeIconDate(Datos.getLog_personal().getStat_ma(), Datos.getLog_personal().getDias_ma(), im_ma);
        
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
                tf_nroci.setEditable(false);
                tf_nombres.setEditable(false);
                tf_apellidos.setEditable(false);
                tf_direccion.setEditable(false);
                tf_thab.setEditable(false);
                tf_celular.setEditable(false);
                tf_correo.setEditable(false);
                tf_ci.setEditable(false);
                tf_lc.setEditable(false);
                tf_cm.setEditable(false);
                tf_cs.setEditable(false);
                tf_ma.setEditable(false);

                dp_lc.setDisable(true);
                dp_cm.setDisable(true);
                dp_cs.setDisable(true);
                dp_ma.setDisable(true);

                lb_lc.setVisible(true);
                lb_cm.setVisible(true);
                lb_cs.setVisible(true);
                lb_ma.setVisible(true);
                
                im_lc.setVisible(true);
                im_cm.setVisible(true);
                im_cs.setVisible(true);
                im_ma.setVisible(true);

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
                tf_nroci.setEditable(true);
                tf_nombres.setEditable(true);
                tf_apellidos.setEditable(true);
                tf_direccion.setEditable(true);
                tf_thab.setEditable(true);
                tf_celular.setEditable(true);
                tf_correo.setEditable(true);
                tf_ci.setEditable(true);
                tf_lc.setEditable(true);
                tf_cm.setEditable(true);
                tf_cs.setEditable(true);
                tf_ma.setEditable(true);

                dp_lc.setDisable(false);
                dp_cm.setDisable(false);
                dp_cs.setDisable(false);
                dp_ma.setDisable(false);
                
                lb_lc.setVisible(false);
                lb_cm.setVisible(false);
                lb_cs.setVisible(false);
                lb_ma.setVisible(false);

                im_lc.setVisible(false);
                im_cm.setVisible(false);
                im_cs.setVisible(false);
                im_ma.setVisible(false);

                im_check.setVisible(true);
                im_val.setVisible(true);

                //SE PERMITE: NUEVO,GUARDAR Y CANCELAR             
                disables = new Integer[]{0,1,3,4,6,7,8,9,10,11};
                disableAllToolBar(disables);                            
                break;
            case 2:  //EDITAR
//                lb_Title.setText(Tools.verticalText("EDITAR"));
                lb_Title.setText("EDITAR");
                tf_nroci.setEditable(false);
                tf_nombres.setEditable(true);
                tf_apellidos.setEditable(true);
                tf_direccion.setEditable(true);
                tf_thab.setEditable(true);
                tf_celular.setEditable(true);
                tf_correo.setEditable(true);
                tf_ci.setEditable(true);
                tf_lc.setEditable(true);
                tf_cm.setEditable(true);
                tf_cs.setEditable(true);
                tf_ma.setEditable(true);

                dp_lc.setDisable(false);
                dp_cm.setDisable(false);
                dp_cs.setDisable(false);
                dp_ma.setDisable(false);
                
                lb_lc.setVisible(false);
                lb_cm.setVisible(false);
                lb_cs.setVisible(false);
                lb_ma.setVisible(false);
                
                im_check.setVisible(false);
                im_val.setVisible(false);

                //SE PERMITE: EDITAR,GUARDAR Y CANCELAR
                disables = new Integer[]{0,1,3,4,6,7,8,9,10,11};
                disableAllToolBar(disables);            
                break;
            case 3:  //GUARDAR
                tf_nroci.setEditable(false);
                tf_nombres.setEditable(false);
                tf_apellidos.setEditable(false);
                tf_direccion.setEditable(false);
                tf_thab.setEditable(false);
                tf_celular.setEditable(false);
                tf_correo.setEditable(false);
                tf_ci.setEditable(false);
                tf_lc.setEditable(false);
                tf_cm.setEditable(false);
                tf_cs.setEditable(false);
                tf_ma.setEditable(false);

                dp_lc.setDisable(true);
                dp_cm.setDisable(true);
                dp_cs.setDisable(true);
                dp_ma.setDisable(true);
                
                im_check.setVisible(false);
                im_val.setVisible(false);

                //SE PERMITE: GUARDAR Y CANCELAR
                disables = new Integer[]{0,1,3,4,6,7,8,9,10,11};
                disableAllToolBar(disables);   
                break;
            case 4:  //CAMBIAR STATUS DEL USUARIO            
                tf_nroci.setEditable(false);
                tf_nombres.setEditable(false);
                tf_apellidos.setEditable(false);
                tf_direccion.setEditable(false);
                tf_thab.setEditable(false);
                tf_celular.setEditable(false);
                tf_correo.setEditable(false);
                tf_ci.setEditable(false);
                tf_lc.setEditable(false);
                tf_cm.setEditable(false);
                tf_cs.setEditable(false);
                tf_ma.setEditable(false);

                dp_lc.setDisable(true);
                dp_cm.setDisable(true);
                dp_cs.setDisable(true);
                dp_ma.setDisable(true);
                
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
    private void loadPersonal(){        
        Datos.setRep_log_personal(Ln.getInstance().load_log_Personal());
        loadTable(Datos.getRep_log_personal());    
    }
    /**
     * Procedimiento de llenado de datos en la tabla de datos
     */
    private void loadTable(log_Personal[] log_personal){    
        if(log_personal != null){
            ObservableList<log_Personal> data = FXCollections.observableArrayList();        
            data.addAll(Arrays.asList(log_personal));   
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
        log_Personal log_personal = tb_table.getSelectionModel().getSelectedItem();          
        if(log_personal != null){
            Datos.setLog_personal(log_personal);            //Asigno el Usuario a la Clase de Datos Globales
            change_im_tool4(log_personal.getStatus());          //Se define el valor del Boton de Cambio se Status
            refreshForm();                                  //Refresca el Formulario
            setFormVisible(true);                           //Coloca Visible el formulario
        }
    }
    /**
     * Procedimiento que obtiene los Distintos Sexo de la BD
     * y los carga en el COMBOBOX
     */
    private void loadSexs(){        
        Sex[] sex = Ln.getInstance().load_Sex();        
        final ObservableList<Sex> data = FXCollections.observableArrayList();
        data.addAll(Arrays.asList(sex));          
        cb_sexo.setItems(data); 
//        CbSexKeyHandler cbkh = new CbSexKeyHandler(data);
//        cb_sexo.setOnKeyReleased(cbkh);
        Datos.setCbSex(cb_sexo);                       
        new SelectKeyComboBoxListener(cb_sexo); 
    }  
    /**
     * Procedimiento que obtiene los Distintos Sexo de la BD
     * y los carga en el COMBOBOX
     */
    private void loadTPersonals(){        
        log_TPersonal[] log_tpersonal = Ln.getInstance().load_log_TPersonal();        
        final ObservableList<log_TPersonal> data = FXCollections.observableArrayList();
        data.addAll(Arrays.asList(log_tpersonal));          
        cb_tpersonal.setItems(data); 
//        CbTPersonalKeyHandler cbkh = new CbTPersonalKeyHandler(data);
//        cb_tpersonal.setOnKeyReleased(cbkh);
        Datos.setCbTPersonal(cb_tpersonal);                       
        new SelectKeyComboBoxListener(cb_tpersonal); 
    }  
    /**
     * Procedimiento que obtiene los Distintos Estados de la BD
     * y los carga en el COMBOBOX
     * param: nombre del pais
     */
    private void loadState(){ 
        State[] state = Ln.getInstance().find_State("Venezuela");        
        final ObservableList<State> data = FXCollections.observableArrayList();
        data.addAll(Arrays.asList(state));          
        cb_estado.setItems(data); 
//        CbStateKeyHandler cbkh = new CbStateKeyHandler(data);
//        cb_estado.setOnKeyReleased(cbkh);
        Datos.setCbState(cb_estado);                       
        new SelectKeyComboBoxListener(cb_estado); 
    }    
    /**
     * Procedimiento que obtiene las Distintas Ciudades de la BD
     * y los carga en el COMBOBOX
     * param: nombre del estado
     */
    private void loadCity(){        
        City[] city = Ln.getInstance().find_City(
            cb_estado.getSelectionModel().getSelectedItem().toString());        
        final ObservableList<City> data = FXCollections.observableArrayList();
        data.addAll(Arrays.asList(city));          
        cb_localidad.setItems(data); 
//        CbCityKeyHandler cbkh = new CbCityKeyHandler(data);
//        cb_localidad.setOnKeyReleased(cbkh);
        Datos.setCbCity(cb_localidad);                       
        new SelectKeyComboBoxListener(cb_estado); 
    }    
    /**
     * Procedimiento que obtiene los Distintos Municipios de la BD
     * y los carga en el COMBOBOX
     * param: nombre de la ciudad
     */
    private void loadMunicipality(){        
        Municipality[] municipality = Ln.getInstance().find_Municipality(
            cb_localidad.getSelectionModel().getSelectedItem().toString());        
        final ObservableList<Municipality> data = FXCollections.observableArrayList();
        data.addAll(Arrays.asList(municipality));          
        cb_municipio.setItems(data); 
//        CbMunicipalityKeyHandler cbkh = new CbMunicipalityKeyHandler(data);
//        cb_municipio.setOnKeyReleased(cbkh);
        Datos.setCbMunicipality(cb_municipio);                       
        new SelectKeyComboBoxListener(cb_municipio); 
    }    
    /**
     * Procedimiento que obtiene las Distintas Parroquias de la BD
     * y los carga en el COMBOBOX
     * param: nombre de la ciudad
     */
    private void loadParish(){        
        Parish[] parish = Ln.getInstance().find_Parish(
            cb_municipio.getSelectionModel().getSelectedItem().toString(),
            cb_estado.getSelectionModel().getSelectedItem().toString());        
        final ObservableList<Parish> data = FXCollections.observableArrayList();
        data.addAll(Arrays.asList(parish));          
        cb_parroquia.setItems(data); 
//        CbParishKeyHandler cbkh = new CbParishKeyHandler(data);
//        cb_parroquia.setOnKeyReleased(cbkh);
        Datos.setCbParish(cb_parroquia);                       
        new SelectKeyComboBoxListener(cb_parroquia); 
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
                    tf_nroci,cb_sexo,tf_nombres,tf_apellidos,cb_estado,cb_localidad,
                    cb_municipio,cb_parroquia,tf_direccion,tf_thab,tf_celular,tf_correo,
                    cb_tpersonal,tf_ci, bt_ci,tf_lc,bt_lc,dp_lc,tf_cm,bt_cm,dp_cm,
                    tf_cs,bt_cs,dp_cs,tf_ma,bt_ma,dp_ma};
                break;
            case 1:     //NUEVO
                nodos = new Node[]{
                    tf_nroci,im_check,cb_sexo,tf_nombres,tf_apellidos,cb_estado,cb_localidad,
                    cb_municipio,cb_parroquia,tf_direccion,tf_thab,tf_celular,tf_correo,
                    cb_tpersonal,tf_ci, bt_ci,tf_lc,bt_lc,dp_lc,tf_cm,bt_cm,dp_cm,
                    tf_cs,bt_cs,dp_cs,tf_ma,bt_ma,dp_ma};
                break;
            case 2:     //EDITAR
                nodos = new Node[]{
                    tf_nroci,im_check,cb_sexo,tf_nombres,tf_apellidos,cb_estado,cb_localidad,
                    cb_municipio,cb_parroquia,tf_direccion,tf_thab,tf_celular,tf_correo,
                    cb_tpersonal,tf_ci, bt_ci,tf_lc,bt_lc,dp_lc,tf_cm,bt_cm,dp_cm,
                    tf_cs,bt_cs,dp_cs,tf_ma,bt_ma,dp_ma};
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
                        //Solicita los datos y envia la Respuesta a imprimirse en la Pantalla
                        try{
                            Datos.setRep_log_personal(Ln.getInstance().find_log_Personal(tf_buscar.getText()));
                            loadTable(Datos.getRep_log_personal());     
                        } catch(Exception e){
                            Gui.getInstance().showMessage("El " + ScreenName + " NO existe!", "A");
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
        loadToolBar();
        //SE LIMPIA EL FORMULARIO
        tf_buscar.setText("");
        tf_buscar.setVisible(false);
        Datos.setLog_personal(new log_Personal());                           
        refreshForm();                      
        Datos.setLog_personal(null);             //RESET DE LA VARIABLE
        setFormVisible(false);               //OCULTA EL FORMULARIO
        //RECARGA LA TABLA ORIGINAL
        loadPersonal();
    }
    /**
     * 
     */
    private void botonNuevo(){
        if(toolsConfig[2]==1){
            tipoOperacion = 1;
            change_im_check(false);
            loadPersonal();
            Datos.setLog_personal(new log_Personal());
            refreshForm();
            setFormVisible(true);
            Gui.getFields()[Gui.getFieldFocused()].requestFocus();
        }
    }
    /**
     * 
     */
    private void botonEditar(){
        if(Datos.getLog_personal()!= null && toolsConfig[3]==1){
            tipoOperacion = 2;
            change_im_tool4(Datos.getLog_personal().getStatus());
            refreshForm();
            setFormVisible(true);     
            Gui.getFields()[Gui.getFieldFocused()].requestFocus();
        }
    }
    /**
     * 
     */
    private void botonGuardar(){        
        if(Datos.getLog_personal()!= null && toolsConfig[4]==1){
            boolean result = savePersonal();
            if (result)
                botonInicio();
        }
    }
    /**
     * 
     */
    private void botonEliminar() {
        if(Datos.getLog_personal()!= null && toolsConfig[5]==1){
            tipoOperacion = 4;      //OPERACION DE BORRADO
            change_im_check(true);       //SE CAMBIA EL ICONO DE VERIFICACION DEL SUPPLIER                   
            refreshForm();         
            setFormVisible(true);  
            String verbo = "desactivar";
            if(Datos.getLog_personal().getStatus() == 1){
                verbo = "activar";
            }
            String mensj = 
                "¿Seguro que desea " + verbo + " el " + ScreenName + " " + Datos.getLog_personal().getNro_ci() + " ?";
            Gui.getInstance().showConfirmar(mensj);  
        }
    }
    /**
     * 
     */
    private void botonBuscar(){
        if(toolsConfig[13]==1){
            tipoOperacion = 0;                          //OPERACION SOLO LECTURA
            //SE LIMPIA EL FORMULARIO
            tf_buscar.setVisible(true);
            Datos.setLog_personal(new log_Personal());                           
            refreshForm();                      
            Datos.setLog_personal(null);                //RESET DE LA VARIABLE
            setFormVisible(false);                      //OCULTA EL FORMULARIO     
            tf_buscar.requestFocus();
        }
    }
    /**
     * 
     */
    private void botonOcultar(){
        tipoOperacion = 0;                              //OPERACION SOLO LECTURA
        //SE LIMPIA EL FORMULARIO
        tf_buscar.setVisible(false);
        Datos.setLog_personal(new log_Personal());                           
        refreshForm();                      
        Datos.setLog_personal(new log_Personal());      //RESET DE LA VARIABLE
        setFormVisible(false);                          //OCULTA EL FORMULARIO
    }
    /**
     * 
     */
    private void botonImprimir(){
        tipoOperacion = 5;                  //OPERACION SOLO LECTURA
        Gui.getInstance().showPrint(ScreenName);  
    }
    /**
     * Procedimiento que define los comportamientos en diversos Eventos 
     * de cada boton en la pantalla actual.
     */
    private void init_buttons(){
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
                    //
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
                    boolean boo = Ln.getInstance().check_log_Personal(tf_nroci.getText());
                    if(boo){
                        Gui.getInstance().showMessage("Ya existe el " + ScreenName + "!", "E");
                        botonInicio();
                    }
                }        
            }
        });                
        /**
         * metodo para mostrar el item (estado) seleccionado y cargar las ciudades
         * param: nombre del estado
         */
        cb_estado.getSelectionModel().selectedItemProperty().addListener((ObservableValue<? extends State> arg0, State arg1, State arg2) -> {
            if (arg2 != null)
                loadCity();
        });
        /**
         * metodo para mostrar el item (localidad) seleccionado y cargar los municipios
         * param: nombre de la ciudad
         */
        cb_localidad.getSelectionModel().selectedItemProperty().addListener((ObservableValue<? extends City> arg0, City arg1, City arg2) -> {
            if (arg2 != null)
                loadMunicipality();
        });
        /**
         * metodo para mostrar el item (municipio) seleccionado y cargar las parroquias
         * param: nombre de la ciudad
         */
        cb_municipio.getSelectionModel().selectedItemProperty().addListener((ObservableValue<? extends Municipality> arg0, Municipality arg1, Municipality arg2) -> {
            if (arg2 != null)
                loadParish();
        });
        /**
         * metodo para mostrar buscar el nro de ci
         * param: ENTER O TAB
         */
        tf_nroci.setOnKeyReleased((KeyEvent ke) -> {
            if (ke.getCode().equals(KeyCode.ENTER) || ke.getCode().equals(KeyCode.TAB)){
                //Valida que el evento se haya generado en el campo de busqueda
                if(((Node)ke.getSource()).getId().equals("tf_nroci")){
                    //Solicita los datos y envia la Respuesta a imprimirse en la Pantalla
                    boolean boo = Ln.getInstance().check_log_Personal(tf_nroci.getText());
                    if(boo){
                        Gui.getInstance().showMessage("Ya existe el " + ScreenName + "!", "E");
                        botonInicio();
                    }
                }
            }
        });
        /**
         * BOTON CI
         */
        bt_ci.setOnAction((ActionEvent event) -> {
            FileChooser fileChooser = new FileChooser();
            if (tipoOperacion == 0){
                if(tf_ci.getText() != null){
                    file = new File(tf_ci.getText());
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

                fileChooser.setInitialDirectory(new File(path + path_dat + "/logistica/personal/"));

                //Show open file dialog
                file = fileChooser.showOpenDialog(null);
                if (file != null)
                    tf_ci.setText(file.getPath());
            }
        });
        /**
         * BOTON LC
         */
        bt_lc.setOnAction((ActionEvent event) -> {
            FileChooser fileChooser = new FileChooser();
            if (tipoOperacion == 0){
                if(tf_lc.getText() != null){
                    file = new File(tf_lc.getText());
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

                fileChooser.setInitialDirectory(new File(path + path_dat + "/logistica/personal/"));

                //Show open file dialog
                file = fileChooser.showOpenDialog(null);
                if (file != null)
                    tf_lc.setText(file.getPath());
            }
        });
        /**
         * Fecha LC
         */
        dp_lc.setOnKeyReleased((KeyEvent ke) -> {
            if (ke.getCode().equals(KeyCode.ENTER) || ke.getCode().equals(KeyCode.TAB)){
                //Valida que el evento se haya generado en el campo de busqueda
                if(((Node)ke.getSource()).getId().equals("dp_lc") &&
                        dp_lc.getValue() != null){
                    
                    Calendar calendar1 = Calendar.getInstance();
                    Calendar calendar2 = Calendar.getInstance();
                    calendar1.setTime(Date.valueOf(dp_lc.getValue()));
                    calendar2.setTime(Date.valueOf(LocalDate.now())); 
 
                    long milliseconds1 = calendar1.getTimeInMillis();
                    long milliseconds2 = calendar2.getTimeInMillis();
                    long diff = milliseconds2 - milliseconds1;
                    long diffDays = diff / (24 * 60 * 60 * 1000);
        
                    lb_lc.setText(String.valueOf(Math.abs(diffDays)) + " D");
                    if(diffDays < 0){
                        changeIconDate("x vencer", (int) Math.abs(diffDays), im_lc);          
                    }
                    else{
                        changeIconDate("vencido", (int) Math.abs(diffDays), im_lc);          
                    }
                }
            }
        });
        /**
         * BOTON CM
         */
        bt_cm.setOnAction((ActionEvent event) -> {
            FileChooser fileChooser = new FileChooser();
            if (tipoOperacion == 0){
                if(tf_cm.getText() != null){
                    file = new File(tf_cm.getText());
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

                fileChooser.setInitialDirectory(new File(path + path_dat + "/logistica/personal/"));

                //Show open file dialog
                file = fileChooser.showOpenDialog(null);
                if (file != null)
                    tf_cm.setText(file.getPath());
            }
        });
        /**
         * Fecha CM
         */
        dp_cm.setOnKeyReleased((KeyEvent ke) -> {
            if (ke.getCode().equals(KeyCode.ENTER) || ke.getCode().equals(KeyCode.TAB)){
                //Valida que el evento se haya generado en el campo de busqueda
                if(((Node)ke.getSource()).getId().equals("dp_cm") &&
                        dp_cm.getValue() != null){
                    
                    Calendar calendar1 = Calendar.getInstance();
                    Calendar calendar2 = Calendar.getInstance();
                    calendar1.setTime(Date.valueOf(dp_cm.getValue()));
                    calendar2.setTime(Date.valueOf(LocalDate.now())); 
 
                    long milliseconds1 = calendar1.getTimeInMillis();
                    long milliseconds2 = calendar2.getTimeInMillis();
                    long diff = milliseconds2 - milliseconds1;
                    long diffDays = diff / (24 * 60 * 60 * 1000);
        
                    lb_cm.setText(String.valueOf(Math.abs(diffDays)) + " D");
                    if(diffDays < 0){
                        changeIconDate("x vencer", (int) Math.abs(diffDays), im_cm);
                    }
                    else{
                        changeIconDate("vencido", (int) Math.abs(diffDays), im_cm);
                    }
                }
            }
        });
        /**
         * BOTON CS
         */
        bt_cs.setOnAction((ActionEvent event) -> {
            FileChooser fileChooser = new FileChooser();
            if (tipoOperacion == 0){
                if(tf_cs.getText() != null){
                    file = new File(tf_cs.getText());
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

                fileChooser.setInitialDirectory(new File(path + path_dat + "/logistica/personal/"));

                //Show open file dialog
                file = fileChooser.showOpenDialog(null);
                if (file != null)
                    tf_cs.setText(file.getPath());
            }
        });
        /**
         * Fecha CM
         */
        dp_cs.setOnKeyReleased((KeyEvent ke) -> {
            if (ke.getCode().equals(KeyCode.ENTER) || ke.getCode().equals(KeyCode.TAB)){
                //Valida que el evento se haya generado en el campo de busqueda
                if(((Node)ke.getSource()).getId().equals("dp_cs") &&
                        dp_cs.getValue() != null){
                    
                    Calendar calendar1 = Calendar.getInstance();
                    Calendar calendar2 = Calendar.getInstance();
                    calendar1.setTime(Date.valueOf(dp_cs.getValue()));
                    calendar2.setTime(Date.valueOf(LocalDate.now())); 
 
                    long milliseconds1 = calendar1.getTimeInMillis();
                    long milliseconds2 = calendar2.getTimeInMillis();
                    long diff = milliseconds2 - milliseconds1;
                    long diffDays = diff / (24 * 60 * 60 * 1000);
        
                    lb_cs.setText(String.valueOf(Math.abs(diffDays)) + " D");
                    if(diffDays < 0){
                        changeIconDate("x vencer", (int) Math.abs(diffDays), im_cs);
                    }
                    else{
                        changeIconDate("vencido", (int) Math.abs(diffDays), im_cs);
                    }
                }
            }
        });
        /**
         * BOTON MA
         */
        bt_ma.setOnAction((ActionEvent event) -> {
            FileChooser fileChooser = new FileChooser();
            if (tipoOperacion == 0){
                if(tf_ma.getText() != null){
                    file = new File(tf_ma.getText());
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

                fileChooser.setInitialDirectory(new File(path + path_dat + "/logistica/personal/"));

                //Show open file dialog
                file = fileChooser.showOpenDialog(null);

                if (file != null)
                    tf_ma.setText(file.getPath());
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
        if(value){  //Si el estado es visible entonces 
            vb_table.relocate(30, 439);
            vb_table.setPrefHeight(133);
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
