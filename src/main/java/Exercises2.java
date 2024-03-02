import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Exercises2 {

    /*
     * Given an array of integers nums and an integer target, return indices of the
     * two numbers
     * such that they add up to target.
     * 
     * You may assume that each input would have exactly one solution, and you may
     * not use the same element twice.
     * You can return the answer in any order.
     */

    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    System.out.println(nums[i] + " " + nums[j]);
                    return new int[] { i, j };
                }
            }
        }
        return new int[] {};
    }

    /*
     * Roman numerals are represented by seven different symbols: I, V, X, L, C, D
     * and M.
     * 
     * Symbol Value
     * I 1
     * V 5
     * X 10
     * L 50
     * C 100
     * D 500
     * M 1000
     * 
     * For example, 2 is written as II in Roman numeral, just two ones added
     * together.
     * 12 is written as XII, which is simply X + II.
     * The number 27 is written as XXVII, which is XX + V + II.
     * 
     * Roman numerals are usually written largest to smallest from left to right.
     * However, the numeral for four is not IIII.
     * Instead, the number four is written as IV.
     * Because the one is before the five we subtract it making four.
     * The same principle applies to the number nine, which is written as IX.
     * There are six instances where subtraction is used:
     * 
     * I can be placed before V (5) and X (10) to make 4 and 9.
     * X can be placed before L (50) and C (100) to make 40 and 90.
     * C can be placed before D (500) and M (1000) to make 400 and 900.
     * 
     * Given a roman numeral, convert it to an integer.
     */

    public static int romanToInt(String s) {
        int length = s.length();
        int sum = 0;
        for (int i = 0; i < length; i++) {
            switch (s.charAt(i)) {
                case 'I': {
                    if (i + 1 < length && s.charAt(i + 1) == 'V') {
                        sum += 4;
                        i++;
                        break;
                    } else if (i + 1 < length && s.charAt(i + 1) == 'X') {
                        sum += 9;
                        i++;
                        break;
                    }
                    sum += 1;
                    break;
                }
                case 'X': {
                    if (i + 1 < length && s.charAt(i + 1) == 'L') {
                        sum += 40;
                        i++;
                        break;
                    } else if (i + 1 < length && s.charAt(i + 1) == 'C' ) {
                        sum += 90;
                        i++;
                        break;
                    }
                    sum += 10;
                    break;
                }
                case 'C': {
                    if (i + 1 < length && s.charAt(i + 1) == 'D') {
                        sum += 400;
                        i++;
                        break;
                    } else if (i + 1 < length && s.charAt(i + 1) == 'M') {
                        sum += 900;
                        i++;
                        break;
                    }
                    sum += 100;
                    break;
                }
                case 'V': {
                    sum += 5;
                    break;
                }
                case 'L': {
                    sum += 50;
                    break;
                }
                case 'D': {
                    sum += 500;
                    break;
                }
                case 'M': {
                    sum += 1000;
                    break;
                }
                default:
                    break;
            }
        }

        return sum;
    }

    /*
     * Given an array nums of distinct integers, return all the possible
     * permutations.
     * You can return the answer in any order.
     */

//    public static List<List<Integer>> permute(int[] nums) {
//        ArrayList<Integer> list_of_permute = new ArrayList <Integer>();
//        ArrayList<Integer> temp = new ArrayList<Integer>();
//        for (int i = 0 ; i < nums.length; i++)
//        {
//            temp.add(nums[i]);
//        }
//        list_of_permute.add();
//        return null;
//    }

        public static List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> results = new ArrayList<>();
            backtrack(nums, results, new ArrayList<>());
            return results;
        }

        private static void backtrack(int[] nums, List<List<Integer>> results, List<Integer> tempList) {
            if(tempList.size() == nums.length){
                results.add(new ArrayList<>(tempList));
            } else{
                for(int i = 0; i < nums.length; i++){
                    if(tempList.contains(nums[i])) continue; // element already exists, skip
                    tempList.add(nums[i]);
                    backtrack(nums, results, tempList);
                    tempList.remove(tempList.size() - 1);
                }
            }
        }


    public static void main(String[] args) {
        // test your code here!
        // int array[] = { 2, 1, 3 };
        // twoSum(array, 5);

        System.err.println(romanToInt("IV"));
    }
}