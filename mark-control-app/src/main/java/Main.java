public class Main {
    public static void main(String[] args) {
        Student student = new Student("Семицький Олександр Ігорович");
        student.addMark(new Subject("ОКА", 5.0), 97);
        student.addMark(new Subject("БД", 5.0), 94);
        student.addMark(new Subject("МОПІ", 4.0), 91);
        System.out.println(AverageMarkService.getAverageMark(student));
        System.out.println(AverageMarkService.isScholarship(student));
    }
}
