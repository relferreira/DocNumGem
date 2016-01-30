package com.relferreira.docnumgen.main;

import com.relferreira.docnumgen.base.BaseView;
import com.relferreira.docnumgen.model.Doc;

import java.util.List;

/**
 * Created by renan on 14/01/2016.
 */
public interface MainView extends BaseView {

    void updateList(List<Doc> list);

    void openDetail(Doc document);

}
