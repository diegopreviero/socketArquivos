package anotacoes;

public class InfoCliente {

	public InfoCliente() { }
	
	String versaoCliente;
	String versaoJava;
	String statusDeep;
	String os = System.getProperty("os.name");
	String escola; //setado no properties pelo servidor
	String ip;
	String hostName;
	
	public String getVersaoCliente() {
		return versaoCliente;
	}
	public void setVersaoCliente(String versaoCliente) {
		this.versaoCliente = versaoCliente;
	}
	public String getVersaoJava() {
		return versaoJava;
	}
	public void setVersaoJava(String versaoJava) {
		this.versaoJava = versaoJava;
	}
	public String getStatusDeep() {
		return statusDeep;
	}
	public void setStatusDeep(String statusDeep) {
		this.statusDeep = statusDeep;
	}
	public String getOs() {
		return os;
	}
	public void setOs(String os) {
		this.os = os;
	}
	public String getEscola() {
		return escola;
	}
	public void setEscola(String escola) {
		this.escola = escola;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getHostName() {
		return hostName;
	}
	public void setHostName(String hostName) {
		this.hostName = hostName;
	}

}
