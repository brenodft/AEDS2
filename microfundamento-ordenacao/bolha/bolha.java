public class bolha{
    public static void main(String[] args){
        int[] array = new int[]{4,1,5,8,9,2,3,27,21,12,19,24,11,16,6,81};
        int count = 0;
        boolean houvetroca = true;
        for(int i = 0; i<array.length-1 && houvetroca; i++){
            houvetroca = false;
            for(int b = 0; b<array.length- (i+1); b++){
                if(array[b]>array[b+1]){
                    int temp = array[b];
                    array[b] = array[b+1];
                    array[b+1] = temp;
                    houvetroca = true;
                }
                count++;
            }
        }
        for(int i = 0; i<array.length; i++){
            System.out.print(array[i] +" ");
            
        }
        System.out.println(count);
    }
}