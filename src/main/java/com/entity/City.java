package com.entity;

/**
 * Created by Ray on 2018/3/18 0018.
 **/
public class City {
    private Integer id;
    private String name;
    private String alias;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public City(){

    }

    public City(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }
}
