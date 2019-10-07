package com.gityou.repository.controller;


import com.gityou.repository.entity.BranchResult;
import com.gityou.repository.service.BranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("branch")
public class BranchController {

    @Autowired
    private BranchService branchService;

    /* 根据仓库查询branch
     * */
    @GetMapping("list")
    public ResponseEntity<List<BranchResult>> queryList(String user, String name) {
        List<BranchResult> result = branchService.queryList(user, name);
        if (result == null)
            return ResponseEntity.notFound().build();
        else
            return ResponseEntity.ok(result);
    }

}// end
