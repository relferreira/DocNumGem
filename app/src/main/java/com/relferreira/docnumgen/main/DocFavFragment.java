package com.relferreira.docnumgen.main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.relferreira.docnumgen.R;


public class DocFavFragment extends Fragment implements DocTabFragment {

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

        return view;
    }
}
