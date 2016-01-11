package test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Attribute;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.runner.notification.Failure;

public class RepairTechnique {

	public File repair(String new_file, String old_URL, String new_URL, Failure failure) throws IOException{
		
		System.out.println("****************** FAILURE PROFILE ESTABLISHMENT ******************"); 
		System.out.println("OLD VERSION URL: "+old_URL); 
		System.out.println("NEW VERSION URL: "+new_URL);
		

		String fail=failure.toString(); 
		//System.out.println("FAIIIIIL==============>"+fail);
	
		
		int start=fail.indexOf("{"); 
		int end=fail.indexOf("}"); 
		fail=fail.substring(start, end+1);
		
		
		String[] arr = fail.split(","); 
		String method=arr[0]; 
		String locator=arr[1];
		start=fail.indexOf(":\"");
		end=fail.indexOf("\","); 
		String locator2=null; 
		method=fail.substring(start, end); 
		method=method.replace(":\"", ""); 
		//System.out.println("METHOD==============>"+method); 
		start=locator.indexOf(":\"");
		end=locator.indexOf("\"}"); 
		locator=locator.substring(start, end); 
		locator2=locator.replace(":\"", ""); 
		locator=locator2.replace("\\", ""); 
		
		
		//System.out.println("LOCATOR==============>"+locator);  
		 
		System.out.println("FAILURE DESCRIPTION: Could not locate the element with locator====> \""+locator+ "\", using the technique"
				+ "====> \""+ method+"\"");
		System.out.println("---------------------------------------------------------------------"); 
		System.out.println("---------------------------------------------------------------------");
		
		org.jsoup.nodes.Document doc = Jsoup.connect(old_URL).get();
		 Element elem=null; 
		 Elements cssSelectors =null; 
		if(method.equals("link text")){
			   Elements links = doc.getElementsByTag("a");
			    for (Element link : links) {
			    	  String linkText = link.text();
			      if(linkText.equals(locator)){
			    	  elem=link; 
			      }
			    
			    
			    }
		}	    
	    else if(method.equals("css selector")){
	    	 cssSelectors = doc.select(locator); 
	    	
	    }
<<<<<<< HEAD
	// NEW login page added starting version 61, version 6.1.4 for LOGIN, PHPAddressBook		   
=======
			   
>>>>>>> b11f1cbd1f66ff081fdd7eabac38f430c788dfa9
	System.out.println("--------------------PROFILE ESTABLISHEMENT FOR UNLOCATED ELEMENT-----------------"); 
	   //ID ATTRIBUTE
					elem=cssSelectors.get(0); 
				    String href = elem.attr("href"); 
				    if(href!="" && href!=null){
							System.out.println("HREF ATTRIBUTE VALUE: "+href); 
				   }
			     
			     //ID ATTRIBUTE
			     String id = elem.attr("id"); 
			     if(id!="" && id!=null){
						System.out.println("ID ATTRIBUTE VALUE: "+id); 
			    }
			     //NAME ATTRIBUTE
			     String name = elem.attr("name"); 
			     if(name!="" && name!=null){
						System.out.println("NAME ATTRIBUTE VALUE: "+name); 
			    }
			     String source = elem.attr("src"); 
			     if(source!="" && source!=null){
						System.out.println("SOURCE ATTRIBUTE VALUE: "+source); 
			    }
			     String border = elem.attr("border"); 
			     if(border!="" && border!=null){
						System.out.println("BORDER ATTRIBUTE VALUE: "+border); 
			    }
			     
			     String width = elem.attr("width"); 
			     if(width!="" && width!=null){
						System.out.println("WIDTH ATTRIBUTE VALUE: "+width); 
			    }
			     
			     String height = elem.attr("height"); 
			     if(height!="" && height!=null){
						System.out.println("HEIGHT ATTRIBUTE VALUE: "+height); 
			    }
			     
			     String title = elem.attr("title"); 
			     if(title!="" && title!=null){
						System.out.println("TITLE ATTRIBUTE VALUE: "+title); 
			    }
			     String alt = elem.attr("alt"); 
			     if(alt!="" && alt!=null){
						System.out.println("ALT ATTRIBUTE VALUE: "+alt); 
			    }
			     
		
		
		
		
		
		Elements withAttr = new Elements();

		
		
		org.jsoup.nodes.Document doc2 = Jsoup.connect(new_URL).get();
		for( Element element : doc.getAllElements() )
		{
		    for( Attribute attribute : element.attributes() )
		    {
		        if( attribute.getValue().equals(source) )
		        {
		        	
		        	//System.out.println("yeessss: "); 
		            withAttr.add(element);
		        }
		    }
		}
		
		Element Repaired_Element=withAttr.get(0); 
		String repair= Repaired_Element.cssSelector(); 
	    System.out.println("SUGGESTED REPAIR: "+repair);
	    File file= RepairTest( new_file, locator2, repair); 
		
//		org.jsoup.nodes.Document docc = Jsoup.connect("http://cse.unl.edu/~mouna/WebApps/AddressBook/addressbookv1.2/").get();
//    	Element link = docc.select("a").first();
//
//    	String text = docc.body().text(); // "An example link"
//    	System.out.println("heyyy"+text); 
//    	String linkHref = link.attr("href"); // "http://example.com/"
//    	System.out.println("hey2"+linkHref); 
//    	String linkText = link.text(); // "example""
//    	System.out.println("hey3"+linkText); 
//    	String linkOuterH = link.outerHtml(); 
//    	System.out.println("hey3  "+linkOuterH); 
//    	    // "<a href="http://example.com"><b>example</b></a>"
//    	String linkInnerH = link.html(); // "<b>example</b>"; 
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	

//		File file = new File(new_file); 
//		Writer writer = null;
//
//		try {
//		    writer = new BufferedWriter(new OutputStreamWriter(
//		          new FileOutputStream(new_file), "utf-8"));
//		    writer.write("Something");
//		} catch (IOException ex) {
//		  // report
//		} finally {
//		   try {writer.close();} catch (Exception ex) {/*ignore*/}
//		}	
		return file; 
}
	
	/***************************************************************************************/
	
	private static File RepairTest(String new_file, String locator2, String repair) throws IOException {
		
		BufferedReader file = new BufferedReader(new FileReader(new_file));
		String line;
		String input = "";

		while ((line = file.readLine()) != null)
		{
			input += line + "\n";
			
			if (line.contains(locator2)){
				System.out.println("STATEMENT WITHIN THE TEST CASE TO BE REPAIRED:"+line); 
				input=input.replace(locator2, repair); 
				
			}


		}





		FileOutputStream os = new FileOutputStream(new_file);
		os.write(input.getBytes());

		file.close();
		os.close();
		File dest = new File(new_file);
		return dest; 
	} 
}