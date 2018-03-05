import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * The Quiz program implements an application that
 * quizzes the user with a given data file.
 *
 * The Quiz class is the quiz object that stores the list
 * of questions and supplies the user interface.
 *
 * @author  Cody Potter
 * @version 1.0
 * @since   2018-03-04
 */
public class Quiz {

    private ArrayList<Question> questions;
    private boolean filenameIsValid;

    /*-----------------------------------------------------------------------------*/
    /**
     * This method generates a quiz from a data file.
     * @param dataFile is the name of the data file.
     * @throws Exception is valid file.
     */
    Quiz(String dataFile) {
        this.questions = new ArrayList<>();
        filenameIsValid = checkFileName(dataFile);

        try {
            this.loadQuestions(dataFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*-----------------------------------------------------------------------------*/
    /**
     * This method loads the questions into the quiz from a data file.
     * @param dataFile is the name of the data file.
     * @return true of load questions is successful, false otherwise.
     * @throws Exception invalid file name
     */
    public boolean loadQuestions(String dataFile) throws Exception {
        ArrayList<String> lines;

        if (filenameIsValid) {
            lines = this.openFile(dataFile);
        } else {
            filenameIsValid = false;
            throw new Exception("Given filename for quiz is invalid. Exiting...");
        }

        questions = parseQuestionsFrom(lines);

        return true;
    }

    /*-----------------------------------------------------------------------------*/
    /**
     * This method is a getter for the number of total questions.
     * @return the number of total questions.
     */
    public int totalQuestions() {
        return this.questions.size();
    }

    /*-----------------------------------------------------------------------------*/
    /**
     * This method outputs each question and stores user answers.
     * @param playAgain true of playing only missed questions, false otherwise.
     */
    public void deliverQuiz(boolean playAgain) {
        Scanner reader = new Scanner(System.in);

        for (int i = 0; i < questions.size(); i++) {
            if (playAgain && questions.get(i).isCorrect()) {
                continue;
            }
            questions.get(i).showQuestion();
            String userAnswer = reader.nextLine();
            boolean isCorrect = questions.get(i).checkAnswer(userAnswer);
            if (isCorrect) {
                questions.get(i).markCorrect();
                System.out.println("Correct!");
            } else {
                System.out.println("Sorry, that was incorrect.");
            }
        }
    }

    /*-----------------------------------------------------------------------------*/
    /**
     * This method finds the number of correct answers.
     * @return the number of correct answers.
     */
    public int getCorrectCount() {
        int count = 0;
        for (int i = 0; i < this.totalQuestions(); i++) {
            if (this.questions.get(i).isCorrect()) {
                count++;
            }
        }
        return count;
    }

    /*-----------------------------------------------------------------------------*/
    /**
     * This method finds the number of incorrect answers.
     * @return the number of incorrect answers.
     */
    public int getIncorrectCount() {
        int correctCount = this.getCorrectCount();
        int incorrectCount = this.totalQuestions() - correctCount;
        return incorrectCount;
    }

    /*-----------------------------------------------------------------------------*/
    /**
     * This method checks if filename is valid.
     * @param dataFilename the name of the data file
     * @return true of file name is valid, false otherwise
     */
    private boolean checkFileName(String dataFilename) {
        if (dataFilename == "" || !dataFilename.endsWith(".txt")) {
            return false;
        } else {
            return true;
        }
    }

    /*-----------------------------------------------------------------------------*/
    /**
     * This method parses and creates question objects from the list of question
     * strings.
     * @param questionLines is a list of unformatted questions
     * @return a list of question objects
     */
    private ArrayList<Question> parseQuestionsFrom(ArrayList<String> questionLines) {
        ArrayList<Question> tempQuestions = new ArrayList<Question>();
        int questionNumber = 0;

        for (int i = 0; i < questionLines.size(); i++) {
            if (questionLines.get(i).startsWith("#") || questionLines.get(i).startsWith("//") || questionLines.get(i).trim().length() == 0) {
                continue;
            }
            questionNumber++;
            String questionType;
            String questionText;
            String answerText;
            String multipleChoices;
            String[] tokens = questionLines.get(i).split("\\|");

            if (tokens.length > 5) {
                System.err.println("ERROR: Bad formatting on line number: " + i);
                continue;
            }

            questionType = tokens[0];
            questionText = tokens[2];
            if (questionType.equals("MC")) {
                multipleChoices = tokens[3];
                answerText = tokens[4];
            } else {
                multipleChoices = "";
                answerText = tokens[3];
            }

            if (questionType.equals("MC")) {
                Question tempQuestionMC = new QuestionMC(answerText, questionText, multipleChoices, questionNumber);
                tempQuestions.add(tempQuestionMC);
            } else if (questionType.equals("SA")) {
                Question tempQuestionSA = new QuestionSA(answerText, questionText, questionNumber);
                tempQuestions.add(tempQuestionSA);
            } else if (questionType.equals("TF")) {
                Question tempQuestionTF = new QuestionTF(answerText, questionText, questionNumber);
                tempQuestions.add(tempQuestionTF);
            } else {
                System.err.println("ERROR: Bad formatting on line number: " + i);
                continue;
            }
        }
        return tempQuestions;
    }

    /*-----------------------------------------------------------------------------*/

    /**
     * This method opens the given file name and returns the file as a list of strings.
     * @param dataFilename the name of the data file
     * @return the list of strings from the file by line
     */
    public ArrayList<String> openFile(String dataFilename) {
        ArrayList<String> textData = new ArrayList<String>();
        try {
            File file = new File(dataFilename);
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                textData.add(scanner.nextLine());
            }

            scanner.close();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        return textData;
    }
}
