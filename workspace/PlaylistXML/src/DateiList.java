
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;


/**
 *
 * @author anonymous
 */

public class DateiList{

    private File file;
    private File[] fileArray;
    private final static String dir="C:\\MedienOrdner";

    private List<Datei> ordnerDateiList=new ArrayList<Datei>();
    

    public DateiList(){
        file=new File(dir);   
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
        if(fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0)
        return fileName.substring(fileName.lastIndexOf(".")+1);
        else return "";
    }
    
    public void addAllDateien(){
    if(fileArray!=null){
        for(int i=0;i<fileArray.length;i++){
        ordnerDateiList.add(new Datei(fileArray[i].getName(), this.getFileExtension(fileArray[i]), fileArray[i].length(), fileArray[i].getPath()));
        }
    }
    }
public List<File> searchFile(File dir, String find) {
	boolean isfounded=false;
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
        isfounded=true;
      }
      if (files[i].isDirectory()) {
        // Fügt der List die List mit den Treffern aus dem Unterordner zu
        matches.addAll(searchFile(files[i], find));
      }
    }
  }
  return matches;
}



/*public static void main(String[] args) {
	DateiList dl=new DateiList();
	File f=null;
	List<File> founded=dl.searchFile(f, "willkommen.txt" );
	System.out.println(founded.get(0).getName());
	System.out.println(founded.get(0).getAbsolutePath());
	for(int i=0;i<dl.getOrdnerDateilist().size();i++){
		System.out.println(dl.getOrdnerDateilist().get(i).getName());
	}
}*/
}