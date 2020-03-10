package com.arkdex.springinaction.configprofile;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@ConfigurationProperties("db")
public class DBConfig {
    private String serverName;
    private List<Param> params = new ArrayList<>();

    public DBConfig(String serverName, List<Param> params) {
        this.serverName = serverName;
        this.params = params;
    }

    public String getServerName() {
        return serverName;
    }

    public void setServerName(String serverName) {
        this.serverName = serverName;
    }

    public List<Param> getParams() {
        return params;
    }

    public void setParams(List<Param> params) {
        this.params = params;
    }

    public DBConfig() {
    }

    @Override
    public String toString() {
        return "DBConfig{" +
                "serverName='" + serverName + '\'' +
                ", params=" + params +
                '}';
    }
}
