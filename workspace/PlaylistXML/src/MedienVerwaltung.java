import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Timer;

public class MedienVerwaltung {

    private DateiList dataList;

    private List<Playlist> playList;

    private PlaylistXML playXML;


  
    public MedienVerwaltung() {
        playList = new ArrayList<Playlist>();
        playXML = new PlaylistXML();
        dataList = new DateiList();
        dataList.addAllDateien();
    }

   
    public boolean fillAllPlaylistFromXML() {
        boolean isAdded = true;
        String id, mediumId;
        String name, mediumName;
        char bereich;
        String mediumFormat;
        long mediumAbspielZeit;
        String mediumPfad;
        List<Medium> medien = new ArrayList<Medium>();
        String startDatum, endDatum;
        String startUhrzeit, endUhrzeit;
        for (int i = 0; i < playXML.getAllPlaylist().size(); i++) {
            medien = new ArrayList<Medium>();
            id = playXML.getAllePlaylistID(i);
            name = playXML.getAllePlaylistName(i);
           
            bereich = (playXML.getAllePlaylistBereich(i)).toCharArray()[0];
            for (int j = 0; j < playXML.getAllePlaylistMedien(i).size(); j++) {
                mediumId = playXML.getAllePlaylistMedienID(i, j);
                mediumName = playXML.getAllePlaylistMedienName(i, j);
                mediumFormat = playXML.getAllePlaylistMedienFormat(i, j);
                mediumAbspielZeit = Long.parseLong(playXML.getAllePlaylistMedienAbspielzeit(i, j));
                mediumPfad = playXML.getAllePlaylistMedienPfad(i, j);
                isAdded = medien.add(new Medium(mediumId, mediumName, mediumFormat, mediumAbspielZeit, mediumPfad));
            }
            startDatum = playXML.getAllePlaylistStartzeitDatum(i);
            startUhrzeit = playXML.getAllePlaylistStartzeitUhrzeit(i);
            endDatum = playXML.getAllePlaylistEndzeitDatum(i);
            endUhrzeit = playXML.getAllePlaylistEndzeitUhrzeit(i);
            isAdded = playList.add(
                    new Playlist(id, name, bereich, medien, new Zeit(startDatum, startUhrzeit, endDatum, endUhrzeit)));
        }

        return isAdded;
    }

   
    public void findFileMedium() {
        File dir = null;
        String mediumName, mediumFormat, pfad=null;
        for (int i = 0; i < playXML.getAllPlaylist().size(); i++) {
            for (int j = 0; j < playXML.getAllePlaylistMedien(i).size(); j++) {
                mediumName = playXML.getAllePlaylistMedienName(i, j);
                mediumFormat = playXML.getAllePlaylistMedienFormat(i, j);
                switch (dateiArt(mediumFormat)) {
                    case "text":pfad = dataList.searchFile(dir, mediumName).get(0).getPath();
                                playList.get(i).getMedien().get(j).setPfad(readTxtContent(pfad));
                                break;
                    case "bild":pfad = dataList.searchFile(dir, mediumName).get(0).getPath();
                                playList.get(i).getMedien().get(j).setPfad(pfad);
                                break;
                    case "video":pfad = dataList.searchFile(dir, mediumName).get(0).getPath();
                                 playList.get(i).getMedien().get(j).setPfad(pfad);
                                 break;                    
                }
                /*if ((dateiArt(mediumFormat).equalsIgnoreCase("text") || dateiArt(mediumFormat).equalsIgnoreCase("bild") || dateiArt(mediumFormat).equalsIgnoreCase("video"))
                        && dataList.searchFile(dir, mediumName).size() == 1) {
                    playList.get(i).getMedien().get(j).setPfad(dataList.searchFile(dir, mediumName).get(0).getPath());
                }*/
            }
        }
    }

    public String dateiArt(String ext) {
        String result;
        switch (ext) {
            case "bmp":
                result = "bild";
                break;
            case "png":
                result = "bild";
                break;
            case "jpeg":
                result = "bild";
                break;
            case "jpg":
                result = "bild";
                break;
            case "gif":
                result = "bild";
                break;
            case "tiff":
                result = "bild";
                break;
            case "mp4":
                result = "video";
                break;
            case "avi":
                result = "video";
                break;
            case "flv":
                result = "youtube";
                break;
            case "webm":
                result = "video";
                break;
            case "txt":
                result = "text";
                break;
            case "lnk":
                result = "rss";
                break;
            default:
                result = "undefined format";
                break;
        }
        return result;
    }

    public DateiList getDataList() {
        return dataList;
    }

    public void setDataList(DateiList dataList) {
        this.dataList = dataList;
    }

    public List<Playlist> getPlayList() {
        return playList;
    }

    public void setPlayList(List<Playlist> playList) {
        this.playList = playList;
    }

    public PlaylistXML getPlayXML() {
        return playXML;
    }

    public void setPlayXML(PlaylistXML playXML) {
        this.playXML = playXML;
    }

    public String readTxtContent(String path) {
		String content = null;

		try {
			content = new String(Files.readAllBytes(Paths.get(path)));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return content;	
    }

	/*public static void main(String[] args) {
		MedienVerwaltung mv = new MedienVerwaltung();
		File f=null;
		//String data=mv.dataList.searchFile(f, "willkommen.txt").get(0).getPath();
		//System.out.println(data);
		//System.out.println(mv.readTxtContent(data));
		boolean isOK = mv.fillAllPlaylistFromXML();
		//System.out.println("Ist hinzugefügt? " + isOK);

		mv.findFileMedium();

		for (int i = 0; i < mv.playList.size(); i++) {
			System.out.println("id: " + mv.playList.get(i).getId());
			System.out.println("name: " + mv.playList.get(i).getName());
			System.out.println("bereich: " + mv.playList.get(i).getBereich());
			for (int j = 0; j < mv.playXML.getAllePlaylistMedien(i).size(); j++) {
				System.out.println("--medien id: " + mv.playList.get(i).getMedien().get(j).getId());
				System.out.println("--medien name: " + mv.playList.get(i).getMedien().get(j).getName());
				System.out.println("--medien format: " + mv.playList.get(i).getMedien().get(j).getFormat());
				System.out.println("--medien abspielzeit: " + mv.playList.get(i).getMedien().get(j).getAbspielzeit());
				System.out.println("--medien pfad: " + mv.playList.get(i).getMedien().get(j).getPfad());
				// System.out.print(j+" Datei Name:
				// "+mv.playList.get(i).getMedien().get(j).getName()+"\t");
				// System.out.println("Pfad:
				// "+mv.playList.get(i).getMedien().get(j).getPfad());

			}
		}
	}*/

}
