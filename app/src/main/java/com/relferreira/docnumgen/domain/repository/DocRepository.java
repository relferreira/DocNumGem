package com.relferreira.docnumgen.domain.repository;

import com.relferreira.docnumgen.data.entity.DocRealm;

import java.util.List;

import io.realm.RealmResults;
import rx.Observable;

/**
 * Created by renan on 03/03/2016.
 */
public interface DocRepository {

    Observable<RealmResults<DocRealm>> listDocs();
}
