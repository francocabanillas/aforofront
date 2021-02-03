package com.upc.aforofront.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.upc.aforofront.R;

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
        Sede Sede = SedeList.get(position);
        holder.nombre.setText(" " +Sede.getNombre());
        holder.direccion.setText(" " +Sede.getDireccion());
        holder.idListado.setText(Sede.getIdListado());
        Double calculo = Math.random()*300;
        DecimalFormat format = new DecimalFormat("0");
        String formateado = format.format(calculo);
        holder.aforo.setText("Aforo: " + formateado);

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
        return SedeList.size();
    }
}
