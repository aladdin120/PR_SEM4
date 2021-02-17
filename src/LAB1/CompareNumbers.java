package LAB1;

import java.util.Comparator;

class CompareNumbers implements Comparator<Integer> {

    @Override
    public int compare(Integer o1, Integer o2) {
        return Math.abs(o1) > Math.abs(o2) ? o1 : o2;
    }
}