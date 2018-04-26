package cn.xyz;

import java.text.MessageFormat;
import java.util.GregorianCalendar;
import java.util.Locale;

public class MessageFormatTest {
    public static void main(String[] args) {
        String pattern1 = "{0}，你好！你于{1}在工商银行存款{2}元。";
        String pattern2 = "At {1,time,short} on {1,date,long} , {0} paid {2,number,currency}";

        Object[] params = {"John",new GregorianCalendar().getTime(),1.0E3};

        String msg1 = MessageFormat.format(pattern1,params);
        MessageFormat messageFormat = new MessageFormat(pattern2, Locale.US);
        String msg2 = messageFormat.format(params);

        System.out.println(msg1);
        System.out.println(msg2);
    }
}
