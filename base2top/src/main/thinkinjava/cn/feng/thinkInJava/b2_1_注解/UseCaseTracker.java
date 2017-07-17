package cn.feng.thinkInJava.b2_1_注解;

//: annotations/UseCaseTracker.java

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 注解处理器
 */
public class UseCaseTracker {

    public static void trackUseCases(List<Integer> useCases, Class<?> cl) {
        for (Method m : cl.getDeclaredMethods()) {

		/*	如果没有用来读取注解的工具,那注解不会比注释更有用 
            通过Class Method Filed的 getAnnotation方法取得annotation // 从方法中查某个annotation 
			 UseCase uc = m.getAnnotation(UseCase.class); 其中 UseCase 中的元素称为注解元素*/
            UseCase uc = m.getAnnotation(UseCase.class);
            if (uc != null) {
                //
                System.out.println("Found Use Case:" + uc.id() + " " + uc.description());
                useCases.remove(new Integer(uc.id()));
            }
        }
        for (int i : useCases) {
            System.out.println("Warning: Missing use case-" + i);
        }
    }

    public static void main(String[] args) {
        List<Integer> useCases = new ArrayList<Integer>();
        Collections.addAll(useCases, 47, 48, 49, 50);

        trackUseCases(useCases, PasswordUtils.class);
    }
} /*
 * Output: Found Use Case:47 Passwords must contain at least one numeric Found
 * Use Case:48 no description Found Use Case:49 New passwords can't equal
 * previously used ones Warning: Missing use case-50
 */// :~
