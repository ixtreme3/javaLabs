package com.company;

public class SqrtCommand extends UnaryCommand {
    @Override
    protected double calculate(double val) {
        return Math.sqrt(val);
    }
}
