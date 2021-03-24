/*


package com.nineleaps.rewardandrecognition.config;

import com.nineleaps.rewardandrecognition.utils.GoogleTokenVerifier;
import org.apache.http.protocol.BasicHttpProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
@Configuration
class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    GoogleTokenVerifier googleTokenFil;
    private BasicHttpProcessor registry;

   */
/*@Override
   protected void configure(HttpSecurity http) throws Exception {
        http authorizeRequests().antMatchers("/authenticate", "/v2/api-docs",
                "/swagger-resources/**",
                "/swagger-ui.html",
                "/swagger-ui/",
                "/webjars/**").permitAll()
                .anyRequest().authenticated();
        http.addFilterBefore(googleTokenFil, UsernamePasswordAuthenticationFilter.class);
    }*//*




    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http
                .authorizeRequests()
                    .antMatchers("/**").permitAll()
                    .anyRequest().authenticated();
        http.addFilterBefore(googleTokenFil, UsernamePasswordAuthenticationFilter.class);

    }
    */
/*@Override
    protected void configure(HttpSecurity http) throws Exception {
        registry.addInterceptor(new CustomInterceptor()).addPathPatterns("/**").
                excludePathPatterns(
                        "/v2/api-docs",
                        "/swagger-resources/**",
                        "/swagger-ui.html",
                        "/webjars/**"
                );
        http.addFilterBefore(googleTokenFil, UsernamePasswordAuthenticationFilter.class);
    }*//*


    */
/*@Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
    }
    //@Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").allowedMethods("*");
    }
*//*





}
//.and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)


*/
