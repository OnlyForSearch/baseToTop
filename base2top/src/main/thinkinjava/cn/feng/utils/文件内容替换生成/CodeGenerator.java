package cn.feng.utils.文件内容替换生成;

import java.io.*;
import java.util.Enumeration;
import java.util.Properties;

public class CodeGenerator {


    private String codeFileName = "code.properties";
    private String packageName = "";
    private String servicePath = "";
    private String serviceImplPath = "";
    private String entityPath = "";
    private String domainObjectName = "";
    private String sourceDomainObjectName;
    private String serviceChinaName = "";
    private String sourceServiceChinaName = "";
    private String webServiceImplTemplateName = "";
    private String webServiceTemplateName = "";


    private void getProperties(Properties properties) throws IOException {
        BufferedReader bufferedReader = null;

        bufferedReader = new BufferedReader(new FileReader(codeFileName));
        properties.load(bufferedReader);
        packageName = properties.getProperty("module.parentTargetPackage");
        dirs(packageName);
        domainObjectName = properties.getProperty("module.name");
        sourceDomainObjectName = properties.getProperty("module.sourceName");
        serviceChinaName = properties.getProperty("module.chinaName");
        sourceServiceChinaName = properties.getProperty("module.sourceServiceChinaName");
        webServiceImplTemplateName = properties.getProperty("module.webServiceimplTemplateName");
        webServiceTemplateName = properties.getProperty("module.webServiceTemplateName");

        bufferedReader.close();

    }

    /**
     * 生成WebService实现类
     *
     * @throws IOException
     */
    private void gengeratorFile(String destFileName, String sourceFileName) throws IOException {
        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;
        bufferedReader = new BufferedReader(new FileReader(sourceFileName));


        bufferedWriter = new BufferedWriter(new FileWriter(destFileName));

        String line = null;
        while ((line = bufferedReader.readLine()) != null) {
            line.replaceAll(sourceServiceChinaName, serviceChinaName);
            String domainObjectName2 = domainObjectName;
            domainObjectName2 = firstToLowerCase(domainObjectName2);
            String sourceDomainObjectName2 = sourceDomainObjectName;
            sourceDomainObjectName2 = firstToLowerCase(sourceDomainObjectName2);
            line = line.replaceAll(sourceDomainObjectName, domainObjectName);
            line = line.replaceAll(sourceDomainObjectName2, domainObjectName2);
            line = line.replaceAll(sourceServiceChinaName, serviceChinaName);
            line = line.replaceAll("Config", "");

            bufferedWriter.write(line);
            bufferedWriter.newLine();
            bufferedWriter.flush();
        }
        bufferedReader.close();
        bufferedWriter.close();
    }

    /**
     * 首字母小写
     */
    private String firstToLowerCase(String str) {

        char[] chars = new char[1];
        chars[0] = str.charAt(0);
        String temp = new String(chars);
        if (chars[0] >= 'A' && chars[0] <= 'Z') {
            str = str.replaceFirst(temp, temp.toLowerCase());
        }
        return str;

    }

    private void gengeratorEntity() throws IOException {
        String destFileName = entityPath + domainObjectName + ".java";
        String sourceFileName = sourceDomainObjectName + "Resp.java";

        File file = new File(entityPath);
        file.mkdirs();
        file.exists();
        this.gengeratorFile(destFileName, sourceFileName);

    }

    private void gengeratorService() throws IOException {
        String destFileName = servicePath + "I" + domainObjectName + "WebSerViceImpl.java";

        File file = new File(servicePath);
        file.mkdirs();
        file.exists();
        String sourceFileName = webServiceTemplateName;
        this.gengeratorFile(destFileName, sourceFileName);
    }

    private void gengeratorImpl() throws IOException {
        String destFileDir = serviceImplPath + domainObjectName + "WebSerViceImpl.java";
        File file = new File(serviceImplPath);
        file.mkdirs();
        file.exists();

        String sourceFileName = webServiceImplTemplateName;
        this.gengeratorFile(destFileDir, sourceFileName);
    }

    /**
     * 文件目录生成
     *
     * @param properties
     */
    private void gengeratorDirs(Properties properties) {
        String modelTargetPackage = properties.getProperty("model.targetPackage");

        Enumeration<String> propertyNames = (Enumeration<String>) properties.propertyNames();
        while (propertyNames.hasMoreElements()) {
            String key = propertyNames.nextElement();
            if (key.endsWith("Package")) {

                dirs(properties.getProperty(key));
            }
            if (key.equals("module.name")) {
                domainObjectName = properties.getProperty(key);
            }
        }
    }

    /**
     * 包名转换成目录路径
     */

    private void dirs(String packages) {
        if (packages != null) {
            packages = packages.replaceAll("\\.", "\\\\");

            packageName = packages;
            servicePath = packageName + "\\";
            entityPath = packageName + "\\entity\\";
            serviceImplPath = packageName + "\\impl\\";

        }

    }

    /**
     * 目录删除
     *
     * @param file
     */
    private void removeDir(File file) {
        File[] files = file.listFiles();

    }

    public static void main(String[] args) {

        CodeGenerator codeGenerator = new CodeGenerator();
        codeGenerator.gengerator();
    }

    public void gengerator() {
        Properties properties = new Properties();


        try {
            //配置文件属性获取
            getProperties(properties);
            // 文件目录生成
            gengeratorImpl();

            gengeratorService();
            gengeratorEntity();

        } catch (FileNotFoundException e1) {
            System.out.println(e1.getMessage());
            throw new RuntimeException(e1.getMessage());
        } catch (IOException e) {
            throw new RuntimeException("读写失败");

        }


    }
}
