class P6BruckhausAlexanderBackToSchool {
    class Person {
        private String myName;  // name of the person
        private int myAge;       // person's age
        private String myGender; // "M" for male, "F" for female

        // constructor
        public Person(String name, int age, String gender) {
            myName = name;
            myAge = age;
            myGender = gender;
        }

        public String getName() {
            return myName;
        }

        public int getAge() {
            return myAge;
        }

        public String getGender() {
            return myGender;
        }

        public void setName(String name) {
            myName = name;
        }

        public void setAge(int age) {
            myAge = age;
        }

        public void setGender(String gender) {
            myGender = gender;
        }

        public String toString() {
            return myName + ", age: " + myAge + ", gender: " + myGender;
        }
    }

    class Teacher extends Person {
        private String mySubject;
        private double mySalary;

        // constructor
        public Teacher(String name, int age, String gender,
                       String subject, double salary) {
            // use the super class' constructor
            super(name, age, gender);

            // initialize what's new to Student
            mySubject = subject;
            mySalary = salary;
        }

        public String getSubject() {
            return mySubject;
        }

        public double getSalary() {
            return mySalary;
        }

        public void setSalary(double salary) {
            mySalary = salary;
        }

        public void setSubject(String subject) {
            mySubject = subject;
        }

        // overrides the toString method in the parent class
        public String toString() {
            return super.toString() + ", salary: " + mySalary + ", subject " + mySubject;
        }
    }

    class Student extends Person {
        private String myIdNum; // Student Id Number
        private double myGPA; // grade point average

        // constructor
        public Student(String name, int age, String gender,
                       String idNum, double gpa) {
            // use the super class' constructor
            super(name, age, gender);

            // initialize what's new to Student
            myIdNum = idNum;
            myGPA = gpa;
        }

        public String getIdNum() {
            return myIdNum;
        }

        public double getGPA() {
            return myGPA;
        }

        public void setIdNum(String idNum) {
            myIdNum = idNum;
        }

        public void setGPA(double gpa) {
            myGPA = gpa;
        }

        // overrides the toString method in the parent class
        public String toString() {
            return super.toString() + ", student id: " + myIdNum + ", gpa: " + myGPA;
        }
    }

    class CollegeStudent extends Student {
        private String myMajor; // Student Id Number
        private int myYear; // grade point average

        // constructor
        public CollegeStudent(String name, int age, String gender,
                              String idNum, double gpa,
                              String major, int year) {
            // use the super class' constructor
            super(name, age, gender, idNum, gpa);

            // initialize what's new to Student
            myMajor = major;
            myYear = year;
        }

        public String getMajor() {
            return myMajor;
        }

        public int getYear() {
            return myYear;
        }

        public void setMajor(String major) {
            myMajor = major;
        }

        public void setYear(int year) {
            myYear = year;
        }

        // overrides the toString method in the parent class
        public String toString() {
            return super.toString() + ", Year: " + myYear + ", Major: " + myMajor;
        }
    }

    public static void main(String[] args) {

        Person bob = new P6BruckhausAlexanderBackToSchool().new Person("Coach Bob", 27, "M");
        System.out.println(bob);

        Student lynne = new Student("Lynne Brooke", 16, "F", "HS95129", 3.5);
        System.out.println(lynne);

        Teacher mrJava = new Teacher("Duke Java", 34, "M", "Computer Science", 50000);
        System.out.println(mrJava);

        CollegeStudent ima = new CollegeStudent("Ima Frosh", 18, "F", "UCB123",
                4.0, 1, "English");
        System.out.println(ima);

    }

}
