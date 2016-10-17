package ru.itis.inform.dao;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import ru.itis.inform.configs.WebAppContext;

public class DaoImpl implements Dao {
    private WebAppContext webAppContext = new WebAppContext();
    private NamedParameterJdbcTemplate jdbc = new NamedParameterJdbcTemplate(webAppContext.dataSource());


}
