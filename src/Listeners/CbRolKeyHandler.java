/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Listeners;

import Objects.System.Rol;
import Tools.Datos;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

/**
 *
 * @author ARMGARCES
 */
public class CbRolKeyHandler implements EventHandler< KeyEvent > {
        private static ObservableList<Rol> roles;        
        private String                          s;

        public CbRolKeyHandler(ObservableList<Rol> _roles) {            
            roles = _roles;
            s = "";
        }

        @Override
        public void handle( KeyEvent event ) {            
            // handle non alphanumeric keys like backspace, delete etc
            if( event.getCode() == KeyCode.BACK_SPACE && s.length()>0)
                s = s.substring( 0, s.length() - 1 );
            else s = event.getText();

            if( s.length() == 0 ) {
                Datos.getRoles().getSelectionModel().selectFirst();
                return;
            }            
            for( Rol item: roles ) {                
                if( item.getNombre().startsWith( s ) ){
                    Datos.getRoles().getSelectionModel().select( item );
                }
            }            
        }

}

