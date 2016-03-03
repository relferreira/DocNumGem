package com.relferreira.docnumgen.main;

import com.relferreira.docnumgen.base.BaseView;
import com.relferreira.docnumgen.model.Doc;

import java.util.List;

/**
 * Created by renan on 03/03/2016.
 */
public interface FavView extends BaseView {

    void showFavorites(List<Doc> docList);
}
