package top.dustone.terminal.lasagna.model;

import lombok.Data;

/**
 * @Author: Dustone
 * @Email: 13048062053@163.com
 * @Group: Dustone Network Corp
 * @Date: 2020/12/25 11:32
 * <p>
 * <p>
 * The container of panels
 */
@Data
public class PaperContainer extends PaperRoot implements Comparable {
    /**
     * The default value of paper level,
     */
    public static int DEFAULT_PAPER_LEVEL = 0;
    int paperLevel = DEFAULT_PAPER_LEVEL;


    @Override
    public int compareTo(Object o) {
        if (o instanceof PaperContainer && o != null) {
            PaperContainer p = (PaperContainer) o;
            if (p.paperLevel > this.paperLevel) {
                return -1;
            } else if(p.paperLevel < this.paperLevel){
                return 1;
            }else{
                return 0;
            }
        } else {
            return -1;
        }
    }
}
