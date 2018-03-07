import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * The Quiz program implements an application that
 * quizzes the user with a given data file.
 *
 * The Quiz App class is the starting point for the quiz program.
 * It handles the replay-ability functionality.
 *
 * @author  Cody Potter
 * @version 1.0
 * @since   2018-03-04
 */
public class QuizApp {

    /*-----------------------------------------------------------------------------*/
    /**
     * This is the main entry point for the quiz app.
     * @param args is the command line argument. It should be the name of
     *             a data file.
     * @throws Exception File not found.
     */
    public static void main(String[] args) throws Exception {
        if (args.length != 1) {
            System.err.println("ERROR: usage - java QuizApp [datafile]");
            System.err.println("Exiting...");
            return;
        }
        try {runQuiz(args[0]);}
        catch (FileNotFoundException error){
            System.err.println("ERROR: " + error.getMessage());
        }
    }

    /*-----------------------------------------------------------------------------*/
    /**
     * This method creates the quiz object and runs it until the user quits
     * or gets all answers correct.
     * @param arg the command line argument which is the name of
     *            the data file.
     * @throws Exception Error running quiz.
     */
    private static void runQuiz(String arg) throws Exception {
        if (!arg.equals("")) {
            Quiz quiz = new Quiz(arg);
            quiz.deliverQuiz(false);

            outputScore(quiz);

            while (quiz.getIncorrectCount() != 0) {
                Scanner reader = new Scanner(System.in);
                System.out.println("Do you want to try the questions you missed again? (y/n)");
                String playAgainAnswer = reader.nextLine().toLowerCase();

                if (playAgainAnswer.equals("y") || playAgainAnswer.equals("yes")) {
                    quiz.deliverQuiz(true);
                    outputScore(quiz);
                } else {
                    System.out.println("Thanks for playing! Exiting...");
                    break;
                }
            }
        } else {
            throw new FileNotFoundException("Invalid argument. Usage: java quiz [datafile] ");
        }
    }

    private static void outputScore(Quiz quiz) {
        int correctCount = quiz.getCorrectCount();
        int totalQuestions = quiz.totalQuestions();

        System.out.println("You got " + correctCount + " out of " + totalQuestions + ". ");
    }
}
