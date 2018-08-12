package Enum;
import java.util.ArrayList;
import java.util.List;

public class AmicablePair {
    //No.243:Amicable Pair, 相亲数
    //An amicable pair (m,n) consists of two integers m,n for which the sum of proper divisors
    // (the divisors excluding the number itself) of one number equals the other.
    public List<List<Integer>> amicablePair(int k) {
        List<List<Integer>> result = new ArrayList<>();
        for(int i = 2; i <= k; i++){
            int pair = helper(i);
            if(pair > i && pair <= k && helper(pair) == i){
                List<Integer> path = new ArrayList<>();
                path.add(i);
                path.add(pair);
                result.add(new ArrayList<>(path));
            }
        }
        return result;
    }

    private int helper(int n){
        int sum = 1, i;
        for(i = 2; i * i < n; i++){
            if(n % i == 0){
                sum += i + n / i;
            }
        }
        if(i * i == n){
            sum += i;
        }
        return sum;
    }
}
