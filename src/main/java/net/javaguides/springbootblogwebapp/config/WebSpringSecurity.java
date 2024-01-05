package net.javaguides.springbootblogwebapp.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class WebSpringSecurity {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

          http.csrf().disable()
                  // code for access to any user
                 /* .authorizeHttpRequests((authorize)->
                          authorize.anyRequest().authenticated())*/

                  // Code for access based on the role
                  .authorizeHttpRequests((authorize)->
                          authorize.requestMatchers(new AntPathRequestMatcher("/admin/**"))
                                  .hasAnyRole("ADMIN"))
                  .formLogin(form -> form
                          .loginPage("/login")
                          .defaultSuccessUrl("/admin/getAllPost")
                          .loginProcessingUrl("/login")
                          .permitAll()
                  ).logout(logout -> logout.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                          .permitAll()
                          );


        return http.build();
    }
}
