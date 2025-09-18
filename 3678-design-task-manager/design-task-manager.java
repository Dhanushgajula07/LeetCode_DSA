class TaskManager {

    private Map<Integer,Integer> taskUserMap;
    private Map<Integer,Integer> taskRewardMap;
    private PriorityQueue<int[]> pq;
    public TaskManager(List<List<Integer>> tasks) {
        taskUserMap=new HashMap<>();
        taskRewardMap= new HashMap<>();
        pq= new PriorityQueue<>((a,b)->{
            if(a[1]==b[1]) return Integer.compare(b[0],a[0]);
            return Integer.compare(b[1],a[1]);
        });

        for(List<Integer> lst : tasks){

            int userId =lst.get(0);
            int taskId =lst.get(1);
            int reward =lst.get(2);

            taskUserMap.put(taskId,userId);
            taskRewardMap.put(taskId,reward);
            pq.add(new int[]{taskId,reward});
        }
    }
    
    public void add(int userId, int taskId, int priority) {
        taskUserMap.put(taskId,userId);
        taskRewardMap.put(taskId,priority);
        pq.add(new int[]{taskId,priority});
    }
    
    public void edit(int taskId, int newPriority) {
        taskRewardMap.put(taskId,newPriority);
         pq.add(new int[]{taskId,newPriority});
    }
    
    public void rmv(int taskId) {
        taskUserMap.remove(taskId);
        taskRewardMap.remove(taskId);
    }
    
    public int execTop() {
       
        while(pq.size()>0 && (taskRewardMap.containsKey(pq.peek()[0])==false || taskRewardMap.get(pq.peek()[0])!=pq.peek()[1] ))
           {
                pq.poll();
           }
        
        if(pq.size()>0){
            int taskId=pq.peek()[0];
       
            pq.poll();
            int userId=taskUserMap.get(taskId);
            taskUserMap.remove(taskId);
            taskRewardMap.remove(taskId);
            return userId;
        }

       return -1;
        
    }
}