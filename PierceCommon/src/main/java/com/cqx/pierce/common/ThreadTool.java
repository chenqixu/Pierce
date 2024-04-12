package com.cqx.pierce.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * ThreadTool
 *
 * @author chenqixu
 */
public class ThreadTool {
    private static final Logger logger = LoggerFactory.getLogger(ThreadTool.class);
    private BaseRunable baseRunable;
    private Thread thread;

    public ThreadTool() {
    }

    public ThreadTool(BaseRunable baseRunable) {
        this.baseRunable = baseRunable;
    }

    public void start() {
        start(this.baseRunable);
    }

    public void start(BaseRunable baseRunable) {
        if (baseRunable != null && thread == null) {
            this.baseRunable = baseRunable;
            thread = new Thread(baseRunable);
            thread.start();
        }
    }

    public void stop() {
        if (thread != null) {
            baseRunable.stop();
            try {
                thread.join();
            } catch (InterruptedException e) {
                logger.error(e.getMessage(), e);
            }
        }
    }
}
