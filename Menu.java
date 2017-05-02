package innovable.dev.warung.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

import innovable.dev.warung.R;

public class Menu extends AppCompatActivity {
    private LinearLayout btn_ayam, btn_bubur, btn_baso;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Menu");
        btn_ayam = (LinearLayout)findViewById(R.id.btn_ayam);
        btn_bubur = (LinearLayout)findViewById(R.id.btn_bubur);
        btn_baso = (LinearLayout)findViewById(R.id.btn_bakso);
        btn_ayam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Menu.this, Warung.class);
                i.putExtra("menu", "ayam");
                startActivity(i);
            }
        });
        btn_bubur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Menu.this, Warung.class);
                i.putExtra("menu", "bubur");
                startActivity(i);
            }
        });
        btn_baso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Menu.this, Warung.class);
                i.putExtra("menu", "mie");
                startActivity(i);
            }
        });
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
