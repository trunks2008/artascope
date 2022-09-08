package com.cn.nlp.spo;

import edu.stanford.nlp.trees.TreeGraphNode;
import lombok.Getter;

/**
 * @author : Hydra
 * @date: 2022/9/1 14:20
 * @version: 1.0
 */
@Getter
public class MainPart {

    /**
     * 主语
     */
    public TreeGraphNode subject;
    /**
     * 谓语
     */
    public TreeGraphNode predicate;
    /**
     * 宾语
     */
    public TreeGraphNode object;

    /**
     * 结果
     */
    public String result;

    public MainPart(TreeGraphNode subject, TreeGraphNode predicate, TreeGraphNode object) {
        this.subject = subject;
        this.predicate = predicate;
        this.object = object;
    }

    public MainPart(TreeGraphNode predicate) {
        this(null, predicate, null);
    }

    public MainPart() {
        result = "";
    }

    /**
     * 结果填充完成
     */
    public void done() {
        result = predicate.toString("value");
        if (subject != null) {
            result = subject.toString("value") + result;
        }
        if (object != null) {
            result = result + object.toString("value");
        }
    }

    public boolean isDone() {
        return result != null;
    }

    @Override
    public String toString() {
        if (result != null)
            return result;

        return "MainPart{" +
                "主语='" + subject + '\'' +
                ", 谓语='" + predicate + '\'' +
                ", 宾语='" + object + '\'' +
                '}';
    }

}
