package tree;

import java.util.Arrays;

public class SegmentTree {

    private int [] segmentTree;
    private static final int MAXVALUE = Integer.MAX_VALUE;

    public SegmentTree(int [] initialArray){
        int low = 0;
        int high = initialArray.length - 1;
        this.segmentTree = new int[segmentTreeLength(initialArray.length)];
        Arrays.fill(this.segmentTree,MAXVALUE);
        constructSegmentTree(initialArray,low,high,0);
    }

    private int segmentTreeLength(int initialArrayLength){
        if((initialArrayLength & (initialArrayLength - 1)) == 0){
            return 2*initialArrayLength - 1;
        }
        int result = 0;
        while(result<=initialArrayLength){
            result <<= 1;
        }
        return result - 1;
    }

    private void constructSegmentTree(int [] initialArray,int lowIndex,int highIndex,int position){ }

    private int rangeMinQuery(int requiredLowIndex,int requeredHighIndex,int position){
        return -1;
    }

    private int rangeMaxQuery(int requiredLowIndex,int requeredHighIndex,int position){
        return -1;
    }

    private int rangeMinSumQuery(int requiredLowIndex,int requeredHighIndex,int position){
        return -1;
    }

    private int rangeMaxSumQuery(int requiredLowIndex,int requeredHighIndex,int position){
        return -1;
    }

    private int rangeMinProductQuery(int requiredLowIndex,int requeredHighIndex,int position){
        return -1;
    }

    private int rangeMaxProductQuery(int requiredLowIndex,int requeredHighIndex,int position){
        return -1;
    }

}
