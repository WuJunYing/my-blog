package com.xiaowuu.controller.backstage;

import com.xiaowuu.dto.ChartDataDTO;
import com.xiaowuu.dto.DashboardDetailsDTO;
import com.xiaowuu.entity.blog.BlogComment;
import com.xiaowuu.entity.blog.BlogLeaveMessage;
import com.xiaowuu.service.blog.BlogCommentService;
import com.xiaowuu.service.blog.BlogLeaveMessageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.ManagedMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequestMapping(value = "/dashboard")
public class DashboardController {

    private final static Logger logger = LoggerFactory.getLogger(DashboardController.class);

    @Autowired
    private BlogCommentService blogCommentService;

    @Autowired
    private BlogLeaveMessageService blogLeaveMessageService;

    /**
     * 首页获取未读评论 list
     * @return
     */
    @RequestMapping(value = "getTodoCommentList")
    public Object getTodoCommentList(){
        Map<String, Object> map = new HashMap<>();
        List<BlogComment> todoCommentList = blogCommentService.getTodoCommentList();
        if (todoCommentList != null && !todoCommentList.isEmpty()) {
            map.put("rows", todoCommentList);
            map.put("total", todoCommentList.size());
        }
        return map;
    }

    /**
     * 首页获取未读留言 list
     * @return
     */
    @RequestMapping(value = "getTodoMessageList")
    public Object getTodoMessageList(){
        Map<String, Object> map = new HashMap<>();
        List<BlogLeaveMessage> todoMessageList = blogLeaveMessageService.getTodoMessageList();
        if (todoMessageList != null && !todoMessageList.isEmpty()) {
            map.put("rows",todoMessageList);
            map.put("total",todoMessageList.size());
        }
        return map;
    }
    /**
     * 首页 获取总数
     * @return
     */
    @RequestMapping(value = "getDashboardDetails")
    public Object getDashboardDetails(){
        DashboardDetailsDTO dashboardDetailsDTO = new DashboardDetailsDTO();
        Map<String, Object> map = new HashMap<>();
        //  获取评论总数
        Integer totalComment = blogCommentService.getTotalComment();
        //  获取未读评论数
        Integer readTotalComment = blogCommentService.getTodoCommentList().size();
        //  获取留言总数
        Integer totalMessage = blogLeaveMessageService.getTotalMessage();
        // 获取未读留言数
        Integer readTotalMessage = blogLeaveMessageService.getTodoMessageList().size();

        dashboardDetailsDTO.setTotalComment(totalComment);
        dashboardDetailsDTO.setReadTotalComment(readTotalComment);
        dashboardDetailsDTO.setTotalMessage(totalMessage);
        dashboardDetailsDTO.setReadTotalMessage(readTotalMessage);
            map.put("rows",dashboardDetailsDTO);
            map.put("total",1);
        return map;
    }


    /**
     * 首页 获取半年的 包含本月 图表数据
     * @return
     */
    @RequestMapping(value = "getChartData")
    public Object getChartData(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat yearMonthFormat = new SimpleDateFormat("yyyy-MM");
        Date date = new Date();
        Map<String, Object> map = new HashMap();
        //  获取半年数据
        List<ChartDataDTO> list = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            ChartDataDTO chartDataDTO = new ChartDataDTO();
            Calendar calStar = Calendar.getInstance();
            calStar.setTime(date);
            calStar.add(Calendar.MONTH, -i);
            // 当前月的第一天
            calStar.set(Calendar.DAY_OF_MONTH,1);
            calStar.set(Calendar.HOUR_OF_DAY,0);
            calStar.set(Calendar.MINUTE,0);
            calStar.set(Calendar.SECOND,0);
            Date dateStar = calStar.getTime();
            String startTime = sdf.format(dateStar);

            Calendar calEnd = Calendar.getInstance();
            calEnd.setTime(dateStar);
//            calEnd.add(Calendar.MONTH, -i);
            // 当前月的最后一天
//            calEnd.set(Calendar.DAY_OF_MONTH,0);
            // 07-31 但是要获取 08-01 00:00:00
            calEnd.add(Calendar.MONTH,1);
            calEnd.set(Calendar.HOUR_OF_DAY,0);
            calEnd.set(Calendar.MINUTE,0);
            calEnd.set(Calendar.SECOND,0);
            Date dateEnd = calEnd.getTime();
            String endTime = sdf.format(dateEnd);

            //通过 月初 月尾 查询该月的评论数或者留言数  startTime<=  createTime < endTime
            int totalComment = blogCommentService.getTotalByMonth(startTime, endTime);
            int totalMessage = blogLeaveMessageService.getTotalByMonth(startTime, endTime);
            String myTime = yearMonthFormat.format(dateStar);
            chartDataDTO.setDate(myTime);
            chartDataDTO.setCommentTotal(totalComment);
            chartDataDTO.setMessageTotal(totalMessage);
            list.add(chartDataDTO);
        }
        Collections.reverse(list);
        map.put("result",list);
        return map;
    }
}
