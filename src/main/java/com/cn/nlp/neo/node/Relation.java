package com.cn.nlp.neo.node;

import lombok.Data;
import org.neo4j.ogm.annotation.*;

/**
 * @author : Hydra
 * @date: 2022/9/5 15:53
 * @version: 1.0
 */
@Data
@RelationshipEntity(type = "Relation")
public class Relation {

    @Id
    @GeneratedValue
    private Long id;

    @StartNode
    private Node startNode;

    @EndNode
    private Node endNode;

    @Property(name = "relation")
    private String relation;

}
