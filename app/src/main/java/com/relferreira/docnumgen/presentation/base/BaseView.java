package com.relferreira.docnumgen.presentation.base;

/**
 * Created by renan on 14/01/2016.
 */
public interface BaseView {

    void showError(int status, String error);

    void showLoading(boolean refresh);

    void hideLoading();
}
