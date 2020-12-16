package br.com.lab.security;

import br.com.lab.exception.LabBaseException;
import br.com.lab.util.LabUtil;
import io.jsonwebtoken.Jwts;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import static br.com.lab.security.SecurityConstantes.*;

public class AutorizadorFilter extends BasicAuthenticationFilter {

    private final UsuarioSecurityService usuarioService;

    public AutorizadorFilter(AuthenticationManager authenticationManager, UsuarioSecurityService usuarioService) {
        super(authenticationManager);
        this.usuarioService = usuarioService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain chain) throws IOException, ServletException {

        var header = request.getHeader(HEADER_STRING);
        if (header == null || !header.startsWith(TOKEN_PREFIX)) {
            chain.doFilter(request, response);
            return;
        }
        var authenticationToken = getAuthenticationToken(request);
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        chain.doFilter(request, response);
    }

    private UsernamePasswordAuthenticationToken getAuthenticationToken(HttpServletRequest request) {
        try {
            var token = request.getHeader(HEADER_STRING);

            if (LabUtil.isBlank(token)) {return null;}

            var username = Jwts.parser().setSigningKey(SECRET)
                    .parseClaimsJws(token.replace(TOKEN_PREFIX, ""))
                    .getBody()
                    .getSubject();

            var userDetails = usuarioService.loadUserByUsername(username);

            return LabUtil.isNotBlank(username) ?
                    new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities()) : null;
        }catch (Exception ex){
            throw new LabBaseException(ex);
        }
    }
}