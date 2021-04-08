package kr.co.uk.service;

import java.util.List;

import org.springframework.stereotype.Service;

import kr.co.uk.vo.CategoryVO;


@Service
public interface CategoryService {
	public List<CategoryVO> selectCategories();
	public boolean insertCategory(String name);
	public void deleteCategory(Integer seq);
	public boolean updateCategory(CategoryVO vo);
}
