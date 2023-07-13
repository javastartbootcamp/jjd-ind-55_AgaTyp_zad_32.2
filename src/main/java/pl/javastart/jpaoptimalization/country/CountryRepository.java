package pl.javastart.jpaoptimalization.country;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CountryRepository extends JpaRepository<Country, String> {

    @Query("SELECT c.name as countryName, i.name as cityName, i.population as cityPopulation FROM Country c " +
            "LEFT JOIN c.cities i WHERE i.population is null OR i.population = (SELECT MAX(i2.population) FROM City i2 WHERE i2.country = c) " +
            "ORDER BY c.name asc")
    List<CountryWithBiggestCity> findAllWithBiggestCity();

    @Query("select c.name as countryName, listagg(cl.language, cl.percentage) as languages " +
            "from Country c " +
            "left join CountryLanguage cl on cl.countryCode=c.code " +
            "group by c.name " +
            "order by c.name")
    List<CountryWithLanguages> findAllWithLanguages();

}
