package Task2;

import java.util.regex.Pattern;

public class Regex {
    public static void main(String[] args) {
        System.out.println(checkMail("123@123.com"));
        System.out.println(checkMail("qwerof3"));
    }
    public static boolean checkMail(String mail){
        String pattern = "^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$";
        return Pattern.matches(pattern, mail);
    }
}
