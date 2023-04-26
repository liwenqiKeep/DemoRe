package org.lwq.component;

import com.mongodb.MongoClientSettings;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.lwq.config.MongoDbConfig;
import org.springframework.stereotype.Component;

import java.util.Collections;

/**
 * @author liwenqi
 */
@Component
public class MongoDbFactory {

    private final MongoDbConfig config;

    public MongoDbFactory(MongoDbConfig config) {
        this.config = config;
    }

    public MongoClient getClient() {
        ServerAddress serverAddress = new ServerAddress(config.getHost(), config.getPort());
        MongoCredential credential = MongoCredential.createCredential(
                config.getUser(),
                "test",
                config.getPasswd().toCharArray()
        );
        return MongoClients.create(
                MongoClientSettings.builder()
                        .applyToClusterSettings(builder -> builder.hosts(Collections.singletonList(serverAddress)))
                        .credential(credential).build()
        );
    }
}
