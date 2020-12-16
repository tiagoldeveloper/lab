package br.com.lab.util;

import java.util.Collection;

public final class LabUtil {

    public static boolean isBlank(String s){
        return  s == null || s.trim().isEmpty();
    }

    public static boolean isNotBlank(String s){
        return  !isBlank(s);
    }

    public static boolean isEmpty(Collection collection){
        return collection == null || collection.isEmpty();
    }

    public static boolean isNotEmpty(Collection collection){
        return !isEmpty(collection);
    }

}
