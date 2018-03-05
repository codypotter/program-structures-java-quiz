import java.util.ArrayList;

/**
 * The Quiz program implements an application that
 * quizzes the user with a given data file.
 *
 * The Question MC class overrides the Question class with
 * multiple choice functionality.
 *
 * @author  Cody Potter
 * @version 1.0
 * @since   2018-03-04
 */
public class QuestionMC extends Question {

    private ArrayList<String> multipleChoices = new ArrayList<String>();

    /*-----------------------------------------------------------------------------*/
    /**
     * This method constructs a multiple choice question.
     * @return Nothing.
     * @param answer is the correct answer for the question.
     * @param text is the question text.
     * @param choices is the unformatted string of multiple choices.
     * @param number is the question number.
     */
    public QuestionMC(String answer, String text, String choices, int number) {
        this.answer = answer;
        this.text = text;
        this.number = number;
        String[] choiceArray = choices.split(":");

        for (int i = 0; i < choiceArray.length; i++) {
            multipleChoices.add(choiceArray[i]);
        }
        this.correct = false;
    }

    /*-----------------------------------------------------------------------------*/
    /**
     * This method outputs the question with some formatting.
     */
    @Override
    public void showQuestion() {
        char letter = 'a';
        System.out.println(number + ". " + text + "? (Multiple Choice)");
        for (int i = 0; i < multipleChoices.size(); i++) {
            System.out.println("    " + letter + ". " + multipleChoices.get(i));
            letter++;
        }
    }

}
