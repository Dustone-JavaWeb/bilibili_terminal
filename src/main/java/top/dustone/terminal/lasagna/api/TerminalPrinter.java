package top.dustone.terminal.lasagna.api;

import lombok.Data;

/**
 * @Author: Dustone
 * @Email: 13048062053@163.com
 * @Group: Dustone Network Corp
 * @Date: 2020/12/28 10:27
 * <p>
 * The printer is a container with words.
 */
@Data
public class TerminalPrinter {
    /**
     * The pool of display text,
     * For example,the size of screen is 800x600 it will like StringBuilder[600][800]
     */
    private StringBuilder[][] textBuilderPool;
    /**
     * The pool of ansi control text, it will bigger than textBuilderPool,
     * Fot example,the size of screen is 800x600 it will like StringBuilder[600][801]
     */
    private StringBuilder[][] ansiBuilderPool;
    /**
     * The width of window.
     */
    private int x;
    /**
     * The height of window.
     */
    private int y;

    /**
     * Constructor
     *
     * @param x The width of terminal window.
     * @param y The height of terminal window.
     */
    public TerminalPrinter(int x, int y) {
        this.textBuilderPool = new StringBuilder[y][x];
        this.ansiBuilderPool = new StringBuilder[y][x + 1];
        this.x = x;
        this.y = y;
        initBuilderPools();
    }

    /**
     * Init the StringBuilder Pools.
     */
    private void initBuilderPools() {
        for (int yP = 0; yP < y; yP++) {
            textBuilderPool[yP] = new StringBuilder[x];
            ansiBuilderPool[yP] = new StringBuilder[x + 1];
            for (int xP = 0; xP < x; xP++) {
                textBuilderPool[yP][xP] = new StringBuilder();
                ansiBuilderPool[yP][xP] = new StringBuilder();
                // last
                if (xP == x - 1) ansiBuilderPool[yP][xP + 1] = new StringBuilder();
            }
        }
    }

    /**
     * Reset the StringBuilder Pools.
     */
    private void resetBuilderPools() {
        for (int yP = 0; yP < y; yP++) {
            for (int xP = 0; xP < x; xP++) {
                textBuilderPool[yP][xP].setLength(0);
                ansiBuilderPool[yP][xP].setLength(0);
                // last
                if (xP == x - 1) ansiBuilderPool[yP][xP + 1].setLength(0);
                ;
            }
        }
    }

    /**
     * iterates the pools to print window.
     * For example, if here is an red 'a' in y:200 x:300
     * then textBuilderPool[199][299]= a
     * ansiBuilderPool[199][299]= \033[40;31m
     * ansiBuilderPool[199][300]= \033[0m
     * print result
     * \033[40;31m a \033[0m
     *
     * @return print result
     */
    public StringBuilder printAndResetBuilderPools() {
        StringBuilder sb = new StringBuilder();
        for (int yP = 0; yP < y; yP++) {
            sb.append("\033[").append(yP + 1).append(";1H\033[K");
            for (int xP = 0; xP < x; xP++) {
                sb.append(ansiBuilderPool[yP][xP]);
                sb.append(textBuilderPool[yP][xP]);
                textBuilderPool[yP][xP].setLength(0);
                ansiBuilderPool[yP][xP].setLength(0);
                // last
                if (xP == x - 1) {
                    sb.append(ansiBuilderPool[yP][xP + 1]);
                    ansiBuilderPool[yP][xP + 1].setLength(0);
                }
            }
        }
        return sb;
    }
}
