package Dao;
import Dto.boardDto;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class boardDao {
    //jdbc:mysql://localhost:3306/bydbst
    //중요 dao 순서
    //1단계 import java.sql.* : sql 일단 연동
    //2단계 드라이버를 로드한다. : 본인 컴퓨터에 깔려있는 버전
    //3단계 Connection 객체 생성 : 데이터베이스 연결(url, user, password 필요)
    //4단계 Statement 객체 생성//sql문장 수행
    //SQL문에 결과물이 있다면 resultSet 생성 //결과값 가져오기
    //객체 닫아주기 (중요)

    private static String url="jdbc:mysql://localhost:3306/bydbst";
    private static String user="root";
    private static String password="rlaqhdud2@";

    //추가
    public int addUser(boardDto boardDto){
        int inserCount=0; //추가가 됐는지 확인하는 용도

        try { //sql 드라이버 로드
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        //sql문장 미리 저장해놓기
        String sql = "insert into board(title, content) values (?,?)";

        //Connection : 데이터베이스 연결, preparedStatement : sql 문장 실행 역할
        try(Connection conn = DriverManager.getConnection(url, user, password);
            PreparedStatement ps = conn.prepareStatement(sql);) {

            ps.setString(1, boardDto.getTitle());
            ps.setString(2, boardDto.getContent());

            //★★★★★★ executeUpdate : int값 반환, ExecuteQuery : 객체 값 반환, 반환 : 블리언 값 반환
            inserCount = ps.executeUpdate();
        }catch (Exception e) {
            e.printStackTrace();
        }
        return inserCount;
    }

    //찾기
    public boardDto getDto(String id) {
        //초기화
        boardDto boardDto = null; //객체 연결
        Connection conn = null; //데이터베이스 연결

        PreparedStatement ps=null; //sql문장
        ResultSet rs = null; //값으로 뭔갈 해야할 때 사용
        //ResultSet : 결과 값 저장, 행 단위 불러올 수 있음, 한 행 값 타입 지정 가능

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, password);
            String sql="select title, content from board where title=?";
            ps=conn.prepareStatement(sql);
            ps.setString(1,id);

            rs=ps.executeQuery();

            if (rs.next()){ //rs값이 있다면
                String title = rs.getString(1); //1행
                String content = rs.getString(2); //2행
                boardDto = new boardDto(title, content);
            }

        }catch (Exception e){
            e.printStackTrace();

        }finally { //무조건 한 번 실행 시키기
            if (rs != null) { //Resultset 값 없다면
                try {
                    rs.close(); //닫아라
                }catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (ps != null) { //sql문장 없다면
                try {
                    ps.close();
                }catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) { //DB 드라이버 없다면
                try {
                    conn.close();
                }catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return boardDto;
    }

    //삭제
    public int deleteTest(String title) {
        int deleteCount = 0;

        Connection conn = null;

        PreparedStatement ps = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, password);
            String sql = "delete from board where title=?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, title);
            deleteCount = ps.executeUpdate(); //int값 반환

        }catch (Exception e) {
            e.printStackTrace();
        }

        finally { //무조건 한 번 실행 시키기
            if (ps != null) {
                try {
                    ps.close();
                }catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                }catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return deleteCount;
    }

    //수정
    public int update(boardDto boardDto) {
        int updateCount=0;

        Connection conn = null;
        PreparedStatement ps = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, password);
            String sql="update board set content=? where title=?";
            ps=conn.prepareStatement(sql);

            ps.setString(1, boardDto.getContent());
            ps.setString(2, boardDto.getTitle());

            updateCount=ps.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }

        finally { //무조건 한 번 실행 시키기
            if (ps != null) {
                try {
                    ps.close();
                }catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                }catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return updateCount;
    }
}
