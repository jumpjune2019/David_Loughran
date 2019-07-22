import javax.swing.*;
public class MyLabel {
	private String position;

	MyLabel() {
		
	}
	
	JLabel setLabel(String l, String p, JFrame jf) {
		position = p;
		JLabel lb = new JLabel(l);
		setLabelInLayout.setLabelInLayout(jf, lb);
		return lb;
	}
	
	LayoutLabel setLabelInLayout = (jF, jl) -> {
		jF.add(jl, position);
	};
}
