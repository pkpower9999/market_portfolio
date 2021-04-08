package kr.co.uk.api;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import kr.co.uk.service.ProductImageService;
import kr.co.uk.service.ProductService;
import kr.co.uk.vo.ProductVO;


@RestController
public class ProductApiController {

	@Autowired
	ProductService prodService;
	
	@Autowired
	ProductImageService imageService;
	
	@PutMapping("/product")
	public Map<String, String> putProduct(@RequestBody ProductVO vo) {
		Map<String, String> resultMap = new LinkedHashMap<String, String>();
		
		prodService.insertProduct(vo);
		resultMap.put("status", "success");
		resultMap.put("prod_seq", vo.getMkp_seq().toString());
		return resultMap;
	}
	
	@PutMapping("/product_img/{seq}")
	public Map<String, String> putProductImage(
			@RequestPart MultipartFile file,
			@PathVariable Integer seq,
			@RequestParam String brand,
			@RequestParam String name
		) throws Exception {
		
		if(file.getOriginalFilename() == "") {
			return null;
		}
		
		ProductVO vo = new ProductVO();
		vo.setMkp_name(name);
		vo.setMkp_seq(seq);
		vo.setBrand_name(brand);
		
		return imageService.insertProductImage(file, vo);
	}
	
	@GetMapping("/product_img/{fileName}")
	public ResponseEntity<Resource> getProductImage(@PathVariable String fileName, HttpServletRequest request) throws Exception {
		Resource resource = imageService.getProductImage(fileName);
		
		String contentType = null;
		contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
		if(contentType == null) {
			contentType = "application/octet-stream";
		}
		
		return ResponseEntity.ok()
				.contentType(MediaType.parseMediaType(contentType))
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename*=\""+resource.getFilename()+"\"")
				.body(resource);
	}
	
	@DeleteMapping("/product/{seq}")
	public Map<String, String> deleteProduct(@PathVariable Integer seq) {
		Map<String, String> resultMap = new LinkedHashMap<String, String>();
		
		resultMap.put("status", "success");
		resultMap.put("message", "삭제되었습니다.");
		
		prodService.deleteProduct(seq);
		
		return resultMap;
	}
	
	@GetMapping("/product/{seq}")
	public Map<String, Object> getProduct(@PathVariable Integer seq) {
		Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
		ProductVO vo = prodService.selectProductBySeq(seq);
		if(vo != null) {
			resultMap.put("status", "success");
			resultMap.put("product", vo);
		}
		else {
			resultMap.put("status", "failed");
			resultMap.put("reason", seq+"번 데이터는 존재하지 않습니다.");
		}
		return resultMap;
	}
	
	@PatchMapping("/product")
	public Map<String, String> patchProduct(@RequestBody ProductVO vo) {
		Map<String, String> resultMap = new LinkedHashMap<String, String>();
		
		prodService.updateProduct(vo);
		
		resultMap.put("status", "success");
		resultMap.put("message", "수정되었습니다.");
		
		return resultMap;
	}
	
	
	
}
