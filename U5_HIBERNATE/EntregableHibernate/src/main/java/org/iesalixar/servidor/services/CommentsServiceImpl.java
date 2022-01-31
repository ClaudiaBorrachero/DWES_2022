package org.iesalixar.servidor.services;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.iesalixar.servidor.dao.CommentsDAO;
import org.iesalixar.servidor.dao.CommentsDAOImpl;
import org.iesalixar.servidor.model.Comments;

public class CommentsServiceImpl implements CommentsService{

	private CommentsDAO commentsDAO;
	
	public CommentsServiceImpl (final Session session) {
		this.commentsDAO = new CommentsDAOImpl(session);
	}
	
	@Override
	public void insertNewComment(Comments comment) {
		if (comment != null && comment.getId() == null) {
			commentsDAO.insert(comment);
		}	
	}

	@Override
	public void updateComment(Comments comment) {
		if (comment != null && comment.getId() != null) {
			commentsDAO.update(comment);
		}
	}

	@Override
	public void deleteComment(Comments comment) {
		if (comment != null && comment.getId() != null) {
			commentsDAO.delete(comment);
		}
	}

	@Override
	public Comments searchById(Long commentId) {
		Comments comment = null;
		if (commentId != null) {
			comment = commentsDAO.searchById(commentId);
		}
		return comment;
	}

	@Override
	public List<Comments> searchAll() {
		List<Comments> commentsList = new ArrayList<Comments>();
		commentsList = commentsDAO.searchAll();
		return commentsList;
	}

	@Override
	public List<Comments> searchByWord(String name) {
		List<Comments> commentsList = new ArrayList<Comments>();
		if (name!=null) {
			commentsList = commentsDAO.searchByWord(name);
		}
		return commentsList;
	}

}
