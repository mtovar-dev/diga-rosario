/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BD;

import Tools.Protector;
import Tools.Tools;
import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author MITM
 */
public class ConnBdType {
    public static final int SqlServer   = 1;
    public static final int MySql       = 2;
    public static final int Foxpro      = 3;
    public static final int Oracle      = 4;
    public static String[] SqlParam;
    public static String[] MySqlParam;
    public static String[] FoxParam;
    public static String[] OracleParam;

    // jdbc - sourceforge
    public static String        url          = "jdbc:jtds:sqlserver://";
    public static String        serverName   = "";
    public static String        portNumber   = "";
    public static String        databaseName = "";
    public static String        userName     = "";
    public static String        password     = "";    
    
    
    private static void getXmlConfig(){
        try {
            File fXmlFile = new File("cfg.xml");

            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);

            doc.getDocumentElement().normalize();

            NodeList nList = doc.getElementsByTagName("Server");

            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    serverName      = eElement.getElementsByTagName("serverName").item(0).getTextContent();
                    portNumber      = eElement.getElementsByTagName("portNumber").item(0).getTextContent();
                    databaseName    = eElement.getElementsByTagName("databaseName").item(0).getTextContent();
                    userName        = eElement.getElementsByTagName("userName").item(0).getTextContent();
                    password        = eElement.getElementsByTagName("password").item(0).getTextContent();
                }
            }
        } catch (IOException | ParserConfigurationException | DOMException | SAXException e) {
            e.printStackTrace();
        }
        
    }
    
    public static BdInterface open(int typeDb){
        String salt     = java.util.ResourceBundle.getBundle("BD/DBcon").getString("dns");

        getXmlConfig();

        try{ 
            serverName   = Protector.decrypt(serverName, salt);
            databaseName = Protector.decrypt(databaseName, salt);
            userName     = Protector.decrypt(userName, salt);
            password     = Protector.decrypt(password, salt);
        } catch (Exception e){
            Tools.getErrorMessage(e.getStackTrace(), e.getMessage());
        }

        switch(typeDb){
            case ConnBdType.SqlServer:
                SqlParam = new String[] {serverName, portNumber, databaseName, userName, password};
                return new ConnSqlServer(SqlParam);
            case ConnBdType.MySql:
                MySqlParam = new String[] {serverName, portNumber, databaseName, userName, password};
                return new ConnMySql(MySqlParam);
            case ConnBdType.Foxpro:
                FoxParam = new String[] {databaseName, userName, password};
                return new ConnFox(FoxParam);
            case ConnBdType.Oracle:
                OracleParam = new String[] {"jdbc:oracle:thin:@192.168.1.16:1521:spi", "consulta", "consultavista"};
                return new ConnOracle(OracleParam);
            default:
                return null;
        }
    }
}
