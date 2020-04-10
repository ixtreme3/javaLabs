package com.company;

public class PlusCommand extends BinaryCommand {
    @Override
    protected double calculate(double first, double second) {
        return first + second;
    }
}
