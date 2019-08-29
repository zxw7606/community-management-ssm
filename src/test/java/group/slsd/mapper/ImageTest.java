package group.slsd.mapper;

import java.awt.AlphaComposite;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.junit.Test;

public class ImageTest {

	@Test
	public void test1() {

		String srcImageFile = "C:\\Users\\0\\Desktop\\实训2";
		String imgFileName = "1111.jpg";
		float scale = .8f; // 缩放比例

		try {
			File f = new File(srcImageFile, imgFileName);
			BufferedImage bi = ImageIO.read(f);

			int width = bi.getWidth();
			int height = bi.getHeight();

			width = (int) (width * scale);
			height = (int) (height * scale);

			Image itemp = bi.getScaledInstance(width, height, bi.SCALE_FAST);

			// 新建image缓存
			BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
			Graphics graphics = bufferedImage.getGraphics();

			byte[] bs = "hello world".getBytes();
			graphics.drawImage(itemp, 0, 0, null);
			graphics.drawBytes(bs, 0, bs.length, 0, 0);
			ImageIO.write(bufferedImage, "JPEG", new File(srcImageFile, "test.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * 给图片添加图片水印
	 * 
	 * @param pressImg      水印图片
	 * @param srcImageFile  源图像地址
	 * @param destImageFile 目标图像地址
	 * @param x             修正值。 默认在中间
	 * @param y             修正值。 默认在中间
	 * @param alpha         透明度：alpha 必须是范围 [0.0, 1.0] 之内（包含边界值）的一个浮点数字
	 */
	public final static void pressImage(String pressImg, String srcImageFile, String destImageFile, int x, int y,
			float alpha) {
		try {
			File img = new File(srcImageFile);
			BufferedImage src = ImageIO.read(img);
			int wideth = src.getWidth();
			int height = src.getHeight();
			
			//创建图像
			BufferedImage image = new BufferedImage(wideth, height, BufferedImage.TYPE_INT_RGB);
			Graphics2D g = image.createGraphics();
			//覆写原图像
			g.drawImage(src, 0, 0, wideth, height, null);
			
			
			// 水印文件
			Image src_biao = ImageIO.read(new File(pressImg));
			int wideth_biao = src_biao.getWidth(null);
			int height_biao = src_biao.getHeight(null);
			
			// 设置透明度
			g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, alpha));
			g.drawImage(src_biao, (wideth - wideth_biao) / 2, (height - height_biao) / 2, wideth_biao, height_biao,
					null);
			// 水印文件结束
			g.dispose();
			ImageIO.write((BufferedImage) image, "JPEG", new File(destImageFile));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
