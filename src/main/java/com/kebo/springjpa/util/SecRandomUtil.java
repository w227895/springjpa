package com.kebo.springjpa.util;

import java.security.SecureRandom;

public class SecRandomUtil {
    /***
    * @description:  获取随机数
    * @param: []
    * @return: int
    * @author: kb
    * @date: 2019-10-12
    */
    public int getSecRandom() {
        SecureRandom secRdm;
        try {
            secRdm = SecureRandom.getInstance("SHA1PRNG");
        } catch (Exception e) {
            return 91820028;
        }

        return Math.abs(secRdm.nextInt());
    }

}