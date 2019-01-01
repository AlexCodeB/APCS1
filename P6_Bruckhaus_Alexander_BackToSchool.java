//BackToSchool Reflection

//Alex Bruckhaus, Period 6, 11/19/2017
//This program took me 30 minutes.
//Although this program was fairly simple, I learned a lot from completing this assignment. Prior to this lab, I had little knowledge of what inheritance was, but after reading the notes and continuing with the lab,
//I started to get a better idea of the usefulness of inheritance. I did not really run into any issues during this program except at the end in the main method where my non static variable coudln't be referenced
//from a static context. To resolve this, I added the name of the class before making the new instance. This solved the issue and after this, my program ran smoothly. All in all, this program was very informative.


public class P6_Bruckhaus_Alexander_BackToSchool{
    class Person{
        private String myName ;  // name of the person
        private int myAge;       // person's age
        private String myGender; // "M" for male, "F" for female

        // constructor
        public Person(String name, int age, String gender){
            myName = name;
            myAge = age;
            myGender = gender;
        }

        public String getName(){
            return myName;
        }

        public int getAge(){
            return myAge;
        }

        public String getGender(){
            return myGender;
        }

        public void setName(String name){
            myName = name;
        }

        public void setAge(int age){
            myAge = age;
        }

        public void setGender(String gender){
            myGender = gender;
        }

        public String toString(){
            return myName + ", age: " + myAge + ", gender: " + myGender;
        }
    }

    class Teacher extends Person{
        private String mySubject; 
        private double mySalary; 

        // constructor
        public Teacher(String name, int age, String gender,
        String subject, double salary){
            // use the super class' constructor
            super(name, age, gender);

            // initialize what's new to Student
            mySubject = subject;
            mySalary = salary;
        }

        public String getSubject(){
            return mySubject;
        }

        public double getSalary(){
            return mySalary;
        }

        public void setSalary(double salary){
            mySalary = salary;
        }

        public void setSubject(String subject){
            mySubject = subject;
        }

        // overrides the toString method in the parent class
        public String toString(){
            return super.toString() + ", subject: " + mySubject + ", salary: " + mySalary;
        }
    }

    class Student extends Person{
        private String myIdNum; // Student Id Number
        private double myGPA; // grade point average

        // constructor
        public Student(String name, int age, String gender,
        String idNum, double gpa){
            // use the super class' constructor
            super(name, age, gender);

            // initialize what's new to Student
            myIdNum = idNum;
            myGPA = gpa;
        }

        public String getIdNum(){
            return myIdNum;
        }

        public double getGPA(){
            return myGPA;
        }

        public void setIdNum(String idNum){
            myIdNum = idNum;
        }

        public void setGPA(double gpa){
            myGPA = gpa;
        }

        // overrides the toString method in the parent class
        public String toString(){
            return super.toString() + ", student id: " + myIdNum + ", gpa: " + myGPA;
        }
    }

    class CollegeStudent extends Student{
        private String myMajor; // Student Id Number
        private int myYear; // grade point average

        // constructor
        public CollegeStudent(String name, int age, String gender,
        String idNum, double gpa,
        String major, int year){
            // use the super class' constructor
            super(name, age, gender, idNum, gpa);

            // initialize what's new to Student
            myMajor = major;
            myYear = year;
        }

        public String getMajor(){
            return myMajor;
        }

        public int getYear(){
            return myYear;
        }

        public void setMajor(String major){
            myMajor = major;
        }

        public void setYear(int year){
            myYear = year;
        }

        // overrides the toString method in the parent class
        public String toString(){
            return super.toString() + ", Year: " + myYear + ", Major: " + myMajor;
        }
    }

    public static void main(String[] args){
        
        Person bob = new P6_Bruckhaus_Alexander_BackToSchool().new Person("Coach Bob", 27, "M");
        System.out.println(bob);
        
        Student lynne = new P6_Bruckhaus_Alexander_BackToSchool().new Student("Lynne Brooke", 16, "F", "HS95129", 3.5);
        System.out.println(lynne);

        Teacher mrJava = new P6_Bruckhaus_Alexander_BackToSchool().new Teacher("Duke Java", 34, "M", "Computer Science", 50000);
        System.out.println(mrJava);

        CollegeStudent ima = new P6_Bruckhaus_Alexander_BackToSchool().new CollegeStudent("Ima Frosh", 18, "F", "UCB123",
        4.0, "English", 1);
        System.out.println(ima);
       
        
        System.out.println();
        
        
        Person John = new P6_Bruckhaus_Alexander_BackToSchool().new Person("Coach John", 24, "M");
        System.out.println(John);
        
        Student Wil = new P6_Bruckhaus_Alexander_BackToSchool().new Student("Wil Cox", 17, "M", "HS519", 3.0);
        System.out.println(Wil);

        Teacher mrMan = new P6_Bruckhaus_Alexander_BackToSchool().new Teacher("Professor Man", 43, "M", "Computer Science", 50);
        System.out.println(mrMan);

        CollegeStudent youra = new P6_Bruckhaus_Alexander_BackToSchool().new CollegeStudent("Ima Soph", 18, "F", "UCLA123",
        4.1, "Math", 2);
        System.out.println(youra);
         

    }
}