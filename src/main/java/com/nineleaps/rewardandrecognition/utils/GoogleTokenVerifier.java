/*
package com.nineleaps.rewardandrecognition.utils;

import com.nineleaps.rewardandrecognition.service.UserService;
import lombok.SneakyThrows;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class GoogleTokenVerifier extends OncePerRequestFilter {

    @Autowired
    private UserService userDetailsService;

    @SneakyThrows
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws ServletException, IOException {

        final String authorizationHeader = request.getHeader("authorization");

        String jwt = null;
        System.out.println(authorizationHeader);

        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            jwt = authorizationHeader.substring(7);}
            System.out.println(jwt);
        CloseableHttpClient client = HttpClients.createDefault();
        HttpGet request1 = new HttpGet("https://www.googleapis.com/oauth2/v3/tokeninfo?id_token=" + jwt);
        CloseableHttpResponse response1 = null;
        response1 = client.execute(request1);
        int status = response1.getStatusLine().getStatusCode();
        if (!(status >= 200 && status < 300)) {
            System.out.println("The token is invalid");
        }
        HttpEntity httpEntity = response1.getEntity();
        String responseString = EntityUtils.toString(httpEntity, "UTF-8");
        //data extracting
        JSONObject json = (JSONObject) new JSONParser().parse(responseString);
        String email;
        email = (String) json.get("email");
        String googleId = (String) json.get("sub");
        String uname = (String) json.get("name");
        String picture = (String) json.get("picture");
        String username=email;




        if (uname != null && SecurityContextHolder.getContext().getAuthentication() == null) {

            UserDetails userDetails = this.userDetailsService.getUserByemailAddress(email);
String abc=userDetails.getUsername();
            if ((email.equals(userDetails.getUsername()))) {

                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
                        userDetails, null, userDetails.getAuthorities());
                usernamePasswordAuthenticationToken
                        .setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
            }
        }
        chain.doFilter(request, response);
    }




}
*/
