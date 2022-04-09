package com.learn.world.test;

import com.cronutils.model.CronType;
import com.cronutils.model.definition.CronDefinition;
import com.cronutils.model.definition.CronDefinitionBuilder;
import com.cronutils.model.time.ExecutionTime;
import com.cronutils.parser.CronParser;
import org.springframework.util.unit.DataUnit;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;

/**
 * @author wencheng
 * @create 2021/8/23 17:30
 */
public class TestDoMain {
    public static void main(String[] args) throws ParseException {
//        System.out.println(getCronToDateFirst("0 0 0 *1 * ?"));
        System.out.println(DateUtil.getDate("38 57 10 13 09 ? 2021"));
    }

    private static String getFileNameByFilePath(String filePath){
        if(filePath == null){
            return null;
        }
        String substring = filePath.substring(0, filePath.lastIndexOf("/")+1);
        filePath.substring(filePath.lastIndexOf("/")+1);
        return substring;
    }

    public static boolean accept(String wildcard,String fileName) {
        Pattern bak = Pattern.compile("^" + wildcard);
        return bak.matcher(fileName).find();
    }

    /**
     * cron表达式转为日期
     *
     * @param cron
     * @return
     */
    public static Date getCronToDate(String cron) {
        String dateFormat = "ss mm HH dd MM ? yyyy";
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        Date date = null;
        try {
            date = sdf.parse(cron);
        } catch (ParseException e) {
            throw new RuntimeException("cron expression is not correctly");
        }
        return date;
    }

    /**
     * cron表达式转为日期
     *
     * @param cron
     * @return
     */
    public static Date getCronToDateFirst(String cron) {
        CronDefinition definition = CronDefinitionBuilder.instanceDefinitionFor(CronType.QUARTZ);
        CronParser parser = new CronParser(definition);

        ZonedDateTime now = ZonedDateTime.now();
        ExecutionTime executionTime = ExecutionTime.forCron(parser.parse(cron));
        Optional<ZonedDateTime> next = executionTime.nextExecution(now);
        now = next.get();
        Date date = Date.from(now.toLocalDateTime().atZone(ZoneId.systemDefault()).toInstant());
        return date;
    }
}
