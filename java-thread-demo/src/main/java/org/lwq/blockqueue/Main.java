package org.lwq.blockqueue;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @author Liwq
 */
public class Main {

    public static void main(String[] args) {
        BlockingDeque<Long> blockingDeque = new LinkedBlockingDeque<>();
        final CompletableFuture<Object> objectCompletableFuture = new CompletableFuture<>();
    }
}
