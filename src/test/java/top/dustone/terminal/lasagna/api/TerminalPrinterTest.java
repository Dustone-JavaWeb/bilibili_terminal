package top.dustone.terminal.lasagna.api;

import org.junit.Test;

/**
 * @Author: Dustone
 * @Email: 13048062053@163.com
 * @Group: Dustone Network Corp
 * @Date: 2020/12/28 14:10
 */
public class TerminalPrinterTest {
    @Test
    public void textTerminalPrinter(){
        TerminalPrinter terminalPrinter = new TerminalPrinter(300,200);
        terminalPrinter.getTextBuilderPool()[150][200].append("hello world");
        System.out.println(terminalPrinter.printAndResetBuilderPools());

        StringBuilder sb = new StringBuilder("很严");
    }
}