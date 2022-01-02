package com.aop.encrypt;

import com.aop.util.DESUtils;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

//@Component
public class EncryptPropertyPlaceholderConfigurer extends PropertyPlaceholderConfigurer {
    private String[] encryptPropNames = {"userName", "password"};

    // 基于注解扫描的方式注册bean，通过构造方法初始化其属性
    // 也可以将它单独放到一个配置文件中
    public EncryptPropertyPlaceholderConfigurer() {
        Resource resource = new ClassPathResource("jdbc.properties");
        this.setLocation(resource);
    }

    @Override
    protected String convertProperty(String propertyName, String propertyValue) {
        if (isEncryptProp(propertyName)) {
            String decryptValue = DESUtils.getDecryptString(propertyValue);
            System.out.println(decryptValue);
            return decryptValue;
        } else {
            return propertyValue;
        }
    }

    /**
     * 判断是否是加密的属性
     *
     * @param propertyName
     * @return
     */
    private boolean isEncryptProp(String propertyName) {
        for (String encryptPropName : encryptPropNames) {
            if (encryptPropName.equals(propertyName)) {
                return true;
            }
        }
        return false;
    }
}
