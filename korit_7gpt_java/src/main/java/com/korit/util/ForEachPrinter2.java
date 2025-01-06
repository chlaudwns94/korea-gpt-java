package com.korit.util;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class ForEachPrinter2 {
   public static <T> List<T> print(List<T> datas, Consumer<List<T>> action) {
       List<T> result = new ArrayList<>();
       action.accept(datas);

       return result;
   }

}
