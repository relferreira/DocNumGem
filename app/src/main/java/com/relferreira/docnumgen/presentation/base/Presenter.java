package com.relferreira.docnumgen.presentation.base;

/**
 * Created by renan on 14/01/2016.
 */
public interface Presenter<V extends BaseView> {
    void attachView(V view);

    void dettachView();

    boolean isViewAttached();

    V getView();
}
