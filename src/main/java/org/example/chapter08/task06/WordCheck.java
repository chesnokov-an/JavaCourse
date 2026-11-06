package org.example.chapter08.task06;

public class WordCheck {
    public static boolean isWord(String s) {
        return !s.isEmpty() && s.codePoints().allMatch(Character::isAlphabetic);
    }

    public static boolean isJavaIdentifier(String s) {
        return !s.isEmpty()
                && Character.isJavaIdentifierStart(s.codePointAt(0))
                && s.codePoints().skip(1).allMatch(Character::isJavaIdentifierPart);
    }

    static void main() {
        String[] samples = {"Hello", "Привет", "Java16", "16Java", "_name", "hello-world", ""};

        for (String sample : samples) {
            System.out.printf("%-12s слово: %-5s идентификатор: %s%n",
                    "\"" + sample + "\"", isWord(sample), isJavaIdentifier(sample));
        }
    }
}
