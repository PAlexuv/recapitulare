package ScoalaIt.Java.Curs6InterfaceAbstractArray.TemaCurs6;

public class LibraryPosition {
    private String row;
    private String column;

    public LibraryPosition(String row, String column){
        this.row = row;
        this.column = column;
    }

    public String getRow() {
        return row;
    }

    public String getColumn() {
        return column;
    }

    @Override
    public String toString() {
        return "LibraryPosition{" +
                "row='" + row + '\'' +
                ", column='" + column + '\'' +
                '}';
    }
}
