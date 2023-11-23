package com.mentorOnDemand.confi;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.mentorOnDemand.helper.JWTService;
import com.mentorOnDemand.servImpl.CustomPersonDetailsService;


import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JWTAuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    JWTService jwtHelper;

    @Autowired
    CustomPersonDetailsService customPersonDetailsService;


    @Override
    protected void doFilterInternal
            (HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        String jwtRequestTokenHeader = request.getHeader("Authorization");
        String userName = null;
        String bearerToken = null;
        if(jwtRequestTokenHeader != null && jwtRequestTokenHeader.startsWith("Bearer")) {
            bearerToken = jwtRequestTokenHeader.substring(7);
            try {
                userName = jwtHelper.extractUsername(bearerToken);
            } catch (Exception e) {
                throw new UsernameNotFoundException(e.getMessage());
            }
            UserDetails userDetails = customPersonDetailsService.loadUserByUsername(userName);
            if (userName != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                if (jwtHelper.validateToken(bearerToken, userDetails)) {
                    UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new
                            UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                    usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                    SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
                }
            } else {
                System.out.println("Person is not validated");
            }
        }
        filterChain.doFilter(request,response);
    }

}
