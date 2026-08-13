import java.util.*;

public class Solution {

    public static class Player {
        private String name;
        private int score;

        public Player(String name, int score) {
            this.name = name;
            this.score = score;
        }

        public String getName() {
            return name;
        }

        public int getScore() {
            return score;
        }
    }

    public static class Checker implements Comparator<Player> {

        @Override
        public int compare(Player a, Player b) {

            // Score: descending
            if (a.getScore() != b.getScore()) {
                return Integer.compare(b.getScore(), a.getScore());
            }

            // Name: ascending
            return a.getName().compareTo(b.getName());
        }
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int count = Integer.parseInt(input.nextLine().trim());

        Player[] playersList = new Player[count];

        int i = 0;

        while (i < count) {
            String[] part = input.nextLine().trim().split("\\s+");

            playersList[i] =
                new Player(part[0], Integer.parseInt(part[1]));

            i++;
        }

        Checker checker = new Checker();

        Arrays.sort(playersList, checker);

        for (Player p : playersList) {
            System.out.println(p.getName() + " " + p.getScore());
        }

        input.close();
    }
}
