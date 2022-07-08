package com.learn.world.spring.easyexcle;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.read.listener.PageReadListener;
import com.alibaba.excel.read.listener.ReadListener;
import com.alibaba.fastjson.JSON;
import com.learn.world.common.utils.FileUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

@Slf4j
public class ReadTest {

    @Test
    public void simpleRead() throws Exception{
        String fileName = FileUtil.getFilePath("easyexcle/user.xlsx");
        // 这里 需要指定读用哪个class去读，然后读取第一个sheet 文件流会自动关闭
        EasyExcel.read(fileName, User.class, new PageReadListener<User>(data->{
            for (User user : data) {
                log.info("读取到一条数据{}", JSON.toJSONString(user));
            }
        })).sheet().doRead();
    }

    @Test
    public void listenRead() throws Exception{
        String fileName = FileUtil.getFilePath("easyexcle/user.xlsx");
        // 这里 需要指定读用哪个class去读，然后读取第一个sheet 文件流会自动关闭
        EasyExcel.read(fileName, User.class, new ReadListener<User>(){

            @Override
            public void invoke(User user, AnalysisContext analysisContext) {
                log.info("读取到一条数据{}", JSON.toJSONString(user));
            }

            @Override
            public void doAfterAllAnalysed(AnalysisContext analysisContext) {
                log.info("读取完成");
            }
        }).sheet().doRead();
    }

}