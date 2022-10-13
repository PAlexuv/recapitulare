package ScoalaIt.Java.Curs5InheritPolymorphExtends.TemaClasaCurs5;

public class Teacher extends Person{
    private int teacherId;
    private String specializare;

    public Teacher(String nume, String gen, String cnp, int varsta) {
        super(nume, gen, cnp, varsta);
    }

    public Teacher(String nume, String gen, String cnp, int varsta, int teacherId, String specializare) {
        super(nume, gen, cnp, varsta);
        this.teacherId = teacherId;
        this.specializare = specializare;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public String getSpecializare() {
        return specializare;
    }

    public void setSpecializare(String specializare) {
        this.specializare = specializare;
    }

    @Override
    public String toString() {
        return "Teacher: " +
                "teacherId = " + teacherId  +
                ", specializare= " + specializare +" "+
                super.toString().replace("Person", "");
    }
}

