//         Collections.sort(list, new Comp());
//         List<Integer> res = new ArrayList();
        
//         for (int[] item : list) {
//             // System.out.println(Arrays.toString(item));
//             res.add(item[0]);
//         }
        
//         return res;
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            return a[1] == b[1] ? b[0] - a[0] : b[1] - a[1];
        });
        for(int[] restaurant : restaurants) {
            if((veganFriendly == 0 || veganFriendly == restaurant[2]) &&
                restaurant[3] <= maxPrice &&
                restaurant[4] <= maxDistance
              ) {
                pq.offer(restaurant);
            }
        }
        List<Integer> result = new ArrayList<>();
        while(!pq.isEmpty()) {
            result.add(pq.poll()[0]);
        }
        return result;
    }
    
}
​
class Comp implements Comparator<int[]> {
    @Override
    public int compare(int[] a, int[] b) {
        if (b[1] == a[1])
            return b[0] - a[0];
        return b[1] - a[1];
    }
}
