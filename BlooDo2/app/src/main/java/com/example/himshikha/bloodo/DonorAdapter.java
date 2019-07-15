//package com.example.himshikha.bloodo;
//
//import android.support.annotation.NonNull;
//import android.support.v7.widget.RecyclerView;
//import android.support.v7.widget.RecyclerView.ViewHolder;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.database.Cursor;
//import android.content.Context;
//import android.widget.TextView;
//
//public class DonorAdapter extends RecyclerView.Adapter {
//
//    private Context mContext;
//    private Cursor mCursor;
//    public DonorAdapter(Context context,Cursor cursor){
//    mContext=context;
//    mCursor=cursor;
//    }
//
//    public class DonorViewHolder extends RecyclerView.ViewHolder{
//
//        public DonorViewHolder(@NonNull View itemView) {
//            super(itemView);
//        }
//    }
//
//    @NonNull
//    @Override
//    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
//        LayoutInflater inflater=LayoutInflater.from(mContext);
//        View view=inflater.inflate(R.layout.activity_register,viewGroup, false);
//        return new DonorViewHolder(view);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
//        if(!mCursor.move(i)){
//            return;
//        }
//    }
//
//    @Override
//    public int getItemCount() {
//        return mCursor.getCount();
//    }
//
//    public void swapCursor(Cursor newCursor){
//        if(mCursor!=null){
//            mCursor.close();
//        }
//        mCursor=newCursor;
//        if(newCursor!=null){
//            notifyDataSetChanged();
//        }
//    }
//}
