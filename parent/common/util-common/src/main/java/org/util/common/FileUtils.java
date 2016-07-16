package org.util.common;

import org.apache.commons.io.FilenameUtils;

import java.io.*;
import java.net.URL;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class FileUtils {

    /**
     * get unique temporary directory.
     * @return temporary directory
     */
    public static File getUniqueTmpDir() {
        String sysTmpDir = System.getProperty("java.io.tmpdir");
        if (sysTmpDir == null) {
            sysTmpDir = ".";
        }
        return mkdir(sysTmpDir, UUID.randomUUID().toString());
    }

    /**
     * get file handle of resource directory.
     * @param filename resource file name
     * @return file handle
     */
    public static File getResourceFile(String filename) {
        URL resource = Thread.currentThread().getContextClassLoader().getResource(filename);
        return new File(resource.getPath());
    }

    /**
     * get file extension.
     * @param file file handle
     * @return file extension, such as "txt", "png" etc.
     */
    public static String getFileExtension(File file) {
        try {
            return FilenameUtils.getExtension(file.getCanonicalPath());
        } catch (IOException e) {
            System.err.println("file IO exception.");
            return null;
        }
    }

    public static String getFileExtension(String filename) {
        return FilenameUtils.getExtension(filename);
    }

    /**
     * get filename of the file.
     * @param file file handle
     * @return filename, "a.txt" -> a
     */
    public static String getFilename(File file) {
        try {
            return FilenameUtils.getName(file.getCanonicalPath());
        } catch (IOException e) {
            System.err.println("file IO exception.");
            return null;
        }
    }

    private static File mkdir(String parent, String dirName) {
        try {
            File dir = new File(parent, dirName);
            if (!dir.exists()) {
                dir.mkdir();
            }
            return dir.getCanonicalFile();
        } catch (IOException io) {
            System.err.println("file IO exception.");
            return null;
        }
    }
    
    /******************************************** Wang 2016-1-5 *********************************************/
    
    /**
     * 使用文件通道的方式复制文件
     * @author Wang
     * @param s 源文件
     * @param t 复制到的新文件
     */
	public static void fileChannelCopy(File s, File t) {

		FileInputStream fi = null;

		FileOutputStream fo = null;

		FileChannel in = null;

		FileChannel out = null;

		try {

			fi = new FileInputStream(s);

			fo = new FileOutputStream(t);

			in = fi.getChannel();// 得到对应的文件通道

			out = fo.getChannel();// 得到对应的文件通道

			in.transferTo(0, in.size(), out);// 连接两个通道，并且从in通道读取，然后写入out通道

		} catch (IOException e) {

			e.printStackTrace();

		} finally {

			try {

				fi.close();

				in.close();

				fo.close();

				out.close();

			} catch (IOException e) {

				e.printStackTrace();

			}

		}

	}
	
	/**
	 * 递归删除目录下的所有文件及子目录下所有文件
	 * @param dir 将要删除的文件目录
	 * @return boolean 
	 */
	public static boolean deleteDir(File dir) {
        if (dir.isDirectory()) {
            String[] children = dir.list();
            //递归删除目录中的子目录下
            for (int i=0; i<children.length; i++) {
                boolean success = deleteDir(new File(dir, children[i]));
                if (!success) {
                    return false;
                }
            }
        }
        // 目录此时为空，可以删除
        return dir.delete();
    }
	
	/**
	 * 复制InputStream,防止只能使用一次
	 * 取出后一个对象只能使用一次
	 * @author Wang
	 */
	public static List<InputStream> copyInputStream(InputStream in, int size){
		
		List<InputStream> ins = new ArrayList<InputStream>();
		
		try {
			
			ByteArrayOutputStream baos = new ByteArrayOutputStream();  
			
			byte[] buffer = new byte[1024];  
			
			int len;
			
			while ((len = in.read(buffer)) > -1 ) {  
			    baos.write(buffer, 0, len);  
			}
			
			baos.flush();
			
			for (int i = 0; i<size; i++) {
				ins.add(new ByteArrayInputStream(baos.toByteArray()));
			}
			
		} catch (Exception e) {
			
			return null;
			
		}
		
		return ins;
		
	}
	
}