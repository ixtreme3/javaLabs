package tests;

import com.company.BinaryCommand;
import com.company.Context;
import org.junit.Test;

import static org.junit.Assert.*;

public class BinaryCommandTest {

    @Test
    public void sumExecuteTest() {
        double expected = 30.0;
        int expectedSize = 1;

        Context context = new Context();
        context.pushStack(10.0);
        context.pushStack(20.0);

        String[] args = {"+"};

        BinaryCommand command = new BinaryCommand();
        command.execute(args, context);

        assertEquals(expected, context.peekStack(), 0.0001);
        assertEquals(expectedSize, context.getSizeStack());
    }

    @Test
    public void subExecuteTest() {
        double expected = 2.0099;
        int expectedSize = 1;

        Context context = new Context();
        context.pushStack(156.0);
        context.pushStack(158.0099);

        String[] args = {"-"};

        BinaryCommand command = new BinaryCommand();
        command.execute(args, context);

        assertEquals(expected, context.peekStack(), 0.0001);
        assertEquals(expectedSize, context.getSizeStack());
    }

    @Test
    public void mulExecuteTest() {
        double expected = 6242.3354;
        int expectedSize = 1;

        Context context = new Context();
        context.pushStack(5.0099);
        context.pushStack(1246.0);

        String[] args = {"*"};

        BinaryCommand command = new BinaryCommand();
        command.execute(args, context);

        assertEquals(expected, context.peekStack(), 0.0001);
        assertEquals(expectedSize, context.getSizeStack());
    }

    @Test
    public void divExecuteTest() {
        double expected = 125.0;
        int expectedSize = 1;

        Context context = new Context();
        context.pushStack(5.0);
        context.pushStack(625.0);

        String[] args = {"/"};

        BinaryCommand command = new BinaryCommand();
        command.execute(args, context);

        assertEquals(expected, context.peekStack(), 0.0001);
        assertEquals(expectedSize, context.getSizeStack());
    }

    @Test(expected = IllegalArgumentException.class)
    public void noArgumentExecuteTest() {
        Context context = new Context();
        String[] args = new String[0];

        BinaryCommand command = new BinaryCommand();
        command.execute(args, context);
    }

    @Test(expected = IllegalArgumentException.class)
    public void wrongArgExecuteTest() {
        Context context = new Context();
        String[] args = {"@"};
        context.pushStack(5.0);
        context.pushStack(5.0);

        BinaryCommand command = new BinaryCommand();
        command.execute(args, context);
    }

    @Test
    public void noOpStackExecuteTest() {
        int expectedSize = 3;
        double a = 55.0;
        Context context = new Context();
        context.pushStack(5.0);
        context.pushStack(5.0);
        context.pushStack(a);

        assertEquals(expectedSize, context.getSizeStack());
    }

    @Test
    public void mixedArgsExecuteTest() {
        double expected = 2775.0;
        int expectedSize = 1;
        double a = 5;

        Context context = new Context();
        context.pushStack(a);
        context.pushStack(555.0);

        String[] args = {"*"};

        BinaryCommand command = new BinaryCommand();
        command.execute(args, context);
    }

    @Test
    public void multipleArgsExecuteTest() {
        double expected = 12;
        int expectedSize = 1;

        Context context = new Context();
        context.pushStack(8.0);
        context.pushStack(4.0);
        context.pushStack(2.0);
        context.pushStack(1.0);
        context.pushStack(1.0);

        String[] args = {"+"};

        BinaryCommand command = new BinaryCommand();

        command.execute(args, context);
        args[0] = "/";
        command.execute(args, context);
        args[0] = "*";
        command.execute(args, context);
        args[0] = "+";
        command.execute(args, context);

        assertEquals(expected, context.peekStack(), 0.0001);
        assertEquals(expectedSize, context.getSizeStack());
    }


}