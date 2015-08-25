/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BD;

import Tools.Tools;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 
 * @author ARMGARCES
 */
public final class ConnOracle extends Infocent {

    public ConnOracle (String[] params){
        this.params = params;
        this.open();
    }

    @Override
    public Connection open() {
        try {
            // jdbc 
            Class.forName("oracle.jdbc.driver.OracleDriver");
            this.connection = DriverManager.getConnection(
                    this.params[0], this.params[1], this.params[2]);
        } catch (ClassNotFoundException | SQLException e){
            Tools.getErrorMessage(e.getStackTrace(), e.getMessage());
        }
        return this.connection;
    }
    
}
