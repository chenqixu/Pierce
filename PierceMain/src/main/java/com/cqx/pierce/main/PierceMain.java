package com.cqx.pierce.main;

import com.cqx.pierce.common.ThreadTool;
import com.cqx.pierce.common.YamlUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * PierceMain
 *
 * @author chenqixu
 */
public class PierceMain {
    private static final Logger logger = LoggerFactory.getLogger(PierceMain.class);

    public static void main(String[] args) throws IOException {
        //需要一个参数来标明现在是本机、虚拟机、云桌面、4A远程桌面
        //要有个顺序，往里传，还是往外传
        //读取标志
        //读取顺序
        if (args.length == 1) {
            String confPath = args[0];
            logger.info("confPath：{}", confPath);
            Map param = YamlUtil.builder().parserConf(confPath);
            String flag = (String) param.get("flag");
            List orders = (List) param.get("order");
            logger.info("flag：{}", flag);
            for (Object order : orders) {
                logger.info("order：{}", order);
            }
            //启动剪贴板监控
            ThreadTool threadTool = new ThreadTool(new ClipBoardMonitor());
            threadTool.start();
        } else {
            logger.info("You need input params.");
        }
    }
}
