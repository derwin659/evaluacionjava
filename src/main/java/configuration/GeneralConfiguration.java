
package configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import repository.UserRepository;

@EnableWebMvc
@Configuration
@EnableAutoConfiguration(
        exclude = {DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class}
)
@EnableTransactionManagement
@PropertySource({"classpath:application.properties"})
@EnableJpaRepositories({"com.repository.*"})
@ComponentScan
public class GeneralConfiguration {
    private UserRepository userRepository;
    @Value("${spring.datasource.driver-class-name}")
    public String driver;
    @Value("${spring.datasource.url}")
    public String url;
    @Value("${spring.datasource.username}")
    public String username;
    @Value("${spring.datasource.password}")
    public String password;
    @Value("${spring.jpa.properties.hibernate.dialect}")
    public String dialect;
    @Value("${spring.jpa.hibernate.ddl-auto}")
    public String ddl;

    public GeneralConfiguration(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Bean(
            name = {"dataSource"}
    )
    public DriverManagerDataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(this.driver);
        dataSource.setUrl(this.url);
        dataSource.setUsername(this.username);
        dataSource.setPassword(this.password);
        return dataSource;
    }
}
