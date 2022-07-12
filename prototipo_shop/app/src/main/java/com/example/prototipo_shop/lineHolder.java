package com.example.prototipo_shop;

import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class lineHolder  extends RecyclerView.ViewHolder{

    public TextView nome_shop;
    public ImageView Favorita;

    public lineHolder(@NonNull View itemView) {
        super(itemView);
        this.nome_shop = (TextView) itemView.findViewById(R.id.name_s);
        this.Favorita = (ImageView) itemView.findViewById(R.id.image_c);
    }
    public TextView getNome_shop() {
        return nome_shop;
    }

    public void setNome_shop(TextView nome_shop) {
        this.nome_shop = nome_shop;
    }

    public ImageView getFavorita() {
        return Favorita;
    }

    public void setFavorita(ImageView favorita) {
        Favorita = favorita;
    }
}
