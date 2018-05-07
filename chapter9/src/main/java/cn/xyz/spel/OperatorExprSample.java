package cn.xyz.spel;

import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

public class OperatorExprSample {
    public static void main(String[] args) {
        ExpressionParser parser = new SpelExpressionParser();

        boolean trueValue = parser.parseExpression("2 == 2").getValue(Boolean.class);
        boolean falseValue = parser.parseExpression("2 < -5").getValue(Boolean.class);

        trueValue = parser.parseExpression("\"back\" < \"block\"").getValue(Boolean.class);
        falseValue = parser.parseExpression("'xyz' instanceof T(int)").getValue(Boolean.class);


    }
}
