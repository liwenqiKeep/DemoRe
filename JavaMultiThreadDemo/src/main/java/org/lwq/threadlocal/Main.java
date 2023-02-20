package org.lwq.threadlocal;

import io.netty.util.concurrent.DefaultThreadFactory;

import java.util.concurrent.*;

/**
 * @author liwenqi
 */
public class Main {

    private static final ThreadPoolExecutor POOL_EXECUTOR = new ThreadPoolExecutor(2,
            10,10L, TimeUnit.HOURS,
            new LinkedBlockingQueue<>(),
            new DefaultThreadFactory("aaa"));
    public static void main(String[] args) {

        int cycleIndex = 10;
        for (int i = 0; i < cycleIndex; i++) {
            POOL_EXECUTOR.execute(() ->{

            });
        }

    }
}
