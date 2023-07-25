package duplicatecode.example;

import duplicatecode.components.MyPojo;
import duplicatecode.components.MyRepository;
import duplicatecode.components.MyService1;
import duplicatecode.components.MyService2;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DuplicateCode {

    private final MyService1 myService1;
    private final MyService2 myService2;

    private final MyRepository myRepository;

    public DuplicateCode(MyService1 myService1, MyService2 myService2, MyRepository myRepository) {
        this.myService1 = myService1;
        this.myService2 = myService2;
        this.myRepository = myRepository;
    }

    public void duplicateCode1() {
        if (!myRepository.findAll().isEmpty()) {
            myRepository.findAll().forEach(System.out::println);
        }
    }

    public void duplicateCode2(MyPojo pojo) {
        if (pojo.getField1() != null && "X".equals(pojo.getField1())) {
            //some random action
        }
    }

    public void uselessCode1(MyPojo pojo) {
        Optional<String> strOptional = pojo.getField2();
        if (strOptional.isPresent()) {
            //some random actions
        }

        /*
        Chain the optional
         */
        pojo.getField2().ifPresent(str -> {/* some random action*/});
    }

    public MyPojo uselessCallsCode2(MyPojo pojo) {
        String str1 = myService1.method1();
        String str2 = myService2.method2();

        //some more logic

        if (pojo.getField1() == null) {
            throw new RuntimeException("Cannot be null.");
        }

        //some more logic

        MyPojo result = new MyPojo();
        result.setField(1);
        result.setField1(str1);
        result.setField2(Optional.ofNullable(str2));
        return result;
    }

    public MyPojo guardClause(MyPojo pojo) {
        if (pojo.getField1() == null) {
            throw new RuntimeException("Cannot be null.");
        }

        MyPojo result = new MyPojo();
        result.setField(1);
        result.setField1(myService1.method1());
        result.setField2(Optional.ofNullable(myService2.method2()));

        return result;
    }
}
