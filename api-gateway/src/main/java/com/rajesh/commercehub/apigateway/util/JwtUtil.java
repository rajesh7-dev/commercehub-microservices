package com.rajesh.commercehub.apigateway.util;

import io.jsonwebtoken.Jwts;


public class JwtUtil {

    private static final String SECRET = "mysecretkeymysecretkeymysecretkeymysecretkey";

    public static boolean validateToken(String token){

        Jwts.parser()
                .setSigningKey(SECRET)
                .parseClaimsJws(token);
        return true;

    }

}
