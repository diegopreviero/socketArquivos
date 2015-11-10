package previero3.recursos;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class CriarDiretorios {

	public CriarDiretorios(String arquivo){

		String diretorio = arquivo.substring(0, arquivo.lastIndexOf("/")+1);
		List<String> dir = new ArrayList<String>();  

		while (diretorio.contains("/")) {
			diretorio = diretorio.substring(0, diretorio.lastIndexOf("/"));
			if (diretorio.contains("/")) {
				dir.add(diretorio);
			}			
		}

		ListIterator it = dir.listIterator(dir.size());
		while(it.hasPrevious()) {
			Object obj = it.previous();
			System.out.println(obj);

			File file = new File(obj.toString());
			if(file.exists() == false){
				file.mkdir();
			}			
		}
	}

}