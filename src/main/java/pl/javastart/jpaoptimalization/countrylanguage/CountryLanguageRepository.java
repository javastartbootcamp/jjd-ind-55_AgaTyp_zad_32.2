package pl.javastart.jpaoptimalization.countrylanguage;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.util.List;

public interface CountryLanguageRepository extends JpaRepository<CountryLanguage, CountryLanguageKey> {

    @Query("SELECT cl.language as language, string_agg(c.name) as countryNames FROM " +
            "CountryLanguage cl " +
            "join Country c on c.code=cl.countryCode " +
            "group by cl.language " +
            "order by cl.language")
    List<CountryLanguagesWithCountry> findAllWithCountries();

}
