package com.example.sandy.todolistbyzhuxiaoxi;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder> {
    static List<ListItem> mList;
    private Context context;
    static class ViewHolder extends RecyclerView.ViewHolder{
        View itemView;
        static TextView itemName;
        static TextView itemEdit;
        static TextView itemDelete;


        public ViewHolder(View view){
            super(view);
            itemView = view;
            itemDelete = view.findViewById(R.id.list_delete);
            itemEdit = view.findViewById(R.id.list_edit);
            itemName = view.findViewById(R.id.list_name);

        }
    }
    public ItemAdapter(List<ListItem> itemList){
        mList = itemList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull final ViewGroup viewGroup, int i) {
        final View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_list,viewGroup,false);
        final ViewHolder holder = new ViewHolder(view);
        holder.itemDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mList.remove(viewGroup.indexOfChild(view));
            }
        });
        holder.itemEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentIndex = new Intent(context,EditActivity.class);
                intentIndex.putExtra("extra_index",holder.getAdapterPosition()-1);
                context.startActivity(intentIndex);
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        ListItem listItem = mList.get(i);
        viewHolder.itemName.setText(listItem.getName());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }
}
