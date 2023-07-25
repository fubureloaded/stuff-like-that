package beans.statelessbean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class StatelessBeanServiceOld {

    @Value("${feature.isActive:false}")
    private boolean isActive;

    public String dummyMethod(StatelessBeanDto input) {
        var result = "";

        if (isActive) {
            result += "X";
        } else {
            result += "Y";
        }

        //some other calculation

        if (isActive) {
            result += "X";
        } else {
            result += "Y";
        }

        return result;
    }
}
