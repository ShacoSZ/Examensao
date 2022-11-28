package com.example.examensao;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class adaptador extends RecyclerView.Adapter<adaptador.viewHolder> {
    private List<ListaGanadores> agua;
    public adaptador(List<ListaGanadores>agua){this.agua=agua;}
    @NonNull
    @Override
    public adaptador.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.disenasao,parent,false);
        return new adaptador.viewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull adaptador.viewHolder holder, int position) {
    holder.setData(agua.get(position));
    }
    @Override
    public int getItemCount() {return agua.size();}


    public class viewHolder extends  RecyclerView.ViewHolder {
        TextView nombresao;
        TextView cantidadsao;
//        ImageView imagensao;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            nombresao=itemView.findViewById(R.id.nombresao);
            cantidadsao=itemView.findViewById(R.id.cantidadsao);
           // imagensao=itemView.findViewById(R.id.imagensao);
        }
        public void setData(ListaGanadores reisao)
        {
            nombresao.setText(reisao.getNombre());
            cantidadsao.setText(reisao.getCantidad());
           // Picasso.get().load(""+reisao.getUrlImg()).into(imagensao);
        }
    }
}
