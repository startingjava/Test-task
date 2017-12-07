package ua.oleg.romanyuta.spring.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import ua.oleg.romanyuta.dao.AccountRepository;
import ua.oleg.romanyuta.domain.Account;


@SpringBootApplication(scanBasePackages = {"ua.oleg.romanyuta.api"})
@EnableJpaRepositories(basePackages = "ua.oleg.romanyuta.dao")
@EntityScan("ua.oleg.romanyuta.domain")
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }


    @EnableWebSecurity
    @Configuration
    public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.authorizeRequests().
                    antMatchers(HttpMethod.POST, "/**").authenticated().
                    antMatchers(HttpMethod.PUT, "/**").authenticated().
                    antMatchers(HttpMethod.DELETE, "/**").authenticated().
                    antMatchers("/**").permitAll().and().
                    httpBasic().and().
                    csrf().disable();
        }
    }

    @Configuration
    public class WebSecurityConfiguration extends GlobalAuthenticationConfigurerAdapter {

        @Autowired
        AccountRepository accountRepository;

        @Override
        public void init(AuthenticationManagerBuilder auth) throws Exception {
            auth.userDetailsService(userDetailsService());
        }

        @Bean
        UserDetailsService userDetailsService() {
            return username -> {
                Account account = accountRepository.findByUsername(username);
                if(account != null) {
                    return new User(account.getUsername(), account.getPassword(), true, true, true, true,
                            AuthorityUtils.createAuthorityList("ADMIN"));
                } else {
                    throw new UsernameNotFoundException("could not find the user '"
                            + username + "'");
                }
            };
        }
    }
}
