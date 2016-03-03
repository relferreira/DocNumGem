package com.relferreira.docnumgen.model;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by renan on 03/03/2016.
 */
public class DocRealm extends RealmObject {

    @PrimaryKey
    private int id;
    private String name;

    public DocRealm() {
    }

    public DocRealm(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
