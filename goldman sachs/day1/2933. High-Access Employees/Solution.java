class Solution {
    public List<String> findHighAccessEmployees(List<List<String>> acc) {
        List<String> ans = new ArrayList<>();
        HashMap<String,List<Integer>> hm = new HashMap<>();
        for(List<String> l : acc){
            String curEmployee = l.get(0);
            if(!hm.containsKey(curEmployee)) hm.put(curEmployee,new ArrayList<Integer>());
            hm.get(curEmployee).add(Integer.parseInt(l.get(1)));
        }
        for(String s : hm.keySet()){
            if(helper(hm.get(s))) ans.add(s);
        }
        return ans;
    }
    public boolean helper(List<Integer> l){
        int n = l.size();
        Collections.sort(l);
        for(int i=2;i<n;i++){
            if(l.get(i)-l.get(i-2) < 100) return true; 
        }
        return false;
    }
}