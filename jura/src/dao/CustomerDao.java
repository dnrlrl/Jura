package dao;

import java.io.Reader;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import model.Customer;

public class CustomerDao {
	private static CustomerDao instance=new CustomerDao();
	private CustomerDao() {}
	public static CustomerDao getInstance() {
		return instance;
	}
	private static SqlSession session;
	static { // 클래스 변수 초기화 블럭
		try {
			Reader reader =Resources.getResourceAsReader("configuration.xml");
			SqlSessionFactory ssf=new SqlSessionFactoryBuilder().build(reader);
			session = ssf.openSession(true);
		}catch (Exception e) {
			System.out.println("초기화 에러 : "+e.getMessage());
		}
	}
	public int insert(Customer customer) {
		int result=session.insert("customerns.insert",customer);
		return result;
	}
	public int loginChk(String id, String pass) {
		int result=0;
		Customer customer =select(id);
		if(customer == null )result = -1;
		else if(customer.getC_pass().equals(pass)) {
			result = 1; // 암호, 아이디 일치
		}
		return result;
	}
	public Customer select(String id) {
		Customer customer =(Customer)
				session.selectOne("customerns.select",id);
		return customer;
	}public int update(Customer customer) {
		return (int)session.update("customerns.update",customer);
	}
	public List<Customer> clist() {
		return session.selectList("customerns.clist");
	}
	public int addnum(String id) {
		return (int) session.selectOne("customerns.selectadd",id);
	}
	public String getAdd(String c_id) {
		return (String)session.selectOne("customerns.getadd",c_id);
	}
	public int checkid(String id) {
		return (int) session.selectOne("customerns.selectid",id);
	}
	public String pscheck(String id) {
		return (String)session.selectOne("customerns.pscheck",id);
	}
	public int delete(String id) {
		return (int) session.update("customerns.deleteid",id);
	}
	public String checkDelete(String id) {
		return (String)session.selectOne("customerns.deletecheck",id);
	}
	/* 페이지 나눔 적용할 때 사용할 list
	 * public List<Customer> list(int startRow, int endRow) { HashMap<String,
	 * Integer> hm = new HashMap<String, Integer>(); hm.put("startRow", startRow);
	 * hm.put("endRow", endRow); return session.selectList("customerns.list",hm); }
	 */

}
