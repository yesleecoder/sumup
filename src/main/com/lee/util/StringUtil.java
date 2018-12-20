package main.com.lee.util;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 字符串工具类　判断字符空，非空
 */
public class StringUtil {

    /**
     *  判断字符空
     * @param str
     * @return
     */
    public static boolean isEmpty(String str) {
        if (str == null || "".equals(str.trim())) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 判断字符非空
     * @param str
     * @return
     */
    public static boolean isNotEmpty(String str) {
        if ((str != null) && !"".equals(str.trim())) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 字符加入 %% 用于模糊查询
     * @param str
     * @return
     */
    public static String formatLike(String str) {
        if (isNotEmpty(str)) {
            return "%" + str + "%";
        } else {
            return null;
        }
    }

    private static final Pattern IMAGE_PATTERN = Pattern
            .compile(
                    "\\[img\\]\\s*(.+?)\\s*,\\s*(.+?)\\s*\\[/img\\]",
                    Pattern.CASE_INSENSITIVE);

    private static final Pattern BR_PATTERN = Pattern.compile("$",
            Pattern.MULTILINE);

    private static final Pattern RE_IMAGE_PATTERN = Pattern
            .compile(
                    "<\\s*img\\s*title\\s*=\\s*'(.*?)'\\s*alt\\s*=\\s*'(.*?)'\\s*src\\s*=\\s*'(.*?)'\\s*>\\s*<\\s*/img\\s*>",
                    Pattern.CASE_INSENSITIVE);

    private static final char[] HEX_DIGIT = { '0', '1', '2', '3', '4', '5',
            '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };

    public static boolean isNull(String s) {
        return s == null || s.trim().equals("");
    }

    public static String getRandomFileName() {
        char[] chars = new char[36];
        for (int i = 0; i < 10; ++i) {
            chars[i] = (char) (i + '0');
        }
        for (int i = 0; i < 26; ++i) {
            chars[i + 10] = (char) (i + 'a');
        }

        String fileName = System.currentTimeMillis() + "_";
        try {
            Thread.sleep(1);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Random r = new Random();
        for (int i = 0; i < 10; ++i) {
            fileName += chars[r.nextInt(36)];
        }
        return fileName;
    }

    public static String getFileExtension(String fileName) {
        if (fileName.lastIndexOf('.') != -1) {
            return fileName.substring(fileName.lastIndexOf('.'));
        }
        return "";
    }



    public static String fromStringToHtml(String content, String basePath) {
        Matcher m = IMAGE_PATTERN.matcher(content);
        String result = m.replaceAll("<img title='$1' alt='$1' src='"
                + basePath + "/images/$2'></img>");

        m = BR_PATTERN.matcher(result);
        result = m.replaceAll("<br/>");

        return result;
    }

    public static char fromIntegerToChar(int i) {
        return (char) (i + 'A');
    }

    public static String fromdbAnswerToTrueAnswer(String dbAnswer) {
        String[] selected = dbAnswer.split("_");
        String answer = "";
        char current = 'A';
        for (String s : selected) {
            if (Integer.parseInt(s) != 0) {
                answer += current;
            }
            ++current;
        }

        return answer;

    }

    public static String bytesToHex(byte[] bytes) {
        String result = "";
        for (byte b : bytes) {
            int height = (b & 0xf0) >> 4;
            int low = (b & 0x0f);
            result += HEX_DIGIT[height];
            result += HEX_DIGIT[low];
        }

        return result;
    }

    public static Map<String, String> parseDN(String dn) {
        Map<String, String> map = new HashMap<String, String>();
        String[] kvs = dn.split(",|=");
        for (int i = 0; i < kvs.length - 1; i += 2) {
            map.put(kvs[i].trim(), kvs[i + 1].trim());
        }

        return map;
    }

    public static void main(String[] args) {
        System.out.println(fromStringToHtml("[img]image_h.png,1365059945386_8kl5zsw6qn/1365059946435_bquco8b81j.png[/img]", "/tmp"));
    }
}
