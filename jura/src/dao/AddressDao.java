package dao;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import model.Address;

public class AddressDao {
	private static AddressDao instance = new AddressDao();
	private AddressDao( ) {}
	public static AddressDao getInstance() {
		return instance;
	}
	private static SqlSession session;
	static {
		try {
			Reader reader =Resources.getResourceAsReader("configuration.xml");
			SqlSessionFactory ssf=new SqlSessionFactoryBuilder().build(reader);
			session = ssf.openSession(true);
		}catch (Exception e) {
			System.out.println("초기화 에러 : "+e.getMessage());
		}
	}
	public String address(int anum) {
		return (String)session.selectOne("addressns.addsel",anum);
	}
	
}
