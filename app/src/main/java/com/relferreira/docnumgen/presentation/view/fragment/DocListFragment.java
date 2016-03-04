package com.relferreira.docnumgen.presentation.view.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.relferreira.docnumgen.R;
import com.relferreira.docnumgen.model.Doc;
import com.relferreira.docnumgen.presentation.presenter.MainPresenter;
import com.relferreira.docnumgen.presentation.view.MainView;
import com.relferreira.docnumgen.presentation.view.adapter.DocsAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by renan on 01/03/2016.
 */
public class DocListFragment extends Fragment implements MainView, DocTabFragment {

    private MainPresenter presenter;
    private DocsAdapter adapter;
    private List<Doc> list = new ArrayList<>();
    private FragmentActivity activity;
    private DocFragmentListener listener;

    public interface DocFragmentListener {
        void openDetailListener(Doc document);
    }

    public static DocListFragment newInstance() {

        Bundle args = new Bundle();

        DocListFragment fragment = new DocListFragment();
        fragment.setArguments(args);
        return fragment;
    }

    public DocListFragment() {
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof DocFragmentListener)
            listener = (DocFragmentListener) context;
        else
            throw new ClassCastException();
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_doc_list, viewGroup, false);
        activity = getActivity();

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.docs_list);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(activity, 2));

        adapter = new DocsAdapter(list, this);
        recyclerView.setAdapter(adapter);

        presenter = new MainPresenter();
        presenter.attachView(this);
        presenter.loadData();

        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.dettachView();
    }

    @Override
    public void updateList(List<Doc> list) {
        this.list.addAll(list);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void openDetail(Doc document) {
        listener.openDetailListener(document);
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
