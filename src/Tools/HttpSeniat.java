/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Tools;

import GUI.Gui;
import Objects.Seniat.ValidateRif;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;

/**
 *
 * @author MITM
 */
public class HttpSeniat {

    public static ValidateRif getHttpSeniat(String sRif) {
        ValidateRif seniat = new ValidateRif();

        try{
            URL url = new URL(
                "http://contribuyente.seniat.gob.ve/getContribuyente/getrif?rif=" +  sRif);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setInstanceFollowRedirects(true);  
            HttpURLConnection.setFollowRedirects(true);        

            seniat.setStatus(conn.getResponseCode());

            if((seniat.getStatus() >= 200) && (seniat.getStatus() <= 299)){
                seniat.setStatus(200);
                BufferedReader in = new BufferedReader(
                    new InputStreamReader(conn.getInputStream()));

                String inputLine="" ;
                String readLine="";

                while(true){
                    readLine = in.readLine();
                    if(readLine != null)
                        inputLine = inputLine + readLine ;
                    else
                        break;
                }

                final DocumentBuilderFactory f  = DocumentBuilderFactory.newInstance();
                final DocumentBuilder        db = f.newDocumentBuilder();
                final InputSource            is = new InputSource();

                is.setCharacterStream(new StringReader(inputLine));
                final Document               doc = db.parse(is);

                doc.getDocumentElement().normalize();
                int pos = doc.getElementsByTagName("rif:Nombre").item(0).getTextContent().indexOf("(");
                if (pos == -1)
                    seniat.setNombre(doc.getElementsByTagName("rif:Nombre").item(0).getTextContent());                
                else
                    seniat.setNombre(doc.getElementsByTagName("rif:Nombre").item(0).getTextContent().substring(0, pos));
                
                seniat.setIva_agen(doc.getElementsByTagName("rif:AgenteRetencionIVA").item(0).getTextContent());
                seniat.setIva_cont(doc.getElementsByTagName("rif:ContribuyenteIVA").item(0).getTextContent());
                seniat.setTasa(Integer.parseInt(doc.getElementsByTagName("rif:Tasa").item(0).getTextContent()));
            }
            return seniat;
        } catch (Exception e) {
            switch(e.getMessage()){
                case "Connection refused: connect":
                    Gui.getInstance().ventanaError("Error en conexion: \n" + "Servidor SENIAT no disponible"); 
                case "Connection timed out: connect":
                    Gui.getInstance().ventanaError("Error en conexion: \n" + "Servidor SENIAT no disponible"); 
                default:
                    e.printStackTrace();
            }
            
            return null;
        }
    }
    
    public static ValidateRif getHttpSeniatCi(String sCedula) {
//        Objects.ValidateRif seniat = new Objects.ValidateRif();
//        
//        StringBuffer contenido = new StringBuffer();
//
//        try {
//
//        String nacionalidad = "V";
////      String cedula = "14362641";
//        String cedula = "19733258";
//
//        URL url = new URL("http://contribuyente.seniat.gob.ve/BuscaRif/BuscaRif.jsp?p_cedula=" + cedula);
//
//        BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
//        String line;
//        int i = 0;
//        while ((line = reader.readLine()) != null) {
//                if(i==73)
//                        contenido.append(line);
//                i++;
//        }
//        reader.close();
//
//        System.out.println(contenido.toString());
//
//        } catch (MalformedURLException e) {
//
//        } catch (IOException e) {
//        }
//
//        System.out.println(":"+contenido.indexOf("\">")+":");
//        String contenido1 = contenido.substring(53+2);
//        System.out.println("final:"+contenido1.indexOf("<")+":");
//        System.out.println(":"+contenido1.substring(0,52)+":");
        return null;
    }
}