package Test;
import Dto.boardDto;
import Dao.boardDao;

public class Exam {
    public static void main(String[] args) {
        String title="타이틀입니다";
        String content="컨텐츠입니다";

        boardDto dto = new boardDto(title, content);

        boardDao dao=new boardDao();
        int insertCount=dao.addUser(dto);

        System.out.println(insertCount);
    }
}
