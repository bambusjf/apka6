package com.example.apka;

import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private EditText mail;
    private EditText haslo;
    private EditText phaslo;
    private TextView info;
    private Button button;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mail=findViewById(R.id.email);
        haslo = findViewById(R.id.ehaslo);
        phaslo=findViewById(R.id.ephaslo);
        info=findViewById(R.id.info);
        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String smail = mail.getText().toString().trim();
                String shaslo = haslo.getText().toString().trim();
                String sphaslo = phaslo.getText().toString().trim();
                if(smail.isEmpty()){
                    info.setText("Wpisz E-mail");
                } else if (!Patterns.EMAIL_ADDRESS.matcher(smail).matches()) {
                    info.setText("Nieprawidłowy adres email");
                }else if (shaslo.isEmpty()){
                    info.setText("Prosze Wpisać Hasło");
                }else if (sphaslo.isEmpty()){
                    info.setText("Prosze Powtórzyć hasło");
                }else if (!shaslo.equals(sphaslo)){
                    info.setText("Hasła się różnią");
                }else {
                    info.setText("Witaj "+smail);
                }
            }
        });

    }
}