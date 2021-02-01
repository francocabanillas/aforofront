package com.upc.aforofront.recycler;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.upc.aforofront.R;

import java.util.List;

public class SedeAforoAdapter extends RecyclerView.Adapter<SedeAforoAdapter.MyViewHolder> {

    private List<SedeAforo> sedeAforoList;

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView id, nombre, direccion, referencia, aforo, idListado ;
        public LinearLayout imagen;


        public MyViewHolder(View view) {
            super(view);
            nombre = (TextView) view.findViewById(R.id.sedeaforonombre);
            direccion = (TextView) view.findViewById(R.id.sedeaforodireccion);
            idListado = (TextView) view.findViewById(R.id.sedeaforoidlistado);
            aforo = (TextView) view.findViewById(R.id.sedeaforoaforo);
            imagen = (LinearLayout) view.findViewById(R.id.sedeaforoimagen);
        }
    }


    public SedeAforoAdapter(List<SedeAforo> sedeAforoList) {
        this.sedeAforoList = sedeAforoList;
    }

    @Override
    public SedeAforoAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.sedeaforo_fila, parent, false);

        return new SedeAforoAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(SedeAforoAdapter.MyViewHolder holder, int position) {
        SedeAforo listado = sedeAforoList.get(position);
        holder.nombre.setText(" " +listado.getNombre());
        holder.direccion.setText(" " +listado.getDireccion());
        holder.idListado.setText(listado.getIdListado());
        holder.aforo.setText("Aforo " + String.valueOf(Math.random()*30));

        switch (holder.idListado.toString()) {
            case "1":
                holder.imagen.setBackgroundResource(R.drawable.metro);
                break;
            case "2":
                holder.imagen.setBackgroundResource(R.drawable.plazavea);
                break;
            case "3":
                holder.imagen.setBackgroundResource(R.drawable.preciouno);
                break;
            case "4":
                holder.imagen.setBackgroundResource(R.drawable.tottus);
                break;
            case "5":
                holder.imagen.setBackgroundResource(R.drawable.vivanda);
                break;
            case "6":
                holder.imagen.setBackgroundResource(R.drawable.wong);
                break;
            default:
                holder.imagen.setBackgroundResource(R.drawable.metro);
                break;
        }



    }

    @Override
    public int getItemCount() {
        return sedeAforoList.size();
    }
}
