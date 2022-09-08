package com.cn.nlp.spo;

import edu.stanford.nlp.trees.TreeGraphNode;

import java.util.Objects;

/**
 * @author : Hydra
 * @date: 2022/9/6 13:46
 * @version: 1.0
 */
public class GraphUtil {

    public static String getNodeValue(TreeGraphNode treeGraphNode){
        if (Objects.nonNull(treeGraphNode))
            return treeGraphNode.toString("value");
        return null;
    }

}
