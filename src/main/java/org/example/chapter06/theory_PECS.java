package org.example.chapter06;


import java.util.List;

//public class theory_PECS {
//    // пробуем писать в extends
//    public static void addE(List<? extends Number> list1, List<? extends Number> list2) {
//        list1.add(list2.getFirst());  // ошибка компиляции
//        list1.add(null);  // null можно положить
//    }
//    //  Number — может быть List<Integer>, List<Double>
//    //  Нельзя разрешать писать Double в List<Integer>
//
//    // пробуем читать из super
//    public static void readS(List<? super Integer> list) {
//        Integer a = list.getFirst(); // ошибка компиляции
//        Object b = list.getFirst();  // только Object
//    }
//    // ? super Integer может быть List<Integer>, List<Number> или List<Object>
//    // Если это List<Object>, там может лежать String
//}
