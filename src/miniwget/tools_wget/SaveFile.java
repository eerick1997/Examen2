package miniwget.tools_wget;


import java.io.*;

public class SaveFile {

    private FileWriter fw;

    public SaveFile(String path) {
        try {
            File file = new File(path);
            fw = new FileWriter(file);
        } catch (IOException e) {
            System.err.println("Error to create file: " + e.getMessage());
        }
    }

    public void isFile(File file) {
        if (file.exists()) {
            if (file.isFile()) {
                System.out.println("The file exists.");
                file.delete();
            }
        } else {
            file.delete();
            System.out.println("File've been created. ");
        }
    }

    public void write_sth(String data) {
        try {
            /*Write data*/
            fw.write(data);
            fw.write("\r\n");
        } catch (IOException e) {
            System.err.println("Error to create file: " + e.getMessage());
        }
    }

    public void closeFile() {
        try {
            fw.close();
        } catch (IOException e) {
            System.err.println("Error to create file: " + e.getMessage());
        }
    }

    public StringBuffer read_Content(String archivo)
            throws FileNotFoundException, IOException {
        String cadena;
        StringBuffer labels = new StringBuffer();
        FileReader f = new FileReader(archivo);
        BufferedReader b = new BufferedReader(f);
        while((cadena = b.readLine())!=null)
            labels.append(cadena);

        b.close();
        return labels;
    }
}


