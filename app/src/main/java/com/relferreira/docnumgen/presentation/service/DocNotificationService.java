package com.relferreira.docnumgen.presentation.service;

import android.app.IntentService;
import android.app.NotificationManager;
import android.content.Intent;

import com.relferreira.docnumgen.model.Doc;
import com.relferreira.docnumgen.presentation.presenter.DetailPresenter;

/**
 * Created by renan on 01/02/2016.
 */
public class DocNotificationService extends IntentService {

    public static final String ARG_DOC = "argDoc";
    public static final int NOTIFICATION_ID = 100;

    private DetailPresenter presenter;

    public DocNotificationService() {
        super("Doc Notification Service");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        presenter = new DetailPresenter();
    }

    @Override
    protected void onHandleIntent(Intent intent) {

        Doc document = intent.getParcelableExtra(ARG_DOC);
        String documentText = presenter.generateDocument(document);
        presenter.copyToClipBoard(this, documentText);

        NotificationManager mNotifyMgr =
                (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        mNotifyMgr.notify(NOTIFICATION_ID, presenter.constructNotification(this, document, documentText).build());

    }
}
