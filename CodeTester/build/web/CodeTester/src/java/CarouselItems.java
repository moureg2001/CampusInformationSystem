
import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
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
@SessionScoped
public class CarouselItems implements Serializable{
 
   MedienVerwaltung medienManager;

   private List<Contents> medienBereichA;
 
   private  List<Contents> medienBereichB;
  
   private  List<Contents> medienBereichC;

   private  List<Contents> medienBereichD;

   private  List<Contents> medienBereichE;

  
    public CarouselItems() {
      medienManager= new MedienVerwaltung();
      medienBereichA= new ArrayList<Contents>();
      medienBereichB= new ArrayList<Contents>();
      medienBereichC= new ArrayList<Contents>();
      medienBereichD= new ArrayList<Contents>();
      medienBereichE= new ArrayList<Contents>();
      addElmentToCarouselAccordingArea();
    }
    
   
    public  void addElmentToCarouselAccordingArea(){
       medienManager.fillAllPlaylistFromXML();
       medienManager.findFileMedium();
    for(int i=0;i<medienManager.getPlayList().size();i++)
    switch(medienManager.getPlayList().get(i).getBereich()){
        case 'A': addMedienToCarouselA(medienManager.getPlayList().get(i));
            break;
        case 'B': addMedienToCarouselB(medienManager.getPlayList().get(i));
            break;
        case 'C': addMedienToCarouselC(medienManager.getPlayList().get(i));
            break;
        case 'D': addMedienToCarouselD(medienManager.getPlayList().get(i));
            break;
        case 'E': addMedienToCarouselE(medienManager.getPlayList().get(i));
            break;
    }
    } 
   public void addMedienToCarouselA(Playlist pList){
   String name, format, abspielZeit,  pfad;
   for(int i=0;i<pList.getMedien().size();i++){
       name=pList.getMedien().get(i).getName();
       format=pList.getMedien().get(i).getFormat();
       abspielZeit=String.valueOf(pList.getMedien().get(i).getAbspielzeit());
       pfad=pList.getMedien().get(i).getPfad();
   medienBereichA.add(new Contents(name, format, abspielZeit, pfad, true, true, true, true, true));
   }
   } 
   public void addMedienToCarouselB(Playlist pList){
   String name, format, abspielZeit,  pfad;
   for(int i=0;i<pList.getMedien().size();i++){
       name=pList.getMedien().get(i).getName();
       format=pList.getMedien().get(i).getFormat();
       abspielZeit=String.valueOf(pList.getMedien().get(i).getAbspielzeit());
       pfad=pList.getMedien().get(i).getPfad();
   medienBereichB.add(new Contents(name, format, abspielZeit, pfad, true, true, true, true, true));
   }
   }     
   public void addMedienToCarouselC(Playlist pList){
   String name, format, abspielZeit,  pfad;
   for(int i=0;i<pList.getMedien().size();i++){
       name=pList.getMedien().get(i).getName();
       format=pList.getMedien().get(i).getFormat();
       abspielZeit=String.valueOf(pList.getMedien().get(i).getAbspielzeit());
       pfad=pList.getMedien().get(i).getPfad();
   medienBereichC.add(new Contents(name, format, abspielZeit, pfad, true, true, true, true, true));
   }
   }     
   public void addMedienToCarouselD(Playlist pList){
   String name, format, abspielZeit,  pfad;
   for(int i=0;i<pList.getMedien().size();i++){
       name=pList.getMedien().get(i).getName();
       format=pList.getMedien().get(i).getFormat();
       abspielZeit=String.valueOf(pList.getMedien().get(i).getAbspielzeit());
       pfad=pList.getMedien().get(i).getPfad();
   medienBereichD.add(new Contents(name, format, abspielZeit, pfad, true, true, true, true, true));
   }
   }     
   public void addMedienToCarouselE(Playlist pList){
   String name, format, abspielZeit,  pfad;
   for(int i=0;i<pList.getMedien().size();i++){
       name=pList.getMedien().get(i).getName();
       format=pList.getMedien().get(i).getFormat();
       abspielZeit=String.valueOf(pList.getMedien().get(i).getAbspielzeit());
       pfad=pList.getMedien().get(i).getPfad();
   medienBereichE.add(new Contents(name, format, abspielZeit, pfad, true, true, true, true, true));
   }
   }     
    
    
    
    	public Date convertStringToDate(String datum) {
		DateFormat formatter;
		Date date = null;
		formatter = new SimpleDateFormat("dd-MMM-yy");
		try {
			date = formatter.parse(datum);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date;
	}

	public Date convertStringToTime(String time) {
		DateFormat formatter;
		Date date = null;
		formatter = new SimpleDateFormat("hh:mm:ss");
		try {
			date = formatter.parse(time);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date;
	}

    public MedienVerwaltung getMedienManager() {
        return medienManager;
    }

    public void setMedienManager(MedienVerwaltung medienManager) {
        this.medienManager = medienManager;
    }

    public List<Contents> getMedienBereichA() {
        return medienBereichA;
    }

    public void setMedienBereichA(List<Contents> medienBereichA) {
        this.medienBereichA = medienBereichA;
    }

    public List<Contents> getMedienBereichB() {
        return medienBereichB;
    }

    public void setMedienBereichB(List<Contents> medienBereichB) {
        this.medienBereichB = medienBereichB;
    }

    public List<Contents> getMedienBereichC() {
        return medienBereichC;
    }

    public void setMedienBereichC(List<Contents> medienBereichC) {
        this.medienBereichC = medienBereichC;
    }

    public List<Contents> getMedienBereichD() {
        return medienBereichD;
    }

    public void setMedienBereichD(List<Contents> medienBereichD) {
        this.medienBereichD = medienBereichD;
    }

    public List<Contents> getMedienBereichE() {
        return medienBereichE;
    }

    public void setMedienBereichE(List<Contents> medienBereichE) {
        this.medienBereichE = medienBereichE;
    }
        
        
    
}
