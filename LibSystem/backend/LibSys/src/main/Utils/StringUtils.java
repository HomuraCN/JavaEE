package main.Utils;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class StringUtils {
    public static String UrlEncoder(String url){
        return URLEncoder.encode(url, StandardCharsets.UTF_8);
    }
    public static String UrlDecoder(String url){
        return URLDecoder.decode(url, StandardCharsets.UTF_8);
    }
}
