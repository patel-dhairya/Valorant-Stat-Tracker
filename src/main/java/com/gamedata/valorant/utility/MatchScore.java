package com.gamedata.valorant.utility;

/**
 * The MatchScore class represents the result of a match in the Valorant.
 * It stores the scores of both the user's team and the opponent's team.
 */
public class MatchScore {
    private final int userScore;       // Stores the score of the user's team.
    private final int opponentScore;   // Stores the score of the opponent's team.

    /**
     * Constructor to create a MatchScore object by parsing the input score string.
     *
     * @param inputScore The input score string in the format "score1/score2".
     * @throws IllegalArgumentException If the input score format is invalid (not in "score1/score2" format).
     */
    public MatchScore(String inputScore) throws IllegalArgumentException {
        String[] scores = inputScore.split("/");
        if (scores.length == 2) {
            try {
                userScore = Integer.parseInt(scores[0]);
                opponentScore = Integer.parseInt(scores[1]);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Invalid input format. Please use 'score1/score2' format.");
            }
        } else {
            throw new IllegalArgumentException("Invalid input format. Please use 'score1/score2' format.");
        }
    }

    /**
     * Get the score of the user's team.
     *
     * @return The score of the user's team.
     */
    public int getUserScore() {
        return userScore;
    }

    /**
     * Get the score of the opponent's team.
     *
     * @return The score of the opponent's team.
     */
    public int getOpponentScore() {
        return opponentScore;
    }
}
