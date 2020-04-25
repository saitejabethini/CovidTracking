package com.saitejabethini.CovidTracking;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLOutput;

@RestController
public class CovidRest {
    CovidModel covidModel = new CovidModel();

    @GetMapping(value="/",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CovidModel> getCovidModel(){
CovidRest covidRest = new CovidRest();

        covidModel.setJanavg(covidRest.averageofjan());
//        covidModel.setFebavg(covidRest.averageoffeb());
//        covidModel.setMaravg(covidRest.averageofmar());
//        covidModel.setApravg(covidRest.averageofapr());
//        covidModel.setAprilX(covidRest.averageofaprX());
//        covidModel.setMayavg(covidRest.averageofmay());
//        covidModel.setMayX(covidRest.averageofmayX());
        return new ResponseEntity<CovidModel>(covidModel, HttpStatus.ACCEPTED);
//        return 10;
    }

    public int averageofjan(){
       CovidData covidData = new CovidData();
        covidData.getCovid();
        int last_date = covidData.dateCollected.indexOf("1/31");
        System.out.println("Jan end: "+last_date);
        int totaltestofjan = 0;
        for(int i=0;i<=last_date;i++){
            totaltestofjan = totaltestofjan + covidData.dailyTotal.get(i);
        }
        System.out.println(totaltestofjan/(last_date+1));
        return totaltestofjan/(last_date+1);
    }
    public int averageoffeb(){
        CovidData covidData = new CovidData();
        covidData.getCovid();
        System.out.println(covidData.dailyTotal.size());

        int start_date = covidData.dateCollected.indexOf("2/1");
        int end_date = covidData.dateCollected.indexOf("2/29");
        System.out.println("feb: "+start_date);
        System.out.println("feb: "+end_date);
        int totaltestoffeb = 0;
        for(int i=start_date;i<end_date;i++){

            System.out.println(covidData.dailyTotal.get(i));

            totaltestoffeb = totaltestoffeb + covidData.dailyTotal.get(i); }


        System.out.println(totaltestoffeb/(end_date-start_date));
        return totaltestoffeb/(end_date-start_date);
    }
    public int averageofmar(){
        CovidData covidData = new CovidData();
        covidData.getCovid();
        int start_date = covidData.dateCollected.indexOf("3/1");
        int end_date = covidData.dateCollected.indexOf("3/31");
        System.out.println("mar: "+start_date);
        System.out.println("mar: "+end_date);
        int totaltestofmar = 0;
        for(int i=start_date;i<=end_date;i++){
            totaltestofmar = totaltestofmar + covidData.dailyTotal.get(i);
        }
        System.out.println(totaltestofmar/(end_date-start_date));
        return totaltestofmar/(end_date-start_date);
    }
    public int averageofapr(){
        CovidData covidData = new CovidData();
        covidData.getCovid();
        int start_date = covidData.dateCollected.indexOf("4/1");
        int end_date = covidData.dateCollected.indexOf("4/7");
        System.out.println("apr: "+start_date);
        System.out.println("apr: "+end_date);
        int totaltestofapr = 0;
        for(int i=start_date;i<=end_date;i++){
            totaltestofapr = totaltestofapr + covidData.dailyTotal.get(i);
        }
        System.out.println(totaltestofapr/(end_date-start_date));
        return totaltestofapr/(end_date-start_date);
    }
    public int averageofmay(){
        CovidData covidData = new CovidData();
        covidData.getCovid();
        int start_date = covidData.dateCollected.indexOf("5/01");
        int end_date = covidData.dateCollected.indexOf("5/31");
        if(start_date <0 || end_date < 0){
            return new CovidRest().averageofapr();
        }
        int totaltestofmay = 0;
        for(int i=start_date;i<=end_date;i++){
            totaltestofmay = totaltestofmay + covidData.dailyTotal.get(i);
        }
        System.out.println(totaltestofmay/(end_date-start_date));
        return totaltestofmay/(end_date-start_date);
    }

    public int averageofaprX(){
        CovidRest covidRest = new CovidRest();
        return covidRest.averageofapr()*10;


    }

    public int averageofmayX(){
        CovidRest covidRest = new CovidRest();
        return covidRest.averageofmay()*10;


    }





}
