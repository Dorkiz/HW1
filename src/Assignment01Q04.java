import java.util.Arrays;

public class Assignment01Q04 {

    public static int[] shiftArrayCyclic(int[] array, int move, char direction) {
        if (direction != 'R' && direction != 'L') {return array;}
        if (array.length == 0) {return array;}

        int[] helper = new int[array.length];
        int normalized = NormalizedMove(array.length, move, direction);
        if (normalized==0){return array;}
        for(int i=0; i< array.length; i++){
            int newplace = i + normalized;
            if (newplace >= array.length){newplace = newplace - array.length;}
            helper[newplace] = array[i];
        }
        for(int i=0; i< array.length; i++){
            array[i] = helper[i];
        }
        return array;
    }
    public static int NormalizedMove(int len, int move, char direction){
        int normalized = Math.abs(move) % len;
        if (direction == 'R'){ normalized = -normalized;}
        if (move > 0){ normalized = -normalized;}
        if (normalized < 0) {normalized=len + normalized;}
        return normalized;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(
            shiftArrayCyclic(new int[]{1, 2, 3, 4, 5}, -1, 'R'))); // [2, 3, 4, 5, 1]
        System.out.println(Arrays.toString(
            shiftArrayCyclic(new int[]{1, 2, 3, 4, 5}, 1, 'R'))); // [5, 1, 2, 3, 4]
        System.out.println(Arrays.toString(
            shiftArrayCyclic(new int[]{1, 2, 3, 4, 5}, 1, 'r'))); // [1, 2, 3, 4, 5]
        System.out.println(Arrays.toString(
            shiftArrayCyclic(new int[]{1, 2, 3, 4, 5}, -2, 'g'))); // [1, 2, 3, 4, 5]
        System.out.println(Arrays.toString(
            shiftArrayCyclic(new int[]{1, 2, 3, 4, 5}, 3, 'L'))); // [4, 5, 1, 2, 3]
        System.out.println(Arrays.toString(
            shiftArrayCyclic(new int[]{1, 2, 3, 4, 5}, -3, 'L'))); // [3, 4, 5, 1, 2]
        System.out.println(Arrays.toString(
            shiftArrayCyclic(new int[]{0, 8, 9, 5, 6}, 6, 'L'))); // [8, 9, 5, 6, 0]
        System.out.println(Arrays.toString(
            shiftArrayCyclic(new int[]{}, 3, 'R'))); // []
    }
}