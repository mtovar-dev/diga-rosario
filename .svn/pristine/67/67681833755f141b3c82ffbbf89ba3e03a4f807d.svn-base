/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tools;

import javafx.scene.control.TextField;

/**
 *
 * @author MITM
 */
public class ValidateTextFieldPassword extends TextField {
    private int minlength;
    String pattern = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+-*=])(?=\\S+$).{6,10}";

    public ValidateTextFieldPassword() {
        this.minlength = 6;
    }

    public void setMinlength(int minlength) {
        this.minlength = minlength;
    }

    @Override
    public void replaceText(int start, int end, String text) {
        if(text.matches(pattern) || text.isEmpty()){
            super.replaceText(start, end, text); 
            verify();
        }
    }

    @Override
    public void replaceSelection(String text) {
        super.replaceSelection(text); 
        verify();
    }

    private void verify() {
        if (getText().length() < minlength) {
            setText(getText().substring(0, minlength));
        }
    }    
}
