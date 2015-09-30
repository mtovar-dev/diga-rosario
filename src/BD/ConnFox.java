/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
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
public class ConnFox extends Bd {
    
    public ConnFox (String[] params){
        this.params = params;
        this.open();
    }
    
    @Override
    public Connection open() {
        try {
            // JdbcOdbcDriver
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            this.connection = DriverManager.getConnection(
                "jdbc:odbc:foxpro", "", "");
        } catch (ClassNotFoundException | SQLException e){
            Tools.getErrorMessage(e.getStackTrace(), e.getMessage());
        }
        return this.connection;
    }
    
}

/*
final String DB_URL =
"jdbc:odbc:Driver={Microsoft FoxPro VFP Driver (*.dbf)};" +
"UID=;"+
"Deleted=Yes;"+
"Null=Yes;"+
"Collate=Machine;"+
"BackgroundFetch=Yes;"+
"Exclusive=No;"+
"SourceType=DBF;"+
"SourceDB=<path to databass>";


String url = "jdbc:odbc:VFP;"+ 
"Deleted=No;"+ 
"Exclusive=No;"+ 
"SourceType=DBF;"+ 
"SourceDB=F:\dbase\DATA";
*/