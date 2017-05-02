package innovable.dev.warung.activity;

import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import innovable.dev.warung.R;
import innovable.dev.warung.adapter.AdapterWarungFav;
import innovable.dev.warung.helper.SqliteHelper;
import innovable.dev.warung.models.modelWarung;
import innovable.dev.warung.models.modelWarungFav;

public class Favorite extends AppCompatActivity {
    private RecyclerView recyclerView;
    private AdapterWarungFav adapter;
    private ArrayList<modelWarungFav> models = new ArrayList<>();
    private SqliteHelper sqliteHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Favorite");
        recyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        sqliteHelper = new SqliteHelper(Favorite.this);
        getDataFavorite();
    }

    private void getDataFavorite(){
        models = sqliteHelper.getAllDataFav();
        if (models.size()==0){
            Toast.makeText(Favorite.this, "Belum ada warung favorite yang di tambahkan", Toast.LENGTH_SHORT).show();
        }
        adapter = new AdapterWarungFav(Favorite.this, models, new AdapterWarungFav.OnItemClickListener() {
            @Override
            public void onClick(final modelWarungFav item) {
                Intent i = new Intent(Favorite.this, DetailWarung.class);
                Log.d("Res ", item.getId_warung());
                if (item.getId_warung().equals("1")){
                    i.putExtra("warung", item.getWarung());
                    i.putExtra("id", item.getId_warung());
                    i.putExtra("hp", "08967812333");
                } else if (item.getId_warung().equals("2")){
                    i.putExtra("warung", item.getWarung());
                    i.putExtra("id", item.getId_warung());
                    i.putExtra("hp", "089678123423");
                } else if (item.getId_warung().equals("3")){
                    i.putExtra("warung", item.getWarung());
                    i.putExtra("id", item.getId_warung());
                    i.putExtra("hp", "089123419012");
                } else if (item.getId_warung().equals("4")){
                    i.putExtra("warung", item.getWarung());
                    i.putExtra("id", item.getId_warung());
                    i.putExtra("hp", "08529012312");
                }
                startActivity(i);
            }
        }, new AdapterWarungFav.OnItemLongClickListener() {
            @Override
            public void onlClick(final modelWarungFav item) {
                final Dialog dialog = new Dialog(Favorite.this);
                if (dialog.isShowing()){
                    dialog.dismiss();
                }
                dialog.setCancelable(true);
                dialog.setContentView(R.layout.popup);
                final TextView btn_cancel = (TextView) dialog.findViewById(R.id.btn_cancel);
                final TextView btn_delete = (TextView) dialog.findViewById(R.id.btn_delete);
                btn_cancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
                btn_delete.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Integer i = Integer.parseInt(item.getId());
                        sqliteHelper.deleteFav(i);
                        Toast.makeText(Favorite.this, item.getWarung()+" berhasil di hapus dari favorite", Toast.LENGTH_SHORT).show();
                        models.clear();
                        adapter.notifyDataSetChanged();
                        dialog.dismiss();
                        getDataFavorite();
                    }
                });
                dialog.show();
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
