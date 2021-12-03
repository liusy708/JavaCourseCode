package scannable;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class School {

    public void print() {

        System.out.println("This is a School object");

    }

}
