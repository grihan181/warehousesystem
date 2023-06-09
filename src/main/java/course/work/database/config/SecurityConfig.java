package course.work.database.config;

import course.work.database.security.jwts.JwtTokenFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig {
    @Autowired
    private AccessDeniedHandler accessDeniedHandler;
    private final JwtTokenFilter jwtFilter;
    /*
        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.cors().and()
                    .csrf().disable()
                    .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                    .and()
                    .authorizeRequests()
                    //.antMatchers("/questionnaire").permitAll()
                    .antMatchers("/api/v1/auth/**", "/").permitAll()
                    .anyRequest().authenticated()
                    .and()
                    .formLogin()
                    .loginPage("/login")
                    .failureUrl("/login-error")
                    .permitAll()
                    .and()
                    .logout()
                    .permitAll()
                    .and()
                    .apply(jwtConfigurer)
                    .and()
                    .exceptionHandling().accessDeniedHandler(accessDeniedHandler);;
        }
    */
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
                .httpBasic().disable()
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeHttpRequests(
                        authz -> {
                            try {
                                authz
                                        .antMatchers("/api/v1/auth/**", "/", "/css/**", "/webjars/**", "/logout**").permitAll()
                                        .anyRequest().authenticated()
                                        .and()
                                        .formLogin()
                                        .loginPage("/login")
                                        .defaultSuccessUrl("/product/getAll", true)
                                        //.failureUrl("/login-error")
                                        .permitAll()
                                        .and()
                                        .logout()
                                       // .logoutUrl("/logout")
                                        //.permitAll()
                                       // .logoutSuccessUrl("/login")
                                        .permitAll()
                                        .and()
                                        .exceptionHandling().accessDeniedHandler(accessDeniedHandler)
                                        .and()
                                        .addFilterAfter(jwtFilter, UsernamePasswordAuthenticationFilter.class);
                            } catch (Exception e) {
                                throw new RuntimeException(e);
                            }
                        }
                )
                .build();
    }
}