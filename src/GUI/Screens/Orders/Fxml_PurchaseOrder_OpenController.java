/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Screens.Orders;

import GUI.Gui;
import LN.Ln;
import Listeners.FocusPropertyChangeListener;
import Objects.Orders.Orders;
import Objects.Orders.Supplier;
import Tools.Datos;
import java.math.RoundingMode;
import java.net.URL;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
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
public class Fxml_PurchaseOrder_OpenController implements Initializable {

    @FXML
    private AnchorPane ap_root;

    @FXML 
    private Button bt_aceptar; 

    @FXML
    private DatePicker dp_fecha;
    
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
    private ImageView im_checkr;

    @FXML
    private ImageView im_checkp;

    @FXML
    private Label lb_mensj;

    @FXML
    private Label lb_screen;

    @FXML
    private Label lb_Title;

    @FXML 
    private TableView<Orders> tb_table; 

    @FXML 
    private TableView<Orders> tb_view; 

    @FXML
    private TextField tf_buscar;

    @FXML
    private TextField tf_orden1;

    @FXML
    private TextField tf_orden2;

    @FXML
    private TextField tf_proveedor;

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

    private static JasperReport jReport = null;
    private static JasperViewer jview = null;
    private static JasperPrint jPrint = null;
    
    private static JRBeanCollectionDataSource JRDs = null;
    
    private static int tipoOperacion;    
    private static ImageView[] tools;    
    private static Integer[] toolsConfig;    
    private static String[] tooltips;

    private static int numGuias         = 0; 
    private static int numStatDet       = 0; 
    private static int numIdProv        = 0; 
    
    private static final ObservableList<Orders> orders_hea = FXCollections.observableArrayList();
    private static final ObservableList<Orders> orders_det = FXCollections.observableArrayList();

    private static final String ScreenName = "Ord. de Compra";
    
    /**
     * Initializes the controller class.
     * @param fxmlFileLocation
     * @param resources
     */     
    @Override // This method is called by the FXMLLoader when initialization is complete
    public void initialize(URL fxmlFileLocation, ResourceBundle resources) {
        assert ap_root != null : "fx:id=\"ap_root\" was not injected: check your FXML file 'Fxml_PurchaseOrderOpenController.fxml'.";
        assert bt_aceptar != null : "fx:id=\"bt_aceptar\" was not injected: check your FXML file 'Fxml_PurchaseOrderOpenController.fxml'.";
        assert dp_fecha != null : "fx:id=\"dp_fecha\" was not injected: check your FXML file 'Fxml_PurchaseOrderOpenController.fxml'."; 
        assert hb_1 != null : "fx:id=\"hb_1\" was not injected: check your FXML file 'Fxml_PurchaseOrderOpenController.fxml'.";
        assert hbox_toolbar != null : "fx:id=\"hbox_toolbar\" was not injected: check your FXML file 'Fxml_PurchaseOrderOpenController.fxml'.";
        assert im_checkr != null : "fx:id=\"im_checkr\" was not injected: check your FXML file 'Fxml_PurchaseOrderOpenController.fxml'.";
        assert im_checkp != null : "fx:id=\"im_checkp\" was not injected: check your FXML file 'Fxml_PurchaseOrderOpenController.fxml'.";
        assert im_tool1 != null : "fx:id=\"im_tool1\" was not injected: check your FXML file 'Fxml_PurchaseOrderOpenController.fxml'.";
        assert im_tool10 != null : "fx:id=\"im_tool10\" was not injected: check your FXML file 'Fxml_PurchaseOrderOpenController.fxml'.";
        assert im_tool11 != null : "fx:id=\"im_tool11\" was not injected: check your FXML file 'Fxml_PurchaseOrderOpenController.fxml'.";
        assert im_tool12 != null : "fx:id=\"im_tool12\" was not injected: check your FXML file 'Fxml_PurchaseOrderOpenController.fxml'.";
        assert im_tool2 != null : "fx:id=\"im_tool2\" was not injected: check your FXML file 'Fxml_PurchaseOrderOpenController.fxml'.";
        assert im_tool3 != null : "fx:id=\"im_tool3\" was not injected: check your FXML file 'Fxml_PurchaseOrderOpenController.fxml'.";
        assert im_tool4 != null : "fx:id=\"im_tool4\" was not injected: check your FXML file 'Fxml_PurchaseOrderOpenController.fxml'.";
        assert im_tool5 != null : "fx:id=\"im_tool5\" was not injected: check your FXML file 'Fxml_PurchaseOrderOpenController.fxml'.";
        assert im_tool6 != null : "fx:id=\"im_tool6\" was not injected: check your FXML file 'Fxml_PurchaseOrderOpenController.fxml'.";
        assert im_tool7 != null : "fx:id=\"im_tool7\" was not injected: check your FXML file 'Fxml_PurchaseOrderOpenController.fxml'.";
        assert im_tool8 != null : "fx:id=\"im_tool8\" was not injected: check your FXML file 'Fxml_PurchaseOrderOpenController.fxml'.";
        assert im_tool9 != null : "fx:id=\"im_tool9\" was not injected: check your FXML file 'Fxml_PurchaseOrderOpenController.fxml'.";
        assert lb_mensj != null : "fx:id=\"lb_mensj\" was not injected: check your FXML file 'Fxml_PurchaseOrderOpenController.fxml'.";
        assert lb_screen != null : "fx:id=\"lb_screen\" was not injected: check your FXML file 'Fxml_PurchaseOrderOpenController.fxml'.";
        assert lb_Title != null : "fx:id=\"lb_Title\" was not injected: check your FXML file 'Fxml_PurchaseOrderOpenController.fxml'.";
        assert tb_table != null : "fx:id=\"tb_table\" was not injected: check your FXML file 'Fxml_PurchaseOrderOpenController.fxml'.";
        assert tf_buscar != null : "fx:id=\"tf_buscar\" was not injected: check your FXML file 'Fxml_PurchaseOrderOpenController.fxml'.";
        assert tf_orden1 != null : "fx:id=\"tf_orden1\" was not injected: check your FXML file 'Fxml_PurchaseOrderOpenController.fxml'.";
        assert tf_orden2 != null : "fx:id=\"tf_orden2\" was not injected: check your FXML file 'Fxml_PurchaseOrderOpenController.fxml'.";
        assert tf_proveedor != null : "fx:id=\"tf_proveedor\" was not injected: check your FXML file 'Fxml_PurchaseOrderOpenController.fxml'.";
        assert vb_form != null : "fx:id=\"vb_form\" was not injected: check your FXML file 'Fxml_PurchaseOrderOpenController.fxml'.";
        assert vb_table != null : "fx:id=\"vb_table\" was not injected: check your FXML file 'Fxml_PurchaseOrderOpenController.fxml'.";

        //Inicializa la Barra de Herramientas y comportamiento del Boton de Busqueda
        defineToolBar();         
        defineBotonBuscar();    
        init_buttons(); //Establece los comportamientos de los botones
        botonInicio();  //Se imprime la pantalla Inicio

        createTable();
        createDetail();
        
        loadTable( Ln.getInstance().find_orders_open(Integer.parseInt(rows), ""));  

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
        TableColumn col_ordenc        = new TableColumn("#");        
        TableColumn col_fechac        = new TableColumn<>("Fecha");        
        TableColumn col_numorden      = new TableColumn<>("Nro Orden");                
        TableColumn col_idprovc       = new TableColumn<>("ID");                
        TableColumn col_rifprovc      = new TableColumn<>("Rif");        
        TableColumn col_nfiscalc      = new TableColumn<>("Nombre Fiscal");        
        TableColumn col_fpersonalc    = new TableColumn<>("Firma Personal");        
        TableColumn col_cantsol       = new TableColumn<>("Cant");        

        //Se establece el ancho de cada columna
        this.objectWidth(col_ordenc       , 34,  34); 
        this.objectWidth(col_fechac       , 66,  66);
        this.objectWidth(col_numorden     , 66,  66);
        this.objectWidth(col_idprovc      , 45,  45);
        this.objectWidth(col_rifprovc     , 75,  75);
        this.objectWidth(col_nfiscalc     , 330, 350); //270
        this.objectWidth(col_fpersonalc   , 200, 350);
        this.objectWidth(col_cantsol      , 60,  60);

        col_numorden.setCellFactory(new Callback<TableColumn<Object, Object>, TableCell<Object, Object>>() {
            @Override
            public TableCell<Object, Object> call(TableColumn<Object, Object> param) {
                return new TableCell<Object, Object>() {
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

        col_fechac.setCellFactory(new Callback<TableColumn<Object, Object>, TableCell<Object, Object>>() {
            @Override
            public TableCell<Object, Object> call(TableColumn<Object, Object> param) {
                return new TableCell<Object, Object>() {
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

        col_idprovc.setCellFactory(new Callback<TableColumn<Object, Object>, TableCell<Object, Object>>() {
            @Override
            public TableCell<Object, Object> call(TableColumn<Object, Object> param) {
                return new TableCell<Object, Object>() {
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

        col_cantsol.setCellFactory(new Callback<TableColumn<Object, Object>, TableCell<Object, Object>>() {
            @Override
            public TableCell call(TableColumn<Object, Object> param) {
                return new TableCell<Orders, Integer>() {
                    @Override
                    public void updateItem(Integer item, boolean empty) {
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
        col_ordenc.setCellValueFactory( 
                new PropertyValueFactory<>("numorden") );
        col_fechac.setCellValueFactory( 
                new PropertyValueFactory<>("fecha") );
        col_numorden.setCellValueFactory( 
                new PropertyValueFactory<>("idOrden") );
        col_idprovc.setCellValueFactory( 
                new PropertyValueFactory<>("idSupplier") );
        col_rifprovc.setCellValueFactory( 
                new PropertyValueFactory<>("rif") );
        col_nfiscalc.setCellValueFactory( 
                new PropertyValueFactory<>("nombre") );
        col_fpersonalc.setCellValueFactory( 
                new PropertyValueFactory<>("firma") );
        col_cantsol.setCellValueFactory( 
                new PropertyValueFactory<>("cant_sol") );

        //Se Asigna ordenadamente las columnas de la tabla
        tb_table.getColumns().addAll(
            col_ordenc, col_fechac, col_numorden, col_idprovc, col_nfiscalc
            );   

        //Se Asigna menu contextual 

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
    * Metodo encargado de Crear e inicializar la Tabla de Datos
    */
    private void createDetail(){
        //Se crean y definen las columnas de la Tabla
        TableColumn col_orden       = new TableColumn("#");
        TableColumn col_status      = new TableColumn("Act");
        TableColumn col_producto    = new TableColumn("Código");                
        TableColumn col_descrip     = new TableColumn("Descripción");        
        TableColumn col_unidped     = new TableColumn("Unid");
        TableColumn col_empaque     = new TableColumn("Empaque");
        
        TableColumn col_cantped      = new TableColumn("Pedida");        
        TableColumn col_cantrec      = new TableColumn("Recibida");        
        TableColumn col_cantpen      = new TableColumn("Faltante");        
        TableColumn col_cantidades   = new TableColumn("Cantidades");
        col_cantidades.getColumns().addAll(
                col_cantrec, col_cantpen);//col_cantped, 

        TableColumn col_precio       = new TableColumn<>("P. Marcado");        
        TableColumn col_fecha1       = new TableColumn<>("F. Vcto 1");        
        TableColumn col_fecha2       = new TableColumn<>("F. Vcto 2");        
        TableColumn col_cbarra       = new TableColumn<>("Cod. de Barra");        

        //Se establece el ancho de cada columna
        this.objectWidth(col_orden          , 25,  25);
        this.objectWidth(col_status         , 30 , 30);
        this.objectWidth(col_producto       , 52 , 52);   
        this.objectWidth(col_descrip        , 220, 300);
        this.objectWidth(col_unidped        , 45,  45);
        this.objectWidth(col_empaque        , 60,  60);
        this.objectWidth(col_cantped        , 55 , 65);
        this.objectWidth(col_cantrec        , 62 , 62);
        this.objectWidth(col_cantpen        , 62 , 62);
        this.objectWidth(col_precio         , 75,  75);
        this.objectWidth(col_fecha1         , 65,  65);
        this.objectWidth(col_fecha2         , 65,  65);
        this.objectWidth(col_cbarra         , 115,  115);

        /**
         * Sobreescritura de un metodo de la Columna, para sustituir el valor numerico 
         * del STATUS del usuario por una Imagen segun el valor
         * 1 - VERDE (HABILITADO)
         * 2 - ROJO  (DESHABILITADO)
         */
        col_status.setCellFactory(new Callback<TableColumn, TableCell>() {
            @Override
            public TableCell call(TableColumn param) {
                return new TableCell<Orders, String>() {
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

        col_producto.setCellFactory(new Callback<TableColumn, TableCell>() {
            @Override
            public TableCell call(TableColumn param) {
                return new TableCell<Orders, String>() {
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

        col_cantped.setCellFactory(new Callback<TableColumn, TableCell>() {
            @Override
            public TableCell call(TableColumn param) {
                return new TableCell<Orders, Integer>() {
                    @Override
                    public void updateItem(Integer item, boolean empty) {
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

        col_unidped.setCellFactory(new Callback<TableColumn, TableCell>() {
            @Override
            public TableCell call(TableColumn param) {
                return new TableCell<Orders, String>() {
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
                new PropertyValueFactory<>("numorden") );
        col_status.setCellValueFactory( 
                new PropertyValueFactory<>("statdet") );
        col_producto.setCellValueFactory( 
                new PropertyValueFactory<>("idProducto") );
        col_descrip.setCellValueFactory( 
                new PropertyValueFactory<>("descrip") );
        col_cantped.setCellValueFactory( 
                new PropertyValueFactory<>("cant_sol") );
        col_unidped.setCellValueFactory( 
                new PropertyValueFactory<>("unidsol") );
        
        //Se Asigna ordenadamente las columnas de la tabla
        tb_view.getColumns().addAll(
                col_orden, col_producto, col_descrip, col_unidped, col_empaque,
                col_cantidades, col_precio, col_fecha1, col_fecha2
                );                
        
        //Se Asigna menu contextual 
        
        //Se define el comportamiento de las teclas ARRIBA y ABAJO en la tabla
        EventHandler eh = new EventHandler<KeyEvent>(){
            @Override
            public void handle(KeyEvent ke){
                //Si fue presionado la tecla ARRIBA o ABAJO
                if (ke.getCode().equals(KeyCode.UP) || ke.getCode().equals(KeyCode.DOWN)){     
                    //Selecciona la FILA enfocada
                    //selectedRow();
                }
            }
        };
        //Se Asigna el comportamiento para que se ejecute cuando se suelta una tecla
        tb_view.setOnKeyReleased(eh);
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
                tf_orden1.setEditable(true);
                tf_orden2.setEditable(true);

                //SE PERMITE: NUEVO, CANCELAR Y BUSCAR
                disables = new Integer[]{2,5,6,9,10};
                disableAllToolBar(disables); 
                break;
            case 1:  //NUEVO
                lb_Title.setText("NUEVO");
                tf_orden1.setEditable(false);
                tf_orden2.setEditable(false);

                //SE PERMITE: NUEVO,GUARDAR Y CANCELAR             
                disables = new Integer[]{0,1,3,4,6,7,8,9,10,11};
                disableAllToolBar(disables);                            
                break;
            case 2:  //EDITAR
                lb_Title.setText("EDITAR");
                tf_orden1.setEditable(false);
                tf_orden2.setEditable(false);

                //SE PERMITE: EDITAR,GUARDAR Y CANCELAR
                disables = new Integer[]{0,1,3,4,6,7,8,9,10,11};
                disableAllToolBar(disables);            
                break;
            case 3:  //GUARDAR
                tf_orden1.setEditable(true);
                tf_orden2.setEditable(true);

                //SE PERMITE: GUARDAR Y CANCELAR
                disables = new Integer[]{0,1,3,4,6,7,8,9,10,11};
                disableAllToolBar(disables);   
                break;
            case 4:  //CAMBIAR STATUS 
                tf_orden1.setEditable(true);
                tf_orden2.setEditable(true);

                //SE PERMITE: GUARDAR,CAMBIO STATUS Y CANCELAR
                disables = new Integer[]{0,1,2,4,6,7,8,9,10,11};
                disableAllToolBar(disables); 
                break;
        }        
        init_FocusArray(tipoOperacion);       
        Gui.getInstance().setTipoOperacion(tipoOperacion);
    }    
    /**
     * Procedimiento de llenado de datos en la tabla de datos
     */
    private void loadTable(Orders[] orders){    
        if(orders != null){
            ObservableList<Orders> data = FXCollections.observableArrayList();        
            data.addAll(Arrays.asList(orders));   
            tb_table.setItems(data);        
        }
    } 
    /**
     * Metodo que selecciona y llena el formulario con los datos del usuario 
     * seleccionado en la tabla
     */
    private void selectedRow(){
        tipoOperacion = 0;      //SOLO LECTURA
        Datos.setRep_orders(Ln.getInstance().find_orders(String.valueOf(tb_table.getSelectionModel().getSelectedItem().getIdOrden())));
        if(Datos.getRep_orders() != null){
            loadTableView(Datos.getRep_orders()); 
        }
    }
    /**
     * Procedimiento de llenado de datos en la tabla de datos
     */
    private void loadTableView(Orders[] order){    
        if(order != null){
            ObservableList<Orders> data = FXCollections.observableArrayList();        
            data.addAll(Arrays.asList(order));   
            tb_view.setItems(data);        
        }
    }    
    


    /***************************************************************************/
    /************************ METODOS DE ACCESO RAPIDO *************************/
    /******************************************
        
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
                    tf_orden1, tf_orden2, tf_proveedor, dp_fecha, bt_aceptar
                    };
                break;
            case 1:     //NUEVO
                nodos = new Node[]{
                    tf_orden1, tf_orden2, tf_proveedor, dp_fecha, bt_aceptar
                    };
                break;
            case 2:     //EDITAR
                nodos = new Node[]{
                    tf_orden1, tf_orden2, tf_proveedor, dp_fecha, bt_aceptar
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
            "Sin Asignar",
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
                        Datos.setOrders(new Orders());                           
                        boolean boo = Ln.getInstance().check_orders(tf_buscar.getText());                
                        if(boo){
                            Datos.setRep_orders(Ln.getInstance().find_orders(tf_buscar.getText()));
                        }
                        else{
                            Gui.getInstance().showMessage("El Nro de Orden de Compra NO existe!", "A");
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
        numGuias = 0;
        
        loadToolBar();
        //SE LIMPIA EL FORMULARIO
        tf_orden1.setText("");
        tf_orden2.setText("");
        tf_proveedor.setText("");

        tf_buscar.setText("");
        tf_buscar.setVisible(false);
        
        Datos.setOrders(new Orders());                           
        refreshForm();                      
        Datos.setLog_cguias(null);                  //RESET DE LA VARIABLE
        setFormVisible(true);                      //OCULTA EL FORMULARIO
        //RECARGA LA TABLA ORIGINAL
        
        tf_orden1.requestFocus();
    }
    /**
     * 
     */
    private void botonNuevo(){
        if(toolsConfig[2]==1){
            tipoOperacion = 1;
            Datos.setOrders(new Orders());                           
            refreshForm();
            setFormVisible(true);
            Gui.getFields()[Gui.getFieldFocused()].requestFocus();

            tf_orden1.setText("");
            tf_orden2.setText("");
            tf_orden1.requestFocus();
        }
    }
    /**
     * 
     */
    private void botonEditar(){
        if(Datos.getOrders() != null && toolsConfig[3]==1){
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
        if(Datos.getOrders() != null){
//            boolean result = saveOrder();
//            if (result)
//                botonInicio();
        }
    }
    /**
     * 
     */
    private void botonEliminar() {
        if(Datos.getOrders() != null && toolsConfig[5]==1){
            tipoOperacion = 4;      //OPERACION DE BORRADO
            change_im_check(true);       //SE CAMBIA EL ICONO DE VERIFICACION DEL SUPPLIER                   
            refreshForm();         
            setFormVisible(true);  
            String verbo = "desactivar";
            if(Datos.getOrders().getStatenc()== 1){
                verbo = "activar";
            }
            String mensj = 
                "¿Seguro que desea " + verbo + " el " + ScreenName + Datos.getOrders().getIdOrden()+"?";
            Gui.getInstance().showConfirmar(mensj);  
        }
    }
    /**
     * 
     */
    private void botonBuscar(){
        if(toolsConfig[13]==1){
            //tipoOperacion = 0;                          //OPERACION SOLO LECTURA
            tf_orden1.setText("");
            //SE LIMPIA EL FORMULARIO
            tf_buscar.setVisible(true);
            Datos.setOrders(new Orders());                           
            refreshForm();                      
            Datos.setOrders(null);                //RESET DE LA VARIABLE
            //setFormVisible(false);                      //OCULTA EL FORMULARIO     
            tf_buscar.requestFocus();
        }
    }
    /**
     * 
     */
    private void botonImprimir(){
        tipoOperacion = 5;                  //OPERACION SOLO LECTURA

        ObservableList<Orders> data = FXCollections.observableArrayList();
        data.addAll(Datos.getRep_orders());   

        List<Supplier> datas = Ln.getList_Supplier(Ln.getInstance().find_Supplier(data.get(0).getRif()));
        Datos.setSupplier(datas.get(0));
        
        if(!data.isEmpty()){
            JRDs = new JRBeanCollectionDataSource(data, true);

            JrxmlParam.put("p_user", Datos.getSesion().getUsername());
            JrxmlParam.put("p_orden", "RECEPCION SEGUN O/C NRO.:  " + data.get(0).getIdOrden());
            try{ 
                jReport = (JasperReport) JRLoader.loadObjectFromFile(path + path_rep + "/compras/ord_com_port_rec.jasper");

                if(Datos.getSupplier().getCountry().getAbrev().equals("VE")){
                    jReport = (JasperReport) JRLoader.loadObjectFromFile(path + path_rep + "/compras/ord_com_port_rec_nac.jasper");
                }
                else{
                    jReport = (JasperReport) JRLoader.loadObjectFromFile(path + path_rep + "/compras/ord_com_port_rec_imp.jasper");
                }
                jPrint = JasperFillManager.fillReport(jReport, JrxmlParam, JRDs);

                jview = new JasperViewer(jPrint, false);
                jview.setTitle("DIGA - Recepción de Compra (Compras) ");
            } catch (JRException ee){
                Gui.getInstance().showMessage("Error Cargando Reporte: \n" + ee.getMessage(), "E");
            }
            jview.setVisible(true);
            jview.setResizable(false);
        }
        else{
            Gui.getInstance().showMessage("Debe indicar un Nro. de Orden!", "A");
            tf_orden1.requestFocus();
        }
    }
    /**
     * 
     */
    private void botonCorreoOrden(){
        tipoOperacion = 8;                  //OPERACION SOLO LECTURA

        Datos.setIdButton(1002012);
        Gui.getInstance().showEmailSend();  
    }
    /**
     * 
     */
    private void botonCorreoAgenda(){
        tipoOperacion = 9;                  //OPERACION SOLO LECTURA

        Datos.setIdButton(1002013);
        Gui.getInstance().showEmail(ScreenName);  
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
         * BOTON POR ASIGNAR
         */
        im_tool8.setOnMouseClicked((MouseEvent mouseEvent) -> {
            if(mouseEvent.getButton().equals(MouseButton.PRIMARY)){
                if(mouseEvent.getClickCount() > 0){
                    botonCorreoOrden();
                }
            }
        });
        /**
         * BOTON POR ASIGNAR
         */
        im_tool9.setOnMouseClicked((MouseEvent mouseEvent) -> {
            if(mouseEvent.getButton().equals(MouseButton.PRIMARY)){
                if(mouseEvent.getClickCount() > 0){
                    botonCorreoAgenda();
                }
            }
        });
        /**
         * BOTON BUSCAR
         */
        im_tool12.setOnMouseClicked((MouseEvent mouseEvent) -> {
            if(mouseEvent.getButton().equals(MouseButton.PRIMARY)){
                botonBuscar();
            } 
        });
        /**
         * SELECCION EN LA TABLA
         */
        tb_table.setOnMouseClicked((MouseEvent mouseEvent) -> {
            if(mouseEvent.getButton().equals(MouseButton.PRIMARY)){
                if(mouseEvent.getClickCount() > 0){
                    if ((tb_table.getItems() != null) && (!tb_table.getItems().isEmpty()))
                        selectedRow();
                }
            }
        });        
        /**
         * metodo para mostrar buscar el nro de RIF
         * param: ENTER O TAB
         */
        tf_orden1.setOnKeyReleased((KeyEvent ke) -> {
            if (ke.getCode().equals(KeyCode.ENTER) || ke.getCode().equals(KeyCode.TAB)){
                if (!tf_orden1.getText().isEmpty()){
                }
            }
        });
        /**
         * 
         */
        bt_aceptar.setOnMouseClicked((MouseEvent mouseEvent) -> {
            if(mouseEvent.getButton().equals(MouseButton.PRIMARY)){
                if(mouseEvent.getClickCount() > 0){
                    if(tf_orden1.getText().isEmpty() && tf_orden2.getText().isEmpty() && dp_fecha.getValue() == null){
                        loadTable( Ln.getInstance().find_orders_open(Integer.parseInt(rows), ""));  
                    }
                    else{
                        if(tf_orden1.getText().isEmpty() && tf_orden2.getText().isEmpty()){
                            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                            loadTable( Ln.getInstance().find_orders_date(dp_fecha.getValue().format(formatter)));  
                        }
                        else{
                            if(!tf_orden1.getText().isEmpty() && tf_orden2.getText().isEmpty()){
                                loadTable( Ln.getInstance().find_orders_id(tf_orden1.getText()));  
                            }
                            if(!tf_orden1.getText().isEmpty() && !tf_orden2.getText().isEmpty()){
                                loadTable( Ln.getInstance().find_orders_ids(tf_orden1.getText(), tf_orden2.getText()));  
                            }
                        }
                    }
                }
            }
        });
        /**
         * 
         */
        bt_aceptar.setOnKeyReleased((KeyEvent ke) -> {
            if (ke.getCode().equals(KeyCode.ENTER)){
                if(tf_orden1.getText().isEmpty() && tf_orden2.getText().isEmpty() && dp_fecha.getValue() == null){
                    loadTable( Ln.getInstance().find_orders_open(Integer.parseInt(rows), ""));  
                }
                else{
                    if(tf_orden1.getText().isEmpty() && tf_orden2.getText().isEmpty()){
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                        loadTable( Ln.getInstance().find_orders_date(dp_fecha.getValue().format(formatter)));  
                    }
                    else{
                        if(!tf_orden1.getText().isEmpty() && tf_orden2.getText().isEmpty()){
                            loadTable( Ln.getInstance().find_orders_id(tf_orden1.getText()));  
                        }
                        if(!tf_orden1.getText().isEmpty() && !tf_orden2.getText().isEmpty()){
                            loadTable( Ln.getInstance().find_orders_ids(tf_orden1.getText(), tf_orden2.getText()));  
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
