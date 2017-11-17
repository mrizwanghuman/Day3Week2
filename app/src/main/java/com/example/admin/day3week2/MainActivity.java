package com.example.admin.day3week2;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements CelDetailFragment.OnFragmentInteractionListener{

    private String First_Frag_Tag="First Fragment";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
String val1 ="Value 1";
String val2 = "Value 2";
        FirstFragment firstFragment = FirstFragment.newInstance(val1, val2);

        getSupportFragmentManager().beginTransaction().add(R.id.flListCeleb,firstFragment, First_Frag_Tag).commit();
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
