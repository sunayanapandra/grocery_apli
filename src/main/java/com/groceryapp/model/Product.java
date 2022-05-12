package com.groceryapp.model;


	
	import javax.persistence.Column;
	import javax.persistence.Entity;
	import javax.persistence.GeneratedValue;
	import javax.persistence.GenerationType;
	import javax.persistence.Id;

	import lombok.AllArgsConstructor;
	import lombok.Data;
	import lombok.NoArgsConstructor;
	import lombok.ToString;
	@Data
	@ToString
	@NoArgsConstructor
	@AllArgsConstructor

	@Entity(name="grocery_products")
		
		public class Product {
			
			
			
			
			
			@Id
			@GeneratedValue(strategy = GenerationType.IDENTITY) //AutoIncrement
			@Column(name="id")
			private Integer id;
			
			@Column(name="name")
			private String name;
			
			@Column(name = "brand")
			private String brand;
			
			@Column(name = "category")
			private String category;
			
			@Column(name = "price")
			private Integer price;
			
			@Column(name = "image")
			private String image;

			
		}







