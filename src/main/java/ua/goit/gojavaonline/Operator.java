package ua.goit.gojavaonline;

/**
 * Created by tamila on 7/20/16.
 */
public abstract class Operator {
    private int priority;

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public static boolean isValid(){
        return true;
    }
}
