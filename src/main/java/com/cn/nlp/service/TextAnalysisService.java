package com.cn.nlp.service;

import com.cn.nlp.neo.node.Relation;

import java.util.List;

public interface TextAnalysisService {

    List<Relation> parseAndBind(String sentence);

}
