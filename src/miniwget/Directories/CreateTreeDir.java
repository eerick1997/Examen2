package miniwget.Directories;

import miniwget.Wget;

import java.io.File;
import java.net.URL;
import java.net.URLConnection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**This class create a tree directories if we
 * give it a path. miniwget.Directories are make them in
 * the root of our project                      **/
public class CreateTreeDir {

    public void create(String path) throws Exception{
        System.out.println("CreateTreeDir.create");
        System.out.println("path = [" + path + "]");
        File directory;
        String dir = "";
        for(int i = 0; i < path.length(); i++){
            dir+=path.charAt(i);
            if(path.charAt(i) == '\\' || i == path.length()-1){
                directory = new File(dir);
                if(!directory.exists()){
                    System.out.println("creating directory: " + directory.getName());
                    directory.mkdir();
                }
            }
        }
    }

    /**
     * This method search urls in HTML code. This method has been implemented using
     * regular expressions. The regular expression has been made using a Pattern object
     * and Matcher object.
     * **/
    public void searchUrls(String str) throws Exception{
        System.out.println("CreateTreeDir.searchUrls");
        Pattern pattern = Pattern.compile("(?i)HREF\\s*=\\s*\"(.*?)\"");
        Matcher matcher = pattern.matcher(str);
        Wget wget=new Wget();
        String urlx2="a";

        while(matcher.find()){

            String urlx=matcher.group(1);
            if(urlx.contains("http")||urlx.contains("http"))
            {
                System.out.println("Elemento encontrado: "+urlx);
                wget.downloadPage(urlx,urlx2+".html");
                urlx2+="a";
            }
            /*else if(urlx.contains("png"))
            {
                System.out.println("Imagen png encontrada: "+urlb);
                wget.downloadPage(urlb,urlb+".png");
                urlb+="a";
            }*/

        }
    }

    public void searchImages(String str, String urlprincipal) throws Exception{
        System.out.println("CreateTreeDir.searchImages");
        //Pattern pattern = Pattern.compile("(?i)src\\s*=\\s*\"(.*?)");
        Pattern pattern = Pattern.compile("(?i)src\\s*=\\s*\"(.*?)\"");
        Matcher matcher = pattern.matcher(str);
        Wget wget2=new Wget();
        String urlb="b";
        //  Matcher matcher = pattern.matcher(url.toString());
        //System.out.println(url.toString());
        //wget2.downloadPage(url.toString(),"hola.ico");
        while(matcher.find()){
            String urlimg=matcher.group(1);
            if(urlimg.contains(".png"))
            {
                System.out.println("Imagen png encontrada: "+urlimg);
                if(urlimg.contains(".com") || urlimg.contains(".net") || urlimg.contains(".mx") || urlimg.contains(".edu"))
                {
                    wget2.downloadPage(urlimg,urlb+".png");
                }
                else
                {
                    wget2.downloadPage(urlprincipal+urlimg,urlb+".png");
                    System.out.println("Ruta relativa completa: "+urlprincipal+urlimg);
                }
                urlb+="a";

            }
            else if(urlimg.contains(".jpg"))
            {
                System.out.println("Imagen jpg encontrada: "+urlimg);
                if(urlimg.contains(".com") || urlimg.contains(".net") || urlimg.contains(".mx") || urlimg.contains(".edu"))
                {
                    wget2.downloadPage(urlimg,urlb+".jpg");
                }
                else
                {
                    wget2.downloadPage(urlprincipal+urlimg,urlb+".jpg");
                    System.out.println("Ruta relativa completa: "+urlprincipal+urlimg);
                }
                urlb+="a";
            }
            else if(urlimg.contains(".jpeg"))
            {
                System.out.println("Imagen png encontrada: "+urlimg);
                if(urlimg.contains(".com") || urlimg.contains(".net") || urlimg.contains(".mx") || urlimg.contains(".edu"))
                {
                    wget2.downloadPage(urlimg,urlb+".jpeg");
                }
                else
                {
                    wget2.downloadPage(urlprincipal+urlimg,urlb+".jpeg");
                    System.out.println("Ruta relativa completa: "+urlprincipal+urlimg);
                }
                urlb+="a";
            }
            else if(urlimg.contains(".gif"))
            {
                System.out.println("Imagen png encontrada: "+urlimg);
                if(urlimg.contains(".com") || urlimg.contains(".net") || urlimg.contains(".mx") || urlimg.contains(".edu"))
                {
                    wget2.downloadPage(urlimg,urlb+".gif");
                }
                else
                {
                    wget2.downloadPage(urlprincipal+urlimg,urlb+".gif");
                    System.out.println("Ruta relativa completa: "+urlprincipal+urlimg);
                }
                urlb+="a";
            }
            else if(urlimg.contains(".ico"))
            {
                System.out.println("Imagen ico encontrada: "+urlimg);
                if(urlimg.contains(".com") || urlimg.contains(".net") || urlimg.contains(".mx") || urlimg.contains(".edu"))
                {
                    wget2.downloadPage(urlimg,urlb+".ico");
                }
                else
                {
                    wget2.downloadPage(urlprincipal+urlimg,urlb+".ico");
                    System.out.println("Ruta relativa completa: "+urlprincipal+urlimg);
                }
                urlb+="a";
            }

        }

    }

    private String getNameFile(String str){
        String nme_file = "";
        boolean found = false;
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == '.'){

                if(!found)
                    found = true;
                else
                    break;
            }

            if(found){
                nme_file+=str.charAt(i);
            }
        }
        return nme_file;
    }
}