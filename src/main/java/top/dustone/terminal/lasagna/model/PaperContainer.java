package top.dustone.terminal.lasagna.model;

import lombok.Data;

/**
 * @Author: Dustone
 * @Email: 13048062053@163.com
 * @Group: Dustone Network Corp
 * @Date: 2020/12/25 11:32
 *
 *
 *
 */
@Data
public class PaperContainer extends PaperRoot implements Comparable{
    int pageLevel;

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
