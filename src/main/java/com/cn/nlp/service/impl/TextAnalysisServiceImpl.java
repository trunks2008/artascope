package com.cn.nlp.service.impl;

import com.cn.nlp.neo.node.Node;
import com.cn.nlp.neo.node.Relation;
import com.cn.nlp.neo.repository.RelationRepository;
import com.cn.nlp.neo.repository.NodeRepository;
import com.cn.nlp.service.TextAnalysisService;
import com.cn.nlp.spo.GraphUtil;
import com.cn.nlp.spo.MainPart;
import com.cn.nlp.spo.MainPartExtractor;
import edu.stanford.nlp.trees.TreeGraphNode;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * @author : Hydra
 * @date: 2022/9/6 14:01
 * @version: 1.0
 */
@Service
@AllArgsConstructor
public class TextAnalysisServiceImpl implements TextAnalysisService {

    private final NodeRepository nodeRepository;
    private final RelationRepository relationRepository;

    @Override
    public List<Relation> parseAndBind(String sentence) {
        MainPart mp = MainPartExtractor.getMainPart(sentence);

        TreeGraphNode subject = mp.getSubject();    //主语
        TreeGraphNode predicate = mp.getPredicate();//谓语
        TreeGraphNode object = mp.getObject();      //宾语

        if (Objects.isNull(subject) || Objects.isNull(object))
            return null;

        Node startNode = addNode(subject);
        Node endNode = addNode(object);
        String relationName = GraphUtil.getNodeValue(predicate);//关系词

        List<Relation> oldRelation = relationRepository
                .findRelation(startNode, endNode,relationName);
        if (!oldRelation.isEmpty())
            return oldRelation;

        Relation botRelation=new Relation();
        botRelation.setStartNode(startNode);
        botRelation.setEndNode(endNode);
        botRelation.setRelation(relationName);
        Relation relation = relationRepository.save(botRelation);

        return Arrays.asList(relation);
    }

    private Node addNode(TreeGraphNode treeGraphNode){
        String nodeName = GraphUtil.getNodeValue(treeGraphNode);

        Node existNode = nodeRepository.findByName(nodeName);
        if (Objects.nonNull(existNode))
            return existNode;

        Node node =new Node();
        node.setName(nodeName);
        return nodeRepository.save(node);
    }

}
