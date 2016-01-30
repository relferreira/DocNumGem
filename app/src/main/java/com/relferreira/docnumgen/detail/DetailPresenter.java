package com.relferreira.docnumgen.detail;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;

import com.relferreira.docnumgen.base.BasePresenter;
import com.relferreira.docnumgen.factories.GeneratorFactory;
import com.relferreira.docnumgen.model.Doc;

/**
 * Created by renan on 28/01/2016.
 */
public class DetailPresenter extends BasePresenter<DetailView> {

    public void getResult(Doc document) {
        if (isViewAttached())
            getView().displayResult(GeneratorFactory.generate(document).generateDoc());
    }


    public void copyToClipBoard(Context context, String documentText) {
        ClipboardManager clipboard = (ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
        ClipData clip = ClipData.newPlainText("text", documentText);
        clipboard.setPrimaryClip(clip);
        if (isViewAttached())
            getView().notifyCopy();
    }

}
