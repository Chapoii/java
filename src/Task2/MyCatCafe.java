package Task2;

import java.lang.reflect.Field;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

public class MyCatCafe implements CatCafe {

    public static ArrayList<Integer> ids = new ArrayList<>();
    public MyCatCafe(int id, double money, ArrayList<Cat> cats) {
        if(money<0){
            throw new RuntimeException("初始余额不能为负");
        }
        if(find(id)){
           throw new IllegalArgumentException("猫咖id重复!");
        }
        this.id = id;
        MyCatCafe.ids.add(id);
        balance = money;
        this.cats = cats;
    }

    @Override
    public void purchase(Cat cat) throws IllegalArgumentException {
        if (balance < cat.price) {
            throw new InsufficientBalanceException("钱不够!");
        } else {
            balance -= cat.price;
            cats.add(cat);
        }

    }



    @Override
    public void treatCustomer(Customer customer) {
        customers.add(customer);
    }

    private boolean findCat(String catType) {
        for (Cat i : cats) {
            String cat = i.getClass().getName();
            if (Objects.equals(cat.split("\\.")[1], catType)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void close(LocalDate time) {



        closedTime = time;
        int sum=0;
        System.out.println("顾客列表:");
        for (Customer customer:customers){
            String catType = "";
            try {
                Field wantRua = Customer.class.getField("wantRua");
                catType = (String) wantRua.get(customer);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (closedTime != null && customer.time.isAfter(closedTime)) {
                throw new IllegalArgumentException("CatCafe have already closed.");
            } else {
                if (findCat(catType)) {
                    balance += 15;
                } else {
                    throw new CatNotFoundException("没有这样的猫！");
                }
                System.out.println(customer);
            }
            sum +=15;
        }
        System.out.println(closedTime+"总利润:"+sum+"余额:"+balance);
    }

    public void setCats(ArrayList<Cat> cats) {
        this.cats = cats;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    private ArrayList<Cat> cats;
    private ArrayList<Customer> customers = new ArrayList<>();
    private LocalDate closedTime = null;
    private double balance;
    private final int id;

    private static boolean find(int id) {
        for (long i : MyCatCafe.ids) {
            if (id == i) {
                return true;
            }
        }
        return false;
    }
}
