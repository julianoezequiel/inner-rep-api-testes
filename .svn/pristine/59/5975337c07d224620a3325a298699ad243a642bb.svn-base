package com.api.rep.dto.comandos;

import com.api.rep.entity.Empregado;

/**
 * Classe representa o comando EMPREGADO
 * 
 * @author juliano.ezequiel
 *
 */
public class EmpregadoCmd implements Cmd {

	private static final long serialVersionUID = 1L;

	/**
	 * EMPREGADO_NOME
	 */
	private String fNome;

	/**
	 * EMPREGADO_PIS
	 */
	private String fPis;

	/**
	 * EMPREGADO_SENHA
	 */
	private String fSenha;

	/**
	 * EMPREGADO_NOME_EXIBE
	 */
	private String fNEx;

	/**
	 * EMPREGADO_CARTAO_BARRAS
	 */
	private String fCB;

	/**
	 * EMPREGADO_CARTAO_PROX
	 */
	private String fCP;

	/**
	 * EMPREGADO_CARTAO_TECLADO
	 */
	private String fCT;


	public String getfNome() {
		return fNome;
	}

	public void setfNome(String empregadoNome) {
		this.fNome = empregadoNome;
	}

	public String getfPis() {
		return fPis;
	}

	public void setfPis(String empregadoPis) {
		this.fPis = empregadoPis;
	}

	public String getfNEx() {
		return fNEx;
	}

	public void setfNEx(String empregadoNomeExibe) {
		this.fNEx = empregadoNomeExibe;
	}

	public String getfCB() {
		return fCB;
	}

	public void setfCB(String empregadoCartaoBarras) {
		this.fCB = empregadoCartaoBarras;
	}

	public String getfCP() {
		return fCP;
	}

	public void setfCP(String empregadoCartaoProx) {
		this.fCP = empregadoCartaoProx;
	}

	public String getfCT() {
		return fCT;
	}

	public void setfCT(String empregadoCartaoTeclado) {
		this.fCT = empregadoCartaoTeclado;
	}

	
	public String getfSenha() {
		return fSenha;
	}

	public void setfSenha(String fSenha) {
		this.fSenha = fSenha;
	}

	public Empregado toEmpregado() {
		Empregado empregado = new Empregado();
		empregado.setEmpregadoCartaoBarras(fCB);
		empregado.setEmpregadoCartaoProx(fCP);
		empregado.setEmpregadoCartaoTeclado(fCT);
		empregado.setEmpregadoNome(fNome);
		empregado.setEmpregadoNomeExibe(fNEx);
		empregado.setEmpregadoPis(fPis);
		empregado.setEmpregadoSenha(fSenha);
		return empregado;
	}
}
