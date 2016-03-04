package com.relferreira.docnumgen.domain.interactor;

import com.relferreira.docnumgen.model.Doc;

import java.util.List;

import rx.Observable;

/**
 * Created by renan on 04/03/2016.
 */
public interface DocInteratorInterface {

    Observable<List<Doc>> getFavoriteDocs();
}
