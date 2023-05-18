package com.fincity.interviewQuestions;

import java.util.ArrayList;
import java.util.List;

public class GrootPie {
    public static List<List<Integer>> findPies(int[] pies, int desiredSweetness) {
        int pieCount = pies.length;
        List<List<Integer>> result = new ArrayList<>();

        for (int r = 1; r <= pieCount; r++) {
            combinations(pies, pieCount, r, desiredSweetness, new ArrayList<>(), result);
        }

        return result;
    }

    private static void combinations(int[] pies, int pieCount, int r, int desiredSweetness,
                                     List<Integer> combination, List<List<Integer>> result) {
        if (combination.size() == r) {
            int sum = 0;
            for (int index : combination) {
                sum += pies[index];
            }
            if (sum == desiredSweetness) {
                result.add(new ArrayList<>(combination));
            }
            return;
        }

        int lastIndex = combination.isEmpty() ? -1 : combination.get(combination.size() - 1);
        for (int i = lastIndex + 1; i < pieCount; i++) {
            combination.add(i);
            combinations(pies, pieCount, r, desiredSweetness, combination, result);
            combination.remove(combination.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] pies = {1, 2, 3, 2, 1};
        int desiredSweetness = 6;
        List<List<Integer>> pieCombinations = findPies(pies, desiredSweetness);
        System.out.println(pieCombinations);
    }
}

