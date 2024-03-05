package ua.mibal.adapter.in.web;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ua.mibal.application.ReportService;
import ua.mibal.domain.SalesAndTrafficByAsin;
import ua.mibal.domain.SalesAndTrafficByDate;

import java.time.LocalDate;
import java.util.List;

/**
 * @author Mykhailo Balakhon
 * @link <a href="mailto:9mohapx9@gmail.com">9mohapx9@gmail.com</a>
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("/report")
public class ReportController {
    private final ReportService reportService;

    @GetMapping("/dates")
    public List<SalesAndTrafficByDate> findAllByDate() {
        return reportService.findAllByDate();
    }

    @GetMapping("/dates/search")
    public List<SalesAndTrafficByDate> findByDate(@RequestParam LocalDate start,
                                                  @RequestParam(required = false) LocalDate end) {
        if (end == null) {
            end = start;
        }
        return reportService.findByDate(start, end);
    }

    @GetMapping("/asins")
    public List<SalesAndTrafficByAsin> findAllByAsins() {
        return reportService.findAllByAsins();
    }

    @GetMapping("/asins/search")
    public List<SalesAndTrafficByAsin> findByAsins(@RequestParam("asins") List<String> asins) {
        return reportService.findByAsins(asins);
    }
}
