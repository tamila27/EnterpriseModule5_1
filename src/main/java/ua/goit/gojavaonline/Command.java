package ua.goit.gojavaonline;

/**
 * Created by tamila on 7/21/16.
 */
public class Command {
    public <T> T calculate(Class<T> typeClass) {
        return null;
    }

    public static void main(String[] args) {
        Command cmd = new Command();
        Integer calculate = cmd.calculate(int.class);
        Integer calculate2 = cmd.calculate(Integer.class);

    }

    private class TypeDescriptor {
        Class type;
    }

    private class Operation<TypeDescriptor> {
        String calculate(){return null;}
    }
}
