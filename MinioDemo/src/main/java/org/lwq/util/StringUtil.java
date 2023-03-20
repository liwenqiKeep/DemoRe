package org.lwq.util;

/**
 * @author liwenqi
 */
public class StringUtil {

    public static boolean isEmpty(String str, boolean trimFlag) {
        if (trimFlag) {
            str = str.trim();
        }
        return str == null || "".equals(str);
    }
}
