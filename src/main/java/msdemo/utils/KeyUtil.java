package msdemo.utils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.Key;

import javax.servlet.ServletContext;

import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.crypto.MacProvider;

/**
 * @Author: TODY
 * @Version: V1.00 
 * @Create Date: 2017年4月13日11:25:00
 * @Description: KEY生成工具类
 */
public class KeyUtil {
	public static Key getKey(ServletContext context) {
		String path = (context.getRealPath("/"));
		File file = new File(path, "key.txt");
		try {
			if (!file.exists()) {
				Key key = MacProvider.generateKey(SignatureAlgorithm.HS512);
				ObjectOutputStream oo = new ObjectOutputStream(new FileOutputStream(file));
				oo.writeObject(key);
				oo.close();
				return key;
			}
			ObjectInputStream ois = null;
			ois = new ObjectInputStream(new FileInputStream(file));
			Key key = (Key) ois.readObject();
			return key;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

}
