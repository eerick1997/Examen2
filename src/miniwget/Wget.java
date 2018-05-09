package miniwget;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Scanner;

public class Wget {

    public static void downloadPage(){
        URL url;
        InputStream inputStream = null;
        BufferedReader bufferedReader;
        String line, web_url = "";
        try{
            Scanner scanner = new Scanner(System.in);
            System.out.println("Write the URL of a web page");
            web_url = scanner.nextLine();
            url = new URL(web_url);
            inputStream = url.openStream();
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

            String content="";
            while((line = bufferedReader.readLine()) != null){
                //System.out.println(line);
                content += line;
            }
            System.out.println(content);

        } catch (Exception e) {
            System.err.println("An exception has occurred downloading " + web_url);
        }
    }

    public static void main(String[] args){
        Wget wget = new Wget();
        wget.downloadPage();
    }

}
