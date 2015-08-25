/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Listeners;

import Objects.Setup.Sex;
import Tools.Datos;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

/**
 *
 * @author MITM
 */
public class CbSexKeyHandler implements EventHandler< KeyEvent >{
        private static ObservableList<Sex> sex;        
        private String                          s;

        public CbSexKeyHandler(ObservableList<Sex> _sex) {            
            sex = _sex;
            s = "";
        }

        @Override
        public void handle( KeyEvent event ) {            
            // handle non alphanumeric keys like backspace, delete etc
            if( event.getCode() == KeyCode.BACK_SPACE && s.length()>0)
                s = s.substring( 0, s.length() - 1 );
            else s = event.getText();

            if( s.length() == 0 ) {
                Datos.getCbSex().getSelectionModel().selectFirst();
                return;
            }            
            for( Sex item: sex ) {                
                if( item.getNombre().startsWith( s ) ){
                    Datos.getCbSex().getSelectionModel().select( item );
                }
            }            
        }
        
}
