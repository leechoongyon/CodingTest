package codingtest.site.codility;

public class SemiPrime {
    public static void main(String[] args) {
        System.out.println(new SemiPrime().isSemiPrime(26) == true);
        System.out.println(new SemiPrime().isSemiPrime(25) == true);
        System.out.println(new SemiPrime().isSemiPrime(22) == true);
        System.out.println(new SemiPrime().isSemiPrime(21) == true);
        System.out.println(new SemiPrime().isSemiPrime(15) == true);
        System.out.println(new SemiPrime().isSemiPrime(14) == true);
        System.out.println(new SemiPrime().isSemiPrime(6) == true);
        System.out.println(new SemiPrime().isSemiPrime(4) == true);
        System.out.println(new SemiPrime().isSemiPrime(11) == false);
        System.out.println(new SemiPrime().isSemiPrime(10) == true);
        System.out.println(new SemiPrime().isSemiPrime(9) == true);
        System.out.println(new SemiPrime().isSemiPrime(8) == false);
        System.out.println(new SemiPrime().isSemiPrime(7) == false);
    }

    private boolean isPrime(int num) {
        if (num < 2) {
            return true;
        }

        for (int i = 2 ; i <= Math.sqrt(num) ; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    private boolean isSemiPrime(int num) {
        boolean isExistSemiPrime = false;

        if (num < 2) {
            return false;
        }

        for (int i = 2 ; i <= Math.sqrt(num) ; i++) {
            if (num % i == 0) {
                if ( !isPrime(i) || !isPrime(num / i)) {
                    return false;
                } else if (isExistSemiPrime) {
                    return false;
                } else {
                    isExistSemiPrime = true;
                }
            }
        }
        return isExistSemiPrime;
    }
}
