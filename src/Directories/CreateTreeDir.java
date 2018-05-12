package Directories;

import java.io.File;

/**This class create a tree directories if we
 * give it a path. Directories are make them in
 * the root of our project                      **/
public class CreateTreeDir {

    public CreateTreeDir(){

    }

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
}
