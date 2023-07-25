package beans.statelessbean;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StatelessBeanController {

    private final StatelessBeanService statelessBeanService;

    public StatelessBeanController(StatelessBeanService statelessBeanService) {
        this.statelessBeanService = statelessBeanService;
    }

    @PostMapping("stateless-bean")
    public String dummyMethod(@RequestBody StatelessBeanDto input) {
        return statelessBeanService.dummyMethod(input);
    }
}
