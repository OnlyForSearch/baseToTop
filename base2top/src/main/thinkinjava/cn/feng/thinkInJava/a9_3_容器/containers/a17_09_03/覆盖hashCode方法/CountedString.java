package cn.feng.thinkInJava.a9_3_容器.containers.a17_09_03.覆盖hashCode方法;
//: containers/CountedString.java
// Creating a good hashCode().

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static net.mindview.util.Print.print;

/**
 * 覆盖hashCode()

 设计hashCode()时最重要的因素就是：无论何时，对同一个对象调用hashCode()都应该生成同样的值。
 如果在将一个对象用put()添加进HashMap时产生一个hashCode()，而用get()取出时却产生了另一个hashCode()值，那么就无法重新取得该对象了。

 此外，也不应该使hashCode()依赖于具有唯一性的对象信息，尤其是使用this的值，这只能产生很糟糕的hashCode()。
 因为这样做无法生成一个新的键，使之与put()中原始的键值对中的键相同。应该使用对象内有意义的识别信息。

 对于String而言，hashCode()明显是基于String的内容的。

 因此，要想使hashCode()实用，它必须速度快并且必须有意义。也就是说，它必须基于对象的内容生成散列码。
 散列码不必是独一无二的（应该更关注生成速度，而不是唯一性），但是通过hashCode()和equals()，必须能够完全确定对象的身份。

 因为在生成桶的下标前，hashCode()还需要做进一步的处理，所以散列码的生成范围并不重要，只要是int即可。

 还有另外一个影响因素：好的hashCode()应该能够产生分布均匀的散列码。如果散列码都集中在一块，
 那么HashMap或者HashSet在某些区域的负载会很重，这样就不如分布均匀的散列函数快。

 给int变量result赋予某个非零常量
 为对象内每个有意义的域f(即每个可以做equals()操作的域)计算出一个int散列码e:

 域类型 	计算
 boolean 	c=(f?0:1)
 byte、char、short或int 	c=(int)f
 long 	c=(int)(f^(f>>>32))
 float 	c=Float.floatToIntBits(f);
 double 	long l = Double.doubleToLongBits(f);<br/>c=(int)(l ^ (l>>>32))
 Object，其equals()调用这个域的equals() 	c=f.hashCode()
 数组 	对每个元素应用上述规则

 合并计算得到的散列码：
 result = 37*result + c;
 返回result。
 检查hashCode()最后生成的结果，确保相同的对象有相同的散列码。

 编写正确的hashCode()和equals()类库
 Apache的Jakarta Commons项目中有很多工具可以帮助你编写正确的hashCode()和equals()。
 * */

public class CountedString {

    private static List<String> created = new ArrayList<String>();
    private String s;
    private int id = 0;
    public CountedString(String str) {
        s = str;
        created.add(s);
        // id is the total number of instances
        // of this string in use by CountedString:
        for (String s2 : created)
            if (s2.equals(s))
                id++;
    }
    public static void main(String[] args) {
        Map<CountedString, Integer> map = new HashMap<CountedString, Integer>();
        CountedString[] cs = new CountedString[5];
        for (int i = 0; i < cs.length; i++) {
            cs[i] = new CountedString("hi");
            map.put(cs[i], i); // Autobox int -> Integer
        }
        print(map);
        for (CountedString cstring : cs) {
            print("Looking up " + cstring);
            print(map.get(cstring));
        }
    }
    public String toString() {
        return "String: " + s + " id: " + id +
                " hashCode(): " + hashCode();
    }
    public int hashCode() {
        // The very simple approach:
        // return s.hashCode() * id;
        // Using Joshua Bloch's recipe:
        int result = 17;
        result = 37 * result + s.hashCode();
        result = 37 * result + id;
        return result;
    }
    public boolean equals(Object o) {
        return o instanceof CountedString &&
                s.equals(((CountedString) o).s) &&
                id == ((CountedString) o).id;
    }
} /* Output: (Sample)
{String: hi id: 4 hashCode(): 146450=3, String: hi id: 1 hashCode(): 146447=0, String: hi id: 3 hashCode(): 146449=2, String: hi id: 5 hashCode(): 146451=4, String: hi id: 2
hashCode(): 146448=1}
Looking up String: hi id: 1 hashCode(): 146447
0
Looking up String: hi id: 2 hashCode(): 146448
1
Looking up String: hi id: 3 hashCode(): 146449
2
Looking up String: hi id: 4 hashCode(): 146450
3
Looking up String: hi id: 5 hashCode(): 146451
4
*///:~
