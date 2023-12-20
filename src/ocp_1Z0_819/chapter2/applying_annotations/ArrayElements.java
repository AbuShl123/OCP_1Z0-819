package ocp_1Z0_819.chapter2.applying_annotations;


@interface Music {

	String[] genre() default "Modern";

}

public class ArrayElements {
	
	public static void main(String[] args) {
		@Music
		String aloneAlanW;

		@Music(genre = "classic")
		String rondaAllaTurkey;

		@Music(genre = {"classic", "romantic"})
		String nocturne9;
	}
	
}

