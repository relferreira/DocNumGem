package com.relferreira.docnumgen.main;

import com.relferreira.docnumgen.base.BasePresenter;
import com.relferreira.docnumgen.model.Doc;
import com.relferreira.docnumgen.model.DocRealm;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;

/**
 * Created by renan on 03/03/2016.
 */
public class FavPresenter extends BasePresenter<FavView> {

    public void loadFavorites() {
        Realm realm = Realm.getDefaultInstance();
        realm.where(DocRealm.class)
                .findAllAsync()
                .asObservable()
                .filter(RealmResults::isLoaded)
                .map(docRealms -> {
                    List<Doc> docList = new ArrayList<>();
                    for (DocRealm docRealm : docRealms)
                        docList.add(new Doc(docRealm.getName(), docRealm.getId()));
                    return docList;
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(docs -> {
                    if (isViewAttached())
                        getView().showFavorites(docs);
                });
    }

}
