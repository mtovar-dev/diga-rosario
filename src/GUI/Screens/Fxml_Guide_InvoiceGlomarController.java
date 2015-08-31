/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Screens;

import GUI.Gui;
import LN.Ln;
import Listeners.FocusPropertyChangeListener;
import Objects.log_CGuias_Glomar_invoice;
import Objects.log_CGuias_Glomar_price;
import Tools.Datos;
import java.math.RoundingMode;
import java.net.URL;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.TimeZone;
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
public class Fxml_Guide_InvoiceGlomarController implements Initializable {

    @FXML
    private AnchorPane ap_root;

    @FXML 
    private Button bt_execute; 

    @FXML
    private ComboBox<Integer> cb_ano;

    @FXML
    private ComboBox<String> cb_mes;

    @FXML
    private DatePicker dp_fecha1;
    
    @FXML
    private DatePicker dp_fecha2;
    
    @FXML
    private HBox hb_1;    
    
    @FXML
    private HBox hbox_toolbar;

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
    private Label lb_mensj;

    @FXML
    private Label lb_screen;

    @FXML
    private Label lb_Title;

    @FXML
    private RadioButton rb_quality1;
    
    @FXML
    private RadioButton rb_quality2;
    
    @FXML
    private RadioButton rb_quality3;
    
    @FXML
    private TableView<log_CGuias_Glomar_price> tb_price;

    @FXML
    private TableView<log_CGuias_Glomar_invoice> tb_invoice;

    @FXML
    private TextField tf_buscar;

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

    private static DateTimeFormatter dtf_yyyy = DateTimeFormatter.ofPattern("yyyy/MM/dd");

    private static JasperReport jReport = null;
    private static JasperViewer jview = null;
    private static JasperPrint jPrint = null;
    
    private static JRBeanCollectionDataSource JRDs = null;
    
    final ToggleGroup rb_group = new ToggleGroup();

    
    private static int tipoOperacion;    
    private static ImageView[] tools;    
    private static Integer[] toolsConfig;    
    private static String[] tooltips;

    private static int numGuias         = 0; 
    
    private static final String ScreenName = "Facturación de Carga";
    
    /**
     * Initializes the controller class.
     * @param fxmlFileLocation
     * @param resources
     */     
    @Override // This method is called by the FXMLLoader when initialization is complete
    public void initialize(URL fxmlFileLocation, ResourceBundle resources) {
        assert ap_root != null : "fx:id=\"ap_root\" was not injected: check your FXML file 'Fxml_InvoiceGlomarController.fxml'.";
        assert bt_execute != null : "fx:id=\"bt_execute\" was not injected: check your FXML file 'Fxml_InvoiceGlomarController.fxml'.";
        assert cb_ano != null : "fx:id=\"cb_ano\" was not injected: check your FXML file 'Fxml_InvoiceGlomarController.fxml'.";
        assert cb_mes != null : "fx:id=\"cb_mes\" was not injected: check your FXML file 'Fxml_InvoiceGlomarController.fxml'.";
        assert dp_fecha1 != null : "fx:id=\"dt_fecha1\" was not injected: check your FXML file 'Fxml_InvoiceGlomarController.fxml'.";
        assert dp_fecha2 != null : "fx:id=\"dt_fecha2\" was not injected: check your FXML file 'Fxml_InvoiceGlomarController.fxml'.";
        assert hb_1 != null : "fx:id=\"hb_1\" was not injected: check your FXML file 'Fxml_InvoiceGlomarController.fxml'.";
        assert hbox_toolbar != null : "fx:id=\"hbox_toolbar\" was not injected: check your FXML file 'Fxml_InvoiceGlomarController.fxml'.";
        assert im_tool1 != null : "fx:id=\"im_tool1\" was not injected: check your FXML file 'Fxml_InvoiceGlomarController.fxml'.";
        assert im_tool10 != null : "fx:id=\"im_tool10\" was not injected: check your FXML file 'Fxml_InvoiceGlomarController.fxml'.";
        assert im_tool11 != null : "fx:id=\"im_tool11\" was not injected: check your FXML file 'Fxml_InvoiceGlomarController.fxml'.";
        assert im_tool12 != null : "fx:id=\"im_tool12\" was not injected: check your FXML file 'Fxml_InvoiceGlomarController.fxml'.";
        assert im_tool2 != null : "fx:id=\"im_tool2\" was not injected: check your FXML file 'Fxml_InvoiceGlomarController.fxml'.";
        assert im_tool3 != null : "fx:id=\"im_tool3\" was not injected: check your FXML file 'Fxml_InvoiceGlomarController.fxml'.";
        assert im_tool4 != null : "fx:id=\"im_tool4\" was not injected: check your FXML file 'Fxml_InvoiceGlomarController.fxml'.";
        assert im_tool5 != null : "fx:id=\"im_tool5\" was not injected: check your FXML file 'Fxml_InvoiceGlomarController.fxml'.";
        assert im_tool6 != null : "fx:id=\"im_tool6\" was not injected: check your FXML file 'Fxml_InvoiceGlomarController.fxml'.";
        assert im_tool7 != null : "fx:id=\"im_tool7\" was not injected: check your FXML file 'Fxml_InvoiceGlomarController.fxml'.";
        assert im_tool8 != null : "fx:id=\"im_tool8\" was not injected: check your FXML file 'Fxml_InvoiceGlomarController.fxml'.";
        assert im_tool9 != null : "fx:id=\"im_tool9\" was not injected: check your FXML file 'Fxml_InvoiceGlomarController.fxml'.";
        assert lb_screen != null : "fx:id=\"lb_screen\" was not injected: check your FXML file 'Fxml_InvoiceGlomarController.fxml'.";
        assert lb_Title != null : "fx:id=\"lb_Title\" was not injected: check your FXML file 'Fxml_InvoiceGlomarController.fxml'.";
        assert rb_quality1 != null : "fx:id=\"rb_quality1\" was not injected: check your FXML file 'Fxml_InvoiceGlomarController.fxml'."; 
        assert rb_quality2 != null : "fx:id=\"rb_quality2\" was not injected: check your FXML file 'Fxml_InvoiceGlomarController.fxml'."; 
        assert rb_quality3 != null : "fx:id=\"rb_quality3\" was not injected: check your FXML file 'Fxml_InvoiceGlomarController.fxml'."; 
        assert tb_price != null : "fx:id=\"tb_price\" was not injected: check your FXML file 'Fxml_InvoiceGlomarController.fxml'.";
        assert tb_invoice != null : "fx:id=\"tb_invoice\" was not injected: check your FXML file 'Fxml_InvoiceGlomarController.fxml'.";
        assert tf_buscar != null : "fx:id=\"tf_pcarga\" was not injected: check your FXML file 'Fxml_InvoiceGlomarController.fxml'.";
        assert vb_form != null : "fx:id=\"vb_form\" was not injected: check your FXML file 'Fxml_InvoiceGlomarController.fxml'.";
        assert vb_table != null : "fx:id=\"vb_table\" was not injected: check your FXML file 'Fxml_InvoiceGlomarController.fxml'.";

        //Inicializa la Barra de Herramientas y comportamiento del Boton de Busqueda
        defineToolBar();         
        defineBotonBuscar();    
        init_buttons(); //Establece los comportamientos de los botones
        botonInicio();  //Se imprime la pantalla Inicio

        loadYear();      
        loadMonth();
        createTablePrice();
        createTableInvoice();

        rb_quality1.setToggleGroup(rb_group);
        rb_quality2.setToggleGroup(rb_group);
        rb_quality3.setToggleGroup(rb_group);
        
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
     * Procedimiento de llenado de datos en la tabla de datos
     */
    private void loadYear(){
        Calendar localCalendar = Calendar.getInstance(TimeZone.getDefault());

        final ObservableList<Integer> data = FXCollections.observableArrayList();
        for (int i = localCalendar.get(Calendar.YEAR); i >= 2015; i--) {
            data.addAll(i);
        }
        cb_ano.setItems(data);    
    }    
    /**
     * Procedimiento de llenado de datos en la tabla de datos
     */
    private void loadMonth(){        
        Calendar localCalendar = Calendar.getInstance(TimeZone.getDefault());

        final ObservableList<String> data = FXCollections.observableArrayList();
        for (int i = 12; i >= 1; i--) {
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
    }
    /**
    * Metodo encargado de Crear e inicializar la Tabla de Datos
    */
    private void createTablePrice(){
        //Se crean y definen las columnas de la Tabla
        TableColumn col_code        = new TableColumn("Código");
        TableColumn col_zonglomar   = new TableColumn("Zona");                
        TableColumn col_monpeq      = new TableColumn("Peq");        
        TableColumn col_mongra      = new TableColumn("Gra");
        TableColumn col_mtogan      = new TableColumn("Gan");        
        
        //Se establece el ancho de cada columna
        this.objectWidth(col_code           , 60, 60);  
        this.objectWidth(col_zonglomar      , 110, 110); 
        this.objectWidth(col_monpeq         , 60,  60);  
        this.objectWidth(col_mongra         , 60,  60);  
        this.objectWidth(col_mtogan         , 60,  60);  

        col_code.setCellFactory(new Callback<TableColumn, TableCell>() {
            @Override
            public TableCell call(TableColumn param) {
                return new TableCell<log_CGuias_Glomar_price, String>() {
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

        col_monpeq.setCellFactory(new Callback<TableColumn, TableCell>() {
            @Override
            public TableCell call(TableColumn param) {
                return new TableCell<log_CGuias_Glomar_price, Double>() {
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
                            df.setMinimumFractionDigits(0);
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

        col_mongra.setCellFactory(new Callback<TableColumn, TableCell>() {
            @Override
            public TableCell call(TableColumn param) {
                return new TableCell<log_CGuias_Glomar_price, Double>() {
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
                            df.setMinimumFractionDigits(0);
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

        col_mtogan.setCellFactory(new Callback<TableColumn, TableCell>() {
            @Override
            public TableCell call(TableColumn param) {
                return new TableCell<log_CGuias_Glomar_price, Double>() {
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
                            df.setMinimumFractionDigits(0);
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
        col_code.setCellValueFactory( 
                new PropertyValueFactory<>("codigo") );
        col_zonglomar.setCellValueFactory( 
                new PropertyValueFactory<>("zonGlomar") );
        col_monpeq.setCellValueFactory( 
                new PropertyValueFactory<>("vehPeq") );
        col_mongra.setCellValueFactory( 
                new PropertyValueFactory<>("vehGra") );
        col_mtogan.setCellValueFactory( 
                new PropertyValueFactory<>("vehGan") );
        
        //Se Asigna ordenadamente las columnas de la tabla
        tb_price.getColumns().addAll(
                col_code, col_zonglomar, col_monpeq, col_mongra, col_mtogan
                );                
        
        //Se Asigna menu contextual 
        
        //Se define el comportamiento de las teclas ARRIBA y ABAJO en la tabla
        EventHandler eh = new EventHandler<KeyEvent>(){
            @Override
            public void handle(KeyEvent ke){
                //Si fue presionado la tecla ARRIBA o ABAJO
                if (ke.getCode().equals(KeyCode.UP) || ke.getCode().equals(KeyCode.DOWN)){     
                    //Selecciona la FILA enfocada
                    //selectedRowInvoice();
                }
            }
        };
        //Se Asigna el comportamiento para que se ejecute cuando se suelta una tecla
        tb_price.setOnKeyReleased(eh);    
    }
    /**
    * Metodo encargado de Crear e inicializar la Tabla de Datos
    */
    private void createTableInvoice(){
        //Se crean y definen las columnas de la Tabla
        TableColumn col_chofer      = new TableColumn("Chofer");
        TableColumn col_fecha       = new TableColumn("Fecha");                
        TableColumn col_guia        = new TableColumn("Nro. Guia");        
        TableColumn col_destino     = new TableColumn("Destino");
        TableColumn col_placa       = new TableColumn("Nro. Placa");        
        TableColumn col_monguia     = new TableColumn("Mto Guia");
        TableColumn col_mtoflete    = new TableColumn("Mto Flete");        
        
        //Se establece el ancho de cada columna
        this.objectWidth(col_chofer             , 200, 250);  
        this.objectWidth(col_fecha              , 80,  80); 
        this.objectWidth(col_guia               , 80,  80);  
        this.objectWidth(col_destino            , 100, 100);  
        this.objectWidth(col_placa              , 80,  80);  
        this.objectWidth(col_monguia            , 90,  90);  
        this.objectWidth(col_mtoflete           , 90,  90);  

        col_fecha.setCellFactory(new Callback<TableColumn, TableCell>() {
            @Override
            public TableCell call(TableColumn param) {
                return new TableCell<log_CGuias_Glomar_price, String>() {
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

        col_guia.setCellFactory(new Callback<TableColumn, TableCell>() {
            @Override
            public TableCell call(TableColumn param) {
                return new TableCell<log_CGuias_Glomar_price, String>() {
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

        col_placa.setCellFactory(new Callback<TableColumn, TableCell>() {
            @Override
            public TableCell call(TableColumn param) {
                return new TableCell<log_CGuias_Glomar_price, String>() {
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

        col_monguia.setCellFactory(new Callback<TableColumn, TableCell>() {
            @Override
            public TableCell call(TableColumn param) {
                return new TableCell<log_CGuias_Glomar_price, Double>() {
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
                            df.setMinimumFractionDigits(0);
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

        col_mtoflete.setCellFactory(new Callback<TableColumn, TableCell>() {
            @Override
            public TableCell call(TableColumn param) {
                return new TableCell<log_CGuias_Glomar_price, Double>() {
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
                            df.setMinimumFractionDigits(0);
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
        col_chofer.setCellValueFactory( 
                new PropertyValueFactory<>("chofer") );
        col_fecha.setCellValueFactory( 
                new PropertyValueFactory<>("fecha") );
        col_guia.setCellValueFactory( 
                new PropertyValueFactory<>("guia") );
        col_destino.setCellValueFactory( 
                new PropertyValueFactory<>("destino") );
        col_placa.setCellValueFactory( 
                new PropertyValueFactory<>("nroPlaca") );
        col_monguia.setCellValueFactory( 
                new PropertyValueFactory<>("mtoGuia") );
        col_mtoflete.setCellValueFactory( 
                new PropertyValueFactory<>("mtoFlete") );
        
        //Se Asigna ordenadamente las columnas de la tabla
        tb_invoice.getColumns().addAll(
                col_chofer, col_fecha, col_guia, col_destino, col_placa,
                col_monguia, col_mtoflete
                );                
        
        //Se Asigna menu contextual 
        
        //Se define el comportamiento de las teclas ARRIBA y ABAJO en la tabla
        EventHandler eh = new EventHandler<KeyEvent>(){
            @Override
            public void handle(KeyEvent ke){
                //Si fue presionado la tecla ARRIBA o ABAJO
                if (ke.getCode().equals(KeyCode.UP) || ke.getCode().equals(KeyCode.DOWN)){     
                    //Selecciona la FILA enfocada
                    //selectedRowInvoice();
                }
            }
        };
        //Se Asigna el comportamiento para que se ejecute cuando se suelta una tecla
        tb_invoice.setOnKeyReleased(eh);    
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

                //SE PERMITE: NUEVO, CANCELAR Y BUSCAR
                disables = new Integer[]{2,5,6,9,10};
                disableAllToolBar(disables); 
                hb_1.setVisible(true);
                break;
            case 1:  //NUEVO
//                lb_Title.setText("NUEVO");

                //SE PERMITE: NUEVO,GUARDAR Y CANCELAR             
                disables = new Integer[]{0,1,3,4,6,7,8,9,10,11};
                disableAllToolBar(disables);                            
                break;
            case 2:  //EDITAR
//                lb_Title.setText("EDITAR");

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
                disables = new Integer[]{2,5,6,7,8,9,10};
                disableAllToolBar(disables); 
                break;
        }        
        init_FocusArray(tipoOperacion);       
        Gui.getInstance().setTipoOperacion(tipoOperacion);
    }    
    /**
     * Procedimiento que busca en BD la lista de usuarios
     * y los envia a cargar en la tabla
     */
    private void loadPrices(){        
        Datos.setRep_log_cguias_glomar_price(Ln.getInstance().load_Glomar_price());
        loadTablePrice( Datos.getRep_log_cguias_glomar_price());     
    }
    /**
     * Procedimiento de llenado de datos en la tabla de datos
     */
    private void loadTablePrice(log_CGuias_Glomar_price[] glomar_price){    
        if(glomar_price != null){
            ObservableList<log_CGuias_Glomar_price> data = FXCollections.observableArrayList();        
            data.addAll(Arrays.asList(glomar_price));        
            tb_price.setItems(data);        
        }
    } 
    /**
     * Procedimiento de llenado de datos en la tabla de datos
     */
    private void loadTableInvoice(log_CGuias_Glomar_invoice[] glomar_invoice){    
        if(glomar_invoice != null){
            ObservableList<log_CGuias_Glomar_invoice> data = FXCollections.observableArrayList();        
            data.addAll(Arrays.asList(glomar_invoice));        
            tb_invoice.setItems(data);        
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
                    };
                break;
            case 1:     //NUEVO
                nodos = new Node[]{
                    };
                break;
            case 2:     //EDITAR
                nodos = new Node[]{
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
        
        //ima.setImage(new Image(getClass().getResourceAsStream("/Images/img61a.png")));
        Image ima = new Image(getClass().getResourceAsStream("/Images/img46.png"));
//        bt_execute.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("/Images/img46.png"))));
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
        numGuias = 0;
        
        loadToolBar();
        //SE LIMPIA EL FORMULARIO

        tf_buscar.setText("");
        tf_buscar.setVisible(false);
        
        //RECARGA LA TABLA ORIGINAL
        loadPrices();
    }
    /**
     * 
     */
    private void botonNuevo(){
        if(toolsConfig[2]==1){
            tipoOperacion = 1;
            refreshForm();
            setFormVisible(true);
            Gui.getFields()[Gui.getFieldFocused()].requestFocus();
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
//                        result = saveCGuias();
                    break;
                case 2:
                    if(toolsConfig[4]==1)
//                        result = saveCGuias();
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
            //SE LIMPIA EL FORMULARIO
            tf_buscar.setVisible(true);
            tf_buscar.requestFocus();
        }
    }
    /**
     * 
     */
    private void botonImprimir(){
        tipoOperacion = 5;                  //OPERACION SOLO LECTURA

        ObservableList<log_CGuias_Glomar_invoice> data = FXCollections.observableArrayList();
        data.addAll(Datos.getRep_log_cguias_glomar_invoice());   
        JRDs = new JRBeanCollectionDataSource(data, true);

        JrxmlParam.put("p_user", Datos.getSesion().getUsername());

        try{ 
            jReport = (JasperReport) JRLoader.loadObjectFromFile(path + path_rep + "/logistica/log_pre_port_inv_glomar.jasper");
            jPrint = JasperFillManager.fillReport(jReport, JrxmlParam, JRDs);
            jview = new JasperViewer(jPrint, false);
            jview.setTitle("DIGA - Relación de Fletes Despachados (Logistica) ");
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
         * BOTON EXECUTE
         */
        bt_execute.setOnAction((ActionEvent event) -> {
            Integer imonth = 0;
            Integer iquality = 0;

            switch (cb_mes.getValue()){
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
            
            if (rb_quality1.isSelected())
                iquality = 1;

            if (rb_quality2.isSelected())
                iquality = 2;

            if (rb_quality3.isSelected())
                iquality = 3;
            
            Datos.setRep_log_cguias_glomar_invoice(
                Ln.getInstance().find_Glomar_invoice(
                    cb_ano.getValue(), imonth, iquality, 
                    dp_fecha1.getValue().format(dtf_yyyy), dp_fecha2.getValue().format(dtf_yyyy)));
            loadTableInvoice( Datos.getRep_log_cguias_glomar_invoice());     
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
//        if(boo){    //IMAGEN SI EL MEASURE ES CORRECTO
//            im_check.setImage(new Image(getClass().getResourceAsStream("/Images/img06.png")));
//        }else{      //IMAGEN PARA LA BUSQUEDA DE UN MEASURE
//            im_check.setImage(new Image(getClass().getResourceAsStream("/Images/img34.png")));
//        }
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
