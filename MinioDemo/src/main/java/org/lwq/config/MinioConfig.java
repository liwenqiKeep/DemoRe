package org.lwq.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @author liwenqi
 */
@Configuration
public class MinioConfig {

    @Value("${minio.endpoint}")
    private String endpoint;

    @Value("${minio.user}")
    private String user;

    public String getEndpoint() {
        return endpoint;
    }

    public String getUser() {
        return user;
    }

    public String getPasswd() {
        return passwd;
    }

    public String getBucket() {
        return bucket;
    }

    @Value("${minio.passwd}")
    private String passwd;

    @Value("${minio.bucket}")
    private String bucket;
}
