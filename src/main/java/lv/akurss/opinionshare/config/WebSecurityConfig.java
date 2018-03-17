package lv.akurss.opinionshare.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
				.authorizeRequests()
					.antMatchers("/login").permitAll()
					.anyRequest().authenticated()
					.and()
				.formLogin()
					.loginPage("/login.html")
					.loginProcessingUrl("/login")
					.defaultSuccessUrl("/")
					.permitAll()
					.and()
				.logout()
					.permitAll()
				.and()
					.csrf().disable();
	}
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
		auth.inMemoryAuthentication()
				.withUser("test").password("test").roles("USER").and()
				.withUser("admin").password("admin").roles("ADMIN");
	}

}
