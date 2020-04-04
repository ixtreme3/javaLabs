package com.company;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

public class CommandFactory {
    public BaseCommand create(String commandName) throws Exception {
        Properties prop = new Properties(); // вытащить в конструктор
        InputStream inputStream = getClass().getResourceAsStream("settings.properties");
        prop.load(inputStream); // void load(InputStream streamIn) throws IOException
        // Вводит список свойств из входного потока, связанного с streamIn.

        String className = prop.getProperty(commandName); //String getProperty(String key)
        // Возвращает значение, связанное с ключом. Возвращается нулевой объект, если ключ не находится ни в списке, ни в списке свойств по умолчанию.
        if (className == null)
            throw new IllegalArgumentException("Неопознанная команда");

        BaseCommand command = (BaseCommand) Class.forName(className).getDeclaredConstructor().newInstance();

        return command;
    }
}
