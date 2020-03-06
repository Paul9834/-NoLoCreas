package com.luminosity.apps.nolocreas.Actividades;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.luminosity.apps.nolocreas.R;
import com.luminosity.apps.nolocreas.Adaptadores.SlideAdapter;


public class Welcome_Activity extends AppCompatActivity {
    ViewPager viewPager;
    SlideAdapter myadapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = (ViewPager) findViewById(R.id.viewpager);

        myadapter = new SlideAdapter(this);
        viewPager.setAdapter(myadapter);

    }

    @Override
    public void onResume() {
        super.onResume();

    }

}
