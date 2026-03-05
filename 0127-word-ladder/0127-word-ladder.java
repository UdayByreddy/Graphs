class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        if(!set.contains(endWord)) return 0;
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        int res =1;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
                String temp = queue.poll();
                if(temp.equals(endWord)) return res;
                for(int j=0;j<temp.length();j++){
                    char[] ch = temp.toCharArray();
                    for(char c='a';c<='z';c++){
                        ch[j]=c;
                       String newWord = new String(ch);
                       if(set.contains(newWord)){
                        set.remove(newWord);
                        queue.offer(newWord);
                       } 
                    }
                }
            }
            res++;
        }
        return 0;
        
    }
}