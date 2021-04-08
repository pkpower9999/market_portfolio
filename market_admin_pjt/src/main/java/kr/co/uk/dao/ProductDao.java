package kr.co.uk.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import kr.co.uk.vo.ProductVO;
import kr.co.uk.vo.SearchVO;

@Repository
public interface ProductDao {
	public void insertProduct(ProductVO vo);

	public List<ProductVO> selectProducts(SearchVO vo);
	public void deleteProduct(Integer seq);
	public ProductVO selectProductBySeq(Integer seq);
	public void updateProduct(ProductVO vo);
}
