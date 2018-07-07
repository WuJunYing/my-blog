package com.xiaowuu.controller.backstage;

import com.xiaowuu.entity.blog.BlogComment;
import com.xiaowuu.service.blog.BlogCommentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/dashboard")
public class DashboardController {

    private final static Logger logger = LoggerFactory.getLogger(DashboardController.class);

    @Autowired
    private BlogCommentService blogCommentService;

    /**
     * 首页获取未评论 list
     * @return
     */
    @RequestMapping(value = "getTodoCommentList")
    public Object getTodoCommentList(){
        Map<String, Object> map = new HashMap<>();
        List<BlogComment> todoCommentList = blogCommentService.getTodoCommentList();
        map.put("rows",todoCommentList);
        map.put("total",todoCommentList.size());

        return map;
    }
}
