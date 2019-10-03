package dec26;//DEC26

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class Client {
static HashMap<String,HashMap<String,Integer>>  rgraph=new HashMap<>();
static HashMap<String,HashMap<String,Integer>>  lgraph=new HashMap<>();
static HashMap<String,Integer> lgraphlevels= new HashMap<>();
static HashMap<String, Boolean> processed=new HashMap<>();

	public static void main(String[] args) {
		rgraph=new HashMap<>();
		lgraph= new HashMap<>();
		
		rgraph.put("S", new HashMap<>());
		rgraph.put("A", new HashMap<>());
		rgraph.put("B", new HashMap<>());
		rgraph.put("C", new HashMap<>());
		rgraph.put("D", new HashMap<>());
		rgraph.put("T", new HashMap<>());
		
		
		rgraph.get("S").put("A",10);
		rgraph.get("A").put("S", 0);
		

		rgraph.get("S").put("B",8);
		rgraph.get("B").put("S", 0);
		

		rgraph.get("C").put("A",0);
		rgraph.get("A").put("C", 8);
		

		rgraph.get("B").put("D",7);
		rgraph.get("D").put("B", 0);
		

		rgraph.get("B").put("C",6);
		rgraph.get("C").put("B", 0);
		

		rgraph.get("C").put("T",10);
		rgraph.get("T").put("C", 0);
		

		rgraph.get("D").put("T",10);
		rgraph.get("T").put("D", 0);
		
	int oflow=0;
	
	while(true)
	{
		lgraph= new HashMap<>();
		lgraphlevels=new HashMap<>();
		boolean hasPath =createlgraphfromrgraph();
		
		if(hasPath==false)
		{
			break;
		}
		
		while(true)
		{
			processed=new HashMap<>();
			int tflow=getFlowPath("S","T",Integer.MAX_VALUE);
			if(tflow!=0)
			{
				oflow+=tflow;
			}else 
			{
				break;
			}
		}
		System.out.println(oflow);
	}
	

	}

	private static int getFlowPath(String string, String string2, int maxValue) {
		// TODO Auto-generated method stub
		return 0;
	}

	private static boolean createlgraphfromrgraph() {
		boolean retval=false;
		LinkedList<dinicpair> queue= new LinkedList<>();
		dinicpair dp=new dinicpair();
		dp.vname="S";
		dp.avname="";
		dp.level=0;
		dp.psf="S";
		queue.addLast(dp);
		
		while(!queue.isEmpty())
		{
			dinicpair rp=queue.removeFirst();
			if(processed.containsKey(rp.vname))
			{
				if(lgraphlevels.get(rp.vname)==rp.level)
				{
					
					lgraph.get(rp.avname).put(rp.vname,0);
				}
			}
			
			ArrayList<String> nbrs=new ArrayList<>(rgraph.get(rp.vname).keySet());
			for(String nbr:nbrs)
			{
				
			}
		}
		
		
		
		return retval;
	}
	private static class dinicpair
	{
		String vname;
		String psf;
		String avname;
		int level;
	}
	
	

}
