import java.util.ArrayList;
import java.util.Arrays;

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

    private ArrayList<String> multipleChoices = new ArrayList<>();

    /*-----------------------------------------------------------------------------*/
    /**
     * This method constructs a multiple choice question.
     * @param answer is the correct answer for the question.
     * @param text is the question text.
     * @param choices is the unformatted string of multiple choices.
     * @param number is the question number.
     */
    QuestionMC(String answer, String text, String choices, int number) {
        this.answer = answer;
        this.text = text;
        this.number = number;
        String[] choiceArray = choices.split(":");

        if (choiceArray.length <= 1) try {
            throw new Exception("There aren't enough multiple choices for question: " + this.number);
        } catch (Exception e) {
            e.printStackTrace();
        }

        multipleChoices.addAll(Arrays.asList(choiceArray));
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
        for (String multipleChoice : multipleChoices) {
            System.out.println("    " + letter + ". " + multipleChoice);
            letter++;
        }
    }

}
