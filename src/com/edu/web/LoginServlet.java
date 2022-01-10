//package com.edu.web;
//
//import com.edu.po.Student;
//import com.edu.po.Teacher;
//import com.edu.po.User;
//import com.edu.service.AdminService;
//import com.edu.service.Impl.AdminServiceImpl;
//import com.edu.service.Impl.StudentServiceImpl;
//import com.edu.service.Impl.TeacherServiceImpl;
//import com.edu.service.StudentService;
//import com.edu.service.TeacherService;
//import com.edu.utils.WebUtils;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//import org.springframework.web.context.WebApplicationContext;
//import org.springframework.web.context.support.WebApplicationContextUtils;
//
//import javax.servlet.ServletContext;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.lang.reflect.Method;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//
//@WebServlet(name = "loginServlet", urlPatterns = "/loginServlet")
//public class LoginServlet extends HttpServlet {
//
//    ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
//
//    private StudentService studentService = app.getBean("studentService", StudentService.class);
//    private TeacherService teacherService = app.getBean("teacherService", TeacherService.class);
//    private AdminService adminService = app.getBean("adminService", AdminService.class);
//
//
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {
//        request.setCharacterEncoding("utf-8");
//        response.setContentType("text/html;charset=utf-8");
//
//        //        通过反射判断调用哪个方法
//        String action = request.getParameter("action");
//        Class clazz = this.getClass();
//        try {
//            Method method = clazz.getDeclaredMethod(action, HttpServletRequest.class, HttpServletResponse.class);
//            method.setAccessible(true);
//            method.invoke(this, request, response);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//    }
//
//    //    登录
//    protected void login(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {
//
//        System.out.println("登录方法被调用");
//        String username = request.getParameter("username");
//        System.out.println(username);
//        String password = request.getParameter("password");
//        System.out.println(password);
//        String job = request.getParameter("job");
//        System.out.println(job);
//
////        学生登录
//        if (job.equals("student")) {
//            Student student = studentService.studentLogin(WebUtils.toInteger(username), password);
//            System.out.println("student = " + student);
//            if (student != null) { //登录成功
////                用户对象信息存入session
//                request.getSession().setAttribute("user", student);
////                设置身份为学生
//                request.getSession().setAttribute("identity", "学生");
////                登录时间
//                String loginTime = new SimpleDateFormat("YYYY年MM月dd日HH时mm分ss秒").format(new Date());
//                request.getSession().setAttribute("loginTime", loginTime);
////                登录ip
//                request.getSession().setAttribute("ip", request.getRemoteAddr());
////                重定向到学生主页
//                request.getRequestDispatcher("/pages/student/index.jsp").forward(request, response);
//            } else {
////                登录失败
//                request.setAttribute("msg", "用户名或密码错误！");
//                request.getRequestDispatcher("/pages/page/login.jsp").forward(request, response);
//            }
//        } else if (job.equals("teacher")) { //教师登录
//
//            Teacher teacher = teacherService.teacherLogin(WebUtils.toInteger(username), password);
//            if (teacher != null) {
////                登录成功
//                request.getSession().setAttribute("user", teacher);
//                request.getSession().setAttribute("identity", "教师");
//                String loginTime = new SimpleDateFormat("YYYY年MM月dd日HH时mm分ss秒").format(new Date());
//                request.getSession().setAttribute("loginTime", loginTime);
//                request.getSession().setAttribute("ip", request.getRemoteAddr());
//                request.getRequestDispatcher("/pages/teacher/index.jsp").forward(request, response);
//            } else {
////                登录失败
//                request.setAttribute("msg", "用户名或密码错误！");
//                request.getRequestDispatcher("/pages/page/login.jsp").forward(request, response);
//            }
//
//        } else if (job.equals("admin")) { //管理员登录
//            User user = adminService.adminLogin(username, password);
//            if (user != null) {
//                request.getSession().setAttribute("user",user);
//                request.getSession().setAttribute("identity", user.getUid() == 1?"超级管理员":"普通管理员");
//                String loginTime = new SimpleDateFormat("YYYY年MM月dd日HH时mm分ss秒").format(new Date());
//                request.getSession().setAttribute("loginTime", loginTime);
//                request.getSession().setAttribute("ip", request.getRemoteAddr());
//                request.getRequestDispatcher("/pages/admin/index.jsp").forward(request, response);
//            }else {
//                request.setAttribute("msg", "用户名或密码错误！");
//                request.getRequestDispatcher("/pages/page/login.jsp").forward(request, response);
//            }
//        }
//    }
//
//    //退出登录
//    protected void logout(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {
//        request.getSession().invalidate();
//        request.getRequestDispatcher("/pages/page/login.jsp").forward(request, response);
//    }
//
//
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {
//        doPost(request, response);
//    }
//}
