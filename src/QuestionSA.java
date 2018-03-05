/**
 * The Quiz program implements an application that
 * quizzes the user with a given data file.
 *
 * The Questions SA class overrides the Question class with
 * short answer functionality.
 *
 * @author  Cody Potter
 * @version 1.0
 * @since   2018-03-04
 */
public class QuestionSA extends Question {

    /*-----------------------------------------------------------------------------*/
    /**
     * This method constructs a short answer question.
     * @param answer the correct answer
     * @param text the question text
     * @param number the question number
     */
    public QuestionSA(String answer, String text, int number) {
        this.answer = answer;
        this.text = text;
        this.correct = false;
        this.number = number;
    }

    /*-----------------------------------------------------------------------------*/
    /**
     * This method outputs a short answer question with some special formatting.
     */
    @Override
    public void showQuestion() {
        System.out.println(number + ". " + this.text + "? (Short Answer)");
    }
}

