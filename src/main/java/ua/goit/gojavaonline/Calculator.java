package ua.goit.gojavaonline;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by tamila on 7/26/16.
 */
public class Calculator {
    private Map<String, Operator> operatorsList;
    private String operatorsTokens;

    public Calculator(){
        registerOperator("+", new AddOperator());
        registerOperator("-", new SubOperator());
        registerOperator("√", new SqrtOperator());
    }

    public Map<String, Operator> getOperatorsList() {
        return operatorsList;
    }

    public void registerOperator(String operatorSign, Operator operator) {
        if (operatorsList == null) {
            operatorsList = new HashMap<>();
        }
        operatorsList.put(operatorSign, operator);
        operatorsTokens += operatorSign;
    }

    public Operator getOperatorBySign(String operatorSign) {
        return operatorsList.get(operatorSign);
    }

    public String getOperatorsTokens() {
        return operatorsTokens + "()";
    }

}
