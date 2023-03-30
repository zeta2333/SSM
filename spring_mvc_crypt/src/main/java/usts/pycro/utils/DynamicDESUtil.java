package usts.pycro.utils;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author Pycro
 * @Create 2023-03-13  22:03
 * @Description
 * @Version 1.0
 */
public class DynamicDESUtil {

    private static final String STR_16 = "0123456789ABCDEF";

    /**
     * DES加密
     *
     * @param msg 明文消息
     * @param key 明文秘钥
     * @return 16进制密文字符串
     */
    public String encryption(String msg, String key, long seed) {
        init(seed);
        //检查二进制字符串是否是64位
        String msgbin = Check64(hex2Bin(str2Hex(msg)));
        String keybin = Check64(hex2Bin(str2Hex(key)));
        //正则获取匹配的值
        String[] msgs = regex(msgbin, ".{64}");
        String k = regex(keybin, ".{64}")[0];
        //生成16组秘钥
        String[] keys = generateKey(k);
        StringBuilder mm = new StringBuilder();
        //依次把二进制流和秘钥进行加密
        for (String binmsg : msgs) {
            mm.append(Wheel(binmsg, keys));
        }
        //二进制结果转16进制
        return bin2Hex(mm.toString().trim()).toLowerCase();
    }

    /**
     * DES解密
     *
     * @param cipher 16进制密文
     * @param key    解密/加密 秘钥
     * @return 明文字符串
     */
    public String decryption(String cipher, String key, long seed) {
        init(seed);
        String msgbin = hex2Bin(cipher);
        key = Check64(hex2Bin(str2Hex(key)));
        String[] cpbin = regex(msgbin, ".{64}");
        String k = regex(key, ".{64}")[0];
        String[] keys = generateKey(k);
        Collections.reverse(Arrays.asList(keys)); //反转数组
        StringBuilder mm = new StringBuilder();
        for (String binmsg : cpbin) {
            mm.append(Wheel(binmsg, keys));
        }
        return hex2Str(bin2Hex(mm.toString().trim())).trim();

    }
    // =========进制转换===============

    /**
     * 字符串转十六进制字符串
     *
     * @param str String
     * @return HexString
     */
    public String str2Hex(String str) {
        char[] chars = STR_16.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        byte[] bytes = str.getBytes();
        for (byte b : bytes) {
            stringBuilder.append(chars[(b & 0xf0) >> 4]);
            stringBuilder.append(chars[(b & 0xf)]);
        }
        return stringBuilder.toString().trim().toLowerCase();
    }

    /**
     * 十六进制字符串转字符串
     *
     * @param hexStr
     * @return
     */
    public String hex2Str(String hexStr) {
        byte[] bytes = new byte[hexStr.length() / 2];
        char[] hex = hexStr.toUpperCase().toCharArray();
        int i;
        for (int j = 0; j < bytes.length; j++) {
            i = STR_16.indexOf(hex[j * 2]) << 4;
            i += STR_16.indexOf(hex[j * 2 + 1]);
            bytes[j] = (byte) i;
        }
        return new String(bytes);
    }

    public String hex2Bin(String hexStr) {
        char[] hexchr = hexStr.toLowerCase().toCharArray();
        StringBuilder binStr = new StringBuilder();
        for (char i : hexchr) {
            String bin = Integer.toBinaryString(Integer.parseInt(String.valueOf(i), 16));
            if (bin.length() < 4) {
                bin = String.join("", Collections.nCopies(4 - bin.length(), "0")) + bin;
            }
            binStr.append(bin);
        }
        return binStr.toString();
    }

    public String bin2Hex(String bin) {
        char[] chars = STR_16.toCharArray();
        String[] h4 = regex(bin, ".{4}");
        StringBuilder hexstr = new StringBuilder();
        for (String s : h4) {
            hexstr.append(chars[Integer.parseInt(s, 2)]);
        }
        return hexstr.toString().trim();
    }

    /**
     * 检查二进制字符串是否是64位
     *
     * @param binStr str
     * @return str64
     */
    public String Check64(String binStr) {
        int num = binStr.length() % 64;
        if (num != 0) {
            //补0
            binStr += String.join("", Collections.nCopies(64 - num, "0"));
        }
        return binStr;
    }

    /**
     * 正则获取匹配的值
     *
     * @param str   字符串
     * @param regex 正则表达式
     * @return String[]
     */
    public String[] regex(String str, String regex) {
        Matcher matcher = Pattern.compile(regex).matcher(str);
        List<String> list = new ArrayList<>();
        while (matcher.find()) {
            list.add(matcher.group(0));
        }
        String[] strings = new String[list.size()];
        list.toArray(strings);
        return strings;
    }

    /**
     * 0 1 的异或
     *
     * @param left  二进制字符串
     * @param right 二进制字符串
     * @return xor
     */
    public String xor(String left, String right) {
        StringBuilder str = new StringBuilder();
        char[] leftchr = left.toCharArray();
        char[] rightchr = right.toCharArray();
        for (int i = 0; i < leftchr.length; i++) {
            str.append(leftchr[i] ^ rightchr[i]);
        }
        return str.toString().trim();
    }

    /**
     * F函数的实现
     *
     * @param bin32 64位明文的右边32位
     * @param key   当前轮的加密秘钥
     * @return
     */
    public String f_function(String bin32, String key) {
        //E表置换
        bin32 = Swap(bin32, E);
        // 异或，以第一个参数的长度为准
        String xor = xor(bin32, key);
        //S盒代换
        String[] slist = regex(xor, ".{6}");
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < slist.length; i++) {
            String s = slist[i];
            int h = Integer.parseInt(s.charAt(0) + s.substring(5), 2);
            int l = Integer.parseInt(s.substring(1, 5), 2);
            String i1 = Integer.toBinaryString(S[i][h * 16 + l]);
            if (i1.length() < 4) {
                i1 = String.join("", Collections.nCopies(4 - i1.length(), "0")) + i1;
            }
            builder.append(i1);
        }
        //P置换
        String trim = builder.toString().trim();
        return Swap(trim, P);
    }

    /**
     * 轮函数
     *
     * @param bin64 64位明文二进制
     * @param keys  16组秘钥
     * @return
     */
    public String Wheel(String bin64, String[] keys) {
        bin64 = Swap(bin64, IP_table); // 初始置换
        String leftbin = bin64.substring(0, 32);
        String rightbin = bin64.substring(32);
        for (String key : keys) {
            String temp = rightbin;
            String f_function = f_function(rightbin, key);
            rightbin = xor(leftbin, f_function);
            leftbin = temp;
        }
        return Swap(rightbin + leftbin, IP_re_table);
    }

    /**
     * 生成16组秘钥
     *
     * @param binKey 初始秘钥的二进制
     * @return keys[]
     */
    public String[] generateKey(String binKey) {
        List<String> list = new ArrayList<>();
        String leftbin, rightbin;
        binKey = Swap(binKey, PC_1);
        leftbin = binKey.substring(0, 28);
        rightbin = binKey.substring(28, 56);
        for (int j : SHIFT) {
            int i = j + 1;
            leftbin = leftbin.substring(i) + leftbin.substring(0, i);
            rightbin = rightbin.substring(i) + rightbin.substring(0, i);
            list.add(Swap(leftbin + rightbin, PC_2));
        }
        return list.toArray(new String[0]);
    }

    /**
     * 置换运算
     *
     * @param swap  待置换的字符串
     * @param table 置换表
     * @return 置换后的字符串
     */
    public static String Swap(String swap, int[] table) {
        char[] array = swap.toCharArray();
        StringBuilder string = new StringBuilder();
        for (int i = 0; i < table.length; i++) {
            string.append(array[table[i] - 1]);
        }
        return string.toString().trim();
    }


    public static void init(long seed) {
        Random random = new Random(seed);
        List<Integer> ipTableList = new ArrayList<>(),
                pList = new ArrayList<>(),
                pc_1List = new ArrayList<>(),
                sList = new ArrayList<>();
        for (int i = 0; i < 64; i++) {
            ipTableList.add(i + 1);
            if (i % 8 != 0) pc_1List.add(i);
            if (i < 32) pList.add(i + 1);
            if (i < 16) {
                SHIFT[i] = random.nextInt(27) + 1;
                sList.add(i);
            }
        }

        //打乱
        Collections.shuffle(ipTableList, random);
        Collections.shuffle(pList, random);
        Collections.shuffle(pc_1List, random);
        //Collections.shuffle(sList, random);

        //对IP_table和IP_re_table进行初始化
        IP_table = ipTableList.stream().mapToInt(Integer::intValue).toArray();
        for (int i = 0; i < IP_table.length; i++) IP_re_table[IP_table[i] - 1] = i + 1;

        //对P进行初始化
        P = pList.stream().mapToInt(Integer::intValue).toArray();

        //对PC_1进行初始化
        PC_1 = pc_1List.stream().mapToInt(Integer::intValue).toArray();

        //对S盒初始化
        for (int i = 0; i < 8; i++) {
            List<Integer> tempList = new ArrayList<>();
            for (int j = 0; j < 4; j++) {
                Collections.shuffle(sList, new Random(++seed));
                tempList.addAll(sList);
            }
            S[i] = tempList.stream().mapToInt(Integer::intValue).toArray();
        }
    }

    private static int[] PC_1 = new int[56];

    private static final int[] PC_2 = {// 8*6  1-32的有规律地出现，随机分布,不可随机排列
            14, 17, 11, 24, 5, 1, 3, 28,
            15, 6, 21, 10, 23, 19, 12, 4,
            26, 8, 16, 7, 27, 20, 13, 2,
            41, 52, 31, 37, 47, 55, 30, 40,
            51, 45, 33, 48, 44, 49, 39, 56,
            34, 53, 46, 42, 50, 36, 29, 32
    };

    public static final int[] SHIFT = new int[16];

    //S盒，长度为8，对应着48bit分成的8个6bit的小块，行取首尾2bit，为4，列取中间4bit，为16
    //输出为4bit，即0~15
    private static int[][] S = new int[8][64];

    private static int[] P = new int[32];

    private static final int[] E = { // 6*8
            32, 1, 2, 3, 4, 5, 4, 5,
            6, 7, 8, 9, 8, 9, 10, 11,
            12, 13, 12, 13, 14, 15, 16, 17,
            16, 17, 18, 19, 20, 21, 20, 21,
            22, 23, 24, 25, 24, 25, 26, 27,
            28, 29, 28, 29, 30, 31, 32, 1
    };

    private static int[] IP_table = new int[64];

    private static int[] IP_re_table = new int[64];

}