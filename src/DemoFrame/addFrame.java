/*
 * addFrame.java
 *
 * Created on 2013
 */

package DemoFrame;

import java.awt.event.ActionEvent;
import java.io.IOException;

import javax.swing.JOptionPane;

import DemoDao.Until;
import DemoDate.SystemDate;
import DemoDto.MyDto;
/**
 * @author fengche
 *创建addFrame窗口
 */
public class addFrame extends javax.swing.JFrame {

	private SystemDate systemDate;//系统时间对象
	private Until dao;//数据库操作对象
	private MyDto myDto;//数据对象
	/**
	 *创建addFrame窗口
	 *传入一个数据对象
	 */
	public addFrame(MyDto myDto) {
		this.systemDate = new SystemDate();//创建系统时间对象
		this.myDto = myDto;//创建数据对象
		this.dao = new Until(myDto);//创建数据库操作对象，传入一个数据对象
		initComponents();
		this.setLocationRelativeTo(null);//设置窗口居中显示

	}

	private void initComponents() {

		jLabel1 = new javax.swing.JLabel();
		jTextField_name = new javax.swing.JTextField();
		jLabel2 = new javax.swing.JLabel();
		jScrollPane1 = new javax.swing.JScrollPane();
		jTextArea = new javax.swing.JTextArea();
		jButton_reset = new javax.swing.JButton();
		jButton_ok = new javax.swing.JButton();
		jButton_esc = new javax.swing.JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
		setTitle("\u6dfb\u52a0");

		jLabel1.setText("\u6807\u9898\uff1a");

		jLabel2.setText("\u5185\u5bb9\uff1a");

		jTextArea.setColumns(20);
		jTextArea.setRows(5);
		jScrollPane1.setViewportView(jTextArea);

		jButton_reset.setText("\u91cd\u7f6e");
		jButton_reset.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton_resetActionPerformed(evt);
			}
		});

		jButton_ok.setText("\u786e\u5b9a");
		jButton_ok.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				try {
					jButton_okActionPerformed(evt);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

		jButton_esc.setText("\u53d6\u6d88");
		jButton_esc.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton_escActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout
				.setHorizontalGroup(layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								layout
										.createSequentialGroup()
										.addGroup(
												layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.TRAILING)
														.addGroup(
																layout
																		.createSequentialGroup()
																		.addComponent(
																				jButton_ok)
																		.addGap(
																				48,
																				48,
																				48)
																		.addComponent(
																				jButton_esc))
														.addGroup(
																javax.swing.GroupLayout.Alignment.LEADING,
																layout
																		.createSequentialGroup()
																		.addGap(
																				60,
																				60,
																				60)
																		.addGroup(
																				layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.LEADING,
																								false)
																						.addGroup(
																								layout
																										.createSequentialGroup()
																										.addComponent(
																												jLabel1)
																										.addPreferredGap(
																												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																										.addComponent(
																												jTextField_name,
																												javax.swing.GroupLayout.PREFERRED_SIZE,
																												324,
																												javax.swing.GroupLayout.PREFERRED_SIZE)
																										.addPreferredGap(
																												javax.swing.LayoutStyle.ComponentPlacement.RELATED,
																												javax.swing.GroupLayout.DEFAULT_SIZE,
																												Short.MAX_VALUE)
																										.addComponent(
																												jButton_reset))
																						.addGroup(
																								layout
																										.createSequentialGroup()
																										.addComponent(
																												jLabel2)
																										.addPreferredGap(
																												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																										.addComponent(
																												jScrollPane1,
																												javax.swing.GroupLayout.PREFERRED_SIZE,
																												429,
																												javax.swing.GroupLayout.PREFERRED_SIZE)))))
										.addContainerGap(68, Short.MAX_VALUE)));
		layout
				.setVerticalGroup(layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								layout
										.createSequentialGroup()
										.addGap(35, 35, 35)
										.addGroup(
												layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(jLabel1)
														.addComponent(
																jTextField_name,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																jButton_reset))
										.addGap(35, 35, 35)
										.addGroup(
												layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(jLabel2)
														.addComponent(
																jScrollPane1,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																233,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGap(36, 36, 36)
										.addGroup(
												layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																jButton_ok)
														.addComponent(
																jButton_esc))
										.addContainerGap(51, Short.MAX_VALUE)));

		pack();
	}
	/**
	 *退出当前窗口，新建主窗口
	 */
	private void jButton_escActionPerformed(java.awt.event.ActionEvent evt) {
		this.dispose();
		new MainFrame(myDto).setVisible(true);
	}
	/**
	 *确认键事件监听
	 */
	private void jButton_okActionPerformed(java.awt.event.ActionEvent evt) throws Exception {
			//判断是否为空
			if (!this.jTextField_name.getText().equals("")) {
				String myname = this.jTextField_name.getText();//获取名称文本框内容，string类型
				String content = this.jTextArea.getText();//获取内容文本框
				String time = this.systemDate.getdate();//获取系统时间
				this.dao.insertOne(myname, content, time);//数据库插入一条记录
				int i = JOptionPane.showConfirmDialog(null, "添加成功，再来一条？");//信息提示框
				switch (i) {
				case 0:
					this.reset();//重置
					break;
				case 1:
					this.dispose();//取消
					new MainFrame(myDto).setVisible(true);
				}
			} else {
				JOptionPane.showMessageDialog(null, "输入错误！");//信息提示框
			}
	}
	/**
	 *重置键事件监听
	 */
	private void jButton_resetActionPerformed(java.awt.event.ActionEvent evt) {
		this.reset();
	}

	private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
	}
	/**
	 *取消键事件监听
	 */
	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
		this.dispose();
		new MainFrame(myDto).setVisible(true);
	}
	/**
	 *确认件事件监听
	 */
	private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
		JOptionPane.showMessageDialog(null, "添加成功");
		this.dispose();
		new MainFrame(myDto).setVisible(true);
	}
	/**
	 *文本框重置的方法
	 */
	private void reset() {
		this.jTextArea.setText("");
		this.jTextField_name.setText("");
	}

	private javax.swing.JButton jButton_esc;
	private javax.swing.JButton jButton_ok;
	private javax.swing.JButton jButton_reset;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JTextArea jTextArea;
	private javax.swing.JTextField jTextField_name;

}