package cn.feng.utils;

public class Regex {

    private Regex() {}

    /**
     * UUID格式,长度36
     */
    public static final String UUID_FORMAT = "(^[0-9a-zA-Z]{8}-[0-9a-zA-Z]{4}-[0-9a-zA-Z]{4}-[0-9a-zA-Z]{4}-[0-9a-zA-Z]{12}$)";

    /**
     * UUID格式,长度36
     */
    public static final String UUID_FORMAT_LENGTH = "(^[0-9a-zA-Z]{8}-[0-9a-zA-Z]{4}-[0-9a-zA-Z]{4}-[0-9a-zA-Z]{4}-[0-9a-zA-Z]{12}$){36}";
}
