package kr.co.uk.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.co.uk.vo.ProductVO;
import kr.co.uk.vo.SearchVO;



@Mapper
public interface ProductMapper {
	public void insertProduct(ProductVO vo);
	public List<ProductVO> selectProducts(SearchVO vo);
	public void deleteProduct(Integer seq);
	public ProductVO selectProductBySeq(Integer seq);
	public void updateProduct(ProductVO vo);

	
}
