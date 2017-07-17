//: annotations/database/DBTable.java
package cn.feng.thinkInJava.b2_1_注解.annotations.database;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 告诉注解处理器,你需要为我生成一个数据表
 *
 * @author fengyu
 * @date 2015年8月9日
 */
//@Target注解的每一个ElementType都是一个约束,他告诉编译器这个自定义的注解只能应用于该类型
@Target(ElementType.TYPE) // Applies to classes only
@Retention(RetentionPolicy.RUNTIME)
public @interface DBTable {

    String name() default "";//创建数据库提供表名
} ///:~
