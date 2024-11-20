import java.util.*;

public class ComputerScienceQuizGame {

        public static void main(String[] args) {
                QuizManager quizManager = new QuizManager();
                quizManager.startQuiz();
        }
}

class Question {
        String questionText;
        String[] options;
        char correctAnswer;

        public Question(String questionText, String[] options, char correctAnswer) {
                this.questionText = questionText;
                this.options = options;
                this.correctAnswer = correctAnswer;
        }

        public void displayQuestion() {
                System.out.println("\n==============================");
                System.out.println("Question: " + questionText);
                for (String option : options) {
                        System.out.println(option);
                }
                System.out.println("==============================");
        }
}

class QuizManager {

        private static final int TOTAL_QUESTIONS = 12;
        private int score = 0;
        private int consecutiveCorrectAnswers = 0;
        private Scanner scanner = new Scanner(System.in);

        private List<Question[]> questionSets = Arrays.asList(
                        new Question[] {
                                        new Question("Which of the following algorithms has the best worst-case time complexity?",
                                                        new String[] { "A) Bubble Sort", "B) Merge Sort",
                                                                        "C) Quick Sort", "D) Insertion Sort" },
                                                        'B'),
                                        new Question("What is the time complexity of accessing an element in an unsorted array?",
                                                        new String[] { "A) O(1)", "B) O(log n)", "C) O(n)",
                                                                        "D) O(n^2)" },
                                                        'C'),
                                        new Question("What does the 'Big O' notation express in terms of an algorithm's performance?",
                                                        new String[] { "A) Best-case time complexity",
                                                                        "B) Worst-case time complexity",
                                                                        "C) Average-case time complexity",
                                                                        "D) Space complexity" },
                                                        'B'),
                                        new Question(
                                                        "Which of the following data structures is most efficient for implementing a priority queue?",
                                                        new String[] { "A) Array", "B) Linked List", "C) Binary Heap",
                                                                        "D) Hash Map" },
                                                        'C'),
                                        new Question("Which of the following is NOT a feature of object-oriented programming?",
                                                        new String[] { "A) Encapsulation", "B) Abstraction",
                                                                        "C) Inheritance", "D) Compilation" },
                                                        'D'),
                                        new Question(
                                                        "In a binary search tree, what is the time complexity for searching for an element in the worst case?",
                                                        new String[] { "A) O(log n)", "B) O(n)", "C) O(n log n)",
                                                                        "D) O(1)" },
                                                        'B'),
                                        new Question("What is the time complexity of an insertion sort algorithm?",
                                                        new String[] { "A) O(n)", "B) O(n^2)", "C) O(log n)",
                                                                        "D) O(n log n)" },
                                                        'B'),
                                        new Question("Which data structure supports fast lookups and retrievals based on a key?",
                                                        new String[] { "A) Linked List", "B) Array", "C) Hash Map",
                                                                        "D) Stack" },
                                                        'C'),
                                        new Question("What is the average time complexity for searching in a balanced binary search tree?",
                                                        new String[] { "A) O(1)", "B) O(log n)", "C) O(n)",
                                                                        "D) O(n log n)" },
                                                        'B'),
                                        new Question("Which type of search algorithm is used to find an element in a sorted array?",
                                                        new String[] { "A) Linear Search", "B) Binary Search",
                                                                        "C) Hash Search", "D) Tree Search" },
                                                        'B'),
                                        new Question("What is the time complexity of accessing an element in an array?",
                                                        new String[] { "A) O(1)", "B) O(n)", "C) O(log n)",
                                                                        "D) O(n^2)" },
                                                        'A'),
                                        new Question("Which sorting algorithm is considered efficient for large datasets?",
                                                        new String[] { "A) Quick Sort", "B) Bubble Sort",
                                                                        "C) Selection Sort", "D) Merge Sort" },
                                                        'A'),
                                        new Question("Which of the following is the most efficient sorting algorithm in the average case?",
                                                        new String[] { "A) Bubble Sort", "B) Quick Sort",
                                                                        "C) Merge Sort", "D) Insertion Sort" },
                                                        'B')
                        },
                        new Question[] {
                                        new Question("Which of the following is a linear data structure?",
                                                        new String[] { "A) Array", "B) Tree", "C) Graph", "D) Queue" },
                                                        'A'),
                                        new Question("Which algorithm is used for solving shortest path problems in graphs?",
                                                        new String[] { "A) Dijkstra's Algorithm", "B) Quick Sort",
                                                                        "C) Merge Sort",
                                                                        "D) Binary Search" },
                                                        'A'),
                                        new Question("Which data structure is most efficient for implementing a queue?",
                                                        new String[] { "A) Linked List", "B) Stack", "C) Array",
                                                                        "D) Binary Tree" },
                                                        'A'),
                                        new Question(
                                                        "In object-oriented programming, which of the following is the term for a function inside a class?",
                                                        new String[] { "A) Method", "B) Constructor", "C) Variable",
                                                                        "D) Object" },
                                                        'A'),
                                        new Question("Which of the following search algorithms works by dividing the search space in half?",
                                                        new String[] { "A) Linear Search", "B) Binary Search",
                                                                        "C) Hash Search", "D) Jump Search" },
                                                        'B'),
                                        new Question("What does a compiler do in the context of programming?",
                                                        new String[] { "A) Executes the code",
                                                                        "B) Translates the code to machine language",
                                                                        "C) Debugs the code",
                                                                        "D) Compresses the code" },
                                                        'B'),
                                        new Question("What is the time complexity of finding an element in a hash map?",
                                                        new String[] { "A) O(1)", "B) O(n)", "C) O(log n)",
                                                                        "D) O(n log n)" },
                                                        'A'),
                                        new Question("Which of the following is an example of an abstract data type?",
                                                        new String[] { "A) Array", "B) Stack", "C) Linked List",
                                                                        "D) String" },
                                                        'B'),
                                        new Question("In a doubly linked list, each node has:",
                                                        new String[] { "A) A single link to the next node",
                                                                        "B) A link to the previous node and next node",
                                                                        "C) A reference to a single value",
                                                                        "D) No links" },
                                                        'B'),
                                        new Question("What is the primary goal of data normalization in databases?",
                                                        new String[] { "A) Reducing redundancy", "B) Improving speed",
                                                                        "C) Increasing complexity",
                                                                        "D) Sorting data" },
                                                        'A'),
                                        new Question("Which of the following represents the highest level of abstraction in the OSI model?",
                                                        new String[] { "A) Application Layer", "B) Transport Layer",
                                                                        "C) Network Layer",
                                                                        "D) Physical Layer" },
                                                        'A'),
                                        new Question("What does the term 'polymorphism' mean in object-oriented programming?",
                                                        new String[] { "A) Multiple classes",
                                                                        "B) Multiple methods with the same name but different signatures",
                                                                        "C) A class hierarchy",
                                                                        "D) A method signature" },
                                                        'B')
                        });

        public void startQuiz() {
                System.out.println("\n==============================");
                System.out.println("Welcome to the Computer Science Quiz Game!");
                System.out.println("Test your knowledge of algorithms, data structures, and theory.");
                System.out.println("==============================");

                boolean retry = true;
                while (retry) {
                        score = 0;
                        consecutiveCorrectAnswers = 0;
                        Question[] currentQuestions = getRandomQuestionSet();
                        runQuiz(currentQuestions);
                        displayResults();

                        retry = askRetry();
                }
        }

        private Question[] getRandomQuestionSet() {
                Random rand = new Random();
                return questionSets.get(rand.nextInt(questionSets.size()));
        }

        private void runQuiz(Question[] questions) {
                for (int i = 0; i < TOTAL_QUESTIONS; i++) {
                        Question question = questions[i];
                        question.displayQuestion();

                        char userAnswer = getUserAnswer();

                        processAnswer(question, userAnswer);
                }
        }

        private char getUserAnswer() {
                char userAnswer = ' ';
                boolean validInput = false;

                while (!validInput) {
                        System.out.print("Your answer: ");
                        String input = scanner.next().toUpperCase();

                        if (input.length() == 1 && (input.charAt(0) >= 'A' && input.charAt(0) <= 'D')) {
                                userAnswer = input.charAt(0);
                                validInput = true;
                        } else {
                                System.out.println("Invalid input. Please enter A, B, C, or D.");
                        }
                }

                return userAnswer;
        }

        private void processAnswer(Question question, char userAnswer) {
                if (userAnswer == question.correctAnswer) {
                        System.out.println("\033[32mCorrect! Good job.\033[0m");
                        score++;
                        consecutiveCorrectAnswers++;
                } else {
                        System.out.println("\033[31mIncorrect! The correct answer was " + question.correctAnswer
                                        + ".\033[0m");
                        consecutiveCorrectAnswers = 0;
                }

                System.out.println("\n==============================");
        }

        private void displayResults() {
                System.out.println("\n==============================");
                double percentage = (score / (double) TOTAL_QUESTIONS) * 100;
                System.out.println("Quiz Completed!");
                System.out.println("You scored " + score + " out of " + TOTAL_QUESTIONS + " ("
                                + String.format("%.2f", percentage) + "%).");
                System.out.println("==============================");

                if (percentage >= 80) {
                        System.out.println("\033[32mExcellent! You're a Computer Science Guru!\033[0m");
                } else if (percentage >= 50) {
                        System.out.println("\033[33mGood job! Keep improving.\033[0m");
                } else {
                        System.out.println(
                                        "\033[31mKeep learning! Computer science is vast, and there's so much more to discover.\033[0m");
                }
        }

        private boolean askRetry() {
                System.out.print("\nWould you like to try again? (Y/N): ");
                String response = scanner.next().toUpperCase();
                return response.equals("Y");
        }
}