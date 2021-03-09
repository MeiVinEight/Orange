package org.orange;

import net.mamoe.mirai.message.code.MiraiCode;
import net.mamoe.mirai.message.data.MessageChain;

public class Mirai
{
	/**
	 * 把字符串消息解析为mirai消息链，包括解析mirai code等，实现取决于{@link MiraiCode#deserializeMiraiCode(String)}
	 *
	 * @param str 字符串形式的消息
	 * @return 解析后的Mirai消息链
	 */
	public static MessageChain toMessage(String str)
	{
		return MiraiCode.deserializeMiraiCode(str);
	}
}
