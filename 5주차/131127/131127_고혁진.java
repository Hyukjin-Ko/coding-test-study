import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        Map<String, Integer> hm = new HashMap<String, Integer>();

        for(int i=0; i<want.length; i++)
            hm.put(want[i], number[i]);

        for(int j=0; j<discount.length - 9; j++){
            int idx = 0;
            Map<String, Integer> map = new HashMap<String, Integer>();

            for(int i=0; i<10; i++)
                map.put(discount[i+j], map.getOrDefault(discount[i+j], 0) + 1);

            for (Map.Entry<String, Integer> entry : hm.entrySet())
                if(map.containsKey(entry.getKey()) && entry.getValue()<=map.get(entry.getKey()))
                    idx++;

            if(idx == want.length)
                answer++;
        }

        return answer;
    }
}