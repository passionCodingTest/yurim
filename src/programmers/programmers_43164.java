package programmers;

import java.util.*;

public class programmers_43164 {
	static ArrayList<String> list = new ArrayList<>() ;
    static boolean[] visited;
    static String route ="";
	public static void main(String[] args) {
		String[][] tickets = {{"ICN","ABC"},{"ABC","BCD"},{"ICN","CDE"},{"CDE","ICN"}};
//		String[][] tickets = {{"ICN","SFO"},{"ICN","ATL"},{"SFO","ATL"},{"ATL","ICN"},{"ATL","SFO"}};
		visited = new boolean[tickets.length];
        for(int i = 0; i<tickets.length; i++){
            String start = tickets[i][0];
            String destination = tickets[i][1];
            if(start.equals("ICN")){
                visited[i] = true;
                route += start+",";
                dfs(tickets, destination, 1);
                visited[i] = false;
                route = "";
            }
        }
        Collections.sort(list);
        String[] result = list.get(0).split(",");
        for(String d : result) {
        	System.out.print(d+" ");
        }
	}
	static public void dfs(String[][] tickets, String end, int cnt){
        route += end+",";
        if(cnt == tickets.length) {
            list.add(route);
            return;
        }
        for(int i = 0; i<tickets.length; i++){
            String tickStart = tickets[i][0];
            String tickEnd = tickets[i][1];
            if(!visited[i] && end.equals(tickStart)){
                visited[i] = true;
                dfs(tickets, tickEnd, cnt+1);
                visited[i] = false;
                route = route.substring(0, route.length()-4);
            }
        }
    }

}
