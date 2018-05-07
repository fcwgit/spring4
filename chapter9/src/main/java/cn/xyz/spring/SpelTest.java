package cn.xyz.spring;

import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import java.util.ArrayList;
import java.util.List;

public class SpelTest {
    public static void main(String[] args) {
        class Simple{
            public List<Boolean> booleanList = new ArrayList<>();
        }

        Simple simple = new Simple();
        simple.booleanList.add(true);

        //创建求职上下文
        StandardEvaluationContext context = new StandardEvaluationContext(simple);

        //自动将false转换为布尔类型
        ExpressionParser parser = new SpelExpressionParser();
        parser.parseExpression("booleanList[0]").setValue(context,"false");

        //b将被设置为false
        boolean b = simple.booleanList.get(0);
        System.out.println(b);
    }
}
