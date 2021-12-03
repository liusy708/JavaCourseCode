import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import scannable.School;

@Configuration
@ImportResource("classpath:beans.xml")
public class AppConfig {

    @Bean
    public Klass klass() {
        return new Klass();
    }

    @Autowired
    public School school;
}
