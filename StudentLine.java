/**
 * @Author Bryan Zen 113252725
 * @version 1.0
 * @since 2021-09-07
 */

public class StudentLine {
    final int CAPACITY = 20;
    private Student [] students;
    private int studentCount;

    /**
     * This is the getter method for studentCount.
     * @return This method returns the student count.
     */

    public int numStudentCount() {
        return studentCount;
    }

    /**
     * This is the setter method for studentCount.
     * @param studentCount This is the parameter that the current studentCount
     *                     is set to.
     */

    public void setStudentCount(int studentCount) {
        this.studentCount = studentCount;
    }

    /**
     * This method is the method that initializes a new StudentLine array.
     */

    public StudentLine(){
        students = new Student[0];
        studentCount = 0;
    }

    /**
     * This method is the method that gets the number of students in the
     * specified student array.
     * @return This
     */

    public int numStudents(){
        return students.length;
    }

    /**
     *
     * @param index
     * @return
     */

    public Student getStudent(int index){
        if (index > studentCount){
            throw new ArrayIndexOutOfBoundsException("Array Index " +
                    "Out Of Bounds");
        }
        return students[index];
    }

    /**
     * This is the method that removes the current student at the given interval
     * the array is then shifted to the left in order to fill the empty slot.
     * @param index This is the parameter that indicates the index of the
     *              student that is removed.
     * @return Gets the reference to the Student at the given index
     * @throws EmptyLineException This exception is thrown when the
     * line is empty
     */

    public Student removeStudent(int index) throws EmptyLineException {
        if (index > studentCount){
            throw new ArrayIndexOutOfBoundsException("Array Index " +
                    "Out Of Bounds.");
        }
        if (students == null){
            throw new EmptyLineException("The line is empty.");
        }
        Student[] temp = new Student[studentCount - 1];
        Student skipped = students[index];
        if (studentCount == 1){
            studentCount--;
            students = null;
            return skipped;
        } else {
            boolean passed = false;
            for (int i = 0; i < studentCount - 1; i++) {
                int j = i + 1;
                if (i != index && !passed)
                    temp[i] = students[i];
                if (i == index) {
                    temp[i] = students[j];
                    passed = true;
                }
                if (passed && i != index)
                    temp[i] = students[j];
            }
        }
        studentCount--;
        students = new Student[studentCount];
        for (int n = 0; n < temp.length; n++){
            students[n] = temp[n];
        }
        return skipped;
    }

    /**
     * This is the method that adds a new student at a given interval, all
     * Students to the right is then shifted to the right.
     * @param index This is the parameter that indicates where the added
     *              student is inserted.
     * @param student This is the parameter that sets the added student as the
     *                student specified.
     * @throws DeanException This exception is thrown when the line has
     * reached maximum capacity.
     */

    public void addStudent(int index, Student student) throws DeanException {
        if (index > studentCount + 1){
            throw new IllegalArgumentException("Index is too high " +
                    "for this line.");
        }
        if (studentCount == 20){
            throw new DeanException("The line is full.");
        }
        Student[] temp = new Student[studentCount + 1];
        if (index == studentCount){
            for (int i = 0; i < studentCount + 1; i++){
                if (i != studentCount)
                    temp[i] = students[i];
                if (i == studentCount)
                    temp[i] = student;
            }
        } else {
            boolean passed = false;
            for (int i = 0; i < studentCount + 1; i++) {
                int j = i - 1;
                if (i != index && !passed)
                    temp[i] = students[i];
                if (i == index) {
                    temp[i] = student;
                    passed = true;
                }
                if (i != index && passed)
                    temp[i] = students[j];
            }
        }
        students = new Student[studentCount + 1];
        for (int n = 0; n < temp.length; n++){
            students[n] = temp[n];
        }
        studentCount++;
    }

    /**
     * This is the method where two students are swapped in two
     * indexes specified
     * @param index1 This is the parameter that specifies the index of the first
     *               student that is swapped.
     * @param index2 This is the parameter that specifies the index of the
     *               second student that is swapped.
     */

    public void swapStudents(int index1, int index2){
        if (index1 > studentCount - 1 || index2 > studentCount - 1
                || index1 == index2){
            throw new ArrayIndexOutOfBoundsException("The indices are " +
                    "out of bounds.");
        }
        Student[] temp = new Student[studentCount];
        for (int i = 0; i < studentCount; i++){
            if (i != index1 && i != index2)
                temp[i] = students[i];
            if (i == index1)
                temp[index1] = students[index2];
            if (i == index2)
                temp[index2] = students[index1];
        }
        students = new Student[studentCount + 1];
        for (int n = 0; n < temp.length; n++){
            students[n] = temp[n];
        }
    }

    /**
     * This is the method that clones the current student array to a
     * temporary array.
     * @return This method returns temp as an instance of StudentLine.
     */

    public StudentLine clone(){
        StudentLine temp = new StudentLine();
        temp.students = new Student[studentCount];
        for (int i = 0; i < studentCount; i++){
            temp.students[i] = students[i].clone();
        }
        temp.setStudentCount(studentCount);
        return temp;
    }

    /**
     * This is the method that compares the current students array to the
     * specified instance of student object.
     * @param o This is the parameter that indicates the specified instance of
     *          the student object.
     * @return This method returns a boolean depending on whether the two
     * objects being compared are true or false.
     */

    public boolean equals(Object o){
        if (o instanceof StudentLine){
            StudentLine p = (StudentLine)o;
            if ((p.students == null) && (students == null))
                return true;
            if ((p.students == null) || (students == null))
                return false;
            if ((p.students.length != students.length))
                return false;
            for (int i = 0; i < studentCount; i++){
                if (!(p.students[i].getName() == students[i].getName())
                        || !(p.students[i].getMoney() ==
                        students[i].getMoney())){
                    return false;
                }
            }
            return true;
        } else
            return false;
    }

    /**
     * This is the method that formats the name and the amount of money a
     * specified Student object has in its attributes.
     * @return This method prints the attributes in the form of a list.
     */

    public String toString(){
        String list = "";
        for (int i = 0; i < studentCount; i++){
            list = list + String.format("\n" + "\t" + "\t" +
                            "%2d. %-20s $%.2f%n",
                    i + 1, students[i].getName(), students[i].getMoney());
        }
        return list;
    }
}
