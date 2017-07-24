package demo.java.io;


import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

/**
 * Created by F245310999 on 2017/7/11.
 */

public class FileTest {
    
    private static volatile File testDir;
    
    private static File dotePath = new File(".");
    
    @Before
    public void setUp() throws Exception {
        System.out.println("File.pathSeparator:"+ File.pathSeparator);
        System.out.println("File.separator:"+ File.separator);
    }
    
    
    public static File getTestFile() {
        if (testDir == null) {
            testDir= new File("test/io/").getAbsoluteFile();
        }
        testDir.mkdirs();
        return testDir;
    }
    
    public static Long getTimestamp() {
        return System.currentTimeMillis();
    }
    
    @Test
    public void testGetTestFile() {
        assertEquals("D:\\project\\one-zero\\one-zero-java-src\\test\\io", FileTest.getTestFile().getAbsolutePath()); FileTest.getTestFile();
    }
    
    /**
     * 测试系统分隔符
     */
    @Test
    public void testFileSeparator() {
        assertEquals(File.separator,System.getProperty("file.separator"));
        assertEquals("\\",File.separator);//Window
       // assertEquals("/",File.separator);//Unix
        
    }
    
    /**测试 系统路径分隔符*/
    @Test
    public void testPathSeparator() {
        assertEquals(";", File.pathSeparator);//window
        assertEquals(System.getProperty("path.separator"), File.pathSeparator);
        assertNotEquals(":",File.pathSeparator);//unix
      
    }
    /**
     * 测试构造器
     * 构造的时候都未生成实际文件或目录
     * */
    @Test
    public void testConstruct1() {
        File file = new File(".");
        assertEquals(".",file.getPath());
        File expectedSrc = new File("test/io/testConstruct1");
        assertEquals("test\\io\\testConstruct1",expectedSrc.getPath());
    
        File stringParentAndChild = new File("test/io", "/construct/child");
        assertEquals("test\\io\\construct\\child", stringParentAndChild.getPath());
        assertEquals("file:/D:/project/one-zero/one-zero-java-src/test/io/construct/child", stringParentAndChild.toURI().toString());
        assertEquals("D:\\project\\one-zero\\one-zero-java-src\\test\\io\\construct\\child", stringParentAndChild.getAbsolutePath());
    
    
        File parentAndChild = new File(getTestFile(), "relative/child");
        assertEquals("D:\\project\\one-zero\\one-zero-java-src\\test\\io\\relative\\child",parentAndChild.getPath());
     File parentAndChild2 = new File(getTestFile(), "/relative/child2");
        assertEquals("D:\\project\\one-zero\\one-zero-java-src\\test\\io\\relative\\child2",parentAndChild2.getPath());
    
    }
    
    
    /**
     * 测试获取文件或者目录的名称
     * */
    @Test
    public void testGetName() {
        
        assertEquals("", new File("").getName());
        assertEquals(".", new File(".").getName());
        
        assertEquals("io",new File("test/io").getName());
        assertEquals("io",new File("/test/io").getName());
        assertEquals("io",new File("/test/io/").getName());
        assertEquals("io",new File("test/io").getName());
        
        assertEquals("test.txt",new File("test/io/test.txt").getName());
        assertEquals("test.txt",new File("/test/io/test.txt").getName());
        
        
    }
     /**
     * 获取抽象路径的父目录的抽象路径名
     * */
    @Test
    public void testGetParent() {
        
        assertNull("路径名没有指定父目录，则返回 null", new File("").getParent());
        assertNull( new File(".").getParent());
        assertEquals( "\\",new File("/.").getParent());
    
        assertEquals(null,new File("test").getParent());
        assertEquals("test",new File("test/io").getParent());
        assertEquals("\\test",new File("/test/io").getParent());
        assertEquals("\\test",new File("/test/io/").getParent());
        assertEquals("test",new File("test/io").getParent());
    
        assertEquals("test\\io",new File("test/io/test.txt").getParent());
        assertEquals("\\test\\io",new File("/test/io/test.txt").getParent());
        
        
    }
    
    /**
     *
     * */
    @Test
    public void testGetPath() {
        assertEquals("", new File("").getPath());
        assertEquals(".", new File(".").getPath());
        assertEquals("\\.", new File("/.").getPath());
    
        assertEquals("test", new File("test").getPath());
        assertEquals("test\\io", new File("test/io").getPath());
        assertEquals("\\test\\io", new File("/test/io").getPath());
        assertEquals("\\test\\io", new File("/test/io/").getPath());
        assertEquals("test\\io", new File("test/io").getPath());
    
        assertEquals("test\\io\\test.txt", new File("test/io/test.txt").getPath());
        assertEquals("test\\io", new File("test/io/test.txt").getParent());
        assertEquals("\\test\\io", new File("/test/io/test.txt").getParent());
        
    }
     /**
     *判断是否是绝对路径
     * */
    @Test
    public void testIsAbsolutePath() {
        assertEquals(false, new File("").isAbsolute());
        assertEquals(true, new File("e://").isAbsolute());
        assertEquals(false, new File(".").isAbsolute());
        assertEquals(true, new File("e://.").isAbsolute());
        assertEquals(true, new File("e:///.").isAbsolute());
    
        assertEquals(false, new File("test").isAbsolute());
        assertEquals(false, new File("/test").isAbsolute());
        assertEquals(false, new File("test/io").isAbsolute());
        assertEquals(false, new File("/test/io").isAbsolute());
        assertEquals(false, new File("/test/io/").isAbsolute());
        assertEquals(false, new File("test/io").isAbsolute());
    
        assertEquals("test\\io", new File("test/io/test.txt").getParent());
        assertEquals("\\test\\io", new File("/test/io/test.txt").getParent());
        
    }
    
    /*** 得到绝对路径的字符串*/
     @Test
    public void testGetAbsolutePath() {
         System.out.println(System.getProperty("user.dir"));
        assertEquals("D:\\project\\one-zero\\one-zero-java-src", new File("").getAbsolutePath());//获取当前用户目录的字符
        assertEquals("e:\\", new File("e://").getAbsolutePath());
        assertEquals("D:\\project\\one-zero\\one-zero-java-src\\.", new File(".").getAbsolutePath());
        assertEquals("e:\\.", new File("e://.").getAbsolutePath());
        assertEquals("e:\\.", new File("e:///.").getAbsolutePath());
        assertEquals("e:\\.", new File("e:///////.").getAbsolutePath());
    
        assertEquals("D:\\project\\one-zero\\one-zero-java-src\\test", new File("test").getAbsolutePath());
        assertEquals("D:\\test", new File("/test").getAbsolutePath());// 绝对路径
        assertEquals("D:\\project\\one-zero\\one-zero-java-src\\test\\io", new File("test/io").getAbsolutePath());
        assertEquals("D:\\test\\io", new File("/test/io").getAbsolutePath());
        assertEquals("D:\\project\\one-zero\\one-zero-java-src\\test\\io", new File("test/io").getAbsolutePath());
    
        assertEquals("D:\\project\\one-zero\\one-zero-java-src\\test\\io\\test.txt", new File("test/io/test.txt").getAbsolutePath());
        assertEquals("D:\\test\\io\\test.txt", new File("/test/io/test.txt").getAbsolutePath());
    
        
        
    }
     /*** 得到规范的路径 盘符 大写,
      * 通常涉及到从路径名中移除多余的名称（比如 "." 和 ".."）、解析符号连接（对于 UNIX 平台），
      * 以及将驱动器号转换为标准大小写形式（对于 Microsoft Windows 平台）。
      * */
     @Test
    public void testGetCanonicalPath() {
         System.out.println(System.getProperty("user.dir"));
         try {
             assertEquals("D:\\project\\one-zero\\one-zero-java-src", new File("").getCanonicalPath());//获取当前用户目录的字符
             
             assertEquals("E:\\", new File("e://").getCanonicalPath());
             assertNotEquals("e:\\", new File("e://").getCanonicalPath());
             
             assertNotEquals("D:\\project\\one-zero\\one-zero-java-src\\.", new File(".").getCanonicalPath());
             assertEquals("D:\\project\\one-zero\\one-zero-java-src", new File(".").getCanonicalPath());
             
             
             assertNotEquals("e:\\", new File("e://.").getCanonicalPath());
             assertEquals("E:\\", new File("e://.").getCanonicalPath());
             
             assertNotEquals("e:\\", new File("e:///.").getCanonicalPath());
             assertEquals("E:\\", new File("e:///.").getCanonicalPath());
             
             assertNotEquals("e:\\", new File("e:///////.").getCanonicalPath());
             assertEquals("E:\\", new File("e:///////.").getCanonicalPath());
    
             assertEquals("D:\\project\\one-zero\\one-zero-java-src\\test", new File("test").getCanonicalPath());
             assertEquals("D:\\test", new File("/test").getCanonicalPath());// 绝对路径
             assertEquals("D:\\project\\one-zero\\one-zero-java-src\\test\\io", new File("test/io").getCanonicalPath());
             assertEquals("D:\\test\\io", new File("/test/io").getCanonicalPath());
             assertEquals("D:\\project\\one-zero\\one-zero-java-src\\test\\io", new File("test/io").getCanonicalPath());
    
             assertEquals("D:\\project\\one-zero\\one-zero-java-src\\test\\io\\test.txt", new File("test/io/test.txt").getCanonicalPath());
             assertEquals("D:\\test\\io\\test.txt", new File("/test/io/test.txt").getCanonicalPath());
    
         } catch (IOException e) {
             e.printStackTrace();
         }
         
        
        
    }
    
    /**
     * 不管是绝对路径或相对路径,只有 当文件或者真实存在的时候,系统可以读取到 返回true
     * */
    @Test
    public void testCanRead() {
        assertEquals(false, new File("").canRead());//获取当前用户目录的字符
    
        assertEquals(true, new File("e://").canRead());
    
        assertEquals(true, new File(".").canRead());
    
    
        assertEquals(true, new File("e://.").canRead());
    
        assertEquals(true, new File("e:///.").canRead());
    
        assertEquals(true, new File("e:///////.").canRead());
    
        assertEquals(true, new File("test").canRead());
        assertEquals(false, new File("test2").canRead());
        
        assertEquals(true, new File("/test").canRead());// 绝对路径 路径存在的时候
        assertEquals(false, new File("/test2").canRead());// 绝对路径 路径不存在的时候
        
        
        assertEquals(true, new File("test/io").canRead());
        
        assertEquals(true, new File("/test/io").canRead());
        assertEquals(false, new File("/test/io2").canRead());
        
        assertEquals(true, new File("test/io").canRead());
        assertEquals(false, new File("test/io2").canRead());
    
        assertEquals(false, new File("test/io/test.txt").canRead());
        assertEquals(true, new File("/test/io/test.txt").canRead());
        assertEquals(false, new File("/test/io/test2.txt").canRead());
    
    
    }
     /**
     * 不管是绝对路径或相对路径,只有 当文件或者真实存在的时候,系统可以写入的时候,返回true
     * */
    @Test
    public void testCanWrite() {
        assertEquals(false, new File("").canWrite());//获取当前用户目录的字符
    
        assertEquals(true, new File("e://").canWrite());
    
        assertEquals(true, new File(".").canWrite());
    
    
        assertEquals(true, new File("e://.").canWrite());
    
        assertEquals(true, new File("e:///.").canWrite());
    
        assertEquals(true, new File("e:///////.").canWrite());
    
        assertEquals(true, new File("test").canWrite());
        assertEquals(false, new File("test2").canWrite());
        
        assertEquals(true, new File("/test").canWrite());// 绝对路径 路径存在的时候
        assertEquals(false, new File("/test2").canWrite());// 绝对路径 路径不存在的时候
        
        
        assertEquals(true, new File("test/io").canWrite());
        
        assertEquals(true, new File("/test/io").canWrite());
        assertEquals(false, new File("/test/io2").canWrite());
        
        assertEquals(true, new File("test/io").canWrite());
        assertEquals(false, new File("test/io2").canWrite());
    
        assertEquals(false, new File("test/io/test.txt").canWrite());
        assertEquals(true, new File("/test/io/test.txt").canWrite());
        assertEquals(false, new File("/test/io/test2.txt").canWrite());
    
    
    }
    /**文件或目录是否存在*/
    @Test
    public void testExists() {
        assertEquals(false, new File("").exists());//获取当前用户目录的字符
    
        assertEquals(true, new File("e://").exists());
    
        assertEquals(true, new File(".").exists());
    
    
        assertEquals(true, new File("e://.").exists());
    
        assertEquals(true, new File("e:///.").exists());
    
        assertEquals(true, new File("e:///////.").exists());
    
        assertEquals(true, new File("test").exists());
        assertEquals(false, new File("test2").exists());
        
        assertEquals(true, new File("/test").exists());// 绝对路径 路径存在的时候
        assertEquals(false, new File("/test2").exists());// 绝对路径 路径不存在的时候
        
        
        assertEquals(true, new File("test/io").exists());
        
        assertEquals(true, new File("/test/io").exists());
        assertEquals(false, new File("/test/io2").exists());
        
        assertEquals(true, new File("test/io").exists());
        assertEquals(false, new File("test/io2").exists());
    
        assertEquals(false, new File("test/io/test.txt").exists());
        assertEquals(true, new File("/test/io/test.txt").exists());
        assertEquals(false, new File("/test/io/test2.txt").exists());
    
    
    }
    
    /**判断是否是一个目录
     * */
    @Test
    public void testIsDirectory() {
        assertEquals(false, new File("").isDirectory());//获取当前用户目录的字符
    
        assertEquals(true, new File("e://").isDirectory());
    
        assertEquals(true, new File(".").isDirectory());
    
    
        assertEquals(true, new File("e://.").isDirectory());
    
        assertEquals(true, new File("e:///.").isDirectory());
    
        assertEquals(true, new File("e:///////.").isDirectory());
    
        assertEquals(true, new File("test").isDirectory());
        assertEquals(false, new File("test2").isDirectory());
        
        assertEquals(true, new File("/test").isDirectory());// 绝对路径 路径存在的时候
        assertEquals(false, new File("/test2").isDirectory());// 绝对路径 路径不存在的时候
        
        
        assertEquals(true, new File("test/io").isDirectory());
        
        assertEquals(true, new File("/test/io").isDirectory());
        assertEquals(false, new File("/test/io2").isDirectory());
        
        assertEquals(true, new File("test/io").isDirectory());
        assertEquals(false, new File("test/io2").isDirectory());
    
        assertEquals(false, new File("test/io/test.txt").isDirectory());
        assertEquals(false, new File("/test/io/test2.txt").isDirectory());
    
    
    }
   /**
    * 只有实际存在的文件 才是ture
    * */
     @Test
    public void testIsFile() {
        assertEquals(false, new File("").isFile());//获取当前用户目录的字符
    
        assertEquals(false, new File("e://").isFile());
    
        assertEquals(false, new File(".").isFile());
    
    
        assertEquals(false, new File("e://.").isFile());
    
        assertEquals(false, new File("e:///.").isFile());
    
        assertEquals(false, new File("e:///////.").isFile());
    
        assertEquals(false, new File("test").isFile());
        assertEquals(false, new File("test2").isFile());
        
        assertEquals(false, new File("/test").isFile());// 绝对路径 路径存在的时候
        assertEquals(false, new File("/test2").isFile());// 绝对路径 路径不存在的时候
        
        
        assertEquals(false, new File("test/io").isFile());
        
        assertEquals(false, new File("/test/io").isFile());
        assertEquals(false, new File("/test/io2").isFile());
        
        assertEquals(false, new File("test/io").isFile());
        assertEquals(false, new File("test/io2").isFile());
    
        assertEquals(false, new File("test/io/test.txt").isFile());
        assertEquals(true, new File("/test/io/test.txt").isFile());
        assertEquals(false, new File("/test/io/test2.txt").isFile());
    
    
    }
    
    @Test
    public void testIsHidden() {
        assertEquals(false,new File("").isHidden());
    
        assertEquals(true, new File("e://").isHidden());
    
        assertEquals(false, new File(".").isHidden());
    
    
        assertEquals(true, new File("e://.").isHidden());
    
        assertEquals(true, new File("e:///.").isHidden());
    
        assertEquals(true, new File("e:///////.").isHidden());
    
        assertEquals(false, new File("test").isHidden());
        assertEquals(false, new File("test2").isHidden());
    
        assertEquals(false, new File("/test").isHidden());
        assertEquals(false, new File("/test2").isHidden());
    
    
        assertEquals(false, new File("test/io").isHidden());
    
        assertEquals(false, new File("/test/io").isHidden());
        assertEquals(false, new File("/test/io2").isHidden());
    
        assertEquals(false, new File("test/io").isHidden());
        assertEquals(false, new File("test/io2").isHidden());
    
        assertEquals(false, new File("test/io/test.txt").isHidden());
        assertEquals(false, new File("/test/io/test.txt").isHidden());
        assertEquals(false, new File("/test/io/test2.txt").isHidden());
    
    }
    
    @Test
    public void testLastModified() {
    
        assertEquals(0, new File("").lastModified());
    
        assertEquals(1499646309079L, new File("e://").lastModified());
    
        assertEquals(1499762090179L, new File(".").lastModified());
    
    
        assertEquals(1499646309079L, new File("e://.").lastModified());
    
        assertEquals(1499646309079L, new File("e:///.").lastModified());
    
        assertEquals(1499646309079L, new File("e:///////.").lastModified());
    
        assertEquals(1499762090180L, new File("test").lastModified());
        assertEquals(0, new File("test2").lastModified());
    
        assertEquals(1499766613209L, new File("/test").lastModified());
        assertEquals(0, new File("/test2").lastModified());
    
    
        assertEquals(1499762090180L, new File("test/io").lastModified());
    
        assertEquals(1499766618089L, new File("/test/io").lastModified());
        assertEquals(0, new File("/test/io2").lastModified());
    
        assertEquals(1499762090180L, new File("test/io").lastModified());
        assertEquals(0, new File("test/io2").lastModified());
    
        assertEquals(0, new File("test/io/test.txt").lastModified());
        assertEquals(1499766616776L, new File("/test/io/test.txt").lastModified());
        assertEquals(0, new File("/test/io/test2.txt").lastModified());
    
    
    }
        
    
    @Test
    public void testCreateNewFile(){
        try {
       
         assertEquals(false, new File(".").createNewFile());
    
            File test20170712 = new File("test"+System.currentTimeMillis()/1000);
            assertEquals(true, test20170712.createNewFile());
            assertEquals(false, test20170712.createNewFile());//存在的不能继续创建
            test20170712.deleteOnExit();
    
            File filetest1 = new File("/test/test2" + System.currentTimeMillis() / 1000);
            assertEquals(true, filetest1.createNewFile());
            assertEquals(false, filetest1.createNewFile());//存在的不能继续创建
            filetest1.deleteOnExit();
    
            //父路径如果不存在则创建失败,不会递归创建,抛出java.io.IOException: 系统找不到指定的路径。
            File filetest2 = new File("/test/test2/test3"+ System.currentTimeMillis() / 1000);
//            assertEquals(false, filetest2.createNewFile());
//            assertEquals(false, filetest2.createNewFile());//存在的不能继续创建
            filetest2.delete();
            new File("").createNewFile();
            fail("java.io.IOException: 系统找不到指定的路径。");
    
    
            //    assertEquals(true, new File("e://").isHidden());
    
        } catch (IOException e) {
        e.printStackTrace();
        }
    
    }
    
    
    @Test
    public void testDelete() throws IOException {
    
        File file = new File("test/io/testdelete"+ getTimestamp());
        assertEquals(false, file.delete());//不存在的
        
    
        file.createNewFile();
        assertEquals(true,file.delete());//存在
        
    
        
    }
    
    /**
     * 只有当前的文件
     */
    @Test
    public void testList(){
        File file = new File(".");
        String[] listPath = file.list();
         System.out.println(Arrays.toString(listPath));   //[one-zero-java.iml, pom.xml, src, target, test]
    
        assertNull(new File("").list());//不存在的返回null
        assertNull(new File("noExist").list());//不存在的返回null
        assertNull(new File("test/io/noExist").list());//不存在的返回null
    
    
        File file2 = new File("test/io/");
        String[] fileNamelist = file2.list();
        assertNotNull(fileNamelist);//不存在的返回null
        System.out.println(Arrays.toString(fileNamelist));//[]
    
        assertNotNull(new File("/").list());//不存在的返回null
        try {
               } catch (Exception e) {
            e.printStackTrace();
        }
    
    }
    @Test
    public void testListWithFilter(){
        File file = new File(".");
        String[] listPath = file.list();
         System.out.println(Arrays.toString(listPath));   //[one-zero-java.iml, pom.xml, src, target, test]
    
        String[] filenameList = file.list(new FilenameFilter() {
            public boolean accept(File dir, String name) {
                return name.startsWith("t");
            }
        });
        System.out.println(Arrays.toString(filenameList));//[target, test]
    
        String[] filenameList2 = file.list(new FilenameFilter() {
            public boolean accept(File dir, String name) {
                return name.matches("\\w*");
            }
        });
        System.out.println(Arrays.toString(filenameList2));//[src, target, test]
    
    
    }
    
    @Test
    public void testListFiles() {
        File basefile = new File("test");
        File[] files = basefile.listFiles();
        System.out.println(Arrays.toString(files));//[test\io, test\io.txt, test\io2, test\io3]
    
    }
    /**
     * 过滤文件名过滤器
     * */
    @Test
    public void testListFilesWithFilenameFilter() {
        File basefile = new File("test");
        File[] files = basefile.listFiles();
        System.out.println(Arrays.toString(files));//[test\io, test\io.txt, test\io2, test\io3]
    
        basefile.listFiles(new FilenameFilter() {
            public boolean accept(File dir, String name) {
                return name.contains("");
            }
        });
        File[] files2 = basefile.listFiles(new FileFilter() {
            public boolean accept(File pathname) {
            
                return !pathname.isHidden();
            }
        
        });
    
    
    }
    
    
    @Test
    public void testMkdir() {
    
        File file = new File("test/io/testMkdir/" );//父路径存在的时候
        assertEquals(true, file.mkdir());
        file.delete();
    
         File fileNoExist = new File("test/io_no_exit/testMkdir/" );//父路径不存在存在的时候
        fileNoExist.delete();
        assertEquals(false, fileNoExist.mkdir());//父目录,不存在的时候无法创建
        fileNoExist.delete();
    
        
        
    }
     
    @Test
    public void testMkdirs() {
    
        File file = new File("test/io/testMkdir/" );//父路径存在的时候
        assertEquals(true, file.mkdirs());
        file.delete();
    
         File fileNoExist = new File("test/io_no_exit/testMkdir/" );//父路径不存在存在的时候
        fileNoExist.deleteOnExit();
        assertEquals(true, fileNoExist.mkdirs());//父目录,
     //   fileNoExist.deleteOnExit();
    
        
        
    }
    
    @Test
    public void testRenameTo() throws IOException, InterruptedException {
        File renameToFile = new File("test/testRenameTo");
        
        assertEquals(false,renameToFile.renameTo(new File("test/testRenameTo")));//不存在
        
        renameToFile.mkdir();
        File dest = new File("test/testRenameTo2");
        assertEquals(true,renameToFile.renameTo(dest));//真实存在的
    
        TimeUnit.SECONDS.sleep(6);
        renameToFile.delete();
        dest.delete();
                
                
    }
     @Test
    public void testListRoots() throws IOException, InterruptedException {
    
         File[] files = File.listRoots();
         System.out.println(Arrays.toString(files));//[C:\, D:\, E:\, F:\, G:\]
    
     }
    
}
