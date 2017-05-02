package innovable.dev.warung.activity;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.widget.ImageView;

import java.util.ArrayList;

import innovable.dev.warung.R;
import innovable.dev.warung.adapter.AdapterWarung;
import innovable.dev.warung.models.modelWarung;

public class Warung extends AppCompatActivity {

    private RecyclerView recyclerView;
    private AdapterWarung adapter;
    private ArrayList<modelWarung> models = new ArrayList<>();
    private String kat="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_warung);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        recyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        Intent i = getIntent();
        if (i.getStringExtra("menu")!=null){
            kat = i.getStringExtra("menu");
            getSupportActionBar().setTitle(kat);
            setDataWarungByMenu(kat);
        } else {
            setDataWarung();
        }
    }

    private void setDataWarung(){
        models.add(new modelWarung("1", "Mang Jajang", "08967812333", "0"));
        models.add(new modelWarung("2", "Mas Jono", "089678123423", "0"));
        models.add(new modelWarung("3", "Salsabila", "089123419012", "1"));
        models.add(new modelWarung("4", "Warkop", "08529012312", "1"));
        adapter = new AdapterWarung(Warung.this, models, new AdapterWarung.OnItemClickListener() {
            @Override
            public void onClick(modelWarung item) {
                Intent i = new Intent(Warung.this, DetailWarung.class);
                i.putExtra("warung", item.getNama());
                i.putExtra("id", item.getId());
                i.putExtra("hp", item.getHp());
                startActivity(i);
            }
        }, new AdapterWarung.OnItemLongClickListener() {
            @Override
            public void onlClick(modelWarung item) {

            }
        });
        recyclerView.setAdapter(adapter);
    }

    private void setDataWarungByMenu(String menu){
        if (menu.equals("ayam")) {
            models.add(new modelWarung("1", "Mang Jajang", "08967812333", "0"));
            models.add(new modelWarung("2", "Mas Jono", "089678123423", "0"));
            models.add(new modelWarung("3", "Salsabila", "089123419012", "1"));
        } else if (menu.equals("ikan")){
            models.add(new modelWarung("2", "Mas Jono", "089678123423", "0"));
            models.add(new modelWarung("3", "Salsabila", "089123419012", "1"));
        } else if (menu.equals("bubur")){
            models.add(new modelWarung("3", "Salsabila", "089123419012", "1"));
        } else if (menu.equals("mie")){
            models.add(new modelWarung("1", "Mang Jajang", "08967812333", "0"));
            models.add(new modelWarung("4", "Warkop", "08529012312", "1"));
        } else if (menu.equals("bakso")){
            models.add(new modelWarung("3", "Salsabila", "089123419012", "1"));
        }
        adapter = new AdapterWarung(Warung.this, models, new AdapterWarung.OnItemClickListener() {
            @Override
            public void onClick(modelWarung item) {
                Intent i = new Intent(Warung.this, DetailWarung.class);
                if (!kat.equals("")){
                    i.putExtra("warung", item.getNama());
                    i.putExtra("kategori", kat);
                    i.putExtra("id", item.getId());
                    i.putExtra("hp", item.getHp());
                    startActivity(i);
                } else {
                    i.putExtra("warung", item.getNama());
                    i.putExtra("id", item.getId());
                    i.putExtra("hp", item.getHp());
                    startActivity(i);
                }
            }
        }, new AdapterWarung.OnItemLongClickListener() {
            @Override
            public void onlClick(modelWarung item) {

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
