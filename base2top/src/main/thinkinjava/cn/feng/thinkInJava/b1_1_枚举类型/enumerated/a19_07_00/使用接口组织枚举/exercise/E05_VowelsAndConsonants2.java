package cn.feng.thinkInJava.b1_1_枚举类型.enumerated.a19_07_00.使用接口组织枚举.exercise;
//: enumerated/E05_VowelsAndConsonants2.java
/**
 * *************** Exercise 5 *****************
 * Modify control/VowelsAndConsonants.java so that
 * it uses three enum types: VOWEL, SOMETIMES_A_VOWEL,
 * and CONSONANT. The enum constructor should take
 * the various letters that describe that particular
 * category. Hint: Use varargs, and remember that
 * Enumerated Types 553
 * varargs automatically creates an array for you.
 * *********************************************
 */
/**修改 control/VowelsAndConsonants.java使用3个enum类型:VOWEL, SOMETIMES_A_VOWEL,
 * and CONSONANT,其中的enum构造器,应该可以接受属于不同类别的字母.提示:使用可变参数,要
 * 记住,可变参数会自动为你创建一个数组*/
import java.util.HashSet;

        import java.util.*;
        import static net.mindview.util.Print.*;

enum CharacterCategory {
    VOWEL('a', 'e', 'i', 'o', 'u') {
        public String toString() { return "vowel"; }
    },
    SOMETIMES_A_VOWEL('y', 'w') {
        public String toString() {
            return "sometimes a vowel";
        }
    },
    CONSONANT {
        public String toString() { return "consonant"; }
    };
    private HashSet<Character> chars = new HashSet<Character>();
    private CharacterCategory(Character... chars) {
        if (chars != null)
            this.chars.addAll(Arrays.asList(chars));
    }
    public static CharacterCategory getCategory(Character c) {
        if (VOWEL.chars.contains(c))
            return VOWEL;
        if (SOMETIMES_A_VOWEL.chars.contains(c))
            return SOMETIMES_A_VOWEL;
        return CONSONANT;
    }
}

public class E05_VowelsAndConsonants2 {

    public static void main(String[] args) {
        Random rand = new Random(47);
        for (int i = 0; i < 100; i++) {
            int c = rand.nextInt(26) + 'a';
            printnb((char) c + ", " + c + ": ");
            print(CharacterCategory.getCategory((char) c).toString());
        }
    }
} /* Output: (Sample)
y, 121: sometimes a vowel
n, 110: consonant
z, 122: consonant
Thinking in Java, 4 554 th Edition Annotated Solution Guide
b, 98: consonant
r, 114: consonant
...
h, 104: consonant
x, 120: consonant
x, 120: consonant
h, 104: consonant
v, 118: consonant
*///:~

/**
 *
 * The getCategory( ) factory method returns the appropriate enum constant
 (based on the character provided): VOWEL, SOMETIMES_A_VOWEL, or
 CONSONANT. Each enum has a custom toString( ) method to return the
 appropriate text for that enum. (More can be found in the Constant-specific
 methods section in TIJ4.)
 * */