package com.relferreira.docnumgen.presentation.view;

import com.relferreira.docnumgen.presentation.base.BaseView;

/**
 * Created by renan on 28/01/2016.
 */
public interface DetailView extends BaseView {

    void displayResult(String result);

    void notifyCopy();

    void notifyDocumentFavorited();

}
