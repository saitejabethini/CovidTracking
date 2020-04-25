package com.saitejabethini.CovidTracking;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;


public class CovidData {
    public List<Integer> usPubHealthLabs = new ArrayList<>();
    public List<Integer> dailyTotal = new ArrayList<>();
    public List<Integer> cdcLabs = new ArrayList<>();
     public List<String> dateCollected = new ArrayList<>();
//    public static void main(String[] args) {
//        CovidData covidData = new CovidData();
//        covidData.getCovid();
//    }

    public void  getCovid(){
        final String url = "http://covidtracking.com/api/cdc/daily";
        RestTemplate restTemplate = new RestTemplate();


          String str = restTemplate.getForObject(url, String.class);

        JSONArray jsonArray = new JSONArray(str);
        for (int i=0;i<jsonArray.length();i++){
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            usPubHealthLabs.add(jsonObject.getInt("usPubHealthLabs"));
            dailyTotal.add(jsonObject.getInt("dailyTotal"));
            cdcLabs.add(jsonObject.getInt("cdcLabs"));
            dateCollected.add(jsonObject.getString("dateCollected"));
        }





    }
}
