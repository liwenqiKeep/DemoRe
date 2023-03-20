package org.lwq.component;

import io.minio.BucketExistsArgs;
import io.minio.MakeBucketArgs;
import io.minio.MinioClient;
import io.minio.RemoveBucketArgs;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class MinioClientFactoryTest {


    @Autowired
    private MinioClientFactory minioClientFactory;


    @Test
    public void testGetClient(){


        try {
            MinioClient client = minioClientFactory.getClient();
            assert  client != null;

            String bucketName = "minio-test";

                    client.makeBucket(MakeBucketArgs.builder().bucket(bucketName).build());
            assert client.bucketExists(BucketExistsArgs.builder().bucket(bucketName).build());

            client.removeBucket(RemoveBucketArgs.builder().bucket(bucketName).build());

            assert !client.bucketExists(BucketExistsArgs.builder().bucket(bucketName).build());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}