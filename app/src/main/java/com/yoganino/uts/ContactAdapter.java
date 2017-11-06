package com.yoganino.uts;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by cipowela on 06/11/17.
 */
public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.Holders>{
    private Context c;
    private List<ContactModel> contactModels;

    public ContactAdapter(Context c, List<ContactModel> contactModels) {
        this.c = c;
        this.contactModels = contactModels;
    }

    @Override
    public Holders onCreateViewHolder(ViewGroup parent, int viewType) {
       View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout,parent,false);

        return new Holders(v);
    }

    @Override
    public void onBindViewHolder(Holders holder, int position) {
        final ContactModel model = contactModels.get(position);
        holder.Text.setText(model.getNama());
        holder.Layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(c,Detail.class);
                i.putExtra("nama.kontak",model.getNama());
                i.putExtra("email.kontak",model.getEmail());
                i.putExtra("telp.kontak",model.getNomor());

                c.startActivity(i);
            }
        });

    }

    @Override
    public int getItemCount() {
        return contactModels.size();
    }

    public class Holders extends RecyclerView.ViewHolder {
        TextView Text;
        LinearLayout Layout;
        public Holders(View itemView) {
            super(itemView);
             Text = (TextView)itemView.findViewById(R.id.nama1);
             Layout = (LinearLayout)itemView.findViewById(R.id.layout) ;
        }
    }
}
