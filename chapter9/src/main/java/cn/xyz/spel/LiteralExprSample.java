package cn.xyz.spel;

import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

public class LiteralExprSample {
    public static void main(String[] args) {
        ExpressionParser parser = new SpelExpressionParser();

        String helloWorld = (String)parser.parseExpression("\"Hello World\"").getValue();

        double doubleNumber = (Double)parser.parseExpression("6.0293838E+23").getValue();

        int maxValue = (Integer)parser.parseExpression("0x7FFFFFFF").getValue();

        boolean trueValue = (Boolean)parser.parseExpression("true").getValue();

        Object nullValue = parser.parseExpression("null").getValue();
    }
}
