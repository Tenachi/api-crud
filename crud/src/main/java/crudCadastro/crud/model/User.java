package crudCadastro.crud.model;


import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="user")
public class User implements Serializable{
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_usr;

    @Column(name="login")
    private String login;
    
    @Column(name="pwd")
    private String pwd;
    
    @Column(name="nome")
    private String nome;
    
	public User() {
		super();
	}
}
