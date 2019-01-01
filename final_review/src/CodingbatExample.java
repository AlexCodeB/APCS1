public class CodingbatExample {
    private static int compare(int[] nums1, int[] nums2){
        int count = 0;
        for(int i = 0; i < nums1.length; i++){
            if ((i == nums1.length - 1 || (nums1[i+1] != 0 && nums2[i+1] != 0)) && nums1[i] == nums2[i]) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args){
        int[] a1;
        int[] a2;

        a1 = new int[]{0, 5, 6, 2, 1};
        a2 = new int[]{0, 5, 0, 6, 8};
        System.out.println(CodingbatExample.compare(a1, a2));

        a1 = new int[]{};
        a2 = new int[]{};
        System.out.println(CodingbatExample.compare(a1, a2));

        a1 = new int[]{1};
        a2 = new int[]{1};
        System.out.println(CodingbatExample.compare(a1, a2));

        a1 = new int[]{0, 0, 0, 0};
        a2 = new int[]{0, 0, 0, 0};
        System.out.println(CodingbatExample.compare(a1, a2));

        a1 = new int[]{1, 2, 3, 4, 5, 0};
        a2 = new int[]{1, 2, 9, 4, 5, 0};
        System.out.println(CodingbatExample.compare(a1, a2));
    }
}
