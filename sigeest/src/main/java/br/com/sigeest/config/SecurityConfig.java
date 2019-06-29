package br.com.sigeest.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import br.com.sigeest.security.ImplUserDetailsService;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private ImplUserDetailsService usuarioServico;

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests().antMatchers("/css/**", "/js/**", "/images/**").permitAll()
				.antMatchers("/estruturas").hasRole("PESQUISAR")
				.antMatchers("/fabricantes").hasRole("PESQUISAR")
				.antMatchers("/equipamentos").hasRole("PESQUISAR")
				.antMatchers("/baterias").hasRole("PESQUISAR")
				.antMatchers("/estoques").hasRole("PESQUISAR")
				.antMatchers("/usuarios").hasRole("PESQUISAR")
				.antMatchers("/estrutura/**/exibir").hasRole("PESQUISAR")
		        .antMatchers("/**/novo").hasRole("CADASTRAR")
				.antMatchers("/editar/**/selecionar").hasRole("EDITAR")
				.antMatchers("/editar/**/**").hasRole("EDITAR")
				.antMatchers("/excluir/**/selecionar").hasRole("EXCLUIR")
				.antMatchers("/excluir/**/**").hasRole("EXCLUIR")
				.antMatchers("/**/**/adicionar").hasRole("ADICIONAR")
				.antMatchers("/**/**/remover/**").hasRole("REMOVER")
				.antMatchers("/**/**/**/estocar/**").hasRole("REMOVER")
				.antMatchers("/", "/inicio", "index").permitAll().anyRequest().authenticated().and().formLogin()
				.loginPage("/login").permitAll().and().logout().logoutSuccessUrl("/login?logout").permitAll().and()
				.rememberMe();

	}

	@Override
	protected void configure(AuthenticationManagerBuilder builder) throws Exception {
		builder.userDetailsService(usuarioServico);
	}

}