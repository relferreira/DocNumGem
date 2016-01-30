package com.relferreira.docnumgen.main;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.relferreira.docnumgen.R;
import com.relferreira.docnumgen.model.Doc;

import java.util.List;

/**
 * Created by renan on 11/01/2016.
 */
public class DocsAdapter extends RecyclerView.Adapter<DocsAdapter.DocViewHolder> {

    protected List<Doc> list;
    protected MainView mainView;


    public DocsAdapter(List<Doc> list, MainView mainView) {
        this.list = list;
        this.mainView = mainView;
    }

    @Override
    public DocViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View item = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_docs, parent, false);
        return new DocViewHolder(item, onItemClick);
    }

    @Override
    public void onBindViewHolder(DocViewHolder viewHolder, int position) {
        Doc item = list.get(position);
        viewHolder.textViewName.setText(item.getName());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    DocsAdapter.DocViewHolder.DocViewClickListener onItemClick = new DocsAdapter.DocViewHolder.DocViewClickListener() {

        @Override
        public void onClick(int position) {
            mainView.openDetail(list.get(position));
        }
    };


    protected static class DocViewHolder extends RecyclerView.ViewHolder {

        private DocViewClickListener listener;
        protected TextView textViewName;

        public interface DocViewClickListener {
            void onClick(int position);
        }

        public DocViewHolder(View itemView, final DocViewClickListener listener) {
            super(itemView);
            this.listener = listener;
            textViewName = (TextView) itemView.findViewById(R.id.adapter_doc_name);

            itemView.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    listener.onClick(getAdapterPosition());
                }
            });
        }
    }
}
