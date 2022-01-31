package org.iesalixar.servidor.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.iesalixar.servidor.model.Post;
import org.iesalixar.servidor.model.User;
import org.iesalixar.servidor.utils.dao.GenericDAOImpl;

public class PostDAOImpl extends GenericDAOImpl<Post> implements PostDAO {

	private Session session;
	
	public PostDAOImpl(Session session) {
		super(session);
		this.session = session;
	}

	@Override
	public List<Post> searchTitleByUser(Long userId) {
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}
		
		List<Post> postList = new ArrayList<>();
		
		if (userId!=null) {
			postList = session.createQuery("FROM Post p INNER JOIN User u ON p.userP=postU WHERE u.id= p.id:=u.id")
					.setParameter("user", userId).list();
		}
		
		return postList;
	}

}
