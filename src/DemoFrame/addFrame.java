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
 *����addFrame����
 */
public class addFrame extends javax.swing.JFrame {

	private SystemDate systemDate;//ϵͳʱ�����
	private Until dao;//���ݿ��������
	private MyDto myDto;//���ݶ���
	/**
	 *����addFrame����
	 *����һ�����ݶ���
	 */
	public addFrame(MyDto myDto) {
		this.systemDate = new SystemDate();//����ϵͳʱ�����
		this.myDto = myDto;//�������ݶ���
		this.dao = new Until(myDto);//�������ݿ�������󣬴���һ�����ݶ���
		initComponents();
		this.setLocationRelativeTo(null);//���ô��ھ�����ʾ

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
	 *�˳���ǰ���ڣ��½�������
	 */
	private void jButton_escActionPerformed(java.awt.event.ActionEvent evt) {
		this.dispose();
		new MainFrame(myDto).setVisible(true);
	}
	/**
	 *ȷ�ϼ��¼�����
	 */
	private void jButton_okActionPerformed(java.awt.event.ActionEvent evt) throws Exception {
			//�ж��Ƿ�Ϊ��
			if (!this.jTextField_name.getText().equals("")) {
				String myname = this.jTextField_name.getText();//��ȡ�����ı������ݣ�string����
				String content = this.jTextArea.getText();//��ȡ�����ı���
				String time = this.systemDate.getdate();//��ȡϵͳʱ��
				this.dao.insertOne(myname, content, time);//���ݿ����һ����¼
				int i = JOptionPane.showConfirmDialog(null, "��ӳɹ�������һ����");//��Ϣ��ʾ��
				switch (i) {
				case 0:
					this.reset();//����
					break;
				case 1:
					this.dispose();//ȡ��
					new MainFrame(myDto).setVisible(true);
				}
			} else {
				JOptionPane.showMessageDialog(null, "�������");//��Ϣ��ʾ��
			}
	}
	/**
	 *���ü��¼�����
	 */
	private void jButton_resetActionPerformed(java.awt.event.ActionEvent evt) {
		this.reset();
	}

	private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
	}
	/**
	 *ȡ�����¼�����
	 */
	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
		this.dispose();
		new MainFrame(myDto).setVisible(true);
	}
	/**
	 *ȷ�ϼ��¼�����
	 */
	private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
		JOptionPane.showMessageDialog(null, "��ӳɹ�");
		this.dispose();
		new MainFrame(myDto).setVisible(true);
	}
	/**
	 *�ı������õķ���
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