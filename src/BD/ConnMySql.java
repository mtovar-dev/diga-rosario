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
 * @author MITM
 */
public final class ConnMySql extends Bd {

    public ConnMySql (String[] params){
        this.params = params;
        this.open();
    }    

    @Override
    public Connection open() {
        try {
            // mysql.jdbc
            Class.forName("com.mysql.jdbc.Driver");
            this.connection = DriverManager.getConnection(
                "jdbc:mysql://" + this.params[0] + ":" + this.params[1] + "/" +  this.params[2], this.params[3], this.params[4]);
        } catch (ClassNotFoundException | SQLException e){
            Tools.getErrorMessage(e.getStackTrace(), e.getMessage());
        }
        return this.connection;
    }
    
}
