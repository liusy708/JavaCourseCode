import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:beans.xml"})
public class SpringTest {

    @Resource(name = "student100")
    private Student student1;

    @Test
    public void assembleTest() {
        System.out.println(student1.getName());
        Assert.assertEquals("student100", student1.getName());
    }
 }
