package br.com.lab.security;

import br.com.lab.domain.model.Grupo;
import br.com.lab.exceptionhandler.AcessoNegadoEntryPoint;
import br.com.lab.model.PermissaoModel;
import br.com.lab.repository.PermissaoRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final UsuarioSecurityService usuarioSecurityService;
    private final PermissaoRepository permissaoRepository;

    public SecurityConfig(UsuarioSecurityService usuarioSecurityService, PermissaoRepository permissaoRepository){
        this.usuarioSecurityService = usuarioSecurityService;
        this.permissaoRepository = permissaoRepository;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf().disable();
        http.authorizeRequests().antMatchers("/v2/api-docs", "/configuration/ui", "/swagger-resources/**","/configuration/security", "/swagger-ui.html","/webjars/**").permitAll();

        var grupos = permissaoRepository.recupera(Grupo.class);

        for(Grupo umGrupo: grupos){ //forEach não lança exception, por isso não usei
            var permissoes = permissaoRepository.recuperaPermissoesPorGrupo(umGrupo.getId());
            for (PermissaoModel umaPermissaoModel : permissoes) {
                http.authorizeRequests().antMatchers(umaPermissaoModel.getUrl()).hasAnyRole(umGrupo.getNome());
            }
        }
        http.authorizeRequests()
                .anyRequest()
                .authenticated()
                .and()
                .exceptionHandling().authenticationEntryPoint(authenticationEntryPoint()).and()
                .addFilter(new AutenticadorFilter(authenticationManager()))
                .addFilter(new AutorizadorFilter(authenticationManager(), usuarioSecurityService));

    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(usuarioSecurityService).passwordEncoder(new BCryptPasswordEncoder());
    }

    @Bean
    public AuthenticationEntryPoint authenticationEntryPoint(){
        return new AcessoNegadoEntryPoint();
    }

}
