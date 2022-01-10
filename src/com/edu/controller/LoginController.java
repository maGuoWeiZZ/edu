package com.edu.controller;

import com.edu.po.Student;
import com.edu.po.Teacher;
import com.edu.po.User;
import com.edu.service.AdminService;
import com.edu.service.StudentService;
import com.edu.service.TeacherService;
import com.edu.utils.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;


@Controller
public class LoginController {

    @Autowired
    private AdminService adminService;
    @Autowired
    private StudentService studentService;
    @Autowired
    private TeacherService teacherService;

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(Model model, HttpServletRequest request, String username, String password, String job) {
        String loginTime = new SimpleDateFormat("YYYY年MM月dd日HH时mm分ss秒").format(new Date());
        String ip = request.getRemoteAddr();
        if (job.equals("admin")) {
            User user = adminService.adminLogin(username, password);
            System.out.println(user);
            if (user != null) {
                HttpSession session = request.getSession();
                session.setAttribute("user", user);
                session.setAttribute("identity", user.getUid() == 1?"超级管理员":"普通管理员");
                session.setAttribute("loginTime",loginTime);
                session.setAttribute("ip",ip);
                return "/pages/admin/index";
            } else {
                model.addAttribute("msg", "账号或密码错误！");
                return "/pages/page/login";
            }
        } else if (job.equals("student")) {
            Student student = studentService.studentLogin(WebUtils.toInteger(username), password);
            if (student != null) {
                HttpSession session = request.getSession();
                session.setAttribute("user",student);
                session.setAttribute("identity","学生");
                session.setAttribute("loginTime",loginTime);
                session.setAttribute("ip",ip);
                return "/pages/student/index";
            }else{
                model.addAttribute("msg", "账号或密码错误！");
                return "/pages/page/login";
            }
        } else {
            Teacher teacher = teacherService.teacherLogin(WebUtils.toInteger(username), password);
            if (teacher != null) {
                HttpSession session = request.getSession();
                session.setAttribute("user",teacher);
                session.setAttribute("identity","教师");
                session.setAttribute("loginTime",loginTime);
                session.setAttribute("ip",ip);
                return "/pages/teacher/index";
            }else{
                model.addAttribute("msg", "账号或密码错误！");
                return "/pages/page/login";
            }
        }
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/pages/page/login.jsp";
    }
}
