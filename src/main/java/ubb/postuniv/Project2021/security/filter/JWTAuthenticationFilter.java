package ubb.postuniv.Project2021.security.filter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import ubb.postuniv.Project2021.exception.ProjectException;
import ubb.postuniv.Project2021.security.model.SecurityUser;
import ubb.postuniv.Project2021.security.model.UsernameAndPasswordAuthenticationRequest;

import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import static ubb.postuniv.Project2021.security.model.SecurityConstants.EXPIRATION_TIME;
import static ubb.postuniv.Project2021.security.model.SecurityConstants.SECRET;


public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private AuthenticationManager authenticationManager;


    public JWTAuthenticationFilter(AuthenticationManager authenticationManager) {

        this.authenticationManager = authenticationManager;

        setFilterProcessesUrl("/api/users/login");
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest req,
                                                HttpServletResponse res) throws AuthenticationException {

        try {

            UsernameAndPasswordAuthenticationRequest authenticationRequest = new ObjectMapper()
                    .readValue(req.getInputStream(), UsernameAndPasswordAuthenticationRequest.class);

            return authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            authenticationRequest.getUsername(),
                            authenticationRequest.getPassword())

            );

        } catch (IOException e) {

            throw new ProjectException("Could not authenticate user");
        }
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest req,
                                            HttpServletResponse res,
                                            FilterChain chain,
                                            Authentication auth) throws IOException {

        Collection<? extends GrantedAuthority> authorities = ((SecurityUser) auth.getPrincipal()).getAuthorities();

        SecurityUser principal = (SecurityUser) auth.getPrincipal();

        List<String> authoritiesList = authorities.stream()
                .map(Object::toString)
                .collect(Collectors.toList());

        String token = JWT.create()
                .withSubject(auth.getName())
                .withClaim("firstName", principal.getAppUser().getFirstName())
                .withClaim("lastName", principal.getAppUser().getLastName())
                .withClaim("roles", authoritiesList)
                .withExpiresAt(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .sign(Algorithm.HMAC512(SECRET.getBytes()));

        String body = principal.getUsername() + "," +
                principal.getAppUser().getFirstName() + "," +
                principal.getAppUser().getLastName() + "," + token + "," + authoritiesList;

        res.getWriter().write(body);

        res.getWriter().flush();
    }
}

