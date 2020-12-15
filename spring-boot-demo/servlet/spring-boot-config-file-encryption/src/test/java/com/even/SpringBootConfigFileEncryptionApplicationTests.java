package com.even;

import org.jasypt.encryption.StringEncryptor;
import org.jasypt.util.text.BasicTextEncryptor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootConfigFileEncryptionApplicationTests {

    @Autowired
    private StringEncryptor stringEncryptor;

    @Test
    public void contextLoads() {
        String mysqlPassWord="UI.com1234qwer";
        String encryptMysql= stringEncryptor.encrypt(mysqlPassWord);
        String decryptMysql=stringEncryptor.decrypt(encryptMysql);
        System.out.println(encryptMysql);
        System.out.println(decryptMysql);
    }

    /**
     * 设置密钥
     * 这里每次加密的字符串都不一样确可以通过密钥解密出相同的明文
     */
    @Test
    public void setPassword(){

        BasicTextEncryptor basicTextEncryptor = new BasicTextEncryptor();
        // application.properties, jasypt.encryptor.password
        basicTextEncryptor.setPassword("renrenxiangxue");
        String mysqlPassWord="rrxx123456789";
        String rootOne=basicTextEncryptor.encrypt(mysqlPassWord);
        String rootTwo=basicTextEncryptor.encrypt(mysqlPassWord);
        String rootTree=basicTextEncryptor.encrypt(mysqlPassWord);
        // encrypt mysqlPassWord
        System.out.println(rootOne);
        System.out.println(rootTwo);
        System.out.println(rootTree);
        // decrypt, the result is mysqlPassWord
        System.out.println(basicTextEncryptor.decrypt(rootOne));
        System.out.println(basicTextEncryptor.decrypt(rootTwo));
        System.out.println(basicTextEncryptor.decrypt(rootTree));
    }

}
