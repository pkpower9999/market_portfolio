package kr.co.uk.service;

import java.util.List;

import org.springframework.stereotype.Service;

import kr.co.uk.vo.CompanyVO;

@Service
public interface CompanyService {
	public boolean insertCompany(String name);

	public List<CompanyVO> selectCompanies();
	public void deleteCompany(Integer seq);
	public boolean updateCompany(CompanyVO vo);

}
