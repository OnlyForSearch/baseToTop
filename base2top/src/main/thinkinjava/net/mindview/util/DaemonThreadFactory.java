//: net/mindview/util/DaemonThreadFactory.java
package net.mindview.util;

import java.util.concurrent.ThreadFactory;

/**
 * 创建显式的线程,以便可以设置他们的后台标志.通过编写定制的ThreadFactory可以定制由
 * Executor创建的线程的属性(后台,优先级,名称)
 *
 * @author fengyu
 * @date 2015年8月15日
 */
public class DaemonThreadFactory implements ThreadFactory {

    public Thread newThread(Runnable r) {
        Thread t = new Thread(r);
        //与普通的ThreadFactory唯一的差异就是它将后台状态全被设置为true
        t.setDaemon(true);
        return t;
    }
} ///:~
