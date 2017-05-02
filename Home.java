package innovable.dev.warung.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import innovable.dev.warung.R;

public class Home extends AppCompatActivity {

    private LinearLayout btn_warung, btn_fav, btn_menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        btn_warung = (LinearLayout) findViewById(R.id.btn_warung);
        btn_fav = (LinearLayout) findViewById(R.id.btn_fav);
        btn_menu = (LinearLayout) findViewById(R.id.btn_menu);

        btn_warung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Home.this, Warung.class);
                startActivity(i);
            }
        });
        btn_fav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Home.this, Favorite.class);
                startActivity(i);
            }
        });
        btn_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Home.this, Menu.class);
                startActivity(i);
            }
        });
    }
}
