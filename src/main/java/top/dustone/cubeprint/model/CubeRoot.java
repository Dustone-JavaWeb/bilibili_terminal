package top.dustone.cubeprint.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import top.dustone.cubeprint.component.TerminalPrinter;
import top.dustone.terminal.lasagna.model.PaperRoot;

import java.util.List;

/**
 * @Author: Dustone
 * @Email: 13048062053@163.com
 * @Group: Dustone Network Corp
 * @Date: 2020/12/31 15:53
 * <p>
 * The super class for all Paper classes, To store some common attributes
 */
@Data
@NoArgsConstructor
@Accessors(chain = true)
public class CubeRoot {
    public static final int MAX_WEIGHT = 24;

    /**
     * Unique id of each cube
     */
    String cubeId;
    /**
     * The name to display
     */
    String displayName;
    /**
     * options of display
     */
    CubeLayoutDisplay displayFlag = CubeLayoutDisplay.DISPLAY;
    /**
     * The flag whether the topic display only the top border is on
     */
    boolean displayNameFlag;


    /**
     * parent paper
     */
    CubeRoot parent;
    /**
     * parent paper
     */
    List<CubeRoot> children;
    /**
     * layout weight from 0 to 24  o: none display  24 max display
     */
    int layoutOccupy = 0;
    /**
     * layout weight offset default 0 max 24
     */
    int layoutOccupyOffset = 0;
    /**
     * the style of layout,  when CubeLayoutDirection.X
     */
    CubeLayoutDirection layoutDirection;

    /**
     * border display flag
     */
    boolean borderTop = false;
    boolean borderBottom = false;
    boolean borderLeft = false;
    boolean borderRight = false;
    char borderTopChar = '-';
    char borderBottomChar = '-';
    char borderLeftChar = '│';
    char borderRightChar = '│';
    char borderTopRightChar = '┐';
    char borderTopLeftChar = '┌';
    char borderBottomLeftChar = '└';
    char borderBottomRightChar = '┘';
    /**
     * position
     */
    int startX = 0;
    int startY = 0;
    int endX = 0;
    int endY = 0;
    int x = -1;
    int y = -1;
    int width = 1;
    int height = 1;

    public enum CubeLayoutDirection {
        X, Y
    }

    public enum CubeLayoutDisplay {
        DISPLAY, HIDDEN, NONE
    }

    public CubeRoot loadPositionInfoFromParent(CubeRoot parent, int layoutOccupyOffset) {
        this.parent = parent;
        this.displayFlag = parent.displayFlag;
        if (this.displayFlag == CubeLayoutDisplay.NONE) {
            startX = 0;
            startY = 0;
            endX = 0;
            endY = 0;
            x = -1;
            y = -1;
            width = 1;
            height = 1;
        } else {
            // X way layout
            if (parent.layoutDirection == CubeLayoutDirection.X) {
                this.x = parent.startX + layoutOccupyOffset;
                this.y = parent.startY;
                this.width = (parent.endX - parent.startX) / 24 * layoutOccupy;
                this.height = parent.endY - parent.startY;
            } else {
                this.x = parent.startX;
                this.y = parent.startY + layoutOccupyOffset;
                this.height = (parent.endY - parent.startY) / 24 * layoutOccupy;
                this.width = parent.endX - parent.startX;
            }
            if (borderTop) startY = y + 1;
            else startY = y;
            if (borderBottom) endY = y + height - 1;
            else endY = y + height;
            if (borderLeft) startX = x + 1;
            else startX = x;
            if (borderRight) endX = x + width - 1;
            else endX = x;
        }
        return this;
    }

    public CubeRoot paintBorder(TerminalPrinter terminalPrinter) {
        StringBuilder[][] textBuilderPool = terminalPrinter.getTextBuilderPool();
        StringBuilder[][] ansiBuilderPool = terminalPrinter.getAnsiBuilderPool();
        if(borderTop){
            // paint the border without angle
            for(int i = startX;i<x+width-1;i++){
                textBuilderPool[y][i].append(borderTopChar);
            }
        }
        if(borderBottom){
            // paint the border without angle
            for(int i = startX;i<x+width-1;i++){
                textBuilderPool[y+height][i].append(borderBottomChar);
            }
        }
        if(borderLeft){
            // paint the border without angle
            for(int i = startY;i<y+height-1;i++){
                textBuilderPool[i][x].append(borderLeftChar);
            }
        }
        if(borderRight){
            // paint the border without angle
            for(int i = startY;i<y+height-1;i++){
                textBuilderPool[i][x+width].append(borderRightChar);
            }
        }
        // paint the angle
        if(borderLeft) {
            if (borderTop) textBuilderPool[y][x].append(borderTopLeftChar);
            else textBuilderPool[y][x].append(borderLeftChar);
        }else if(borderTop){
            textBuilderPool[y][x].append(borderTop);
        }
        if(borderTop) {
            if (borderRight) textBuilderPool[y][x+width].append(borderTopRightChar);
            else textBuilderPool[y][x+width].append(borderTopRightChar);
        }else if(borderRight){
            textBuilderPool[y][x+width].append(borderTopRightChar);
        }
        if(borderRight) {
            if (borderBottom) textBuilderPool[y+height][x+width].append(borderBottomRightChar);
            else textBuilderPool[y+height][x+width].append(borderBottomRightChar);
        }else if(borderBottom){
            textBuilderPool[y+height][x+width].append(borderBottomRightChar);
        }
        if(borderBottom) {
            if (borderLeft) textBuilderPool[y+height][x+1].append(borderBottomLeftChar);
            else textBuilderPool[y+height][x+1].append(borderBottomLeftChar);
        }else if(borderLeft){
            textBuilderPool[y+height][x+1].append(borderBottomLeftChar);
        }
        return this;
    }


}
