package ua.goit.gojavaonline;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Created by tamila on 5/14/16.
 */
public class MathExpressionParser {
    private Calculator calculator;

    public void setCalculator(Calculator calculator){
        this.calculator = calculator;
    }

    public List<String> parseExpression(String expression){
        StringTokenizer stringTokenizer = new StringTokenizer(expression, calculator.getOperatorsTokens(), true);
        List<String> parsedExpression = new ArrayList<>();
        while(stringTokenizer.hasMoreTokens()){
            String token = stringTokenizer.nextToken().trim();
            if(!token.equals("")){
                parsedExpression.add(token);
            }
        }
        return parsedExpression;
    }

    private boolean isOperator(String operator) {
        return calculator.getOperatorBySign(operator) != null;
    }

    private int getOperatorPriority(Operator operator) {
        return operator.getPriority();
    }

    private Operator getOperatorObject(String operator){
        return calculator.getOperatorBySign(operator);
    }

    private void calculateSimpleExpression(LinkedList<String> numbers, Operator operator) throws NullPointerException, IllegalArgumentException {
        if(numbers == null || operator == null) {
            throw new NullPointerException();
        }

        String someOne = ( numbers.size() > 0) ? numbers.removeLast() : "0";
        String someTwo = ( numbers.size() > 0) ? numbers.removeLast() : "0";

        if (operator instanceof BinaryOperator){
            numbers.add(((BinaryOperator) operator).calculate(someTwo, someOne));
        } else if (operator instanceof UnaryOperator){
            numbers.add(((UnaryOperator) operator).calculate(someOne));
        }
    }

    public String calculateExpression(String s) throws NumberFormatException, IllegalArgumentException, NullPointerException{

        if(s == null || s.equals(""))
            return "0";

        LinkedList<String> numbers = new LinkedList<>();
        LinkedList<String> operators = new LinkedList<>();

        List<String> tokensList = parseExpression(s);
        for ( String token: tokensList) {
            if(token.equals("(")) {
                operators.add("(");
            } else if (token.equals(")")) {
                while(!operators.getLast().equals("(")) {
                    calculateSimpleExpression(numbers, getOperatorObject(operators.removeLast()));
                }
                operators.removeLast();
            } else if (isOperator(token)) {
                while(!operators.isEmpty() &&
                        getOperatorPriority(getOperatorObject(operators.getLast())) >= getOperatorPriority(getOperatorObject(token))) {
                    calculateSimpleExpression(numbers, getOperatorObject(operators.removeLast()));
                }
                operators.add(token);
            } else {
                numbers.add(token);

            }
        }

        while(!operators.isEmpty()) {
            calculateSimpleExpression(numbers, getOperatorObject(operators.removeLast()));
        }

        return numbers.get(0);
    }
}
