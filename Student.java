/**
 * @Author Bryan Zen 113252725
 * @version 1.0
 * @since 2021-09-07
 */

public class Student {
    private String name;
    private double money;

    /**
     * This method is the constructor for the Student object. This object has
     * been initialized to a Student object with specified name and price
     * @param name This is the parameter where a name is assigned to the
     *             current Student object.
     * @param money This is the parameter where the amount of money the
     *              Student has is assigned to the current Student object.
     */

    public Student(String name, double money){
        this.name = name;
        this.money = money;
    }

    /**
     * This method is a getter for the attribute "name".
     * @return Returns the name of the specified Student object.
     */

    public String getName() {
        return name;
    }

    /**
     * This method is the setter for the attribute "name".
     * @param name This is the parameter where a String name becomes the
     *             specified Student object's name.
     */

    public void setName(String name) {
        this.name = name;
    }

    /**
     *This method is a getter for the attribute "money".
     * @return Returns the amount of money the specified Student object has.
     */

    public double getMoney(){
        return money;
    }

    /**
     * This method is the setter for the attribute "money".
     * @param money This is the parameter where double money becomes the
     *              specified Student object's worth.
     */

    public void setMoney(double money){
        this.money = money;
    }

    /**
     * This method compares two Student objects. If the object is an instance
     * of Student, the attributes are compared.
     * @param obj This is the parameter that describes the object that is being
     *            compared.
     * @return The method returns a boolean depending on if the two objects
     * are equal.
     */

    public boolean equals(Object obj){
        if (obj instanceof Student){
            Student p = (Student)obj;
            return (p.name == name) && (p.money == money);
        } else
            return false;
    }

    /**
     * This is the method that clones the current Student and saves it to a
     * new Student obj.
     * @return This method returns the copied new Student object.
     */

    public Student clone(){
        Student newStudent = new Student(this.name, this.money);
        return newStudent;
    }

    /**
     * This is the method that prints Student object.
     * @return This method returns the current object, and it's attributes as
     * a String.
     */

    public String toString(){
        return "Student:" + name + "Money: " + "$" + money;
    }
}
