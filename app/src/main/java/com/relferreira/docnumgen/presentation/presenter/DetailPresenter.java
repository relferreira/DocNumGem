package com.relferreira.docnumgen.presentation.presenter;

import android.app.PendingIntent;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.widget.RemoteViews;

import com.relferreira.docnumgen.R;
import com.relferreira.docnumgen.presentation.base.BasePresenter;
import com.relferreira.docnumgen.presentation.view.DetailView;
import com.relferreira.docnumgen.presentation.service.DocNotificationService;
import com.relferreira.docnumgen.factories.GeneratorFactory;
import com.relferreira.docnumgen.model.Doc;
import com.relferreira.docnumgen.data.entity.DocRealm;

import io.realm.Realm;

/**
 * Created by renan on 28/01/2016.
 */
public class DetailPresenter extends BasePresenter<DetailView> {

    public static String DOCNUMGEM_CLIPART = "docnumgem_copy";
    public static int PENDING_INTENT_REQUEST_CODE = 100;

    public String generateDocument(Doc document) {
        return GeneratorFactory.generate(document).generateDoc();
    }

    public void getResult(Doc document) {
        if (isViewAttached())
            getView().displayResult(generateDocument(document));
    }

    public void favoriteDocument(Doc document) {
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        realm.copyToRealm(new DocRealm(document.getId(), document.getName()));
        realm.commitTransaction();
        if (isViewAttached())
            getView().notifyDocumentFavorited();
    }


    public void copyToClipBoard(Context context, String documentText) {
        ClipboardManager clipboard = (ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
        ClipData clip = ClipData.newPlainText(DOCNUMGEM_CLIPART, documentText);
        clipboard.setPrimaryClip(clip);
        if (isViewAttached())
            getView().notifyCopy();
    }

    public NotificationCompat.Builder constructNotification(Context context, Doc document, String documentText) {
        Intent intent = new Intent(context, DocNotificationService.class);
        intent.putExtra(DocNotificationService.ARG_DOC, document);
        PendingIntent pendingIntent = PendingIntent.getService(context, PENDING_INTENT_REQUEST_CODE, intent, PendingIntent.FLAG_UPDATE_CURRENT);

        RemoteViews contentView = new RemoteViews(context.getPackageName(), R.layout.notification_doc);
        contentView.setTextViewText(R.id.notification_title, document.getName());
        contentView.setTextViewText(R.id.notification_subTitle, documentText);
        contentView.setOnClickPendingIntent(R.id.notification_refresh, pendingIntent);

        return new NotificationCompat.Builder(context)
                .setContent(contentView)
                .setSmallIcon(R.drawable.menu_notification);
    }

}
