package kr.co.uk.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.co.uk.vo.CompanyVO;


@Mapper
public interface CompanyMapper {
	public void insertCompany(String name);
	public Integer selectCompanyByName(String name);
	public List<CompanyVO> selectCompanies();
	public void deleteCompany(Integer seq);
	public void updateCompany(CompanyVO vo);


}
