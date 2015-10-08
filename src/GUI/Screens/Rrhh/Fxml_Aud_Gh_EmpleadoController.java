/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Screens.Rrhh;

import GUI.Gui;
import LN.Ln;
import Listeners.FocusPropertyChangeListener;
import Objects.Infocent.Asignacion;
import Objects.Infocent.Deduccion;
import Objects.Infocent.Empleado;
import Objects.Infocent.Empresa;
import Tools.Datos;
import Tools.ValidateTextFieldNumber;
import java.math.RoundingMode;
import javafx.fxml.Initializable;
import java.net.URL;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.TimeZone;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
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
import javafx.util.Callback;

/**
 *
 * @author MITM
 */
public class Fxml_Aud_Gh_EmpleadoController implements Initializable {

    @FXML
    private AnchorPane ap_root;

    @FXML
    private Button bt_ci;

    @FXML
    private ComboBox<Integer> cb_ano;

    @FXML
    private ComboBox<Empresa> cb_empresa;

    @FXML
    private ComboBox<Empleado> cb_ficha;

    @FXML
    private ComboBox<String> cb_mes;

    @FXML
    private ComboBox<Integer> cb_per;

    @FXML
    private HBox hbox_toolbar;

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
    private ImageView im_tool2;

    @FXML
    private ImageView im_tool1;

    @FXML
    private Label lb_fecing;

    @FXML
    private Label lb_fecret;

    @FXML
    private Label lb_empleado;

    @FXML
    private Label lb_nomina;

    @FXML
    private Label lb_screen;

    @FXML
    private Label lb_Title;

    @FXML
    private TableView<Asignacion> tb_asigna;

    @FXML
    private TableView<Deduccion> tb_deduc;

    @FXML
    private ValidateTextFieldNumber tf_nroci;

    @FXML
    private TextField tf_buscar;

    @FXML
    private VBox vb_asigna;

    @FXML
    private VBox vb_deduc;

    @FXML
    private VBox vb_form;


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


    private static final String ScreenName = "Aud. x Empleado";
    
    /**
     * Initializes the controller class.
     * @param fxmlFileLocation
     * @param resources
     */     
    @Override // This method is called by the FXMLLoader when initialization is complete
    public void initialize(URL fxmlFileLocation, ResourceBundle resources) {
        assert ap_root != null : "fx:id=\"ap_root\" was not injected: check your FXML file 'Fxml_Aud_Gh_Empleado.fxml'.";
        assert bt_ci != null : "fx:id=\"bt_ci\" was not injected: check your FXML file 'Fxml_Aud_Gh_Empleado.fxml'.";
        assert cb_ano != null : "fx:id=\"cb_ano\" was not injected: check your FXML file 'Fxml_Aud_Gh_Empleado.fxml'.";
        assert cb_empresa != null : "fx:id=\"cb_empresa\" was not injected: check your FXML file 'Fxml_Aud_Gh_Empleado.fxml'.";
        assert cb_ficha != null : "fx:id=\"cb_ficha\" was not injected: check your FXML file 'Fxml_Aud_Gh_Empleado.fxml'.";
        assert cb_mes != null : "fx:id=\"cb_mes\" was not injected: check your FXML file 'Fxml_Aud_Gh_Empleado.fxml'.";
        assert cb_per != null : "fx:id=\"cb_per\" was not injected: check your FXML file 'Fxml_Aud_Gh_Empleado.fxml'.";
        assert hbox_toolbar != null : "fx:id=\"hbox_toolbar\" was not injected: check your FXML file 'Fxml_Aud_Gh_Empleado.fxml'.";
        assert im_tool1 != null : "fx:id=\"im_tool1\" was not injected: check your FXML file 'Fxml_Aud_Gh_Empleado.fxml'.";
        assert im_tool2 != null : "fx:id=\"im_tool2\" was not injected: check your FXML file 'Fxml_Aud_Gh_Empleado.fxml'.";
        assert im_tool3 != null : "fx:id=\"im_tool3\" was not injected: check your FXML file 'Fxml_Aud_Gh_Empleado.fxml'.";
        assert im_tool4 != null : "fx:id=\"im_tool4\" was not injected: check your FXML file 'Fxml_Aud_Gh_Empleado.fxml'.";
        assert im_tool5 != null : "fx:id=\"im_tool5\" was not injected: check your FXML file 'Fxml_Aud_Gh_Empleado.fxml'.";
        assert im_tool6 != null : "fx:id=\"im_tool6\" was not injected: check your FXML file 'Fxml_Aud_Gh_Empleado.fxml'.";
        assert im_tool7 != null : "fx:id=\"im_tool7\" was not injected: check your FXML file 'Fxml_Aud_Gh_Empleado.fxml'.";
        assert im_tool8 != null : "fx:id=\"im_tool8\" was not injected: check your FXML file 'Fxml_Aud_Gh_Empleado.fxml'.";
        assert im_tool9 != null : "fx:id=\"im_tool9\" was not injected: check your FXML file 'Fxml_Aud_Gh_Empleado.fxml'.";
        assert im_tool10 != null : "fx:id=\"im_tool10\" was not injected: check your FXML file 'Fxml_Aud_Gh_Empleado.fxml'.";
        assert im_tool11 != null : "fx:id=\"im_tool11\" was not injected: check your FXML file 'Fxml_Aud_Gh_Empleado.fxml'.";
        assert im_tool12 != null : "fx:id=\"im_tool12\" was not injected: check your FXML file 'Fxml_Aud_Gh_Empleado.fxml'.";
        assert lb_empleado != null : "fx:id=\"lb_empleado\" was not injected: check your FXML file 'Fxml_Aud_Gh_Empleado.fxml'.";
        assert lb_fecret != null : "fx:id=\"lb_fecret\" was not injected: check your FXML file 'Fxml_Aud_Gh_Empleado.fxml'.";
        assert lb_fecing != null : "fx:id=\"lb_fecing\" was not injected: check your FXML file 'Fxml_Aud_Gh_Empleado.fxml'.";
        assert lb_nomina != null : "fx:id=\"lb_nomina\" was not injected: check your FXML file 'Fxml_Aud_Gh_Empleado.fxml'.";
        assert lb_screen != null : "fx:id=\"lb_screen\" was not injected: check your FXML file 'Fxml_Aud_Gh_Empleado.fxml'.";
        assert lb_Title != null : "fx:id=\"lb_Title\" was not injected: check your FXML file 'Fxml_Aud_Gh_Empleado.fxml'.";
        assert vb_asigna != null : "fx:id=\"vb_asigna\" was not injected: check your FXML file 'Fxml_Aud_Gh_Empleado.fxml'.";
        assert vb_deduc != null : "fx:id=\"vb_deduc\" was not injected: check your FXML file 'Fxml_Aud_Gh_Empleado.fxml'.";
        assert vb_form != null : "fx:id=\"vb_form\" was not injected: check your FXML file 'Fxml_Aud_Gh_Empleado.fxml'.";
        assert tb_asigna != null : "fx:id=\"tb_asigna\" was not injected: check your FXML file 'Fxml_Aud_Gh_Empleado.fxml'.";
        assert tb_deduc != null : "fx:id=\"tb_deduc\" was not injected: check your FXML file 'Fxml_Aud_Gh_Empleado.fxml'.";
        assert tf_buscar != null : "fx:id=\"tf_buscar\" was not injected: check your FXML file 'Fxml_Aud_Gh_Empleado.fxml'.";
        assert tf_nroci != null : "fx:id=\"tf_nroci\" was not injected: check your FXML file 'Fxml_Aud_Gh_Empleado.fxml'.";

        //Inicializa la Barra de Herramientas y comportamiento del Boton de Busqueda
        defineToolBar();         
        defineBotonBuscar();    
        init_buttons();     //Establece los comportamientos de los botones
//        botonInicio();      //Se imprime la pantalla Inicio
        
        //

        createTableAsigna();      //Crea e Inicializa la Tabla de Datos   
        createTableDeduc();       //Crea e Inicializa la Tabla de Datos   
        
        loadYear();      
        loadMonth();
                
        refreshForm();                      

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
    private void createTableAsigna(){
        //Se crean y definen las columnas de la Tabla
        TableColumn col_orden       = new TableColumn("#");        
        TableColumn col_nomina      = new TableColumn("Nom.");
        TableColumn col_concepto    = new TableColumn("Concep.");
        TableColumn col_descrip     = new TableColumn("Descripción");
        TableColumn col_tipo        = new TableColumn("Tipo");
        TableColumn col_proceso     = new TableColumn("Proceso");
        TableColumn col_subproceso  = new TableColumn("Sub");
        TableColumn col_cantidad    = new TableColumn("Cant");
        TableColumn col_monto       = new TableColumn("Monto");
        TableColumn col_saldo       = new TableColumn("Saldo");
        
        //Se establece el ancho de cada columna
        this.objectWidth(col_orden          , 22,  22); 
        this.objectWidth(col_nomina         , 44,  44); 
        this.objectWidth(col_concepto       , 50,  50);
        this.objectWidth(col_descrip        , 202, 202); //180
        this.objectWidth(col_tipo           , 44,  44); 
        this.objectWidth(col_proceso        , 202, 202); //180
        this.objectWidth(col_subproceso     , 40,  40);
        this.objectWidth(col_cantidad       , 40,  40); 
        this.objectWidth(col_monto          , 80,  80); 
        this.objectWidth(col_saldo          , 70,  70);

        col_concepto.setCellFactory(new Callback<TableColumn, TableCell>() {
            @Override
            public TableCell call(TableColumn param) {
                return new TableCell<Asignacion, String>() {
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

        col_tipo.setCellFactory(new Callback<TableColumn, TableCell>() {
            @Override
            public TableCell call(TableColumn param) {
                return new TableCell<Asignacion, Integer>() {
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

        col_subproceso.setCellFactory(new Callback<TableColumn, TableCell>() {
            @Override
            public TableCell call(TableColumn param) {
                return new TableCell<Asignacion, Integer>() {
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

        col_cantidad.setCellFactory(new Callback<TableColumn, TableCell>() {
            @Override
            public TableCell call(TableColumn param) {
                return new TableCell<Asignacion, Integer>() {
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

        col_monto.setCellFactory(new Callback<TableColumn, TableCell>() {
            @Override
            public TableCell call(TableColumn param) {
                return new TableCell<Asignacion, Double>() {
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

        col_saldo.setCellFactory(new Callback<TableColumn, TableCell>() {
            @Override
            public TableCell call(TableColumn param) {
                return new TableCell<Asignacion, Double>() {
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

        //Se define la columna de la tabla con el nombre del atributo del objeto USUARIO correspondiente
        col_nomina.setCellValueFactory( 
                new PropertyValueFactory<>("nomina") );
        col_concepto.setCellValueFactory( 
                new PropertyValueFactory<>("concepto") );
        col_descrip.setCellValueFactory( 
                new PropertyValueFactory<>("descto") );
        col_tipo.setCellValueFactory( 
                new PropertyValueFactory<>("tipoProceso") );
        col_proceso.setCellValueFactory( 
                new PropertyValueFactory<>("proceso") );
        col_subproceso.setCellValueFactory( 
                new PropertyValueFactory<>("subproceso") );
        col_cantidad.setCellValueFactory( 
                new PropertyValueFactory<>("cantidad") );
        col_monto.setCellValueFactory( 
                new PropertyValueFactory<>("monto") );
        col_saldo.setCellValueFactory( 
                new PropertyValueFactory<>("saldo") );
        
        //Se Asigna ordenadamente las columnas de la tabla
        tb_asigna.getColumns().addAll(
                col_concepto, col_descrip, col_tipo, col_proceso, 
                col_subproceso, col_cantidad, col_monto, col_saldo
                );                
        
        //Se define el comportamiento de las teclas ARRIBA y ABAJO en la tabla
        EventHandler eh = new EventHandler<KeyEvent>(){
            @Override
            public void handle(KeyEvent ke){
                //Si fue presionado la tecla ARRIBA o ABAJO
                if (ke.getCode().equals(KeyCode.UP) || ke.getCode().equals(KeyCode.DOWN)){     
                    //Selecciona la FILA enfocada
                    //selectedRowGuide();
                }
            }
        };
        //Se Asigna el comportamiento para que se ejecute cuando se suelta una tecla
        tb_asigna.setOnKeyReleased(eh);    

    }
    
    /**
    * Metodo encargado de Crear e inicializar la Tabla de Datos
    */
    private void createTableDeduc(){
        //Se crean y definen las columnas de la Tabla
        TableColumn col_orden       = new TableColumn("#");        
        TableColumn col_nomina      = new TableColumn("Nom.");
        TableColumn col_concepto    = new TableColumn("Concep.");
        TableColumn col_descrip     = new TableColumn("Descripción");
        TableColumn col_tipo        = new TableColumn("Tipo");
        TableColumn col_proceso     = new TableColumn("Proceso");
        TableColumn col_subproceso  = new TableColumn("Sub");
        TableColumn col_cantidad    = new TableColumn("Cant");
        TableColumn col_monto       = new TableColumn("Monto");
        TableColumn col_saldo       = new TableColumn("Saldo");
        
        //Se establece el ancho de cada columna
        this.objectWidth(col_orden          , 22,  22); 
        this.objectWidth(col_nomina         , 44,  44); 
        this.objectWidth(col_concepto       , 50,  50);
        this.objectWidth(col_descrip        , 202, 202); //180
        this.objectWidth(col_tipo           , 44,  44); 
        this.objectWidth(col_proceso        , 202, 202); //180
        this.objectWidth(col_subproceso     , 40,  40);
        this.objectWidth(col_cantidad       , 40,  40); 
        this.objectWidth(col_monto          , 70,  70); 
        this.objectWidth(col_saldo          , 80,  80);

        col_concepto.setCellFactory(new Callback<TableColumn, TableCell>() {
            @Override
            public TableCell call(TableColumn param) {
                return new TableCell<Asignacion, String>() {
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

        col_tipo.setCellFactory(new Callback<TableColumn, TableCell>() {
            @Override
            public TableCell call(TableColumn param) {
                return new TableCell<Asignacion, Integer>() {
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

        col_subproceso.setCellFactory(new Callback<TableColumn, TableCell>() {
            @Override
            public TableCell call(TableColumn param) {
                return new TableCell<Asignacion, Integer>() {
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

        col_cantidad.setCellFactory(new Callback<TableColumn, TableCell>() {
            @Override
            public TableCell call(TableColumn param) {
                return new TableCell<Asignacion, Integer>() {
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

        col_monto.setCellFactory(new Callback<TableColumn, TableCell>() {
            @Override
            public TableCell call(TableColumn param) {
                return new TableCell<Asignacion, Double>() {
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

        col_saldo.setCellFactory(new Callback<TableColumn, TableCell>() {
            @Override
            public TableCell call(TableColumn param) {
                return new TableCell<Asignacion, Double>() {
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

        //Se define la columna de la tabla con el nombre del atributo del objeto USUARIO correspondiente
        col_nomina.setCellValueFactory( 
                new PropertyValueFactory<>("nomina") );
        col_concepto.setCellValueFactory( 
                new PropertyValueFactory<>("concepto") );
        col_descrip.setCellValueFactory( 
                new PropertyValueFactory<>("descto") );
        col_tipo.setCellValueFactory( 
                new PropertyValueFactory<>("tipoProceso") );
        col_proceso.setCellValueFactory( 
                new PropertyValueFactory<>("proceso") );
        col_subproceso.setCellValueFactory( 
                new PropertyValueFactory<>("subproceso") );
        col_cantidad.setCellValueFactory( 
                new PropertyValueFactory<>("cantidad") );
        col_monto.setCellValueFactory( 
                new PropertyValueFactory<>("monto") );
        col_saldo.setCellValueFactory( 
                new PropertyValueFactory<>("saldo") );
        
        //Se Asigna ordenadamente las columnas de la tabla
        tb_deduc.getColumns().addAll(
                col_concepto, col_descrip, col_tipo, col_proceso, 
                col_subproceso, col_cantidad, col_monto, col_saldo
                );                
        
        //Se define el comportamiento de las teclas ARRIBA y ABAJO en la tabla
        EventHandler eh = new EventHandler<KeyEvent>(){
            @Override
            public void handle(KeyEvent ke){
                //Si fue presionado la tecla ARRIBA o ABAJO
                if (ke.getCode().equals(KeyCode.UP) || ke.getCode().equals(KeyCode.DOWN)){     
                    //Selecciona la FILA enfocada
                    //selectedRowGuide();
                }
            }
        };
        //Se Asigna el comportamiento para que se ejecute cuando se suelta una tecla
        tb_deduc.setOnKeyReleased(eh);    

    }

    /**
     * Procedimiento de llenado de datos en la tabla de datos
     */
    private void loadYear(){
//        Date currentTime = localCalendar.getTime();
//        int currentDay = localCalendar.get(Calendar.DATE);
//        int currentMonth = localCalendar.get(Calendar.MONTH) + 1;
//        int currentYear = localCalendar.get(Calendar.YEAR);
//        int currentDayOfWeek = localCalendar.get(Calendar.DAY_OF_WEEK);
//        int currentDayOfMonth = localCalendar.get(Calendar.DAY_OF_MONTH);
//        int CurrentDayOfYear = localCalendar.get(Calendar.DAY_OF_YEAR);

        Calendar localCalendar = Calendar.getInstance(TimeZone.getDefault());

        final ObservableList<Integer> data = FXCollections.observableArrayList();
        for (int i = localCalendar.get(Calendar.YEAR); i >= 2007; i--) {
            data.addAll(i);
        }
        cb_ano.setItems(data);    
        //cb_ano.getSelectionModel().selectFirst();
    }    
    /**
     * Procedimiento de llenado de datos en la tabla de datos
     */
    private void loadMonth(){        
        Calendar localCalendar = Calendar.getInstance(TimeZone.getDefault());

        final ObservableList<String> data = FXCollections.observableArrayList();
        for (int i = 12; i >= 1; i--) {
//        for (int i = localCalendar.get(Calendar.MONTH) + 1; i >= 1; i--) {
            switch (i){
                case 1:
                    data.add("Enero");
                    break;
                case 2:
                    data.add("Febrero");
                    break;
                case 3:
                    data.add("Marzo");
                    break;
                case 4:
                    data.add("Abril");
                    break;
                case 5:
                    data.add("Mayo");
                    break;
                case 6:
                    data.add("Junio");
                    break;
                case 7:
                    data.add("Julio");
                    break;
                case 8:
                    data.add("Agosto");
                    break;
                case 9:
                    data.add("Septiembre");
                    break;
                case 10:
                    data.add("Octubre");
                    break;
                case 11:
                    data.add("Noviembre");
                    break;
                case 12:
                    data.add("Diciembre");
                    break;
            }
        }
        cb_mes.setItems(data);    
        //cb_mes.getSelectionModel().select(localCalendar.get(Calendar.MONTH));
    }
    /**
     * Procedimiento de llenado de datos en la tabla de datos
     */
    public void loadFicha(){
        if(!tf_nroci.getText().isEmpty()){
            Empleado[] ficha = Ln.getInstance().loadInfoEmpleado(new Empleado(tf_nroci.getText()));

            final ObservableList<Empleado> data = FXCollections.observableArrayList();
            data.addAll(Arrays.asList(ficha)); 
            cb_ficha.setItems(data);    
            cb_ficha.getSelectionModel().selectLast();
            
            final ObservableList<Empresa> dataEmp = FXCollections.observableArrayList();
            Empresa[] empresas = null;
            switch (data.get(0).getCompania()){
                case "DI":
                    empresas = new Empresa[]{
                        new Empresa("DI","DIGA")
                    };
                    break;
                case "GI":
                    empresas = new Empresa[]{
                        new Empresa("GI","GLOMAR")
                    };
                    break;
            }
            cb_empresa.getItems().clear();
            dataEmp.addAll(Arrays.asList(empresas)); 
            cb_empresa.setItems(dataEmp);    
            cb_empresa.getSelectionModel().selectFirst();    
            
            if (data.size() == 0)
                showInfoEmpleado(null);
        }
    }
    /**
     * Establece los datos del empleado seleccionado en sus campos graficos
     * @param value valor del empleado
     */
    private void showInfoEmpleado(Empleado empleado){
        tb_asigna.setItems(null);
        tb_deduc.setItems(null);
        cb_ano.setValue(null);
        cb_mes.setValue(null);
        cb_per.setValue(null);
                
        if(empleado != null){  
            lb_empleado.setText(empleado.getNombre() + " " + empleado.getApellido());
            lb_fecing.setText(empleado.getIngreso().substring(0, 10));
            if(empleado.getRetiro() != null)
                lb_fecret.setText(empleado.getRetiro().substring(0, 10));
            else
                lb_fecret.setText("Activo");
            lb_nomina.setText(empleado.getNomina());
        }else{      
            lb_empleado.setText("");
            lb_fecing.setText("");
            lb_fecret.setText("");
            lb_nomina.setText("");
        }
    }
    /**
     * Establece los datos del empleado seleccionado en sus campos graficos
     * @param value valor del empleado
     */
    private void showInfoEmpleadoAno(Integer year){
        Empleado ficha = cb_ficha.getSelectionModel().getSelectedItem();
        cb_mes.setValue(null);
        cb_per.setValue(null);

        Asignacion[] asigna = Ln.getInstance().loadAsignacionesXAno(ficha, year);      
        if(asigna != null){  
            final ObservableList<Asignacion> dataa = FXCollections.observableArrayList();
            dataa.addAll(Arrays.asList(asigna)); 
            tb_asigna.setItems(dataa); 
        }
        //Obtiene y llena las tablas con los resultados
        Deduccion[] deduc = Ln.getInstance().loadDeduccionesXAno(ficha, year);
        if(deduc != null){ 
            final ObservableList<Deduccion> datad = FXCollections.observableArrayList();
            datad.addAll(Arrays.asList(deduc)); 
            tb_deduc.setItems(datad);         
        }
    }
    /**
     * Establece los datos del empleado seleccionado en sus campos graficos
     * @param value valor del empleado
     */
    private void showInfoEmpleadoAnoMes(Integer year, String month){
        Empleado ficha = cb_ficha.getSelectionModel().getSelectedItem();
        cb_per.setValue(null);

        Integer imonth = 0;
        switch (month){
            case "Enero":
                imonth = 1;
                break;
            case "Febrero":
                imonth = 2;
                break;
            case "Marzo":
                imonth = 3;
                break;
            case "Abril":
                imonth = 4;
                break;
            case "Mayo":
                imonth = 5;
                break;
            case "Junio":
                imonth = 6;
                break;
            case "Julio":
                imonth = 7;
                break;
            case "Agosto":
                imonth = 8;
                break;
            case "Septiembre":
                imonth = 9;
                break;
            case "Octubre":
                imonth = 10;
                break;
            case "Noviembre":
                imonth = 11;
                break;
            case "Diciembre":
                imonth = 12;
                break;
        }

        Asignacion[] asigna = Ln.getInstance().loadAsignacionesXMes(ficha, year, imonth);      
        if(asigna != null){  
            final ObservableList<Asignacion> dataa = FXCollections.observableArrayList();
            dataa.addAll(Arrays.asList(asigna)); 
            tb_asigna.setItems(dataa); 
        }
        //Obtiene y llena las tablas con los resultados
        Deduccion[] deduc = Ln.getInstance().loadDeduccionesXMes(ficha, year, imonth);
        if(deduc != null){ 
            final ObservableList<Deduccion> datad = FXCollections.observableArrayList();
            datad.addAll(Arrays.asList(deduc)); 
            tb_deduc.setItems(datad);         
        }
        
        if (asigna != null){
            loadPeriodos(ficha.getCedula(), year, imonth);
        }
    }
    /**
     * Se cargan los datos del ComboBox
     * @param cedula
     * @param year
     * @param month 
     */
    private void loadPeriodos(String cedula, Integer year, Integer month){     
        Integer[] nominas = Ln.getInstance().loadPeriodos(cedula, year, month);
        if(nominas != null){
            final ObservableList<Integer> data = FXCollections.observableArrayList();
            data.addAll(Arrays.asList(nominas)); 
            cb_per.setItems(data);    
            cb_per.getSelectionModel().selectFirst();        
        }
    }
    /**
     * Establece los datos del empleado seleccionado en sus campos graficos
     * @param value valor del empleado
     */
    private void showInfoEmpleadoAnoMesPer(Integer year, String month, Integer period){
        Empleado ficha = cb_ficha.getSelectionModel().getSelectedItem();

        Integer imonth = 0;
        switch (month){
            case "Enero":
                imonth = 1;
                break;
            case "Febrero":
                imonth = 2;
                break;
            case "Marzo":
                imonth = 3;
                break;
            case "Abril":
                imonth = 4;
                break;
            case "Mayo":
                imonth = 5;
                break;
            case "Junio":
                imonth = 6;
                break;
            case "Julio":
                imonth = 7;
                break;
            case "Agosto":
                imonth = 8;
                break;
            case "Septiembre":
                imonth = 9;
                break;
            case "Octubre":
                imonth = 10;
                break;
            case "Noviembre":
                imonth = 11;
                break;
            case "Diciembre":
                imonth = 12;
                break;
        }

        Asignacion[] asigna = Ln.getInstance().loadAsignacionesXPeriodo(ficha, year, imonth, period);      
        if(asigna != null){  
            final ObservableList<Asignacion> dataa = FXCollections.observableArrayList();
            dataa.addAll(Arrays.asList(asigna)); 
            tb_asigna.setItems(dataa); 
        }
        //Obtiene y llena las tablas con los resultados
        Deduccion[] deduc = Ln.getInstance().loadDeduccionesXPeriodo(ficha, year, imonth, period);
        if(deduc != null){ 
            final ObservableList<Deduccion> datad = FXCollections.observableArrayList();
            datad.addAll(Arrays.asList(deduc)); 
            tb_deduc.setItems(datad);         
        }
    }
    /**
     * Procedimiento encargado de refrescar el formulario de la pantalla,
     * establece nuevos valores a cada campo de Texto
     */
    private void refreshForm(){        
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

                //SE PERMITE: NUEVO, CANCELAR Y BUSCAR
                disables = new Integer[]{2,6,7,8,9,10};
                disableAllToolBar(disables); 
                break;
            case 1:  //NUEVO
                lb_Title.setText("NUEVO");

                //SE PERMITE: NUEVO,GUARDAR Y CANCELAR             
                disables = new Integer[]{0,1,3,4,6,7,8,9,10,11};
                disableAllToolBar(disables);                            
                break;
            case 2:  //EDITAR
                lb_Title.setText("EDITAR");
                
                //SE PERMITE: EDITAR,GUARDAR Y CANCELAR
                disables = new Integer[]{0,1,3,4,6,7,8,9,10,11};
                disableAllToolBar(disables);            
                break;
            case 3:  //GUARDAR

                //SE PERMITE: GUARDAR Y CANCELAR
                disables = new Integer[]{0,1,3,4,6,7,8,9,10,11};
                disableAllToolBar(disables);   
                break;
            case 4:  //CAMBIAR STATUS 

                //SE PERMITE: GUARDAR,CAMBIO STATUS Y CANCELAR
                disables = new Integer[]{0,1,2,4,6,7,8,9,10,11};
                disableAllToolBar(disables); 
                break;
        }        
        init_FocusArray(tipoOperacion);       
        Gui.getInstance().setTipoOperacion(tipoOperacion);
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
                    tf_nroci, cb_ficha, cb_empresa, 
                    cb_ano, cb_mes, cb_per};
                break;
            case 1:     //NUEVO
                nodos = new Node[]{
                    tf_nroci, cb_ficha, cb_empresa, 
                    cb_ano, cb_mes, cb_per};
                break;
            case 2:     //EDITAR
                nodos = new Node[]{
                    tf_nroci, cb_ficha, cb_empresa, 
                    cb_ano, cb_mes, cb_per};
                break;
        }             
        switch (opc){
            case 0: 
            case 1: 
            case 2: 
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
            "Sin Asignar ",
            "Imprimir " + ScreenName + " ",
            "Cancelar ",
            "Sin Asignar ",
            "Sin Asignar ",
            "Sin Asignar ",
            "Sin Asignar",
            "Sin Asignar",
            "Buscar " + ScreenName + " "
            };
        //se asigna la etiqueta a su respectivo boton
        for (int i = 0; i < tools.length; i++) {            
            Tooltip tip_tool = new Tooltip(tooltips[i]);
            Tooltip.install(tools[i], tip_tool);
        }
        
        im_tool1.setVisible(false);
        im_tool2.setVisible(false);
        im_tool3.setVisible(false);
        im_tool4.setVisible(false);
        im_tool6.setVisible(false);
        im_tool7.setVisible(false);
        im_tool8.setVisible(false);
        im_tool9.setVisible(false);
        im_tool10.setVisible(false);
        im_tool11.setVisible(false);
        im_tool12.setVisible(false);
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
                    }
                }
            }
        };
        //Se asigna el manejador a ejecutarse cuando se suelta una tecla
    }        

    private void init_buttons(){
        /**
         * SELECCION EN LA TABLA
         */
        tb_asigna.setOnMouseClicked((MouseEvent mouseEvent) -> {
            if(mouseEvent.getButton().equals(MouseButton.PRIMARY)){
                if(mouseEvent.getClickCount() > 0){
                    //selectedRowAlmm();
                }
            }
        });        
        /**
         * SELECCION EN LA TABLA
         */
        tb_deduc.setOnMouseClicked((MouseEvent mouseEvent) -> {
            if(mouseEvent.getButton().equals(MouseButton.PRIMARY)){
                if(mouseEvent.getClickCount() > 0){
                    //selectedRowAlmm();
                }
            }
        });        
        /**
         * BOTON NUEVO
         */
        im_tool1.setOnMouseClicked((MouseEvent mouseEvent) -> {
            if(mouseEvent.getButton().equals(MouseButton.PRIMARY)){
                if(mouseEvent.getClickCount() > 0){
                    //
                }
            }
        });
        /**
         * BOTON EDITAR
         */
        im_tool2.setOnMouseClicked((MouseEvent mouseEvent) -> {
            if(mouseEvent.getButton().equals(MouseButton.PRIMARY)){
                if(mouseEvent.getClickCount() > 0){
                    //
                }
            }
        });
        /**
         * BOTON GUARDAR
         */
        im_tool3.setOnMouseClicked((MouseEvent mouseEvent) -> {
            if(mouseEvent.getButton().equals(MouseButton.PRIMARY)){
                if(mouseEvent.getClickCount() > 0){
                    //
                }
            }
        });        
        /**
         * BOTON ELIMINAR
         */
        im_tool4.setOnMouseClicked((MouseEvent mouseEvent) -> {
            if(mouseEvent.getButton().equals(MouseButton.PRIMARY)){
                if(mouseEvent.getClickCount() > 0){
                    //
                }
            }
        });
        /**
         * BOTON IMPRIMIR
         */
        im_tool5.setOnMouseClicked((MouseEvent mouseEvent) -> {
            if(mouseEvent.getButton().equals(MouseButton.PRIMARY)){
                if(mouseEvent.getClickCount() > 0){   
                    //botonImprimir();
                }
            }
        });
        /**
         * BOTON REGRESAR
         */
        im_tool6.setOnMouseClicked((MouseEvent mouseEvent) -> {
            if(mouseEvent.getButton().equals(MouseButton.PRIMARY)){
                if(mouseEvent.getClickCount() > 0){
                    //
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
                if(mouseEvent.getClickCount() > 0){
                    //
                }
            }
        });
         /**
         * metodo para mostrar buscar el nro de guia
         * param: ENTER O TAB
         */
        tf_nroci.setOnKeyReleased((KeyEvent ke) -> {
            if (ke.getCode().equals(KeyCode.ENTER)){
                //Valida que el evento se haya generado en el campo de busqueda
                if(((Node)ke.getSource()).getId().equals("tf_nroci")){
                    //Solicita los datos y envia la Respuesta a imprimirse en la Pantalla
                    loadFicha();
                }
            }
        });
        /**
         * BOTON CHOFER
         */
        bt_ci.setOnMouseClicked((MouseEvent mouseEvent) -> {
            if(mouseEvent.getButton().equals(MouseButton.PRIMARY)){
                if(mouseEvent.getClickCount() > 0){
                    Datos.setIdButton(7001021);
                    Gui.getInstance().showBusqueda("Empleado");  
                }
            }
        });
        /**
         * metodo para mostrar el item (estado) seleccionado y cargar las ciudades
         * param: nombre del estado
         */
        cb_ficha.getSelectionModel().selectedItemProperty().addListener((ObservableValue<? extends Empleado> arg0, Empleado arg1, Empleado arg2) -> {
            if (arg2 != null)
                showInfoEmpleado(cb_ficha.getValue());
        });
        /**
         * metodo para mostrar el item (estado) seleccionado y cargar las ciudades
         * param: nombre del estado
         */
        cb_ano.getSelectionModel().selectedItemProperty().addListener((ObservableValue<? extends Integer> arg0, Integer arg1, Integer arg2) -> {
            if (arg2 != null)
                showInfoEmpleadoAno(cb_ano.getValue());
        });
        /**
         * metodo para mostrar el item (estado) seleccionado y cargar las ciudades
         * param: nombre del estado
         */
        cb_mes.getSelectionModel().selectedItemProperty().addListener((ObservableValue<? extends String> arg0, String arg1, String arg2) -> {
            if (arg2 != null)
                showInfoEmpleadoAnoMes(cb_ano.getValue(), cb_mes.getValue());
        });
        /**
         * metodo para mostrar el item (estado) seleccionado y cargar las ciudades
         * param: nombre del estado
         */
        cb_per.getSelectionModel().selectedItemProperty().addListener((ObservableValue<? extends Integer> arg0, Integer arg1, Integer arg2) -> {
            if (arg2 != null)
                showInfoEmpleadoAnoMesPer(cb_ano.getValue(), cb_mes.getValue(), cb_per.getValue());
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
            //im_check.setImage(new Image(getClass().getResourceAsStream("/Images/img06.png")));
        }else{      //IMAGEN PARA LA BUSQUEDA DE UN VEHICULO
            //im_check.setImage(new Image(getClass().getResourceAsStream("/Images/img34.png")));
        }
    }
    /**
     * Metodo que permite cambiar la imagen del boton CheckUserSupplier
     * @param boo TRUE si el VEHICULO esta validado
     */
    private void change_im_val(int boo){
        // 200 HTTP_request Ok
        if(boo == 200){    //IMAGEN SI EL VEHICULO ES CORRECTO
            //im_val.setImage(new Image(getClass().getResourceAsStream("/Images/img57a.png")));
        }else{      //IMAGEN PARA LA BUSQUEDA DE UN VEHICULO
            //im_val.setImage(new Image(getClass().getResourceAsStream("/Images/img61a.png")));
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
            //vb_table.relocate(30, 439);
            //vb_table.setPrefHeight(133);
        }else{
            //vb_table.relocate(30, 64);
            //vb_table.setPrefHeight(508);
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
