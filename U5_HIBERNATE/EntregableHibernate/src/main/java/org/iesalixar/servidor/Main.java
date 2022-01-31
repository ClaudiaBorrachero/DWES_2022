package org.iesalixar.servidor;

import java.util.Calendar;

import org.hibernate.Session;
import org.iesalixar.servidor.dao.CommentsDAOImpl;
import org.iesalixar.servidor.dao.UserDAOImpl;
import org.iesalixar.servidor.model.Comments;
import org.iesalixar.servidor.model.Post;
import org.iesalixar.servidor.model.User;
import org.iesalixar.servidor.services.CommentsService;
import org.iesalixar.servidor.services.CommentsServiceImpl;
import org.iesalixar.servidor.services.PostService;
import org.iesalixar.servidor.services.PostServiceImpl;
import org.iesalixar.servidor.services.UserService;
import org.iesalixar.servidor.services.UserServiceImpl;
import org.iesalixar.servidor.utils.HibernateUtils;

public class Main {

	public static void main(String[] args) {

//		//Para trabajar con las fechas
		Calendar calendar = Calendar.getInstance();
		
		// Creo la sesión
		Session session = HibernateUtils.getSessionFactory().openSession();

		// Creo los servicios definidos
		CommentsService commentsService = new CommentsServiceImpl(session);
		PostService postService = new PostServiceImpl(session);
		UserService userService = new UserServiceImpl(session);
		
		//Creo 2 usuarios
		User u1 = new User();
		u1.setUserName("cladussbro");
		u1.setPassword("123");
		u1.setFirstName("Claudia");
		u1.setLastName("Borrachero");
		u1.setEmail("claudiaborrachero@gmail.com");
		User u2 = new User();
		u2.setUserName("cpuyana");
		u2.setPassword("123");
		u2.setFirstName("Carlos");
		u2.setLastName("Puyana");
		u2.setEmail("carlospuyana@gmail.com");
		
		//Persisto los usuarios
		userService.insertNewUser(u1);
		userService.insertNewUser(u2);
		
		//Creo 5 posts
		Post p1 = new Post();
		p1.setTitle("Hola");
		p1.setContent("Saludo");
		calendar.set(Calendar.YEAR, 2017);
		calendar.set(Calendar.MONTH, 5);
		calendar.set(Calendar.DAY_OF_MONTH, 13);
		p1.setDate(calendar.getTime());
		Post p2 = new Post();
		p2.setTitle("2");
		p2.setContent("2");
		calendar.set(Calendar.YEAR, 2018);
		calendar.set(Calendar.MONTH, 5);
		calendar.set(Calendar.DAY_OF_MONTH, 13);
		p2.setDate(calendar.getTime());
		Post p3 = new Post();
		p3.setTitle("3");
		p3.setContent("3");
		calendar.set(Calendar.YEAR, 2019);
		calendar.set(Calendar.MONTH, 5);
		calendar.set(Calendar.DAY_OF_MONTH, 13);
		p3.setDate(calendar.getTime());
		Post p4 = new Post();
		p4.setTitle("4");
		p4.setContent("4");
		calendar.set(Calendar.YEAR, 2020);
		calendar.set(Calendar.MONTH, 5);
		calendar.set(Calendar.DAY_OF_MONTH, 13);
		p4.setDate(calendar.getTime());
		Post p5 = new Post();
		p5.setTitle("5");
		p5.setContent("5");
		calendar.set(Calendar.YEAR, 2021);
		calendar.set(Calendar.MONTH, 5);
		calendar.set(Calendar.DAY_OF_MONTH, 13);
		p5.setDate(calendar.getTime());
				
		//Persisto los posts
		postService.insertNewPost(p1);
		postService.insertNewPost(p2);
		postService.insertNewPost(p3);
		postService.insertNewPost(p4);
		postService.insertNewPost(p5);
				
		//Creo 10 valoraciones
		u1.addValoracion(p1, 1);
		u1.addValoracion(p2, 2);
		u1.addValoracion(p3, 3);
		u1.addValoracion(p4, 4);
		u1.addValoracion(p5, 5);
		u2.addValoracion(p1, 1);
		u2.addValoracion(p2, 2);
		u2.addValoracion(p3, 3);
		u2.addValoracion(p4, 4);
		u2.addValoracion(p5, 5);
		
		userService.updateUser(u1);
		userService.updateUser(u2);
		
		//Añadimos posts a los usuarios y actualizamos
		u1.addPost(p1);
		u2.addPost(p2);
		
		userService.updateUser(u1);
		userService.updateUser(u2);
		
		//Creo comentarios
		Comments c1 = new Comments();
		c1.setTitle("HOLA");
		c1.setContent("Arbol");
		Comments c2 = new Comments();
		c2.setTitle("ADIOS");
		c2.setContent("Tree");
		Comments c3 = new Comments();
		c3.setTitle("Hi");
		c3.setContent("Bye");
		Comments c4 = new Comments();
		c4.setTitle("Hello");
		c4.setContent("Goodbye");
		
		//Persisto los comentarios
		commentsService.insertNewComment(c1);
		commentsService.insertNewComment(c2);
		commentsService.insertNewComment(c3);
		commentsService.insertNewComment(c4);
		
		//Añadimos comentarios a los usuarios
		u1.addComentario(c1);
		u2.addComentario(c2);
		u1.addComentario(c3);
		u2.addComentario(c3);
		u1.addComentario(c4);
		
		userService.updateUser(u1);
		userService.updateUser(u2);
		
		//Borrar comentarios de los usuarios y actualizamos
		u1.removeComentario(c4);
		userService.updateUser(u1);
		
		//Modificar el correo de un usuario
		u2.setEmail("cpuyana@gmail.com");
		userService.updateUser(u2);
		
		//Añadimos comentarios a los posts
		p1.addComentario(c1);
		p2.addComentario(c2);
		p3.addComentario(c1);
		p4.addComentario(c3);
		p5.addComentario(c2);
		p5.addComentario(c4);
			
		//Borrar comentarios de los post y actualizamos
		p5.removeComentario(c4);
		postService.updatePost(p5);
		
		// Buscar un comentario que contenga una palabra determinada
		CommentsDAOImpl daoComments = new CommentsDAOImpl(session);
        daoComments.searchByWord("Hi");

        // Busqueda de todos los usuarios con un usuario o email determinado
        UserDAOImpl daoUser = new UserDAOImpl(session);
        daoUser.searchByEmail("carlos", "cpuyana@gmail.com");
		
		//Cerramos la sesión
		session.close();
		
	}

}

