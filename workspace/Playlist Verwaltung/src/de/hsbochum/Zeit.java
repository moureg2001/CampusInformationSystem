package de.hsbochum;

import java.io.Serializable;
import java.util.Date;

public class Zeit implements Serializable {
	private String startDatum;
	private String startZeit;
	private String endDatum;
	private String endZeit;

	public Zeit(String startDatum, String startZeit, String endDatum, String endZeit) {
		super();
		this.startDatum = startDatum;
		this.startZeit = startZeit;
		this.endDatum = endDatum;
		this.endZeit = endZeit;
	}

	public String getStartDatum() {
		return startDatum;
	}

	public void setStartDatum(String startDatum) {
		this.startDatum = startDatum;
	}

	public String getStartZeit() {
		return startZeit;
	}

	public void setStartZeit(String startZeit) {
		this.startZeit = startZeit;
	}

	public String getEndDatum() {
		return endDatum;
	}

	public void setEndDatum(String endDatum) {
		this.endDatum = endDatum;
	}

	public String getEndZeit() {
		return endZeit;
	}

	public void setEndZeit(String endZeit) {
		this.endZeit = endZeit;
	}

}
