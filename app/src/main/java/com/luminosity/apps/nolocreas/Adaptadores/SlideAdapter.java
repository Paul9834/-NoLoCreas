package com.luminosity.apps.nolocreas.Adaptadores;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.content.Intent;

import com.luminosity.apps.nolocreas.Actividades.Login_Activity;
import com.luminosity.apps.nolocreas.R;

public class SlideAdapter extends PagerAdapter {


    Context context;
    LayoutInflater inflater;

    public int[] lst_images = {
            R.drawable.image_1,
            R.drawable.image_2,
            R.drawable.image_3,
            R.drawable.image_4

    };
    // list of titles
    public String[] lst_title = {
            "VERIFICACIÓN",
            "USO",
            "APRENDIZAJE",
            "CONFIANZA"
    };
    // list of descriptions
    public String[] lst_description = {
            "Verificamos los enlaces proporcionados por los usuarios para decirles si son seguros o no.",
            "El usuario puede hacer uso de la herramienta para hacer envio de sus enlaces.",
            "Podrás aprender a conocer todo los factores de los riesgos al navegar en la web.",
            "Somos un equipo comprometido donde nuestro objetivo en sensibilizar a las personas.",
    };
    // list of background colors
    public int[] lst_backgroundcolor = {
            Color.rgb(255, 160, 0),
            Color.rgb(229, 57, 53),
            Color.rgb(33, 150, 243),
            Color.rgb(76, 175, 80),


    };

    public SlideAdapter(Context context) {
        this.context = context;


    }

    @Override
    public int getCount() {
        return lst_title.length;
    }


    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return (view == (LinearLayout) object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        //cambiar la actividad//

        View view = inflater.inflate(R.layout.slide, container, false);
        LinearLayout layoutslide = view.findViewById(R.id.slidelinearlayout);
        ImageView imgslide = (ImageView) view.findViewById(R.id.slideimg);
        TextView txttitle = (TextView) view.findViewById(R.id.txttitle);
        TextView description = (TextView) view.findViewById(R.id.txtdescription);
        layoutslide.setBackgroundColor(lst_backgroundcolor[position]);
        imgslide.setImageResource(lst_images[position]);
        txttitle.setText(lst_title[position]);
        description.setText(lst_description[position]);
        container.addView(view);
        Button c = (Button) view.findViewById(R.id.saltar);
        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(view.getContext(), Login_Activity.class);
                view.getContext().startActivity(i);

            }
        });

        return view;

    }


    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((LinearLayout) object);
    }


}
