package com.bct.app.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.bct.app.security.CustomUserDetailService;
import com.bct.app.security.JwtAuthenticationEntryPoint;
import com.bct.app.security.JwtAuthenticationFilter;


@Configuration
@EnableWebSecurity
@EnableWebMvc
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter{

//	 public static final String[] PUBLIC_URLS = { "/exercise/**","/trackRecord/**", "/auth/**", "/role/**", "/workoutplan/**"
//
//	    };

	    @Autowired
	    private CustomUserDetailService customUserDetailService;

	    @Autowired
	    private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;

	    @Autowired
	    private JwtAuthenticationFilter jwtAuthenticationFilter;
		
		@Override
		protected void configure(HttpSecurity http) throws Exception {
			http.
					csrf()
					.disable()
					.authorizeHttpRequests()
//					.antMatchers(PUBLIC_URLS)
					.antMatchers("/auth/login","/user/register").permitAll()
//					.antMatchers(HttpMethod.GET).permitAll()
//					.antMatchers()
//					.permitAll()
//					.antMatchers(HttpMethod.GET)
					.anyRequest()
//					.permitAll()
//					.anyRequest()
					.authenticated()
					.and().exceptionHandling()
					.authenticationEntryPoint(this.jwtAuthenticationEntryPoint)
					.and()
					.sessionManagement()
					.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
			http.addFilterBefore(this.jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
//			http.authenticationProvider(daoAuthenticationProvider());
		}
		 
		
	    @Override
	    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	        auth.userDetailsService(this.customUserDetailService).passwordEncoder(passwordEncoder());
	    }


	    @Bean
	    public PasswordEncoder passwordEncoder() {
	        return new BCryptPasswordEncoder();
	    }

	    @Bean
	    public AuthenticationManager authenticationManagerBean(AuthenticationConfiguration configuration) throws Exception {
	        return configuration.getAuthenticationManager();
	    }
	    
//	    @Bean
//	    public DaoAuthenticationProvider daoAuthenticationProvider() {
//
//	        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
//	        provider.setUserDetailsService(this.customUserDetailService);
//	        provider.setPasswordEncoder(passwordEncoder());
//	        return provider;
//
//	    }
}
