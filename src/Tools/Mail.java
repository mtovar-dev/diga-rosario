/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tools;

import Objects.System.Email;
import java.io.InputStream;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 *
 * @author MITM
 */
public class Mail {

    public static Email SendMail(Email email) {
        Properties props = new Properties();
        props.put("mail.smtp.host", "mail.grupodiga.com");
        //props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.port", "26");
        props.put("mail.smtp.auth", "true");

        Session session = Session.getInstance(props,
            new javax.mail.Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(Datos.getSesion().getEmail(), Datos.getSesion().getEmail_pswd());
                }
            });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(email.getUsr_email()));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(email.getUsr_to()));
            message.setRecipients(Message.RecipientType.CC,
                    InternetAddress.parse(email.getUsr_cc()));
            message.setSubject(email.getSubject());

            Multipart mp = new MimeMultipart();

            MimeBodyPart htmlPart = new MimeBodyPart();
            htmlPart.setContent(email.getMessage(), "text/html; charset=utf-8");
            mp.addBodyPart(htmlPart);

            MimeBodyPart attachment = new MimeBodyPart();
            attachment.setDataHandler(new DataHandler(new FileDataSource(email.getPathFile())));
            attachment.setFileName(email.getAttachFile());
            mp.addBodyPart(attachment);
  
            message.setContent(mp);            

            Transport.send(message);
            return email;
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
    
}
//         message.setContent("<h1>This is actual message</h1>", "text/html" );
