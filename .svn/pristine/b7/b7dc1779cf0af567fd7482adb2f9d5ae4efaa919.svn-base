/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BD;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;


/**
 *
 * @author MITM
 */
public class SqlProc {

    Bd conn;
    
    /**
     * 
     * @param con 
     */
    public static void ExeSpNoParams(Connection con) {
        try {
            CallableStatement cstmt = con.prepareCall("{call sp_get_usuario}");

            ResultSet rs = cstmt.executeQuery();

            while (rs.next()) {
                System.out.println(rs.getString("NombreCompleto"));
            }
            rs.close();
            cstmt.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }    

    /**
     * 
     * @param con 
     */
    public static void ExeSpInParams(Connection con) {
        try {
            CallableStatement cstmt = con.prepareCall("{call sp_get_usuario_param(?)}");
            cstmt.setInt(1, 50);
            ResultSet rs = cstmt.executeQuery();

            while (rs.next()) {
               System.out.println("Usuario:");
               System.out.println(rs.getString("apellido1") + ", " + rs.getString("nombre1"));
               System.out.println("Rol ID:");
               System.out.println(rs.getString("id_rol"));
               System.out.println();
            }
            rs.close();
            cstmt.close();
         }
        catch (Exception e) {
           e.printStackTrace();
         }
    }

    /**
     * 
     * @param con 
     */
    public static void ExeSpInOutParams(Connection con) {
        try {
            CallableStatement cstmt = con.prepareCall("{call sp_get_usuario_paramIN_paramOUT(?, ?)}");
            //cstmt.setInt(1, 1);
            //cstmt.registerOutParameter(2, java.sql.Types.INTEGER);
            //cstmt.execute();
            //System.out.println("ROL ID: " + cstmt.getInt(2));

            cstmt.setInt("@id_usuario", 1);
            cstmt.registerOutParameter("id_rol", java.sql.Types.INTEGER);
            cstmt.execute();
            System.out.println("ROL ID: " + cstmt.getInt("id_rol"));
            cstmt.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }    

    /**
     * 
     * @param con 
     */
    public static void ExeSpInParamsTypeData(Connection con) {
        try {
//            CallableStatement cstmt = con.prepareCall("{? = call sp_get_usuario_check(?)}");
//            cstmt.registerOutParameter(1, java.sql.Types.INTEGER);
//            cstmt.setString(2, "1");
//            cstmt.execute();

            CallableStatement cstmt = con.prepareCall("{? = call sp_get_user_check(?, ?)}");
            cstmt.setString("@id_user", "mtovar");
            cstmt.setString("@pswd", "123456");
            cstmt.registerOutParameter(1, java.sql.Types.VARCHAR);
            //cstmt.setString(1, "mtovar");
//            cstmt.registerOutParameter(2, java.sql.Types.VARCHAR);
//            cstmt.setString(2, "123456");
            cstmt.execute();
            System.out.println("Existe: " + cstmt.getInt(1));
            cstmt.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }    

    /**
     * 
     * @param con 
     */
    public static void ExeUpdSp(Connection con) {
        try {
            CallableStatement cstmt = con.prepareCall("{call dbo.UpdateTestTable(?, ?)}");
            //cstmt.setString(1, "A");
            cstmt.setInt(1, 100);
            cstmt.execute();
            //int count = cstmt.getUpdateCount();
            cstmt.close();

            //System.out.println("ROWS AFFECTED: " + count);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }    

    /**
     * 
     * @param con 
     */
    public static void executeBatchUpdate(Connection con) {
//CREATE TABLE TestTable 
//   (Col1 int IDENTITY, 
//    Col2 varchar(50), 
//    Col3 int);
        try {
            Statement stmt = con.createStatement();
            stmt.addBatch("INSERT INTO TestTable (Col2, Col3) VALUES ('X', 100)");
            stmt.addBatch("INSERT INTO TestTable (Col2, Col3) VALUES ('Y', 200)");
            stmt.addBatch("INSERT INTO TestTable (Col2, Col3) VALUES ('Z', 300)");
            int[] updateCounts = stmt.executeBatch();
            stmt.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    
    
}
