package org.example.chapter01.task12;

import static java.lang.Character.isDigit;
import java.util.Calendar;

public class Task12 {
    // src/java.base/java/text/SimpleDateFormat.java

    private int subParseNumericZone(String text, int start, int sign, int count,
                                    boolean colon, CalendarBuilder calb) {
        int index = start;

        try {
            char c = text.charAt(index++);
            // Parse hh
            int hours;
            if (!isDigit(c)) {
                return  1 - index;
            }
            hours = c - '0';
            c = text.charAt(index++);
            if (isDigit(c)) {
                hours = hours * 10 + (c - '0');
            } else {
                // If no colon in RFC 822 or 'X' (ISO), two digits are
                // required.
                if (count > 0 || !colon) {
                    return  1 - index;
                }
                --index;
            }
            if (hours > 23) {
                return  1 - index;
            }
            int minutes = 0;
            if (count != 1) {
                // Proceed with parsing mm
                c = text.charAt(index++);
                if (colon) {
                    if (c != ':') {
                        return  1 - index;
                    }
                    c = text.charAt(index++);
                }
                if (!isDigit(c)) {
                    return  1 - index;
                }
                minutes = c - '0';
                c = text.charAt(index++);
                if (!isDigit(c)) {
                    return  1 - index;
                }
                minutes = minutes * 10 + (c - '0');
                if (minutes > 59) {
                    return  1 - index;
                }
            }
            minutes += hours * 60;
            calb.set(Calendar.ZONE_OFFSET, minutes * 60 * 1000 * sign)
                    .set(Calendar.DST_OFFSET, 0);
            return index;
        } catch (IndexOutOfBoundsException e) {
        }
        return  1 - index; // -(index - 1)
    }
}
