package br.com.lab.security;

import br.com.lab.domain.model.Usuario;
import br.com.lab.repository.GrupoRepository;
import br.com.lab.repository.UsuarioRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import java.util.*;
import static java.util.Optional.ofNullable;

@Component
public class UsuarioSecurityService implements UserDetailsService {

    private final UsuarioRepository usuarioRepository;
    private final GrupoRepository grupoRepository;

    public UsuarioSecurityService(UsuarioRepository usuarioRepository, GrupoRepository grupoRepository){
        this.usuarioRepository = usuarioRepository;
        this.grupoRepository = grupoRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String usuarioStr){

        var usuario = ofNullable(usuarioRepository.logar(usuarioStr)).orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado"));
        var authorities = permissoesPorGrupos(usuario);

        return new User(usuario.getLogin(), usuario.getSenha(),  authorities);
    }

    private Set<GrantedAuthority> permissoesPorGrupos(Usuario usuario){

        var grupos = grupoRepository.recuperaGruposPorUsuario(usuario.getId());
        var permissoesPorGrupo = new HashSet<GrantedAuthority>();

        grupos.forEach(grupo -> permissoesPorGrupo.add(new SimpleGrantedAuthority("ROLE_"+ grupo.getNome())));
        return permissoesPorGrupo;
    }
}