package org.lwq.list;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Liwq
 */
public class DistinctMain {

    public static void main(String[] args) {

        List<String> buildList = getDuplicateList();

        long start = System.currentTimeMillis();

        List<String> distinctList = distinctListByContains(buildList);
        assert distinctList.size() > 0;
        int a = distinctList.size();
        System.out.println("distinctListByContains spend :" + (System.currentTimeMillis() - start) + "ms");
        start = System.currentTimeMillis();

        distinctList = distinctListByDoubleFor(buildList);
        assert distinctList.size() > 0 && distinctList.size() == a;
        System.out.println("distinctListByDoubleFor spend :" + (System.currentTimeMillis() - start) + "ms");
        start = System.currentTimeMillis();

        distinctList = distinctListByHashSet(buildList);
        assert distinctList.size() > 0 && distinctList.size() == a;
        System.out.println("distinctListByHashSet spend :" + (System.currentTimeMillis() - start) + "ms");
        start = System.currentTimeMillis();

        List<Object> distinctList2 = distinctListBySteam(buildList);
        assert distinctList2.size() > 0 && distinctList2.size() == a;
        System.out.println("distinctListBySteam spend :" + (System.currentTimeMillis() - start) + "ms");

    }

    private static List<String> distinctListByDoubleFor(List<String> buildList) {
        List<String> result = new ArrayList<>(buildList);
        for (int i = 0; i < buildList.size(); i++) {
            for (int j = i + 1; j < buildList.size(); j++) {
                if (buildList.get(i).equals(buildList.get(j))) {
                    result.remove(buildList.get(j));
                }
            }
        }
        return result;
    }

    private static List<Object> distinctListBySteam(List<String> buildList) {
        return buildList.stream().distinct().collect(Collectors.toList());
    }

    private static ArrayList<String> distinctListByHashSet(List<String> buildList) {
        return new ArrayList<>(new HashSet<>(buildList));
    }

    private static List<String> distinctListByContains(List<String> buildList) {
        List<String> result = new ArrayList<>();
        for (String s : buildList) {
            if (!result.contains(s)) {
                result.add(s);
            }
        }
        return result;
    }

    private static List<String> getDuplicateList() {
        List<String> list = new ArrayList<>();
        int n = 1000;
        for (int i = 0; i < n; i++) {
            list.add("aaaa");
            list.add("aaaa" + i);
        }

        return list;
    }


}
