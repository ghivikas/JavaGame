package com.redomar.game;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

/**
 * Credit to Gagandeep Bali @ stackoverflow
 */
public class HelpMenu {

	private MyPanel contentPane;

	private void displayGUI() {
		JFrame frame = new JFrame("Help Menu");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		contentPane = new MyPanel();

		frame.setContentPane(contentPane);
		frame.setLocationRelativeTo(null);
		frame.pack();
		frame.setLocationByPlatform(true);
		frame.setVisible(true);
	}

	private class MyPanel extends JPanel {

		private BufferedImage image;

		private MyPanel() {
			try {
				image = ImageIO.read(MyPanel.class.getResource("/controls/controls.png"));
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
		}

		@Override
		public Dimension getPreferredSize() {
			return image == null ? new Dimension(400, 300): new Dimension(image.getWidth(), image.getHeight());
		}

		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(image, 0, 0, this);
		}
	}

	public static void run() {
		Runnable runnable = () -> new HelpMenu().displayGUI();
		EventQueue.invokeLater(runnable);
	}
}
