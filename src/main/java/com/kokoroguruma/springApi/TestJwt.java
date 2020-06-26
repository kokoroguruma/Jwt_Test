package com.kokoroguruma.springApi;

import java.util.Calendar;
import java.util.Date;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator.Builder;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.Verification;

/**
 * 「java-jwt」の取り込み必須。 暗号化メソッド
 *
 * @author Kokoroguruma
 */
public class TestJwt {

    // JWTで使う暗号化キー
    public final String JWT_KEY = "自由に設定。長めが嬉しい。";

    public final String KEY_ACCOUNT_ID = "accountId";

    /**
     * JWT（JSON WEB TOKEN）作成メソッド 暗号化は簡単なもの。
     *
     * @param accountId
     * @return
     */
    public String createJwt(String accountId) {

        Builder jwtBuilder = JWT.create();

        // name設定
        jwtBuilder.withClaim(KEY_ACCOUNT_ID, accountId);

        // トークンの有効期限の設定。
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.HOUR_OF_DAY, 12); // 現在時間＋12時間
        Date date = cal.getTime();
        jwtBuilder.withExpiresAt(date);

        // 暗号化アルゴリズム
        Algorithm alg = Algorithm.HMAC256(JWT_KEY);

        // 暗号化
        String token = jwtBuilder.sign(alg);

        return token;
    }

    /**
     * 復号化メソッド
     *
     * @param jwt
     * @param accountId  戻り値用
     * @param errMessage 戻り値用
     * @return
     */
    public boolean checkDecodeJWT(String jwt, String accountId, String errMessage) {

        // 復号化
        Algorithm alg = Algorithm.HMAC256(JWT_KEY);

        DecodedJWT decodeJwt;
        try {
            Verification ver = JWT.require(alg);
            JWTVerifier jver = ver.build();
            decodeJwt = jver.verify(jwt);
        } catch (Exception e) {
            e.printStackTrace();
            errMessage = "復号化エラー";
            return false;
        }

        Date date = decodeJwt.getExpiresAt();
        if (date.after(new Date())) {
            // 現在時間よりも使用期限が後の場合
            errMessage = "使用期限エラー";
            return false;
        }

        // アカウントID取得
        accountId = decodeJwt.getClaim(KEY_ACCOUNT_ID).asString();

        return true;
    }

}
