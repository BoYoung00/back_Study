package Dao;

public class Dao1 {
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


}
