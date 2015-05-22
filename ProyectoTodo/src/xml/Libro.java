//package org.microforum.cursojava;
package xml;



public class Libro {
	   private String isbn = null;  
	   private String titulo = null;  
	   private String autor = null;  
	   private String anyo = null;  
	   private String editorial = null;  
	   
	   
	   
	   // Constructor por defecto 
	   public Libro() {
			// TODO Auto-generated constructor stub
		}
	   public Libro(String isbn, String titulo, String autor, String anyo, String editorial) {  
	        this.isbn = isbn;
	        this.titulo = titulo;
	        this.autor = autor;
	        this.anyo = anyo;
	        this.editorial = editorial;
	   }  
	    

	public String getIsbn() {  
	      return isbn;  
	   }  
	     
	   public void setIsbn(String isbn) {  
	      this.isbn = isbn;  
	   }  
	     
	   public String getTitulo() {  
	      return titulo;  
	   }  
	     
	   public void setTitulo(String titulo) {  
	      this.titulo = titulo;  
	   }  
	     
	   public String getAutor() {  
	      return autor;  
	   }  
	     
	   public void setAutor(String autor) {  
	      this.autor = autor;  
	   }  
	     
	   public String getAnyo() {  
	      return anyo;  
	   }  
	     
	   public void setAnyo(String anyo) {  
	      this.anyo = anyo;  
	   }  
	     
	   public String getEditorial() {  
	      return editorial;  
	   }  
	     
	   public void setEditorial(String editorial) {  
	      this.editorial = editorial;  
	   }  
	  
	   @Override  
	   public String toString() {  
	      StringBuilder sb = new StringBuilder(); //tipo de String más rápido en añadir!
	     // sb.append("\n");
	      sb.append("\nISBN: "+isbn);  
	      sb.append("\nTítulo: "+titulo);  
	      sb.append("\nAutor: "+autor);  
	      sb.append("\nAño: "+anyo);  
	      sb.append("\nEditorial: "+editorial);  
	        
	      return sb.toString();  
	   }  
	     
	     
	  
	}  
