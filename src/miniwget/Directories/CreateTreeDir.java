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
    public void searchUrls(String str,String urlprincipal) throws Exception{
        System.out.println("CreateTreeDir.searchUrls");
        Pattern pattern = Pattern.compile("(?i)HREF\\s*=\\s*\"(.*?)\"");
        Matcher matcher = pattern.matcher(str);
        Wget wget=new Wget();


        while(matcher.find()){

            String urlx=matcher.group(1);

            if(urlx.contains(".html"))
            {
                System.out.println("Elemento encontrado: "+urlx);


                //inicio de cambios
                int contador=0;
                for(int i=0;i<urlx.length();i++)
                {
                    if(urlx.charAt(i)=='/')
                    {
                        contador++;
                    }
                }
                String[]urlhtml=urlx.split("/");

                System.out.println("Nombre del html:"+urlhtml[contador]);


                if(urlx.contains(".com") || urlx.contains(".net") || urlx.contains(".mx") || urlx.contains(".edu"))
                {
                    wget.downloadPage(urlx,urlhtml[contador]);
                    System.out.println("URLX= "+urlx);
                }
                else
                {
                    System.out.println("");

                    System.out.println("URL PRINCIPAL: "+urlprincipal);
                    String []urlprincipalnuevo=urlprincipal.split(".htm");
                    System.out.println("*********:"+urlprincipalnuevo[0]);
                    System.out.println("URL HTML: "+urlhtml[contador]);
                    System.out.println("Nombre chido del html:" +urlprincipalnuevo[0]+"/"+urlhtml[contador]);

                    wget.downloadPage(urlprincipalnuevo[0]+"/"+urlhtml[contador],urlhtml[contador]);

                }
                contador=0;


                //Cambio de arriba

                //fin de cambios
            }


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
                //Inicio de cambios
                String[]urlimgchida=urlimg.split(".png");
                System.out.println("urlimgchida:"+urlimgchida[0]+".png");
                URL urlxas=new URL(urlprincipal+urlimgchida[0]+".png");//Checat
                String nuevo=urlxas.toString();
                int contador=0;
                for(int i=0;i<nuevo.length();i++)
                {
                    if(nuevo.charAt(i)=='/')
                    {
                        contador++;
                    }
                }
                System.out.println("contador:"+contador);
                String[]parts=nuevo.split("/");
                System.out.println("imprimir:"+parts[contador]);
                //Fin de cambios

                if(urlimg.contains(".com") || urlimg.contains(".net") || urlimg.contains(".mx") || urlimg.contains(".edu"))
                {
                    wget2.downloadPage(urlimg,parts[contador]);

                }
                else
                {
                    wget2.downloadPage(urlprincipal+urlimg,parts[contador]);
                    System.out.println("Ruta relativa completa: "+urlprincipal+urlimg);

                }
                contador=0;

            }
            else if(urlimg.contains(".jpg"))
            {
                System.out.println("Imagen jpg encontrada: "+urlimg);
                //Inicio de cambios
                String[]urlimgchida=urlimg.split(".jpg");
                System.out.println("urlimgchida:"+urlimgchida[0]+".jpg");
                URL urlxas=new URL(urlprincipal+urlimgchida[0]+".jpg");
                String nuevo=urlxas.toString();
                int contador=0;
                for(int i=0;i<nuevo.length();i++)
                {
                    if(nuevo.charAt(i)=='/')
                    {
                        contador++;
                    }
                }
                System.out.println("contador:"+contador);
                String[]parts=nuevo.split("/");
                System.out.println("imprimir:"+parts[contador]);
                //Fin de cambios

                if(urlimg.contains(".com") || urlimg.contains(".net") || urlimg.contains(".mx") || urlimg.contains(".edu"))
                {
                    wget2.downloadPage(urlimg,parts[contador]);

                }
                else
                {
                    wget2.downloadPage(urlprincipal+urlimg,parts[contador]);
                    System.out.println("Ruta relativa completa: "+urlprincipal+urlimg);

                }
                contador=0;
            }
            else if(urlimg.contains(".jpeg"))
            {
                System.out.println("Imagen jpeg encontrada: "+urlimg);
                //Inicio de cambios
                String[]urlimgchida=urlimg.split(".jpeg");
                System.out.println("urlimgchida:"+urlimgchida[0]+".jpeg");
                URL urlxas=new URL(urlprincipal+urlimgchida[0]+".jpeg");
                String nuevo=urlxas.toString();
                int contador=0;
                for(int i=0;i<nuevo.length();i++)
                {
                    if(nuevo.charAt(i)=='/')
                    {
                        contador++;
                    }
                }
                System.out.println("contador:"+contador);
                String[]parts=nuevo.split("/");
                System.out.println("imprimir:"+parts[contador]);
                //Fin de cambios

                if(urlimg.contains(".com") || urlimg.contains(".net") || urlimg.contains(".mx") || urlimg.contains(".edu"))
                {
                    wget2.downloadPage(urlimg,parts[contador]);

                }
                else
                {
                    wget2.downloadPage(urlprincipal+urlimg,parts[contador]);
                    System.out.println("Ruta relativa completa: "+urlprincipal+urlimg);

                }
                contador=0;
            }
            else if(urlimg.contains(".gif"))
            {
                System.out.println("Imagen gif encontrada: "+urlimg);
                //Inicio de cambios
                String[]urlimgchida=urlimg.split(".gif");
                System.out.println("urlimgchida:"+urlimgchida[0]+".gif");
                URL urlxas=new URL(urlprincipal+urlimgchida[0]+".gif");
                String nuevo=urlxas.toString();
                int contador=0;
                for(int i=0;i<nuevo.length();i++)
                {
                    if(nuevo.charAt(i)=='/')
                    {
                        contador++;
                    }
                }
                System.out.println("contador:"+contador);
                String[]parts=nuevo.split("/");
                System.out.println("imprimir:"+parts[contador]);
                //Fin de cambios

                if(urlimg.contains(".com") || urlimg.contains(".net") || urlimg.contains(".mx") || urlimg.contains(".edu"))
                {
                    wget2.downloadPage(urlimg,parts[contador]);

                }
                else
                {
                    wget2.downloadPage(urlprincipal+urlimg,parts[contador]);
                    System.out.println("Ruta relativa completa: "+urlprincipal+urlimg);

                }
                contador=0;

            }
            else if(urlimg.contains(".ico"))
            {
                System.out.println("Imagen ico encontrada: "+urlimg);
                //Inicio de cambios
                String[]urlimgchida=urlimg.split(".ico");
                System.out.println("urlimgchida:"+urlimgchida[0]+".ico");
                URL urlxas=new URL(urlprincipal+urlimgchida[0]+".ico");
                String nuevo=urlxas.toString();
                int contador=0;
                for(int i=0;i<nuevo.length();i++)
                {
                    if(nuevo.charAt(i)=='/')
                    {
                        contador++;
                    }
                }
                System.out.println("contador:"+contador);
                String[]parts=nuevo.split("/");
                System.out.println("imprimir:"+parts[contador]);
                //Fin de cambios

                if(urlimg.contains(".com") || urlimg.contains(".net") || urlimg.contains(".mx") || urlimg.contains(".edu"))
                {
                    wget2.downloadPage(urlimg,parts[contador]);

                }
                else
                {
                    wget2.downloadPage(urlprincipal+urlimg,parts[contador]);
                    System.out.println("Ruta relativa completa: "+urlprincipal+urlimg);

                }
                contador=0;
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