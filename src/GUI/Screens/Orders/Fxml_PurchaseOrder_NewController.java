/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Screens.Orders;

import GUI.Gui;
import LN.Ln;
import Listeners.FocusPropertyChangeListener;
import Listeners.SelectKeyComboBoxListener;
import Objects.Orders.Fxp_Inventa;
import Objects.Orders.Orders;
import Objects.Orders.Supplier;
import Objects.Setup.Unit;
import Tools.Datos;
import java.math.RoundingMode;
import java.net.URL;
import java.sql.Date;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
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
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
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
public class Fxml_PurchaseOrder_NewController implements Initializable {

    @FXML
    private AnchorPane ap_root;

    @FXML 
    private Button bt_orden; 

    @FXML 
    private Button bt_prov; 

    @FXML 
    private Button bt_prod;

    @FXML
    private ComboBox<Unit> cb_unidad;

    @FXML
    private ComboBox<String> cb_usupervisa;

    @FXML 
    private CheckBox ch_IvaAgent; 

    @FXML 
    private CheckBox ch_t100; 

    @FXML 
    private CheckBox ch_t75; 
    
    @FXML
    private HBox hb_1;    
    
    @FXML
    private HBox hbox_toolbar;

    @FXML
    private Hyperlink hp_editar;

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
    private TextField tf_buscar;

    @FXML
    private TextField tf_orden;

    @FXML
    private TextField tf_rif;

    @FXML
    private TextField tf_nombre;

    @FXML
    private TextField tf_prod;

    @FXML
    private TextField tf_descrip;

    @FXML
    private TextField tf_cant;

    @FXML
    private TextField tf_fdespacho;

    @FXML
    private TextField tf_ldespacho;

    @FXML
    private TextArea ta_nota;

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
    
    private static final ObservableList<Orders> orders_new = FXCollections.observableArrayList();

    private static final String ScreenName = "Ord. de Compra";
    
    /**
     * Initializes the controller class.
     * @param fxmlFileLocation
     * @param resources
     */     
    @Override // This method is called by the FXMLLoader when initialization is complete
    public void initialize(URL fxmlFileLocation, ResourceBundle resources) {
        assert ap_root != null : "fx:id=\"ap_root\" was not injected: check your FXML file 'Fxml_PurchaseOrderNewController.fxml'.";
        assert bt_orden != null : "fx:id=\"bt_orden\" was not injected: check your FXML file 'Fxml_PurchaseOrderNewController.fxml'.";
        assert bt_prov != null : "fx:id=\"bt_prov\" was not injected: check your FXML file 'Fxml_PurchaseOrderNewController.fxml'.";
        assert bt_prod != null : "fx:id=\"bt_prod\" was not injected: check your FXML file 'Fxml_PurchaseOrderNewController.fxml'.";
        assert cb_unidad != null : "fx:id=\"cb_unidad\" was not injected: check your FXML file 'Fxml_PurchaseOrderNewController.fxml'.";
        assert cb_usupervisa != null : "fx:id=\"cb_usupervisa\" was not injected: check your FXML file 'Fxml_PurchaseOrderNewController.fxml'.";
        assert hb_1 != null : "fx:id=\"hb_1\" was not injected: check your FXML file 'Fxml_PurchaseOrderNewController.fxml'.";
        assert hbox_toolbar != null : "fx:id=\"hbox_toolbar\" was not injected: check your FXML file 'Fxml_PurchaseOrderNewController.fxml'.";
        assert hp_editar != null : "fx:id=\"hp_editar\" was not injected: check your FXML file 'Fxml_PurchaseOrderNewController.fxml'.";
        assert im_checkr != null : "fx:id=\"im_checkr\" was not injected: check your FXML file 'Fxml_PurchaseOrderNewController.fxml'.";
        assert im_checkp != null : "fx:id=\"im_checkp\" was not injected: check your FXML file 'Fxml_PurchaseOrderNewController.fxml'.";
        assert im_tool1 != null : "fx:id=\"im_tool1\" was not injected: check your FXML file 'Fxml_PurchaseOrderNewController.fxml'.";
        assert im_tool10 != null : "fx:id=\"im_tool10\" was not injected: check your FXML file 'Fxml_PurchaseOrderNewController.fxml'.";
        assert im_tool11 != null : "fx:id=\"im_tool11\" was not injected: check your FXML file 'Fxml_PurchaseOrderNewController.fxml'.";
        assert im_tool12 != null : "fx:id=\"im_tool12\" was not injected: check your FXML file 'Fxml_PurchaseOrderNewController.fxml'.";
        assert im_tool2 != null : "fx:id=\"im_tool2\" was not injected: check your FXML file 'Fxml_PurchaseOrderNewController.fxml'.";
        assert im_tool3 != null : "fx:id=\"im_tool3\" was not injected: check your FXML file 'Fxml_PurchaseOrderNewController.fxml'.";
        assert im_tool4 != null : "fx:id=\"im_tool4\" was not injected: check your FXML file 'Fxml_PurchaseOrderNewController.fxml'.";
        assert im_tool5 != null : "fx:id=\"im_tool5\" was not injected: check your FXML file 'Fxml_PurchaseOrderNewController.fxml'.";
        assert im_tool6 != null : "fx:id=\"im_tool6\" was not injected: check your FXML file 'Fxml_PurchaseOrderNewController.fxml'.";
        assert im_tool7 != null : "fx:id=\"im_tool7\" was not injected: check your FXML file 'Fxml_PurchaseOrderNewController.fxml'.";
        assert im_tool8 != null : "fx:id=\"im_tool8\" was not injected: check your FXML file 'Fxml_PurchaseOrderNewController.fxml'.";
        assert im_tool9 != null : "fx:id=\"im_tool9\" was not injected: check your FXML file 'Fxml_PurchaseOrderNewController.fxml'.";
        assert lb_mensj != null : "fx:id=\"lb_mensj\" was not injected: check your FXML file 'Fxml_PurchaseOrderNewController.fxml'.";
        assert lb_screen != null : "fx:id=\"lb_screen\" was not injected: check your FXML file 'Fxml_PurchaseOrderNewController.fxml'.";
        assert lb_Title != null : "fx:id=\"lb_Title\" was not injected: check your FXML file 'Fxml_PurchaseOrderNewController.fxml'.";
        assert tb_table != null : "fx:id=\"tb_table\" was not injected: check your FXML file 'Fxml_PurchaseOrderNewController.fxml'.";
        assert tf_buscar != null : "fx:id=\"tf_buscar\" was not injected: check your FXML file 'Fxml_PurchaseOrderNewController.fxml'.";
        assert tf_orden != null : "fx:id=\"tf_orden\" was not injected: check your FXML file 'Fxml_PurchaseOrderNewController.fxml'.";
        assert tf_rif != null : "fx:id=\"tf_rif\" was not injected: check your FXML file 'Fxml_PurchaseOrderNewController.fxml'.";
        assert tf_nombre != null : "fx:id=\"tf_nombre\" was not injected: check your FXML file 'Fxml_PurchaseOrderNewController.fxml'.";
        assert tf_prod != null : "fx:id=\"tf_prod\" was not injected: check your FXML file 'Fxml_PurchaseOrderNewController.fxml'.";
        assert tf_descrip != null : "fx:id=\"tf_descrip\" was not injected: check your FXML file 'Fxml_PurchaseOrderNewController.fxml'.";
        assert tf_cant != null : "fx:id=\"tf_cant\" was not injected: check your FXML file 'Fxml_PurchaseOrderNewController.fxml'.";
        assert tf_fdespacho != null : "fx:id=\"tf_fdespacho\" was not injected: check your FXML file 'Fxml_PurchaseOrderNewController.fxml'.";
        assert tf_ldespacho != null : "fx:id=\"tf_ldespacho\" was not injected: check your FXML file 'Fxml_PurchaseOrderNewController.fxml'.";
        assert ta_nota != null : "fx:id=\"ta_nota\" was not injected: check your FXML file 'Fxml_PurchaseOrderNewController.fxml'.";
        assert vb_form != null : "fx:id=\"vb_form\" was not injected: check your FXML file 'Fxml_PurchaseOrderNewController.fxml'.";
        assert vb_table != null : "fx:id=\"vb_table\" was not injected: check your FXML file 'Fxml_PurchaseOrderNewController.fxml'.";

        //Inicializa la Barra de Herramientas y comportamiento del Boton de Busqueda
        defineToolBar();         
        defineBotonBuscar();    
        init_buttons(); //Establece los comportamientos de los botones
        botonInicio();  //Se imprime la pantalla Inicio

        loadUnits();
        loadUSupervisa();
        createTable();

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
        TableColumn col_orden       = new TableColumn("#");        
        TableColumn col_status      = new TableColumn("Act");
        TableColumn col_producto    = new TableColumn("Código");                
        TableColumn col_descrip     = new TableColumn("Descripción");        
        TableColumn col_cant        = new TableColumn("Cant.");        
        TableColumn col_unidad      = new TableColumn("Unidad");
        
        //Se establece el ancho de cada columna
        this.objectWidth(col_orden          , 25,  25);
        this.objectWidth(col_status         , 30 , 30);
        this.objectWidth(col_producto       , 65 , 65);   
        this.objectWidth(col_descrip        , 300, 350);
        this.objectWidth(col_cant           , 65 , 65);
        this.objectWidth(col_unidad         , 65,  65);
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

        col_cant.setCellFactory(new Callback<TableColumn, TableCell>() {
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

        col_unidad.setCellFactory(new Callback<TableColumn, TableCell>() {
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
        col_cant.setCellValueFactory( 
                new PropertyValueFactory<>("cant_sol") );
        col_unidad.setCellValueFactory( 
                new PropertyValueFactory<>("unidsol") );
        
        //Se Asigna ordenadamente las columnas de la tabla
        tb_table.getColumns().addAll(
                col_orden, col_status, col_producto, col_descrip, col_cant, col_unidad
                );                
        
        //Se Asigna menu contextual 
        tb_table.setRowFactory((TableView<Orders> tableView) -> {
            final TableRow<Orders> row = new TableRow<>();
            final ContextMenu contextMenu = new ContextMenu();
            final MenuItem removeMenuItem = new MenuItem("Eliminar");

            contextMenu.getItems().add(removeMenuItem);
            removeMenuItem.setOnAction((ActionEvent event) -> {
                switch (tipoOperacion){
                    case 1:
                        tb_table.getItems().remove(row.getItem());
                        break;
                    case 2:
                        tb_table.getItems().get(tb_table.getSelectionModel().getSelectedIndex()).setStatdet("A");

                        numStatDet = Integer.parseInt(( tb_table.getItems().get(tb_table.getSelectionModel().getSelectedIndex())).getNumorden());
                        col_status.setVisible(false);
                        col_status.setVisible(true);
                        break;
                }
            });

            final MenuItem changeMenuItem = new MenuItem("Modificar");
            contextMenu.getItems().add(changeMenuItem);
            changeMenuItem.setOnAction((ActionEvent event) -> {
                switch (tipoOperacion){
                    case 1:
                    case 2:
                        numStatDet = Integer.parseInt((tb_table.getItems().get(tb_table.getSelectionModel().getSelectedIndex())).getNumorden());
                        tf_prod.setText((tb_table.getItems().get(tb_table.getSelectionModel().getSelectedIndex())).getIdProducto());
                        tf_cant.setText(String.valueOf((tb_table.getItems().get(tb_table.getSelectionModel().getSelectedIndex())).getCant_sol()));

                        List<Supplier> data = Ln.getList_Supplier(Ln.getInstance().find_Supplier(String.valueOf((tb_table.getItems().get(tb_table.getSelectionModel().getSelectedIndex())).getIdSupplier())));
                        Datos.setSupplier(data.get(0));
                        
                        tf_prod.requestFocus();
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
                    //selectedRow();
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
    private boolean saveOrder() {
        //Se asigna el valor del tipo de procedimiento que viene de ser ejecutado,
        // 1 si es un NUEVO proveedor 
        // 2 si es un proveedor MODIFICADO
        int proceso = tipoOperacion;    
        
        //Se obtiene el rif y nombre del proveedor
        String supplierrif = tf_rif.getText();
        int orderrows = orders_new.size();
                
        //Si el nombre de usuario no esta en blanco
        if((supplierrif != null && !supplierrif.equals("")) &&
           (orderrows > 0)){
            //Ejecuta los procesos predeterminados para el guardado del proveedor
            setCurrentOperation();
            //Se asignan los valores del objeto 
            boolean result = false;
            Orders orders = new Orders();
            
            for (int i = 0; i < orders_new.size(); i++) {
                orders.setFecha(Date.valueOf(LocalDate.now()));
                orders.setIdSupplier(orders_new.get(i).getIdSupplier());
                orders.setRif(orders_new.get(i).getRif());
                orders.setNombre(orders_new.get(i).getNombre());
                orders.setFirma(orders_new.get(i).getFirma());
                orders.setFdespacho(orders_new.get(i).getFdespacho());
                orders.setLdespacho(orders_new.get(i).getLdespacho());
                orders.setNota(orders_new.get(i).getNota());
                orders.setUsr_creacion(orders_new.get(i).getUsr_creacion());
                orders.setUsr_supervisa(orders_new.get(i).getUsr_supervisa());
                orders.setStatenc(orders_new.get(i).getStatenc());
                orders.setNumorden(orders_new.get(i).getNumorden());
                orders.setIdProducto(orders_new.get(i).getIdProducto());
                orders.setDescrip(orders_new.get(i).getDescrip());
                orders.setCant_sol(orders_new.get(i).getCant_sol());
                orders.setId_unidsol(orders_new.get(i).getId_unidsol());
                orders.setUnidsol(orders_new.get(i).getUnidsol());
                orders.setCant_ent(orders_new.get(i).getCant_ent());
                orders.setId_unident(orders_new.get(i).getId_unident());
                orders.setUnident(orders_new.get(i).getUnident());
                orders.setCant_dif(orders_new.get(i).getCant_dif());
                orders.setId_uniddif(orders_new.get(i).getId_uniddif());
                orders.setUniddif(orders_new.get(i).getUniddif());
                orders.setCosto(orders_new.get(i).getCosto());
                orders.setPreciosug(orders_new.get(i).getPreciosug());
                orders.setObserv(orders_new.get(i).getObserv());
                orders.setStatdet(orders_new.get(i).getStatdet());
                orders.setStatord(orders_new.get(i).getStatord());

                if (i == numGuias)
                    proceso = 1;

                result = 
                        Ln.getInstance().save_orders(orders, proceso, i, ScreenName);
            }
            
            //Si el Resultado es correcto
            if(result){
                //Se Notifica al usuario
                tf_orden.setText(String.valueOf(Datos.getNumOrd_comp()));
                Gui.getInstance().showMessage("La " + ScreenName + " se ha Guardado Correctamente!", "I");
                return true;
            }     
        }else{                            
            Gui.getInstance().showMessage("No Existe ninguna " + ScreenName + " para ser Guardado!", "A");
        }
        return false;
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
                tf_orden.setEditable(true);
                tf_rif.setEditable(false);
                tf_prod.setEditable(false);
                tf_cant.setEditable(false);

                cb_unidad.setDisable(true);

                bt_orden.setDisable(false);
                bt_prov.setDisable(true);
                bt_prod.setDisable(true);

                //SE PERMITE: NUEVO, CANCELAR Y BUSCAR
                disables = new Integer[]{2,5,6,9,10};
                disableAllToolBar(disables); 
                break;
            case 1:  //NUEVO
                lb_Title.setText("NUEVO");
                tf_orden.setEditable(false);
                tf_rif.setEditable(true);
                tf_prod.setEditable(true);
                tf_cant.setEditable(true);

                cb_unidad.setDisable(false);

                bt_orden.setDisable(true);
                bt_prov.setDisable(false);
                bt_prod.setDisable(false);

                //SE PERMITE: NUEVO,GUARDAR Y CANCELAR             
                disables = new Integer[]{0,1,3,4,6,7,8,9,10,11};
                disableAllToolBar(disables);                            
                break;
            case 2:  //EDITAR
                lb_Title.setText("EDITAR");
                tf_orden.setEditable(false);
                tf_rif.setEditable(true);
                tf_prod.setEditable(true);
                tf_cant.setEditable(true);

                cb_unidad.setDisable(false);

                bt_orden.setDisable(true);
                bt_prov.setDisable(false);
                bt_prod.setDisable(false);

                //SE PERMITE: EDITAR,GUARDAR Y CANCELAR
                disables = new Integer[]{0,1,3,4,6,7,8,9,10,11};
                disableAllToolBar(disables);            
                break;
            case 3:  //GUARDAR
                tf_orden.setEditable(true);
                tf_rif.setEditable(false);
                tf_prod.setEditable(false);
                tf_cant.setEditable(false);

                cb_unidad.setDisable(true);

                bt_orden.setDisable(true);
                bt_prov.setDisable(false);
                bt_prod.setDisable(false);

                //SE PERMITE: GUARDAR Y CANCELAR
                disables = new Integer[]{0,1,3,4,6,7,8,9,10,11};
                disableAllToolBar(disables);   
                break;
            case 4:  //CAMBIAR STATUS 
                tf_orden.setEditable(true);
                tf_rif.setEditable(false);
                tf_prod.setEditable(false);
                tf_cant.setEditable(false);

                cb_unidad.setDisable(true);

                bt_orden.setDisable(true);
                bt_prov.setDisable(false);
                bt_prod.setDisable(false);

                //SE PERMITE: GUARDAR,CAMBIO STATUS Y CANCELAR
                disables = new Integer[]{0,1,2,4,6,7,8,9,10,11};
                disableAllToolBar(disables); 
                break;
        }        
        init_FocusArray(tipoOperacion);       
        Gui.getInstance().setTipoOperacion(tipoOperacion);
    }    
    /**
     * Procedimiento que obtiene los Distintos Motivos de la BD
     * y los carga en el COMBOBOX
     */
    private void loadUnits(){        
        Unit[] unit = Ln.getInstance().load_Unit();        
        final ObservableList<Unit> data = FXCollections.observableArrayList();
        data.addAll(Arrays.asList(unit)); 
        cb_unidad.setItems(data); 
        cb_unidad.getSelectionModel().select(3);
                
        Datos.setCbUnit(cb_unidad);              
        new SelectKeyComboBoxListener(cb_unidad);
    }  
    /**
     * Procedimiento que obtiene los Distintos Motivos de la BD
     * y los carga en el COMBOBOX
     */
    private void loadWeeks(){        
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        Calendar localCalendar = Calendar.getInstance(TimeZone.getDefault());
        int currentDayOfWeek = localCalendar.get(Calendar.DAY_OF_WEEK);
        
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();

        switch (currentDayOfWeek){
            case Calendar.MONDAY:
                c1.add(Calendar.DATE, 7);
                c2.add(Calendar.DATE, 11);
                break;
            case Calendar.TUESDAY:
                c1.add(Calendar.DATE, 6);
                c2.add(Calendar.DATE, 10);
                break;
            case Calendar.WEDNESDAY:
                c1.add(Calendar.DATE, 5);
                c2.add(Calendar.DATE, 9);
                break;
            case Calendar.THURSDAY:
                c1.add(Calendar.DATE, 4);
                c2.add(Calendar.DATE, 8);
                break;
            case Calendar.FRIDAY:
                c1.add(Calendar.DATE, 3);
                c2.add(Calendar.DATE, 7);
                break;
            case Calendar.SATURDAY:
                c1.add(Calendar.DATE, 2);
                c2.add(Calendar.DATE, 6); 
                break;
        }
        String dt1 = sdf.format(c1.getTime()); 
        String dt2 = sdf.format(c2.getTime()); 
        tf_fdespacho.setText(dt1 + " AL " + dt2);
    }
    /**
     * Procedimiento de llenado de datos en la tabla de datos
     */
    private void loadUSupervisa(){        
        final ObservableList<String> data = FXCollections.observableArrayList();
        data.add("ydeoliveira");
        cb_usupervisa.setItems(data);    
        cb_usupervisa.getSelectionModel().selectFirst();
    }
    /**
     * Procedimiento de llenado de datos en la tabla de datos
     */
    private void loadTable(){    
        if (tipoOperacion == 0){
            orders_new.clear();
            tb_table.setItems(orders_new);
        }else{
            tb_table.setItems(orders_new);
            tb_table.scrollTo(orders_new.size());
        }
    } 
    /**
     * Procedimiento de llenado de datos en la tabla de datos
     */
    private void loadOrders(Orders[] order){    
        if(order != null){
            Datos.setNumOrd_comp(String.valueOf(order[0].getIdOrden()));

            ObservableList<Orders> data = FXCollections.observableArrayList();
            data.addAll(Arrays.asList(order));   

            orders_new.clear();

            tf_orden.setText(String.valueOf(order[0].getIdOrden()));
            tf_rif.setText(order[0].getRif());
            tf_nombre.setText(order[0].getNombre());
            tf_fdespacho.setText(order[0].getFdespacho());
            tf_ldespacho.setText(order[0].getLdespacho());
            ta_nota.setText(order[0].getNota());
            cb_usupervisa.setValue(order[0].getUsr_supervisa());

            for (int i = 0; i < data.size(); i++) {
                Orders orders = new Orders();

                orders.setIdOrden(data.get(i).getIdOrden());
                orders.setFecha(data.get(i).getFecha());
                orders.setIdSupplier(data.get(i).getIdSupplier());
                orders.setRif(data.get(i).getRif());
                orders.setNombre(data.get(i).getNombre());
                orders.setFirma(data.get(i).getFirma());
                orders.setDireccion(data.get(i).getDireccion());
                orders.setCiudad(data.get(i).getCiudad());
                orders.setTelefonos(data.get(i).getTelefonos());
                orders.setFdespacho(data.get(i).getFdespacho());
                orders.setLdespacho(data.get(i).getLdespacho());
                orders.setNota(data.get(i).getNota());
                orders.setUsr_creacion(data.get(i).getUsr_creacion());
                orders.setUsr_ncreacion(data.get(i).getUsr_ncreacion());
                orders.setUsr_supervisa(data.get(i).getUsr_supervisa());
                orders.setUsr_nsupervisa(data.get(i).getUsr_nsupervisa());
                orders.setStatenc(data.get(i).getStatenc());

                orders.setNumorden(data.get(i).getNumorden());
                orders.setIdProducto(data.get(i).getIdProducto());
                orders.setDescrip(data.get(i).getDescrip());

                orders.setCant_sol(data.get(i).getCant_sol());
                orders.setId_unidsol(data.get(i).getId_unidsol());
                orders.setUnidsol(data.get(i).getUnidsol());

                orders.setCant_ent(data.get(i).getCant_ent());
                orders.setId_unident(data.get(i).getId_unident());
                orders.setUnident(data.get(i).getUnident());

                orders.setCant_dif(data.get(i).getCant_dif());
                orders.setId_uniddif(data.get(i).getId_uniddif());
                orders.setUniddif(data.get(i).getUniddif());

                orders.setCosto(data.get(i).getCosto());
                orders.setPreciosug(data.get(i).getPreciosug());
                orders.setObserv(data.get(i).getObserv());
                orders.setStatdet(data.get(i).getStatdet());
                orders.setCorreo(data.get(i).getCorreo());
                orders_new.add(orders);
            }
            tb_table.setItems(orders_new); 
        }
        else {
            botonInicio();
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
                    tf_orden, tf_rif, tf_prod, tf_descrip, tf_cant, cb_unidad, tf_fdespacho, 
                    cb_usupervisa, tf_ldespacho, ta_nota
                    };
                break;
            case 1:     //NUEVO
                nodos = new Node[]{
                    tf_orden, tf_rif, tf_prod, tf_descrip, tf_cant, cb_unidad, tf_fdespacho, 
                    cb_usupervisa, tf_ldespacho, ta_nota
                    };
                break;
            case 2:     //EDITAR
                nodos = new Node[]{
                    tf_orden, tf_rif, tf_prod, tf_descrip, tf_cant, cb_unidad, tf_fdespacho, 
                    cb_usupervisa, tf_ldespacho, ta_nota
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
            "Sin Asignar",
            "Orden de Compra ",
            "Agenda de Recepción ",
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
//        im_tool8.setVisible(false);
//        im_tool9.setVisible(false);
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
                            loadOrders(Datos.getRep_orders());     
                        }
                        else{
                            Gui.getInstance().showMessage("El Nro. de " + ScreenName + " NO existe!", "A");
                            tf_orden.requestFocus();
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
        //tf_orden.setText("");
        tf_rif.setText("");
        tf_nombre.setText("");
        tf_prod.setText("");
        tf_descrip.setText("");
        tf_cant.setText("");

        tf_buscar.setText("");
        tf_buscar.setVisible(false);
        
        Datos.setOrders(new Orders());                           
        refreshForm();                      
        Datos.setLog_cguias(null);                  //RESET DE LA VARIABLE
        setFormVisible(true);                      //OCULTA EL FORMULARIO
        //RECARGA LA TABLA ORIGINAL
        
        tf_ldespacho.setText("Almacen de Rosario, La Morita - Edo. Aragua");
        ta_nota.setText("Todos los productos deben tener impreso su respectivo REGISTRO SANITARIO y CPE.");

        tf_nombre.setDisable(true);
        tf_descrip.setDisable(true);
        ch_IvaAgent.setDisable(true);
        ch_t75.setDisable(true);
        ch_t100.setDisable(true);
        tf_fdespacho.setDisable(true);
        cb_usupervisa.setDisable(true);
        tf_ldespacho.setDisable(true);
        ta_nota.setDisable(true);

        loadWeeks();
        loadTable();

        tf_orden.requestFocus();
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

            tf_orden.setText("");
            tf_rif.requestFocus();
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
            boolean result = saveOrder();
            if (result)
                botonInicio();
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
            tf_orden.setText("");
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

        if(!orders_new.isEmpty()){
            ObservableList<Orders> data = FXCollections.observableArrayList();
            data.addAll(orders_new);   
            JRDs = new JRBeanCollectionDataSource(data, true);

            JrxmlParam.put("p_user", Datos.getSesion().getUsername());
            JrxmlParam.put("p_orden", "ORDEN DE COMPRA:  " + orders_new.get(0).getIdOrden());
            try{ 
                if(Datos.getSupplier().getCountry().getAbrev().equals("VE")){
                    jReport = (JasperReport) JRLoader.loadObjectFromFile(path + path_rep + "/compras/ord_com_port_ord_nac.jasper");
                }
                else{
                    jReport = (JasperReport) JRLoader.loadObjectFromFile(path + path_rep + "/compras/ord_com_port_ord_imp.jasper");
                }
                jPrint = JasperFillManager.fillReport(jReport, JrxmlParam, JRDs);

                jview = new JasperViewer(jPrint, false);
                jview.setTitle("DIGA - Ordenes de Compra (Compras) ");
            } catch (JRException ee){
                Gui.getInstance().showMessage("Error Cargando Reporte: \n" + ee.getMessage(), "E");
            }
            jview.setVisible(true);
            jview.setResizable(false);
        }
        else{
            Gui.getInstance().showMessage("Debe indicar un Nro. de Orden!", "A");
            tf_orden.requestFocus();
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
         * metodo para mostrar buscar el nro de RIF
         * param: ENTER O TAB
         */
        tf_orden.setOnKeyReleased((KeyEvent ke) -> {
            if (ke.getCode().equals(KeyCode.ENTER) || ke.getCode().equals(KeyCode.TAB)){
                if (!tf_orden.getText().isEmpty()){
                    if(((Node)ke.getSource()).getId().equals("tf_orden") &&
                            (tf_orden.getText().length() > 4)){
                        //Solicita los datos y envia la Respuesta a imprimirse en la Pantalla
                        Datos.setOrders(new Orders());                           
                        boolean boo = Ln.getInstance().check_orders(tf_orden.getText());                
                        if(boo){
                            Datos.setNumOrd_comp(tf_orden.getText());
                            Datos.setRep_orders(Ln.getInstance().find_orders(tf_orden.getText()));
                            loadOrders(Datos.getRep_orders());     

                            List<Supplier> data = Ln.getList_Supplier(Ln.getInstance().find_Supplier(orders_new.get(0).getRif()));
                            Datos.setSupplier(data.get(0));
                        }
                        else{
                            Gui.getInstance().showMessage("El Nro. de " + ScreenName + " NO existe!", "A");
                            tf_orden.requestFocus();
                        }
                    }
                }
                else{
                    botonInicio();
                    botonNuevo();
                }
            }
        });
        /**
         * BOTON ORDEN DE COMPRA
         */
        bt_orden.setOnMouseClicked((MouseEvent mouseEvent) -> {
            if(mouseEvent.getButton().equals(MouseButton.PRIMARY)){
                if(mouseEvent.getClickCount() > 0){
                    botonInicio();
                    Datos.setIdButton(1002011);
                    Gui.getInstance().showBusqueda("Orden de Compra");  
                }
            }
        });
        /**
         * metodo para mostrar buscar el nro de RIF
         * param: ENTER O TAB
         */
        tf_rif.setOnKeyReleased((KeyEvent ke) -> {
            if (ke.getCode().equals(KeyCode.ENTER) || ke.getCode().equals(KeyCode.TAB)){
                if (!tf_rif.getText().isEmpty()){
                    if(((Node)ke.getSource()).getId().equals("tf_rif") &&
                            (tf_rif.getText().length() > 0)){
                        //Solicita los datos y envia la Respuesta a imprimirse en la Pantalla
                        boolean boo = Ln.getInstance().check_Supplier(tf_rif.getText());
                        //Si el resultado el rif del proveedor ya Existe
                        if(Datos.getStSeniat() != 200)
                            boo = false;

                        if(boo){
                            List<Supplier> data = Ln.getList_Supplier(Ln.getInstance().find_Supplier(tf_rif.getText()));
                            Datos.setSupplier(data.get(0));
                            tf_rif.setText(Datos.getSupplier().getRif());
                            tf_nombre.setText(Datos.getSupplier().getNombre());

                            if (Datos.getSupplier().getSen_areten() == 1){
                                ch_IvaAgent.setSelected(true);
                            }
                            else{
                                ch_IvaAgent.setSelected(false);
                            }
                            switch (Datos.getSupplier().getSen_preten()){
                                case 75:
                                    ch_t75.setSelected(true);
                                    ch_t100.setSelected(false);
                                    break;
                                case 100:
                                    ch_t75.setSelected(false);
                                    ch_t100.setSelected(true);
                                    break;
                            }

                        }else{                                  
                        //    change_im_val(0, im_checkg); 
                            Gui.getInstance().showMessage("El Proveedor indicado NO existe!", "A");
                            tf_rif.requestFocus();
                        }
                    }
                }
                else{
                    Gui.getInstance().showMessage("Indicar el ID / Rif del Proveedor!", "A");
                    tf_rif.requestFocus();
                }
            }
        });
        /**
         * BOTON PROVEEDOR
         */
        bt_prov.setOnMouseClicked((MouseEvent mouseEvent) -> {
            if(mouseEvent.getButton().equals(MouseButton.PRIMARY)){
                if(mouseEvent.getClickCount() > 0){
                    Datos.setIdButton(1002012);
                    Gui.getInstance().showBusqueda("Proveedores");  
                }
            }
        });
        /**
         * metodo para mostrar buscar el nro de RIF
         * param: ENTER O TAB
         */
        tf_prod.setOnKeyReleased((KeyEvent ke) -> {
            if (ke.getCode().equals(KeyCode.ENTER) || ke.getCode().equals(KeyCode.TAB)){
//                if (!tf_prod.getText().isEmpty()){
                    if(((Node)ke.getSource()).getId().equals("tf_prod") &&
                            (tf_prod.getText().length() < 6)){

                        boolean boo = true;
                        if(numStatDet == 0){
                            for (int i = 0; i < orders_new.size(); i++) {
                                if(tf_prod.getText().equals(tb_table.getItems().get(i).getIdProducto())){
                                    boo = false;
                                    Gui.getInstance().showMessage("Este Producto ya esta relacionado!", "A");
                                    tf_prod.requestFocus();
                                    break;
                                }
                            } 
                        }

                        if(boo){
                            //Solicita los datos y envia la Respuesta a imprimirse en la Pantalla
                            Fxp_Inventa[] inventa = 
                                Ln.getInstance().find_inventa_prod_prov(tf_prod.getText(), String.valueOf(Datos.getSupplier().getIdSupplier()));

                            cb_unidad.getItems().clear();
                            if (inventa != null && inventa.length > 0){
                                switch(inventa[0].getEstado()){  
                                    case "A":     //HABILITADO
                                        change_im_val(200, im_checkp);
                                        break;
                                    case "I":     //DESHABILITADO
                                        change_im_val(0, im_checkp);
                                        break;   
                                }

                                tf_descrip.setText(inventa[0].getDescri());

                                final ObservableList<Unit> data = FXCollections.observableArrayList();

                                if (inventa[0].getTipoemba().getAbrev() == null){
                                    Unit[] unitUnida = Ln.getInstance().find_Unit(inventa[0].getTipounida().getAbrev());        
                                    data.addAll(Arrays.asList(unitUnida)); 
                                }
                                else {
                                    Unit[] unitEmb = Ln.getInstance().find_Unit(inventa[0].getTipoemba().getAbrev());        
                                    data.addAll(Arrays.asList(unitEmb)); 

                                    if (!inventa[0].getTipoemba().getAbrev().equals(inventa[0].getTipounida().getAbrev())){
                                        Unit[] unitUnida = Ln.getInstance().find_Unit(inventa[0].getTipounida().getAbrev());        
                                        data.addAll(Arrays.asList(unitUnida)); 
                                    }
                                }

                                cb_unidad.setItems(data); 
                                cb_unidad.getSelectionModel().selectFirst();        

                                tf_cant.requestFocus();
                            }
                            else{
                                Gui.getInstance().showMessage("Indicar el Código del Producto!", "A");
                                tf_prod.requestFocus();
                            }
                        }
                    }
//                }
//                else{
//                    Gui.getInstance().showMessage("Indicar el Código del Producto!", "A");
//                    tf_prod.requestFocus();
//                }
            }
        });
        /**
         * BOTON PRODUCTO
         */
        bt_prod.setOnMouseClicked((MouseEvent mouseEvent) -> {
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
        tf_cant.setOnKeyReleased((KeyEvent ke) -> {
            if (ke.getCode().equals(KeyCode.ENTER) || ke.getCode().equals(KeyCode.TAB)){
                //Valida que el evento se haya generado en el campo de busqueda
                if(((Node)ke.getSource()).getId().equals("tf_cant") &&
                        tf_cant.getText().isEmpty()){
                    Gui.getInstance().showMessage("Indicar la Cantidad del Producto!", "A");
                    tf_cant.requestFocus();
                }
            }
        });
         /**
         * metodo para mostrar buscar el nro de guia
         * param: ENTER 
         */
        cb_unidad.setOnKeyPressed((KeyEvent ke) -> {
            if (ke.getCode().equals(KeyCode.ENTER)){
                //Valida que el evento se haya generado en el campo de busqueda
                if(((Node)ke.getSource()).getId().equals("cb_unidad") &&
                        cb_unidad.getPromptText().isEmpty()){
                    //Solicita los datos y envia la Respuesta a imprimirse en la Pantalla
                    if (!cb_unidad.getValue().getAbrev().equals("")){
                        Orders orders = new Orders();
                        
                        orders.setIdOrden(0);
                        orders.setStatord("O");
                        orders.setFecha(Date.valueOf(LocalDate.now()));
                        orders.setIdSupplier(Datos.getSupplier().getIdSupplier());
                        orders.setRif(Datos.getSupplier().getRif());
                        orders.setNombre(Datos.getSupplier().getNombre());
                        orders.setFirma(Datos.getSupplier().getFirma());
                        orders.setFdespacho(tf_fdespacho.getText());
                        orders.setLdespacho(tf_ldespacho.getText());
                        orders.setNota(ta_nota.getText());
                        orders.setUsr_creacion(Datos.getSesion().getUsername());
                        orders.setUsr_supervisa(cb_usupervisa.getValue());
                        orders.setStatenc(0);

                        orders.setIdProducto(tf_prod.getText().toUpperCase());
                        orders.setDescrip(tf_descrip.getText());

                        orders.setCant_sol(Integer.parseInt(tf_cant.getText()));
                        Unit unit = (Unit) cb_unidad.getValue();            
                        orders.setId_unidsol(unit.getIdUnit());
                        orders.setUnidsol(unit.getAbrev());
                        
                        orders.setCant_ent(0);
                        orders.setId_unident(0);
                        orders.setUnident(null);

                        orders.setCant_dif(0);
                        orders.setId_uniddif(0);
                        orders.setUniddif(null);
                        
                        orders.setCosto(0);
                        orders.setPreciosug(0);
                        orders.setObserv(null);

                        if (numStatDet == 0){
                            orders.setStatdet(null);
                            orders.setNumorden(String.valueOf(orders_new.size() + 1));
                            orders_new.add(orders);
                        }
                        else{
                            orders.setStatdet("C");
                            orders.setNumorden(String.valueOf(numStatDet));
                            if (numStatDet == 1){
                                orders_new.remove(0);
                                orders_new.add(0, orders);
                            }
                            else{
                                orders_new.remove(numStatDet - 1);
                                orders_new.add(numStatDet - 1, orders);
                            }
                        }
                        loadTable();

                        tf_prod.setText("");
                        tf_descrip.setText("");
                        tf_cant.setText("");

                        numStatDet = 0;
                        
                        tf_prod.requestFocus();
                    } 
                    else{
                        Gui.getInstance().showMessage("Indicar la Cantidad del Producto!", "A");
                        cb_unidad.requestFocus();
                    }
                }
            }
        });
        /**
         * BOTON PROVEEDOR
         */
        hp_editar.setOnMouseClicked((MouseEvent mouseEvent) -> {
            if(mouseEvent.getButton().equals(MouseButton.PRIMARY)){
                if(mouseEvent.getClickCount() > 0){
                    switch (hp_editar.getText()){
                        case "Editar":
                            tf_fdespacho.setDisable(false);
                            cb_usupervisa.setDisable(false);
                            tf_ldespacho.setDisable(false);
                            ta_nota.setDisable(false);

                            hp_editar.setText("Guardar");
                            break;
                        case "Guardar":
                            tf_fdespacho.setDisable(true);
                            cb_usupervisa.setDisable(true);
                            tf_ldespacho.setDisable(true);
                            ta_nota.setDisable(true);

                            hp_editar.setText("Editar");
                            break;
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
