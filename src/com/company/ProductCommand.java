package com.company;

public class ProductCommand extends BinaryCommand {
    @Override
    protected double calculate(double first, double second) {
        return first * second;
    }
}
