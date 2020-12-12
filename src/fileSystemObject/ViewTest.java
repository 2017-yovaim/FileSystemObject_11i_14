package fileSystemObject;

import java.awt.Rectangle;

import javax.swing.JFrame;

public class ViewTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		File file1 = new File("Parks.txt", 20);
		File file2 = new File("Gardents.txt", 30);
		File file3 = new File("Reservations.txt", 60);
		FileSystemObject[] files = {file1, file2, file3};
		Folder folder1 = new Folder("Green files", files);
		File file4 = new File("Parks.xlx", 40);
		File file5 = new File("Gardens.xlx", 60);
		File file6 = new File("Reservations.xlx", 120);
		FileSystemObject[] files2 = {file4, file5, file6, folder1};
		Folder folder2 = new Folder("Files", files2);
		
		
		
		JFrame window = new JFrame();
		window.setBounds(50, 50, 800, 800);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
		
		Rectangle w = new Rectangle(0, 0, 100, 100);
		FileSystemObjectView view = new FileSystemObjectView(w, folder2);
		window.add(view);

	}

}
