package testingAssignment;

public enum Scale {
    mm(1000000),
    cm(100000),
    dm(10000),
    m( 1000),
    km(1);

    private int number;
    Scale(int number){
        this.number=number;
    }
    int getNumber(){
        return number;
    }
}
