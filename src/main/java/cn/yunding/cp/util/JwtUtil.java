package cn.yunding.cp.util;

import cn.yunding.cp.dto.JwtResult;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import javax.xml.crypto.Data;
import java.security.Key;
import java.util.Date;

public class JwtUtil {

    private static Logger logger= LoggerFactory.getLogger(JwtUtil.class);
    public static String secretkey="oakUsdhNSOjodasasd";

    /**
     * 生成token
     */
    public static JwtResult ctreateJwt(Claims claims, long ttl){
        //SignatureAlgorithm属性表示签名的算法（algorithm），默认是 HMAC SHA256（写成 HS256）；
        SignatureAlgorithm signatureAlgorithm=SignatureAlgorithm.HS256;
        long nowMillis=System.currentTimeMillis();
        Date now=new Date(nowMillis);

        byte[] apiKeySecretBytes= DatatypeConverter.parseBase64Binary(secretkey);
        Key signingKey=new SecretKeySpec(apiKeySecretBytes,signatureAlgorithm.getJcaName());

        JwtBuilder builder= Jwts.builder().setClaims(claims).setIssuedAt(now);

        builder.signWith(signatureAlgorithm,signingKey);

        long expMillis=0L;
        if (ttl>=0){
            expMillis =nowMillis+ttl*1000;
            //exp (expiration time)：过期时间
            /**
             * JWT 规定了7个官方字段，供选用。
             * iss (issuer)：签发人
             exp (expiration time)：过期时间
             sub (subject)：主题
             aud (audience)：受众
             nbf (Not Before)：生效时间
             iat (Issued At)：签发时间
             jti (JWT ID)：编号
             */
            Date exp = new Date(expMillis);
            builder.setExpiration(exp);
        }
        String token=builder.compact();
        return new JwtResult(token,expMillis);
    }

    public JwtResult updateToken(String token, long ttl) {
        try {
            Claims claims = verifyToken(token);
            return ctreateJwt(claims, ttl);
        } catch (Exception e) {
            logger.error(e.getMessage());
            e.printStackTrace();
        }
        return null;
    }
    public static Claims verifyToken(String token) {
        Claims claims = claims = Jwts.parser()
                .setSigningKey(DatatypeConverter.parseBase64Binary(secretkey))
                .parseClaimsJws(token).getBody();

        return claims;
    }
}
