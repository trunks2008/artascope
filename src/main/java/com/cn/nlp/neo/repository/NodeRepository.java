package com.cn.nlp.neo.repository;

import com.cn.nlp.neo.node.Node;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NodeRepository extends Neo4jRepository<Node,Long> {

    @Query("MATCH p=(n:Person) RETURN p")
    List<Node> selectAll();

    @Query("MATCH(p:Person{name:{name}}) return p")
    Node findByName(String name);

}
