
public class Medium {
	
	private String id;
	private String name;
	private String format;
	private long abspielzeit;
	private String pfad;
	private long abspielZeit;
	
	public Medium(String id, String name, String format, long abspielzeit, String pfad) {
		this.id = id;
		this.name = name;
		this.format = format;
		this.abspielzeit = abspielzeit;
		this.pfad = pfad;
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
	public String getFormat() {
		return format;
	}
	public void setFormat(String format) {
		this.format = format;
	}
	public long getAbspielzeit() {
		return abspielzeit;
	}
	public void setAbspielzeit(long abspielzeit) {
		this.abspielzeit = abspielzeit;
	}
	public String getPfad() {
		return pfad;
	}
	public void setPfad(String pfad) {
		this.pfad = pfad;
	}
	
	

}
