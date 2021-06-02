package pl.weatherapp.service;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.weatherapp.model.Current;
import pl.weatherapp.model.Weather;

@Service
public class WeatherService {
    RestTemplate restTemplate;
    String API_KEY = "616661cb367648de996145940212805";
    String URL = "http://api.weatherapi.com/v1/current.json?key=" + API_KEY + "&q=";



    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }


    public Current dataAboutWeather(String city) {
        this.restTemplate = new RestTemplate();
        Weather weather = restTemplate.getForObject(URL + city, Weather.class);
        return weather.getCurrent();
    }


}
