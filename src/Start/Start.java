package Start;

import DemoDto.MyDto;
import DemoFrame.MainFrame;
/**
 * @author fengche
 *��ʼ���࣬��������
 */
public class Start {
	/**
	 *main����
	 */
	public static void main(String[] args) {
		MyDto myDto = new MyDto();
		MainFrame mainFrame = new MainFrame(myDto);
		mainFrame.setVisible(true);
	}

}
