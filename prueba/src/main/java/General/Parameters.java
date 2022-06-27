package General;

import java.util.ArrayList;

public class Parameters {
	

 public ArrayList<Object[]>tenis=new ArrayList<Object[]>();
 public ArrayList<String>preciotenis=new ArrayList<String>();

   public void maddtenis(String ten) {
	 try {
		 Object a[]= {ten};
		 tenis.add(a);
			}catch(Exception e) {
				System.out.println("Error en params add tenis:"+e);
			}
   }
   
   public void maddpricetenis(String ten) {
		 try {
			 preciotenis.add(ten);
				}catch(Exception e) {
					System.out.println("Error en params add tenis:"+e);
				}
	   }
   
   
   
   
	//---------------------------------------------------singleton---------------------------
		private static Parameters params;

		private Parameters() {
		}

		public static Parameters getInstance() {
	        if (params == null) {
	        	params=new Parameters();
			}
			return params;
		}
}
