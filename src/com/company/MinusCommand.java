package com.company;

public class MinusCommand extends BinaryCommand {
    @Override
    protected double calculate(double first, double second) {
        return first - second;
    }
}
