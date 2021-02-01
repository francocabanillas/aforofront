package com.upc.aforofront.recycler;

import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.upc.aforofront.R;

import java.util.List;

public class ListadoAdapter extends RecyclerView.Adapter<ListadoAdapter.MyViewHolder> {

    private List<Listado> listadoList;

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView id, nombre;
        public LinearLayout imagen;

        public MyViewHolder(View view) {
            super(view);
            id = (TextView) view.findViewById(R.id.idestablecimiento);
            nombre = (TextView) view.findViewById(R.id.nombreestablecimiento);
            imagen = (LinearLayout) view.findViewById(R.id.imagenestablecimiento);

        }
    }


    public ListadoAdapter(List<Listado> listadoList) {
        this.listadoList = listadoList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.listado_fila, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Listado listado = listadoList.get(position);
        holder.id.setText(listado.getId());
        holder.nombre.setText(listado.getNombre());
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
        return listadoList.size();
    }
}
