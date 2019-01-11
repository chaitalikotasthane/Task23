package com.example.android.firebasecloud;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.FirebaseError;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    private Context mcontext;
    private List<UsersClass> li=new ArrayList<>();
    public Adapter(Context context, ArrayList<UsersClass> li) {
        mcontext = context;
        this.li=li;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int ViewType){
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.box, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }


    public int getItemCount() {
        return li.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView name;
        public TextView age;
        public ViewHolder(View itemView)
        {
            super(itemView);
            name=(TextView)itemView.findViewById(R.id.textView1);
            age=(TextView)itemView.findViewById(R.id.textView2);
        }
    }
    @Override
    public void onBindViewHolder(Adapter.ViewHolder holder, int position) {
        holder.name.setText("Name: "+li.get(position).getName());
        holder.age.setText("Age: "+li.get(position).getAge());
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View listItem = convertView;
        if(listItem == null)
            listItem = LayoutInflater.from(mcontext).inflate(R.layout.box,parent,false);

        UsersClass user = li.get(position);

        TextView name = (TextView) listItem.findViewById(R.id.textView1);
        name.setText(user.getName());

        TextView age = (TextView) listItem.findViewById(R.id.textView2);
        age.setText(user.getAge());

        return listItem;
    }
}
