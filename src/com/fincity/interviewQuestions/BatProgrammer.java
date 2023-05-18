package com.fincity.interviewQuestions;

public class BatProgrammer {
    public static int findNumOfStepsRequired(int numOfPatients, int startStep) {
        int[] steps = new int[numOfPatients];

        for (int i = 0; i < numOfPatients; i++) {
            steps[i] = (i + 1) * startStep;
        }

        int lcm = steps[0];
        for (int i = 1; i < numOfPatients; i++) {
            lcm = calculateLCM(lcm, steps[i]);
        }

        return lcm / startStep;
    }

    private static int calculateLCM(int a, int b) {
        int gcd = calculateGCD(a, b);
        return (a / gcd) * b;
    }

    private static int calculateGCD(int a, int b) {
        if (b == 0) {
            return a;
        }
        return calculateGCD(b, a % b);
    }

    public static void main(String[] args) {
        int numOfPatients = 10;
        int startStep = 1;
        int requiredSteps = findNumOfStepsRequired(numOfPatients, startStep);

        System.out.println("Number of steps required: " + requiredSteps);
    }
}
