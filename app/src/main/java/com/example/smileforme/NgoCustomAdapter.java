//package com.example.smileforme;
//
//import android.content.Context;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.TextView;
//
//import androidx.annotation.NonNull;
//import androidx.recyclerview.widget.RecyclerView;
//
//import java.util.ArrayList;
//
//public class NgoCustomAdapter extends RecyclerView.Adapter<NgoCustomAdapter.MyViewHolder>
//{
//    private Context ctx;
//    private ArrayList ngoname, ngoid, ngotype;
//
//    NgoCustomAdapter(Context ctx, ArrayList ngoname, ArrayList ngoid, ArrayList ngotype){
//        this.ctx = ctx;
//        this.ngoname = ngoname;
//        this.ngoid = ngoid;
//        this.ngotype = ngotype;
//    }
//
//    @NonNull
//    @Override
//    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        LayoutInflater inflater = LayoutInflater.from(ctx);
//        View view = inflater.inflate(R.id.ngo_row, parent, false);
//        return new MyViewHolder(view);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
//        holder.nameofngo.setText(String.valueOf(ngoname.get(position)));
//        holder.idofngo.setText(String.valueOf(ngoid.get(position)));
//        holder.typeofngo.setText(String.valueOf(ngotype.get(position)));
//    }
//
//    @Override
//    public int getItemCount() {
//        return ngoname.size();
//    }
//
//    public class MyViewHolder extends RecyclerView.ViewHolder {
//        TextView nameofngo, idofngo, typeofngo;
//
//        public MyViewHolder(@NonNull View itemView) {
//            super(itemView);
//            nameofngo = itemView.findViewById(R.id.ngoval);
//            idofngo = itemView.findViewById(R.id.ngovalid);
//            typeofngo = itemView.findViewById(R.id.ngotype);
//        }
//    }
//}
