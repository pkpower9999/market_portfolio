package kr.co.uk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.uk.dao.CategoryDao;
import kr.co.uk.vo.CategoryVO;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	CategoryDao cateDao;
	
	@Override
	public List<CategoryVO> selectCategories() {
		// TODO Auto-generated method stub
		return cateDao.selectCategories();
	}

	@Override
	public boolean insertCategory(String name) {
		Integer result = cateDao.selectCategoryByName(name);
		if(result == 1) {
			return false;
		}
		cateDao.insertCategory(name);
		
		return true;
		
	}
	
	public void deleteCategory(Integer seq) {
		cateDao.deleteCategory(seq);
	}
	
	public boolean updateCategory(CategoryVO vo) {
		if(vo.getMkpc_name() == null || vo.getMkpc_name() == "") {
			return false;
		}
		Integer n = cateDao.selectCategoryByName(vo.getMkpc_name());
		if(n == 1) {
			return false;
		}
		cateDao.updateCategory(vo);
		return true;
	}

}
