package com.company;

import java.util.logging.Level;
import java.util.logging.Logger;

public class BinaryCommand implements BaseCommand {

    Logger LOGGER = Logger.getLogger(BinaryCommand.class.getName());

    @Override
    public void execute(String[] args, Context context) {
        if (args.length != 1)
            throw new IllegalArgumentException("Неверное количество аргументов");
        if (context.getSizeStack() < 2)
            throw new IllegalArgumentException("Недостаточно элементов в стеке");

        String operation = args[0];
        LOGGER.log(Level.INFO, "Операция: " + operation);
        double first = context.peekStack();
        context.popStack();
        LOGGER.log(Level.INFO, "Взяли элемент из стека: " + first);
        double second = context.peekStack();
        context.popStack();
        LOGGER.log(Level.INFO, "Взяли элемент из стека: " + second);

        double res;
        if (operation.equals("+"))
            res = first + second;
        else if (operation.equals("-"))
            res = first - second;
        else if (operation.equals("*"))
            res = first * second;
        else if (operation.equals("/"))
            res = first / second;
        else
            throw new IllegalArgumentException("Нераспознанная операция");

        LOGGER.log(Level.INFO, "Результат: " + res);

        context.pushStack(res);
    }
}
