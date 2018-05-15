package miniwget;


import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import miniwget.Directories.*;



/**
 * Wget is a class that allow us to download a resource or a web page if
 * we give it an URL
 * **/
public class Wget{

    //public static CreateTreeDir createTreeDir;

    public void downloadPage(final String anURL, final String name_file){

        //Creating a thread to download a page
        Thread thread = new Thread(){
            @Override
            public void run(){
                //URL of a web page
                URL url;

                //Input stream
                InputStream inputStream = null;
                try{
                    File file = new File(name_file);
                    if(file.exists())
                        return;

                    String result = "";
                    CreateTreeDir createTreeDir = new CreateTreeDir();
                    //Creating a connection
                    url = new URL(anURL);
                    //Getting the input stream of a web page
                    inputStream = url.openStream();
                    //Creating a File Output Stream
                    FileOutputStream fileOutputStream = new FileOutputStream(name_file);

                    //We need bytes 'cause we gonna create a file
                    byte[] bytes = new byte[1500];
                    int n = 0;
                    //We get input stream while inputStream returns more than
                    while((n = inputStream.read(bytes)) > 0){
                        result += new String(bytes);
                        fileOutputStream.write(bytes,0,n);
                    }
                    //System.out.println(result);
                    createTreeDir.searchImages(result,anURL);
                    fileOutputStream.close();

                } catch (Exception e) {
                    System.err.println("An exception has occurred downloading " + anURL);
                }
            }
        };
        thread.start();

    }

    public static void main(String[] args){
        Wget wget = new Wget();
        wget.downloadPage("https://www.google.com","index.html");



    }

}
