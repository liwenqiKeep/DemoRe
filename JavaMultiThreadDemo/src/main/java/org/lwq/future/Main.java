package org.lwq.future;

import java.util.concurrent.CompletableFuture;

/**
 * @author liwenqi
 */
public class Main {

    public static void main(String[] args) {
        CompletableFuture<Thread> completableFuture  = new CompletableFuture<>();
        CompletableFuture.allOf(completableFuture).join();
    }
}
