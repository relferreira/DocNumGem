package com.relferreira.docnumgen.presentation.view;

import com.relferreira.docnumgen.presentation.base.BaseView;
import com.relferreira.docnumgen.model.Doc;

import java.util.List;

/**
 * Created by renan on 03/03/2016.
 */
public interface FavView extends BaseView {

    void showFavorites(List<Doc> docList);
}
