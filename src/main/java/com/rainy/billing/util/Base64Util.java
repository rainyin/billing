package com.rainy.billing.util;

import java.io.IOException;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 * Title: Base64加密工具<br>
 * Description: <br>
 * Project: 亿阳物流 <br>
 * Company: Finalist IT Group <br> 
 * Copyright: 2010 www.rainy.cn Inc. All rights reserved. <br>
 * Date: May 5, 2010
 * 
 * @author Neil
 * @version 1.0
 */
public class Base64Util {

    /**
     * base64加密
     * @param value
     * @return
     */
    public static String encode(String value) {
        BASE64Encoder encoder = new BASE64Encoder();
        return encoder.encode(value.getBytes());
    }

    /**
     * base64加密
     * @param value
     * @return
     */
    public static String encode(byte[] value) {
        BASE64Encoder encoder = new BASE64Encoder();
        return encoder.encode(value);
    }

    /**
     * base64解密
     * @param value
     * @return
     */
    public static String decode(String value) {
        BASE64Decoder decode = new BASE64Decoder();
        try {
            return new String(decode.decodeBuffer(value), "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    
}
