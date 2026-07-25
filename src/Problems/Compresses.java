package Problems;

public class Compresses {

    public static String compressedString(String str){
	if(str == null || str.isEmpty())
		return str;
	StringBuilder compressed = new StringBuilder();
	int count = 1;
	
	for(int i=0;i<str.length();i++)
	{
		if((i+1)< str.length() && str.charAt(i)==str.charAt(i+1))
		{
			count++;
		}
		else
		{
			compressed.append(str.charAt(i)).append(count);
			count =1;
		}
	}
	return (compressed.length() < str.length())?compressed.toString():str;
}
    void main()
    {
        String str = "aaabbccdeaaaa";
        System.out.println("Compressed String: " + compressedString(str));
    }
}
