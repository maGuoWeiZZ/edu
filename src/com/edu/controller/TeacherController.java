package com.edu.controller;

import com.edu.po.SC;
import com.edu.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    //修改密码
    @RequestMapping("/modifyPwd")
    public String modifyPwd(Integer tNo, String newPassword, HttpServletRequest request) {
        int i = teacherService.teacherModifyPassword(tNo, newPassword);
        if (i > 0) {
            request.setAttribute("msg", "修改密码成功，请重新登录");
            request.getSession().invalidate();
            return "/pages/page/login";
        } else {
            request.setAttribute("msg", "修改密码失败！");
            request.getSession().invalidate();
            return "/pages/page/login";
        }
    }

    //    按学号查询学生所有成绩信息
    @RequestMapping("/selectScoreBySno")
    public ModelAndView selectScoreBySno(Integer sNo, String type, ModelAndView modelAndView) {
        List<SC> scList = teacherService.selectScoreBySno(sNo);
        modelAndView.addObject("scList", scList);
        if (type != null && type.equals("input")) {
            modelAndView.setViewName("/pages/teacher/inputScore_student");
        } else {
            modelAndView.setViewName("/pages/teacher/score_student");
        }
        return modelAndView;
    }

    //    查询成绩并排名
    @RequestMapping("/selectSCOrderByscore")
    public ModelAndView selectSCOrderByscore(Integer cNo, ModelAndView modelAndView) {
        List<SC> scList = teacherService.selectScoreByCnoOrderByScore(cNo);
        modelAndView.addObject("scList", scList);
        modelAndView.setViewName("/pages/teacher/score_rank");
        return modelAndView;
    }

    //    按课程号查询该门课程所学生有成绩信息
    @RequestMapping("/selectScoreByCno")
    public ModelAndView selectScoreByCno(ModelAndView modelAndView, Integer cNo, String type) {
        List<SC> scList = teacherService.selectScoreByCno(cNo);
        modelAndView.addObject("scList", scList);
        if (type != null && type.equals("input")) {
            modelAndView.setViewName("/pages/teacher/inputScore_course");
        } else {
            modelAndView.setViewName("/pages/teacher/score_course");
        }
        return modelAndView;
    }

    //    录入学生成绩
    @RequestMapping("/inputScore")
    public ModelAndView inputScore(ModelAndView modelAndView, Integer sNo, Integer cNo, Integer score, String source) {
        int i = teacherService.inputScore(sNo, cNo, score);
        if (i > 0) {
            modelAndView.addObject("inputScoreMsg", "录入成绩成功！");
            modelAndView.addObject("type", "input");
            if (source.equals("student")) {
                List<SC> scList = teacherService.selectScoreBySno(sNo);
                modelAndView.addObject("scList", scList);
                modelAndView.setViewName("/pages/teacher/inputScore_student");
            }
            if (source.equals("course")) {
                List<SC> scList = teacherService.selectScoreByCno(cNo);
                modelAndView.addObject("scList", scList);
                modelAndView.setViewName("/pages/teacher/inputScore_course");
            }
        } else {
            modelAndView.addObject("inputScoreMsg", "录入成绩失败！");
            modelAndView.setViewName("pages/teacher/inputScore_student");
        }
        return modelAndView;
    }
}

