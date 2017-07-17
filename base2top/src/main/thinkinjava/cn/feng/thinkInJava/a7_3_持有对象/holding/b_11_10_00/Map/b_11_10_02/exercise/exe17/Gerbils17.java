package cn.feng.thinkInJava.a7_3_持有对象.holding.b_11_10_00.Map.b_11_10_02.exercise.exe17;// holding/Gerbils17.java
// TIJ4 Chapter Holding, Exercise 17, page 422
/* Take the Gerbil class in Exercise 1 and put it into a Map instead, 
* associating each Gerbil's name (e.g. "Fuzzy" or "Spot") as a String (the
* key) for each Gerbil (the value) you put in the table. Get an Iterator for
* the keySet() and use it to move through the Map, looking up the Gerbil for
* each key and printing out the key and telling the Gerbil to hop().
*/

/**
 * 使用练习1中的Gerbil类,将其放入Map中,将每个Gerbil的名字(例如Fuzzy或Spot)String键与每一个Gerbil关联起来
 * ,为keyset()获取Interator,使用它遍历Map,,针对每个键查询Gerbil,然后打印出"键",并让gerbil执行hop()
 */

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


class Gerbil {

    private int gerbilNumber;
    public Gerbil(int i) {
        gerbilNumber = i;
    }
    public void hop() {
        System.out.println("gerbil " + gerbilNumber + " hops");
    }
}

public class Gerbils17 {

    public static void main(String[] args) {
        Map<String, Gerbil> gerbils = new HashMap<String, Gerbil>();
        gerbils.put("Fuzzy", new Gerbil(0));
        gerbils.put("Spot", new Gerbil(1));
        gerbils.put("Speedy", new Gerbil(2));
        gerbils.put("Dopey", new Gerbil(3));
        gerbils.put("Sleepy", new Gerbil(4));
        gerbils.put("Happy", new Gerbil(5));
        Iterator<String> it = gerbils.keySet().iterator();
        while (it.hasNext()) {
            String s = it.next();
            System.out.print(s + ": ");
            gerbils.get(s).hop();
        }
    }
}

