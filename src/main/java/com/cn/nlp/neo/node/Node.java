package com.cn.nlp.neo.node;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.neo4j.ogm.annotation.*;

import java.util.List;
import java.util.Set;

/**
 * @author : Hydra
 * @date: 2022/9/5 15:49
 * @version: 1.0
 */
@Data
@NodeEntity(label = "Person")
public class Node {

    @Id
    @GeneratedValue
    private Long id;

    @Property(name = "name")
    private String name;

    @Property(name = "title")
    private String title;

//    @ToString.Exclude
//    @Relationship(type = "BotRelation", direction = Relationship.OUTGOING)
//    @JsonIgnoreProperties("outgoing")
//    public Set<BotRelation> relations;

}
