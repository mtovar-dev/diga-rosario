/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Listeners;

import Objects.Setup.City;
import Tools.Datos;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

/**
 *
 * @author MITM
 */
public class CbCityKeyHandler implements EventHandler< KeyEvent >{
        private static ObservableList<City> city;        
        private String                          s;

        public CbCityKeyHandler(ObservableList<City> _city) {            
            city = _city;
            s = "";
        }

        @Override
        public void handle( KeyEvent event ) {            
            // handle non alphanumeric keys like backspace, delete etc
            if( event.getCode() == KeyCode.BACK_SPACE && s.length()>0)
                s = s.substring( 0, s.length() - 1 );
            else s = event.getText();

            if( s.length() == 0 ) {
                Datos.getCbCity().getSelectionModel().selectFirst();
                return;
            }            
            for( City item: city ) {                
                if( item.getNombre().startsWith( s ) ){
                    Datos.getCbCity().getSelectionModel().select( item );
                }
            }            
        }
    
}
