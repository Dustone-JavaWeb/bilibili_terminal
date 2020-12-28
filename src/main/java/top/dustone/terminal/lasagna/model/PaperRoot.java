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
@Accessors( chain = true )
public class PaperRoot {
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
    int layoutWeight = 1;
    /**
     * border display config
     */
    boolean borderTop = false;
    boolean borderBottom=false;
    boolean borderLeft=false;
    boolean borderRight=false;
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

    public PaperRoot configBorder(boolean borderTop, boolean borderBottom, boolean borderLeft, boolean borderRight, char borderTopChar, char borderBottomChar, char borderLeftChar, char borderRightChar) {
        this.borderTop = borderTop;
        this.borderBottom = borderBottom;
        this.borderLeft = borderLeft;
        this.borderRight = borderRight;
        this.borderTopChar = borderTopChar;
        this.borderBottomChar = borderBottomChar;
        this.borderLeftChar = borderLeftChar;
        this.borderRightChar = borderRightChar;
        return this;
    }

    public enum PaperLayoutDirection{
        X,Y
    }
}
