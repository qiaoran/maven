package org.util.common;

import java.awt.AlphaComposite;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.Transparency;
import java.awt.color.ColorSpace;
import java.awt.image.BufferedImage;
import java.awt.image.ColorConvertOp;
import java.awt.image.CropImageFilter;
import java.awt.image.FilteredImageSource;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import sun.misc.BASE64Encoder;  

/**
 * Author: leiqiao
 */
public class ImageUtils {

    public ImageUtils() {
        imageType = BufferedImage.TYPE_INT_ARGB;
        position = Position.RIGHT_BOT_CORNER;
    }

    public ImageUtils(int imageType) {
        this.imageType = imageType;
    }


    /**
     * add an PNG image watermark to another image
     * @param image image file
     * @param watermark image watermark file
     * @param out we're wanting
     */
    public void PNGWatermarking(File image, File watermark, File out) {
        try {
            BufferedImage image0 = ImageIO.read(image);
            BufferedImage watermark0 = ImageIO.read(watermark);
            BufferedImage bufferedImage = watermarking(image0, watermark0, position);
            renderingPNGImage(out, bufferedImage);
        } catch (IOException e) {
            System.err.println("image IO exception.");
        }
    }

    /**
     * Test if file is image.
     * @param file
     * @return true if file is image otherwise is false
     */
    public boolean isImage(File file) {
        try {
            BufferedImage image = ImageIO.read(file);
            if (image == null) {
                return false;
            } else {
                return true;
            }
        } catch (IOException e) {
            System.out.println("file IO exception.");
            return false;
        }
    }

    /**
     * watermarking helper.
     * @param image which image to watermarking
     * @param watermark buffered watermark data
     * @param position position to put watermark
     * @return combined image data
     */
    private BufferedImage watermarking(BufferedImage image, BufferedImage watermark, Position position) {
        switch (position) {
            case LEFT_TOP_CORNER:
                return combineBufferedImage(image, watermark, 0, 0);
            case RIGHT_TOP_CORNER:
                return combineBufferedImage(image, watermark, image.getWidth() - watermark.getWidth(), 0);
            case CENTER:
                return combineBufferedImage(image, watermark, (image.getWidth() - watermark.getWidth()) / 2,
                        (image.getHeight() - watermark.getHeight()) / 2);
            case LEFT_BOT_CORNER:
                return combineBufferedImage(image, watermark, 0, image.getHeight() - watermark.getHeight());
            case RIGHT_BOT_CORNER:
                return combineBufferedImage(image, watermark, image.getWidth() - watermark.getWidth(),
                        image.getHeight() - watermark.getHeight());
            default:
                return null;
        }
    }

    /**
     * Combine two buffered images.
     * @param image0 background image
     * @param image1 overlay image
     * @param x overlay image x coordinate
     * @param y overlay image y coordinate
     * @return combined buffered image
     */
    private BufferedImage combineBufferedImage(BufferedImage image0, BufferedImage image1, int x, int y) {

        if ((x + image1.getWidth()) > image0.getWidth()) {
            throw new IllegalArgumentException("x coordinate is too large.");
        }

        if ((y + image1.getHeight()) > image0.getHeight()) {
            throw new IllegalArgumentException("y coordinate is too large.");
        }

        BufferedImage combined = new BufferedImage(image0.getWidth(), image0.getHeight(), imageType);

        Graphics graphics = combined.getGraphics();
        graphics.drawImage(image0, 0, 0, null);
        graphics.drawImage(image1, x, y, null);

        return combined;
    }

    /**
     * write buffered image data to PNG image file
     * @param file file to save
     * @param image image data
     */
    private void renderingPNGImage(File file, BufferedImage image) {
        try {
            ImageIO.write(image, "PNG", file);
        } catch (IOException e) {
            System.err.println("image IO exception.");
        }
    }

    /**
     * watermark position.
     */
    private enum Position {
        LEFT_TOP_CORNER,
        RIGHT_TOP_CORNER,
        CENTER,
        LEFT_BOT_CORNER,
        RIGHT_BOT_CORNER
    }

    private int imageType;
    private Position position;
    
    
    
    /******************************************** Wang 2016-1-5 *********************************************/
    
    /**
     * 把图片印刷到图片上  
     * @param pressImg -- 水印文件  
     * @param targetImg -- 目标文件  
     * @param x --x坐标  
     * @param y --y坐标
     */   
	public final static void pressImage(String pressImg, String targetImg, int x, int y, String ext) {
		
		try {
			
			System.out.println(targetImg);
			
			// 目标文件
			File _file = new File(targetImg);
			
			Image src = ImageIO.read(_file);
			
			int wideth = src.getWidth(null);
			
			int height = src.getHeight(null);
			
			BufferedImage image = new BufferedImage(wideth, height, BufferedImage.TYPE_INT_RGB);
			
			// 获得画笔
			Graphics2D g = image.createGraphics();
			
			// 设置对线段的锯齿状边缘处理   
            g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
  
            g.drawImage(src.getScaledInstance(src.getWidth(null), src.getHeight(null), Image.SCALE_SMOOTH), 0, 0, null);   
            
            // 水印图象的路径 水印一般为gif或者png的，这样可设置透明度   
            ImageIcon imgIcon = new ImageIcon(pressImg);
  
            // 得到Image对象。   
			Image img = imgIcon.getImage();
			
            // 表示水印图片的位置   
            g.drawImage(img, wideth - img.getWidth(null) - 10, height - img.getHeight(null) - 20, null);   
  
            g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER));   
  
			// 水印文件结束
			g.dispose();
			
			FileOutputStream out = new FileOutputStream(targetImg);
			
			//JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
			
			ImageIO.write(image, ext, out);  
			
			//encoder.encode(image);
			
			out.close();
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
	}
	
    /**
     * 彩色转黑白
     * @author Wang
     * @param srcImageFilePath 待转换源文件地址
     * @param destImageFilePath 处理后文件地址
     * */
	public final static void gray(String srcImageFilePath, String destImageFilePath) {
		
        try {
        	
            BufferedImage src = ImageIO.read(new File(srcImageFilePath));
            
            ColorSpace cs = ColorSpace.getInstance(ColorSpace.CS_GRAY);
            
            ColorConvertOp op = new ColorConvertOp(cs, null);
            
            src = op.filter(src, null);
            
            ImageIO.write(src, "JPEG", new File(destImageFilePath));
            
        } catch (IOException e) {
        	
            e.printStackTrace();
            
        }
        
    }
	
	public static void createThumb(InputStream in, String destImgPath, String sizeStr) {
		
		int destImgH = 0, destImgW = 0;
		
		if (sizeStr != null && !sizeStr.equals("") && sizeStr.equals("80*80")) { 
			destImgW = 80;
			destImgH = 80;
			createThumb(in, destImgPath, destImgW, destImgH);
			
		// 公司logo、所有封面、头像、案例封面，设计封面	
		} else if (sizeStr != null && !sizeStr.equals("") && sizeStr.equals("360*360")) {
			destImgW = 360;
			destImgH = 360;
			createThumb(in, destImgPath, destImgW, destImgH);
			
		// 资质证书、身份证等大小
		} else if (sizeStr != null && !sizeStr.equals("") && sizeStr.equals("460*300")) {
			destImgW = 460;
			destImgH = 300;
			createThumb(in, destImgPath, destImgW, destImgH);
		
		// 代表作品图片
		} else if (sizeStr != null && !sizeStr.equals("") && sizeStr.equals("640*320")) {
			destImgW = 640;
			destImgH = 320;
			createThumb(in, destImgPath, destImgW, destImgH);
		
		// 知识库插入图片
		} else if (sizeStr != null && !sizeStr.equals("") && sizeStr.equals("1024*768")) {
			destImgW = 900;
			destImgH = 510;
			createThumb(in, destImgPath, destImgW, destImgH);
		}
		
	}
	
    /**
     * 按照像素等比裁剪
     * @author Wang
     * @param in 待切割图片流
     * @param destImgPath 切割后图片路径
     * @param destImgW 所需宽度
     * @param destImgH 所需高度
     */
    private static void createThumb (InputStream in, String destImgPath, int destImgW, int destImgH){
    	
		// 原图片等比例缩小或放大之后的图片
		int narrowImgW;
		int narrowImgH;
		// 原图片大小
		int srcImgW;
		int srcImgH;
        
        try {
        	//destImgW == 900
        	if( 1 != 1){
        		
        		BufferedImage bi = ImageIO.read(in);
	            srcImgW = bi.getWidth();
	            srcImgH = bi.getHeight();
        		
        		narrowImgW = destImgW;
				narrowImgH =(int) (((float) destImgW / (float) srcImgW) * srcImgH);//srcImgH;
				int cutNarrowImgSize = (narrowImgH - destImgH) / 2;

				BufferedImage narrowImg = new BufferedImage(narrowImgW, narrowImgH, BufferedImage.TYPE_INT_RGB);
				narrowImg.getGraphics().drawImage(bi.getScaledInstance(narrowImgW, narrowImgH, Image.SCALE_SMOOTH), 0, 0, null);

				Image image = narrowImg.getScaledInstance(narrowImgW, narrowImgH, Image.SCALE_DEFAULT);
				CropImageFilter cropFilter = new CropImageFilter(0, cutNarrowImgSize, narrowImgW, narrowImgH - cutNarrowImgSize);
				Image img = Toolkit.getDefaultToolkit().createImage(new FilteredImageSource(image.getSource(), cropFilter));
				BufferedImage cutTopNarrowImg = new BufferedImage(narrowImgW, narrowImgH - cutNarrowImgSize, BufferedImage.TYPE_INT_RGB);
				cutTopNarrowImg.getGraphics().drawImage(img, 0, 0, null);

				image = cutTopNarrowImg.getScaledInstance(narrowImgW, narrowImgH - cutNarrowImgSize, Image.SCALE_DEFAULT);
				cropFilter = new CropImageFilter(0, 0, narrowImgW, narrowImgH - cutNarrowImgSize * 2);
				img = Toolkit.getDefaultToolkit().createImage(new FilteredImageSource(image.getSource(), cropFilter));
				BufferedImage cutBottomNarrowImg = new BufferedImage(narrowImgW, narrowImgH - cutNarrowImgSize * 2, BufferedImage.TYPE_INT_RGB);
				Graphics g = cutBottomNarrowImg.getGraphics();
				g.drawImage(img, 0, 0, null);
				g.dispose();
				ImageIO.write(cutBottomNarrowImg, "JPEG", new File(destImgPath));
        		
        	}else{
        		
				BufferedImage bi = ImageIO.read(in);
	            srcImgW = bi.getWidth();
	            srcImgH = bi.getHeight();
	            
	            // 转换图片尺寸与目标尺寸比较 ， 如果转换图片较小，说明转换图片相对于目标图片来说高较小，需要以高为基准进行缩放。
				if ((float) srcImgW / srcImgH > (float) destImgW / destImgH) {
					narrowImgW = (int) (((float) destImgH / (float) srcImgH) * srcImgW);
					narrowImgH = destImgH;
					// 按照原图以高为基准等比例缩放、或放大。这一步高为所需图片的高度，宽度肯定会比目标宽度宽。
					int cutNarrowImgSize = (narrowImgW - destImgW) / 2;
					BufferedImage narrowImg = new BufferedImage(narrowImgW, narrowImgH, BufferedImage.TYPE_INT_RGB);
					narrowImg.getGraphics().drawImage(bi.getScaledInstance(narrowImgW, narrowImgH, Image.SCALE_SMOOTH), 0, 0, null);
					// 等比例缩放完成后宽度与目标尺寸宽度相比较 ， 将多余宽的部分分为两份 ，左边删除一部分
					Image image = narrowImg.getScaledInstance(narrowImgW, narrowImgH, Image.SCALE_DEFAULT);
					CropImageFilter cropFilter = new CropImageFilter(cutNarrowImgSize, 0, narrowImgW - cutNarrowImgSize, narrowImgH);
					Image img = Toolkit.getDefaultToolkit().createImage(new FilteredImageSource(image.getSource(), cropFilter));
					BufferedImage cutLiftNarrowImg = new BufferedImage(narrowImgW - cutNarrowImgSize, narrowImgH, BufferedImage.TYPE_INT_RGB);
					cutLiftNarrowImg.getGraphics().drawImage(img, 0, 0, null);
					// 右边删除一部分
					image = cutLiftNarrowImg.getScaledInstance(narrowImgW - cutNarrowImgSize, narrowImgH, Image.SCALE_DEFAULT);
					cropFilter = new CropImageFilter(0, 0, narrowImgW - cutNarrowImgSize * 2, narrowImgH);
					img = Toolkit.getDefaultToolkit().createImage(new FilteredImageSource(image.getSource(), cropFilter));
					BufferedImage cutRightNarrowImg = new BufferedImage(narrowImgW - cutNarrowImgSize * 2, narrowImgH, BufferedImage.TYPE_INT_RGB);
					Graphics g = cutRightNarrowImg.getGraphics();
					g.drawImage(img, 0, 0, null); // 绘制截取后的图
					g.dispose();
					// 输出为文件 最终为所需要的格式
					ImageIO.write(cutRightNarrowImg, "JPEG", new File(destImgPath));
	            }
	            else{ //以宽度为基准
					narrowImgW = destImgW;
					narrowImgH = (int) (((float) destImgW / (float) srcImgW) * srcImgH);
					int cutNarrowImgSize = (narrowImgH - destImgH) / 2;
	
					BufferedImage narrowImg = new BufferedImage(narrowImgW, narrowImgH, BufferedImage.TYPE_INT_RGB);
					narrowImg.getGraphics().drawImage(bi.getScaledInstance(narrowImgW, narrowImgH, Image.SCALE_SMOOTH), 0, 0, null);
	
					Image image = narrowImg.getScaledInstance(narrowImgW, narrowImgH, Image.SCALE_DEFAULT);
					CropImageFilter cropFilter = new CropImageFilter(0, cutNarrowImgSize, narrowImgW, narrowImgH - cutNarrowImgSize);
					Image img = Toolkit.getDefaultToolkit().createImage(new FilteredImageSource(image.getSource(), cropFilter));
					BufferedImage cutTopNarrowImg = new BufferedImage(narrowImgW, narrowImgH - cutNarrowImgSize, BufferedImage.TYPE_INT_RGB);
					cutTopNarrowImg.getGraphics().drawImage(img, 0, 0, null);
	
					image = cutTopNarrowImg.getScaledInstance(narrowImgW, narrowImgH - cutNarrowImgSize, Image.SCALE_DEFAULT);
					cropFilter = new CropImageFilter(0, 0, narrowImgW, narrowImgH - cutNarrowImgSize * 2);
					img = Toolkit.getDefaultToolkit().createImage(new FilteredImageSource(image.getSource(), cropFilter));
					BufferedImage cutBottomNarrowImg = new BufferedImage(narrowImgW, narrowImgH - cutNarrowImgSize * 2, BufferedImage.TYPE_INT_RGB);
					Graphics g = cutBottomNarrowImg.getGraphics();
					g.drawImage(img, 0, 0, null);
					g.dispose();
					ImageIO.write(cutBottomNarrowImg, "JPEG", new File(destImgPath));
	            }
        	}	
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    static BASE64Encoder encoder = new sun.misc.BASE64Encoder();    
    
	
	
	/**
	 * @Descriptionmap 将图片文件转化为字节数组字符串，并对其进行Base64编码处理
	 * @author temdy
	 * @Date 2015-01-26
	 * @param path
	 *            图片路径
	 * @return
	 */
	public static String imageToBase64(String path) {// 将图片文件转化为字节数组字符串，并对其进行Base64编码处理
		byte[] data = null;
		// 读取图片字节数组
		try {
			InputStream in = new FileInputStream(path);
			data = new byte[in.available()];
			in.read(data);
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// 对字节数组Base64编码
		BASE64Encoder encoder = new BASE64Encoder();
		return encoder.encode(data);// 返回Base64编码过的字节数组字符串
	}
	
	
	public File transformToPNG(File image, String filename) throws IOException {
        if (isImage(image)) {
            File out = new File(FileUtils.getUniqueTmpDir(), filename);
            BufferedImage bufferedImage = ImageIO.read(image);
            renderingPNGImage(out, bufferedImage);
            return out;
        } else {
            return null;
        }
    }
	
	/*下载网络图片*/
	public static File getUrlImage(String url){
		
		// 创建临时文件夹
        File tmpDir = FileUtils.getUniqueTmpDir();
        
        String watermarkedImageFilename = UUID.randomUUID().toString() + ".jpg";
        
        File watermarkedImage = new File(tmpDir, watermarkedImageFilename);
        
        try {
        	
			download(url, watermarkedImageFilename, tmpDir.getPath());
			
			return new File(tmpDir.getPath() + File.separator + watermarkedImageFilename);
			
		} catch (Exception e) {
			
			e.printStackTrace();
			return null;
		}
	}

	public static void download(String urlString, String filename, String savePath) throws Exception {
		// 构造URL
		URL url = new URL(urlString);
		// 打开连接
		URLConnection con = url.openConnection();
		// 设置请求超时为5s
		con.setConnectTimeout(5 * 1000);
		// 输入流
		InputStream is = con.getInputStream();

		// 1K的数据缓冲
		byte[] bs = new byte[1024];
		// 读取到的数据长度
		int len;
		// 输出的文件流
		File sf = new File(savePath);
		if (!sf.exists()) {
			sf.mkdirs();
		}
		OutputStream os = new FileOutputStream(sf.getPath() + "\\" + filename);
		// 开始读取
		while ((len = is.read(bs)) != -1) {
			os.write(bs, 0, len);
		}
		// 完毕，关闭所有链接
		os.close();
		is.close();
	}
	
}
