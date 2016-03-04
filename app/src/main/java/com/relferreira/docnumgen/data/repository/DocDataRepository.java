package com.relferreira.docnumgen.data.repository;

import com.relferreira.docnumgen.domain.repository.DocRepository;
import com.relferreira.docnumgen.data.entity.DocRealm;

import io.realm.Realm;
import io.realm.RealmResults;
import rx.Observable;

/**
 * Created by renan on 03/03/2016.
 */
public class DocDataRepository implements DocRepository {

    @Override
    public Observable<RealmResults<DocRealm>> listDocs() {
        Realm realm = Realm.getDefaultInstance();
        return realm.where(DocRealm.class)
                .findAllAsync()
                .asObservable();
    }
}
