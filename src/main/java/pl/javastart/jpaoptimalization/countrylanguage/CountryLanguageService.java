package pl.javastart.jpaoptimalization.countrylanguage;

import org.springframework.stereotype.Service;
import pl.javastart.jpaoptimalization.country.CountryWithLanguages;

import java.util.List;

@Service
public class CountryLanguageService {

    private final CountryLanguageRepository countryLanguageRepository;

    public CountryLanguageService(CountryLanguageRepository countryLanguageRepository) {
        this.countryLanguageRepository = countryLanguageRepository;
    }

    public List<CountryLanguage> findAll() {
        return countryLanguageRepository.findAll();
    }
    public List<CountryLanguagesWithCountry> findAllWithCountries() {
        List<CountryLanguagesWithCountry> allWithCountries = countryLanguageRepository.findAllWithCountries();
        return allWithCountries;
    }
}
