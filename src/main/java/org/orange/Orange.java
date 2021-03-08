package org.orange;

import net.mamoe.mirai.Bot;
import net.mamoe.mirai.BotFactory;
import org.mve.invoke.ReflectionFactory;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

public class Orange
{
	public static final Orange orange = null;
	private final long qq;
	private final Bot bot;

	public Orange() throws IOException
	{
		ReflectionFactory.access(Orange.class, "orange").set(this);

		// read orange.properties
		Properties properties = new Properties();
		{
			FileInputStream prop = new FileInputStream("orange.properties");
			properties.load(prop);
		}

		// qq number
		long qq = 0;
		{
			try
			{
				qq = Long.parseLong(properties.get("qq").toString());
			}
			catch (NumberFormatException e)
			{
				System.out.println("Input QQ number");
				BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
				boolean continuing = true;
				while (continuing)
				{
					try
					{
						qq = Long.parseLong(reader.readLine());
						continuing = false;
					}
					catch (IOException ioe)
					{
						System.out.println("Input a correct QQ number");
					}
				}
			}
		}
		this.qq = qq;

		// password
		String password;
		{
			password = properties.get("password").toString();
			BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
			while (password == null || password.isEmpty())
			{
				System.out.println("Input the password");
				password = read.readLine();
			}
		}

		this.bot = BotFactory.INSTANCE.newBot(this.qq, password);
	}

	public long getQQ()
	{
		return this.qq;
	}
}
