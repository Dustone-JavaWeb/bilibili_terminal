package top.dustone.terminal.lasagna.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @Author: Dustone
 * @Email: 13048062053@163.com
 * @Group: Dustone Network Corp
 * @Date: 2020/12/25 11:26
 * <p>
 * <p>
 * The super class for all Paper classes, To store some common attributes
 */
@Data
@NoArgsConstructor
@Accessors(chain = true)
public class PaperRoot {
    public final static int MAX_LAYOUT_OFFSET = 24;
    /**
     * Unique id of each paper
     */
    String paperId;
    /**
     * The name to display
     */
    String displayName;
    /**
     * The
     */
    boolean topicDisplayFlag;
    /**
     * parent paper
     */
    PaperRoot parent;
    /**
     * layout weight max to 24 default 1
     */
    int layoutWeight = 0;
    /**
     * layout weight offset default 0 max 24
     */
    int layoutWeightOffset = 0;
    /**
     * the direction of layout
     */
    PaperLayoutDirection layoutDirection = PaperLayoutDirection.X;
    /**
     * border display config
     */
    boolean borderTop = false;
    boolean borderBottom = false;
    boolean borderLeft = false;
    boolean borderRight = false;
    /**
     * border style
     */
    char borderTopChar;
    char borderBottomChar;
    char borderLeftChar;
    char borderRightChar;
    /**
     * writeable border
     */
    int startX;
    int startY;
    int endX;
    int endY;
    int x;
    int y;
    int width;
    int height;

    public PaperRoot configWriteableBorder() {
        if (borderTop) startY = y + 1;
        else startY = y;
        if (borderBottom) endY = y + height - 1;
        else endY = y + height;
        if (borderLeft) startX = x + 1;
        else startX = x;
        if (borderRight) endX = x + width - 1;
        else endX = x;
        return this;
    }

    public enum PaperLayoutDirection {
        X, Y
    }
}
