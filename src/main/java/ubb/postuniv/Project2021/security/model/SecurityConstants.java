package ubb.postuniv.Project2021.security.model;

public class SecurityConstants {

    public static final String SECRET = "SECRET_KEY";
    public static final String ROLE_USER = "[\"ROLE_USER\"]";
    public static final String ROLE_ADMIN = "[\"ROLE_ADMIN\"]";
    public static final long EXPIRATION_TIME = 900_000_000; // 15000 min = 250 hours
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";
    public static final String SIGN_UP_URL = "/api/users/register";
}
