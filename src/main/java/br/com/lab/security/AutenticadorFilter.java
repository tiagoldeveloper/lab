package br.com.lab.security;

import br.com.lab.exception.LabBaseException;
import com.google.gson.Gson;
import io.jsonwebtoken.Jwts;
import org.springframework.security.core.userdetails.User;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import static br.com.lab.security.SecurityConstantes.*;

public class AutenticadorFilter extends UsernamePasswordAuthenticationFilter {

    private final AuthenticationManager authenticationManager;

    public AutenticadorFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response){
        try {
            var reader = new InputStreamReader(request.getInputStream(), StandardCharsets.UTF_8);
            var user = new Gson().fromJson(reader, User.class);
            return this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
        } catch (Exception e) {
            throw new LabBaseException(e);
        }
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response,
                                            FilterChain chain, Authentication authResult) throws IOException {
        var username = ((User) authResult.getPrincipal()).getUsername();
        var token = Jwts.builder().setSubject(username)
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS512, SECRET).compact();

        var bearerToken = TOKEN_PREFIX + token;
        response.getWriter().write(bearerToken);
        response.addHeader(HEADER_STRING, bearerToken);
    }
}