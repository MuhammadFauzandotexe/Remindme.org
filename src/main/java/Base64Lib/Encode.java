package Base64Lib;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

public class Encode {
    public static void main(String[] args) {

//        Base64.Encoder encoder = Base64.getEncoder();
//        String str = encoder.encodeToString("JavaTpoint".getBytes());
//        System.out.println("Encoded string: "+str);

//        Base64.Decoder decoder = Base64.getDecoder();
//        String dStr = new String(decoder.decode("bWZhdXphbjUxMDg3QGdtYWlsLmNvbSBmYXV6YW4geDVzb2xmT2Q="));
//        System.out.println("Decoded string: "+dStr);

        String stg = "Practice&=makes&=man&=perfect!";
        List<String> mydata = new ArrayList<>();
        String[] spStg = stg.split("&=");
        for (String i: spStg) {
            mydata.add(i);
        }
        String email = mydata.get(0);
        String email1 = mydata.get(1);
        String email2 = mydata.get(3);
        System.out.println(email+" "+email1+" "+email2);
    }
}
