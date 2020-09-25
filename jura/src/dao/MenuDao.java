package dao;

import java.io.Reader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import model.Menu;

public class MenuDao{
	private static MenuDao instance=new MenuDao();
	private MenuDao() {}
	public static MenuDao getInstance() {
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
	public List<Menu> list(String s_id) {
		List<Menu> list = null;
		try {
			list = session.selectList("menuns.list",s_id);
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return list;
	}
	public int insert(Menu menu) {
		return (int)session.insert("menuns.insert", menu);
	}
	public int update(Menu menu) {
		return (int)session.update("menuns.update", menu);
	}
	public int delete(int m_num) {
		return (int)session.delete("menuns.delete", m_num);
	}
	public String mname_select(int m_num) {
		// TODO Auto-generated method stub
		return (String)session.selectOne("menuns.selectname",m_num);
	}
	public int getRecMenu(String sid) {
		return (int)session.selectOne("menuns.getrecmenu",sid);
	}
	public Menu getRecMenuinfo(int menuNum) {
		return (Menu) session.selectOne("menuns.getrecmenuinfo",menuNum);
	}
	public int deleteRecMenu(int recnum) {
		return (int)session.update("menuns.deleterec", recnum);
	}
	public int mgetRecMenu(String s_id) {
		return (int)session.selectOne("menuns.mgetrecmenu",s_id);
	}
	public int updateRec(int m_num) {
		return (int)session.update("menuns.updaterec",m_num);
	}
	public String getImg(int m_num) {
		return (String) session.selectOne("menuns.getImg", m_num);
	}
	public int mgetRecCount(String s_id) {
		return (int)session.selectOne("menuns.mgetreccount",s_id);
	}


}
