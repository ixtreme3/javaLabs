package com.company;

public class DivisionCommand extends BinaryCommand {
    @Override
    protected double calculate(double first, double second) {
        return first / second;
    }
}
