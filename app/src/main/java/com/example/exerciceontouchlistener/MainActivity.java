package com.example.exerciceontouchlistener;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Stagiaire> stgs = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        stgs.add(new Stagiaire("nom 1","prenom 1","H",R.drawable.image1));
        stgs.add(new Stagiaire("nom 2","prenom 2","H",R.drawable.image2));
        stgs.add(new Stagiaire("nom 3","prenom 3","F",R.drawable.image3));
        stgs.add(new Stagiaire("nom 4","prenom 4","H",R.drawable.image4));
        stgs.add(new Stagiaire("nom 5","prenom 5","H",R.drawable.image5));
        stgs.add(new Stagiaire("nom 6","prenom 6","F",R.drawable.image6));
        stgs.add(new Stagiaire("nom 7","prenom 7","H",R.drawable.image7));
        stgs.add(new Stagiaire("nom 8","prenom 8","F",R.drawable.image8));


    }
}