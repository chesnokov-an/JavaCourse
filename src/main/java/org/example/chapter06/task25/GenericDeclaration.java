package org.example.chapter06.task25;

import java.lang.reflect.*;
import java.util.*;

public class GenericDeclaration {

    public static String genericDeclaration(Method m) {
        StringBuilder sb = new StringBuilder();

        // Параметры типа с ограничениями
        TypeVariable<Method>[] tvars = m.getTypeParameters();
        if (tvars.length > 0) {
            sb.append("<");
            for (int i = 0; i < tvars.length; i++) {
                if (i > 0) sb.append(", ");
                sb.append(tvars[i].getName());

                Type[] bounds = tvars[i].getBounds();
                if (bounds.length > 0 && !bounds[0].equals(Object.class)) {
                    sb.append(" extends ");
                    for (int j = 0; j < bounds.length; j++) {
                        if (j > 0) sb.append(" & ");
                        sb.append(bounds[j].getTypeName());
                    }
                }
            }
            sb.append("> ");
        }

        // Возвращаемый тип + имя
        sb.append(m.getGenericReturnType().getTypeName())
                .append(" ")
                .append(m.getName())
                .append("(");

        // Параметры метода
        Type[] params = m.getGenericParameterTypes();
        for (int i = 0; i < params.length; i++) {
            if (i > 0) sb.append(", ");
            sb.append(params[i].getTypeName());
        }
        sb.append(")");

        return sb.toString();
    }

    static void main() throws Exception {
        Method sort = Collections.class.getMethod("sort", List.class);
        System.out.println(genericDeclaration(sort));

        Method sortCmp = Collections.class.getMethod("sort", List.class, Comparator.class);
        System.out.println(genericDeclaration(sortCmp));

        Method max = Collections.class.getMethod("max", Collection.class);
        System.out.println(genericDeclaration(max));
    }
}