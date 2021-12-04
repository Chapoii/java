package Task2;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;


public class Test {
    public static void main(String[] args) {
        Logger log = Logger.getGlobal();
        log.info("测试");

        log.info("测试:创建猫");
        OrangeCat orangeCat1 = new OrangeCat("orange_cat1", 4, "female", true);
        OrangeCat orangeCat2 = new OrangeCat("orange_cat2", 5, "female", true);
        ArrayList<Cat> cats = new ArrayList<>() {
            {
                add(orangeCat1);
            }
        };
        for (int i = 0; i < 5; i++) {
            cats.add(new BlackCat("black_cat" + (i + 1), i + 1, "male"));
        }
        for (int i = 0; i < 5; i++) {
            cats.add(new BlackCat("black_cat" + (i + 5), i + 5, "female"));
        }
        cats.add(orangeCat2);

        log.info("测试:创建顾客");
        Customer customer1 = new Customer("cus1", "OrangeCat", LocalDate.of(2021, Month.OCTOBER, 1));
        Customer customer2 = new Customer("cus2", "BlackCat", LocalDate.of(2021, Month.OCTOBER, 1));
        Customer customer3 = new Customer("cus3", "OrangeCat", LocalDate.of(2021, Month.OCTOBER, 3));

        log.info("测试:创建猫咖");
        MyCatCafe catCafe1 = null;
        MyCatCafe catCafe2;
        try {
            catCafe1 = new MyCatCafe(1, 100, new ArrayList<>(List.of(orangeCat2)));
            catCafe2 = new MyCatCafe(1, 100, cats);
            catCafe2.treatCustomer(customer3);
        } catch (Exception e) {
            log.warning(e.toString());
        }
        catCafe2 = new MyCatCafe(2, 100, cats);

        log.info("测试:将顾客添加到列表");
        try {
            if (catCafe1 == null) throw new NullPointerException("null");
            catCafe1.treatCustomer(customer1);
            catCafe1.treatCustomer(customer1);
            catCafe1.treatCustomer(customer2);
            catCafe1.treatCustomer(customer3);
            catCafe2.treatCustomer(customer1);
        } catch (Exception e) {
            log.warning(e.toString());
        }

        log.info("测试:猫咖买猫");
        try {
            if (catCafe1 == null) throw new NullPointerException("null");
            catCafe1.purchase(new BlackCat("black_cat1", 3, "male"));
        } catch (Exception e) {
            log.warning(e.toString());
        }
        if (catCafe1 == null) throw new NullPointerException("null");
        catCafe1.setBalance(350);
        catCafe1.purchase(new BlackCat("black_cat1", 3, "male"));

        log.info("测试:招待顾客");
        try {
            catCafe1.close(LocalDate.of(2021, Month.OCTOBER, 1));
            catCafe2.close(LocalDate.of(2021, Month.OCTOBER, 1));
        } catch (Exception e) {
            log.warning(e.toString());
        }


    }
}
