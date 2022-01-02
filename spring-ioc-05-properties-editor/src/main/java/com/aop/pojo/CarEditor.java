package com.aop.pojo;

import java.beans.PropertyEditorSupport;

// 代码清单6-7
// 自定义属性编辑器
/*
  命名规范：如果属性编辑器和目标类型在同一个包下，且命名符合命名规范(xxxEditor),则不需要配置映射关系
 */
public class CarEditor extends PropertyEditorSupport {


    // 覆盖父类的方法
    // ① 将字面值转换为属性类型对象
    public void setAsText(String text) {
        if (text == null || text.indexOf(",") == -1) {
            throw new IllegalArgumentException("设置的字符串格式不正确");
        }
        String[] infos = text.split(",");
        Car car = new Car();
        car.setBrand(infos[0]);
        car.setMaxSpeed(Integer.parseInt(infos[1]));
        car.setPrice(Double.parseDouble(infos[2]));
        // ② 调用父类的方法
        // 设置转换后的属性对象
        setValue(car);
    }
}
