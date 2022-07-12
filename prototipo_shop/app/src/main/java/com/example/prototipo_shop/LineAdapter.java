package com.example.prototipo_shop;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class LineAdapter extends RecyclerView.Adapter<lineHolder>{

    private final List<ShoppingValue> shop;
    private ItemClickListener clickListener;

    public LineAdapter(List<ShoppingValue> shop, ItemClickListener clicklistener){
        this.shop = shop;
        this.clickListener = clicklistener;
    }

    @NonNull
    @Override
    public lineHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new lineHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.itemlist,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull lineHolder holder, int position) {
       ShoppingValue shoppings = shop.get(position);
       holder.getNome_shop().setText(shoppings.getNome());
       holder.itemView.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               clickListener.onItemClick(shoppings);

           }
       });

    }
    public interface ItemClickListener {
        public void onItemClick(ShoppingValue shoppingvalue);
    }
    @Override
    public int getItemCount() {
        return 0;
    }

    private void insertItem(ShoppingValue shoppingvalue) {
        shop.add(shoppingvalue);
        notifyItemInserted(getItemCount());
    }
}

