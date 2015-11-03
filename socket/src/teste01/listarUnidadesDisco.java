package teste01;

import java.io.File;

import javax.swing.filechooser.FileSystemView;

public class listarUnidadesDisco {

	public static void main(String args[]){
		File[] roots = null;//cria um vetor de file aonde ficara os dispositivos

		FileSystemView fs = FileSystemView.getFileSystemView();

		//verifica se o so eh windows
		if (System.getProperties().getProperty("os.name").toLowerCase().contains("windows")) {

			roots = File.listRoots();//lista os diretorios raiz

			for (File file : roots) {//percorre o vetor roots
				String descricao = fs.getSystemTypeDescription(file);//pega a descrição dos diretorios
				if (descricao != null) {//se for diferente de nulo
					//if (descricao.endsWith("removível")) {//verifica se é um disco removivel
						System.out.println(file.getAbsolutePath());//mostra dispositivo
					//}
				}
			}       //verifica se eh linux
		} else if (System.getProperties().getProperty("os.name").toLowerCase().contains("linux")) {

			roots = fs.getFiles(new File("/media/"), true);//pega todos os diretorios montados em /media/

			for (File file : roots) {//percorre o vetor roots
				System.out.println(file.getAbsolutePath());//mostra dispositivo
			}
		}
	}

}
