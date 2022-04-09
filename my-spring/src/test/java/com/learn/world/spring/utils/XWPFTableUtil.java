package com.learn.world.spring.utils;

import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STMerge;

/**
 * @author wencheng
 * @create 2021/9/27 15:18
 */
public class XWPFTableUtil {

    /**
     * word单元格列合并
     * @param table 表格
     * @param row 合并列所在行
     * @param startCell 开始列
     * @param endCell 结束列
     * @date 2020年4月8日 下午4:43:54
     */
    public static void mergeCellsHorizontal(XWPFTable table, int row, int startCell, int endCell) {
        for (int i = startCell; i <= endCell; i++) {
            XWPFTableCell cell = table.getRow(row).getCell(i);
            if (i == startCell) {
                // The first merged cell is set with RESTART merge value
                cell.getCTTc().addNewTcPr().addNewHMerge().setVal(STMerge.RESTART);
            } else {
                // Cells which join (merge) the first one, are set with CONTINUE
                cell.getCTTc().addNewTcPr().addNewHMerge().setVal(STMerge.CONTINUE);
            }
        }
    }

    /**
     * word单元格行合并
     * @param table 表格
     * @param col 合并行所在列
     * @param startRow 开始行
     * @param endRow 结束行
     * @date 2020年4月8日 下午4:46:18
     */
    public static void mergeCellsVertically(XWPFTable table, int col, int startRow, int endRow) {
        for (int i = startRow; i <= endRow; i++) {
            XWPFTableCell cell = table.getRow(i).getCell(col);
            if (i == startRow) {
                // The first merged cell is set with RESTART merge value
                cell.getCTTc().addNewTcPr().addNewVMerge().setVal(STMerge.RESTART);
            } else {
                // Cells which join (merge) the first one, are set with CONTINUE
                cell.getCTTc().addNewTcPr().addNewVMerge().setVal(STMerge.CONTINUE);
            }
        }
    }
}
