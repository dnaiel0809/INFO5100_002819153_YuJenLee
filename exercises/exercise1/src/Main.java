import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

class Student {
    private String name;
    private List<Integer> quizScores;

    public Student(String name) {
        this.name = name;
        this.quizScores = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 15; i++) {
            quizScores.add(random.nextInt(101));
        }
    }

//    public String getName() {
//        return name;
//    }

//    public List<Integer> getQuizScores() {
//        return quizScores;
//    }
}

class FullTimeStudent extends Student {
    private List<Integer> examScores;

    public FullTimeStudent(String name) {
        super(name);
        Random random = new Random();
        for (int i = 0; i < 2; i++) {
            examScores.add(random.nextInt(101));
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
    private List<Student> students;

    public Session(List<Student> students) {
        this.students = students;
    }

    public void calculateAndPrintAverageQuizScores() {
        for (Student student : students) {
            double average = student.getQuizScores().stream().mapToDouble(Integer::doubleValue).average().orElse(0);
            System.out.println(student.getName() + "'s average quiz score: " + average);
        }
    }

    public void printQuizScoresInAscendingOrder() {
        for (Student student : students) {
            List<Integer> quizScores = student.getQuizScores();
            Collections.sort(quizScores);
            System.out.println(student.getName() + "'s quiz scores in ascending order: " + quizScores);
        }
    }

    public void printPartTimeStudentNames() {
        System.out.print("Part-Time Student Names: ");
        for (Student student : students) {
            if (student instanceof PartTimeStudent) {
                System.out.print(student.getName() + ", ");
            }
        }
        System.out.println();
    }

    public void printFullTimeStudentExamScores() {
        for (Student student : students) {
            if (student instanceof FullTimeStudent) {
                List<Integer> examScores = ((FullTimeStudent) student).getExamScores();
                System.out.println(student.getName() + "'s exam scores: " + examScores);
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        String[] studentsName = {"Dale Harrington", "Aneesa Mcmahon", "Osman Yang", "Louis Houston", "Kira Patterson", "Isabelle Owen", "Nathanael Rojas", "Millie Villa", "Ruth Moyer", "Arran Campbell", "Adelaide Cannon", "Gordon Gillespie", "Rico Ruiz", "Christian Henderson", "Antonia Lam", "Colby Heath", "Steve Rosales", "Kobe Andersen", "Gracie Mullen", "Cassius Hahn"};
//        List<Student> students = new ArrayList<>();
//        students.add(new PartTimeStudent("Alice"));
//        students.add(new FullTimeStudent("Bob", List.of(85, 92)));
//        students.add(new PartTimeStudent("Charlie"));
//        students.add(new FullTimeStudent("David", List.of(78, 89)));
        // Add more students as needed

        Session session = new Session(students);


        session.calculateAndPrintAverageQuizScores();
        session.printQuizScoresInAscendingOrder();
        session.printPartTimeStudentNames();
        session.printFullTimeStudentExamScores();
    }
}
