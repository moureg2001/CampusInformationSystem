import java.util.ArrayList;
import java.util.List;

public class Playlist {

	private String id;
	private String name;
	private char bereich;
	private List<Medium> medien=new ArrayList<Medium>();
	private Zeit zeit;
	
	
	
	public Playlist(String id, String name, char bereich, List<Medium> medien,
			Zeit zeit) {
		this.id = id;
		this.name = name;
		this.bereich = bereich;
		this.medien = medien;
		this.zeit = zeit;
	}
	
	public boolean addMedium(String id, String name, String format,long abspielzeit, String pfad){
		return medien.add(new Medium(id, name, format, abspielzeit, pfad));
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public char getBereich() {
		return bereich;
	}
	public void setBereich(char bereich) {
		this.bereich = bereich;
	}
	public List<Medium> getMedien() {
		return medien;
	}
	public void setMedien(List<Medium> medien) {
		this.medien = medien;
	}
	public Zeit getZeit() {
		return zeit;
	}
	public void setZeit(Zeit zeit) {
		this.zeit = zeit;
	}
}
