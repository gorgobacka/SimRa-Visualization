package visualization.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import visualization.service.IncidentService;
import visualization.service.StatisticsService;
import visualization.web.resources.IncidentResource;
import visualization.web.resources.StatisticsResource;

import java.util.List;


/*⁄ø

This is the place where we communicate with the frontend

 */

@RestController
public class StatisticsController {

    @Autowired
    private StatisticsService statisticsService;

    // gets Statistics
    @GetMapping(value = "/statistics")
    public HttpEntity<StatisticsResource> getStatistics() {
        return ResponseEntity.ok(statisticsService.getStatistics());
    }

}
