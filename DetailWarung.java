package innovable.dev.warung.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import innovable.dev.warung.R;
import innovable.dev.warung.adapter.AdapterListMenu;
import innovable.dev.warung.helper.SqliteHelper;
import innovable.dev.warung.models.modelData;
import innovable.dev.warung.models.modelMenu;

public class DetailWarung extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<modelMenu> models = new ArrayList<>();
    private ArrayList<modelData> database = new ArrayList<>();
    private AdapterListMenu adapter;
    private ImageView btn_save;
    private SqliteHelper sqliteHelper;
    private boolean favorite = false;
    private String kat = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_warung);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Intent i = getIntent();
        final String warung = i.getStringExtra("warung");
        final String id = i.getStringExtra("id");
        String hp = i.getStringExtra("hp");
        if (i.getStringExtra("kategori")!=null){
            kat = i.getStringExtra("kategori");
        }
        getSupportActionBar().setTitle(warung);
        sqliteHelper = new SqliteHelper(DetailWarung.this);
        btn_save = (ImageView)findViewById(R.id.btn_fav);
        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                database = sqliteHelper.getAllData();
                for (int i = 0; i<database.size(); i++){
                    if (database.get(i).getWarung().equals(warung)){
                        favorite = true;
                    }
                }
                if (favorite) {
                    Toast.makeText(DetailWarung.this, warung + " sudah menjadi warung favorite!", Toast.LENGTH_SHORT).show();
                } else {
                    addToFavorite(id, warung);
                }
            }
        });
        TextView txt_hp = (TextView)findViewById(R.id.txt_hp);
        txt_hp.setText("Nomor hp : "+hp);
        recyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        setDataMenu(id);
    }

    private void addToFavorite(String id, String warung){
        sqliteHelper.getReadableDatabase();
        sqliteHelper.masukanData(id, warung);
    }

    private void setDataMenu(String id){
        if (!kat.equals("")){
            if (kat.equals("ayam")){
                if (id.equals("1")) {
                    Log.d("result ", id);
                    models.add(new modelMenu(id, "1", "Ayam bumbu bali", "Rp. 15.000, 00", "ayam"));
                    models.add(new modelMenu(id, "2", "Ayam suir", "Rp. 14.000, 00", "ayam"));
                    models.add(new modelMenu(id, "3", "Nasi goreng ayam", "Rp. 13.000, 00", "ayam"));
                } else if (id.equals("2")){
                    models.add(new modelMenu(id, "1", "Ayam kremes", "Rp. 15.000, 00", "ayam"));
                } else if (id.equals("3")){
                    models.add(new modelMenu(id, "2", "Ayam penyet", "Rp. 14.000, 00", "ayam"));
                }
            } else if (kat.equals("bakso")){
                models.add(new modelMenu(id, "1", "Bakso", "Rp. 13.000, 00", "bakso"));
            } else if (kat.equals("bubur")){
                models.add(new modelMenu(id, "3", "Bubur ayam", "Rp. 13.000, 00", "bubur"));
            } else if (kat.equals("ikan")){
                if (id.equals("2")){
                    models.add(new modelMenu(id, "2", "Pecel lele", "Rp. 14.000, 00", "ikan"));
                } else if (id.equals("3")){
                    models.add(new modelMenu(id, "1", "Lele penyet 1", "Rp. 15.000, 00", "ikan"));
                }
            } else if (kat.equals("mie")){
                if (id.equals("1")){
                    models.add(new modelMenu(id, "4", "Mie tek-tek", "Rp. 12.000, 00", "mie"));
                } else if (id.equals("4")){
                    models.add(new modelMenu(id, "1", "Mie rebus", "Rp. 6.000, 00", "mie"));
                    models.add(new modelMenu(id, "2", "Mie goreng", "Rp. 5.000, 00", "mie"));
                }
            }
        } else {
            if (id.equals("1")) {
                Log.d("result ", id);
                models.add(new modelMenu(id, "1", "Ayam bumbu bali", "Rp. 15.000, 00", "ayam"));
                models.add(new modelMenu(id, "2", "Ayam suir", "Rp. 14.000, 00", "ayam"));
                models.add(new modelMenu(id, "3", "Nasi goreng ayam", "Rp. 13.000, 00", "ayam"));
                models.add(new modelMenu(id, "4", "Mie tek-tek", "Rp. 12.000, 00", "ayam"));
            } else if (id.equals("2")) {
                Log.d("result ", id);
                models.add(new modelMenu(id, "1", "Ayam kremes", "Rp. 15.000, 00", "ayam"));
                models.add(new modelMenu(id, "2", "Pecel lele", "Rp. 14.000, 00", "ikan"));
                models.add(new modelMenu(id, "3", "Nasi goreng", "Rp. 13.000, 00", "lainnya"));
            } else if (id.equals("3")) {
                Log.d("result ", id);
                models.add(new modelMenu(id, "1", "Lele penyet 1", "Rp. 15.000, 00", "ikan"));
                models.add(new modelMenu(id, "2", "Ayam penyet", "Rp. 14.000, 00", "ayam"));
                models.add(new modelMenu(id, "3", "Bubur ayam", "Rp. 13.000, 00", "bubur"));
                models.add(new modelMenu(id, "3", "Bakso", "Rp. 13.000, 00", "bakso"));
            } else if (id.equals("4")) {
                Log.d("result ", id);
                models.add(new modelMenu(id, "1", "Mie rebus", "Rp. 6.000, 00", "mie"));
                models.add(new modelMenu(id, "2", "Mie goreng", "Rp. 5.000, 00", "mie"));
                models.add(new modelMenu(id, "3", "Nasi Telor", "Rp. 13.000, 00", "nasi"));
            } else {
                Log.d("result ", id);
            }
        }
        adapter = new AdapterListMenu(DetailWarung.this, models, new AdapterListMenu.OnItemClickListener() {
            @Override
            public void onClick(modelMenu item) {

            }
        }, new AdapterListMenu.OnItemLongClickListener() {
            @Override
            public void onlClick(modelMenu item) {

            }
        });
        recyclerView.setAdapter(adapter);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            default:
                break;
        }
        // User didn't trigger a refresh, let the superclass handle this action
        return super.onOptionsItemSelected(item);
    }
}
