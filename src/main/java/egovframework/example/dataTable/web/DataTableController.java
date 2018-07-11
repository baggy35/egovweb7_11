package egovframework.example.dataTable.web;

import java.util.HashMap;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

import javax.servlet.ServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DataTableController {
	@RequestMapping("/dataTable.do")
	 public String dataTable() throws Exception {
		 
		  
		  return "dataTable/list";
	 }
	
	@RequestMapping("/ajax.do")
	 public @ResponseBody Map<String, Object> ajax(ServletRequest req) throws Exception {
		dispParams(req);
		  Map map = new HashMap<String, Object>();
		  
		  map.put("AA", "1");
		  map.put("BB", "2");
		  map.put("CC", "3");
		  map.put("DD", "4");
		  return map;
	 }
	
	private void dispParams(ServletRequest req)
	{
		Map<String, String[]> map = req.getParameterMap();
		SortedSet<String> set = new TreeSet<String>();
		set.addAll(map.keySet());
		
		for(String key : set)
		{
			String[] values = map.get(key);
			System.out.print(key);
			System.out.print(" : ");
			for(String value : values)
			{
				if (value != null)
				{
					System.out.print(value);
					System.out.print(",");
				}
			}
			System.out.println();
		}
	}
}


