package com.edu.controller;

import com.edu.po.Course;
import com.edu.po.SC;
import com.edu.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    //  个人成绩查询
    @RequestMapping("/selectSCBySno")
    public String selectSCBySno(Model model, Integer sNo) {
        List<SC> scList = studentService.getSCListBySno(sNo);
        model.addAttribute("scList", scList);
        return "/pages/student/score_single";
    }

    //    精确成绩查询
    @RequestMapping("/selectSCBySnoAndCno")
    public String selectSCBySnoAndCno(Model model, Integer sNo, Integer cNo) {
        SC sc = studentService.getSCBySnoAndCno(sNo, cNo);
        if (sc != null) {
            ArrayList<SC> scList = new ArrayList<>();
            scList.add(sc);
            model.addAttribute("scList", scList);
        }
        return "/pages/student/score_accuracy";
    }

    //    修改密码
    @RequestMapping("/modifyPwd")
    public String modifyPwd(Integer sNo, String newPassword, HttpServletRequest request) {
        int i = studentService.studentModifyPassword(sNo, newPassword);
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

    //    查询已选课列表
    @RequestMapping("/selectCourseList")
    public String selectCourseList(Integer sNo, Model model) {
        List<Course> courseList = studentService.getSelectCourseList(sNo);
        model.addAttribute("courseList", courseList);
        return "/pages/student/select_course_list";
    }

    //    获取已选课程和未选课程
    @RequestMapping("/getSelectedAndNotSelectedCourse")
    public String getSelectedAndNotSelectedCourse(Integer sNo, Model model) {
        List<Course> selected = studentService.getSelectCourseList(sNo);
        List<Course> notSelected = studentService.getNotSelectCourseList(sNo);
        model.addAttribute("selected", selected);
        model.addAttribute("notSelected", notSelected);
        return "/pages/student/select_course";
    }

    //    添加选课信息(处理选课操作)
    @RequestMapping("/selectCourse")
    public ModelAndView selectCourse(Integer sNo, Integer cNo, ModelAndView modelAndView) {
        int i = studentService.selectCourse(sNo, cNo);
        List<Course> selected = studentService.getSelectCourseList(sNo);
        List<Course> notSelected = studentService.getNotSelectCourseList(sNo);
        modelAndView.addObject("selected", selected);
        modelAndView.addObject("notSelected", notSelected);
        if (i > 0) {
            modelAndView.addObject("selectCourseMsg", "选课成功！");
            modelAndView.setViewName("/pages/student/select_course");
        } else {
            modelAndView.addObject("selectCourseMsg", "选课失败！");
            modelAndView.setViewName("/pages/student/select_course");
        }
        return modelAndView;
    }

    //    处理退课操作
    @RequestMapping("/deleteSelectCourse")
    public ModelAndView deleteSelectCourse(Integer sNo,Integer cNo,ModelAndView modelAndView){
        int i = studentService.deleteSelectCourse(sNo, cNo);
        List<Course> selected = studentService.getSelectCourseList(sNo);
        List<Course> notSelected = studentService.getNotSelectCourseList(sNo);
        modelAndView.addObject("selected", selected);
        modelAndView.addObject("notSelected", notSelected);
        if (i > 0) {
            modelAndView.addObject("selectCourseMsg", "退课成功！");
            modelAndView.setViewName("/pages/student/select_course");
        } else {
            modelAndView.addObject("selectCourseMsg", "退课失败！");
            modelAndView.setViewName("/pages/student/select_course");
        }
        return modelAndView;
    }

}
