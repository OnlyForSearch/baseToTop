package cn.feng.thinkInJava.a0_0.exercise.a5_1_初始化;

/**
 * 运行时类型识别
 */
public class RTTI {

    public static void main(String[] args) {
        UserFul[] userFuls = {new UserFul(), new MoreUserFul()};
        userFuls[0].f();
        //向下转型
        userFuls[1].g();
        //userFuls[1].v();
    }

}

class UserFul {

    void f() {
    }

    void g() {
    }

}

class MoreUserFul extends UserFul {

    void f() {
    }

    void g() {
    }

    void u() {
    }

    void v() {
    }

    void w() {
    }

}