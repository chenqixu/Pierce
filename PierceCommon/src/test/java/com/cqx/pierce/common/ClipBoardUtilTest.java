package com.cqx.pierce.common;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ClipBoardUtilTest {
    private static final Logger logger = LoggerFactory.getLogger(ClipBoardUtilTest.class);
    private ClipBoardUtil clipBoardUtil = new ClipBoardUtil();

    @Test
    public void getSysClipBoardText() throws IOException, UnsupportedFlavorException {
        logger.info("get text，{}", clipBoardUtil.getSysClipBoardText());
    }

    @Test
    public void setSysClipBoardText() throws IOException, UnsupportedFlavorException {
        String setText = "123";
        logger.info("set，{}", setText);
        clipBoardUtil.setSysClipBoardText(setText);
        logger.info("get text，{}", clipBoardUtil.getSysClipBoardText());
    }

    @Test
    public void getSysClipBoardFileList() throws IOException, UnsupportedFlavorException {
        logger.info("get file list，{}", clipBoardUtil.getSysClipBoardFileList());
    }

    @Test
    public void setSysClipBoardFileList() throws IOException, UnsupportedFlavorException {
        List<File> fileList = new ArrayList<File>();
        fileList.add(new File("d:\\Work\\ETL\\天空\\组件开发\\批-FTP采集到HDFS\\"));
        logger.info("set，{}", fileList);
        clipBoardUtil.setSysClipBoardFileList(fileList);
        logger.info("get file list，{}", clipBoardUtil.getSysClipBoardFileList());
    }
}