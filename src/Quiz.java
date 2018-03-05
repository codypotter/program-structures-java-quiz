import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Quiz {

    ArrayList<Question> questions;
    String filename;
    boolean filenameIsValid;

    Quiz(String dataFile) throws Exception {
        this.questions = new ArrayList<Question>();
        filenameIsValid = checkFileName(dataFile);
        this.filename = dataFile;
        this.loadQuestions(this.filename);
    }

    public boolean loadQuestions(String dataFile) throws Exception {
        ArrayList<String> lines;

        if (filenameIsValid) {
            lines = this.openFile(filename);
        } else {
            filenameIsValid = false;
            Exception e = new Exception("Given filename for quiz is invalid. Exiting...");
            throw e;
        }

        questions = parseQuestionsFrom(lines);

        return true;
    }

    public int totalQuestions() {
        return this.questions.size();
    }

    public void deliverQuiz() {
        Scanner reader = new Scanner(System.in);
        for (int i = 0; i < questions.size(); i++) {
            questions.get(i).showQuestion();
            String userAnswer = reader.nextLine();
            System.out.println(userAnswer);
        }
    }

    public int getCorrectCount() {
        return 0;
    }

    public int getIncorrectCount() {
        return 0;
    }

    private boolean checkFileName(String dataFilename) {
        if (dataFilename == "" || !dataFilename.endsWith(".txt")) {
            return false;
        } else {
            return true;
        }
    }

    private ArrayList<Question> parseQuestionsFrom(ArrayList<String> questionLines) throws Exception {
        ArrayList<Question> tempQuestions = new ArrayList<Question>();

        for (int i = 0; i < questionLines.size(); i++) {

            if (questionLines.get(i).startsWith("#") || questionLines.get(i).startsWith("//") || questionLines.get(i).trim().length() == 0) {
                continue;
            }
            String questionType;
            String level;
            String questionText;
            String answerText;
            String multipleChoices;
            String[] tokens = questionLines.get(i).split("\\|");

            questionType = tokens[0];
            level = tokens[1];
            questionText = tokens[2];
            if (questionType.equals("MC")) {
                multipleChoices = tokens[3];
                answerText = tokens[4];
            } else {
                multipleChoices = "";
                answerText = tokens[3];
            }

            if (questionType.equals("MC")) {
                Question tempQuestionMC = new QuestionMC(answerText, questionText, multipleChoices);
                tempQuestions.add(tempQuestionMC);
            } else if (questionType.equals("SA")) {
                Question tempQuestionSA = new QuestionSA(answerText, questionText);
                tempQuestions.add(tempQuestionSA);
            } else if (questionType.equals("TF")) {
                Question tempQuestionTF = new QuestionTF(answerText, questionText);
                tempQuestions.add(tempQuestionTF);
            } else {
                System.out.println("Question type is unrecognized");
                continue;
            }
        }
        return tempQuestions;
    }

    public ArrayList<String> openFile(String dataFilename) throws FileNotFoundException {
        ArrayList<String> textData = new ArrayList<String>();
        try {
            File file = new File(dataFilename);
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                textData.add(scanner.nextLine());
            }

            scanner.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return textData;
    }
}
