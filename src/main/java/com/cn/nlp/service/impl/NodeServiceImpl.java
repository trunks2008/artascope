package com.cn.nlp.service.impl;

import com.cn.nlp.neo.node.Node;
import com.cn.nlp.neo.node.Relation;
import com.cn.nlp.neo.repository.RelationRepository;
import com.cn.nlp.neo.repository.NodeRepository;
import com.cn.nlp.service.NodeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author : Hydra
 * @date: 2022/9/5 16:02
 * @version: 1.0
 */
@Service
@AllArgsConstructor
public class NodeServiceImpl implements NodeService {
    private final NodeRepository nodeRepository;
    private final RelationRepository relationRepository;

    @Override
    public List<Node> getAll() {
//        Iterable<Node> all = nodeRepository.findAll();
//        ArrayList<Node> nodes = Lists.newArrayList(all);
//        all.forEach(System.out::println);

        List<Node> nodes = nodeRepository.selectAll();
        nodes.forEach(System.out::println);
        return nodes;
    }

    @Override
    public Node save(Node node) {
        Node save = nodeRepository.save(node);
        return save;
    }

    @Override
    public Node findByName(String name) {
        return nodeRepository.findByName(name);
    }

    @Override
    public void bind(Long startId, Long endId) {
        Node start = nodeRepository.findById(startId).get();
        Node end = nodeRepository.findById(endId).get();

        Relation relation =new Relation();
        relation.setStartNode(start);
        relation.setEndNode(end);
        relation.setRelation("re"+ UUID.randomUUID().toString());

        Relation save = relationRepository.save(relation);
    }

    @Override
    public void bind(String name1, String name2, String relationName) {
        Node start = nodeRepository.findByName(name1);
        Node end = nodeRepository.findByName(name2);

        Relation relation =new Relation();
        relation.setStartNode(start);
        relation.setEndNode(end);
        relation.setRelation(relationName);

        relationRepository.save(relation);
    }

}
