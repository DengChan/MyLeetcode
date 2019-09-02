import java.util.Arrays;
public class middle_num {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int k1 = (n+m+1)/2;
        int k2 = (n+m+2)/2;
        return (getK(nums1,0,n-1,nums2,0,m-1,k1)+getK(nums1,0,n-1,nums2,0,m-1,k2))*0.5;
    }
    private static int getK(int[] nums1, int start1,int end1, int[] nums2, int start2, int end2, int k){
        int len1 = end1-start1+1;
        int len2 = end2-start2+1;

        if(len1>len2) return getK(nums2,start2,end2,nums1,start1,end1,k);

        if(len1==0) return nums2[start2+k-1];

        if(k==1) return nums1[start1]<nums2[start2]? nums1[start1]:nums2[start2];

        int i = start1+ Math.min(len1,k/2)-1;
        int j = start2+ Math.min(len2,k/2)-1;
        if(nums1[i]<nums2[j]){
            return getK(nums1,i+1,end1,nums2,start2,end2,k-(i-start1+1));
        }
        else {
            return getK(nums1,start1,end1,nums2,j+1,end2,k-(j-start2+1));
        }
    }
    public static void main(String[] args){
        int[] nums1 ={1,3};
        int[] nums2 = {2};
        System.out.println(findMedianSortedArrays(nums1,nums2));
    }

}
