package ua.mibal.application.component;

import com.nimbusds.jose.shaded.gson.Gson;
import org.springframework.stereotype.Component;
import ua.mibal.domain.Report;

/**
 * @author Mykhailo Balakhon
 * @link <a href="mailto:9mohapx9@gmail.com">9mohapx9@gmail.com</a>
 */
@Component
public class MongoReportConverter {

    public Report convert(String json) {
        return new Gson().fromJson(json, Report.class);
    }
}
