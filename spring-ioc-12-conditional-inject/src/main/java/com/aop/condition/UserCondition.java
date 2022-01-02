package com.aop.condition;

import com.aop.anno.UserAnno;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.annotation.MergedAnnotation;
import org.springframework.core.annotation.MergedAnnotations;
import org.springframework.core.type.AnnotatedTypeMetadata;

import java.util.Map;

public class UserCondition implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {

        // 得到的是 @Conditional注解所在方法或类上的注解
        //MergedAnnotations annotations = metadata.getAnnotations();
        //Object[] objects = annotations.stream().toArray();
        //for (Object object : objects) {
        //    if (object instanceof UserAnno){
        //        System.out.println(((UserAnno) object).name());
        //    }
        //}
        Map<String, Object> attributes = metadata.getAnnotationAttributes(UserAnno.class.getName());
        MergedAnnotations annotations = metadata.getAnnotations();

        MergedAnnotation<UserAnno> annotation = annotations.get(UserAnno.class);
        System.out.println(annotation.getString("name"));
        System.out.println(attributes);
        return true;
    }
}
