package pl.javastart.jpaoptimalization;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.javastart.jpaoptimalization.country.Country;
import pl.javastart.jpaoptimalization.country.CountryService;
import pl.javastart.jpaoptimalization.country.CountryWithBiggestCity;
import pl.javastart.jpaoptimalization.country.CountryWithLanguages;
import pl.javastart.jpaoptimalization.countrylanguage.CountryLanguage;
import pl.javastart.jpaoptimalization.countrylanguage.CountryLanguageService;
import pl.javastart.jpaoptimalization.countrylanguage.CountryLanguagesWithCountry;

import java.util.List;

@Controller
public class MainController {

    private final CountryService countryService;
    private final CountryLanguageService countryLanguageService;

    public MainController(CountryService countryService,
                          CountryLanguageService countryLanguageService) {
        this.countryService = countryService;
        this.countryLanguageService = countryLanguageService;
    }

    @GetMapping("/najwieksze-miasta")
    public String countryWithBiggestCity(Model model) {
//        List<Country> countries = countryService.findAll();
        List<CountryWithBiggestCity> countries = countryService.findAllWithBiggestCity();
        model.addAttribute("countries", countries);

        return "countryWithBiggestCity";
    }

    @GetMapping("/kraje-i-jezyki")
    public String countryWithLanguages(Model model) {
//        List<Country> countries = countryService.findAll();
        List<CountryWithLanguages> countries = countryService.findAllWithLanguages();

        model.addAttribute("countries", countries);

        return "countryWithLanguages";
    }

    @GetMapping("/jezyki-i-kraje")
    public String languagesWithCountries(Model model) {
//        List<CountryLanguage> languages = countryLanguageService.findAll();
        List<CountryLanguagesWithCountry> languages = countryLanguageService.findAllWithCountries();

        model.addAttribute("languages", languages);

        return "languagesWithCountries";
    }

}
