package com.oneday.digest.baekjoon;

import com.oneday.digest.entity.problemInput.ProblemInput;
import com.oneday.digest.entity.web.ProblemRequest;
import com.oneday.digest.entity.web.ProblemResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

@RestController
@RequestMapping("/baekjoon")
public class BaekjoonController {
    @Autowired
    BaekjoonService baekjoonService;

    @GetMapping("/{id}")
    public ResponseEntity<String> problem(@PathVariable("id") String id)
            throws InvocationTargetException, IllegalAccessException {
        Method[] declaredMethods = baekjoonService.getClass().getDeclaredMethods();
        Object result = Arrays.stream(declaredMethods).filter(method -> method.getName().equals("solve_" + id))
                                                        .findFirst().get()
                                                        .invoke(baekjoonService);
        return ResponseEntity.ok(result.toString());
    }

    @PostMapping("/{id}")
    public ResponseEntity<String[]> problem(@PathVariable("id") String id, @RequestBody ProblemRequest request)
            throws InvocationTargetException, IllegalAccessException {
        String[] result = baekjoonService.solve(request);
        return ResponseEntity.status(HttpStatus.OK)
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(result);
    }

}
