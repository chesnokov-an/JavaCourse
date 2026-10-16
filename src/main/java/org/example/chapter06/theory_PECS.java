package org.example.chapter06;


import java.util.List;

//public class theory_PECS {
//
//    // пробуем писать в extends
//    public static void addAll(List<? extends Number> list) {
//        list.add(42.2);  // ошибка компиляции
//        list.add(null); // null можно положить
//    }
//    //  Number — может быть List<Integer>, List<Double> или List<BigDecimal>.
//    //  Нельзя разрешать писать Double в List<Integer>
//
//    // пробуем читать из super
//    public static void readAll(List<? super Integer> list) {
//        Integer x = list.get(0); // ошибка компиляции
//        Object o = list.get(0);  // только Object
//    }
//    // ? super Integer может быть List<Integer>, List<Number> или List<Object>
//    // Если это List<Object>, там может лежать String
//}
