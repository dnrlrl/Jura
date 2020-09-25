package dao;

import java.io.Reader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import model.Shop;
import model.Simg;

public class ShopDao {
	private static ShopDao instance=new ShopDao();
	private ShopDao() {}
	public static ShopDao getInstance() {
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
	public List<Shop> list(String n_type, int anum){
		HashMap<String,Object> hm=new HashMap<>();
		hm.put("n_type",n_type);
		hm.put("add_nu",anum);
		//return session.selectList("shopns.list",hm);
		//<select id="list" parameter="hasgmap" resultMap=""
		//List<Shop> list=new ArrayList<Shop>();
		//list=(List<Shop>)session.selectList("shopns.list",n_type);
		return session.selectList("shopns.list",hm);
	}
	public List<Shop> slist() {
		return session.selectList("shopns.slist");
	}
	public int insert(Shop shop) {
		int result=session.insert("shopns.insert",shop);
		return result;
	}
	public int update(Shop shop) {
		return (int)session.update("shopns.update",shop);
	}
	public String address(String s_id) {
		return (String) session.selectOne("shopns.addsel",s_id);
	}
	public int delete(int m_num) {
		return (int)session.delete("shopns.delete",m_num);
	}
	public Shop select(String s_id) {
		return (Shop)session.selectOne("shopns.select",s_id);
	}
	public List<Shop> juralist(String jtype, int anum) {
		HashMap<String,Object> hash=new HashMap<>();
		hash.put("j_type", jtype);
		hash.put("add_num", anum);
		return session.selectList("shopns.juralist",hash);
	}
	public List<Shop> alljuralist(int anum) {
		return session.selectList("shopns.alljuralist",anum);
	}
	public List<Shop> getSimg(List<String> slist) {
		return  session.selectList("shopns.getsimg",slist);
	}
	public String getS_img(String id) {
		return (String) session.selectOne("shopns.gets_img",id);
	}
}
