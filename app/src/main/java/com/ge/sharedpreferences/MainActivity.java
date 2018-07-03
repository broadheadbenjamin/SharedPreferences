package com.ge.sharedpreferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private static final String PREFS_FILE = "com.ge.sharedpreferences.preferences";
    private static final String KEY_EDITTEXT = "KEY_EDITTEXT";
    private SharedPreferences.Editor editor;
    private SharedPreferences sharedPreferenes;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        sharedPreferenes = getSharedPreferences(PREFS_FILE, Context.MODE_PRIVATE);
        editor = sharedPreferenes.edit();

        String editTextString = sharedPreferenes.getString(KEY_EDITTEXT, "");
        editText.setText(editTextString);
    }

    @Override
    protected void onPause() {
        super.onPause();

        editor.putString(KEY_EDITTEXT, editText.getText().toString());
        editor.apply();
    }
}
