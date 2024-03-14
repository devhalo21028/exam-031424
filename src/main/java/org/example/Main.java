package org.example;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        var sampleA = new int[]{9, 3, 9, 3, 9, 7, 9};
        var sampleB = new int[]{1, 2, 9, 2, 1};

        System.out.println("unpaired a: " + solution.solution(sampleA));
        System.out.println("unpaired b: " + solution.solution(sampleB));
    }

    static class Solution {
        public int solution(int[] A) {
            var counterMap = new HashMap<Integer, Integer>();

            for(var num: A) {
                counterMap.merge(num, 1, Integer::sum);
            }

            var unpaired = -1;

            for(var counter: counterMap.entrySet()) {
                if(counter.getValue() == 1) {
                    unpaired = counter.getKey();
                    break;
                }
            }

            return unpaired;
        }
    }
}