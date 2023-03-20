package org.lwq.component;

import io.minio.BucketExistsArgs;
import io.minio.MakeBucketArgs;
import io.minio.MinioClient;
import org.lwq.config.MinioConfig;
import org.lwq.util.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author liwenqi
 */
@Component
public class MinioClientFactory {

    private final static Logger log = LoggerFactory.getLogger(MinioClientFactory.class);

    private MinioClient client;

    private String bucket;

    private final MinioConfig config;

    private static final String HEALTH_CHECK_BUCKET_NAME = "health-check";

    private final BucketExistsArgs healthBucketExistsArgs = BucketExistsArgs.builder().bucket(HEALTH_CHECK_BUCKET_NAME).build();

    public MinioClientFactory(MinioConfig config) {
        client = MinioClient.builder()
                .endpoint(config.getEndpoint())
                .credentials(config.getUser(), config.getPasswd())
                .build();
        if (!StringUtil.isEmpty(config.getBucket(), true)) {
            bucket = config.getBucket();
        }

        this.config = config;

        try {
            if (!client.bucketExists(healthBucketExistsArgs)) {
                log.info("== 健康检查Bucket创建");
                client.makeBucket(MakeBucketArgs.builder().bucket(HEALTH_CHECK_BUCKET_NAME).build());
            }
        } catch (Exception e) {
            log.error("== minio连接获取异常，请检查配置");
            e.printStackTrace();
        }


    }

    public MinioClient getClient() throws Exception {
        if (client == null || !client.bucketExists(healthBucketExistsArgs)) {
            client =
                    MinioClient.builder()
                            .endpoint(config.getEndpoint())
                            .credentials(config.getUser(), config.getPasswd())
                            .build();
        }
        return client;
    }
}
