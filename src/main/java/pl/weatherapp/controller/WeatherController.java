package pl.weatherapp.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.weatherapp.service.WeatherService;


@Controller
public class WeatherController {

    private WeatherService weatherService;


    @Autowired
    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping
    public String getWeatherByCity(Model model) {
        model.addAttribute("request", weatherService.dataAboutWeather("Warsaw"));
        return "view" ;
    }

    @PostMapping
    public String setCity(Model model, String city) {
            model.addAttribute("request", weatherService.dataAboutWeather(city));
            return "view";

        }
    }