package pl.weatherapp.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.weatherapp.model.Current;
import pl.weatherapp.service.WeatherService;


@Controller
public class WeatherController {
    private WeatherService weatherService;

    @Autowired
    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/weather")
    public Current getDataAboutWeather(@RequestParam String city) {
        return weatherService.dataAboutWeather(city);
    }


    @GetMapping("/view")
    public String getWeather(Model model, String city) {
        model.addAttribute("weatherData", getDataAboutWeather(city));
        return "view";
    }




}
