package dao;

import java.io.Reader;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import model.Orders;

public class OrdersDao {
	private static OrdersDao instance=new OrdersDao();
	private OrdersDao() {}
	public static OrdersDao getInstance() {
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
	public int insert(Orders or) {
		return (int)session.insert("ordersns.insert",or);
	}
	public int maxid() {
		return (int)session.selectOne("ordersns.findmax");
	}
	public int ckdata() {
		return (int)session.selectOne("ordersns.checkdata");
	}
	public List<Orders> getCusOrd(String id) {
		return session.selectList("ordersns.getcusord",id);
	}
	public int orderUpdate(Orders orders) {
		return (int)session.update("ordersns.orderupdate",orders);
		
	}
	public int maxid(int ordernum) {
		return (int)session.selectOne("ordersns.findmax");
		
	}
	public List<Orders> ouplist() {
		return session.selectList("orderns.oderuplist");
	}
	public int cancelorder2(int onum) {
		return (int)session.delete("ordersns.ordercancel2",onum);
		
	}
	public int nullselect() {
		return (int)session.delete("ordersns.nullselect");
	}
}
