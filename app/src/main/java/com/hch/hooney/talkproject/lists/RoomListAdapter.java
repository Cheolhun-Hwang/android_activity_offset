package com.hch.hooney.talkproject.lists;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hch.hooney.talkproject.R;
import com.hch.hooney.talkproject.vo.ListData;

import java.util.ArrayList;
import java.util.List;

public class RoomListAdapter extends RecyclerView.Adapter<RoomListAdapter.RoomListHolder> {
    private List<ListData> list;
    private OnViewClickListener listener;

    public RoomListAdapter() {
        this.list = new ArrayList<>();
    }

    public RoomListAdapter(List<ListData> list) {
        this.list = list;
    }

    public void setList(List<ListData> list){
        this.list.clear();
        this.list.addAll(list);
        this.notifyDataSetChanged();
    }

    public void setOnViewClickListener(OnViewClickListener listener){
        this.listener = listener;
    }

    @NonNull
    @Override
    public RoomListHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_room, parent, false);
        return new RoomListHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RoomListHolder holder, int position) {
        holder.roomName.setText(list.get(position).getName());
        holder.roomDate.setText(list.get(position).getCreate());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class RoomListHolder extends RecyclerView.ViewHolder{
        TextView roomName, roomDate;

        public RoomListHolder(@NonNull final View itemView) {
            super(itemView);
            roomDate = itemView.findViewById(R.id.item_room_create);
            roomName = itemView.findViewById(R.id.item_room_name);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if(listener != null && position != RecyclerView.NO_POSITION){
                        listener.onClicked(itemView, list.get(position));
                    }
                }
            });
        }
    }

    public interface OnViewClickListener{
        void onClicked(View view, ListData item);
    }
}
