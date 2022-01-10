//package com.edu.web;
//
//import com.edu.po.SC;
//import com.edu.service.AdminService;
//import com.edu.service.Impl.TeacherServiceImpl;
//import com.edu.service.TeacherService;
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
//import java.util.List;
//
//@WebServlet(name = "TeacherServlet", urlPatterns = "/teacherServlet")
//public class TeacherServlet extends HttpServlet {
//
//    ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
//
//    private TeacherService teacherService = app.getBean("teacherService",TeacherService.class);
//
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
//    //    修改密码
//    protected void modifyPwd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String tNo = request.getParameter("tNo");
//        String newPassword = request.getParameter("newPassword");
//        int i = teacherService.teacherModifyPassword(WebUtils.toInteger(tNo), newPassword);
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
//    //    按学号查询学生所有成绩信息
//    protected void selectScoreBySno(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        System.out.println("按学号查询成绩");
//        String sNo = request.getParameter("sNo");
//        String type = request.getParameter("type");
//        System.out.println("type = " + type);
//        List<SC> scList = teacherService.selectScoreBySno(WebUtils.toInteger(sNo));
//        request.setAttribute("scList", scList);
//        if (type != null && type.equals("input")) {
//            request.getRequestDispatcher("/pages/teacher/inputScore_student.jsp").forward(request, response);
//        } else {
//            request.getRequestDispatcher("/pages/teacher/score_student.jsp").forward(request, response);
//        }
//    }
//
//    //    查询成绩并排名
//    protected void selectSCOrderByscore(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String cNo = request.getParameter("cNo");
//        List<SC> scList = teacherService.selectScoreByCnoOrderByScore(WebUtils.toInteger(cNo));
//        request.setAttribute("scList",scList);
//        request.getRequestDispatcher("/pages/teacher/score_rank.jsp").forward(request,response);
//    }
//
//    //    按课程号查询该门课程所学生有成绩信息
//    protected void selectScoreByCno(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        System.out.println("按课程号查询成绩");
//        String cNo = request.getParameter("cNo");
//        String type = request.getParameter("type");
//        System.out.println("type = " + type);
//        List<SC> scList = teacherService.selectScoreByCno(WebUtils.toInteger(cNo));
//        request.setAttribute("scList", scList);
//        if (type != null && type.equals("input")) {
//            request.getRequestDispatcher("/pages/teacher/inputScore_course.jsp").forward(request, response);
//        } else {
//            request.getRequestDispatcher("/pages/teacher/score_course.jsp").forward(request, response);
//        }
//    }
//
//    //    录入学生成绩
//    protected void inputScore(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        System.out.println("录入成绩");
//        Integer sNo = WebUtils.toInteger(request.getParameter("sNo"));
//        Integer cNo = WebUtils.toInteger(request.getParameter("cNo"));
//        Integer score = WebUtils.toInteger(request.getParameter("score"));
//        String source = request.getParameter("source");
//        int i = teacherService.inputScore(sNo, cNo, score);
//        if (i > 0) {
//            if (source.equals("student")) {
//                request.setAttribute("type", "input");
//                response.sendRedirect(request.getContextPath() + "/teacherServlet?action=selectScoreBySno&sNo=" + sNo);
//            }
//            if (source.equals("course")) {
//                request.setAttribute("type", "input");
//                response.sendRedirect(request.getContextPath() + "/teacherServlet?action=selectScoreByCno&cNo=" + cNo);
//            }
//        } else {
//            return;
//        }
//
//    }
//
//
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        doPost(request, response);
//    }
//}
