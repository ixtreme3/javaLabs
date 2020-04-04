package com.company;

public class PushCommand implements BaseCommand {
    @Override
    public void execute(String[] args, Context context) {
        String arg = args[0];
        Double val;
        if (checkDouble(arg))
            val = Double.parseDouble(arg);
        else if (context.containsParam(arg))
            val = context.getParamValue(arg);
        else
            throw new IllegalArgumentException("Переменная не найдена в словаре");

        context.pushStack(val);
    }

    private boolean checkDouble(String s)
    {
        try {
            double d = Double.parseDouble(s);
        }
        catch (Exception e)
        {
            return false;
        }
        return true;
    }
}
