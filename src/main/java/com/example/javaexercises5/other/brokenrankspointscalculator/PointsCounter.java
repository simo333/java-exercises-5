package com.example.javaexercises5.other.brokenrankspointscalculator;

import java.util.List;

public class PointsCounter {

    public static int countPoints(int level) {
        int totalPoints = level - 1;
        while (level != 1) {
            totalPoints += --level;
        }
        return totalPoints;
    }

    public static void showPoints(int level) {
        int points = countPoints(level);
        int minorPoints = points;
        int masterPoints = points / (14 * 14);
        points = points - (masterPoints * 14 * 14);
        int adeptPoints = points / 14;
        int studentPoints = points % 14;

        System.out.println("Total minor points: " + minorPoints);
        System.out.printf("Student points: %d | Adept points: %d | Master points: %d", studentPoints, adeptPoints, masterPoints);
        System.out.println();
    }

    /*
     * 's' - student points, eg. 5 = 5 student points
     * 'a' - adept points, eg. 5a = 5 adept points
     * 'm' - master points, eg. 5a = 5 master points
     * */
    public static int countTotalPointsCost(List<String> skillList) {
        int totalPoints = 0;
        for (String s : skillList) {
            int skillLevel = Integer.parseInt(s.substring(0, s.length() - 1));
            if (s.contains("s")) {
                totalPoints += pointsCounter(skillLevel);
            } else if (s.contains("a")) {
                totalPoints += pointsCounter(7) + pointsCounter(skillLevel) * 14;
            } else if (s.contains("m")) {
                totalPoints += pointsCounter(7) + pointsCounter(7) * 14 + pointsCounter(skillLevel) * 14 * 14;
            }
        }
        return totalPoints;
    }

    private static int pointsCounter(int skillLevel) {
        int points = skillLevel;
        while (skillLevel > 1) {
            points += --skillLevel;
        }
        return points;
    }

}
