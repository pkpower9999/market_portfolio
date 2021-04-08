package kr.co.uk.mapper;

import org.apache.ibatis.annotations.Mapper;

import kr.co.uk.vo.ProductImageVO;


@Mapper
public interface ProductImageMapper {
	public void insertProductImage(ProductImageVO vo);
	public ProductImageVO selectProductImage(String uri);
	public String selectProductImageURI(Integer seq);
	public String selectProductImageName(Integer seq);
}
