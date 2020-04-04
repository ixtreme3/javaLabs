package tests;

import com.company.BaseCommand;
import com.company.UnaryCommand;
import com.company.Context;
import org.junit.Test;
import static org.junit.Assert.*;

public class UnaryCommandTest {



    @Test(expected = IllegalArgumentException.class)
    public void wrongArgExecuteTest() {
        double expected = 11;
        int expectedSize = 1;

        Context context = new Context();
        context.pushStack(121.0);

        String[] args = {"$"};

        BaseCommand command = new UnaryCommand();
        command.execute(args, context);
    }


    @Test
    public void sqrtExecuteTest() {
        double expected = 25.0;
        int expectedSize = 1;

        Context context = new Context();
        context.pushStack(625.0);

        String[] args = {"SQRT"};

        BaseCommand command = new UnaryCommand();
        command.execute(args, context);
        assertEquals(expected, context.peekStack(), 0.0001);
        assertEquals(expectedSize, context.getSizeStack());
    }

    @Test(expected = IllegalArgumentException.class)
    public void negativeNumTest() {
        int expectedSize = 1;

        Context context = new Context();
        context.pushStack(-25.0);

        String[] args = {"SQRT"};

        BaseCommand command = new UnaryCommand();
        command.execute(args, context);
    }







}



