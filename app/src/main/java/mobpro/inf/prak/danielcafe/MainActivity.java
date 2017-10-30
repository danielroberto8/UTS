package mobpro.inf.prak.danielcafe;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
    EditText user,pass;
    Button login;
    Intent in;
    SharedPreferences sp;
    public static final String pref = "Profil Saya";
    public static final String Nama = "Admin";

    @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
        user = (EditText) findViewById(R.id.txtUsername);
        pass = (EditText) findViewById(R.id.txtPass);
        login = (Button)findViewById(R.id.btnLogin);
        sp = getSharedPreferences(pref, Context.MODE_PRIVATE);

        login.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                if (user.getText().toString().equals("admin") && pass.getText().toString().equals("admin")) {
                    Toast.makeText(getApplicationContext(), "login berhasil", Toast.LENGTH_SHORT).show();
                    SharedPreferences.Editor editor = sp.edit();
                    editor.putString(Nama, "Daniel");
                    editor.commit();
                    in = new Intent(MainActivity.this,second_main.class);
                    startActivity(in);
                } else {
                    Toast.makeText(getApplicationContext(), "login gagal!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
