package kr.co.uk.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import kr.co.uk.vo.CategoryVO;

@Repository
public interface CategoryDao {
	public void insertCategory(String name);

	public List<CategoryVO> selectCategories();
	public Integer selectCategoryByName(String name);
	public void deleteCategory(Integer seq);
	public void updateCategory(CategoryVO vo);
}
