package miniwget.Directories;

import miniwget.Wget;

import java.io.File;
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

    public void searchImages(String str) throws Exception{
        System.out.println("CreateTreeDir.searchImages");
        //Pattern pattern = Pattern.compile("(?i)src\\s*=\\s*\"(.*?)");
        Pattern pattern = Pattern.compile("(?i)src\\s*=\\s*\"(.*?)\"");
        Matcher matcher = pattern.matcher(str);
        Wget wget2=new Wget();
        String urlb="b";
        while(matcher.find()){
            String urlimg=matcher.group(1);

            if(urlimg.contains("png"))
            {
                System.out.println("Imagen png encontrada: "+urlimg);
                wget2.downloadPage(urlimg,urlb+".png");
                urlb+="a";
            }
            else if(urlimg.contains("jpg"))
            {
                System.out.println("Imagen jpg encontrada: "+urlimg);
                wget2.downloadPage(urlimg,urlb+".jpg");
                urlb+="a";
            }
            else if(urlimg.contains("jpeg"))
            {
                System.out.println("Imagen jpeg encontrada: "+urlimg);
                wget2.downloadPage(urlimg,urlb+".jpeg");
                urlb+="a";
            }
            else if(urlimg.contains("gif"))
            {
                System.out.println("Imagen gif encontrada: "+urlimg);
                wget2.downloadPage(urlimg,urlb+".gif");
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