package ua.goit.gojavaonline;

/**
 * Created by tamila on 7/20/16.
 */
public class Runner {
    public static void main(String[] args) {
        MathExpressionParser mathExpressionParser = new MathExpressionParser();
        System.out.println(mathExpressionParser.calculateExpression("√4"));
    }
}
