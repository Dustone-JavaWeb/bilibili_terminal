package top.dustone.terminal.lasagna.api;

import top.dustone.terminal.lasagna.model.PaperContainer;

import java.util.Iterator;
import java.util.SortedSet;
import java.util.concurrent.ConcurrentSkipListSet;

/**
 * @Author: Dustone
 * @Email: 13048062053@163.com
 * @Group: Dustone Network Corp
 * @Date: 2020/12/28 15:46
 */
public class PaperLayoutEngine {
    private int width;
    private int height;
    private SortedSet<PaperContainer> paperContainers;
    private PaperContainer mainContainer;

    public PaperLayoutEngine(int width, int height) {
        this.width = width;
        this.height = height;
        this.mainContainer = new PaperContainer();
        this.mainContainer.setX(0).setY(0).setWidth(width).setHeight(height).setBorderBottom(false).setBorderLeft(false).setBorderTop(false).setBorderRight(false);
        this.paperContainers = new ConcurrentSkipListSet<>();
    }
    public PaperLayoutEngine loadLayout(int width,int height){
        this.width = width;
        this.height = height;
        this.mainContainer.setWidth(width).setHeight(height);
        loadLayout();
        return this;
    }
    public PaperLayoutEngine loadLayout(){
        Iterator<PaperContainer> containerIterator = paperContainers.iterator();
        while(containerIterator.hasNext()){
            PaperContainer paperContainer = containerIterator.next();
            paperContainer.loadPositionInfo(mainContainer);
        }
        return this;
    }


}
