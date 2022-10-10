package com.oneday.digest.algorithm;

import com.oneday.digest.algorithm.ProblemSolvingService;
import com.oneday.digest.entity.web.ProblemRequest;
import com.oneday.digest.entity.web.ProblemResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

@RestController
@RequestMapping("/problem")
public class ProblemController {
    @Autowired
    ProblemSolvingService problemSolvingService;

    @PostMapping("/{id}")
    public ResponseEntity<ProblemResponse> problem(@PathVariable("id") String id, @RequestBody ProblemRequest request)
            throws InvocationTargetException, IllegalAccessException {
        List<String[]> results = problemSolvingService.solve(request);

        return ResponseEntity.status(HttpStatus.OK)
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(ProblemResponse.builder()
                                .results(results)
                                .build());
    }

}
