package com.cn.nlp.controller;

import com.cn.nlp.neo.node.Relation;
import com.cn.nlp.service.TextAnalysisService;
import com.cn.nlp.spo.GraphUtil;
import com.cn.nlp.spo.MainPart;
import com.cn.nlp.spo.MainPartExtractor;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author : Hydra
 * @date: 2022/9/6 13:37
 * @version: 1.0
 */
@RestController
@RequestMapping("text")
@AllArgsConstructor
public class TextAnalysisController {

    private final TextAnalysisService textAnalysisService;

    @GetMapping("parse")
    public List<Relation> parse(String sentence) {
        return textAnalysisService.parseAndBind(sentence);
    }

    @GetMapping("test")
    public void mpTest(String testCase) {
        MainPart mp = MainPartExtractor.getMainPart(testCase);
        System.out.printf("%s   %s   %s \n",
                GraphUtil.getNodeValue(mp.getSubject()),
                GraphUtil.getNodeValue(mp.getPredicate()),
                GraphUtil.getNodeValue(mp.getObject()));
    }

    public static void main(String[] args) {
        String[] testCaseArray = {
                "我一直很喜欢你",
                "你被我喜欢",
                "美丽又善良的你被卑微的我深深的喜欢着……",
                "小米公司主要生产智能手机",
                "他送给了我一份礼物",
                "这类算法在有限的一段时间内终止",
                "如果大海能够带走我的哀愁",
                "天青色等烟雨，而我在等你",
                "我昨天看见了一个非常可爱的小孩",
//                "只有自信的程序员才能把握未来",
//                "主干识别可以提高检索系统的智能",
//                "这个项目的作者是hankcs",
//                "hankcs是一个无门无派的浪人",
//                "搜索hankcs可以找到我的博客",
//                "静安区体育局2013年部门决算情况说明",
        };
        for (String testCase : testCaseArray) {
            MainPart mp = MainPartExtractor.getMainPart(testCase);
            System.out.printf("%s   %s   %s \n",
                    GraphUtil.getNodeValue(mp.getSubject()),
                    GraphUtil.getNodeValue(mp.getPredicate()),
                    GraphUtil.getNodeValue(mp.getObject()));
        }
    }

}
