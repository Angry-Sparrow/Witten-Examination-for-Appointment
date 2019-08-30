import com.sun.javafx.image.BytePixelSetter;

import java.util.Scanner;
import java.util.Arrays;

public class 华为第一题 {
        public static void main(String[] args){
            Scanner in = new Scanner(System.in);
            String s = in.nextLine();
            String input = s.substring(s.indexOf(" ")+1);
            String slen = s.substring(0,s.indexOf(" "));
            long len = Long.parseLong(slen,16);
            String[] strings = input.split(" ");
            String r = "";
            for(int i=0;i<len && i<strings.length;i++){
                if(strings[i].equals("A"))
                    strings[i] = "12 34";
                if(strings[i].equals("B"))
                    strings[i] = "AB CD";
                if(i!=0)
                    r = r + " " + strings[i];
                else
                    r += strings[i];
            }
            Integer length = r.split(" ").length + 1;

            String res = Integer.toHexString(length).toUpperCase() + " " + r;
            System.out.println(res);
        }

}
