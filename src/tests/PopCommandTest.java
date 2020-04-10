package tests;

import com.company.BaseCommand;
import com.company.BinaryCommand;
import com.company.Context;
import com.company.PopCommand;
import org.junit.Test;

import static org.junit.Assert.*;

public class PopCommandTest {
    @Test
    public void decreaseStackTest() {
        int expectedSize = 1;
        BaseCommand command = new PopCommand();
        Context context = new Context();
        context.pushStack(15.0);
        context.pushStack(25.0);
        String[] args = {"+"};
        //command.execute(args, context);

        assertEquals(expectedSize, context.getSizeStack());
    }
}