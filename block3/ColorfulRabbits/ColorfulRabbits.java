import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ColorfulRabbits {
    public int getMinimum(int[] replies) {
        int count = 0;
        ArrayList<Integer> list = new ArrayList<>();
        for (int reply : replies) {
            list.add(reply);
        }
        Map<Integer, List<Integer>> map = list.stream().collect(Collectors.groupingBy(Integer::intValue));
        for (Integer i : map.keySet()) {
            int j = map.get(i).size() % (i + 1) == 0 ? map.get(i).size() / (i + 1) : map.get(i).size() / (i + 1) + 1;
            count += (i + 1) * j;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new ColorfulRabbits().getMinimum(new int[]
                {0}
        ));
    }
}
