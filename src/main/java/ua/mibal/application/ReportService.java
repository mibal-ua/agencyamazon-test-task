package ua.mibal.application;

import org.springframework.stereotype.Service;
import ua.mibal.domain.SalesAndTrafficByAsin;
import ua.mibal.domain.SalesAndTrafficByDate;

import java.time.LocalDate;
import java.util.List;

/**
 * @author Mykhailo Balakhon
 * @link <a href="mailto:9mohapx9@gmail.com">9mohapx9@gmail.com</a>
 */
@Service
public class ReportService {

    // TODO
    public List<SalesAndTrafficByDate> findByDate(LocalDate start, LocalDate end) {
        return null;
    }


    public List<SalesAndTrafficByAsin> findByAsins(List<String> asins) {
        return null;
    }
}
