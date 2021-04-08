package kr.co.uk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.uk.dao.ProductDao;
import kr.co.uk.mapper.ProductImageMapper;
import kr.co.uk.vo.ProductVO;
import kr.co.uk.vo.SearchVO;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductDao prodDao;
	
	@Autowired
	ProductImageMapper imageMapper;
	
	@Override
	public void insertProduct(ProductVO vo) {
		prodDao.insertProduct(vo);
	}

	@Override
	public List<ProductVO> selectProducts(SearchVO vo) {
		// TODO Auto-generated method stub
		List<ProductVO> list = prodDao.selectProducts(vo);

		String prefix="/product_img/";
		list.forEach(item -> {
			 String uri = imageMapper.selectProductImageURI(item.getMkp_seq());
			 if(uri != null) {
				 item.setImage_uri(prefix+uri);
			 }
		});
		//화면에 이미지 표시,썸네일처리 
		return list;
		
	}

	@Override
	public void deleteProduct(Integer seq) {
		prodDao.deleteProduct(seq);
	}

	@Override
	public void updateProduct(ProductVO vo) {
		prodDao.updateProduct(vo);
	}

	@Override
	public ProductVO selectProductBySeq(Integer seq) {
		String imageName = imageMapper.selectProductImageName(seq);
		ProductVO vo = prodDao.selectProductBySeq(seq);
		vo.setImage_name(imageName);
		return vo;
	}
}
