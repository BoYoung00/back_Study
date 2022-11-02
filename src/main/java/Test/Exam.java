package Test;
import Dto.boardDto;
import Dao.boardDao;

import java.util.List;

public class Exam {
    public static void main(String[] args) {
//        String title="타이틀입니다3";
//        String content="컨텐츠입니다3";
//
//        boardDto dto = new boardDto(title, content);
//        boardDao dao=new boardDao();
//        int insertCount=dao.addUser(dto);
//
//        System.out.println(insertCount);


//        boardDao dao=new boardDao();
//        boardDto dto=dao.getDto("타이틀입니다1");
//        System.out.println(dto);

        boardDao dao = new boardDao();
        List<boardDto> list = dao.getboards();

        for (boardDto boardDto:list) {
            System.out.println(boardDto);
        }

    }
    //추가
    public static void adddata(String head, String body){
        String title=head;
        String content=body;

        boardDto dto = new boardDto(title, content);
        boardDao dao = new boardDao();

        int insertCount=dao.addUser(dto);

        System.out.println(insertCount);
    }

    //찾기
    public  static void getdata(){
        boardDao dao=new boardDao();
        boardDto dto=dao.getDto("타이틀입니다2");

        System.out.println(dto);

    }

    //삭제
    public  static void delete(){
        String title="타이틀입니다";

        //왜 삭제만 dao 부름?
        boardDao boardDao = new boardDao();
        int deleteCount = boardDao.deleteTest(title);

        System.out.println(deleteCount);
    }

    //수정
    public  static  void correct() {
        String title = "타이틀입니다2";
        String content = "타이틀입니다 수정본";

        boardDto dto = new boardDto(title, content);
        boardDao dao = new boardDao();

        int updatecount = dao.update(dto);

        System.out.println(updatecount);
    }

}
