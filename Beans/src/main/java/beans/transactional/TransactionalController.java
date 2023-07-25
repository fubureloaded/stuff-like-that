package beans.transactional;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransactionalController {

    private final TransactionalService transactionalService;

    public TransactionalController(TransactionalService transactionalService) {
        this.transactionalService = transactionalService;
    }

    @PostMapping("transactional")
    public String save(@RequestBody RequestDto input) {
        return transactionalService.save(input);
    }

    @PostMapping("not-transactional")
    public String save2(@RequestBody RequestDto input) {
        return transactionalService.save2(input);
    }
}
