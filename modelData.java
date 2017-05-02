package innovable.dev.warung.models;

/**
 * Created by yoktavian on 4/12/17.
 */

public class modelData {
    private String id, warung;

    public modelData(String id, String warung){
        this.id=id;
        this.warung=warung;
    }

    public String getId(){
        return id;
    }
    public String getWarung(){
        return warung;
    }
}
