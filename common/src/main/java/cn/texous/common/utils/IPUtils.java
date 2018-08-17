package cn.texous.common.utils;

/**
 * insert description here
 *
 * @author liuxiaohua
 * @since 2018/7/26 8:45
 */
public class IPUtils {

    /**
     * 将 IP 转换为 Long
     * @param IP
     * @return
     */
    public static Long getIPNum(final String IP) {
        Long IPNum = 0L;
        final String IPStr = IP.trim();
        if (IP != null && IPStr.length() != 0) {
            final String[] subips = IPStr.split("\\.");
            for (final String str : subips) {
                // 向左移8位
                IPNum = IPNum << 8;
                IPNum += Integer.parseInt(str);
            }
        }
        return IPNum;
    }

    /**
     * 将 Long 转换为 IP
     * @param IPNum
     * @return
     */
    public static String getIPString(final Long IPNum) {
        final Long andNumbers[] = { 0xff000000L, 0x00ff0000L, 0x0000ff00L, 0x000000ffL };
        final StringBuilder IPStrSb = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            // 获取需要的位数的值， 别的位数的值转为0
            long tempIPNum = IPNum & andNumbers[i];
            IPStrSb.append(String.valueOf(tempIPNum >> 8 * (3 - i)));
            if (i != 3) {
                IPStrSb.append(".");
            }
        }
        return IPStrSb.toString();
    }

    public static void main(final String[] args) {
        final String IPStr = "192.168.11.11";
        System.out.println(getIPNum(IPStr));

        final Long IPNum = 3232238347L;
        System.out.println(getIPString(IPNum));

    }

}
