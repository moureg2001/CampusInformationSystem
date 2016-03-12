
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class Contents implements Serializable{
    private String name;
    private String format;
    private String abspielZeit;
    private String pfad;
    private boolean isText;
    private boolean isPicture;
    private boolean isVideo;
    private boolean isYoutube;
    private boolean isRss;

    public Contents(String name, String format, String abspielZeit, String pfad, boolean isText, boolean isPicture, boolean isVideo, boolean isYoutube, boolean isRss) {
        this.name = name;
        this.format = format;
        this.abspielZeit = abspielZeit;
        this.pfad = pfad;
        this.isText = isText;
        this.isPicture = isPicture;
        this.isVideo = isVideo;
        this.isYoutube = isYoutube;
        this.isRss = isRss;
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

    public String getAbspielZeit() {
        return abspielZeit;
    }

    public void setAbspielZeit(String abspielZeit) {
        this.abspielZeit = abspielZeit;
    }

    public String getPfad() {
        return pfad;
    }

    public void setPfad(String pfad) {
        this.pfad = pfad;
    }

    public boolean isIsText() {
        return isText;
    }

    public void setIsText(boolean isText) {
        this.isText = isText;
    }

    public boolean isIsPicture() {
        return isPicture;
    }

    public void setIsPicture(boolean isPicture) {
        this.isPicture = isPicture;
    }

    public boolean isIsVideo() {
        return isVideo;
    }

    public void setIsVideo(boolean isVideo) {
        this.isVideo = isVideo;
    }

    public boolean isIsYoutube() {
        return isYoutube;
    }

    public void setIsYoutube(boolean isYoutube) {
        this.isYoutube = isYoutube;
    }

    public boolean isIsRss() {
        return isRss;
    }

    public void setIsRss(boolean isRss) {
        this.isRss = isRss;
    }
    
}
