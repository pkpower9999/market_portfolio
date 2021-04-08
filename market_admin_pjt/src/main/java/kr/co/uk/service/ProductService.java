package kr.co.uk.service;

import java.util.List;

import org.springframework.stereotype.Service;

import kr.co.uk.vo.ProductVO;
import kr.co.uk.vo.SearchVO;



@Service
public interface ProductService {

	public void insertProduct(ProductVO vo);
	public List<ProductVO> selectProducts(SearchVO vo);
	public void deleteProduct(Integer seq);
	public void updateProduct(ProductVO vo);
	public ProductVO selectProductBySeq(Integer seq);

}
