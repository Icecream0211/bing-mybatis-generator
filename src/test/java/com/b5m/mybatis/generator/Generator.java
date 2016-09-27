package com.b5m.mybatis.generator;

import java.io.File;

import org.mybatis.generator.api.ShellRunner;

public class Generator {
	public static void main(String[] args) throws Exception {
		if (args.length == 0) {
			args = new String[] { "resource:test-generator.xml" };
		}
		if (args.length == 1 && !isEmpty(args[0])
				&& !"-h".equalsIgnoreCase(args[0])) {
			String configFile = args[0];
			if (configFile.startsWith("\\") || configFile.startsWith("/")) { // Linux绝对路径

			} else if (configFile.length() > 2 && configFile.charAt(1) == ':') { // Windows绝对路径

			} else if (configFile.startsWith("resource:")) { // resource路径
				configFile = new File("").getAbsolutePath()
						+ "/src/main/resources/"
						+ configFile.replace("resource:", "");
			} else { // 当前目录
				configFile = new File("").getAbsolutePath() + "/" + configFile;
			}
			System.out.println("使用配置文件:" + configFile);
			ShellRunner.main(new String[] { "-overwrite", "-verbose",
					"-configfile", configFile });
		} else {
			ShellRunner.main(args);
		}

	}

	public static boolean isEmpty(String string) {
		return string == null || string.trim().length() == 0;
	}

	
}
