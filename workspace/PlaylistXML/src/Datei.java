import java.io.Serializable;
/**
 *
 * @author anonymous
 */

public class Datei implements Serializable{

    private static final long serialVersionUID = 1L;

    private String id;
    private String name;
    private String type;
    private double groesse;
    private String pfad;
    
    public Datei(String name,  String type, double groesse, String pfad){
        this.name=name;
        this.type=type;
        this.pfad=pfad;
        this.groesse=groesse;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPfad() {
        return pfad;
    }

    public void setPfad(String pfad) {
        this.pfad = pfad;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getGroesse() {
        return groesse;
    }

    public void setGroesse(double groesse) {
        this.groesse = groesse;
    }

}
