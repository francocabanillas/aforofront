package com.upc.aforofront.view;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.StrictMode;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.upc.aforofront.R;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.List;

public class SedeAdapter extends RecyclerView.Adapter<SedeAdapter.MyViewHolder> {

    private List<Sede> SedeList;

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView id, nombre, direccion, referencia, aforo, idListado ;
        public LinearLayout imagen;


        public MyViewHolder(View view) {
            super(view);
            nombre = (TextView) view.findViewById(R.id.sedenombre);
            direccion = (TextView) view.findViewById(R.id.sededireccion);
            idListado = (TextView) view.findViewById(R.id.sedeidlistado);
            aforo = (TextView) view.findViewById(R.id.sedeaforo);
            imagen = (LinearLayout) view.findViewById(R.id.sedeimagen);
        }
    }


    public SedeAdapter(List<Sede> aSedeList) {
        this.SedeList = aSedeList;
    }

    @Override
    public SedeAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.sede_fila, parent, false);

        return new SedeAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(SedeAdapter.MyViewHolder holder, int position) {
        Sede sede = SedeList.get(position);
        holder.nombre.setText(sede.getNombre());
        holder.direccion.setText(sede.getDireccion());
        holder.idListado.setText(sede.getIdmarca());
//        Double calculo = Math.random()*300;
//        DecimalFormat format = new DecimalFormat("0");
//        String formateado = format.format(calculo);
//        holder.aforo.setText("Aforo: " + formateado);
        holder.aforo.setText("Aforo: " + sede.getAforo());

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        Bitmap myImage = getBitmapFromURL(sede.getImagen());
        Drawable dr = new BitmapDrawable(myImage);
        holder.imagen.setBackgroundDrawable(dr);

    }

    public Bitmap getBitmapFromURL(String imageUrl) {
        try {
            URL url = new URL(imageUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoInput(true);
            connection.connect();
            InputStream input = connection.getInputStream();
            Bitmap myBitmap = BitmapFactory.decodeStream(input);
            return myBitmap;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public int getItemCount() {
        return SedeList.size();
    }
}
