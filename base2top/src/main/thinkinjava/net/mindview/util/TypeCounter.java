//: net/mindview/util/TypeCounter.java
// Counts instances of a type family.
package net.mindview.util;

import java.util.HashMap;

/**
 * 递归计数
 *
 * @author fengyu
 * @date 2015年8月9日
 */
public class TypeCounter extends HashMap<Class<?>, Integer> {

    private Class<?> baseType;

    public TypeCounter(Class<?> baseType) {
        this.baseType = baseType;
    }

    /**
     * 获取其参数的Class,然后使用isAssignableFrom()来执行运行时检查,以校验你传递的对象确实属于我们感兴趣的继承结构
     *
     * @param obj
     * @author fengyu
     * @date 2015年8月12日
     */
    public void count(Object obj) {
        Class<?> type = obj.getClass();
        if (!baseType.isAssignableFrom(type))
            throw new RuntimeException(obj + " incorrect type: " + type + ", should be type or subtype of " + baseType);
        countClass(type);
    }

    /**
     * 首先对该类的确切类型进行计数,然后,如果其超类可以复制给baseType,countClass()将其超类上递归计数
     *
     * @param type
     * @author fengyu
     * @date 2015年8月12日
     */
    private void countClass(Class<?> type) {
        Integer quantity = get(type);
        put(type, quantity == null ? 1 : quantity + 1);
        Class<?> superClass = type.getSuperclass();
        //isAssignableFrom来执行运行时检查,以校验你传递的对象确实属于感兴趣的继承结构
        if (superClass != null && baseType.isAssignableFrom(superClass))
            countClass(superClass);
    }

    public String toString() {
        StringBuilder result = new StringBuilder("{");
        for (Entry<Class<?>, Integer> pair : entrySet()) {
            result.append(pair.getKey().getSimpleName());
            result.append("=");
            result.append(pair.getValue());
            result.append(", ");
        }
        result.delete(result.length() - 2, result.length());
        result.append("}");
        return result.toString();
    }
} // /:~
