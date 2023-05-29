/*import java.util.ArrayList;
import java.util.List;

public class Last3Max {
    private List<Integer> nombers;

    public Last3Max() {
        nombers = new ArrayList<>();
    }

    public void put(int num){
        nombers.add(num);
        if (nombers.size()>3){
            nombers.remove(0);
        }
    }

    public int getLast3Max()throws Exception {
        if (nombers.size() == 0) {
            throw new Exception("Нет чисел в списке");
        } else {
            int maxNum = Integer.MIN_VALUE;
            for (Integer nomber : nombers) {
                if (maxNum<nomber){
                    maxNum = nomber;
                }
            }
            return maxNum;
        }
    }
}

 */

