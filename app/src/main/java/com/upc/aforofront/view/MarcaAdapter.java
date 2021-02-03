package com.upc.aforofront.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.upc.aforofront.R;

import java.util.List;

public class MarcaAdapter extends RecyclerView.Adapter<MarcaAdapter.MyViewHolder> {

    private List<Marca> MarcaList;

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView id, nombre;
        public LinearLayout imagen;

        public MyViewHolder(View view) {
            super(view);
            id = (TextView) view.findViewById(R.id.marcaid);
            nombre = (TextView) view.findViewById(R.id.marcanombre);
            imagen = (LinearLayout) view.findViewById(R.id.marcaimagen);

        }
    }


    public MarcaAdapter(List<Marca> MarcaList) {
        this.MarcaList = MarcaList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.marca_fila, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Marca Marca = MarcaList.get(position);
        holder.id.setText(Marca.getId());
        holder.nombre.setText(Marca.getNombre());
        switch (position) {
            case 0:
                holder.imagen.setBackgroundResource(R.drawable.metro);
                break;
            case 1:
                holder.imagen.setBackgroundResource(R.drawable.plazavea);
                break;
            case 2:
                holder.imagen.setBackgroundResource(R.drawable.preciouno);
                break;
            case 3:
                holder.imagen.setBackgroundResource(R.drawable.tottus);
                break;
            case 4:
                holder.imagen.setBackgroundResource(R.drawable.vivanda);
                break;
            case 5:
                holder.imagen.setBackgroundResource(R.drawable.wong);
                break;
            default:
                holder.imagen.setBackgroundResource(R.drawable.metro);
                break;
        }

    }

    @Override
    public int getItemCount() {
        return MarcaList.size();
    }
}
