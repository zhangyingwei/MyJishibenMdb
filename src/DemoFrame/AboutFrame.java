/*
 * About.java
 *
 * Created on __DATE__, __TIME__
 */

package DemoFrame;

/**
 *关于窗口的类
 * @author  fengche
 */
public class AboutFrame extends javax.swing.JFrame {

	/** 创建About窗口 */
	public AboutFrame() {
		initComponents();
		this.setLocationRelativeTo(null);//设置窗口居中
		this.setVisible(true);//设置窗口可见
	}
	private void initComponents() {

		jLabel_about = new javax.swing.JLabel();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		jLabel_about.setFont(new java.awt.Font("微软雅黑", 1, 18));
		jLabel_about.setText("\u5f00\u53d1\u4eba\u5458\uff1a");

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				layout.createSequentialGroup().addGap(48, 48, 48).addComponent(
						jLabel_about).addContainerGap(280, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				layout.createSequentialGroup().addGap(45, 45, 45).addComponent(
						jLabel_about).addContainerGap(104, Short.MAX_VALUE)));

		pack();
	}
	private javax.swing.JLabel jLabel_about;
}