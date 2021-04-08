package kr.co.uk.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import kr.co.uk.vo.CompanyVO;


@Repository
public interface CompanyDao {
	public void insertCompany(String name);
	public Integer selectCompanyByName(String name);
	public List<CompanyVO> selectCompanies();
	public void deleteCompany(Integer seq);
	public void updateCompany(CompanyVO vo);
}
