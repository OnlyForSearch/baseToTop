//: annotations/database/Member.java
package cn.feng.thinkInJava.b2_1_注解.annotations.database;
/**
 *快捷方式：
 注解中定义了名为value的元素，且在应用该注解时，若该元素是唯一需赋值元素，则无需使用名-值对语法，只需在括号内给出value值即可。
 *
 * */
@DBTable(name = "MEMBER")
public class Member {

    static int memberCount;
    /**
     * 其中@SQLString(30)就是只提供了一个值。

     变通之道
     嵌套注解有时会使代码非常复杂，可以同时使用两个注解类型来注解一个域。
     * */
    @SQLString(30)
    String firstName;
    @SQLString(50)
    String lastName;
    @SQLInteger
    Integer age;
    @SQLString(value = 30, constraints = @Constraints(primaryKey = true))
    String handle;
    public String getHandle() {
        return handle;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String toString() {
        return handle;
    }

    public Integer getAge() {
        return age;
    }
} /// :~
