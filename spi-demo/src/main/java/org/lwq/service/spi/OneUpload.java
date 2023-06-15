package org.lwq.service.spi;

import org.lwq.service.Upload;

/**
 * @author Liwq
 */
public class OneUpload implements Upload {
    @Override
    public void upload(String url) {
        System.out.println("OneUpload" + url);
    }
}
