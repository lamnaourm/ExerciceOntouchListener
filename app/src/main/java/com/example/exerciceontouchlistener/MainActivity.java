package com.example.exerciceontouchlistener;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ArrayList<Stagiaire> stgs = new ArrayList<>();
    int pos = 0;
    EditText enom, eprenom;
    RadioGroup grp;
    ImageView im;
    Button b1,b2,b3,b4;
    float dx = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        enom = findViewById(R.id.enom);
        eprenom = findViewById(R.id.eprenom);
        grp = findViewById(R.id.grp);
        im = findViewById(R.id.img);
        b1 = findViewById(R.id.b1);
        b2 = findViewById(R.id.b2);
        b3 = findViewById(R.id.b3);
        b4 = findViewById(R.id.b4);

        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        b4.setOnClickListener(this);

        stgs.add(new Stagiaire("nom 1","prenom 1","H",R.drawable.image1));
        stgs.add(new Stagiaire("nom 2","prenom 2","H",R.drawable.image2));
        stgs.add(new Stagiaire("nom 3","prenom 3","F",R.drawable.image3));
        stgs.add(new Stagiaire("nom 4","prenom 4","H",R.drawable.image4));
        stgs.add(new Stagiaire("nom 5","prenom 5","H",R.drawable.image5));
        stgs.add(new Stagiaire("nom 6","prenom 6","F",R.drawable.image6));
        stgs.add(new Stagiaire("nom 7","prenom 7","H",R.drawable.image7));
        stgs.add(new Stagiaire("nom 8","prenom 8","F",R.drawable.image8));

        pos = 0;
        afficheStagiaire();

        im.setOnTouchListener(new View.OnTouchListener() {
             @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
               switch (motionEvent.getAction()){
                   case MotionEvent.ACTION_DOWN:
                       dx = motionEvent.getX();
                       break;
                   case MotionEvent.ACTION_UP:
                       float upx = motionEvent.getX();

                       if(dx>upx)
                           pos++;
                       else if(dx<upx)
                           pos--;

                       afficheStagiaire();

                       break;
               }
                return true;
            }
        });
    }

    public void afficheStagiaire(){
        if(pos<0){
            pos = stgs.size()-1;
        }else if(pos>=stgs.size()){
            pos = 0;
        }

        Stagiaire s = stgs.get(pos);
        enom.setText(s.getNom());
        eprenom.setText(s.getPrenom());
        if(s.getSexe().equals("H"))
            grp.check(R.id.rd1);
        else
            grp.check(R.id.rd2);
        im.setImageResource(s.getImage());
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.b1: pos = 0; break;
            case R.id.b2: pos--; break;
            case R.id.b3: pos++; break;
            case R.id.b4: pos = stgs.size()-1; break;
        }

        afficheStagiaire();
    }
}