package org.iesalixar.servidor.services;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.iesalixar.servidor.dao.PostDAO;
import org.iesalixar.servidor.dao.PostDAOImpl;
import org.iesalixar.servidor.model.Post;

public class PostServiceImpl implements PostService {

	private PostDAO postDAO;
	
	public PostServiceImpl (final Session session) {
		this.postDAO = new PostDAOImpl(session);
	}

	@Override
	public void insertNewPost(Post post) {
		if (post != null && post.getId() == null) {
			postDAO.insert(post);
		}			
	}

	@Override
	public void updatePost(Post post) {
		if (post != null && post.getId() != null) {
			postDAO.update(post);
		}
	}

	@Override
	public void deletePost(Post post) {
		if (post != null && post.getId() != null) {
			postDAO.delete(post);
		}
	}

	@Override
	public Post searchById(Long postId) {
		Post posts = null;
		if (postId != null) {
			posts = postDAO.searchById(postId);
		}
		return posts;
	}

	@Override
	public List<Post> searchAll() {
		List<Post> postsList = new ArrayList<Post>();
		postsList = postDAO.searchAll();
		return postsList;
	}

	@Override
	public List<Post> searchTitleByUser(String name) {
//		List<Post> postsList = new ArrayList<Post>();
//		if (name!=null) {
//			postsList = postDAO.searchTitleByUser(name);
//		}
		return null;
	}
	
}
