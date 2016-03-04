package com.relferreira.docnumgen.presentation.view;

import com.relferreira.docnumgen.presentation.base.BaseView;
import com.relferreira.docnumgen.model.Doc;

import java.util.List;

/**
 * Created by renan on 14/01/2016.
 */
public interface MainView extends BaseView {

    void updateList(List<Doc> list);

    void openDetail(Doc document);

}
