package org.example.chapter05.task14;

import java.util.logging.*;
import java.io.*;

public class HtmlFormatter extends Formatter {

    @Override
    public String format(LogRecord record) {
        return "<p>" + record.getLevel() + ": " + formatMessage(record) + "</p>\n";
    }

    @Override
    public String getHead(Handler h) {
        return "<html><body>\n";
    }

    @Override
    public String getTail(Handler h) {
        return "</body></html>\n";
    }

    static void main() throws IOException {
        Logger logger = Logger.getLogger("test");
        logger.setUseParentHandlers(false);
        logger.setLevel(Level.ALL);

        FileHandler handler = new FileHandler("log.html");
        handler.setFormatter(new HtmlFormatter());
        logger.addHandler(handler);

        logger.info("Обычное сообщение");
        logger.warning("Предупреждение");
        logger.severe("Ошибка!");

        System.out.println("Готово. Открой log.html");
    }
}
