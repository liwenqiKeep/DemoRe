package org.lwq;

import org.lwq.service.Upload;

import java.util.ServiceLoader;

/**
 * Hello world!
 * @author Liwq
 */
public class App {
    public static void main(String[] args) {

        ServiceLoader<Upload> uploads = ServiceLoader.load(Upload.class);
        for (Upload upload : uploads) {
            upload.upload(" file path ");
        }
    }
}
