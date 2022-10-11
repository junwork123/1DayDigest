package com.oneday.digest.algorithm;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.Queue;

@Slf4j
@Service
public class CalculationService {
    public String[] calculate(String[] input) {
        solution(0,0);
        return input;
    }

    public int solution(int n, int k) {
        int answer = -1;

        //bfs
        Queue<Integer> q = new LinkedList<>();
        q.offer(n);
        int cnt = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                int x = q.poll();
                if(x == k) {
                    answer = cnt;
                    return answer;
                }
                if(x > k) {
                    continue;
                }
                q.offer(x + 1);
                q.offer(x - 1);
                q.offer(x * 2);
            }
            cnt++;
        }

        return answer;
    }

    public int[] solution(int[] fees, String[] records) {
        int[] answer = {};
        return answer;
    }

    public int[] solution(int n, int[] info) {
        int[] answer = {};
        return answer;
    }
}
