package com.company;

import java.io.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class Main {

    static Logger LOGGER;
    static {
        try(FileInputStream ins = new FileInputStream("log.config")){
            LogManager.getLogManager().readConfiguration(ins);
            LOGGER = Logger.getLogger(Main.class.getName());
        } catch (Exception ignore){
            ignore.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = null;
        if (args.length > 0){
            try {
                scanner = new Scanner(new File(args[0]));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            LOGGER.log(Level.INFO, "Чтение из файла: " + args[0]);
        }
        else{
            scanner = new Scanner(System.in);
            LOGGER.log(Level.INFO, "Чтение команд с консоли");
        }

        String[] lines;
        Context context = new Context();
        CommandFactory factory = new CommandFactory();

        while (scanner.hasNextLine()) { // !scanner.nextLine().equals("END")
            try {
                String line = scanner.nextLine();
                LOGGER.log(Level.INFO, "Обработка команды: " + line);
                lines = line.split(" ");

                String commandName = lines[0];
                String[] commandArgs = new String[lines.length - 1];

                String mathBinaryCommands = "+-*/";

                if (commandName.equals("DEFINE")) {
                    commandArgs[0] = lines[1];
                    commandArgs[1] = lines[2];
                }
                if (commandName.equals("PUSH")) {
                    commandArgs[0] = lines[1];
                } else if (mathBinaryCommands.contains(commandName) || commandName.equals("SQRT")) {
                    commandArgs = new String[1];
                    commandArgs[0] = commandName;
                }

                BaseCommand command = factory.create(lines[0]);
                command.execute(commandArgs, context); //
            }
            catch (Exception e)
            {
                System.out.println(e.getMessage());
                StringWriter sw = new StringWriter();
                PrintWriter pw = new PrintWriter(sw);
                e.printStackTrace(pw);

                LOGGER.log(Level.SEVERE, sw.toString());
            }
        }

        LOGGER.log(Level.INFO, "Конец обработки команд");
    }
}
