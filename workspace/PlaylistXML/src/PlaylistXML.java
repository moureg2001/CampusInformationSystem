import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.XMLOutputter;

import org.apache.xerces.parsers.DOMParser;

public class PlaylistXML  {
	Document docXML = null;
	File dateiXML;
	SAXBuilder builder;
	XMLOutputter fmt;

	public PlaylistXML() {
		try {
			dateiXML = new File("C:\\MedienOrdner\\playlist.xml");
			builder = new SAXBuilder();
			docXML = builder.build(dateiXML);
			fmt = new XMLOutputter();
		} catch (JDOMException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	// Dadurch greif man auf Playlist Element in XML Datei
	public List<Element> getAllPlaylist() {
		return docXML.getRootElement().getChildren("playlist");
	}
	//Zeigt welches {Layout} hat der Player(Abspielgerät)
	public String playerLayout(){
		return docXML.getRootElement().getChild("layout").getValue();
	}
	//Zeigt welche {ID} hat ein Playlist
	public String getAllePlaylistID(int playListNr) {
		return docXML.getRootElement().getChildren("playlist").get(playListNr).getAttributeValue("id");
	
	}

	// Zeigt welche {Name} hat ein Playlist
	public String getAllePlaylistName(int playListNr) {
		return docXML.getRootElement().getChildren("playlist").get(playListNr).getChildren("name").get(0).getValue();
	}

	// Zeigt welche {Bereich} hat ein Playlist
	public String getAllePlaylistBereich(int playListNr) {
		return docXML.getRootElement().getChildren("playlist").get(playListNr).getChildren("bereich").get(0).getValue();
	}

	//{Medien List} einer Playlist
	public List<Element> getAllePlaylistMedien(int playListNr) {
		return docXML.getRootElement().getChildren("playlist").get(playListNr).getChildren("medien").get(0).getChildren();
	}

	// Playlist {Medien ID}
	public String getAllePlaylistMedienID(int playIndex, int index) {
		return docXML.getRootElement().getChildren("playlist").get(playIndex).getChildren("medien").get(0).getChildren("medium")
				.get(index).getAttributeValue("id");
	}

	// Playlist {Medien Name}
	public String getAllePlaylistMedienName(int playIndex, int index) {
		return docXML.getRootElement().getChildren("playlist").get(playIndex).getChildren("medien").get(0).getChildren("medium")
				.get(index).getChildren("name").get(0).getValue();
	}

	// Playlist {Medien Format}
	public String getAllePlaylistMedienFormat(int playIndex, int index) {
		return docXML.getRootElement().getChildren("playlist").get(playIndex).getChildren("medien").get(0).getChildren("medium")
				.get(index).getChildren("format").get(0).getValue();
	}
	// Playlist {Medien Abspielzeit}
	public String getAllePlaylistMedienAbspielzeit(int playIndex, int index) {
		return docXML.getRootElement().getChildren("playlist").get(playIndex).getChildren("medien").get(0).getChildren("medium")
				.get(index).getChildren("abspielzeit").get(0).getValue();
	}
	
	// Playlist {Medien Pfad}
	public String getAllePlaylistMedienPfad(int playIndex, int index) {
		return docXML.getRootElement().getChildren("playlist").get(playIndex).getChildren("medien").get(0).getChildren("medium")
				.get(index).getChildren("pfad").get(0).getValue();
	}
	// Playlist Zeit {Starzeit-Datum-}
	public String getAllePlaylistStartzeitDatum(int playlist) {
		return docXML.getRootElement().getChildren("playlist").get(playlist).getChildren("zeit").get(0).getChildren("startzeit").get(0).getChildren("datum").get(0).getValue();
	}
	// Playlist Zeit {Starzeit-Uhrzeit-}
	public String getAllePlaylistStartzeitUhrzeit(int playlist) {
		return docXML.getRootElement().getChildren("playlist").get(playlist).getChildren("zeit").get(0).getChildren("startzeit").get(0).getChildren("uhrzeit").get(0).getValue();
	}

	// Playlist Zeit {Endzeit-Datum-}
	public String getAllePlaylistEndzeitDatum(int playlist) {
		return docXML.getRootElement().getChildren("playlist").get(playlist).getChildren("zeit").get(0).getChildren("endzeit").get(0).getChildren("datum").get(0).getValue();
	}
	// Playlist Zeit {Endzeit-Uhrzeit-}
	public String getAllePlaylistEndzeitUhrzeit(int playlist) {
		return docXML.getRootElement().getChildren("playlist").get(playlist).getChildren("zeit").get(0).getChildren("endzeit").get(0).getChildren("uhrzeit").get(0).getValue();
	}	


}
