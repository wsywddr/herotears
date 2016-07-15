package com.wsywddr.herotears.util;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 字符串工具类
 *
 * @author liuz
 */
public class StringUtil {

    public static final String[] COUNTRY_SUFFIX = {"aero", "asia", "biz",
            "cat", "com", "coop", "edu", "eu", "gov", "info", "int", "jobs",
            "mil", "mobi", "museum", "name", "net", "org", "pro", "tel",
            "travel", "xxx", "ac", "ae", "af", "ag", "ai", "al", "am", "an",
            "ao", "aq", "ar", "as", "at", "aw", "ax", "az", "ba", "bb", "bd",
            "be", "bf", "bg", "bh", "bi", "bj", "bm", "bn", "bo", "br", "bs",
            "bt", "bv", "bw", "by", "bz", "ca", "cc", "cd", "cf", "cg", "ch",
            "ck", "cl", "cm", "cn", "co", "cr", "cs", "cu", "cv", "cx", "cy",
            "cz", "de", "dj", "dk", "dm", "do", "dz", "ec", "ee", "eg", "er",
            "es", "et", "eu", "fi", "fj", "fk", "fm", "fo", "fr", "ga", "gb",
            "gd", "ge", "gf", "gg", "gh", "gi", "gl", "gm", "gn", "gp", "gq",
            "gr", "gs", "gt", "gu", "gw", "gy", "hk", "hm", "hn", "ht", "hu",
            "id", "ie", "il", "in", "io", "iq", "ir", "je", "jm", "jo", "jp",
            "kg", "ki", "km", "kn", "kp", "kr", "kw", "ky", "kz", "la", "lb",
            "lc", "li", "lk", "lr", "ls", "lt", "lu", "lv", "ly", "ma", "mc",
            "md", "me", "mg", "mh", "mk", "ml", "mm", "mn", "mo", "mp", "mq",
            "mr", "ms", "mt", "mu", "mv", "mw", "mx", "my", "na", "nc", "ne",
            "nf", "ng", "ni", "nl", "no", "np", "nr", "nu", "nz", "om", "pa",
            "pe", "pf", "pg", "ph", "pk", "pl", "pm", "pn", "pr", "ps", "pt",
            "pw", "py", "qa", "re", "ro", "rs", "ru", "rw", "sa", "sb", "sc",
            "sd", "se", "sg", "sh", "si", "sj", "sk", "sl", "sm", "sn", "so",
            "sr", "st", "su", "sv", "sy", "sz", "tc", "td", "tf", "tg", "th",
            "tj", "tk", "tl", "tm", "tn", "to", "tp", "tr", "tt", "tv", "tw",
            "tz", "ua", "ug", "uk", "us", "uy", "uz", "va", "vc", "ve", "vg",
            "vi", "vn", "vu", "wf", "ws", "ye", "yt", "za", "zm", "zw"};

    /**
     * 格式化字符串
     *
     * @param format 字符串格式
     * @param args   替换列表（必须按照字符串所约定的顺序传入）
     * @return 格式化后的字符串
     */
    public static String format(String format, Object... args) {
        String msg = (args == null) ? format : String.format(Locale.CHINA,
                format, args);
        return msg;
    }

    /**
     * 判断字符串是否为空
     *
     * @param input
     * @return
     */
    public static boolean isEmpty(String input) {
        boolean isEmpty = true;
        if (input != null && !"".equals(input.trim())) {
            isEmpty = false;
        }
        return isEmpty;
    }

    /**
     * 去除换行、回车、空格、水平制表符 注：\n 回车( ) \t 水平制表符( ) \s 空格(\u0008) \r 换行( )
     *
     * @param str
     * @return
     */
    public static String replaceAllInvalid(String str) {
        String dest = "";
        if (!isEmpty(str)) {
            Pattern p = Pattern.compile("\\s*|\t|\r|\n");
            Matcher m = p.matcher(str);
            dest = m.replaceAll("");
        }
        return dest;
    }

    /**
     * null string to empty string
     * <p/>
     * <pre>
     * nullStrToEmpty(null) = &quot;&quot;;
     * nullStrToEmpty(&quot;&quot;) = &quot;&quot;;
     * nullStrToEmpty(&quot;aa&quot;) = &quot;aa&quot;;
     * </pre>
     *
     * @param str
     * @return
     */
    public static String nullStrToEmpty(String str) {
        return (str == null ? "" : str);
    }

    /**
     * capitalize first letter
     * <p/>
     * <pre>
     * capitalizeFirstLetter(null)     =   null;
     * capitalizeFirstLetter("")       =   "";
     * capitalizeFirstLetter("2ab")    =   "2ab"
     * capitalizeFirstLetter("a")      =   "A"
     * capitalizeFirstLetter("ab")     =   "Ab"
     * capitalizeFirstLetter("Abc")    =   "Abc"
     * </pre>
     *
     * @param str
     * @return
     */
    public static String capitalizeFirstLetter(String str) {
        if (isEmpty(str)) {
            return str;
        }

        char c = str.charAt(0);
        return (!Character.isLetter(c) || Character.isUpperCase(c)) ? str
                : new StringBuilder(str.length())
                .append(Character.toUpperCase(c))
                .append(str.substring(1)).toString();
    }

    /**
     * encoded in utf-8
     * <p/>
     * <pre>
     * utf8Encode(null)        =   null
     * utf8Encode("")          =   "";
     * utf8Encode("aa")        =   "aa";
     * utf8Encode("啊啊啊啊")   = "%E5%95%8A%E5%95%8A%E5%95%8A%E5%95%8A";
     * </pre>
     *
     * @param str
     * @return
     * @throws UnsupportedEncodingException if an error occurs
     */
    public static String utf8Encode(String str) {
        if (!isEmpty(str) && str.getBytes().length != str.length()) {
            try {
                return URLEncoder.encode(str, "UTF-8");
            } catch (UnsupportedEncodingException e) {
                throw new RuntimeException(
                        "UnsupportedEncodingException occurred. ", e);
            }
        }
        return str;
    }

    /**
     * encoded in utf-8, if exception, return defultReturn
     *
     * @param str
     * @param defultReturn
     * @return
     */
    public static String utf8Encode(String str, String defultReturn) {
        if (!isEmpty(str) && str.getBytes().length != str.length()) {
            try {
                return URLEncoder.encode(str, "UTF-8");
            } catch (UnsupportedEncodingException e) {
                return defultReturn;
            }
        }
        return str;
    }

    /**
     * get innerHtml from href
     * <p/>
     * <pre>
     * getHrefInnerHtml(null)                                  = ""
     * getHrefInnerHtml("")                                    = ""
     * getHrefInnerHtml("mp3")                                 = "mp3";
     * getHrefInnerHtml("&lt;a innerHtml&lt;/a&gt;")                    = "&lt;a innerHtml&lt;/a&gt;";
     * getHrefInnerHtml("&lt;a&gt;innerHtml&lt;/a&gt;")                    = "innerHtml";
     * getHrefInnerHtml("&lt;a&lt;a&gt;innerHtml&lt;/a&gt;")                    = "innerHtml";
     * getHrefInnerHtml("&lt;a href="baidu.com"&gt;innerHtml&lt;/a&gt;")               = "innerHtml";
     * getHrefInnerHtml("&lt;a href="baidu.com" title="baidu"&gt;innerHtml&lt;/a&gt;") = "innerHtml";
     * getHrefInnerHtml("   &lt;a&gt;innerHtml&lt;/a&gt;  ")                           = "innerHtml";
     * getHrefInnerHtml("&lt;a&gt;innerHtml&lt;/a&gt;&lt;/a&gt;")                      = "innerHtml";
     * getHrefInnerHtml("jack&lt;a&gt;innerHtml&lt;/a&gt;&lt;/a&gt;")                  = "innerHtml";
     * getHrefInnerHtml("&lt;a&gt;innerHtml1&lt;/a&gt;&lt;a&gt;innerHtml2&lt;/a&gt;")        = "innerHtml2";
     * </pre>
     *
     * @param href
     * @return <ul>
     * <li>if href is null, return ""</li>
     * <li>if not match regx, return source</li>
     * <li>return the last string that match regx</li>
     * </ul>
     */
    public static String getHrefInnerHtml(String href) {
        if (isEmpty(href)) {
            return "";
        }

        String hrefReg = ".*<[\\s]*a[\\s]*.*>(.+?)<[\\s]*/a[\\s]*>.*";
        Pattern hrefPattern = Pattern
                .compile(hrefReg, Pattern.CASE_INSENSITIVE);
        Matcher hrefMatcher = hrefPattern.matcher(href);
        if (hrefMatcher.matches()) {
            return hrefMatcher.group(1);
        }
        return href;
    }

    /**
     * process special char in html
     * <p/>
     * <pre>
     * htmlEscapeCharsToString(null) = null;
     * htmlEscapeCharsToString("") = "";
     * htmlEscapeCharsToString("mp3") = "mp3";
     * htmlEscapeCharsToString("mp3&lt;") = "mp3<";
     * htmlEscapeCharsToString("mp3&gt;") = "mp3\>";
     * htmlEscapeCharsToString("mp3&amp;mp4") = "mp3&mp4";
     * htmlEscapeCharsToString("mp3&quot;mp4") = "mp3\"mp4";
     * htmlEscapeCharsToString("mp3&lt;&gt;&amp;&quot;mp4") = "mp3\<\>&\"mp4";
     * </pre>
     *
     * @param source
     * @return
     */
    public static String htmlEscapeCharsToString(String source) {
        return StringUtil.isEmpty(source) ? source : source
                .replaceAll("&lt;", "<").replaceAll("&gt;", ">")
                .replaceAll("&amp;", "&").replaceAll("&quot;", "\"");
    }

    /**
     * transform half width char to full width char
     * <p/>
     * <pre>
     * fullWidthToHalfWidth(null) = null;
     * fullWidthToHalfWidth("") = "";
     * fullWidthToHalfWidth(new String(new char[] {12288})) = " ";
     * fullWidthToHalfWidth("！＂＃＄％＆) = "!\"#$%&";
     * </pre>
     *
     * @param s
     * @return
     */
    public static String fullWidthToHalfWidth(String s) {
        if (isEmpty(s)) {
            return s;
        }

        char[] source = s.toCharArray();
        for (int i = 0; i < source.length; i++) {
            if (source[i] == 12288) {
                source[i] = ' ';
                // } else if (source[i] == 12290) {
                // source[i] = '.';
            } else if (source[i] >= 65281 && source[i] <= 65374) {
                source[i] = (char) (source[i] - 65248);
            } else {
                source[i] = source[i];
            }
        }
        return new String(source);
    }

    /**
     * transform full width char to half width char
     * <p/>
     * <pre>
     * halfWidthToFullWidth(null) = null;
     * halfWidthToFullWidth("") = "";
     * halfWidthToFullWidth(" ") = new String(new char[] {12288});
     * halfWidthToFullWidth("!\"#$%&) = "！＂＃＄％＆";
     * </pre>
     *
     * @param s
     * @return
     */
    public static String halfWidthToFullWidth(String s) {
        if (isEmpty(s)) {
            return s;
        }

        char[] source = s.toCharArray();
        for (int i = 0; i < source.length; i++) {
            if (source[i] == ' ') {
                source[i] = (char) 12288;
                // } else if (source[i] == '.') {
                // source[i] = (char)12290;
            } else if (source[i] >= 33 && source[i] <= 126) {
                source[i] = (char) (source[i] + 65248);
            } else {
                source[i] = source[i];
            }
        }
        return new String(source);
    }

    /**
     * 返回一个有逗号(,)隔开的字符串
     *
     * @param array
     * @return the {@code String} representation of {@code array}.
     */
    public static String toString(String[] array) {
        if (array == null) {
            return "null"; //$NON-NLS-1$
        }
        if (array.length == 0) {
            return ""; //$NON-NLS-1$
        }
        StringBuilder sb = new StringBuilder(array.length * 5);
        sb.append(array[0]);
        for (int i = 1; i < array.length; i++) {
            sb.append(","); //$NON-NLS-1$
            sb.append(array[i]);
        }
        return sb.toString();
    }

    public static String toString(List<String> list) {
        if (list == null) {
            return "null"; //$NON-NLS-1$
        }
        int length = list.size();
        if (length == 0) {
            return ""; //$NON-NLS-1$
        }
        StringBuilder sb = new StringBuilder(length * 5);
        sb.append(list.get(0));
        for (int i = 1; i < length; i++) {
            sb.append(","); //$NON-NLS-1$
            sb.append(list.get(i));
        }
        return sb.toString();
    }

    /**
     * /** Check whether the characters are all numbers
     *
     * @param str
     * @return
     */
    public static boolean IsPhoneNumber(String str) {
        if (Pattern.compile("^\\+?[0-9]*").matcher(str).matches())
            return true;
        else
            return false;
    }

    /**
     * Checking whether the characters is a email
     *
     * @param str
     * @return
     */
    public static boolean IsEmailAddr(String str) {
        String estr = "^[a-zA-Z0-9._-]{1,}@[a-zA-Z0-9_-]{1,}(.([a-zA-Z0-9]){2,3}){1,3}$";
        if (Pattern.compile(estr).matcher(str).matches()) {
            String[] suffix = str.substring(str.indexOf("@") + 1).split("\\.");
            if (suffix.length <= 1) {
                return false;
            }
            for (int i = 0; i < COUNTRY_SUFFIX.length; i++) {
                if (COUNTRY_SUFFIX[i].equals(suffix[suffix.length - 1])) {
                    return true;
                }
            }
            return false;
        } else
            return false;
    }

    /**
     * 判断字符串是否是数字
     *
     * @param str
     * @return
     */
    public static boolean isNumeric(String str) {
        Pattern pattern = Pattern.compile("[0-9]*");
        return pattern.matcher(str).matches();
    }

    /**
     * 判断昵称格式
     *
     * @param str
     * @return
     */
    public static boolean isNickName(String str) {
        Pattern pattern = Pattern.compile("[a-zA-Z0-9_]*");
        return pattern.matcher(str).matches();
    }

    /**
     * 判断昵称是否有非法字符
     *
     * @param str
     * @return
     */
    public static boolean IsIllegal(String str) {
        String regEx = "^[\u4e00-\u9fa5_a-zA-Z0-9]+$";
        Pattern pattern = Pattern.compile(regEx);
        return pattern.matcher(str).matches();
    }

    /**
     * Checking whether the characters is legal characters
     *
     * @param str
     * @return
     */
    public static boolean IsLegalName(String str) {
        String estr = "[a-zA-Z0-9.'-_ \u4e00-\u9fa5]{0,16}";
        if (Pattern.compile(estr).matcher(str).matches()) {
            return true;
        }
        return false;
    }

    public static String getDataStr(String str) {
        String b = "";
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != '-' && str.charAt(i) != ':'
                    && str.charAt(i) != ' ') {
                b = b + String.valueOf(str.charAt(i));
            }

        }
        return b;
    }

    // /**
    // * 判断字符串是否为json
    // *
    // * @param json
    // * @return
    // */
    // public static boolean isJson(String json) {
    // if (TextUtils.isEmpty(json)) {
    // return false;
    // }
    // try {
    // new JsonParser().parse(json);
    // return true;
    // } catch (JsonSyntaxException e) {
    // // TODO Auto-generated catch block
    // return false;
    // }
    // }

    /**
     * 获取输入字符中的中文字符数
     *
     * @param content
     * @return
     * @throws UnsupportedEncodingException
     * @author liuz
     */
    public static int getNumOfChineseChar(String content)
            throws UnsupportedEncodingException {
        // TODO Auto-generated method stub
        int numOfChineseChar = 0;
        for (int i = 0; i < content.length(); i++) {
            if (isChineseChar((int) content.charAt(i))) {
                numOfChineseChar++;
            }
        }
        return numOfChineseChar;
    }

    /**
     * 判断字符是否为中文（根据Unicode）
     *
     * @param tempChar
     * @return
     * @author liuz
     */
    private static Boolean isChineseChar(int tempChar) {
        // TODO Auto-generated method stub
        return 19968 <= tempChar && tempChar < 40623 ? true : false;
    }

}
