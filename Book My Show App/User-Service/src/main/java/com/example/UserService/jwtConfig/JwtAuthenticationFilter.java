package com.example.UserService.jwtConfig;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

    /*

    step-7

    Create JWTAuthenticationFilter that extends OncePerRequestFilter
    and override method and write the logic to check the token that is comming in header.
    We have to write 5 important logic

   1 Get Token from request
   2 Validate Token
   3 GetUsername from token
   4 Load user associated with this token
   5 set authentication
     */

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private Logger logger = LoggerFactory.getLogger(OncePerRequestFilter.class);
    @Autowired
    private JwtHelper jwtHelper;


    @Autowired
    private UserDetailsService userDetailsService;

    /*
    This doFilter implementation stores a request attribute for "already filtered",
    proceeding without filtering again if the attribute is already there.
     */
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException, IOException {

//        try {
//            Thread.sleep(500);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
        //Authorization


        /*
        , the header contains encoded credentials like username/password,
        tokens, etc. These are used to validate the client.
         */

        String requestHeader = request.getHeader("Authorization");
        //Bearer 2352345235sdfrsfgsdfsdf
        logger.info(" Header :  {}", requestHeader);
        String username = null;
        String token = null;

        if (requestHeader != null && requestHeader.startsWith("Bearer")) {
            //looking good
            token = requestHeader.substring(7);
            try {

                username = this.jwtHelper.getUsernameFromToken(token);

            } catch (IllegalArgumentException e) {
                logger.info("Illegal Argument while fetching the username !!");
                e.printStackTrace();
            } catch (ExpiredJwtException e) {
                logger.info("Given jwt token is expired !!");
                e.printStackTrace();
            } catch (MalformedJwtException e) {
                logger.info("Some changed has done in token !! Invalid Token");
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();

            }


        } else {
            logger.info("Invalid Header Value !! ");
        }


        //
        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {


            //fetch user detail from username
            /*
             UserDetailsService is used by the authentication manager
            in Spring Security to load the user details for an authenticated user
             */
            UserDetails userDetails = this.userDetailsService.loadUserByUsername(username);
            Boolean validateToken = this.jwtHelper.validateToken(token, userDetails);
            if (validateToken) {

                //set the authentication
                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authentication);
            } else {
                logger.info("Validation fails !!");
            }
        }
       filterChain.doFilter(request, response);

    }
}

/*
SecurityContextHolder.getContext().getAuthentication() == null", it is verifying whether
there is an existing Authentication object in the SecurityContext. If the result is true
 (i.e., the Authentication object is null), then it means that the user has not yet logged
  in or their session has expired. Otherwise, if the result is false
(i.e., the Authentication object is not null), then it indicates that the user is already logged in.
 */