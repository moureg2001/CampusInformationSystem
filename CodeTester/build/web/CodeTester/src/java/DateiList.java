
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author anonymous
 */
@Named
@ApplicationScoped
public class DateiList implements Serializable{


    File file;

    File[] fileArray;
    
    private final static String dir = "C:\\MedienOrdner";
    private List<Datei> ordnerDateiList;

    @Inject
    public void init() {
        ordnerDateiList = new ArrayList<Datei>();
        file = new File(dir);
        fileArray = file.listFiles();
        addAllDateien();
  
    }

    public List<Datei> getOrdnerDateilist() {
        return ordnerDateiList;
    }

    public void setOrdnerDateilist(List<Datei> ordnerDateilist) {
        this.ordnerDateiList = ordnerDateilist;
    }

    public String getFileExtension(File file) {
        String fileName = file.getName();
        if (fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0) {
            return fileName.substring(fileName.lastIndexOf(".") + 1);
        } else {
            return "";
        }
    }

    public void addAllDateien() {
        if (fileArray != null) {
            for (int i = 0; i < fileArray.length; i++) {
                ordnerDateiList.add(new Datei(fileArray[i].getName(), this.getFileExtension(fileArray[i]), fileArray[i].length(), fileArray[i].getPath()));
            }
        }
    }

    public List<File> searchFile(File dir, String find) {
        boolean isfounded = false;
        File[] files = fileArray;
        List<File> matches = new ArrayList<File>();
        if (files != null) {
            for (int i = 0; i < files.length; i++) {
                /*
       * Überprüft, ob der Dateiname mit dem Suchstring übereinstimmt.
       * Groß- und Kleinschreibung wird ignoriert.
                 */
                if (files[i].getName().equalsIgnoreCase(find)) {
                    matches.add(files[i]);
                    isfounded = true;
                }
                if (files[i].isDirectory()) {
                    // Fügt der List die List mit den Treffern aus dem Unterordner zu
                    matches.addAll(searchFile(files[i], find));
                }
            }
        }
        return matches;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public File[] getFileArray() {
        return fileArray;
    }

    public void setFileArray(File[] fileArray) {
        this.fileArray = fileArray;
    }

    public String getDir() {
        return dir;
    }


    public List<Datei> getOrdnerDateiList() {
        return ordnerDateiList;
    }

    public void setOrdnerDateiList(List<Datei> ordnerDateiList) {
        this.ordnerDateiList = ordnerDateiList;
    }
        
}
