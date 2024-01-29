import java.util.Random;
public class Hero {
    // properties
    private String name;
    private int hitPoints;

    //constructors
    public Hero(String name) {
        this.name = name;
        hitPoints = 100;
    }
    public String getName() {
        return name;
    }
    public int getHitPoints() {
        return hitPoints;
    }
    public String toString() {
        return "Hero{name='" + name + "', hitPoints=" + hitPoints + "}";
    }
    public void attack(Hero opponent) {
        Random rand = new Random();
        double dmg = rand.nextDouble();
        if (dmg < 0.5) {
            opponent.hitPoints -= dmg;
        }
        else {
            hitPoints -= dmg;
        }
    }
    public void senzuBean() {
        hitPoints = 100;
    }
    private void fightUntilTheDeathHelper(Hero opponent) {
        int i = 0;
        while (i < 1) {
            attack(opponent);
            opponent.attack(opponent);
            if (hitPoints == 0 || opponent.hitPoints == 0) i = 1;
        }
    }
    public String fightUntilTheDeath(Hero opponent) {
        senzuBean();
        opponent.senzuBean();
        fightUntilTheDeathHelper(opponent);
        return name + ": " + hitPoints + "        " + opponent.name + ": " + hitPoints;
    }
    private int[] nFightsToTheDeathHelper(Hero opponent, int n) {
        int[] fightsWon = new int[2];
        for (int i = 0; i < n; i++) {
            int j = 0;
            while (j < 1) {
                attack(opponent);
                opponent.attack(opponent);
                if (opponent.hitPoints == 0) {
                    fightsWon[0]++;
                    senzuBean();
                    opponent.senzuBean();
                    j = 1;
                } else if (hitPoints == 0) {
                    fightsWon[1]++;
                    senzuBean();
                    opponent.senzuBean();
                    j = 1;
                }
            }
        }
        return fightsWon;
    }
    public String nFightsToTheDeath(Hero opponent, int n) {
        int[] wins = nFightsToTheDeathHelper(opponent, n);
        String announcement = name + ": " + wins[0] + " wins" + "\n" + opponent.name + ": " + wins[1] + " wins";
        if (wins[0] == wins[1]) {
            return announcement + "\nOMG! It was actually a draw!";
        }
        else{
            if (wins[0] > wins[1]) {
                return announcement + "\n" + name + " wins!";
            }
            else {
                return announcement + "\n" + opponent.name + "wins!";
            }
        }
    }
    public void dramaticFightToTheDeath(Hero opponent) {
        senzuBean();
        opponent.senzuBean();
        int k = 0;
        while (k < 1) {
            attack(opponent);
            opponent.attack(opponent);
            System.out.println(name + ": " + hitPoints + "        " + opponent.name + ": " + hitPoints);
            if (hitPoints == 0 || opponent.hitPoints == 0) k = 1;
        }
    }
}
