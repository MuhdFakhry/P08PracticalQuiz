package sg.edu.rp.c346.p08practicalquiz;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText etName;
    EditText etAge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.editTextName);
        etAge = findViewById(R.id.editTextAge);
    }

    @Override
    protected void onPause() {
        super.onPause();

        String strName = etName.getText().toString();
        int intAge = Integer.parseInt(etAge.getText().toString());
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor prefEdit = prefs.edit();
        prefEdit.putString("name", strName);
        prefEdit.putInt("age", intAge);
        prefEdit.commit();
    }

    @Override
    protected void onResume() {
        super.onResume();

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        String displayName = prefs.getString("name", "");
        int displayAge = prefs.getInt("age", 0);
        etName.setText(displayName);
        etAge.setText(Integer.toString(displayAge));
    }

}
