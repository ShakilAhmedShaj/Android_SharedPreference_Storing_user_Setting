package com.t3ch.shaj.android_sharedpreference_storing_user_setting;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    private LinearLayout linearLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        linearLayout = findViewById(R.id.LL_id);

        if (loadColor() != getResources().getColor(R.color.colorPrimary)) {
            linearLayout.setBackgroundColor(loadColor());
        }


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_layout, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == R.id.red_id) {

            linearLayout.setBackgroundColor(getResources().getColor(R.color.red));
            storeColor(getResources().getColor(R.color.red));

        } else if (item.getItemId() == R.id.green_id) {

            linearLayout.setBackgroundColor(getResources().getColor(R.color.green));
            storeColor(getResources().getColor(R.color.green));

        } else if (item.getItemId() == R.id.blue_id) {

            linearLayout.setBackgroundColor(getResources().getColor(R.color.blue));
            storeColor(getResources().getColor(R.color.blue));

        }


        return super.onOptionsItemSelected(item);
    }

    private void storeColor(int color) {

        SharedPreferences sharedPreferences = getSharedPreferences("BG_Color", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("color", color);
        editor.commit();


    }

    private int loadColor() {
        SharedPreferences sharedPreferences = getSharedPreferences("BG_Color", Context.MODE_PRIVATE);
        int selectedColor = sharedPreferences.getInt("color", getResources().getColor(R.color.colorPrimary));

        return selectedColor;

    }


}
