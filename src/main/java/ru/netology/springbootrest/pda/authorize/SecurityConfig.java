package ru.netology.springbootrest.pda.authorize;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("admin").password("{noop}111").authorities("READ","WRITE","DELETE").and()
                .withUser("manager").password("{noop}222").authorities("READ","WRITE").and()
                .withUser("user").password("{noop}333").authorities("READ");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin()
                .defaultSuccessUrl("/all")
                .and().authorizeRequests().antMatchers("/user").hasAuthority("READ")
                .and().authorizeRequests().antMatchers("/admin").hasAuthority("DELETE")
                .and().authorizeRequests().antMatchers("/manager").hasAuthority("WRITE")
                .and().authorizeRequests().antMatchers("/all").permitAll()
                .and().authorizeRequests().anyRequest().authenticated()
        ;
    }
}
