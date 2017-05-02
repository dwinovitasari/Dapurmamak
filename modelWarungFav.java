package innovable.dev.warung.models;

/**
 * Created by yoktavian on 4/12/17.
 */

public class modelWarungFav {
    private String id, id_warung ,warung;

    public modelWarungFav(String id, String id_warung,String warung){
        this.id=id;
        this.id_warung=id_warung;
        this.warung=warung;
    }

    public String getId(){
        return id;
    }
    public String getId_warung(){
        return id_warung;
    }
    public String getWarung(){
        return warung;
    }
}
