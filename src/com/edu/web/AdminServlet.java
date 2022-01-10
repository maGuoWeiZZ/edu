//package com.edu.web;
//
//import com.edu.po.Student;
//import com.edu.service.AdminService;
//import com.edu.service.Impl.AdminServiceImpl;
//import com.edu.utils.WebUtils;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//import org.springframework.web.context.WebApplicationContext;
//import org.springframework.web.context.support.WebApplicationContextUtils;
//
//import javax.servlet.ServletContext;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.lang.reflect.Method;
//import java.util.ArrayList;
//import java.util.List;
//
//@WebServlet(name = "AdminServlet", urlPatterns = "/adminServlet")
//public class AdminServlet extends HttpServlet {
//
//    ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
//    AdminService adminService = app.getBean("adminService", AdminService.class);
////    ServletContext servletContext = this.getServletContext();
////    WebApplicationContext app = WebApplicationContextUtils.getWebApplicationContext(servletContext);
////    AdminService adminService = app.getBean("adminService", AdminService.class);
//
//
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        request.setCharacterEncoding("utf-8");
//        response.setContentType("text/html;charset=utf-8");
//
//        //通过反射判断调用哪个方法
//        String action = request.getParameter("action");
//        Class clazz = this.getClass();
//        try {
//            Method method = clazz.getDeclaredMethod(action, HttpServletRequest.class, HttpServletResponse.class);
//            method.setAccessible(true);
//            method.invoke(this, request, response);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    //修改密码
//    protected void modifyPwd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        Integer uid = WebUtils.toInteger(request.getParameter("uid"));
//        String password = request.getParameter("newPassword");
//        int i = adminService.modifyPwd(uid, password);
//        if (i > 0) {
//            request.setAttribute("msg", "修改密码成功，请重新登录");
//            request.getSession().invalidate();
//            request.getRequestDispatcher("/pages/page/login.jsp").forward(request, response);
//            return;
//        } else if (i == 0) {
//            return;
//        }
//    }
//
//    //查询所有学生信息
//    protected void selectAllStu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        List<Student> stuList = adminService.selectAllStu();
//        request.setAttribute("stuList", stuList);
//        request.getRequestDispatcher("/pages/admin/select_all_students.jsp").forward(request, response);
//    }
//
//    //按学号查询学生信息
//    protected void selectStuBySno(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        Student student = adminService.selectStuBySno(WebUtils.toInteger(request.getParameter("sNo")));
//        if (student != null) {
//            ArrayList<Student> stuList = new ArrayList<>();
//            stuList.add(student);
//            request.setAttribute("stuList", stuList);
//        }
//        request.getRequestDispatcher("/pages/admin/select_student_sno.jsp").forward(request, response);
//    }
//
//    //添加学生信息
//    protected void addStu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String sName = request.getParameter("sName");
//        String sSex = request.getParameter("sSex");
//        Integer sAge = WebUtils.toInteger(request.getParameter("sAge"));
//        String sDept = request.getParameter("sDept");
//        String sClass = request.getParameter("sClass");
//        Student student = new Student(null, sName, sSex, sAge, sDept, sClass, "123456");
//        int i = adminService.addStu(student);
//        if (i > 0) {
////            selectAllStu(request,response);
//            response.sendRedirect(request.getContextPath() + "/adminServlet?action=selectAllStu");
//        } else {
//            return;
//        }
//    }
//
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        doPost(request, response);
//    }
//}
