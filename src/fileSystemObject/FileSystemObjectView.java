package fileSystemObject;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import javax.swing.JComponent;

public class FileSystemObjectView extends JComponent{
	private FileSystemObject fso;
	private Rectangle outline;
	private double lastStringX = 5;
	private double lastStringY = 20;
	private int newFileSquare = 110;
	
	public FileSystemObjectView(Rectangle outline, FileSystemObject fsoValue)
	{
		if(fsoValue != null)
			this.fso = fsoValue;
		if(outline != null)
		{
			this.setBounds(outline);
			this.outline = outline;
		}
			
	}
	
	public void paintComponent(Graphics graphics)
	{
		super.paintComponent(graphics);
		Graphics2D g = (Graphics2D)graphics;
		g.setColor(Color.black);
		g.draw(this.outline);
		if(this.fso.getClass().equals(Folder.class))
		{
			this.paintFolder(graphics, (Folder)this.fso);
		}
		else
		{
			this.paintFile(graphics, (File)this.fso);
		}
		
	}
	
	public void paintFolder(Graphics graphics, Folder f)
	{
		super.paintComponent(graphics);
		Graphics2D g = (Graphics2D)graphics;
		g.setColor(Color.YELLOW);
		g.fill(this.outline);
		g.setColor(Color.BLACK);
		String fsoData = String.format("%s, %d", this.fso.getName(), this.fso.getSize());
		g.drawString(fsoData, (int)lastStringX, (int)lastStringY);
		
		for(int i = 0; i < f.getIndex(); i++)
		{
			this.outline.setBounds(0, (int)this.outline.getBounds().getY() + 110, 100, 100);
			if(f.getFiles()[i].getClass().equals(Folder.class))
			{
				this.paintFolder(graphics, (Folder)f.getFiles()[i]);
				lastStringX += newFileSquare;
			}
			else if(f.getFiles()[i].getClass().equals(File.class))
			{
				lastStringY += newFileSquare;
				this.paintFile(graphics, (File)f.getFiles()[i]);
			}
		}
		
	}
	
	public void paintFile(Graphics graphics, File f)
	{
		super.paintComponent(graphics);
		Graphics2D g = (Graphics2D)graphics;
		g.setColor(Color.BLUE);
		g.fill(this.outline);
		g.setColor(Color.WHITE);
		String fData = String.format("%s, %d", f.getName(), f.getSize());
		g.drawString(fData, (int)lastStringX, (int)lastStringY);
	}
}
