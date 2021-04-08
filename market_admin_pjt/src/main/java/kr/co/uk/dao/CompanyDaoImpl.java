package kr.co.uk.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.uk.mapper.CompanyMapper;
import kr.co.uk.vo.CompanyVO;

@Repository
public class CompanyDaoImpl implements CompanyDao {
	
	@Autowired
	CompanyMapper companyMapper;

	@Override
	public List<CompanyVO> selectCompanies() {

		return companyMapper.selectCompanies();
	}

	@Override
	public void insertCompany(String name) {
		companyMapper.insertCompany(name);
	}

	@Override
	public Integer selectCompanyByName(String name) {
		return companyMapper.selectCompanyByName(name);
	}

	@Override
	public void deleteCompany(Integer seq) {
		companyMapper.deleteCompany(seq);
	}

	@Override
	public void updateCompany(CompanyVO vo) {
		companyMapper.updateCompany(vo);
	}

}
