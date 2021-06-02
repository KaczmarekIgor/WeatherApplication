package pl.weatherapp.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.weatherapp.model.Current;
import pl.weatherapp.service.WeatherService;


@Controller
public class WeatherController {

    private WeatherService weatherService;

    @Autowired
    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping
    public Current getDataAboutWeather(@RequestParam String city) {
        return weatherService.dataAboutWeather(city);
    }

    @GetMapping("/")
    public String viewData(Model model, String city) {
        model.addAttribute("request", getDataAboutWeather(city));
        return "view";
    }


}


