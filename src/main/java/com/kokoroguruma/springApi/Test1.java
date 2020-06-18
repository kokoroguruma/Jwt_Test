package com.kokoroguruma.springApi;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator.Builder;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.Verification;

import lombok.Getter;

public class Test1 {

    public static void main(String[] args) {

        System.out.println("aaaaaaaaaaaa");

        System.out.println("---------------------------------");

        @Component
        @PropertySource("classpath:application.properties")
        class AppStr {


            @Getter
            String abcdefg;

        };

        AppStr apps = new AppStr();
        System.out.println(apps.getAbcdefg());


        System.out.println("---------------------------------");



        Algorithm alg = Algorithm.HMAC256("keydata");
        Algorithm alg1 = Algorithm.HMAC256("keydataa");


        Builder jwtBase = JWT.create();

        jwtBase.withClaim("kkg", "ggk");
//        Date date = new Date(2020, 6, 16, 17, 0);


        Date date = new Date();

        Calendar cal = Calendar.getInstance();
        cal.setTime(date);

        cal.add(Calendar.HOUR_OF_DAY, 12);


//        jwtBase.withExpiresAt(date);
        jwtBase.withExpiresAt(cal.getTime());

        String token = jwtBase.sign(alg);





        System.out.println(token);


        System.out.println("---------------------------------");


        DecodedJWT decodejwt = JWT.decode(token);

        System.out.println(decodejwt);
        System.out.println(decodejwt.getAlgorithm());
        System.out.println(decodejwt.getClaim("kkg").asString()); // これで取れる。as～の形になるらしい。
        System.out.println(decodejwt.getClaim("kkg").toString()); // これ間違い
        System.out.println(decodejwt);
        System.out.println(decodejwt);


        System.out.println("---------------------------------");

        Verification ver = JWT.require(alg); // ここが違えばエラーになる。
        JWTVerifier jver = ver.build();
        DecodedJWT decodejwtv = jver.verify(token);


        System.out.println(decodejwtv);
        System.out.println(decodejwtv.getAlgorithm());
        System.out.println(decodejwtv.getClaim("kkg").asString()); // これで取れる。as～の形になるらしい。
        System.out.println(decodejwtv.getClaim("kkg").toString()); // これ間違い
        System.out.println(decodejwtv.getExpiresAt());

        Date dateRes = decodejwtv.getExpiresAt();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        String dateStr = sdf.format(dateRes);
        System.out.println(dateStr);


        System.out.println(decodejwtv);
        System.out.println(decodejwtv);
        System.out.println(decodejwtv);
        System.out.println(decodejwtv);
        System.out.println(decodejwtv);
        System.out.println(decodejwtv);
        System.out.println(decodejwtv);
        System.out.println(decodejwtv);






    }

}
