package cn.xyz;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.util.Date;
import java.util.Locale;

public class LocalTest {
    public static void main(String[] args) {
        Locale locale = new Locale("zh","CN");
        NumberFormat format = NumberFormat.getCurrencyInstance(locale);

        double amt = 12393848.67;
        System.out.println(format.format(amt));

        locale = new Locale("en","US");
        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.MEDIUM,locale);

        System.out.println(dateFormat.format(date));
    }
}
