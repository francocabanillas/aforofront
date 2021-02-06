package com.upc.aforofront.view;

import android.content.Context;
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
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.upc.aforofront.R;
import com.upc.aforofront.ui.dashboard.DashboardFragment;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class MarcaAdapter extends RecyclerView.Adapter<MarcaAdapter.MyViewHolder> {

    private List<Marca> MarcaList;
    private Context context;
    private View.OnClickListener listener;

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView id, nombre;
        public LinearLayout imagen;
        public RecyclerView recyclerView;



        public MyViewHolder(View view) {
            super(view);
            id = (TextView) view.findViewById(R.id.marcaid);
            nombre = (TextView) view.findViewById(R.id.marcanombre);
            imagen = (LinearLayout) view.findViewById(R.id.marcaimagen);
            recyclerView = (RecyclerView) view.findViewById(R.id.marcarecycler);



        }


        @Override
        public void onClick(View view) {
            if (listener!=null) {
                listener.onClick(view);
            }
        }
    }


    public MarcaAdapter(List<Marca> MarcaList, Context context) {
        this.MarcaList = MarcaList;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.marca_fila, parent, false);

        itemView.setOnClickListener(this.listener);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Bitmap bmp = null;
        URL url = null;

        Marca marca = MarcaList.get(position);
        holder.id.setText(marca.getId());
        holder.nombre.setText(marca.getNombre());

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        Bitmap myImage = getBitmapFromURL(marca.getImagen());

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
        return MarcaList.size();
    }

    public void setOnClicListener(View.OnClickListener listener) {
        this.listener = listener;
    }
}
