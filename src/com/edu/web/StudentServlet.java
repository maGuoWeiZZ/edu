//package com.edu.web;
//
//
//import com.edu.po.Course;
//import com.edu.po.SC;
//import com.edu.service.AdminService;
//import com.edu.service.Impl.StudentServiceImpl;
//import com.edu.service.StudentService;
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
//@WebServlet(name = "StudentServlet", urlPatterns = "/studentServlet")
//public class StudentServlet extends HttpServlet {
//    ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
//
//    private StudentService studentService = app.getBean("studentService",StudentService.class);
//
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//
////        通过反射判断调用哪个方法
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
//    //  个人成绩查询
//    protected void selectSCBySno(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        System.out.println("查询个人成绩方法被调用");
//        List<SC> scList = studentService.getSCListBySno(WebUtils.toInteger(request.getParameter("sNo")));
//        request.setAttribute("scList", scList);
//        request.getRequestDispatcher("/pages/student/score_single.jsp").forward(request, response);
//    }
//
//    //    精确成绩查询
//    protected void selectSCBySnoAndCno(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        System.out.println("查询精确成绩方法被调用");
//        String sNo = request.getParameter("sNo");
//        String cNo = request.getParameter("cNo");
//        SC sc = studentService.getSCBySnoAndCno(WebUtils.toInteger(sNo), WebUtils.toInteger(cNo));
//        if (sc != null) {
//            ArrayList<SC> scList = new ArrayList<>();
//            scList.add(sc);
//            request.setAttribute("scList", scList);
//        }
//        request.getRequestDispatcher("/pages/student/score_accuracy.jsp").forward(request, response);
//
//    }
//
//    //    修改密码
//    protected void modifyPwd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String sNo = request.getParameter("sNo");
//        String newPassword = request.getParameter("newPassword");
//        int i = studentService.studentModifyPassword(WebUtils.toInteger(sNo), newPassword);
//        if (i == 1) {
//            request.setAttribute("msg", "修改密码成功，请重新登录");
//            request.getSession().invalidate();
//            request.getRequestDispatcher("/pages/page/login.jsp").forward(request, response);
//            return;
//        } else if (i == 0) {
//            return;
//        }
//    }
//
//    //    查询已选课列表
//    protected void selectCourseList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String sNo = request.getParameter("sNo");
//        List<Course> courseList = studentService.getSelectCourseList(WebUtils.toInteger(sNo));
//        request.setAttribute("courseList", courseList);
//        request.getRequestDispatcher("/pages/student/select_course_list.jsp").forward(request, response);
//    }
//
//    //    获取已选课程和未选课程
//    protected void getSelectedAndNotSelectedCourse(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        System.out.println("获取已选课程和未选课程  方法被调用");
//        String sNo = request.getParameter("sNo");
//        List<Course> selected = studentService.getSelectCourseList(WebUtils.toInteger(sNo));
//        List<Course> notSelected = studentService.getNotSelectCourseList(WebUtils.toInteger(sNo));
//        request.setAttribute("selected", selected);
//        request.setAttribute("notSelected", notSelected);
//        request.getRequestDispatcher("/pages/student/select_course.jsp").forward(request, response);
//    }
//
//    //    添加选课信息(处理选课操作)
//    protected void selectCourse(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        System.out.println("选课方法调用");
//        String sNo = request.getParameter("sNo");
//        String cNo = request.getParameter("cNo");
//        int i = studentService.selectCourse(WebUtils.toInteger(sNo), WebUtils.toInteger(cNo));
//        if (i > 0) {
////            getSelectedAndNotSelectedCourse(request, response);
//            response.sendRedirect(request.getContextPath() + "/studentServlet?action=getSelectedAndNotSelectedCourse");
//        } else {
//
//        }
//    }
//
//    //    处理退课操作
//    protected void deleteSelectCourse(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        System.out.println("退课方法调用");
//        String sNo = request.getParameter("sNo");
//        String cNo = request.getParameter("cNo");
//        int i = studentService.deleteSelectCourse(WebUtils.toInteger(sNo), WebUtils.toInteger(cNo));
//        if (i > 1) {
////            getSelectedAndNotSelectedCourse(request, response);
//            response.sendRedirect(request.getContextPath() + "/studentServlet?action=getSelectedAndNotSelectedCourse");
//
//        } else {
//
//        }
//    }
//
//
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        doPost(request, response);
//    }
//}
