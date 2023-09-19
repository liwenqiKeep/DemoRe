package org.lwq.sch.hash;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        String[] a1 = {"eat", "tea", "tan", "ate", "nat", "bat"};

        for (List<String> list : groupAnagrams(a1)) {
            System.out.println(String.join(",", list));
        }

        String[] a2 = {""};

        for (List<String> list : groupAnagrams(a2)) {
            System.out.println(String.join(",", list));
        }

        String[] a3 = {"a"};

        for (List<String> list : groupAnagrams(a3)) {
            System.out.println(String.join(",", list));
        }
    }
    /**
     * 128. 最长连续序列
     * 中等
     * 1.8K
     * 相关企业
     * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
     *
     * 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
     *
     *
     *
     * 示例 1：
     *
     * 输入：nums = [100,4,200,1,3,2]
     * 输出：4
     * 解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
     * 示例 2：
     *
     * 输入：nums = [0,3,7,2,5,8,4,6,0,1]
     * 输出：9
     */
    public int longestConsecutive(int[] nums) {
        // 去重
        Set<Integer> num_set = new HashSet<Integer>();
        for (int num : nums) {
            num_set.add(num);
        }

        int longestStreak = 0;

        for (int num : num_set) {
            // 不包含当前值-1 ；包含时跳过，则循环到时 当前值 -1 时可以在 while循环中检查到
            if (!num_set.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                while (num_set.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }

                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;
    }

    /**
     * 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
     * <p>
     * 字母异位词 是由重新排列源单词的所有字母得到的一个新单词。
     * <p>
     * <p>
     * <p>
     * 示例 1:
     * <p>
     * 输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
     * 输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
     * 示例 2:
     * <p>
     * 输入: strs = [""]
     * 输出: [[""]]
     * 示例 3:
     * <p>
     * 输入: strs = ["a"]
     * 输出: [["a"]]
     */
    public static List<List<String>> groupAnagrams(String[] strs) {
//        List<List<String>> result = new ArrayList<>();
//        List<Integer> integers = new ArrayList<>();
//        for (int i = 0; i < strs.length; i++) {
//
//            Map<Character, Integer> oo = getCharacterIntegerMap(strs[i]);
//            List<String> item = new ArrayList<>();
//            if (!integers.contains(i)) {
//                item.add(strs[i]);
//            }
//
//            for (int j = i+1; j < strs.length; j++) {
//                if(integers.contains(j)){
//                    continue;
//                }
//                String it2 = strs[j];
//                Map<Character, Integer> oo2 = getCharacterIntegerMap(it2);
//
//                if (oo2.size() == oo.size() && equals2(oo, oo2)) {
//                    item.add(it2);
//                    integers.add(j);
//                }
//            }
//            if (item.size() > 0) {
//
//                result.add(item);
//            }
//        }
//
//
//        return result;

//        Map<String, List<String>> map = new HashMap<>();
//        for (String str : strs) {
//            char[] array = str.toCharArray();
//            Arrays.sort(array);
//            String key = new String(array);
//            List<String> list = map.getOrDefault(key, new ArrayList<>());
//            list.add(str);
//            map.put(key, list);
//        }
//        return new ArrayList<>(map.values());


            Map<String, List<String>> map = new HashMap<String, List<String>>();
            for (String str : strs) {
                int[] counts = new int[26];
                int length = str.length();
                // 获取字符串中的单个字符出现的次数，
                // 例如： abbc
                // 得到： counts = [1,2,1,...]
                for (int i = 0; i < length; i++) {
                    counts[str.charAt(i) - 'a']++;
                }
                // 将每个出现次数大于 0 的字母和出现次数按顺序拼接成字符串，作为哈希表的键
                StringBuffer sb = new StringBuffer();

                // 将 单个字符+其出现的次数 构造为hash的键
                // 例如： abbc
                // 得到： sb.toString = "a1b2c3"
                for (int i = 0; i < 26; i++) {
                    if (counts[i] != 0) {
                        sb.append((char) ('a' + i));
                        sb.append(counts[i]);
                    }
                }
                String key = sb.toString();
                List<String> list = map.getOrDefault(key, new ArrayList<String>());
                list.add(str);
                map.put(key, list);
            }
            return new ArrayList<List<String>>(map.values());



    }
}
