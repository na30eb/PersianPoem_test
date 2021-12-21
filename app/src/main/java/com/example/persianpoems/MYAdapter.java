package com.example.persianpoems;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MYAdapter extends RecyclerView.Adapter<MYAdapter.myViewHolder> {
    String title[],category[],poem[] ;
    Context context ;



    public MYAdapter (Context ct,String s1[],String s2[] , String s3[]){
        context = ct ;
        title = s1;
        category = s2 ;
        poem = s3 ;


    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View v = inflater.inflate(R.layout.recyclerlayout,parent,false);
        return new myViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {
        holder.titles.setText(title[position]);
        holder.categories.setText(category[position]);
        holder.poesm.setText(poem[position]);


        //
        holder.share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/palin");
                String sharebody = title[position];
                String sharesub = poem[position] +"\r\n شاعر "+title[position] ;
                intent.putExtra(intent.EXTRA_SUBJECT,sharebody);
                intent.putExtra(intent.EXTRA_TEXT,sharesub);
                context.startActivity(Intent.createChooser(intent,"Share with :"));

            }
        });
        holder.copy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ClipboardManager clipboard = (ClipboardManager)context.getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clip = ClipData.newPlainText("copy",poem[position] +"\r\n شاعر "+title[position]);
                clipboard.setPrimaryClip(clip);
                Toast.makeText(context, "copied!", Toast.LENGTH_SHORT).show();


            }
        });


    }

    @Override
    public int getItemCount() {
        return title.length;
    }

    public class myViewHolder extends RecyclerView.ViewHolder {
        TextView titles , categories , poesm ;
        ImageButton copy , share ;
        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            titles = itemView.findViewById(R.id.txt_title);
            categories = itemView.findViewById(R.id.txt_category);
            poesm = itemView.findViewById(R.id.txt_poems);
            // buttons
            copy = itemView.findViewById(R.id.copybutton);
            share = itemView.findViewById(R.id.share_button);



        }





    }
}
