package cn.feng.utils.apache.utils;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.BeanUtilsBean;
import org.junit.BeforeClass;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;

public class BeanUtilsTest {

    static BeanTwo beanTwo = null;

    @BeforeClass
    public static void init() {
        beanTwo = new BeanTwo();
        beanTwo.setAge(23);
        beanTwo.setBirthday(new Date());
        beanTwo.setName("sd");
        beanTwo.setSalary(23.50);
        beanTwo.setSex('男');
        //beanTwo.setFlag(false);
    }

    /**
     * JavaBean属性克隆 为
     * bean创建一个clone对象,方法返回类型为Object.注意bean即使没有实现java.lang.Cloneable接口,此方法依然有效.
     * 此方法的实现机制建立在bean提供的一系列的getters和setters的基础之上.此方法的正常使用代码非常简单,故略掉.
     */
    @SuppressWarnings("deprecation")
    @Test
    public void testClone() throws IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchMethodException {

        System.out.println(beanTwo);
        //BeanUtils.setDebug(-1);
        BeanTwo cloneBean = (BeanTwo) BeanUtils.cloneBean(beanTwo);
        System.out.println(cloneBean);


    }
    /**
     * 并且属性个数相同,属性名完全相同的之间进行属性值复制
     *
     * @throws Exception
     */
    @Test
    public void testCopyProperties() throws Exception {
        BeansOne beansOne = new BeansOne();
        System.out.println(beansOne);
        System.out.println(beanTwo);
        BeanUtilsBean beanUtilsBean = BeanUtilsBean.getInstance();
        //	BeanUtils.copyProperties(beansOne, beanTwo);
        System.out.println(beansOne);
        beanUtilsBean.copyProperties(beansOne, beanTwo);

        System.out.println(beansOne);


    }

}

//java.lang.NoClassDefFoundError: org/apache/commons/collections/FastHashMap