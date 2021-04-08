package kr.co.uk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.uk.dao.CompanyDao;
import kr.co.uk.vo.CompanyVO;

@Service
public class CompanyServiceImpl implements CompanyService {

	@Autowired
	CompanyDao companyDao;
	
	@Override
	public List<CompanyVO> selectCompanies() {
		// TODO Auto-generated method stub
		return companyDao.selectCompanies();
	}

	@Override
	public boolean insertCompany(String name) {
		Integer result = companyDao.selectCompanyByName(name);
		if(result == 1) {
			return false;
		}
		companyDao.insertCompany(name);
		
		return true;
	}

	@Override
	public void deleteCompany(Integer seq) {
		companyDao.deleteCompany(seq);
	}

	@Override
	public boolean updateCompany(CompanyVO vo) {
		if(vo.getMkb_name() == null || vo.getMkb_name() == "") {
			return false;
		}
		Integer n = companyDao.selectCompanyByName(vo.getMkb_name());
		if(n == 1) {
			return false;
		}
		companyDao.updateCompany(vo);
		return true;
	}

}
