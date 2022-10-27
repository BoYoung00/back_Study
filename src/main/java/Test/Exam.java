package Test;
import Dto.boardDto;
import Dao.boardDao;

public class Exam {
    public static void main(String[] args) {
//        String title="타이틀입니다3";
//        String content="컨텐츠입니다3";
//
//        boardDto dto = new boardDto(title, content);
//
//        boardDao dao=new boardDao();
//        int insertCount=dao.addUser(dto);
//
//        System.out.println(insertCount);


//        boardDao dao=new boardDao();
//        boardDto dto=dao.getDto("타이틀입니다1");
//        System.out.println(dto);

        String title="타이틀입니다2";
        String content="타이틀입니다 수정본";

        boardDto dto = new boardDto(title, content);
        boardDao dao = new boardDao();

        int updatecount=dao.update(dto);

        System.out.println(updatecount);

    }
    public static void adddata(String head, String body){
        String title=head;
        String content=body;

        boardDto dto = new boardDto(title, content);

        boardDao dao=new boardDao();
        int insertCount=dao.addUser(dto);

        System.out.println(insertCount);
    }

    public  static void getdata(){
        boardDao dao=new boardDao();
        boardDto dto=dao.getDto("타이틀입니다2");
        System.out.println(dto);

    }

    public  static void delete(){
        String title="타이틀입니다";

        boardDao boardDao = new boardDao();
        int deleteCount = boardDao.deleteTest(title);

        System.out.println(deleteCount);
    }
}
