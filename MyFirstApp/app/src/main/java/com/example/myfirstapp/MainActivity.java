package com.example.myfirstapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;




public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void sendMessage(View view) {
        Intent intent = new Intent(this, DisplayMessageAcitivity.class);
        EditText editText = (EditText) findViewById(R.id.editText);
        EditText editText2 = (EditText) findViewById(R.id.editText2);

        int x =0;
        int x2=0;
        double tulos=0;
        double tulos2=0;
        String message ="syötä numeroita";
        try {
            x = Integer.parseInt(editText.getText().toString());
            x2 = Integer.parseInt(editText2.getText().toString());
            tulos = (double) x * (double) x2 * 0.0333 + x;
            tulos2 = (int) Math.ceil(tulos);
            message = String.valueOf(tulos2)+" kg";
        }catch (Exception e){

        }

        String viesti;
        if (tulos < 50) {
            viesti = "Nyt vaan lisää treeniä!";
        } else if (tulos < 60) {
            viesti = "Tästä on hyvä lähteä";
        } else if (tulos < 70) {
            viesti = "ihan ok";
        } else if (tulos < 80) {
            viesti = "ei huono";
        } else if (tulos < 90) {
        viesti = "kohta menee 90kg!";
    }else if (tulos<100) {
            viesti = "Hyvä! vähän vielä treeniä, niin 100kg menee rikki!";

        } else if(tulos<110) {
            viesti ="Yli 100kg, se on jo hyvin!";
    } else {
            viesti ="Oot vahva!";
        }

        intent.putExtra(EXTRA_MESSAGE, message);

        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }

}
