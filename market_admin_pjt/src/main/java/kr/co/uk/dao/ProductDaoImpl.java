package kr.co.uk.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import kr.co.uk.mapper.ProductMapper;
import kr.co.uk.vo.ProductVO;
import kr.co.uk.vo.SearchVO;

@Repository
@Primary
public class ProductDaoImpl implements ProductDao{

	@Autowired
	ProductMapper mapper;
	
	@Override
	public void insertProduct(ProductVO vo) {
		mapper.insertProduct(vo);
	}

	@Override
	public List<ProductVO> selectProducts(SearchVO vo) {
		return mapper.selectProducts(vo);
	}

	@Override
	public void deleteProduct(Integer seq) {
		mapper.deleteProduct(seq);
	}

	@Override
	public ProductVO selectProductBySeq(Integer seq) {
		return mapper.selectProductBySeq(seq);
	}

	@Override
	public void updateProduct(ProductVO vo) {
		mapper.updateProduct(vo);
	}
}
