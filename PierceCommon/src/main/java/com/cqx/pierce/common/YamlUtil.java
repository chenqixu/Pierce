package com.cqx.pierce.common;

import org.yaml.snakeyaml.Yaml;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Map;

/**
 * YamlUtil
 *
 * @author chenqixu
 */
public class YamlUtil {

    private YamlUtil() {
    }

    public static YamlUtil builder() {
        return new YamlUtil();
    }

    public Map parserConf(String path) throws IOException {
        Yaml yaml;
        InputStream is = null;
        Map map;
        try {
            // 加载yaml配置文件
            yaml = new Yaml();
            URL url = new URL(path);
            is = url.openStream();
            map = yaml.loadAs(is, Map.class);
            is.close();
        } finally {
            if (is != null)
                is.close();
        }
        return map;
    }
}
