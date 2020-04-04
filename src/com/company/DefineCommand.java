package com.company;

public class DefineCommand implements BaseCommand {
    @Override
    public void execute(String[] args, Context context) {
        context.setParams(args[0], Double.parseDouble(args[1]));
    }
}
