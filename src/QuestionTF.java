/**
 * The Quiz program implements an application that
 * quizzes the user with a given data file.
 *
 * The Question TF class overrides the Quesiton class with
 * true/false functionality.
 *
 * @author  Cody Potter
 * @version 1.0
 * @since   2018-03-04
 */
public class QuestionTF extends Question {

    /*-----------------------------------------------------------------------------*/
    /**
     * This method constructs a true false question.
     * @param answer
     * @param text
     * @param number
     */
    public QuestionTF(String answer, String text, int number) {
        this.answer = answer;
        this.text = text;
        this.correct = false;
        this.number = number;
    }

    /*-----------------------------------------------------------------------------*/

    /**
     * This method outputs a true false question with some special formatting.
     */
    @Override
    public void showQuestion() {
        System.out.println(number + ". " + text + "? (True/False)");
    }
}
