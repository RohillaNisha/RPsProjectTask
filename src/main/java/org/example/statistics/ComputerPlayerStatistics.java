package org.example.statistics;

public class ComputerPlayerStatistics {
    private int totalMatches;
    private int userMatchesWon;

    public ComputerPlayerStatistics() {
        totalMatches = 0;
        userMatchesWon = 0;
    }

    public void update(boolean userWins) {
        totalMatches++;
        if (userWins) {
            userMatchesWon++;
        }
    }

    public double getWinPercentage() {
        return (double) userMatchesWon / totalMatches * 100;
    }
}