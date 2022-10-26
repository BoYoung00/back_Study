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
        boardDao dao=new boardDao();
        boardDto dto=dao.getDto("타이틀입니다1");
        System.out.println(dto);
    }
    public static void adddata(String head, String body){
        String title=head;
        String content=body;

        boardDto dto = new boardDto(title, content);

        boardDao dao=new boardDao();
        int insertCount=dao.addUser(dto);

        System.out.println(insertCount);
    }
}
