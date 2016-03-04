package com.relferreira.docnumgen.presentation.view.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.relferreira.docnumgen.presentation.view.fragment.DocTabFragment;

import java.util.ArrayList;
import java.util.List;


public class TabsAdapter extends FragmentPagerAdapter {

    private List<DocTabFragment> listFragments = new ArrayList<>();
    private List<String> listFragmentsTitle = new ArrayList<>();

    public TabsAdapter(FragmentManager fm) {
        super(fm);
    }

    public void add(DocTabFragment frag, String title) {
        this.listFragments.add(frag);
        this.listFragmentsTitle.add(title);
    }

    @Override
    public Fragment getItem(int position) {
        return (Fragment) listFragments.get(position);
    }

    @Override
    public int getCount() {
        return listFragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return listFragmentsTitle.get(position);
    }
}