package Harsh.Singh.CustomerService.Service;

import Harsh.Singh.CustomerService.Domain.Customer;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class JwtSecurityTokenImpl implements SecurityTokenGenrator {

    // Generate a key for signing the JWT tokens
    private final Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    @Override
    public Map<String, String> generateToken(Customer user) {
        String jwtToken = Jwts.builder()
                .setSubject(user.getCustomerName())
                .setIssuedAt(new Date())
                .signWith(key)
                .compact();

        Map<String, String> map = new HashMap<>();
        System.out.println(jwtToken);

        map.put("token", jwtToken);
        map.put("UserName", user.getCustomerName());
        map.put("message", "User Successfully logged in");
        System.out.println(map);
        return map;
    }
}
