package imperativedeclarative.optional;

import imperativedeclarative.optional.classes.ClassA;
import imperativedeclarative.optional.classes.ClassB;
import imperativedeclarative.optional.classes.ClassC;
import imperativedeclarative.optional.classes.ClassD;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@Slf4j
public class TheOptional {

    public String getData(ClassA classA) {
        if (classA != null) {
            ClassB classB = classA.getClassB();
            if (classB != null) {
                ClassC classC = classB.getClassC();
                if (classC != null) {
                    ClassD classD = classC.getClassD();
                    return classD.getData();
                }
            }
        }
        return null;
    }

    public String getDataRefactored(ClassA classA) {
        if (classA == null) {
            return null;
        }

        ClassB classB = classA.getClassB();
        if (classB == null) {
            return null;
        }

        ClassC classC = classB.getClassC();
        if (classC == null) {
            return null;
        }

        ClassD classD = classC.getClassD();
        return classD.getData();
    }

    public String getDataWithOptional(ClassA classA) {
        return Optional.ofNullable(classA)
                .map(ClassA::getClassB)
                .map(ClassB::getClassC)
                .map(ClassC::getClassD)
                .map(ClassD::getData)
                .orElse(null);
    }
    /*
        NEVER do something like:
      -  Optional.ofNullable(classA.getClassB().getClassC().getClassD().getData());
      -  Optional.ofNullable(classA.getClassB().getClassC().getClassD()).map(ClassD::getData);
    */


    public void logData(ClassA classA) {
        Optional.ofNullable(classA)
                .map(ClassA::getClassB)
                .map(ClassB::getClassC)
                .map(ClassC::getClassD)
                .map(ClassD::getData)
                //.ifPresent(log::info);
                .ifPresentOrElse(log::info, () -> log.warn("no data"));
    }
}
