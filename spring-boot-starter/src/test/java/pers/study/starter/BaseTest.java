package pers.study.starter;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * <p>
 * 官方文档:
 * https://docs.spring.io/spring-boot/docs/current/reference/html/boot-features-testing.html
 * </p>
 *
 * <p>
 * 一点小意外以及解决办法:
 * https://stackoverflow.com/questions/39084491/unable-to-find-a-springbootconfiguration-when-doing-a-jpatest
 * </p>
 *
 * @author : panxin
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
@Import(TestConfiguration.class)
public class BaseTest {

}
