package com.edu.controller;

import com.edu.po.*;
import com.edu.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    //修改密码
    @RequestMapping("/modifyPwd")
    public String modifyPwd(Integer uid, String newPassword, HttpServletRequest request) {
        int i = adminService.modifyPwd(uid, newPassword);
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

    //查询所有学生信息
    @RequestMapping("/selectAllStu")
    public ModelAndView selectAllStu(ModelAndView modelAndView) {
        List<Student> stuList = adminService.selectAllStu();
        modelAndView.addObject("stuList", stuList);
        modelAndView.setViewName("/pages/admin/select_all_students");
        return modelAndView;
    }

    //按学号查询学生信息
    @RequestMapping("/selectStuBySno")
    public ModelAndView selectStuBySno(ModelAndView modelAndView, Integer sNo) {
        Student student = adminService.selectStuBySno(sNo);
        if (student != null) {
            ArrayList<Student> stuList = new ArrayList<>();
            stuList.add(student);
            modelAndView.addObject("stuList", stuList);
        }
        modelAndView.setViewName("/pages/admin/select_student_sno");
        return modelAndView;
    }

    //添加学生信息
    @RequestMapping("/addStu")
    public ModelAndView addStu(ModelAndView modelAndView, Student student) {
        int i = adminService.addStu(student);
        if (i > 0) {
            modelAndView.addObject("addStuMsg", "添加学生成功！");
            Student student1 = adminService.selectStuBySno(student.getsNo());
            if (student1 != null) {
                ArrayList<Student> stuList = new ArrayList<>();
                stuList.add(student1);
                modelAndView.addObject("stuList", stuList);
            }
        } else {
            modelAndView.addObject("addStuMsg", "添加学生失败！");
        }
        modelAndView.setViewName("/pages/admin/select_student_sno");
        return modelAndView;
    }

    //修改学生表单数据回显
    @RequestMapping("/updateStuForm")
    public ModelAndView updateStuForm(ModelAndView modelAndView, Integer sNo) {
        Student student = adminService.selectStuBySno(sNo);
        modelAndView.addObject("student", student);
        modelAndView.setViewName("/pages/admin/update_student");
        return modelAndView;
    }


    //修改学生信息
    @RequestMapping("/updateStu")
    public ModelAndView updateStu(ModelAndView modelAndView, Student student) {
        int i = adminService.updateStu(student);
        if (i > 0) {
            modelAndView.addObject("addStuMsg", "修改学生成功！");
        } else {
            modelAndView.addObject("addStuMsg", "修改学生失败！");
        }
        Student student1 = adminService.selectStuBySno(student.getsNo());
        if (student1 != null) {
            ArrayList<Student> stuList = new ArrayList<>();
            stuList.add(student1);
            modelAndView.addObject("stuList", stuList);
        }
        modelAndView.setViewName("/pages/admin/select_student_sno");
        return modelAndView;
    }

    //删除学生信息
    @RequestMapping("/deleteStu")
    public ModelAndView deleteStu(ModelAndView modelAndView, Integer sNo) {
        int i = adminService.deleteStuById(sNo);
        if (i > 0) {
            modelAndView.addObject("delStuMsg", "删除学生成功！");
        } else {
            modelAndView.addObject("delStuMsg", "删除学生失败或不存在该学生！");
        }
        List<Student> stuList = adminService.selectAllStu();
        modelAndView.addObject("stuList", stuList);
        modelAndView.setViewName("/pages/admin/select_all_students");
        return modelAndView;
    }

    //按学号查询学生成绩
    @RequestMapping("/selectSCBySno")
    public ModelAndView selectSCBySno(ModelAndView modelAndView, Integer sNo) {
        List<SC> scList = adminService.selectSCBySno(sNo);
        modelAndView.addObject("scList", scList);
        modelAndView.setViewName("/pages/admin/score_sno");
        return modelAndView;
    }

    //按课程号查询学生成绩
    @RequestMapping("/selectSCByCno")
    public ModelAndView selectSCByCno(ModelAndView modelAndView, Integer cNo) {
        List<SC> scList = adminService.selectSCByCno(cNo);
        modelAndView.addObject("scList", scList);
        modelAndView.setViewName("/pages/admin/score_cno");
        return modelAndView;
    }

    //修改学生成绩
    @RequestMapping("/updateScore")
    public ModelAndView updateScore(ModelAndView modelAndView, Integer sNo, Integer cNo, Integer newScore, String source) {
        int i = adminService.updateScore(sNo, cNo, newScore);
        if (i > 0) {
            modelAndView.addObject("scoreMsg", "修改成绩成功！");
        } else {
            modelAndView.addObject("scoreMsg", "修改成绩失败！");
        }
        if (source.equals("sNo")) {
            List<SC> scList = adminService.selectSCBySno(sNo);
            modelAndView.addObject("scList", scList);
            modelAndView.setViewName("/pages/admin/score_sno");
        } else if (source.equals("cNo")) {
            List<SC> scList = adminService.selectSCByCno(cNo);
            modelAndView.addObject("scList", scList);
            modelAndView.setViewName("/pages/admin/score_cno");
        }
        return modelAndView;
    }

    //查询所有教师信息
    @RequestMapping("/selectAllTeachers")
    public ModelAndView selectAllTeachers(ModelAndView modelAndView) {
        List<Teacher> teacherList = adminService.selectAllTeachers();
        modelAndView.addObject("teacherList", teacherList);
        modelAndView.setViewName("/pages/admin/select_all_teachers");
        return modelAndView;
    }

    //通过教师编号查询教师信息
    @RequestMapping("/selectTeacherById")
    public String selectTeacherById(Model model, Integer tNo) {
        Teacher teacher = adminService.selectTeacherById(tNo);
        model.addAttribute("teacher", teacher);
        return "/pages/admin/select_teacher_tno";
    }

    //添加教师信息
    @RequestMapping("/addTeacher")
    public String addTeacher(Model model, Teacher teacher) {
        int i = adminService.addTeacher(teacher);
        if (i > 0) {
            model.addAttribute("updateTeacherMsg", "添加教师成功！");
            model.addAttribute("teacher", adminService.selectTeacherById(teacher.gettNo()));
        } else {
            model.addAttribute("updateTeacherMsg", "添加教师失败！");
        }
        return "/pages/admin/select_teacher_tno";
    }

    //修改教师信息表单数据回显
    @RequestMapping("/updateTeacherForm")
    public String updateTeacherForm(Model model, Integer tNo) {
        Teacher teacher = adminService.selectTeacherById(tNo);
        model.addAttribute("teacher", teacher);
        return "/pages/admin/update_teacher";
    }


    //修改教师信息
    @RequestMapping("/updateTeacher")
    public String updateTeacher(Model model, Teacher teacher) {
        int i = adminService.updateTeacher(teacher);
        if (i > 0) {
            model.addAttribute("updateTeacherMsg", "修改教师信息成功！");
        } else {
            model.addAttribute("updateTeacherMsg", "修改教师信息失败！");
        }
        model.addAttribute("teacher", adminService.selectTeacherById(teacher.gettNo()));
        return "/pages/admin/select_teacher_tno";
    }

    //删除教师信息
    @RequestMapping("/deleteTeacher")
    public String deleteTeacher(Model model, Integer tNo) {
        int i = adminService.deleteTeacher(tNo);
        if (i > 0) {
            model.addAttribute("delTeacherMsg", "删除教师成功！");
        } else {
            model.addAttribute("delTeacherMsg", "删除教师失败或教师不存在！");
        }
        List<Teacher> teacherList = adminService.selectAllTeachers();
        model.addAttribute("teacherList", teacherList);
        return "/pages/admin/select_all_teachers";
    }

    //查询所有管理员信息
    @RequestMapping("/selectAllUsers")
    public String selectAllUsers(Model model) {
        model.addAttribute("userList", adminService.selectAllUsers());
        return "/pages/admin/select_all_users";
    }

    //按uid查询管理员信息
    @RequestMapping("/selectUserById")
    public String selectUserById(Model model, Integer uid) {
        model.addAttribute("user", adminService.selectUserById(uid));
        return "/pages/admin/select_user_uid";
    }

    //检测用户名是否可用（ajax）
    @RequestMapping("/checkUsername")
    @ResponseBody
    public boolean checkUsername(String username, Integer uid) {
        User user = adminService.selectUserByUsername(username);
        if (user == null) {
            return true;
        }
        if (user != null && user.getUid() == uid) {
            return true;
        }
        return false;
    }

    //添加管理员信息
    @RequestMapping("/addUser")
    public String addUser(Model model, User user) {
        int i = adminService.addUser(user);
        System.out.println(user);
        if (i > 0) {
            model.addAttribute("updateUserMsg", "添加管理员成功！");
        } else {
            model.addAttribute("updateUserMsg", "添加管理员失败！");
        }
        model.addAttribute("user", adminService.selectUserById(user.getUid()));
        return "/pages/admin/select_user_uid";
    }

    //修改管理员信息表单数据回显
    @RequestMapping("/updateUserForm")
    public String updateUserForm(Model model, Integer uid) {
        User user = adminService.selectUserById(uid);
        model.addAttribute("user", user);
        return "/pages/admin/update_user";
    }

    //修改管理员信息
    @RequestMapping("/updateUser")
    public String updateUser(Model model, User user) {
        int i = adminService.updateUser(user);
        if (i > 0) {
            model.addAttribute("updateUserMsg", "修改管理员信息成功！");
        } else {
            model.addAttribute("updateUserMsg", "修改管理员信息失败！");
        }
        model.addAttribute("user", adminService.selectUserById(user.getUid()));
        return "/pages/admin/select_user_uid";
    }

    //删除管理员信息
    @RequestMapping("/deleteUser")
    public String deleteUser(Model model, Integer uid) {
        if (uid == 1) {
            model.addAttribute("delUserMsg","不能删除超级管理员自己！");
            model.addAttribute("userList",adminService.selectAllUsers());
            return "/pages/admin/select_all_users";
        }
        int i = adminService.deleteUser(uid);
        if (i > 0) {
            model.addAttribute("delUserMsg","删除管理员成功！");
        }else {
            model.addAttribute("delUserMsg","删除管理员失败或管理员不存在！");
        }
        model.addAttribute("userList",adminService.selectAllUsers());
        return "/pages/admin/select_all_users";
    }

    @RequestMapping("/tt")
    @ResponseBody
    public User tt(Integer uid){
        System.out.println("uid="+uid);
        User user = adminService.selectUserById(uid);
        System.out.println(user);
        return user;
    }

    @RequestMapping("/ss")
    @ResponseBody
    public Student ss(Integer sNo){
        System.out.println("sNo="+sNo);
        Student student = adminService.selectStuBySno(sNo);
        System.out.println(student);
        return student;
    }

    @RequestMapping("/cc")
    @ResponseBody
    public List<SC> cc(Integer sNo){
        System.out.println("sNo="+sNo);
        List<SC> scs = adminService.selectSCBySno(sNo);
        for (SC sc : scs) {
            System.out.println(sc);
        }
        return scs;
    }

}
