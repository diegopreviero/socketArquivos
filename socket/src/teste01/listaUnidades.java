package teste01;

import java.awt.GridLayout;
import java.io.File;

import javax.swing.JFrame;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeModel;

public class listaUnidades {
	public static void main(String[] args) {
		File[] raizes = File.listRoots(); //Aqui é retornado um Array de File, cada índice contém um dispositivo de armazenamento
		
		//JFrame para colocar o JTree
		JFrame jFrame = new JFrame();
		JTree jTree;
		
		jFrame.setLayout(new GridLayout());
		
		//Definindo o nó raiz do JTree
		DefaultMutableTreeNode root = new DefaultMutableTreeNode("Meu Computador");
		TreeModel model = new DefaultTreeModel(root);
		
		//Populando o JTree com as unidades
		for(File raiz : raizes){
			root.add(new DefaultMutableTreeNode(raiz.getAbsolutePath()));
		}
		
		jTree = new JTree(model);
		
		jFrame.add(jTree);
		
		jFrame.setSize(400, 600);
		jFrame.setVisible(true);
	}

}
