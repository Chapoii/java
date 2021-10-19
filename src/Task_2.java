import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class Task_2 {
    public static void main(String... args) {
        if (!Arrays.equals(args, new String[]{})) {
            System.out.println(Arrays.toString(args));
            for (String arg : args) {
                if ("-v".equals(arg)) {
                    System.out.println("v 1.0");
                    break;
                }
            }
        }

        Booth booth1 = new Booth(1, "Bob", 100, false);
        System.out.println(booth1);

        Booth booth2 = new Booth(2, "jack", 40, true);
        booth2.setName("Tom");
        System.out.println(booth2);

        purchase(booth1, 150);
        System.out.println(booth1.getName());

        booth1.setId(1);
        booth1.setId(2);
        booth1.setId(3);
        System.out.println(booth1.getId());

        closeBooths(new Booth[]{booth1, booth2});
        booth2.restock(20);
        purchase(booth2, 80);
        booth2.setIsClosed(false);
        purchase(booth2, 80);

        System.out.println("\n---请依次输入id、name、total、isClosed并以空格分割:");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String[] arr = str.split(" +");
        Booth booth = new Booth(Integer.parseInt(arr[0]), arr[1], Integer.parseInt(arr[2]), Boolean.parseBoolean(arr[3]));
        System.out.println(booth);

    }

    public static void purchase(Booth booth, int number) {
        if (number <= 0) {
            System.out.println("购买数应大于0");
        } else if (booth.getIsClosed()) {
            System.out.println("商家正在休摊整改中");
        } else if (booth.getTotal() < number) {
            System.out.println("在售西瓜数不足");
        } else {
            booth.setTotal(booth.getTotal() - number);
        }
    }

    public static void closeBooths(Booth[] booths) {
        for (Booth booth : booths) {
            if (!booth.getIsClosed()) {
                booth.setIsClosed(false);
            } else {
                System.out.println(booth);
            }
        }
    }


}


class Booth {
    public static ArrayList<Long> ids = new ArrayList<>();
    private long id;
    private String name;
    private int total;
    private boolean isClosed;

    public static boolean check(long id) {
        for (long i : Booth.ids) {
            if (id == i) {
                return true;
            }
        }
        return false;
    }

    public void setId(long id) {
        if (id < 0) {
            System.out.println("id应大于0");
        } else if (check(id)) {
            System.out.println("该摊位号已存在");
        } else {

            Booth.ids.remove(this.id);
            Booth.ids.add(id);
            this.id = id;
        }

    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTotal(int total) {
        if (total < 0) {
            System.out.println("在售西瓜数应不小于0");
        } else {
            this.total = total;
        }
    }

    public void setIsClosed(boolean isClosed) {
        this.isClosed = isClosed;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getTotal() {
        return total;
    }

    public boolean getIsClosed() {
        return isClosed;
    }

    public Booth(long id, String name, int total, boolean isClosed) {
        if (id < 0) {
            System.out.println("id应大于0");
        } else if (check(id)) {
            System.out.println("该摊位号已存在");
        } else {
            Booth.ids.remove(this.id);
            Booth.ids.add(id);
            this.id = id;
        }
        if (total < 0) {
            System.out.println("在售西瓜数应不小于0");
        } else {
            this.total = total;
        }
        this.name = name;
        this.isClosed = isClosed;
    }

    @Override
    public String toString() {
        return "class:" + this.getClass().getName() +
                "\nid:" + id +
                "\nname:" + name +
                "\ntotal:" + total +
                "\nisClosed:" + isClosed +
                "\n";
    }

    public void restock(int num) {
        if (num > 200) {
            System.out.println("进货数量超出限制");
        } else if (num <= 0) {
            System.out.println("进货数量应大于0");
        } else {
            this.total += num;
        }
    }
}

