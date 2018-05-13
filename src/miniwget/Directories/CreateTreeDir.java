package miniwget.Directories;

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
        while(matcher.find()){

        }
    }

    public void searchImages(String str) throws Exception{
        System.out.println("CreateTreeDir.searchImages");
        Pattern pattern = Pattern.compile("(?i)src\\s*=\\s*\"(.*?)");
        Matcher matcher = pattern.matcher(str);
        while(matcher.find()){

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