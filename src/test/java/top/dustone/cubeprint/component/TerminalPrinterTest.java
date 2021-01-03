package top.dustone.cubeprint.component;

import org.junit.Test;
import top.dustone.cubeprint.model.CubeRoot;

import static org.junit.Assert.*;

/**
 * @Author: Dustone
 * @Email: 13048062053@163.com
 * @Group: Dustone Network Corp
 * @Date: 2021/1/3 11:19
 */
public class TerminalPrinterTest {
    @Test
    public void testBorderPaint(){
        TerminalPrinter terminalPrinter = new TerminalPrinter(30,20);
        CubeRoot cubeRoot = new CubeRoot();
        cubeRoot.setLayoutOccupy(24).setLayoutOccupyOffset(0).setWidth(30).setHeight(20).setBorderBottom(true);
        cubeRoot.paintBorder(terminalPrinter);
        System.out.println(terminalPrinter.debugPrintAndResetBuilderPools());
    }
}