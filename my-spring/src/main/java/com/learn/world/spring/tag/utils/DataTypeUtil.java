package com.learn.world.spring.tag.utils;

/**
 * @author leidd Create on 2019/11/20 17:23
 */

public class DataTypeUtil {
    public static final String QUOTE_DEFAULT = "\"";
    public static final String QUOTE_MYSQL = "`";


    private DataTypeUtil(){}
    /**
     * 数据库的quote符
     *
     * @return
     */
    public static String getQuote(String databaseType) {
        String quote = null;
        if ("mysql".equals(databaseType) || "sdc_etl_mysql".equals(databaseType) || "hive".equals(databaseType) || "gbase8a".equals(databaseType)) {
            quote = QUOTE_MYSQL;
        } else {
            quote = QUOTE_DEFAULT;
        }
        return quote;
    }

    public static String quoteReplaceObj(String databaseType, String field) {
        String quote = null;
        if ("mysql".equals(databaseType) || "sdc_etl_mysql".equals(databaseType) || "hive".equals(databaseType) || "gbase8a".equals(databaseType)) {
            quote = QUOTE_MYSQL;
        } else {
            quote = QUOTE_DEFAULT;
        }
        if (field.indexOf(quote) >= 0) {
            return field;
        }
        return quote + field + quote;
    }

    public static String quoteField(String type, String field) {
        String quote = getQuote(type);
        if (field.indexOf(quote) >= 0) {
            return field;
        }
        return quote + field + quote;
    }

    public static String getQuoteSchemaTable(String type, String schemaName, String tableName) {
        if (schemaName == null || schemaName.length() <= 0) {
            return quoteField(type, tableName);
        } else {
            return quoteField(type, schemaName) + "." + quoteField(type, tableName);
        }
    }
}
