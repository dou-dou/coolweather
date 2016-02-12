package com.coolweather.app.model;

/**
 * Created by doudou on 2016/2/10.
 */
public class County {
    private int id ;
    private String countyName;
    private String countyCode;
    private int cityid;
    public int getId() {
        return id;
    }

    public void setId(int id ){
        this.id=id;
    }

    public String getCountyCode() {
        return countyCode;
    }

    public void setCountyCode(String countyCode) {
        this.countyCode = countyCode;
    }

    public String getCountyName() {
        return countyName;
    }

    public void setCountyName(String countyName) {
        this.countyName = countyName;
    }

    public int getCityid() {
        return cityid;
    }

    public void setCityid(int cityid) {
        this.cityid = cityid;
    }
}
