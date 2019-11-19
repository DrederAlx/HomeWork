package IOHomeWork;

public class Xor {

    public byte[] encrypt(String text, String keyWord) {
        byte[] arr = text.getBytes();
        byte[] keyArr = keyWord.getBytes();
        byte[] result = new byte[arr.length];
        for(int i = 0; i< arr.length; i++) {
            result[i] = (byte) (arr[i] ^ keyArr[i % keyArr.length]);
        }
        return result;
    }

    public String decrypt(byte[] text, String keyWord) {
        byte[] result = new byte[text.length];
        byte[] keyArr = keyWord.getBytes();
        for(int i = 0; i < text.length;i++) {
            result[i] = (byte) (text[i] ^ keyArr[i% keyArr.length]);
        }
        return new String(result);
    }
}