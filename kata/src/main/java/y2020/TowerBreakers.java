package y2020;

/**
 * /challenges/tower-breakers-1/problem
 *
 * n towers of heigh x (same height)
 * 2 playrs take turns
 *
 * pick tower and reduce height by y - where y < x && evenly divides x
 *
 * if player cannot make a move - they loose
 *
 * determine which player wins
 *
 * return 1 if first wins or 2 otherwise
 */
public class TowerBreakers {
    static int towerBreakers(int n, int m) {
        if (m == 1) return 2;

        if (n == 1){
            return 1;
        }else{
            if (n % 2 == 0) return 2;
            else return 1;
        }
    }
}
