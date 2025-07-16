import java.util.HashMap;
import java.util.Map;

public class EjerciciosPD {
    private Map<Integer, Long> map = new HashMap<>();
    
    public long getFibonnaci(int n){
        if (n <= 1) {
            return (long) n;
        }
        return getFibonnaci(n - 1) + getFibonnaci(n - 2);
    }

    public long getFibonnaciPD(int n){
        Map<Integer, Long> cache = new HashMap<>();
        return getFibonnaciPDHelper(n, cache);

    }

    public Long getFibonnaciPDHelper(int n , Map<Integer, Long> cache){
        if(n <= 1){
            return (long) n;
        }
        if(cache.containsKey(n))
            return cache.get(n);
        Long value = getFibonnaciPDHelper(n-1, cache)+ getFibonnaciPDHelper(n-2, cache);
        cache.put(n, value);
        return value;
    }

}