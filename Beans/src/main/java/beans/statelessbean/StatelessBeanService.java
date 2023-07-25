package beans.statelessbean;

import org.springframework.stereotype.Service;

@Service
public class StatelessBeanService {

    private boolean isActive;

    public String dummyMethod(StatelessBeanDto input) {
        isActive = input.getIsActive();

        var result = "";

        if (isActive) {
            result += "X";
        } else {
            result += "Y";
        }

        //some other calculation
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            //silent fail for demo purpose
        }

        if (isActive) {
            result += "X";
        } else {
            result += "Y";
        }

        return result;
    }
}
