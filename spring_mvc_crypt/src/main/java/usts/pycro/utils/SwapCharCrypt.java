package usts.pycro.utils;

import java.math.BigInteger;
import java.util.*;

/**
 * @Author Pycro
 * @Create 2023-03-13  23:33
 * @Description
 * @Version 1.0
 */
public class SwapCharCrypt {
    private static final Map<Character, Character>
            encryptMap = new HashMap<>(),
            decryptMap = new HashMap<>();

    private static final DynamicDESUtil DES = new DynamicDESUtil();


    // 生成秘钥
    public static void generateSK(long seed) {
        List<Character>
                encryptList = new ArrayList<>(),
                copyList = new ArrayList<>();
        // 添加小写字母
        for (int i = 0; i < 6; i++) {
            copyList.add((char) (i + 97));
            encryptList.add((char) (i + 97));
        }
        //添加数字
        for (int i = 0; i < 10; i++) {
            copyList.add((char) (i + 48));
            encryptList.add((char) (i + 48));
        }
        // 生成加密秘钥和解密秘钥的对称映射关系
        Collections.shuffle(encryptList, new Random(seed));
        for (int i = 0; i < encryptList.size(); i++) {
            encryptMap.put(copyList.get(i), encryptList.get(i));
            decryptMap.put(encryptList.get(i), copyList.get(i));
        }
    }

    // 加密or解密
    //public static String change(String srcText, int flag, long seed, String key) {
    //    generateSK(seed);
    //    String resultText = flag == 0 ? DES.encryption(srcText, key, seed) : DES.decryption(srcText, key, seed);
    //    StringBuilder targetText = new StringBuilder();
    //    Map<Character, Character> operateMap = flag == 0 ? encryptMap : decryptMap;
    //    for (int i = 0; i < resultText.length(); i++) targetText.append(operateMap.get(resultText.charAt(i)));
    //    return targetText.toString();
    //}

    //加密
    public static String encrypt(String srcText, long seed, String key) {
        generateSK(seed);
        String resultText = DES.encryption(srcText, key, seed);
        StringBuilder targetText = new StringBuilder();
        for (int i = 0; i < resultText.length(); i++) targetText.append(encryptMap.get(resultText.charAt(i)));
        return targetText.toString();
    }

    //解密
    public static String decrypt(String srcText, long seed, String key) {
        generateSK(seed);
        StringBuilder targetText = new StringBuilder();
        for (int i = 0; i < srcText.length(); i++) targetText.append(decryptMap.get(srcText.charAt(i)));
        return DES.decryption(targetText.toString(), key, seed);
    }

    //将输入的字符串转换成long类型的随机数种子
    public static long str2long(String input) {
        byte[] chars = input.trim().getBytes();
        StringBuilder builder = new StringBuilder();
        for (byte ch : chars) builder.append(Math.abs(ch));
        BigInteger bigInt = new BigInteger(builder.toString());
        BigInteger longMax = BigInteger.valueOf(Long.MAX_VALUE);
        if (bigInt.compareTo(longMax) > 0) bigInt = bigInt.mod(longMax);
        return bigInt.longValue();
    }

    //将随机数种子转换成秘钥
    public static String seed2Key(long seed) {
        char[] sch = String.valueOf(seed).toCharArray();
        List<Character> scList = new ArrayList<>();
        for (char c : sch) scList.add(c);
        Collections.shuffle(scList, new Random(seed));
        StringBuilder builder = new StringBuilder();
        for (Character c : scList) builder.append(c);
        return builder.toString();
    }
}
