package top.dustone.bilibili.terminal;

import java.awt.*;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        System.out.println("ab".length());
        System.out.println("你好".length());
        System.out.println("\u2593\u2593\u2593\u2593\u2593\u2593\u2593");
        Font font = new Font("MS Sans Serif", java.awt.Font.PLAIN, 12);
        FontMetrics fm = Toolkit.getDefaultToolkit().getFontMetrics(font);
        System.out.println(fm.stringWidth("你好你好"));
        System.out.println(fm.stringWidth("abab"));
    }
}
