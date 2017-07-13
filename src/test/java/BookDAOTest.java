import com.alibaba.fastjson.JSON;
import com.spring.sjlian.dao.BookDAO;
import com.spring.sjlian.model.Book;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by lian on 17/7/12.
 */
@SuppressWarnings(value = "unchecked")
public class BookDAOTest extends BaseTest{
    @Autowired
    private BookDAO bookDAO;

    @Test
    public void testQueryById() throws Exception {
        long bookId = 1000;
        Book book = bookDAO.queryById(bookId);
        System.out.println(JSON.toJSONString(book));
    }

}
