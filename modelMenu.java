package innovable.dev.warung.models;

/**
 * Created by yoktavian on 4/12/17.
 */

public class modelMenu {
    private String id_warung, id, item, harga, kategori;
    public modelMenu(String id_warung, String id, String item, String harga, String kategori){
        this.id_warung = id_warung;
        this.id = id;
        this.item = item;
        this.harga = harga;
        this.kategori = kategori;
    }

    public String getId_warung(){
        return id_warung;
    }
    public String getId(){
        return id;
    }
    public String getItem(){
        return item;
    }
    public String getHarga(){
        return harga;
    }
    public String getKategori(){
        return kategori;
    }
}
