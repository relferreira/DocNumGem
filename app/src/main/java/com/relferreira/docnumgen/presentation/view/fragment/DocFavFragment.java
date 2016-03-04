package com.relferreira.docnumgen.presentation.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.relferreira.docnumgen.R;
import com.relferreira.docnumgen.model.Doc;
import com.relferreira.docnumgen.presentation.presenter.FavPresenter;
import com.relferreira.docnumgen.presentation.view.FavView;
import com.relferreira.docnumgen.presentation.view.adapter.DocFavAdapter;

import java.util.ArrayList;
import java.util.List;


public class DocFavFragment extends Fragment implements DocTabFragment, FavView {

    private FavPresenter presenter;
    private List<Doc> docList = new ArrayList<>();
    private DocFavAdapter adapter;

    public static DocFavFragment newInstance() {

        Bundle args = new Bundle();

        DocFavFragment fragment = new DocFavFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_doc_fav, container, false);

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.docs__fav_list);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        adapter = new DocFavAdapter(docList);
        recyclerView.setAdapter(adapter);

        presenter = new FavPresenter();
        presenter.attachView(this);
        presenter.loadFavorites();
        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.dettachView();
    }

    @Override
    public void showFavorites(List<Doc> docList) {
        Toast.makeText(getActivity(), "teste", Toast.LENGTH_LONG).show();
        this.docList.addAll(docList);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void showError(int status, String error) {

    }

    @Override
    public void showLoading(boolean refresh) {

    }

    @Override
    public void hideLoading() {

    }
}
