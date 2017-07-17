package cn.feng.utils.apache.utils;

import java.util.Date;

public class BeansOne {

    private String name;
    private String age;
    private String birthday;
    private String salary;
    private String sex;
    private Date times;

    private String flag;


    //	private Double dest;
    //
    //	public Double getDest() {
    //		return dest;
    //	}
    //
    //	public void setDest(Double dest) {
    //		this.dest = dest;
    //	}

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public Date getTimes() {
        return times;
    }

    public void setTimes(Date times) {
        this.times = times;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "BeansOne [name=" + name + ", age=" + age + ", birthday=" + birthday + ", salary=" + salary + ", sex=" + sex + ", times=" + times + ", flag=" + flag + "]";
    }


}
