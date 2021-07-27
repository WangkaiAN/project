package org.example.controller;

import org.example.model.Classes;
import org.example.service.ClassesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/classes")
public class ClassesController {

    @Autowired
    private ClassesService classesService;

    /**
     * 查询班级数据字典
     *  多表查询，需要继承，或者再写一个类
     */

    @GetMapping("/queryAsDict")
    public Object queryAsDict(){
        //查询所有班级信息，转换班级id为数据字典标签的key dictionaryTagKey
        //转换班级name，为数据字典百年前的value
        List<Classes> dicts = classesService.queryAsDict();
        return dicts;

    }

    @GetMapping("/query")
    public Object query(Classes classes){
        List<Classes> list  = classesService.query(classes);
        return list;
    }

    @PostMapping("/add")
    public Object add(@RequestBody Classes classes){
        int n = classesService.add(classes);
        return null;
    }

    @PostMapping("/update")
    public Object update(@RequestBody Classes classes){
        int n = classesService.update(classes);
        return null;
    }

    @GetMapping("/delete")
    public Object delete(@RequestParam("ids") List<Integer> ids){
        int n = classesService.delete(ids);
        return null;
    }

    @GetMapping("/queryById")
    public Object queryById(Integer id){
        Classes classes = classesService.queryById(id);
        return classes;
    }
}
