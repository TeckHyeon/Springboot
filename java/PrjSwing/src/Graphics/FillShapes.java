package Graphics;

import java.util.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.awt.geom.*;

public class FillShapes extends JFrame {

	public FillShapes() {
		setSize(600, 130);
		setTitle("Java 2D Fill Shapes");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(new MyComponent());
		setVisible(true);
	}

	public static void main(String[] args) {
		new FillShapes();
	}
}

class MyComponent extends JComponent {

	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;

		// 앤티 에일리어싱을 설정한다.
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);

		g2.setStroke(new BasicStroke(3));
		GradientPaint gp = new GradientPaint(0, 10, Color.WHITE, 0, 70,
				Color.RED);

		// 사각형
		g2.setPaint(Color.RED);
		g2.fill(new Rectangle2D.Float(10, 10, 70, 80));

		// 둥근 사각형
		g2.setPaint(gp);
		g2.fill(new RoundRectangle2D.Float(110, 10, 70, 80, 20, 20));

		// 타원
		g2.setPaint(Color.RED);
		g2.fill(new Ellipse2D.Float(210, 10, 80, 80));

		// 원호: Arc2D.OPEN
		g2.setPaint(gp);
		g2.fill(new Arc2D.Float(310, 10, 80, 80, 45, 225, Arc2D.OPEN));

		// 원호 Arc2D.CHORD
		g2.setPaint(Color.RED);
		g2.fill(new Arc2D.Float(410, 10, 80, 80, 45, 225, Arc2D.CHORD));

		// 원호 Arc2D.PIE
		g2.setPaint(gp);
		g2.fill(new Arc2D.Float(510, 10, 80, 80, 45, 225, Arc2D.PIE));
	}
}
