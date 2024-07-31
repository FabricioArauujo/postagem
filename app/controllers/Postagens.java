package controllers;

import java.util.List;

import org.hibernate.query.criteria.internal.Renderable;

import models.Postagem;
import play.mvc.Controller;

public class Postagens extends Controller{
	
	public static void salvar(Postagem postagem) {
		postagem.titulo = postagem.titulo.toUpperCase();
		postagem.conteudo = postagem.conteudo.toUpperCase();
		postagem.autor = postagem.autor.toUpperCase();
		postagem.data = postagem.data;
		
		postagem.save();
		
		listar();
	}
	
	public static void listar() {
		List<Postagem> postagem = Postagem.findAll();
		render(postagem);
	}
	
	public static void form() {
		render();
	}
	
	public static void remover(long id) {
		Postagem postagem = Postagem.findById(id);
		postagem.delete();
		
		listar();
	}
}
