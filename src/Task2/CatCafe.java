package Task2;

import java.time.LocalDate;

// 因为接口定义的所有方法默认都是public abstract的，所以这两个修饰符不需要写出来（写不写效果都一样）
public interface CatCafe {
    void purchase(Cat cat);
    void treatCustomer(Customer customer);
    void close(LocalDate close_time);
}
