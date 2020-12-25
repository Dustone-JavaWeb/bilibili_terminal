package top.dustone.terminal.lasagna.model;

import lombok.Data;

/**
 * @Author: Dustone
 * @Email: 13048062053@163.com
 * @Group: Dustone Network Corp
 * @Date: 2020/12/25 11:26
 *
 *
 *  The super class for all Paper classes, To store some common attributes
 */
@Data
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
     * father paper
     */
    PaperRoot father;

}
