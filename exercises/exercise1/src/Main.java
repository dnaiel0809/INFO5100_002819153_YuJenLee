import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

class Student {
    protected String name;
    protected List<Integer> quizScores;

    public Student(String name) {

        this.name = name;
        this.quizScores = new ArrayList<>();
        Random random = new Random();
//        System.out.println(name);
        for (int i = 0; i < 15; i++) {
            quizScores.add(random.nextInt(101));
//            System.out.println("Quiz"+i +": "+ quizScores.get(i));
        }
    }

    public String getName() {
        return name;
    }

    public List<Integer> getQuizScores() {
        return quizScores;
    }


}

class FullTimeStudent extends Student {
    private List<Integer> examScores;

    public FullTimeStudent(String name) {
        super(name);
        Random random = new Random();
        this.examScores = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            examScores.add(random.nextInt(101));
//            System.out.println("Exam" + i +": "+ examScores.get(i));

        }
    }


    public List<Integer> getExamScores() {
        return examScores;
    }
}

class PartTimeStudent extends Student {
    public PartTimeStudent(String name) {
        super(name);
    }
}

class Session {
    private List<FullTimeStudent> fullTimeStudents = new ArrayList<>();
    private List<PartTimeStudent> partTimeStudents = new ArrayList<>();

    public void addStudent(FullTimeStudent student) {
        fullTimeStudents.add(student);
    }

    public void addStudent(PartTimeStudent student) {
        partTimeStudents.add(student);
    }

    public void fullTimeStudentsScores() {
        for (FullTimeStudent fullTimestudent : fullTimeStudents) {
            System.out.println(fullTimestudent.getName() + "'s exam score: " + fullTimestudent.getExamScores().get(0) + ", " + fullTimestudent.getExamScores().get(1));
        }
    }

    public void partTimeStudentsNames() {
        for (PartTimeStudent partTimestudent : partTimeStudents) {
            System.out.println(partTimestudent.getName());
        }
    }

    public void calculateAndPrintAverageQuizScores() {
        for (FullTimeStudent fullTimestudent : fullTimeStudents) {
            double average = fullTimestudent.getQuizScores().stream().mapToDouble(d -> d).average().orElse(0);
            System.out.println(fullTimestudent.getName() + "'s average quiz score: " + average);
        }
        for (PartTimeStudent partTimestudent : partTimeStudents) {
            double average = partTimestudent.getQuizScores().stream().mapToDouble(d -> d).average().orElse(0);
            System.out.println(partTimestudent.getName() + "'s average quiz score: " + average);
        }
    }

    public void printQuizScoresInAscendingOrder() {
        List<Integer> quizScores = new ArrayList<>();
        for (FullTimeStudent fullTimestudent : fullTimeStudents) {
            for (int i = 0; i < fullTimestudent.getQuizScores().size(); i++)
                quizScores.add(fullTimestudent.getQuizScores().get(i));
        }
        for(PartTimeStudent partTimestudent :partTimeStudents){
            for (int i = 0; i < partTimestudent.getQuizScores().size(); i++)
                quizScores.add(partTimestudent.getQuizScores().get(i));
        }
        Collections.sort(quizScores);
        System.out.println("Quiz scores in ascending order: " + quizScores);
    }


}



public class Main {
    public static void main(String[] args) {
        String[] fullTimeStudentsName = {"Dale Harrington", "Aneesa Mcmahon", "Osman Yang", "Louis Houston", "Kira Patterson", "Isabelle Owen", "Nathanael Rojas"};
        String[] partTimeStudentsName= {"Millie Villa", "Ruth Moyer", "Arran Campbell", "Adelaide Cannon", "Gordon Gillespie", "Rico Ruiz", "Christian Henderson", "Antonia Lam", "Colby Heath", "Steve Rosales", "Kobe Andersen", "Gracie Mullen", "Cassius Hahn"};


        Session session = new Session();
        for (String s : fullTimeStudentsName) {
            session.addStudent(new FullTimeStudent(s));
        }
        for (String s : partTimeStudentsName) {
            session.addStudent(new PartTimeStudent(s));
        }


        System.out.println("Create public methods to calculate average quiz scores per student for the whole class.");
        session.calculateAndPrintAverageQuizScores();
        System.out.println();

        System.out.println("Create public method to print the list of quiz scores in ascending order for one session.");
        session.printQuizScoresInAscendingOrder();
        System.out.println();

        System.out.println("Create public method to print names of part-time students.");
        session.partTimeStudentsNames();
        System.out.println();

        System.out.println("Create public method to print exam scores of full-time students.");
        session.fullTimeStudentsScores();


    }
}
