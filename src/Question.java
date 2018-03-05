import java.io.IOException;

/**
 * The Quiz program implements an application that
 * quizzes the user with a given data file.
 *
 * This is the base class for all quiz questions. It stores
 * all data related to questions including the question number,
 * question, and correct answer.
 *
 * @author  Cody Potter
 * @version 1.0
 * @since   2018-03-04
 */
public abstract class Question {

    String text;
    String answer;
    boolean correct;
    int number;

    public abstract void showQuestion();

    /*-----------------------------------------------------------------------------*/

    /**
     * This is the default constructor for the Question class.
     */
    public Question() {
        text = "";
        answer = "";
        correct = false;
        number = 0;
    }

    /*-----------------------------------------------------------------------------*/
    /**
     * This method is a setter for correct.
     */
    public void markCorrect() {
        correct = true;
    }

    /*-----------------------------------------------------------------------------*/
    /**
     * This method is a getter for correct.
     * @return correct.
     */
    public boolean isCorrect() {
        return correct;
    }

    /*-----------------------------------------------------------------------------*/
    /**
     * This method compares the user answer to the answer from the given data
     * file.
     * @param userAnswer The input string the user entered.
     * @return True if answer is correct, false otherwise.
     */
    public boolean checkAnswer(String userAnswer) {
        String formattedText = userAnswer.toLowerCase();
        String formattedAnswer = answer.toLowerCase();

        if (formattedText.equals("true") || formattedText.equals("t")) {
            formattedText = "true";
        } else if (formattedText.equals("false") || formattedText.equals("f")) {
            formattedText = "false";
        }

        if (formattedText.equals(formattedAnswer)) {
            return true;
        } else {
            return false;
        }
    }
}
