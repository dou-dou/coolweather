package com.coolweather.app.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.Log;

import com.coolweather.app.model.City;
import com.coolweather.app.model.CoolWeatherDB;
import com.coolweather.app.model.County;
import com.coolweather.app.model.Province;

import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by doudou on 2016/2/10.
 */
public class Utility {

    public synchronized static boolean handleProvincesResponse(CoolWeatherDB coolWeatherDB,String response){
        if(!TextUtils.isEmpty(response)){
            String[] allprovince=response.split(",");
            if(allprovince!=null&&allprovince.length>0){
                for(String p:allprovince){

                    String[] array=p.split("\\|");
                    Province province=new Province();
                    province.setProvinceCode(array[0]);
                    province.setProvinceName(array[1]);

                    coolWeatherDB.saveProvince(province);

                }
                return true;
            }
        }
        return false;
    }

    public static boolean handleCitiesResponse(CoolWeatherDB coolWeatherDB,int provinceid,String response){
        if(!TextUtils.isEmpty(response)){
            String[] allcities=response.split(",");
            if(allcities!=null&&allcities.length>0){
                for(String c:allcities){
                    String[] array=c.split("\\|");
                    City city=new City();
                    city.setProvinceid(provinceid);
                    city.setCityCode(array[0]);
                    city.setCityName(array[1]);
                    coolWeatherDB.saveCity(city);
                }
                return true;
            }

        }

        return false;

    }

    public static boolean handleCountiesResponse(CoolWeatherDB coolWeatherDB,String response,int cityid){
        if(!TextUtils.isEmpty(response)){
            String[] allcounties=response.split(",");
            if(allcounties!=null&&allcounties.length>0){
                for(String c:allcounties){
                    String[] array=c.split("\\|");
                    County county=new County();
                    county.setCountyName(array[1]);
                    county.setCountyCode(array[0]);
                    county.setCityid(cityid);
                    coolWeatherDB.saveCounty(county);
                }
                return true;
            }
        }
        return false;
    }
    public static void handleWeatherResponse(Context context,String reponse){
        try{
            JSONObject jsonObject=new JSONObject(reponse);
            JSONObject weather=jsonObject.getJSONObject("weatherinfo");
            String cityName=weather.getString("city");
            String weatherCode=weather.getString("cityid");
            String temp1=weather.getString("temp1");
            String temp2=weather.getString("temp2");
            String weatherDesp=weather.getString("weather");
            String weatherTime=weather.getString("ptime");
            saveWeatherInfo(context,cityName,weatherCode,temp1,temp2,weatherDesp,weatherTime);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private static void saveWeatherInfo(Context context, String cityName, String weatherCode, String temp1, String temp2, String weatherDesp, String weatherTime) {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy年M月d日",Locale.CHINA);
        SharedPreferences.Editor editor= PreferenceManager.getDefaultSharedPreferences(context).edit();
        editor.putBoolean("city_selected",true);
        editor.putString("city_name", cityName);
        editor.putString("weather_code", weatherCode);
        editor.putString("temp1", temp1);
        editor.putString("temp2", temp2);
        editor.putString("weather_desp", weatherDesp);
        editor.putString("publish_time", weatherTime);
        editor.putString("current_date",sdf.format(new Date()));
        editor.commit();

    }

}
