package ua.goit.gojavaonline;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by tamila on 7/20/16.
 */
public class OperandTypeAnalyser {
    private final static Pattern LONG_PATTERN = Pattern.compile("^-?\\d+");
    private final static Pattern DOUBLE_PATTERN = Pattern.compile("^-?\\d+\\.\\d+");

    public static Class getOperandClass(String operand){
        Matcher matcher = LONG_PATTERN.matcher(operand);
        if(LONG_PATTERN.matcher(operand).matches()){
            return Long.class;
        } else if(DOUBLE_PATTERN.matcher(operand).matches()){
            return Double.class;
        }
        return null;
    }

    public static Number parseOperand(String operand){
        if(getOperandClass(operand) == Long.class){
            return Long.parseLong(operand);
        } else if (getOperandClass(operand) == Double.class){
            return Double.parseDouble(operand);
        }
        return Double.parseDouble(operand);
    }

    public static void main(String[] args) {
        Class c = getOperandClass("-1234");
        System.out.println(c);

        System.out.println(getOperandClass("-1.234"));

    }
}
