package cn.xyz.spel;

import cn.xyz.PlaceOfBirth;
import cn.xyz.User;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class CollectionExprSample {
    public static void main(String[] args) {
        //构建对象
        User user = new User();
        user.setUserName("tom");
        user.setLastVisit(new Date());
        user.setCredits(100);
        user.setPlaceOfBirth(new PlaceOfBirth("中国","厦门"));

        ExpressionParser parser = new SpelExpressionParser();
        EvaluationContext context = new StandardEvaluationContext(user);

        //数组表达式解析
        int[] array1 = (int[])parser.parseExpression("new int[]{1,2,3}").getValue(context);
        System.out.println(array1);
        int[][] array2 = (int[][])parser.parseExpression("new int[2][3]").getValue(context);
        System.out.println(array2);
        //目前不支持多维数组初始化，以下语句报错
        int[][] array3 = (int[][])parser.parseExpression("new int[2][3]{{1,2,3},{4,5,6}}").getValue(context);
        System.out.println(array3);

        //List表达式解析
        List list = (List)parser.parseExpression("{1,2,3,4}").getValue(context);
        System.out.println(list);
        List listOfLists = (List)parser.parseExpression("{{'a','b'},{'x','y'}}").getValue(context);
        System.out.println(listOfLists);

        //列表字符串解析
        Map userInfo = (Map)parser.parseExpression("{userName:'tom',credits:100}").getValue(context);
        System.out.println(userInfo);
        List userInfo2 = (List)parser.parseExpression("{{userName:'tom',credits:100},{userName:'tom',credits:100}}").getValue(context);
        System.out.println(userInfo2);
        //从数组，List、Map中取值
        String interest1 = (String)parser.parseExpression("interestsArray[0]").getValue(context);
        String interest2 = (String)parser.parseExpression("interestsList[0]").getValue(context);
        String interest3 = (String)parser.parseExpression("interestsMap['interest1']").getValue(context);
    }
}
