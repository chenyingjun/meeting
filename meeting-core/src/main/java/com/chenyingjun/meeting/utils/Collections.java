package com.chenyingjun.meeting.utils;

import org.apache.commons.lang3.StringUtils;

import java.util.*;

/**
 *  Collection 工具类
 *
 * @author chenyingjun
 * @version 2017年12月25日
 * @since 1.0
 */
public class Collections {
    public Collections() {
    }

    public static String convertToString(Collection collection, String separator) {
        return StringUtils.join(collection, separator);
    }

    public static String convertToString(Collection collection, String prefix, String postfix) {
        StringBuilder builder = new StringBuilder();
        Iterator i$ = collection.iterator();

        while(i$.hasNext()) {
            Object o = i$.next();
            builder.append(prefix).append(o).append(postfix);
        }

        return builder.toString();
    }

    public static boolean isEmpty(Collection collection) {
        return collection == null || collection.isEmpty();
    }

    public static boolean isNotEmpty(Collection collection) {
        return collection != null && !collection.isEmpty();
    }

    public static <T> T getFirst(Collection<T> collection) {
        return isEmpty(collection) ? null : collection.iterator().next();
    }

    public static <T> T getLast(Collection<T> collection) {
        if (isEmpty(collection)) {
            return null;
        } else if (collection instanceof List) {
            List<T> list = (List)collection;
            return list.get(list.size() - 1);
        } else {
            Iterator iterator = collection.iterator();

            Object current;
            do {
                current = iterator.next();
            } while(iterator.hasNext());

            return (T) current;
        }
    }

    public static <T> List<T> union(Collection<T> a, Collection<T> b) {
        List<T> result = new ArrayList(a);
        result.addAll(b);
        return result;
    }

    public static <T> List<T> subtract(Collection<T> a, Collection<T> b) {
        List<T> list = new ArrayList(a);
        Iterator i$ = b.iterator();

        while(i$.hasNext()) {
            T element = (T) i$.next();
            list.remove(element);
        }

        return list;
    }

    public static <T> List<T> intersection(Collection<T> a, Collection<T> b) {
        List<T> list = new ArrayList();
        Iterator i$ = a.iterator();

        while(i$.hasNext()) {
            T element = (T) i$.next();
            if (b.contains(element)) {
                list.add(element);
            }
        }

        return list;
    }
}
