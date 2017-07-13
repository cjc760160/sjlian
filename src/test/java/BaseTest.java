import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by lian on 17/7/12.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:spring/spring.xml", "classpath:spring/spring-mvc.xml","classpath:spring/spring-mybatis.xml"})
public class BaseTest {

}
