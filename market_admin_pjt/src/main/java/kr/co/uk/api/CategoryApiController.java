package kr.co.uk.api;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kr.co.uk.service.CategoryService;
import kr.co.uk.vo.CategoryVO;


@RestController
public class CategoryApiController {
	
	@Autowired
	CategoryService cateService;
	
	
	
	
	@GetMapping("/category_list")
	public List<CategoryVO> getCategory() {
		return cateService.selectCategories();
	}
	
	@GetMapping("/api/insert_category")
	public Map<String, String> getInsertCategory(@RequestParam String name) {
		Map<String, String> resultMap = new LinkedHashMap<String, String>();
		boolean result = cateService.insertCategory(name);
		if(result) {
			resultMap.put("status", "success");
			resultMap.put("message", "추가되었습니다.");
		}
		else {
			resultMap.put("status", "failed");
			resultMap.put("message", "["+name+"]은/는 이미 존재합니다.");
		}
		
		return resultMap;
	}
	
	@DeleteMapping("/category")
	public Map<String, String> deleteCategory(@RequestParam Integer seq) {
		Map<String, String> resultMap = new LinkedHashMap<String, String>();
		cateService.deleteCategory(seq);
		resultMap.put("status", "success");
		resultMap.put("message", "삭제되었습니다.");
		return resultMap;
	}
	
	@PatchMapping("/category/{seq}")
	public Map<String, String> patchCategory(@PathVariable Integer seq, @RequestParam String name) {
		Map<String, String> resultMap = new LinkedHashMap<String, String>();
		CategoryVO vo = new CategoryVO();
		vo.setMkpc_seq(seq);
		vo.setMkpc_name(name);
		boolean updateStatus = cateService.updateCategory(vo);
		
		if(updateStatus) {
			resultMap.put("status", "success");
			resultMap.put("message", "변경되었습니다.");
		}
		else {
			resultMap.put("status", "failed");
			resultMap.put("message", "카테고리 이름이 중복됩니다.");
		}
		
		return resultMap;
	}
	
}
