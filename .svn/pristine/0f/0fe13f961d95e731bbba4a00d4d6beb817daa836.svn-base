/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Tools;

import javafx.scene.Node;

/**
 *
 * @author ARMGARCES
 */
public class Tools {
 
    /**
     * Metodo que rastrea la Ubicacion, el Metodo y la linea de una Excepcion que se ha 
     * ejecutado e imprime el mensaje correspondiente.
     * @param stacktrace Log de ejecucion del programa.
     * @param msg Mensaje Personalizado del error.
     */
    public static void getErrorMessage(StackTraceElement[] stacktrace, String msg){
        //
        StackTraceElement e = stacktrace[1];
        String className = e.getClassName();
        String methodName = e.getMethodName();
        int lineNumber = e.getLineNumber();
        
        System.out.println(className + " > " + methodName + " > line " + lineNumber + " : " + msg);
    }
    
    /**
     * 
     * @param param Refiere al Nodo o Panel donde se procedera a buscar
     * @param id Valor del ID de el componente que se desea buscar
     * @return 
     */
    public static Node getNode(Node param,String id){
        return param.lookup(id);
    }
    /**
     * 
     * @param value
     * @return Cadena de Caracteres con saltos de linea para los efectos de Texto Vertical
     */
    public static String verticalText(String value){
        String string = "";
        for (int i = 0; i < value.length(); i++) {
            string += value.charAt(i) + "\n";            
        }
        return string;
    }
}
