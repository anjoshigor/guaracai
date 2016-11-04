package util;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Point;
import javax.swing.ImageIcon;
/**
 * 
 * @author marcos-alves
 *
 */
public abstract class GraphicsUtil {
	
	public static ImageIcon adjustImage(String path, Dimension imageDimension){
		ImageIcon image = new ImageIcon(GraphicsUtil.class.getResource(path));
		image.setImage(image.getImage().getScaledInstance(imageDimension.width, imageDimension.height,
					                                      Image.SCALE_SMOOTH));
		return image;
	}
	
	public static Point getLocaleCenter(Dimension component, Dimension target){
		return new Point(getLocaleCenterX(component, target), getLocaleCenterY(component, target));
	} 
	
	public static int getLocaleCenterX(Dimension component, Dimension target){
		return (target.width - component.width)/2;
	}
	
	public static int getLocaleCenterY(Dimension component, Dimension target){
		return (target.height - component.height)/2;
	}
}
