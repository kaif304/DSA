package Question;

public class FlippingAnImage832 {
    static int[][] flipAndInvertImage(int[][] image) {
        for(int[] arr: image){
            change(arr);
        }
//        for(int i=0; i<image.length; i++){
//            for(int j=0; j<image.length; j++){
//                if(image[i][j] == 0){
//                    image[i][j] = 1;
//                }
//                else{
//                    image[i][j] = 0;
//                }
//            }
//        }
        return image;
    }
    static void change(int[] arr){
        for(int s = 0, e = arr.length-1; s <= e; s++, e--){
            int t = arr[s];
            arr[s] = arr[e];
            arr[e] = t;
            if(arr[s] == 0){
                arr[s] = 1;
            } else{
                arr[s] = 0;
            }
            if(s != e){
                if(arr[e] == 0){
                    arr[e] = 1;
                } else{
                    arr[e] = 0;
                }
            }
        }
    }
    public static void main(String[] args) {
        int[][] arr = {{1,1,0},{1,0,1},{0,0,0}};
        arr = flipAndInvertImage(arr);
        for(int[] ar : arr){
            for(int e : ar){
                System.out.print(e+" ");
            }
            System.out.println();
        }
    }
}
