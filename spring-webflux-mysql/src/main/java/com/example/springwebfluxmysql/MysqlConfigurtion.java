package com.example.springwebfluxmysql;

import com.github.jasync.r2dbc.mysql.JasyncConnectionFactory;
import com.github.jasync.sql.db.mysql.pool.MySQLConnectionFactory;
import com.github.jasync.sql.db.mysql.util.URLParser;
import io.r2dbc.spi.ConnectionFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.r2dbc.config.AbstractR2dbcConfiguration;

import java.nio.charset.StandardCharsets;

@Configuration
public class MysqlConfigurtion extends AbstractR2dbcConfiguration {
    @Override
    public ConnectionFactory connectionFactory() {
        String url ="mysql://root:123456@127.0.0.1:3306/test";
        return new JasyncConnectionFactory(new MySQLConnectionFactory(URLParser.INSTANCE.parseOrDie(url, StandardCharsets.UTF_8)));
    }
}
