package com.example.a7oda.AccountSaver;

import android.app.Activity;
import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import static android.content.ContentValues.TAG;

public class PersonAdpter extends RecyclerView.Adapter<PersonAdpter.PersonViewHolder> {
    private Context mContext;
    private List<person> mPersonList;
    public PersonsDB db;
    public Notification noti ;
    public PersonAdpter(Context c, List<person> personList) {
        this.mContext = c;
        mPersonList = personList;
    }

    @NonNull
    @Override
    public PersonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.person, parent, false);
        return new PersonViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final PersonViewHolder holder, final int position) {
        final person p = mPersonList.get(position);
        holder.Rname.setText(p.getName());
        holder.Remail.setText(p.getEmail());
        holder.image.setImageResource(R.drawable.person);
        holder.personsLO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pintent = new Intent(mContext,detailsActivity.class);
                pintent.putExtra("personclicked",p);
                mContext.startActivity(pintent);
            }
        });
        holder.personsLO.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Log.e(TAG, "onLongClick: "+position );
                PopupMenu pum = new PopupMenu(mContext,holder.personsLO);
                pum.inflate(R.menu.menuoptions);
                pum.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        db = new PersonsDB(mContext);
                        switch (item.getItemId()){
                            case R.id.item1:
                                if(db.deletePerson(p.getName())) {
                                    Toast.makeText(mContext, "deleted", Toast.LENGTH_SHORT).show();
                                    mPersonList.remove(position);
                                    notifyDataSetChanged();
                                }
                                else
                                    Toast.makeText(mContext,"can't delete this person",Toast.LENGTH_SHORT).show();break;
                                 case R.id.updateitem: {
                                    Intent intent = new Intent(mContext, MainActivity.class);
                                    intent.putExtra("Pupdate", p);
                                    mContext.startActivity(intent);
                                     ((Activity)mContext).finish();

                                 }
                        }
                        return false;
                    }
                });
                pum.show();
                return false;
            }
        });

    }

    @Override
    public int getItemCount() {
        return mPersonList.size();
    }

    public static class PersonViewHolder extends RecyclerView.ViewHolder {
        TextView Rname;
        TextView Remail;
        ImageView image;
        LinearLayout personsLO;
        public PersonViewHolder(View itemView) {
            super(itemView);
            Rname = itemView.findViewById(R.id.nameview);
            Remail = itemView.findViewById(R.id.emailview);
            image = itemView.findViewById(R.id.imageView);
            personsLO = itemView.findViewById(R.id.personLO);
        }
    }

}
