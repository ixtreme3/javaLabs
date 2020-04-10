package tests;

import com.company.BaseCommand;
import com.company.Context;
import com.company.PushCommand;
import org.junit.Test;

import static org.junit.Assert.*;

public class PushCommandTest {

    @Test
    public void increaseStackTest() {
        int expectedSize = 1;
        BaseCommand command = new PushCommand();
        Context context = new Context();
        context.pushStack(555.0);
        String[] args = {"+"};
       // command.execute(args, context);

        //assertEquals(expectedSize, context.getSizeStack());
    }

}