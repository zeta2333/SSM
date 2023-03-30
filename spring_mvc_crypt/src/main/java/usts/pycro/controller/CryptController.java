package usts.pycro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import usts.pycro.utils.SwapCharCrypt;

import java.util.Map;

/**
 * @author Pycro
 * @version 1.0
 * 2023-03-30 0:19
 */
@Controller
public class CryptController {
    @RequestMapping("/encrypt")
    @ResponseBody
    public String doEncrypt(@RequestBody Map<String, String> map) {
        String plain = map.get("plain");
        String keyWord = map.get("keyWord");
        long seed = SwapCharCrypt.str2long(keyWord);
        String key = SwapCharCrypt.seed2Key(seed);
        return SwapCharCrypt.encrypt(plain, seed, key);
    }

    @RequestMapping("/decrypt")
    @ResponseBody
    public String doDecrypt(@RequestBody Map<String, String> map) {
        String cipher = map.get("cipher");
        String keyWord = map.get("keyWord");
        long seed = SwapCharCrypt.str2long(keyWord);
        String key = SwapCharCrypt.seed2Key(seed);
        return SwapCharCrypt.decrypt(cipher, seed, key);
    }
}

