package dao;

import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import model.Order_list;


public class OrderListDao{
	private static OrderListDao instance= new OrderListDao();
	private OrderListDao() {}
	public static OrderListDao getInstancee() {
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
	public int insert(Order_list oli) {
		return (int)session.insert("orderlistns.insert",oli);
		
	}
	public List<Order_list> olist(int o_num) {
		return session.selectList("orderlistns.olist",o_num);
	}
	public Order_list juraoli(int ordernum, int count, int odprice) {
		HashMap<String, Integer> hash=new HashMap<String, Integer>();
		hash.put("ordernum", ordernum);
		hash.put("count", count);
		hash.put("odprice", odprice);
		return (Order_list) session.selectOne("orderlistns.juraoli",hash);
	}
	public int cancelorder(int onum) {
		return session.delete("orderlistns.ordercancel",onum);
	}
	public int olclean(int o_num) {
		return (int)session.insert("orderlistns.olclean",o_num);
	}
	public List<String> getSid(List<Integer> nlist) {
		return session.selectList("orderlistns.getsid",nlist);
	}
	
}
	
