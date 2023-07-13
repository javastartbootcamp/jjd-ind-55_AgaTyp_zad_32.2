package pl.javastart.jpaoptimalization.country;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {

    private final CountryRepository countryRepository;

    public CountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    public List<Country> findAll() {
        return countryRepository.findAll();
    }

    public List<CountryWithBiggestCity> findAllWithBiggestCity() {
        List<CountryWithBiggestCity> allWithCities = countryRepository.findAllWithBiggestCity();
        return allWithCities;
    }

    public List<CountryWithLanguages> findAllWithLanguages() {
        List<CountryWithLanguages> allWithLanguages = countryRepository.findAllWithLanguages();
        return allWithLanguages;
    }
}
