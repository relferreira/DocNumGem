package com.relferreira.docnumgen.main;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.relferreira.docnumgen.R;
import com.relferreira.docnumgen.detail.DetailActivity;
import com.relferreira.docnumgen.model.Doc;

public class MainActivity extends AppCompatActivity implements DocListFragment.DocFragmentListener {


    private Resources resources;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        resources = getResources();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        TabsAdapter adapter = new TabsAdapter(getSupportFragmentManager());
        adapter.add(DocListFragment.newInstance(), resources.getString(R.string.main_tab_list));
        adapter.add(DocFavFragment.newInstance(), resources.getString(R.string.main_tab_fav));

        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPager.setAdapter(adapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void openDetailListener(Doc document) {
        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra(DetailActivity.ARG_DOC, document);
        startActivity(intent);
    }
}
