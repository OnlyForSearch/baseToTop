package cn.feng.thinkInJava.a7_4_异常.exceptions.a12_06_03.异常链;
//: exceptions/DynamicFields.java
// A Class that dynamically adds fields to itself.
// Demonstrates exception chaining.

import static net.mindview.util.Print.print;

/**
 * 异常链
 *常常会想要在捕获一个异常后抛出另一个异常，并且希望把原始异常的信息保存下来，这被称为异常链。所有Throwable的子类在构造器中都可以接受一个cause对象作为参数。这个cause就用来表示原始异常，这样通过把原始异常传递给新的异常，就使得即使在当前位置创建并抛出新的异常，也能通过这个异常链追踪到异常最初发生的位置。在Throwable
 * 的子类中，只有三种基本的异常类提供了带cause参数的构造器。它们是Error，Exception和RuntimeException。如果要把其他类型的异常链接起来，应该使用initCause()方法而不是构造器。
 * @author fengyu
 * @date 2015年8月8日
 */
class DynamicFieldsException extends Exception {}
/**下面例子能让你在运行时动态的向DynamicFields对象添加字段*/
public class DynamicFields {

    private Object[][] fields;
    public DynamicFields(int initialSize) {
        fields = new Object[initialSize][2];
        for (int i = 0; i < initialSize; i++)
            fields[i] = new Object[]{null, null};
    }
    public static void main(String[] args) {
        DynamicFields df = new DynamicFields(3);
        print(df);
        try {
            df.setField("d", "A value for d");
            df.setField("number", 47);
            df.setField("number2", 48);
            print(df);
            df.setField("d", "A new value for d");
            df.setField("number3", 11);
            print("df: " + df);
            print("df.getField(\"d\") : " + df.getField("d"));
            Object field = df.setField("d", null); // Exception
        } catch (NoSuchFieldException e) {
            e.printStackTrace(System.out);
        } catch (DynamicFieldsException e) {
            e.printStackTrace(System.out);
        }
    }
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Object[] obj : fields) {
            result.append(obj[0]);
            result.append(": ");
            result.append(obj[1]);
            result.append("\n");
        }
        return result.toString();
    }
    private int hasField(String id) {
        for (int i = 0; i < fields.length; i++)
            if (id.equals(fields[i][0]))
                return i;
        return -1;
    }
    private int getFieldNumber(String id) throws NoSuchFieldException {
        int fieldNum = hasField(id);
        if (fieldNum == -1)
            throw new NoSuchFieldException();
        return fieldNum;
    }
    private int makeField(String id) {
        for (int i = 0; i < fields.length; i++)
            if (fields[i][0] == null) {
                fields[i][0] = id;
                return i;
            }
        // No empty fields. Add one:
        Object[][] tmp = new Object[fields.length + 1][2];
        for (int i = 0; i < fields.length; i++)
            tmp[i] = fields[i];
        for (int i = fields.length; i < tmp.length; i++)
            tmp[i] = new Object[]{null, null};
        fields = tmp;
        // Recursive call with expanded fields:
        return makeField(id);
    }
    public Object getField(String id) throws NoSuchFieldException {
        return fields[getFieldNumber(id)][1];
    }
    public Object setField(String id, Object value) throws DynamicFieldsException {
        if (value == null) {
            // Most exceptions don't have a "cause" constructor.
            // In these cases you must use initCause(),
            // available in all Throwable subclasses.
            DynamicFieldsException dfe = new DynamicFieldsException();
            dfe.initCause(new NullPointerException());
            throw dfe;
        }
        int fieldNumber = hasField(id);
        if (fieldNumber == -1)
            fieldNumber = makeField(id);
        Object result = null;
        try {
            result = getField(id); // Get old value
        } catch (NoSuchFieldException e) {
            // Use constructor that takes "cause":
            throw new RuntimeException(e);
        }
        fields[fieldNumber][1] = value;
        return result;
    }
} /* Output:
null: null
null: null
null: null

d: A value for d
number: 47
number2: 48

df: d: A new value for d
number: 47
number2: 48
number3: 11

df.getField("d") : A new value for d
DynamicFieldsException
        at DynamicFields.setField(DynamicFields.java:64)
        at DynamicFields.main(DynamicFields.java:94)
Caused by: java.lang.NullPointerException
        at DynamicFields.setField(DynamicFields.java:66)
        ... 1 more
*///:~
