package org.example.controller;

import org.example.model.Student;
import org.example.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    /**
     * 查询学生列表，为选择班级的下拉菜单后，选择别的下拉菜单
     */
    @GetMapping("/queryAsDict")
    public Object queryAsDict(Integer dictionaryKey){
        //在班级表，查询所有学生列表
        List<Student> students = studentService.queryAsDict(dictionaryKey);
        return students;
    }
    @GetMapping("/query")
    public Object query(Student student){
        List<Student> students = studentService.query(student);
        return students;
    }
    /**
     * /api/student/add
     * */
    @PostMapping("/add")
    public Object add(@RequestBody Student student){
        int n = studentService.add(student);
        return null;
    }

    @PostMapping("/update")
    public Object update(@RequestBody Student student){
        int n = studentService.update(student);
        return null;
    }

    @GetMapping("/delete")
    public Object delete(@RequestParam("ids") List<Integer> ids){
        int n = studentService.delete(ids);
        return null;
    }
    /**
     * Get 查询学生详情，和请求数据一样
     * */
    @GetMapping("/queryById")
    public Object queryBuId(Integer id){
        Student student = studentService.queryById(id);
        return student;
    }
}
