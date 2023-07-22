package com.example.demo.controller;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

@Controller
public class WeatherController  {

    @GetMapping("/Weather")
    public String WeatherView(Model model) {
        return "WeatherView";
    }

    @PostMapping("/Weather")
    public String showWeather(@RequestParam("City") String city, Model model) throws IOException, ParseException {
        String s = "http://api.weatherapi.com/v1/current.json?key=dc5a34c1a48e4929b8f95300231707&q="+city+"&aqi=no";
        URL url = new URL(s);
        BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
        JSONParser parser = new JSONParser();
        JSONObject jsonObject = (JSONObject) parser.parse(reader);
        String location = (String) ((JSONObject)jsonObject.get("location")).get("name");
        Double temp_c = (Double) ((JSONObject)jsonObject.get("current")).get("temp_c");
        if(location != null && temp_c != null){
            model.addAttribute("city", location);
            model.addAttribute("temperature", temp_c);
        }
        return "WeatherView";
    }
}
