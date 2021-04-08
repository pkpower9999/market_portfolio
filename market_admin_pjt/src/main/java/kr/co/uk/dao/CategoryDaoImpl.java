package kr.co.uk.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.uk.mapper.CategoryMapper;
import kr.co.uk.vo.CategoryVO;

@Repository
public class CategoryDaoImpl implements CategoryDao {
	@Autowired
	CategoryMapper cateMapper;
	
	@Override
	public List<CategoryVO> selectCategories() {
		
		
		return cateMapper.selectCategories();
	}

	@Override
	public void insertCategory(String name) {
		cateMapper.insertCategory(name);
	}
	@Override
	public Integer selectCategoryByName(String name) {
		// TODO Auto-generated method stub
		return cateMapper.selectCategoryByName(name);
	}
	@Override
	public void deleteCategory(Integer seq) {
		// TODO Auto-generated method stub
		cateMapper.deleteCategory(seq);
	}
	@Override
	public void updateCategory(CategoryVO vo) {
		// TODO Auto-generated method stub
		cateMapper.updateCategory(vo);
	}
}
