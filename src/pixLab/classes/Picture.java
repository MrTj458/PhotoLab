package pixLab.classes;
import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List

/**
 * A class that represents a picture.  This class inherits from 
 * SimplePicture and allows the student to add functionality to
 * the Picture class.  
 * 
 * @author Barbara Ericson ericson@cc.gatech.edu
 */
public class Picture extends SimplePicture 
{
  ///////////////////// constructors //////////////////////////////////
  
  /**
   * Constructor that takes no arguments 
   */
  public Picture ()
  {
    /* not needed but use it to show students the implicit call to super()
     * child constructors always call a parent constructor 
     */
    super();  
  }
  
  /**
   * Constructor that takes a file name and creates the picture 
   * @param fileName the name of the file to create the picture from
   */
  public Picture(String fileName)
  {
    // let the parent class handle this fileName
    super(fileName);
  }
  
  /**
   * Constructor that takes the width and height
   * @param height the height of the desired picture
   * @param width the width of the desired picture
   */
  public Picture(int height, int width)
  {
    // let the parent class handle this width and height
    super(width,height);
  }
  
  /**
   * Constructor that takes a picture and creates a 
   * copy of that picture
   * @param copyPicture the picture to copy
   */
  public Picture(Picture copyPicture)
  {
    // let the parent class do the copy
    super(copyPicture);
  }
  
  /**
   * Constructor that takes a buffered image
   * @param image the buffered image to use
   */
  public Picture(BufferedImage image)
  {
    super(image);
  }
  
  ////////////////////// methods ///////////////////////////////////////
  
  /**
   * Method to return a string with information about this picture.
   * @return a string with information about the picture such as fileName,
   * height and width.
   */
  public String toString()
  {
    String output = "Picture, filename " + getFileName() + 
      " height " + getHeight() 
      + " width " + getWidth();
    return output;
    
  }
  
  /** Method to set the blue to 0 */
  public void zeroBlue()
  {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)
      {
        pixelObj.setBlue(0);
      }
    }
  }
  
  /** Method to set the red to 0 */
  public void zeroRed()
  {
	  Pixel[][] redPixels = this.getPixels2D();
	  for(int row = 0; row < redPixels.length; row++)
	  {
		  for(int col = 0; col < redPixels[0].length; col++)
		  {  
			  redPixels[row][col].setRed(0);
		  }
	  }
  }
  
  /** Method to set the green to 0 */
  public void zeroGreen()
  {
	  Pixel[][] greenPixels = this.getPixels2D();
	  for(int row = 0; row < greenPixels.length; row++)
	  {
		  for(int col = 0 ; col < greenPixels[0].length; col++)
		  {
			  greenPixels[row][col].setGreen(0);
		  }
	  }
  }
  
  /** Method to set red and green pixels to 0 */
  public void keepOnlyBlue()
  {
	  Pixel[][] bluePixels = this.getPixels2D();
	  for(int row = 0; row < bluePixels.length; row++)
	  {
		  for(int col = 0; col < bluePixels[0].length; col++)
		  {
			  bluePixels[row][col].setRed(0);
			  bluePixels[row][col].setGreen(0);
		  }
	  }
  }
  
  /** Method to set blue and green pixels to 0 */
  public void keepOnlyRed()
  {
	  Pixel[][] redPixels = this.getPixels2D();
	  for(int row = 0; row < redPixels.length; row++)
	  {
		  for(int col = 0; col < redPixels[0].length; col++)
		  {
			  redPixels[row][col].setBlue(0);
			  redPixels[row][col].setGreen(0);
		  }
	  }
  }
  
  /** Method to set the blur and red pixels to 0 */
  public void keepOnlyGreen()
  {
	  Pixel[][] greenPixels = this.getPixels2D();
	  for(int row = 0; row < greenPixels.length; row++)
	  {
		  for(int col = 0; col < greenPixels[0].length; col++)
		  {
			  greenPixels[row][col].setRed(0);
			  greenPixels[row][col].setBlue(0);
		  }
	  }
  }
  
  public void grayScale()
  {
	  Pixel[][] pixels = this.getPixels2D();
	  for(int row = 0; row < pixels.length; row++)
	  {
		  for(int col = 0; col < pixels[0].length; col++)
		  {
			  int red = pixels[row][col].getRed();
			  int green = pixels[row][col].getGreen();
			  int blue = pixels[row][col].getBlue();
			  
			  int newValue = (red + blue + green) / 3;
			  
			  pixels[row][col].setRed(newValue);
			  pixels[row][col].setGreen(newValue);
			  pixels[row][col].setBlue(newValue);
		  }
	  }
  }
  
  /** Method that mirrors the picture around a 
    * vertical mirror in the center of the picture
    * from left to right
    */
  public void mirrorVertical()
  {
    Pixel[][] pixels = this.getPixels2D();
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int width = pixels[0].length;
    for (int row = 0; row < pixels.length; row++)
    {
      for (int col = 0; col < width / 2; col++)
      {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][width - 1 - col];
        rightPixel.setColor(leftPixel.getColor());
      }
    } 
  }
  
  public void mirrorVerticalRightToLeft()
  {
	  Pixel[][] pixels = this.getPixels2D();
	  Pixel leftPixel = null;
	  Pixel rightPixel = null;
	  int width = pixels[0].length;
	  
	  for(int row = 0; row < pixels.length; row++)
	  {
		  for(int col = pixels[0].length - 1; col > width / 2; col--)
		  {
			  rightPixel = pixels[row][col];
			  leftPixel = pixels[row][(width / 2) - (col - width / 2)];
			  leftPixel.setColor(rightPixel.getColor());
		  }
	  }
  }
  
  public void mirrorHorizontal()
  {
	  Pixel[][] pixels = this.getPixels2D();
	  Pixel topPixel = null;
	  Pixel bottomPixel = null;
	  int height = pixels.length;
	  for(int row = 0; row < height / 2; row++)
	  {
		  for(int col = 0; col < pixels[0].length; col++)
		  {
			  topPixel = pixels[row][col];
			  bottomPixel = pixels[height - 1 - row][col];
			  bottomPixel.setColor(topPixel.getColor());
		  }
	  }
  }
  
  public void randomColor()
  {
	  Pixel[][] pixels = this.getPixels2D();
	  for(Pixel[] row : pixels)
	  {
		  for(Pixel current : row)
		  {
			  int randomRed = (int) (Math.random() * 256);
			  int randomGreen = (int) (Math.random() * 256);
			  int randomBlue = (int) (Math.random() * 256);
			  current.setRed(randomRed);
			  current.setGreen(randomGreen);
			  current.setBlue(randomBlue);
		  }
	  }
  }
  
  public void randomChange()
  {
	  Pixel[][] pixels = this.getPixels2D();
	  for(Pixel[] row : pixels)
	  {
		  for(Pixel current : row)
		  {
			  int randomRedScale = (int) (Math.random() * 50);
			  int randomGreenScale = (int) (Math.random() * 50);
			  int randomBlueScale = (int) (Math.random() * 50);
			  int plusOrMinus = (int) (Math.random() * 2);
			  if(plusOrMinus > 0)
			  {
				  current.setRed((current.getRed() + randomRedScale) % 256);
				  current.setGreen((current.getGreen() + randomGreenScale) % 256);
				  current.setBlue((current.getBlue() + randomBlueScale) % 256);
			  }
			  else
			  {
				  current.setRed((current.getRed() - randomRedScale) % 256);
				  current.setGreen((current.getGreen() - randomGreenScale) % 256);
				  current.setBlue((current.getBlue() - randomBlueScale) % 256);
			  }
		  }
	  }
  }
  
  /** Mirror just part of a picture of a temple */
  public void mirrorTemple()
  {
    int mirrorPoint = 276;
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int count = 0;
    Pixel[][] pixels = this.getPixels2D();
    
    // loop through the rows
    for (int row = 27; row < 97; row++)
    {
      // loop from 13 to just before the mirror point
      for (int col = 13; col < mirrorPoint; col++)
      {
        
        leftPixel = pixels[row][col];      
        rightPixel = pixels[row]                       
                         [mirrorPoint - col + mirrorPoint];
        rightPixel.setColor(leftPixel.getColor());
      }
    }
  }
  
  /** copy from the passed fromPic to the
    * specified startRow and startCol in the
    * current picture
    * @param fromPic the picture to copy from
    * @param startRow the start row to copy to
    * @param startCol the start col to copy to
    */
  public void copy(Picture fromPic, 
                 int startRow, int startCol)
  {
    Pixel fromPixel = null;
    Pixel toPixel = null;
    Pixel[][] toPixels = this.getPixels2D();
    Pixel[][] fromPixels = fromPic.getPixels2D();
    for (int fromRow = 0, toRow = startRow; 
         fromRow < fromPixels.length &&
         toRow < toPixels.length; 
         fromRow++, toRow++)
    {
      for (int fromCol = 0, toCol = startCol; 
           fromCol < fromPixels[0].length &&
           toCol < toPixels[0].length;  
           fromCol++, toCol++)
      {
        fromPixel = fromPixels[fromRow][fromCol];
        toPixel = toPixels[toRow][toCol];
        toPixel.setColor(fromPixel.getColor());
      }
    }   
  }

  /** Method to create a collage of several pictures */
  public void createCollage(Picture img)
  {
	  Picture collageCar = new Picture("audiR8.jpg");
	  img.randomChange();
	  img.mirrorVerticalRightToLeft();
	  img.zeroRed();
	  img.mirrorHorizontal();
	  this.write("TrevorsCollage.jpg");
  }
  
  
  /** Method to show large changes in color 
    * @param edgeDist the distance for finding edges
    */
  public void edgeDetection(int edgeDist)
  {
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    Pixel[][] pixels = this.getPixels2D();
    Color rightColor = null;
    for (int row = 0; row < pixels.length; row++)
    {
      for (int col = 0; 
           col < pixels[0].length-1; col++)
      {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][col+1];
        rightColor = rightPixel.getColor();
        if (leftPixel.colorDistance(rightColor) > 
            edgeDist)
          leftPixel.setColor(Color.BLACK);
        else
          leftPixel.setColor(Color.WHITE);
      }
    }
  }
  
  
  /* Main method for testing - each class in Java can have a main 
   * method 
   */
  public static void main(String[] args) 
  {
    Picture car = new Picture("audiR8.jpg");
//    car.grayScale();
//    car.zeroRed();
//    car.mirrorVertical();
//    car.copy(car, car.getWidth() / 2, car.getHeight() / 2);
    car.createCollage(car);
    car.explore();
  }
  
} // this } is the end of class Picture, put all new methods before this
