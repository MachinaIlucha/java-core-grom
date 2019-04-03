package lesson8.DZ2;

public class Demo {

   public Student createHighestParent(){
       Course[] courses= new Course[]{};
       Student student = new Student("Illia","Pop",2,courses);
       return student;
   }

   public SpecialStudent createLowestChild(){
       Course[] courses= new Course[]{};
       SpecialStudent specialStudent = new SpecialStudent("Illia","Pop",2,courses,31413531,"email");
       return specialStudent;
   }
}
