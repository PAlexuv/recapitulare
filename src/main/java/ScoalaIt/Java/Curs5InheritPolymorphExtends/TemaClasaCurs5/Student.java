package ScoalaIt.Java.Curs5InheritPolymorphExtends.TemaClasaCurs5;

public class Student extends Person{
    //id grupa an specializare
    private int studentId;
    private String grupa;
    private String specializare;

    public Student(String nume, String gen, String cnp, int varsta) {
        super(nume, gen, cnp, varsta);
    }

    public Student(String nume, String gen, String cnp, int varsta, int studentId, String grupa, String specializare) {
        super(nume, gen, cnp, varsta);
        this.studentId = studentId;
        this.grupa= grupa;
        this.specializare = specializare;
    }



    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getGrupa() {
        return grupa;
    }

    public void setGrupa(String grupa) {
        this.grupa = grupa;
    }

    public String getSpecializare() {
        return specializare;
    }

    public void setSpecializare(String specializare) {
        this.specializare = specializare;
    }

    @Override
    public String toString()  {
        return "Student: " +
                "studentId = " + studentId +
                ", grupa =" + grupa +
                ", specializare='" + specializare + '\'' +" "+
                super.toString().replace("Person", "");
    }
}
