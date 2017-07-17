package cn.feng.thinkInJava.b2_1_注解.annotations.a20_01_01.定义注解;

//: annotations/PasswordUtils.java

import java.util.List;

public class PasswordUtils {

    //注解的元素在使用时表现为名-值对的形式,并需要置于@UseCase声明之后的括号内
    @UseCase(id = 47, description = "Passwords must contain at least one numeric")
    public boolean validatePassword(String password) {
        return (password.matches("\\w*\\d\\w*"));
    }
    //并没有给出description的值
    @UseCase(id = 48)
    public String encryptPassword(String password) {
        return new StringBuilder(password).reverse().toString();
    }

    @UseCase(id = 49, description = "New passwords can't equal previously used ones")
    public boolean checkForNewPassword(List<String> prevPasswords, String password) {
        return !prevPasswords.contains(password);
    }
} /// :~
