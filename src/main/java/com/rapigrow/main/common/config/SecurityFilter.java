package com.rapigrow.main.common.config;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseToken;
import com.rapigrow.main.common.exceptions.RapiGrowRuntimeException;
import com.rapigrow.main.common.services.CookieService;
import com.rapigrow.main.common.services.SecurityHelperService;
import com.rapigrow.main.auth.models.User;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
@Slf4j
public class SecurityFilter extends OncePerRequestFilter {
    @Autowired
    private SecurityHelperService securityService;

    @Autowired
    private CookieService cookieUtils;

    @Autowired
    private SecurityProperties securityProps;
    @Autowired
    private FirebaseAuth firebaseAuth;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try {
            authorize(request);
        } catch (FirebaseAuthException e) {
            throw new RuntimeException(e);
        }
        filterChain.doFilter(request, response);
    }

    private void authorize(HttpServletRequest request) throws FirebaseAuthException {
        String sessionCookieValue = null;
        FirebaseToken decodedToken = null;
        Credentials.CredentialType type = null;
        // Token verification
        boolean strictServerSessionEnabled = securityProps.getFirebaseProps().isEnableStrictServerSession();
        Cookie sessionCookie = cookieUtils.getCookie("session");
        String token = securityService.getBearerToken(request);
        try {
            if (sessionCookie != null) {
                sessionCookieValue = sessionCookie.getValue();
                decodedToken = firebaseAuth.verifySessionCookie(sessionCookieValue, securityProps.getFirebaseProps().isEnableCheckSessionRevoked());
                type = Credentials.CredentialType.SESSION;
            } else if (!strictServerSessionEnabled && token != null && !token.equals("null") && !token.equalsIgnoreCase("undefined")) {
                decodedToken = firebaseAuth.verifyIdToken(token);
                type = Credentials.CredentialType.ID_TOKEN;
            }
        } catch (FirebaseAuthException e) {
//            log.error("Firebase Exception:: ", e.getLocalizedMessage());
            throw e;
        }
        List<GrantedAuthority> authorities = new ArrayList<>();
        User user = firebaseTokenToUserDto(decodedToken);
        // Handle roles
        if (user != null) {
            // Handle Super Role
//            if (securityProps.getSuperAdmins().contains(user.getEmail())) {
//                if (!decodedToken.getClaims().containsKey(RoleConstants.ROLE_SUPER)) {
//                    try {
//                        securityRoleService.addRole(decodedToken.getUid(), RoleConstants.ROLE_SUPER);
//                    } catch (Exception e) {
//                        log.error("Super Role registeration expcetion ", e);
//                    }
//                }
//                authorities.add(new SimpleGrantedAuthority("SUPER"));
//            }
            // Handle Other roles
            decodedToken.getClaims().forEach((k, v) -> authorities.add(new SimpleGrantedAuthority(k)));
            // Set security context
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(user, new Credentials(type, decodedToken, token, sessionCookieValue), authorities);
            authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }
    }

    private User firebaseTokenToUserDto(FirebaseToken decodedToken) {
        User user = null;
        if (decodedToken != null) {
            user = new User();
            user.setUid(decodedToken.getUid());
            user.setName(decodedToken.getName());
            user.setEmail(decodedToken.getEmail());
            user.setPicture(decodedToken.getPicture());
            user.setIssuer(decodedToken.getIssuer());
            user.setEmailVerified(decodedToken.isEmailVerified());
        }
        return user;
    }
//    @Override
//    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
//        verifyToken(request);
//        filterChain.doFilter(request, response);
//    }
//
//    private void verifyToken(HttpServletRequest request) {
//        String session = null;
//        FirebaseToken decodedToken = null;
//        Credentials.CredentialType type = null;
//        boolean strictServerSessionEnabled = securityProps.getFirebaseProps().isEnableStrictServerSession();
//        Cookie sessionCookie = cookieUtils.getCookie("session");
//        String token = securityService.getBearerToken(request);
//        logger.info(token);
//        try {
//            if (sessionCookie != null) {
//                session = sessionCookie.getValue();
//                decodedToken = FirebaseAuth.getInstance().verifySessionCookie(session,
//                        securityProps.getFirebaseProps().isEnableCheckSessionRevoked());
//                type = Credentials.CredentialType.SESSION;
//            } else if (!strictServerSessionEnabled) {
//                if (token != null && !token.equalsIgnoreCase("undefined")) {
//                    decodedToken = FirebaseAuth.getInstance().verifyIdToken(token);
//                    type = Credentials.CredentialType.ID_TOKEN;
//                }
//            }
//        } catch (FirebaseAuthException e) {
//            e.printStackTrace();
//            log.error("Firebase Exception:: ", e.getLocalizedMessage());
//        }
//        User user = firebaseTokenToUserDto(decodedToken);
//        if (user != null) {
//            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(user,
//                    new Credentials(type, decodedToken, token, session), null);
//            authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
//            SecurityContextHolder.getContext().setAuthentication(authentication);
//        }
//    }
//
//    private User firebaseTokenToUserDto(FirebaseToken decodedToken) {
//        User user = null;
//        if (decodedToken != null) {
//            user = new User();
//            user.setUid(decodedToken.getUid());
//            user.setName(decodedToken.getName());
//            user.setEmail(decodedToken.getEmail());
//            user.setPicture(decodedToken.getPicture());
//            user.setIssuer(decodedToken.getIssuer());
//            user.setEmailVerified(decodedToken.isEmailVerified());
//        }
//        return user;
//    }

// This method is used to avoid filter for specific URL's
//    @Override
//    protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
//        System.out.println(request.getServletPath());
//        return new AntPathRequestMatcher("/auth/login").matches(request);
//    }
}
