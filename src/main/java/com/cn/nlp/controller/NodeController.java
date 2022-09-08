package com.cn.nlp.controller;

import com.cn.nlp.neo.node.Node;
import com.cn.nlp.service.NodeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author : Hydra
 * @date: 2022/9/5 16:34
 * @version: 1.0
 */
@RestController
@RequestMapping("node")
@AllArgsConstructor
public class NodeController {
    private final NodeService nodeService;

    @PostMapping("save")
    public Node save(@RequestBody Node node){
        Node save = nodeService.save(node);
        return save;
    }

    @GetMapping("all")
    public List<Node> findAll(){
        return  nodeService.getAll();
    }

    @GetMapping("name")
    public Node findByName(String name){
        return  nodeService.findByName(name);
    }

    @GetMapping("bind")
    public void save(Long startId,Long endId){
        nodeService.bind(startId,endId);
    }

    @GetMapping("bind2")
    public void save(String name1,String name2,String relationName){
        nodeService.bind(name1,name2,relationName);
    }
}
