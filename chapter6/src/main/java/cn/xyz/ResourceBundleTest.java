package cn.xyz;

import java.text.MessageFormat;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.ResourceBundle;

public class ResourceBundleTest {
    public static void main(String[] args) {
        ResourceBundle resourceBundle1 = ResourceBundle.getBundle("cn/xyz/resource", Locale.US);
        ResourceBundle resourceBundle2 = ResourceBundle.getBundle("cn/xyz/resource", Locale.CHINA);

        System.out.println("us:" + resourceBundle1.getString("greeting.common"));
        System.out.println("cn:" + resourceBundle2.getString("greeting.common"));


        ResourceBundle resourceBundle3 = ResourceBundle.getBundle("cn/xyz/fmt", Locale.US);
        ResourceBundle resourceBundle4 = ResourceBundle.getBundle("cn/xyz/fmt", Locale.CHINA);
        Object[] params = {"John",new GregorianCalendar().getTime()};

        System.out.println(new MessageFormat(resourceBundle3.getString("greeting.common"),Locale.US).format(params));
        System.out.println(new MessageFormat(resourceBundle4.getString("greeting.morning"),Locale.CHINA).format(params));
        System.out.println(new MessageFormat(resourceBundle4.getString("greeting.afternoon"),Locale.CHINA).format(params));
    }
}
