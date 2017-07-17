// generics/storyCharacters/StoryCharacterGenerator.java
// TIJ4 Chapter Generics, Exercise 8, page 631
/* Following the form of the Coffee example, create a hierarchy of StoryCharacter(s) from 
* your favorite movie, dividing them into GoodGuy(s) and BadGuy(s). Create a generator
* for StoryCharacter(s), following the form of CoffeeGenerator.

/* Solution includes, in same package, generics.storyCharacters:
* public class StoryCharacter {
*  	private static long counter = 0;
*  	private final long id = counter++;
*  	public String toString() {
*    		return getClass().getSimpleName() + " " + id;
*  	}
* }
* public class GoodGuy extends StoryCharacter {}
* public class LukeSkywalker extends GoodGuy {}
* public class Yoda extends GoodGuy {}
* public class BadGuy extends StoryCharacter {}
* public class DarthVader extends BadGuy {}
* public class JabbaTheHut extends BadGuy {}
*/
/**
 * 模仿Coffee示例的样子,根据你喜爱的电影人物,创建一个StoryCharacters的类层次结果
 * 将它们划分为GoodGuy(s) and BadGuy(s),在按照CoffeeGenerator的形式,编写编写StoryCharacters的生成器
 */
package cn.feng.thinkInJava.a9_2_泛型.generics.coffee.泛型接口.exercise.exe8;

import cn.feng.thinkInJava.数据生成器.Generator;

import java.util.Iterator;
import java.util.Random;

class StoryCharacter {

    private static long counter = 0;
    private final long id = counter++;
    public String toString() {
        return getClass().getSimpleName() + " " + id;
    }
}

class GoodGuy extends StoryCharacter {}

class LukeSkywalker extends GoodGuy {}

class Yoda extends GoodGuy {}

class BadGuy extends StoryCharacter {}

class DarthVader extends BadGuy {}

class JabbaTheHut extends BadGuy {}

public class StoryCharacterGenerator implements Generator<StoryCharacter>, Iterable<StoryCharacter> {

    private static Random rand = new Random();
    private Class[] types = {DarthVader.class, JabbaTheHut.class, LukeSkywalker.class, Yoda.class};
    // For iteration:
    private int size = 0;
    public StoryCharacterGenerator() {}
    public StoryCharacterGenerator(int sz) { size = sz; }
    public static void main(String[] args) {
        StoryCharacterGenerator gen = new StoryCharacterGenerator();
        for (int i = 0; i < 5; i++)
            System.out.println(gen.next());
        for (StoryCharacter s : new StoryCharacterGenerator(5))
            System.out.println(s);
    }
    public StoryCharacter next() {
        try {
            return (StoryCharacter) types[rand.nextInt(types.length)].newInstance();
            // Report programmer errors at run time:
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public Iterator<StoryCharacter> iterator() {
        return new StoryCharacterIterator();
    }

    class StoryCharacterIterator implements Iterator<StoryCharacter> {

        int count = size;
        public boolean hasNext() { return count > 0; }
        public StoryCharacter next() {
            count--;
            return StoryCharacterGenerator.this.next();
        }
        public void remove() { // Not implemented
            throw new UnsupportedOperationException();
        }
    }
}
