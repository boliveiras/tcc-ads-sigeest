package br.com.sigeest.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import br.com.sigeest.converters.LocalDateTimeAttributeConverter;
import br.com.sigeest.enums.Setor;

@Entity
@Table(name = "usuarios", uniqueConstraints = @UniqueConstraint(columnNames = "login", name = "u_usuario_login"))
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	
	@NotNull
	@NotEmpty(message = "Nome é obrigatório")
	@Size(max = 55, message = "Nome deve conter no máximo 55 caracteres")
	private String nome;

	@Enumerated(EnumType.STRING)	
	private Setor setor;
	
	@NotEmpty(message = "E-mail é obrigatório")
	@Email(message = "Email fora do padrão permitido")
	private String email;
	
	@NotNull
	@NotEmpty(message = "Login é obrigatório")
	@Size(max = 25, message = "Login deve conter no máximo 25 caracteres")
	private String login;

	@DateTimeFormat(pattern = "dd/MM/yyy - HH:mm")	
	@Convert(converter = LocalDateTimeAttributeConverter.class)
	private LocalDateTime dataHoraCadastro;

	@NotNull(message = "Password é obrigatório")
	@NotEmpty(message = "A senha não pode ser vazia")
	@Size(min = 8, max = 15, message = "Password deve conter de 8 a 15 caracteres")
	private String password;

	@NotNull(message = "Confirmação do password é obrigatória")
	@NotEmpty(message = "A senha não pode ser vazia")
	@Size(min = 8, max = 15, message = "Password deve conter de 8 a 15 caracteres")
	private String confPassword;
	
	private Boolean ativo;

	@ManyToOne
	@JoinColumn(name = "codigo_grupo", foreignKey = @ForeignKey(name = "fk_usuario_grupo"), referencedColumnName = "codigo")
	private Grupo grupo;

	public Usuario() {
		dataHoraCadastro = LocalDateTime.now();
		ativo = true;
	}

	public Usuario(Long codigo, String nome, Setor setor, String email, String login, LocalDateTime dataHoraCadastro,
			String password, String confPassword, Boolean ativo, Grupo grupo) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.setor = setor;
		this.email = email;
		this.login = login;
		this.dataHoraCadastro = dataHoraCadastro;
		this.password = password;
		this.confPassword = confPassword;
		this.ativo = ativo;
		this.grupo = grupo;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Setor getSetor() {
		return setor;
	}

	public void setSetor(Setor setor) {
		this.setor = setor;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public LocalDateTime getDataHoraCadastro() {
		return dataHoraCadastro;
	}

	public void setDataHoraCadastro(LocalDateTime dataHoraCadastro) {
		this.dataHoraCadastro = dataHoraCadastro;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfPassword() {
		return confPassword;
	}

	public void setConfPassword(String confPassword) {
		this.confPassword = confPassword;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public Grupo getGrupo() {
		return grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
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
		Usuario other = (Usuario) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

}
