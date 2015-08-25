/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Listeners;

import Objects.Setup.GroupSupplier;
import Tools.Datos;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

/**
 *
 * @author MITM
 */
public class CbGroupSupplierKeyHandler implements EventHandler< KeyEvent > {
        private static ObservableList<GroupSupplier> groupsupplier;        
        private String                          s;

        public CbGroupSupplierKeyHandler(ObservableList<GroupSupplier> _groupsupplier) {            
            groupsupplier = _groupsupplier;
            s = "";
        }

        @Override
        public void handle( KeyEvent event ) {            
            // handle non alphanumeric keys like backspace, delete etc
            if( event.getCode() == KeyCode.BACK_SPACE && s.length()>0)
                s = s.substring( 0, s.length() - 1 );
            else s = event.getText();

            if( s.length() == 0 ) {
                Datos.getCbGroupSupplier().getSelectionModel().selectFirst();
                return;
            }            
            for( GroupSupplier item: groupsupplier ) {                
                if( item.getNombre().startsWith( s ) ){
                    Datos.getCbGroupSupplier().getSelectionModel().select( item );
                }
            }            
        }
   
}
