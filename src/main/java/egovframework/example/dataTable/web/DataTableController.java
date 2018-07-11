package egovframework.example.dataTable.web;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DataTableController {
	@RequestMapping("/ajax.do")
	 public @ResponseBody Map<String, Object> ajax() throws Exception {
		  Map map = new HashMap<String, Object>();
		  map.put("AA", "1");
		  map.put("BB", "2");
		  map.put("CC", "3");
		  map.put("DD", "4");
		  return map;
	 }
}
