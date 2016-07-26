package ua.goit.gojavaonline;

/**
 * Created by tamila on 7/25/16.
 */
public class SubOperator extends Operator implements BinaryOperator {
    public String calculate(String a, String b) {
        if(OperandTypeAnalyser.parseOperand(a).getClass() == Double.class || OperandTypeAnalyser.parseOperand(b).getClass() == Double.class){
            return calculateDouble(OperandTypeAnalyser.parseOperand(a).doubleValue(), OperandTypeAnalyser.parseOperand(b).doubleValue());
        }
        return calculateLong(OperandTypeAnalyser.parseOperand(a).longValue(), OperandTypeAnalyser.parseOperand(b).longValue());
    }

    public String calculateLong(Long a, Long b) {
        return String.valueOf(a-b);
    }

    public String calculateDouble(Double a, Double b) {
        return String.valueOf(a-b);
    }
}
