class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>>  ans = new ArrayList<>();
        int[] a = {1,2,3,4,5,6,7,8,9};
        find(ans,a,k,n,new ArrayList<>(),0);
        return ans;
        
    }
    void find(List<List<Integer>>  ans, int[] a,int k , int sum , List<Integer> dummy , int st){
        if(sum==0 && k==0){
            ans.add(new ArrayList<>(dummy));
            return;
        }
        for(int i =st;i<a.length;i++){
            dummy.add(a[i]);
            find(ans,a,k-1,sum-a[i],dummy,i+1);
            dummy.remove(dummy.size()-1);
        }

    }
}