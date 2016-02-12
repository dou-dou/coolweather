package com.coolweather.app.model;

/**
 * Created by doudou on 2016/2/10.
 */
public class City {
    private int id ;
    private String cityName;
    private String cityCode;
    private int provinceid;
    public int getId() {
        return id;
    }

    public void setId(int id ){
        this.id=id;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public int getProvinceid() {
        return provinceid;
    }

    public void setProvinceid(int provinceid) {
        this.provinceid = provinceid;
    }
}
