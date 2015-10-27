package teste01;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class testes {

	public static void main(String[] args) {

		JFileChooser chooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter(
				"JPG & GIF Images", "jpg", "gif");
		chooser.setFileFilter(filter);
		chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		/*int returnVal = chooser.showOpenDialog("nome do frame");
		if(returnVal == JFileChooser.APPROVE_OPTION) {
			System.out.println("You chose to open this file: " +
					chooser.getSelectedFile().getName());
		}*/
		
	}

}
