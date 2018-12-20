package pt.link.sc.transaction.api;


import javax.sql.DataSource;

import org.flywaydb.core.Flyway;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

@SpringBootApplication
public class TransactionApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(TransactionApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(TransactionApplication.class, args);
    }
    
    @Bean(name = "flyway")
    @Profile("!embedded")
    public Flyway flyway(DataSource dataSource) {
        Flyway f = new Flyway();
        f.setDataSource(dataSource);
        f.setSchemas("transactions");
        f.setSqlMigrationPrefix("transaction-");
        f.setSqlMigrationSeparator("-");
        f.setOutOfOrder(true);
        f.setPlaceholderReplacement(false);
        f.setBaselineOnMigrate(true);
        f.setInstalledBy("Transactions_user");
        f.setCleanDisabled(true);
        f.setIgnoreMissingMigrations(true);
        f.migrate();
        return f;
    }
}
