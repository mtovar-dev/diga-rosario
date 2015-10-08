/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI.Dialogs;

import GUI.Gui;
import LN.Ln;
import Objects.Orders.Orders;
import Objects.Orders.Supplier;
import Tools.Datos;
import java.math.RoundingMode;
import java.net.URL;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.util.Callback;

/**
 *
 * @author MITM
 */
public class Fxml_EmailController implements Initializable {
    @FXML 
    private AnchorPane ap_root; 
    
    @FXML 
    private Button bt_aceptar; 

    @FXML 
    private Button bt_correo; 

    @FXML 
    private Button bt_cancelar; 
    
    @FXML
    private DatePicker dp_fecha;
    
    @FXML
    private ImageView im_imp;

    @FXML
    private Label lb_b;

    @FXML 
    private Label lb_mensj; 

    @FXML
    private RadioButton rb_find11;
    
    @FXML
    private RadioButton rb_find12;
    
    @FXML
    private TableView<Object> tb_table;

    @FXML
    private TextField tf_buscar1;

    @FXML
    private TextField tf_buscar2;

    @FXML
    private TextField tf_rows;

    @FXML
    private VBox vb_1;

    @FXML
    private VBox vb_2;

    @FXML
    private VBox vb_b;
    

    private static final String path_dat = 
            java.util.ResourceBundle.getBundle("BD/DBcon").getString("path_dat");

    private static final String path_ima = 
            java.util.ResourceBundle.getBundle("BD/DBcon").getString("path_ima");

    private static final String path_rep = 
            java.util.ResourceBundle.getBundle("BD/DBcon").getString("path_rep");

    private static final String path_exp = 
            java.util.ResourceBundle.getBundle("BD/DBcon").getString("path_exp");

    private static String rows = 
            java.util.ResourceBundle.getBundle("BD/DBcon").getString("rows");

    private static final String path = System.getProperty("user.dir");
    
    final ToggleGroup rb_group = new ToggleGroup();

    boolean keybackspace = false;
    boolean print = false;

    /**
     * Initializes the controller class.
     * @param fxmlFileLocation
     * @param resources
     */     
    @Override // This method is called by the FXMLLoader when initialization is complete
    public void initialize(URL fxmlFileLocation, ResourceBundle resources) {
        assert ap_root != null : "fx:id=\"ap_root\" was not injected: check your FXML file 'Fxml_Email.fxml'.";
        assert dp_fecha != null : "fx:id=\"dp_fecha\" was not injected: check your FXML file 'Fxml_Email.fxml'."; 
        assert im_imp != null : "fx:id=\"im_imp\" was not injected: check your FXML file 'Fxml_Email.fxml'."; 
        assert lb_b != null : "fx:id=\"lb_b\" was not injected: check your FXML file 'Fxml_Email.fxml'."; 
        assert lb_mensj != null : "fx:id=\"lb_mensj\" was not injected: check your FXML file 'Fxml_Email.fxml'."; 
        assert tb_table != null : "fx:id=\"tb_table\" was not injected: check your FXML file 'Fxml_Email.fxml'.";
        assert tf_buscar1 != null : "fx:id=\"tf_buscar1\" was not injected: check your FXML file 'Fxml_Email.fxml'.";
        assert tf_buscar2 != null : "fx:id=\"tf_buscar2\" was not injected: check your FXML file 'Fxml_Email.fxml'.";
        assert tf_rows != null : "fx:id=\"tf_rows\" was not injected: check your FXML file 'Fxml_Email.fxml'.";
        assert vb_1 != null : "fx:id=\"vb_1\" was not injected: check your FXML file 'Fxml_Email.fxml'.";
        assert vb_2 != null : "fx:id=\"vb_2\" was not injected: check your FXML file 'Fxml_Email.fxml'.";
        assert vb_b != null : "fx:id=\"vb_b\" was not injected: check your FXML file 'Fxml_Email.fxml'.";

        // TODO        
        init_bt_aceptar();
        init_bt_correo();
        init_bt_cancelar();
        init_rb_group();
        
        createTable(Datos.getIdButton());  //Crea e Inicializa la Tabla de Datos                    
        init_screen_loads(Datos.getIdButton());
        
//        tf_buscar.requestFocus();
    }

    /***************************************************************************/
    /***************************** PROCEDIMIENTOS ******************************/
    /***************************************************************************/
    
    /**
    * Metodo encargado de Crear e inicializar la Tabla de Datos
    */
    private void createTable(int IdButton){

        switch (IdButton){
            case 1002011: // button orden de compra
            case 1002012: // button orden
            case 1002013: // button agenda
                TableColumn<Object, Object> col_ordenc        = new TableColumn("#");        
                TableColumn<Object, Object> col_fechac        = new TableColumn<>("Fecha");        
                TableColumn<Object, Object> col_numorden      = new TableColumn<>("Nro Orden");                
                TableColumn<Object, Object> col_idprovc       = new TableColumn<>("ID");                
                TableColumn<Object, Object> col_rifprovc      = new TableColumn<>("Rif");        
                TableColumn<Object, Object> col_nfiscalc      = new TableColumn<>("Nombre Fiscal");        
                TableColumn<Object, Object> col_fpersonalc    = new TableColumn<>("Firma Personal");        
                TableColumn<Object, Object> col_cantsol       = new TableColumn<>("Cant");        

                //Se establece el ancho de cada columna
                this.objectWidth(col_ordenc       , 34,  34); 
                this.objectWidth(col_fechac       , 66,  66);
                this.objectWidth(col_numorden     , 66,  66);
                this.objectWidth(col_idprovc      , 45,  45);
                this.objectWidth(col_rifprovc     , 75,  75);
                this.objectWidth(col_nfiscalc     , 278, 350);
                this.objectWidth(col_fpersonalc   , 200, 350);
                this.objectWidth(col_cantsol      , 60,  60);

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
                    col_ordenc, col_fechac, col_numorden, col_idprovc, col_nfiscalc, 
                    col_cantsol    
                    );   
                break;
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

    /***************************************************************************/
    /**************************** METODOS DE BOTONES ***************************/
    /***************************************************************************/
    
    /**
     * 
     */
    private void init_bt_aceptar(){
        assert bt_aceptar != null : "fx:id=\"bt_aceptar\" was not injected: check your FXML file 'Fxml_Email.fxml'.";

        /**
         * 
         */
        bt_aceptar.setOnMouseClicked((MouseEvent mouseEvent) -> {
            if(mouseEvent.getButton().equals(MouseButton.PRIMARY)){
                if(mouseEvent.getClickCount() > 0){
                    imprimir(Datos.getIdButton());
                }
            }
        });
        /**
         * 
         */
        bt_aceptar.setOnKeyReleased((KeyEvent ke) -> {
            if (ke.getCode().equals(KeyCode.ENTER)){
                imprimir(Datos.getIdButton());
            }
        });
         /**
         * metodo para mostrar buscar el nro de guia
         * param: ENTER O TAB
         */
        tf_buscar1.setOnKeyReleased((KeyEvent ke) -> {
            if (ke.getCode().equals(KeyCode.ENTER)){
                //Valida que el evento se haya generado en el campo de busqueda
                if(((Node)ke.getSource()).getId().equals("tf_buscar1")){
                    //Solicita los datos y envia la Respuesta a imprimirse en la Pantalla
                    imprimir(Datos.getIdButton());
                }
            }
        });
         /**
         * metodo para mostrar buscar el nro de guia
         * param: ENTER O TAB
         */
        tf_buscar2.setOnKeyReleased((KeyEvent ke) -> {
            if (ke.getCode().equals(KeyCode.ENTER)){
                //Valida que el evento se haya generado en el campo de busqueda
                if(((Node)ke.getSource()).getId().equals("tf_buscar2")){
                    //Solicita los datos y envia la Respuesta a imprimirse en la Pantalla
                    imprimir(Datos.getIdButton());
                }
            }
        });
         /**
         * metodo para mostrar buscar el nro de guia
         * param: ENTER O TAB
         */
        tf_rows.setOnKeyReleased((KeyEvent ke) -> {
            if (ke.getCode().equals(KeyCode.ENTER)){
                //Valida que el evento se haya generado en el campo de busqueda
                if(((Node)ke.getSource()).getId().equals("tf_rows")){
                    //Solicita los datos y envia la Respuesta a imprimirse en la Pantalla
                    tf_buscar1.requestFocus();
                }
            }
        });
        /**
         * SELECCION EN LA TABLA
         */
        tb_table.setOnMouseClicked((MouseEvent mouseEvent) -> {
            if(mouseEvent.getButton().equals(MouseButton.PRIMARY)){
                if(mouseEvent.getClickCount() > 1){
                    switch (Datos.getIdButton()){
                        case 1002011: // button orden de compra
                            Gui.setIdBusqueda(String.valueOf(((Orders) tb_table.getItems().get(tb_table.getSelectionModel().getSelectedIndex())).getIdOrden()));
                            break;
                    }
                    Gui.refreshIdBusqueda();
                    closeDialog();
                }
            }
        });        
    }
    
    /**
     * 
     */
    private void init_bt_correo(){
        assert bt_correo != null : "fx:id=\"bt_correo\" was not injected: check your FXML file 'Fxml_Email.fxml'.";
         
        /**
         * 
         */
        bt_correo.setOnMouseClicked((MouseEvent mouseEvent) -> {
            if(mouseEvent.getButton().equals(MouseButton.PRIMARY)){
                if(mouseEvent.getClickCount() > 0){
                    Gui.getInstance().showEmailSend();  
                }
            }
        });
        /**
         * 
         */
        bt_correo.setOnKeyReleased((KeyEvent ke) -> {
            if (ke.getCode().equals(KeyCode.ENTER)){
                Gui.getInstance().showEmailSend();  
            }
        });
    }

    /**
     * 
     */
    private void init_bt_cancelar(){
        assert bt_cancelar != null : "fx:id=\"bt_cancelar\" was not injected: check your FXML file 'Fxml_Email.fxml'.";
         
        /**
         * 
         */
        bt_cancelar.setOnMouseClicked((MouseEvent mouseEvent) -> {
            if(mouseEvent.getButton().equals(MouseButton.PRIMARY)){
                if(mouseEvent.getClickCount() > 0){
                    closeDialog();
                }
            }
        });
        /**
         * 
         */
        bt_cancelar.setOnKeyReleased((KeyEvent ke) -> {
            if (ke.getCode().equals(KeyCode.ENTER)){
                closeDialog();
            }
        });
    }

    /**
     * 
     */
    private void init_rb_group(){
        assert rb_find11 != null : "fx:id=\"rb_find1\" was not injected: check your FXML file 'Fxml_Email.fxml'."; 
        assert rb_find12 != null : "fx:id=\"rb_find2\" was not injected: check your FXML file 'Fxml_Email.fxml'."; 

        /**
         * Nro. Orden
         */
        rb_find11.setOnMouseClicked((MouseEvent mouseEvent) -> {
            if(mouseEvent.getButton().equals(MouseButton.PRIMARY)){
                if(mouseEvent.getClickCount() > 0){
                    tf_buscar1.setText("");
                    tf_buscar1.requestFocus();

                    dp_fecha.setEditable(false);
                    dp_fecha.setValue(null);
                }
            }
        });

        /**
         * Fecha
         */
        rb_find12.setOnMouseClicked((MouseEvent mouseEvent) -> {
            if(mouseEvent.getButton().equals(MouseButton.PRIMARY)){
                if(mouseEvent.getClickCount() > 0){
                    tf_buscar1.setText("");
                    tf_buscar2.setText("");
                    
                    dp_fecha.setEditable(true);
                    dp_fecha.setValue(LocalDate.now());
                    dp_fecha.requestFocus();
                }
            }
        });
    }
    /**
     * 
     */
    public static void closeDialog(){ 
        Gui.getInstance().closeDialog();
    }

    /**
     * @param lb_mensj the lb_error to set
     */
    public void setLb_mensj(String lb_mensj) {
        this.lb_mensj.setText(lb_mensj);
    }    


    /**
     * @author MITM
     * @param IdButton
     */
    private void imprimir(int IdButton){
        boolean result;
        
        tb_table.setItems(null);
        switch (IdButton){
            case 1002012: // button ordenes de compra
                if(rb_group.getSelectedToggle().getUserData().toString().equals("idorden")){
                    if(!tf_buscar1.getText().isEmpty() && tf_buscar2.getText().isEmpty()){
                        loadTableOrdCompra( Ln.getInstance().find_orders_id(tf_buscar1.getText()));  
                    }
                    if(!tf_buscar1.getText().isEmpty() && !tf_buscar2.getText().isEmpty()){
                        loadTableOrdCompra( Ln.getInstance().find_orders_ids(tf_buscar1.getText(), tf_buscar2.getText()));  
                    }
                }
                break;
            case 1002013: // button agenda
                if(rb_group.getSelectedToggle().getUserData().toString().equals("idorden")){
                    if(!tf_buscar1.getText().isEmpty() && tf_buscar2.getText().isEmpty()){
                        loadTableOrdCompra( Ln.getInstance().find_orders_id(tf_buscar1.getText()));  
                    }
                    if(!tf_buscar1.getText().isEmpty() && !tf_buscar2.getText().isEmpty()){
                        loadTableOrdCompra( Ln.getInstance().find_orders_ids(tf_buscar1.getText(), tf_buscar2.getText()));  
                    }
                }
                if(rb_group.getSelectedToggle().getUserData().toString().equals("date")){
                    if(tf_buscar1.getText().isEmpty() && tf_buscar2.getText().isEmpty()){
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                        loadTableOrdCompra( Ln.getInstance().find_orders_date(dp_fecha.getValue().format(formatter)));  
                    }
                }
                break;
        }
    }

    /**
     * Procedimiento que define los comportamientos en diversos Eventos 
     * de cada boton en la pantalla actual.
     * @param IdButton
     */
    private void init_screen_loads(int IdButton){
        boolean result;

        switch (IdButton){
            case 1002011: // button orden de compra
            case 1002012: // button orden de compra
            case 1002013: // button orden de compra
                lb_b.setText("Buscar Orden de Compra:");

                rb_find11.setToggleGroup(rb_group);
                rb_find11.setUserData("idorden");
                
                rb_find12.setToggleGroup(rb_group);
                rb_find12.setUserData("date");

                bt_correo.setDisable(true);
                break;
        }
        tf_buscar1.setText("");
        tf_buscar2.setText("");
        tf_buscar1.requestFocus();
    }

    /**
     * Procedimiento de llenado de datos en la tabla de datos
     */
    private void loadTableOrdCompra(Orders[] orders){  
        if(orders != null){
            ObservableList<Object> data = FXCollections.observableArrayList();        
            data.addAll(Arrays.asList(orders));   
            tb_table.setItems(data);    
            
            Datos.setRep_orders(orders);
            bt_correo.setDisable(false);
        }
    } 

}
