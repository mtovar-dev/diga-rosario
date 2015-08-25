/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Listeners;

import Objects.Setup.Country;
import Tools.Datos;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

/**
 *
 * @author MITM
 */
public class CbCountryKeyHandler implements EventHandler< KeyEvent > {
        private static ObservableList<Country> country;        
        private String                          s;

        public CbCountryKeyHandler(ObservableList<Country> _country) {            
            country = _country;
            s = "";
        }

        @Override
        public void handle( KeyEvent event ) {            
            // handle non alphanumeric keys like backspace, delete etc
            if( event.getCode() == KeyCode.BACK_SPACE && s.length()>0)
                s = s.substring( 0, s.length() - 1 );
            else s = event.getText();

            if( s.length() == 0 ) {
                Datos.getCbCountry().getSelectionModel().selectFirst();
                return;
            }            
            for( Country item: country ) {                
                if( item.getNombre().startsWith( s ) ){
                    Datos.getCbCountry().getSelectionModel().select( item );
                }
            }            
        }
    
}
