/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.LeftBar;

import GUI.Gui;
import GUI.Screens.Screens;
import Objects.System.ItemLeftBar;
import Tools.Datos;
import Tools.Tools;
import javafx.scene.Node;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

/**
 *
 * @author Personal
 */
public class LeftBar {
    private static final Gui gui = Gui.getInstance();
    
    private static String value;
    
    private Node rootIcon;
    private Image nodeIcon;
    private Image itemIcon;
    private Image conIcon;
    private Image sysIcon;
    private Image usrIcon;
    
    public LeftBar(){
        try{
            final Node rootIcon1 = new ImageView(new Image(getClass().getResourceAsStream("/Images/img54a.png")));
            final Image nodeIcon1 = new Image(getClass().getResourceAsStream("/Images/img39a.png"));
            final Image itemIcon1 = new Image(getClass().getResourceAsStream("/Images/img73a.png"));
            final Image conIcon1 = new Image(getClass().getResourceAsStream("/Images/img17a.png"));
            final Image sysIcon1 = new Image(getClass().getResourceAsStream("/Images/img18a.png"));
            final Image usrIcon1 = new Image(getClass().getResourceAsStream("/Images/img20a.png"));
            
            rootIcon = rootIcon1;
            nodeIcon = nodeIcon1;
            itemIcon = itemIcon1;
            conIcon = conIcon1;
            sysIcon = sysIcon1;
            usrIcon = usrIcon1;
            
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
     
    /**
     * Limpia el leftBar para cuando no hay sesion o se ejecuta un LogOff
     */
    public void clearLeftBar() {
        Node node = Tools.getNode(Gui.getAp_leftbar(), "#tv_tree");
        TreeView tv_tree = (TreeView) node;
        tv_tree.setRoot(null);
    }
    
    /**
     * Carga de BD el leftBar
     * @param items
     */
    public void loadLeftBar(ItemLeftBar[] items){
        
        Node node = Tools.getNode(Gui.getAp_leftbar(), "#tv_tree");
        final TreeView tv_tree = (TreeView) node;
        tv_tree.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        
        TreeItem<String> treeItemRoot = new TreeItem<>(
            Datos.getSesion().getUsername(), Gui.getLeftBar().getRootIcon());

        treeItemRoot.setExpanded(true);
        tv_tree.setRoot(treeItemRoot);
       
        
        tv_tree.setOnMouseClicked((MouseEvent mouseEvent) -> {
            if(mouseEvent.getButton().equals(MouseButton.PRIMARY)){
                if(mouseEvent.getClickCount() > 1){
                    String sItemMenu = tv_tree.getSelectionModel().getSelectedItems().toString();
                    if(sItemMenu.length() > 19){
                        value = sItemMenu.substring(19, sItemMenu.length()-2).trim();
                        if(Gui.getInstance().getTipoOperacion() != 0){
                            String id =  java.util.ResourceBundle.getBundle("GUI/Screens/Screens").getString("changeScreen");
                            Datos.setIdScreen(Integer.parseInt(id));

                            String mensj = "¿Seguro que desea salir de la Pantalla actual?";
                            Gui.getInstance().showConfirmar(mensj);
                        }else{
                            openSelection();                        
                        }
                    }
                }
            }
        });        
        
        TreeItem itemRoot = null;
        TreeItem itemNode = null;
        
        for (ItemLeftBar menu : Datos.getItemLeftBar()) {

            if ( (menu.getMenu() != null) && (menu.getNombre_mn() == null) && (menu.getNombre_smn1() == null) ){
                switch(menu.getMenu()){
                    case "Configuración":
                        treeItemRoot.getChildren().addAll(
                                itemRoot = new TreeItem<>(menu.getMenu(), new ImageView(conIcon)));
                        break;
                    case "Sistemas":
                        treeItemRoot.getChildren().addAll(
                                itemRoot = new TreeItem<>(menu.getMenu(), new ImageView(sysIcon)));
                        break;
                    default:
                        treeItemRoot.getChildren().addAll(
                                itemRoot = new TreeItem<>(menu.getMenu(), new ImageView(nodeIcon)));
                        break;
                }
            }


            if ( (menu.getMenu() != null) && (menu.getNombre_mn() != null) && (menu.getNombre_smn1() == null) ){
                if(!menu.getNombre_mn().equals("Usuarios")){
                    itemRoot.getChildren().addAll(
                            itemNode = new TreeItem<>(menu.getNombre_mn(), new ImageView(itemIcon)));
                }else{
                    itemRoot.getChildren().addAll(
                            itemNode = new TreeItem<>(menu.getNombre_mn(), new ImageView(usrIcon)));
                }
            }

            if ( (menu.getMenu() != null) && (menu.getNombre_mn() != null) && (menu.getNombre_smn1() != null) ){
                itemNode.setGraphic(new ImageView(nodeIcon));
                
                itemNode.getChildren().addAll(
                        new TreeItem<>(menu.getNombre_smn1(), new ImageView(itemIcon)));
            }

        }
        
    }    
    /**
     * @return the rootIcon
     */
    public Node getRootIcon() {
        return rootIcon;
    }
    
    /**
     * @param rootIcon the rootIcon to set
     */
    public void setRootIcon(Node rootIcon) {
        this.rootIcon = rootIcon;
    }
    /**
     * 
     */
    public static void openSelection(){
        switch (value){
            case "Proveedores":
                Screens.getInstance().startSupplier();
                break;
            case "Nuevas":
                Screens.getInstance().startOrdersNew();
                break;
            case "Abiertas":
                Screens.getInstance().startOrdersOpen();
                break;
            case "Datos de Carga":
                Screens.getInstance().startGuide_data();
                break;
            case "Informe de Carga":
                Screens.getInstance().startGuide_print();
                break;
            case "Relación de Caja":
                Screens.getInstance().startGuide_paydesk();
                break;
            case "Facturación de Carga":
                Screens.getInstance().startGuide_InvoiceGlomar();
                break;
            case "Personal":
                Screens.getInstance().startPersonal();
                break;
            case "Vehiculos":
                Screens.getInstance().startVehicles();
                break;
            case "Medidas":
                Screens.getInstance().startMeasure();
                break;
            case "Grupo de Proveedores":
                Screens.getInstance().startGroupSupplier();
                break;
            case "Unidades":
                Screens.getInstance().startUnit();
                break;
            case "Motivos":
                Screens.getInstance().startReason();
                break;
            case "Usuarios":
                Screens.getInstance().startUser();
                break;
            case "Roles":
                Screens.getInstance().startRole();
                break;
            case "Concepto":
                Screens.getInstance().startAud_Gh_Concepto();
                break;
            case "Empleado":
                Screens.getInstance().startAud_Gh_Empleado();
                break;
            case "Empresa":
                Screens.getInstance().startAud_Gh_Empresa();
                break;
            case "Consulta de Rif":
                //Screens.getInstance().startAud_Gh_Concepto();
                break;
            case "Carga de Retenciones":
                Screens.getInstance().startSeniat_UpFile_Reten();
                break;
            case "Consulta de Retenciones":
                Screens.getInstance().startSeniat_Query_Reten();
                break;
//            default:
//                Stage aux = gui.getStage();
//                Screens.getInstance().startIndex(aux);
//                break;
        }
    }
}

