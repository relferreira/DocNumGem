package com.relferreira.docnumgen.presentation.view.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.relferreira.docnumgen.R;
import com.relferreira.docnumgen.model.Doc;

import java.util.List;

/**
 * Created by renan on 02/03/2016.
 */
public class DocFavAdapter extends RecyclerView.Adapter<DocFavAdapter.DocFavViewHolder> {


    private final List<Doc> documents;

    public DocFavAdapter(List<Doc> documents) {
        this.documents = documents;
    }

    @Override
    public DocFavViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View item = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_docs_fav, parent, false);
        return new DocFavViewHolder(item);
    }

    @Override
    public void onBindViewHolder(DocFavViewHolder holder, int position) {
        Doc document = documents.get(position);
        holder.docText.setText(document.getName());
    }

    @Override
    public int getItemCount() {
        return documents.size();
    }

    public static class DocFavViewHolder extends RecyclerView.ViewHolder {

        protected TextView docText;

        public DocFavViewHolder(View itemView) {
            super(itemView);
            docText = (TextView) itemView.findViewById(R.id.adapter_fav_text);
        }
    }
}
