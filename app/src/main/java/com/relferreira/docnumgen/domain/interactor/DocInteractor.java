package com.relferreira.docnumgen.domain.interactor;

import com.relferreira.docnumgen.data.entity.DocRealm;
import com.relferreira.docnumgen.data.repository.DocDataRepository;
import com.relferreira.docnumgen.domain.repository.DocRepository;
import com.relferreira.docnumgen.model.Doc;

import java.util.ArrayList;
import java.util.List;

import io.realm.RealmResults;
import rx.Observable;

/**
 * Created by renan on 04/03/2016.
 */
public class DocInteractor implements DocInteratorInterface {

    private final DocRepository repository;

    public DocInteractor() {
        repository = new DocDataRepository();
    }

    @Override
    public Observable<List<Doc>> getFavoriteDocs() {
        return repository.listDocs()
                .filter(RealmResults::isLoaded)
                .map(docRealms -> {
                    List<Doc> docList = new ArrayList<>();
                    for (DocRealm docRealm : docRealms)
                        docList.add(new Doc(docRealm.getName(), docRealm.getId()));
                    return docList;
                });
    }
}
