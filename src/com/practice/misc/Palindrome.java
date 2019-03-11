import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Palindrome {

	

public void checkPallindrom(String testWord){
if (testWord!=null && testWord.length()%3==0){
int size = testWord.length()-1;


if (testWord.isEmpty())
{	System.out.println("the sring is empty");
return;}

char[] charArray = testWord.toCharArray();
for (int i=0; i<size/2;i++){
	if(
	charArray[i]!=charArray[size-i]){
	System.out.println("its not a palindrome" + charArray[i] + "....."+ charArray[size-i]);
	return;
	}
}
System.out.println("stiring is a plaindrome");
return;
}
else {System.out.println("the stirng is not a plaindrom");}
}

public void splitnReverse(String testSentence){
		int size = testSentence.length();
	String[] splits = testSentence.split("\\s+");
	size = splits.length;
//		for (int i=0;i<=size-1;i++){
//			System.out.println("strin split is" + splits[i]+".........");
//
//}
	for (String word: splits){}
		size=splits.length;
		for (int i=size-1;i>=0;i--){
			System.out.println("reverse  split is" + splits[i]+".........");

}		
	}

public void findOccurrence(String testSentence, String another){
	int size = testSentence.length();int count=0;
String[] splits = testSentence.split("\\s+");
size = splits.length;
//	for (int i=0;i<=size-1;i++){
//		System.out.println("strin split is" + splits[i]+".........");
//
//}
for (String word: splits){
	if(word.equalsIgnoreCase(another)) count++;
}
//
System.out.println("count s......." + count);
}

public void testAnother(){
String in = "this is reverse tester which is simpler to test as is it";
int i = 0;
Pattern p = Pattern.compile("test");
Matcher m = p.matcher( in );
while (m.find()) {
    i++;
}
System.out.println(i);
}

private static void numberPalindrome(int a){
	int newnum = 0; int orig=a;
	
	while(a > 0)
	{
		newnum = newnum * 10+ a%10 ;
				a = a/10;
	}
System.out.println("original number...." + orig+ "reversed number ...." + newnum);	
}


public static void main (String args[]){
//	new Palindrome().checkPallindrom("malayala");
////	new Palindrome().splitnReverse("this is reverse");
//	new Palindrome().findOccurrence("this is reverse tester which is simpler to test as is it", "test" );
//	new Palindrome().testAnother();
//    int newInt[] = new int[20];
	numberPalindrome(12345);
}
}
