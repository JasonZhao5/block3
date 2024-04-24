import java.util.Arrays;

public class CastleGuards {
    public int missing(String[] castle) {
        int[] columns = new int[castle.length];
        int[] rows = new int[castle[0].length()];
        for (int i = 0; i < castle.length; i++) {
            for (int j = 0; j < castle[i].length(); j++) {
                if (castle[i].charAt(j) == 'X') {
                    columns[i] = 1;
                    rows[j] = 1;
                }
            }
        }
        long count1 = Arrays.stream(columns).filter(c -> c == 0).count();
        long count2 = Arrays.stream(rows).filter(r -> r == 0).count();
        return (int) Math.max(count1, count2);
    }

    public static void main(String[] args) {
        System.out.println(new CastleGuards().missing(new String[]
                { "........X..",
                        "...X.......",
                        "...........",
                        "..X...X....",
                        "...........",
                        "...........",
                        "........X..",
                        "...........",
                        "...........",
                        "........X..",
                        ".....X....." }


        ));
    }
}
