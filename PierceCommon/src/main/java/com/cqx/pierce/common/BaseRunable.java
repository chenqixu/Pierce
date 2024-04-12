package com.cqx.pierce.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * BaseRunable
 *
 * @author chenqixu
 */
public abstract class BaseRunable implements Runnable {

    /**
     * 共用日志，使用getClass()保证都是当前类输出
     */
    protected final Logger logger = LoggerFactory.getLogger(getClass());
    private AtomicBoolean flag = new AtomicBoolean(false);

    @Override
    public void run() {
        while (!flag.get()) {
            try {
                exec();
            } catch (Exception e) {
                logger.error("exec发生异常，信息：" + e.getMessage(), e);
            }
        }
        try {
            close();
        } catch (Exception e) {
            logger.error("close发生异常，信息：" + e.getMessage(), e);
        }
    }

    public void stop() {
        flag.set(true);
    }

    public abstract void exec() throws Exception;

    public abstract void close() throws Exception;
}
