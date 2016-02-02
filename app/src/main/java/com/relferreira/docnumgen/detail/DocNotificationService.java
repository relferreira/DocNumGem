package com.relferreira.docnumgen.detail;

import android.app.IntentService;
import android.app.NotificationManager;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.widget.Toast;

import com.relferreira.docnumgen.R;
import com.relferreira.docnumgen.model.Doc;

/**
 * Created by renan on 01/02/2016.
 */
public class DocNotificationService extends IntentService {

    public static final String ARG_DOC = "argDoc";

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
        mNotifyMgr.notify(100, presenter.constructNotification(this, document, documentText).build());

        Toast.makeText(this, "New document number copied!", Toast.LENGTH_LONG).show();
    }
}
