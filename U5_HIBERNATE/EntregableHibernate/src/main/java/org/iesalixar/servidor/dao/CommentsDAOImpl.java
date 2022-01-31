package org.iesalixar.servidor.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.iesalixar.servidor.model.Comments;
import org.iesalixar.servidor.utils.dao.GenericDAOImpl;

public class CommentsDAOImpl extends GenericDAOImpl<Comments> implements CommentsDAO {

	private Session session;
	
	public CommentsDAOImpl(Session session) {
		super(session);
		this.session = session;
	}

	@Override
	public List<Comments> searchByWord(String word) {
	
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}
		
		List<Comments> commentsList = new ArrayList<>();
		
		if (word!=null) {
			commentsList = session.createQuery("FROM Comments WHERE word LIKE %word%")
					.setParameter("word", word).list();
		}
		
		return commentsList;
	}

	
}
