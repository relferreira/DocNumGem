package com.relferreira.docnumgen.presentation.presenter;

import com.relferreira.docnumgen.presentation.base.BasePresenter;
import com.relferreira.docnumgen.model.Doc;
import com.relferreira.docnumgen.presentation.view.MainView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by renan on 14/01/2016.
 */
public class MainPresenter extends BasePresenter<MainView> {

    public void loadData() {
        List<Doc> list = new ArrayList<>();
        list.add(new Doc("CPF", 1));
        list.add(new Doc("CNPJ", 1));

        if (isViewAttached())
            getView().updateList(list);
    }

}
