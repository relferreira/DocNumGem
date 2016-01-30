package com.relferreira.docnumgen.detail;

import com.relferreira.docnumgen.base.BaseView;
import com.relferreira.docnumgen.model.Doc;

/**
 * Created by renan on 28/01/2016.
 */
public interface DetailView extends BaseView {

    void displayResult(String result);

    void notifyCopy();

}
