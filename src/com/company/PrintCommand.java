package com.company;

import java.util.Stack;

public class PrintCommand implements BaseCommand {
    @Override
    public void execute(String[] args, Context context) {
        System.out.println(context.peekStack());
    }
}
