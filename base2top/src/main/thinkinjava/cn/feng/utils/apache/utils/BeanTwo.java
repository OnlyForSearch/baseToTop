package cn.feng.utils.apache.utils;

import java.util.Date;

public class BeanTwo {

    private String name;
    private int age;
    private Date birthday;
    private Double salary;
    private char sex;
    private boolean flag;
    private String times = "1234567891000";
    //private String more;

    //	public String getMore() {
    //		return more;
    //	}
    //	public void setMore(String more) {
    //		this.more = more;
    //	}
    public boolean isFlag() {
        return flag;
    }
    public void setFlag(boolean flag) {
        this.flag = flag;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public Date getBirthday() {
        return birthday;
    }
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
    public Double getSalary() {
        return salary;
    }
    public void setSalary(Double salary) {
        this.salary = salary;
    }
    public char getSex() {
        return sex;
    }
    public void setSex(char sex) {
        this.sex = sex;
    }
    @Override
    public String toString() {
        return "BeanTwo [name=" + name + ", age=" + age + ", birthday=" + birthday + ", salary=" + salary + ", sex=" + sex + ", flag=" + flag + "]";
    }


}
