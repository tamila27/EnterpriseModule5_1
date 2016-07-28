package ua.goit.gojavaonline;

/**
 * Created by tamila on 7/27/16.
 */
public class SqrtOperator extends Operator implements UnaryOperator {
    @Override
    public String calculate(String a) {
        return String.valueOf(Math.sqrt(OperandTypeAnalyser.parseOperand(a).doubleValue()));
    }
}
