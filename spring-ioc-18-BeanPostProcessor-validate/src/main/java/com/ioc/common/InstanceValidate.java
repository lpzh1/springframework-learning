package com.ioc.common;

public interface InstanceValidate {
    /**
     *  验证 bean 实例是否已经被正确初始化。由 BeanPostProcessor 调用
     */
    public void validateInstance();
}
