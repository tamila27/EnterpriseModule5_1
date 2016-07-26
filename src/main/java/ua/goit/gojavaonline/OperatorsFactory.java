package ua.goit.gojavaonline;

/**
 * Created by tamila on 7/20/16.
 */
public class OperatorsFactory {
    private static String operatorsTokens = "+-";

    public static void addOperatorsToken(String token){
        operatorsTokens+=token;
    }

    public static String getOperatorsTokens(){
        return operatorsTokens;
    }

    public static Operator getOperatorObject(String operator){ // TODO must have implementation
        switch (operator){
            case "+":
                return new AddOperator();
            case "-":
                return new SubOperator();
            default:
                return null;
        }
    }
}
