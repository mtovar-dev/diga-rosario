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
import Tools.Datos;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TableColumn;    
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
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
import javafx.stage.DirectoryChooser;
import jxl.Cell;
import jxl.DateCell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.read.biff.BiffException;

/**
 *
 * @author MITM
 */
public class Fxml_UpFile_RetencionesController implements Initializable {

    @FXML
    private AnchorPane ap_root;

    @FXML 
    private Button bt_path; 

    @FXML 
    private Button bt_jan; 

    @FXML 
    private Button bt_feb; 

    @FXML 
    private Button bt_mar; 

    @FXML 
    private Button bt_apr; 

    @FXML 
    private Button bt_may; 

    @FXML 
    private Button bt_jun; 

    @FXML 
    private Button bt_jul; 

    @FXML 
    private Button bt_agu; 

    @FXML 
    private Button bt_sep; 

    @FXML 
    private Button bt_oct; 

    @FXML 
    private Button bt_nov; 

    @FXML 
    private Button bt_dec; 

    @FXML
    private ComboBox<Integer> cb_ano;

    @FXML
    private CheckBox cb_jan;

    @FXML
    private CheckBox cb_feb;

    @FXML
    private CheckBox cb_mar;

    @FXML
    private CheckBox cb_apr;

    @FXML
    private CheckBox cb_may;

    @FXML
    private CheckBox cb_jun;

    @FXML
    private CheckBox cb_jul;

    @FXML
    private CheckBox cb_agu;

    @FXML
    private CheckBox cb_sep;

    @FXML
    private CheckBox cb_oct;

    @FXML
    private CheckBox cb_nov;

    @FXML
    private CheckBox cb_dec;

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
    private Label lb_janr;

    @FXML
    private Label lb_janf;

    @FXML
    private Label lb_janc;

    @FXML
    private Label lb_jand;

    @FXML
    private Label lb_febr;

    @FXML
    private Label lb_febf;

    @FXML
    private Label lb_febc;

    @FXML
    private Label lb_febd;

    @FXML
    private Label lb_marr;

    @FXML
    private Label lb_marf;

    @FXML
    private Label lb_marc;

    @FXML
    private Label lb_mard;

    @FXML
    private Label lb_aprr;

    @FXML
    private Label lb_aprf;

    @FXML
    private Label lb_aprc;

    @FXML
    private Label lb_aprd;

    @FXML
    private Label lb_mayr;

    @FXML
    private Label lb_mayf;

    @FXML
    private Label lb_mayc;

    @FXML
    private Label lb_mayd;

    @FXML
    private Label lb_junr;

    @FXML
    private Label lb_junf;

    @FXML
    private Label lb_junc;

    @FXML
    private Label lb_jund;

    @FXML
    private Label lb_julr;

    @FXML
    private Label lb_julf;

    @FXML
    private Label lb_julc;

    @FXML
    private Label lb_juld;

    @FXML
    private Label lb_agur;

    @FXML
    private Label lb_aguf;

    @FXML
    private Label lb_aguc;

    @FXML
    private Label lb_agud;

    @FXML
    private Label lb_sepr;

    @FXML
    private Label lb_sepf;

    @FXML
    private Label lb_sepc;

    @FXML
    private Label lb_sepd;

    @FXML
    private Label lb_octr;

    @FXML
    private Label lb_octf;

    @FXML
    private Label lb_octc;

    @FXML
    private Label lb_octd;

    @FXML
    private Label lb_novr;

    @FXML
    private Label lb_novf;

    @FXML
    private Label lb_novc;

    @FXML
    private Label lb_novd;

    @FXML
    private Label lb_decr;

    @FXML
    private Label lb_decf;

    @FXML
    private Label lb_decc;

    @FXML
    private Label lb_decd;

    @FXML
    private Label lb_mensj;

    @FXML
    private Label lb_screen;

    @FXML
    private Label lb_Title;

    @FXML
    private ProgressBar pb_jan;

    @FXML
    private ProgressBar pb_feb;

    @FXML
    private ProgressBar pb_mar;

    @FXML
    private ProgressBar pb_apr;

    @FXML
    private ProgressBar pb_may;

    @FXML
    private ProgressBar pb_jun;

    @FXML
    private ProgressBar pb_jul;

    @FXML
    private ProgressBar pb_agu;

    @FXML
    private ProgressBar pb_sep;

    @FXML
    private ProgressBar pb_oct;

    @FXML
    private ProgressBar pb_nov;

    @FXML
    private ProgressBar pb_dec;

    @FXML
    private TextField tf_buscar;

    @FXML
    private TextField tf_path;

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

    private static SimpleDateFormat sdf_dd = new SimpleDateFormat("dd/MM/yyyy"); // Set your date format
    
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
        assert ap_root != null : "fx:id=\"ap_root\" was not injected: check your FXML file 'Fxml_UpFile_RetencionesController.fxml'.";
        assert bt_path != null : "fx:id=\"bt_path\" was not injected: check your FXML file 'Fxml_UpFile_RetencionesController.fxml'.";
        assert bt_jan != null : "fx:id=\"bt_jan\" was not injected: check your FXML file 'Fxml_UpFile_RetencionesController.fxml'.";
        assert bt_feb != null : "fx:id=\"bt_feb\" was not injected: check your FXML file 'Fxml_UpFile_RetencionesController.fxml'.";
        assert bt_mar != null : "fx:id=\"bt_mar\" was not injected: check your FXML file 'Fxml_UpFile_RetencionesController.fxml'.";
        assert bt_apr != null : "fx:id=\"bt_apr\" was not injected: check your FXML file 'Fxml_UpFile_RetencionesController.fxml'.";
        assert bt_may != null : "fx:id=\"bt_may\" was not injected: check your FXML file 'Fxml_UpFile_RetencionesController.fxml'.";
        assert bt_jun != null : "fx:id=\"bt_jun\" was not injected: check your FXML file 'Fxml_UpFile_RetencionesController.fxml'.";
        assert bt_jul != null : "fx:id=\"bt_jul\" was not injected: check your FXML file 'Fxml_UpFile_RetencionesController.fxml'.";
        assert bt_agu != null : "fx:id=\"bt_ago\" was not injected: check your FXML file 'Fxml_UpFile_RetencionesController.fxml'.";
        assert bt_sep != null : "fx:id=\"bt_sep\" was not injected: check your FXML file 'Fxml_UpFile_RetencionesController.fxml'.";
        assert bt_oct != null : "fx:id=\"bt_oct\" was not injected: check your FXML file 'Fxml_UpFile_RetencionesController.fxml'.";
        assert bt_nov != null : "fx:id=\"bt_nov\" was not injected: check your FXML file 'Fxml_UpFile_RetencionesController.fxml'.";
        assert bt_dec != null : "fx:id=\"bt_dic\" was not injected: check your FXML file 'Fxml_UpFile_RetencionesController.fxml'.";
        assert cb_ano != null : "fx:id=\"cb_ano\" was not injected: check your FXML file 'Fxml_UpFile_RetencionesController.fxml'.";
        assert cb_jan != null : "fx:id=\"cb_jan\" was not injected: check your FXML file 'Fxml_UpFile_RetencionesController.fxml'.";
        assert cb_feb != null : "fx:id=\"cb_feb\" was not injected: check your FXML file 'Fxml_UpFile_RetencionesController.fxml'.";
        assert cb_mar != null : "fx:id=\"cb_mar\" was not injected: check your FXML file 'Fxml_UpFile_RetencionesController.fxml'.";
        assert cb_apr != null : "fx:id=\"cb_apr\" was not injected: check your FXML file 'Fxml_UpFile_RetencionesController.fxml'.";
        assert cb_may != null : "fx:id=\"cb_may\" was not injected: check your FXML file 'Fxml_UpFile_RetencionesController.fxml'.";
        assert cb_jun != null : "fx:id=\"cb_jun\" was not injected: check your FXML file 'Fxml_UpFile_RetencionesController.fxml'.";
        assert cb_jul != null : "fx:id=\"cb_jul\" was not injected: check your FXML file 'Fxml_UpFile_RetencionesController.fxml'.";
        assert cb_agu != null : "fx:id=\"cb_agu\" was not injected: check your FXML file 'Fxml_UpFile_RetencionesController.fxml'.";
        assert cb_sep != null : "fx:id=\"cb_sep\" was not injected: check your FXML file 'Fxml_UpFile_RetencionesController.fxml'.";
        assert cb_oct != null : "fx:id=\"cb_oct\" was not injected: check your FXML file 'Fxml_UpFile_RetencionesController.fxml'.";
        assert cb_nov != null : "fx:id=\"cb_nov\" was not injected: check your FXML file 'Fxml_UpFile_RetencionesController.fxml'.";
        assert cb_dec != null : "fx:id=\"cb_dec\" was not injected: check your FXML file 'Fxml_UpFile_RetencionesController.fxml'.";
        assert hb_1 != null : "fx:id=\"hb_1\" was not injected: check your FXML file 'Fxml_UpFile_RetencionesController.fxml'.";
        assert hbox_toolbar != null : "fx:id=\"hbox_toolbar\" was not injected: check your FXML file 'Fxml_UpFile_RetencionesController.fxml'.";
        assert im_tool1 != null : "fx:id=\"im_tool1\" was not injected: check your FXML file 'Fxml_UpFile_RetencionesController.fxml'.";
        assert im_tool10 != null : "fx:id=\"im_tool10\" was not injected: check your FXML file 'Fxml_UpFile_RetencionesController.fxml'.";
        assert im_tool11 != null : "fx:id=\"im_tool11\" was not injected: check your FXML file 'Fxml_UpFile_RetencionesController.fxml'.";
        assert im_tool12 != null : "fx:id=\"im_tool12\" was not injected: check your FXML file 'Fxml_UpFile_RetencionesController.fxml'.";
        assert im_tool2 != null : "fx:id=\"im_tool2\" was not injected: check your FXML file 'Fxml_UpFile_RetencionesController.fxml'.";
        assert im_tool3 != null : "fx:id=\"im_tool3\" was not injected: check your FXML file 'Fxml_UpFile_RetencionesController.fxml'.";
        assert im_tool4 != null : "fx:id=\"im_tool4\" was not injected: check your FXML file 'Fxml_UpFile_RetencionesController.fxml'.";
        assert im_tool5 != null : "fx:id=\"im_tool5\" was not injected: check your FXML file 'Fxml_UpFile_RetencionesController.fxml'.";
        assert im_tool6 != null : "fx:id=\"im_tool6\" was not injected: check your FXML file 'Fxml_UpFile_RetencionesController.fxml'.";
        assert im_tool7 != null : "fx:id=\"im_tool7\" was not injected: check your FXML file 'Fxml_UpFile_RetencionesController.fxml'.";
        assert im_tool8 != null : "fx:id=\"im_tool8\" was not injected: check your FXML file 'Fxml_UpFile_RetencionesController.fxml'.";
        assert im_tool9 != null : "fx:id=\"im_tool9\" was not injected: check your FXML file 'Fxml_UpFile_RetencionesController.fxml'.";
        assert lb_janr != null : "fx:id=\"lb_janr\" was not injected: check your FXML file 'Fxml_UpFile_RetencionesController.fxml'.";
        assert lb_janf != null : "fx:id=\"lb_janf\" was not injected: check your FXML file 'Fxml_UpFile_RetencionesController.fxml'.";
        assert lb_janc != null : "fx:id=\"lb_janc\" was not injected: check your FXML file 'Fxml_UpFile_RetencionesController.fxml'.";
        assert lb_jand != null : "fx:id=\"lb_jand\" was not injected: check your FXML file 'Fxml_UpFile_RetencionesController.fxml'.";
        assert lb_febr != null : "fx:id=\"lb_febr\" was not injected: check your FXML file 'Fxml_UpFile_RetencionesController.fxml'.";
        assert lb_febf != null : "fx:id=\"lb_febf\" was not injected: check your FXML file 'Fxml_UpFile_RetencionesController.fxml'.";
        assert lb_febc != null : "fx:id=\"lb_febc\" was not injected: check your FXML file 'Fxml_UpFile_RetencionesController.fxml'.";
        assert lb_febd != null : "fx:id=\"lb_febd\" was not injected: check your FXML file 'Fxml_UpFile_RetencionesController.fxml'.";
        assert lb_marr != null : "fx:id=\"lb_marr\" was not injected: check your FXML file 'Fxml_UpFile_RetencionesController.fxml'.";
        assert lb_marf != null : "fx:id=\"lb_marf\" was not injected: check your FXML file 'Fxml_UpFile_RetencionesController.fxml'.";
        assert lb_marc != null : "fx:id=\"lb_marc\" was not injected: check your FXML file 'Fxml_UpFile_RetencionesController.fxml'.";
        assert lb_mard != null : "fx:id=\"lb_mard\" was not injected: check your FXML file 'Fxml_UpFile_RetencionesController.fxml'.";
        assert lb_aprr != null : "fx:id=\"lb_aprr\" was not injected: check your FXML file 'Fxml_UpFile_RetencionesController.fxml'.";
        assert lb_aprf != null : "fx:id=\"lb_aprf\" was not injected: check your FXML file 'Fxml_UpFile_RetencionesController.fxml'.";
        assert lb_aprc != null : "fx:id=\"lb_aprc\" was not injected: check your FXML file 'Fxml_UpFile_RetencionesController.fxml'.";
        assert lb_aprd != null : "fx:id=\"lb_aprd\" was not injected: check your FXML file 'Fxml_UpFile_RetencionesController.fxml'.";
        assert lb_mayr != null : "fx:id=\"lb_mayr\" was not injected: check your FXML file 'Fxml_UpFile_RetencionesController.fxml'.";
        assert lb_mayf != null : "fx:id=\"lb_mayf\" was not injected: check your FXML file 'Fxml_UpFile_RetencionesController.fxml'.";
        assert lb_mayc != null : "fx:id=\"lb_mayc\" was not injected: check your FXML file 'Fxml_UpFile_RetencionesController.fxml'.";
        assert lb_mayd != null : "fx:id=\"lb_mayd\" was not injected: check your FXML file 'Fxml_UpFile_RetencionesController.fxml'.";
        assert lb_junr != null : "fx:id=\"lb_junr\" was not injected: check your FXML file 'Fxml_UpFile_RetencionesController.fxml'.";
        assert lb_junf != null : "fx:id=\"lb_junf\" was not injected: check your FXML file 'Fxml_UpFile_RetencionesController.fxml'.";
        assert lb_junc != null : "fx:id=\"lb_junc\" was not injected: check your FXML file 'Fxml_UpFile_RetencionesController.fxml'.";
        assert lb_jund != null : "fx:id=\"lb_jund\" was not injected: check your FXML file 'Fxml_UpFile_RetencionesController.fxml'.";
        assert lb_julr != null : "fx:id=\"lb_julr\" was not injected: check your FXML file 'Fxml_UpFile_RetencionesController.fxml'.";
        assert lb_julf != null : "fx:id=\"lb_julf\" was not injected: check your FXML file 'Fxml_UpFile_RetencionesController.fxml'.";
        assert lb_julc != null : "fx:id=\"lb_julc\" was not injected: check your FXML file 'Fxml_UpFile_RetencionesController.fxml'.";
        assert lb_juld != null : "fx:id=\"lb_juld\" was not injected: check your FXML file 'Fxml_UpFile_RetencionesController.fxml'.";
        assert lb_agur != null : "fx:id=\"lb_agur\" was not injected: check your FXML file 'Fxml_UpFile_RetencionesController.fxml'.";
        assert lb_aguf != null : "fx:id=\"lb_aguf\" was not injected: check your FXML file 'Fxml_UpFile_RetencionesController.fxml'.";
        assert lb_aguc != null : "fx:id=\"lb_aguc\" was not injected: check your FXML file 'Fxml_UpFile_RetencionesController.fxml'.";
        assert lb_agud != null : "fx:id=\"lb_agud\" was not injected: check your FXML file 'Fxml_UpFile_RetencionesController.fxml'.";
        assert lb_sepr != null : "fx:id=\"lb_sepr\" was not injected: check your FXML file 'Fxml_UpFile_RetencionesController.fxml'.";
        assert lb_sepf != null : "fx:id=\"lb_sepf\" was not injected: check your FXML file 'Fxml_UpFile_RetencionesController.fxml'.";
        assert lb_sepc != null : "fx:id=\"lb_sepc\" was not injected: check your FXML file 'Fxml_UpFile_RetencionesController.fxml'.";
        assert lb_sepd != null : "fx:id=\"lb_sepd\" was not injected: check your FXML file 'Fxml_UpFile_RetencionesController.fxml'.";
        assert lb_octr != null : "fx:id=\"lb_octr\" was not injected: check your FXML file 'Fxml_UpFile_RetencionesController.fxml'.";
        assert lb_octf != null : "fx:id=\"lb_octf\" was not injected: check your FXML file 'Fxml_UpFile_RetencionesController.fxml'.";
        assert lb_octc != null : "fx:id=\"lb_octc\" was not injected: check your FXML file 'Fxml_UpFile_RetencionesController.fxml'.";
        assert lb_octd != null : "fx:id=\"lb_octd\" was not injected: check your FXML file 'Fxml_UpFile_RetencionesController.fxml'.";
        assert lb_novr != null : "fx:id=\"lb_novr\" was not injected: check your FXML file 'Fxml_UpFile_RetencionesController.fxml'.";
        assert lb_novf != null : "fx:id=\"lb_novf\" was not injected: check your FXML file 'Fxml_UpFile_RetencionesController.fxml'.";
        assert lb_novc != null : "fx:id=\"lb_novc\" was not injected: check your FXML file 'Fxml_UpFile_RetencionesController.fxml'.";
        assert lb_novd != null : "fx:id=\"lb_novd\" was not injected: check your FXML file 'Fxml_UpFile_RetencionesController.fxml'.";
        assert lb_decr != null : "fx:id=\"lb_decr\" was not injected: check your FXML file 'Fxml_UpFile_RetencionesController.fxml'.";
        assert lb_decf != null : "fx:id=\"lb_decf\" was not injected: check your FXML file 'Fxml_UpFile_RetencionesController.fxml'.";
        assert lb_decc != null : "fx:id=\"lb_decc\" was not injected: check your FXML file 'Fxml_UpFile_RetencionesController.fxml'.";
        assert lb_decd != null : "fx:id=\"lb_decd\" was not injected: check your FXML file 'Fxml_UpFile_RetencionesController.fxml'.";
        assert lb_mensj != null : "fx:id=\"lb_mensj\" was not injected: check your FXML file 'Fxml_UpFile_RetencionesController.fxml'.";
        assert lb_screen != null : "fx:id=\"lb_screen\" was not injected: check your FXML file 'Fxml_UpFile_RetencionesController.fxml'.";
        assert lb_Title != null : "fx:id=\"lb_Title\" was not injected: check your FXML file 'Fxml_UpFile_RetencionesController.fxml'.";
        assert pb_jan != null : "fx:id=\"pb_jan\" was not injected: check your FXML file 'Fxml_UpFile_RetencionesController.fxml'.";
        assert pb_feb != null : "fx:id=\"pb_feb\" was not injected: check your FXML file 'Fxml_UpFile_RetencionesController.fxml'.";
        assert pb_mar != null : "fx:id=\"pb_mar\" was not injected: check your FXML file 'Fxml_UpFile_RetencionesController.fxml'.";
        assert pb_apr != null : "fx:id=\"pb_apr\" was not injected: check your FXML file 'Fxml_UpFile_RetencionesController.fxml'.";
        assert pb_may != null : "fx:id=\"pb_may\" was not injected: check your FXML file 'Fxml_UpFile_RetencionesController.fxml'.";
        assert pb_jun != null : "fx:id=\"pb_jun\" was not injected: check your FXML file 'Fxml_UpFile_RetencionesController.fxml'.";
        assert pb_jul != null : "fx:id=\"pb_jul\" was not injected: check your FXML file 'Fxml_UpFile_RetencionesController.fxml'.";
        assert pb_agu != null : "fx:id=\"pb_agu\" was not injected: check your FXML file 'Fxml_UpFile_RetencionesController.fxml'.";
        assert pb_sep != null : "fx:id=\"pb_sep\" was not injected: check your FXML file 'Fxml_UpFile_RetencionesController.fxml'.";
        assert pb_oct != null : "fx:id=\"pb_oct\" was not injected: check your FXML file 'Fxml_UpFile_RetencionesController.fxml'.";
        assert pb_nov != null : "fx:id=\"pb_nov\" was not injected: check your FXML file 'Fxml_UpFile_RetencionesController.fxml'.";
        assert pb_dec != null : "fx:id=\"pb_dec\" was not injected: check your FXML file 'Fxml_UpFile_RetencionesController.fxml'.";
        assert tf_buscar != null : "fx:id=\"tf_buscar\" was not injected: check your FXML file 'Fxml_UpFile_RetencionesController.fxml'.";
        assert tf_path != null : "fx:id=\"tf_path\" was not injected: check your FXML file 'Fxml_UpFile_RetencionesController.fxml'.";
        assert vb_form != null : "fx:id=\"vb_form\" was not injected: check your FXML file 'Fxml_UpFile_RetencionesController.fxml'.";
        assert vb_table != null : "fx:id=\"vb_table\" was not injected: check your FXML file 'Fxml_UpFile_RetencionesController.fxml'.";

        //Inicializa la Barra de Herramientas y comportamiento del Boton de Busqueda
        defineToolBar();         
        defineBotonBuscar();    
        init_buttons(); //Establece los comportamientos de los botones
        botonInicio();  //Se imprime la pantalla Inicio

        loadYear();      

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
        cb_ano.setItems(data);    
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
        
        bt_jan.setDisable(true);
        bt_feb.setDisable(true);
        bt_mar.setDisable(true);
        bt_apr.setDisable(true);
        bt_may.setDisable(true);
        bt_jun.setDisable(true);
        bt_jul.setDisable(true);
        bt_agu.setDisable(true);
        bt_sep.setDisable(true);
        bt_oct.setDisable(true);
        bt_nov.setDisable(true);
        bt_dec.setDisable(true);
        bt_jul.setDisable(true);
        bt_agu.setDisable(true);
        bt_sep.setDisable(true);
        bt_oct.setDisable(true);
        bt_nov.setDisable(true);
        bt_dec.setDisable(true);
        
        bt_jan.setText("Cargar");
        bt_feb.setText("Cargar");
        bt_mar.setText("Cargar");
        bt_apr.setText("Cargar");
        bt_may.setText("Cargar");
        bt_jun.setText("Cargar");
        bt_jul.setText("Cargar");
        bt_agu.setText("Cargar");
        bt_sep.setText("Cargar");
        bt_oct.setText("Cargar");
        bt_nov.setText("Cargar");
        bt_dec.setText("Cargar");
        
        cb_jan.setSelected(false);
        cb_feb.setSelected(false);
        cb_mar.setSelected(false);
        cb_apr.setSelected(false);
        cb_may.setSelected(false);
        cb_jun.setSelected(false);
        cb_jul.setSelected(false);
        cb_agu.setSelected(false);
        cb_sep.setSelected(false);
        cb_oct.setSelected(false);
        cb_nov.setSelected(false);
        cb_dec.setSelected(false);
        
        lb_janr.setText("");
        lb_febr.setText("");
        lb_marr.setText("");
        lb_aprr.setText("");
        lb_mayr.setText("");
        lb_junr.setText("");
        lb_julr.setText("");
        lb_agur.setText("");
        lb_sepr.setText("");
        lb_octr.setText("");
        lb_novr.setText("");
        lb_decr.setText("");

        lb_janf.setText("");
        lb_febf.setText("");
        lb_marf.setText("");
        lb_aprf.setText("");
        lb_mayf.setText("");
        lb_junf.setText("");
        lb_julf.setText("");
        lb_aguf.setText("");
        lb_sepf.setText("");
        lb_octf.setText("");
        lb_novf.setText("");
        lb_decf.setText("");

        lb_janc.setText("");
        lb_febc.setText("");
        lb_marc.setText("");
        lb_aprc.setText("");
        lb_mayc.setText("");
        lb_junc.setText("");
        lb_julc.setText("");
        lb_aguc.setText("");
        lb_sepc.setText("");
        lb_octc.setText("");
        lb_novc.setText("");
        lb_decc.setText("");

        lb_jand.setText("");
        lb_febd.setText("");
        lb_mard.setText("");
        lb_aprd.setText("");
        lb_mayd.setText("");
        lb_jund.setText("");
        lb_juld.setText("");
        lb_agud.setText("");
        lb_sepd.setText("");
        lb_octd.setText("");
        lb_novd.setText("");
        lb_decd.setText("");

        //RECARGA LA TABLA ORIGINAL
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
            String verbo = "eliminar";
            if(Datos.getLog_cguias().getAnulada()== 1){
                verbo = "habilitar";
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
        Gui.getInstance().showPrint(ScreenName + " en Construcción");  
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
         * BOTON PATH
         */
        bt_path.setOnAction((ActionEvent event) -> {
            DirectoryChooser directoryChooser = new DirectoryChooser();
            File selectedDirectory = directoryChooser.showDialog(null);
            if (selectedDirectory != null) {
                selectedDirectory.getAbsolutePath();
                tf_path.setText(selectedDirectory.getAbsolutePath());
            }
        });
        /**
         * metodo para mostrar el item (estado) seleccionado y cargar las ciudades
         * param: nombre del estado
         */
        cb_ano.getSelectionModel().selectedItemProperty().addListener((ObservableValue<? extends Integer> arg0, Integer arg1, Integer arg2) -> {
            if (arg2 != null)
                botonInicio();
        });
        /**
         * CHECKBOX JANUARY
         */
        cb_jan.setOnAction((ActionEvent event) -> {
            bt_jan.setDisable(!cb_jan.selectedProperty().getValue());
        });
        /**
         * BOTON UPDFILE JANUARY
         */
        bt_jan.setOnAction((ActionEvent event) -> {
            if(tf_path.getText().equals("")){
                Gui.getInstance().showMessage("Debe indicar la Ruta del archivo!", "A");
                bt_path.requestFocus();
            }
            else{
                if (bt_jan.getText().equals("Cargar")){
                    try{
                        FileInputStream inputStream = 
                            new FileInputStream(new File(tf_path.getText() + "\\ENE" + cb_ano.getValue().toString().substring(2) + ".xls"));
                        contentReading(cb_ano.getValue(), 1, inputStream, pb_jan, lb_janr, lb_janf, lb_janc, lb_jand, bt_jan);
                    }
                    catch (FileNotFoundException e)
                    {
                        Gui.getInstance().showMessage("El archivo No se encuentra en la ruta especificada!", "E");
                    } catch (BiffException | ParseException ex) {
                        Logger.getLogger(Fxml_UpFile_RetencionesController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                else {
                    Gui.getInstance().showMessage("El archivo ya fue procesado!", "I");
                }
            }
        });
        /**
         * CHECKBOX FEBRUARY
         */
        cb_feb.setOnAction((ActionEvent event) -> {
            bt_feb.setDisable(!cb_feb.selectedProperty().getValue());
        });
        /**
         * BOTON UPDFILE FEBRUARY
         */
        bt_feb.setOnAction((ActionEvent event) -> {
            if(tf_path.getText().equals("")){
                Gui.getInstance().showMessage("Debe indicar la Ruta del archivo!", "A");
                bt_path.requestFocus();
            }
            else{
                if (bt_feb.getText().equals("Cargar")){
                    try{
                        FileInputStream inputStream = 
                            new FileInputStream(new File(tf_path.getText() + "\\FEB" + cb_ano.getValue().toString().substring(2) + ".xls"));
                        contentReading(cb_ano.getValue(), 2, inputStream, pb_feb, lb_febr, lb_febf, lb_febc, lb_febd, bt_feb);
                    }
                    catch (FileNotFoundException e)
                    {
                        Gui.getInstance().showMessage("El archivo No se encuentra en la ruta especificada!", "E");
                    } catch (BiffException | ParseException ex) {
                        Logger.getLogger(Fxml_UpFile_RetencionesController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                else {
                    Gui.getInstance().showMessage("El archivo ya fue procesado!", "I");
                }
            }
        });
        /**
         * CHECKBOX MARCH
         */
        cb_mar.setOnAction((ActionEvent event) -> {
            bt_mar.setDisable(!cb_mar.selectedProperty().getValue());
        });
        /**
         * BOTON UPDFILE MARCH
         */
        bt_mar.setOnAction((ActionEvent event) -> {
            if(tf_path.getText().equals("")){
                Gui.getInstance().showMessage("Debe indicar la Ruta del archivo!", "A");
                bt_path.requestFocus();
            }
            else{
                if (bt_mar.getText().equals("Cargar")){
                    try{
                        FileInputStream inputStream = 
                            new FileInputStream(new File(tf_path.getText() + "\\MAR" + cb_ano.getValue().toString().substring(2) + ".xls"));
                        contentReading(cb_ano.getValue(), 3, inputStream, pb_mar, lb_marr, lb_marf, lb_marc, lb_mard, bt_mar);
                    }
                    catch (FileNotFoundException e)
                    {
                        Gui.getInstance().showMessage("El archivo No se encuentra en la ruta especificada!", "E");
                    } catch (BiffException | ParseException ex) {
                        Logger.getLogger(Fxml_UpFile_RetencionesController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                else {
                    Gui.getInstance().showMessage("El archivo ya fue procesado!", "I");
                }
            }
        });
        /**
         * CHECKBOX APRIL
         */
        cb_apr.setOnAction((ActionEvent event) -> {
            bt_apr.setDisable(!cb_apr.selectedProperty().getValue());
        });
        /**
         * BOTON UPDFILE APRIL
         */
        bt_apr.setOnAction((ActionEvent event) -> {
            if(tf_path.getText().equals("")){
                Gui.getInstance().showMessage("Debe indicar la Ruta del archivo!", "A");
                bt_path.requestFocus();
            }
            else{
                if (bt_apr.getText().equals("Cargar")){
                    try{
                        FileInputStream inputStream = 
                            new FileInputStream(new File(tf_path.getText() + "\\ABR" + cb_ano.getValue().toString().substring(2) + ".xls"));
                        contentReading(cb_ano.getValue(), 4, inputStream, pb_apr, lb_aprr, lb_aprf, lb_aprc, lb_aprd, bt_apr);
                    }
                    catch (FileNotFoundException e)
                    {
                        Gui.getInstance().showMessage("El archivo No se encuentra en la ruta especificada!", "E");
                    } catch (BiffException | ParseException ex) {
                        Logger.getLogger(Fxml_UpFile_RetencionesController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                else {
                    Gui.getInstance().showMessage("El archivo ya fue procesado!", "I");
                }
            }
        });
        /**
         * CHECKBOX MAY
         */
        cb_may.setOnAction((ActionEvent event) -> {
            bt_may.setDisable(!cb_may.selectedProperty().getValue());
        });
        /**
         * BOTON UPDFILE MAY
         */
        bt_may.setOnAction((ActionEvent event) -> {
            if(tf_path.getText().equals("")){
                Gui.getInstance().showMessage("Debe indicar la Ruta del archivo!", "A");
                bt_path.requestFocus();
            }
            else{
                if (bt_may.getText().equals("Cargar")){
                    try{
                        FileInputStream inputStream = 
                            new FileInputStream(new File(tf_path.getText() + "\\MAY" + cb_ano.getValue().toString().substring(2) + ".xls"));
                        contentReading(cb_ano.getValue(), 5, inputStream, pb_may, lb_mayr, lb_mayf, lb_mayc, lb_mayd, bt_may);
                    }
                    catch (FileNotFoundException e)
                    {
                        Gui.getInstance().showMessage("El archivo No se encuentra en la ruta especificada!", "E");
                    } catch (BiffException | ParseException ex) {
                        Logger.getLogger(Fxml_UpFile_RetencionesController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                else {
                    Gui.getInstance().showMessage("El archivo ya fue procesado!", "I");
                }
            }
        });
        /**
         * CHECKBOX JUNE
         */
        cb_jun.setOnAction((ActionEvent event) -> {
            bt_jun.setDisable(!cb_jun.selectedProperty().getValue());
        });
        /**
         * BOTON UPDFILE JUNE
         */
        bt_jun.setOnAction((ActionEvent event) -> {
            if(tf_path.getText().equals("")){
                Gui.getInstance().showMessage("Debe indicar la Ruta del archivo!", "A");
                bt_path.requestFocus();
            }
            else{
                if (bt_jun.getText().equals("Cargar")){
                    try{
                        FileInputStream inputStream = 
                            new FileInputStream(new File(tf_path.getText() + "\\JUN" + cb_ano.getValue().toString().substring(2) + ".xls"));
                        contentReading(cb_ano.getValue(), 6, inputStream, pb_jun, lb_junr, lb_junf, lb_junc, lb_jund, bt_jun);
                    }
                    catch (FileNotFoundException e)
                    {
                        Gui.getInstance().showMessage("El archivo No se encuentra en la ruta especificada!", "E");
                    } catch (BiffException | ParseException ex) {
                        Logger.getLogger(Fxml_UpFile_RetencionesController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                else {
                    Gui.getInstance().showMessage("El archivo ya fue procesado!", "I");
                }
            }
        });
        /**
         * CHECKBOX JULY
         */
        cb_jul.setOnAction((ActionEvent event) -> {
            bt_jul.setDisable(!cb_jul.selectedProperty().getValue());
        });
        /**
         * BOTON UPDFILE JULY
         */
        bt_jul.setOnAction((ActionEvent event) -> {
            if(tf_path.getText().equals("")){
                Gui.getInstance().showMessage("Debe indicar la Ruta del archivo!", "A");
                bt_path.requestFocus();
            }
            else{
                if (bt_jul.getText().equals("Cargar")){
                    try{
                        FileInputStream inputStream = 
                            new FileInputStream(new File(tf_path.getText() + "\\JUL" + cb_ano.getValue().toString().substring(2) + ".xls"));
                        contentReading(cb_ano.getValue(), 7, inputStream, pb_jul, lb_julr, lb_julf, lb_julc, lb_juld, bt_jul);
                    }
                    catch (FileNotFoundException e)
                    {
                        Gui.getInstance().showMessage("El archivo No se encuentra en la ruta especificada!", "E");
                    } catch (BiffException | ParseException ex) {
                        Logger.getLogger(Fxml_UpFile_RetencionesController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                else {
                    Gui.getInstance().showMessage("El archivo ya fue procesado!", "I");
                }
            }
        });
        /**
         * CHECKBOX AGUST
         */
        cb_agu.setOnAction((ActionEvent event) -> {
            bt_agu.setDisable(!cb_agu.selectedProperty().getValue());
        });
        /**
         * BOTON UPDFILE AGUST
         */
        bt_agu.setOnAction((ActionEvent event) -> {
            if(tf_path.getText().equals("")){
                Gui.getInstance().showMessage("Debe indicar la Ruta del archivo!", "A");
                bt_path.requestFocus();
            }
            else{
                if (bt_agu.getText().equals("Cargar")){
                    try{
                        FileInputStream inputStream = 
                            new FileInputStream(new File(tf_path.getText() + "\\AGO" + cb_ano.getValue().toString().substring(2) + ".xls"));
                        contentReading(cb_ano.getValue(), 8, inputStream, pb_agu, lb_agur, lb_aguf, lb_aguc, lb_agud, bt_agu);
                    }
                    catch (FileNotFoundException e)
                    {
                        Gui.getInstance().showMessage("El archivo No se encuentra en la ruta especificada!", "E");
                    } catch (BiffException | ParseException ex) {
                        Logger.getLogger(Fxml_UpFile_RetencionesController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                else {
                     Gui.getInstance().showMessage("El archivo ya fue procesado!", "I");
               }
            }
        });
        /**
         * CHECKBOX SEPTEMBER
         */
        cb_sep.setOnAction((ActionEvent event) -> {
            bt_sep.setDisable(!cb_sep.selectedProperty().getValue());
        });
        /**
         * BOTON UPDFILE SEPTEMBER
         */
        bt_sep.setOnAction((ActionEvent event) -> {
            if(tf_path.getText().equals("")){
                Gui.getInstance().showMessage("Debe indicar la Ruta del archivo!", "A");
                bt_path.requestFocus();
            }
            else{
                if (bt_sep.getText().equals("Cargar")){
                    try{
                        FileInputStream inputStream = 
                            new FileInputStream(new File(tf_path.getText() + "\\SEP" + cb_ano.getValue().toString().substring(2) + ".xls"));
                        contentReading(cb_ano.getValue(), 9, inputStream, pb_sep, lb_sepr, lb_sepf, lb_sepc, lb_sepd, bt_sep);
                    }
                    catch (FileNotFoundException e)
                    {
                        Gui.getInstance().showMessage("El archivo No se encuentra en la ruta especificada!", "E");
                    } catch (BiffException | ParseException ex) {
                        Logger.getLogger(Fxml_UpFile_RetencionesController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                else {
                     Gui.getInstance().showMessage("El archivo ya fue procesado!", "I");
               }
            }
        });
        /**
         * CHECKBOX OCTOBER
         */
        cb_oct.setOnAction((ActionEvent event) -> {
            bt_oct.setDisable(!cb_oct.selectedProperty().getValue());
        });
        /**
         * BOTON UPDFILE OCTOBER
         */
        bt_oct.setOnAction((ActionEvent event) -> {
            if(tf_path.getText().equals("")){
                Gui.getInstance().showMessage("Debe indicar la Ruta del archivo!", "A");
                bt_path.requestFocus();
            }
            else{
                if (bt_oct.getText().equals("Cargar")){
                    try{
                        FileInputStream inputStream = 
                            new FileInputStream(new File(tf_path.getText() + "\\OCT" + cb_ano.getValue().toString().substring(2) + ".xls"));
                        contentReading(cb_ano.getValue(), 10, inputStream, pb_oct, lb_octr, lb_octf, lb_octc, lb_octd, bt_oct);
                    }
                    catch (FileNotFoundException e)
                    {
                        Gui.getInstance().showMessage("El archivo No se encuentra en la ruta especificada!", "E");
                    } catch (BiffException | ParseException ex) {
                        Logger.getLogger(Fxml_UpFile_RetencionesController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                else {
                    Gui.getInstance().showMessage("El archivo ya fue procesado!", "I");
                }
            }
        });
        /**
         * CHECKBOX NOVEMBER
         */
        cb_nov.setOnAction((ActionEvent event) -> {
            bt_nov.setDisable(!cb_nov.selectedProperty().getValue());
        });
        /**
         * BOTON UPDFILE NOVEMBER
         */
        bt_nov.setOnAction((ActionEvent event) -> {
            if(tf_path.getText().equals("")){
                Gui.getInstance().showMessage("Debe indicar la Ruta del archivo!", "A");
                bt_path.requestFocus();
            }
            else{
                if (bt_nov.getText().equals("Cargar")){
                    try{
                        FileInputStream inputStream = 
                            new FileInputStream(new File(tf_path.getText() + "\\NOV" + cb_ano.getValue().toString().substring(2) + ".xls"));
                        contentReading(cb_ano.getValue(), 11, inputStream, pb_nov, lb_novr, lb_novf, lb_novc, lb_novd, bt_nov);
                    }
                    catch (FileNotFoundException e)
                    {
                        Gui.getInstance().showMessage("El archivo No se encuentra en la ruta especificada!", "E");
                    } catch (BiffException | ParseException ex) {
                        Logger.getLogger(Fxml_UpFile_RetencionesController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                else {
                    Gui.getInstance().showMessage("El archivo ya fue procesado!", "I");
                }
            }
        });
        /**
         * CHECKBOX NOVEMBER
         */
        cb_dec.setOnAction((ActionEvent event) -> {
            bt_dec.setDisable(!cb_dec.selectedProperty().getValue());
        });
        /**
         * BOTON UPDFILE NOVEMBER
         */
        bt_dec.setOnAction((ActionEvent event) -> {
            if(tf_path.getText().equals("")){
                Gui.getInstance().showMessage("Debe indicar la Ruta del archivo!", "A");
                bt_path.requestFocus();
            }
            else{
                if (bt_dec.getText().equals("Cargar")){
                    try{
                        FileInputStream inputStream = 
                            new FileInputStream(new File(tf_path.getText() + "\\DIC" + cb_ano.getValue().toString().substring(2) + ".xls"));
                        contentReading(cb_ano.getValue(), 12, inputStream, pb_dec, lb_decr, lb_decf, lb_decc, lb_decd, bt_dec);
                    }
                    catch (FileNotFoundException e)
                    {
                        Gui.getInstance().showMessage("El archivo No se encuentra en la ruta especificada!", "E");
                    } catch (BiffException | ParseException ex) {
                        Logger.getLogger(Fxml_UpFile_RetencionesController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                else {
                    Gui.getInstance().showMessage("El archivo ya fue procesado!", "I");
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

    public void contentReading(
            int year, int month, InputStream fileInputStream, ProgressBar pb, 
            Label lb1, Label lb2, Label lb3, Label lb4, Button bt) throws BiffException, ParseException {
        WorkbookSettings ws = null;
        Workbook workbook = null;
        Sheet s = null;
        Cell rowData[] = null;
        DateCell dc = null;

        int totalSheet = 0;
        int rowCount = 0;
        int columnCount = 0;
        int iday;
        int imonth;
        int iyear;

        float mtoFact = 0;
        float mtoCred = 0;
        float mtoDeb = 0;
        
        String mto = null;
        String tipDoc = null;
        String fecha;

        boolean result = false;
        
        try {
            ws = new WorkbookSettings();
            ws.setLocale(new Locale("es", "ES"));
            workbook = Workbook.getWorkbook(fileInputStream, ws);

            totalSheet = workbook.getNumberOfSheets();
            if(workbook.getNumberOfSheets() > 0) {
                //Getting Default Sheet i.e. 0
                s = workbook.getSheet(0);

                //Total Total No Of Rows in Sheet, will return you no of rows that are occupied with some data
                rowCount = s.getRows() - 1;

                //Total Total No Of Columns in Sheet
                columnCount = s.getColumns();

                sqlexcel.clear();
                //Reading Individual Row Content
                for (int i = 28; i < rowCount; i++) {
                    UploadExcelFile uploadexcelfile = new UploadExcelFile();

                    uploadexcelfile.setAno(year);
                    uploadexcelfile.setMes(month);
                    uploadexcelfile.setExcelfile(workbook.getSheet(0).getName().toUpperCase());

                    //Get Individual Row
                    pb.setProgress(i);
                    //pb.progressProperty().bind(task.progressProperty());
                    rowData = s.getRow(i);
                    if (rowData[0].getContents().length() != 0) { // the first date column must not null
                        for (int j = 0; j < columnCount; j++) {
                            switch (j) {
                                case 0:
                                    uploadexcelfile.setRifAgente(rowData[j].getContents().toUpperCase());
                                    break;
                                case 1:
                                    uploadexcelfile.setNombAgente(rowData[j].getContents());
                                    break;
                                case 2:
                                    iday = Integer.parseInt(rowData[j].getContents().substring(0, 2));
                                    imonth = Integer.parseInt(rowData[j].getContents().substring(3, 5));
                                    if (rowData[j].getContents().substring(6, 8).length() == 1)
                                        iyear = Integer.parseInt("200" + rowData[j].getContents().substring(6, 8));
                                    else
                                        iyear = Integer.parseInt("20" + rowData[j].getContents().substring(6, 8));
                                        
                                    fecha = iday + "/" + imonth + "/" + iyear;
                                    
                                    Date date = sdf_dd.parse(fecha);

                                    java.sql.Date sqlDate = new java.sql.Date(date.getTime());
                                    uploadexcelfile.setFechaDoc(sqlDate);
                                    break;
                                case 3:
                                    uploadexcelfile.setTipoDoc(rowData[j].getContents());
                                    tipDoc = rowData[j].getContents();
                                    break;
                                case 4:
                                    mto = rowData[j].getContents().replaceAll("\\.", "");
                                    mto = mto.replaceAll("\\,", ".");
                                    uploadexcelfile.setMtoDoc1(Double.parseDouble(mto));
                                    break;
                                case 5:
                                    mto = rowData[j].getContents().replaceAll("\\.", "");
                                    mto = mto.replaceAll("\\,", ".");
                                    uploadexcelfile.setMtoDoc2(Double.parseDouble(mto));
                                    break;
                                case 6:
                                    mto = rowData[j].getContents().replaceAll("\\.", "");
                                    mto = mto.replaceAll("\\,", ".");
                                    uploadexcelfile.setMtoRet1(Double.parseDouble(mto));
                                    switch (tipDoc){
                                        case "FACTURA":
                                            mtoFact += Double.parseDouble(mto);
                                            break;
                                        case "NOTA DE DEBITO":
                                            mtoDeb += Double.parseDouble(mto);
                                            break;
                                        case "NOTA DE CREDITO":
                                            mtoCred += Double.parseDouble(mto);
                                            break;
                                    }
                                    break;
                                case 7:
                                    mto = rowData[j].getContents().replaceAll("\\.", "");
                                    mto = mto.replaceAll("\\,", ".");
                                    uploadexcelfile.setMtoRet2(Double.parseDouble(mto));
                                    break;
                                case 8:
                                    mto = rowData[j].getContents().replaceAll("\\.", "");
                                    mto = mto.replaceAll("\\,", ".");
                                    uploadexcelfile.setMtoExe1(Double.parseDouble(mto));
                                    break;
                                case 9:
                                    mto = rowData[j].getContents().replaceAll("\\.", "");
                                    mto = mto.replaceAll("\\,", ".");
                                    uploadexcelfile.setMtoExe2(Double.parseDouble(mto));
                                    break;
                                case 10:
                                    uploadexcelfile.setNroDoc(rowData[j].getContents());
                                    break;
                                case 11:
                                    uploadexcelfile.setNroControl(rowData[j].getContents());
                                    break;
                                case 12:
                                    uploadexcelfile.setNroDocAfect(rowData[j].getContents());
                                    break;
                                case 13:
                                    mto = rowData[j].getContents().replaceAll("\\.", "");
                                    mto = mto.replaceAll("\\,", ".");
                                    uploadexcelfile.setAlicuota(Double.parseDouble(mto));
                                    break;
                                default:
                                    break;
                            }
                        }
                        sqlexcel.add(uploadexcelfile); 
                        result = Ln.getInstance().save_Upfile_Retenciones(uploadexcelfile, 1, i);
                   }
                }
                workbook.close();
                bt.setText("Procesado");
                
                NumberFormat dfp = new DecimalFormat("###,###,###,##0.00");     
                NumberFormat dfi = new DecimalFormat("###,##0");     

                lb1.setText(dfi.format(rowCount - 28));
                lb2.setText("Fact. " + dfp.format(mtoFact));
                lb3.setText("Cred. " + dfp.format(mtoCred));
                lb4.setText("Deb. " + dfp.format(mtoDeb));
            }
        } catch (IOException | BiffException e) {
        }
    }
}
