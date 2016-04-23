package com.yfhl.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class CopyFolder {

		// 允许复制的文件类�?
		public static String[] filterFile = { ".jpg", ".png", ".jpeg",".gif", ".bmp"};
		private static long total = 0l;

		/** * * @param folder * @param filterFile * @throws Exception */
		public static void copyFolder(File srcFolder, File destFolder, String[] filterFile)
				throws Exception {			
			File[] files = srcFolder.listFiles();
			for (File file : files) {
				if (file.isFile()) {
					String pathname = destFolder + File.separator + file.getName();
					for (String suff : filterFile) {
						if (pathname.endsWith(suff)) {
							File dest = new File(pathname);
							File destPar = dest.getParentFile();
							destPar.mkdirs();
							if (!dest.exists()) {
								dest.createNewFile();
							}
							copyFile(file, dest);
						}
					}
				} else {
					copyFolder(file, destFolder, filterFile);
				}
			}
		} 

		/***
		 * * copy file * * @param src * @param dest * @param status * @throws
		 * IOException
		 */
		private static void copyFile(File src, File dest) throws Exception {
			FileInputStream input = null;
			FileOutputStream outstrem = null;
			try {
				 input = new FileInputStream(src);
				 outstrem = new FileOutputStream(dest);
				 outstrem.getChannel().transferFrom(input.getChannel(), 0,input.available());
				total++;
			} catch (Exception e) {
				throw e;
			} finally {
				outstrem.flush();
				outstrem.close();
				input.close();
			}
		}
	
}
