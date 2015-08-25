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
public final class ConnSqlServer extends Bd {

    public ConnSqlServer (String[] params){
        this.params = params;
        this.open();
    }
    
    @Override
    public Connection open() {
        try {
            // jdbc - sourceforge
            Class.forName("net.sourceforge.jtds.jdbc.Driver");
            this.connection = DriverManager.getConnection(
                "jdbc:jtds:sqlserver://" + this.params[0] + ":" + this.params[1] + ";databaseName=" +  this.params[2], this.params[3], this.params[4]);
        } catch (ClassNotFoundException | SQLException e){
            Tools.getErrorMessage(e.getStackTrace(), e.getMessage());
        }
        return this.connection;
    }
    
}
