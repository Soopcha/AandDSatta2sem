import java.util.ArrayList;
import java.util.List;

class Last3Max {
    private List<Integer> nombers;

    public Last3Max() {
        nombers = new ArrayList<>();
    }

    public void put(int num) {
        nombers.add(num);
        if (nombers.size() > 3) {
            nombers.remove(0);
        }
    }

    public int getLast3Max() throws Exception {
        if (nombers.size() == 0) {
            throw new Exception("Нет чисел в списке");
        } else {
            int maxNum = Integer.MIN_VALUE;
            for (Integer nomber : nombers) {
                if (maxNum < nomber) {
                    maxNum = nomber;
                }
            }
            return maxNum;
        }
    }
}


public class One {
    public static void main(String[] args) throws Exception {
        Last3Max last3Max = new Last3Max();

        try {
            System.out.println(last3Max.getLast3Max());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            last3Max.put(5);
            System.out.println(last3Max.getLast3Max());  // Выводит: 5
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        last3Max.put(10);
        System.out.println(last3Max.getLast3Max());  // Выводит: 10

        last3Max.put(8);
        System.out.println(last3Max.getLast3Max());  // Выводит: 10

        last3Max.put(15);
        System.out.println(last3Max.getLast3Max());  // Выводит: 15

        last3Max.put(3);
        System.out.println(last3Max.getLast3Max());  // Выводит: 15
    }
}
