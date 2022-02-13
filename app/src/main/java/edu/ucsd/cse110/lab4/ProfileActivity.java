package edu.ucsd.cse110.lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        loadProfile();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        saveProfile();
    }

    public void onGoBackClicked(View view) {
        finish();
    }

    public void loadProfile() {
        SharedPreferences preferences = getPreferences(MODE_PRIVATE);
        String name = preferences.getString("name", "");
        String status = preferences.getString("status", "");

        EditText nameView = findViewById(R.id.name_textview);
        nameView.setText(name);
        EditText statusView = findViewById(R.id.status_textview);
        statusView.setText(status);
    }

    public void saveProfile() {
        SharedPreferences preferences = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();

        EditText nameView = findViewById(R.id.name_textview);
        editor.putString("name", nameView.getText().toString());
        EditText statusView = findViewById(R.id.status_textview);
        editor.putString("status", statusView.getText().toString());

        editor.apply();
    }
}