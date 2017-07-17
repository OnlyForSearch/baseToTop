package cn.feng.thinkInJava.a10_1_IO.io.a18_14_00.PreferencesAPI;
//: io/PreferencesDemo.java

import java.util.prefs.Preferences;

import static net.mindview.util.Print.print;

/**
 * Preferences参数选择
 *userNodeForPackage()用于个别用户偏好，systemNodeForPackage()用于通用的安装配置。在非静态方法内部，通常用getClass() 标识节点，静态方法中可以用.class。
 keys()方法以String[]的形式返回。
 put()，get()有系列针对基本类型的方法
 get()如果没有这个条目，将使用第二个参数设置该条目。

 1
 2
 3
 4



 Preferences prefs = Preferences.userNodeForPackage(PreferencesDemo.class);
 int usageCount = prefs.getInt("UsageCount", 0);
 usageCount++;
 prefs.putInt("UsageCount", usageCount);

 第一次运行程序时，UsageCount值为0，随后引用中，他将会是非零值。

 数据存储在哪里，不同的系统会不同，例如在windows中，就使用注册表。

 Properties

 Properties 类表示了一个持久的属性集。Properties 可保存在流中或从流中加载。属性列表中
 每个键及其对应值都是一个字符串。

 一个属性列表可包含另一个属性列表作为它的“默认值”；如果未能在原有的属性列表中搜索到
 属性键，则搜索第二个属性列表。（重载的构造器提供了这种功能）

 因为 Properties 继承于 Hashtable，所以可对 Properties 对象应用 put 和 putAll 方法。
 但不建议使用这两个方法，因为它们允许调用者插入其键或值不是 String 的项。相反，应该使
 用 setProperty 方法。如果在“不安全”的 Properties 对象（即包含非 String 的键或值）上调用
 store 或 save 方法，则该调用将失败。类似地，如果在“不安全”的 Properties 对象（即包
 含非 String 的键）上调用 propertyNames 或 list 方法，则该调用将失败。

 load(Reader) / store(Writer, String) 方法按下面所指定的、简单的面向行的格式在基于
 字符的流中加载和存储属性。除了输入/输出流使用 ISO 8859-1 字符编码外，
 load(InputStream) / store(OutputStream, String) 方法与 load(Reader)/store
 (Writer, String) 对的工作方式完全相同。可以使用 Unicode 转义来编写此编码中无法直接表
 示的字符；转义序列中只允许单个 ‘u’ 字符。可使用 native2ascii 工具对属性文件和其他字符编码进行相互转换。


 loadFromXML(InputStream) 和 storeToXML(OutputStream, String, String) 方法按简单
 的 XML 格式加载和存储属性。默认使用 UTF-8 字符编码，但如果需要，可以指定某种特定的编码。XML 属性文档具有以下 DOCTYPE 声明：

 <!DOCTYPE properties SYSTEM “http://java.sun.com/dtd/properties.dtd">
 注意，导入或导出属性时不 访问系统 URI (http://java.sun.com/dtd/properties.dtd)；
 该系统 URI 仅作为一个唯一标识 DTD 的字符串：

 JSON

 json类库将在Java SE9中加入
 * @author fengyu
 * @date 2015年8月9日
 */
public class PreferencesDemo {

    public static void main(String[] args) throws Exception {
        Preferences prefs = Preferences.userNodeForPackage(PreferencesDemo.class);
        prefs.put("Location", "Oz");
        prefs.put("Footwear", "Ruby Slippers");
        prefs.putInt("Companions", 4);
        prefs.putBoolean("Are there witches?", true);
        int usageCount = prefs.getInt("UsageCount", 0);
        usageCount++;
        prefs.putInt("UsageCount", usageCount);
        for (String key : prefs.keys())
            print(key + ": " + prefs.get(key, null));
        // You must always provide a default value:
        print("How many companions does Dorothy have? " + prefs.getInt("Companions", 0));
    }
} /* Output: (Sample)
Location: Oz
Footwear: Ruby Slippers
Companions: 4
Are there witches?: true
UsageCount: 53
How many companions does Dorothy have? 4
*///:~
