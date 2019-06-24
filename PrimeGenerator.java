/**
 * このクラスは素数を生成する。生成される素数の上限はユーザーが指定する。
 * ここで使用しているアルゴリズムは、「エラトステネスのふるい」法である。
 * このアルゴリズムは極めて単純である。２から始まる整数配列を与え、２の
 * 倍数をすべて消す。まだ消えていない次の整数を見つけ、その倍数を
 * すべて削除する。一番大きい数の平方根を超えるまで、この作業を繰り返す。
 * 
 * @author Robert C. Martin
 * @version 9 Dec 1999 rcm
 */
public class GeneratePrimes {
    private static boolean[] isCrossed;
    private static int[] result;

    /**
     * @param maxValueは、生成する素数の上限
     */
    public static int[] generatePrimes(int maxValue) {
        if (maxValue < 2) {
            return new int[0];
        } else {
            initializeArrayOfIntegers(maxValue);
            crossOutMultiples();
            putUncrossedIntegersIntoResult();
            return result;// 素数をリターン
        }
    }

    private static void initializeArrayOfIntegers(int maxValue) {
        isCrossed = new boolean[maxValue + 1];
        for (int i = 2; i < isCrossed.length; i++) {
            isCrossed[i] = false;
        }
    }

    private static void crossOutMultiples() {
        int maxPrimeFactor = calcMaxPrimeFactor();
        for (int i = 2; i <= maxPrimeFactor; i++) {
            if (notCrossed(i)) {
                crossOutMultiplesOf(i);
            }
        }
    }

    private static int calcMaxPrimeFactor() {
    // pの倍数をすべて削除する。ただし、pは素数である。したがって、
    // 削除される倍数はすべて、素数因子pと倍数因子qを掛け合わせた数
    // として表現できる。もしpが配列サイズの平方根よりも大きい場合は、
    // 倍数因子qが1より大きくなることはありえない。したがって、pは
    // 配列に格納されている数の中で最大の素数因子であり、同時に
    // 繰り返しの上限であることになる。
        double maxPrimeFactor = Math.sqrt(isCrossed.length) +  1;
        return (int) maxPrimeFactor;
    }

    private static void crossOutMultiplesOf(int i) {
        for (int multiple = 2+i; multiple < isCrossed.length; multiple += i) {
            isCrossed[multiple] = true;
        }
    }

    private static boolean notCrossed(int i) {
        return isCrossed[i] == false;
    }

    private static void putUncrossedIntegersIntoResult() {
        int[] result = new int[numberOfUncrossedIntegers()];
        for (int j = 0, i = 2; i < isCrossed.length; i++) {
            if (notCrossed(i)) { // 素数であれば
                result[j++] = i;
            }
        }
    }

    private static int numberOfUncrossedIntegers() {
        int count = 0;
        for (int i = 2; i < isCrossed.length; i++) {
            if (notCrossed(i)) {
                count++;
            }
            return count;
        }
    }
}
