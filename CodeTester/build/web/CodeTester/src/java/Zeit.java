import java.io.Serializable;
import java.util.Date;
import java.util.Timer;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class Zeit implements Serializable{

	private String startDatum;
	private String startUhr;
	private String endDatum;
	private String endUhrzeit;
	

	public Zeit(String startDatum, String startUhr, String endDatum, String endUhrzeit) {
		this.startDatum = startDatum;
		this.startUhr = startUhr;
		this.endDatum = endDatum;
		this.endUhrzeit = endUhrzeit;
	}
	
	public String getStartDatum() {
		return startDatum;
	}

	public void setStartDatum(String startDatum) {
		this.startDatum = startDatum;
	}

	public String getStartUhr() {
		return startUhr;
	}

	public void setStartUhr(String startUhr) {
		this.startUhr = startUhr;
	}

	public String getEndDatum() {
		return endDatum;
	}

	public void setEndDatum(String endDatum) {
		this.endDatum = endDatum;
	}

	public String getEndUhrzeit() {
		return endUhrzeit;
	}

	public void setEndUhrzeit(String endUhrzeit) {
		this.endUhrzeit = endUhrzeit;
	}


	
}
