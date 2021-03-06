package io.github.biezhi.bye2017.cache;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 黑名单缓存
 *
 * @author biezhi
 * @date 2017/12/7
 */
public class BlackCache {

    private static final Set<String>     ips              = new HashSet<>(64);
    private static final ExecutorService EXECUTOR_SERVICE = Executors.newFixedThreadPool(2);

    /**
     * 是否屏蔽该 IP
     *
     * @param ip
     * @return
     */
    public static boolean isBlock(String ip) {
        return ips.contains(ip);
    }

    /**
     * 添加黑名单
     *
     * @param ip
     */
    public static void addBlock(String ip) {
        ips.add(ip);
    }

    /**
     * 解除黑名单
     *
     * @param ip
     */
    public static void addWhitelist(String ip) {
        ips.remove(ip);
    }

    public static Set<String> blockList() {
        return ips;
    }

    public static void clean(){
        ips.clear();
    }
}
