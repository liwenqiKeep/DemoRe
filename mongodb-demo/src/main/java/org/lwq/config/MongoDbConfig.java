package org.lwq.config;

import org.springframework.context.annotation.Configuration;

/**
 * @author liwenqi
 */
@Configuration
public class MongoDbConfig {

    private String host;

    private int port;

    private String user;

    private String passwd;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }
}
