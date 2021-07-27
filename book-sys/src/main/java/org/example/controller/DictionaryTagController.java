package org.example.controller;

import org.example.model.DictionaryTag;
import org.example.service.DictionaryService;
import org.example.service.DictionaryTagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/dict/tag")
public class DictionaryTagController {

    @Autowired
    private DictionaryTagService dictionaryTagService;

    /**
     * 通过数据字典key查询关联的数据字典标签列表
     * 响应数据格式
     * {
     * "success" : true,
     * "code" : "200",
     * "message" : "操作成功",
     * "data" : [ {
     * "dictionaryTagKey" : "000001001",
     * "dictionaryTagValue" : "2020届"
     * },
     * */
    @GetMapping("/query")
    public Object query(String dictionaryKey){
        List<DictionaryTag> tags = dictionaryTagService.query(dictionaryKey);
        return tags;
    }
}
