package com.juba13.dyboard;
/**
 * Configuration class for the Dashboard application.
 */
public class Config {
    // Base context path for the application
    public static final String CONTEXT = "/dynamic-dashboard/";

    // Default server port
    public static final String PORT = "8282";

    // Paths that are not filtered (excluded from filtering)
    public static String[] NON_FILTERING_PATH_PATTERNS = new String[]{
            "/swagger-resources/configuration/ui",
            "/configuration/ui",
            "/swagger-resources",
            "/swagger-resources/configuration/security",
            "/configuration/security",
            "/swagger-ui.html",
            "/webjars/**"
    };

    // Paths that are filtered
    public static String[] FILTERING_PATH_PATTERNS = new String[]{"/**"};

    // Private key for JWT authentication
    public static final String JWT_PRIVATE_KEY = "sjsjfdsjfidsjfiamsadsadisadsadosadsakdsad";

    /**
     * Inner class containing keys for session attributes.
     */
    static public class KEY {
        public static String USER_ID = "USER_ID";     // User ID key
        public static String ORG_ID = "ORG_ID";   // Organization ID key
        public static String SESSION_ID = "SESSION_ID"; // Session ID key
        public static String TOKEN = "TOKEN";         // Token key
    }
}
