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
 * @author MITM
 */
public class LeftBar {

    private static final Gui gui = Gui.getInstance();

    private static String value;

    private Node rootIcon;
    private Image nodeIcon;
    private Image itemIcon;

    private Image comIcon;
    private Image logIcon;
    private Image finIcon;
    private Image hhrIcon;
    private Image conIcon;
    private Image sysIcon;
    private Image usrIcon;

    public LeftBar() {
        try {
            final Node rootIcon1 = new ImageView(new Image(getClass().getResourceAsStream("/Images/img54a.png")));
            final Image nodeIcon1 = new Image(getClass().getResourceAsStream("/Images/img39a.png"));
            final Image itemIcon1 = new Image(getClass().getResourceAsStream("/Images/img73a.png"));

            final Image comIcon1 = new Image(getClass().getResourceAsStream("/Images/img23.png"));
            final Image logIcon1 = new Image(getClass().getResourceAsStream("/Images/img24.png"));
            final Image finIcon1 = new Image(getClass().getResourceAsStream("/Images/img25.png"));
            final Image hhrIcon1 = new Image(getClass().getResourceAsStream("/Images/img26.png"));
            final Image conIcon1 = new Image(getClass().getResourceAsStream("/Images/img17.png"));
            final Image sysIcon1 = new Image(getClass().getResourceAsStream("/Images/img18.png"));
            final Image usrIcon1 = new Image(getClass().getResourceAsStream("/Images/img20.png"));

            rootIcon = rootIcon1;
            nodeIcon = nodeIcon1;
            itemIcon = itemIcon1;

            comIcon = comIcon1;
            logIcon = logIcon1;
            finIcon = finIcon1;
            hhrIcon = hhrIcon1;
            conIcon = conIcon1;
            sysIcon = sysIcon1;
            usrIcon = usrIcon1;

        } catch (Exception e) {
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
     *
     * @param items
     */
    public void loadLeftBar(ItemLeftBar[] items) {

        Node node = Tools.getNode(Gui.getAp_leftbar(), "#tv_tree");
        final TreeView tv_tree = (TreeView) node;
        tv_tree.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

        TreeItem<String> treeItemRoot = new TreeItem<>(
                Datos.getSesion().getUsername(), Gui.getLeftBar().getRootIcon());

        treeItemRoot.setExpanded(true);
        tv_tree.setRoot(treeItemRoot);

        tv_tree.setOnMouseClicked((MouseEvent mouseEvent) -> {
            if (mouseEvent.getButton().equals(MouseButton.PRIMARY)) {
                if (mouseEvent.getClickCount() > 1) {
                    String sItemMenu = tv_tree.getSelectionModel().getSelectedItems().toString();
                    if (sItemMenu.length() > 19) {
                        value = sItemMenu.substring(19, sItemMenu.length() - 2).trim();
                        if (Gui.getInstance().getTipoOperacion() != 0) {
                            String id = java.util.ResourceBundle.getBundle("GUI/Screens/Screens").getString("changeScreen");
                            Datos.setIdScreen(Integer.parseInt(id));

                            String mensj = "¿Seguro que desea salir de la Pantalla actual?";
                            Gui.getInstance().showConfirmar(mensj);
                        } else {
                            openSelection();
                        }
                    }
                }
            }
        });

        TreeItem itemRoot = null;
        TreeItem itemNode = null;

        for (ItemLeftBar menu : Datos.getItemLeftBar()) {

            if ((menu.getMenu() != null) && (menu.getNombre_mn() == null) && (menu.getNombre_smn1() == null)) {
                switch (menu.getMenu()) {
                    case "Compras":
                        treeItemRoot.getChildren().addAll(
                                itemRoot = new TreeItem<>(menu.getMenu(), new ImageView(comIcon)));
                        break;
                    case "Logistica":
                        treeItemRoot.getChildren().addAll(
                                itemRoot = new TreeItem<>(menu.getMenu(), new ImageView(logIcon)));
                        break;
                    case "Finanzas":
                        treeItemRoot.getChildren().addAll(
                                itemRoot = new TreeItem<>(menu.getMenu(), new ImageView(finIcon)));
                        break;
                    case "Gestión Humana":
                        treeItemRoot.getChildren().addAll(
                                itemRoot = new TreeItem<>(menu.getMenu(), new ImageView(hhrIcon)));
                        break;
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

            if ((menu.getMenu() != null) && (menu.getNombre_mn() != null) && (menu.getNombre_smn1() == null)) {
//                if (!menu.getNombre_mn().equals("Usuarios")) {
                    itemRoot.getChildren().addAll(
                            itemNode = new TreeItem<>(menu.getNombre_mn(), new ImageView(itemIcon)));
//                } else {
//                    itemRoot.getChildren().addAll(
//                            itemNode = new TreeItem<>(menu.getNombre_mn(), new ImageView(usrIcon)));
//                }
            }

            if ((menu.getMenu() != null) && (menu.getNombre_mn() != null) && (menu.getNombre_smn1() != null)) {
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
    public static void openSelection() {
        switch (value) {
            case "Proveedores":
                Screens.getInstance().startSupplier();
                break;
            case "Nuevas":
                Screens.getInstance().startOrders_new();
                break;
            case "Abiertas":
                Screens.getInstance().startOrders_open();
                break;
            case "Cerradas":
                Screens.getInstance().startOrders_closed();
                break;

            case "Factura":
                Screens.getInstance().startGuide_branch();
                break;
            case "Guia de Carga":
                Screens.getInstance().startGuide_main();
                break;
            case "Recuperación":
                Screens.getInstance().startGuide_recovery();
                break;

            case "Personal":
                Screens.getInstance().startFleet_staff();
                break;
            case "Vehiculo":
                Screens.getInstance().startFleet_vehicle();
                break;

            case "Faltante de Carga":
                Screens.getInstance().startReport_Missingload();
                break;
            case "Fact. Anuladas por Sucursal":
                Screens.getInstance().startReport_Invoicebranch();
                break;

            case "Fact. Emitidas":
                Screens.getInstance().startIndicators_Invoicemade();
                break;
            case "Fact. Despachadas":
                Screens.getInstance().startIndicators_Invoiceloaded();
                break;
            case "Guias Emitidas":
                Screens.getInstance().startIndicators_Guidemade();
                break;
            case "Guias Despachadas":
                Screens.getInstance().startIndicators_Guideloaded();
                break;
            case "Guias Pendientes":
                Screens.getInstance().startIndicators_Guidepending();
                break;
            case "Vehiculos Cargados":
                Screens.getInstance().startIndicators_Vehiclesloaded();
                break;

            case "Caja":
                Screens.getInstance().startRelation_Guidepaydesk();
                break;
            case "Glomar":
                Screens.getInstance().startRelation_Guideinvglomar();
                break;

            case "Consulta de Rif":
                Screens.getInstance().startSeniat_Qryrif();
                break;
            case "Carga de Retenciones":
                Screens.getInstance().startSeniat_Upfileretenciones();
                break;
            case "Consulta de Retenciones":
                Screens.getInstance().startSeniat_Qryretenciones();
                break;

            case "Concepto":
                Screens.getInstance().startHhrr_Audconcepto();
                break;
            case "Empleado":
                Screens.getInstance().startHhrr_Audempleado();
                break;
            case "Empresa":
                Screens.getInstance().startHhrr_Audempresa();
                break;

            case "Aseguradora":
                Screens.getInstance().startConfig_Insurance();
                break;
            case "Disp. de Flota":
                Screens.getInstance().startConfig_Available();
                break;
            case "Grupo de Proveedores":
                Screens.getInstance().startConfig_Groupsupplier();
                break;
            case "Medidas":
                Screens.getInstance().startConfig_Measure();
                break;
            case "Motivos":
                Screens.getInstance().startConfig_Reason();
                break;
            case "Unidades":
                Screens.getInstance().startConfig_Unit();
                break;

            case "Usuarios":
                Screens.getInstance().startSystem_User();
                break;
            case "Roles":
                Screens.getInstance().startSystem_Role();
                break;
//            default:
//                Stage aux = gui.getStage();
//                Screens.getInstance().startIndex(aux);
//                break;
        }
    }
}
