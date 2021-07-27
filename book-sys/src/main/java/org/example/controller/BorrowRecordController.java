package org.example.controller;

import org.example.model.Book;
import org.example.model.BorrowRecord;
import org.example.service.BorrowRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/borrowRecord")
public class BorrowRecordController {

    @Autowired
    private BorrowRecordService borrowRecordService;

    @GetMapping("/query")
    public Object query(BorrowRecord input){
        List<BorrowRecord> records = borrowRecordService.query(input);
        return records;
    }

    @PostMapping("/add")
    public Object add(@RequestBody BorrowRecord record){
        int n = borrowRecordService.add(record);
        return null;
    }

    @GetMapping("/delete")
    public Object delete(@RequestParam("ids") List<Integer> ids){
        int n = borrowRecordService.delete(ids);
        return null;
    }
    /**
     * 查询详情接口，修改借阅记录
     * GET borrowRecord/1 queryById?id=1
     * */

    @GetMapping("/queryById")
    public Object queryBuId(Integer id){
        BorrowRecord record = borrowRecordService.queryById(id);
        return record;
    }
    /**
     * POST borrowRecord/update
     *
     * */
    @PostMapping("/update")
    public Object update(@RequestBody BorrowRecord record){
        int n = borrowRecordService.update(record);
        return null;
    }

}
