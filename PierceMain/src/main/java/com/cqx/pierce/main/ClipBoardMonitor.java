package com.cqx.pierce.main;

import com.cqx.pierce.common.BaseRunable;
import com.cqx.pierce.common.ClipBoardUtil;

/**
 * ClipBoardMonitor
 *
 * @author chenqixu
 */
public class ClipBoardMonitor extends BaseRunable {
    private ClipBoardUtil clipBoardUtil = new ClipBoardUtil();

    @Override
    public void exec() throws Exception {
        logger.info("get text，{}", clipBoardUtil.getSysClipBoardText());
        Thread.sleep(200);
    }

    @Override
    public void close() throws Exception {

    }
}
