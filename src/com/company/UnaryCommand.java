package com.company;

public class UnaryCommand implements BaseCommand {
    @Override
    public void execute(String[] args, Context context) {
        String operation = args[0];
        double val = context.peekStack();
        if (val < 0) {
            throw new IllegalArgumentException("Неподходящий аргумент");
        }
        context.popStack();

        if (operation.equals("SQRT"))
        {
            double res = Math.sqrt(val);
            context.pushStack(res);
        }
        else
            throw new IllegalArgumentException("Нераспознанная операция");
    }
}
