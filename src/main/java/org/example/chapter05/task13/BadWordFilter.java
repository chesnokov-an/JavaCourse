package org.example.chapter05.task13;

import java.util.logging.*;
import java.util.*;

public class BadWordFilter implements Filter {

    @Override
    public boolean isLoggable(LogRecord record) {
        String msg = record.getMessage().toLowerCase();
        return !msg.contains("секс")
                && !msg.contains("наркотики")
                && !msg.contains("c++");
    }

    static void main() {
        Logger logger = Logger.getLogger("test");
        logger.setUseParentHandlers(false);
        logger.setLevel(Level.ALL);

        ConsoleHandler handler = new ConsoleHandler();
        handler.setLevel(Level.ALL);
        handler.setFilter(new BadWordFilter());
        logger.addHandler(handler);

        logger.info("Это нормальное сообщение");
        logger.info("Тут есть секс");
        logger.info("Наркотики — это плохо");
        logger.info("Я люблю C++");
        logger.info("А это снова нормально");
    }
}
