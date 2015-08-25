/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Listeners;

import GUI.Gui;
import javafx.event.EventHandler;
import javafx.scene.control.SingleSelectionModel;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

/**
 *
 * @author ARMGARCES
 */
public class KeyHandler implements EventHandler< KeyEvent > {
        private int focusPos;
        private SingleSelectionModel< String >  sm;
        private String                          s;

        public KeyHandler(int _pos) {
            focusPos = _pos;
        }

        @Override
        public void handle( KeyEvent event ) {
            System.out.println("hello = ");
            if( event.getCode() == KeyCode.ENTER){
                Gui.setFieldFocused(focusPos);
                System.out.println("done = ");
            }
        }

    }