package pl.javastart.jpaoptimalization;

import org.hibernate.dialect.MySQLDialect;
import org.hibernate.dialect.function.SQLFunctionTemplate;
import org.hibernate.type.StandardBasicTypes;

public class CustomMySQLDialect extends MySQLDialect {
    public CustomMySQLDialect() {
        super();
        registerFunction("LISTAGG", new SQLFunctionTemplate(StandardBasicTypes.STRING,
                "LISTAGG(concat(?1, ' ', ?2, '%'),', ') WITHIN GROUP(ORDER BY ?2 desc)"));
        registerFunction("STRING_AGG", new SQLFunctionTemplate(StandardBasicTypes.STRING,
                "STRING_AGG(?1,', ') WITHIN GROUP(ORDER BY ?1 asc)"));

    }
}
