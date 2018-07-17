package egovframework.example.dataTable.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

import javax.annotation.Resource;
import javax.servlet.ServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import egovframework.example.dataTable.service.DataTableService;

@Controller
public class DataTableController {
	@Resource(name = "dataTableService")
	private DataTableService dataTableService;
			
			
	@RequestMapping("/dataTable.do")
	 public String dataTable() throws Exception {
		 
		  
		  return "dataTable/list";
	 }
	
	@RequestMapping("/ajax.do")
	 public @ResponseBody Map<String, Object> ajax(ServletRequest req) throws Exception {
		//검색 반환을 위한
		Map<String, Object> mapReturn = new HashMap<String, Object>();
		//데이터 검색을 위한
		Map<String, Object> mapSearch = new HashMap<String, Object>();
		//검색 결과 보관을 위한
		List listData=new ArrayList();
		
		
		
		
		
		//컬럼명 수집
		List<String>listColumns=new ArrayList<String>();
		
		List<String> lisSerchable=new ArrayList<String>();
		for(int i=0; ;i++){
			String colName=req.getParameter("columns["+i+"][data]");
			if(colName!=null && colName.length() > 0){
				listColumns.add(colName);
			}else{
				break;
			}
			String colSearchable =req.getParameter("columns["+i+"][searchable]");
			if("true".equalsIgnoreCase(colSearchable)){
				lisSerchable.add(colName);
			}
		}
		//기타 데이터수집
		String sDraw=req.getParameter("draw");
		String sLength=req.getParameter("length");
		String sStart=req.getParameter("start");
		String sTable=req.getParameter("table");
		String sOrderColumn=req.getParameter("order[0][column]");
		String sOrderDir=req.getParameter("order[0][dir]");
		String sSearch=req.getParameter("search[value]");
		
		String dateColumn=req.getParameter("dateColumn");
		String dateStart=req.getParameter("dateStart");
		String dateEnd=req.getParameter("dateEnd");
		int nStart=0;
		int nLength=10;
		try{
			nStart=Integer.parseInt(sStart);
		}catch(NumberFormatException e){}
		try{
			nLength=Integer.parseInt(sLength);
		}catch(NumberFormatException e){}
		//검색컬럼명
		int nOrderColumn=0;
		String sOrderColumnName=null;
		try{
			nOrderColumn=Integer.parseInt(sOrderColumn);
		}catch(NumberFormatException e){
			nOrderColumn=0;
		}
		if(nOrderColumn>=0 && nOrderColumn<listColumns.size()){
			sOrderColumnName=listColumns.get(nOrderColumn);
		}
		//검색 데이터 구성
		mapSearch.put("sTable", sTable);
		mapSearch.put("nStart", nStart);
		mapSearch.put("nLength", nLength);
		mapSearch.put("sSearch", sSearch);
		mapSearch.put("sOrderDir", sOrderDir);
		mapSearch.put("sOrderColumnName", sOrderColumnName);
		mapSearch.put("listColumns", listColumns);
		mapSearch.put("lisSerchable", lisSerchable);
		
		mapSearch.put("dateColumn", dateColumn);
		mapSearch.put("dateStart", dateStart);
		mapSearch.put("dateEnd", dateEnd);
		
		listData=dataTableService.ajax(mapSearch);
		
		int nRecordTotal=dataTableService.ajaxTotCnt(mapSearch);
		
		//데이터 검색처리
		
		//전체 데이터 갯수 처리
		
		//임시 파라미터 출력확인
		dispParams(req);
		//반환데이터 구성
		
		
		mapReturn.put("draw", sDraw);
		mapReturn.put("recordsTotal", nRecordTotal);
		mapReturn.put("recordsFiltered", nRecordTotal);
		mapReturn.put("data",listData );
		
			
		 
		  return mapReturn;
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


