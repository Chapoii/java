package Task2;

import java.time.LocalDate;

public class Customer {
    public String name;
    public String wantRua;
    public LocalDate time;
    public Customer(String name, String wantRua, LocalDate time){
        this.name = name;
        this.wantRua = wantRua;
        this.time = time;
    }
    @Override
    public String toString() {
        return "name:" + name +
                "\nwant_rua:" + wantRua +
                "\ntime:" + time +
                "\n";
    }
}
