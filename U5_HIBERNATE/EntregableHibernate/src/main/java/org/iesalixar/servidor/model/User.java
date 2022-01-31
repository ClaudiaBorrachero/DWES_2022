package org.iesalixar.servidor.model;

import java.io.Serializable;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User implements Serializable{

	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name="userName",unique=true,nullable=false)
	private String userName;
	
	@Column(name="password",nullable=false)
	private String password;
	
	@Column(name="firstName",nullable=false)
	private String firstName;
	
	@Column(name="lastName",nullable=false)
	private String lastName;
	
	@Column(name="email",unique=true,nullable=false)
	private String email;
	
	@OneToMany(mappedBy="user", cascade = CascadeType.ALL,
			orphanRemoval = true)
	private Set<Valorar> valoraciones = new HashSet<>();
	
	@OneToMany(mappedBy="userC", cascade = CascadeType.ALL,
			orphanRemoval = true)
	private Set<Comments> comentarios = new HashSet<>();
	
	@OneToMany(mappedBy="userP", cascade = CascadeType.ALL,
			orphanRemoval = true)
	private Set<Post> posts = new HashSet<>();

	public User() {
	}

	public Long getId() {
		return id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	

	public Set<Valorar> getValoraciones() {
		return valoraciones;
	}

	public void setValoraciones(Set<Valorar> valoraciones) {
		this.valoraciones = valoraciones;
	}
	
	

	public Set<Comments> getComentarios() {
		return comentarios;
	}

	public void setComentarios(Set<Comments> comentarios) {
		this.comentarios = comentarios;
	}
	
	

	public Set<Post> getPosts() {
		return posts;
	}

	public void setPosts(Set<Post> posts) {
		this.posts = posts;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", password=" + password + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", email=" + email + "]";
	}
	
	//HELPERS VALORACION (USER-POST)
	public void addValoracion(Post post, Integer puntuacion) {
		Valorar valorar = new Valorar(this,post,puntuacion);
		this.valoraciones.add(valorar);
		post.getValoraciones().add(valorar);
	}
	
	public void removeValoracion(Post post) {
		Valorar valorar = new Valorar(this,post);
		this.valoraciones.remove(valorar);
		post.getValoraciones().remove(valorar);
	}
	
	//HELPERS ESCRIBIR COMENTARIO(USER-COMMENTS)
	public void addComentario(Comments comment) {
		this.comentarios.add(comment);
		comment.setUserC(this);
	}
	
	public void removeComentario(Comments comment) {
		this.comentarios.remove(comment);
		comment.setUserC(null);
	}
	
	//HELPERS AÑADIR POST(USER-POST)
	public void addPost(Post post) {
		this.posts.add(post);
		post.setUserP(this);
	}
	
	public void removePost(Post post) {
		this.posts.remove(post);
		post.setUserP(null);
	}
	
}
