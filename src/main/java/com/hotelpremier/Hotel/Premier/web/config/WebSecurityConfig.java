package com.hotelpremier.Hotel.Premier.web.config;

import com.hotelpremier.Hotel.Premier.persistence.UsuarioRepository;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.config.ldap.EmbeddedLdapServerContextSourceFactoryBean;
import org.springframework.security.config.ldap.LdapBindAuthenticationManagerFactory;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.security.web.context.SecurityContextRepository;

import javax.sql.DataSource;

import static org.springframework.security.config.Customizer.withDefaults;
@Configuration
@EnableWebSecurity
public class WebSecurityConfig{
    private SecurityContextRepository repo = new HttpSessionSecurityContextRepository();

    //Filtro de seguridad (Construyendo protección a vulnerabilidades con FormsHtml)
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http
                .authorizeHttpRequests(authorizeRequests ->
                                authorizeRequests
                                        .requestMatchers("/user").permitAll()//Aquí se ponen los endpoints a los que se pueden acceder sin autorización
                                        .anyRequest().authenticated() //Esto indica que el resto lo necesitará
                )
                .formLogin( form ->
                        form
                                .successHandler(successHandler())
                            .loginPage("/index") // Este le muestra la ruta del login (Mapping)
                             // Eso indica que cualquiera puede entrar al Login
                )
                .sessionManagement( sm ->
                        sm
                                .sessionCreationPolicy(SessionCreationPolicy.ALWAYS) //Hace que se cree una sesión siempre y cuando no exista ninguna
                                .invalidSessionUrl("/login")
                                .maximumSessions(1)
                                .expiredUrl("/login")
                )
                .securityContext(sc ->
                        sc.securityContextRepository(repo))
                .rememberMe(Customizer.withDefaults());
        return http.build();
    }
    public AuthenticationSuccessHandler successHandler(){
        //NO OLVIDAR USAR EL LoginController
        return (((request, response, authentication) -> {
            response.sendRedirect("/index");//A dónde lo va a redirigir al validar la existencia del usuario
        }));
    }

    public AuthenticationManager authenticationManager(){
        return authentication -> authentication;
    }
}
