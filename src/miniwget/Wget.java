package miniwget;

import javax.swing.*;
import java.io.*;
import java.net.URL;

public class Wget {

    public static void downloadPage(){
        String messy_HTML= "INDICEP.html";
        Lexicografico lexer = new Lexicografico();
        //URL of a web page
        URL url;
        //Input stream
        InputStream inputStream = null;
        //Here we store the url
        String web_url = "";
        web_url = JOptionPane.showInputDialog(null, "What page do you want to clone?");

        try{
            //Creating a connection
            url = new URL(web_url);
            //Getting the input stream of a web page
            inputStream = url.openStream();
            //Creating a File Output Stream
            FileOutputStream fileOutputStream = new FileOutputStream(messy_HTML);
            //We need bytes 'cause we gonna create a file
            byte[] bytes = new byte[1500];
            int n = 0;
            //We get input stream while inputStream returns more than 0
            while((n = inputStream.read(bytes)) > 0){
                fileOutputStream.write(bytes,0,n);
            }
            fileOutputStream.close();
            lexer.order_HTML(messy_HTML);

        } catch (Exception e) {
            System.err.println("An exception has occurred downloading " + web_url);
        }
    }

    public static void main(String[] args){
        Wget wget = new Wget();
        wget.downloadPage();
    }

}
