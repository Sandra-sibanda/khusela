/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package khuselasecuritycompanysystem;

/**
 *
 * @author mahlobo
 */
public class CaesarsChiper {
    
    
private String strCipherCharacters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890~!@#$%^&*()[]{}:?/";

private int intKey = 5;


private String mCleanString(String strText)
{
strText = strText.replaceAll("\n","");
for (int x = 0; x<strText.length(); x++)
{
int intPosition = strCipherCharacters.indexOf(strText.charAt(x));
if(intPosition==-1)
{
      strText=strText.replace(strText.charAt(x),' ');
}
}
return strText;
}

public String mEncrypt(String strText,int intKey)
{
String strCleanedText = mCleanString(strText);
String strEncrypted = "";
for (int i = 0; i <strCleanedText.length();i++)
{
int intCharacterPosition = strCipherCharacters.indexOf(strCleanedText.charAt(i));
if((intCharacterPosition + intKey)<strCipherCharacters.length())
{
strEncrypted += strCipherCharacters.charAt(intCharacterPosition + intKey);
}
else
{
strEncrypted+=strCipherCharacters.charAt((intCharacterPosition+intKey)-strCipherCharacters.length());
}
}
return strEncrypted;

}


public String mDecrypt(String strText,int intKey)
{
String strCleanedText=mCleanString(strText);
String strDecrypted="";
for(int x =0;x<strCleanedText.length();x++)
{
    int intCharacterPosition=strCipherCharacters.indexOf(strCleanedText.charAt(x));
    if((intCharacterPosition-intKey)<0)
{
strDecrypted+=strCipherCharacters.charAt((intCharacterPosition-intKey)+strCipherCharacters.length());
}
    else
{
strDecrypted+=strCipherCharacters.charAt(intCharacterPosition-intKey);
}
}
return strDecrypted;
}
    
}
