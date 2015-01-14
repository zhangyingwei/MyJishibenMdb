package Start;

import DemoDto.MyDto;
import DemoFrame.MainFrame;
/**
 * @author fengche
 *开始的类，程序的入口
 */
public class Start {
	/**
	 *main函数
	 */
	public static void main(String[] args) {
		MyDto myDto = new MyDto();
		MainFrame mainFrame = new MainFrame(myDto);
		mainFrame.setVisible(true);
	}

}
