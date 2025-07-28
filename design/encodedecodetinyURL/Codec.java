package design.encodedecodetinyURL;
// COMPLETED

import java.util.HashMap;
public class Codec {
    private static final String salt = "secret-key"; // key/base which has to be with every encoded url
    private final HashMap<String, String> urlToCode = new HashMap<>();
    private final HashMap<String, String> codeToUrl = new HashMap<>();
    private int counter = 1;
    public String encode(String longUrl) {
        if(urlToCode.containsKey(longUrl)){
            return salt + urlToCode.get(longUrl);
        }

        String code = Integer.toHexString(counter++);
        urlToCode.put(longUrl, code);
        codeToUrl.put(code, longUrl);

        return salt + code;
    }
    public String decode(String shortUrl) {
        String code = shortUrl.replaceAll(salt, "");
        return codeToUrl.get(code);
    }
}
// public class Codec {

//     HashMap<String, String> map;

//     public Codec(){
//         this.map = new HashMap<>();
//     }

//     public String encode(String longUrl) {
//         map.put(longUrl, longUrl);
//         return longUrl;
//     }

//     public String decode(String shortUrl) {
//         return map.get(shortUrl);
//     }
// }