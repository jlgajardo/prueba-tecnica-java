package cl.jlgajardo.pruebatecnica.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Map;

@ConfigurationProperties(prefix = "myapp")
public class AppProperties {

    private Map<String, String> properties;
    private Map<String, String> sp;
    private Map<String, Map<String, String>> datasources;

    public Map<String, String> getProperties() {
        return properties;
    }

    public void setProperties(Map<String, String> properties) {
        this.properties = properties;
    }

    public Map<String, String> getSp() {
        return sp;
    }

    public void setSp(Map<String, String> sp) {
        this.sp = sp;
    }

    public Map<String, Map<String, String>> getDatasources() {
        return datasources;
    }

    public void setDatasources(Map<String, Map<String, String>> datasources) {
        this.datasources = datasources;
    }
}
