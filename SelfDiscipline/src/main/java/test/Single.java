package test;

public class Single {
			private static final Single s=new Single();
			private String a="11";
			private Single() {}
			
			public static Single getSingle() {
				  Single ss=s;
				   return s;
			}
}
