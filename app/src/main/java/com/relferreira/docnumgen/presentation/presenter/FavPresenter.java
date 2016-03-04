package com.relferreira.docnumgen.presentation.presenter;

import com.relferreira.docnumgen.presentation.base.BasePresenter;
import com.relferreira.docnumgen.domain.interactor.DocInteractor;
import com.relferreira.docnumgen.domain.interactor.DocInteratorInterface;
import com.relferreira.docnumgen.presentation.view.FavView;

import rx.android.schedulers.AndroidSchedulers;

/**
 * Created by renan on 03/03/2016.
 */
public class FavPresenter extends BasePresenter<FavView> {

    private final DocInteratorInterface interactor;

    public FavPresenter() {
        super();
        interactor = new DocInteractor();
    }

    public void loadFavorites() {
        interactor.getFavoriteDocs()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(docs -> {
                    if (isViewAttached())
                        getView().showFavorites(docs);
                });
    }

}
