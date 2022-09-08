package com.cn.nlp.service;

import com.cn.nlp.neo.node.Node;

import java.util.List;

/**
 * @author : Hydra
 * @date: 2022/9/5 16:01
 * @version: 1.0
 */
public interface NodeService {

    List<Node> getAll();

    Node save(Node node);

    Node findByName(String name);

    void bind(Long startId,Long endId);

    void bind(String name1,String name2,String relationName);

}
