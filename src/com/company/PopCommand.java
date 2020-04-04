package com.company;

import java.util.ArrayList;

public class PopCommand implements BaseCommand {
    @Override
    public void execute(String[] args, Context context) {
        context.popStack();
    }
}
