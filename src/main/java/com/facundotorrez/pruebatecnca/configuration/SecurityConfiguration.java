package com.facundotorrez.pruebatecnca.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.facundotorrez.pruebatecnca.services.UsuarioService;



@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled=true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	
	private UsuarioService userService;
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userService).passwordEncoder(new BCryptPasswordEncoder());
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/css/*","/webfonts/*", "/js/*","/vendor/bootstrap/css/*", "/vendor/jquery/*", "/vendor/bootstrap/js/*").permitAll()

				.antMatchers("/conductores","/conductores/*").authenticated() //TIENE QUE ESTAR EL USER LOGUEADO
	            .antMatchers("/inspectores","/inspectores/*").authenticated()
	            .antMatchers("/vehiculos","/vehiculos/*").authenticated()
	            .antMatchers("/inspecciones","/inspecciones/*").authenticated()
	            .antMatchers("/usuarios","/usuarios/*").permitAll()
				.antMatchers("/").authenticated()
				
				.anyRequest().authenticated() 
			
			.and()
				.formLogin().loginPage("/login").loginProcessingUrl("/loginprocess")
				.usernameParameter("nombreUsuario").passwordParameter("password")
				.defaultSuccessUrl("/loginsuccess").permitAll()
			.and()
				.logout().logoutUrl("/logout").logoutSuccessUrl("/logout").permitAll();
	}
	
	public BCryptPasswordEncoder passwordEncoder() {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(4);
		return bCryptPasswordEncoder;
	}
	
}
