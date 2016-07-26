package ua.goit.gojavaonline;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Created by tamila on 7/20/16.
 */
public class ExpressionParser {

    public List<String> parseExpression(String expression){
        StringTokenizer stringTokenizer = new StringTokenizer(expression, OperatorsFactory.getOperatorsTokens(), true);
        List<String> parsedExpression = new ArrayList<>();
        while(stringTokenizer.hasMoreTokens()){
            String token = stringTokenizer.nextToken().trim();
            if(!token.equals("")){
                parsedExpression.add(token);
            }
        }
        return parsedExpression;
    }

    public boolean isOperator(String operator) {
        return OperatorsFactory.getOperatorsTokens().contains(operator);
    }
}
