/*
 * package com.demo.Config;
 * 
 * import java.util.Arrays;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.context.annotation.Bean; import
 * org.springframework.context.annotation.Configuration; import
 * org.springframework.security.config.annotation.authentication.builders.
 * AuthenticationManagerBuilder; import
 * org.springframework.security.config.annotation.web.builders.HttpSecurity;
 * import
 * org.springframework.security.config.annotation.web.builders.WebSecurity;
 * import org.springframework.security.config.annotation.web.configuration.
 * EnableWebSecurity; import
 * org.springframework.security.config.annotation.web.configuration.
 * WebSecurityConfigurerAdapter; import
 * org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder; import
 * org.springframework.security.crypto.password.NoOpPasswordEncoder; import
 * org.springframework.security.crypto.password.PasswordEncoder; import
 * org.springframework.web.cors.CorsConfiguration; import
 * org.springframework.web.cors.CorsConfigurationSource; import
 * org.springframework.web.cors.UrlBasedCorsConfigurationSource;
 * 
 * @Configuration
 * 
 * @EnableWebSecurity public class SecurityConfig extends
 * WebSecurityConfigurerAdapter {
 * 
 * @Autowired PasswordEncoder passwordEncoder;
 * 
 * 
 * @Override protected void configure(AuthenticationManagerBuilder auth) throws
 * Exception { auth.inMemoryAuthentication() .withUser("user") .password("user")
 * .roles("USER") .and() .withUser("admin") .password("admin") .roles("ADMIN");
 * }
 * 
 * //Circular issue : Fix //Default redirection after login //Custom login page
 * integration //CSRF enable
 * 
 * @Override protected void configure(HttpSecurity http) throws Exception { http
 * .cors() .and() .authorizeRequests()
 * .antMatchers("/admin*").hasAuthority("ROLE_ADMIN") //.antMatchers("/",
 * "/hello","/loginPage").permitAll() //.anyRequest().authenticated() .and()
 * .sessionManagement() .sessionFixation() .none() .and() .formLogin()
 * .defaultSuccessUrl("/hello") .and() .logout() .deleteCookies("JSESSIONID")
 * .and() .exceptionHandling().accessDeniedPage("/accessDenied"); }
 * 
 * 
 * 
 * 
 * @Override protected void configure(HttpSecurity http) throws Exception { http
 * .authorizeRequests() .anyRequest().authenticated() .and() .formLogin() .and()
 * .httpBasic(); }
 * 
 * 
 * @Override public void configure(WebSecurity web) throws Exception{
 * web.ignoring().antMatchers("/resources/**"); }
 * 
 * @Bean public PasswordEncoder passwordEncoder() { return
 * NoOpPasswordEncoder.getInstance(); }
 * 
 * @Bean CorsConfigurationSource corsConfigurationSource() { CorsConfiguration
 * configuration = new CorsConfiguration();
 * configuration.setAllowedOrigins(Arrays.asList("http://apilayer.net/"));
 * configuration.setAllowedMethods(Arrays.asList("GET","POST"));
 * UrlBasedCorsConfigurationSource source = new
 * UrlBasedCorsConfigurationSource(); source.registerCorsConfiguration("/**",
 * configuration); return source; } }
 */