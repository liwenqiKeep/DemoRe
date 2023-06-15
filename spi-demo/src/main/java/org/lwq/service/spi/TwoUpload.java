package org.lwq.service.spi;

import org.lwq.service.Upload;

/**
 * @author Liwq
 */
public class TwoUpload implements Upload {
    @Override
    public void upload(String url) {
        System.out.println("two upload " + url);
    }
}
