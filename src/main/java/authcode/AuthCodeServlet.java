package authcode;

import java.io.IOException;
import java.util.Random;
import java.awt.*;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = {"/auth/code"})
public class AuthCodeServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//取得驗證碼
		String authCode = String.format("%04d", new Random().nextInt(10000));//%04d 表示不足補0 最多補4個
		System.out.println("authCode : " + authCode);
		//將驗證碼存入session中,便於日後驗證
		req.getSession().setAttribute("authCode", authCode);
		
		try {
			//取得圖片
			BufferedImage img = getAuthCodeImage(authCode);
			//發送圖片
			ImageIO.write(img,"JPEG", resp.getOutputStream());
		} catch (Exception e) {
			e.printStackTrace(System.err);
		}
	}
	
	//產生圖檔
	private BufferedImage getAuthCodeImage(String authCode) {
		Random r= new Random();
		int w = 80 ;
		int h = 30 ;
		//建立圖像暫存區
		BufferedImage img = new BufferedImage(80,30,BufferedImage.TYPE_INT_BGR);
		//建立畫布
		Graphics g = img.getGraphics();
		//設定顏色
		g.setColor(Color.YELLOW);
		//塗滿背景
		g.fillRect(0,0,w,h);
		
		//繪文字
		//g.setFont(new Font("新細明體",Font.BOLD,30));//設定自型
		//g.drawString(authCode,10,25);//在座標(3,25) 上畫 authCode 的內容
		
		//設定顏色
		g.setColor(Color.BLACK);
		g.setFont(new Font("新細明體",Font.BOLD,r.nextInt(15)+15));//設定自型
		g.drawString(authCode.charAt(0)+"",10,25);//在座標(3,25) 上畫 authCode 的內容
		
		g.setColor(Color.RED);
		g.setFont(new Font("新細明體",Font.BOLD,r.nextInt(15)+15));//設定自型
		g.drawString(authCode.charAt(1)+"",25,25);//在座標(3,25) 上畫 authCode 的內容
		
		g.setColor(Color.BLUE);
		g.setFont(new Font("新細明體",Font.BOLD,r.nextInt(15)+15));//設定自型
		g.drawString(authCode.charAt(2)+"",40,25);//在座標(3,25) 上畫 authCode 的內容
		
		g.setColor(Color.GREEN);
		g.setFont(new Font("新細明體",Font.BOLD,r.nextInt(15)+15));//設定自型
		g.drawString(authCode.charAt(3)+"",60,25);//在座標(3,25) 上畫 authCode 的內容
		
		//加入干擾線
		for(int i = 1 ; i<= 10 ; i++) {
			int x1 = r.nextInt(w);
			int y1 = r.nextInt(h);
			int x2 = r.nextInt(w);
			int y2 = r.nextInt(h);
			g.drawLine(x1,y1,x2,y2);
		}
		return img;
	}
}
