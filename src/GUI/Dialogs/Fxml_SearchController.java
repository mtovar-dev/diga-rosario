/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI.Dialogs;

import GUI.Gui;
import LN.Ln;
import Objects.Fxp_Archguid_cli;
import Objects.Fxp_Archguip_det;
import Objects.Infocent.Empleado;
import Objects.Orders.Orders;
import Objects.Orders.Supplier;
import Objects.log_CGuias;
import Objects.log_Personal;
import Objects.log_TSeguros;
import Objects.log_Vehiculos;
import Tools.Datos;
import java.math.RoundingMode;
import java.net.URL;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.ResourceBundle;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.util.Callback;

/**
 *
 * @author MITM
 */
public class Fxml_SearchController implements Initializable {
    @FXML 
    private AnchorPane ap_root; 
    
    @FXML 
    private Button bt_aceptar; 

    @FXML 
    private Button bt_cancelar; 
    
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
    private RadioButton rb_find13;

    @FXML
    private RadioButton rb_find14;
    
    @FXML
    private RadioButton rb_find21;

    @FXML
    private RadioButton rb_find22;

    @FXML
    private RadioButton rb_find23;

    @FXML
    private RadioButton rb_find24;

    @FXML
    private RadioButton rb_find25;

    @FXML
    private TableView<Object> tb_table;

    @FXML
    private TextField tf_buscar;

    @FXML
    private TextField tf_producto;

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

    /**
     * Initializes the controller class.
     * @param fxmlFileLocation
     * @param resources
     */     
    @Override // This method is called by the FXMLLoader when initialization is complete
    public void initialize(URL fxmlFileLocation, ResourceBundle resources) {
        assert ap_root != null : "fx:id=\"ap_root\" was not injected: check your FXML file 'Fxml_Search.fxml'.";
        assert im_imp != null : "fx:id=\"im_imp\" was not injected: check your FXML file 'Fxml_Search.fxml'."; 
        assert lb_b != null : "fx:id=\"lb_b\" was not injected: check your FXML file 'Fxml_Search.fxml'."; 
        assert lb_mensj != null : "fx:id=\"lb_mensj\" was not injected: check your FXML file 'Fxml_Search.fxml'."; 
        assert tb_table != null : "fx:id=\"tb_table\" was not injected: check your FXML file 'Fxml_Search.fxml'.";
        assert tf_buscar != null : "fx:id=\"tf_buscar\" was not injected: check your FXML file 'Fxml_Search.fxml'.";
        assert tf_producto != null : "fx:id=\"tf_producto\" was not injected: check your FXML file 'Fxml_Search.fxml'.";
        assert tf_rows != null : "fx:id=\"tf_rows\" was not injected: check your FXML file 'Fxml_Search.fxml'.";
        assert vb_1 != null : "fx:id=\"vb_1\" was not injected: check your FXML file 'Fxml_Search.fxml'.";
        assert vb_b != null : "fx:id=\"vb_b\" was not injected: check your FXML file 'Fxml_Search.fxml'.";

        vb_2.setVisible(false);

        // TODO        
        init_bt_aceptar();
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
            case 1002012: // button proveedores
                //Se crean y definen las columnas de la Tabla
                TableColumn<Object, Object> col_statprov    = new TableColumn<>("Act");
                TableColumn<Object, Object> col_idprov      = new TableColumn<>("ID");                
                TableColumn<Object, Object> col_rifprov     = new TableColumn<>("Rif");        
                TableColumn<Object, Object> col_nfiscal     = new TableColumn<>("Nombre Fiscal");        
                TableColumn<Object, Object> col_fpersonal   = new TableColumn<>("Firma Personal");        


                //Se establece el ancho de cada columna
                this.objectWidth(col_statprov    , 30,  30);
                this.objectWidth(col_idprov      , 45,  45);
                this.objectWidth(col_rifprov     , 75,  75);
                this.objectWidth(col_nfiscal     , 200, 350);
                this.objectWidth(col_fpersonal   , 200, 350);
                /**
                 * Sobreescritura de un metodo de la Columna, para sustituir el valor numerico 
                 * del STATUS del usuario por una Imagen segun el valor
                 * 1 - VERDE (HABILITADO)
                 * 2 - ROJO  (DESHABILITADO)
                 */
                col_statprov.setCellFactory(new Callback<TableColumn<Object, Object>, TableCell<Object, Object>>() {
                    @Override
                    public TableCell<Object, Object> call(TableColumn<Object, Object> param) {
                        return new TableCell<Object, Object>() {
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

                col_idprov.setCellFactory(new Callback<TableColumn<Object, Object>, TableCell<Object, Object>>() {
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

                //Se define la columna de la tabla con el nombre del atributo del objeto USUARIO correspondiente
                col_statprov.setCellValueFactory( 
                        new PropertyValueFactory<>("status") );
                col_idprov.setCellValueFactory( 
                        new PropertyValueFactory<>("idSupplier") );
                col_rifprov.setCellValueFactory( 
                        new PropertyValueFactory<>("rif") );
                col_nfiscal.setCellValueFactory( 
                        new PropertyValueFactory<>("nombre") );
                col_fpersonal.setCellValueFactory( 
                        new PropertyValueFactory<>("firma") );

                //Se Asigna ordenadamente las columnas de la tabla
                tb_table.getColumns().addAll(
                    col_statprov, col_idprov, col_rifprov, col_nfiscal, col_fpersonal
                    );   
                break;
            case 2003031: // button chofer
            case 2003034: // button ayudante 1
            case 2003035: // button ayudante 2
            case 2003036: // button chequeadores
            case 2003038: // button chequeadores
            case 2003042: // button sup. de ruta
                //Se crean y definen las columnas de la Tabla
                TableColumn<Object, Object> col_statper     = new TableColumn<>("Act");
                TableColumn<Object, Object> col_nroci       = new TableColumn<>("Nro CI");                
                TableColumn<Object, Object> col_nombres     = new TableColumn<>("Nombres");        
                TableColumn<Object, Object> col_apellidos   = new TableColumn<>("Apellidos");        
                TableColumn<Object, Object> col_tpersonal   = new TableColumn<>("T/Personal");        


                //Se establece el ancho de cada columna
                this.objectWidth(col_statper    , 30 , 30);
                this.objectWidth(col_nroci      , 70, 70);
                this.objectWidth(col_nombres    , 175, 200);
                this.objectWidth(col_apellidos  , 175, 200);
                this.objectWidth(col_tpersonal  , 100, 100);
                /**
                 * Sobreescritura de un metodo de la Columna, para sustituir el valor numerico 
                 * del STATUS del usuario por una Imagen segun el valor
                 * 1 - VERDE (HABILITADO)
                 * 2 - ROJO  (DESHABILITADO)
                 */
                col_statper.setCellFactory(new Callback<TableColumn<Object, Object>, TableCell<Object, Object>>() {
                    @Override
                    public TableCell<Object, Object> call(TableColumn<Object, Object> param) {
                        return new TableCell<Object, Object>() {
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

                //Se define la columna de la tabla con el nombre del atributo del objeto USUARIO correspondiente
                col_statper.setCellValueFactory( 
                        new PropertyValueFactory<>("status") );
                col_nroci.setCellValueFactory( 
                        new PropertyValueFactory<>("nro_ci") );
                col_nombres.setCellValueFactory( 
                        new PropertyValueFactory<>("nombres") );
                col_apellidos.setCellValueFactory( 
                        new PropertyValueFactory<>("apellidos") );
                col_tpersonal.setCellValueFactory( 
                        new PropertyValueFactory<>("tpersonal") );

                //Se Asigna ordenadamente las columnas de la tabla
                tb_table.getColumns().addAll(
                    col_statper, col_nroci, col_nombres, col_apellidos, col_tpersonal
                    );   
                break;
            case 2003032: // screen vehiculo 1
            case 2003033: // screen vehiculo 2
                //Se crean y definen las columnas de la Tabla
                TableColumn<Object, Object> col_statveh         = new TableColumn<>("Act");
                TableColumn<Object, Object> col_nroplaca        = new TableColumn<>("Nro Placa");                
                TableColumn<Object, Object> col_modelo          = new TableColumn<>("Modelo");        
                TableColumn<Object, Object> col_capacidad       = new TableColumn<>("Cap. Carga");        
                TableColumn<Object, Object> col_tmarca          = new TableColumn<>("T/Marca");

                //Se establece el ancho de cada columna
                this.objectWidth(col_statveh        , 30, 30);
                this.objectWidth(col_nroplaca       , 80, 80);
                this.objectWidth(col_modelo         , 130, 200);
                this.objectWidth(col_capacidad      , 90, 90);
                this.objectWidth(col_tmarca         , 100, 150);
                /**
                 * Sobreescritura de un metodo de la Columna, para sustituir el valor numerico 
                 * del STATUS del usuario por una Imagen segun el valor
                 * 1 - VERDE (HABILITADO)
                 * 2 - ROJO  (DESHABILITADO)
                 */
                col_statveh.setCellFactory(new Callback<TableColumn<Object, Object>, TableCell<Object, Object>>() {
                    @Override
                    public TableCell<Object, Object> call(TableColumn<Object, Object> param) {
                        return new TableCell<Object, Object>() {
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

                col_nroplaca.setCellFactory(new Callback<TableColumn<Object, Object>, TableCell<Object, Object>>() {
                    @Override
                    public TableCell call(TableColumn param) {
                        return new TableCell<Object, String>() {
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
                col_statveh.setCellValueFactory( 
                        new PropertyValueFactory<>("status") );
                col_nroplaca.setCellValueFactory( 
                        new PropertyValueFactory<>("idPlaca") );
                col_modelo.setCellValueFactory( 
                        new PropertyValueFactory<>("modelo") );
                col_capacidad.setCellValueFactory( 
                        new PropertyValueFactory<>("capacidad") );
                col_tmarca.setCellValueFactory( 
                        new PropertyValueFactory<>("tmarca") );

                //Se Asigna ordenadamente las columnas de la tabla
                tb_table.getColumns().addAll(
                    col_statveh, col_nroplaca, col_modelo, col_capacidad, col_tmarca
                    );                
                break;
            case 2003037: // screen Guia de Carga
                //Se crean y definen las columnas de la Tabla
                TableColumn<Object, Object> col_nroguia        = new TableColumn<>("Nro Guia");                

                //Se establece el ancho de cada columna
                this.objectWidth(col_nroguia       , 80, 80);
                //Se define la columna de la tabla con el nombre del atributo del objeto USUARIO correspondiente
                col_nroguia.setCellValueFactory( 
                        new PropertyValueFactory<>("nroguia") );

                //Se Asigna ordenadamente las columnas de la tabla
                tb_table.getColumns().addAll(
                    col_nroguia
                    );                
                break;
            case 2003039: // screen Producto
                TableColumn<Object, Object> col_statpro     = new TableColumn<>("Act");
                TableColumn<Object, Object> col_codigop     = new TableColumn<>("Código");                
                TableColumn<Object, Object> col_unidad      = new TableColumn<>("Unidad");        
                TableColumn<Object, Object> col_descrip     = new TableColumn<>("Descripción");        

                //Se establece el ancho de cada columna
                this.objectWidth(col_statpro     , 30,  30);
                this.objectWidth(col_codigop     , 55,  55);
                this.objectWidth(col_unidad      , 90,  90);
                this.objectWidth(col_descrip     , 320, 320);
                /**
                 * Sobreescritura de un metodo de la Columna, para sustituir el valor numerico 
                 * del STATUS del usuario por una Imagen segun el valor
                 * 1 - VERDE (HABILITADO)
                 * 2 - ROJO  (DESHABILITADO)
                 */
                col_statpro.setCellFactory(new Callback<TableColumn<Object, Object>, TableCell<Object, Object>>() {
                    @Override
                    public TableCell<Object, Object> call(TableColumn<Object, Object> param) {
                        return new TableCell<Object, Object>() {
                            @Override
                            public void updateItem(Object item, boolean empty) {
                                super.updateItem(item, empty);
                                if(!empty){
                                    switch(item.toString()){  
                                        case "A":     //DESHABILITADO
                                            setGraphic(new ImageView(new Image(getClass().getResourceAsStream("/Images/img57.png"), 15, 15, false,false))); 
                                            break;
                                        case "I":     //HABILITADO
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

                col_codigop.setCellFactory(new Callback<TableColumn<Object, Object>, TableCell<Object, Object>>() {
                    @Override
                    public TableCell call(TableColumn param) {
                        return new TableCell<Object, String>() {
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
                col_statpro.setCellValueFactory( 
                        new PropertyValueFactory<>("estado") );
                col_codigop.setCellValueFactory( 
                        new PropertyValueFactory<>("codigo") );
                col_unidad.setCellValueFactory( 
                        new PropertyValueFactory<>("unidad") );
                col_descrip.setCellValueFactory( 
                        new PropertyValueFactory<>("descrip") );

                //Se Asigna ordenadamente las columnas de la tabla
                tb_table.getColumns().addAll(
                        col_statpro, col_codigop, col_unidad, col_descrip
                        );                
                break;
            case 2003040: // screen Cliente 
                TableColumn<Object, Object> col_statcli      = new TableColumn<>("Act");
                TableColumn<Object, Object> col_codigoc      = new TableColumn<>("Código");                
                TableColumn<Object, Object> col_cliente      = new TableColumn<>("Cliente");        
                TableColumn<Object, Object> col_rif          = new TableColumn<>("Rif");        

                //Se establece el ancho de cada columna
                this.objectWidth(col_statcli     , 30,  30);
                this.objectWidth(col_codigoc     , 100, 100);
                this.objectWidth(col_cliente     , 320, 320);
                this.objectWidth(col_rif         , 90,  90);
                /**
                 * Sobreescritura de un metodo de la Columna, para sustituir el valor numerico 
                 * del STATUS del usuario por una Imagen segun el valor
                 * 1 - VERDE (HABILITADO)
                 * 2 - ROJO  (DESHABILITADO)
                 */
                col_statcli.setCellFactory(new Callback<TableColumn<Object, Object>, TableCell<Object, Object>>() {
                    @Override
                    public TableCell<Object, Object> call(TableColumn<Object, Object> param) {
                        return new TableCell<Object, Object>() {
                            @Override
                            public void updateItem(Object item, boolean empty) {
                                super.updateItem(item, empty);
                                if(!empty){
                                    switch(item.toString()){  
                                        case "A":     //DESHABILITADO
                                            setGraphic(new ImageView(new Image(getClass().getResourceAsStream("/Images/img57.png"), 15, 15, false,false))); 
                                            break;
                                        case "I":     //HABILITADO
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

                col_codigoc.setCellFactory(new Callback<TableColumn<Object, Object>, TableCell<Object, Object>>() {
                    @Override
                    public TableCell call(TableColumn param) {
                        return new TableCell<Object, String>() {
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

                col_rif.setCellFactory(new Callback<TableColumn<Object, Object>, TableCell<Object, Object>>() {
                    @Override
                    public TableCell call(TableColumn param) {
                        return new TableCell<Object, String>() {
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
                col_statcli.setCellValueFactory( 
                        new PropertyValueFactory<>("estado") );
                col_codigoc.setCellValueFactory( 
                        new PropertyValueFactory<>("codigo") );
                col_cliente.setCellValueFactory( 
                        new PropertyValueFactory<>("descrip") );
                col_rif.setCellValueFactory( 
                        new PropertyValueFactory<>("rif") );

                //Se Asigna ordenadamente las columnas de la tabla
                tb_table.getColumns().addAll(
                        col_statcli, col_codigoc, col_cliente, col_rif
                        );                
                break;
            case 2003041: // screen Guia Avanzada
                TableColumn<Object, Object> col_orden        = new TableColumn("#");        
                TableColumn<Object, Object> col_fecha        = new TableColumn<>("Fecha");        
                TableColumn<Object, Object> col_numrela      = new TableColumn<>("Relación");
                TableColumn<Object, Object> col_numguia      = new TableColumn<>("Guia");                
                TableColumn<Object, Object> col_statrel      = new TableColumn<>("S");        
                TableColumn<Object, Object> col_vehiculo     = new TableColumn<>("Nro Placa");        
                TableColumn<Object, Object> col_chofer       = new TableColumn<>("Chofer");        
                TableColumn<Object, Object> col_nrocig       = new TableColumn<>("Nro CI");        

                //Se establece el ancho de cada columna
                this.objectWidth(col_orden       , 34,  34); 
                this.objectWidth(col_fecha       , 66,  66);
                this.objectWidth(col_numrela     , 66,  66);
                this.objectWidth(col_numguia     , 66,  66);
                this.objectWidth(col_statrel     , 18,  18);
                this.objectWidth(col_vehiculo    , 66,  66);
                this.objectWidth(col_chofer      , 170, 300);
                this.objectWidth(col_nrocig      , 64,  64);
                /**
                 * Sobreescritura de un metodo de la Columna, para sustituir el valor numerico 
                 * del STATUS del usuario por una Imagen segun el valor
                 * 1 - VERDE (HABILITADO)
                 * 2 - ROJO  (DESHABILITADO)
                 */
                col_fecha.setCellFactory(new Callback<TableColumn<Object, Object>, TableCell<Object, Object>>() {
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

                col_numrela.setCellFactory(new Callback<TableColumn<Object, Object>, TableCell<Object, Object>>() {
                    @Override
                    public TableCell call(TableColumn param) {
                        return new TableCell<Object, String>() {
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

                col_numguia.setCellFactory(new Callback<TableColumn<Object, Object>, TableCell<Object, Object>>() {
                    @Override
                    public TableCell call(TableColumn param) {
                        return new TableCell<Object, String>() {
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

                col_statrel.setCellFactory(new Callback<TableColumn<Object, Object>, TableCell<Object, Object>>() {
                    @Override
                    public TableCell call(TableColumn param) {
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

                col_vehiculo.setCellFactory(new Callback<TableColumn<Object, Object>, TableCell<Object, Object>>() {
                    @Override
                    public TableCell call(TableColumn param) {
                        return new TableCell<Object, String>() {
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

                col_nrocig.setCellFactory(new Callback<TableColumn<Object, Object>, TableCell<Object, Object>>() {
                    @Override
                    public TableCell call(TableColumn param) {
                        return new TableCell<Object, String>() {
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
                col_fecha.setCellValueFactory( 
                        new PropertyValueFactory<>("fecha") );
                col_numrela.setCellValueFactory( 
                        new PropertyValueFactory<>("numrela") );
                col_numguia.setCellValueFactory( 
                        new PropertyValueFactory<>("numguia") );
                col_statrel.setCellValueFactory( 
                        new PropertyValueFactory<>("stat_guia") );
                col_vehiculo.setCellValueFactory( 
                        new PropertyValueFactory<>("veh1") );
                col_chofer.setCellValueFactory( 
                        new PropertyValueFactory<>("schofer") );
                col_nrocig.setCellValueFactory( 
                        new PropertyValueFactory<>("chofer") );

                //Se Asigna ordenadamente las columnas de la tabla
                tb_table.getColumns().addAll(
                        col_orden, col_fecha, col_numrela, col_numguia, 
                        col_statrel, col_vehiculo, col_chofer, col_nrocig);                

                //Se Asigna menu contextual 
                tb_table.setRowFactory((TableView<Object> tableView) -> {
                    final TableRow<Object> row = new TableRow<>();
                    final ContextMenu contextMenu = new ContextMenu();
                    final MenuItem NumVhMenuItem = new MenuItem("Copiar Placa");
                    final MenuItem NumCiMenuItem = new MenuItem("Copiar Cedula");

                    contextMenu.getItems().add(NumVhMenuItem);
                    NumVhMenuItem.setOnAction((ActionEvent event) -> {
                        rb_find21.setSelected(true);
                        tf_buscar.setText(((log_CGuias) tb_table.getItems().get(tb_table.getSelectionModel().getSelectedIndex())).getVeh1());
                    });

                    contextMenu.getItems().add(NumCiMenuItem);
                    NumCiMenuItem.setOnAction((ActionEvent event) -> {
                        rb_find22.setSelected(true);
                        tf_buscar.setText(((log_CGuias) tb_table.getItems().get(tb_table.getSelectionModel().getSelectedIndex())).getChofer());
                    });

                    // Set context menu on row, but use a binding to make it only show for non-empty rows:
                    row.contextMenuProperty().bind(
                        Bindings.when(row.emptyProperty())
                            .then((ContextMenu)null)
                            .otherwise(contextMenu)
                    );
                    return row ;  
                });
                break;
            case 2005011: // screen Cliente 
                TableColumn<Object, Object> col_statseg      = new TableColumn<>("Act");
                TableColumn<Object, Object> col_codigos      = new TableColumn<>("Código");                
                TableColumn<Object, Object> col_seguro       = new TableColumn<>("Empresa de Seguro");        

                //Se establece el ancho de cada columna
                this.objectWidth(col_statseg     , 30,  30);
                this.objectWidth(col_codigos     , 100, 100);
                this.objectWidth(col_seguro      , 320, 320);
                /**
                 * Sobreescritura de un metodo de la Columna, para sustituir el valor numerico 
                 * del STATUS del usuario por una Imagen segun el valor
                 * 1 - VERDE (HABILITADO)
                 * 2 - ROJO  (DESHABILITADO)
                 */
                col_statseg.setCellFactory(new Callback<TableColumn<Object, Object>, TableCell<Object, Object>>() {
                    @Override
                    public TableCell<Object, Object> call(TableColumn<Object, Object> param) {
                        return new TableCell<Object, Object>() {
                            @Override
                            public void updateItem(Object item, boolean empty) {
                                super.updateItem(item, empty);
                                if(!empty){
                                    switch(item.toString()){  
                                        case "A":     //DESHABILITADO
                                            setGraphic(new ImageView(new Image(getClass().getResourceAsStream("/Images/img57.png"), 15, 15, false,false))); 
                                            break;
                                        case "I":     //HABILITADO
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

                col_codigos.setCellFactory(new Callback<TableColumn<Object, Object>, TableCell<Object, Object>>() {
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

                //Se define la columna de la tabla con el nombre del atributo del objeto USUARIO correspondiente
                col_statseg.setCellValueFactory( 
                        new PropertyValueFactory<>("status") );
                col_codigos.setCellValueFactory( 
                        new PropertyValueFactory<>("idTSeguro") );
                col_seguro.setCellValueFactory( 
                        new PropertyValueFactory<>("nombre") );

                //Se Asigna ordenadamente las columnas de la tabla
                tb_table.getColumns().addAll(
                        col_statseg, col_codigos, col_seguro
                        );                
                break;
            case 7001021: // button empleados
                //Se crean y definen las columnas de la Tabla
                TableColumn<Object, Object> col_inroci       = new TableColumn<>("Nro CI");                
                TableColumn<Object, Object> col_ificha       = new TableColumn<>("Ficha");                
                TableColumn<Object, Object> col_inombres     = new TableColumn<>("Nombres");        
                TableColumn<Object, Object> col_iapellidos   = new TableColumn<>("Apellidos");        
                TableColumn<Object, Object> col_ifecing      = new TableColumn<>("Fec. Ingreso");        

                //Se establece el ancho de cada columna
                this.objectWidth(col_inroci      , 80, 80);
                this.objectWidth(col_ificha      , 80, 80);
                this.objectWidth(col_inombres    , 150, 200);
                this.objectWidth(col_iapellidos  , 150, 200);
                this.objectWidth(col_ifecing     , 85, 85);

                col_inroci.setCellFactory(new Callback<TableColumn<Object, Object>, TableCell<Object, Object>>() {
                    @Override
                    public TableCell call(TableColumn param) {
                        return new TableCell<Object, String>() {
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

                col_ificha.setCellFactory(new Callback<TableColumn<Object, Object>, TableCell<Object, Object>>() {
                    @Override
                    public TableCell call(TableColumn param) {
                        return new TableCell<Object, String>() {
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
                col_inroci.setCellValueFactory( 
                        new PropertyValueFactory<>("cedula") );
                col_ificha.setCellValueFactory( 
                        new PropertyValueFactory<>("ficha") );
                col_inombres.setCellValueFactory( 
                        new PropertyValueFactory<>("nombre") );
                col_iapellidos.setCellValueFactory( 
                        new PropertyValueFactory<>("apellido") );
                col_ifecing.setCellValueFactory( 
                        new PropertyValueFactory<>("fecha_ingreso") );

                //Se Asigna ordenadamente las columnas de la tabla
                tb_table.getColumns().addAll(
                    col_inroci, col_ificha, col_inombres, col_iapellidos, col_ifecing
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
        assert bt_aceptar != null : "fx:id=\"bt_aceptar\" was not injected: check your FXML file 'Fxml_Search.fxml'.";

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
        tf_buscar.setOnKeyReleased((KeyEvent ke) -> {
            if (ke.getCode().equals(KeyCode.ENTER)){
                //Valida que el evento se haya generado en el campo de busqueda
                if(((Node)ke.getSource()).getId().equals("tf_buscar")){
                    //Solicita los datos y envia la Respuesta a imprimirse en la Pantalla
                    imprimir(Datos.getIdButton());
                }
            }
        });
         /**
         * metodo para mostrar buscar el nro de guia
         * param: ENTER O TAB
         */
        tf_producto.setOnKeyReleased((KeyEvent ke) -> {
            if (ke.getCode().equals(KeyCode.ENTER)){
                //Valida que el evento se haya generado en el campo de busqueda
                if(((Node)ke.getSource()).getId().equals("tf_producto")){
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
                    tf_buscar.requestFocus();
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
                        case 1002012: // button proveedores
                            Gui.setIdBusqueda(((Supplier) tb_table.getItems().get(tb_table.getSelectionModel().getSelectedIndex())).getRif());
                            break;
                        case 2003031: // button chofer
                        case 2003034: // button ayudante 1
                        case 2003035: // button ayudante 2
                        case 2003036: // button Chequeadores
                        case 2003038: // button Chequeadores
                        case 2003042: // button sup. de ruta
                            Gui.setIdBusqueda(((log_Personal) tb_table.getItems().get(tb_table.getSelectionModel().getSelectedIndex())).getNro_ci());
                            break;
                        case 2003032: // screen vehiculo 1
                        case 2003033: // screen vehiculo 2
                            Gui.setIdBusqueda(((log_Vehiculos) tb_table.getItems().get(tb_table.getSelectionModel().getSelectedIndex())).getIdPlaca());
                            break;
                        case 2003037: // screen Guia de Carga
                            break;
                        case 2003039: // screen Producto
                            Gui.setIdBusqueda(((Fxp_Archguip_det) tb_table.getItems().get(tb_table.getSelectionModel().getSelectedIndex())).getCodigo());
                            break;
                        case 2003040: // screen Cliente
                            Gui.setIdBusqueda(((Fxp_Archguid_cli) tb_table.getItems().get(tb_table.getSelectionModel().getSelectedIndex())).getCliente());
                            break;
                        case 2003041: // screen Guia Avanzada
                            Gui.setIdBusqueda(((log_CGuias) tb_table.getItems().get(tb_table.getSelectionModel().getSelectedIndex())).getNumrela());
                            break;
                        case 2005011: // screen Aseguradora
                            Gui.setIdBusqueda(String.valueOf(((log_TSeguros) tb_table.getItems().get(tb_table.getSelectionModel().getSelectedIndex())).getIdTSeguro()));
                        case 7001021: // screen Guia Avanzada
                            Gui.setIdBusqueda(((Empleado) tb_table.getItems().get(tb_table.getSelectionModel().getSelectedIndex())).getCedula());
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
    private void init_bt_cancelar(){
        assert bt_cancelar != null : "fx:id=\"bt_cancelar\" was not injected: check your FXML file 'Fxml_Search.fxml'.";
         
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
        assert rb_find11 != null : "fx:id=\"rb_find1\" was not injected: check your FXML file 'Fxml_Search.fxml'."; 
        assert rb_find12 != null : "fx:id=\"rb_find2\" was not injected: check your FXML file 'Fxml_Search.fxml'."; 
        assert rb_find13 != null : "fx:id=\"rb_find3\" was not injected: check your FXML file 'Fxml_Search.fxml'."; 
        assert rb_find14 != null : "fx:id=\"rb_find4\" was not injected: check your FXML file 'Fxml_Search.fxml'."; 
        assert rb_find21 != null : "fx:id=\"rb_find5\" was not injected: check your FXML file 'Fxml_Search.fxml'."; 
        assert rb_find22 != null : "fx:id=\"rb_find6\" was not injected: check your FXML file 'Fxml_Search.fxml'."; 
        assert rb_find23 != null : "fx:id=\"rb_find7\" was not injected: check your FXML file 'Fxml_Search.fxml'."; 
        assert rb_find24 != null : "fx:id=\"rb_find8\" was not injected: check your FXML file 'Fxml_Search.fxml'."; 
        assert rb_find25 != null : "fx:id=\"rb_find9\" was not injected: check your FXML file 'Fxml_Search.fxml'."; 

        /**
         * Nro. Guia
         */
        rb_find11.setOnMouseClicked((MouseEvent mouseEvent) -> {
            if(mouseEvent.getButton().equals(MouseButton.PRIMARY)){
                if(mouseEvent.getClickCount() > 0){
                    tf_buscar.setText("");
                    tf_buscar.requestFocus();
                }
            }
        });

        /**
         * Nro. Factura
         */
        rb_find12.setOnMouseClicked((MouseEvent mouseEvent) -> {
            if(mouseEvent.getButton().equals(MouseButton.PRIMARY)){
                if(mouseEvent.getClickCount() > 0){
                    tf_buscar.setText("");
                    tf_buscar.requestFocus();
                }
            }
        });

        /**
         * Nro. Faltante
         */
        rb_find13.setOnMouseClicked((MouseEvent mouseEvent) -> {
            if(mouseEvent.getButton().equals(MouseButton.PRIMARY)){
                if(mouseEvent.getClickCount() > 0){
                    tf_buscar.setText("");
                    tf_buscar.requestFocus();
                }
            }
        });

        /**
         * Producto
         */
        rb_find14.setOnMouseClicked((MouseEvent mouseEvent) -> {
            if(mouseEvent.getButton().equals(MouseButton.PRIMARY)){
                if(mouseEvent.getClickCount() > 0){
                    //tf_buscar.setText("");
                    tf_producto.requestFocus();
                }
            }
        });

        /**
         * Vehiculo
         */
        rb_find21.setOnMouseClicked((MouseEvent mouseEvent) -> {
            if(mouseEvent.getButton().equals(MouseButton.PRIMARY)){
                if(mouseEvent.getClickCount() > 0){
                    tf_buscar.setText("");
                    tf_buscar.requestFocus();
                }
            }
        });

        /**
         * Chofer
         */
        rb_find22.setOnMouseClicked((MouseEvent mouseEvent) -> {
            if(mouseEvent.getButton().equals(MouseButton.PRIMARY)){
                if(mouseEvent.getClickCount() > 0){
                    tf_buscar.setText("");
                    tf_buscar.requestFocus();
                }
            }
        });

        /**
         * Ayudante
         */
        rb_find23.setOnMouseClicked((MouseEvent mouseEvent) -> {
            if(mouseEvent.getButton().equals(MouseButton.PRIMARY)){
                if(mouseEvent.getClickCount() > 0){
                    tf_buscar.setText("");
                    tf_buscar.requestFocus();
                }
            }
        });

        /**
         * Chequeador
         */
        rb_find24.setOnMouseClicked((MouseEvent mouseEvent) -> {
            if(mouseEvent.getButton().equals(MouseButton.PRIMARY)){
                if(mouseEvent.getClickCount() > 0){
                    tf_buscar.setText("");
                    tf_buscar.requestFocus();
                }
            }
        });

        /**
         * Sup. de Ruta
         */
        rb_find25.setOnMouseClicked((MouseEvent mouseEvent) -> {
            if(mouseEvent.getButton().equals(MouseButton.PRIMARY)){
                if(mouseEvent.getClickCount() > 0){
                    tf_buscar.setText("");
                    tf_buscar.requestFocus();
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
            case 1002011: // button ordenes de compra
                switch (tf_buscar.getText().length()){
                    case 0:
                        loadTableOrdCompra( Ln.getInstance().find_orders_all(Integer.parseInt(tf_rows.getText())));  
                        break;
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                        loadTableOrdCompra( Ln.getInstance().find_orders_id(tf_buscar.getText()));  
                        break;
                    case 10:
                        loadTableOrdCompra( Ln.getInstance().find_orders_date(tf_buscar.getText()));  
                        break;
                }
                
                break;
            case 1002012: // button proveedores
                loadTableProv( Ln.getInstance().find_Supplier(tf_buscar.getText()));  
                break;
            case 2003031: // button chofer
                loadTablePer( Ln.getInstance().find_log_Personal_tp(tf_buscar.getText(), 3, 4));  
                break;
            case 2003032: // screen vehiculo 1
            case 2003033: // screen vehiculo 2
                loadTableVeh( Ln.getInstance().find_log_Vehiculos(tf_buscar.getText()));  
                break;
            case 2003034: // button ayudante 1
            case 2003035: // button ayudante 2
                loadTablePer( Ln.getInstance().find_log_Personal_tp(tf_buscar.getText(), 5, 6));  
                break;
            case 2003036: // button chequeadores
            case 2003038: // button chequeadores
                loadTablePer( Ln.getInstance().find_log_Personal_tp(tf_buscar.getText(), 1, 7));  
                break;
            case 2003037: // button Guia de Carga
                //loadTablePer( Ln.getInstance().find_log_Personal_tp(tf_buscar.getText(), 2, 2));  
                break;
            case 2003039: // screen Producto
                loadTablePro( Ln.getInstance().find_Archguip_pro_det(tf_buscar.getText()));  
                break;
            case 2003040: // screen Cliente
                loadTableCli( Ln.getInstance().find_Archguid_cli(tf_buscar.getText()));  
                break;
            case 2003041: // screen Guia Avanzada
                if (rb_group.getSelectedToggle() != null){
                    if (tf_rows.getText().isEmpty() && tf_rows.getText().equals(""))
                        tf_rows.setText(rows);

                    loadTableGui(Ln.getInstance().find_log_CGuias(
                        tf_buscar.getText(), tf_producto.getText(), 
                        rb_group.getSelectedToggle().getUserData().toString(), Integer.parseInt(tf_rows.getText())));  
                }
                else{
                    Gui.getInstance().showMessage("Debe indicar el Parametro de Busqueda!", "A");
                }
                    
                break;            
            case 2003042: // button sup de ruta
                loadTablePer( Ln.getInstance().find_log_Personal_tp(tf_buscar.getText(), 7, 7));  
                break;
            case 2005011: // screen Aseguradora
                loadTableEmpSeg( Ln.getInstance().find_log_TSeguros(tf_buscar.getText()));  
                break;
            case 7001021: // screen Guia Avanzada
                loadTableEmpInfocent( Ln.getInstance().find_Empelado(tf_buscar.getText().toUpperCase()));  
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

        tf_producto.setVisible(false);
        switch (IdButton){
            case 1002011: // button orden de compra
                lb_b.setText("Buscar Orden de Compra:");
                imprimir(Datos.getIdButton());
                break;
            case 1002012: // button proveedores
                lb_b.setText("Buscar Proveedor:");
                break;
            case 2003031: // button chofer
            case 2003034: // button ayudante 1
            case 2003035: // button ayudante 2
            case 2003036: // button chequeadores
            case 2003038: // button chequeadores
            case 2003042: // button sup. de ruta
                lb_b.setText("Buscar texto (Cédula o Nombres o Apellidos):");
                break;
            case 2003032: // screen vehiculo 1
            case 2003033: // screen vehiculo 2
                lb_b.setText("Buscar texto (Placa o Modelo o Empresa):");
                break;
            case 2003037: // screen vehiculo 2
                lb_b.setText("Buscar Nro de Guia por Producto:");
                break;
            case 2003039: // screen Producto
                lb_b.setText("Buscar Producto:");
                break;
            case 2003040: // screen Producto
                lb_b.setText("Buscar Cliente:");
                break;
            case 2003041: // screen Guia Avanzada
                lb_b.setText("Buscar texto:");

                rb_find11.setToggleGroup(rb_group);
                rb_find11.setUserData("nguia");
                
                rb_find12.setToggleGroup(rb_group);
                rb_find12.setUserData("nfact");

                rb_find13.setToggleGroup(rb_group);
                rb_find13.setUserData("nfcarga");
                
                rb_find14.setToggleGroup(rb_group);
                rb_find14.setUserData("cprod");
                
                rb_find21.setToggleGroup(rb_group);
                rb_find21.setUserData("vehi");
                
                rb_find22.setToggleGroup(rb_group);
                rb_find22.setUserData("chof");

                rb_find23.setToggleGroup(rb_group);
                rb_find23.setUserData("ayud");

                rb_find24.setToggleGroup(rb_group);
                rb_find24.setUserData("cheq");

                rb_find25.setToggleGroup(rb_group);
                rb_find25.setUserData("sruta");

                vb_1.setLayoutY(146);
                vb_1.setPrefHeight(143);
                
                vb_2.setVisible(true);
                
                tf_producto.setVisible(true);
                break;
            case 2005011: // screen Aseguradora
                lb_b.setText("Buscar Seguro:");
                break;
        }
        tf_buscar.setText("");
        tf_buscar.requestFocus();
    }

    /**
     * Procedimiento de llenado de datos en la tabla de datos
     */
    private void loadTableOrdCompra(Orders[] orders){  
        if(orders != null){
            ObservableList<Object> data = FXCollections.observableArrayList();        
            data.addAll(Arrays.asList(orders));   
            tb_table.setItems(data);        
        }
    } 
    /**
     * Procedimiento de llenado de datos en la tabla de datos
     */
    private void loadTableProv(Supplier[] supplier){  
        if(supplier != null){
            ObservableList<Object> data = FXCollections.observableArrayList();        
            data.addAll(Arrays.asList(supplier));   
            tb_table.setItems(data);        
        }
    } 
    /**
     * Procedimiento de llenado de datos en la tabla de datos
     */
    private void loadTablePer(log_Personal[] log_personal){  
        if(log_personal != null){
            ObservableList<Object> data = FXCollections.observableArrayList();        
            data.addAll(Arrays.asList(log_personal));   
            tb_table.setItems(data);        
        }
    } 
    /**
     * Procedimiento de llenado de datos en la tabla de datos
     */
    private void loadTableVeh(log_Vehiculos[] log_vehiculos){  
        if(log_vehiculos != null){
            ObservableList<Object> data = FXCollections.observableArrayList();        
            data.addAll(Arrays.asList(log_vehiculos));   
            tb_table.setItems(data);        
        }
    } 
    /**
     * Procedimiento de llenado de datos en la tabla de datos
     */
    private void loadTablePro(Fxp_Archguip_det[] archguip_det){  
        if(archguip_det != null){
            ObservableList<Object> data = FXCollections.observableArrayList();        
            data.addAll(Arrays.asList(archguip_det));   
            tb_table.setItems(data);        
        }
    } 
    /**
     * Procedimiento de llenado de datos en la tabla de datos
     */
    private void loadTableCli(Fxp_Archguid_cli[] archguid_clie){  
        if(archguid_clie != null){
            ObservableList<Object> data = FXCollections.observableArrayList();        
            data.addAll(Arrays.asList(archguid_clie));   
            tb_table.setItems(data);        
        }
    } 
    /**
     * Procedimiento de llenado de datos en la tabla de datos
     */
    private void loadTableGui(log_CGuias[] log_cguias){  
        if(log_cguias != null){
            ObservableList<Object> data = FXCollections.observableArrayList();        
            data.addAll(Arrays.asList(log_cguias));   
            tb_table.setItems(data);        
        }
    } 
    /**
     * Procedimiento de llenado de datos en la tabla de datos
     */
    private void loadTableEmpInfocent(Empleado[] empleado){  
        if(empleado != null){
            ObservableList<Object> data = FXCollections.observableArrayList();        
            data.addAll(Arrays.asList(empleado));   
            tb_table.setItems(data);        
        }
    } 
    /**
     * Procedimiento de llenado de datos en la tabla de datos
     */
    private void loadTableEmpSeg(log_TSeguros[] log_tseguros){  
        if(log_tseguros != null){
            ObservableList<Object> data = FXCollections.observableArrayList();        
            data.addAll(Arrays.asList(log_tseguros));   
            tb_table.setItems(data);        
        }
    } 

}
