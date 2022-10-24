package com.example.back_study;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

// 맵핑 : www.~/html/ 어떻게 서버를 열어줄거냐
@WebServlet(name = "helloServlet", value = "/hello-servlet")
//localhost8080//hello-servlet

//웹 만들기 위해 상속 받음
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    //갭 맵핑 : 메인페이지 글 작성 > 다음 페이지 넘어갈 때 (처음경로)
    //포스트 맵핑 : 결과값 처리해서 다음 페이지로 넘어갈 때 (차이점 구글링 하기)
    //request받아주기, response 결과값 보내기
    //throws 예외처리 오류면 IOException 실행
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello
        //PrintWriter 백엔드에서 페이지 보내주고 싶을 때
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}