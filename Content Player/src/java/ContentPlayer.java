
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
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
@SessionScoped
public class ContentPlayer implements Serializable {

    private List<Contents> selectedContent;

    public ContentPlayer() {
  selectedContent = new ArrayList<Contents>();
  selectedContent.add(new Contents("Obst(Granatapfel eng: pomegranate)", "png", 10000, "C:\\MedienOrdner\\b01.png", false, true, false, false, false));
  selectedContent.add(new Contents("Die schönheit der Nature (Strand)", "jpg", 5000, "C:\\MedienOrdner\\beauty_of_nature.jpg", false, true, false, false, false));
  selectedContent.add(new Contents("Big Buck Bunny Kurzfilm", "avi", 50000, "C:\\MedienOrdner\\big_buck_bunny.avi", false, false,true, false, false));
  selectedContent.add(new Contents("Die schönheit der Nature (Strand)", "txt", 7000, "Der Test ist Erfolgreich alhamdou lilah", true, false, false, false, false));
  selectedContent.add(new Contents("Die Erde erstaunliche Natur(Planet Earth Amazing Nature)", "mp4", 100000, "C:\\MedienOrdner\\Planet_Earth_ Amazing_nature.mp4", false, false, true, false, false));
  selectedContent.add(new Contents("Types of Operating Systems as Fast As Possible", "flv", 500000, "https://www.youtube.com/watch?v=MR2ntdZW__A&spfreload=10", false, false, false, true, false));
 selectedContent.add(new Contents("Tagesschau", "rss", 100000, "http://www.tagesschau.de/xml/rss2", false, false, false, false, true));

    }

    public List<Contents> getContentList() {
        return selectedContent;
    }

    public boolean HasItems() {
        return !selectedContent.isEmpty();
    }

}
