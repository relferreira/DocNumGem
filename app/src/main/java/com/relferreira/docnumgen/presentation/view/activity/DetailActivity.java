package com.relferreira.docnumgen.presentation.view.activity;

import android.app.NotificationManager;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.relferreira.docnumgen.R;
import com.relferreira.docnumgen.presentation.presenter.DetailPresenter;
import com.relferreira.docnumgen.presentation.view.DetailView;
import com.relferreira.docnumgen.model.Doc;

/**
 * Created by renan on 27/01/2016.
 */
public class DetailActivity extends AppCompatActivity implements DetailView {

    public static final String ARG_DOC = "argDoc";

    private TextView resultText;
    private DetailPresenter presenter;
    private Doc document;
    private CoordinatorLayout coordinatorLayout;
    private String documentText;
    private Resources resources;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        resources = getResources();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeButtonEnabled(true);
        }

        coordinatorLayout = (CoordinatorLayout) findViewById(R.id.coordinatorLayout);
        Button refreshButton = (Button) findViewById(R.id.detail_refresh);
        Button copyButton = (Button) findViewById(R.id.detail_copy);
        refreshButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.getResult(document);
            }
        });


        copyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.copyToClipBoard(DetailActivity.this, documentText);
            }
        });


        resultText = (TextView) findViewById(R.id.detail_value);

        document = getIntent().getParcelableExtra(ARG_DOC);

        presenter = new DetailPresenter();
        presenter.attachView(this);
        presenter.getResult(document);

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.dettachView();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_detail, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            case R.id.menu_pin:
                showNotification();
                return true;
            case R.id.menu_favorite:
                favoriteDoc();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void displayResult(String result) {
        documentText = result;
        resultText.setText(result);
    }

    @Override
    public void notifyCopy() {
        Snackbar.make(coordinatorLayout, resources.getString(R.string.detail_doc_copied), Snackbar.LENGTH_SHORT).show();
    }

    @Override
    public void notifyDocumentFavorited() {
        Snackbar.make(coordinatorLayout, resources.getString(R.string.detail_doc_favorited), Snackbar.LENGTH_SHORT).show();
    }

    @Override
    public void showError(int status, String error) {

    }

    @Override
    public void showLoading(boolean refresh) {

    }

    @Override
    public void hideLoading() {

    }

    private void favoriteDoc() {
        presenter.favoriteDocument(document);
    }

    private void showNotification() {
        NotificationManager mNotifyMgr =
                (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        mNotifyMgr.notify(100, presenter.constructNotification(this, document, documentText).build());
    }
}
