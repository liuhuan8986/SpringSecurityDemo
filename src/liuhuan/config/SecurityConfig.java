package liuhuan.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		auth.inMemoryAuthentication()
		.withUser("user").password("123456").roles("USER").and()
		.withUser("admin").password("123456").roles("USER","ADMIN").and()
		.withUser("dba").password("123456").roles("DBA","ADMIN");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers("/admin/**").access("hasRole('ADMIN1')")
			.antMatchers("/db/**").access("hasRole('ADMIN') and hasRole('DBA')")
			.antMatchers("/", "/home").permitAll()
			.and()
			.formLogin()
			.loginPage("/mylogin")
			.failureUrl("/login_fail")
			.usernameParameter("ssoId").passwordParameter("password")
			.and().exceptionHandling().accessDeniedPage("/Access_Denied");
	}
}
