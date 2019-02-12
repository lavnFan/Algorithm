
/**
 * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */


public class Solution {
    public boolean Find(int target, int [][] array) {
        //二维数组，查找最好是递增的，此时在右上或左下角时，就只是要么大，要么小
        for(int i = array.length - 1; i >= 0; i--){
            for(int j = 0; j < array[i].length; j++){
                if(array[i][j] == target){
                    return true;
                }
            }
        }
        return false;
    }
}