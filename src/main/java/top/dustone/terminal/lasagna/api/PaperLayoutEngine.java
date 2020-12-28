package top.dustone.terminal.lasagna.api;

import top.dustone.terminal.lasagna.model.PaperContainer;

/**
 * @Author: Dustone
 * @Email: 13048062053@163.com
 * @Group: Dustone Network Corp
 * @Date: 2020/12/28 15:46
 */
public class PaperLayoutEngine {
    private static PaperLayoutEngine layoutEngine = new PaperLayoutEngine();
    public PaperLayoutEngine getInstance(){
        return layoutEngine;
    }
    public PaperLayoutEngine loadConfig(int x, int y, PaperContainer mainContainer){

    }

}
