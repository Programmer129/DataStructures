package tree;

public class SegmentTree {

    private int [] segmentTree;
    private int [] initialArray;
    private int height;
    private static final int MAXVALUE = Integer.MAX_VALUE;
    private static final int MINVALUE = Integer.MIN_VALUE;

    public SegmentTree(int [] initialArray,int height){
        int low = 0;
        int high = initialArray.length - 1;
        this.height = height;
        this.initialArray = initialArray;
        //this.segmentTree = new int[segmentTreeLength(initialArray.length)];
        this.segmentTree = new int[2*initialArray.length-1];
        constructSegmentTreeForXorAndOrOperations(initialArray,low,high,0,height);
    }

    private int segmentTreeLength(int initialArrayLength){
        if((initialArrayLength & (initialArrayLength - 1)) == 0){
            return 2*initialArrayLength - 1;
        }
        int result = 1;
        while(result<=initialArrayLength){
            result <<= 1;
        }
        return 2*result - 1;
    }

    public int answer(){
        return segmentTree[0];
    }

    private void constructSegmentTree(int [] initialArray,int lowIndex,int highIndex,int position){
        if(lowIndex == highIndex){
            this.segmentTree[position] = initialArray[lowIndex];
            return;
        }
        int middle = (lowIndex + highIndex)/2;
        constructSegmentTree(initialArray,lowIndex,middle,2*position + 1);
        constructSegmentTree(initialArray,middle + 1,highIndex,2*position + 2);
        this.segmentTree[position] = segmentTree[2*position+1]*segmentTree[2*position+2];
    }


    private void constructSegmentTreeForXorAndOrOperations(int [] initialArray,int lowIndex,int highIndex,int position,
                                                           int heightOfSegmentTree){
        if(lowIndex == highIndex){
            this.segmentTree[position] = initialArray[lowIndex];
            return;
        }
        int middle = (lowIndex + highIndex)/2;
        constructSegmentTreeForXorAndOrOperations(initialArray,lowIndex,middle,2*position+1,heightOfSegmentTree-1);
        constructSegmentTreeForXorAndOrOperations(initialArray,middle+1,highIndex,2*position+2,heightOfSegmentTree-1);
        if(heightOfSegmentTree %2 ==1){
            segmentTree[position] = segmentTree[2*position+1] | segmentTree[2*position+2];
        }
        else{
            segmentTree[position] = segmentTree[2*position+1] ^ segmentTree[2*position+2];
        }
    }

    private void updateSemgentTreeForXorAndOrOperation(int lowIndex,int highIndex,int changeableIndex,int valueToChange,
                                                       int position,int height){
        if(changeableIndex < lowIndex || highIndex<changeableIndex){
            return;
        }
        if(lowIndex == highIndex){
            segmentTree[position] = valueToChange;
            return;
        }
        int middle = (lowIndex + highIndex)/2;
        updateSemgentTreeForXorAndOrOperation(lowIndex,middle,changeableIndex,valueToChange,2*position+1,height-1);
        updateSemgentTreeForXorAndOrOperation(middle+1,highIndex,changeableIndex,valueToChange,2*position+2,height-1);
        segmentTree[position] = height %2 ==1 ? segmentTree[2*position+1] | segmentTree[2*position+2] :
                segmentTree[2*position+1] ^ segmentTree[2*position+2];
    }

    public void updateFotBitmask(int changeableIndex,int valueToChange){
        updateSemgentTreeForXorAndOrOperation(0,initialArray.length-1,changeableIndex,valueToChange,
                0,height);
    }


    public int queryMaximum(int lowIndex,int highIndex){
        return rangeMaxQuery(0,initialArray.length-1,lowIndex,highIndex,0);
    }

    private int rangeMaxQuery(int lowIndex,int highIndex,int requiredLowIndex,int requeredHighIndex,int position){
        if(requiredLowIndex<=lowIndex && highIndex<=requeredHighIndex){
            return segmentTree[position];
        }
        else
            if(requeredHighIndex<lowIndex || requiredLowIndex>highIndex){
                return MINVALUE;
            }
            else{
                int middle = (lowIndex + highIndex)/2;
                return Math.max(rangeMaxQuery(lowIndex,middle,requiredLowIndex,requeredHighIndex,2*position+1),
                        rangeMaxQuery(middle+1,highIndex,requiredLowIndex,requeredHighIndex,2*position+2));
            }
    }

    private int rangeProductQuery(int lowIndex,int highIndex,int requiredLowIndex,int requeredHighIndex,int position){
        if(requiredLowIndex<=lowIndex && highIndex<=requeredHighIndex){
            return segmentTree[position];
        }
        else
        if(requeredHighIndex<lowIndex || requiredLowIndex>highIndex){
            return 1;
        }
        else{
            int middle = (lowIndex + highIndex)/2;
            return rangeProductQuery(lowIndex,middle,requiredLowIndex,requeredHighIndex,2*position+1)*
                    rangeProductQuery(middle+1,highIndex,requiredLowIndex,requeredHighIndex,2*position+2);
        }
    }

    public int queryProduct(int requiredLowIndex,int requiredHighIndex){
       return rangeProductQuery(0,initialArray.length-1,requiredLowIndex,requiredHighIndex,0);
    }

    private void updateSegmentTreeForProduct(int lowIndex,int highIndex,int changeableIndex,int valueToChange,int position){
        if(changeableIndex<lowIndex || changeableIndex>highIndex){
            return;
        }
        if(lowIndex == highIndex){
            segmentTree[position] = valueToChange;
            return;
        }
        int middle = (lowIndex + highIndex)/2;
        updateSegmentTreeForProduct(lowIndex,middle,changeableIndex,valueToChange,2*position+1);
        updateSegmentTreeForProduct(middle+1,highIndex,changeableIndex,valueToChange,2*position+2);
        segmentTree[position] = segmentTree[2*position+1]*segmentTree[2*position+2];
    }

    public void updateSegmentTree(int changeableIndex,int valueToChange){
        updateSegmentTreeForProduct(0,initialArray.length-1,changeableIndex,valueToChange,0);
    }

    public void printSegmentTree(){
        for (int i = 0; i < this.segmentTree.length; i++) {
            System.out.println(segmentTree[i]);
        }
    }

}
