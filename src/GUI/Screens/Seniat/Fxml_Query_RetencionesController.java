/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Screens.Seniat;

import GUI.Gui;
import LN.Ln;
import Listeners.FocusPropertyChangeListener;
import Objects.Seniat.UploadExcelFile;
import Objects.log_CGuias;
import Tools.Datos;
import java.io.File;
import java.math.RoundingMode;
import java.net.URL;
import java.sql.Date;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.TimeZone;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
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
 * @author mtovar
 */
public class Fxml_Query_RetencionesController implements Initializable {

    @FXML
    private AnchorPane ap_root;

    @FXML 
    private Button bt_aceptar; 

    @FXML
    private ComboBox<Integer> cb_ano1;

    @FXML
    private ComboBox<Integer> cb_ano2;

    @FXML
    private CheckBox cb_comprob;
    
    @FXML
    private CheckBox cb_difmonto;
    
    @FXML
    private CheckBox cb_difnrodoc;
    
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
    private TableView<UploadExcelFile> tb_query;

    @FXML
    private TextField tf_buscar;

    @FXML
    private TextField tf_rif;

    @FXML
    private TextField tf_nombre;

    @FXML
    private TextField tf_documento;

    @FXML
    private TextField tf_control;

    @FXML
    private TextField tf_mtomay;

    @FXML
    private TextField tf_mtomen;

    @FXML
    private TextField tf_retmay;

    @FXML
    private TextField tf_retmen;

    @FXML
    private TextField tf_difmto;


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

    private static JasperReport jReport = null;
    private static JasperViewer jview = null;
    private static JasperPrint jPrint = null;
    
    private static JRBeanCollectionDataSource JRDs = null;
    
    private static SimpleDateFormat sdf_dd = new SimpleDateFormat("dd/MM/yy"); // Set your date format
    private static DateTimeFormatter dtf_yyyy = DateTimeFormatter.ofPattern("yyyy/MM/dd");
    
    private static int tipoOperacion;    
    private static ImageView[] tools;    
    private static Integer[] toolsConfig;    
    private static String[] tooltips;
    private File file;    

    private static int numGuias         = 0; 
    
    private static final ObservableList<UploadExcelFile> sqlexcel = FXCollections.observableArrayList();

    private static final String ScreenName = "Informe de Carga";
    
    /**
     * Initializes the controller class.
     * @param fxmlFileLocation
     * @param resources
     */     
    @Override // This method is called by the FXMLLoader when initialization is complete
    public void initialize(URL fxmlFileLocation, ResourceBundle resources) {
        assert ap_root != null : "fx:id=\"ap_root\" was not injected: check your FXML file 'Fxml_Query_RetencionesController.fxml'.";
        assert bt_aceptar != null : "fx:id=\"bt_aceptar\" was not injected: check your FXML file 'Fxml_Query_RetencionesController.fxml'.";
        assert cb_ano1 != null : "fx:id=\"cb_ano1\" was not injected: check your FXML file 'Fxml_Query_RetencionesController.fxml'.";
        assert cb_ano2 != null : "fx:id=\"cb_ano2\" was not injected: check your FXML file 'Fxml_Query_RetencionesController.fxml'.";
        assert cb_comprob != null : "fx:id=\"cb_comprob\" was not injected: check your FXML file 'Fxml_Query_RetencionesController.fxml'.";
        assert cb_difmonto != null : "fx:id=\"cb_difmonto\" was not injected: check your FXML file 'Fxml_Query_RetencionesController.fxml'.";
        assert cb_difnrodoc != null : "fx:id=\"cb_difnrodoc\" was not injected: check your FXML file 'Fxml_Query_RetencionesController.fxml'.";
        assert dp_fecha1 != null : "fx:id=\"dt_fecha1\" was not injected: check your FXML file 'Fxml_Query_RetencionesController.fxml'.";
        assert dp_fecha2 != null : "fx:id=\"dt_fecha2\" was not injected: check your FXML file 'Fxml_Query_RetencionesController.fxml'.";
        assert hb_1 != null : "fx:id=\"hb_1\" was not injected: check your FXML file 'Fxml_Query_RetencionesController.fxml'.";
        assert hbox_toolbar != null : "fx:id=\"hbox_toolbar\" was not injected: check your FXML file 'Fxml_Query_RetencionesController.fxml'.";
        assert im_tool1 != null : "fx:id=\"im_tool1\" was not injected: check your FXML file 'Fxml_Query_RetencionesController.fxml'.";
        assert im_tool10 != null : "fx:id=\"im_tool10\" was not injected: check your FXML file 'Fxml_Query_RetencionesController.fxml'.";
        assert im_tool11 != null : "fx:id=\"im_tool11\" was not injected: check your FXML file 'Fxml_Query_RetencionesController.fxml'.";
        assert im_tool12 != null : "fx:id=\"im_tool12\" was not injected: check your FXML file 'Fxml_Query_RetencionesController.fxml'.";
        assert im_tool2 != null : "fx:id=\"im_tool2\" was not injected: check your FXML file 'Fxml_Query_RetencionesController.fxml'.";
        assert im_tool3 != null : "fx:id=\"im_tool3\" was not injected: check your FXML file 'Fxml_Query_RetencionesController.fxml'.";
        assert im_tool4 != null : "fx:id=\"im_tool4\" was not injected: check your FXML file 'Fxml_Query_RetencionesController.fxml'.";
        assert im_tool5 != null : "fx:id=\"im_tool5\" was not injected: check your FXML file 'Fxml_Query_RetencionesController.fxml'.";
        assert im_tool6 != null : "fx:id=\"im_tool6\" was not injected: check your FXML file 'Fxml_Query_RetencionesController.fxml'.";
        assert im_tool7 != null : "fx:id=\"im_tool7\" was not injected: check your FXML file 'Fxml_Query_RetencionesController.fxml'.";
        assert im_tool8 != null : "fx:id=\"im_tool8\" was not injected: check your FXML file 'Fxml_Query_RetencionesController.fxml'.";
        assert im_tool9 != null : "fx:id=\"im_tool9\" was not injected: check your FXML file 'Fxml_Query_RetencionesController.fxml'.";
        assert lb_mensj != null : "fx:id=\"lb_mensj\" was not injected: check your FXML file 'Fxml_Query_RetencionesController.fxml'.";
        assert lb_screen != null : "fx:id=\"lb_screen\" was not injected: check your FXML file 'Fxml_Query_RetencionesController.fxml'.";
        assert lb_Title != null : "fx:id=\"lb_Title\" was not injected: check your FXML file 'Fxml_Query_RetencionesController.fxml'.";
        assert tf_buscar != null : "fx:id=\"tf_buscar\" was not injected: check your FXML file 'Fxml_Query_RetencionesController.fxml'.";
        assert tf_rif != null : "fx:id=\"tf_rif\" was not injected: check your FXML file 'Fxml_Query_RetencionesController.fxml'.";
        assert tf_nombre != null : "fx:id=\"tf_nombre\" was not injected: check your FXML file 'Fxml_Query_RetencionesController.fxml'.";
        assert tf_documento != null : "fx:id=\"tf_documento\" was not injected: check your FXML file 'Fxml_Query_RetencionesController.fxml'.";
        assert tf_control != null : "fx:id=\"tf_control\" was not injected: check your FXML file 'Fxml_Query_RetencionesController.fxml'.";
        assert tf_mtomay != null : "fx:id=\"tf_mtomay\" was not injected: check your FXML file 'Fxml_Query_RetencionesController.fxml'.";
        assert tf_mtomen != null : "fx:id=\"tf_mtomen\" was not injected: check your FXML file 'Fxml_Query_RetencionesController.fxml'.";
        assert tf_retmay != null : "fx:id=\"tf_retmay\" was not injected: check your FXML file 'Fxml_Query_RetencionesController.fxml'.";
        assert tf_retmen != null : "fx:id=\"tf_retmen\" was not injected: check your FXML file 'Fxml_Query_RetencionesController.fxml'.";
        assert tf_difmto != null : "fx:id=\"tf_difmto\" was not injected: check your FXML file 'Fxml_Query_RetencionesController.fxml'.";
        assert vb_form != null : "fx:id=\"vb_form\" was not injected: check your FXML file 'Fxml_Query_RetencionesController.fxml'.";
        assert vb_table != null : "fx:id=\"vb_table\" was not injected: check your FXML file 'Fxml_Query_RetencionesController.fxml'.";

        //Inicializa la Barra de Herramientas y comportamiento del Boton de Busqueda
        defineToolBar();         
        defineBotonBuscar();    
        init_buttons(); //Establece los comportamientos de los botones
        botonInicio();  //Se imprime la pantalla Inicio

        loadYear();      
        createTableQuery();

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
        for (int i = localCalendar.get(Calendar.YEAR); i >= 2003; i--) {
            data.addAll(i);
        }
        cb_ano1.setItems(data);    
        cb_ano1.getSelectionModel().selectFirst();    

        cb_ano2.setItems(data);    
        cb_ano2.getSelectionModel().selectFirst();    
    }    
    /**
    * Metodo encargado de Crear e inicializar la Tabla de Datos
    */
    private void createTableQuery(){
        //Se crean y definen las columnas de la Tabla
        TableColumn col_orden       = new TableColumn("#");
        TableColumn col_ano         = new TableColumn("Año");
        TableColumn col_mes         = new TableColumn("Mes");                
        TableColumn col_comprob     = new TableColumn("Comprobante");        
        TableColumn col_archivo     = new TableColumn("Archivo");        
        TableColumn col_rif         = new TableColumn("Rif");        
        TableColumn col_nombre      = new TableColumn("Nombre");
        TableColumn col_fecha       = new TableColumn("Fecha");
        TableColumn col_tipodoc     = new TableColumn("T/Doc");                
        TableColumn col_mtodoc1     = new TableColumn("Monto Doc");        
        TableColumn col_mtodoc2     = new TableColumn("Monto Doc");        
        TableColumn col_mtoret1     = new TableColumn("Reten. Seniat");        
        TableColumn col_mtoret2     = new TableColumn("Retenido");        
        TableColumn col_mtoret3     = new TableColumn("Reten. Diga");        
        TableColumn col_mtoexe1     = new TableColumn("Exento");        
        TableColumn col_mtoexe2     = new TableColumn("Exento");        
        TableColumn col_nrodoc      = new TableColumn("Documento");        
        TableColumn col_control     = new TableColumn("Control");
        TableColumn col_nrodocafec  = new TableColumn("Doc. Afec.");
        TableColumn col_alicuota    = new TableColumn("Alicuota");
        
        //Se establece el ancho de cada columna
        this.objectWidth(col_orden          , 40,   40);  
        this.objectWidth(col_ano            , 40,   40); 
        this.objectWidth(col_mes            , 30,   30); 
        this.objectWidth(col_comprob        , 100,  100); 
        this.objectWidth(col_archivo        , 60,   60);  
        this.objectWidth(col_rif            , 75,   75);  
        this.objectWidth(col_nombre         , 215,  300);  
        this.objectWidth(col_fecha          , 75,   75);  
        this.objectWidth(col_tipodoc        , 45,   45);  
        this.objectWidth(col_mtodoc1        , 80,   80);  
        this.objectWidth(col_mtodoc2        , 85,   85);  
        this.objectWidth(col_mtoret1        , 80,   80);  
        this.objectWidth(col_mtoret2        , 80,   80);  
        this.objectWidth(col_mtoret3        , 80,   80);  
        this.objectWidth(col_mtoexe1        , 75,   75);  
        this.objectWidth(col_mtoexe2        , 80,   80);  
        this.objectWidth(col_nrodoc         , 95,   100);  
        this.objectWidth(col_control        , 95,   100);  
        this.objectWidth(col_nrodocafec     , 95,   100);  
        this.objectWidth(col_alicuota       , 60,   60);  

        col_ano.setCellFactory(new Callback<TableColumn, TableCell>() {
            @Override
            public TableCell call(TableColumn param) {
                return new TableCell<UploadExcelFile, Integer>() {
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

        col_mes.setCellFactory(new Callback<TableColumn, TableCell>() {
            @Override
            public TableCell call(TableColumn param) {
                return new TableCell<UploadExcelFile, Integer>() {
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

        col_rif.setCellFactory(new Callback<TableColumn, TableCell>() {
            @Override
            public TableCell call(TableColumn param) {
                return new TableCell<UploadExcelFile, String>() {
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
                return new TableCell<UploadExcelFile, Date>() {
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

        col_tipodoc.setCellFactory(new Callback<TableColumn, TableCell>() {
            @Override
            public TableCell call(TableColumn param) {
                return new TableCell<UploadExcelFile, String>() {
                    @Override
                    public void updateItem(String item, boolean empty) {
                        super.updateItem(item, empty);
                        if(!empty){
                            setText(item.toString());
                            setAlignment(Pos.CENTER);
                        }
                        else
                            setText(null);
                    }
                };
            }
        });

        col_mtodoc1.setCellFactory(new Callback<TableColumn, TableCell>() {
            @Override
            public TableCell call(TableColumn param) {
                return new TableCell<UploadExcelFile, Double>() {
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

        col_mtodoc2.setCellFactory(new Callback<TableColumn, TableCell>() {
            @Override
            public TableCell call(TableColumn param) {
                return new TableCell<UploadExcelFile, Double>() {
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

        col_mtoret1.setCellFactory(new Callback<TableColumn, TableCell>() {
            @Override
            public TableCell call(TableColumn param) {
                return new TableCell<UploadExcelFile, Double>() {
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

        col_mtoret2.setCellFactory(new Callback<TableColumn, TableCell>() {
            @Override
            public TableCell call(TableColumn param) {
                return new TableCell<UploadExcelFile, Double>() {
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

        col_mtoret3.setCellFactory(new Callback<TableColumn, TableCell>() {
            @Override
            public TableCell call(TableColumn param) {
                return new TableCell<UploadExcelFile, Double>() {
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

        col_mtoexe1.setCellFactory(new Callback<TableColumn, TableCell>() {
            @Override
            public TableCell call(TableColumn param) {
                return new TableCell<UploadExcelFile, Double>() {
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

        col_mtoexe2.setCellFactory(new Callback<TableColumn, TableCell>() {
            @Override
            public TableCell call(TableColumn param) {
                return new TableCell<UploadExcelFile, Double>() {
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

        col_alicuota.setCellFactory(new Callback<TableColumn, TableCell>() {
            @Override
            public TableCell call(TableColumn param) {
                return new TableCell<UploadExcelFile, Double>() {
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
        col_orden.setCellValueFactory( 
                new PropertyValueFactory<>("numorden") );
        col_ano.setCellValueFactory( 
                new PropertyValueFactory<>("ano") );
        col_mes.setCellValueFactory( 
                new PropertyValueFactory<>("mes") );
        col_archivo.setCellValueFactory( 
                new PropertyValueFactory<>("Excelfile") );
        col_rif.setCellValueFactory( 
                new PropertyValueFactory<>("RifAgente") );
        col_nombre.setCellValueFactory( 
                new PropertyValueFactory<>("NombAgente") );
        col_fecha.setCellValueFactory( 
                new PropertyValueFactory<>("FechaDoc") );
        col_tipodoc.setCellValueFactory( 
                new PropertyValueFactory<>("TipoDoc") );
        col_mtodoc1.setCellValueFactory( 
                new PropertyValueFactory<>("MtoDoc1") );
        col_mtodoc2.setCellValueFactory( 
                new PropertyValueFactory<>("MtoDoc2") );
        col_mtoret1.setCellValueFactory( 
                new PropertyValueFactory<>("MtoRet1") );
        col_mtoret2.setCellValueFactory( 
                new PropertyValueFactory<>("MtoRet2") );
        col_mtoret3.setCellValueFactory( 
                new PropertyValueFactory<>("MtoRet3") );
        col_mtoexe1.setCellValueFactory( 
                new PropertyValueFactory<>("MtoExe1") );
        col_mtoexe2.setCellValueFactory( 
                new PropertyValueFactory<>("MtoExe2") );
        col_nrodoc.setCellValueFactory( 
                new PropertyValueFactory<>("NroDoc") );
        col_control.setCellValueFactory( 
                new PropertyValueFactory<>("NroControl") );
        col_nrodocafec.setCellValueFactory( 
                new PropertyValueFactory<>("NroDocAfect") );
        col_alicuota.setCellValueFactory( 
                new PropertyValueFactory<>("alicuota") );
        col_comprob.setCellValueFactory( 
                new PropertyValueFactory<>("NroComprobante") );
        
        //Se Asigna ordenadamente las columnas de la tabla
        tb_query.getColumns().addAll(
                col_ano, col_mes, col_comprob, col_fecha, col_nrodoc, col_control, 
                col_tipodoc, col_rif, col_nombre, col_mtodoc1, col_mtoexe1, 
                col_mtoret1, col_mtoret3, 
                col_nrodocafec, col_alicuota, col_mtodoc2, 
                col_mtoret2, col_mtoexe2
                );                
        
        //Se Asigna menu contextual 
        tb_query.setRowFactory((TableView<UploadExcelFile> tableView) -> {
            final TableRow<UploadExcelFile> row = new TableRow<>();
            final ContextMenu contextMenu = new ContextMenu();
            final MenuItem RifMenuItem = new MenuItem("Copiar Rif");

            contextMenu.getItems().add(RifMenuItem);
            RifMenuItem.setOnAction((ActionEvent event) -> {
                tf_rif.setText(((UploadExcelFile) tb_query.getItems().get(tb_query.getSelectionModel().getSelectedIndex())).getRifAgente());
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
                    //selectedRowInvoice();
                }
            }
        };
        //Se Asigna el comportamiento para que se ejecute cuando se suelta una tecla
        tb_query.setOnKeyReleased(eh);    
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
     * Procedimiento de llenado de datos en la tabla de datos
     */
    private void loadTableQuery(UploadExcelFile[] sqlexcel){    
        if(sqlexcel != null){
            ObservableList<UploadExcelFile> data = FXCollections.observableArrayList();        
            data.addAll(Arrays.asList(sqlexcel));        
            tb_query.setItems(data);        
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
                    cb_ano1, cb_ano2, tf_rif, tf_nombre, tf_documento, tf_control, 
                    dp_fecha1, dp_fecha2, tf_mtomay, tf_mtomen, tf_retmay, 
                    tf_retmen, cb_comprob, cb_difmonto, tf_difmto, bt_aceptar
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
        refreshForm();
        
        loadToolBar();
        //SE LIMPIA EL FORMULARIO

        tf_buscar.setText("");
        tf_buscar.setVisible(false);

        tf_rif.requestFocus();
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

        ObservableList<UploadExcelFile> data = FXCollections.observableArrayList();
        data.addAll(Datos.getRep_updloadexcelfile());   
        JRDs = new JRBeanCollectionDataSource(data, true);

        JrxmlParam.put("p_user", Datos.getSesion().getUsername());
        try{ 
            jReport = (JasperReport) JRLoader.loadObjectFromFile(path + path_rep + "/seniat/sen_file_port_qry_reten.jasper");
            jPrint = JasperFillManager.fillReport(jReport, JrxmlParam, JRDs);
            jview = new JasperViewer(jPrint, false);
            jview.setTitle("DIGA - Retenciones de Clientes (Seniat) ");
        } catch (JRException ee){
            Gui.getInstance().showMessage("Error Cargando Reporte: \n"+ee.getMessage(), "E");
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
        bt_aceptar.setOnAction((ActionEvent event) -> {
            String SqlWhere = "";

            int year1 = cb_ano1.getValue(); 

            if (year1 != 0){
                SqlWhere = 
                    "ano >= " + cb_ano1.getValue() + " " +
                    "AND ano <= " + cb_ano2.getValue() + " ";
                
                if (!tf_rif.getText().isEmpty()){
                    SqlWhere = SqlWhere + 
                        "AND rif_agente like '%" + tf_rif.getText() + "%' ";
                }
                
                if (!tf_nombre.getText().isEmpty()){
                    SqlWhere = SqlWhere + 
                        "AND nombre_agente like '%" + tf_nombre.getText() + "%' ";
                }

                if (!tf_documento.getText().isEmpty()){
                    SqlWhere = SqlWhere + 
                        "AND nro_doc like '%" + tf_documento.getText() + "%' ";
                }

                if (!tf_control.getText().isEmpty()){
                    SqlWhere = SqlWhere + 
                        "AND nro_control like '%" + tf_control.getText() + "%' ";
                }

                if ((dp_fecha1.getValue() != null) && (dp_fecha2.getValue() == null)){
                    SqlWhere = SqlWhere + 
                        "AND fecha_doc = '" + dp_fecha1.getValue().format(dtf_yyyy) + "' ";
                }

                if ((dp_fecha1.getValue() != null) && (dp_fecha2.getValue() != null)){
                    SqlWhere = SqlWhere + 
                        "AND fecha_doc >= '" + dp_fecha1.getValue().format(dtf_yyyy) + "' " +
                        "AND fecha_doc <= '" + dp_fecha2.getValue().format(dtf_yyyy) + "' ";
                }

                if (!tf_mtomay.getText().isEmpty()){
                    SqlWhere = SqlWhere + 
                        "AND mto_doc1 >" + tf_mtomay.getText() + " ";
                }

                if (!tf_mtomen.getText().isEmpty()){
                    SqlWhere = SqlWhere + 
                        "AND mto_doc1 <" + tf_mtomen.getText() + " ";
                }

                if (!tf_retmay.getText().isEmpty()){
                    SqlWhere = SqlWhere + 
                        "AND mto_ret1 >" + tf_retmay.getText() + " ";
                }

                if (!tf_retmen.getText().isEmpty()){
                    SqlWhere = SqlWhere + 
                        "AND mto_ret1 <" + tf_retmen.getText() + " ";
                }

                if (cb_comprob.isSelected()){
                    SqlWhere = SqlWhere + 
                        "AND ISNULL(nro_comprobante, 'x') = 'x' ";
                }

                if (cb_difmonto.isSelected()){
                    if (!tf_difmto.getText().isEmpty()){
                        SqlWhere = SqlWhere + 
                            "AND mto_ret1 BETWEEN " +
                            "(mto_retd1 -" + tf_difmto.getText() + ") AND (mto_retd1 +" + tf_difmto.getText() + ") ";
                    }
                    else{
                        SqlWhere = SqlWhere + 
                            "AND (mto_ret1 - mto_retd1) > 0 " ;
                    }
                }
            }
            else{
                if (!tf_rif.getText().isEmpty()){
                    SqlWhere = 
                        "rif_agente like '%" + tf_rif.getText() + "%' ";

                    if (!tf_nombre.getText().isEmpty()){
                        SqlWhere = SqlWhere + 
                            "AND nombre_agente like '%" + tf_nombre.getText() + "%' ";
                    }

                    if (!tf_documento.getText().isEmpty()){
                        SqlWhere = SqlWhere + 
                            "AND nro_doc like '%" + tf_documento.getText() + "%' ";
                    }

                    if (!tf_control.getText().isEmpty()){
                        SqlWhere = SqlWhere + 
                            "AND nro_control like '%" + tf_control.getText() + "%' ";
                    }

                    if ((dp_fecha1.getValue() != null) && (dp_fecha2.getValue() == null)){
                        SqlWhere = SqlWhere + 
                            "AND fecha_doc = '" + dp_fecha1.getValue().format(dtf_yyyy) + "' ";
                    }

                    if ((dp_fecha1.getValue() != null) && (dp_fecha2.getValue() != null)){
                        SqlWhere = SqlWhere + 
                            "AND fecha_doc >= '" + dp_fecha1.getValue().format(dtf_yyyy) + "' " +
                            "AND fecha_doc <= '" + dp_fecha2.getValue().format(dtf_yyyy) + "' ";
                    }

                    if (!tf_mtomay.getText().isEmpty()){
                        SqlWhere = SqlWhere + 
                            "AND mto_doc1 >" + tf_mtomay.getText() + " ";
                    }

                    if (!tf_mtomen.getText().isEmpty()){
                        SqlWhere = SqlWhere + 
                            "AND mto_doc1 <" + tf_mtomen.getText() + " ";
                    }

                    if (!tf_retmay.getText().isEmpty()){
                        SqlWhere = SqlWhere + 
                            "AND mto_ret1 >" + tf_retmay.getText() + " ";
                    }

                    if (!tf_retmen.getText().isEmpty()){
                        SqlWhere = SqlWhere + 
                            "AND mto_ret1 <" + tf_retmen.getText() + " ";
                    }

                    if (cb_comprob.isSelected()){
                        SqlWhere = SqlWhere + 
                            "AND ISNULL(nro_comprobante, 'x') = 'x' ";
                    }

                    if (cb_difmonto.isSelected()){
                        if (!tf_difmto.getText().isEmpty()){
                            SqlWhere = SqlWhere + 
                                "AND mto_ret1 BETWEEN " +
                                "(mto_retd1 -" + tf_difmto.getText() + ") AND (mto_retd1 +" + tf_difmto.getText() + ") ";
                        }
                        else{
                            SqlWhere = SqlWhere + 
                                "AND (mto_ret1 - mto_retd1) > 0 " ;
                        }
                    }
                }
                else{
                    if (!tf_nombre.getText().isEmpty()){
                        SqlWhere = 
                            "nombre_agente like '%" + tf_nombre.getText() + "%' ";

                        if (!tf_documento.getText().isEmpty()){
                            SqlWhere = SqlWhere + 
                                "AND nro_doc like '%" + tf_documento.getText() + "%' ";
                        }

                        if (!tf_control.getText().isEmpty()){
                            SqlWhere = SqlWhere + 
                                "AND nro_control like '%" + tf_control.getText() + "%' ";
                        }

                        if ((dp_fecha1.getValue() != null) && (dp_fecha2.getValue() == null)){
                            SqlWhere = SqlWhere + 
                                "AND fecha_doc = '" + dp_fecha1.getValue().format(dtf_yyyy) + "' ";
                        }

                        if ((dp_fecha1.getValue() != null) && (dp_fecha2.getValue() != null)){
                            SqlWhere = SqlWhere + 
                                "AND fecha_doc >= '" + dp_fecha1.getValue().format(dtf_yyyy) + "' " +
                                "AND fecha_doc <= '" + dp_fecha2.getValue().format(dtf_yyyy) + "' ";
                        }

                        if (!tf_mtomay.getText().isEmpty()){
                            SqlWhere = SqlWhere + 
                                "AND mto_doc1 >" + tf_mtomay.getText() + " ";
                        }

                        if (!tf_mtomen.getText().isEmpty()){
                            SqlWhere = SqlWhere + 
                                "AND mto_doc1 <" + tf_mtomen.getText() + " ";
                        }

                        if (!tf_retmay.getText().isEmpty()){
                            SqlWhere = SqlWhere + 
                                "AND mto_ret1 >" + tf_retmay.getText() + " ";
                        }

                        if (!tf_retmen.getText().isEmpty()){
                            SqlWhere = SqlWhere + 
                                "AND mto_ret1 <" + tf_retmen.getText() + " ";
                        }

                        if (cb_comprob.isSelected()){
                            SqlWhere = SqlWhere + 
                                "AND ISNULL(nro_comprobante, 'x') = 'x' ";
                        }

                        if (cb_difmonto.isSelected()){
                            if (!tf_difmto.getText().isEmpty()){
                                SqlWhere = SqlWhere + 
                                    "AND mto_ret1 BETWEEN " +
                                    "(mto_retd1 -" + tf_difmto.getText() + ") AND (mto_retd1 +" + tf_difmto.getText() + ") ";
                            }
                            else{
                                SqlWhere = SqlWhere + 
                                    "AND (mto_ret1 - mto_retd1) > 0 " ;
                            }
                        }
                    }
                    else{
                        if (!tf_documento.getText().isEmpty()){
                            SqlWhere = 
                                "nro_doc like '%" + tf_documento.getText() + "%' ";

                            if (!tf_control.getText().isEmpty()){
                                SqlWhere = SqlWhere + 
                                    "AND nro_control like '%" + tf_control.getText() + "%' ";
                            }

                            if ((dp_fecha1.getValue() != null) && (dp_fecha2.getValue() == null)){
                                SqlWhere = SqlWhere + 
                                    "AND fecha_doc = '" + dp_fecha1.getValue().format(dtf_yyyy) + "' ";
                            }

                            if ((dp_fecha1.getValue() != null) && (dp_fecha2.getValue() != null)){
                                SqlWhere = SqlWhere + 
                                    "AND fecha_doc >= '" + dp_fecha1.getValue().format(dtf_yyyy) + "' " +
                                    "AND fecha_doc <= '" + dp_fecha2.getValue().format(dtf_yyyy) + "' ";
                            }

                            if (!tf_mtomay.getText().isEmpty()){
                                SqlWhere = SqlWhere + 
                                    "AND mto_doc1 >" + tf_mtomay.getText() + " ";
                            }

                            if (!tf_mtomen.getText().isEmpty()){
                                SqlWhere = SqlWhere + 
                                    "AND mto_doc1 <" + tf_mtomen.getText() + " ";
                            }

                            if (!tf_retmay.getText().isEmpty()){
                                SqlWhere = SqlWhere + 
                                    "AND mto_ret1 >" + tf_retmay.getText() + " ";
                            }

                            if (!tf_retmen.getText().isEmpty()){
                                SqlWhere = SqlWhere + 
                                    "AND mto_ret1 <" + tf_retmen.getText() + " ";
                            }

                            if (cb_comprob.isSelected()){
                                SqlWhere = SqlWhere + 
                                    "AND ISNULL(nro_comprobante, 'x') = 'x' ";
                            }

                            if (cb_difmonto.isSelected()){
                                if (!tf_difmto.getText().isEmpty()){
                                    SqlWhere = SqlWhere + 
                                        "AND mto_ret1 BETWEEN " +
                                        "(mto_retd1 -" + tf_difmto.getText() + ") AND (mto_retd1 +" + tf_difmto.getText() + ") ";
                                }
                                else{
                                    SqlWhere = SqlWhere + 
                                        "AND (mto_ret1 - mto_retd1) > 0 " ;
                                }
                            }
                        }
                        else{
                            if (!tf_control.getText().isEmpty()){
                                SqlWhere = 
                                    "nro_control like '%" + tf_control.getText() + "%' ";

                                if ((dp_fecha1.getValue() != null) && (dp_fecha2.getValue() == null)){
                                    SqlWhere = SqlWhere + 
                                        "AND fecha_doc = '" + dp_fecha1.getValue().format(dtf_yyyy) + "' ";
                                }

                                if ((dp_fecha1.getValue() != null) && (dp_fecha2.getValue() != null)){
                                    SqlWhere = SqlWhere + 
                                        "AND fecha_doc >= '" + dp_fecha1.getValue().format(dtf_yyyy) + "' " +
                                        "AND fecha_doc <= '" + dp_fecha2.getValue().format(dtf_yyyy) + "' ";
                                }

                                if (!tf_mtomay.getText().isEmpty()){
                                    SqlWhere = SqlWhere + 
                                        "AND mto_doc1 >" + tf_mtomay.getText() + " ";
                                }

                                if (!tf_mtomen.getText().isEmpty()){
                                    SqlWhere = SqlWhere + 
                                        "AND mto_doc1 <" + tf_mtomen.getText() + " ";
                                }

                                if (!tf_retmay.getText().isEmpty()){
                                    SqlWhere = SqlWhere + 
                                        "AND mto_ret1 >" + tf_retmay.getText() + " ";
                                }

                                if (!tf_retmen.getText().isEmpty()){
                                    SqlWhere = SqlWhere + 
                                        "AND mto_ret1 <" + tf_retmen.getText() + " ";
                                }

                                if (cb_comprob.isSelected()){
                                    SqlWhere = SqlWhere + 
                                        "AND ISNULL(nro_comprobante, 'x') = 'x' ";
                                }

                                if (cb_difmonto.isSelected()){
                                    if (!tf_difmto.getText().isEmpty()){
                                        SqlWhere = SqlWhere + 
                                            "AND mto_ret1 BETWEEN " +
                                            "(mto_retd1 -" + tf_difmto.getText() + ") AND (mto_retd1 +" + tf_difmto.getText() + ") ";
                                    }
                                    else{
                                        SqlWhere = SqlWhere + 
                                            "AND (mto_ret1 - mto_retd1) > 0 " ;
                                    }
                                }
                            }
                            else{
                                if ((dp_fecha1.getValue() != null) && (dp_fecha2.getValue() == null)){
                                    SqlWhere = 
                                        "fecha_doc = '" + dp_fecha1.getValue().format(dtf_yyyy) + "' ";

                                    if ((dp_fecha1.getValue() != null) && (dp_fecha2.getValue() != null)){
                                        SqlWhere = SqlWhere + 
                                            "AND fecha_doc >= '" + dp_fecha1.getValue().format(dtf_yyyy) + "' " +
                                            "AND fecha_doc <= '" + dp_fecha2.getValue().format(dtf_yyyy) + "' ";
                                    }

                                    if (!tf_mtomay.getText().isEmpty()){
                                        SqlWhere = SqlWhere + 
                                            "AND mto_doc1 >" + tf_mtomay.getText() + " ";
                                    }

                                    if (!tf_mtomen.getText().isEmpty()){
                                        SqlWhere = SqlWhere + 
                                            "AND mto_doc1 <" + tf_mtomen.getText() + " ";
                                    }

                                    if (!tf_retmay.getText().isEmpty()){
                                        SqlWhere = SqlWhere + 
                                            "AND mto_ret1 >" + tf_retmay.getText() + " ";
                                    }

                                    if (!tf_retmen.getText().isEmpty()){
                                        SqlWhere = SqlWhere + 
                                            "AND mto_ret1 <" + tf_retmen.getText() + " ";
                                    }

                                    if (cb_comprob.isSelected()){
                                        SqlWhere = SqlWhere + 
                                            "AND ISNULL(nro_comprobante, 'x') = 'x' ";
                                    }

                                    if (cb_difmonto.isSelected()){
                                        if (!tf_difmto.getText().isEmpty()){
                                            SqlWhere = SqlWhere + 
                                                "AND mto_ret1 BETWEEN " +
                                                "(mto_retd1 -" + tf_difmto.getText() + ") AND (mto_retd1 +" + tf_difmto.getText() + ") ";
                                        }
                                        else{
                                            SqlWhere = SqlWhere + 
                                                "AND (mto_ret1 - mto_retd1) > 0 " ;
                                        }
                                    }
                                }
                                else{
                                    if (!tf_mtomay.getText().isEmpty()){
                                        SqlWhere = 
                                            "mto_doc1 >" + tf_mtomay.getText() + " ";

                                        if (!tf_mtomen.getText().isEmpty()){
                                            SqlWhere = SqlWhere + 
                                                "AND mto_doc1 <" + tf_mtomen.getText() + " ";
                                        }

                                        if (!tf_retmay.getText().isEmpty()){
                                            SqlWhere = SqlWhere + 
                                                "AND mto_ret1 >" + tf_retmay.getText() + " ";
                                        }

                                        if (!tf_retmen.getText().isEmpty()){
                                            SqlWhere = SqlWhere + 
                                                "AND mto_ret1 <" + tf_retmen.getText() + " ";
                                        }

                                        if (cb_comprob.isSelected()){
                                            SqlWhere = SqlWhere + 
                                                "AND ISNULL(nro_comprobante, 'x') = 'x' ";
                                        }
                                    }
                                    else{
                                        if (!tf_retmay.getText().isEmpty()){
                                                SqlWhere = 
                                                    "mto_ret1 >" + tf_retmay.getText() + " ";

                                            if (!tf_retmen.getText().isEmpty()){
                                                SqlWhere = SqlWhere + 
                                                    "AND mto_ret1 <" + tf_retmen.getText() + " ";
                                            }

                                            if (cb_comprob.isSelected()){
                                                SqlWhere = SqlWhere + 
                                                    "AND ISNULL(nro_comprobante, 'x') = 'x' ";
                                            }
                                        }
                                        else{
                                            if (cb_comprob.isSelected()){
                                                SqlWhere = 
                                                    "ISNULL(nro_comprobante, 'x') = 'x' ";
                                            }
                                            else{
                                                if (cb_difmonto.isSelected()){
                                                    if (!tf_difmto.getText().isEmpty()){
                                                        SqlWhere = 
                                                            "mto_ret1 BETWEEN " +
                                                            "(mto_retd1 -" + tf_difmto.getText() + ") AND (mto_retd1 +" + tf_difmto.getText() + ") ";
                                                    }
                                                    else{
                                                        SqlWhere = 
                                                            "(mto_ret1 - mto_retd1) > 0 " ;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            
            Datos.setRep_updloadexcelfile(Ln.getInstance().find_Upfile_Retenciones(SqlWhere));
            loadTableQuery(Datos.getRep_updloadexcelfile());     
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
