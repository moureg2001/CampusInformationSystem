package de.hsbochum;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@ApplicationScoped
public class Playlist implements Serializable {
	
	private String id;
	private String name;
	private char bereich; 
	@Inject
	private List<Medium> medien;
	@Inject
	private Zeit zeit;

	
	public Playlist(String id, String name, char bereich, List<Medium> medien , Zeit zeit) {
	
		this.id = id;
		this.name = name;
		this.medien = medien;
		this.zeit = zeit;
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
