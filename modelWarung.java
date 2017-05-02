package innovable.dev.warung.models;

/**
 * Created by yoktavian on 4/12/17.
 */

public class modelWarung {
    private String id, nama, hp, status;

    public modelWarung(String id, String nama, String hp, String status){
        this.id=id;
        this.hp=hp;
        this.nama=nama;
        this.status=status;
    }

    public String getId(){
        return id;
    }
    public String getNama(){
        return nama;
    }
    public String getStatus(){
        return status;
    }
    public String getHp(){
        return hp;
    }
}
