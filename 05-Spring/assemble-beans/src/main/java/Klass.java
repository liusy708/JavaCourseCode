import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import scannable.School;

@Data
public class Klass {

    @Autowired
    School school;

    public void print() {
        System.out.println("this is a Klass object");
    }
}
