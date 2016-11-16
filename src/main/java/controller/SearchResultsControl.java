package controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import view.SearchResultsView;
/**
 * 
 * @author alvesmarcos
 *
 */
public class SearchResultsControl {
	
	//private SearchResultsView searchResultsView;
	
	public SearchResultsControl(SearchResultsView searchResultsView){
		SearchResultsView searchResult = searchResultsView;
		
		searchResult.getLblImageButtonVoltar().addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) { }
			
			@Override
			public void mousePressed(MouseEvent e) { }
			
			@Override
			public void mouseExited(MouseEvent e) { }
			
			@Override
			public void mouseEntered(MouseEvent e) { }
			
			@Override
			public void mouseClicked(MouseEvent e) {
				searchResultsView.dispose();
			}
		});
	}
}
